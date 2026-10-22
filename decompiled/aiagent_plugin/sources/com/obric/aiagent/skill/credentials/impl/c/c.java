package com.obric.aiagent.skill.credentials.impl.c;

import android.net.Uri;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAccountStatus;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperationException;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarSessionEnv;
import com.bytedance.safetyguard.lxc.api.sidecar.StartSidecarSessionRequest;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.credentials.api.e;
import com.obric.aiagent.skill.credentials.api.g;
import com.obric.aiagent.skill.credentials.api.h;
import com.obric.aiagent.skill.credentials.api.i;
import com.obric.aiagent.skill.credentials.api.j;
import com.obric.aiagent.skill.credentials.api.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.t;

/* JADX INFO: compiled from: SafetyGuardSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final String TAG = "SkillCredential";

    /* JADX INFO: compiled from: SafetyGuardSupport.kt */
    @f(b = "SafetyGuardSupport.kt", c = {35}, d = "runCatchingCredential", e = "com.obric.aiagent.skill.credentials.impl.safetyguard.SafetyGuardSupportKt")
    static final class a<T> extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19028b;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f19027a = r2;
            this.f19028b |= Integer.MIN_VALUE;
            Object r1 = c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r1 != d.c.a.b.a()) goto L6;
            return r1;
        L6:
            return n.g(r1);
        }
    }

    /* JADX INFO: compiled from: SafetyGuardSupport.kt */
    @f(b = "SafetyGuardSupport.kt", c = {95}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.safetyguard.SafetyGuardSupportKt$sidecarFlow$1")
    static final class b extends l implements m<q<? super com.obric.aiagent.skill.credentials.api.c>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<SidecarDeviceFlowCallback, SidecarOperation> f19031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f19032d;

        /* JADX INFO: compiled from: SafetyGuardSupport.kt */
        public static final class a implements SidecarDeviceFlowCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f19033a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q<com.obric.aiagent.skill.credentials.api.c> f19034b;

            a(String r3, q<? super com.obric.aiagent.skill.credentials.api.c> r4) {
                q<com.obric.aiagent.skill.credentials.api.c> r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
                this.f19033a = r3;
                this.f19034b = r5;
            }

            @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback
            public void onVerificationUrl(String r5, int r6) {
                o.e(r5, "url");
                c.a(this.f19033a + " verificationUrl expires=" + r6, this.f19033a + " verificationUrl safeUrl=" + c.a(r5) + " expires=" + r6);
                q<com.obric.aiagent.skill.credentials.api.c> r0 = this.f19034b;
                String r4 = this.f19033a;
                r0.a_(new com.obric.aiagent.skill.credentials.api.c.b(new j(r4, r5, r6, c.b(r4))));
            }

            @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback
            public void onComplete(SidecarResult r6) {
                o.e(r6, "result");
                h r7 = c.a(r6);
                c.a(this.f19033a + " complete ok=" + r7.a() + " code=" + r7.b(), this.f19033a + " complete ok=" + r7.a() + " code=" + r7.b() + " type=" + r7.getType() + " subtype=" + r7.c() + " scopeCount=" + r7.f().size());
                this.f19034b.a_(new com.obric.aiagent.skill.credentials.api.c.a(r7));
                t.a.a((t) ZeusTransformUtils.preCheckCast(this.f19034b, t.class, "com.obric.aiagent.plugin"), null, 1, null);
            }
        }

        b(String r3, d.h.a.b<? super SidecarDeviceFlowCallback, ? extends SidecarOperation> r4, d.c.d<? super b> r5) {
            d.h.a.b<SidecarDeviceFlowCallback, SidecarOperation> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19030b = r3;
            this.f19031c = r6;
            super(2, r7);
        }

        /* JADX INFO: renamed from: lambda$bDi56ZWwR1MURoyc4jP-YTftldU, reason: not valid java name */
        public static /* synthetic */ x m249lambda$bDi56ZWwR1MURoyc4jPYTftldU(q r0, z.f r1, String r2) {
            return a(r0, r1, r2);
        }

        public final Object a(q<? super com.obric.aiagent.skill.credentials.api.c> r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f19030b, this.f19031c, r6);
            r0.f19032d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(q<? super com.obric.aiagent.skill.credentials.api.c> r3, d.c.d<? super x> r4) {
            return a((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.Object] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19029a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L26:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            final q r12 = (q) ZeusTransformUtils.preCheckCast(this.f19032d, q.class, "com.obric.aiagent.plugin");
            final z.f r2 = new z.f();
            a r4 = new a(this.f19030b, r12);
            d.h.a.b<SidecarDeviceFlowCallback, SidecarOperation> r5 = this.f19031c;
            String r6 = this.f19030b;
            n.a r8 = n.f38560a;     // Catch: Throwable -> L17
            r2.f38504a = r5.invoke(r4);     // Catch: Throwable -> L17
            String r7 = r6 + " operation started";     // Catch: Throwable -> L17
            StringBuilder r9 = new StringBuilder().append(r6).append(" operation started operationId=");     // Catch: Throwable -> L17
            SidecarOperation r10 = (SidecarOperation) ZeusTransformUtils.preCheckCast(r2.f38504a, SidecarOperation.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            if (r10 == null) goto L12;
            String r13 = r10.getOperationId();     // Catch: Throwable -> L17
        L13:
            if (r13 != null) goto L15;
            r13 = "";
        L15:
            c.a(r7, r9.append(r13).toString());     // Catch: Throwable -> L17
            Object r14 = n.f(x.f38692a);     // Catch: Throwable -> L17
        L19:
            String r15 = this.f19030b;
            Throwable r16 = n.c(r14);
            if (r16 == null) goto L22;
            c.a(r15 + " start failed", r15 + " start failed", r16);
            r12.a_(new com.obric.aiagent.skill.credentials.api.c.a(c.a(r16, r15)));
            t.a.a((t) ZeusTransformUtils.preCheckCast(r12, t.class, "com.obric.aiagent.plugin"), null, 1, null);
        L22:
            final String r17 = this.f19030b;
            d.h.a.a r18 = new $$Lambda$c$b$bDi56ZWwR1MURoyc4jPYTftldU(r12, r2, r17);
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19029a = 1;
            if (kotlinx.coroutines.a.o.a(r12, r18, r3) != r0) goto L26;
            return r0;
        L12:
            r13 = null;
        L17:
            th = move-exception;
            n.a r19 = n.f38560a;
            r14 = n.f(d.o.a(th));
            goto L19
        }

        private static final x a(q r2, z.f r3, String r4) {
            q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
            n.a r6 = n.f38560a;     // Catch: Throwable -> L9
            SidecarOperation r7 = (SidecarOperation) ZeusTransformUtils.preCheckCast(r3.f38504a, SidecarOperation.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r7 == null) goto L6;
            r7.close();     // Catch: Throwable -> L9
            x r8 = x.f38692a;     // Catch: Throwable -> L9
        L7:
            Object r9 = n.f(r8);     // Catch: Throwable -> L9
        L11:
            Throwable r10 = n.c(r9);
            if (r10 == null) goto L15;
            c.a(r4 + " operation close failed", r4 + " operation close failed", r10);
        L15:
            return x.f38692a;
        L6:
            r8 = null;
        L9:
            th = move-exception;
            n.a r11 = n.f38560a;
            r9 = n.f(d.o.a(th));
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.c.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafetyGuardSupport.kt */
    @f(b = "SafetyGuardSupport.kt", c = {193}, d = "startSessionModel", e = "com.obric.aiagent.skill.credentials.impl.safetyguard.SafetyGuardSupportKt")
    static final class C0418c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19036b;

        C0418c(d.c.d<? super C0418c> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19035a = r3;
            this.f19036b |= Integer.MIN_VALUE;
            return c.a(null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ String a(String r0) {
        return e(r0);
    }

    public static final /* synthetic */ String b(String r0) {
        return c(r0);
    }

    public static final <T> Object a(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r4, d.c.d<? super n<? extends T>> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if ((r0.f19028b & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19028b -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f19027a;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f19028b;
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L18;
        d.o.a(r8);     // Catch: Throwable -> L13 CancellationException -> L15
    L23:
    L30:
        return n.f(r8);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r8);
        n.a r9 = n.f38560a;     // Catch: Throwable -> L13 CancellationException -> L15
        r0.f19028b = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        r8 = r6.invoke(r0);     // Catch: Throwable -> L13 CancellationException -> L15
        if (r8 != r1) goto L23;
        return r1;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        n.a r10 = n.f38560a;
        return n.f(d.o.a(th));
    L7:
        r0 = new a(r7);
        goto L8
    }

    public static final kotlinx.coroutines.b.h<com.obric.aiagent.skill.credentials.api.c> a(String r3, d.h.a.b<? super SidecarDeviceFlowCallback, ? extends SidecarOperation> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "flowName");
        o.e(r5, "start");
        return kotlinx.coroutines.b.j.c((m) ZeusTransformUtils.preCheckCast(new b(r3, r5, null), m.class, "com.obric.aiagent.plugin"));
    }

    public static final h a(com.obric.aiagent.skill.credentials.api.f r2, String r3) {
        o.e(r2, "<this>");
        o.e(r3, "method");
        if (r2 != com.obric.aiagent.skill.credentials.api.f.f18949a) goto L7;
        return null;
    L7:
        return a(r3, "unsupported_provider", "Credential provider " + r2.a() + " is not supported in phase 1.", "Use provider " + com.obric.aiagent.skill.credentials.api.f.f18949a.a() + '.');
    }

    public static final com.obric.aiagent.skill.credentials.api.b a(SidecarAppInfo r10, com.obric.aiagent.skill.credentials.api.f r11) {
        o.e(r10, "<this>");
        o.e(r11, "provider");
        String r0 = r10.getCurrentUserOpenId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r10.getCurrentUserName();
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L12;
    L14:
        i r7 = new i(r0, r1);
    L16:
        return new com.obric.aiagent.skill.credentials.api.b(r11.a(), r10.getAppId(), a(r10.getBrand()), r7, r10.getHasUserToken(), r10.getHasBotToken());
    L12:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        r7 = null;
        goto L16
    }

    public static final com.obric.aiagent.skill.credentials.api.a a(SidecarAccountStatus r7, com.obric.aiagent.skill.credentials.api.f r8) {
        o.e(r7, "<this>");
        o.e(r8, "provider");
        SidecarAppInfo r1 = r7.getApp();
        if (r1 == null) goto L5;
        com.obric.aiagent.skill.credentials.api.b r9 = a(r1, r8);
    L7:
        return new com.obric.aiagent.skill.credentials.api.a(r9, r7.getLoggedIn(), p.o((Iterable) ZeusTransformUtils.preCheckCast(r7.getGrantedScopes(), Iterable.class, "com.obric.aiagent.plugin")), r7.getAccessTokenExpiresAtMillis(), r7.getRefreshTokenExpiresAtMillis());
    L5:
        r9 = null;
        goto L7
    }

    public static final h a(SidecarResult r12) {
        o.e(r12, "<this>");
        boolean r2 = r12.getOk();
        Integer r3 = Integer.valueOf(r12.getCode());
        String r4 = d(r12.getType());
        String r5 = d(r12.getSubtype());
        if (r12.getOk() == false) goto L5;
        String r7 = null;
    L7:
        if (r12.getOk() == false) goto L9;
        String r8 = null;
    L10:
        String r9 = d(r12.getAppId());
        String r10 = d(r12.getUserOpenId());
        SidecarBrand r1 = r12.getBrand();
        if (r1 == null) goto L13;
        String r11 = a(r1);
    L15:
        return new h(r2, r3, r4, r5, r7, r8, r9, r10, r11, p.o((Iterable) ZeusTransformUtils.preCheckCast(r12.getScopes(), Iterable.class, "com.obric.aiagent.plugin")));
    L13:
        r11 = null;
        goto L15
    L9:
        r8 = "Retry the operation.";
        goto L10
    L5:
        r7 = "Credential operation failed.";
        goto L7
    }

    public static final g a(SidecarSessionEnv r8) {
        o.e(r8, "<this>");
        Map<String, String> r0 = r8.asEnvironment();
        Set<String> r1 = k.a();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r3 = r0.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r1.contains((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L4;
        r2.put(r4.getKey(), r4.getValue());
        goto L4
    L8:
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");
        return new g(r8.getSessionId(), r5, r8.getAppId(), a(r8.getBrand()), r8.getExpiresAtMillis());
    }

    public static final Object a(SafetyGuardSidecar r5, String r6, long r7, d.c.d<? super g> r9) {
        SafetyGuardSidecar r8 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r5, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C0418c.class) == false) goto L7;
        C0418c r0 = (C0418c) ZeusTransformUtils.preCheckCast(r10, C0418c.class, "com.obric.aiagent.plugin");
        if ((r0.f19036b & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19036b -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f19035a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19036b;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r11);
    L18:
        return a((SidecarSessionEnv) ZeusTransformUtils.preCheckCast(r11, SidecarSessionEnv.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        StartSidecarSessionRequest r12 = new StartSidecarSessionRequest(r6, d.c.b.a.b.a(r7));
        r0.f19036b = 1;
        r11 = r8.startSession(r12, r0);
        if (r11 != r2) goto L18;
        return r2;
    L7:
        r0 = new C0418c(r10);
        goto L8
    }

    public static final h a(Throwable r3, String r4) {
        o.e(r3, "<this>");
        o.e(r4, "method");
        h r2 = null;
        if (ZeusTransformUtils.instanceOf(r3, SidecarOperationException.class) == false) goto L5;
        SidecarOperationException r0 = (SidecarOperationException) ZeusTransformUtils.preCheckCast(r3, SidecarOperationException.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L8;
        SidecarResult r1 = r0.getResult();
    L9:
        if (r1 == null) goto L13;
        return a(r1);
    L13:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L15;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
    L16:
        if (r5 == null) goto L18;
        r2 = r5.a();
    L18:
        if (r2 == null) goto L21;
        return r2;
    L21:
        return a(r4, "adapter_failed", "Credential operation failed.", "Retry the operation.");
    L15:
        r5 = null;
        goto L16
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }

    public static final void a(String r2, String r3) {
        o.e(r2, "releaseMessage");
        o.e(r3, "debugMessage");
        ILogDepend.Companion r0 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r2 = r3;
    L5:
        r0.i(TAG, r2);
    }

    public static final void b(String r2, String r3) {
        o.e(r2, "releaseMessage");
        o.e(r3, "debugMessage");
        ILogDepend.Companion r0 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r2 = r3;
    L5:
        r0.w(TAG, r2);
    }

    public static final void a(String r2, String r3, Throwable r4) {
        o.e(r2, "releaseMessage");
        o.e(r3, "debugMessage");
        o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r3, r4);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }

    public static final h a(String r14, String r15, String r16, String r17) {
        o.e(r14, "method");
        o.e(r15, "subtype");
        o.e(r16, "message");
        o.e(r17, "hint");
        a("Credential operation unavailable", "Credential operation unavailable method=" + r14 + " subtype=" + r15);
        return new h(false, null, "sidecar", r15, r16, r17, null, null, null, null, 962, null);
    }

    private static final String c(String r1) {
        if (o.a(r1, "configCreateApp") == false) goto L6;
        return "Create Feishu App";
    L6:
        if (o.a(r1, "requestGrant") == false) goto L8;
        return "Grant Feishu Scopes";
    L8:
        return "Login Feishu Account";
    }

    private static final String a(SidecarBrand r0) {
        return r0.getCliValue();
    }

    private static final String d(String r3) {
        if (r3 == null) goto L8;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        return r3;
    L8:
        return null;
    }

    private static final String e(String r2) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L7
        Uri r3 = Uri.parse(r2);     // Catch: Throwable -> L7
        StringBuilder r1 = new StringBuilder().append(r3.getScheme()).append("://").append(r3.getHost());     // Catch: Throwable -> L7
        String r4 = r3.getPath();     // Catch: Throwable -> L7
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Object r5 = n.f(r1.append(r4).toString());     // Catch: Throwable -> L7
    L10:
        if (n.b(r5) == false) goto L13;
        r5 = "invalid-url";
    L13:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L10
    }
}
