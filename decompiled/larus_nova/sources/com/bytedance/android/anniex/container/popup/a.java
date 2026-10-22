package com.bytedance.android.anniex.container.popup;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f40517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SheetBaseDialog f40518b;

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean a() {
        return this.f40517a.a();
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean b() {
        return this.f40517a.b();
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean c() {
        if (this.f40517a.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f40517a.c() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean d() {
        if (this.f40517a.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f40517a.d() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean e() {
        if (this.f40517a.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f40518b.f40497h == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean f(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f40517a.f(r100);
    }

    public a(d r100, SheetBaseDialog r101) {
        this.f40517a = r100;
        this.f40518b = r101;
    }
}
