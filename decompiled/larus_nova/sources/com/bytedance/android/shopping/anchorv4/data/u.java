package com.bytedance.android.shopping.anchorv4.data;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes12.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4Repository f166482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f166483b;

    public u(AnchorV4Repository r100, Function3 r101) {
        this.f166482a = r100;
        this.f166483b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function3 r102 = this.f166483b;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke(-1, "network error!", r101);
    L5:
        AnchorV4Repository.a(this.f166482a);
    }
}
