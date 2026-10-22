package com.bytedance.android.gamecp.business.comment.edit;

import com.bytedance.android.gamecp.business.view.GamePromoteCommonRatingBar;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends GamePromoteCommonRatingBar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorFullscreenDialog f52159a;

    public j(CommentEditorFullscreenDialog r100) {
        this.f52159a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.view.GamePromoteCommonRatingBar.a
    public final void a(float r100) {
        CommentEditorFullscreenDialog r101 = this.f52159a;
        int r102 = CommentEditorFullscreenDialog.I;
        r101.Y90().setAlpha(1.0f);
        this.f52159a.da0((int) r100);
    }
}
