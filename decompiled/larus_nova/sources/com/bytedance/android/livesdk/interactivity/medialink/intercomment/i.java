package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaInteractCommentDataContext.f f138207a;

    public i(MediaInteractCommentDataContext.f r100) {
        this.f138207a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        MediaInteractCommentDataContext.access$sendAction(this.f138207a.f138178a, new e());
    }
}
