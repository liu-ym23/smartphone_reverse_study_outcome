package com.bytedance.android.gamecp.business.gamedetail.component.minigamebar;

import com.bytedance.android.gamecp.base.network.response.i;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f54562a = null;

    static {
        f54562a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i r101 = (i) r100;
        yr.c.e("MiniGame", "notify open mini game action success");
    }
}
