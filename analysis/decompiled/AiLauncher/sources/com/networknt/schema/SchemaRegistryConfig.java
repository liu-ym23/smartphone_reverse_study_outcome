package com.networknt.schema;

import com.networknt.schema.i18n.DefaultMessageSource;
import com.networknt.schema.i18n.MessageSource;
import com.networknt.schema.path.PathType;
import com.networknt.schema.regex.JDKRegularExpressionFactory;
import com.networknt.schema.regex.RegularExpressionFactory;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SchemaRegistryConfig {
    private final boolean cacheRefs;
    private final String errorMessageKeyword;
    private final ExecutionContextCustomizer executionContextCustomizer;
    private final boolean failFast;
    private final Boolean formatAssertionsEnabled;
    private final Locale locale;
    private final boolean losslessNarrowing;
    private final MessageSource messageSource;
    private final PathType pathType;
    private final boolean preloadSchema;
    private final RegularExpressionFactory regularExpressionFactory;
    private final SchemaIdValidator schemaIdValidator;
    private final Map<String, Boolean> strictness;
    private boolean typeLoose;

    public static class Builder extends BuilderSupport<Builder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.SchemaRegistryConfig.BuilderSupport
        public Builder self() {
            return this;
        }
    }

    public static class Holder {
        private static final SchemaRegistryConfig INSTANCE = SchemaRegistryConfig.builder().build();

        private Holder() {
        }
    }

    public SchemaRegistryConfig(boolean z10, String str, ExecutionContextCustomizer executionContextCustomizer, boolean z11, Boolean bool, Locale locale, boolean z12, MessageSource messageSource, PathType pathType, boolean z13, RegularExpressionFactory regularExpressionFactory, SchemaIdValidator schemaIdValidator, Map<String, Boolean> map, boolean z14) {
        this.cacheRefs = z10;
        this.errorMessageKeyword = str;
        this.executionContextCustomizer = executionContextCustomizer;
        this.failFast = z11;
        this.formatAssertionsEnabled = bool;
        this.locale = locale;
        this.losslessNarrowing = z12;
        this.messageSource = messageSource;
        this.pathType = pathType;
        this.preloadSchema = z13;
        this.regularExpressionFactory = regularExpressionFactory;
        this.schemaIdValidator = schemaIdValidator;
        this.strictness = map;
        this.typeLoose = z14;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SchemaRegistryConfig getInstance() {
        return Holder.INSTANCE;
    }

    public String getErrorMessageKeyword() {
        return this.errorMessageKeyword;
    }

    public ExecutionContextCustomizer getExecutionContextCustomizer() {
        return this.executionContextCustomizer;
    }

    public Boolean getFormatAssertionsEnabled() {
        return this.formatAssertionsEnabled;
    }

    public Locale getLocale() {
        Locale locale = this.locale;
        return locale == null ? Locale.getDefault() : locale;
    }

    public MessageSource getMessageSource() {
        MessageSource messageSource = this.messageSource;
        return messageSource == null ? DefaultMessageSource.getInstance() : messageSource;
    }

    public PathType getPathType() {
        return this.pathType;
    }

    public RegularExpressionFactory getRegularExpressionFactory() {
        return this.regularExpressionFactory;
    }

    public SchemaIdValidator getSchemaIdValidator() {
        return this.schemaIdValidator;
    }

    public boolean isCacheRefs() {
        return this.cacheRefs;
    }

    public boolean isFailFast() {
        return this.failFast;
    }

    public boolean isLosslessNarrowing() {
        return this.losslessNarrowing;
    }

    public boolean isPreloadSchema() {
        return this.preloadSchema;
    }

    public boolean isStrict(String str) {
        return isStrict(str, Boolean.TRUE);
    }

    public boolean isTypeLoose() {
        return this.typeLoose;
    }

    public static abstract class BuilderSupport<T> {
        protected boolean cacheRefs = true;
        protected String errorMessageKeyword = null;
        protected ExecutionContextCustomizer executionContextCustomizer = null;
        protected boolean failFast = false;
        protected Boolean formatAssertionsEnabled = null;
        protected Locale locale = null;
        protected boolean losslessNarrowing = false;
        protected MessageSource messageSource = null;
        protected PathType pathType = PathType.JSON_POINTER;
        protected boolean preloadSchema = true;
        protected RegularExpressionFactory regularExpressionFactory = JDKRegularExpressionFactory.getInstance();
        protected SchemaIdValidator schemaIdValidator = SchemaIdValidator.DEFAULT;
        protected Map<String, Boolean> strictness = new HashMap(0);
        protected boolean typeLoose = false;

        public SchemaRegistryConfig build() {
            return new SchemaRegistryConfig(this.cacheRefs, this.errorMessageKeyword, this.executionContextCustomizer, this.failFast, this.formatAssertionsEnabled, this.locale, this.losslessNarrowing, this.messageSource, this.pathType, this.preloadSchema, this.regularExpressionFactory, this.schemaIdValidator, this.strictness, this.typeLoose);
        }

        public T cacheRefs(boolean z10) {
            this.cacheRefs = z10;
            return self();
        }

        public T errorMessageKeyword(String str) {
            this.errorMessageKeyword = str;
            return self();
        }

        public T executionContextCustomizer(ExecutionContextCustomizer executionContextCustomizer) {
            this.executionContextCustomizer = executionContextCustomizer;
            return self();
        }

        public T failFast(boolean z10) {
            this.failFast = z10;
            return self();
        }

        public T formatAssertionsEnabled(Boolean bool) {
            this.formatAssertionsEnabled = bool;
            return self();
        }

        public T locale(Locale locale) {
            this.locale = locale;
            return self();
        }

        public T losslessNarrowing(boolean z10) {
            this.losslessNarrowing = z10;
            return self();
        }

        public T messageSource(MessageSource messageSource) {
            this.messageSource = messageSource;
            return self();
        }

        public T pathType(PathType pathType) {
            this.pathType = pathType;
            return self();
        }

        public T preloadSchema(boolean z10) {
            this.preloadSchema = z10;
            return self();
        }

        public T regularExpressionFactory(RegularExpressionFactory regularExpressionFactory) {
            this.regularExpressionFactory = regularExpressionFactory;
            return self();
        }

        public T schemaIdValidator(SchemaIdValidator schemaIdValidator) {
            this.schemaIdValidator = schemaIdValidator;
            return self();
        }

        public abstract T self();

        public T strict(Map<String, Boolean> map) {
            this.strictness = map;
            return self();
        }

        public T typeLoose(boolean z10) {
            this.typeLoose = z10;
            return self();
        }

        public T strict(String str, boolean z10) {
            Map<String, Boolean> map = this.strictness;
            Objects.requireNonNull(str, "keyword cannot be null");
            map.put(str, Boolean.valueOf(z10));
            return self();
        }
    }

    public static Builder builder(SchemaRegistryConfig schemaRegistryConfig) {
        Builder builder = new Builder();
        builder.cacheRefs = schemaRegistryConfig.cacheRefs;
        builder.errorMessageKeyword = schemaRegistryConfig.errorMessageKeyword;
        builder.executionContextCustomizer = schemaRegistryConfig.executionContextCustomizer;
        builder.failFast = schemaRegistryConfig.failFast;
        builder.formatAssertionsEnabled = schemaRegistryConfig.formatAssertionsEnabled;
        builder.locale = schemaRegistryConfig.locale;
        builder.losslessNarrowing = schemaRegistryConfig.losslessNarrowing;
        builder.messageSource = schemaRegistryConfig.messageSource;
        builder.pathType = schemaRegistryConfig.pathType;
        builder.preloadSchema = schemaRegistryConfig.preloadSchema;
        builder.regularExpressionFactory = schemaRegistryConfig.regularExpressionFactory;
        builder.schemaIdValidator = schemaRegistryConfig.schemaIdValidator;
        builder.strictness = schemaRegistryConfig.strictness;
        builder.typeLoose = schemaRegistryConfig.typeLoose;
        return builder;
    }

    public boolean isStrict(String str, Boolean bool) {
        Map<String, Boolean> map = this.strictness;
        Objects.requireNonNull(str, "keyword cannot be null");
        return map.getOrDefault(str, bool).booleanValue();
    }
}
