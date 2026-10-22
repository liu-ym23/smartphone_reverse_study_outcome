package com.networknt.schema;

import com.networknt.schema.ExecutionConfig;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class ExecutionConfig {
    private final boolean annotationCollectionEnabled;
    private final Predicate<String> annotationCollectionFilter;
    private final boolean failFast;
    private final Boolean formatAssertionsEnabled;
    private final Locale locale;
    private final Boolean readOnly;
    private final Boolean writeOnly;

    public static class Builder extends BuilderSupport<Builder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.ExecutionConfig.BuilderSupport
        public Builder self() {
            return this;
        }
    }

    public static abstract class BuilderSupport<T> {
        protected Locale locale = Locale.ROOT;
        protected boolean annotationCollectionEnabled = false;
        protected Predicate<String> annotationCollectionFilter = new Predicate() { // from class: com.networknt.schema.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ExecutionConfig.BuilderSupport.a((String) obj);
            }
        };
        protected Boolean formatAssertionsEnabled = null;
        protected boolean failFast = false;
        protected Boolean readOnly = null;
        protected Boolean writeOnly = null;

        public static /* synthetic */ boolean a(String str) {
            return false;
        }

        public T annotationCollectionEnabled(boolean z10) {
            this.annotationCollectionEnabled = z10;
            return self();
        }

        public T annotationCollectionFilter(Predicate<String> predicate) {
            this.annotationCollectionFilter = predicate;
            return self();
        }

        public ExecutionConfig build() {
            Locale locale = this.locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            Locale locale2 = locale;
            Objects.requireNonNull(this.annotationCollectionFilter, "annotationCollectionFilter must not be null");
            return new ExecutionConfig(locale2, this.annotationCollectionEnabled, this.annotationCollectionFilter, this.formatAssertionsEnabled, this.failFast, this.readOnly, this.writeOnly);
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

        public T readOnly(Boolean bool) {
            this.readOnly = bool;
            return self();
        }

        public abstract T self();

        public T writeOnly(Boolean bool) {
            this.writeOnly = bool;
            return self();
        }
    }

    public static class Holder {
        private static final ExecutionConfig INSTANCE = ExecutionConfig.builder().build();

        private Holder() {
        }
    }

    public ExecutionConfig(Locale locale, boolean z10, Predicate<String> predicate, Boolean bool, boolean z11, Boolean bool2, Boolean bool3) {
        this.locale = locale;
        this.annotationCollectionEnabled = z10;
        this.annotationCollectionFilter = predicate;
        this.formatAssertionsEnabled = bool;
        this.failFast = z11;
        this.readOnly = bool2;
        this.writeOnly = bool3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ExecutionConfig getInstance() {
        return Holder.INSTANCE;
    }

    public Predicate<String> getAnnotationCollectionFilter() {
        return this.annotationCollectionFilter;
    }

    public Boolean getFormatAssertionsEnabled() {
        return this.formatAssertionsEnabled;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Boolean getReadOnly() {
        return this.readOnly;
    }

    public Boolean getWriteOnly() {
        return this.writeOnly;
    }

    public boolean isAnnotationCollectionEnabled() {
        return this.annotationCollectionEnabled;
    }

    public boolean isFailFast() {
        return this.failFast;
    }

    public static Builder builder(ExecutionConfig executionConfig) {
        Builder builder = new Builder();
        builder.locale = executionConfig.locale;
        builder.annotationCollectionEnabled = executionConfig.annotationCollectionEnabled;
        builder.annotationCollectionFilter = executionConfig.annotationCollectionFilter;
        builder.formatAssertionsEnabled = executionConfig.formatAssertionsEnabled;
        builder.failFast = executionConfig.failFast;
        builder.readOnly = executionConfig.readOnly;
        builder.writeOnly = executionConfig.writeOnly;
        return builder;
    }
}
