package androidx.appsearch.stats;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.core.util.Preconditions;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class BaseStats {
    private static final int LAUNCH_VM = 0;
    private final long mEnabledFeatures;

    @SuppressLint({"StaticFinalBuilder"})
    public static abstract class Builder<BuilderType extends Builder> {
        private final BuilderType mBuilderTypeInstance = this;
        long mEnabledFeatures;

        private void modifyEnabledFeature(int i, boolean z10) {
            if (z10) {
                this.mEnabledFeatures = (1 << i) | this.mEnabledFeatures;
            } else {
                this.mEnabledFeatures = (~(1 << i)) & this.mEnabledFeatures;
            }
        }

        public abstract BaseStats build();

        @CanIgnoreReturnValue
        public BuilderType setLaunchVMEnabled(boolean z10) {
            modifyEnabledFeature(0, z10);
            return this.mBuilderTypeInstance;
        }
    }

    public BaseStats(Builder<?> builder) {
        Preconditions.checkNotNull(builder);
        this.mEnabledFeatures = builder.mEnabledFeatures;
    }

    public long getEnabledFeatures() {
        return this.mEnabledFeatures;
    }
}
