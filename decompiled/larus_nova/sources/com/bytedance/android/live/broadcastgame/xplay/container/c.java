package com.bytedance.android.live.broadcastgame.xplay.container;

import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f62046a;

    public c(m r100) {
        this.f62046a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        if ((!Intrinsics.areEqual((Boolean) this.f62046a.getValue(), r101)) == false) goto L6;
        this.f62046a.setValue(r101);
        return;
    }
}
