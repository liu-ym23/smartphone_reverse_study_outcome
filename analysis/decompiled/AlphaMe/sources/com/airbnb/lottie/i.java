package com.airbnb.lottie;

/* loaded from: classes.dex */
public final class i implements x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4545a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4546b;

    public /* synthetic */ i(String str, int i4) {
        this.f4545a = i4;
        this.f4546b = str;
    }

    @Override // com.airbnb.lottie.x
    public final void a(Object obj) {
        int i4 = this.f4545a;
        String str = this.f4546b;
        switch (i4) {
            case 0:
                m.f4554a.remove(str);
                break;
            default:
                LottieComposition lottieComposition = (LottieComposition) obj;
                if (str != null) {
                    J0.g.f874b.f875a.b(str, lottieComposition);
                }
                m.f4554a.remove(str);
                break;
        }
    }
}
