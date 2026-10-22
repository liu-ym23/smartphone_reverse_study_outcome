package com.obric.aiagent.skill.credentials.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.List;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f18959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f18960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18963e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final List<String> j;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f18959a == r6.f18959a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18960b, r6.f18960b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18961c, r6.f18961c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18962d, r6.f18962d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f18963e, r6.f18963e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f18959a) * 31;
        Integer r1 = this.f18960b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f18961c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f18962d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f18963e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return ((r22 + r2) * 31) + this.j.hashCode();
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CredentialSidecarEnvelope(ok=" + this.f18959a + ", code=" + this.f18960b + ", type=" + this.f18961c + ", subtype=" + this.f18962d + ", message=" + this.f18963e + ", hint=" + this.f + ", appId=" + this.g + ", userOpenId=" + this.h + ", brand=" + this.i + ", scopes=" + this.j + ')';
    }

    public h(boolean r3, Integer r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "scopes");
        this.f18959a = r3;
        this.f18960b = r4;
        this.f18961c = r5;
        this.f18962d = r6;
        this.f18963e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
    }

    public final boolean a() {
        return this.f18959a;
    }

    public final Integer b() {
        return this.f18960b;
    }

    public final String getType() {
        return this.f18961c;
    }

    public final String c() {
        return this.f18962d;
    }

    public final String d() {
        return this.f18963e;
    }

    public final String e() {
        return this.f;
    }

    public /* synthetic */ h(boolean r12, Integer r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, List r21, int r22, d.h.b.h r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        String r3 = null;
        if ((r22 & 2) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r22 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r22 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r22 & 64) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r22 & 128) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r22 & 256) != 0) goto L35;
        r3 = r20;
    L35:
        if ((r22 & 512) == 0) goto L37;
        r1 = p.b();
    L37:
        this(r12, r2, r4, r5, r6, r7, r8, r9, r3, r1);
        return;
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final List<String> f() {
        return this.j;
    }
}
