package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f36411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<i> f36412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f36413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f36414d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (this.f36411a == r6.f36411a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f36412b, r6.f36412b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f36413c, r6.f36413c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f36414d, r6.f36414d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f36411a.hashCode() * 31) + this.f36412b.hashCode()) * 31) + this.f36413c.hashCode()) * 31) + this.f36414d.hashCode();
    }

    public String toString() {
        return "PropertyTrack(property=" + this.f36411a + ", keyframes=" + this.f36412b + ", easing=" + this.f36413c + ", selector=" + this.f36414d + ')';
    }

    public l(e r3, List<i> r4, c r5, m r6) {
        List<i> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "property");
        d.h.b.o.e(r7, "keyframes");
        d.h.b.o.e(r5, "easing");
        d.h.b.o.e(r6, "selector");
        this.f36411a = r3;
        this.f36412b = r7;
        this.f36413c = r5;
        this.f36414d = r6;
    }

    public final e a() {
        return this.f36411a;
    }

    public final List<i> b() {
        return this.f36412b;
    }

    public /* synthetic */ l(e r2, List r3, c r4, m r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = (c) ZeusTransformUtils.preCheckCast(c.C0998c.f36375a, c.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = (m) ZeusTransformUtils.preCheckCast(m.a.f36415a, m.class, "com.obric.aiagent.plugin");
    L8:
        this(r2, r8, r4, r5);
    }

    public final c c() {
        return this.f36413c;
    }

    public final m d() {
        return this.f36414d;
    }
}
