package com.obric.oui.texteffects.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f36421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f36422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f36423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<f> f36424e;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, n.class) == true) goto L8;
        return false;
    L8:
        n r10 = (n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f36420a, r10.f36420a) == true) goto L12;
        return false;
    L12:
        if (this.f36421b == r10.f36421b) goto L15;
        return false;
    L15:
        if (this.f36422c == r10.f36422c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f36423d, r10.f36423d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f36424e, r10.f36424e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f36420a.hashCode() * 31) + Integer.hashCode(this.f36421b)) * 31) + Long.hashCode(this.f36422c)) * 31) + this.f36423d.hashCode()) * 31) + this.f36424e.hashCode();
    }

    public String toString() {
        return "TextEffectSpec(id=" + this.f36420a + ", version=" + this.f36421b + ", durationMs=" + this.f36422c + ", loop=" + this.f36423d + ", stages=" + this.f36424e + ')';
    }

    public n(String r3, int r4, long r5, j r7, List<f> r8) {
        List<f> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r7, "loop");
        d.h.b.o.e(r9, "stages");
        this.f36420a = r3;
        this.f36421b = r4;
        this.f36422c = r5;
        this.f36423d = r7;
        this.f36424e = r9;
    }

    public final String a() {
        return this.f36420a;
    }

    public final long b() {
        return this.f36422c;
    }

    public /* synthetic */ n(String r10, int r11, long r12, j r14, List r15, int r16, d.h.b.h r17) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if ((r16 & 2) == 0) goto L5;
        int r4 = 1;
    L7:
        if ((r16 & 8) == 0) goto L9;
        j r7 = (j) ZeusTransformUtils.preCheckCast(j.c.f36409a, j.class, "com.obric.aiagent.plugin");
    L10:
        this(r10, r4, r12, r7, r8);
        return;
    L9:
        r7 = r14;
        goto L10
    L5:
        r4 = r11;
        goto L7
    }

    public final j c() {
        return this.f36423d;
    }

    public final List<f> d() {
        return this.f36424e;
    }
}
