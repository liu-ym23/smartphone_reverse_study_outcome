package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: VirtualDisplayRecordSetPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f27499a = null;

    /* JADX INFO: compiled from: VirtualDisplayRecordSetPolicy.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f27500a = null;

        static {
            f27500a = new a();
        }

        a() {
            super(1, d.o.o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
        }

        public final String a(String r2) {
            d.h.b.o.e(r2, "p0");
            return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetPolicy.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f27501a = null;

        static {
            f27501a = new b();
        }

        b() {
            super(1, d.o.o.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r1 = true;
        L7:
            return Boolean.valueOf(r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27499a = new o();
    }

    private o() {
    }

    public final Set<String> a(Collection<String> r3) {
        Collection r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "packageNames");
        return (Set) ZeusTransformUtils.preCheckCast(d.n.m.b(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f27500a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f27501a, d.h.a.b.class, "com.obric.aiagent.plugin"))), Set.class, "com.obric.aiagent.plugin");
    }

    public final boolean b(Collection<String> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "packageNames");
        if (r1.size() > 512) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<List<String>> c(Collection<String> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "packageNames");
        return d.a.p.d((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), 128);
    }
}
