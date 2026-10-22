package com.bytedance.android.livesdk.chatroom.end.vip;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f106143a = null;

    static {
        f106143a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("VipLiveEndService", ((Throwable) r100).getMessage());
        f2.b(R.string.ttlive_vip_end_error_toast, 0);
    }
}
