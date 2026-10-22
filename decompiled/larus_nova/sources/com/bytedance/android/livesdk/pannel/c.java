package com.bytedance.android.livesdk.pannel;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetBaseDialog f154364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f154365b;

    @Override // com.bytedance.android.livesdk.pannel.f
    public final boolean disableDragDown() {
        if (this.f154365b.disableDragDown() == true) goto L10;
        SheetBaseDialog r100 = this.f154364a;
        if (r100.f154338c == false) goto L10;
        if (r100.f154354s == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.livesdk.pannel.f
    public final boolean a(MotionEvent r100) {
        return this.f154365b.a(r100);
    }

    @Override // com.bytedance.android.livesdk.pannel.f
    public final boolean shouldInterceptSlide(int r100) {
        return this.f154365b.shouldInterceptSlide(r100);
    }

    public c(SheetBaseDialog r100, f r101) {
        this.f154364a = r100;
        this.f154365b = r101;
    }
}
