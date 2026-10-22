package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.jdk14.JDK14Util;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultAccessorNamingStrategy extends AccessorNamingStrategy {
    protected final BaseNameValidator _baseNameValidator;
    protected final MapperConfig<?> _config;
    protected final AnnotatedClass _forClass;
    protected final String _getterPrefix;
    protected final String _isGetterPrefix;
    protected final boolean _isGettersNonBoolean;
    protected final String _mutatorPrefix;
    protected final boolean _stdBeanNaming;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface BaseNameValidator {
        boolean accept(char c9, String str, int i);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class FirstCharBasedValidator implements BaseNameValidator {
        private final boolean _allowLowerCaseFirstChar;
        private final boolean _allowNonLetterFirstChar;

        public FirstCharBasedValidator(boolean z10, boolean z11) {
            this._allowLowerCaseFirstChar = z10;
            this._allowNonLetterFirstChar = z11;
        }

        public static BaseNameValidator forFirstNameRule(boolean z10, boolean z11) {
            if (z10 && z11) {
                return null;
            }
            return new FirstCharBasedValidator(z10, z11);
        }

        @Override // com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.BaseNameValidator
        public boolean accept(char c9, String str, int i) {
            return Character.isLetter(c9) ? this._allowLowerCaseFirstChar || !Character.isLowerCase(c9) : this._allowNonLetterFirstChar;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class RecordNaming extends DefaultAccessorNamingStrategy {
        protected final Set<String> _fieldNames;

        public RecordNaming(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            super(mapperConfig, annotatedClass, null, "get", "is", null);
            String[] recordFieldNames = JDK14Util.getRecordFieldNames(annotatedClass.getRawType());
            this._fieldNames = recordFieldNames == null ? Collections.EMPTY_SET : new HashSet(Arrays.asList(recordFieldNames));
        }

        @Override // com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy, com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
            return this._fieldNames.contains(str) ? str : super.findNameForRegularGetter(annotatedMethod, str);
        }
    }

    public DefaultAccessorNamingStrategy(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, String str, String str2, String str3, BaseNameValidator baseNameValidator) {
        this._config = mapperConfig;
        this._forClass = annotatedClass;
        this._stdBeanNaming = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this._isGettersNonBoolean = mapperConfig.isEnabled(MapperFeature.ALLOW_IS_GETTERS_FOR_NON_BOOLEAN);
        this._mutatorPrefix = str;
        this._getterPrefix = str2;
        this._isGetterPrefix = str3;
        this._baseNameValidator = baseNameValidator;
    }

    private boolean _booleanType(JavaType javaType) {
        if (javaType.isReferenceType()) {
            javaType = javaType.getReferencedType();
        }
        return javaType.hasRawClass(Boolean.TYPE) || javaType.hasRawClass(Boolean.class) || javaType.hasRawClass(AtomicBoolean.class);
    }

    public boolean _isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Class<?> rawType = annotatedMethod.getRawType();
        if (rawType.isArray()) {
            String name = rawType.getComponentType().getName();
            if (name.contains(".cglib")) {
                return name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib");
            }
        }
        return false;
    }

    public boolean _isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.getRawType().getName().startsWith("groovy.lang");
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
        if (this._isGetterPrefix == null) {
            return null;
        }
        if ((!this._isGettersNonBoolean && !_booleanType(annotatedMethod.getType())) || !str.startsWith(this._isGetterPrefix)) {
            return null;
        }
        boolean z10 = this._stdBeanNaming;
        String str2 = this._isGetterPrefix;
        return z10 ? stdManglePropertyName(str, str2.length()) : legacyManglePropertyName(str, str2.length());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForMutator(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this._mutatorPrefix;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        boolean z10 = this._stdBeanNaming;
        String str3 = this._mutatorPrefix;
        return z10 ? stdManglePropertyName(str, str3.length()) : legacyManglePropertyName(str, str3.length());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this._getterPrefix;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (_isCglibGetCallbacks(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && _isGroovyMetaClassGetter(annotatedMethod)) {
            return null;
        }
        boolean z10 = this._stdBeanNaming;
        String str3 = this._getterPrefix;
        return z10 ? stdManglePropertyName(str, str3.length()) : legacyManglePropertyName(str, str3.length());
    }

    public String legacyManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        BaseNameValidator baseNameValidator = this._baseNameValidator;
        if (baseNameValidator != null && !baseNameValidator.accept(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb2 = new StringBuilder(length - i);
        sb2.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb2.append((CharSequence) str, i, length);
                break;
            }
            sb2.append(lowerCase2);
        }
        return sb2.toString();
    }

    public String stdManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        BaseNameValidator baseNameValidator = this._baseNameValidator;
        if (baseNameValidator != null && !baseNameValidator.accept(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        int i3 = i + 1;
        if (i3 < length && Character.isUpperCase(str.charAt(i3))) {
            return str.substring(i);
        }
        StringBuilder sb2 = new StringBuilder(length - i);
        sb2.append(lowerCase);
        sb2.append((CharSequence) str, i3, length);
        return sb2.toString();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Provider extends AccessorNamingStrategy.Provider implements Serializable {
        private static final long serialVersionUID = 1;
        protected final BaseNameValidator _baseNameValidator;
        protected final String _getterPrefix;
        protected final String _isGetterPrefix;
        protected final String _setterPrefix;
        protected final String _withPrefix;

        public Provider() {
            this("set", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "get", "is", (BaseNameValidator) null);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forBuilder(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanDescription beanDescription) {
            AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
            JsonPOJOBuilder.Value valueFindPOJOBuilderConfig = annotationIntrospector != null ? annotationIntrospector.findPOJOBuilderConfig(annotatedClass) : null;
            return new DefaultAccessorNamingStrategy(mapperConfig, annotatedClass, valueFindPOJOBuilderConfig == null ? this._withPrefix : valueFindPOJOBuilderConfig.withPrefix, this._getterPrefix, this._isGetterPrefix, this._baseNameValidator);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forPOJO(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            return new DefaultAccessorNamingStrategy(mapperConfig, annotatedClass, this._setterPrefix, this._getterPrefix, this._isGetterPrefix, this._baseNameValidator);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forRecord(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            return new RecordNaming(mapperConfig, annotatedClass);
        }

        public Provider withBaseNameValidator(BaseNameValidator baseNameValidator) {
            return new Provider(this, baseNameValidator);
        }

        public Provider withBuilderPrefix(String str) {
            return new Provider(this, this._setterPrefix, str, this._getterPrefix, this._isGetterPrefix);
        }

        public Provider withFirstCharAcceptance(boolean z10, boolean z11) {
            return withBaseNameValidator(FirstCharBasedValidator.forFirstNameRule(z10, z11));
        }

        public Provider withGetterPrefix(String str) {
            return new Provider(this, this._setterPrefix, this._withPrefix, str, this._isGetterPrefix);
        }

        public Provider withIsGetterPrefix(String str) {
            return new Provider(this, this._setterPrefix, this._withPrefix, this._getterPrefix, str);
        }

        public Provider withSetterPrefix(String str) {
            return new Provider(this, str, this._withPrefix, this._getterPrefix, this._isGetterPrefix);
        }

        public Provider(Provider provider, String str, String str2, String str3, String str4) {
            this(str, str2, str3, str4, provider._baseNameValidator);
        }

        public Provider(Provider provider, BaseNameValidator baseNameValidator) {
            this(provider._setterPrefix, provider._withPrefix, provider._getterPrefix, provider._isGetterPrefix, baseNameValidator);
        }

        public Provider(String str, String str2, String str3, String str4, BaseNameValidator baseNameValidator) {
            this._setterPrefix = str;
            this._withPrefix = str2;
            this._getterPrefix = str3;
            this._isGetterPrefix = str4;
            this._baseNameValidator = baseNameValidator;
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String modifyFieldName(AnnotatedField annotatedField, String str) {
        return str;
    }
}
