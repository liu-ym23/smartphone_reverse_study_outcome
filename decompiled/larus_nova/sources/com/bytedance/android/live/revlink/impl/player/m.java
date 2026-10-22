package com.bytedance.android.live.revlink.impl.player;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f97467a;

    public m(j r100) {
        this.f97467a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        e r102 = this.f97467a.f97457i;
        if (r102 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) sh6.c.b(r101), Boolean.TRUE) == false) goto L7;
        int r103 = 0;
    L8:
        r102.a(r103);
        return;
    L7:
        r103 = 8;
        goto L8
    }
}
