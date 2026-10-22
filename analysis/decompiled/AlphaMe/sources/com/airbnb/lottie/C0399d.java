package com.airbnb.lottie;

import com.stepos.activeview.elements.LottieView;

/* renamed from: com.airbnb.lottie.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0399d implements x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4543a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0402g f4544b;

    public /* synthetic */ C0399d(LottieView lottieView, int i4) {
        this.f4543a = i4;
        this.f4544b = lottieView;
    }

    @Override // com.airbnb.lottie.x
    public final void a(Object obj) {
        switch (this.f4543a) {
            case 0:
                this.f4544b.setComposition((LottieComposition) obj);
                return;
            default:
                throw new IllegalStateException("Unable to parse composition", (Throwable) obj);
        }
    }
}
