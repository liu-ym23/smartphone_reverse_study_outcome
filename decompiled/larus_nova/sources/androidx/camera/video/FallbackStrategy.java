package androidx.camera.video;

/* JADX INFO: loaded from: classes2.dex */
public class FallbackStrategy {
    static final int FALLBACK_RULE_HIGHER = 2;
    static final int FALLBACK_RULE_HIGHER_OR_LOWER = 1;
    static final int FALLBACK_RULE_LOWER = 4;
    static final int FALLBACK_RULE_LOWER_OR_HIGHER = 3;
    static final int FALLBACK_RULE_NONE = 0;
    static final FallbackStrategy NONE = null;

    /* JADX INFO: renamed from: androidx.camera.video.FallbackStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class RuleStrategy extends FallbackStrategy {
        public RuleStrategy() {
            super(null);
        }

        public abstract Quality getFallbackQuality();

        public abstract int getFallbackRule();
    }

    static {
        NONE = new AutoValue_FallbackStrategy_RuleStrategy(Quality.NONE, 0);
    }

    private FallbackStrategy() {
    }

    public /* synthetic */ FallbackStrategy(AnonymousClass1 r100) {
        this();
    }

    public static FallbackStrategy higherQualityOrLowerThan(Quality r100) {
        return new AutoValue_FallbackStrategy_RuleStrategy(r100, 1);
    }

    public static FallbackStrategy higherQualityThan(Quality r100) {
        return new AutoValue_FallbackStrategy_RuleStrategy(r100, 2);
    }

    public static FallbackStrategy lowerQualityOrHigherThan(Quality r100) {
        return new AutoValue_FallbackStrategy_RuleStrategy(r100, 3);
    }

    public static FallbackStrategy lowerQualityThan(Quality r100) {
        return new AutoValue_FallbackStrategy_RuleStrategy(r100, 4);
    }
}
