package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: ITTNetFileTransfer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f22254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f22255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f22256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f22257e;
    private final Long f;
    private final m g;
    private final int h;
    private final boolean i;
    private final boolean j;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22253a, r10.f22253a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22254b, r10.f22254b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22255c, r10.f22255c) == true) goto L18;
        return false;
    L18:
        if (this.f22256d == r10.f22256d) goto L21;
        return false;
    L21:
        if (this.f22257e == r10.f22257e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f22253a.hashCode() * 31) + this.f22254b.hashCode()) * 31) + this.f22255c.hashCode()) * 31) + Long.hashCode(this.f22256d)) * 31) + Long.hashCode(this.f22257e)) * 31;
        Long r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((r0 + r2) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TTNetFileDownloadRequest(url=" + this.f22253a + ", destination=" + this.f22254b + ", headers=" + this.f22255c + ", connectTimeoutMs=" + this.f22256d + ", readTimeoutMs=" + this.f22257e + ", maxBytes=" + this.f + ", urlPolicy=" + this.g + ", maxRedirects=" + this.h + ", isolateCookies=" + this.i + ", redactUrlInLogs=" + this.j + ')';
    }

    public i(String r3, File r4, Map<String, String> r5, long r6, long r8, Long r10, m r11, int r12, boolean r13, boolean r14) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "url");
        o.e(r4, "destination");
        o.e(r7, "headers");
        o.e(r11, "urlPolicy");
        this.f22253a = r3;
        this.f22254b = r4;
        this.f22255c = r7;
        this.f22256d = r6;
        this.f22257e = r8;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
    }

    public final String a() {
        return this.f22253a;
    }

    public final File b() {
        return this.f22254b;
    }

    public /* synthetic */ i(String r16, File r17, Map r18, long r19, long r21, Long r23, m r24, int r25, boolean r26, boolean r27, int r28, d.h.b.h r29) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        if ((r28 & 4) == 0) goto L5;
        r1 = ao.b();
    L5:
        Map r5 = r1;
        if ((r28 & 32) == 0) goto L8;
        Long r10 = null;
    L10:
        if ((r28 & 64) == 0) goto L12;
        m r11 = m.f22287a;
    L14:
        if ((r28 & 128) == 0) goto L16;
        int r12 = 5;
    L18:
        if ((r28 & 256) == 0) goto L20;
        boolean r13 = false;
    L22:
        if ((r28 & 512) == 0) goto L24;
        boolean r14 = false;
    L25:
        this(r16, r17, r5, r19, r21, r10, r11, r12, r13, r14);
        return;
    L24:
        r14 = r27;
        goto L25
    L20:
        r13 = r26;
        goto L22
    L16:
        r12 = r25;
        goto L18
    L12:
        r11 = r24;
        goto L14
    L8:
        r10 = r23;
        goto L10
    }

    public final Map<String, String> c() {
        return this.f22255c;
    }

    public final long d() {
        return this.f22256d;
    }

    public final long e() {
        return this.f22257e;
    }

    public final Long f() {
        return this.f;
    }

    public final m g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }
}
