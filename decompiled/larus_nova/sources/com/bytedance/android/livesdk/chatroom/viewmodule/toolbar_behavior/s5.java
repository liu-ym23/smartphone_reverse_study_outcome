package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class s5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s5 f117367a = null;

    static {
        f117367a = new s5();
    }

    public s5() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("ToolbarVSMsgBoardBehavior", "load remote img error");
    }
}
