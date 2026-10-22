package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f70173a = null;

    static {
        f70173a = new m();
    }

    public m() {
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r102 != null) goto L4;
    L6:
        return false;
    L4:
        if (r102.getKeyCode() != 66) goto L6;
        return true;
    }
}
