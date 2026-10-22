package com.bytedance.android.gamecp.business.comment.edit;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorFullscreenDialog f52124a;

    public g(CommentEditorFullscreenDialog r100) {
        this.f52124a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L13;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r102.getAction() == 0) goto L8;
        return false;
    L8:
        if (r102.getRepeatCount() == 0) goto L10;
        return false;
    L10:
        if (this.f52124a.ca0() == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        return false;
    }
}
