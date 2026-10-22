package com.bytedance.safetyguard.lxc.internal.service;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyAttachRequestParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ClientRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f11012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.a.e f11013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f11014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<IBinder, a> f11015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile d.h.a.q<? super IBinder, ? super Set<String>, ? super Set<String>, d.x> f11016e;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClientRegistry.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.b<Set<? extends com.bytedance.safetyguard.lxc.internal.service.e>, d.x> {
        AnonymousClass1(Object r8) {
            super(1, r8, g.class, "onSessionAttachmentsRemoved", "onSessionAttachmentsRemoved(Ljava/util/Set;)V", 0);
        }

        public final void a(Set<com.bytedance.safetyguard.lxc.internal.service.e> r3) {
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            g.a((g) ZeusTransformUtils.preCheckCast(this.receiver, g.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Set<? extends com.bytedance.safetyguard.lxc.internal.service.e> r3) {
            a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ClientRegistry.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f11017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IBinder.DeathRecipient f11019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final LinkedHashSet<com.bytedance.safetyguard.lxc.internal.service.e> f11020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final LinkedHashSet<String> f11021e;
        private final LinkedHashSet<String> f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11017a, r6.f11017a) == true) goto L12;
            return false;
        L12:
            if (this.f11018b == r6.f11018b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11019c, r6.f11019c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11020d, r6.f11020d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11021e, r6.f11021e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f11017a.hashCode() * 31) + Integer.hashCode(this.f11018b)) * 31) + this.f11019c.hashCode()) * 31) + this.f11020d.hashCode()) * 31) + this.f11021e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "ClientRecord(clientToken=" + this.f11017a + ", callerUid=" + this.f11018b + ", deathRecipient=" + this.f11019c + ", proxyAttachments=" + this.f11020d + ", sidecarOperations=" + this.f11021e + ", sidecarSessions=" + this.f + ')';
        }

        public a(IBinder r3, int r4, IBinder.DeathRecipient r5, LinkedHashSet<com.bytedance.safetyguard.lxc.internal.service.e> r6, LinkedHashSet<String> r7, LinkedHashSet<String> r8) {
            IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r10 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r9, "clientToken");
            d.h.b.o.e(r10, "deathRecipient");
            d.h.b.o.e(r6, "proxyAttachments");
            d.h.b.o.e(r7, "sidecarOperations");
            d.h.b.o.e(r8, "sidecarSessions");
            this.f11017a = r9;
            this.f11018b = r4;
            this.f11019c = r10;
            this.f11020d = r6;
            this.f11021e = r7;
            this.f = r8;
        }

        public final IBinder a() {
            return this.f11017a;
        }

        public final int b() {
            return this.f11018b;
        }

        public final IBinder.DeathRecipient c() {
            return this.f11019c;
        }

        public /* synthetic */ a(IBinder r10, int r11, IBinder.DeathRecipient r12, LinkedHashSet r13, LinkedHashSet r14, LinkedHashSet r15, int r16, d.h.b.h r17) {
            IBinder r3 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r5 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r12, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            if ((r16 & 8) == 0) goto L5;
            LinkedHashSet r6 = new LinkedHashSet();
        L7:
            if ((r16 & 16) == 0) goto L9;
            LinkedHashSet r7 = new LinkedHashSet();
        L11:
            if ((r16 & 32) == 0) goto L13;
            LinkedHashSet r8 = new LinkedHashSet();
        L14:
            this(r3, r11, r5, r6, r7, r8);
            return;
        L13:
            r8 = r15;
            goto L14
        L9:
            r7 = r14;
            goto L11
        L5:
            r6 = r13;
            goto L7
        }

        public final LinkedHashSet<com.bytedance.safetyguard.lxc.internal.service.e> d() {
            return this.f11020d;
        }

        public final LinkedHashSet<String> e() {
            return this.f11021e;
        }

        public final LinkedHashSet<String> f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: ClientRegistry.kt */
    static final class b extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f11023b;

        b(int r1, i r2) {
            this.f11022a = r1;
            this.f11023b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=client_registry event=session_attachments_removed outcome=success removed=" + this.f11022a + " remainingClients=" + this.f11023b.a() + " remainingAttachments=" + this.f11023b.b();
        }
    }

    /* JADX INFO: compiled from: ClientRegistry.kt */
    static final class c extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11024a;

        c(String r1) {
            this.f11024a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=client_registry event=sidecar_resources_removed outcome=failed reason=" + this.f11024a;
        }
    }

    /* JADX INFO: compiled from: ClientRegistry.kt */
    static final class d extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f11026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f11027c;

        d(String r1, a r2, i r3) {
            this.f11025a = r1;
            this.f11026b = r2;
            this.f11027c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=client_registry event=client_released outcome=success reason=" + this.f11025a + " proxyAttachments=" + this.f11026b.d().size() + " sidecarOperations=" + this.f11026b.e().size() + " sidecarSessions=" + this.f11026b.f().size() + " remainingClients=" + this.f11027c.a() + " remainingAttachments=" + this.f11027c.b();
        }
    }

    /* JADX INFO: compiled from: ClientRegistry.kt */
    static final class e extends d.h.b.p implements d.h.a.q<IBinder, Set<? extends String>, Set<? extends String>, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f11028a = null;

        static {
            f11028a = new e();
        }

        e() {
            super(3);
        }

        public final void a(IBinder r2, Set<String> r3, Set<String> r4) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "<anonymous parameter 0>");
            d.h.b.o.e(r5, "<anonymous parameter 1>");
            d.h.b.o.e(r6, "<anonymous parameter 2>");
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(IBinder r3, Set<? extends String> r4, Set<? extends String> r5) {
            a((IBinder) ZeusTransformUtils.preCheckCast(r3, IBinder.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    public static /* synthetic */ void lambda$4i3AkCNHF1Ya5pp84nptMrfYMv0(g r0, IBinder r1) {
        a(r0, r1);
    }

    public g(x r3, com.bytedance.safetyguard.lxc.internal.a.e r4) {
        com.bytedance.safetyguard.lxc.internal.a.e r5 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "proxySessions");
        d.h.b.o.e(r5, "logger");
        this.f11012a = r3;
        this.f11013b = r5;
        this.f11014c = new Object();
        this.f11015d = new LinkedHashMap();
        this.f11016e = (d.h.a.q) ZeusTransformUtils.preCheckCast(e.f11028a, d.h.a.q.class, "com.obric.aiagent.plugin");
        r3.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(g r2, Set r3) {
        r2.a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
    }

    public final void a(d.h.a.q<? super IBinder, ? super Set<String>, ? super Set<String>, d.x> r3) {
        d.h.a.q<? super IBinder, ? super Set<String>, ? super Set<String>, d.x> r4 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.f11016e = r4;
    }

    public final q a(int r9, IBinder r10, s r11, ProxyAttachRequestParcel r12, ParcelFileDescriptor r13, IProxyClientCallback r14, IOutboundPolicyCallback r15) {
        IBinder r16 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.aiagent.plugin");
        IProxyClientCallback r6 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r14, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        IOutboundPolicyCallback r7 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r15, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "clientToken");
        d.h.b.o.e(r11, "fdKey");
        d.h.b.o.e(r12, Ext.KEY_REQUEST);
        d.h.b.o.e(r13, "receivedFd");
        d.h.b.o.e(r6, "callback");
        com.bytedance.safetyguard.lxc.internal.service.e r17 = new com.bytedance.safetyguard.lxc.internal.service.e(r16, r12.getAttachmentId());
        Object r18 = this.f11014c;
        monitor-enter(r18);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r16), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31 Exception -> L33
        if (r0 != null) goto L7;
        r0 = a(r16, r9);     // Catch: Throwable -> L31 Exception -> L33
    L7:
        a r19 = r0;
        d.h.b.o.a(r19);     // Catch: Throwable -> L31
        if (r19.b() != r9) goto L29;
        boolean r20 = r19.d().contains(r17);     // Catch: Throwable -> L31
        if (r20 == false) goto L13;
    L40:
        q r110 = this.f11012a.a(r17, r11, r12.getSessionId(), r12.getConfig(), r13, r6, r7);     // Catch: Exception -> L26 Throwable -> L31
        if (r20 == false) goto L20;
    L22:
        if (r20 == true) goto L24;
        a(r19);     // Catch: Throwable -> L31
    L24:
        monitor-exit(r18);
        return r110;
    L20:
        if (ZeusTransformUtils.instanceOf(r110, q.a.class) == false) goto L22;
        r19.d().add(r17);     // Catch: Throwable -> L31
        goto L24
    L26:
        e = move-exception;
        h.a(r13);     // Catch: Throwable -> L31
        a(r19);     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L13:
        if (r19.d().size() < 128) goto L40;
        h.a(r13);     // Catch: Throwable -> L31
        a(r19);     // Catch: Throwable -> L31
        throw new com.bytedance.safetyguard.lxc.internal.ipc.e(3, "too many proxy attachments for client");     // Catch: Throwable -> L31
    L29:
        h.a(r13);     // Catch: Throwable -> L31
        throw new SecurityException("clientToken cannot be reused by another UID");     // Catch: Throwable -> L31
    L33:
        e = move-exception;
        h.a(r13);     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final boolean a(int r5, IBinder r6, String r7) {
        IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "clientToken");
        d.h.b.o.e(r7, "operationId");
        Object r0 = this.f11014c;
        monitor-enter(r0);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r8), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r1 != null) goto L7;
        r1 = a(r8, r5);     // Catch: Throwable -> L20
    L7:
        d.h.b.o.a(r1);     // Catch: Throwable -> L20
        a(r1, r5);     // Catch: Throwable -> L20
        if (r1.e().contains(r7) == false) goto L13;
        monitor-exit(r0);
        return false;
    L13:
        if (r1.e().size() >= 32) goto L18;
        r1.e().add(r7);     // Catch: Throwable -> L20
        monitor-exit(r0);
        return true;
    L18:
        a(r1);     // Catch: Throwable -> L20
        throw new com.bytedance.safetyguard.lxc.internal.ipc.e(3, "too many sidecar operations for client");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean a(IBinder r4, String r5, String r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "clientToken");
        d.h.b.o.e(r5, "operationId");
        Object r0 = this.f11014c;
        monitor-enter(r0);
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r7), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        boolean r1 = false;
        if (r8 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        d.h.b.o.a(r8);     // Catch: Throwable -> L25
        if (r8.e().remove(r5) == true) goto L13;
        monitor-exit(r0);
        return false;
    L13:
        if (r6 != null) goto L15;
    L17:
        if (r6 == null) goto L19;
        r8.f().add(r6);     // Catch: Throwable -> L25
    L19:
        r1 = true;
    L20:
        if (r1 == false) goto L22;
        if (r6 == null) goto L22;
    L23:
        monitor-exit(r0);
        return r1;
    L22:
        a(r8);     // Catch: Throwable -> L25
        goto L23
    L15:
        if (r8.f().size() < 128) goto L17;
    L25:
        th = move-exception;
        throw th;
    }

    public final boolean a(IBinder r4, String r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "clientToken");
        d.h.b.o.e(r5, "operationId");
        Object r0 = this.f11014c;
        monitor-enter(r0);
        a r7 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r7 == null) goto L7;
        d.h.b.o.a(r7);     // Catch: Throwable -> L14
        boolean r8 = r7.e().remove(r5);     // Catch: Throwable -> L14
        if (r8 == false) goto L12;
        a(r7);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r8;
    L7:
        monitor-exit(r0);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean b(IBinder r3, String r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "clientToken");
        d.h.b.o.e(r4, "operationId");
        Object r0 = this.f11014c;
        monitor-enter(r0);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r5), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        boolean r6 = true;
        if (r2 == null) goto L11;
        LinkedHashSet<String> r7 = r2.e();     // Catch: Throwable -> L14
        if (r7 == null) goto L11;
        if (r7.contains(r4) != true) goto L11;
    L12:
        monitor-exit(r0);
        return r6;
    L11:
        r6 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean c(IBinder r4, String r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "clientToken");
        d.h.b.o.e(r5, ObricMemoryConstants.KEY_SESSION_ID);
        Object r0 = this.f11014c;
        monitor-enter(r0);
        a r7 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r7 == null) goto L7;
        d.h.b.o.a(r7);     // Catch: Throwable -> L14
        boolean r8 = r7.f().remove(r5);     // Catch: Throwable -> L14
        if (r8 == false) goto L12;
        a(r7);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r8;
    L7:
        monitor-exit(r0);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public final void d(IBinder r4, String r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "clientToken");
        d.h.b.o.e(r5, "attachmentId");
        com.bytedance.safetyguard.lxc.internal.service.e r0 = new com.bytedance.safetyguard.lxc.internal.service.e(r6, r5);
        Object r7 = this.f11014c;
        monitor-enter(r7);
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r8 != null) goto L7;
        boolean r9 = false;
    L11:
        monitor-exit(r7);
        if (r9 == false) goto L20;
        this.f11012a.a(r0);
        return;
    L20:
        return;
    L7:
        d.h.b.o.a(r8);     // Catch: Throwable -> L15
        boolean r1 = r8.d().remove(r0);     // Catch: Throwable -> L15
        if (r1 == false) goto L10;
        a(r8);     // Catch: Throwable -> L15
    L10:
        r9 = r1;
    L15:
        th = move-exception;
        throw th;
    }

    public final void a(IBinder r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "clientToken");
        a(r4, true, "explicit_close");
    }

    public final void b(IBinder r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "clientToken");
        a(r4, false, "binder_died");
    }

    public final i a() {
        Object r0 = this.f11014c;
        monitor-enter(r0);
        int r1 = this.f11015d.size();     // Catch: Throwable -> L19
        Collection<a> r2 = this.f11015d.values();     // Catch: Throwable -> L19
        d.h.b.o.c(r2, "<get-values>(...)");     // Catch: Throwable -> L19
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L19
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r3.hasNext() == false) goto L8;
        r5 = r5 + ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin")).d().size();     // Catch: Throwable -> L19
        goto L6
    L8:
        Collection<a> r6 = this.f11015d.values();     // Catch: Throwable -> L19
        d.h.b.o.c(r6, "<get-values>(...)");     // Catch: Throwable -> L19
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L19
        int r8 = 0;
    L10:
        if (r7.hasNext() == false) goto L12;
        r8 = r8 + ((a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.aiagent.plugin")).e().size();     // Catch: Throwable -> L19
        goto L10
    L12:
        Collection<a> r9 = this.f11015d.values();     // Catch: Throwable -> L19
        d.h.b.o.c(r9, "<get-values>(...)");     // Catch: Throwable -> L19
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L19
    L14:
        if (r10.hasNext() == false) goto L16;
        r4 = r4 + ((a) ZeusTransformUtils.preCheckCast(r10.next(), a.class, "com.obric.aiagent.plugin")).f().size();     // Catch: Throwable -> L19
        goto L14
    L16:
        i r11 = new i(r1, r5, r8, r4);     // Catch: Throwable -> L19
        monitor-exit(r0);
        return r11;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Object r1 = this.f11014c;
        monitor-enter(r1);
        Collection<a> r2 = this.f11015d.values();     // Catch: Throwable -> L21
        d.h.b.o.c(r2, "<get-values>(...)");     // Catch: Throwable -> L21
        List r3 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        this.f11015d.clear();     // Catch: Throwable -> L21
        monitor-exit(r1);
        LinkedHashSet r4 = new LinkedHashSet();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L19;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin");
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L12
        g r8 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        d.n.f(Boolean.valueOf(r6.a().unlinkToDeath(r6.c(), 0)));     // Catch: Throwable -> L12
    L14:
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r6.d(), Collection.class, "com.obric.aiagent.plugin"));
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L17
        ((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin")).f11016e.invoke(r6.a(), d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r6.e(), Iterable.class, "com.obric.aiagent.plugin")), d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r6.f(), Iterable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L17
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L12:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L14
    L19:
        this.f11012a.a((Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"));
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private final a a(IBinder r12, int r13) {
        final IBinder r14 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r12, IBinder.class, "com.obric.aiagent.plugin");
        IBinder.DeathRecipient r5 = new $$Lambda$g$4i3AkCNHF1Ya5pp84nptMrfYMv0(this, r14);
        r14.linkToDeath(r5, 0);     // Catch: RemoteException -> L6
        a r0 = new a(r14, r13, r5, null, null, null, 56, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.f11015d, Map.class, "com.obric.aiagent.plugin")).put(r14, r0);
        return r0;
    L6:
        e = move-exception;
        throw new SecurityException("clientToken is already dead", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private static final void a(g r2, IBinder r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "this$0");
        d.h.b.o.e(r4, "$clientToken");
        r2.b(r4);
    }

    private final void a(IBinder r6, boolean r7, String r8) {
        IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
        Object r1 = this.f11014c;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.remove(r9), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        monitor-exit(r1);
        if (r2 != null) goto L8;
        return;
    L8:
        if (r7 == true) goto L26;
    L13:
        this.f11012a.a((Set) ZeusTransformUtils.preCheckCast(r2.d(), Set.class, "com.obric.aiagent.plugin"));
        d.n.a r10 = d.n.f38560a;     // Catch: Throwable -> L16
        ((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin")).f11016e.invoke(r9, d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r2.e(), Iterable.class, "com.obric.aiagent.plugin")), d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r2.f(), Iterable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L16
        Object r11 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L16
    L18:
        Throwable r12 = d.n.c(r11);
        if (r12 == null) goto L21;
        this.f11013b.a("ClientRegistry", r12, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L21:
        i r13 = a();
        this.f11013b.b("ClientRegistry", (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r8, r2, r13), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L18
    L26:
        d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L11
        g r16 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        d.n.f(Boolean.valueOf(r9.unlinkToDeath(r2.c(), 0)));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L23:
        th = move-exception;
        throw th;
    }

    private final void a(Set<com.bytedance.safetyguard.lxc.internal.service.e> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        Object r0 = this.f11014c;
        monitor-enter(r0);
        LinkedHashSet r1 = new LinkedHashSet();     // Catch: Throwable -> L21
        int r2 = 0;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L21
    L6:
        if (r10.hasNext() == false) goto L13;
        com.bytedance.safetyguard.lxc.internal.service.e r3 = (com.bytedance.safetyguard.lxc.internal.service.e) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.safetyguard.lxc.internal.service.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.f11015d.get(r3.a()), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L6;
        d.h.b.o.a(r4);     // Catch: Throwable -> L21
        if (r4.d().remove(r3) == false) goto L6;
        r2 = r2 + 1;     // Catch: Throwable -> L21
        r1.add(r4);     // Catch: Throwable -> L21
        goto L6
    L13:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L21
    L14:
        if (r11.hasNext() == false) goto L18;
        a((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        goto L14
    L18:
        monitor-exit(r0);
        i r12 = a();
        this.f11013b.b("ClientRegistry", (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r2, r12), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private final void a(a r1, int r2) {
        if (r1.b() != r2) goto L6;
        return;
    L6:
        throw new SecurityException("clientToken cannot be reused by another UID");
    }

    private final void a(a r4) {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.d(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
        return;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.e(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
        return;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.f(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L10;
        return;
    L10:
        if (this.f11015d.remove(r4.a(), r4) == false) goto L20;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L13
        g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        d.n.f(Boolean.valueOf(r4.a().unlinkToDeath(r4.c(), 0)));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    }
}
