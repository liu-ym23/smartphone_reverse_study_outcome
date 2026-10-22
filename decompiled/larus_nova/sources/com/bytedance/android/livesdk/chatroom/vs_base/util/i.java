package com.bytedance.android.livesdk.chatroom.vs_base.util;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f118198a;

    public i(Function0 r100) {
        this.f118198a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        this.f118198a.invoke();
    }
}
