package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f144473a;

    public h(Function1 r100) {
        this.f144473a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f144473a.invoke(sh6.c.b((sh6.b) r100));
    }
}
