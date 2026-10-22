package com.bytedance.android.ecom.arch.slice.render.elements.input;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcInputElementViewManager f50448a;

    public e(SlcInputElementViewManager r100) {
        this.f50448a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L5;
    L12:
        SlcInputElementViewManager r103 = this.f50448a;
        r103.f50425b4 = true;
        r103.N0(false);
        return true;
    L5:
        if (r101 == 3) goto L12;
        if (r101 == 4) goto L12;
        if (r101 == 2) goto L12;
        return false;
    }
}
