package com.bytedance.android.live.revlink.impl.intercomment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractCommentDataContext.e f92542a;

    public j(InteractCommentDataContext.e r100) {
        this.f92542a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        InteractCommentDataContext.access$sendAction(this.f92542a.f92510a, new f());
    }
}
