package com.bytedance.safetyguard.lxc.internal.e.d;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10772e;
    private final com.bytedance.safetyguard.lxc.internal.e.f.a f;
    private final String g;
    private final String h;
    private final byte[] i;
    private final Map<String, String> j;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10768a, r6.f10768a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10769b, r6.f10769b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10770c, r6.f10770c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10771d, r6.f10771d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f10772e, r6.f10772e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f10768a.hashCode() * 31) + this.f10769b.hashCode()) * 31) + this.f10770c.hashCode()) * 31) + this.f10771d.hashCode()) * 31) + this.f10772e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Arrays.hashCode(this.i)) * 31) + this.j.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "VerifiedSidecarRequest(method=" + this.f10768a + ", pathAndQuery=" + this.f10769b + ", targetHost=" + this.f10770c + ", authHeader=" + this.f10771d + ", sessionId=" + this.f10772e + ", identity=" + this.f + ", appId=" + this.g + ", userOpenId=" + this.h + ", body=" + Arrays.toString(this.i) + ", headers=" + this.j + ')';
    }

    public c(String r3, String r4, String r5, String r6, String r7, com.bytedance.safetyguard.lxc.internal.e.f.a r8, String r9, String r10, byte[] r11, Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "method");
        o.e(r4, "pathAndQuery");
        o.e(r5, "targetHost");
        o.e(r6, "authHeader");
        o.e(r7, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r8, DownloadHelper.IDENTITY);
        o.e(r9, "appId");
        o.e(r11, "body");
        o.e(r13, "headers");
        this.f10768a = r3;
        this.f10769b = r4;
        this.f10770c = r5;
        this.f10771d = r6;
        this.f10772e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
    }

    public final String a() {
        return this.f10768a;
    }

    public final String b() {
        return this.f10769b;
    }

    public final String c() {
        return this.f10770c;
    }

    public final String d() {
        return this.f10771d;
    }

    public final String e() {
        return this.f10772e;
    }

    public final com.bytedance.safetyguard.lxc.internal.e.f.a f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final byte[] i() {
        return this.i;
    }

    public final Map<String, String> j() {
        return this.j;
    }
}
