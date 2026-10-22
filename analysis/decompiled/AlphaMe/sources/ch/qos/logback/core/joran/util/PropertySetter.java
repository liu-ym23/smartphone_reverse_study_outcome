package ch.qos.logback.core.joran.util;

import B0.g;
import ch.qos.logback.core.joran.spi.DefaultClass;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.AggregationType;
import ch.qos.logback.core.util.PropertySetterException;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class PropertySetter extends ContextAwareBase {
    protected MethodDescriptor[] methodDescriptors;
    protected Object obj;
    protected Class<?> objClass;
    protected PropertyDescriptor[] propertyDescriptors;

    /* renamed from: ch.qos.logback.core.joran.util.PropertySetter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$util$AggregationType;

        static {
            int[] iArr = new int[AggregationType.values().length];
            $SwitchMap$ch$qos$logback$core$util$AggregationType = iArr;
            try {
                iArr[AggregationType.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$util$AggregationType[AggregationType.AS_BASIC_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$util$AggregationType[AggregationType.AS_COMPLEX_PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PropertySetter(Object obj) {
        this.obj = obj;
        this.objClass = obj.getClass();
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private AggregationType computeRawAggregationType(Method method) {
        Class<?> parameterClassForMethod = getParameterClassForMethod(method);
        return parameterClassForMethod == null ? AggregationType.NOT_FOUND : StringToObjectConverter.canBeBuiltFromSimpleString(parameterClassForMethod) ? AggregationType.AS_BASIC_PROPERTY : AggregationType.AS_COMPLEX_PROPERTY;
    }

    private Method findAdderMethod(String str) {
        return getMethod("add" + capitalizeFirstLetter(str));
    }

    private Method findSetterMethod(String str) {
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(Introspector.decapitalize(str));
        if (propertyDescriptor != null) {
            return propertyDescriptor.getWriteMethod();
        }
        return null;
    }

    private Class<?> getParameterClassForMethod(Method method) {
        if (method == null) {
            return null;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            return null;
        }
        return parameterTypes[0];
    }

    private boolean isSanityCheckSuccessful(String str, Method method, Class<?>[] clsArr, Object obj) {
        Class<?> cls = obj.getClass();
        if (clsArr.length != 1) {
            StringBuilder sbW = g.w("Wrong number of parameters in setter method for property [", str, "] in ");
            sbW.append(this.obj.getClass().getName());
            addError(sbW.toString());
            return false;
        }
        if (clsArr[0].isAssignableFrom(obj.getClass())) {
            return true;
        }
        addError("A \"" + cls.getName() + "\" object is not assignable to a \"" + clsArr[0].getName() + "\" variable.");
        StringBuilder sb = new StringBuilder("The class \"");
        sb.append(clsArr[0].getName());
        sb.append("\" was loaded by ");
        addError(sb.toString());
        addError("[" + clsArr[0].getClassLoader() + "] whereas object of type ");
        addError("\"" + cls.getName() + "\" was loaded by [" + cls.getClassLoader() + "].");
        return false;
    }

    private boolean isUnequivocallyInstantiable(Class<?> cls) {
        if (cls.isInterface()) {
            return false;
        }
        return cls.newInstance() != null;
    }

    public void addBasicProperty(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (str2 == null) {
            return;
        }
        String strCapitalizeFirstLetter = capitalizeFirstLetter(str);
        Method methodFindAdderMethod = findAdderMethod(strCapitalizeFirstLetter);
        if (methodFindAdderMethod == null) {
            addError("No adder for property [" + strCapitalizeFirstLetter + "].");
            return;
        }
        Class<?>[] parameterTypes = methodFindAdderMethod.getParameterTypes();
        isSanityCheckSuccessful(strCapitalizeFirstLetter, methodFindAdderMethod, parameterTypes, str2);
        try {
            if (StringToObjectConverter.convertArg(this, str2, parameterTypes[0]) != null) {
                invokeMethodWithSingleParameterOnThisObject(methodFindAdderMethod, str2);
            }
        } catch (Throwable th) {
            addError("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
        }
    }

    public void addComplexProperty(String str, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method methodFindAdderMethod = findAdderMethod(str);
        if (methodFindAdderMethod != null) {
            if (isSanityCheckSuccessful(str, methodFindAdderMethod, methodFindAdderMethod.getParameterTypes(), obj)) {
                invokeMethodWithSingleParameterOnThisObject(methodFindAdderMethod, obj);
            }
        } else {
            StringBuilder sbW = g.w("Could not find method [add", str, "] in class [");
            sbW.append(this.objClass.getName());
            sbW.append("].");
            addError(sbW.toString());
        }
    }

    public AggregationType computeAggregationType(String str) {
        Method methodFindAdderMethod = findAdderMethod(capitalizeFirstLetter(str));
        if (methodFindAdderMethod != null) {
            int i4 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$util$AggregationType[computeRawAggregationType(methodFindAdderMethod).ordinal()];
            if (i4 == 1) {
                return AggregationType.NOT_FOUND;
            }
            if (i4 == 2) {
                return AggregationType.AS_BASIC_PROPERTY_COLLECTION;
            }
            if (i4 == 3) {
                return AggregationType.AS_COMPLEX_PROPERTY_COLLECTION;
            }
        }
        Method methodFindSetterMethod = findSetterMethod(str);
        return methodFindSetterMethod != null ? computeRawAggregationType(methodFindSetterMethod) : AggregationType.NOT_FOUND;
    }

    public <T extends Annotation> T getAnnotation(String str, Class<T> cls, Method method) {
        if (method != null) {
            return (T) method.getAnnotation(cls);
        }
        return null;
    }

    public Class<?> getByConcreteType(String str, Method method) {
        Class<?> parameterClassForMethod = getParameterClassForMethod(method);
        if (parameterClassForMethod != null && isUnequivocallyInstantiable(parameterClassForMethod)) {
            return parameterClassForMethod;
        }
        return null;
    }

    public Class<?> getClassNameViaImplicitRules(String str, AggregationType aggregationType, DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        Class<?> clsFindDefaultComponentType = defaultNestedComponentRegistry.findDefaultComponentType(this.obj.getClass(), str);
        if (clsFindDefaultComponentType != null) {
            return clsFindDefaultComponentType;
        }
        Method relevantMethod = getRelevantMethod(str, aggregationType);
        if (relevantMethod == null) {
            return null;
        }
        Class<?> defaultClassNameByAnnonation = getDefaultClassNameByAnnonation(str, relevantMethod);
        return defaultClassNameByAnnonation != null ? defaultClassNameByAnnonation : getByConcreteType(str, relevantMethod);
    }

    public Class<?> getDefaultClassNameByAnnonation(String str, Method method) {
        DefaultClass defaultClass = (DefaultClass) getAnnotation(str, DefaultClass.class, method);
        if (defaultClass != null) {
            return defaultClass.value();
        }
        return null;
    }

    public Method getMethod(String str) {
        if (this.methodDescriptors == null) {
            introspect();
        }
        int i4 = 0;
        while (true) {
            MethodDescriptor[] methodDescriptorArr = this.methodDescriptors;
            if (i4 >= methodDescriptorArr.length) {
                return null;
            }
            if (str.equals(methodDescriptorArr[i4].getName())) {
                return this.methodDescriptors[i4].getMethod();
            }
            i4++;
        }
    }

    public Object getObj() {
        return this.obj;
    }

    public Class<?> getObjClass() {
        return this.objClass;
    }

    public PropertyDescriptor getPropertyDescriptor(String str) {
        if (this.propertyDescriptors == null) {
            introspect();
        }
        int i4 = 0;
        while (true) {
            PropertyDescriptor[] propertyDescriptorArr = this.propertyDescriptors;
            if (i4 >= propertyDescriptorArr.length) {
                return null;
            }
            if (str.equals(propertyDescriptorArr[i4].getName())) {
                return this.propertyDescriptors[i4];
            }
            i4++;
        }
    }

    public Method getRelevantMethod(String str, AggregationType aggregationType) {
        String strCapitalizeFirstLetter = capitalizeFirstLetter(str);
        if (aggregationType == AggregationType.AS_COMPLEX_PROPERTY_COLLECTION) {
            return findAdderMethod(strCapitalizeFirstLetter);
        }
        if (aggregationType == AggregationType.AS_COMPLEX_PROPERTY) {
            return findSetterMethod(strCapitalizeFirstLetter);
        }
        throw new IllegalStateException(aggregationType + " not allowed here");
    }

    public void introspect() {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(this.obj.getClass());
            this.propertyDescriptors = beanInfo.getPropertyDescriptors();
            this.methodDescriptors = beanInfo.getMethodDescriptors();
        } catch (IntrospectionException e4) {
            addError("Failed to introspect " + this.obj + ": " + e4.getMessage());
            this.propertyDescriptors = new PropertyDescriptor[0];
            this.methodDescriptors = new MethodDescriptor[0];
        }
    }

    public void invokeMethodWithSingleParameterOnThisObject(Method method, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        try {
            method.invoke(this.obj, obj);
        } catch (Exception e4) {
            addError("Could not invoke method " + method.getName() + " in class " + this.obj.getClass().getName() + " with parameter of type " + cls.getName(), e4);
        }
    }

    public void setComplexProperty(String str, Object obj) {
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(Introspector.decapitalize(str));
        if (propertyDescriptor == null) {
            StringBuilder sbW = g.w("Could not find PropertyDescriptor for [", str, "] in ");
            sbW.append(this.objClass.getName());
            addWarn(sbW.toString());
            return;
        }
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            StringBuilder sbW2 = g.w("Not setter method for property [", str, "] in ");
            sbW2.append(this.obj.getClass().getName());
            addWarn(sbW2.toString());
        } else if (isSanityCheckSuccessful(str, writeMethod, writeMethod.getParameterTypes(), obj)) {
            try {
                invokeMethodWithSingleParameterOnThisObject(writeMethod, obj);
            } catch (Exception e4) {
                addError("Could not set component " + this.obj + " for parent component " + this.obj, e4);
            }
        }
    }

    public void setProperty(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (str2 == null) {
            return;
        }
        String strDecapitalize = Introspector.decapitalize(str);
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(strDecapitalize);
        if (propertyDescriptor == null) {
            StringBuilder sbW = g.w("No such property [", strDecapitalize, "] in ");
            sbW.append(this.objClass.getName());
            sbW.append(".");
            addWarn(sbW.toString());
            return;
        }
        try {
            setProperty(propertyDescriptor, strDecapitalize, str2);
        } catch (PropertySetterException e4) {
            addWarn("Failed to set property [" + strDecapitalize + "] to value \"" + str2 + "\". ", e4);
        }
    }

    public void setProperty(PropertyDescriptor propertyDescriptor, String str, String str2) throws IllegalAccessException, PropertySetterException, IllegalArgumentException, InvocationTargetException {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod != null) {
            Class<?>[] parameterTypes = writeMethod.getParameterTypes();
            if (parameterTypes.length == 1) {
                try {
                    Object objConvertArg = StringToObjectConverter.convertArg(this, str2, parameterTypes[0]);
                    if (objConvertArg == null) {
                        throw new PropertySetterException("Conversion to type [" + parameterTypes[0] + "] failed.");
                    }
                    try {
                        writeMethod.invoke(this.obj, objConvertArg);
                        return;
                    } catch (Exception e4) {
                        throw new PropertySetterException(e4);
                    }
                } catch (Throwable th) {
                    throw new PropertySetterException("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
                }
            }
            throw new PropertySetterException("#params for setter != 1");
        }
        throw new PropertySetterException(g.n("No setter for property [", str, "]."));
    }
}
