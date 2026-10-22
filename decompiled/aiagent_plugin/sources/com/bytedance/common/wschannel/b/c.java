package com.bytedance.common.wschannel.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConnectionState.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f6777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f6778c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f6779d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f6780e = null;
    private static final /* synthetic */ c[] g = null;
    final int f;

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(g.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("CONNECTION_UNKNOWN", 0, 1);
        f6776a = r0;
        c r1 = new c("CONNECTING", 1, 2);
        f6777b = r1;
        c r4 = new c("CONNECT_FAILED", 2, 4);
        f6778c = r4;
        c r6 = new c("CONNECT_CLOSED", 3, 8);
        f6779d = r6;
        c r8 = new c("CONNECTED", 4, 16);
        f6780e = r8;
        g = new c[]{r0, r1, r4, r6, r8};
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.f + '}';
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f = r3;
    }
}
