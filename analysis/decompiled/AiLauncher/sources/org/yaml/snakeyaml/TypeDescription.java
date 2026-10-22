package org.yaml.snakeyaml;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.internal.Logger;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertySubstitute;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes5.dex */
public class TypeDescription {
    private static final Logger log = Logger.getLogger(TypeDescription.class.getPackage().getName());
    protected BeanAccess beanAccess;
    private transient boolean delegatesChecked;
    private transient Set<Property> dumpProperties;
    protected Set<String> excludes;
    private Class<?> impl;
    protected String[] includes;
    private Map<String, PropertySubstitute> properties;
    private transient PropertyUtils propertyUtils;
    private final Tag tag;
    private final Class<? extends Object> type;

    public TypeDescription(Class<? extends Object> cls, Tag tag) {
        this(cls, tag, null);
    }

    private void checkDelegates() {
        for (PropertySubstitute propertySubstitute : this.properties.values()) {
            try {
                propertySubstitute.setDelegate(discoverProperty(propertySubstitute.getName()));
            } catch (YAMLException unused) {
            }
        }
        this.delegatesChecked = true;
    }

    private Property discoverProperty(String str) {
        PropertyUtils propertyUtils = this.propertyUtils;
        if (propertyUtils == null) {
            return null;
        }
        BeanAccess beanAccess = this.beanAccess;
        return beanAccess == null ? propertyUtils.getProperty(this.type, str) : propertyUtils.getProperty(this.type, str, beanAccess);
    }

    public void addPropertyParameters(String str, Class<?>... clsArr) throws SecurityException {
        if (this.properties.containsKey(str)) {
            this.properties.get(str).setActualTypeArguments(clsArr);
        } else {
            substituteProperty(str, null, null, null, clsArr);
        }
    }

    public Object finalizeConstruction(Object obj) {
        return obj;
    }

    public Set<Property> getProperties() {
        Set<Property> set = this.dumpProperties;
        if (set != null) {
            return set;
        }
        PropertyUtils propertyUtils = this.propertyUtils;
        if (propertyUtils == null) {
            return null;
        }
        if (this.includes != null) {
            this.dumpProperties = new LinkedHashSet();
            for (String str : this.includes) {
                if (!this.excludes.contains(str)) {
                    this.dumpProperties.add(getProperty(str));
                }
            }
            return this.dumpProperties;
        }
        BeanAccess beanAccess = this.beanAccess;
        Set<Property> properties = beanAccess == null ? propertyUtils.getProperties(this.type) : propertyUtils.getProperties(this.type, beanAccess);
        if (this.properties.isEmpty()) {
            if (this.excludes.isEmpty()) {
                this.dumpProperties = properties;
                return properties;
            }
            this.dumpProperties = new LinkedHashSet();
            for (Property property : properties) {
                if (!this.excludes.contains(property.getName())) {
                    this.dumpProperties.add(property);
                }
            }
            return this.dumpProperties;
        }
        if (!this.delegatesChecked) {
            checkDelegates();
        }
        this.dumpProperties = new LinkedHashSet();
        for (PropertySubstitute propertySubstitute : this.properties.values()) {
            if (!this.excludes.contains(propertySubstitute.getName()) && propertySubstitute.isReadable()) {
                this.dumpProperties.add(propertySubstitute);
            }
        }
        for (Property property2 : properties) {
            if (!this.excludes.contains(property2.getName())) {
                this.dumpProperties.add(property2);
            }
        }
        return this.dumpProperties;
    }

    public Property getProperty(String str) {
        if (!this.delegatesChecked) {
            checkDelegates();
        }
        return this.properties.containsKey(str) ? this.properties.get(str) : discoverProperty(str);
    }

    public Tag getTag() {
        return this.tag;
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    public Object newInstance(String str, Node node) {
        return null;
    }

    @Deprecated
    public void putListPropertyType(String str, Class<? extends Object> cls) throws SecurityException {
        addPropertyParameters(str, cls);
    }

    @Deprecated
    public void putMapPropertyType(String str, Class<? extends Object> cls, Class<? extends Object> cls2) throws SecurityException {
        addPropertyParameters(str, cls, cls2);
    }

    public void setExcludes(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            this.excludes = Collections.EMPTY_SET;
            return;
        }
        HashSet hashSet = new HashSet();
        this.excludes = hashSet;
        Collections.addAll(hashSet, strArr);
    }

    public void setIncludes(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            strArr = null;
        }
        this.includes = strArr;
    }

    public boolean setProperty(Object obj, String str, Object obj2) throws Exception {
        return false;
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
    }

    public boolean setupPropertyType(String str, Node node) {
        return false;
    }

    public void substituteProperty(String str, Class<?> cls, String str2, String str3, Class<?>... clsArr) throws SecurityException {
        substituteProperty(new PropertySubstitute(str, cls, str2, str3, clsArr));
    }

    public String toString() {
        return "TypeDescription for " + getType() + " (tag='" + getTag() + "')";
    }

    public TypeDescription(Class<? extends Object> cls, Tag tag, Class<?> cls2) {
        this.properties = Collections.EMPTY_MAP;
        this.excludes = Collections.EMPTY_SET;
        this.includes = null;
        this.type = cls;
        this.tag = tag;
        this.impl = cls2;
        this.beanAccess = null;
    }

    public Object newInstance(Node node) throws NoSuchMethodException, SecurityException {
        Class<?> cls = this.impl;
        if (cls != null) {
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null);
            } catch (Exception e10) {
                log.warn(e10.getLocalizedMessage());
                this.impl = null;
            }
        }
        return null;
    }

    public void substituteProperty(PropertySubstitute propertySubstitute) throws SecurityException {
        if (Collections.EMPTY_MAP == this.properties) {
            this.properties = new LinkedHashMap();
        }
        propertySubstitute.setTargetType(this.type);
        this.properties.put(propertySubstitute.getName(), propertySubstitute);
    }

    public TypeDescription(Class<? extends Object> cls, String str) {
        this(cls, new Tag(str), null);
    }

    public TypeDescription(Class<? extends Object> cls) {
        this(cls, new Tag(cls), null);
    }

    public TypeDescription(Class<? extends Object> cls, Class<?> cls2) {
        this(cls, new Tag(cls), cls2);
    }
}
