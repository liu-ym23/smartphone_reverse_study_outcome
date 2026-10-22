package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c<T> {

    public static final class a {
    }

    static {
    }

    public abstract com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.a<T> a();

    public abstract jq1.b b();

    public final void c() {
        if (a().a() == false) goto L8;
        jq1.b r100 = b();
        if (r100 == null) goto L9;
        a().b(r100);
        return;
    L9:
        return;
    }

    public c(com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
    }
}
