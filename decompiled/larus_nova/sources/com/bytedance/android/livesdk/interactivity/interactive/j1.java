package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.msgboard.a f137421a;

    public j1(com.bytedance.android.livesdk.chatroom.msgboard.a r100) {
        this.f137421a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f137421a.setRequestDressInfoFailed(true);
        ALogger.e("VSMsgBoardUtils", "request dressInfo Failed");
    }
}
