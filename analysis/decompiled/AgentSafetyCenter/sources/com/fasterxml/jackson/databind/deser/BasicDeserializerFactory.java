package com.fasterxml.jackson.databind.deser;

import androidx.activity.b;
import b8.z;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.EnumNamingStrategyFactory;
import com.fasterxml.jackson.databind.introspect.PotentialCreator;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import g5.f;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    protected final DeserializerFactoryConfig _factoryConfig;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    private static final Class<?> CLASS_CHAR_SEQUENCE = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Map.Entry.class;
    private static final Class<?> CLASS_SERIALIZABLE = Serializable.class;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ContainerDefaultMappings {
        static final HashMap<String, Class<? extends Collection>> _collectionFallbacks;
        static final HashMap<String, Class<? extends Map>> _mapFallbacks;

        static {
            HashMap<String, Class<? extends Collection>> map = new HashMap<>();
            map.put(Collection.class.getName(), ArrayList.class);
            map.put(List.class.getName(), ArrayList.class);
            map.put(Set.class.getName(), HashSet.class);
            map.put(SortedSet.class.getName(), TreeSet.class);
            map.put(Queue.class.getName(), LinkedList.class);
            map.put(AbstractList.class.getName(), ArrayList.class);
            map.put(AbstractSet.class.getName(), HashSet.class);
            map.put(Deque.class.getName(), LinkedList.class);
            map.put(NavigableSet.class.getName(), TreeSet.class);
            map.put("java.util.SequencedCollection", ArrayList.class);
            map.put("java.util.SequencedSet", LinkedHashSet.class);
            _collectionFallbacks = map;
            HashMap<String, Class<? extends Map>> map2 = new HashMap<>();
            map2.put(Map.class.getName(), LinkedHashMap.class);
            map2.put(AbstractMap.class.getName(), LinkedHashMap.class);
            map2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            map2.put(SortedMap.class.getName(), TreeMap.class);
            map2.put(NavigableMap.class.getName(), TreeMap.class);
            map2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            map2.put("java.util.SequencedMap", LinkedHashMap.class);
            _mapFallbacks = map2;
        }

        public static Class<?> findCollectionFallback(JavaType javaType) {
            return _collectionFallbacks.get(javaType.getRawClass().getName());
        }

        public static Class<?> findMapFallback(JavaType javaType) {
            return _mapFallbacks.get(javaType.getRawClass().getName());
        }
    }

    public BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    private boolean _addExplicitDelegatingCreator(DeserializationContext deserializationContext, BeanDescription beanDescription, CreatorCollector creatorCollector, CreatorCandidate creatorCandidate) throws InvalidDefinitionException {
        BasicDeserializerFactory basicDeserializerFactory;
        DeserializationContext deserializationContext2;
        BeanDescription beanDescription2;
        int iParamCount = creatorCandidate.paramCount();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iParamCount];
        if (iParamCount == 0) {
            creatorCollector.addPropertyCreator(creatorCandidate.creator(), true, settableBeanPropertyArr);
            return true;
        }
        int i = -1;
        int i3 = 0;
        while (i3 < iParamCount) {
            AnnotatedParameter annotatedParameterParameter = creatorCandidate.parameter(i3);
            JacksonInject.Value valueInjection = creatorCandidate.injection(i3);
            if (valueInjection != null) {
                basicDeserializerFactory = this;
                deserializationContext2 = deserializationContext;
                beanDescription2 = beanDescription;
                settableBeanPropertyArr[i3] = basicDeserializerFactory.constructCreatorProperty(deserializationContext2, beanDescription2, null, i3, annotatedParameterParameter, valueInjection);
            } else {
                basicDeserializerFactory = this;
                deserializationContext2 = deserializationContext;
                beanDescription2 = beanDescription;
                if (i < 0) {
                    i = i3;
                } else {
                    deserializationContext2.reportBadTypeDefinition(beanDescription2, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i), Integer.valueOf(i3), creatorCandidate);
                }
            }
            i3++;
            this = basicDeserializerFactory;
            deserializationContext = deserializationContext2;
            beanDescription = beanDescription2;
        }
        BasicDeserializerFactory basicDeserializerFactory2 = this;
        DeserializationContext deserializationContext3 = deserializationContext;
        BeanDescription beanDescription3 = beanDescription;
        if (i < 0) {
            deserializationContext3.reportBadTypeDefinition(beanDescription3, "No argument left as delegating for Creator %s: exactly one required", creatorCandidate);
        }
        if (iParamCount == 1) {
            return basicDeserializerFactory2._handleSingleArgumentCreator(creatorCollector, creatorCandidate.creator(), true, true);
        }
        creatorCollector.addDelegatingCreator(creatorCandidate.creator(), true, settableBeanPropertyArr, i);
        return true;
    }

    private boolean _addExplicitDelegatingCreators(DeserializationContext deserializationContext, BeanDescription beanDescription, CreatorCollector creatorCollector, List<PotentialCreator> list) {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Iterator<PotentialCreator> it = list.iterator();
        boolean z_addExplicitDelegatingCreator = false;
        while (it.hasNext()) {
            z_addExplicitDelegatingCreator |= _addExplicitDelegatingCreator(deserializationContext, beanDescription, creatorCollector, CreatorCandidate.construct(annotationIntrospector, it.next().creator(), null));
        }
        return z_addExplicitDelegatingCreator;
    }

    private void _addImplicitDelegatingConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, CreatorCollector creatorCollector, List<PotentialCreator> list) {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        for (PotentialCreator potentialCreator : list) {
            int iParamCount = potentialCreator.paramCount();
            AnnotatedWithParams annotatedWithParamsCreator = potentialCreator.creator();
            if (iParamCount == 1) {
                _handleSingleArgumentCreator(creatorCollector, annotatedWithParamsCreator, false, visibilityChecker.isCreatorVisible(annotatedWithParamsCreator));
            } else {
                BasicDeserializerFactory basicDeserializerFactory = this;
                SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iParamCount];
                int i = 0;
                int i3 = 0;
                while (i < iParamCount) {
                    AnnotatedParameter parameter = annotatedWithParamsCreator.getParameter(i);
                    JacksonInject.Value valueFindInjectableValue = annotationIntrospector.findInjectableValue(parameter);
                    if (valueFindInjectableValue != null) {
                        i3++;
                        settableBeanPropertyArr[i] = basicDeserializerFactory.constructCreatorProperty(deserializationContext, beanDescription, null, i, parameter, valueFindInjectableValue);
                    } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                        settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, UnwrappedPropertyHandler.creatorParamName(i), i, parameter, null);
                    }
                    i++;
                    basicDeserializerFactory = this;
                }
                if (i3 + 1 == iParamCount) {
                    creatorCollector.addDelegatingCreator(annotatedWithParamsCreator, false, settableBeanPropertyArr, 0);
                }
            }
        }
    }

    private void _addImplicitDelegatingFactories(DeserializationContext deserializationContext, VisibilityChecker<?> visibilityChecker, CreatorCollector creatorCollector, List<PotentialCreator> list) {
        for (PotentialCreator potentialCreator : list) {
            int iParamCount = potentialCreator.paramCount();
            AnnotatedWithParams annotatedWithParamsCreator = potentialCreator.creator();
            if (iParamCount == 1) {
                _handleSingleArgumentCreator(creatorCollector, annotatedWithParamsCreator, false, visibilityChecker.isCreatorVisible(annotatedWithParamsCreator));
            }
        }
    }

    private void _addSelectedPropertiesBasedCreator(DeserializationContext deserializationContext, BeanDescription beanDescription, CreatorCollector creatorCollector, CreatorCandidate creatorCandidate) throws InvalidDefinitionException {
        int iParamCount = creatorCandidate.paramCount();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iParamCount];
        int i = -1;
        for (int i3 = 0; i3 < iParamCount; i3++) {
            JacksonInject.Value valueInjection = creatorCandidate.injection(i3);
            AnnotatedParameter annotatedParameterParameter = creatorCandidate.parameter(i3);
            PropertyName propertyNameParamName = creatorCandidate.paramName(i3);
            if (Boolean.TRUE.equals(deserializationContext.getAnnotationIntrospector().hasAnySetter(annotatedParameterParameter))) {
                if (i >= 0) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "More than one 'any-setter' specified (parameter #%d vs #%d)", Integer.valueOf(i), Integer.valueOf(i3));
                } else {
                    i = i3;
                }
            } else if (propertyNameParamName == null) {
                if (deserializationContext.getAnnotationIntrospector().findUnwrappingNameTransformer(annotatedParameterParameter) != null) {
                    settableBeanPropertyArr[i3] = constructCreatorProperty(deserializationContext, beanDescription, UnwrappedPropertyHandler.creatorParamName(i3), i3, annotatedParameterParameter, null);
                }
                if (propertyNameParamName == null && valueInjection == null) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "Argument #%d of Creator %s has no property name (and is not Injectable): can not use as property-based Creator", Integer.valueOf(i3), creatorCandidate);
                }
            }
            settableBeanPropertyArr[i3] = constructCreatorProperty(deserializationContext, beanDescription, propertyNameParamName, i3, annotatedParameterParameter, valueInjection);
        }
        creatorCollector.addPropertyCreator(creatorCandidate.creator(), true, settableBeanPropertyArr);
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws SecurityException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        BeanDescription beanDescriptionIntrospect = config.introspect(javaType);
        KeyDeserializer keyDeserializerFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, beanDescriptionIntrospect.getClassInfo());
        if (keyDeserializerFindKeyDeserializerFromAnnotation != null) {
            return keyDeserializerFindKeyDeserializerFromAnnotation;
        }
        JsonDeserializer<?> jsonDeserializer_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, beanDescriptionIntrospect);
        if (jsonDeserializer_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, jsonDeserializer_findCustomEnumDeserializer);
        }
        JsonDeserializer<Object> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, beanDescriptionIntrospect.getClassInfo());
        if (jsonDeserializerFindDeserializerFromAnnotation != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, jsonDeserializerFindDeserializerFromAnnotation);
        }
        EnumResolver enumResolverConstructEnumResolver = constructEnumResolver(rawClass, config, beanDescriptionIntrospect);
        EnumResolver enumResolverConstructEnumNamingStrategyResolver = constructEnumNamingStrategyResolver(config, beanDescriptionIntrospect.getClassInfo());
        EnumResolver enumResolverConstructUsingToString = EnumResolver.constructUsingToString(config, beanDescriptionIntrospect.getClassInfo());
        EnumResolver enumResolverConstructUsingIndex = EnumResolver.constructUsingIndex(config, beanDescriptionIntrospect.getClassInfo());
        for (AnnotatedMethod annotatedMethod : beanDescriptionIntrospect.getFactoryMethods()) {
            if (_hasCreatorAnnotation(config, annotatedMethod)) {
                if (annotatedMethod.getParameterCount() != 1 || !annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    StringBuilder sb2 = new StringBuilder("Unsuitable method (");
                    sb2.append(annotatedMethod);
                    sb2.append(") decorated with @JsonCreator (for Enum type ");
                    f.s(b.m(sb2, rawClass, ")"));
                    return null;
                }
                if (annotatedMethod.getRawParameterType(0) == String.class) {
                    if (config.canOverrideAccessModifiers()) {
                        ClassUtil.checkAndFixAccess(annotatedMethod.getMember(), deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver, annotatedMethod, enumResolverConstructEnumNamingStrategyResolver, enumResolverConstructUsingToString, enumResolverConstructUsingIndex);
                }
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver, enumResolverConstructEnumNamingStrategyResolver, enumResolverConstructUsingToString, enumResolverConstructUsingIndex);
    }

    private PropertyMetadata _getSetterInfo(MapperConfig<?> mapperConfig, BeanProperty beanProperty, PropertyMetadata propertyMetadata) {
        Nulls nullsNonDefaultContentNulls;
        JsonSetter.Value valueFindSetterInfo;
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        AnnotatedMember member = beanProperty.getMember();
        Nulls nullsNonDefaultValueNulls = null;
        if (member != null) {
            if (annotationIntrospector == null || (valueFindSetterInfo = annotationIntrospector.findSetterInfo(member)) == null) {
                nullsNonDefaultContentNulls = null;
            } else {
                nullsNonDefaultValueNulls = valueFindSetterInfo.nonDefaultValueNulls();
                nullsNonDefaultContentNulls = valueFindSetterInfo.nonDefaultContentNulls();
            }
            JsonSetter.Value setterInfo = mapperConfig.getConfigOverride(beanProperty.getType().getRawClass()).getSetterInfo();
            if (setterInfo != null) {
                if (nullsNonDefaultValueNulls == null) {
                    nullsNonDefaultValueNulls = setterInfo.nonDefaultValueNulls();
                }
                if (nullsNonDefaultContentNulls == null) {
                    nullsNonDefaultContentNulls = setterInfo.nonDefaultContentNulls();
                }
            }
        } else {
            nullsNonDefaultContentNulls = null;
        }
        JsonSetter.Value defaultSetterInfo = mapperConfig.getDefaultSetterInfo();
        if (nullsNonDefaultValueNulls == null) {
            nullsNonDefaultValueNulls = defaultSetterInfo.nonDefaultValueNulls();
        }
        if (nullsNonDefaultContentNulls == null) {
            nullsNonDefaultContentNulls = defaultSetterInfo.nonDefaultContentNulls();
        }
        return (nullsNonDefaultValueNulls == null && nullsNonDefaultContentNulls == null) ? propertyMetadata : propertyMetadata.withNulls(nullsNonDefaultValueNulls, nullsNonDefaultContentNulls);
    }

    private boolean _handleSingleArgumentCreator(CreatorCollector creatorCollector, AnnotatedWithParams annotatedWithParams, boolean z10, boolean z11) {
        Class<?> rawParameterType = annotatedWithParams.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CLASS_CHAR_SEQUENCE) {
            if (z10 || z11) {
                creatorCollector.addStringCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z10 || z11) {
                creatorCollector.addIntCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z10 || z11) {
                creatorCollector.addLongCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z10 || z11) {
                creatorCollector.addDoubleCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (z10 || z11) {
                creatorCollector.addBooleanCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == BigInteger.class && (z10 || z11)) {
            creatorCollector.addBigIntegerCreator(annotatedWithParams, z10);
        }
        if (rawParameterType == BigDecimal.class && (z10 || z11)) {
            creatorCollector.addBigDecimalCreator(annotatedWithParams, z10);
        }
        if (!z10) {
            return false;
        }
        creatorCollector.addDelegatingCreator(annotatedWithParams, z10, null, 0);
        return true;
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        if (!this._factoryConfig.hasAbstractTypeResolvers()) {
            return null;
        }
        Iterator<AbstractTypeResolver> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeFindTypeMapping = it.next().findTypeMapping(deserializationConfig, javaType);
            if (javaTypeFindTypeMapping != null && !javaTypeFindTypeMapping.hasRawClass(rawClass)) {
                return javaTypeFindTypeMapping;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.databind.deser.ValueInstantiator _constructDefaultValueInstantiator(com.fasterxml.jackson.databind.DeserializationContext r12, com.fasterxml.jackson.databind.BeanDescription r13) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            r11 = this;
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r12.getConfig()
            com.fasterxml.jackson.databind.introspect.PotentialCreators r1 = r13.getPotentialCreators()
            com.fasterxml.jackson.databind.cfg.ConstructorDetector r2 = r0.getConstructorDetector()
            java.lang.Class r3 = r13.getBeanClass()
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r4 = r13.getClassInfo()
            com.fasterxml.jackson.databind.introspect.VisibilityChecker r8 = r0.getDefaultVisibilityChecker(r3, r4)
            com.fasterxml.jackson.databind.deser.impl.CreatorCollector r9 = new com.fasterxml.jackson.databind.deser.impl.CreatorCollector
            r9.<init>(r13, r0)
            boolean r3 = r1.hasPropertiesBased()
            if (r3 == 0) goto L46
            com.fasterxml.jackson.databind.introspect.PotentialCreator r3 = r1.propertiesBased
            int r4 = r3.paramCount()
            if (r4 != 0) goto L33
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r3.creator()
            r9.setDefaultCreator(r0)
            goto L46
        L33:
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r0.getAnnotationIntrospector()
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r4 = r3.creator()
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[] r3 = r3.propertyDefs()
            com.fasterxml.jackson.databind.deser.impl.CreatorCandidate r0 = com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.construct(r0, r4, r3)
            r11._addSelectedPropertiesBasedCreator(r12, r13, r9, r0)
        L46:
            java.util.List r0 = r1.getExplicitDelegating()
            boolean r0 = r11._addExplicitDelegatingCreators(r12, r13, r9, r0)
            com.fasterxml.jackson.databind.JavaType r3 = r13.getType()
            boolean r3 = r3.isConcrete()
            if (r3 == 0) goto L5e
            boolean r3 = r13.isNonStaticInnerClass()
            if (r3 == 0) goto L61
        L5e:
            r5 = r11
            r6 = r12
            goto L84
        L61:
            boolean r3 = r9.hasDefaultCreator()
            if (r3 != 0) goto L70
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r3 = r13.findDefaultConstructor()
            if (r3 == 0) goto L70
            r9.setDefaultCreator(r3)
        L70:
            java.lang.Class r3 = r13.getBeanClass()
            boolean r2 = r2.shouldIntrospectorImplicitConstructors(r3)
            if (r2 == 0) goto L5e
            java.util.List r10 = r1.getImplicitDelegatingConstructors()
            r5 = r11
            r6 = r12
            r7 = r13
            r5._addImplicitDelegatingConstructors(r6, r7, r8, r9, r10)
        L84:
            if (r0 != 0) goto L8d
            java.util.List r11 = r1.getImplicitDelegatingFactories()
            r5._addImplicitDelegatingFactories(r6, r8, r9, r11)
        L8d:
            com.fasterxml.jackson.databind.deser.ValueInstantiator r11 = r9.constructValueInstantiator(r6)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory._constructDefaultValueInstantiator(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.deser.ValueInstantiator");
    }

    public JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            ArrayType arrayType2 = arrayType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindArrayDeserializer = it.next().findArrayDeserializer(arrayType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindArrayDeserializer != null) {
                return jsonDeserializerFindArrayDeserializer;
            }
            arrayType = arrayType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    public JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindBeanDeserializer = it.next().findBeanDeserializer(javaType, deserializationConfig, beanDescription);
            if (jsonDeserializerFindBeanDeserializer != null) {
                return jsonDeserializerFindBeanDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            CollectionType collectionType2 = collectionType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindCollectionDeserializer = it.next().findCollectionDeserializer(collectionType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindCollectionDeserializer != null) {
                return jsonDeserializerFindCollectionDeserializer;
            }
            collectionType = collectionType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            CollectionLikeType collectionLikeType2 = collectionLikeType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindCollectionLikeDeserializer = it.next().findCollectionLikeDeserializer(collectionLikeType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindCollectionLikeDeserializer != null) {
                return jsonDeserializerFindCollectionLikeDeserializer;
            }
            collectionLikeType = collectionLikeType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindEnumDeserializer = it.next().findEnumDeserializer(cls, deserializationConfig, beanDescription);
            if (jsonDeserializerFindEnumDeserializer != null) {
                return jsonDeserializerFindEnumDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            MapType mapType2 = mapType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            KeyDeserializer keyDeserializer2 = keyDeserializer;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindMapDeserializer = it.next().findMapDeserializer(mapType2, deserializationConfig2, beanDescription2, keyDeserializer2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindMapDeserializer != null) {
                return jsonDeserializerFindMapDeserializer;
            }
            mapType = mapType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            keyDeserializer = keyDeserializer2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            MapLikeType mapLikeType2 = mapLikeType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            KeyDeserializer keyDeserializer2 = keyDeserializer;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindMapLikeDeserializer = it.next().findMapLikeDeserializer(mapLikeType2, deserializationConfig2, beanDescription2, keyDeserializer2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindMapLikeDeserializer != null) {
                return jsonDeserializerFindMapLikeDeserializer;
            }
            mapLikeType = mapLikeType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            keyDeserializer = keyDeserializer2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            ReferenceType referenceType2 = referenceType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindReferenceDeserializer = it.next().findReferenceDeserializer(referenceType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindReferenceDeserializer != null) {
                return jsonDeserializerFindReferenceDeserializer;
            }
            referenceType = referenceType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindTreeNodeDeserializer = it.next().findTreeNodeDeserializer(cls, deserializationConfig, beanDescription);
            if (jsonDeserializerFindTreeNodeDeserializer != null) {
                return jsonDeserializerFindTreeNodeDeserializer;
            }
        }
        return null;
    }

    public JavaType _findRemappedType(DeserializationConfig deserializationConfig, Class<?> cls) {
        JavaType javaTypeMapAbstractType = mapAbstractType(deserializationConfig, deserializationConfig.constructType(cls));
        if (javaTypeMapAbstractType == null || javaTypeMapAbstractType.hasRawClass(cls)) {
            return null;
        }
        return javaTypeMapAbstractType;
    }

    public boolean _hasCreatorAnnotation(MapperConfig<?> mapperConfig, Annotated annotated) {
        JsonCreator.Mode modeFindCreatorAnnotation;
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        return (annotationIntrospector == null || (modeFindCreatorAnnotation = annotationIntrospector.findCreatorAnnotation(mapperConfig, annotated)) == null || modeFindCreatorAnnotation == JsonCreator.Mode.DISABLED) ? false : true;
    }

    public CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<?> clsFindCollectionFallback = ContainerDefaultMappings.findCollectionFallback(javaType);
        if (clsFindCollectionFallback != null) {
            return (CollectionType) deserializationConfig.getTypeFactory().constructSpecializedType(javaType, clsFindCollectionFallback, true);
        }
        return null;
    }

    public MapType _mapAbstractMapType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<?> clsFindMapFallback = ContainerDefaultMappings.findMapFallback(javaType);
        if (clsFindMapFallback != null) {
            return (MapType) deserializationConfig.getTypeFactory().constructSpecializedType(javaType, clsFindMapFallback, true);
        }
        return null;
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationConfig, Annotated annotated, Object obj) {
        ValueInstantiator valueInstantiatorValueInstantiatorInstance;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (!(obj instanceof Class)) {
            z.m("AnnotationIntrospector returned key deserializer definition of type ", obj.getClass().getName(), "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            return null;
        }
        Class<?> cls = (Class) obj;
        if (ClassUtil.isBogusClass(cls)) {
            return null;
        }
        if (ValueInstantiator.class.isAssignableFrom(cls)) {
            HandlerInstantiator handlerInstantiator = deserializationConfig.getHandlerInstantiator();
            return (handlerInstantiator == null || (valueInstantiatorValueInstantiatorInstance = handlerInstantiator.valueInstantiatorInstance(deserializationConfig, annotated, cls)) == null) ? (ValueInstantiator) ClassUtil.createInstance(cls, deserializationConfig.canOverrideAccessModifiers()) : valueInstantiatorValueInstantiatorInstance;
        }
        od.f.e(b.m(new StringBuilder("AnnotationIntrospector returned Class "), cls, "; expected Class<ValueInstantiator>"));
        return null;
    }

    public SettableBeanProperty constructCreatorProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, PropertyName propertyName, int i, AnnotatedParameter annotatedParameter, JacksonInject.Value value) throws JsonMappingException {
        PropertyName propertyNameFindWrapperName;
        PropertyMetadata propertyMetadata;
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            propertyMetadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
            propertyNameFindWrapperName = null;
        } else {
            PropertyMetadata propertyMetadataConstruct = PropertyMetadata.construct(annotationIntrospector.hasRequiredMarker(annotatedParameter), annotationIntrospector.findPropertyDescription(annotatedParameter), annotationIntrospector.findPropertyIndex(annotatedParameter), annotationIntrospector.findPropertyDefaultValue(annotatedParameter));
            propertyNameFindWrapperName = annotationIntrospector.findWrapperName(annotatedParameter);
            propertyMetadata = propertyMetadataConstruct;
        }
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedParameter, annotatedParameter.getType());
        BeanProperty std = new BeanProperty.Std(propertyName, javaTypeResolveMemberAndTypeAnnotations, propertyNameFindWrapperName, annotatedParameter, propertyMetadata);
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, javaTypeResolveMemberAndTypeAnnotations);
        }
        CreatorProperty creatorPropertyConstruct = CreatorProperty.construct(propertyName, javaTypeResolveMemberAndTypeAnnotations, std.getWrapperName(), typeDeserializerFindTypeDeserializer, beanDescription.getClassAnnotations(), annotatedParameter, i, value, _getSetterInfo(config, std, propertyMetadata));
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return jsonDeserializerFindDeserializerFromAnnotation != null ? creatorPropertyConstruct.withValueDeserializer(deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, creatorPropertyConstruct, javaTypeResolveMemberAndTypeAnnotations)) : creatorPropertyConstruct;
    }

    public EnumResolver constructEnumNamingStrategyResolver(DeserializationConfig deserializationConfig, AnnotatedClass annotatedClass) {
        EnumNamingStrategy enumNamingStrategyCreateEnumNamingStrategyInstance = EnumNamingStrategyFactory.createEnumNamingStrategyInstance(deserializationConfig.getAnnotationIntrospector().findEnumNamingStrategy(deserializationConfig, annotatedClass), deserializationConfig.canOverrideAccessModifiers(), deserializationConfig.getEnumNamingStrategy());
        if (enumNamingStrategyCreateEnumNamingStrategyInstance == null) {
            return null;
        }
        return EnumResolver.constructUsingEnumNamingStrategy(deserializationConfig, annotatedClass, enumNamingStrategyCreateEnumNamingStrategyInstance);
    }

    public EnumResolver constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws SecurityException {
        AnnotatedMember annotatedMemberFindJsonValueAccessor = beanDescription.findJsonValueAccessor();
        if (annotatedMemberFindJsonValueAccessor == null) {
            return EnumResolver.constructFor(deserializationConfig, beanDescription.getClassInfo());
        }
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotatedMemberFindJsonValueAccessor.getMember(), deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return EnumResolver.constructUsingMethod(deserializationConfig, beanDescription.getClassInfo(), annotatedMemberFindJsonValueAccessor);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType contentType = arrayType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomArrayDeserializer == null) {
            if (jsonDeserializer == null) {
                if (contentType.isPrimitive()) {
                    jsonDeserializer_findCustomArrayDeserializer = PrimitiveArrayDeserializers.forType(contentType.getRawClass());
                } else if (contentType.hasRawClass(String.class)) {
                    jsonDeserializer_findCustomArrayDeserializer = StringArrayDeserializer.instance;
                }
            }
            if (jsonDeserializer_findCustomArrayDeserializer == null) {
                jsonDeserializer_findCustomArrayDeserializer = new ObjectArrayDeserializer(arrayType, jsonDeserializer, typeDeserializer);
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomArrayDeserializer = it.next().modifyArrayDeserializer(config, arrayType, beanDescription, jsonDeserializer_findCustomArrayDeserializer);
            }
        }
        return jsonDeserializer_findCustomArrayDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription) throws JsonMappingException {
        CollectionType collectionType_mapAbstractCollectionType;
        BeanDescription beanDescriptionIntrospectForCreation;
        JavaType contentType = collectionType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomCollectionDeserializer == null) {
            Class<?> rawClass = collectionType.getRawClass();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(rawClass)) {
                jsonDeserializer_findCustomCollectionDeserializer = new EnumSetDeserializer(contentType, null);
            }
        }
        if (jsonDeserializer_findCustomCollectionDeserializer == null) {
            if ((collectionType.isInterface() || collectionType.isAbstract()) && (collectionType_mapAbstractCollectionType = _mapAbstractCollectionType(collectionType, config)) != null) {
                beanDescriptionIntrospectForCreation = config.introspectForCreation(collectionType_mapAbstractCollectionType);
            } else {
                collectionType_mapAbstractCollectionType = collectionType;
                beanDescriptionIntrospectForCreation = beanDescription;
            }
            if (jsonDeserializer_findCustomCollectionDeserializer == null) {
                ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescriptionIntrospectForCreation);
                if (!valueInstantiatorFindValueInstantiator.canCreateUsingDefault()) {
                    if (collectionType_mapAbstractCollectionType.hasRawClass(ArrayBlockingQueue.class)) {
                        return new ArrayBlockingQueueDeserializer(collectionType_mapAbstractCollectionType, jsonDeserializer, typeDeserializer, valueInstantiatorFindValueInstantiator);
                    }
                    JsonDeserializer<?> jsonDeserializerFindForCollection = JavaUtilCollectionsDeserializers.findForCollection(deserializationContext, collectionType_mapAbstractCollectionType);
                    if (jsonDeserializerFindForCollection != null) {
                        return jsonDeserializerFindForCollection;
                    }
                }
                jsonDeserializer_findCustomCollectionDeserializer = contentType.hasRawClass(String.class) ? new StringCollectionDeserializer(collectionType_mapAbstractCollectionType, jsonDeserializer, valueInstantiatorFindValueInstantiator) : new CollectionDeserializer(collectionType_mapAbstractCollectionType, jsonDeserializer, typeDeserializer, valueInstantiatorFindValueInstantiator);
            }
        } else {
            collectionType_mapAbstractCollectionType = collectionType;
            beanDescriptionIntrospectForCreation = beanDescription;
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomCollectionDeserializer = it.next().modifyCollectionDeserializer(config, collectionType_mapAbstractCollectionType, beanDescriptionIntrospectForCreation, jsonDeserializer_findCustomCollectionDeserializer);
            }
        }
        return jsonDeserializer_findCustomCollectionDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionLikeType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> jsonDeserializer_findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, beanDescription, typeDeserializerFindTypeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomCollectionLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomCollectionLikeDeserializer = it.next().modifyCollectionLikeDeserializer(config, collectionLikeType, beanDescription, jsonDeserializer_findCustomCollectionLikeDeserializer);
            }
        }
        return jsonDeserializer_findCustomCollectionLikeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws InvalidDefinitionException, SecurityException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, beanDescription);
        if (jsonDeserializer_findCustomEnumDeserializer == null) {
            if (rawClass == Enum.class) {
                return AbstractDeserializer.constructForNonPOJO(beanDescription);
            }
            ValueInstantiator valueInstantiator_constructDefaultValueInstantiator = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
            SettableBeanProperty[] fromObjectArguments = valueInstantiator_constructDefaultValueInstantiator == null ? null : valueInstantiator_constructDefaultValueInstantiator.getFromObjectArguments(deserializationContext.getConfig());
            Iterator<AnnotatedMethod> it = beanDescription.getFactoryMethods().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnnotatedMethod next = it.next();
                if (_hasCreatorAnnotation(config, next)) {
                    if (next.getParameterCount() == 0) {
                        jsonDeserializer_findCustomEnumDeserializer = EnumDeserializer.deserializerForNoArgsCreator(config, rawClass, next);
                    } else {
                        if (!next.getRawReturnType().isAssignableFrom(rawClass)) {
                            deserializationContext.reportBadDefinition(javaType, "Invalid `@JsonCreator` annotated Enum factory method [" + next.toString() + "]: needs to return compatible type");
                        }
                        jsonDeserializer_findCustomEnumDeserializer = EnumDeserializer.deserializerForCreator(config, rawClass, next, valueInstantiator_constructDefaultValueInstantiator, fromObjectArguments, constructEnumResolver(rawClass, config, beanDescription));
                    }
                }
            }
            if (jsonDeserializer_findCustomEnumDeserializer == null) {
                jsonDeserializer_findCustomEnumDeserializer = new EnumDeserializer(constructEnumResolver(rawClass, config, beanDescription), config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS), constructEnumNamingStrategyResolver(config, beanDescription.getClassInfo()), EnumResolver.constructUsingToString(config, beanDescription.getClassInfo()));
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializer_findCustomEnumDeserializer = it2.next().modifyEnumDeserializer(config, javaType, beanDescription, jsonDeserializer_findCustomEnumDeserializer);
            }
        }
        return jsonDeserializer_findCustomEnumDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public KeyDeserializer createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) {
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDescription beanDescriptionIntrospectClassAnnotations = config.introspectClassAnnotations(javaType);
        KeyDeserializer keyDeserializerFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, beanDescriptionIntrospectClassAnnotations.getClassInfo());
        if (keyDeserializerFindKeyDeserializerFromAnnotation == null && this._factoryConfig.hasKeyDeserializers()) {
            Iterator<KeyDeserializers> it = this._factoryConfig.keyDeserializers().iterator();
            while (it.hasNext() && (keyDeserializerFindKeyDeserializerFromAnnotation = it.next().findKeyDeserializer(javaType, config, beanDescriptionIntrospectClassAnnotations)) == null) {
            }
        }
        if (keyDeserializerFindKeyDeserializerFromAnnotation == null) {
            keyDeserializerFindKeyDeserializerFromAnnotation = javaType.isEnumType() ? _createEnumKeyDeserializer(deserializationContext, javaType) : StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
        }
        if (keyDeserializerFindKeyDeserializerFromAnnotation != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                keyDeserializerFindKeyDeserializerFromAnnotation = it2.next().modifyKeyDeserializer(config, javaType, keyDeserializerFindKeyDeserializerFromAnnotation);
            }
        }
        return keyDeserializerFindKeyDeserializerFromAnnotation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createMapDeserializer(DeserializationContext deserializationContext, MapType mapType, BeanDescription beanDescription) throws JsonMappingException {
        MapType mapType2;
        BeanDescription beanDescriptionIntrospectForCreation;
        JsonDeserializer<?> jsonDeserializerModifyMapDeserializer;
        JsonDeserializer<?> enumMapDeserializer;
        MapType mapType3;
        MapDeserializer mapDeserializer;
        ValueInstantiator valueInstantiatorFindValueInstantiator;
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType keyType = mapType.getKeyType();
        JavaType contentType = mapType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomMapDeserializer = _findCustomMapDeserializer(mapType, config, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomMapDeserializer == null) {
            Class<?> rawClass = mapType.getRawClass();
            if (EnumMap.class.isAssignableFrom(rawClass)) {
                if (rawClass == EnumMap.class) {
                    beanDescriptionIntrospectForCreation = beanDescription;
                    valueInstantiatorFindValueInstantiator = null;
                } else {
                    beanDescriptionIntrospectForCreation = beanDescription;
                    valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescriptionIntrospectForCreation);
                }
                if (!keyType.isEnumImplType()) {
                    f.s("Cannot construct EnumMap; generic (key) type not available");
                    return null;
                }
                enumMapDeserializer = new EnumMapDeserializer(mapType, valueInstantiatorFindValueInstantiator, null, jsonDeserializer, typeDeserializer, null);
            } else {
                beanDescriptionIntrospectForCreation = beanDescription;
                enumMapDeserializer = jsonDeserializer_findCustomMapDeserializer;
            }
            if (enumMapDeserializer == null) {
                if (mapType.isInterface() || mapType.isAbstract()) {
                    MapType mapType4 = mapType;
                    MapType mapType_mapAbstractMapType = _mapAbstractMapType(mapType4, config);
                    if (mapType_mapAbstractMapType != null) {
                        mapType_mapAbstractMapType.getRawClass();
                        beanDescriptionIntrospectForCreation = config.introspectForCreation(mapType_mapAbstractMapType);
                        mapType4 = mapType_mapAbstractMapType;
                    }
                    mapType3 = mapType4;
                    mapDeserializer = enumMapDeserializer;
                } else {
                    JsonDeserializer<?> jsonDeserializerFindForMap = JavaUtilCollectionsDeserializers.findForMap(deserializationContext, mapType);
                    if (jsonDeserializerFindForMap != null) {
                        return jsonDeserializerFindForMap;
                    }
                    mapType3 = mapType;
                    mapDeserializer = jsonDeserializerFindForMap;
                }
                if (mapDeserializer == 0) {
                    mapDeserializer = new MapDeserializer(mapType3, findValueInstantiator(deserializationContext, beanDescriptionIntrospectForCreation), keyDeserializer, jsonDeserializer, typeDeserializer);
                    JsonIgnoreProperties.Value defaultPropertyIgnorals = config.getDefaultPropertyIgnorals(Map.class, beanDescriptionIntrospectForCreation.getClassInfo());
                    mapDeserializer.setIgnorableProperties(defaultPropertyIgnorals == null ? null : defaultPropertyIgnorals.findIgnoredForDeserialization());
                    JsonIncludeProperties.Value defaultPropertyInclusions = config.getDefaultPropertyInclusions(Map.class, beanDescriptionIntrospectForCreation.getClassInfo());
                    mapDeserializer.setIncludableProperties(defaultPropertyInclusions != null ? defaultPropertyInclusions.getIncluded() : null);
                }
                mapType2 = mapType3;
                jsonDeserializerModifyMapDeserializer = mapDeserializer;
            } else {
                mapType2 = mapType;
                jsonDeserializerModifyMapDeserializer = enumMapDeserializer;
            }
        } else {
            mapType2 = mapType;
            beanDescriptionIntrospectForCreation = beanDescription;
            jsonDeserializerModifyMapDeserializer = jsonDeserializer_findCustomMapDeserializer;
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            jsonDeserializerModifyMapDeserializer = jsonDeserializerModifyMapDeserializer;
            while (it.hasNext()) {
                jsonDeserializerModifyMapDeserializer = it.next().modifyMapDeserializer(config, mapType2, beanDescriptionIntrospectForCreation, jsonDeserializerModifyMapDeserializer);
            }
        }
        return jsonDeserializerModifyMapDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType keyType = mapLikeType.getKeyType();
        JavaType contentType = mapLikeType.getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> jsonDeserializer_findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, beanDescription, keyDeserializer, typeDeserializerFindTypeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomMapLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomMapLikeDeserializer = it.next().modifyMapLikeDeserializer(config, mapLikeType, beanDescription, jsonDeserializer_findCustomMapLikeDeserializer);
            }
        }
        return jsonDeserializer_findCustomMapLikeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext deserializationContext, ReferenceType referenceType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = referenceType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomReferenceDeserializer = _findCustomReferenceDeserializer(referenceType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomReferenceDeserializer == null && referenceType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return new AtomicReferenceDeserializer(referenceType, referenceType.getRawClass() == AtomicReference.class ? null : findValueInstantiator(deserializationContext, beanDescription), typeDeserializer, jsonDeserializer);
        }
        if (jsonDeserializer_findCustomReferenceDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomReferenceDeserializer = it.next().modifyReferenceDeserializer(config, referenceType, beanDescription, jsonDeserializer_findCustomReferenceDeserializer);
            }
        }
        return jsonDeserializer_findCustomReferenceDeserializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, beanDescription);
        return jsonDeserializer_findCustomTreeNodeDeserializer != null ? jsonDeserializer_findCustomTreeNodeDeserializer : JsonNodeDeserializer.getDeserializer(rawClass);
    }

    public JsonDeserializer<Object> findContentDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) {
        Object objFindContentDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindContentDeserializer = annotationIntrospector.findContentDeserializer(annotated)) == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(annotated, objFindContentDeserializer);
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        JavaType javaType_findRemappedType;
        JavaType javaType_findRemappedType2;
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == CLASS_OBJECT || rawClass == CLASS_SERIALIZABLE) {
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                javaType_findRemappedType = _findRemappedType(config, List.class);
                javaType_findRemappedType2 = _findRemappedType(config, Map.class);
            } else {
                javaType_findRemappedType = null;
                javaType_findRemappedType2 = null;
            }
            return new UntypedObjectDeserializer(javaType_findRemappedType, javaType_findRemappedType2);
        }
        if (rawClass == CLASS_STRING || rawClass == CLASS_CHAR_SEQUENCE) {
            return StringDeserializer.instance;
        }
        Class<?> cls = CLASS_ITERABLE;
        if (rawClass == cls) {
            TypeFactory typeFactory = deserializationContext.getTypeFactory();
            JavaType[] javaTypeArrFindTypeParameters = typeFactory.findTypeParameters(javaType, cls);
            return createCollectionDeserializer(deserializationContext, typeFactory.constructCollectionType(Collection.class, (javaTypeArrFindTypeParameters == null || javaTypeArrFindTypeParameters.length != 1) ? TypeFactory.unknownType() : javaTypeArrFindTypeParameters[0]), beanDescription);
        }
        if (rawClass == CLASS_MAP_ENTRY) {
            JavaType javaTypeContainedTypeOrUnknown = javaType.containedTypeOrUnknown(0);
            JavaType javaTypeContainedTypeOrUnknown2 = javaType.containedTypeOrUnknown(1);
            TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) javaTypeContainedTypeOrUnknown2.getTypeHandler();
            if (typeDeserializerFindTypeDeserializer == null) {
                typeDeserializerFindTypeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), javaTypeContainedTypeOrUnknown2);
            }
            return new MapEntryDeserializer(javaType, (KeyDeserializer) javaTypeContainedTypeOrUnknown.getValueHandler(), (JsonDeserializer<Object>) javaTypeContainedTypeOrUnknown2.getValueHandler(), typeDeserializerFindTypeDeserializer);
        }
        String name = rawClass.getName();
        if (rawClass.isPrimitive() || name.startsWith("java.")) {
            JsonDeserializer<?> jsonDeserializerFind = NumberDeserializers.find(rawClass, name);
            if (jsonDeserializerFind == null) {
                jsonDeserializerFind = DateDeserializers.find(rawClass, name);
            }
            if (jsonDeserializerFind != null) {
                return jsonDeserializerFind;
            }
        }
        if (rawClass == TokenBuffer.class) {
            return new TokenBufferDeserializer();
        }
        JsonDeserializer<?> jsonDeserializerFindOptionalStdDeserializer = findOptionalStdDeserializer(deserializationContext, javaType, beanDescription);
        return jsonDeserializerFindOptionalStdDeserializer != null ? jsonDeserializerFindOptionalStdDeserializer : JdkDeserializers.find(deserializationContext, rawClass, name);
    }

    public JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) {
        Object objFindDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindDeserializer = annotationIntrospector.findDeserializer(annotated)) == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(annotated, objFindDeserializer);
    }

    public KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) {
        Object objFindKeyDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindKeyDeserializer = annotationIntrospector.findKeyDeserializer(annotated)) == null) {
            return null;
        }
        return deserializationContext.keyDeserializerInstance(annotated, objFindKeyDeserializer);
    }

    public JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), beanDescription);
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) {
        TypeResolverBuilder<?> typeResolverBuilderFindPropertyContentTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        return typeResolverBuilderFindPropertyContentTypeResolver == null ? findTypeDeserializer(deserializationConfig, contentType) : typeResolverBuilderFindPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, contentType));
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeResolverBuilder<?> typeResolverBuilderFindPropertyTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (typeResolverBuilderFindPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType);
        }
        try {
            return typeResolverBuilderFindPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaType));
        } catch (IllegalArgumentException | IllegalStateException e10) {
            throw InvalidDefinitionException.from((JsonParser) null, ClassUtil.exceptionMessage(e10), javaType).withCause(e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeMapAbstractType;
        AnnotatedClass classInfo = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).getClassInfo();
        TypeResolverBuilder<?> typeResolverBuilderFindTypeResolver = deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, classInfo, javaType);
        if (typeResolverBuilderFindTypeResolver == null && (typeResolverBuilderFindTypeResolver = deserializationConfig.getDefaultTyper(javaType)) == null) {
            return null;
        }
        Collection<NamedType> collectionCollectAndResolveSubtypesByTypeId = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, classInfo);
        if (typeResolverBuilderFindTypeResolver.getDefaultImpl() == null && javaType.isAbstract() && (javaTypeMapAbstractType = mapAbstractType(deserializationConfig, javaType)) != null && !javaTypeMapAbstractType.hasRawClass(javaType.getRawClass())) {
            typeResolverBuilderFindTypeResolver = typeResolverBuilderFindTypeResolver.withDefaultImpl(javaTypeMapAbstractType.getRawClass());
        }
        try {
            return typeResolverBuilderFindTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collectionCollectAndResolveSubtypesByTypeId);
        } catch (IllegalArgumentException | IllegalStateException e10) {
            throw InvalidDefinitionException.from((JsonParser) null, ClassUtil.exceptionMessage(e10), javaType).withCause(e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotatedClass classInfo = beanDescription.getClassInfo();
        Object objFindValueInstantiator = config.getAnnotationIntrospector().findValueInstantiator(classInfo);
        ValueInstantiator valueInstantiator_valueInstantiatorInstance = objFindValueInstantiator != null ? _valueInstantiatorInstance(config, classInfo, objFindValueInstantiator) : null;
        if (valueInstantiator_valueInstantiatorInstance == null && (valueInstantiator_valueInstantiatorInstance = JDKValueInstantiators.findStdValueInstantiator(config, beanDescription.getBeanClass())) == null) {
            valueInstantiator_valueInstantiatorInstance = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators valueInstantiators : this._factoryConfig.valueInstantiators()) {
                valueInstantiator_valueInstantiatorInstance = valueInstantiators.findValueInstantiator(config, beanDescription, valueInstantiator_valueInstantiatorInstance);
                if (valueInstantiator_valueInstantiatorInstance == null) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", valueInstantiators.getClass().getName());
                }
            }
        }
        return valueInstantiator_valueInstantiatorInstance != null ? valueInstantiator_valueInstantiatorInstance.createContextual(deserializationContext, beanDescription) : valueInstantiator_valueInstantiatorInstance;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public boolean hasExplicitDeserializerFor(DeserializationConfig deserializationConfig, Class<?> cls) {
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return true;
        }
        String name = cls.getName();
        if (!name.startsWith("java.")) {
            return name.startsWith("com.fasterxml.") ? JsonNode.class.isAssignableFrom(cls) || cls == TokenBuffer.class : OptionalHandlerFactory.instance.hasDeserializerFor(cls);
        }
        if (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return true;
        }
        return Number.class.isAssignableFrom(cls) ? NumberDeserializers.find(cls, name) != null : JdkDeserializers.hasDeserializerFor(cls) || cls == CLASS_STRING || cls == Boolean.class || cls == EnumMap.class || cls == AtomicReference.class || DateDeserializers.hasDeserializerFor(cls);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) {
        JavaType javaType_mapAbstractType2;
        while (true) {
            javaType_mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (javaType_mapAbstractType2 == null) {
                return javaType;
            }
            Class<?> rawClass = javaType.getRawClass();
            Class<?> rawClass2 = javaType_mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
                break;
            }
            javaType = javaType_mapAbstractType2;
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + javaType_mapAbstractType2 + ": latter is not a subtype of former");
    }

    public JavaType resolveMemberAndTypeAnnotations(DeserializationContext deserializationContext, AnnotatedMember annotatedMember, JavaType javaType) {
        KeyDeserializer keyDeserializerKeyDeserializerInstance;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return javaType;
        }
        if (javaType.isMapLikeType() && javaType.getKeyType() != null && (keyDeserializerKeyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember))) != null) {
            javaType = ((MapLikeType) javaType).withKeyValueHandler(keyDeserializerKeyDeserializerInstance);
            javaType.getKeyType();
        }
        if (javaType.hasContentType()) {
            JsonDeserializer<Object> jsonDeserializerDeserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (jsonDeserializerDeserializerInstance != null) {
                javaType = javaType.withContentValueHandler(jsonDeserializerDeserializerInstance);
            }
            TypeDeserializer typeDeserializerFindPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
            if (typeDeserializerFindPropertyContentTypeDeserializer != null) {
                javaType = javaType.withContentTypeHandler(typeDeserializerFindPropertyContentTypeDeserializer);
            }
        }
        TypeDeserializer typeDeserializerFindPropertyTypeDeserializer = findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
        if (typeDeserializerFindPropertyTypeDeserializer != null) {
            javaType = javaType.withTypeHandler(typeDeserializerFindPropertyTypeDeserializer);
        }
        return annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotatedMember, javaType);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(abstractTypeResolver));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalDeserializers(Deserializers deserializers) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(deserializers));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(keyDeserializers));
    }

    public abstract DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
        return withConfig(this._factoryConfig.withDeserializerModifier(beanDeserializerModifier));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withValueInstantiators(ValueInstantiators valueInstantiators) {
        return withConfig(this._factoryConfig.withValueInstantiators(valueInstantiators));
    }

    @Deprecated
    public EnumResolver constructEnumNamingStrategyResolver(DeserializationConfig deserializationConfig, Class<?> cls, AnnotatedClass annotatedClass) {
        EnumNamingStrategy enumNamingStrategyCreateEnumNamingStrategyInstance = EnumNamingStrategyFactory.createEnumNamingStrategyInstance(deserializationConfig.getAnnotationIntrospector().findEnumNamingStrategy(deserializationConfig, annotatedClass), deserializationConfig.canOverrideAccessModifiers(), deserializationConfig.getEnumNamingStrategy());
        if (enumNamingStrategyCreateEnumNamingStrategyInstance == null) {
            return null;
        }
        return EnumResolver.constructUsingEnumNamingStrategy(deserializationConfig, cls, enumNamingStrategyCreateEnumNamingStrategyInstance);
    }
}
