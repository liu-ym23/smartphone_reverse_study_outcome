package com.bytedance.android.livesdk.pannel;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetBaseDialog f154362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f154363b;

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean a() {
        return this.f154363b.a();
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean b() {
        return this.f154363b.b();
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean c() {
        if (this.f154363b.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f154363b.c() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean d() {
        if (this.f154363b.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f154363b.d() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean e() {
        if (this.f154363b.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f154362a.f154338c == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean f(MotionEvent r100) {
        return this.f154363b.f(r100);
    }

    public b(SheetBaseDialog r100, e r101) {
        this.f154362a = r100;
        this.f154363b = r101;
    }
}
