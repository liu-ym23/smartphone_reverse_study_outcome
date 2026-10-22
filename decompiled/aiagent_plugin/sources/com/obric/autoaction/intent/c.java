package com.obric.autoaction.intent;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.DispatchContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: ResultMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f24728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f24729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f24730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f24731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f24732e;
    private static DispatchContext f;
    private static final CopyOnWriteArrayList<b> g = null;
    private static final Object h = null;

    private c() {
    }

    public final boolean a() {
        return f24730c;
    }

    static {
        f24728a = new c();
        f24731d = "";
        f24732e = "";
        g = new CopyOnWriteArrayList();
        h = new Object();
    }

    public final void setResult(String r1) {
        o.e(r1, "<set-?>");
        f24731d = r1;
    }

    public final DispatchContext b() {
        return f;
    }

    public final void a(DispatchContext r1) {
        o.e(r1, "dispatchContext");
        f24729b = false;
        f24731d = "";
        f24732e = "";
        f24730c = true;
        f = r1;
    }

    public static /* synthetic */ void a(c r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.setResult(r1, r2, r3, r4);
    }

    public final void setResult(String r4, String r5, String r6, boolean r7) {
        o.e(r4, "result");
        o.e(r5, "reason");
        o.e(r6, ObricMemoryConstants.KEY_SESSION_ID);
        if (f24730c == true) goto L5;
        return;
    L5:
        f24731d = r4;
        f24732e = r5;
        f24729b = true;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        r0.a(r4, r5, r6, r7);     // Catch: Throwable -> L11
        n.f(x.f38692a);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        n.a r8 = n.f38560a;
        n.f(d.o.a(th));
        goto L7
    L13:
        f24730c = false;
    }

    public final void a(String r9, String r10, String r11, int r12, int r13) {
        o.e(r9, "result");
        o.e(r10, "reason");
        o.e(r11, ObricMemoryConstants.KEY_SESSION_ID);
        if (f24730c == true) goto L5;
        return;
    L5:
        f24731d = r9;
        f24732e = r10;
        f24729b = true;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L13;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L11
        r2.a(r9, r10, r11, r12, r13);     // Catch: Throwable -> L11
        n.f(x.f38692a);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        n.a r3 = n.f38560a;
        n.f(d.o.a(th));
        goto L7
    L13:
        f24730c = false;
    }

    public final void a(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        g.add(r1);
    }

    public final void b(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        g.remove(r1);
    }
}
