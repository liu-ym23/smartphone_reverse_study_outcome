package com.bytedance.android.shopping.card_list.utils;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f171916a;

    public e(Function0 r100) {
        this.f171916a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function0 r102 = this.f171916a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }
}
