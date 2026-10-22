package com.networknt.schema.walk;

/* loaded from: classes2.dex */
public class ApplyDefaultsStrategy {
    public static final ApplyDefaultsStrategy EMPTY_APPLY_DEFAULTS_STRATEGY = new ApplyDefaultsStrategy(false, false, false);
    private final boolean applyArrayDefaults;
    private final boolean applyPropertyDefaults;
    private final boolean applyPropertyDefaultsIfNull;

    public static class Builder {
        private boolean applyPropertyDefaults = false;
        private boolean applyPropertyDefaultsIfNull = false;
        private boolean applyArrayDefaults = false;

        public Builder applyArrayDefaults(boolean z10) {
            this.applyArrayDefaults = z10;
            return this;
        }

        public Builder applyPropertyDefaults(boolean z10) {
            this.applyPropertyDefaults = z10;
            if (!z10) {
                this.applyPropertyDefaultsIfNull = false;
            }
            return this;
        }

        public Builder applyPropertyDefaultsIfNull(boolean z10) {
            this.applyPropertyDefaultsIfNull = z10;
            if (z10) {
                this.applyPropertyDefaults = true;
            }
            return this;
        }

        public ApplyDefaultsStrategy build() {
            return new ApplyDefaultsStrategy(this.applyPropertyDefaults, this.applyPropertyDefaultsIfNull, this.applyArrayDefaults);
        }
    }

    public ApplyDefaultsStrategy(boolean z10, boolean z11, boolean z12) {
        if (!z10 && z11) {
            throw new IllegalArgumentException();
        }
        this.applyPropertyDefaults = z10;
        this.applyPropertyDefaultsIfNull = z11;
        this.applyArrayDefaults = z12;
    }

    public static Builder builder(ApplyDefaultsStrategy applyDefaultsStrategy) {
        if (applyDefaultsStrategy == null) {
            return new Builder();
        }
        Builder builder = new Builder();
        builder.applyArrayDefaults = applyDefaultsStrategy.applyArrayDefaults;
        builder.applyPropertyDefaults = applyDefaultsStrategy.applyPropertyDefaults;
        builder.applyPropertyDefaultsIfNull = applyDefaultsStrategy.applyPropertyDefaultsIfNull;
        return builder;
    }

    public boolean shouldApplyArrayDefaults() {
        return this.applyArrayDefaults;
    }

    public boolean shouldApplyPropertyDefaults() {
        return this.applyPropertyDefaults;
    }

    public boolean shouldApplyPropertyDefaultsIfNull() {
        return this.applyPropertyDefaultsIfNull;
    }

    public static Builder builder() {
        return new Builder();
    }
}
