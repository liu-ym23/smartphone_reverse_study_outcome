package com.bytedance.android.gamecp.business;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f56508a;

    public z(Ref.IntRef r100) {
        this.f56508a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("GamePromoteManager", "reportInstallFailStatus pushType:" + this.f56508a.element + ", error: " + ((Throwable) r100).getMessage());
    }
}
