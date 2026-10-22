package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f137281a = null;

    static {
        f137281a = new f();
    }

    public f() {
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
