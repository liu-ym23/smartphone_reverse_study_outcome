package com.bytedance.android.gamecp.business.comment.edit.view;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0876a f52210a;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.comment.edit.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0876a {
        boolean onBack();
    }

    public a() {
        super(null, true);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r100) {
        if (r100 == null) goto L13;
        if (r100.getKeyCode() != 67) goto L13;
        if (r100.getAction() != 0) goto L13;
        InterfaceC0876a r101 = this.f52210a;
        if (r101 == null) goto L13;
        if (r101.onBack() != true) goto L13;
        return true;
    L13:
        return super.sendKeyEvent(r100);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r100, int r101) {
        if (r100 != 1) goto L11;
        if (r101 != 0) goto L11;
        InterfaceC0876a r102 = this.f52210a;
        if (r102 == null) goto L11;
        if (r102.onBack() != true) goto L11;
        return true;
    L11:
        return super.deleteSurroundingText(r100, r101);
    }
}
