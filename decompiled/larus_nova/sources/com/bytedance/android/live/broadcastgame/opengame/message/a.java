package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f60187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f60188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60189h;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{appId:");
        r100.append(this.f60248a);
        r100.append(", roomId:");
        r100.append(this.f60249b);
        r100.append(", seqNum:");
        r100.append(this.f60239d);
        r100.append(", connId:");
        r100.append(this.f60250c);
        r100.append(", sendType:");
        r100.append(this.f60240e);
        r100.append(", data:");
        r100.append(this.f60187f);
        r100.append(", audienceOpenId:");
        String r101 = this.f60188g;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(", extra:");
        String r103 = this.f60189h;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    }

    public a(String r110, long r111, long r112, long r113, String r210, long r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r210, "data");
        super(r110, r111, r112, r113, r211);
        this.f60187f = r210;
        this.f60188g = r212;
        this.f60189h = null;
    }
}
