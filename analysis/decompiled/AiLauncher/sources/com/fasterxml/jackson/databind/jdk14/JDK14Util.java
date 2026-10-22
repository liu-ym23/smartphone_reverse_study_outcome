package com.fasterxml.jackson.databind.jdk14;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.PotentialCreator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NativeImageUtil;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class JDK14Util {

    @Deprecated
    public static class CreatorLocator {
        protected final MapperConfig<?> _config;
        protected final List<AnnotatedConstructor> _constructors;
        protected final AnnotationIntrospector _intr;
        protected final AnnotatedConstructor _primaryConstructor;
        protected final AnnotatedClass _recordClass;
        protected final RawTypeName[] _recordFields;

        public CreatorLocator(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) throws IllegalArgumentException {
            this._recordClass = annotatedClass;
            this._intr = mapperConfig.getAnnotationIntrospector();
            this._config = mapperConfig;
            RawTypeName[] recordFields = RecordAccessor.instance().getRecordFields(annotatedClass.getRawType());
            this._recordFields = recordFields;
            AnnotatedConstructor defaultConstructor = null;
            if (recordFields == null) {
                this._constructors = annotatedClass.getConstructors();
                this._primaryConstructor = null;
                return;
            }
            int length = recordFields.length;
            if (length != 0) {
                List<AnnotatedConstructor> constructors = annotatedClass.getConstructors();
                this._constructors = constructors;
                Iterator<AnnotatedConstructor> it = constructors.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AnnotatedConstructor next = it.next();
                    if (next.getParameterCount() == length) {
                        for (int i10 = 0; i10 < length; i10++) {
                            if (!next.getRawParameterType(i10).equals(this._recordFields[i10].rawType)) {
                                break;
                            }
                        }
                        defaultConstructor = next;
                        break loop0;
                    }
                }
            } else {
                defaultConstructor = annotatedClass.getDefaultConstructor();
                this._constructors = Collections.singletonList(defaultConstructor);
            }
            if (defaultConstructor != null) {
                this._primaryConstructor = defaultConstructor;
                return;
            }
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + ClassUtil.getTypeDescription(this._recordClass.getType()));
        }

        public AnnotatedConstructor locate(List<String> list) {
            for (AnnotatedConstructor annotatedConstructor : this._constructors) {
                JsonCreator.Mode modeFindCreatorAnnotation = this._intr.findCreatorAnnotation(this._config, annotatedConstructor);
                if (modeFindCreatorAnnotation != null && JsonCreator.Mode.DISABLED != modeFindCreatorAnnotation && (JsonCreator.Mode.DELEGATING == modeFindCreatorAnnotation || annotatedConstructor != this._primaryConstructor)) {
                    return null;
                }
            }
            RawTypeName[] rawTypeNameArr = this._recordFields;
            if (rawTypeNameArr == null) {
                return null;
            }
            for (RawTypeName rawTypeName : rawTypeNameArr) {
                list.add(rawTypeName.name);
            }
            return this._primaryConstructor;
        }
    }

    public static class RawTypeName {
        public final String name;
        public final Class<?> rawType;

        public RawTypeName(Class<?> cls, String str) {
            this.rawType = cls;
            this.name = str;
        }
    }

    public static class RecordAccessor {
        private static final RecordAccessor INSTANCE;
        private static final RuntimeException PROBLEM;
        private final Method RECORD_COMPONENT_GET_NAME;
        private final Method RECORD_COMPONENT_GET_TYPE;
        private final Method RECORD_GET_RECORD_COMPONENTS;

        static {
            RecordAccessor recordAccessor = null;
            try {
                e = null;
                recordAccessor = new RecordAccessor();
            } catch (RuntimeException e10) {
                e = e10;
            }
            INSTANCE = recordAccessor;
            PROBLEM = e;
        }

        private RecordAccessor() throws ClassNotFoundException, RuntimeException {
            try {
                this.RECORD_GET_RECORD_COMPONENTS = Class.class.getMethod("getRecordComponents", null);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.RECORD_COMPONENT_GET_NAME = cls.getMethod("getName", null);
                this.RECORD_COMPONENT_GET_TYPE = cls.getMethod("getType", null);
            } catch (Exception e10) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e10.getClass().getName(), e10.getMessage()), e10);
            }
        }

        public static RecordAccessor instance() {
            RuntimeException runtimeException = PROBLEM;
            if (runtimeException == null) {
                return INSTANCE;
            }
            throw runtimeException;
        }

        public String[] getRecordFieldNames(Class<?> cls) throws IllegalArgumentException {
            Object[] objArrRecordComponents = recordComponents(cls);
            if (objArrRecordComponents == null) {
                return null;
            }
            String[] strArr = new String[objArrRecordComponents.length];
            for (int i10 = 0; i10 < objArrRecordComponents.length; i10++) {
                try {
                    strArr[i10] = (String) this.RECORD_COMPONENT_GET_NAME.invoke(objArrRecordComponents[i10], null);
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e10);
                }
            }
            return strArr;
        }

        public RawTypeName[] getRecordFields(Class<?> cls) throws IllegalArgumentException {
            Object[] objArrRecordComponents = recordComponents(cls);
            if (objArrRecordComponents == null) {
                return null;
            }
            RawTypeName[] rawTypeNameArr = new RawTypeName[objArrRecordComponents.length];
            for (int i10 = 0; i10 < objArrRecordComponents.length; i10++) {
                try {
                    try {
                        rawTypeNameArr[i10] = new RawTypeName((Class) this.RECORD_COMPONENT_GET_TYPE.invoke(objArrRecordComponents[i10], null), (String) this.RECORD_COMPONENT_GET_NAME.invoke(objArrRecordComponents[i10], null));
                    } catch (Exception e10) {
                        throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e10);
                    }
                } catch (Exception e11) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e11);
                }
            }
            return rawTypeNameArr;
        }

        public Object[] recordComponents(Class<?> cls) throws IllegalArgumentException {
            try {
                return (Object[]) this.RECORD_GET_RECORD_COMPONENTS.invoke(cls, null);
            } catch (Exception e10) {
                if (NativeImageUtil.isUnsupportedFeatureError(e10)) {
                    return null;
                }
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + ClassUtil.nameOf(cls));
            }
        }
    }

    public static PotentialCreator findCanonicalRecordConstructor(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<PotentialCreator> list) throws IllegalArgumentException {
        AnnotatedConstructor defaultConstructor;
        RawTypeName[] recordFields = RecordAccessor.instance().getRecordFields(annotatedClass.getRawType());
        if (recordFields == null) {
            return null;
        }
        int length = recordFields.length;
        if (length == 0 && (defaultConstructor = annotatedClass.getDefaultConstructor()) != null) {
            return new PotentialCreator(defaultConstructor, null);
        }
        for (PotentialCreator potentialCreator : list) {
            if (potentialCreator.paramCount() == length) {
                for (int i10 = 0; i10 < length; i10++) {
                    if (!potentialCreator.creator().getRawParameterType(i10).equals(recordFields[i10].rawType)) {
                        break;
                    }
                }
                PropertyName[] propertyNameArr = new PropertyName[length];
                for (int i11 = 0; i11 < length; i11++) {
                    propertyNameArr[i11] = PropertyName.construct(recordFields[i11].name);
                }
                return potentialCreator.introspectParamNames(mapperConfig, propertyNameArr);
            }
        }
        throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + ClassUtil.getTypeDescription(annotatedClass.getType()));
    }

    @Deprecated
    public static AnnotatedConstructor findRecordConstructor(DeserializationContext deserializationContext, BeanDescription beanDescription, List<String> list) {
        return findRecordConstructor(beanDescription.getClassInfo(), deserializationContext.getAnnotationIntrospector(), deserializationContext.getConfig(), list);
    }

    public static String[] getRecordFieldNames(Class<?> cls) {
        return RecordAccessor.instance().getRecordFieldNames(cls);
    }

    @Deprecated
    public static AnnotatedConstructor findRecordConstructor(AnnotatedClass annotatedClass, AnnotationIntrospector annotationIntrospector, MapperConfig<?> mapperConfig, List<String> list) {
        return new CreatorLocator(mapperConfig, annotatedClass).locate(list);
    }
}
