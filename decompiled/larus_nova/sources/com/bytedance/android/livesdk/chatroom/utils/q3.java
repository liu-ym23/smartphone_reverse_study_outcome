package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public class q3 implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q3 f114606a = null;

    public static final class a {
    }

    public q3() {
    }

    static {
        f114606a = new q3();
    }

    public void a(Throwable r100) throws Exception {
        if ((r100 instanceof ApiServerException) == false) goto L5;
        com.bytedance.android.live.core.utils.f2.c(((ApiServerException) r100).getPrompt(), 0);
        return;
    L5:
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_network_error, 0);
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Throwable r100) {
        a(r100);
    }
}
