package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.data.activityemoji.b f135993a;

    public u(com.bytedance.android.live.base.model.data.activityemoji.b r100) {
        this.f135993a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("input activity emoji failed due to " + ((Throwable) r100).getMessage() + ", emoji id: " + this.f135993a.getIdStr());
    }
}
