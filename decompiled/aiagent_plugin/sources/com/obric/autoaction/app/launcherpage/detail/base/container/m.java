package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailModelExtraViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23334e;

    public m() {
        this(null, false, null, null, null, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23330a, r6.f23330a) == true) goto L12;
        return false;
    L12:
        if (this.f23331b == r6.f23331b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23332c, r6.f23332c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23333d, r6.f23333d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f23334e, r6.f23334e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f23330a.hashCode() * 31) + Boolean.hashCode(this.f23331b)) * 31) + this.f23332c.hashCode()) * 31;
        String r1 = this.f23333d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f23334e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailModelExtraDataV2(model=" + this.f23330a + ", frequencyEnabled=" + this.f23331b + ", historyCount=" + this.f23332c + ", historyTaskId=" + this.f23333d + ", historyQuery=" + this.f23334e + ')';
    }

    public m(String r2, boolean r3, String r4, String r5, String r6) {
        d.h.b.o.e(r2, "model");
        d.h.b.o.e(r4, "historyCount");
        d.h.b.o.e(r6, "historyQuery");
        this.f23330a = r2;
        this.f23331b = r3;
        this.f23332c = r4;
        this.f23333d = r5;
        this.f23334e = r6;
    }

    public /* synthetic */ m(String r2, boolean r3, String r4, String r5, String r6, int r7, d.h.b.h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = "0";
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = "";
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String a() {
        return this.f23330a;
    }

    public final boolean b() {
        return this.f23331b;
    }

    public final String c() {
        return this.f23332c;
    }

    public final String d() {
        return this.f23333d;
    }

    public final String e() {
        return this.f23334e;
    }
}
