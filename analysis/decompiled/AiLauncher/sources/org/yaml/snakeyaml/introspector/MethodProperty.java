package org.yaml.snakeyaml.introspector;

import io.ktor.sse.ServerSentEventKt;
import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.ArrayUtils;

/* loaded from: classes5.dex */
public class MethodProperty extends GenericProperty {
    private static final String TRANSIENT = "transient";
    private final PropertyDescriptor property;
    private final boolean readable;
    private final boolean writable;

    public MethodProperty(PropertyDescriptor propertyDescriptor) {
        super(propertyDescriptor.getName(), propertyDescriptor.getPropertyType(), discoverGenericType(propertyDescriptor));
        this.property = propertyDescriptor;
        this.readable = propertyDescriptor.getReadMethod() != null;
        this.writable = propertyDescriptor.getWriteMethod() != null;
    }

    public static boolean addPublicFields(Class<?> cls, Map<String, Property> map) {
        try {
            for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(cls).getPropertyDescriptors()) {
                Method readMethod = propertyDescriptor.getReadMethod();
                if ((readMethod == null || !readMethod.getName().equals("getClass")) && !isTransient(propertyDescriptor)) {
                    map.put(propertyDescriptor.getName(), new MethodProperty(propertyDescriptor));
                }
            }
            boolean z10 = false;
            while (cls != null) {
                for (Field field : cls.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                        if (Modifier.isPublic(modifiers)) {
                            map.put(field.getName(), new FieldProperty(field));
                        } else {
                            z10 = true;
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return z10;
        } catch (IntrospectionException e10) {
            throw new YAMLException((Throwable) e10);
        }
    }

    private static Type discoverGenericType(PropertyDescriptor propertyDescriptor) {
        Method readMethod = propertyDescriptor.getReadMethod();
        if (readMethod != null) {
            return readMethod.getGenericReturnType();
        }
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            return null;
        }
        Type[] genericParameterTypes = writeMethod.getGenericParameterTypes();
        if (genericParameterTypes.length > 0) {
            return genericParameterTypes[0];
        }
        return null;
    }

    private static boolean isTransient(FeatureDescriptor featureDescriptor) {
        return Boolean.TRUE.equals(featureDescriptor.getValue(TRANSIENT));
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Object get(Object obj) throws SecurityException {
        try {
            this.property.getReadMethod().setAccessible(true);
            return this.property.getReadMethod().invoke(obj, null);
        } catch (Exception e10) {
            throw new YAMLException("Unable to find getter for property '" + this.property.getName() + "' on object " + obj + ServerSentEventKt.COLON + e10);
        }
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        A a10 = isReadable() ? (A) this.property.getReadMethod().getAnnotation(cls) : null;
        return (a10 == null && isWritable()) ? (A) this.property.getWriteMethod().getAnnotation(cls) : a10;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public List<Annotation> getAnnotations() {
        return (isReadable() && isWritable()) ? ArrayUtils.toUnmodifiableCompositeList(this.property.getReadMethod().getAnnotations(), this.property.getWriteMethod().getAnnotations()) : isReadable() ? ArrayUtils.toUnmodifiableList(this.property.getReadMethod().getAnnotations()) : ArrayUtils.toUnmodifiableList(this.property.getWriteMethod().getAnnotations());
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isReadable() {
        return this.readable;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isWritable() {
        return this.writable;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public void set(Object obj, Object obj2) throws Exception {
        if (this.writable) {
            this.property.getWriteMethod().invoke(obj, obj2);
            return;
        }
        throw new YAMLException("No writable property '" + getName() + "' on class: " + obj.getClass().getName());
    }
}
