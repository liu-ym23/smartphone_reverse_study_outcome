package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f135954a = null;

    static {
        f135954a = new r();
    }

    public r() {
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
