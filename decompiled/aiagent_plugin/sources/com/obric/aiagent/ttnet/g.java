package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTNetConfigInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f22236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f22237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f22238d;

    public g() {
        this(false, null, null, false, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f22235a == r6.f22235a) goto L12;
        return false;
    L12:
        if (o.a(this.f22236b, r6.f22236b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22237c, r6.f22237c) == true) goto L18;
        return false;
    L18:
        if (this.f22238d == r6.f22238d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f22235a) * 31) + this.f22236b.hashCode()) * 31) + this.f22237c.hashCode()) * 31) + Boolean.hashCode(this.f22238d);
    }

    public String toString() {
        return "TTNetConfigInfo(isDebug=" + this.f22235a + ", configServersArray=" + this.f22236b + ", serviceDomainMap=" + this.f22237c + ", enableAntiSniffing=" + this.f22238d + ')';
    }

    public g(boolean r3, List<String> r4, Map<String, String> r5, boolean r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r7, "configServersArray");
        o.e(r8, "serviceDomainMap");
        this.f22235a = r3;
        this.f22236b = r7;
        this.f22237c = r8;
        this.f22238d = r6;
    }

    public final boolean a() {
        return this.f22235a;
    }

    public /* synthetic */ g(boolean r2, List r3, Map r4, boolean r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = p.b();
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = ao.b();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = true;
    L14:
        this(r2, r8, r9, r5);
    }

    public final List<String> b() {
        return this.f22236b;
    }

    public final Map<String, String> c() {
        return this.f22237c;
    }

    public final boolean d() {
        return this.f22238d;
    }
}
