package com.bytedance.android.livesdk.chatroom.vs_base.util;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f118221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f118222b;

    public z(Function1 r100, c r101) {
        this.f118221a = r100;
        this.f118222b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f118221a.invoke(this.f118222b);
    }
}
