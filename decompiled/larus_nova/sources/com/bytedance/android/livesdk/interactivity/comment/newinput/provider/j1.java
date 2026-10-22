package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f135913a = null;

    static {
        f135913a = new j1();
    }

    public j1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("SecretChatListProvider", "get history chat list error");
    }
}
