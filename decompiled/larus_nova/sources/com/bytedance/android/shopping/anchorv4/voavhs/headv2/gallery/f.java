package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f169306a;

    public f(e r100) {
        this.f169306a = r100;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        e r100 = this.f169306a;
        View r101 = r100.f169294b;
        if (r101 == null) goto L6;
        r101.removeCallbacks(r100.f169295c);
        return;
    }
}
