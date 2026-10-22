package com.bytedance.android.live.broadcastgame.opengame.message;

import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o0 implements com.bytedance.android.live.broadcastgame.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Long> f60266a;

    public static final class a {
    }

    static {
    }

    public o0() {
        this.f60266a = new LinkedList();
    }

    @Override // com.bytedance.android.live.broadcastgame.a0
    public final boolean a(com.bytedance.android.live.broadcastgame.v r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof k) == true) goto L5;
        com.bytedance.android.live.broadcastgame.v r101 = null;
    L7:
        if (((k) r101) == null) goto L26;
        long r102 = ((k) r100).f60239d;
        if (r102 == (-1)) goto L26;
        if (r102 == 1) goto L26;
        if (this.f60266a.contains(Long.valueOf(r102)) == false) goto L16;
        return true;
    L16:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L18:
        if (this.f60266a.size() != 1024) goto L20;
        this.f60266a.removeFirst();     // Catch: Throwable -> L23
    L20:
        this.f60266a.add(Long.valueOf(r102));     // Catch: Throwable -> L23
        monitor-exit(this);
    L26:
        return false;
    L5:
        r101 = r100;
        goto L7
    }
}
