package com.bytedance.android.livesdk.castscreen.guide;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcPlayGuideNew f104508a;

    public j(PadAndPcPlayGuideNew r100) {
        this.f104508a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PadAndPcGuideExpandType r101 = (PadAndPcGuideExpandType) r100;
        if (r101 == null) goto L20;
        int r102 = h.f104506a[r101.ordinal()];
        if (r102 != 1) goto L8;
        View r103 = this.f104508a.f104468g;
        if (r103 == null) goto L19;
        r103.performClick();
        return;
    L19:
        return;
    L8:
        if (r102 != 2) goto L21;
        View r104 = this.f104508a.f104464c;
        if (r104 == null) goto L17;
        r104.performClick();
        return;
    L17:
        return;
    L21:
        return;
    }
}
