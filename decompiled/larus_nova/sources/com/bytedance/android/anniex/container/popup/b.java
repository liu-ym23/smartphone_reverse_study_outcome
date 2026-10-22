package com.bytedance.android.anniex.container.popup;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f40519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SheetBaseDialog f40520b;

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean disableDragDown() {
        if (this.f40519a.disableDragDown() == true) goto L10;
        SheetBaseDialog r100 = this.f40520b;
        if (r100.f40497h == false) goto L10;
        if (r100.f40491b == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f40519a.a(r100);
    }

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean shouldInterceptSlide(int r100) {
        return this.f40519a.shouldInterceptSlide(r100);
    }

    public b(e r100, SheetBaseDialog r101) {
        this.f40519a = r100;
        this.f40520b = r101;
    }
}
