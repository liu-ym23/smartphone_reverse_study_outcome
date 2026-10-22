package com.bytedance.android.gamecp.business.comment.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListAdapter f51974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListAdapter.CommentChildReplyViewHolder f51975b;

    public c(CommentReplyListAdapter r100, CommentReplyListAdapter.CommentChildReplyViewHolder r101) {
        this.f51974a = r100;
        this.f51975b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f51974a.C2(this.f51975b.getAdapterPosition(), Boolean.FALSE);
    }
}
