package com.fasterxml.jackson.databind.jdk14;

import androidx.activity.b;
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
import g5.f;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JDK14Util {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class CreatorLocator {
        protected final MapperConfig<?> _config;
        protected final List<AnnotatedConstructor> _constructors;
        protected final AnnotationIntrospector _intr;
        protected final AnnotatedConstructor _primaryConstructor;
        protected final AnnotatedClass _recordClass;
        protected final RawTypeName[] _recordFields;

        public CreatorLocator(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
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
                        for (int i = 0; i < length; i++) {
                            if (!next.getRawParameterType(i).equals(this._recordFields[i].rawType)) {
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
            if (defaultConstructor == null) {
                f.f(ClassUtil.getTypeDescription(this._recordClass.getType()), "Failed to find the canonical Record constructor of type ");
                throw null;
            }
            this._primaryConstructor = defaultConstructor;
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class RawTypeName {
        public final String name;
        public final Class<?> rawType;

        public RawTypeName(Class<?> cls, String str) {
            this.rawType = cls;
            this.name = str;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        private RecordAccessor() throws ClassNotFoundException {
            try {
                this.RECORD_GET_RECORD_COMPONENTS = Class.class.getMethod("getRecordComponents", null);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.RECORD_COMPONENT_GET_NAME = cls.getMethod("getName", null);
                this.RECORD_COMPONENT_GET_TYPE = cls.getMethod("getType", null);
            } catch (Exception e10) {
                od.f.g(b.j("Failed to access Methods needed to support `java.lang.Record`: (", e10.getClass().getName(), ") ", e10.getMessage()), e10);
                throw null;
            }
        }

        public static RecordAccessor instance() {
            RuntimeException runtimeException = PROBLEM;
            if (runtimeException == null) {
                return INSTANCE;
            }
            throw runtimeException;
        }

        public String[] getRecordFieldNames(Class<?> cls) {
            Object[] objArrRecordComponents = recordComponents(cls);
            if (objArrRecordComponents == null) {
                return null;
            }
            String[] strArr = new String[objArrRecordComponents.length];
            for (int i = 0; i < objArrRecordComponents.length; i++) {
                try {
                    strArr[i] = (String) this.RECORD_COMPONENT_GET_NAME.invoke(objArrRecordComponents[i], null);
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e10);
                }
            }
            return strArr;
        }

        public RawTypeName[] getRecordFields(Class<?> cls) {
            Object[] objArrRecordComponents = recordComponents(cls);
            if (objArrRecordComponents == null) {
                return null;
            }
            RawTypeName[] rawTypeNameArr = new RawTypeName[objArrRecordComponents.length];
            for (int i = 0; i < objArrRecordComponents.length; i++) {
                try {
                    try {
                        rawTypeNameArr[i] = new RawTypeName((Class) this.RECORD_COMPONENT_GET_TYPE.invoke(objArrRecordComponents[i], null), (String) this.RECORD_COMPONENT_GET_NAME.invoke(objArrRecordComponents[i], null));
                    } catch (Exception e10) {
                        throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e10);
                    }
                } catch (Exception e11) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e11);
                }
            }
            return rawTypeNameArr;
        }

        public Object[] recordComponents(Class<?> cls) {
            try {
                return (Object[]) this.RECORD_GET_RECORD_COMPONENTS.invoke(cls, null);
            } catch (Exception e10) {
                if (NativeImageUtil.isUnsupportedFeatureError(e10)) {
                    return null;
                }
                f.f(ClassUtil.nameOf(cls), "Failed to access RecordComponents of type ");
                return null;
            }
        }
    }

    public static PotentialCreator findCanonicalRecordConstructor(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<PotentialCreator> list) {
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
                for (int i = 0; i < length; i++) {
                    if (!potentialCreator.creator().getRawParameterType(i).equals(recordFields[i].rawType)) {
                        break;
                    }
                }
                PropertyName[] propertyNameArr = new PropertyName[length];
                for (int i3 = 0; i3 < length; i3++) {
                    propertyNameArr[i3] = PropertyName.construct(recordFields[i3].name);
                }
                return potentialCreator.introspectParamNames(mapperConfig, propertyNameArr);
            }
        }
        f.f(ClassUtil.getTypeDescription(annotatedClass.getType()), "Failed to find the canonical Record constructor of type ");
        return null;
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
