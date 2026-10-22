package com.bytedance.android.livesdk.interactivity.personalized;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f138627a;

    public b(Function1 r100) {
        this.f138627a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        this.f138627a.invoke(r100);
    }
}
