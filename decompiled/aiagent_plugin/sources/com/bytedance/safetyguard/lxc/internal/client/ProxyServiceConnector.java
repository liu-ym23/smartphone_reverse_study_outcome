package com.bytedance.safetyguard.lxc.internal.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ProxyReady;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarSessionEnv;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionActivationResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionContextTokenParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionFinishResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService;
import com.bytedance.safetyguard.lxc.internal.ipc.ISidecarCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyAttachRequestParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyDiagnosticParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyReadyParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxySessionResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarCommandParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarResultParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyServiceConnector implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.client.m f9866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.client.k f9867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.d.p f9868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f9869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.client.q f9870e;
    private final com.bytedance.safetyguard.lxc.internal.client.q f;
    private final long g;
    private final com.bytedance.safetyguard.lxc.internal.a.e h;
    private final Object i;
    private final Binder j;
    private final LinkedHashMap<String, d> k;
    private final ArrayDeque<String> l;
    private final EnumMap<com.bytedance.safetyguard.lxc.internal.client.d, Integer> m;
    private final LinkedHashMap<String, n> n;
    private final ArrayDeque<String> o;
    private final LinkedHashMap<String, q> p;
    private com.bytedance.safetyguard.lxc.internal.client.g q;
    private long r;
    private e s;
    private g t;

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class GenerationProxyCallback extends IProxyClientCallback.Stub {
        private final long generation;
        final /* synthetic */ ProxyServiceConnector this$0;

        public GenerationProxyCallback(ProxyServiceConnector r1, long r2) {
            this.this$0 = r1;
            this.generation = r2;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onReady(String r4, ProxyReadyParcel r5) {
            ProxyServiceConnector.a(this.this$0, this.generation, r4, r5);
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onRecovering(int r4, String r5) {
            ProxyServiceConnector.a(this.this$0, this.generation, r4, r5);
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onTerminal(String r4, ProxySessionResultParcel r5) {
            ProxyServiceConnector.a(this.this$0, this.generation, r4, r5);
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onDiagnostic(ProxyDiagnosticParcel r4) {
            ProxyServiceConnector.a(this.this$0, this.generation, r4);
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class GenerationServiceConnection implements ServiceConnection {
        private final long generation;
        final /* synthetic */ ProxyServiceConnector this$0;

        public GenerationServiceConnection(ProxyServiceConnector r1, long r2) {
            this.this$0 = r1;
            this.generation = r2;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            ProxyServiceConnector.a(this.this$0, this.generation, r5);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            ProxyServiceConnector.a(this.this$0, this.generation, "service_disconnected");
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r3) {
            ProxyServiceConnector.a(this.this$0, this.generation, "binding_died");
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r3) {
            ProxyServiceConnector.b(this.this$0, this.generation, "Proxy service rejected the binding");
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class GenerationSidecarCallback extends ISidecarCallback.Stub {
        private final long generation;
        final /* synthetic */ ProxyServiceConnector this$0;

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISidecarCallback
        public void onDiagnostic(ProxyDiagnosticParcel r1) {
        }

        public GenerationSidecarCallback(ProxyServiceConnector r1, long r2) {
            this.this$0 = r1;
            this.generation = r2;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISidecarCallback
        public void onVerificationUrl(int r8, String r9, String r10, int r11) {
            ProxyServiceConnector.a(this.this$0, this.generation, r8, r9, r10, r11);
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISidecarCallback
        public void onResult(SidecarResultParcel r4) {
            ProxyServiceConnector.a(this.this$0, this.generation, r4);
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f9871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f9872b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9871a, r6.f9871a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9872b, r6.f9872b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9871a.hashCode() * 31) + this.f9872b.hashCode();
        }

        public String toString() {
            return "ActionServiceRequest(record=" + this.f9871a + ", service=" + this.f9872b + ')';
        }

        public a(d r2, g r3) {
            d.h.b.o.e(r2, "record");
            d.h.b.o.e(r3, WsConstants.KEY_SERVICE);
            this.f9871a = r2;
            this.f9872b = r3;
        }

        public final d a() {
            return this.f9871a;
        }

        public final g b() {
            return this.f9872b;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class aa extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f9873a;

        aa(e r1) {
            this.f9873a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=bind_failed outcome=failed generation=" + this.f9873a.a();
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class ab extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxyAttachRequestParcel f9875b;

        ab(ProxyServiceConnector r1, ProxyAttachRequestParcel r2) {
            this.f9874a = r1;
            this.f9875b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            com.bytedance.safetyguard.lxc.internal.client.o r0 = this.f9874a.a();
            return "component=proxy_connector event=attachment_reserved outcome=pending attachmentRef=" + ProxyServiceConnector.a(this.f9874a).a(this.f9875b.getAttachmentId()) + " state=" + r0.a() + " remainingLeases=" + r0.b();
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class ac extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f9876a;

        ac(h r1) {
            this.f9876a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=detach_failed outcome=fail_closed generation=" + this.f9876a.b().a();
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class ad extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f9877a;

        ad(k r1) {
            this.f9877a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=sidecar_cancel_failed outcome=ignored generation=" + this.f9877a.b().a();
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f9880c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9878a, r10.f9878a) == true) goto L12;
            return false;
        L12:
            if (this.f9879b == r10.f9879b) goto L15;
            return false;
        L15:
            if (this.f9880c == r10.f9880c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9878a.hashCode() * 31) + Long.hashCode(this.f9879b)) * 31) + Long.hashCode(this.f9880c);
        }

        public String toString() {
            return "AttachRetryTimeoutRequest(attachmentId=" + this.f9878a + ", token=" + this.f9879b + ", delayMillis=" + this.f9880c + ')';
        }

        public b(String r2, long r3, long r5) {
            d.h.b.o.e(r2, "attachmentId");
            this.f9878a = r2;
            this.f9879b = r3;
            this.f9880c = r5;
        }

        public final String a() {
            return this.f9878a;
        }

        public final long b() {
            return this.f9879b;
        }

        public final long c() {
            return this.f9880c;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.r f9881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProxySessionResult f9882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j f9883c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9881a, r6.f9881a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9882b, r6.f9882b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f9883c, r6.f9883c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9881a.hashCode() * 31) + this.f9882b.hashCode()) * 31) + this.f9883c.hashCode();
        }

        public String toString() {
            return "AttachmentFailure(attachment=" + this.f9881a + ", result=" + this.f9882b + ", releasePlan=" + this.f9883c + ')';
        }

        public c(com.bytedance.safetyguard.lxc.internal.client.r r2, ProxySessionResult r3, j r4) {
            d.h.b.o.e(r2, "attachment");
            d.h.b.o.e(r3, "result");
            d.h.b.o.e(r4, "releasePlan");
            this.f9881a = r2;
            this.f9882b = r3;
            this.f9883c = r4;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.r a() {
            return this.f9881a;
        }

        public final ProxySessionResult b() {
            return this.f9882b;
        }

        public final j c() {
            return this.f9883c;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.r f9884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProxyAttachRequestParcel f9885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IOutboundPolicyCallback f9886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ParcelFileDescriptor f9887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f9888e;
        private boolean f;
        private boolean g;
        private long h;
        private Long i;
        private Long j;
        private boolean k;
        private boolean l;
        private boolean m;
        private long n;
        private com.bytedance.safetyguard.lxc.internal.client.p o;
        private boolean p;
        private boolean q;
        private com.bytedance.safetyguard.lxc.internal.client.c r;

        public d(com.bytedance.safetyguard.lxc.internal.client.r r3, ProxyAttachRequestParcel r4, IOutboundPolicyCallback r5, ParcelFileDescriptor r6, Object r7) {
            IOutboundPolicyCallback r8 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r5, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "attachment");
            d.h.b.o.e(r4, Ext.KEY_REQUEST);
            d.h.b.o.e(r7, "startToken");
            this.f9884a = r3;
            this.f9885b = r4;
            this.f9886c = r8;
            this.f9887d = r6;
            this.f9888e = r7;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.r a() {
            return this.f9884a;
        }

        public final ProxyAttachRequestParcel b() {
            return this.f9885b;
        }

        public final IOutboundPolicyCallback c() {
            return this.f9886c;
        }

        public final ParcelFileDescriptor d() {
            return this.f9887d;
        }

        public final Object e() {
            return this.f9888e;
        }

        public final void a(boolean r1) {
            this.f = r1;
        }

        public final boolean f() {
            return this.f;
        }

        public final void b(boolean r1) {
            this.g = r1;
        }

        public final boolean g() {
            return this.g;
        }

        public final void a(long r1) {
            this.h = r1;
        }

        public final long h() {
            return this.h;
        }

        public final void a(Long r1) {
            this.i = r1;
        }

        public final Long i() {
            return this.i;
        }

        public final void b(Long r1) {
            this.j = r1;
        }

        public final Long j() {
            return this.j;
        }

        public final void c(boolean r1) {
            this.k = r1;
        }

        public final boolean k() {
            return this.k;
        }

        public final void d(boolean r1) {
            this.l = r1;
        }

        public final boolean l() {
            return this.l;
        }

        public final void e(boolean r1) {
            this.m = r1;
        }

        public final boolean m() {
            return this.m;
        }

        public final void b(long r1) {
            this.n = r1;
        }

        public final long n() {
            return this.n;
        }

        public final void a(com.bytedance.safetyguard.lxc.internal.client.p r3) {
            this.o = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
        }

        public final void f(boolean r1) {
            this.p = r1;
        }

        public final boolean o() {
            return this.p;
        }

        public final void g(boolean r1) {
            this.q = r1;
        }

        public final boolean p() {
            return this.q;
        }

        public final void a(com.bytedance.safetyguard.lxc.internal.client.c r1) {
            this.r = r1;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.c q() {
            return this.r;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.p r() {
            this.m = false;
            this.n++;
            com.bytedance.safetyguard.lxc.internal.client.p r0 = this.o;
            this.o = null;
            return r0;
        }

        public final ParcelFileDescriptor s() {
            ParcelFileDescriptor r0 = this.f9887d;
            this.f9887d = null;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ServiceConnection f9890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.e f9891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bytedance.safetyguard.lxc.internal.client.p f9893e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
            if (this.f9889a == r10.f9889a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9890b, r10.f9890b) == true) goto L15;
            return false;
        L15:
            if (this.f9891c == r10.f9891c) goto L18;
            return false;
        L18:
            if (this.f9892d == r10.f9892d) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f9893e, r10.f9893e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((Long.hashCode(this.f9889a) * 31) + this.f9890b.hashCode()) * 31) + this.f9891c.hashCode()) * 31) + Boolean.hashCode(this.f9892d)) * 31;
            com.bytedance.safetyguard.lxc.internal.client.p r2 = this.f9893e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "BindingAttempt(generation=" + this.f9889a + ", connection=" + this.f9890b + ", kind=" + this.f9891c + ", registered=" + this.f9892d + ", bindTimeoutHandle=" + this.f9893e + ')';
        }

        public e(long r3, ServiceConnection r5, com.bytedance.safetyguard.lxc.internal.client.e r6, boolean r7, com.bytedance.safetyguard.lxc.internal.client.p r8) {
            ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.aiagent.plugin");
            com.bytedance.safetyguard.lxc.internal.client.p r10 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r9, WsConstants.KEY_CONNECTION);
            d.h.b.o.e(r6, "kind");
            this.f9889a = r3;
            this.f9890b = r9;
            this.f9891c = r6;
            this.f9892d = r7;
            this.f9893e = r10;
        }

        public /* synthetic */ e(long r10, ServiceConnection r12, com.bytedance.safetyguard.lxc.internal.client.e r13, boolean r14, com.bytedance.safetyguard.lxc.internal.client.p r15, int r16, d.h.b.h r17) {
            ServiceConnection r5 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r12, ServiceConnection.class, "com.obric.aiagent.plugin");
            com.bytedance.safetyguard.lxc.internal.client.p r0 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.wrapperContextForParams(r15, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
            if ((r16 & 8) == 0) goto L5;
            boolean r7 = false;
        L7:
            if ((r16 & 16) == 0) goto L9;
            r0 = null;
        L9:
            this(r10, r5, r13, r7, r0);
            return;
        L5:
            r7 = r14;
            goto L7
        }

        public final long a() {
            return this.f9889a;
        }

        public final ServiceConnection b() {
            return this.f9890b;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.e c() {
            return this.f9891c;
        }

        public final void a(boolean r1) {
            this.f9892d = r1;
        }

        public final boolean d() {
            return this.f9892d;
        }

        public final void a(com.bytedance.safetyguard.lxc.internal.client.p r3) {
            this.f9893e = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
        }

        public final com.bytedance.safetyguard.lxc.internal.client.p e() {
            return this.f9893e;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f9895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ServiceConnection f9896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f9898e;
        private final com.bytedance.safetyguard.lxc.internal.client.p f;

        public f(ProxyServiceConnector r3, g r4, ServiceConnection r5, boolean r6, boolean r7, com.bytedance.safetyguard.lxc.internal.client.p r8) {
            ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.aiagent.plugin");
            com.bytedance.safetyguard.lxc.internal.client.p r10 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
            this.f9894a = r3;
            this.f9895b = r4;
            this.f9896c = r9;
            this.f9897d = r6;
            this.f9898e = r7;
            this.f = r10;
        }

        public final void a() {
            com.bytedance.safetyguard.lxc.internal.client.p r1 = this.f;
            if (r1 == null) goto L5;
            r1.cancel();
        L5:
            g r2 = this.f9895b;
            if (this.f9898e == false) goto L13;
            if (r2 == null) goto L13;
            ProxyServiceConnector r3 = this.f9894a;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L11
            f r5 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            r2.b().closeClient(3, (IBinder) ZeusTransformUtils.preCheckCast(ProxyServiceConnector.f(r3), IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            d.n.f(d.x.f38692a);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            d.n.a r6 = d.n.f38560a;
            d.n.f(d.o.a(th));
        L13:
            if (r2 == null) goto L19;
            d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L16
            f r0 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            d.n.f(Boolean.valueOf(r2.c().unlinkToDeath(r2.d(), 0)));     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            d.n.a r8 = d.n.f38560a;
            d.n.f(d.o.a(th));
        L19:
            if (this.f9897d == false) goto L28;
            ServiceConnection r9 = this.f9896c;
            if (r9 == null) goto L29;
            ProxyServiceConnector.a(this.f9894a, r9);
            return;
        L29:
            return;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ISafetyGuardRuntimeService f9900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IBinder f9901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final IBinder.DeathRecipient f9902d;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
            return false;
        L8:
            g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
            if (this.f9899a == r10.f9899a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9900b, r10.f9900b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f9901c, r10.f9901c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f9902d, r10.f9902d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f9899a) * 31) + this.f9900b.hashCode()) * 31) + this.f9901c.hashCode()) * 31) + this.f9902d.hashCode();
        }

        public String toString() {
            return "ConnectedService(generation=" + this.f9899a + ", service=" + this.f9900b + ", binder=" + this.f9901c + ", deathRecipient=" + this.f9902d + ')';
        }

        public g(long r3, ISafetyGuardRuntimeService r5, IBinder r6, IBinder.DeathRecipient r7) {
            ISafetyGuardRuntimeService r8 = (ISafetyGuardRuntimeService) ZeusTransformUtils.wrapperContextForParams(r5, ISafetyGuardRuntimeService.class, "com.obric.aiagent.plugin");
            IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r10 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, WsConstants.KEY_SERVICE);
            d.h.b.o.e(r9, "binder");
            d.h.b.o.e(r10, "deathRecipient");
            this.f9899a = r3;
            this.f9900b = r8;
            this.f9901c = r9;
            this.f9902d = r10;
        }

        public final long a() {
            return this.f9899a;
        }

        public final ISafetyGuardRuntimeService b() {
            return this.f9900b;
        }

        public final IBinder c() {
            return this.f9901c;
        }

        public final IBinder.DeathRecipient d() {
            return this.f9902d;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f9903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f9904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.c f9905c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9903a, r6.f9903a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9904b, r6.f9904b) == true) goto L15;
            return false;
        L15:
            if (this.f9905c == r6.f9905c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9903a.hashCode() * 31) + this.f9904b.hashCode()) * 31) + this.f9905c.hashCode();
        }

        public String toString() {
            return "DetachRequest(record=" + this.f9903a + ", service=" + this.f9904b + ", releaseReason=" + this.f9905c + ')';
        }

        public h(d r2, g r3, com.bytedance.safetyguard.lxc.internal.client.c r4) {
            d.h.b.o.e(r2, "record");
            d.h.b.o.e(r3, WsConstants.KEY_SERVICE);
            d.h.b.o.e(r4, "releaseReason");
            this.f9903a = r2;
            this.f9904b = r3;
            this.f9905c = r4;
        }

        public final d a() {
            return this.f9903a;
        }

        public final g b() {
            return this.f9904b;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.c c() {
            return this.f9905c;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9907b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, i.class) == true) goto L8;
            return false;
        L8:
            i r8 = (i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9906a, r8.f9906a) == true) goto L12;
            return false;
        L12:
            if (this.f9907b == r8.f9907b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9906a.hashCode() * 31) + Long.hashCode(this.f9907b);
        }

        public String toString() {
            return "DispatchRequest(attachmentId=" + this.f9906a + ", generation=" + this.f9907b + ')';
        }

        public i(String r2, long r3) {
            d.h.b.o.e(r2, "attachmentId");
            this.f9906a = r2;
            this.f9907b = r3;
        }

        public final String a() {
            return this.f9906a;
        }

        public final long b() {
            return this.f9907b;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.r f9909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ParcelFileDescriptor f9911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.p f9912e;
        private final f f;
        private final com.bytedance.safetyguard.lxc.internal.client.c g;
        private final com.bytedance.safetyguard.lxc.internal.client.h h;

        /* JADX INFO: compiled from: ProxyServiceConnector.kt */
        static final class a extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProxyServiceConnector f9913a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ j f9914b;

            a(ProxyServiceConnector r1, j r2) {
                this.f9913a = r1;
                this.f9914b = r2;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                return "component=proxy_connector event=transport_shutdown outcome=failed attachmentRef=" + ProxyServiceConnector.a(this.f9913a).a(j.c(this.f9914b));
            }
        }

        /* JADX INFO: compiled from: ProxyServiceConnector.kt */
        static final class b extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.f<String> f9915a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ j f9916b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ProxyServiceConnector f9917c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f9918d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.bytedance.safetyguard.lxc.internal.client.o f9919e;
            final /* synthetic */ int f;

            b(d.h.b.z.f<String> r1, j r2, ProxyServiceConnector r3, boolean r4, com.bytedance.safetyguard.lxc.internal.client.o r5, int r6) {
                this.f9915a = r1;
                this.f9916b = r2;
                this.f9917c = r3;
                this.f9918d = r4;
                this.f9919e = r5;
                this.f = r6;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                StringBuilder r0 = new StringBuilder().append("component=proxy_connector event=attachment_released outcome=");
                if (d.h.b.o.a(this.f9915a.f38504a, "failed") == false) goto L5;
                String r1 = "partial";
            L7:
                return r0.append(r1).append(" releaseReason=").append(j.a(this.f9916b)).append(" endpointDisposition=").append(j.b(this.f9916b)).append(" attachmentRef=").append(ProxyServiceConnector.a(this.f9917c).a(j.c(this.f9916b))).append(" backupFdClosed=").append(this.f9918d).append(" shutdownAttempted=").append(j.b(this.f9916b).a()).append(" shutdownOutcome=").append((String) ZeusTransformUtils.preCheckCast(this.f9915a.f38504a, String.class, "com.obric.aiagent.plugin")).append(" remainingLeases=").append(this.f9919e.b()).append(" remainingAttachments=").append(this.f).toString();
            L5:
                r1 = "success";
                goto L7
            }
        }

        public j(ProxyServiceConnector r3, com.bytedance.safetyguard.lxc.internal.client.r r4, String r5, ParcelFileDescriptor r6, com.bytedance.safetyguard.lxc.internal.client.p r7, f r8, com.bytedance.safetyguard.lxc.internal.client.c r9, com.bytedance.safetyguard.lxc.internal.client.h r10) {
            com.bytedance.safetyguard.lxc.internal.client.p r11 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "attachment");
            d.h.b.o.e(r5, "attachmentId");
            d.h.b.o.e(r9, "releaseReason");
            d.h.b.o.e(r10, "endpointDisposition");
            this.f9908a = r3;
            this.f9909b = r4;
            this.f9910c = r5;
            this.f9911d = r6;
            this.f9912e = r11;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }

        public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.client.c a(j r0) {
            return r0.g;
        }

        public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.client.h b(j r0) {
            return r0.h;
        }

        public static final /* synthetic */ String c(j r0) {
            return r0.f9910c;
        }

        public final void a() {
            com.bytedance.safetyguard.lxc.internal.client.p r0 = this.f9912e;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            ParcelFileDescriptor r1 = this.f9911d;
            d.h.b.z.f r2 = new d.h.b.z.f();
            r2.f38504a = "not_required";
            if (this.h.a() == false) goto L19;
            if (r1 == null) goto L19;
            ProxyServiceConnector r3 = this.f9908a;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L11
            j r5 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            ProxyServiceConnector.d(r3).shutdown(r1);     // Catch: Throwable -> L11
            Object r6 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L11
        L14:
            if (d.n.a(r6) == false) goto L16;
            d.x r7 = (d.x) ZeusTransformUtils.preCheckCast(r6, d.x.class, "com.obric.aiagent.plugin");
            r2.f38504a = "success";
        L16:
            ProxyServiceConnector r8 = this.f9908a;
            Throwable r9 = d.n.c(r6);
            if (r9 == null) goto L19;
            r2.f38504a = "failed";
            ProxyServiceConnector.a(r8).a("ProxyServiceConnector", r9, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r8, this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        L11:
            th = move-exception;
            d.n.a r10 = d.n.f38560a;
            r6 = d.n.f(d.o.a(th));
        L19:
            ProxyServiceConnector.a(this.f9908a, r1);
            if (r1 != null) goto L22;
        L25:
            boolean r11 = true;
        L26:
            boolean r12 = r11;
            this.f9909b.c();
            f r13 = this.f;
            if (r13 == null) goto L29;
            r13.a();
        L29:
            com.bytedance.safetyguard.lxc.internal.client.o r14 = this.f9908a.a();
            Object r15 = ProxyServiceConnector.c(this.f9908a);
            ProxyServiceConnector r16 = this.f9908a;
            monitor-enter(r15);
            int r17 = ProxyServiceConnector.e(r16).size();     // Catch: Throwable -> L35
            monitor-exit(r15);
            ProxyServiceConnector.a(this.f9908a).b("ProxyServiceConnector", (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r2, this, this.f9908a, r12, r14, r17), d.h.a.a.class, "com.obric.aiagent.plugin"));
            return;
        L35:
            th = move-exception;
            throw th;
        L22:
            if (r1.getFileDescriptor().valid() == false) goto L25;
            r11 = false;
            goto L26
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f9921b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
            return false;
        L8:
            k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9920a, r6.f9920a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9921b, r6.f9921b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9920a.hashCode() * 31) + this.f9921b.hashCode();
        }

        public String toString() {
            return "SidecarCancellationRequest(operationId=" + this.f9920a + ", service=" + this.f9921b + ')';
        }

        public k(String r2, g r3) {
            d.h.b.o.e(r2, "operationId");
            d.h.b.o.e(r3, WsConstants.KEY_SERVICE);
            this.f9920a = r2;
            this.f9921b = r3;
        }

        public final String a() {
            return this.f9920a;
        }

        public final g b() {
            return this.f9921b;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9923b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, l.class) == true) goto L8;
            return false;
        L8:
            l r8 = (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9922a, r8.f9922a) == true) goto L12;
            return false;
        L12:
            if (this.f9923b == r8.f9923b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9922a.hashCode() * 31) + Long.hashCode(this.f9923b);
        }

        public String toString() {
            return "SidecarDispatchRequest(operationId=" + this.f9922a + ", generation=" + this.f9923b + ')';
        }

        public l(String r2, long r3) {
            d.h.b.o.e(r2, "operationId");
            this.f9922a = r2;
            this.f9923b = r3;
        }

        public final String a() {
            return this.f9922a;
        }

        public final long b() {
            return this.f9923b;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f9924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f9925b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
            return false;
        L8:
            m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9924a, r6.f9924a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9925b, r6.f9925b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9924a.hashCode() * 31) + this.f9925b.hashCode();
        }

        public String toString() {
            return "SidecarFailure(record=" + this.f9924a + ", releasePlan=" + this.f9925b + ')';
        }

        public m(n r2, o r3) {
            d.h.b.o.e(r2, "record");
            d.h.b.o.e(r3, "releasePlan");
            this.f9924a = r2;
            this.f9925b = r3;
        }

        public final n a() {
            return this.f9924a;
        }

        public final o b() {
            return this.f9925b;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SidecarCommandParcel f9926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.client.u f9927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f9928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9929d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9930e;
        private boolean f;
        private boolean g;

        public n(SidecarCommandParcel r3, com.bytedance.safetyguard.lxc.internal.client.u r4) {
            com.bytedance.safetyguard.lxc.internal.client.u r5 = (com.bytedance.safetyguard.lxc.internal.client.u) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.client.u.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "command");
            d.h.b.o.e(r5, "callback");
            this.f9926a = r3;
            this.f9927b = r5;
        }

        public final SidecarCommandParcel a() {
            return this.f9926a;
        }

        public final com.bytedance.safetyguard.lxc.internal.client.u b() {
            return this.f9927b;
        }

        public final void a(long r1) {
            this.f9928c = r1;
        }

        public final long c() {
            return this.f9928c;
        }

        public final void a(boolean r1) {
            this.f9929d = r1;
        }

        public final boolean d() {
            return this.f9929d;
        }

        public final void b(boolean r1) {
            this.f9930e = r1;
        }

        public final boolean e() {
            return this.f9930e;
        }

        public final void c(boolean r1) {
            this.f = r1;
        }

        public final boolean f() {
            return this.f;
        }

        public final void d(boolean r1) {
            this.g = r1;
        }

        public final boolean g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f9932b;

        public o(ProxyServiceConnector r1, f r2) {
            this.f9931a = r1;
            this.f9932b = r2;
        }

        public final void a() {
            f r0 = this.f9932b;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f9933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f9934b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
            return false;
        L8:
            p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9933a, r6.f9933a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9934b, r6.f9934b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9933a.hashCode() * 31) + this.f9934b.hashCode();
        }

        public String toString() {
            return "SidecarSessionEndRequest(record=" + this.f9933a + ", service=" + this.f9934b + ')';
        }

        public p(q r2, g r3) {
            d.h.b.o.e(r2, "record");
            d.h.b.o.e(r3, WsConstants.KEY_SERVICE);
            this.f9933a = r2;
            this.f9934b = r3;
        }

        public final q a() {
            return this.f9933a;
        }

        public final g b() {
            return this.f9934b;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f9937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9938d;

        public q(String r2, long r3, long r5) {
            d.h.b.o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            this.f9935a = r2;
            this.f9936b = r3;
            this.f9937c = r5;
        }

        public final String a() {
            return this.f9935a;
        }

        public final long b() {
            return this.f9936b;
        }

        public final void a(boolean r1) {
            this.f9938d = r1;
        }

        public final boolean c() {
            return this.f9938d;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    private final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f9940b;

        public r(ProxyServiceConnector r1, f r2) {
            this.f9939a = r1;
            this.f9940b = r2;
        }

        public final void a() {
            f r0 = this.f9940b;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    public /* synthetic */ class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9941a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.client.g.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.client.g.f9981c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[com.bytedance.safetyguard.lxc.internal.client.g.f9979a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[com.bytedance.safetyguard.lxc.internal.client.g.f9980b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[com.bytedance.safetyguard.lxc.internal.client.g.f9982d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[com.bytedance.safetyguard.lxc.internal.client.g.f9983e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f9941a = r0;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class t extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.client.j f9943b;

        t(ProxyServiceConnector r1, com.bytedance.safetyguard.lxc.internal.client.j r2) {
            this.f9942a = r1;
            this.f9943b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            com.bytedance.safetyguard.lxc.internal.client.o r0 = this.f9942a.a();
            return "component=proxy_connector event=attachment_activated outcome=pending attachmentRef=" + ProxyServiceConnector.a(this.f9942a).a(this.f9943b.a()) + " state=" + r0.a() + " remainingLeases=" + r0.b();
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class u extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f9944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9945b;

        u(e r1, ProxyServiceConnector r2) {
            this.f9944a = r1;
            this.f9945b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=bind_timeout_schedule_failed outcome=failed generation=" + this.f9944a.a() + " timeoutMs=" + ProxyServiceConnector.b(this.f9945b);
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class v extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9947b;

        v(long r1, ProxyServiceConnector r3) {
            this.f9946a = r1;
            this.f9947b = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=bind_timeout outcome=failed generation=" + this.f9946a + " timeoutMs=" + ProxyServiceConnector.b(this.f9947b);
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class w extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9948a;

        w(long r1) {
            this.f9948a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=invalid_diagnostic outcome=ignored generation=" + this.f9948a;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class x extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9949a;

        x(long r1) {
            this.f9949a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=connected outcome=success generation=" + this.f9949a;
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class y extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f9952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f9953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<c> f9954e;
        final /* synthetic */ List<b> f;

        y(long r3, String r5, d.h.b.z.d r6, d.h.b.z.d r7, List<c> r8, List<b> r9) {
            List<c> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            List<b> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            this.f9950a = r3;
            this.f9951b = r5;
            this.f9952c = r6;
            this.f9953d = r7;
            this.f9954e = r10;
            this.f = r11;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_connector event=service_lost outcome=failed generation=" + this.f9950a + " reason=" + this.f9951b + " committedAttachments=" + this.f9952c.f38502a + " pendingAttachments=" + this.f9953d.f38502a + " terminalAttachments=" + this.f9954e.size() + " pendingAttachRetries=" + this.f.size();
        }
    }

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    static final class z extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxySessionResult f9955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxyServiceConnector f9956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f9958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.client.w f9959e;

        z(ProxySessionResult r1, ProxyServiceConnector r2, String r3, long r4, com.bytedance.safetyguard.lxc.internal.client.w r6) {
            this.f9955a = r1;
            this.f9956b = r2;
            this.f9957c = r3;
            this.f9958d = r4;
            this.f9959e = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder().append("component=proxy_connector event=terminal_received outcome=").append(this.f9955a.getCloseReason()).append(" attachmentRef=").append(ProxyServiceConnector.a(this.f9956b).a(this.f9957c)).append(" generation=").append(this.f9958d).append(" closeReason=").append(this.f9955a.getCloseReason()).append(" errorCode=").append(this.f9955a.getErrorCode()).append(" hasTerminalAction=");
            if (this.f9959e == null) goto L5;
            boolean r3 = true;
        L7:
            return r0.append(r3).toString();
        L5:
            r3 = false;
            goto L7
        }
    }

    public static /* synthetic */ void lambda$1gb36C37ldKqfQGODqPLaZjT2F0(ProxyServiceConnector r0, long r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$8Ifa5wnv94kLN24ZkOm4o9jemGs(ProxyServiceConnector r0, e r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8V_9G3SlsSIUdrSFweeELvj-5mk, reason: not valid java name */
    public static /* synthetic */ Thread m39lambda$8V_9G3SlsSIUdrSFweeELvj5mk(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$9Fwb_A4NJr44Jb2B9vldm-69oLw, reason: not valid java name */
    public static /* synthetic */ void m40lambda$9Fwb_A4NJr44Jb2B9vldm69oLw(ProxyServiceConnector r0, k r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ITi5S_6UbAQW6Seg-emnNS13-zk, reason: not valid java name */
    public static /* synthetic */ void m41lambda$ITi5S_6UbAQW6SegemnNS13zk(ProxyServiceConnector r0, i r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$VETUWFtaKv4UzqH7A6eh5VoIaQU(ProxyServiceConnector r0, b r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$rX5mRM2tQmd8-hmLsOr7fngV38g, reason: not valid java name */
    public static /* synthetic */ void m42lambda$rX5mRM2tQmd8hmLsOr7fngV38g(ProxyServiceConnector r0, l r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$wO6enlgCt__Qn8uILKg6xju54kQ(ProxyServiceConnector r0, h r1) {
        a(r0, r1);
    }

    public ProxyServiceConnector(Context r3, com.bytedance.safetyguard.lxc.internal.client.m r4, com.bytedance.safetyguard.lxc.internal.client.k r5, com.bytedance.safetyguard.lxc.internal.d.p r6, Executor r7, com.bytedance.safetyguard.lxc.internal.client.q r8, com.bytedance.safetyguard.lxc.internal.client.q r9, long r10, com.bytedance.safetyguard.lxc.internal.a.e r12) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.m r13 = (com.bytedance.safetyguard.lxc.internal.client.m) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.client.m.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.k r14 = (com.bytedance.safetyguard.lxc.internal.client.k) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.client.k.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.p r15 = (com.bytedance.safetyguard.lxc.internal.d.p) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.safetyguard.lxc.internal.d.p.class, "com.obric.aiagent.plugin");
        Executor r16 = (Executor) ZeusTransformUtils.wrapperContextForParams(r7, Executor.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.q r17 = (com.bytedance.safetyguard.lxc.internal.client.q) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.safetyguard.lxc.internal.client.q.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.q r18 = (com.bytedance.safetyguard.lxc.internal.client.q) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.safetyguard.lxc.internal.client.q.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r19 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        d.h.b.o.e(r13, "binding");
        d.h.b.o.e(r14, "fdDuplicator");
        d.h.b.o.e(r15, "endpointTerminator");
        d.h.b.o.e(r16, "worker");
        d.h.b.o.e(r17, "recoveryTimeoutScheduler");
        d.h.b.o.e(r18, "bindingTimeoutScheduler");
        d.h.b.o.e(r19, "logger");
        this.f9866a = r13;
        this.f9867b = r14;
        this.f9868c = r15;
        this.f9869d = r16;
        this.f9870e = r17;
        this.f = r18;
        this.g = r10;
        this.h = r19;
        this.i = new Object();
        this.j = new Binder();
        this.k = new LinkedHashMap();
        this.l = new ArrayDeque();
        EnumMap<com.bytedance.safetyguard.lxc.internal.client.d, Integer> r20 = new EnumMap(com.bytedance.safetyguard.lxc.internal.client.d.class);
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.client.d.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        boolean r22 = false;
        if (r21.hasNext() == false) goto L6;
        r20.put((Enum) ZeusTransformUtils.preCheckCast((com.bytedance.safetyguard.lxc.internal.client.d) ZeusTransformUtils.preCheckCast(r21.next(), com.bytedance.safetyguard.lxc.internal.client.d.class, "com.obric.aiagent.plugin"), Enum.class, "com.obric.aiagent.plugin"), 0);
        goto L3
    L6:
        this.m = r20;
        this.n = new LinkedHashMap();
        this.o = new ArrayDeque();
        this.p = new LinkedHashMap();
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9979a;
        if (this.g <= 0) goto L9;
        r22 = true;
    L9:
        if (r22 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Proxy service bind timeout must be positive".toString());
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.e a(ProxyServiceConnector r0) {
        return r0.h;
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, int r3, String r4) {
        r0.a(r1, r3, r4);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, int r3, String r4, String r5, int r6) {
        r0.a(r1, r3, r4, r5, r6);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r2, long r3, IBinder r5) {
        r2.a(r3, (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, ProxyDiagnosticParcel r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, SidecarResultParcel r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, String r3) {
        r0.b(r1, r3);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, String r3, ProxyReadyParcel r4) {
        r0.a(r1, r3, r4);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, long r1, String r3, ProxySessionResultParcel r4) {
        r0.a(r1, r3, r4);
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r2, ServiceConnection r3) {
        r2.a((ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(ProxyServiceConnector r0, ParcelFileDescriptor r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ long b(ProxyServiceConnector r2) {
        return r2.g;
    }

    public static final /* synthetic */ void b(ProxyServiceConnector r0, long r1, String r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ Object c(ProxyServiceConnector r0) {
        return r0.i;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.d.p d(ProxyServiceConnector r0) {
        return r0.f9868c;
    }

    public static final /* synthetic */ LinkedHashMap e(ProxyServiceConnector r0) {
        return r0.k;
    }

    public static final /* synthetic */ Binder f(ProxyServiceConnector r0) {
        return r0.j;
    }

    public /* synthetic */ ProxyServiceConnector(Context r13, com.bytedance.safetyguard.lxc.internal.client.m r14, com.bytedance.safetyguard.lxc.internal.client.k r15, com.bytedance.safetyguard.lxc.internal.d.p r16, Executor r17, com.bytedance.safetyguard.lxc.internal.client.q r18, com.bytedance.safetyguard.lxc.internal.client.q r19, long r20, com.bytedance.safetyguard.lxc.internal.a.e r22, int r23, d.h.b.h r24) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.m r3 = (com.bytedance.safetyguard.lxc.internal.client.m) ZeusTransformUtils.wrapperContextForParams(r14, com.bytedance.safetyguard.lxc.internal.client.m.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.k r4 = (com.bytedance.safetyguard.lxc.internal.client.k) ZeusTransformUtils.wrapperContextForParams(r15, com.bytedance.safetyguard.lxc.internal.client.k.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.p r5 = (com.bytedance.safetyguard.lxc.internal.d.p) ZeusTransformUtils.wrapperContextForParams(r16, com.bytedance.safetyguard.lxc.internal.d.p.class, "com.obric.aiagent.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r17, Executor.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.q r7 = (com.bytedance.safetyguard.lxc.internal.client.q) ZeusTransformUtils.wrapperContextForParams(r18, com.bytedance.safetyguard.lxc.internal.client.q.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.q r8 = (com.bytedance.safetyguard.lxc.internal.client.q) ZeusTransformUtils.wrapperContextForParams(r19, com.bytedance.safetyguard.lxc.internal.client.q.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r9 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r22, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        if ((r23 & 2) == 0) goto L6;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r10, "getApplicationContext(...)");
        r3 = (com.bytedance.safetyguard.lxc.internal.client.m) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.client.b(r10), com.bytedance.safetyguard.lxc.internal.client.m.class, "com.obric.aiagent.plugin");
    L6:
        if ((r23 & 4) == 0) goto L9;
        r4 = com.bytedance.safetyguard.lxc.internal.client.k.f10004a.a();
    L9:
        if ((r23 & 8) == 0) goto L12;
        r5 = com.bytedance.safetyguard.lxc.internal.d.p.f10254a.a();
    L12:
        if ((r23 & 16) == 0) goto L15;
        ExecutorService r11 = Executors.newCachedThreadPool($$Lambda$ProxyServiceConnector$8V_9G3SlsSIUdrSFweeELvj5mk.INSTANCE);
        d.h.b.o.c(r11, "newCachedThreadPool(...)");
        r6 = (Executor) ZeusTransformUtils.preCheckCast(r11, Executor.class, "com.obric.aiagent.plugin");
    L15:
        if ((r23 & 32) == 0) goto L18;
        r7 = (com.bytedance.safetyguard.lxc.internal.client.q) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.client.f.f9977a, com.bytedance.safetyguard.lxc.internal.client.q.class, "com.obric.aiagent.plugin");
    L18:
        if ((r23 & 64) == 0) goto L21;
        r8 = (com.bytedance.safetyguard.lxc.internal.client.q) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.client.f.f9977a, com.bytedance.safetyguard.lxc.internal.client.q.class, "com.obric.aiagent.plugin");
    L21:
        if ((r23 & 128) == 0) goto L23;
        long r12 = 4000;
    L25:
        if ((r23 & 256) == 0) goto L27;
        r9 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.a.d.f9723a, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
    L27:
        this(r1, r3, r4, r5, r6, r7, r8, r12, r9);
        return;
    L23:
        r12 = r20;
        goto L25
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "safetyguard-proxy-connector");
        r0.setDaemon(true);
        return r0;
    }

    public final Object a(ParcelFileDescriptor r3) {
        d.h.b.o.e(r3, "input");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r1 = d.n.f(this.f9867b.dup(r3));     // Catch: Throwable -> L5
    L4:
        b(r3);
        return r1;
    L5:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
        r1 = d.n.f(d.o.a(th));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        b(r3);
        throw th;
    }

    public final Object a(com.bytedance.safetyguard.lxc.internal.client.r r11, ProxyAttachRequestParcel r12, ParcelFileDescriptor r13, IOutboundPolicyCallback r14) {
        IOutboundPolicyCallback r3 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r14, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "attachment");
        d.h.b.o.e(r12, Ext.KEY_REQUEST);
        d.h.b.o.e(r13, "backupFd");
        Object r15 = this.i;
        monitor-enter(r15);
        IllegalStateException r6 = null;
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9983e) goto L9;
        IllegalStateException r16 = new IllegalStateException("ProxyServiceConnector is closed");     // Catch: Throwable -> L25
    L7:
        r6 = r16;
        com.bytedance.safetyguard.lxc.internal.client.j r17 = null;
    L15:
        monitor-exit(r15);
        if (r6 == null) goto L19;
        b(r13);
        d.n.a r10 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        this.h.a("ProxyServiceConnector", (d.h.a.a) ZeusTransformUtils.preCheckCast(new ab(this, r12), d.h.a.a.class, "com.obric.aiagent.plugin"));
        d.n.a r18 = d.n.f38560a;
        if (r17 == null) goto L24;
        return d.n.f(r17);
    L24:
        throw new IllegalArgumentException("Required value was null.".toString());
    L9:
        if (r11.a() == false) goto L12;
        r16 = new IllegalStateException("proxy attachment was closed before reservation");     // Catch: Throwable -> L25
        goto L7
    L12:
        if (this.k.containsKey(r12.getAttachmentId()) == false) goto L14;
        r16 = new IllegalStateException("proxy attachment already exists: " + r12.getAttachmentId());     // Catch: Throwable -> L25
        goto L7
    L14:
        Object r7 = new Object();     // Catch: Throwable -> L25
        ((Map) ZeusTransformUtils.preCheckCast(this.k, Map.class, "com.obric.aiagent.plugin")).put(r12.getAttachmentId(), new d(r11, r12, r3, r13, r7));     // Catch: Throwable -> L25
        r17 = new com.bytedance.safetyguard.lxc.internal.client.j(r12.getAttachmentId(), r7);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final boolean a(com.bytedance.safetyguard.lxc.internal.client.j r9) {
        d.h.b.o.e(r9, "start");
        Object r0 = this.i;
        monitor-enter(r0);
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.k.get(r9.a()), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        e r2 = null;
        if (r1 != null) goto L7;
    L33:
        i r3 = null;
        boolean r5 = false;
    L34:
        monitor-exit(r0);
        if (r5 == true) goto L37;
        return false;
    L37:
        this.h.a("ProxyServiceConnector", (d.h.a.a) ZeusTransformUtils.preCheckCast(new t(this, r9), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L40;
        a(r2);
    L40:
        if (r3 == null) goto L42;
        a(r3);
    L42:
        return true;
    L7:
        if (r1.e() != r9.b()) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L33;
        if (r1.p() == true) goto L33;
        if (r1.f() == true) goto L31;
        r1.a(true);     // Catch: Throwable -> L43
        r1.b(true);     // Catch: Throwable -> L43
        a(com.bytedance.safetyguard.lxc.internal.client.d.f9968a);     // Catch: Throwable -> L43
        c(r1);     // Catch: Throwable -> L43
        int r7 = s.f9941a[this.q.ordinal()];     // Catch: Throwable -> L43
        if (r7 != 1) goto L22;
        r3 = b(r1);     // Catch: Throwable -> L43
    L32:
        r5 = true;
        goto L34
    L22:
        if (r7 != 2) goto L24;
        r2 = b();     // Catch: Throwable -> L43
        r3 = null;
        goto L32
    L24:
        if (r7 != 5) goto L31;
        throw new IllegalStateException("closed connector cannot retain an attachment".toString());     // Catch: Throwable -> L43
    L31:
        r3 = null;
        goto L32
    L9:
        r6 = false;
    L43:
        th = move-exception;
        throw th;
    }

    public final void a(String r12) {
        d.h.b.o.e(r12, "attachmentId");
        Object r0 = this.i;
        monitor-enter(r0);
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.k.get(r12), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r3 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        d.h.b.o.a(r3);     // Catch: Throwable -> L32
        if (r3.p() == false) goto L13;
        monitor-exit(r0);
        return;
    L13:
        r3.g(true);     // Catch: Throwable -> L32
        r3.a(com.bytedance.safetyguard.lxc.internal.client.c.f9963a);     // Catch: Throwable -> L32
        this.l.remove(r12);     // Catch: Throwable -> L32
        j r1 = null;
        if (r3.j() == null) goto L16;
    L24:
        h r13 = null;
    L25:
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L32
        monitor-exit(r0);
        if (r1 == null) goto L29;
        r1.a();
    L29:
        if (r13 == null) goto L37;
        a(r13);
        return;
    L37:
        return;
    L16:
        if (r3.i() != null) goto L24;
        if (r3.k() == false) goto L23;
        r13 = a(r3, com.bytedance.safetyguard.lxc.internal.client.c.f9963a);     // Catch: Throwable -> L32
        if (r13 != null) goto L25;
        r1 = a(this, r3, com.bytedance.safetyguard.lxc.internal.client.c.f9963a, com.bytedance.safetyguard.lxc.internal.client.h.f9986c, false, false, 24, null);     // Catch: Throwable -> L32
        goto L25
    L23:
        r1 = a(this, r3, com.bytedance.safetyguard.lxc.internal.client.c.f9963a, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L32
        r13 = null;
    L32:
        th = move-exception;
        throw th;
    }

    public final Object a(String r9, String r10) {
        d.h.b.o.e(r9, "attachmentId");
        d.h.b.o.e(r10, "outboundSensitiveDataJson");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        ProxyServiceConnector r3 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r10);     // Catch: Throwable -> L5
        Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = d.n.c(r4);
        if (r5 != null) goto L25;
        Object r6 = d(r9);
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L23;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin");
        ActionActivationResultParcel r11 = r8.b().b().activateAction(3, r9, (IBinder) ZeusTransformUtils.preCheckCast(this.j, IBinder.class, "com.obric.aiagent.plugin"), r10);     // Catch: Exception -> L19 DeadObjectException -> L21
        goto L20
    L14:
        if (a(r8) == true) goto L18;
        return a(9, "Action service generation changed");
    L18:
        return a(r11);
    L21:
        b(r8.b().a(), "action_activate_dead_object");
        return a(9, "Action service is unavailable");
    L20:
        return a(9, "Action service is unavailable");
    L23:
        d.n.a r12 = d.n.f38560a;
        return d.n.f(d.o.a(r7));
    L25:
        d.n.a r13 = d.n.f38560a;
        return d.n.f(d.o.a(r5));
    L5:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L7
    }

    public final Object a(String r9, ActionContextToken r10) {
        d.h.b.o.e(r9, "attachmentId");
        d.h.b.o.e(r10, "token");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        ProxyServiceConnector r3 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r11 = d.n.f(com.bytedance.safetyguard.lxc.internal.client.l.a(r10));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = d.n.c(r11);
        if (r4 != null) goto L25;
        ActionContextTokenParcel r12 = (ActionContextTokenParcel) ZeusTransformUtils.preCheckCast(r11, ActionContextTokenParcel.class, "com.obric.aiagent.plugin");
        Object r5 = d(r9);
        Throwable r6 = d.n.c(r5);
        if (r6 != null) goto L23;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        ActionFinishResultParcel r13 = r7.b().b().finishAction(3, r9, (IBinder) ZeusTransformUtils.preCheckCast(this.j, IBinder.class, "com.obric.aiagent.plugin"), r12);     // Catch: Exception -> L19 DeadObjectException -> L21
        goto L20
    L14:
        if (a(r7) == true) goto L18;
        return a(9, "Action service generation changed");
    L18:
        return a(r13);
    L21:
        b(r7.b().a(), "action_finish_dead_object");
        return a(9, "Action service is unavailable");
    L20:
        return a(9, "Action service is unavailable");
    L23:
        d.n.a r8 = d.n.f38560a;
        return d.n.f(d.o.a(r6));
    L25:
        d.n.a r14 = d.n.f38560a;
        return d.n.f(d.o.a(r4));
    L5:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(SidecarCommandParcel r6, com.bytedance.safetyguard.lxc.internal.client.u r7) {
        com.bytedance.safetyguard.lxc.internal.client.u r8 = (com.bytedance.safetyguard.lxc.internal.client.u) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.safetyguard.lxc.internal.client.u.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "command");
        d.h.b.o.e(r8, "callback");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r2 = d.n.f(com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r6));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = d.n.c(r2);
        if (r3 != null) goto L43;
        Object r4 = this.i;
        monitor-enter(r4);
        IllegalStateException r5 = null;
        e r9 = null;
        r5 = null;
        r5 = null;
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9983e) goto L15;
        l r10 = 0;
        r5 = new IllegalStateException("ProxyServiceConnector is closed");     // Catch: Throwable -> L40
        r9 = null;
    L30:
        monitor-exit(r4);
        if (r5 == null) goto L34;
        d.n.a r11 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin")));
    L34:
        if (r9 == null) goto L36;
        a(r9);
    L36:
        if (r10 == 0) goto L38;
        a(r10);
    L38:
        d.n.a r12 = d.n.f38560a;
        return d.n.f(d.x.f38692a);
    L15:
        if (this.n.containsKey(r6.getOperationId()) == false) goto L18;
        r5 = new IllegalStateException("sidecar operation already exists: " + r6.getOperationId());     // Catch: Throwable -> L40
    L17:
        r10 = r5;
        goto L30
    L18:
        n r13 = new n(r6, r8);     // Catch: Throwable -> L40
        ((Map) ZeusTransformUtils.preCheckCast(this.n, Map.class, "com.obric.aiagent.plugin")).put(r6.getOperationId(), r13);     // Catch: Throwable -> L40
        this.o.addLast(r6.getOperationId());     // Catch: Throwable -> L40
        a(com.bytedance.safetyguard.lxc.internal.client.d.f9969b);     // Catch: Throwable -> L40
        int r14 = s.f9941a[this.q.ordinal()];     // Catch: Throwable -> L40
        if (r14 == 1) goto L29;
        if (r14 != 2) goto L23;
        r9 = b();     // Catch: Throwable -> L40
        r10 = 0;
        goto L30
    L23:
        if (r14 != 5) goto L17;
        throw new IllegalStateException("handled above".toString());     // Catch: Throwable -> L40
    L29:
        r10 = a(r13);     // Catch: Throwable -> L40
        r9 = null;
    L40:
        th = move-exception;
        throw th;
    L43:
        d.n.a r15 = d.n.f38560a;
        return d.n.f(d.o.a(r3));
    L5:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L7
    }

    public final boolean b(String r7) {
        d.h.b.o.e(r7, "operationId");
        Object r0 = this.i;
        monitor-enter(r0);
        n r1 = (n) ZeusTransformUtils.preCheckCast(this.n.get(r7), n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        d.h.b.o.a(r1);     // Catch: Throwable -> L24
        if (r1.g() == false) goto L14;
        monitor-exit(r0);
        return false;
    L14:
        r1.d(true);     // Catch: Throwable -> L24
        this.o.remove(r7);     // Catch: Throwable -> L24
        if (r1.e() == false) goto L18;
        monitor-exit(r0);
        return true;
    L18:
        k r8 = b(r1);     // Catch: Throwable -> L24
        o r2 = a(this, r1, false, 2, null);     // Catch: Throwable -> L24
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L24
        monitor-exit(r0);
        r2.a();
        if (r8 == null) goto L23;
        a(r8);
    L23:
        return true;
    L24:
        th = move-exception;
        throw th;
    }

    public final Object c(String r9) {
        d.h.b.o.e(r9, ObricMemoryConstants.KEY_SESSION_ID);
        Object r0 = this.i;
        monitor-enter(r0);
        q r1 = (q) ZeusTransformUtils.preCheckCast(this.p.get(r9), q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r1 != null) goto L9;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L44
        Object r10 = d.n.f(false);     // Catch: Throwable -> L44
        monitor-exit(r0);
        return r10;
    L9:
        d.h.b.o.a(r1);     // Catch: Throwable -> L44
        if (r1.c() == false) goto L14;
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L44
        Object r12 = d.n.f(false);     // Catch: Throwable -> L44
        monitor-exit(r0);
        return r12;
    L14:
        g r3 = this.t;     // Catch: Throwable -> L44
        if (r3 != null) goto L17;
    L41:
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L44
        Object r14 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Proxy service is unavailable"), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L44
        monitor-exit(r0);
        return r14;
    L17:
        if (r3.a() != r1.b()) goto L19;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        r3 = null;
    L24:
        if (r3 == null) goto L41;
        r1.a(true);     // Catch: Throwable -> L44
        p r5 = new p(r1, r3);     // Catch: Throwable -> L44
        monitor-exit(r0);
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L29
        Object r15 = d.n.f(Boolean.valueOf(r5.b().b().endSidecarSession(3, r9, (IBinder) ZeusTransformUtils.preCheckCast(((ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin")).j, IBinder.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L29
    L31:
        Object r6 = this.i;
        monitor-enter(r6);
        r r16 = a(this, r5.a(), false, 2, null);     // Catch: Throwable -> L38
        monitor-exit(r6);
        if (r16 == null) goto L37;
        r16.a();
    L37:
        return r15;
    L38:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
        goto L31
    L19:
        r4 = false;
    L44:
        th = move-exception;
        throw th;
    }

    public final com.bytedance.safetyguard.lxc.internal.client.o a() {
        Object r0 = this.i;
        monitor-enter(r0);
        com.bytedance.safetyguard.lxc.internal.client.g r2 = this.q;     // Catch: Throwable -> L24
        long r3 = this.r;     // Catch: Throwable -> L24
        int r5 = this.o.size() + this.l.size();     // Catch: Throwable -> L24
        int r6 = c(com.bytedance.safetyguard.lxc.internal.client.d.f9968a);     // Catch: Throwable -> L24
        int r7 = c(com.bytedance.safetyguard.lxc.internal.client.d.f9969b);     // Catch: Throwable -> L24
        int r8 = c(com.bytedance.safetyguard.lxc.internal.client.d.f9970c);     // Catch: Throwable -> L24
        Collection<d> r13 = this.k.values();     // Catch: Throwable -> L24
        d.h.b.o.c(r13, "<get-values>(...)");     // Catch: Throwable -> L24
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        int r9 = 0;
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L7;
    L9:
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L24
        int r1 = 0;
    L11:
        if (r15.hasNext() == false) goto L20;
        if (((d) ZeusTransformUtils.preCheckCast(r15.next(), d.class, "com.obric.aiagent.plugin")).d() == null) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L11;
        r1 = r1 + 1;     // Catch: Throwable -> L24
        if (r1 >= 0) goto L11;
        d.a.p.d();     // Catch: Throwable -> L24
        goto L11
    L15:
        r10 = false;
        goto L16
    L20:
        r9 = r1;
    L21:
        com.bytedance.safetyguard.lxc.internal.client.o r16 = new com.bytedance.safetyguard.lxc.internal.client.o(r2, r3, r5, r6, r7, r8, r9);     // Catch: Throwable -> L24
        monitor-exit(r0);
        return r16;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
    L24:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v22, types: [T, java.util.List] */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.h.b.z.f r9 = new d.h.b.z.f();
        d.h.b.z.f r10 = new d.h.b.z.f();
        Object r11 = this.i;
        monitor-enter(r11);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9983e) goto L8;
        monitor-exit(r11);
        return;
    L8:
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9983e;     // Catch: Throwable -> L48
        this.l.clear();     // Catch: Throwable -> L48
        this.o.clear();     // Catch: Throwable -> L48
        Collection<d> r1 = this.k.values();     // Catch: Throwable -> L48
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L48
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        Iterator r14 = r2.iterator();     // Catch: Throwable -> L48
    L10:
        if (r14.hasNext() == false) goto L27;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r14.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        r3.g(true);     // Catch: Throwable -> L48
        r3.a(com.bytedance.safetyguard.lxc.internal.client.c.f9964b);     // Catch: Throwable -> L48
        if (r3.k() == true) goto L16;
        if (r3.j() != null) goto L16;
    L20:
        if (r3.k() == false) goto L22;
    L25:
        com.bytedance.safetyguard.lxc.internal.client.h r4 = com.bytedance.safetyguard.lxc.internal.client.h.f9986c;     // Catch: Throwable -> L48
    L18:
        com.bytedance.safetyguard.lxc.internal.client.h r5 = r4;
        com.bytedance.safetyguard.lxc.internal.client.r r15 = r3.a();     // Catch: Throwable -> L48
        d.h.b.o.a(r3);     // Catch: Throwable -> L48
        r13.add(d.s.a(r15, a(this, r3, com.bytedance.safetyguard.lxc.internal.client.c.f9964b, r5, false, false, 16, null)));     // Catch: Throwable -> L48
        goto L10
    L22:
        if (r3.j() != null) goto L25;
        r4 = com.bytedance.safetyguard.lxc.internal.client.h.f9984a;     // Catch: Throwable -> L48
    L16:
        if (this.t == null) goto L20;
        r4 = com.bytedance.safetyguard.lxc.internal.client.h.f9985b;     // Catch: Throwable -> L48
        goto L18
    L27:
        r9.f38504a = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        Collection<n> r6 = this.n.values();     // Catch: Throwable -> L48
        d.h.b.o.c(r6, "<get-values>(...)");     // Catch: Throwable -> L48
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        Iterator r12 = r7.iterator();     // Catch: Throwable -> L48
    L29:
        if (r12.hasNext() == false) goto L31;
        n r16 = (n) ZeusTransformUtils.preCheckCast(r12.next(), n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        r8.add(d.s.a(r16.a().getOperationId(), r16.b()));     // Catch: Throwable -> L48
        goto L29
    L31:
        r10.f38504a = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        this.n.clear();     // Catch: Throwable -> L48
        this.p.clear();     // Catch: Throwable -> L48
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.client.d.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L48
    L33:
        if (r17.hasNext() == false) goto L35;
        com.bytedance.safetyguard.lxc.internal.client.d r18 = (com.bytedance.safetyguard.lxc.internal.client.d) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.safetyguard.lxc.internal.client.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        ((Map) ZeusTransformUtils.preCheckCast(this.m, Map.class, "com.obric.aiagent.plugin")).put(r18, 0);     // Catch: Throwable -> L48
        goto L33
    L35:
        f r0 = b(true);     // Catch: Throwable -> L48
        d.x r19 = d.x.f38692a;     // Catch: Throwable -> L48
        monitor-exit(r11);
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.f38504a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L39:
        if (r20.hasNext() == false) goto L41;
        d.m r21 = (d.m) ZeusTransformUtils.preCheckCast(r20.next(), d.m.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.r r22 = (com.bytedance.safetyguard.lxc.internal.client.r) ZeusTransformUtils.preCheckCast(r21.c(), com.bytedance.safetyguard.lxc.internal.client.r.class, "com.obric.aiagent.plugin");
        j r23 = (j) ZeusTransformUtils.preCheckCast(r21.d(), j.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.r.a(r22, com.bytedance.safetyguard.lxc.internal.client.n.a(r22.getSessionId(), ProxySessionErrorCode.SERVICE_UNAVAILABLE, "Proxy service connector closed"), null, 2, null);
        r23.a();
        goto L39
    L41:
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.f38504a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L43:
        if (r24.hasNext() == false) goto L45;
        d.m r25 = (d.m) ZeusTransformUtils.preCheckCast(r24.next(), d.m.class, "com.obric.aiagent.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25.c(), String.class, "com.obric.aiagent.plugin");
        ((com.bytedance.safetyguard.lxc.internal.client.u) ZeusTransformUtils.preCheckCast(r25.d(), com.bytedance.safetyguard.lxc.internal.client.u.class, "com.obric.aiagent.plugin")).a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r26, "Proxy service connector closed"));
        goto L43
    L45:
        if (r0 == null) goto L58;
        r0.a();
        return;
    }

    private final e b() {
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9979a) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L17;
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9979a) goto L13;
        com.bytedance.safetyguard.lxc.internal.client.e r1 = com.bytedance.safetyguard.lxc.internal.client.e.f9973a;
    L14:
        com.bytedance.safetyguard.lxc.internal.client.e r5 = r1;
        long r2 = 1 + this.r;
        this.r = r2;
        e r3 = new e(r2, (ServiceConnection) ZeusTransformUtils.preCheckCast(new GenerationServiceConnection(this, r2), ServiceConnection.class, "com.obric.aiagent.plugin"), r5, false, null, 24, null);
        this.s = r3;
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9980b;
        return r3;
    L13:
        r1 = com.bytedance.safetyguard.lxc.internal.client.e.f9974b;
        goto L14
    L17:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        if (this.q == com.bytedance.safetyguard.lxc.internal.client.g.f9982d) goto L8;
        r0 = false;
        goto L9
    }

    private final void a(e r8) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        Object r1 = d.n.f(Boolean.valueOf(((ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin")).f9866a.a(r8.b())));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = d.n.c(r1);
        if (r2 == null) goto L9;
        this.h.a("ProxyServiceConnector", r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new aa(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L9:
        boolean r3 = false;
        if (d.n.b(r1) == false) goto L12;
        r1 = false;
    L12:
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Object r5 = this.i;
        monitor-enter(r5);
        boolean r6 = true;
        if (this.s == r8) goto L17;
        r6 = false;
        r3 = r4;
        boolean r7 = false;
    L29:
        d.x r9 = d.x.f38692a;     // Catch: Throwable -> L38
        monitor-exit(r5);
        if (r3 == false) goto L33;
        a(r8.b());
    L33:
        if (r6 == false) goto L35;
        a(r8.a(), "Unable to bind SafetyGuard proxy service");
        return;
    L35:
        if (r7 == false) goto L46;
        b(r8);
        return;
    L46:
        return;
    L17:
        r8.a(r4);     // Catch: Throwable -> L38
        if (r4 == false) goto L20;
    L22:
        if (r4 == true) goto L24;
    L28:
        r7 = false;
        r6 = false;
        goto L29
    L24:
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9980b) goto L28;
        if (r8.c() != com.bytedance.safetyguard.lxc.internal.client.e.f9973a) goto L28;
        r7 = true;
        r6 = false;
        goto L29
    L20:
        if (this.q == com.bytedance.safetyguard.lxc.internal.client.g.f9981c) goto L22;
        r7 = false;
    L38:
        th = move-exception;
        throw th;
    L4:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L6
    }

    private final void b(final e r7) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        final ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        Object r2 = d.n.f(r1.f.a(r1.g, new $$Lambda$ProxyServiceConnector$8Ifa5wnv94kLN24ZkOm4o9jemGs(r1, r7)));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = d.n.c(r2);
        if (r3 != null) goto L24;
        com.bytedance.safetyguard.lxc.internal.client.p r4 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
        Object r5 = this.i;
        monitor-enter(r5);
    L21:
        th = move-exception;
        throw th;
    L11:
        if (this.s == r7) goto L13;
    L16:
        boolean r6 = true;
    L17:
        monitor-exit(r5);
        if (r6 == false) goto L30;
        r4.cancel();
        return;
    L30:
        return;
    L13:
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9980b) goto L16;
        r7.a(r4);     // Catch: Throwable -> L21
        r6 = false;
        goto L17
    L24:
        this.h.a("ProxyServiceConnector", r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new u(r7, this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        a(r7.a(), "Unable to schedule proxy service bind timeout");
        return;
    L4:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L6
    }

    private static final void a(ProxyServiceConnector r2, e r3) {
        d.h.b.o.e(r2, "$this_runCatching");
        d.h.b.o.e(r3, "$attempt");
        r2.a(r3.a());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v22, types: [T, com.bytedance.safetyguard.lxc.internal.client.p] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.util.List] */
    private final void a(final long r19, IBinder r21) {
        IBinder r11 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r21, IBinder.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L6;
        ((ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin")).a(r19, "Proxy service returned a null binder");
        return;
    L6:
        ISafetyGuardRuntimeService r5 = ISafetyGuardRuntimeService.Stub.asInterface(r11);
        if (r5 != null) goto L10;
        ((ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin")).a(r19, "Proxy service binder has an incompatible interface");
        return;
    L10:
        IBinder.DeathRecipient r12 = new $$Lambda$ProxyServiceConnector$1gb36C37ldKqfQGODqPLaZjT2F0(this, r19);
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L13
        ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r11.linkToDeath(r12, 0);     // Catch: Throwable -> L13
        Object r2 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L13
    L16:
        if (d.n.b(r2) == false) goto L19;
        b(r19, "binder_already_dead");
        return;
    L19:
        d.h.b.z.f r3 = new d.h.b.z.f();
        d.h.b.z.f r14 = new d.h.b.z.f();
        r14.f38504a = d.a.p.b();
        d.h.b.z.f r15 = new d.h.b.z.f();
        r15.f38504a = d.a.p.b();
        Object r7 = this.i;
        monitor-enter(r7);
        e r6 = this.s;     // Catch: Throwable -> L73
        if (r6 != null) goto L24;
    L50:
        Object r17 = r7;
        boolean r4 = false;
    L51:
        d.x r8 = d.x.f38692a;     // Catch: Throwable -> L71
        monitor-exit(r17);
        com.bytedance.safetyguard.lxc.internal.client.p r9 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.preCheckCast(r3.f38504a, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L56;
        r9.cancel();
    L56:
        if (r4 == false) goto L77;
        this.h.a("ProxyServiceConnector", (d.h.a.a) ZeusTransformUtils.preCheckCast(new x(r19), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.f38504a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L64:
        if (r10.hasNext() == false) goto L66;
        a((i) ZeusTransformUtils.preCheckCast(r10.next(), i.class, "com.obric.aiagent.plugin"));
        goto L64
    L66:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r15.f38504a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L68:
        if (r13.hasNext() == false) goto L70;
        a((l) ZeusTransformUtils.preCheckCast(r13.next(), l.class, "com.obric.aiagent.plugin"));
        goto L68
    L70:
        return;
    L77:
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L59
        ProxyServiceConnector r18 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        d.n.f(Boolean.valueOf(r11.unlinkToDeath(r12, 0)));     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L71:
        th = th;
    L75:
        monitor-exit(r17);
        throw th;
    L24:
        if (r6.a() != r19) goto L50;
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9980b) goto L50;
        if (c() <= 0) goto L50;
        r17 = r7;
        this.t = new g(r19, r5, r11, r12);     // Catch: Throwable -> L71
        ?? r22 = r6.e();     // Catch: Throwable -> L71
        r6.a(null);     // Catch: Throwable -> L71
        r3.f38504a = r22;     // Catch: Throwable -> L71
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9981c;     // Catch: Throwable -> L71
        r4 = true;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(this.l, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Iterator r25 = r23.iterator();     // Catch: Throwable -> L71
    L33:
        if (r25.hasNext() == false) goto L40;
        d r26 = (d) ZeusTransformUtils.preCheckCast(this.k.get((String) ZeusTransformUtils.preCheckCast(r25.next(), String.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        if (r26 == null) goto L37;
        d.h.b.o.a(r26);     // Catch: Throwable -> L71
        i r27 = b(r26);     // Catch: Throwable -> L71
    L38:
        if (r27 == null) goto L33;
        r24.add(r27);     // Catch: Throwable -> L71
        goto L33
    L37:
        r27 = null;
        goto L38
    L40:
        r14.f38504a = (List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Iterator r30 = r28.iterator();     // Catch: Throwable -> L71
    L42:
        if (r30.hasNext() == false) goto L49;
        n r31 = (n) ZeusTransformUtils.preCheckCast(this.n.get((String) ZeusTransformUtils.preCheckCast(r30.next(), String.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        if (r31 == null) goto L46;
        d.h.b.o.a(r31);     // Catch: Throwable -> L71
        l r32 = a(r31);     // Catch: Throwable -> L71
    L47:
        if (r32 == null) goto L42;
        r29.add(r32);     // Catch: Throwable -> L71
        goto L42
    L46:
        r32 = null;
        goto L47
    L49:
        r15.f38504a = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
    L73:
        th = th;
        r17 = r7;
    L13:
        th = move-exception;
        d.n.a r33 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L16
    }

    private static final void a(ProxyServiceConnector r1, long r2) {
        d.h.b.o.e(r1, "this$0");
        r1.b(r2, "binder_died");
    }

    private final void a(long r7, String r9) {
        a(r7, r9, ProxySessionErrorCode.SERVICE_UNAVAILABLE, com.bytedance.safetyguard.lxc.internal.client.c.f9966d);
    }

    private final void a(long r8) {
        if (a(r8, "Proxy service binding timed out after " + this.g + " ms", ProxySessionErrorCode.SERVICE_BIND_TIMEOUT, com.bytedance.safetyguard.lxc.internal.client.c.f9967e) == false) goto L6;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.h, "ProxyServiceConnector", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new v(r8, this), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [T, java.util.List] */
    private final boolean a(long r20, String r22, ProxySessionErrorCode r23, com.bytedance.safetyguard.lxc.internal.client.c r24) {
        d.h.b.z.f r10 = new d.h.b.z.f();
        Object r11 = this.i;
        monitor-enter(r11);
        e r1 = this.s;     // Catch: Throwable -> L41
        if (r1 != null) goto L7;
    L38:
        monitor-exit(r11);
        return false;
    L7:
        if (r1.a() != r20) goto L38;
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9980b) goto L38;
        Collection<d> r2 = this.k.values();     // Catch: Throwable -> L41
        d.h.b.o.c(r2, "<get-values>(...)");     // Catch: Throwable -> L41
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L41
    L13:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();     // Catch: Throwable -> L41
        if (((d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin")).f() == false) goto L13;
        r4.add(r6);     // Catch: Throwable -> L41
        goto L13
    L17:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Iterator r14 = r7.iterator();     // Catch: Throwable -> L41
    L19:
        if (r14.hasNext() == false) goto L27;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r14.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        com.bytedance.safetyguard.lxc.internal.client.r r9 = r8.a();     // Catch: Throwable -> L41
        String r12 = r8.a().getSessionId();     // Catch: Throwable -> L41
        if (r23 == ProxySessionErrorCode.SERVICE_UNAVAILABLE) goto L23;
    L25:
        ProxySessionErrorCode r15 = r23;
    L26:
        ProxySessionResult r16 = com.bytedance.safetyguard.lxc.internal.client.n.a(r12, r15, r22);     // Catch: Throwable -> L41
        d.h.b.o.a(r8);     // Catch: Throwable -> L41
        r13.add(new c(r9, r16, a(this, r8, r24, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 8, null)));     // Catch: Throwable -> L41
        r14 = r14;
        goto L19
    L23:
        if (r8.m() == false) goto L25;
        r15 = ProxySessionErrorCode.SERVICE_RECOVERY_FAILED;     // Catch: Throwable -> L41
        goto L26
    L27:
        r10.f38504a = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        List<m> r17 = a(false);     // Catch: Throwable -> L41
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9979a;     // Catch: Throwable -> L41
        f r18 = b(false);     // Catch: Throwable -> L41
        d.x r19 = d.x.f38692a;     // Catch: Throwable -> L41
        monitor-exit(r11);
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.f38504a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L31:
        if (r21.hasNext() == false) goto L33;
        c r25 = (c) ZeusTransformUtils.preCheckCast(r21.next(), c.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.r.a(r25.a(), r25.b(), null, 2, null);
        r25.c().a();
        goto L31
    L33:
        a(r17, r22);
        if (r18 == null) goto L55;
        r18.a();
        return true;
    L55:
        return true;
    L41:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v32, types: [T, java.util.List] */
    private final void b(long r27, String r29) {
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r12 = new d.h.b.z.f();
        d.h.b.z.d r13 = new d.h.b.z.d();
        d.h.b.z.d r14 = new d.h.b.z.d();
        Object r15 = this.i;
        monitor-enter(r15);
        e r1 = this.s;     // Catch: Throwable -> L102
        if (r1 != null) goto L7;
    L100:
        monitor-exit(r15);
        return;
    L7:
        if (r1.a() != r27) goto L100;
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9982d;     // Catch: Throwable -> L102
        Collection<d> r2 = this.k.values();     // Catch: Throwable -> L102
        d.h.b.o.c(r2, "<get-values>(...)");     // Catch: Throwable -> L102
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L102
    L11:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();     // Catch: Throwable -> L102
        if (((d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin")).f() == false) goto L11;
        r4.add(r6);     // Catch: Throwable -> L102
        goto L11
    L15:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        boolean r16 = false;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L18;
    L20:
        Iterator r17 = r8.iterator();     // Catch: Throwable -> L102
        int r18 = 0;
    L22:
        if (r17.hasNext() == false) goto L28;
        if (((d) ZeusTransformUtils.preCheckCast(r17.next(), d.class, "com.obric.aiagent.plugin")).k() == false) goto L22;
        r18 = r18 + 1;     // Catch: Throwable -> L102
        if (r18 >= 0) goto L22;
        d.a.p.d();     // Catch: Throwable -> L102
    L28:
        r13.f38502a = r18;     // Catch: Throwable -> L102
        r14.f38502a = r7.size() - r13.f38502a;     // Catch: Throwable -> L102
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L102
    L30:
        if (r19.hasNext() == false) goto L66;
        d r20 = (d) ZeusTransformUtils.preCheckCast(r19.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        if (r20.p() == false) goto L41;
        Long r21 = r20.j();     // Catch: Throwable -> L102
        if (r21 == null) goto L41;
        if (r21.longValue() != r27) goto L41;
        List r110 = r9;
        List r111 = r10;
    L65:
        r10 = r111;
        r9 = r110;
        r16 = false;
    L41:
        if (r20.p() == false) goto L47;
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        d.h.b.o.a(r20);     // Catch: Throwable -> L102
        com.bytedance.safetyguard.lxc.internal.client.c r23 = com.bytedance.safetyguard.lxc.internal.client.c.f;     // Catch: Throwable -> L102
        if (r20.k() == false) goto L45;
        com.bytedance.safetyguard.lxc.internal.client.h r24 = com.bytedance.safetyguard.lxc.internal.client.h.f9986c;     // Catch: Throwable -> L102
    L46:
        r111 = r10;
        r22.add(a(this, r20, r23, r24, false, false, 8, null));     // Catch: Throwable -> L102
        r110 = r9;
        goto L65
    L45:
        r24 = com.bytedance.safetyguard.lxc.internal.client.h.f9984a;     // Catch: Throwable -> L102
        goto L46
    L47:
        r111 = r10;
        if (r20.k() == false) goto L50;
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        com.bytedance.safetyguard.lxc.internal.client.r r26 = r20.a();     // Catch: Throwable -> L102
        ProxySessionResult r28 = com.bytedance.safetyguard.lxc.internal.client.n.a(r20.a().getSessionId(), ProxySessionErrorCode.SERVICE_DIED, "Proxy service died after attachment commit");     // Catch: Throwable -> L102
        d.h.b.o.a(r20);     // Catch: Throwable -> L102
        r110 = r9;
        r25.add(new c(r26, r28, a(this, r20, com.bytedance.safetyguard.lxc.internal.client.c.g, com.bytedance.safetyguard.lxc.internal.client.h.f9986c, false, false, 8, null)));     // Catch: Throwable -> L102
        goto L65
    L50:
        r110 = r9;
        r20.a(0);     // Catch: Throwable -> L102
        Long r30 = r20.i();     // Catch: Throwable -> L102
        if (r30 != null) goto L54;
    L56:
        Long r31 = r20.j();     // Catch: Throwable -> L102
        if (r31 != null) goto L60;
    L61:
        d.h.b.o.a(r20);     // Catch: Throwable -> L102
        c(r20);     // Catch: Throwable -> L102
    L62:
        d.h.b.o.a(r20);     // Catch: Throwable -> L102
        b r32 = a(r20);     // Catch: Throwable -> L102
        if (r32 == null) goto L65;
        r11.add(r32);     // Catch: Throwable -> L102
        goto L65
    L60:
        if (r31.longValue() == r27) goto L62;
    L54:
        if (r30.longValue() != r27) goto L56;
        r20.a(null);     // Catch: Throwable -> L102
        goto L56
    L66:
        List r112 = r9;
        List r113 = r10;
        List<m> r33 = a(r16);     // Catch: Throwable -> L102
        Collection<q> r34 = this.p.values();     // Catch: Throwable -> L102
        d.h.b.o.c(r34, "<get-values>(...)");     // Catch: Throwable -> L102
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Iterator r37 = r35.iterator();     // Catch: Throwable -> L102
    L68:
        if (r37.hasNext() == false) goto L72;
        q r38 = (q) ZeusTransformUtils.preCheckCast(r37.next(), q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        d.h.b.o.a(r38);     // Catch: Throwable -> L102
        r r39 = a(r38, false);     // Catch: Throwable -> L102
        if (r39 == null) goto L68;
        r36.add(r39);     // Catch: Throwable -> L102
        goto L68
    L72:
        r12.f38504a = (List) ZeusTransformUtils.preCheckCast(r36, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        f r114 = b(false);     // Catch: Throwable -> L102
        if (c() <= 0) goto L75;
        e r40 = b();     // Catch: Throwable -> L102
    L76:
        d.x r41 = d.x.f38692a;     // Catch: Throwable -> L102
        monitor-exit(r15);
        e r210 = r40;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.h, "ProxyServiceConnector", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new y(r27, r29, r13, r14, r112, r11), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        Iterator r42 = ((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L80:
        if (r42.hasNext() == false) goto L82;
        c r43 = (c) ZeusTransformUtils.preCheckCast(r42.next(), c.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.r.a(r43.a(), r43.b(), null, 2, null);
        r43.c().a();
        goto L80
    L82:
        Iterator r44 = ((Iterable) ZeusTransformUtils.preCheckCast(r113, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L84:
        if (r44.hasNext() == false) goto L86;
        ((j) ZeusTransformUtils.preCheckCast(r44.next(), j.class, "com.obric.aiagent.plugin")).a();
        goto L84
    L86:
        a(r33, "Proxy service died during sidecar operation");
        Iterator r45 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.f38504a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L88:
        if (r45.hasNext() == false) goto L90;
        ((r) ZeusTransformUtils.preCheckCast(r45.next(), r.class, "com.obric.aiagent.plugin")).a();
        goto L88
    L90:
        if (r114 == null) goto L92;
        r114.a();
    L92:
        Iterator r46 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L94:
        if (r46.hasNext() == false) goto L97;
        a((b) ZeusTransformUtils.preCheckCast(r46.next(), b.class, "com.obric.aiagent.plugin"));
        goto L94
    L97:
        if (r210 == null) goto L134;
        a(r210);
        return;
    L134:
        return;
    L75:
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9979a;     // Catch: Throwable -> L102
        r40 = null;
        goto L76
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L20;
        r18 = 0;
    L102:
        th = move-exception;
        throw th;
    }

    private final b a(d r9) {
        if (r9.m() == false) goto L6;
        return null;
    L6:
        r9.e(true);
        r9.b(r9.n() + 1);
        return new b(r9.b().getAttachmentId(), r9.n(), r9.b().getConfig().getRecoveryTimeoutMillis());
    }

    private final void a(final b r7) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        final ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        Object r2 = d.n.f(r1.f9870e.a(r7.c(), new $$Lambda$ProxyServiceConnector$VETUWFtaKv4UzqH7A6eh5VoIaQU(r1, r7)));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = d.n.c(r2);
        if (r3 != null) goto L27;
        com.bytedance.safetyguard.lxc.internal.client.p r4 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
        Object r5 = this.i;
        monitor-enter(r5);
        d r6 = (d) ZeusTransformUtils.preCheckCast(this.k.get(r7.a()), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r6 != null) goto L13;
    L19:
        boolean r8 = true;
    L20:
        monitor-exit(r5);
        if (r8 == false) goto L36;
        r4.cancel();
        return;
    L36:
        return;
    L13:
        if (r6.m() == false) goto L19;
        if (r6.n() != r7.b()) goto L19;
        r6.a(r4);     // Catch: Throwable -> L24
        r8 = false;
    L24:
        th = move-exception;
        throw th;
    L27:
        String r9 = r3.getMessage();
        if (r9 != null) goto L30;
        r9 = "Unable to schedule proxy service recovery timeout";
    L30:
        a(r7, r9);
        return;
    L4:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L6
    }

    private static final void a(ProxyServiceConnector r1, b r2) {
        d.h.b.o.e(r1, "$this_runCatching");
        d.h.b.o.e(r2, "$request");
        r1.a(r2, "Proxy service recovery timed out before attachment commit");
    }

    private final void a(b r11, String r12) {
        Object r0 = this.i;
        monitor-enter(r0);
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.k.get(r11.a()), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        d.h.b.o.a(r1);     // Catch: Throwable -> L19
        if (r1.m() == true) goto L11;
    L17:
        monitor-exit(r0);
        return;
    L11:
        if (r1.n() != r11.b()) goto L17;
        j r10 = a(this, r1, com.bytedance.safetyguard.lxc.internal.client.c.h, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L19
        d.x r13 = d.x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r0);
        com.bytedance.safetyguard.lxc.internal.client.r.a(r1.a(), com.bytedance.safetyguard.lxc.internal.client.n.a(r1.a().getSessionId(), ProxySessionErrorCode.SERVICE_RECOVERY_FAILED, r12), null, 2, null);
        r10.a();
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private final i b(d r4) {
        g r3 = this.t;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r4.f() == true) goto L8;
        return null;
    L8:
        if (r4.p() == false) goto L10;
        return null;
    L10:
        if (r4.i() == null) goto L12;
        return null;
    L12:
        if (r4.j() == null) goto L14;
        return null;
    L14:
        if (r4.k() == true) goto L22;
        r4.a(Long.valueOf(r3.a()));
        r4.a(r3.a());
        return new i(r4.b().getAttachmentId(), r3.a());
    L22:
        return null;
    }

    private final void a(final i r3) {
        this.f9869d.execute(new $$Lambda$ProxyServiceConnector$ITi5S_6UbAQW6SegemnNS13zk(this, r3));
    }

    private static final void a(ProxyServiceConnector r1, i r2) {
        d.h.b.o.e(r1, "this$0");
        d.h.b.o.e(r2, "$request");
        r1.b(r2);
    }

    private final l a(n r4) {
        g r3 = this.t;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r4.g() == false) goto L8;
        return null;
    L8:
        if (r4.d() == false) goto L10;
        return null;
    L10:
        if (r4.e() == false) goto L12;
        return null;
    L12:
        if (r4.f() == true) goto L19;
        r4.a(true);
        r4.a(r3.a());
        return new l(r4.a().getOperationId(), r3.a());
    L19:
        return null;
    }

    private final void a(final l r3) {
        this.f9869d.execute(new $$Lambda$ProxyServiceConnector$rX5mRM2tQmd8hmLsOr7fngV38g(this, r3));
    }

    private static final void a(ProxyServiceConnector r1, l r2) {
        d.h.b.o.e(r1, "this$0");
        d.h.b.o.e(r2, "$request");
        r1.b(r2);
    }

    private final void b(l r13) {
        Object r0 = this.i;
        monitor-enter(r0);
        n r1 = (n) ZeusTransformUtils.preCheckCast(this.n.get(r13.a()), n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        d.h.b.o.a(r1);     // Catch: Throwable -> L56
        g r2 = this.t;     // Catch: Throwable -> L56
        if (r1.c() != r13.b()) goto L53;
        if (r2 == null) goto L53;
        if (r2.a() != r13.b()) goto L53;
        o r7 = null;
        if (r1.g() == false) goto L17;
        r1.a(false);     // Catch: Throwable -> L56
        o r3 = a(this, r1, false, 2, null);     // Catch: Throwable -> L56
        d.m r4 = null;
    L19:
        monitor-exit(r0);
        if (r3 == null) goto L22;
        r3.a();
    L22:
        if (r4 != null) goto L24;
        return;
    L24:
        n r5 = (n) ZeusTransformUtils.preCheckCast(r4.c(), n.class, "com.obric.aiagent.plugin");
        g r6 = (g) ZeusTransformUtils.preCheckCast(r4.d(), g.class, "com.obric.aiagent.plugin");
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L27
        ProxyServiceConnector r9 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        r6.b().executeSidecar(r5.a(), (IBinder) ZeusTransformUtils.preCheckCast(r9.j, IBinder.class, "com.obric.aiagent.plugin"), (ISidecarCallback) ZeusTransformUtils.preCheckCast(new GenerationSidecarCallback(r9, r13.b()), ISidecarCallback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        Object r14 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L27
    L29:
        Throwable r15 = d.n.c(r14);
        if (r15 == null) goto L33;
        a(r5, r15);
        return;
    L33:
        Object r16 = this.i;
        monitor-enter(r16);
    L50:
        th = move-exception;
        throw th;
    L36:
        if (this.n.get(r5.a().getOperationId()) == r5) goto L39;
        monitor-exit(r16);
        return;
    L39:
        r5.b(false);     // Catch: Throwable -> L50
        r5.c(true);     // Catch: Throwable -> L50
        if (r5.g() == false) goto L42;
        k r10 = b(r5);     // Catch: Throwable -> L50
        r7 = a(this, r5, false, 2, null);     // Catch: Throwable -> L50
    L43:
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L50
        monitor-exit(r16);
        if (r7 == null) goto L47;
        r7.a();
    L47:
        if (r10 == null) goto L64;
        a(r10);
        return;
    L64:
        return;
    L42:
        r10 = null;
    L27:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r14 = d.n.f(d.o.a(th));
        goto L29
    L17:
        r1.a(false);     // Catch: Throwable -> L56
        r1.b(true);     // Catch: Throwable -> L56
        this.o.remove(r1.a().getOperationId());     // Catch: Throwable -> L56
        r4 = d.s.a(r1, r2);     // Catch: Throwable -> L56
        r3 = null;
    L53:
        r1.a(false);     // Catch: Throwable -> L56
        monitor-exit(r0);
        return;
    L56:
        th = move-exception;
        throw th;
    }

    private final void a(n r6, Throwable r7) {
        Object r0 = this.i;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.n.get(r6.a().getOperationId()) == r6) goto L9;
        monitor-exit(r0);
        return;
    L9:
        r6.b(false);     // Catch: Throwable -> L22
        if (r6.g() == true) goto L12;
        boolean r2 = true;
    L13:
        o r5 = a(this, r6, false, 2, null);     // Catch: Throwable -> L22
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(r0);
        if (r2 == false) goto L20;
        com.bytedance.safetyguard.lxc.internal.client.u r3 = r6.b();
        String r8 = r6.a().getOperationId();
        String r9 = r7.getMessage();
        if (r9 != null) goto L19;
        r9 = "Proxy service sidecar transact failed";
    L19:
        r3.a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r8, r9));
    L20:
        r5.a();
        return;
    L12:
        r2 = false;
        goto L13
    }

    private final k b(n r6) {
        g r5 = this.t;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.a() != r6.c()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r5 = null;
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        return new k(r6.a().getOperationId(), r5);
    L7:
        r1 = false;
        goto L8
    }

    private final void a(final k r3) {
        this.f9869d.execute(new $$Lambda$ProxyServiceConnector$9Fwb_A4NJr44Jb2B9vldm69oLw(this, r3));
    }

    private static final void a(ProxyServiceConnector r6, k r7) {
        d.h.b.o.e(r6, "this$0");
        d.h.b.o.e(r7, "$request");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        r7.b().b().cancelSidecar(3, r7.a(), (IBinder) ZeusTransformUtils.preCheckCast(r6.j, IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        Object r2 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = d.n.c(r2);
        if (r3 == null) goto L13;
        r6.h.a("ProxyServiceConnector", r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new ad(r7), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L7
    }

    private final void b(i r19) {
        Object r10 = this.i;
        monitor-enter(r10);
        d r2 = (d) ZeusTransformUtils.preCheckCast(this.k.get(r19.a()), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        if (r2 != null) goto L8;
        monitor-exit(r10);
        return;
    L8:
        d.h.b.o.a(r2);     // Catch: Throwable -> L105
        g r0 = this.t;     // Catch: Throwable -> L105
        Long r1 = r2.i();     // Catch: Throwable -> L105
        long r3 = r19.b();     // Catch: Throwable -> L105
        if (r1 != null) goto L12;
    L103:
        monitor-exit(r10);
        return;
    L12:
        if (r1.longValue() != r3) goto L103;
        if (r2.h() != r19.b()) goto L103;
        if (r0 == null) goto L103;
        if (r0.a() != r19.b()) goto L103;
        Throwable r11 = null;
        if (r2.p() == false) goto L22;
        r2.a(null);     // Catch: Throwable -> L105
        j r4 = a(this, r2, com.bytedance.safetyguard.lxc.internal.client.c.f9963a, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L105
        d.m r5 = null;
    L24:
        monitor-exit(r10);
        if (r4 == null) goto L27;
        r4.a();
    L27:
        if (r5 != null) goto L29;
        return;
    L29:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5.c(), d.class, "com.obric.aiagent.plugin");
        g r7 = (g) ZeusTransformUtils.preCheckCast(r5.d(), g.class, "com.obric.aiagent.plugin");
        boolean r8 = true;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L54
        ProxyServiceConnector r12 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        Object r13 = r12.i;     // Catch: Throwable -> L54
        monitor-enter(r13);     // Catch: Throwable -> L54
        d r14 = (d) ZeusTransformUtils.preCheckCast(r12.k.get(r6.b().getAttachmentId()), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (r14 == null) goto L45;
        if (r14 == r6) goto L36;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == true) goto L42;
        r14 = null;
    L42:
        if (r14 == null) goto L45;
        ParcelFileDescriptor r16 = r14.d();     // Catch: Throwable -> L51
    L46:
        monitor-exit(r13);     // Catch: Throwable -> L54
        if (r16 == null) goto L50;
        Object r17 = d.n.f(r12.f9867b.dup(r16));     // Catch: Throwable -> L54
    L56:
        Throwable r18 = d.n.c(r17);
        if (r18 != null) goto L101;
        ParcelFileDescriptor r20 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r17, ParcelFileDescriptor.class, "com.obric.aiagent.plugin");
        Object r21 = this.i;
        monitor-enter(r21);
    L98:
        th = move-exception;
        throw th;
    L61:
        if (this.k.get(r6.b().getAttachmentId()) == r6) goto L63;
    L80:
        r8 = false;
    L81:
        monitor-exit(r21);
        if (r8 == true) goto L112;
        b(r20);
        b(r6, r19.b());
        return;
    L112:
        r7.b().attachProxy(r6.b(), r20, (IBinder) ZeusTransformUtils.preCheckCast(this.j, IBinder.class, "com.obric.aiagent.plugin"), (IProxyClientCallback) ZeusTransformUtils.preCheckCast(new GenerationProxyCallback(this, r19.b()), IProxyClientCallback.class, "com.obric.aiagent.plugin"), r6.c());     // Catch: Throwable -> L87
    L89:
        b(r20);
        if (r11 != null) goto L92;
        a(r6, r19.b());
        return;
    L92:
        if (ZeusTransformUtils.instanceOf(r11, DeadObjectException.class) == false) goto L94;
        b(r19.b(), "attach_dead_object");
    L94:
        a(r6, r19.b(), r11);
        return;
    L87:
        th = move-exception;
        r11 = th;
        goto L89
    L63:
        if (r6.p() == true) goto L80;
        Long r22 = r6.j();     // Catch: Throwable -> L98
        long r23 = r19.b();     // Catch: Throwable -> L98
        if (r22 == null) goto L80;
        if (r22.longValue() != r23) goto L80;
        if (r6.h() != r19.b()) goto L80;
        g r24 = this.t;     // Catch: Throwable -> L98
        if (r24 == null) goto L77;
        if (r24.a() != r19.b()) goto L77;
        boolean r25 = true;
    L78:
        if (r25 == false) goto L80;
    L77:
        r25 = false;
        goto L78
    L101:
        a(r6, r19.b(), r18);
        return;
    L50:
        throw new IOException("proxy attachment closed before FD handoff");     // Catch: Throwable -> L54
    L36:
        if (r14.p() == true) goto L38;
        r15 = true;
    L45:
        r16 = null;
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        d.n.a r26 = d.n.f38560a;
        r17 = d.n.f(d.o.a(th));
        goto L56
    L22:
        r2.a(null);     // Catch: Throwable -> L105
        r2.b(Long.valueOf(r19.b()));     // Catch: Throwable -> L105
        this.l.remove(r2.b().getAttachmentId());     // Catch: Throwable -> L105
        r5 = d.s.a(r2, r0);     // Catch: Throwable -> L105
        r4 = null;
    L105:
        th = move-exception;
        throw th;
    }

    private final void a(d r11, long r12) {
        Object r0 = this.i;
        monitor-enter(r0);
    L54:
        th = move-exception;
        throw th;
    L5:
        if (this.k.get(r11.b().getAttachmentId()) == r11) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Long r1 = r11.j();     // Catch: Throwable -> L54
        if (r1 != null) goto L13;
    L14:
        monitor-exit(r0);
        return;
    L13:
        if (r1.longValue() != r12) goto L14;
        r11.b(null);     // Catch: Throwable -> L54
        boolean r4 = false;
        if (r11.h() != r12) goto L27;
        g r2 = this.t;     // Catch: Throwable -> L54
        if (r2 != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L27;
        r4 = true;
        goto L27
    L22:
        if (r2.a() != r12) goto L24;
        r13 = true;
    L27:
        if (r4 == false) goto L29;
        r11.c(true);     // Catch: Throwable -> L54
        com.bytedance.safetyguard.lxc.internal.client.p r14 = r11.r();     // Catch: Throwable -> L54
        if (r11.p() == false) goto L42;
        com.bytedance.safetyguard.lxc.internal.client.c r15 = r11.q();     // Catch: Throwable -> L54
        if (r15 != null) goto L38;
        r15 = com.bytedance.safetyguard.lxc.internal.client.c.f9963a;     // Catch: Throwable -> L54
    L38:
        com.bytedance.safetyguard.lxc.internal.client.c r5 = r15;
        h r16 = a(r11, r5);     // Catch: Throwable -> L54
        if (r16 != null) goto L41;
        j r3 = a(this, r11, r5, com.bytedance.safetyguard.lxc.internal.client.h.f9986c, false, false, 24, null);     // Catch: Throwable -> L54
        h r6 = r16;
        ProxySessionResult r17 = null;
    L43:
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L54
        monitor-exit(r0);
        if (r14 == null) goto L47;
        r14.cancel();
    L47:
        if (r17 == null) goto L49;
        com.bytedance.safetyguard.lxc.internal.client.r.a(r11.a(), r17, null, 2, null);
    L49:
        if (r3 == null) goto L51;
        r3.a();
    L51:
        if (r6 == null) goto L59;
        a(r6);
        return;
    L59:
        return;
    L41:
        r6 = r16;
        r17 = null;
        r3 = null;
        goto L43
    L42:
        r17 = null;
        r3 = null;
        r6 = null;
        goto L43
    L29:
        if (r11.p() == true) goto L31;
        ProxySessionResult r18 = com.bytedance.safetyguard.lxc.internal.client.n.a(r11.a().getSessionId(), ProxySessionErrorCode.SERVICE_DIED, "Proxy service died after attachment commit");     // Catch: Throwable -> L54
    L32:
        r3 = a(this, r11, com.bytedance.safetyguard.lxc.internal.client.c.j, com.bytedance.safetyguard.lxc.internal.client.h.f9986c, false, false, 24, null);     // Catch: Throwable -> L54
        r6 = null;
        r17 = r18;
        r14 = null;
        goto L43
    L31:
        r18 = null;
        goto L32
    }

    private final void b(d r13, long r14) {
        Object r9 = this.i;
        monitor-enter(r9);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (this.k.get(r13.b().getAttachmentId()) == r13) goto L8;
        monitor-exit(r9);
        return;
    L8:
        Long r1 = r13.j();     // Catch: Throwable -> L38
        if (r1 != null) goto L13;
    L14:
        monitor-exit(r9);
        return;
    L13:
        if (r1.longValue() != r14) goto L14;
        j r10 = null;
        r13.b(null);     // Catch: Throwable -> L38
        if (r13.p() == false) goto L22;
        j r2 = a(this, r13, com.bytedance.safetyguard.lxc.internal.client.c.f9963a, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L38
    L20:
        r10 = r2;
        i r3 = null;
    L32:
        monitor-exit(r9);
        if (r10 == null) goto L35;
        r10.a();
    L35:
        if (r3 == null) goto L42;
        a(r3);
        return;
    L42:
        return;
    L22:
        if (r13.h() != r14) goto L31;
        g r4 = this.t;     // Catch: Throwable -> L38
        boolean r5 = false;
        if (r4 != null) goto L26;
    L28:
        if (r5 == false) goto L31;
        r2 = a(this, r13, com.bytedance.safetyguard.lxc.internal.client.c.i, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L38
        goto L20
    L26:
        if (r4.a() != r14) goto L28;
        r5 = true;
    L31:
        c(r13);     // Catch: Throwable -> L38
        r3 = b(r13);     // Catch: Throwable -> L38
        goto L32
    }

    private final void a(d r11, long r12, Throwable r14) {
        Object r0 = this.i;
        monitor-enter(r0);
    L68:
        th = move-exception;
        throw th;
    L5:
        if (this.k.get(r11.b().getAttachmentId()) == r11) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Long r1 = r11.j();     // Catch: Throwable -> L68
        if (r1 != null) goto L13;
    L14:
        monitor-exit(r0);
        return;
    L13:
        if (r1.longValue() != r12) goto L14;
        r11.b(null);     // Catch: Throwable -> L68
        boolean r3 = true;
        if (r11.h() != r12) goto L27;
        g r2 = this.t;     // Catch: Throwable -> L68
        if (r2 != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L27;
        boolean r15 = true;
    L29:
        if (ZeusTransformUtils.instanceOf(r14, DeadObjectException.class) == false) goto L32;
        if (r15 == true) goto L32;
    L34:
        if (r11.p() == false) goto L43;
        com.bytedance.safetyguard.lxc.internal.client.c r16 = r11.q();     // Catch: Throwable -> L68
        if (r16 != null) goto L38;
        r16 = com.bytedance.safetyguard.lxc.internal.client.c.k;     // Catch: Throwable -> L68
    L38:
        com.bytedance.safetyguard.lxc.internal.client.c r4 = r16;
        if (r3 == false) goto L41;
        com.bytedance.safetyguard.lxc.internal.client.h r17 = com.bytedance.safetyguard.lxc.internal.client.h.f9986c;     // Catch: Throwable -> L68
    L42:
        j r18 = a(this, r11, r4, r17, false, false, 24, null);     // Catch: Throwable -> L68
        ProxySessionResult r19 = null;
        i r110 = null;
    L59:
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L68
        monitor-exit(r0);
        if (r19 == null) goto L63;
        com.bytedance.safetyguard.lxc.internal.client.r.a(r11.a(), r19, null, 2, null);
    L63:
        if (r18 == null) goto L65;
        r18.a();
    L65:
        if (r110 == null) goto L73;
        a(r110);
        return;
    L73:
        return;
    L41:
        r17 = com.bytedance.safetyguard.lxc.internal.client.h.f9984a;     // Catch: Throwable -> L68
        goto L42
    L43:
        if (r3 == false) goto L46;
        r19 = com.bytedance.safetyguard.lxc.internal.client.n.a(r11.a().getSessionId(), ProxySessionErrorCode.SERVICE_DIED, "Proxy service died with an unknown attachment commit outcome");     // Catch: Throwable -> L68
        r18 = a(this, r11, com.bytedance.safetyguard.lxc.internal.client.c.l, com.bytedance.safetyguard.lxc.internal.client.h.f9986c, false, false, 24, null);     // Catch: Throwable -> L68
    L45:
        r110 = null;
        goto L59
    L46:
        if (r15 == true) goto L48;
        c(r11);     // Catch: Throwable -> L68
        r110 = b(r11);     // Catch: Throwable -> L68
        r19 = null;
        r18 = null;
        goto L59
    L48:
        String r111 = r11.a().getSessionId();     // Catch: Throwable -> L68
        if (r11.m() == false) goto L51;
        ProxySessionErrorCode r112 = ProxySessionErrorCode.SERVICE_RECOVERY_FAILED;     // Catch: Throwable -> L68
    L52:
        String r113 = r14.getMessage();     // Catch: Throwable -> L68
        if (r113 == null) goto L55;
    L58:
        r19 = com.bytedance.safetyguard.lxc.internal.client.n.a(r111, r112, r113);     // Catch: Throwable -> L68
        r18 = a(this, r11, com.bytedance.safetyguard.lxc.internal.client.c.m, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L68
        goto L45
    L55:
        if (r11.m() == false) goto L57;
        r113 = "Proxy service recovery attach failed";
        goto L58
    L57:
        r113 = "Proxy service attach transact failed";
        goto L58
    L51:
        r112 = ProxySessionErrorCode.SERVICE_UNAVAILABLE;     // Catch: Throwable -> L68
    L32:
        r3 = false;
        goto L34
    L22:
        if (r2.a() != r12) goto L24;
        r13 = true;
    L27:
        r15 = false;
        goto L29
    }

    private final h a(d r7, com.bytedance.safetyguard.lxc.internal.client.c r8) {
        if (r7.o() == false) goto L5;
        return null;
    L5:
        g r6 = this.t;
        if (r6 != null) goto L8;
    L17:
        return null;
    L8:
        if (r6.a() != r7.h()) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L17;
        r7.f(true);
        return new h(r7, r6, r8);
    L10:
        r0 = false;
        goto L11
    }

    private final void a(final h r3) {
        this.f9869d.execute(new $$Lambda$ProxyServiceConnector$wO6enlgCt__Qn8uILKg6xju54kQ(this, r3));
    }

    private static final void a(ProxyServiceConnector r12, h r13) {
        d.h.b.o.e(r12, "this$0");
        d.h.b.o.e(r13, "$request");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        r13.b().b().detachProxy(3, r13.a().b().getAttachmentId(), (IBinder) ZeusTransformUtils.preCheckCast(r12.j, IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        Object r1 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r1);
        if (r2 != null) goto L10;
    L13:
        Object r3 = r12.i;
        monitor-enter(r3);
    L31:
        th = move-exception;
        throw th;
    L16:
        if (r12.k.get(r13.a().b().getAttachmentId()) == r13.a()) goto L19;
        monitor-exit(r3);
        return;
    L19:
        d r5 = r13.a();     // Catch: Throwable -> L31
        if (r2 != null) goto L22;
        com.bytedance.safetyguard.lxc.internal.client.c r14 = r13.c();     // Catch: Throwable -> L31
    L23:
        com.bytedance.safetyguard.lxc.internal.client.c r6 = r14;
        if (r2 != null) goto L26;
        com.bytedance.safetyguard.lxc.internal.client.h r15 = com.bytedance.safetyguard.lxc.internal.client.h.f9985b;     // Catch: Throwable -> L31
    L27:
        j r16 = a(r12, r5, r6, r15, false, false, 24, null);     // Catch: Throwable -> L31
        monitor-exit(r3);
        r16.a();
        return;
    L26:
        r15 = com.bytedance.safetyguard.lxc.internal.client.h.f9986c;     // Catch: Throwable -> L31
        goto L27
    L22:
        r14 = com.bytedance.safetyguard.lxc.internal.client.c.f9965c;     // Catch: Throwable -> L31
        goto L23
    L10:
        if (ZeusTransformUtils.instanceOf(r2, DeadObjectException.class) == false) goto L12;
        r12.b(r13.b().a(), "detach_dead_object");
    L12:
        r12.h.a("ProxyServiceConnector", r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new ac(r13), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L7
    }

    private final void a(long r6, String r8, ProxyReadyParcel r9) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L11
        ProxyServiceConnector r2 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        ProxyReady r10 = com.bytedance.safetyguard.lxc.internal.client.l.a(r9);     // Catch: Throwable -> L11
        if ((r10.getAcceptedFeatureBitmap() & (-512)) != 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        Object r11 = d.n.f(r10);     // Catch: Throwable -> L11
    L13:
        Throwable r4 = d.n.c(r11);
        if (r4 != null) goto L50;
        ProxyReady r12 = (ProxyReady) ZeusTransformUtils.preCheckCast(r11, ProxyReady.class, "com.obric.aiagent.plugin");
        Object r5 = this.i;
        monitor-enter(r5);
        d r7 = d(r6, r8);     // Catch: Throwable -> L47
        if (r7 == null) goto L23;
        com.bytedance.safetyguard.lxc.internal.client.r r13 = r7.a();     // Catch: Throwable -> L47
        if (r13 == null) goto L23;
        String r14 = r13.getSessionId();     // Catch: Throwable -> L47
    L24:
        monitor-exit(r5);
        if (r14 != null) goto L28;
        return;
    L28:
        if (d.h.b.o.a(r12.getSessionId(), r14) == true) goto L31;
        b(r6, r8, (Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Proxy ready session id mismatch"), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L31:
        Object r15 = this.i;
        monitor-enter(r15);
        d r16 = d(r6, r8);     // Catch: Throwable -> L44
        if (r16 != null) goto L37;
        monitor-exit(r15);
        return;
    L37:
        r16.c(true);     // Catch: Throwable -> L44
        r16.d(true);     // Catch: Throwable -> L44
        d.m r17 = d.s.a(r16.a(), r16.r());     // Catch: Throwable -> L44
        monitor-exit(r15);
        com.bytedance.safetyguard.lxc.internal.client.r r18 = (com.bytedance.safetyguard.lxc.internal.client.r) ZeusTransformUtils.preCheckCast(r17.c(), com.bytedance.safetyguard.lxc.internal.client.r.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.p r19 = (com.bytedance.safetyguard.lxc.internal.client.p) ZeusTransformUtils.preCheckCast(r17.d(), com.bytedance.safetyguard.lxc.internal.client.p.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L42;
        r19.cancel();
    L42:
        r18.a(r12);
        return;
    L44:
        th = move-exception;
        throw th;
    L23:
        r14 = null;
    L47:
        th = move-exception;
        throw th;
    L50:
        b(r6, r8, r4);
        return;
    L10:
        throw new IllegalArgumentException("Proxy service accepted unsupported gateway features".toString());     // Catch: Throwable -> L11
    L6:
        r3 = false;
    L11:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L13
    }

    private final void a(long r3, int r5, String r6) {
        if (r5 == 3) goto L5;
        String r7 = "Unsupported callback protocol version: " + r5;
    L6:
        b(r3, r6, (Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(r7), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r7 = "Unexpected recovering callback: session resume is not supported";
        goto L6
    }

    private final void a(long r12, String r14, ProxySessionResultParcel r15) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        Object r16 = d.n.f(d.s.a(com.bytedance.safetyguard.lxc.internal.client.l.a(r15), com.bytedance.safetyguard.lxc.internal.client.l.b(r15)));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = d.n.c(r16);
        if (r2 != null) goto L40;
        d.m r17 = (d.m) ZeusTransformUtils.preCheckCast(r16, d.m.class, "com.obric.aiagent.plugin");
        ProxySessionResult r3 = (ProxySessionResult) ZeusTransformUtils.preCheckCast(r17.c(), ProxySessionResult.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.client.w r18 = (com.bytedance.safetyguard.lxc.internal.client.w) ZeusTransformUtils.preCheckCast(r17.d(), com.bytedance.safetyguard.lxc.internal.client.w.class, "com.obric.aiagent.plugin");
        Object r4 = this.i;
        monitor-enter(r4);
        d r5 = d(r12, r14);     // Catch: Throwable -> L37
        if (r5 == null) goto L16;
        com.bytedance.safetyguard.lxc.internal.client.r r6 = r5.a();     // Catch: Throwable -> L37
        if (r6 == null) goto L16;
        String r7 = r6.getSessionId();     // Catch: Throwable -> L37
    L17:
        monitor-exit(r4);
        if (r7 != null) goto L21;
        return;
    L21:
        if (d.h.b.o.a(r3.getSessionId(), r7) == true) goto L24;
        b(r12, r14, (Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Proxy terminal session id mismatch"), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L24:
        this.h.b("ProxyServiceConnector", (d.h.a.a) ZeusTransformUtils.preCheckCast(new z(r3, this, r14, r12, r18), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r8 = this.i;
        monitor-enter(r8);
        d r13 = d(r12, r14);     // Catch: Throwable -> L34
        if (r13 != null) goto L30;
        monitor-exit(r8);
        return;
    L30:
        j r11 = a(this, r13, com.bytedance.safetyguard.lxc.internal.client.c.n, com.bytedance.safetyguard.lxc.internal.client.h.f9987d, false, false, 24, null);     // Catch: Throwable -> L34
        d.x r19 = d.x.f38692a;     // Catch: Throwable -> L34
        monitor-exit(r8);
        r13.a().a(r3, r18);
        r11.a();
        return;
    L34:
        th = move-exception;
        throw th;
    L16:
        r7 = null;
    L37:
        th = move-exception;
        throw th;
    L40:
        b(r12, r14, r2);
        return;
    L4:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L6
    }

    private final void a(long r6, ProxyDiagnosticParcel r8) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r8);     // Catch: Throwable -> L7
        if (r8 == null) goto L6;
        Object r9 = d.n.f(r8);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = d.n.c(r9);
        if (r2 != null) goto L45;
        ProxyDiagnosticParcel r10 = (ProxyDiagnosticParcel) ZeusTransformUtils.preCheckCast(r9, ProxyDiagnosticParcel.class, "com.obric.aiagent.plugin");
        Object r3 = this.i;
        monitor-enter(r3);
        String r4 = r10.getAttachmentId();     // Catch: Throwable -> L42
        if (r4 == null) goto L20;
        d r5 = d(r6, r4);     // Catch: Throwable -> L42
        if (r5 == null) goto L18;
        com.bytedance.safetyguard.lxc.internal.client.r r7 = r5.a();     // Catch: Throwable -> L42
    L19:
        List r11 = d.a.p.b(r7);     // Catch: Throwable -> L42
    L36:
        monitor-exit(r3);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L39:
        if (r12.hasNext() == false) goto L41;
        ((com.bytedance.safetyguard.lxc.internal.client.r) ZeusTransformUtils.preCheckCast(r12.next(), com.bytedance.safetyguard.lxc.internal.client.r.class, "com.obric.aiagent.plugin")).a(r10);
        goto L39
    L41:
        return;
    L18:
        r7 = null;
        goto L19
    L20:
        Collection<d> r13 = this.k.values();     // Catch: Throwable -> L42
        d.h.b.o.c(r13, "<get-values>(...)");     // Catch: Throwable -> L42
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L42
    L22:
        if (r16.hasNext() == false) goto L31;
        Object r17 = r16.next();     // Catch: Throwable -> L42
        d r18 = (d) ZeusTransformUtils.preCheckCast(r17, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r18.p() == false) goto L26;
    L28:
        boolean r19 = false;
    L29:
        if (r19 == false) goto L22;
        r15.add(r17);     // Catch: Throwable -> L42
        goto L22
    L26:
        if (r18.h() != r6) goto L28;
        r19 = true;
        goto L29
    L31:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L42
    L33:
        if (r22.hasNext() == false) goto L35;
        r21.add(((d) ZeusTransformUtils.preCheckCast(r22.next(), d.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L42
        goto L33
    L35:
        r11 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    L45:
        this.h.a("ProxyServiceConnector", r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new w(r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        d.n.a r23 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L9
    }

    private final void a(long r6, int r8, String r9, String r10, int r11) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L42
        ProxyServiceConnector r2 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r8);     // Catch: Throwable -> L42
        if (r9 == null) goto L41;
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a("operationId", r9);     // Catch: Throwable -> L42
        if (r10 == null) goto L39;
        boolean r3 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L27;
        byte[] r12 = r10.getBytes(d.o.d.f38623b);     // Catch: Throwable -> L42
        d.h.b.o.c(r12, "getBytes(...)");     // Catch: Throwable -> L42
        if (r12.length > 4096) goto L27;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        int r4 = 0;
    L13:
        if (r4 >= r13.length()) goto L24;
        char r5 = r13.charAt(r4);     // Catch: Throwable -> L42
        if (r5 != 0) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L22;
        r4 = r4 + 1;     // Catch: Throwable -> L42
        goto L13
    L22:
        boolean r14 = false;
    L25:
        if (r14 == false) goto L27;
        boolean r15 = true;
    L28:
        if (r15 == false) goto L37;
        if (r11 > 0) goto L32;
        r3 = false;
    L32:
        if (r3 == false) goto L35;
        Object r16 = d.n.f(d.s.a(r9, r10));     // Catch: Throwable -> L42
    L44:
        Throwable r17 = d.n.c(r16);
        if (r17 != null) goto L64;
        d.m r18 = (d.m) ZeusTransformUtils.preCheckCast(r16, d.m.class, "com.obric.aiagent.plugin");
        Object r19 = this.i;
        monitor-enter(r19);
        n r20 = c(r6, (String) ZeusTransformUtils.preCheckCast(r18.a(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
        if (r20 == null) goto L52;
        com.bytedance.safetyguard.lxc.internal.client.u r21 = r20.b();     // Catch: Throwable -> L61
    L53:
        monitor-exit(r19);
        if (r21 != null) goto L68;
        return;
    L68:
        d.n.a r22 = d.n.f38560a;     // Catch: Throwable -> L58
        ProxyServiceConnector r23 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        r21.a((String) ZeusTransformUtils.preCheckCast(r18.b(), String.class, "com.obric.aiagent.plugin"), r11);     // Catch: Throwable -> L58
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L52:
        r21 = null;
    L61:
        th = move-exception;
        throw th;
    L64:
        a(r6, r9, r17);
        return;
    L35:
        throw new IllegalArgumentException("invalid sidecar verification expiration".toString());     // Catch: Throwable -> L42
    L37:
        throw new IllegalArgumentException("invalid sidecar verification URL".toString());     // Catch: Throwable -> L42
    L17:
        if (Character.isISOControl(r5) == true) goto L20;
        r7 = false;
        goto L21
    L24:
        r14 = true;
    L27:
        r15 = false;
        goto L28
    L39:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L42
    L41:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        d.n.a r110 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L44
    }

    private final void a(long r19, SidecarResultParcel r21) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        ProxyServiceConnector r1 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r21 == null) goto L7;
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r21);     // Catch: Throwable -> L8
        Object r2 = d.n.f(r21);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = d.n.c(r2);
        if (r3 != null) goto L64;
        SidecarResultParcel r12 = (SidecarResultParcel) ZeusTransformUtils.preCheckCast(r2, SidecarResultParcel.class, "com.obric.aiagent.plugin");
        Object r4 = this.i;
        monitor-enter(r4);
        n r13 = c(r19, r12.getOperationId());     // Catch: Throwable -> L60
        monitor-exit(r4);
        if (r13 != null) goto L76;
        return;
    L76:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L24
        ((ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin")).a(r13.a().getCommand(), r12);     // Catch: Throwable -> L24
        if (r12.getResultType() != 4) goto L21;
        SidecarSessionEnv r6 = com.bytedance.safetyguard.lxc.internal.ipc.g.d(r12);     // Catch: Throwable -> L24
    L22:
        Object r7 = d.n.f(r6);     // Catch: Throwable -> L24
    L26:
        Throwable r8 = d.n.c(r7);
        if (r8 != null) goto L58;
        SidecarSessionEnv r9 = (SidecarSessionEnv) ZeusTransformUtils.preCheckCast(r7, SidecarSessionEnv.class, "com.obric.aiagent.plugin");
        Object r14 = this.i;
        monitor-enter(r14);
    L55:
        th = move-exception;
        throw th;
    L31:
        if (c(r19, r12.getOperationId()) == r13) goto L34;
        monitor-exit(r14);
        return;
    L34:
        if (r9 != null) goto L36;
    L39:
        boolean r10 = false;
    L40:
        if (r10 == true) goto L42;
        o r11 = a(this, r13, false, 2, null);     // Catch: Throwable -> L55
    L43:
        d.x r15 = d.x.f38692a;     // Catch: Throwable -> L55
        monitor-exit(r14);
        if (r10 == false) goto L71;
        a(r19, r12.getOperationId(), (Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("duplicate sidecar session id"), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L71:
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L50
        ProxyServiceConnector r17 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        r13.b().a(r12);     // Catch: Throwable -> L50
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L50
    L52:
        if (r11 == null) goto L78;
        r11.a();
        return;
    L78:
        return;
    L50:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L52
    L42:
        r11 = null;
        goto L43
    L36:
        if (this.p.containsKey(r9.getSessionId()) == false) goto L38;
        r10 = true;
        goto L40
    L38:
        a(com.bytedance.safetyguard.lxc.internal.client.d.f9970c);     // Catch: Throwable -> L55
        ((Map) ZeusTransformUtils.preCheckCast(this.p, Map.class, "com.obric.aiagent.plugin")).put(r9.getSessionId(), new q(r9.getSessionId(), r19, r9.getExpiresAtMillis()));     // Catch: Throwable -> L55
        goto L39
    L58:
        a(r19, r12.getOperationId(), r8);
        return;
    L21:
        r6 = null;
    L24:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
    L60:
        th = move-exception;
        throw th;
    L64:
        if (r21 == null) goto L66;
        String r110 = r21.getOperationId();
    L67:
        a(r19, r110, r3);
        return;
    L66:
        r110 = null;
        goto L67
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        d.n.a r22 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L10
    }

    private final void a(int r3, SidecarResultParcel r4) {
        boolean r0 = true;
        if (r4.getResultType() != 1) goto L6;
        return;
    L6:
        if (r3 != 7) goto L8;
        int r2 = 2;
    L16:
        if (r4.getResultType() == r2) goto L19;
        r0 = false;
    L19:
        if (r0 == false) goto L22;
        return;
    L22:
        throw new IllegalArgumentException(("unexpected sidecar result type=" + r4.getResultType() + " for command=" + r3).toString());
    L8:
        if (r3 != 8) goto L10;
        r2 = 3;
        goto L16
    L10:
        if (r3 == 9) goto L12;
        r2 = 1;
        goto L16
    L12:
        r2 = 4;
        goto L16
    }

    private final void a(long r3, String r5, Throwable r6) {
        Object r0 = this.i;
        monitor-enter(r0);
        n r4 = c(r3, r5);     // Catch: Throwable -> L16
        if (r4 != null) goto L9;
        monitor-exit(r0);
        return;
    L9:
        o r2 = a(this, r4, false, 2, null);     // Catch: Throwable -> L16
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        com.bytedance.safetyguard.lxc.internal.client.u r8 = r4.b();
        String r9 = r4.a().getOperationId();
        String r10 = r6.getMessage();
        if (r10 != null) goto L14;
        r10 = "Invalid sidecar service callback";
    L14:
        r8.a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r9, r10));
        r2.a();
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private final n c(long r4, String r6) {
        LinkedHashMap<String, n> r3 = this.n;
        if (r6 != null) goto L5;
        return null;
    L5:
        n r5 = (n) ZeusTransformUtils.preCheckCast(r3.get(r6), n.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
        return null;
    L9:
        if (r5.g() == false) goto L11;
    L14:
        return null;
    L11:
        if (r5.c() != r4) goto L14;
        return r5;
    }

    private final void b(long r11, String r13, Throwable r14) {
        Object r0 = this.i;
        monitor-enter(r0);
        d r15 = d(r11, r13);     // Catch: Throwable -> L33
        if (r15 != null) goto L9;
        monitor-exit(r0);
        return;
    L9:
        r15.g(true);     // Catch: Throwable -> L33
        r15.a(com.bytedance.safetyguard.lxc.internal.client.c.o);     // Catch: Throwable -> L33
        this.l.remove(r15.b().getAttachmentId());     // Catch: Throwable -> L33
        if (r15.k() == false) goto L15;
        h r12 = a(r15, com.bytedance.safetyguard.lxc.internal.client.c.o);     // Catch: Throwable -> L33
        if (r12 != null) goto L14;
        j r16 = a(this, r15, com.bytedance.safetyguard.lxc.internal.client.c.o, com.bytedance.safetyguard.lxc.internal.client.h.f9986c, false, false, 24, null);     // Catch: Throwable -> L33
    L22:
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L33
        monitor-exit(r0);
        com.bytedance.safetyguard.lxc.internal.client.r r2 = r15.a();
        String r17 = r15.a().getSessionId();
        ProxySessionErrorCode r3 = ProxySessionErrorCode.SERVICE_PROTOCOL_MISMATCH;
        String r18 = r14.getMessage();
        if (r18 != null) goto L27;
        r18 = "Invalid proxy service callback";
    L27:
        com.bytedance.safetyguard.lxc.internal.client.r.a(r2, com.bytedance.safetyguard.lxc.internal.client.n.a(r17, r3, r18), null, 2, null);
        if (r16 == null) goto L30;
        r16.a();
    L30:
        if (r12 == null) goto L38;
        a(r12);
        return;
    L38:
        return;
    L14:
        r16 = null;
        goto L22
    L15:
        Long r4 = r15.j();     // Catch: Throwable -> L33
        if (r4 != null) goto L19;
    L20:
        r16 = a(this, r15, com.bytedance.safetyguard.lxc.internal.client.c.o, com.bytedance.safetyguard.lxc.internal.client.h.f9984a, false, false, 24, null);     // Catch: Throwable -> L33
        r12 = null;
        goto L22
    L19:
        if (r4.longValue() != r11) goto L20;
        r12 = null;
        r16 = null;
    L33:
        th = move-exception;
        throw th;
    }

    private final d d(long r4, String r6) {
        LinkedHashMap<String, d> r3 = this.k;
        if (r6 != null) goto L5;
        return null;
    L5:
        d r5 = (d) ZeusTransformUtils.preCheckCast(r3.get(r6), d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
        return null;
    L9:
        if (r5.p() == false) goto L11;
    L14:
        return null;
    L11:
        if (r5.h() != r4) goto L14;
        return r5;
    }

    private final Object d(String r7) {
        Object r0 = this.i;
        monitor-enter(r0);
        d r8 = (d) ZeusTransformUtils.preCheckCast(this.k.get(r7), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r8 != null) goto L7;
        Object r6 = a(4, "Proxy attachment was not found");     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);
        return r6;
    L7:
        d.h.b.o.a(r8);     // Catch: Throwable -> L26
        if (r8.p() == false) goto L11;
        r6 = a(3, "Proxy session is closed");     // Catch: Throwable -> L26
        goto L24
    L11:
        if (r8.k() == true) goto L13;
    L23:
        r6 = a(2, "Proxy attachment is not ready");     // Catch: Throwable -> L26
        goto L24
    L13:
        if (r8.l() == false) goto L23;
        g r1 = this.t;     // Catch: Throwable -> L26
        if (this.q != com.bytedance.safetyguard.lxc.internal.client.g.f9981c) goto L22;
        if (r1 == null) goto L22;
        if (r1.a() != r8.h()) goto L22;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L26
        r6 = d.n.f(new a(r8, r1));     // Catch: Throwable -> L26
    L22:
        r6 = a(9, "Action service is unavailable");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private final boolean a(a r6) {
        Object r0 = this.i;
        monitor-enter(r0);
        boolean r3 = true;
        if (this.k.get(r6.a().b().getAttachmentId()) == r6.a()) goto L7;
    L19:
        r3 = false;
    L20:
        monitor-exit(r0);
        return r3;
    L7:
        if (r6.a().p() == true) goto L19;
        if (r6.a().l() == false) goto L19;
        g r5 = this.t;     // Catch: Throwable -> L22
        if (r5 == null) goto L16;
        if (r5.a() != r6.b().a()) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
    L16:
        r7 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private final Object a(ActionActivationResultParcel r3) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r3);     // Catch: Exception -> L15
        if (r3 == null) goto L14;
        if (r3.getResultCode() != 0) goto L8;
        d.n.a r0 = d.n.f38560a;     // Catch: Exception -> L15
        return d.n.f(com.bytedance.safetyguard.lxc.internal.client.l.a(r3.getToken()));
    L8:
        int r1 = r3.getResultCode();     // Catch: Exception -> L15
        String r4 = r3.getMessage();     // Catch: Exception -> L15
        if (r4 == null) goto L12;
        return a(r1, r4);
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L15
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L15
    L16:
        return a(10, "Action service returned an invalid response");
    }

    private final Object a(ActionFinishResultParcel r3) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r3);     // Catch: Exception -> L15
        if (r3 == null) goto L14;
        if (r3.getResultCode() != 0) goto L8;
        d.n.a r0 = d.n.f38560a;     // Catch: Exception -> L15
        return d.n.f(com.bytedance.safetyguard.lxc.internal.client.l.a(r3.getResult()));
    L8:
        int r1 = r3.getResultCode();     // Catch: Exception -> L15
        String r4 = r3.getMessage();     // Catch: Exception -> L15
        if (r4 == null) goto L12;
        return a(r1, r4);
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L15
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L15
    L16:
        return a(10, "Action service returned an invalid response");
    }

    private final <T> Object a(int r1, String r2) {
        d.n.a r0 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.client.a(r1, r2), Throwable.class, "com.obric.aiagent.plugin")));
    }

    private final List<m> a(boolean r7) {
        Collection<n> r0 = this.n.values();
        d.h.b.o.c(r0, "<get-values>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r4);
        r2.add(new m(r4, a(r4, r7)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    }

    private final void a(List<m> r5, String r6) {
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        m r0 = (m) ZeusTransformUtils.preCheckCast(r7.next(), m.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L8
        ProxyServiceConnector r3 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        r0.a().b().a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r0.a().a().getOperationId(), r6));     // Catch: Throwable -> L8
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        r0.b().a();
    L8:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }

    static /* synthetic */ o a(ProxyServiceConnector r0, n r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    private final o a(n r3, boolean r4) {
        this.n.remove(r3.a().getOperationId());
        this.o.remove(r3.a().getOperationId());
        b(com.bytedance.safetyguard.lxc.internal.client.d.f9969b);
        if (r4 == true) goto L5;
    L9:
        f r5 = null;
    L11:
        return new o(this, r5);
    L5:
        if (c() != 0) goto L9;
        if (this.q == com.bytedance.safetyguard.lxc.internal.client.g.f9983e) goto L9;
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9979a;
        r5 = b(true);
        goto L11
    }

    static /* synthetic */ r a(ProxyServiceConnector r0, q r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    private final r a(q r3, boolean r4) {
        f r0 = null;
        if (this.p.remove(r3.a(), r3) == true) goto L5;
        return null;
    L5:
        b(com.bytedance.safetyguard.lxc.internal.client.d.f9970c);
        if (r4 == false) goto L13;
        if (c() != 0) goto L13;
        if (this.q == com.bytedance.safetyguard.lxc.internal.client.g.f9983e) goto L13;
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9979a;
        r0 = b(true);
    L13:
        return new r(this, r0);
    }

    static /* synthetic */ j a(ProxyServiceConnector r7, d r8, com.bytedance.safetyguard.lxc.internal.client.c r9, com.bytedance.safetyguard.lxc.internal.client.h r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r6 = true;
    L11:
        return r7.a(r8, r9, r10, r5, r6);
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    private final j a(d r11, com.bytedance.safetyguard.lxc.internal.client.c r12, com.bytedance.safetyguard.lxc.internal.client.h r13, boolean r14, boolean r15) {
        this.k.remove(r11.b().getAttachmentId());
        this.l.remove(r11.b().getAttachmentId());
        ParcelFileDescriptor r4 = r11.s();
        com.bytedance.safetyguard.lxc.internal.client.p r5 = r11.r();
        f r0 = null;
        if (r14 == true) goto L5;
    L13:
        f r6 = r0;
        return new j(this, r11.a(), r11.b().getAttachmentId(), r4, r5, r6, r12, r13);
    L5:
        if (r11.g() == false) goto L13;
        r11.b(false);
        b(com.bytedance.safetyguard.lxc.internal.client.d.f9968a);
        if (r15 == false) goto L13;
        if (c() != 0) goto L13;
        if (this.q == com.bytedance.safetyguard.lxc.internal.client.g.f9983e) goto L13;
        this.q = com.bytedance.safetyguard.lxc.internal.client.g.f9979a;
        r0 = b(true);
        goto L13
    }

    private final void c(d r2) {
        if (r2.f() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L14;
        String r3 = r2.b().getAttachmentId();
        if (this.l.contains(r3) == true) goto L15;
        this.l.addLast(r3);
        return;
    L15:
        return;
    L14:
        throw new IllegalStateException("reserved proxy attachment cannot be dispatched".toString());
    L5:
        if (r2.g() == false) goto L7;
        r0 = true;
        goto L8
    }

    private final f b(boolean r10) {
        e r0 = this.s;
        g r3 = this.t;
        ServiceConnection r1 = null;
        this.s = null;
        this.t = null;
        if (r0 != null) goto L6;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r0 == null) goto L8;
        com.bytedance.safetyguard.lxc.internal.client.p r7 = r0.e();
    L9:
        if (r0 == null) goto L13;
        r0.a(null);
    L13:
        if (r0 == null) goto L15;
        r1 = r0.b();
    L15:
        ServiceConnection r4 = r1;
        if (r0 != null) goto L18;
    L20:
        boolean r5 = false;
    L22:
        return new f(this, r3, r4, r5, r10, r7);
    L18:
        if (r0.d() != true) goto L20;
        r5 = true;
        goto L22
    L8:
        r7 = null;
        goto L9
    }

    private final void a(com.bytedance.safetyguard.lxc.internal.client.d r4) {
        ((Map) ZeusTransformUtils.preCheckCast(this.m, Map.class, "com.obric.aiagent.plugin")).put(r4, Integer.valueOf(c(r4) + 1));
    }

    private final void b(com.bytedance.safetyguard.lxc.internal.client.d r5) {
        int r0 = c(r5);
        if (r0 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        ((Map) ZeusTransformUtils.preCheckCast(this.m, Map.class, "com.obric.aiagent.plugin")).put(r5, Integer.valueOf(r0 - 1));
        return;
    L10:
        throw new IllegalStateException(("negative bind lease count for " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    private final int c(com.bytedance.safetyguard.lxc.internal.client.d r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.m.get(r2), Integer.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.intValue();
    }

    private final int c() {
        Collection<Integer> r2 = this.m.values();
        d.h.b.o.c(r2, "<get-values>(...)");
        return d.a.p.B((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final void a(ServiceConnection r3) {
        ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        ((ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin")).f9866a.b(r4);     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    private final void b(ParcelFileDescriptor r3) {
        if (r3 == null) goto L10;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        ProxyServiceConnector r2 = (ProxyServiceConnector) ZeusTransformUtils.preCheckCast(this, ProxyServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r3.close();     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    }
}
