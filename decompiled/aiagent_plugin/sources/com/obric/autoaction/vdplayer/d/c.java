package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerAgentActionReducer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f25469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f25470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<a> f25471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<a> f25472d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<a> f25473e = null;
    private static final List<a> f = null;
    private static final List<a> g = null;

    private c() {
    }

    public final List<a> a() {
        return f25470b;
    }

    static {
        f25469a = new c();
        f25470b = d.a.p.b(new a[]{new a(b.f25465b, false, false, null, 14, null), new a(b.f25468e, false, false, null, 14, null), new a(b.f, false, false, null, 14, null)});
        f25471c = d.a.p.b(new a[]{new a(b.f25465b, false, false, null, 14, null), new a(b.f25468e, false, false, null, 14, null), new a(b.f, false, false, null, 14, null)});
        f25472d = d.a.p.b(new a[]{new a(b.f25465b, false, false, null, 14, null), new a(b.f25467d, false, true, null, 10, null), new a(b.f, false, false, null, 14, null)});
        f25473e = d.a.p.b(new a[]{new a(b.f25464a, false, true, null, 10, null), new a(b.f25468e, false, false, null, 14, null), new a(b.f, false, false, null, 14, null)});
        f = d.a.p.b(new a[]{new a(b.g, false, false, null, 14, null), new a(b.j, false, false, null, 14, null)});
        g = d.a.p.b(new a[]{new a(b.g, false, false, null, 14, null), new a(b.j, false, false, null, 14, null)});
    }

    public final List<a> b() {
        return f25471c;
    }

    public final List<a> c() {
        return f25472d;
    }

    public final List<a> d() {
        return f25473e;
    }

    public final List<a> e() {
        return f;
    }

    public final List<a> f() {
        return g;
    }

    public final List<a> a(List<a> r10, boolean r11) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "<this>");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        if (r2.getType() != b.f25465b) goto L8;
        r2 = a.a(r2, null, r11, false, null, 13, null);
    L8:
        r13.add(r2);
        goto L4
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
    }

    public final List<a> a(List<a> r10, String r11) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "<this>");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        if (r2.getType() != b.f25467d) goto L8;
        r2 = a.a(r2, null, true, false, r11, 5, null);
    L8:
        r13.add(r2);
        goto L4
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
    }
}
