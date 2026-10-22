package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPrivilegeClarityManager f109451a;

    public k(ReplayPrivilegeClarityManager r100) {
        this.f109451a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f109451a.j(String.valueOf(((Throwable) r100).getMessage()));
    }
}
