package androidx.camera.video;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_FallbackStrategy_RuleStrategy extends FallbackStrategy.RuleStrategy {
    private final Quality fallbackQuality;
    private final int fallbackRule;

    public int hashCode() {
        return ((this.fallbackQuality.hashCode() ^ 1000003) * 1000003) ^ this.fallbackRule;
    }

    public String toString() {
        return "RuleStrategy{fallbackQuality=" + this.fallbackQuality + ", fallbackRule=" + this.fallbackRule + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    public Quality getFallbackQuality() {
        return this.fallbackQuality;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    public int getFallbackRule() {
        return this.fallbackRule;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FallbackStrategy.RuleStrategy) == false) goto L14;
        FallbackStrategy.RuleStrategy r101 = (FallbackStrategy.RuleStrategy) r100;
        if (this.fallbackQuality.equals(r101.getFallbackQuality()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.fallbackRule != r101.getFallbackRule()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_FallbackStrategy_RuleStrategy(Quality r100, int r101) {
        if (r100 == null) goto L7;
        this.fallbackQuality = r100;
        this.fallbackRule = r101;
        return;
    L7:
        throw new NullPointerException("Null fallbackQuality");
    }
}
