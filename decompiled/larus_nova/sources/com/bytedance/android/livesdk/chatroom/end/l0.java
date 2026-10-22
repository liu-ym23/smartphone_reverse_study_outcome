package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class l0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f106086a = null;

    static {
        f106086a = new l0();
    }

    public l0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f2.b(R.string.ttlive_reserve_fail, 0);
        Logger.e(((Throwable) r100).getMessage());
    }
}
