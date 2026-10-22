package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.PlatformFeatureDetector;

/* loaded from: classes5.dex */
public class PropertyUtils {
    private boolean allowReadOnlyProperties;
    private BeanAccess beanAccess;
    private final PlatformFeatureDetector platformFeatureDetector;
    private final Map<Class<?>, Map<String, Property>> propertiesCache;
    private final Map<Class<?>, Set<Property>> readableProperties;
    private boolean skipMissingProperties;

    public PropertyUtils() {
        this(new PlatformFeatureDetector());
    }

    public Set<Property> createPropertySet(Class<? extends Object> cls, BeanAccess beanAccess) {
        TreeSet treeSet = new TreeSet();
        for (Property property : getPropertiesMap(cls, beanAccess).values()) {
            if (property.isReadable() && (this.allowReadOnlyProperties || property.isWritable())) {
                treeSet.add(property);
            }
        }
        return treeSet;
    }

    public Set<Property> getProperties(Class<? extends Object> cls) {
        return getProperties(cls, this.beanAccess);
    }

    public Map<String, Property> getPropertiesMap(Class<?> cls, BeanAccess beanAccess) {
        boolean zAddPublicFields;
        if (this.propertiesCache.containsKey(cls)) {
            return this.propertiesCache.get(cls);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (beanAccess == BeanAccess.FIELD) {
            Class<?> superclass = cls;
            while (true) {
                zAddPublicFields = false;
                if (superclass == null) {
                    break;
                }
                for (Field field : superclass.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && !linkedHashMap.containsKey(field.getName())) {
                        linkedHashMap.put(field.getName(), new FieldProperty(field));
                    }
                }
                superclass = superclass.getSuperclass();
            }
        } else {
            zAddPublicFields = MethodProperty.addPublicFields(cls, linkedHashMap);
        }
        if (!linkedHashMap.isEmpty() || !zAddPublicFields) {
            this.propertiesCache.put(cls, linkedHashMap);
            return linkedHashMap;
        }
        throw new YAMLException("No JavaBean properties found in " + cls.getName());
    }

    public Property getProperty(Class<? extends Object> cls, String str) {
        return getProperty(cls, str, this.beanAccess);
    }

    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }

    public boolean isSkipMissingProperties() {
        return this.skipMissingProperties;
    }

    public void setAllowReadOnlyProperties(boolean z10) {
        if (this.allowReadOnlyProperties != z10) {
            this.allowReadOnlyProperties = z10;
            this.readableProperties.clear();
        }
    }

    public void setBeanAccess(BeanAccess beanAccess) {
        if (this.platformFeatureDetector.isRunningOnAndroid() && beanAccess != BeanAccess.FIELD) {
            throw new IllegalArgumentException("JVM is Android - only BeanAccess.FIELD is available");
        }
        if (this.beanAccess != beanAccess) {
            this.beanAccess = beanAccess;
            this.propertiesCache.clear();
            this.readableProperties.clear();
        }
    }

    public void setSkipMissingProperties(boolean z10) {
        if (this.skipMissingProperties != z10) {
            this.skipMissingProperties = z10;
            this.readableProperties.clear();
        }
    }

    public PropertyUtils(PlatformFeatureDetector platformFeatureDetector) {
        this.propertiesCache = new HashMap();
        this.readableProperties = new HashMap();
        this.beanAccess = BeanAccess.DEFAULT;
        this.allowReadOnlyProperties = false;
        this.skipMissingProperties = false;
        this.platformFeatureDetector = platformFeatureDetector;
        if (platformFeatureDetector.isIntrospectionAvailable()) {
            return;
        }
        this.beanAccess = BeanAccess.FIELD;
    }

    public Set<Property> getProperties(Class<? extends Object> cls, BeanAccess beanAccess) {
        if (this.readableProperties.containsKey(cls)) {
            return this.readableProperties.get(cls);
        }
        Set<Property> setCreatePropertySet = createPropertySet(cls, beanAccess);
        this.readableProperties.put(cls, setCreatePropertySet);
        return setCreatePropertySet;
    }

    public Property getProperty(Class<? extends Object> cls, String str, BeanAccess beanAccess) {
        Property missingProperty = getPropertiesMap(cls, beanAccess).get(str);
        if (missingProperty == null && this.skipMissingProperties) {
            missingProperty = new MissingProperty(str);
        }
        if (missingProperty != null) {
            return missingProperty;
        }
        throw new YAMLException("Unable to find property '" + str + "' on class: " + cls.getName());
    }
}
