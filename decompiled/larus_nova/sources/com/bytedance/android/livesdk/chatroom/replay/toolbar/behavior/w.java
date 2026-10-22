package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f110082a = null;

    static {
        f110082a = new w();
    }

    public w() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("ToolbarVSMsgBoardBehavior", "load remote img error");
    }
}
