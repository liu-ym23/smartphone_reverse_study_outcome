package org.yaml.snakeyaml.introspector;

import io.ktor.sse.ServerSentEventKt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.internal.Logger;

/* loaded from: classes5.dex */
public class PropertySubstitute extends Property {
    private static final Logger log = Logger.getLogger(PropertySubstitute.class.getPackage().getName());
    private Property delegate;
    private Field field;
    private boolean filler;
    protected Class<?>[] parameters;
    private transient Method read;
    private final String readMethod;
    protected Class<?> targetType;
    private transient Method write;
    private final String writeMethod;

    public PropertySubstitute(String str, Class<?> cls, String str2, String str3, Class<?>... clsArr) {
        super(str, cls);
        this.readMethod = str2;
        this.writeMethod = str3;
        setActualTypeArguments(clsArr);
        this.filler = false;
    }

    private Method discoverMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException {
        while (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != clsArr.length) {
                        continue;
                    } else {
                        boolean z10 = true;
                        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
                            if (!parameterTypes[i10].isAssignableFrom(clsArr[i10])) {
                                z10 = false;
                            }
                        }
                        if (z10) {
                            method.setAccessible(true);
                            return method;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        Logger logger = log;
        if (!logger.isLoggable(Logger.Level.WARNING)) {
            return null;
        }
        logger.warn(String.format("Failed to find [%s(%d args)] for %s.%s", str, Integer.valueOf(clsArr.length), this.targetType.getName(), getName()));
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Object get(Object obj) {
        try {
            Method method = this.read;
            if (method != null) {
                return method.invoke(obj, null);
            }
            Field field = this.field;
            if (field != null) {
                return field.get(obj);
            }
            Property property = this.delegate;
            if (property != null) {
                return property.get(obj);
            }
            throw new YAMLException("No getter or delegate for property '" + getName() + "' on object " + obj);
        } catch (Exception e10) {
            throw new YAMLException("Unable to find getter for property '" + getName() + "' on object " + obj + ServerSentEventKt.COLON + e10);
        }
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        Property property;
        Class<?>[] clsArr = this.parameters;
        return (clsArr != null || (property = this.delegate) == null) ? clsArr : property.getActualTypeArguments();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Method method = this.read;
        if (method != null) {
            return (A) method.getAnnotation(cls);
        }
        Field field = this.field;
        return field != null ? (A) field.getAnnotation(cls) : (A) this.delegate.getAnnotation(cls);
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public List<Annotation> getAnnotations() {
        Annotation[] annotations;
        Method method = this.read;
        if (method != null) {
            annotations = method.getAnnotations();
        } else {
            Field field = this.field;
            annotations = field != null ? field.getAnnotations() : null;
        }
        return annotations != null ? Arrays.asList(annotations) : this.delegate.getAnnotations();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public String getName() {
        String name = super.getName();
        if (name != null) {
            return name;
        }
        Property property = this.delegate;
        if (property != null) {
            return property.getName();
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Class<?> getType() {
        Class<?> type = super.getType();
        if (type != null) {
            return type;
        }
        Property property = this.delegate;
        if (property != null) {
            return property.getType();
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isReadable() {
        if (this.read != null || this.field != null) {
            return true;
        }
        Property property = this.delegate;
        return property != null && property.isReadable();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isWritable() {
        if (this.write != null || this.field != null) {
            return true;
        }
        Property property = this.delegate;
        return property != null && property.isWritable();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public void set(Object obj, Object obj2) throws Exception {
        Method method = this.write;
        if (method == null) {
            Field field = this.field;
            if (field != null) {
                field.set(obj, obj2);
                return;
            }
            Property property = this.delegate;
            if (property != null) {
                property.set(obj, obj2);
                return;
            }
            log.warn("No setter/delegate for '" + getName() + "' on object " + obj);
            return;
        }
        if (!this.filler) {
            method.invoke(obj, obj2);
            return;
        }
        if (obj2 != null) {
            if (obj2 instanceof Collection) {
                Iterator it = ((Collection) obj2).iterator();
                while (it.hasNext()) {
                    this.write.invoke(obj, it.next());
                }
                return;
            }
            if (obj2 instanceof Map) {
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    this.write.invoke(obj, entry.getKey(), entry.getValue());
                }
                return;
            }
            if (obj2.getClass().isArray()) {
                int length = Array.getLength(obj2);
                for (int i10 = 0; i10 < length; i10++) {
                    this.write.invoke(obj, Array.get(obj2, i10));
                }
            }
        }
    }

    public void setActualTypeArguments(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            this.parameters = null;
        } else {
            this.parameters = clsArr;
        }
    }

    public void setDelegate(Property property) {
        this.delegate = property;
        String str = this.writeMethod;
        if (str == null || this.write != null || this.filler) {
            return;
        }
        this.filler = true;
        this.write = discoverMethod(this.targetType, str, getActualTypeArguments());
    }

    public void setTargetType(Class<?> cls) throws SecurityException {
        Class<?>[] clsArr;
        if (this.targetType != cls) {
            this.targetType = cls;
            String name = getName();
            Class<?> superclass = cls;
            while (true) {
                int i10 = 0;
                if (superclass == null) {
                    break;
                }
                Field[] declaredFields = superclass.getDeclaredFields();
                int length = declaredFields.length;
                while (true) {
                    if (i10 < length) {
                        Field field = declaredFields[i10];
                        if (field.getName().equals(name)) {
                            int modifiers = field.getModifiers();
                            if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                                field.setAccessible(true);
                                this.field = field;
                            }
                        } else {
                            i10++;
                        }
                    }
                }
                superclass = superclass.getSuperclass();
            }
            if (this.field == null) {
                Logger logger = log;
                if (logger.isLoggable(Logger.Level.WARNING)) {
                    logger.warn(String.format("Failed to find field for %s.%s", cls.getName(), getName()));
                }
            }
            String str = this.readMethod;
            if (str != null) {
                this.read = discoverMethod(cls, str, new Class[0]);
            }
            String str2 = this.writeMethod;
            if (str2 != null) {
                this.filler = false;
                Method methodDiscoverMethod = discoverMethod(cls, str2, getType());
                this.write = methodDiscoverMethod;
                if (methodDiscoverMethod != null || (clsArr = this.parameters) == null) {
                    return;
                }
                this.filler = true;
                this.write = discoverMethod(cls, this.writeMethod, clsArr);
            }
        }
    }

    public PropertySubstitute(String str, Class<?> cls, Class<?>... clsArr) {
        this(str, cls, null, null, clsArr);
    }
}
