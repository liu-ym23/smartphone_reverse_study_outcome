package com.fasterxml.jackson.databind.deser;

import B7.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class BeanDeserializerBuilder {
    protected SettableAnyProperty _anySetter;
    protected HashMap<String, SettableBeanProperty> _backRefProperties;
    protected final BeanDescription _beanDesc;
    protected AnnotatedMethod _buildMethod;
    protected JsonPOJOBuilder.Value _builderConfig;
    protected final DeserializationConfig _config;
    protected final DeserializationContext _context;
    protected HashSet<String> _ignorableProps;
    protected boolean _ignoreAllUnknown;
    protected HashSet<String> _includableProps;
    protected List<ValueInjector> _injectables;
    protected ObjectIdReader _objectIdReader;
    protected final Map<String, SettableBeanProperty> _properties;
    protected SettableBeanProperty[] _propsBasedCreatorParams;
    protected ValueInstantiator _valueInstantiator;

    public BeanDeserializerBuilder(BeanDescription beanDescription, DeserializationContext deserializationContext) {
        this._properties = new LinkedHashMap();
        this._beanDesc = beanDescription;
        this._context = deserializationContext;
        this._config = deserializationContext.getConfig();
    }

    private static HashMap<String, SettableBeanProperty> _copy(HashMap<String, SettableBeanProperty> map) {
        if (map == null) {
            return null;
        }
        return new HashMap<>(map);
    }

    public Map<String, List<PropertyName>> _collectAliases(Collection<SettableBeanProperty> collection) {
        HashMap map = null;
        for (SettableBeanProperty settableBeanProperty : collection) {
            List<PropertyName> listFindAliases = settableBeanProperty.findAliases(this._config);
            if (listFindAliases != null && !listFindAliases.isEmpty()) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(settableBeanProperty.getName(), listFindAliases);
            }
        }
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public boolean _findCaseInsensitivity() {
        Boolean feature = this._beanDesc.findExpectedFormat().getFeature(JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        return feature == null ? this._config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : feature.booleanValue();
    }

    public void _fixAccess(Collection<SettableBeanProperty> collection) throws SecurityException, DatabindException {
        if (this._config.canOverrideAccessModifiers()) {
            Iterator<SettableBeanProperty> it = collection.iterator();
            while (it.hasNext()) {
                try {
                    it.next().fixAccess(this._config);
                } catch (IllegalArgumentException e) {
                    _handleBadAccess(e);
                }
            }
        }
        SettableAnyProperty settableAnyProperty = this._anySetter;
        if (settableAnyProperty != null) {
            try {
                settableAnyProperty.fixAccess(this._config);
            } catch (IllegalArgumentException e6) {
                _handleBadAccess(e6);
            }
        }
        AnnotatedMethod annotatedMethod = this._buildMethod;
        if (annotatedMethod != null) {
            try {
                annotatedMethod.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            } catch (IllegalArgumentException e9) {
                _handleBadAccess(e9);
            }
        }
    }

    public void _handleBadAccess(IllegalArgumentException illegalArgumentException) throws DatabindException {
        try {
            this._context.reportBadTypeDefinition(this._beanDesc, illegalArgumentException.getMessage(), new Object[0]);
        } catch (DatabindException e) {
            if (e.getCause() == null) {
                e.initCause(illegalArgumentException);
            }
            throw e;
        }
    }

    public void addBackReferenceProperty(String str, SettableBeanProperty settableBeanProperty) throws DatabindException {
        if (this._backRefProperties == null) {
            this._backRefProperties = new HashMap<>(4);
        }
        if (this._config.canOverrideAccessModifiers()) {
            try {
                settableBeanProperty.fixAccess(this._config);
            } catch (IllegalArgumentException e) {
                _handleBadAccess(e);
            }
        }
        this._backRefProperties.put(str, settableBeanProperty);
    }

    public void addCreatorProperty(SettableBeanProperty settableBeanProperty) {
        addProperty(settableBeanProperty);
    }

    public void addIgnorable(String str) {
        if (this._ignorableProps == null) {
            this._ignorableProps = new HashSet<>();
        }
        this._ignorableProps.add(str);
    }

    public void addIncludable(String str) {
        if (this._includableProps == null) {
            this._includableProps = new HashSet<>();
        }
        this._includableProps.add(str);
    }

    public void addInjectable(PropertyName propertyName, JavaType javaType, Annotations annotations, AnnotatedMember annotatedMember, Object obj) throws SecurityException, DatabindException {
        if (this._injectables == null) {
            this._injectables = new ArrayList();
        }
        if (this._config.canOverrideAccessModifiers()) {
            try {
                annotatedMember.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            } catch (IllegalArgumentException e) {
                _handleBadAccess(e);
            }
        }
        this._injectables.add(new ValueInjector(propertyName, javaType, annotatedMember, obj));
    }

    public void addOrReplaceProperty(SettableBeanProperty settableBeanProperty, boolean z10) {
        SettableBeanProperty[] settableBeanPropertyArr;
        SettableBeanProperty settableBeanPropertyPut = this._properties.put(settableBeanProperty.getName(), settableBeanProperty);
        if (settableBeanPropertyPut == null || (settableBeanPropertyArr = this._propsBasedCreatorParams) == null) {
            return;
        }
        int length = settableBeanPropertyArr.length;
        for (int i = 0; i < length; i++) {
            SettableBeanProperty[] settableBeanPropertyArr2 = this._propsBasedCreatorParams;
            if (settableBeanPropertyArr2[i] == settableBeanPropertyPut) {
                settableBeanPropertyArr2[i] = settableBeanProperty;
            }
        }
    }

    public void addProperty(SettableBeanProperty settableBeanProperty) {
        SettableBeanProperty settableBeanPropertyPut = this._properties.put(settableBeanProperty.getName(), settableBeanProperty);
        if (settableBeanPropertyPut == null || settableBeanPropertyPut == settableBeanProperty) {
            return;
        }
        throw new IllegalArgumentException("Duplicate property '" + settableBeanProperty.getName() + "' for " + this._beanDesc.getType());
    }

    public JsonDeserializer<?> build() throws SecurityException, DatabindException {
        Collection<SettableBeanProperty> collectionValues = this._properties.values();
        _fixAccess(collectionValues);
        BeanPropertyMap beanPropertyMapConstruct = BeanPropertyMap.construct(this._config, collectionValues, _collectAliases(collectionValues), _findCaseInsensitivity());
        beanPropertyMapConstruct.assignIndexes();
        boolean zIsEnabled = this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        boolean z10 = !zIsEnabled;
        if (zIsEnabled) {
            Iterator<SettableBeanProperty> it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().hasViews()) {
                    z10 = true;
                    break;
                }
            }
        }
        boolean z11 = z10;
        if (this._objectIdReader != null) {
            beanPropertyMapConstruct = beanPropertyMapConstruct.withProperty(new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        return new BeanDeserializer(this, this._beanDesc, beanPropertyMapConstruct, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, this._includableProps, z11);
    }

    public AbstractDeserializer buildAbstract() {
        return new AbstractDeserializer(this, this._beanDesc, this._backRefProperties, this._properties);
    }

    public JsonDeserializer<?> buildBuilderBased(JavaType javaType, String str) throws SecurityException, DatabindException {
        AnnotatedMethod annotatedMethod = this._buildMethod;
        if (annotatedMethod != null) {
            Class<?> rawReturnType = annotatedMethod.getRawReturnType();
            Class<?> rawClass = javaType.getRawClass();
            if (rawReturnType != rawClass && !rawReturnType.isAssignableFrom(rawClass) && !rawClass.isAssignableFrom(rawReturnType)) {
                DeserializationContext deserializationContext = this._context;
                JavaType type = this._beanDesc.getType();
                String fullName = this._buildMethod.getFullName();
                String classDescription = ClassUtil.getClassDescription(rawReturnType);
                String typeDescription = ClassUtil.getTypeDescription(javaType);
                StringBuilder sbW = a.w("Build method `", fullName, "` has wrong return type (", classDescription, "), not compatible with POJO type (");
                sbW.append(typeDescription);
                sbW.append(")");
                deserializationContext.reportBadDefinition(type, sbW.toString());
            }
        } else if (!str.isEmpty()) {
            this._context.reportBadDefinition(this._beanDesc.getType(), androidx.appfunctions.metadata.a.m("Builder class ", ClassUtil.getTypeDescription(this._beanDesc.getType()), " does not have build method (name: '", str, "')"));
        }
        Collection<SettableBeanProperty> collectionValues = this._properties.values();
        _fixAccess(collectionValues);
        BeanPropertyMap beanPropertyMapConstruct = BeanPropertyMap.construct(this._config, collectionValues, _collectAliases(collectionValues), _findCaseInsensitivity());
        beanPropertyMapConstruct.assignIndexes();
        boolean zIsEnabled = this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        boolean z10 = !zIsEnabled;
        if (zIsEnabled) {
            Iterator<SettableBeanProperty> it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().hasViews()) {
                    z10 = true;
                    break;
                }
            }
        }
        if (this._objectIdReader != null) {
            beanPropertyMapConstruct = beanPropertyMapConstruct.withProperty(new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        return createBuilderBasedDeserializer(javaType, beanPropertyMapConstruct, z10);
    }

    public JsonDeserializer<?> createBuilderBasedDeserializer(JavaType javaType, BeanPropertyMap beanPropertyMap, boolean z10) {
        return new BuilderBasedDeserializer(this, this._beanDesc, javaType, beanPropertyMap, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, this._includableProps, z10);
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return this._properties.get(propertyName.getSimpleName());
    }

    public SettableAnyProperty getAnySetter() {
        return this._anySetter;
    }

    public AnnotatedMethod getBuildMethod() {
        return this._buildMethod;
    }

    public JsonPOJOBuilder.Value getBuilderConfig() {
        return this._builderConfig;
    }

    public List<ValueInjector> getInjectables() {
        return this._injectables;
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public Iterator<SettableBeanProperty> getProperties() {
        return this._properties.values().iterator();
    }

    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public boolean hasIgnorable(String str) {
        return IgnorePropertiesUtil.shouldIgnore(str, this._ignorableProps, this._includableProps);
    }

    public boolean hasProperty(PropertyName propertyName) {
        return findProperty(propertyName) != null;
    }

    public SettableBeanProperty removeProperty(PropertyName propertyName) {
        return this._properties.remove(propertyName.getSimpleName());
    }

    public void setAnySetter(SettableAnyProperty settableAnyProperty) {
        if (this._anySetter != null && settableAnyProperty != null) {
            throw new IllegalStateException("_anySetter already set to non-null");
        }
        this._anySetter = settableAnyProperty;
    }

    public void setIgnoreUnknownProperties(boolean z10) {
        this._ignoreAllUnknown = z10;
    }

    public void setObjectIdReader(ObjectIdReader objectIdReader) {
        this._objectIdReader = objectIdReader;
    }

    public void setPOJOBuilder(AnnotatedMethod annotatedMethod, JsonPOJOBuilder.Value value) {
        this._buildMethod = annotatedMethod;
        this._builderConfig = value;
    }

    public void setValueInstantiator(ValueInstantiator valueInstantiator) {
        this._valueInstantiator = valueInstantiator;
        this._propsBasedCreatorParams = valueInstantiator.getFromObjectArguments(this._config);
    }

    private static <T> List<T> _copy(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    public BeanDeserializerBuilder(BeanDeserializerBuilder beanDeserializerBuilder) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this._properties = linkedHashMap;
        this._beanDesc = beanDeserializerBuilder._beanDesc;
        this._context = beanDeserializerBuilder._context;
        this._config = beanDeserializerBuilder._config;
        linkedHashMap.putAll(beanDeserializerBuilder._properties);
        this._injectables = _copy(beanDeserializerBuilder._injectables);
        this._backRefProperties = _copy(beanDeserializerBuilder._backRefProperties);
        this._ignorableProps = beanDeserializerBuilder._ignorableProps;
        this._includableProps = beanDeserializerBuilder._includableProps;
        this._valueInstantiator = beanDeserializerBuilder._valueInstantiator;
        this._propsBasedCreatorParams = beanDeserializerBuilder._propsBasedCreatorParams;
        this._objectIdReader = beanDeserializerBuilder._objectIdReader;
        this._anySetter = beanDeserializerBuilder._anySetter;
        this._ignoreAllUnknown = beanDeserializerBuilder._ignoreAllUnknown;
        this._buildMethod = beanDeserializerBuilder._buildMethod;
        this._builderConfig = beanDeserializerBuilder._builderConfig;
    }
}
