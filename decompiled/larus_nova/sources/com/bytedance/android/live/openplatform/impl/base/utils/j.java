package com.bytedance.android.live.openplatform.impl.base.utils;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f84064a;

    public j(Function1 r100) {
        this.f84064a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function1 r102 = this.f84064a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke(r101);
        return;
    }
}
