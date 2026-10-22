package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Easing {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1722a;

    public /* synthetic */ a(int i) {
        this.f1722a = i;
    }

    @Override // androidx.compose.animation.core.Easing
    public final float transform(float f) {
        switch (this.f1722a) {
            case 0:
                return EasingFunctionsKt.EaseInElastic$lambda$0(f);
            case 1:
                return EasingFunctionsKt.EaseOutElastic$lambda$1(f);
            case 2:
                return EasingFunctionsKt.EaseInOutElastic$lambda$2(f);
            case 3:
                return EasingFunctionsKt.EaseOutBounce$lambda$3(f);
            case 4:
                return EasingFunctionsKt.EaseInBounce$lambda$4(f);
            case 5:
                return EasingFunctionsKt.EaseInOutBounce$lambda$5(f);
            default:
                return EasingKt.LinearEasing$lambda$0(f);
        }
    }
}
