package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f25896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f25898c;

    public static /* synthetic */ h a(h r0, boolean r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f25896a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f25897b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.f25898c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final h a(boolean r1, String r2, String r3) {
        d.h.b.o.e(r2, "appName");
        return new h(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f25896a == r6.f25896a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f25897b, r6.f25897b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f25898c, r6.f25898c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.f25896a) * 31) + this.f25897b.hashCode()) * 31;
        String r2 = this.f25898c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "OpAppInfo(show=" + this.f25896a + ", appName=" + this.f25897b + ", packageName=" + this.f25898c + ')';
    }

    public h(boolean r2, String r3, String r4) {
        d.h.b.o.e(r3, "appName");
        this.f25896a = r2;
        this.f25897b = r3;
        this.f25898c = r4;
    }

    public /* synthetic */ h(boolean r1, String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1, r2, r3);
    }

    public final boolean a() {
        return this.f25896a;
    }

    public final String b() {
        return this.f25897b;
    }

    public final String c() {
        return this.f25898c;
    }
}
