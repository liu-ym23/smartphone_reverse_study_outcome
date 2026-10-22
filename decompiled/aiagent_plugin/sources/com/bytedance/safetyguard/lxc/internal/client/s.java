package com.bytedance.safetyguard.lxc.internal.client;

import android.os.ParcelFileDescriptor;
import com.bytedance.safetyguard.lxc.api.ProxySessionOptions;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyConfig;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyAttachRequestParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: RemoteSafetyGuardProxyRuntime.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s implements SafetyGuardProxyRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProxyServiceConnector f10023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SafetyGuardProxyConfig f10024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f10025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<String, r> f10026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.w<x> f10027e;
    private final i f;
    private a g;

    /* JADX INFO: compiled from: RemoteSafetyGuardProxyRuntime.kt */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10028a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f10029b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f10030c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f10031d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f10032e = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f10028a, f10029b, f10030c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f10031d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f10028a = new a("OPEN", 0);
            f10029b = new a("CLOSING", 1);
            f10030c = new a("CLOSED", 2);
            a[] r0 = a();
            f10031d = r0;
            f10032e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardProxyRuntime.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10033a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f10028a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[a.f10029b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[a.f10030c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10033a = r0;
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardProxyRuntime.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<r, x> {
        c(Object r8) {
            super(1, r8, s.class, "onAttachmentReleased", "onAttachmentReleased(Lcom/bytedance/safetyguard/lxc/internal/client/RemoteProxySessionAttachment;)V", 0);
        }

        public final void a(r r3) {
            d.h.b.o.e(r3, "p0");
            s.a((s) ZeusTransformUtils.preCheckCast(this.receiver, s.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(r r3) {
            a((r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public s(ProxyServiceConnector r3, SafetyGuardProxyConfig r4, com.bytedance.safetyguard.lxc.internal.a.e r5) {
        com.bytedance.safetyguard.lxc.internal.a.e r6 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "connector");
        d.h.b.o.e(r4, "config");
        d.h.b.o.e(r6, "logger");
        this.f10023a = r3;
        this.f10024b = r4;
        this.f10025c = new Object();
        this.f10026d = new LinkedHashMap();
        this.f10027e = y.a(null, 1, null);
        this.f = new i(r4.getEventObserver(), r6);
        this.g = a.f10028a;
    }

    public static final /* synthetic */ void a(s r0, r r1) {
        r0.a(r1);
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime
    public boolean isAvailable() {
        Object r0 = this.f10025c;
        monitor-enter(r0);
        if (this.g != a.f10028a) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime
    /* JADX INFO: renamed from: startSession-gIAlu-s */
    public Object mo37startSessiongIAlus(ParcelFileDescriptor r13, ProxySessionOptions r14) {
        d.h.b.o.e(r13, "proxyFd");
        d.h.b.o.e(r14, "options");
        String r15 = r14.getSessionName();
        if (r15 != null) goto L91;
        r15 = UUID.randomUUID().toString();
        d.h.b.o.c(r15, "toString(...)");
    L91:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L7
        s r2 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(ObricMemoryConstants.KEY_SESSION_ID, r15);     // Catch: Throwable -> L7
        Object r3 = d.n.f(l.a(r2.f10024b));     // Catch: Throwable -> L7
    L9:
        Throwable r4 = d.n.c(r3);
        if (r4 != null) goto L93;
        ProxyServiceConfigParcel r5 = (ProxyServiceConfigParcel) ZeusTransformUtils.preCheckCast(r3, ProxyServiceConfigParcel.class, "com.obric.aiagent.plugin");
        Object r6 = this.f10025c;
        monitor-enter(r6);
    L72:
        th = move-exception;
        throw th;
    L14:
        if (this.g == a.f10028a) goto L23;
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L17
        s r17 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        r13.close();     // Catch: Throwable -> L17
        d.n.f(x.f38692a);     // Catch: Throwable -> L17
    L19:
        d.n.a r18 = d.n.f38560a;     // Catch: Throwable -> L72
        Object r12 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("SafetyGuard proxy runtime is " + this.g), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L72
        monitor-exit(r6);
        return r12;
    L17:
        th = move-exception;
        d.n.a r19 = d.n.f38560a;     // Catch: Throwable -> L72
        d.n.f(d.o.a(th));     // Catch: Throwable -> L72
        goto L19
    L23:
        if (this.f10026d.containsKey(r15) == true) goto L85;
        x r7 = x.f38692a;     // Catch: Throwable -> L72
        monitor-exit(r6);
        Object r110 = this.f10023a.a(r13);
        Throwable r8 = d.n.c(r110);
        if (r8 != null) goto L70;
        ParcelFileDescriptor r111 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r110, ParcelFileDescriptor.class, "com.obric.aiagent.plugin");
        String r9 = UUID.randomUUID().toString();
        d.h.b.o.c(r9, "toString(...)");
        r r10 = new r(r15, r9, this.f10023a, this.f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        Object r11 = this.f10025c;
        monitor-enter(r11);
    L67:
        th = move-exception;
        throw th;
    L38:
        if (this.g == a.f10028a) goto L40;
    L81:
        d.n.a r20 = d.n.f38560a;     // Catch: Throwable -> L62
        s r112 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
        r111.close();     // Catch: Throwable -> L62
        d.n.f(x.f38692a);     // Catch: Throwable -> L62
    L64:
        d.n.a r113 = d.n.f38560a;     // Catch: Throwable -> L67
        Object r114 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("proxy session rejected: " + r15), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L67
        monitor-exit(r11);
        return r114;
    L62:
        th = move-exception;
        d.n.a r115 = d.n.f38560a;     // Catch: Throwable -> L67
        d.n.f(d.o.a(th));     // Catch: Throwable -> L67
        goto L64
    L40:
        if (this.f10026d.putIfAbsent(r15, r10) != null) goto L81;
        x r0 = x.f38692a;     // Catch: Throwable -> L67
        monitor-exit(r11);
        Object r116 = this.f10023a.a(r10, new ProxyAttachRequestParcel(0, r9, r15, r5, 1, null), r111, l.b(this.f10024b));
        if (d.n.b(r116) == false) goto L87;
        r10.c();
        d.n.a r117 = d.n.f38560a;
        Throwable r118 = d.n.c(r116);
        if (r118 == null) goto L51;
        return d.n.f(d.o.a(r118));
    L51:
        throw new IllegalArgumentException("Required value was null.".toString());
    L87:
        r10.b();     // Catch: Throwable -> L57
        ProxyServiceConnector r119 = this.f10023a;     // Catch: Throwable -> L57
        d.o.a(r116);     // Catch: Throwable -> L57
        if (r119.a((j) ZeusTransformUtils.preCheckCast(r116, j.class, "com.obric.aiagent.plugin")) == true) goto L55;
        this.f10023a.a(r9);
    L55:
        d.n.a r120 = d.n.f38560a;
        return d.n.f(r10);
    L57:
        th = move-exception;
        this.f10023a.a(r9);
        throw th;
    L70:
        d.n.a r121 = d.n.f38560a;
        return d.n.f(d.o.a(r8));
    L85:
        d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L26
        s r122 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        r13.close();     // Catch: Throwable -> L26
        d.n.f(x.f38692a);     // Catch: Throwable -> L26
    L28:
        d.n.a r123 = d.n.f38560a;     // Catch: Throwable -> L72
        Object r124 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("proxy session already exists: " + r15), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L72
        monitor-exit(r6);
        return r124;
    L26:
        th = move-exception;
        d.n.a r125 = d.n.f38560a;     // Catch: Throwable -> L72
        d.n.f(d.o.a(th));     // Catch: Throwable -> L72
        goto L28
    L93:
        d.n.a r126 = d.n.f38560a;     // Catch: Throwable -> L77
        s r127 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77
        r13.close();     // Catch: Throwable -> L77
        d.n.f(x.f38692a);     // Catch: Throwable -> L77
    L79:
        d.n.a r128 = d.n.f38560a;
        return d.n.f(d.o.a(r4));
    L77:
        th = move-exception;
        d.n.a r129 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L7:
        th = move-exception;
        d.n.a r22 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L9
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime
    /* JADX INFO: renamed from: close-d1pmJ48 */
    public Object mo36closed1pmJ48() {
        Object r0 = this.f10025c;
        monitor-enter(r0);
        a r1 = this.g;     // Catch: Throwable -> L22
        int r2 = b.f10033a[r1.ordinal()];     // Catch: Throwable -> L22
        if (r2 != 1) goto L7;
        this.g = a.f10029b;     // Catch: Throwable -> L22
        Collection<r> r3 = this.f10026d.values();     // Catch: Throwable -> L22
        d.h.b.o.c(r3, "<get-values>(...)");     // Catch: Throwable -> L22
        List r4 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L15:
        monitor-exit(r0);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        ((r) ZeusTransformUtils.preCheckCast(r5.next(), r.class, "com.obric.aiagent.plugin")).mo32closed1pmJ48();
        goto L18
    L20:
        a();
        d.n.a r6 = d.n.f38560a;
        return d.n.f(x.f38692a);
    L7:
        if (r2 != 2) goto L9;
    L13:
        r4 = d.a.p.b();     // Catch: Throwable -> L22
        goto L15
    L9:
        if (r2 == 3) goto L13;
        throw new d.k();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime
    public Object awaitClosed(d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f10027e.a(r4);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    private final void a(r r4) {
        Object r0 = this.f10025c;
        monitor-enter(r0);
        this.f10026d.remove(r4.getSessionId(), r4);     // Catch: Throwable -> L8
        monitor-exit(r0);
        a();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void a() {
        Object r0 = this.f10025c;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.g == a.f10029b) goto L7;
    L10:
        boolean r1 = false;
    L11:
        monitor-exit(r0);
        if (r1 == false) goto L20;
        this.f10027e.a(x.f38692a);
        return;
    L20:
        return;
    L7:
        if (this.f10026d.isEmpty() == false) goto L10;
        this.g = a.f10030c;     // Catch: Throwable -> L15
        r1 = true;
        goto L11
    }
}
