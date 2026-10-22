package androidx.camera.core.resolutionselector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class AspectRatioStrategy {
    public static final int FALLBACK_RULE_AUTO = 1;
    public static final int FALLBACK_RULE_NONE = 0;
    public static final AspectRatioStrategy RATIO_16_9_FALLBACK_AUTO_STRATEGY = null;
    public static final AspectRatioStrategy RATIO_4_3_FALLBACK_AUTO_STRATEGY = null;
    private final int mFallbackRule;
    private final int mPreferredAspectRatio;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AspectRatioFallbackRule {
    }

    static {
        RATIO_4_3_FALLBACK_AUTO_STRATEGY = new AspectRatioStrategy(0, 1);
        RATIO_16_9_FALLBACK_AUTO_STRATEGY = new AspectRatioStrategy(1, 1);
    }

    public int getFallbackRule() {
        return this.mFallbackRule;
    }

    public int getPreferredAspectRatio() {
        return this.mPreferredAspectRatio;
    }

    public AspectRatioStrategy(int r100, int r101) {
        this.mPreferredAspectRatio = r100;
        this.mFallbackRule = r101;
    }
}
