package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f144496a = null;

    static {
        f144496a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r100), Boolean.TRUE)) == false) goto L8;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = KtvComponentOrderSongDataContext.Companion.a();
        if (r101 == null) goto L9;
        r101.getOrderedSongList(false);
        return;
    L9:
        return;
    }
}
