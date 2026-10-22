package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f115847a;

    public f(Function0 r100) {
        this.f115847a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        this.f115847a.invoke();
    }
}
