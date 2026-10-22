package com.obric.aiagent.utils.c;

import android.os.Build;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.f;
import d.g;
import d.h.b.o;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: TrustedCallerConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "TrustedCallerConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f22333b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f22334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f22335d = null;

    public static /* synthetic */ List lambda$8xfBt98sIn7XZbjZsRUc4cH_toI() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$E7oi51tJVXpED33QHCN-tdefUWI, reason: not valid java name */
    public static /* synthetic */ Set m392lambda$E7oi51tJVXpED33QHCNtdefUWI() {
        return d();
    }

    private a() {
    }

    static {
        f22332a = new a();
        f22333b = g.a($$Lambda$a$E7oi51tJVXpED33QHCNtdefUWI.INSTANCE);
        f22334c = ax.a("com.larus.nova");
        f22335d = g.a($$Lambda$a$8xfBt98sIn7XZbjZsRUc4cH_toI.INSTANCE);
    }

    private final Set<String> c() {
        return (Set) ZeusTransformUtils.preCheckCast(f22333b.b(), Set.class, "com.obric.aiagent.plugin");
    }

    private static final Set d() {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        Object r1 = n.f(Build.TAGS);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = n.c(r1);
        if (r2 == null) goto L10;
        ILogDepend.Companion.w(TAG, "failed to read Build.TAGS, fallback to release signatures", r2);
    L10:
        if (n.b(r1) == false) goto L13;
        r1 = null;
    L13:
        if (o.a((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), "test-keys") == false) goto L16;
        return ax.a(new String[]{"c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", "3ac3fbb816b876e984ee015960eb9166e5951dc366979a913a09dd8315ab24bb", "27d4970e5ab876f6cd44ee92f3739ad25fec7aa7ddf0c67a747b2971c6fad886"});
    L16:
        return ax.a(new String[]{"b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", "144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", "27d4970e5ab876f6cd44ee92f3739ad25fec7aa7ddf0c67a747b2971c6fad886"});
    L4:
        th = move-exception;
        n.a r3 = n.f38560a;
        r1 = n.f(d.o.a(th));
        goto L6
    }

    public final Set<String> a() {
        return f22334c;
    }

    public final List<c> b() {
        return (List) ZeusTransformUtils.preCheckCast(f22335d.b(), List.class, "com.obric.aiagent.plugin");
    }

    private static final List e() {
        a r1 = f22332a;
        return p.a(new c("com.obric.agentskills", r1.a(r1.c())));
    }

    private final Set<String> a(Set<String> r15) {
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r14.iterator();
    L4:
        if (r17.hasNext() == false) goto L7;
        String r1 = d.o.o.a(d.o.o.a((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"), ":", "", false, 4, null), " ", "", false, 4, null).toUpperCase(Locale.ROOT);
        o.c(r1, "toUpperCase(...)");
        r16.add(r1);
        goto L4
    L7:
        return p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }
}
