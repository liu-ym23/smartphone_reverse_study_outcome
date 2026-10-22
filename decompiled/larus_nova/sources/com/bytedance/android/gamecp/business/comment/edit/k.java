package com.bytedance.android.gamecp.business.comment.edit;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends gs.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorFullscreenDialog f52160a;

    public k(CommentEditorFullscreenDialog r100) {
        this.f52160a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 != null) goto L4;
    L7:
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        CommentEditorFullscreenDialog r105 = this.f52160a;
        int r106 = CommentEditorFullscreenDialog.I;
        r105.Y90().setAlpha(1.0f);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r104 = false;
        goto L8
    }
}
