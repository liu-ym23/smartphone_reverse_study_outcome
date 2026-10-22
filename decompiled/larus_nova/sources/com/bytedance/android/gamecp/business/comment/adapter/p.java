package com.bytedance.android.gamecp.business.comment.adapter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GamePromoteCommentDetailBarViewHolder f52002a;

    public p(GamePromoteCommentDetailBarViewHolder r100) {
        this.f52002a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        this.f52002a.U3();
        return;
    L5:
        this.f52002a.T3();
    }
}
