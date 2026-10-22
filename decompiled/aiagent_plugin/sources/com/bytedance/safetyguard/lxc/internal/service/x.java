package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionActivationResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionContextTokenParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionFinishResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyReadyParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxySessionResultParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: ProxySessionRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ad f11059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.d.p f11060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.a.e f11061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f11062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<com.bytedance.safetyguard.lxc.internal.service.s, d> f11063e;
    private final LinkedHashMap<com.bytedance.safetyguard.lxc.internal.service.e, b> f;
    private volatile d.h.a.b<? super Set<com.bytedance.safetyguard.lxc.internal.service.e>, d.x> g;

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f11064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.d.a f11065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11066c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11064a, r6.f11064a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11065b, r6.f11065b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11066c, r6.f11066c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11064a.hashCode() * 31) + this.f11065b.hashCode()) * 31) + this.f11066c.hashCode();
        }

        public String toString() {
            return "ActionInvocation(record=" + this.f11064a + ", controller=" + this.f11065b + ", ownerId=" + this.f11066c + ')';
        }

        public a(b r2, com.bytedance.safetyguard.lxc.internal.d.a r3, String r4) {
            d.h.b.o.e(r2, "record");
            d.h.b.o.e(r3, "controller");
            d.h.b.o.e(r4, "ownerId");
            this.f11064a = r2;
            this.f11065b = r3;
            this.f11066c = r4;
        }

        public final b a() {
            return this.f11064a;
        }

        public final com.bytedance.safetyguard.lxc.internal.d.a b() {
            return this.f11065b;
        }

        public final String c() {
            return this.f11066c;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.service.e f11067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f11069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private IProxyClientCallback f11070d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IOutboundPolicyCallback f11071e;
        private final boolean f;
        private final String g;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11067a, r6.f11067a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11068b, r6.f11068b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11069c, r6.f11069c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11070d, r6.f11070d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11071e, r6.f11071e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f11067a.hashCode() * 31) + this.f11068b.hashCode()) * 31) + this.f11069c.hashCode()) * 31) + this.f11070d.hashCode()) * 31;
            IOutboundPolicyCallback r1 = this.f11071e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + Boolean.hashCode(this.f)) * 31) + this.g.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "AttachmentRecord(key=" + this.f11067a + ", sessionId=" + this.f11068b + ", entry=" + this.f11069c + ", callback=" + this.f11070d + ", policyCallback=" + this.f11071e + ", reusedSession=" + this.f + ", actionOwnerId=" + this.g + ')';
        }

        public b(com.bytedance.safetyguard.lxc.internal.service.e r3, String r4, d r5, IProxyClientCallback r6, IOutboundPolicyCallback r7, boolean r8, String r9) {
            IProxyClientCallback r10 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r6, IProxyClientCallback.class, "com.obric.aiagent.plugin");
            IOutboundPolicyCallback r11 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r7, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "key");
            d.h.b.o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
            d.h.b.o.e(r5, "entry");
            d.h.b.o.e(r10, "callback");
            d.h.b.o.e(r9, "actionOwnerId");
            this.f11067a = r3;
            this.f11068b = r4;
            this.f11069c = r5;
            this.f11070d = r10;
            this.f11071e = r11;
            this.f = r8;
            this.g = r9;
        }

        public final com.bytedance.safetyguard.lxc.internal.service.e a() {
            return this.f11067a;
        }

        public final String b() {
            return this.f11068b;
        }

        public final d c() {
            return this.f11069c;
        }

        public final void a(IProxyClientCallback r3) {
            IProxyClientCallback r4 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r3, IProxyClientCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "<set-?>");
            this.f11070d = r4;
        }

        public final IProxyClientCallback d() {
            return this.f11070d;
        }

        public final void a(IOutboundPolicyCallback r3) {
            this.f11071e = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        }

        public final IOutboundPolicyCallback e() {
            return this.f11071e;
        }

        public final boolean f() {
            return this.f;
        }

        public /* synthetic */ b(com.bytedance.safetyguard.lxc.internal.service.e r11, String r12, d r13, IProxyClientCallback r14, IOutboundPolicyCallback r15, boolean r16, String r17, int r18, d.h.b.h r19) {
            IProxyClientCallback r6 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r14, IProxyClientCallback.class, "com.obric.aiagent.plugin");
            IOutboundPolicyCallback r7 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r15, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
            if ((r18 & 64) == 0) goto L5;
            String r0 = UUID.randomUUID().toString();
            d.h.b.o.c(r0, "toString(...)");
            String r9 = r0;
        L6:
            this(r11, r12, r13, r6, r7, r16, r9);
            return;
        L5:
            r9 = r17;
            goto L6
        }

        public final String g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IProxyClientCallback f11072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProxyReadyParcel f11074c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11072a, r6.f11072a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11073b, r6.f11073b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11074c, r6.f11074c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11072a.hashCode() * 31) + this.f11073b.hashCode()) * 31) + this.f11074c.hashCode();
        }

        public String toString() {
            return "ReadyNotification(callback=" + this.f11072a + ", attachmentId=" + this.f11073b + ", ready=" + this.f11074c + ')';
        }

        public c(IProxyClientCallback r3, String r4, ProxyReadyParcel r5) {
            IProxyClientCallback r6 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r3, IProxyClientCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "callback");
            d.h.b.o.e(r4, "attachmentId");
            d.h.b.o.e(r5, "ready");
            this.f11072a = r6;
            this.f11073b = r4;
            this.f11074c = r5;
        }

        public final IProxyClientCallback a() {
            return this.f11072a;
        }

        public final String b() {
            return this.f11073b;
        }

        public final ProxyReadyParcel c() {
            return this.f11074c;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.service.s f11075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProxyServiceConfigParcel f11078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.service.r f11079e;
        private final ParcelFileDescriptor f;
        private final ab g;
        private final com.bytedance.safetyguard.lxc.internal.d.a h;
        private ah i;
        private boolean j;
        private boolean k;
        private ac l;
        private ProxyReadyParcel m;
        private final LinkedHashMap<com.bytedance.safetyguard.lxc.internal.service.e, b> n;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11075a, r6.f11075a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11076b, r6.f11076b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11077c, r6.f11077c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11078d, r6.f11078d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11079e, r6.f11079e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (d.h.b.o.a(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (d.h.b.o.a(this.n, r6.n) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((((((((((((this.f11075a.hashCode() * 31) + this.f11076b.hashCode()) * 31) + this.f11077c.hashCode()) * 31) + this.f11078d.hashCode()) * 31) + this.f11079e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31;
            ac r1 = this.l;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ProxyReadyParcel r5 = this.m;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.n.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("SharedProxySession(key=").append(this.f11075a).append(", endpointRef=").append(this.f11076b).append(", sharedRef=").append(this.f11077c).append(", config=").append(this.f11078d).append(", fingerprint=").append(this.f11079e).append(", sessionFd=").append(this.f).append(", businessPolicy=").append(this.g).append(", actionController=").append(this.h).append(", state=").append(this.i).append(", factoryInitializationStarted=").append(this.j).append(", terminationFinalized=").append(this.k).append(", session=");
            r0.append(this.l).append(", ready=").append(this.m).append(", attachments=").append(this.n).append(')');
            return r0.toString();
        }

        public d(com.bytedance.safetyguard.lxc.internal.service.s r15, String r16, String r17, ProxyServiceConfigParcel r18, com.bytedance.safetyguard.lxc.internal.service.r r19, ParcelFileDescriptor r20, ab r21, com.bytedance.safetyguard.lxc.internal.d.a r22, ah r23, boolean r24, boolean r25, ac r26, ProxyReadyParcel r27, LinkedHashMap<com.bytedance.safetyguard.lxc.internal.service.e, b> r28) {
            ac r11 = (ac) ZeusTransformUtils.wrapperContextForParams(r26, ac.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r15, "key");
            d.h.b.o.e(r16, "endpointRef");
            d.h.b.o.e(r17, "sharedRef");
            d.h.b.o.e(r18, "config");
            d.h.b.o.e(r19, "fingerprint");
            d.h.b.o.e(r20, "sessionFd");
            d.h.b.o.e(r21, "businessPolicy");
            d.h.b.o.e(r22, "actionController");
            d.h.b.o.e(r23, "state");
            d.h.b.o.e(r28, "attachments");
            this.f11075a = r15;
            this.f11076b = r16;
            this.f11077c = r17;
            this.f11078d = r18;
            this.f11079e = r19;
            this.f = r20;
            this.g = r21;
            this.h = r22;
            this.i = r23;
            this.j = r24;
            this.k = r25;
            this.l = r11;
            this.m = r27;
            this.n = r28;
        }

        public final com.bytedance.safetyguard.lxc.internal.service.s a() {
            return this.f11075a;
        }

        public final String b() {
            return this.f11076b;
        }

        public final void a(String r2) {
            d.h.b.o.e(r2, "<set-?>");
            this.f11077c = r2;
        }

        public final String c() {
            return this.f11077c;
        }

        public final ProxyServiceConfigParcel d() {
            return this.f11078d;
        }

        public final com.bytedance.safetyguard.lxc.internal.service.r e() {
            return this.f11079e;
        }

        public final ParcelFileDescriptor f() {
            return this.f;
        }

        public final ab g() {
            return this.g;
        }

        public final com.bytedance.safetyguard.lxc.internal.d.a h() {
            return this.h;
        }

        public /* synthetic */ d(com.bytedance.safetyguard.lxc.internal.service.s r19, String r20, String r21, ProxyServiceConfigParcel r22, com.bytedance.safetyguard.lxc.internal.service.r r23, ParcelFileDescriptor r24, ab r25, com.bytedance.safetyguard.lxc.internal.d.a r26, ah r27, boolean r28, boolean r29, ac r30, ProxyReadyParcel r31, LinkedHashMap r32, int r33, d.h.b.h r34) {
            ac r1 = (ac) ZeusTransformUtils.wrapperContextForParams(r30, ac.class, "com.obric.aiagent.plugin");
            if ((r33 & 4) == 0) goto L5;
            String r6 = "pending";
        L7:
            if ((r33 & 256) == 0) goto L9;
            ah r12 = ah.f10936a;
        L11:
            if ((r33 & 512) == 0) goto L13;
            boolean r13 = false;
        L15:
            if ((r33 & 1024) == 0) goto L17;
            boolean r14 = false;
        L19:
            if ((r33 & 2048) == 0) goto L21;
            ac r15 = null;
        L23:
            if ((r33 & 4096) == 0) goto L25;
            ProxyReadyParcel r16 = null;
        L27:
            if ((r33 & 8192) == 0) goto L29;
            LinkedHashMap r17 = new LinkedHashMap();
        L30:
            this(r19, r20, r6, r22, r23, r24, r25, r26, r12, r13, r14, r15, r16, r17);
            return;
        L29:
            r17 = r32;
            goto L30
        L25:
            r16 = r31;
            goto L27
        L21:
            r15 = r1;
            goto L23
        L17:
            r14 = r29;
            goto L19
        L13:
            r13 = r28;
            goto L15
        L9:
            r12 = r27;
            goto L11
        L5:
            r6 = r21;
            goto L7
        }

        public final void a(ah r2) {
            d.h.b.o.e(r2, "<set-?>");
            this.i = r2;
        }

        public final ah i() {
            return this.i;
        }

        public final void a(boolean r1) {
            this.j = r1;
        }

        public final boolean j() {
            return this.j;
        }

        public final void b(boolean r1) {
            this.k = r1;
        }

        public final boolean k() {
            return this.k;
        }

        public final void a(ac r3) {
            this.l = (ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.aiagent.plugin");
        }

        public final ac l() {
            return this.l;
        }

        public final void a(ProxyReadyParcel r1) {
            this.m = r1;
        }

        public final ProxyReadyParcel m() {
            return this.m;
        }

        public final LinkedHashMap<com.bytedance.safetyguard.lxc.internal.service.e, b> n() {
            return this.n;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11080a = null;

        static {
            int[] r0 = new int[ah.values().length];
            r0[ah.f10936a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ah.f10937b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ah.f10938c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f11080a = r0;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class f extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f11081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<d> f11082b;

        f(x r1, d.h.b.z.f<d> r2) {
            this.f11081a = r1;
            this.f11082b = r2;
            super(0);
        }

        public final void a() {
            x r0 = this.f11081a;
            if (this.f11082b.f38504a != null) goto L5;
            d.h.b.o.c("entry");
            d r3 = null;
        L6:
            x.b(r0, r3);
            return;
        L5:
            r3 = (d) ZeusTransformUtils.preCheckCast(this.f11082b.f38504a, d.class, "com.obric.aiagent.plugin");
            goto L6
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class g extends d.h.b.p implements d.h.a.a<List<? extends IOutboundPolicyCallback>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f11083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<d> f11084b;

        g(x r1, d.h.b.z.f<d> r2) {
            this.f11083a = r1;
            this.f11084b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ List<? extends IOutboundPolicyCallback> invoke() {
            return a();
        }

        public final List<IOutboundPolicyCallback> a() {
            x r0 = this.f11083a;
            if (this.f11084b.f38504a != null) goto L5;
            d.h.b.o.c("entry");
            d r3 = null;
        L7:
            return x.a(r0, r3);
        L5:
            r3 = (d) ZeusTransformUtils.preCheckCast(this.f11084b.f38504a, d.class, "com.obric.aiagent.plugin");
            goto L7
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class h extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11085a;

        h(String r1) {
            this.f11085a = r1;
            super(0);
        }

        public final String a() {
            return this.f11085a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class i extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f11086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f11087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ProxyReadyParcel f11088c;

        i(x r1, b r2, ProxyReadyParcel r3) {
            this.f11086a = r1;
            this.f11087b = r2;
            this.f11088c = r3;
            super(0);
        }

        public final void a() {
            x.a(this.f11086a, this.f11087b, this.f11088c);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class j extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f11089a = null;

        static {
            f11089a = new j();
        }

        j() {
            super(0);
        }

        public final void a() {
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class k extends d.h.b.p implements d.h.a.b<Set<? extends com.bytedance.safetyguard.lxc.internal.service.e>, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f11090a = null;

        static {
            f11090a = new k();
        }

        k() {
            super(1);
        }

        public final void a(Set<com.bytedance.safetyguard.lxc.internal.service.e> r2) {
            d.h.b.o.e((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin"), "it");
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Set<? extends com.bytedance.safetyguard.lxc.internal.service.e> r3) {
            a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    public static final class l implements af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f11091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11092b;

        l(x r1, d r2) {
            this.f11091a = r1;
            this.f11092b = r2;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.service.af
        public void a(ProxyReadyParcel r2) {
            d.h.b.o.e(r2, "ready");
            x.a(this.f11091a, this.f11092b, r2);
        }

        @Override // com.bytedance.safetyguard.lxc.internal.service.af
        public void a(ProxySessionResultParcel r2) {
            d.h.b.o.e(r2, "result");
            x.a(this.f11091a, this.f11092b, r2);
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class m extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<b> f11094b;

        m(d r3, List<b> r4) {
            List<b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f11093a = r3;
            this.f11094b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=shared_session_running outcome=success sharedRef=" + this.f11093a.c() + " attachmentCount=" + this.f11094b.size();
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class n extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f11095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f11096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ProxyReadyParcel f11097c;

        n(x r1, b r2, ProxyReadyParcel r3) {
            this.f11095a = r1;
            this.f11096b = r2;
            this.f11097c = r3;
            super(0);
        }

        public final void a() {
            x.a(this.f11095a, this.f11096b, this.f11097c);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class o extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f11098a = null;

        static {
            f11098a = new o();
        }

        o() {
            super(0);
        }

        public final void a() {
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class p extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<List<b>> f11101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProxySessionResultParcel f11102d;

        p(d r1, String r2, d.h.b.z.f<List<b>> r3, ProxySessionResultParcel r4) {
            this.f11099a = r1;
            this.f11100b = r2;
            this.f11101c = r3;
            this.f11102d = r4;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder().append("component=proxy_registry event=session_cleanup_started outcome=pending sharedRef=").append(this.f11099a.c()).append(" trigger=").append(this.f11100b).append(" attachmentCount=");
            if (this.f11101c.f38504a != null) goto L5;
            d.h.b.o.c("records");
            List r1 = null;
        L6:
            StringBuilder r2 = r0.append(r1.size()).append(" closeReason=");
            ProxySessionResultParcel r4 = this.f11102d;
            if (r4 == null) goto L9;
            Object r5 = Integer.valueOf(r4.getCloseReason());
        L11:
            return r2.append(r5).toString();
        L9:
            r5 = OProtocolTextEffectTextView.EffectNameNone;
            goto L11
        L5:
            r1 = (List) ZeusTransformUtils.preCheckCast(this.f11101c.f38504a, List.class, "com.obric.aiagent.plugin");
            goto L6
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class q extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<List<b>> f11104b;

        q(d r1, d.h.b.z.f<List<b>> r2) {
            this.f11103a = r1;
            this.f11104b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder().append("component=proxy_registry event=attachments_removed_callback outcome=failed sharedRef=").append(this.f11103a.c()).append(" attachmentCount=");
            if (this.f11104b.f38504a != null) goto L5;
            d.h.b.o.c("records");
            List r3 = null;
        L7:
            return r0.append(r3.size()).toString();
        L5:
            r3 = (List) ZeusTransformUtils.preCheckCast(this.f11104b.f38504a, List.class, "com.obric.aiagent.plugin");
            goto L7
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class r extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f11106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f11107c;

        r(d r1, x r2, b r3) {
            this.f11105a = r1;
            this.f11106b = r2;
            this.f11107c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=terminal_callback outcome=failed sharedRef=" + this.f11105a.c() + " attachmentRef=" + x.a(this.f11106b).a(this.f11107c.a().b());
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class s extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f11108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f11111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f11112e;
        final /* synthetic */ Object f;
        final /* synthetic */ Object g;
        final /* synthetic */ Object h;
        final /* synthetic */ Object i;
        final /* synthetic */ d.m<Integer, Integer> j;
        final /* synthetic */ long k;

        s(d.h.b.z.a r1, d r2, String r3, d.h.b.z.d r4, d.h.b.z.d r5, Object r6, Object r7, Object r8, Object r9, d.m<Integer, Integer> r10, long r11) {
            this.f11108a = r1;
            this.f11109b = r2;
            this.f11110c = r3;
            this.f11111d = r4;
            this.f11112e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder();
            StringBuilder r1 = r0.append("component=proxy_registry event=session_cleanup_finished outcome=");
            if (this.f11108a.f38499a == false) goto L5;
            String r2 = "partial";
        L6:
            r1.append(r2).append(" sharedRef=").append(this.f11109b.c()).append(" trigger=").append(this.f11110c).append(" callbacksOk=").append(this.f11111d.f38502a).append(" callbacksFailed=").append(this.f11112e.f38502a).append(" sessionClose=").append(com.bytedance.safetyguard.lxc.internal.service.y.a(this.f)).append(" controllerClose=").append(com.bytedance.safetyguard.lxc.internal.service.y.a(this.g)).append(" endpointShutdown=").append(com.bytedance.safetyguard.lxc.internal.service.y.a(this.h)).append(" fdClose=").append(com.bytedance.safetyguard.lxc.internal.service.y.a(this.i)).append(" remainingSessions=").append(((Number) ZeusTransformUtils.preCheckCast(this.j.a(), Number.class, "com.obric.aiagent.plugin")).intValue()).append(" remainingAttachments=").append(((Number) ZeusTransformUtils.preCheckCast(this.j.b(), Number.class, "com.obric.aiagent.plugin")).intValue()).append(" durationMs=");
            r0.append((System.nanoTime() - this.k) / ((long) 1000000));
            return r0.toString();
        L5:
            r2 = "success";
            goto L6
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class t extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11113a;

        t(d r1) {
            this.f11113a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=action_controller_close outcome=failed sharedRef=" + this.f11113a.c();
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class u extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11114a;

        u(d r1) {
            this.f11114a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=endpoint_shutdown outcome=failed sharedRef=" + this.f11114a.c();
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class v extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11115a;

        v(d r1) {
            this.f11115a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=fd_close outcome=failed sharedRef=" + this.f11115a.c();
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class w extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11116a;

        w(d r1) {
            this.f11116a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=session_close outcome=failed sharedRef=" + this.f11116a.c();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.x$x, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class C0251x extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11117a;

        C0251x(d r1) {
            this.f11117a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=terminal_action_mapping outcome=failed sharedRef=" + this.f11117a.c();
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class y extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<List<b>> f11119b;

        y(d r1, d.h.b.z.f<List<b>> r2) {
            this.f11118a = r1;
            this.f11119b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder().append("component=proxy_registry event=terminal_action_owner outcome=missing sharedRef=").append(this.f11118a.c()).append(" attachmentCount=");
            if (this.f11119b.f38504a != null) goto L5;
            d.h.b.o.c("records");
            List r3 = null;
        L7:
            return r0.append(r3.size()).toString();
        L5:
            r3 = (List) ZeusTransformUtils.preCheckCast(this.f11119b.f38504a, List.class, "com.obric.aiagent.plugin");
            goto L7
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    static final class z extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11120a;

        z(d r1) {
            this.f11120a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_registry event=terminal_action_snapshot outcome=failed sharedRef=" + this.f11120a.c();
        }
    }

    public x(ad r3, com.bytedance.safetyguard.lxc.internal.d.p r4, com.bytedance.safetyguard.lxc.internal.a.e r5) {
        ad r6 = (ad) ZeusTransformUtils.wrapperContextForParams(r3, ad.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.p r7 = (com.bytedance.safetyguard.lxc.internal.d.p) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.d.p.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r8 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "sessionFactory");
        d.h.b.o.e(r7, "endpointTerminator");
        d.h.b.o.e(r8, "logger");
        this.f11059a = r6;
        this.f11060b = r7;
        this.f11061c = r8;
        this.f11062d = new Object();
        this.f11063e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = (d.h.a.b) ZeusTransformUtils.preCheckCast(k.f11090a, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.e a(x r0) {
        return r0.f11061c;
    }

    public static final /* synthetic */ List a(x r0, d r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ void a(x r0, b r1, ProxyReadyParcel r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(x r0, d r1, ProxyReadyParcel r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(x r0, d r1, ProxySessionResultParcel r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void b(x r0, d r1) {
        r0.a(r1);
    }

    public /* synthetic */ x(ad r2, com.bytedance.safetyguard.lxc.internal.d.p r3, com.bytedance.safetyguard.lxc.internal.a.e r4, int r5, d.h.b.h r6) {
        ad r7 = (ad) ZeusTransformUtils.wrapperContextForParams(r2, ad.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.p r8 = (com.bytedance.safetyguard.lxc.internal.d.p) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.d.p.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r9 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = com.bytedance.safetyguard.lxc.internal.d.p.f10254a.a();
    L6:
        if ((r5 & 4) == 0) goto L8;
        r9 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.a.d.f9723a, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
    L8:
        this(r7, r8, r9);
    }

    public final void a(d.h.a.b<? super Set<com.bytedance.safetyguard.lxc.internal.service.e>, d.x> r3) {
        d.h.a.b<? super Set<com.bytedance.safetyguard.lxc.internal.service.e>, d.x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.g = r4;
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [T, com.bytedance.safetyguard.lxc.internal.service.x$d] */
    public final com.bytedance.safetyguard.lxc.internal.service.q a(com.bytedance.safetyguard.lxc.internal.service.e r31, com.bytedance.safetyguard.lxc.internal.service.s r32, String r33, ProxyServiceConfigParcel r34, ParcelFileDescriptor r35, IProxyClientCallback r36, IOutboundPolicyCallback r37) {
        IProxyClientCallback r6 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r36, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        IOutboundPolicyCallback r7 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r37, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r31, "attachmentKey");
        d.h.b.o.e(r32, "fdKey");
        d.h.b.o.e(r33, "requestSessionId");
        d.h.b.o.e(r34, "config");
        d.h.b.o.e(r35, "receivedFd");
        d.h.b.o.e(r6, "callback");
        com.bytedance.safetyguard.lxc.internal.service.r r17 = com.bytedance.safetyguard.lxc.internal.service.r.f11048a.a(r34);
        Object r8 = this.f11062d;
        monitor-enter(r8);
        b r12 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r31), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
        boolean r13 = true;
        String r15 = null;
        if (r12 == null) goto L14;
        com.bytedance.safetyguard.lxc.internal.service.q r1 = a(r12, r32, r33, r17, r6, r7);     // Catch: Throwable -> L60
        if (r1 != null) goto L9;
        d.h.b.o.c("registration");     // Catch: Throwable -> L60
        com.bytedance.safetyguard.lxc.internal.service.q r2 = null;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.safetyguard.lxc.internal.service.q.a.class) == false) goto L13;
        r15 = "component=proxy_registry event=attachment_registered outcome=success sharedRef=" + r12.c().c() + " endpointRef=" + r12.c().b() + " attachmentRef=" + this.f11061c.a(r31.b()) + " reused=true idempotent=true attachmentCount=" + r12.c().n().size();     // Catch: Throwable -> L60
    L13:
        Object r16 = r8;
    L50:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L58
        monitor-exit(r16);
        if (r13 == false) goto L54;
        com.bytedance.safetyguard.lxc.internal.service.y.a(r35);
    L54:
        if (r15 == null) goto L57;
        this.f11061c.b("ProxySessionRegistry", (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r15), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L57:
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(r1, com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    L58:
        th = th;
    L62:
        monitor-exit(r16);
        throw th;
    L9:
        r2 = r1;
        goto L11
    L14:
        d r14 = (d) ZeusTransformUtils.preCheckCast(this.f11063e.get(r32), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
        if (r14 == null) goto L23;
        r1 = a(r14, r31, r33, r17, r6, r7);     // Catch: Throwable -> L60
        if (r1 != null) goto L19;
        d.h.b.o.c("registration");     // Catch: Throwable -> L60
        com.bytedance.safetyguard.lxc.internal.service.q r4 = null;
    L21:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.safetyguard.lxc.internal.service.q.a.class) == false) goto L13;
        r15 = "component=proxy_registry event=attachment_registered outcome=success sharedRef=" + r14.c() + " endpointRef=" + r14.b() + " attachmentRef=" + this.f11061c.a(r31.b()) + " reused=true idempotent=false attachmentCount=" + r14.n().size();     // Catch: Throwable -> L60
        goto L13
    L19:
        r4 = r1;
        goto L21
    L23:
        d.h.b.z.f r5 = new d.h.b.z.f();     // Catch: Throwable -> L60
        r5.f38504a = new d(r32, this.f11061c.a(new StringBuilder().append(r32.a()).append(':').append(r32.b()).toString()), null, r34, r17, r35, new ab((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this, r5), d.h.a.a.class, "com.obric.aiagent.plugin"), 0, null, 6, null), new com.bytedance.safetyguard.lxc.internal.d.a((com.bytedance.safetyguard.lxc.internal.d.s) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.ad(this.f11061c), com.bytedance.safetyguard.lxc.internal.d.s.class, "com.obric.aiagent.plugin"), null, 2, null), null, false, false, null, null, null, 16132, null);     // Catch: Throwable -> L60
        if (r5.f38504a != 0) goto L27;
        d.h.b.o.c("entry");     // Catch: Throwable -> L60
        d r9 = null;
    L28:
        r16 = r8;
        b r18 = new b(r31, r33, r9, r6, r7, false, null, 64, null);     // Catch: Throwable -> L58
        if (r5.f38504a != 0) goto L32;
        d.h.b.o.c("entry");     // Catch: Throwable -> L58
        d r10 = null;
    L33:
        ((Map) ZeusTransformUtils.preCheckCast(r10.n(), Map.class, "com.obric.aiagent.plugin")).put(r31, r18);     // Catch: Throwable -> L58
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(this.f11063e, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        if (r5.f38504a != 0) goto L36;
        d.h.b.o.c("entry");     // Catch: Throwable -> L58
        d r19 = null;
    L37:
        r11.put(r32, r19);     // Catch: Throwable -> L58
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r31, r18);     // Catch: Throwable -> L58
        r1 = new com.bytedance.safetyguard.lxc.internal.service.q.a(false, (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this, r5), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L58
        StringBuilder r20 = new StringBuilder().append("component=proxy_registry event=shared_session_created outcome=pending sharedRef=");     // Catch: Throwable -> L58
        if (r5.f38504a != 0) goto L40;
        d.h.b.o.c("entry");     // Catch: Throwable -> L58
        d r21 = null;
    L41:
        StringBuilder r22 = r20.append(r21.c()).append(" endpointRef=");     // Catch: Throwable -> L58
        if (r5.f38504a != 0) goto L44;
        d.h.b.o.c("entry");     // Catch: Throwable -> L58
        d r23 = null;
    L45:
        StringBuilder r24 = r22.append(r23.b()).append(" attachmentRef=").append(this.f11061c.a(r31.b())).append(" reused=false attachmentCount=");     // Catch: Throwable -> L58
        if (r5.f38504a != 0) goto L48;
        d.h.b.o.c("entry");     // Catch: Throwable -> L58
        d r110 = null;
    L49:
        r15 = r24.append(r110.n().size()).toString();     // Catch: Throwable -> L58
        r13 = false;
        goto L50
    L48:
        r110 = (d) ZeusTransformUtils.preCheckCast(r5.f38504a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        goto L49
    L44:
        r23 = (d) ZeusTransformUtils.preCheckCast(r5.f38504a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        goto L45
    L40:
        r21 = (d) ZeusTransformUtils.preCheckCast(r5.f38504a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        goto L41
    L36:
        r19 = (d) ZeusTransformUtils.preCheckCast(r5.f38504a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        goto L37
    L32:
        r10 = (d) ZeusTransformUtils.preCheckCast(r5.f38504a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        goto L33
    L27:
        r9 = (d) ZeusTransformUtils.preCheckCast(r5.f38504a, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
    L60:
        th = th;
        r16 = r8;
        goto L62
    }

    public final void a(com.bytedance.safetyguard.lxc.internal.service.e r2) {
        d.h.b.o.e(r2, "attachmentKey");
        a(ax.a(r2));
    }

    public final void a(Set<com.bytedance.safetyguard.lxc.internal.service.e> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "attachmentKeys");
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedHashSet r0 = new LinkedHashSet();
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Object r2 = this.f11062d;
        monitor-enter(r2);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L9:
        if (r10.hasNext() == false) goto L18;
        com.bytedance.safetyguard.lxc.internal.service.e r3 = (com.bytedance.safetyguard.lxc.internal.service.e) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.safetyguard.lxc.internal.service.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.f.remove(r3), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r4 == null) goto L9;
        d.h.b.o.a(r4);     // Catch: Throwable -> L29
        d r5 = r4.c();     // Catch: Throwable -> L29
        r5.n().remove(r3);     // Catch: Throwable -> L29
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).add(d.s.a(r5.h(), r4.g()));     // Catch: Throwable -> L29
        if (r5.n().isEmpty() == false) goto L9;
        if (r5.i() == ah.f10938c) goto L9;
        r5.a(ah.f10938c);     // Catch: Throwable -> L29
        r0.add(r5);     // Catch: Throwable -> L29
        goto L9
    L18:
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L29
        monitor-exit(r2);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r12.hasNext() == false) goto L24;
        d.m r6 = (d.m) ZeusTransformUtils.preCheckCast(r12.next(), d.m.class, "com.obric.aiagent.plugin");
        ((com.bytedance.safetyguard.lxc.internal.d.a) ZeusTransformUtils.preCheckCast(r6.c(), com.bytedance.safetyguard.lxc.internal.d.a.class, "com.obric.aiagent.plugin")).a((String) ZeusTransformUtils.preCheckCast(r6.d(), String.class, "com.obric.aiagent.plugin"));
        goto L22
    L24:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        a((d) ZeusTransformUtils.preCheckCast(r13.next(), d.class, "com.obric.aiagent.plugin"), null);
        goto L26
    L28:
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public final ActionActivationResultParcel a(com.bytedance.safetyguard.lxc.internal.service.e r4, String r5) {
        d.h.b.o.e(r4, "attachmentKey");
        d.h.b.o.e(r5, "outboundSensitiveDataJson");
        a r0 = b(r4);
        if (r0 == null) goto L5;
        Object r6 = r0.b().a(r0.c(), r5);
        if (d.n.b(r6) == false) goto L14;
        Throwable r3 = d.n.c(r6);
        if (r3 == null) goto L13;
        return com.bytedance.safetyguard.lxc.internal.service.a.a(com.bytedance.safetyguard.lxc.internal.service.a.a(r3));
    L13:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        Object r1 = this.f11062d;
        monitor-enter(r1);
    L28:
        th = move-exception;
        throw th;
    L17:
        if (this.f.get(r4) != r0.a()) goto L21;
        if (r0.a().c().i() != ah.f10937b) goto L21;
        boolean r7 = true;
    L22:
        monitor-exit(r1);
        if (r7 == true) goto L26;
        r0.b().a(r0.c());
        return com.bytedance.safetyguard.lxc.internal.service.a.a(4);
    L26:
        d.o.a(r6);
        return com.bytedance.safetyguard.lxc.internal.service.a.a((ActionContextToken) ZeusTransformUtils.preCheckCast(r6, ActionContextToken.class, "com.obric.aiagent.plugin"));
    L21:
        r7 = false;
        goto L22
    L5:
        return c(r4);
    }

    public final ActionFinishResultParcel a(com.bytedance.safetyguard.lxc.internal.service.e r4, ActionContextTokenParcel r5) {
        d.h.b.o.e(r4, "attachmentKey");
        d.h.b.o.e(r5, "token");
        a r0 = b(r4);
        if (r0 == null) goto L5;
        ActionContextToken r3 = new ActionContextToken(r5.getSessionInstanceId(), r5.getActivationSequence());
        Object r6 = r0.b().a(r0.c(), r3);
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L10;
        return com.bytedance.safetyguard.lxc.internal.service.a.a((ActionEgressResult) ZeusTransformUtils.preCheckCast(r6, ActionEgressResult.class, "com.obric.aiagent.plugin"));
    L10:
        return com.bytedance.safetyguard.lxc.internal.service.a.b(com.bytedance.safetyguard.lxc.internal.service.a.a(r7));
    L5:
        return d(r4);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Object r0 = this.f11062d;
        monitor-enter(r0);
        this.f.clear();     // Catch: Throwable -> L15
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.f11063e.values(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L8;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r3.n().clear();     // Catch: Throwable -> L15
        r3.a(ah.f10938c);     // Catch: Throwable -> L15
        goto L6
    L8:
        d.h.b.o.c(r1, "onEach(...)");     // Catch: Throwable -> L15
        List r4 = d.a.p.o(r1);     // Catch: Throwable -> L15
        monitor-exit(r0);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r6);
        a(r6, null);
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private final com.bytedance.safetyguard.lxc.internal.service.q a(b r3, com.bytedance.safetyguard.lxc.internal.service.s r4, String r5, com.bytedance.safetyguard.lxc.internal.service.r r6, IProxyClientCallback r7, IOutboundPolicyCallback r8) {
        IProxyClientCallback r9 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r7, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        IOutboundPolicyCallback r10 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r8, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r3.c().a(), r4) == false) goto L19;
        if (d.h.b.o.a(r3.b(), r5) == false) goto L19;
        if (d.h.b.o.a(r3.c().e(), r6) == false) goto L10;
        r3.a(r9);
        r3.a(r10);
        ProxyReadyParcel r11 = r3.c().m();
        if (r3.c().i() != ah.f10937b) goto L15;
        if (r11 == null) goto L15;
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(this, r3, r11), d.h.a.a.class, "com.obric.aiagent.plugin");
    L17:
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.service.q.a(true, r2), com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    L15:
        r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(o.f11098a, d.h.a.a.class, "com.obric.aiagent.plugin");
        goto L17
    L10:
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(a(), com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    L19:
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.service.q.b(20, "attachmentId is already bound to a different proxy session"), com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    }

    private final com.bytedance.safetyguard.lxc.internal.service.q a(d r15, com.bytedance.safetyguard.lxc.internal.service.e r16, String r17, com.bytedance.safetyguard.lxc.internal.service.r r18, IProxyClientCallback r19, IOutboundPolicyCallback r20) {
        IProxyClientCallback r5 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r19, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        IOutboundPolicyCallback r6 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r20, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        if (r15.i() != ah.f10938c) goto L7;
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.service.q.b(11, "proxy session is terminating"), com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    L7:
        if (d.h.b.o.a(r15.e(), r18) == false) goto L9;
        b r13 = new b(r16, r17, r15, r5, r6, true, null, 64, null);
        ((Map) ZeusTransformUtils.preCheckCast(r15.n(), Map.class, "com.obric.aiagent.plugin")).put(r16, r13);
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r16, r13);
        ProxyReadyParcel r1 = r15.m();
        if (r15.i() != ah.f10937b) goto L14;
        if (r1 == null) goto L14;
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(this, r13, r1), d.h.a.a.class, "com.obric.aiagent.plugin");
    L16:
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.service.q.a(false, r0), com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    L14:
        r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(j.f11089a, d.h.a.a.class, "com.obric.aiagent.plugin");
        goto L16
    L9:
        return (com.bytedance.safetyguard.lxc.internal.service.q) ZeusTransformUtils.preCheckCast(a(), com.bytedance.safetyguard.lxc.internal.service.q.class, "com.obric.aiagent.plugin");
    }

    private final void a(d r12) {
        Object r0 = this.f11062d;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.f11063e.get(r12.a()) == r12) goto L7;
    L13:
        boolean r1 = false;
    L14:
        monitor-exit(r0);
        if (r1 == true) goto L62;
        a(r12, null);
        return;
    L62:
        ac r3 = this.f11059a.create(r12.f(), r12.d(), (OutboundPolicyEvaluator) ZeusTransformUtils.preCheckCast(r12.g(), OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin"), r12.h(), (af) ZeusTransformUtils.preCheckCast(new l(this, r12), af.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L44
        Object r4 = this.f11062d;
        monitor-enter(r4);
    L41:
        th = move-exception;
        throw th;
    L24:
        if (this.f11063e.get(r12.a()) == r12) goto L26;
    L31:
        r2 = false;
    L32:
        monitor-exit(r4);
        if (r2 == true) goto L60;
        a(r12, null);
        return;
    L60:
        r3.a();     // Catch: Exception -> L38
        return;
    L38:
        e = move-exception;
        a(r12, a("proxy session start failed", e));
        return;
    L26:
        if (r12.k() == true) goto L31;
        r12.a(r3);     // Catch: Throwable -> L41
        if (r12.i() != ah.f10936a) goto L31;
    L44:
        e = move-exception;
        monitor-enter(this.f11062d);
    L54:
        th = move-exception;
        throw th;
    L48:
        if (this.f11063e.get(r12.a()) != r12) goto L50;
        r12.a(false);     // Catch: Throwable -> L54
    L50:
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L54
        a(r12, a("proxy session creation failed", e));
        return;
    L7:
        if (r12.i() != ah.f10936a) goto L13;
        if (r12.j() == true) goto L13;
        r12.a(true);     // Catch: Throwable -> L57
        r1 = true;
    L57:
        th = move-exception;
        throw th;
    }

    private final void a(d r6, ProxyReadyParcel r7) {
        Object r0 = this.f11062d;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.f11063e.get(r6.a()) == r6) goto L8;
        monitor-exit(r0);
        return;
    L8:
        ah r1 = r6.i();     // Catch: Throwable -> L28
        int r2 = e.f11080a[r1.ordinal()];     // Catch: Throwable -> L28
        if (r2 != 1) goto L12;
        r6.a(ah.f10937b);     // Catch: Throwable -> L28
    L21:
        r6.a(this.f11061c.a(r7.getSessionId()));     // Catch: Throwable -> L28
        r6.a(r7);     // Catch: Throwable -> L28
        Collection<b> r3 = r6.n().values();     // Catch: Throwable -> L28
        d.h.b.o.c(r3, "<get-values>(...)");     // Catch: Throwable -> L28
        List r4 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L28
        monitor-exit(r0);
        this.f11061c.b("ProxySessionRegistry", (d.h.a.a) ZeusTransformUtils.preCheckCast(new m(r6, r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L25:
        if (r8.hasNext() == false) goto L27;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r5);
        a(r5, r7);
        goto L25
    L27:
        return;
    L12:
        if (r2 != 2) goto L14;
        monitor-exit(r0);
        return;
    L14:
        if (r2 != 3) goto L21;
        monitor-exit(r0);
    }

    private final void a(b r18, ProxyReadyParcel r19) {
        Object r1 = this.f11062d;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.f.get(r18.a()) == r18) goto L7;
    L11:
        c r2 = null;
    L12:
        monitor-exit(r1);
        if (r2 != null) goto L23;
        return;
    L23:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L17
        x r0 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        r2.a().onReady(r2.b(), r2.c());     // Catch: Throwable -> L17
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L7:
        if (r18.c().i() != ah.f10937b) goto L11;
        r2 = new c(r18.d(), r18.a().b(), ProxyReadyParcel.copy$default(r19, 0, r18.b(), r18.f(), 0, 0, 0, 0, 121, null));     // Catch: Throwable -> L20
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v133 */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v142 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r4v11, types: [int] */
    /* JADX WARN: Type inference failed for: r6v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    private final void a(d r47, ProxySessionResultParcel r48) {
        Class<x> r14 = x.class;
        long r22 = System.nanoTime();
        d.h.b.z.f r4 = new d.h.b.z.f();
        Object r5 = this.f11062d;
        monitor-enter(r5);
    L196:
        th = move-exception;
        throw th;
    L5:
        if (this.f11063e.get(r47.a()) == r47) goto L7;
    L194:
        monitor-exit(r5);
        return;
    L7:
        if (r47.k() == true) goto L194;
        r47.a(ah.f10938c);     // Catch: Throwable -> L196
        if (r47.j() == true) goto L12;
    L15:
        ?? r15 = 1;
        r15 = 1;
        r47.b(true);     // Catch: Throwable -> L196
        Collection<b> r0 = r47.n().values();     // Catch: Throwable -> L196
        d.h.b.o.c(r0, "<get-values>(...)");     // Catch: Throwable -> L196
        r4.f38504a = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L196
        d.x r24 = null;
        if (r4.f38504a != null) goto L19;
        d.h.b.o.c("records");     // Catch: Throwable -> L196
        List r1 = null;
    L20:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L196
    L22:
        if (r2.hasNext() == false) goto L24;
        this.f.remove(((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L196
        goto L22
    L24:
        r47.n().clear();     // Catch: Throwable -> L196
        ac r25 = r47.l();     // Catch: Throwable -> L196
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L196
        monitor-exit(r5);
        if (r48 != null) goto L28;
        String r6 = "attachment_release";
    L29:
        String r12 = r6;
        this.f11061c.b("ProxySessionRegistry", (d.h.a.a) ZeusTransformUtils.preCheckCast(new p(r47, r12, r4, r48), d.h.a.a.class, "com.obric.aiagent.plugin"));
        d.h.b.z.a r13 = new d.h.b.z.a();
        if (r48 != null) goto L219;
        com.bytedance.safetyguard.lxc.internal.d.ai r7 = null;
    L44:
        if (r7 != null) goto L46;
        b r10 = null;
    L61:
        if (r10 == null) goto L76;
        if (r7 == null) goto L75;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L65
        x r9 = (x) ZeusTransformUtils.preCheckCast(this, r14, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        Object r11 = d.n.f(d.s.a(com.bytedance.safetyguard.lxc.internal.service.a.b(r7.b()), com.bytedance.safetyguard.lxc.internal.service.a.a(r7.c())));     // Catch: Throwable -> L65
    L67:
        Throwable r16 = d.n.c(r11);
        if (r16 == null) goto L71;
        r13.f38499a = true;
        this.f11061c.a("ProxySessionRegistry", r16, (d.h.a.a) ZeusTransformUtils.preCheckCast(new C0251x(r47), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L71:
        if (d.n.b(r11) == false) goto L73;
        r11 = null;
    L73:
        d.m r27 = (d.m) ZeusTransformUtils.preCheckCast(r11, d.m.class, "com.obric.aiagent.plugin");
    L80:
        if (r4.f38504a != null) goto L82;
        d.h.b.o.c("records");
        List r17 = null;
    L84:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L207;
    L100:
        d.h.b.z.d r18 = new d.h.b.z.d();
        d.h.b.z.d r19 = new d.h.b.z.d();
        if (r48 != null) goto L103;
    L145:
        d.h.b.z.d r20 = r19;
        d.h.b.z.d r21 = r18;
        String r29 = r12;
        d.h.b.z.a r23 = r13;
        Class<x> r45 = r14;
        ?? r26 = r15;
        d.n.a r28 = d.n.f38560a;     // Catch: Throwable -> L155
        Class<x> r30 = r45;
        x r31 = (x) ZeusTransformUtils.preCheckCast(this, r30, "com.obric.aiagent.plugin");     // Catch: Throwable -> L153
        if (r25 == null) goto L151;
        r25.b();     // Catch: Throwable -> L153
        r24 = d.x.f38692a;     // Catch: Throwable -> L153
    L151:
        Object r32 = d.n.f(r24);     // Catch: Throwable -> L153
    L158:
        Object r33 = r32;
        Throwable r34 = d.n.c(r33);
        if (r34 == null) goto L221;
        r23.f38499a = r26;
        this.f11061c.a("ProxySessionRegistry", r34, (d.h.a.a) ZeusTransformUtils.preCheckCast(new w(r47), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L221:
        d.n.a r35 = d.n.f38560a;     // Catch: Throwable -> L163
        x r36 = (x) ZeusTransformUtils.preCheckCast(this, r30, "com.obric.aiagent.plugin");     // Catch: Throwable -> L163
        r47.h().b();     // Catch: Throwable -> L163
        Object r37 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L163
    L165:
        Object r38 = r37;
        Throwable r39 = d.n.c(r38);
        if (r39 == null) goto L199;
        r23.f38499a = r26;
        this.f11061c.a("ProxySessionRegistry", r39, (d.h.a.a) ZeusTransformUtils.preCheckCast(new t(r47), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L199:
        d.n.a r40 = d.n.f38560a;     // Catch: Throwable -> L170
        ((x) ZeusTransformUtils.preCheckCast(this, r30, "com.obric.aiagent.plugin")).f11060b.shutdown(r47.f());     // Catch: Throwable -> L170
        Object r41 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L170
    L172:
        Object r110 = r41;
        Throwable r42 = d.n.c(r110);
        if (r42 == null) goto L203;
        r23.f38499a = r26;
        this.f11061c.a("ProxySessionRegistry", r42, (d.h.a.a) ZeusTransformUtils.preCheckCast(new u(r47), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L203:
        d.n.a r43 = d.n.f38560a;     // Catch: Throwable -> L177
        x r44 = (x) ZeusTransformUtils.preCheckCast(this, r30, "com.obric.aiagent.plugin");     // Catch: Throwable -> L177
        r47.f().close();     // Catch: Throwable -> L177
        Object r46 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L177
    L179:
        Throwable r49 = d.n.c(r46);
        if (r49 == null) goto L182;
        r23.f38499a = r26;
        this.f11061c.a("ProxySessionRegistry", r49, (d.h.a.a) ZeusTransformUtils.preCheckCast(new v(r47), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L182:
        Object r50 = this.f11062d;
        monitor-enter(r50);
    L191:
        th = move-exception;
        throw th;
    L185:
        if (this.f11063e.get(r47.a()) != r47) goto L187;
        this.f11063e.remove(r47.a());     // Catch: Throwable -> L191
    L187:
        d.m r111 = d.s.a(Integer.valueOf(this.f11063e.size()), Integer.valueOf(this.f.size()));     // Catch: Throwable -> L191
        monitor-exit(r50);
        this.f11061c.b("ProxySessionRegistry", (d.h.a.a) ZeusTransformUtils.preCheckCast(new s(r23, r47, r29, r21, r20, r33, r38, r110, r46, r111, r22), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L177:
        th = move-exception;
        d.n.a r51 = d.n.f38560a;
        r46 = d.n.f(d.o.a(th));
    L170:
        th = move-exception;
        d.n.a r112 = d.n.f38560a;
        r41 = d.n.f(d.o.a(th));
    L163:
        th = move-exception;
        d.n.a r52 = d.n.f38560a;
        r37 = d.n.f(d.o.a(th));
    L153:
        th = th;
    L157:
        d.n.a r53 = d.n.f38560a;
        r32 = d.n.f(d.o.a(th));
    L155:
        th = th;
        r30 = r45;
        goto L157
    L103:
        if (r4.f38504a != null) goto L105;
        d.h.b.o.c("records");
        List r54 = null;
    L106:
        Iterator r210 = ((Iterable) ZeusTransformUtils.preCheckCast(r54, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L108:
        if (r210.hasNext() == false) goto L145;
        b r55 = (b) ZeusTransformUtils.preCheckCast(r210.next(), b.class, "com.obric.aiagent.plugin");
        d.n.a r56 = d.n.f38560a;     // Catch: Throwable -> L133
        x r57 = (x) ZeusTransformUtils.preCheckCast(this, r14, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r55 != r10) goto L113;
        ?? r58 = r15 == true ? 1 : 0;
    L114:
        IProxyClientCallback r59 = r55.d();     // Catch: Throwable -> L133
        String r60 = r55.a().b();     // Catch: Throwable -> L133
        String r113 = r55.b();     // Catch: Throwable -> L133
        if (r27 == null) goto L117;
        ActionContextTokenParcel r61 = (ActionContextTokenParcel) ZeusTransformUtils.preCheckCast(r27.a(), ActionContextTokenParcel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
    L118:
        if (r58 == 0) goto L120;
        ActionContextTokenParcel r310 = r61;
    L121:
        if (r27 == null) goto L124;
        ActionFinishResultParcel r62 = (ActionFinishResultParcel) ZeusTransformUtils.preCheckCast(r27.b(), ActionFinishResultParcel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
    L125:
        if (r58 == 0) goto L127;
        ActionFinishResultParcel r63 = r62;
    L128:
        b r410 = r55;
        d.h.b.z.d r411 = r19;
        b r311 = r10;
        d.h.b.z.d r412 = r18;
        String r211 = r12;
        d.h.b.z.a r413 = r13;
        Class<x> r414 = r14;
        r59.onTerminal(r60, ProxySessionResultParcel.copy$default(r48, 0, r113, 0, 0, null, 0, 0, 0, 0, r310, r63, 509, null));     // Catch: Throwable -> L131
        Object r64 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L131
    L137:
        if (d.n.a(r64) == false) goto L139;
        d.x r65 = (d.x) ZeusTransformUtils.preCheckCast(r64, d.x.class, "com.obric.aiagent.plugin");
        d.h.b.z.d r66 = r412;
        ?? r67 = 1;
        r66.f38502a++;
    L140:
        Throwable r68 = d.n.c(r64);
        d.h.b.z.d r69 = r411;
        if (r68 == null) goto L143;
        r69.f38502a += r67;
        d.h.b.z.a r70 = r413;
        r70.f38499a = r67;
        this.f11061c.a("ProxySessionRegistry", r68, (d.h.a.a) ZeusTransformUtils.preCheckCast(new r(r47, this, r410), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L144:
        r13 = r70;
        r18 = r66;
        r15 = r67;
        r19 = r69;
        r12 = r211;
        r10 = r311;
        r14 = r414;
        goto L108
    L143:
        r70 = r413;
        goto L144
    L139:
        r66 = r412;
        r67 = 1;
    L131:
        th = th;
    L135:
        d.n.a r71 = d.n.f38560a;
        r64 = d.n.f(d.o.a(th));
        goto L137
    L127:
        r63 = null;
        goto L128
    L124:
        r62 = null;
        goto L125
    L120:
        r310 = null;
        goto L121
    L117:
        r61 = null;
        goto L118
    L113:
        r58 = 0;
    L133:
        th = th;
        r410 = r55;
        r411 = r19;
        r311 = r10;
        r412 = r18;
        r211 = r12;
        r413 = r13;
        r414 = r14;
        goto L135
    L105:
        r54 = (List) ZeusTransformUtils.preCheckCast(r4.f38504a, List.class, "com.obric.aiagent.plugin");
        goto L106
    L207:
        d.n.a r72 = d.n.f38560a;     // Catch: Throwable -> L95
        d.h.a.b<? super Set<com.bytedance.safetyguard.lxc.internal.service.e>, d.x> r73 = ((x) ZeusTransformUtils.preCheckCast(this, r14, "com.obric.aiagent.plugin")).g;     // Catch: Throwable -> L95
        if (r4.f38504a != null) goto L88;
        d.h.b.o.c("records");     // Catch: Throwable -> L95
        List r74 = null;
    L89:
        Iterable r75 = (Iterable) ZeusTransformUtils.preCheckCast(r74, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        Collection r76 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        Iterator r77 = r75.iterator();     // Catch: Throwable -> L95
    L91:
        if (r77.hasNext() == false) goto L93;
        r76.add(((b) ZeusTransformUtils.preCheckCast(r77.next(), b.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L95
        goto L91
    L93:
        r73.invoke(r76);     // Catch: Throwable -> L95
        Object r78 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L95
    L97:
        Throwable r79 = d.n.c(r78);
        if (r79 == null) goto L100;
        r13.f38499a = true;
        this.f11061c.a("ProxySessionRegistry", r79, (d.h.a.a) ZeusTransformUtils.preCheckCast(new q(r47, r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
        goto L100
    L88:
        r74 = (List) ZeusTransformUtils.preCheckCast(r4.f38504a, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        d.n.a r80 = d.n.f38560a;
        r78 = d.n.f(d.o.a(th));
        goto L97
    L82:
        r17 = (List) ZeusTransformUtils.preCheckCast(r4.f38504a, List.class, "com.obric.aiagent.plugin");
    L65:
        th = move-exception;
        d.n.a r81 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L67
    L75:
        throw new IllegalArgumentException("Required value was null.".toString());
    L76:
        if (r7 == null) goto L78;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.f11061c, "ProxySessionRegistry", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new y(r47, r4), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
    L78:
        r27 = null;
        goto L80
    L46:
        if (r4.f38504a != null) goto L48;
        d.h.b.o.c("records");
        List r82 = null;
    L49:
        Iterator r83 = ((Iterable) ZeusTransformUtils.preCheckCast(r82, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        Object r84 = null;
        ?? r85 = false;
    L51:
        if (r83.hasNext() == false) goto L57;
        Object r86 = r83.next();
        if (d.h.b.o.a(((b) ZeusTransformUtils.preCheckCast(r86, b.class, "com.obric.aiagent.plugin")).g(), r7.a()) == false) goto L51;
        if (r85 == true) goto L58;
        r84 = r86;
        r85 = true;
    L58:
        r84 = null;
    L59:
        r10 = (b) ZeusTransformUtils.preCheckCast(r84, b.class, "com.obric.aiagent.plugin");
        goto L61
    L57:
        if (r85 == true) goto L59;
    L48:
        r82 = (List) ZeusTransformUtils.preCheckCast(r4.f38504a, List.class, "com.obric.aiagent.plugin");
        goto L49
    L219:
        d.n.a r87 = d.n.f38560a;     // Catch: Throwable -> L33
        x r88 = (x) ZeusTransformUtils.preCheckCast(this, r14, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Object r89 = d.n.f(r47.h().a());     // Catch: Throwable -> L33
    L35:
        Throwable r90 = d.n.c(r89);
        if (r90 == null) goto L39;
        r13.f38499a = true;
        this.f11061c.a("ProxySessionRegistry", r90, (d.h.a.a) ZeusTransformUtils.preCheckCast(new z(r47), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L39:
        if (d.n.b(r89) == false) goto L41;
        r89 = null;
    L41:
        r7 = (com.bytedance.safetyguard.lxc.internal.d.ai) ZeusTransformUtils.preCheckCast(r89, com.bytedance.safetyguard.lxc.internal.d.ai.class, "com.obric.aiagent.plugin");
    L33:
        th = move-exception;
        d.n.a r91 = d.n.f38560a;
        r89 = d.n.f(d.o.a(th));
        goto L35
    L28:
        r6 = "gateway_terminal";
        goto L29
    L19:
        r1 = (List) ZeusTransformUtils.preCheckCast(r4.f38504a, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L196
        goto L20
    L12:
        if (r47.l() != null) goto L15;
        monitor-exit(r5);
    }

    private final List<IOutboundPolicyCallback> b(d r5) {
        Object r0 = this.f11062d;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.f11063e.get(r5.a()) == r5) goto L7;
    L16:
        List<IOutboundPolicyCallback> r4 = d.a.p.b();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);
        return r4;
    L7:
        if (r5.i() == ah.f10938c) goto L16;
        Collection<b> r6 = r5.n().values();     // Catch: Throwable -> L19
        d.h.b.o.c(r6, "<get-values>(...)");     // Catch: Throwable -> L19
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L19
    L11:
        if (r9.hasNext() == false) goto L15;
        IOutboundPolicyCallback r1 = ((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.aiagent.plugin")).e();     // Catch: Throwable -> L19
        if (r1 == null) goto L11;
        r8.add(r1);     // Catch: Throwable -> L19
        goto L11
    L15:
        r4 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        goto L17
    }

    private final a b(com.bytedance.safetyguard.lxc.internal.service.e r4) {
        Object r0 = this.f11062d;
        monitor-enter(r0);
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r4), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        a r5 = null;
        if (r3 == null) goto L13;
        d.h.b.o.a(r3);     // Catch: Throwable -> L15
        if (r3.c().i() != ah.f10937b) goto L13;
        if (r3.c().m() == null) goto L13;
        r5 = new a(r3, r3.c().h(), r3.g());     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);
        return r5;
    L15:
        th = move-exception;
        throw th;
    }

    private final ActionActivationResultParcel c(com.bytedance.safetyguard.lxc.internal.service.e r1) {
        return com.bytedance.safetyguard.lxc.internal.service.a.a(e(r1));
    }

    private final ActionFinishResultParcel d(com.bytedance.safetyguard.lxc.internal.service.e r1) {
        return com.bytedance.safetyguard.lxc.internal.service.a.b(e(r1));
    }

    private final int e(com.bytedance.safetyguard.lxc.internal.service.e r5) {
        Object r0 = this.f11062d;
        monitor-enter(r0);
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r5), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r4 != null) goto L7;
        int r6 = 4;
    L19:
        monitor-exit(r0);
        return r6;
    L7:
        d.h.b.o.a(r4);     // Catch: Throwable -> L21
        int r7 = e.f11080a[r4.c().i().ordinal()];     // Catch: Throwable -> L21
        if (r7 == 1) goto L18;
        if (r7 == 2) goto L15;
        if (r7 != 3) goto L13;
        r6 = 3;
        goto L19
    L13:
        throw new d.k();     // Catch: Throwable -> L21
    L15:
        if (r4.c().m() == null) goto L18;
        r6 = 9;
    L18:
        r6 = 2;
    L21:
        th = move-exception;
        throw th;
    }

    private final com.bytedance.safetyguard.lxc.internal.service.q.b a() {
        return new com.bytedance.safetyguard.lxc.internal.service.q.b(13, "proxy endpoint already uses a different data-plane configuration");
    }

    private final ProxySessionResultParcel a(String r20, Exception r21) {
        String r0 = r21.getMessage();
        if (r0 == null) goto L8;
        String r2 = r20;
        String r1 = r2 + ": " + r0;
        if (r1 == null) goto L9;
        String r6 = r1;
    L11:
        return new ProxySessionResultParcel(0, "internal", 7, 11, r6, 0, 0, 0, 0, null, null, 2017, null);
    L9:
        r6 = r2;
        goto L11
    L8:
        r2 = r20;
        goto L9
    }
}
