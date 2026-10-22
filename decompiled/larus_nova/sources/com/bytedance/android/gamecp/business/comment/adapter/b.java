package com.bytedance.android.gamecp.business.comment.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListAdapter f51972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListAdapter.CommentChildReplyViewHolder f51973b;

    public b(CommentReplyListAdapter r100, CommentReplyListAdapter.CommentChildReplyViewHolder r101) {
        this.f51972a = r100;
        this.f51973b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f51972a.f51895e.invoke(Integer.valueOf(this.f51973b.getAdapterPosition()));
    }
}
