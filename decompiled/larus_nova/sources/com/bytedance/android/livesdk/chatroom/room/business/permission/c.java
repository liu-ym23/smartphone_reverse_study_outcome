package com.bytedance.android.livesdk.chatroom.room.business.permission;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f110958a;

    public c(Ref.ObjectRef r100) {
        this.f110958a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        xs2.b.a().post(new h1(59));
        CompositeDisposable r102 = (CompositeDisposable) this.f110958a.element;
        if (r102 == null) goto L6;
        r102.clear();
        return;
    }
}
