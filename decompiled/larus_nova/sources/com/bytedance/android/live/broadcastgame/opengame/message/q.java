package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements com.bytedance.android.live.broadcastgame.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f60269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f60270b;

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // com.bytedance.android.live.broadcastgame.a0
    public final boolean a(com.bytedance.android.live.broadcastgame.v r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof m) == true) goto L5;
    L28:
        return false;
    L5:
        if ((r100 instanceof f0) == false) goto L7;
        return false;
    L7:
        m r101 = (m) r100;
        if (r101.f60250c != (-1)) goto L11;
        return false;
    L11:
        if ((r100 instanceof y) == true) goto L13;
    L15:
        String r102 = this.f60269a;
        if (r102 != null) goto L18;
    L27:
        return true;
    L18:
        if (this.f60270b == null) goto L27;
        if ((!Intrinsics.areEqual(r101.f60248a, r102)) == true) goto L27;
        long r103 = r101.f60250c;
        Long r104 = this.f60270b;
        if (r104 == null) goto L27;
        if (r103 == r104.longValue()) goto L28;
    L13:
        if (((y) r100).f60287f != 1) goto L15;
        return false;
    }
}
