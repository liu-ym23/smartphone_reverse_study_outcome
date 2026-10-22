package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f55108a = null;

    static {
        f55108a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.b.b(6, "TeamPlayEntranceEffect", "error = " + ((Throwable) r100).getMessage());
    }
}
