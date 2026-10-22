package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.keva.KevaImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.LoggedInUserInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class af implements fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f19444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.am f19445b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Gson f19446c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<kotlinx.coroutines.a.d<fc>> f19447d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long[] f19448e = null;
    private static final Set<com.obric.autogui.tools.api.net.c> f = null;

    /* JADX INFO: compiled from: SkillServerTracking.kt */
    @d.c.b.a.f(b = "SkillServerTracking.kt", c = {144, 145}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.OfaSkillServerTrackingSink$queues$1$1$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.a.d<fc> f19451c;

        a(kotlinx.coroutines.a.d<fc> r3, d.c.d<? super a> r4) {
            kotlinx.coroutines.a.d<fc> r5 = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19451c = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f19451c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0080 -> B:7:0x001d). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19450b;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            kotlinx.coroutines.a.f<fc> r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f19449a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L7:
            kotlinx.coroutines.a.f<fc> r10 = r2;
        L12:
            d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19449a = r10;
            this.f19450b = 1;
            Object r4 = r10.a(r3);
            if (r4 != r0) goto L15;
            return r0;
        L15:
            r2 = r10;
            r9 = r4;
        L17:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L22;
            fc r11 = (fc) ZeusTransformUtils.preCheckCast(r2.a(), fc.class, "com.obric.aiagent.plugin");
            af r5 = af.f19444a;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19449a = r2;
            this.f19450b = 2;
            if (af.a(r5, r11, r6) != r0) goto L7;
            return r0;
        L22:
            return d.x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f19449a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
            goto L17
        L11:
            d.o.a(r9);
            r10 = this.f19451c.g();
            goto L12
        }
    }

    /* JADX INFO: compiled from: SkillServerTracking.kt */
    @d.c.b.a.f(b = "SkillServerTracking.kt", c = {215, 226}, d = "send", e = "com.obric.aiagent.skill.manager.impl.OfaSkillServerTrackingSink")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ af f19455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19456e;

        b(af r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19455d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19454c = r3;
            this.f19456e |= Integer.MIN_VALUE;
            return af.b(this.f19455d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillServerTracking.kt */
    @d.c.b.a.f(b = "SkillServerTracking.kt", c = {216}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.OfaSkillServerTrackingSink$send$foundationReady$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19457a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19457a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.c.b.a.b.a(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            AutoActionFoundation r6 = AutoActionFoundation.INSTANCE;
            d.c.d<? super d.x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19457a = 1;
            if (r6.suspendUntilReady(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillServerTracking.kt */
    @d.c.b.a.f(b = "SkillServerTracking.kt", c = {174, 209}, d = "sendWithRetry", e = "com.obric.aiagent.skill.manager.impl.OfaSkillServerTrackingSink")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f19461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ af f19462e;
        int f;

        d(af r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19462e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19461d = r3;
            this.f |= Integer.MIN_VALUE;
            return af.a(this.f19462e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private af() {
    }

    public static final /* synthetic */ Object a(af r2, fc r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(af r2, fc r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f19444a = new af();
        f19445b = kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        Gson r2 = new GsonBuilder().disableHtmlEscaping().create();
        d.h.b.o.c(r2, "create(...)");
        f19446c = r2;
        ArrayList r3 = new ArrayList(4);
        int r6 = 0;
    L4:
        if (r6 >= 4) goto L6;
        kotlinx.coroutines.a.d r7 = kotlinx.coroutines.a.g.a(64, null, null, 6, null);
        kotlinx.coroutines.i.a(f19445b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        ee.f19808a.a("SkillManager", "server queue created shard=" + r6, "server queue created shard=" + r6 + " capacity=64");
        r3.add(r7);
        r6 = r6 + 1;
        goto L4
    L6:
        f19447d = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        f19448e = new long[]{1000, 2000, 4000};
        f = d.a.ax.a(new com.obric.autogui.tools.api.net.c[]{com.obric.autogui.tools.api.net.c.f31484c, com.obric.autogui.tools.api.net.c.f31485d, com.obric.autogui.tools.api.net.c.f31486e, com.obric.autogui.tools.api.net.c.f, com.obric.autogui.tools.api.net.c.g, com.obric.autogui.tools.api.net.c.h});
    }

    @Override // com.obric.aiagent.skill.manager.impl.fb
    public boolean a(fc r4) {
        d.h.b.o.e(r4, "snapshot");
        int r3 = (r4.a().hashCode() & Integer.MAX_VALUE) % 4;
        if (kotlinx.coroutines.a.h.a(((kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(f19447d.get(r3), kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin")).a_(r4)) == false) goto L6;
        return true;
    L6:
        ee.f19808a.c("SkillManager", "server report dropped because queue is full", "server report dropped because queue is full: skillId=" + r4.a() + ", operation=" + r4.g().a() + ", shard=" + r3);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01e4 -> B:50:0x01eb). Please report as a decompilation issue!!! */
    private final Object a(fc r18, d.c.d<? super d.x> r19) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
        af r4 = this;
    L8:
        Object r2 = r3.f19461d;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f;
        int r8 = 1;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r7 = r3.f19460c;
        fc r9 = (fc) ZeusTransformUtils.preCheckCast(r3.f19459b, fc.class, "com.obric.aiagent.plugin");
        af r0 = (af) ZeusTransformUtils.preCheckCast(r3.f19458a, af.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        fc r10 = r9;
        Object r11 = r5;
        char r12 = 2;
        int r13 = 1;
    L50:
        r8 = r13;
        int r14 = r7 + r13;
        r4 = r0;
    L52:
        r3.f19458a = r4;     // Catch: CancellationException -> L20 Exception -> L28
        r3.f19459b = r10;     // Catch: CancellationException -> L20 Exception -> L28
        r3.f19460c = r14;     // Catch: CancellationException -> L20 Exception -> L28
        r3.f = r8;     // Catch: CancellationException -> L20 Exception -> L28
        if (r4.b(r10, r3) != r11) goto L26;
        return r11;
    L26:
        af r15 = r4;
        r7 = r14;
        r5 = r11;
        fc r16 = r10;
    L27:
        Exception e2 = null;
    L31:
        if (e2 != null) goto L34;
        ee.f19808a.b("SkillManager", "server report succeeded operation=" + r16.g().a() + " attempt=" + r7, "server report succeeded skillId=" + r16.a() + " operation=" + r16.g().a() + " attempt=" + r7);
        return d.x.f38692a;
    L34:
        boolean r17 = r15.b((Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
        if (r17 == true) goto L37;
    L41:
        boolean r110 = 0;
    L42:
        Object r111 = r5;
        ee.f19808a.a("SkillManager", "server report failed operation=" + r16.g().a() + " attempt=" + r7 + " retryable=" + r17 + " willRetry=" + r110, "server report failed skillId=" + r16.a() + " operation=" + r16.g().a() + " attempt=" + r7 + "/4 retryable=" + r17 + " willRetry=" + r110 + " error=" + r15.a((Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin")), (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
        if (r110 == 0) goto L45;
        long r20 = f19448e[r7 - 1];
        r3.f19458a = r15;
        r3.f19459b = r16;
        r3.f19460c = r7;
        r12 = 2;
        r3.f = 2;
        if (kotlinx.coroutines.ax.a(r20, r3) != r111) goto L49;
        return r111;
    L49:
        r0 = r15;
        r13 = 1;
        fc r112 = r16;
        r11 = r111;
        r10 = r112;
        goto L50
    L45:
        return d.x.f38692a;
    L37:
        if (r7 >= 4) goto L41;
        if (com.obric.aiagent.skill.manager.api.al.f19195a.a().E() == false) goto L41;
        r110 = r8;
        goto L42
    L20:
        e = move-exception;
        throw e;
    L28:
        e2 = e;
        r15 = r4;
        r7 = r14;
        r5 = r11;
        r16 = r10;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r3.f19460c;
        r16 = (fc) ZeusTransformUtils.preCheckCast(r3.f19459b, fc.class, "com.obric.aiagent.plugin");
        r15 = (af) ZeusTransformUtils.preCheckCast(r3.f19458a, af.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Exception -> L18 CancellationException -> L20
    L18:
        e2 = e;
        goto L31
    L22:
        d.o.a(r2);
        r10 = r18;
        r11 = r5;
        r14 = 1;
    L7:
        r4 = this;
        r3 = new d(r4, r1);
        goto L8
    }

    private final Object b(fc r13, d.c.d<? super d.x> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r1.f19456e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f19456e -= Integer.MIN_VALUE;
    L8:
        b r8 = r1;
        Object r16 = r8.f19454c;
        Object r2 = d.c.a.b.a();
        int r3 = r8.f19456e;
        String r11 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r16);
    L29:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r12 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");
        if (r12.a() == false) goto L72;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r12.c(), String.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L65;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L50;
        r17 = null;
    L50:
        if (r17 == null) goto L65;
        fa r18 = (fa) ZeusTransformUtils.preCheckCast(f19446c.fromJson(r17, fa.class), fa.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L61
        if (r18 == null) goto L60;
        if (r18.a() != 0) goto L58;
        return d.x.f38692a;
    L58:
        throw new eq(r18.a());
    L60:
        throw new ex("invalid_body", null, 2, null);
    L61:
        e = move-exception;
        throw new ex("invalid_body", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L65:
        throw new ex("empty_body", null, 2, null);
    L72:
        com.obric.autogui.tools.api.net.b r19 = r12.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L33 CancellationException -> L42
    L35:
        if (r19 == null) goto L37;
        com.obric.autogui.tools.api.net.c r110 = r19.getType();
    L38:
        if (r19 == null) goto L41;
        r11 = r19.a();
    L41:
        throw new et(r110, ez.a(r11));
    L37:
        r110 = null;
    L42:
        e = move-exception;
        throw e;
    L33:
        r19 = null;
        goto L35
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (fc) ZeusTransformUtils.preCheckCast(r8.f19453b, fc.class, "com.obric.aiagent.plugin");
        af this = (af) ZeusTransformUtils.preCheckCast(r8.f19452a, af.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L19:
        Boolean r111 = (Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L22;
        boolean r112 = r111.booleanValue();
    L23:
        if (r112 == false) goto L69;
        ey r113 = this.a();
        String r4 = this.a(r113.a());
        com.obric.autogui.tools.api.net.a r114 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r114 == null) goto L67;
        Map<String, String> r5 = d.a.ao.a(d.a.ao.a(new d.m[]{d.s.a("Accept", "application/json"), d.s.a(DownloadHelper.CONTENT_TYPE, "application/json"), d.s.a("X-Tt-Trace", "1")}), r113.b());
        String r6 = f19446c.toJson(r13);
        d.h.b.o.c(r6, "toJson(...)");
        r8.f19452a = null;
        r8.f19453b = null;
        r8.f19456e = 2;
        r16 = r114.a(r4, r5, r6, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r8);
        if (r16 != r2) goto L29;
        return r2;
    L67:
        throw new er();
    L69:
        throw new es();
    L22:
        r112 = false;
        goto L23
    L16:
        d.o.a(r16);
        d.h.a.m r115 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r8.f19452a = this;
        r8.f19453b = r13;
        r8.f19456e = 1;
        r16 = kotlinx.coroutines.dg.b(5000, r115, r8);
        if (r16 != r2) goto L19;
        return r2;
    L7:
        r1 = new b(this, r15);
        goto L8
    }

    private final ey a() {
        LoggedInUserInfo r4 = AOPlatformTools.INSTANCE.account().acquireUserInfo().getUserInfo();
        Map r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getUserId();
    L6:
        String r2 = ez.b(r1);
        if (r2 != null) goto L13;
        r2 = ez.b(com.obric.aiagent.flow.applog.a.f18577a.e());
        if (r2 != null) goto L13;
        throw new ev(eu.f19841a);
    L13:
        if (r4 == null) goto L15;
        Map<String, String> r5 = r4.getAuthHeaders();
    L16:
        Map r6 = ez.a(r5);
        if (ez.b(r6) == true) goto L21;
        r6 = null;
    L21:
        if (com.obric.aiagent.utils.shared_state.b.f22344a.a() == false) goto L25;
        Map r3 = ez.a(com.obric.aiagent.utils.shared_state.b.f22344a.e());
        if (ez.b(r3) == false) goto L25;
        r0 = r3;
    L25:
        if (r6 != null) goto L31;
        if (r0 == null) goto L29;
        r6 = r0;
        goto L31
    L29:
        throw new ev(eu.f19842b);
    L31:
        return new ey(r2, r6);
    L15:
        r5 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    private final String a(String r2) {
        String r1 = Uri.parse(com.obric.aiagent.product.a.a.f18769a.a("/assistant/multi_agent/update_skill")).buildUpon().appendQueryParameter("uid", r2).build().toString();
        d.h.b.o.c(r1, "toString(...)");
        return r1;
    }

    private final String a(Throwable r5) {
        String r4 = "Unknown";
        if (r5 != null) goto L6;
        return "Unknown";
    L6:
        if (ZeusTransformUtils.instanceOf(r5, eq.class) == false) goto L9;
        return r5.getClass().getSimpleName() + "(code=" + ((eq) ZeusTransformUtils.preCheckCast(r5, eq.class, "com.obric.aiagent.plugin")).a() + ')';
    L9:
        if (ZeusTransformUtils.instanceOf(r5, ev.class) == false) goto L12;
        return r5.getClass().getSimpleName() + "(reason=" + ((ev) ZeusTransformUtils.preCheckCast(r5, ev.class, "com.obric.aiagent.plugin")).a().a() + ')';
    L12:
        if (ZeusTransformUtils.instanceOf(r5, et.class) == false) goto L24;
        StringBuilder r0 = new StringBuilder().append(r5.getClass().getSimpleName()).append("(type=");
        com.obric.autogui.tools.api.net.c r3 = ((et) ZeusTransformUtils.preCheckCast(r5, et.class, "com.obric.aiagent.plugin")).getType();
        if (r3 == null) goto L17;
        String r6 = r3.name();
        if (r6 == null) goto L17;
    L18:
        StringBuilder r1 = r0.append(r6).append(",code=");
        String r7 = ((et) ZeusTransformUtils.preCheckCast(r5, et.class, "com.obric.aiagent.plugin")).a();
        if (r7 == null) goto L33;
        r4 = r7;
    L33:
        return r1.append(r4).append(')').toString();
    L17:
        r6 = "Unknown";
        goto L18
    L24:
        if (ZeusTransformUtils.instanceOf(r5, ex.class) == false) goto L27;
        return r5.getClass().getSimpleName() + "(reason=" + ((ex) ZeusTransformUtils.preCheckCast(r5, ex.class, "com.obric.aiagent.plugin")).a() + ')';
    L27:
        if (ZeusTransformUtils.instanceOf(r5, es.class) == false) goto L29;
        String r8 = r5.getClass().getSimpleName();
        d.h.b.o.c(r8, "getSimpleName(...)");
        return r8;
    L29:
        String r9 = r5.getClass().getSimpleName();
        d.h.b.o.c(r9, "getSimpleName(...)");
        return r9;
    }

    private final boolean b(Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r3, er.class) == false) goto L5;
    L11:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, es.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r3, et.class) == true) goto L13;
        return false;
    L13:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.aiagent.plugin"), ((et) ZeusTransformUtils.preCheckCast(r3, et.class, "com.obric.aiagent.plugin")).getType());
    }
}
