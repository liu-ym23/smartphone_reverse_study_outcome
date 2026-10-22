package com.bytedance.safetyguard.lxc.internal.service;

import android.os.IBinder;
import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecarInternal;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAccountStatus;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperationException;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarSessionEnv;
import com.bytedance.safetyguard.lxc.api.sidecar.StartSidecarSessionRequest;
import com.bytedance.safetyguard.lxc.internal.ipc.ISidecarCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarCommandParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarResultParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: SidecarServiceHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ai implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SafetyGuardSidecar f10941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.service.g f10942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f10943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final am f10944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10945e;
    private final AtomicBoolean f;
    private final LinkedHashMap<b, a> g;
    private final LinkedHashMap<b, ca> h;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ai$1, reason: invalid class name */
    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10946a = null;

        static {
            f10946a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ai$2, reason: invalid class name */
    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    /* synthetic */ class AnonymousClass2 extends d.h.b.l implements d.h.a.q<IBinder, Set<? extends String>, Set<? extends String>, d.x> {
        AnonymousClass2(Object r8) {
            super(3, r8, ai.class, "releaseClientResources", "releaseClientResources(Landroid/os/IBinder;Ljava/util/Set;Ljava/util/Set;)V", 0);
        }

        public final void a(IBinder r3, Set<String> r4, Set<String> r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "p0");
            d.h.b.o.e(r7, "p1");
            d.h.b.o.e(r8, "p2");
            ai.a((ai) ZeusTransformUtils.preCheckCast(this.receiver, ai.class, "com.obric.aiagent.plugin"), r6, r7, r8);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(IBinder r3, Set<? extends String> r4, Set<? extends String> r5) {
            a((IBinder) ZeusTransformUtils.preCheckCast(r3, IBinder.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f10947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ISidecarCallback f10948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f10949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private EnumC0249a f10950d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private SidecarOperation f10951e;
        private ca f;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ai$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SidecarServiceHost.kt */
        private static final enum EnumC0249a extends Enum<EnumC0249a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0249a f10952a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0249a f10953b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0249a f10954c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0249a[] f10955d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final /* synthetic */ d.d.a f10956e = null;

            private static final /* synthetic */ EnumC0249a[] a() {
                return new EnumC0249a[]{f10952a, f10953b, f10954c};
            }

            public static EnumC0249a valueOf(String r2) {
                return (EnumC0249a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0249a.class, r2), EnumC0249a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0249a[] values() {
                return (EnumC0249a[]) ZeusTransformUtils.preCheckCast(f10955d.clone(), EnumC0249a[].class, "com.obric.aiagent.plugin");
            }

            private EnumC0249a(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f10952a = new EnumC0249a("ACTIVE", 0);
                f10953b = new EnumC0249a("COMPLETED", 1);
                f10954c = new EnumC0249a("CANCELLED", 2);
                EnumC0249a[] r0 = a();
                f10955d = r0;
                f10956e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }
        }

        public a(b r3, ISidecarCallback r4) {
            ISidecarCallback r5 = (ISidecarCallback) ZeusTransformUtils.wrapperContextForParams(r4, ISidecarCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "key");
            d.h.b.o.e(r5, "callback");
            this.f10947a = r3;
            this.f10948b = r5;
            this.f10949c = new Object();
            this.f10950d = EnumC0249a.f10952a;
        }

        public final b a() {
            return this.f10947a;
        }

        public final ISidecarCallback b() {
            return this.f10948b;
        }

        public final void a(ca r5) {
            ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "job");
            Object r0 = this.f10949c;
            monitor-enter(r0);
            boolean r2 = false;
            if (this.f != null) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == false) goto L17;
            this.f = r6;     // Catch: Throwable -> L18
            if (this.f10950d != EnumC0249a.f10954c) goto L12;
            r2 = true;
        L12:
            monitor-exit(r0);
            if (r2 == false) goto L22;
            ca.a.a(r6, null, 1, null);
            return;
        L22:
            return;
        L17:
            throw new IllegalStateException("sidecar operation job already installed".toString());     // Catch: Throwable -> L18
        L7:
            r1 = false;
        L18:
            th = move-exception;
            throw th;
        }

        public final void a(SidecarOperation r5) {
            SidecarOperation r6 = (SidecarOperation) ZeusTransformUtils.wrapperContextForParams(r5, SidecarOperation.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "operation");
            Object r0 = this.f10949c;
            monitor-enter(r0);
            boolean r3 = false;
            if (this.f10950d != EnumC0249a.f10952a) goto L8;
            this.f10951e = r6;     // Catch: Throwable -> L14
        L10:
            monitor-exit(r0);
            if (r3 == false) goto L18;
            r6.cancel();
            return;
        L18:
            return;
        L8:
            if (this.f10950d != EnumC0249a.f10954c) goto L10;
            r3 = true;
        L14:
            th = move-exception;
            throw th;
        }

        public final boolean c() {
            Object r0 = this.f10949c;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f10950d == EnumC0249a.f10952a) goto L7;
            boolean r3 = false;
        L9:
            monitor-exit(r0);
            return r3;
        L7:
            this.f10950d = EnumC0249a.f10953b;     // Catch: Throwable -> L11
            r3 = true;
            goto L9
        }

        public final void d() {
            Object r0 = this.f10949c;
            monitor-enter(r0);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (this.f10950d == EnumC0249a.f10952a) goto L8;
            monitor-exit(r0);
            return;
        L8:
            this.f10950d = EnumC0249a.f10954c;     // Catch: Throwable -> L17
            d.m r3 = d.s.a(this.f10951e, this.f);     // Catch: Throwable -> L17
            monitor-exit(r0);
            SidecarOperation r1 = (SidecarOperation) ZeusTransformUtils.preCheckCast(r3.a(), SidecarOperation.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L13;
            r1.cancel();
        L13:
            ca r4 = (ca) ZeusTransformUtils.preCheckCast(r3.b(), ca.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L22;
            ca.a.a(r4, null, 1, null);
            return;
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f10957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10958b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f10957a, r6.f10957a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f10958b, r6.f10958b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10957a.hashCode() * 31) + this.f10958b.hashCode();
        }

        public String toString() {
            return "SidecarResourceKey(clientToken=" + this.f10957a + ", resourceId=" + this.f10958b + ')';
        }

        public b(IBinder r3, String r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "clientToken");
            d.h.b.o.e(r4, "resourceId");
            this.f10957a = r5;
            this.f10958b = r4;
        }

        public final IBinder a() {
            return this.f10957a;
        }

        public final String b() {
            return this.f10958b;
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {280}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost$completeOperation$1$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ai f10960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f10962d;

        c(ai r3, String r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10960b = r3;
            this.f10961c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f10960b, this.f10961c, r6);
            r0.f10962d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10959a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r6);     // Catch: Throwable -> L15
        L13:
            d.n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L15
        L18:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r6);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f10962d, am.class, "com.obric.aiagent.plugin");
            ai r8 = this.f10960b;
            String r2 = this.f10961c;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
            SafetyGuardSidecar r9 = ai.a(r8);     // Catch: Throwable -> L15
            this.f10959a = 1;     // Catch: Throwable -> L15
            r6 = r9.endSession(r2, this);     // Catch: Throwable -> L15
            if (r6 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r10 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {291}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost$completeOperation$2$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ai f10964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f10966d;

        d(ai r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10964b = r3;
            this.f10965c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f10964b, this.f10965c, r6);
            r0.f10966d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10963a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r6);     // Catch: Throwable -> L15
        L13:
            d.n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L15
        L18:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r6);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f10966d, am.class, "com.obric.aiagent.plugin");
            ai r8 = this.f10964b;
            String r2 = this.f10965c;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
            SafetyGuardSidecar r9 = ai.a(r8);     // Catch: Throwable -> L15
            this.f10963a = 1;     // Catch: Throwable -> L15
            r6 = r9.endSession(r2, this);     // Catch: Throwable -> L15
            if (r6 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r10 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {160}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost$endSession$2$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ai f10968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10969c;

        e(ai r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10968b = r3;
            this.f10969c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f10968b, this.f10969c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10967a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            SafetyGuardSidecar r7 = ai.a(this.f10968b);
            String r2 = this.f10969c;
            d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10967a = 1;
            r6 = r7.endSession(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {132}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost$execute$job$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarCommandParcel f10971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ai f10972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f10973d;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ai$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: SidecarServiceHost.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<SidecarDeviceFlowCallback, SidecarOperation> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ai f10974a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SidecarCommandParcel f10975b;

            AnonymousClass1(ai r1, SidecarCommandParcel r2) {
                this.f10974a = r1;
                this.f10975b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ SidecarOperation invoke(SidecarDeviceFlowCallback r3) {
                return a((SidecarDeviceFlowCallback) ZeusTransformUtils.preCheckCast(r3, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin"));
            }

            public final SidecarOperation a(SidecarDeviceFlowCallback r3) {
                SidecarDeviceFlowCallback r4 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r3, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "bridge");
                SafetyGuardSidecar r0 = ai.a(this.f10974a);
                String r2 = this.f10975b.getProduction();
                if (r2 == null) goto L7;
                return r0.configCreateApp(r2, r4);
            L7:
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ai$f$2, reason: invalid class name */
        /* JADX INFO: compiled from: SidecarServiceHost.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.b<SidecarDeviceFlowCallback, SidecarOperation> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ai f10976a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SidecarCommandParcel f10977b;

            AnonymousClass2(ai r1, SidecarCommandParcel r2) {
                this.f10976a = r1;
                this.f10977b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ SidecarOperation invoke(SidecarDeviceFlowCallback r3) {
                return a((SidecarDeviceFlowCallback) ZeusTransformUtils.preCheckCast(r3, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin"));
            }

            public final SidecarOperation a(SidecarDeviceFlowCallback r4) {
                SidecarDeviceFlowCallback r5 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r4, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "bridge");
                return ai.a(this.f10976a).login(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(this.f10977b.getScopes(), Iterable.class, "com.obric.aiagent.plugin")), r5);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.ai$f$3, reason: invalid class name */
        /* JADX INFO: compiled from: SidecarServiceHost.kt */
        static final class AnonymousClass3 extends d.h.b.p implements d.h.a.b<SidecarDeviceFlowCallback, SidecarOperation> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ai f10978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SidecarCommandParcel f10979b;

            AnonymousClass3(ai r1, SidecarCommandParcel r2) {
                this.f10978a = r1;
                this.f10979b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ SidecarOperation invoke(SidecarDeviceFlowCallback r3) {
                return a((SidecarDeviceFlowCallback) ZeusTransformUtils.preCheckCast(r3, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin"));
            }

            public final SidecarOperation a(SidecarDeviceFlowCallback r4) {
                SidecarDeviceFlowCallback r5 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r4, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "bridge");
                return ai.a(this.f10978a).requestGrant(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(this.f10979b.getScopes(), Iterable.class, "com.obric.aiagent.plugin")), r5);
            }
        }

        f(SidecarCommandParcel r3, ai r4, a r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10971b = r3;
            this.f10972c = r4;
            this.f10973d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f10971b, this.f10972c, this.f10973d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10970a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L21:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            int r8 = this.f10971b.getCommand();
            if (r8 != 1) goto L11;
            ai.a(this.f10972c, this.f10973d, (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10972c, this.f10971b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L21
        L11:
            if (r8 != 4) goto L13;
            ai.a(this.f10972c, this.f10973d, (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f10972c, this.f10971b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L21
        L13:
            if (r8 == 5) goto L17;
            ai r9 = this.f10972c;
            a r3 = this.f10973d;
            SidecarCommandParcel r4 = this.f10971b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10970a = 1;
            if (ai.a(r9, r3, r4, r2) != r0) goto L21;
            return r0;
        L17:
            ai.a(this.f10972c, this.f10973d, (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f10972c, this.f10971b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L21
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    public static final class g implements SidecarDeviceFlowCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ai f10980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10981b;

        g(ai r1, a r2) {
            this.f10980a = r1;
            this.f10981b = r2;
        }

        @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback
        public void onVerificationUrl(String r5, int r6) {
            d.h.b.o.e(r5, "url");
            Object r0 = ai.b(this.f10980a);
            ai r1 = this.f10980a;
            a r2 = this.f10981b;
            monitor-enter(r0);
            if (ai.c(r1).get(r2.a()) != r2) goto L7;
            boolean r3 = true;
        L8:
            monitor-exit(r0);
            if (r3 == true) goto L11;
            return;
        L11:
            a r4 = this.f10981b;
            d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L14
            g r8 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            r4.b().onVerificationUrl(3, r4.a().b(), r5, r6);     // Catch: Throwable -> L14
            d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            d.n.a r9 = d.n.f38560a;
            d.n.f(d.o.a(th));
            return;
        L7:
            r3 = false;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback
        public void onComplete(SidecarResult r8) {
            d.h.b.o.e(r8, "result");
            ai r1 = this.f10980a;
            a r2 = this.f10981b;
            ai.a(r1, r2, com.bytedance.safetyguard.lxc.internal.ipc.g.a(r8, r2.a().b()), null, 4, null);
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {227, ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM, 235, 237, 239, 241}, d = "executeSuspending", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f10985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ai f10986e;
        int f;

        h(ai r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10986e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10985d = r3;
            this.f |= Integer.MIN_VALUE;
            return ai.a(this.f10986e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {340}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost$releaseClientResources$2$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ai f10988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f10990d;

        i(ai r3, String r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10988b = r3;
            this.f10989c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f10988b, this.f10989c, r6);
            r0.f10990d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10987a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r6);     // Catch: Throwable -> L15
        L13:
            d.n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L15
        L18:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r6);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f10990d, am.class, "com.obric.aiagent.plugin");
            ai r8 = this.f10988b;
            String r2 = this.f10989c;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
            SafetyGuardSidecar r9 = ai.a(r8);     // Catch: Throwable -> L15
            this.f10987a = 1;     // Catch: Throwable -> L15
            r6 = r9.endSession(r2, this);     // Catch: Throwable -> L15
            if (r6 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r10 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    @d.c.b.a.f(b = "SidecarServiceHost.kt", c = {313, 315}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.service.SidecarServiceHost$scheduleSessionExpiry$job$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f10992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ai f10993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f10994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f10995e;

        j(long r3, ai r5, b r6, d.c.d<? super j> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10992b = r3;
            this.f10993c = r5;
            this.f10994d = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            j r11 = new j(this.f10992b, this.f10993c, this.f10994d, r7);
            r11.f10995e = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10991a;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 != 2) goto L11;
            d.o.a(r9);     // Catch: Throwable -> L8
        L22:
            d.n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L8
        L25:
            Object r10 = ai.b(this.f10993c);
            ai r2 = this.f10993c;
            b r8 = this.f10994d;
            monitor-enter(r10);
            ai.f(r2).remove(r8);     // Catch: Throwable -> L31
            d.x r11 = d.x.f38692a;     // Catch: Throwable -> L31
            monitor-exit(r10);
            return d.x.f38692a;
        L31:
            th = move-exception;
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            am r3 = (am) ZeusTransformUtils.preCheckCast(this.f10995e, am.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L17:
            if (ai.e(this.f10993c).c(this.f10994d.a(), this.f10994d.b()) == false) goto L25;
            ai r12 = this.f10993c;
            b r4 = this.f10994d;
            d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L8
            SafetyGuardSidecar r13 = ai.a(r12);     // Catch: Throwable -> L8
            String r6 = r4.b();     // Catch: Throwable -> L8
            this.f10995e = null;     // Catch: Throwable -> L8
            this.f10991a = 2;     // Catch: Throwable -> L8
            r9 = r13.endSession(r6, this);     // Catch: Throwable -> L8
            if (r9 != r0) goto L22;
            return r0;
        L13:
            d.o.a(r9);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.f10995e, am.class, "com.obric.aiagent.plugin");
            long r7 = d.l.n.a(this.f10992b - ((Number) ZeusTransformUtils.preCheckCast(ai.d(this.f10993c).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), 0);
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10995e = r14;
            this.f10991a = 1;
            if (ax.a(r7, r15) != r0) goto L17;
            return r0;
        L8:
            th = move-exception;
            d.n.a r16 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L25
        }
    }

    public ai(SafetyGuardSidecar r3, com.bytedance.safetyguard.lxc.internal.service.g r4, d.h.a.a<Long> r5, am r6) {
        SafetyGuardSidecar r7 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r6, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "sidecar");
        d.h.b.o.e(r4, "clients");
        d.h.b.o.e(r8, "nowMillis");
        d.h.b.o.e(r9, "scope");
        this.f10941a = r7;
        this.f10942b = r4;
        this.f10943c = r8;
        this.f10944d = r9;
        this.f10945e = new Object();
        this.f = new AtomicBoolean(false);
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        r4.a((d.h.a.q) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), d.h.a.q.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ SafetyGuardSidecar a(ai r0) {
        return r0.f10941a;
    }

    public static final /* synthetic */ Object a(ai r2, a r3, SidecarCommandParcel r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(ai r2, IBinder r3, Set r4, Set r5) {
        r2.a((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(ai r2, a r3, d.h.a.b r4) {
        r2.a(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(ai r0) {
        return r0.f10945e;
    }

    public static final /* synthetic */ LinkedHashMap c(ai r0) {
        return r0.g;
    }

    public static final /* synthetic */ d.h.a.a d(ai r0) {
        return r0.f10943c;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.service.g e(ai r0) {
        return r0.f10942b;
    }

    public static final /* synthetic */ LinkedHashMap f(ai r0) {
        return r0.h;
    }

    public /* synthetic */ ai(SafetyGuardSidecar r2, com.bytedance.safetyguard.lxc.internal.service.g r3, d.h.a.a r4, am r5, int r6, d.h.b.h r7) {
        SafetyGuardSidecar r8 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        am r10 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r9 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10946a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 8) == 0) goto L8;
        r10 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L8:
        this(r8, r3, r9, r10);
    }

    public final void a(int r20, IBinder r21, SidecarCommandParcel r22, ISidecarCallback r23) {
        IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r21, IBinder.class, "com.obric.aiagent.plugin");
        ISidecarCallback r3 = (ISidecarCallback) ZeusTransformUtils.wrapperContextForParams(r23, ISidecarCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "clientToken");
        d.h.b.o.e(r22, "command");
        d.h.b.o.e(r3, "callback");
        if ((!this.f.get()) == false) goto L29;
        if (this.f10942b.a(r20, r2, r22.getOperationId()) == true) goto L8;
        a(r3, com.bytedance.safetyguard.lxc.internal.ipc.g.a(new SidecarResult(false, 409, "operation", "duplicate_operation", "sidecar operation id is already active", null, null, null, null, null, null, 2016, null), r22.getOperationId()));
        return;
    L8:
        b r4 = new b(r2, r22.getOperationId());
        a r5 = new a(r4, r3);
        ca r6 = kotlinx.coroutines.i.a(this.f10944d, null, ao.f38852b, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r22, this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        r5.a(r6);
        Object r7 = this.f10945e;
        monitor-enter(r7);
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin")).put(r4, r5);     // Catch: Throwable -> L25
        d.x r8 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r7);
        if (this.f10942b.b(r2, r22.getOperationId()) == true) goto L23;
        Object r1 = this.f10945e;
        monitor-enter(r1);
        this.g.remove(r4, r5);     // Catch: Throwable -> L20
        monitor-exit(r1);
        r5.d();
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        r6.s_();
        return;
    L25:
        th = move-exception;
        throw th;
    L29:
        throw new IllegalStateException("sidecar service host is closed".toString());
    }

    public final void a(IBinder r5, String r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "clientToken");
        d.h.b.o.e(r6, "operationId");
        b r0 = new b(r7, r6);
        Object r1 = this.f10945e;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.g.remove(r0), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        monitor-exit(r1);
        this.f10942b.a(r7, r6);
        if (r2 == null) goto L15;
        r2.d();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean b(IBinder r5, String r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "clientToken");
        d.h.b.o.e(r6, ObricMemoryConstants.KEY_SESSION_ID);
        if (this.f10942b.c(r7, r6) == true) goto L5;
        return false;
    L5:
        Object r0 = this.f10945e;
        monitor-enter(r0);
        ca r8 = (ca) ZeusTransformUtils.preCheckCast(this.h.remove(new b(r7, r6)), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        monitor-exit(r0);
        if (r8 == null) goto L24;
        ca.a.a(r8, null, 1, null);
    L24:
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L14
        Object r4 = d.n.f(Boolean.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new e((ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin"), r6, null), d.h.a.m.class, "com.obric.aiagent.plugin")), Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L14
    L17:
        if (d.n.b(r4) == false) goto L20;
        r4 = false;
    L20:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L14:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
    L21:
        th = move-exception;
        throw th;
    }

    public final SidecarAuthHandler a() {
        SafetyGuardSidecar r2 = this.f10941a;
        if (ZeusTransformUtils.instanceOf(r2, SafetyGuardSidecarInternal.class) == false) goto L5;
        SafetyGuardSidecarInternal r3 = (SafetyGuardSidecarInternal) ZeusTransformUtils.preCheckCast(r2, SafetyGuardSidecarInternal.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 == null) goto L10;
        SidecarAuthHandler r4 = r3.authHandlerInternal();
        if (r4 == null) goto L10;
        return r4;
    L10:
        return SidecarAuthHandler.Companion.notImplemented();
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Object r0 = this.f10945e;
        monitor-enter(r0);
        Collection<a> r1 = this.g.values();     // Catch: Throwable -> L23
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L23
        List r2 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        Collection<ca> r3 = this.h.values();     // Catch: Throwable -> L23
        d.h.b.o.c(r3, "<get-values>(...)");     // Catch: Throwable -> L23
        List r4 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        this.g.clear();     // Catch: Throwable -> L23
        this.h.clear();     // Catch: Throwable -> L23
        d.m r5 = d.s.a(r2, r4);     // Catch: Throwable -> L23
        monitor-exit(r0);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        ((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin")).d();
        goto L11
    L13:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        AutoCloseable r8 = null;
        if (r7.hasNext() == false) goto L17;
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r7.next(), ca.class, "com.obric.aiagent.plugin"), null, 1, null);
        goto L14
    L17:
        an.a(this.f10944d, "sidecar service host closed", null, 2, null);
        SafetyGuardSidecar r9 = this.f10941a;
        if (ZeusTransformUtils.instanceOf(r9, AutoCloseable.class) == false) goto L20;
        r8 = (AutoCloseable) ZeusTransformUtils.preCheckCast(r9, AutoCloseable.class, "com.obric.aiagent.plugin");
    L20:
        if (r8 == null) goto L30;
        r8.close();
        return;
    L30:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private final void a(a r8, d.h.a.b<? super SidecarDeviceFlowCallback, ? extends SidecarOperation> r9) {
        r8.a((SidecarOperation) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(new g(this, r8)), SidecarOperation.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        e = move-exception;
        throw e;
    L6:
        a(this, r8, com.bytedance.safetyguard.lxc.internal.ipc.g.a(r8.a().b(), "sidecar operation failed"), null, 4, null);
    }

    private final Object a(a r12, SidecarCommandParcel r13, d.c.d<? super d.x> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, h.class) == false) goto L7;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r15, h.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.f10985d;
        Object r3 = d.c.a.b.a();
        String r5 = null;
        switch(r1.f) {
            case 0: goto L30;
            case 1: goto L27;
            case 2: goto L24;
            case 3: goto L21;
            case 4: goto L18;
            case 5: goto L15;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        r13 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r1.f10984c, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        r12 = (a) ZeusTransformUtils.preCheckCast(r1.f10983b, a.class, "com.obric.aiagent.plugin");
        ai this = (ai) ZeusTransformUtils.preCheckCast(r1.f10982a, ai.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L50:
        SidecarSessionEnv r17 = (SidecarSessionEnv) ZeusTransformUtils.preCheckCast(r16, SidecarSessionEnv.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r5 = r17.getSessionId();     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        SidecarResultParcel r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a(r17, r13.getOperationId());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L88:
        this.a(r12, r18, r5);
        return d.x.f38692a;
    L15:
        r13 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r1.f10984c, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        r12 = (a) ZeusTransformUtils.preCheckCast(r1.f10983b, a.class, "com.obric.aiagent.plugin");
        this = (ai) ZeusTransformUtils.preCheckCast(r1.f10982a, ai.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L56:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarAppInfo) ZeusTransformUtils.preCheckCast(r16, SidecarAppInfo.class, "com.obric.aiagent.plugin"), r13.getOperationId());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        goto L88
    L18:
        r13 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r1.f10984c, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        r12 = (a) ZeusTransformUtils.preCheckCast(r1.f10983b, a.class, "com.obric.aiagent.plugin");
        this = (ai) ZeusTransformUtils.preCheckCast(r1.f10982a, ai.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L60:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarAccountStatus) ZeusTransformUtils.preCheckCast(r16, SidecarAccountStatus.class, "com.obric.aiagent.plugin"), r13.getOperationId());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        goto L88
    L21:
        r13 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r1.f10984c, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        r12 = (a) ZeusTransformUtils.preCheckCast(r1.f10983b, a.class, "com.obric.aiagent.plugin");
        this = (ai) ZeusTransformUtils.preCheckCast(r1.f10982a, ai.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L64:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarResult) ZeusTransformUtils.preCheckCast(r16, SidecarResult.class, "com.obric.aiagent.plugin"), r13.getOperationId());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        goto L88
    L24:
        r13 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r1.f10984c, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        r12 = (a) ZeusTransformUtils.preCheckCast(r1.f10983b, a.class, "com.obric.aiagent.plugin");
        this = (ai) ZeusTransformUtils.preCheckCast(r1.f10982a, ai.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L68:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarResult) ZeusTransformUtils.preCheckCast(r16, SidecarResult.class, "com.obric.aiagent.plugin"), r13.getOperationId());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        goto L88
    L27:
        r13 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r1.f10984c, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        r12 = (a) ZeusTransformUtils.preCheckCast(r1.f10983b, a.class, "com.obric.aiagent.plugin");
        this = (ai) ZeusTransformUtils.preCheckCast(r1.f10982a, ai.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L78:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarResult) ZeusTransformUtils.preCheckCast(r16, SidecarResult.class, "com.obric.aiagent.plugin"), r13.getOperationId());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        goto L88
    L30:
        d.o.a(r16);
        int r19 = r13.getCommand();     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        boolean r0 = true;
        if (r19 != 2) goto L35;
        SafetyGuardSidecar r110 = this.f10941a;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        String r4 = r13.getProduction();     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r4 == null) goto L84;
        String r7 = r13.getAppId();     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r7 == null) goto L82;
        String r8 = r13.getAppSecret();     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r8 == null) goto L80;
        r1.f10982a = this;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10983b = r12;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10984c = r13;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f = 1;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r16 = r110.configImportApp(r4, r7, r8, r1);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r16 != r3) goto L78;
        return r3;
    L80:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L82:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L84:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L35:
        if (r19 == 3) goto L65;
        switch(r19) {
            case 6: goto L61;
            case 7: goto L57;
            case 8: goto L53;
            case 9: goto L38;
            default: goto L37;
        };
    L37:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a(r13.getOperationId(), "unsupported sidecar command");     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        goto L88
    L38:
        SafetyGuardSidecar r111 = this.f10941a;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        String r6 = r13.getCliName();     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r6 == null) goto L52;
        Long r9 = d.c.b.a.b.a(r13.getTtlSeconds());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).longValue() >= 0) goto L44;
        r0 = false;
    L44:
        if (r0 == true) goto L47;
        r9 = null;
    L47:
        StartSidecarSessionRequest r2 = new StartSidecarSessionRequest(r6, r9);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10982a = this;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10983b = r12;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10984c = r13;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f = 6;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r16 = r111.startSession(r2, r1);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r16 != r3) goto L50;
        return r3;
    L52:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
    L53:
        SafetyGuardSidecar r112 = this.f10941a;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10982a = this;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10983b = r12;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10984c = r13;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f = 5;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r16 = r112.configuredApp(r1);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r16 != r3) goto L56;
        return r3;
    L57:
        SafetyGuardSidecar r113 = this.f10941a;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10982a = this;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10983b = r12;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10984c = r13;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f = 4;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r16 = r113.status(r1);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r16 != r3) goto L60;
        return r3;
    L61:
        SafetyGuardSidecar r114 = this.f10941a;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10982a = this;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10983b = r12;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10984c = r13;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f = 3;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r16 = r114.logout(r1);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r16 != r3) goto L64;
        return r3;
    L65:
        SafetyGuardSidecar r115 = this.f10941a;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10982a = this;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10983b = r12;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f10984c = r13;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r1.f = 2;     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        r16 = r115.configDeleteApp(r1);     // Catch: Throwable -> L85 SidecarOperationException -> L86 CancellationException -> L90
        if (r16 != r3) goto L68;
        return r3;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L86:
        e = move-exception;
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a(e.getResult(), r13.getOperationId());
    L90:
        e = move-exception;
        throw e;
    L85:
        r18 = com.bytedance.safetyguard.lxc.internal.ipc.g.a(r13.getOperationId(), "sidecar operation failed");
    L7:
        r1 = new h(this, r15);
        goto L8
    }

    static /* synthetic */ void a(ai r0, a r1, SidecarResultParcel r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(a r9, SidecarResultParcel r10, String r11) {
        Object r0 = this.f10945e;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.g.get(r9.a()) == r9) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);
        if (r1 == true) goto L19;
        if (r11 == null) goto L33;
        kotlinx.coroutines.i.a(this.f10944d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L33:
        return;
    L19:
        if (this.f10942b.a(r9.a().a(), r9.a().b(), r11) == true) goto L24;
        if (r11 == null) goto L22;
        kotlinx.coroutines.i.a(this.f10944d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L22:
        a(r9.b(), com.bytedance.safetyguard.lxc.internal.ipc.g.a(r9.a().b(), "sidecar client lease is no longer available"));
        return;
    L24:
        if (r11 == null) goto L26;
        a(new b(r9.a().a(), r11), r10.getExpiresAtMillis());
    L26:
        a(r9.b(), r10);
        return;
    L7:
        if (r9.c() == false) goto L11;
        this.g.remove(r9.a());     // Catch: Throwable -> L28
        r1 = true;
        goto L12
    }

    private final void a(b r10, long r11) {
        ca r12 = kotlinx.coroutines.i.a(this.f10944d, null, ao.f38852b, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r11, this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        Object r13 = this.f10945e;
        monitor-enter(r13);
        ca r9 = (ca) ZeusTransformUtils.preCheckCast(this.h.put(r10, r12), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r9 == null) goto L7;
        d.h.b.o.a(r9);     // Catch: Throwable -> L10
        ca.a.a(r9, null, 1, null);     // Catch: Throwable -> L10
        d.x r14 = d.x.f38692a;     // Catch: Throwable -> L10
    L7:
        monitor-exit(r13);
        r12.s_();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void a(IBinder r10, Set<String> r11, Set<String> r12) {
        IBinder r13 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.aiagent.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        Object r0 = this.f10945e;
        monitor-enter(r0);
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        Iterator r17 = r16.iterator();     // Catch: Throwable -> L31
    L6:
        if (r17.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.g.remove(new b(r13, r2)), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r3 == null) goto L6;
        r1.add(r3);     // Catch: Throwable -> L31
        goto L6
    L10:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        monitor-exit(r0);
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        ((a) ZeusTransformUtils.preCheckCast(r19.next(), a.class, "com.obric.aiagent.plugin")).d();
        goto L14
    L16:
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r110.hasNext() == false) goto L30;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin");
        Object r4 = this.f10945e;
        monitor-enter(r4);
        ca r5 = (ca) ZeusTransformUtils.preCheckCast(this.h.remove(new b(r13, r111)), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        monitor-exit(r4);
        if (r5 == null) goto L26;
        ca.a.a(r5, null, 1, null);
    L26:
        kotlinx.coroutines.i.a(this.f10944d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r111, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L27:
        th = move-exception;
        throw th;
    L30:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    private final void a(ISidecarCallback r3, SidecarResultParcel r4) {
        ISidecarCallback r5 = (ISidecarCallback) ZeusTransformUtils.wrapperContextForParams(r3, ISidecarCallback.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        ai r2 = (ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r5.onResult(r4);     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }
}
