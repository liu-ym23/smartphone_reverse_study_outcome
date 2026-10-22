package com.obric.aiagent.product.platform.impl.app;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetFramework.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f18812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.f f18814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f18815d;

    public static /* synthetic */ x lambda$3dCRnaHrW3vmDR8LbmNA9shubQQ(f r0, Class r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$DJ5ol9_XztO4snNqpWpqFlR7S7I(f r0, Throwable r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$U421Q6mFiw_R8Ur4ao19E19Vo74(f r0) {
        return a(r0);
    }

    public static /* synthetic */ e lambda$WKpgQh5I6zw1nCyNPr3Z5EDrnjM(f r0) {
        return b(r0);
    }

    public f(d r2) {
        o.e(r2, "api");
        this.f18812a = r2;
        this.f18813b = "ObricVDRecordSet";
        this.f18814c = d.g.a(d.j.f38505a, new $$Lambda$f$U421Q6mFiw_R8Ur4ao19E19Vo74(this));
        this.f18815d = d.g.a(d.j.f38505a, new $$Lambda$f$WKpgQh5I6zw1nCyNPr3Z5EDrnjM(this));
    }

    private final boolean b() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f18814c.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean a(final f r5) {
        boolean r0 = j.a(r5.f18812a, f.class.getClassLoader(), new $$Lambda$f$3dCRnaHrW3vmDR8LbmNA9shubQQ(r5), new $$Lambda$f$DJ5ol9_XztO4snNqpWpqFlR7S7I(r5));
        ILogDepend.Companion.i(r5.f18813b, "runtime capability supported=" + r0 + " namespace=" + r5.f18812a.a());
        return r0;
    }

    private static final x a(f r4, Class r5) {
        o.e(r5, "managerClass");
        ILogDepend.Companion r0 = ILogDepend.Companion;
        String r1 = r4.f18813b;
        StringBuilder r6 = new StringBuilder().append("resolved manager=").append(r4.f18812a.b()).append(" classLoader=");
        ClassLoader r7 = r5.getClassLoader();
        if (r7 == null) goto L8;
        Class<?> r8 = r7.getClass();
        if (r8 == null) goto L8;
        String r9 = r8.getName();
        if (r9 == null) goto L8;
    L9:
        r0.i(r1, r6.append(r9).toString());
        return x.f38692a;
    L8:
        r9 = "bootstrap";
        goto L9
    }

    private static final x a(f r4, Throwable r5) {
        o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
        ILogDepend.Companion.i(r4.f18813b, "runtime capability unavailable namespace=" + r4.f18812a.a() + " reason=" + r5.getClass().getSimpleName());
        return x.f38692a;
    }

    private final e c() {
        return (e) ZeusTransformUtils.preCheckCast(this.f18815d.b(), e.class, "com.obric.aiagent.plugin");
    }

    private static final e b(f r2) {
        if (r2.b() == false) goto L7;
        Object r3 = Class.forName(r2.f18812a.d(), true, f.class.getClassLoader()).getField("INSTANCE").get(null);
        o.a(r3, "null cannot be cast to non-null type com.obric.aiagent.product.platform.impl.app.AutoVirtualDisplayRecordSetCalls");
        return (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
    L7:
        throw new IllegalStateException((r2.f18812a.a() + " record-set API is unavailable").toString());
    }

    public final boolean a() {
        return b();
    }

    public final long a(int r5, int r6, ObricAutoVirtualDisplayRecordSetListener r7) {
        o.e(r7, "listener");
        if (b() == true) goto L12;
        return 0;
    L12:
    L15:
        return c().begin(r5, r6, r7);
    L9:
        e = move-exception;
        ILogDepend.Companion.e(this.f18813b, this.f18812a.a() + " beginAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 0;
    L7:
        e = move-exception;
        ILogDepend.Companion.e(this.f18813b, this.f18812a.a() + " beginAutoVirtualDisplayRecordSet linkage failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 0;
    }

    public final boolean a(long r4, String[] r6) {
        o.e(r6, "packageNames");
        if (b() == true) goto L12;
        return false;
    L12:
    L15:
        return c().add(r4, r6);
    L9:
        e = move-exception;
        ILogDepend.Companion.e(this.f18813b, this.f18812a.a() + " addAutoVirtualDisplayRecordPackages failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    L7:
        e = move-exception;
        ILogDepend.Companion.e(this.f18813b, this.f18812a.a() + " addAutoVirtualDisplayRecordPackages linkage failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    public final void a(long r4) {
        if (b() == true) goto L12;
        return;
    L12:
        c().end(r4);     // Catch: LinkageError -> L7 Exception -> L9
    L15:
        return;
    L9:
        e = move-exception;
        ILogDepend.Companion.e(this.f18813b, this.f18812a.a() + " endAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        e = move-exception;
        ILogDepend.Companion.e(this.f18813b, this.f18812a.a() + " endAutoVirtualDisplayRecordSet linkage failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
