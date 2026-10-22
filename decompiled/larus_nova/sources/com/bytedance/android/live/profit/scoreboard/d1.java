package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f88876a = null;

    static {
        f88876a = new d1();
    }

    public d1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ToastUtil.a(R.string.ttlive_scoreboard_toast_invitation_accept_server_error, 0);
    }
}
