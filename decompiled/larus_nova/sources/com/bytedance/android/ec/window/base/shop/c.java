package com.bytedance.android.ec.window.base.shop;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f49638a;

    public c(Function0 r100) {
        this.f49638a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Function0 r102 = this.f49638a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }
}
