package com.bytedance.android.livesdk.chatroom.replay.player;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, WeakReference<com.bytedance.android.livesdk.chatroom.vs_base.player.c>> f109599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f109600b = null;

    public m() {
    }

    static {
        f109600b = new m();
        f109599a = new ConcurrentHashMap();
    }

    public final com.bytedance.android.livesdk.chatroom.vs_base.player.c a(long r100) {
        WeakReference<com.bytedance.android.livesdk.chatroom.vs_base.player.c> r101 = f109599a.get(Long.valueOf(r100));
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }
}
