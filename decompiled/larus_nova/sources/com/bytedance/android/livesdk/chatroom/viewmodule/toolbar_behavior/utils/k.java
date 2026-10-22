package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f117413a = null;

    static {
        f117413a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L6;
        String r102 = r101.getMessage();
        if (r102 == null) goto L6;
    L7:
        Logger.e("introduce-card", r102, r101);
        return;
    L6:
        r102 = "直播间状态设置出错";
        goto L7
    }
}
