package com.obric.aiagent.skill.virt.impl.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LxcConnectionConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f22027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f22028e;
    private final String f;
    private final int g;
    private final int h;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22024a, r6.f22024a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22025b, r6.f22025b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22026c, r6.f22026c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f22027d, r6.f22027d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f22028e, r6.f22028e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.f22024a.hashCode() * 31) + this.f22025b.hashCode()) * 31) + this.f22026c.hashCode()) * 31) + this.f22027d.hashCode()) * 31) + this.f22028e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h);
    }

    public String toString() {
        return "LxcConnectionConfig(businessName=" + this.f22024a + ", serviceName=" + this.f22025b + ", interfaceToken=" + this.f22026c + ", containerName=" + this.f22027d + ", sharedHostPath=" + this.f22028e + ", sharedVirtPath=" + this.f + ", privileged=" + this.g + ", timeoutSeconds=" + this.h + ')';
    }

    public b(String r2, String r3, String r4, String r5, String r6, String r7, int r8, int r9) {
        o.e(r2, "businessName");
        o.e(r3, "serviceName");
        o.e(r4, "interfaceToken");
        o.e(r5, "containerName");
        o.e(r6, "sharedHostPath");
        o.e(r7, "sharedVirtPath");
        this.f22024a = r2;
        this.f22025b = r3;
        this.f22026c = r4;
        this.f22027d = r5;
        this.f22028e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ b(String r9, String r10, String r11, String r12, String r13, String r14, int r15, int r16, int r17, h r18) {
        if ((r17 & 2) == 0) goto L5;
        String r1 = "VirtService";
    L7:
        if ((r17 & 4) == 0) goto L9;
        String r2 = "com.bytedance.virt.IVirtService";
    L11:
        if ((r17 & 8) == 0) goto L13;
        String r3 = "ubuntu";
    L15:
        if ((r17 & 16) == 0) goto L17;
        String r4 = "/data/misc/virt/share";
    L19:
        if ((r17 & 32) == 0) goto L21;
        String r5 = "/home/share";
    L22:
        int r7 = 0;
        if ((r17 & 64) == 0) goto L25;
        int r6 = 0;
    L27:
        if ((r17 & 128) != 0) goto L30;
        r7 = r16;
    L30:
        this(r9, r1, r2, r3, r4, r5, r6, r7);
        return;
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L22
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String a() {
        return this.f22024a;
    }

    public final String b() {
        return this.f22025b;
    }

    public final String c() {
        return this.f22026c;
    }

    public final String d() {
        return this.f22027d;
    }

    public final String e() {
        return this.f22028e;
    }

    public final String f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }
}
