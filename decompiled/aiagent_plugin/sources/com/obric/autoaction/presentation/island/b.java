package com.obric.autoaction.presentation.island;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.k;
import d.o;
import d.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: IslandSessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25048a = null;
    private static final IslandApi n = null;
    private static final Context o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f25050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LiveCardType f25051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f25052e;
    private final am f;
    private final kotlinx.coroutines.a.d<com.obric.autoaction.presentation.island.d> g;
    private IslandSession h;
    private C0599b i;
    private final String j;
    private int k;
    private IslandCardCallback l;
    private m<? super IslandSession, ? super Integer, x> m;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: IslandSessionManager.kt */
    @d.c.b.a.f(b = "IslandSessionManager.kt", c = {67, 69}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.IslandSessionManager$1")
    static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f25054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f25055c;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.b$1$a */
        /* JADX INFO: compiled from: IslandSessionManager.kt */
        @d.c.b.a.f(b = "IslandSessionManager.kt", c = {71, ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId, ITaskManager.Stub.TRANSACTION_tryActiveAgent, 74, 75}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.island.IslandSessionManager$1$result$1")
        static final class a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25056a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autoaction.presentation.island.d f25057b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f25058c;

            a(com.obric.autoaction.presentation.island.d r3, b r4, d.c.d<? super a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25057b = r3;
                this.f25058c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f25057b, this.f25058c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25056a;
                if (r1 == 0) goto L13;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L12;
                if (r1 == 3) goto L12;
                if (r1 == 4) goto L12;
                if (r1 == 5) goto L12;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                o.a(r9);
            L39:
                return x.f38692a;
            L13:
                o.a(r9);
                com.obric.autoaction.presentation.island.d r10 = this.f25057b;
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.presentation.island.d.a.class) == false) goto L19;
                b r11 = this.f25058c;
                com.obric.autoaction.presentation.island.d.a r2 = (com.obric.autoaction.presentation.island.d.a) ZeusTransformUtils.preCheckCast(this.f25057b, com.obric.autoaction.presentation.island.d.a.class, "com.obric.aiagent.plugin");
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25056a = 1;
                if (b.a(r11, r2, r3) != r0) goto L39;
                return r0;
            L19:
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.presentation.island.d.e.class) == false) goto L24;
                b r12 = this.f25058c;
                com.obric.autoaction.presentation.island.d.e r4 = (com.obric.autoaction.presentation.island.d.e) ZeusTransformUtils.preCheckCast(this.f25057b, com.obric.autoaction.presentation.island.d.e.class, "com.obric.aiagent.plugin");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25056a = 2;
                if (b.a(r12, r4, r5) != r0) goto L39;
                return r0;
            L24:
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.presentation.island.d.b.class) == false) goto L29;
                b r13 = this.f25058c;
                com.obric.autoaction.presentation.island.d.b r6 = (com.obric.autoaction.presentation.island.d.b) ZeusTransformUtils.preCheckCast(this.f25057b, com.obric.autoaction.presentation.island.d.b.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25056a = 3;
                if (b.a(r13, r6, r7) != r0) goto L39;
                return r0;
            L29:
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.presentation.island.d.c.class) == false) goto L34;
                b r14 = this.f25058c;
                com.obric.autoaction.presentation.island.d.c r8 = (com.obric.autoaction.presentation.island.d.c) ZeusTransformUtils.preCheckCast(this.f25057b, com.obric.autoaction.presentation.island.d.c.class, "com.obric.aiagent.plugin");
                d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25056a = 4;
                if (b.a(r14, r8, r15) != r0) goto L39;
                return r0;
            L34:
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.presentation.island.d.C0600d.class) == false) goto L41;
                b r16 = this.f25058c;
                com.obric.autoaction.presentation.island.d.C0600d r17 = (com.obric.autoaction.presentation.island.d.C0600d) ZeusTransformUtils.preCheckCast(this.f25057b, com.obric.autoaction.presentation.island.d.C0600d.class, "com.obric.aiagent.plugin");
                d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25056a = 5;
                if (b.a(r16, r17, r18) != r0) goto L39;
                return r0;
            L41:
                throw new k();
            }
        }

        AnonymousClass1(b r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25055c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25055c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0097 -> B:25:0x009a). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25054b;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            kotlinx.coroutines.a.f r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f25053a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            o.a(r12);     // Catch: Exception -> L9
        L25:
            if (((x) ZeusTransformUtils.preCheckCast(r12, x.class, "com.obric.aiagent.plugin")) != null) goto L36;
            Loog.INSTANCE.e(b.a(this.f25055c), "handle command timeout");     // Catch: Exception -> L9
        L36:
            kotlinx.coroutines.a.f r13 = r2;
        L15:
            d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25053a = r13;
            this.f25054b = 1;
            Object r4 = r13.a(r3);
            if (r4 != r0) goto L18;
            return r0;
        L18:
            r2 = r13;
            r12 = r4;
        L20:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L38;
            com.obric.autoaction.presentation.island.d r14 = (com.obric.autoaction.presentation.island.d) ZeusTransformUtils.preCheckCast(r2.a(), com.obric.autoaction.presentation.island.d.class, "com.obric.aiagent.plugin");
            m r15 = (m) ZeusTransformUtils.preCheckCast(new a(r14, this.f25055c, null), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
            this.f25053a = r2;     // Catch: Exception -> L9
            this.f25054b = 2;     // Catch: Exception -> L9
            r12 = dg.b(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r15, r8);     // Catch: Exception -> L9
            if (r12 != r0) goto L25;
            return r0;
        L38:
            return x.f38692a;
        L9:
            e = move-exception;
            IslandSession r6 = this.f25055c.c();
            if (r6 == null) goto L35;
            b r7 = this.f25055c;
            IslandApi r9 = b.f();
            if (r9 == null) goto L34;
            r9.destroySession(r6);
        L34:
            r7.a(null);
        L35:
            Loog.INSTANCE.e(b.a(this.f25055c), "handle command error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L36
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f25053a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            o.a(r12);
            goto L20
        L14:
            o.a(r12);
            r13 = b.e(this.f25055c).g();
            goto L15
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IslandSessionManager.kt */
    private static final class C0599b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f25059a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0599b.class) == true) goto L8;
            return false;
        L8:
            C0599b r8 = (C0599b) ZeusTransformUtils.preCheckCast(r7, C0599b.class, "com.obric.aiagent.plugin");
            if (this.f25059a == r8.f25059a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f25059a);
        }

        public String toString() {
            return "HidingIslandSession(taskId=" + this.f25059a + ')';
        }

        public C0599b(long r1) {
            this.f25059a = r1;
        }

        public final long a() {
            return this.f25059a;
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    @d.c.b.a.f(b = "IslandSessionManager.kt", c = {388}, d = "handleCreate", e = "com.obric.autoaction.presentation.island.IslandSessionManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f25061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f25062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f25063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f25064e;
        int f;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25064e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25063d = r3;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f25064e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class d implements IslandCardCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f25065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<IslandSession> f25066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f25067c;

        d(b r3, n<? super IslandSession> r4) {
            n<IslandSession> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            this.f25065a = r3;
            this.f25066b = r5;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionActive(IslandSession r6) {
            d.h.b.o.e(r6, SensitiveType.SESSION);
            Loog.INSTANCE.d(b.a(this.f25065a), "onSessionActive " + r6.getTaskId());
            IslandCardCallback r5 = this.f25065a.d();
            if (r5 == null) goto L6;
            r5.onSessionActive(r6);
            return;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionCreate(IslandSession r6) {
            d.h.b.o.e(r6, SensitiveType.SESSION);
            Loog.INSTANCE.d(b.a(this.f25065a), "onSessionCreate " + r6.getTaskId());
            IslandCardCallback r0 = this.f25065a.d();
            if (r0 == null) goto L5;
            r0.onSessionCreate(r6);
        L5:
            this.f25067c = true;
            b.a(this.f25065a, 0);
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f25066b, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r5.resumeWith(d.n.f(r6));
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionDestroy(IslandSession r8, Integer r9) {
            d.h.b.o.e(r8, SensitiveType.SESSION);
            Loog.INSTANCE.d(b.a(this.f25065a), "onSessionDestroy " + r8.getTaskId() + ' ' + r9);
            IslandCardCallback r0 = this.f25065a.d();
            if (r0 == null) goto L5;
            r0.onSessionDestroy(r8, r9);
        L5:
            boolean r1 = true;
            if (r9 == null) goto L15;
            if (r9.intValue() != 1) goto L15;
            if (b.b(this.f25065a) > 0) goto L15;
            Loog.INSTANCE.d(b.a(this.f25065a), "try to recreate session ");
            b.a(this.f25065a, 1);
            this.f25065a.a(r8.getCollapseWidget(), r8.getExpandWidget());
            return;
        L15:
            if (this.f25067c == false) goto L17;
        L19:
            IslandSession r10 = this.f25065a.c();
            if (r10 != null) goto L22;
        L24:
            boolean r11 = false;
        L25:
            if (r11 == false) goto L37;
            C0599b r12 = b.c(this.f25065a);
            if (r12 != null) goto L29;
        L31:
            r1 = false;
        L32:
            if (r1 == false) goto L35;
            Loog.INSTANCE.d(b.a(this.f25065a), "[Destroy] CurrentHidden -> " + r8.getTaskId());
            return;
        L35:
            Loog.INSTANCE.d(b.a(this.f25065a), "[Destroy] Clearing IslandSession=" + r8.getTaskId() + ", currentIs=" + this.f25065a.c());
            this.f25065a.a(null);
            return;
        L29:
            if (r8.getTaskId() != r12.a()) goto L31;
        L37:
            return;
        L22:
            if (r8.getTaskId() != r10.getTaskId()) goto L24;
            r11 = true;
            goto L25
        L17:
            if (this.f25066b.a() == false) goto L19;
            ILogDepend.Companion.e(b.a(this.f25065a), "create session failed! " + r9 + ' ');
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f25066b, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r2.resumeWith(d.n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("session create failed " + r9 + ' ' + r8.getTaskId()), Throwable.class, "com.obric.aiagent.plugin"))));
            goto L19
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionInactive(IslandSession r5) {
            d.h.b.o.e(r5, SensitiveType.SESSION);
            IslandCardCallback r0 = this.f25065a.d();
            if (r0 == null) goto L5;
            r0.onSessionInactive(r5);
        L5:
            Loog.INSTANCE.d(b.a(this.f25065a), "onSessionInactive " + r5.getTaskId());
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionStatusChanged(IslandSession r6, int r7) {
            d.h.b.o.e(r6, SensitiveType.SESSION);
            IslandCardCallback r0 = this.f25065a.d();
            if (r0 == null) goto L5;
            r0.onSessionStatusChanged(r6, r7);
        L5:
            Loog.INSTANCE.d(b.a(this.f25065a), "onSessionStatus change session=" + r6.getTaskId() + " stauts=" + r7);
            m r1 = b.d(this.f25065a);
            if (r1 == null) goto L8;
            r1.invoke(r6, Integer.valueOf(r7));
        L8:
            Long r2 = null;
            b.a(this.f25065a, null);
            IslandSession r3 = this.f25065a.c();
            if (r3 == null) goto L11;
            r2 = Long.valueOf(r3.getTaskId());
        L11:
            long r4 = r6.getTaskId();
            if (r2 != null) goto L15;
            return;
        L15:
            if (r4 == r2.longValue()) goto L17;
            return;
        L17:
            if (r7 != (-2)) goto L19;
            this.f25065a.b(8, false);
            return;
        L19:
            this.f25065a.a(8, false);
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public Bundle onWidgetShow(IslandWidget r5) {
            d.h.b.o.e(r5, "widget");
            Loog.INSTANCE.d(b.a(this.f25065a), "onWidgetShow " + r5.getTemplateId());
            IslandCardCallback r4 = this.f25065a.d();
            if (r4 == null) goto L7;
            r4.onWidgetShow(r5);
            return null;
        L7:
            return null;
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    @d.c.b.a.f(b = "IslandSessionManager.kt", c = {315}, d = "handleDestroy", e = "com.obric.autoaction.presentation.island.IslandSessionManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f25069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f25070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f25071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f25072e;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25071d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25070c = r3;
            this.f25072e |= Integer.MIN_VALUE;
            return b.a(this.f25071d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    @d.c.b.a.f(b = "IslandSessionManager.kt", c = {363}, d = "handleShow", e = "com.obric.autoaction.presentation.island.IslandSessionManager")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f25074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f25075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f25076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f25077e;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25076d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25075c = r3;
            this.f25077e |= Integer.MIN_VALUE;
            return b.a(this.f25076d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public b(boolean r8, long r9, LiveCardType r11, String r12) {
        d.h.b.o.e(r11, "type");
        d.h.b.o.e(r12, DownloadHelper.IDENTITY);
        this.f25049b = r8;
        this.f25050c = r9;
        this.f25051d = r11;
        this.f25052e = r12;
        am r1 = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin")));
        this.f = r1;
        this.g = kotlinx.coroutines.a.g.a(Integer.MAX_VALUE, null, null, 6, null);
        this.j = r12 + "_IslandSessionManager";
        i.a(r1, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autoaction.presentation.island.d.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autoaction.presentation.island.d.b r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autoaction.presentation.island.d.c r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autoaction.presentation.island.d.C0600d r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autoaction.presentation.island.d.e r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(b r0) {
        return r0.j;
    }

    public static final /* synthetic */ void a(b r0, int r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ void a(b r2, m r3) {
        r2.m = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ int b(b r0) {
        return r0.k;
    }

    public static final /* synthetic */ C0599b c(b r0) {
        return r0.i;
    }

    public static final /* synthetic */ m d(b r0) {
        return r0.m;
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d e(b r0) {
        return r0.g;
    }

    public static final /* synthetic */ IslandApi f() {
        return n;
    }

    public static final /* synthetic */ Context g() {
        return o;
    }

    public final boolean a() {
        return this.f25049b;
    }

    public final long b() {
        return this.f25050c;
    }

    public /* synthetic */ b(boolean r7, long r8, LiveCardType r10, String r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = false;
    L5:
        boolean r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = 0;
    L8:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r10 = LiveCardType.OAUTO;
    L11:
        this(r1, r2, r10, r11);
    }

    public final LiveCardType getType() {
        return this.f25051d;
    }

    static {
        f25048a = new a(null);
        n = ILiveCard.Companion.getInst().getIslandService();
        o = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public final void a(IslandSession r1) {
        this.h = r1;
    }

    public final IslandSession c() {
        return this.h;
    }

    public final void a(IslandCardCallback r3) {
        this.l = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r3, IslandCardCallback.class, "com.obric.aiagent.plugin");
    }

    public final IslandCardCallback d() {
        return this.l;
    }

    public final void a(m<? super IslandSession, ? super Integer, x> r4) {
        m<? super IslandSession, ? super Integer, x> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "onStatusChanged");
        a(8, true);
        this.m = r5;
    }

    public final void a(long r7, boolean r9) {
        this.f25050c |= r7;
        Loog r0 = Loog.INSTANCE;
        String r1 = this.j;
        StringBuilder r2 = new StringBuilder().append("new flag ");
        String r3 = Long.toString(this.f25050c, d.o.a.a(2));
        d.h.b.o.c(r3, "toString(...)");
        r0.d(r1, r2.append(r3).append(" immediate ").append(r9).toString());
        IslandSession r4 = this.h;
        if (r4 == null) goto L5;
        r4.setFlags(r7 | this.f25050c);
    L5:
        if (r9 == false) goto L10;
        IslandSession r6 = this.h;
        if (r6 == null) goto L11;
        r6.updateFlags();
        return;
    L11:
        return;
    }

    public static /* synthetic */ void a(b r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r0.b(r1, r3);
    }

    public final void b(long r7, boolean r9) {
        long r0 = this.f25050c;
        long r8 = ~r7;
        this.f25050c = r0 & r8;
        Loog r1 = Loog.INSTANCE;
        String r2 = this.j;
        StringBuilder r3 = new StringBuilder().append("clear flag ");
        String r4 = Long.toString(this.f25050c, d.o.a.a(2));
        d.h.b.o.c(r4, "toString(...)");
        r1.d(r2, r3.append(r4).append(" immediate ").append(r9).toString());
        IslandSession r5 = this.h;
        if (r5 == null) goto L5;
        r5.setFlags(r8 & this.f25050c);
    L5:
        if (r9 == false) goto L10;
        IslandSession r6 = this.h;
        if (r6 == null) goto L11;
        r6.updateFlags();
        return;
    L11:
        return;
    }

    public final void a(IslandWidget r4, IslandWidget r5) {
        Loog.INSTANCE.d(this.j, "send createSession");
        this.g.a_(new com.obric.autoaction.presentation.island.d.a(r4, r5));
    }

    public static /* synthetic */ void a(b r0, IslandWidget r1, IslandWidget r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(IslandWidget r4, IslandWidget r5, boolean r6) {
        Loog.INSTANCE.d(this.j, "send update widget");
        this.g.a_(new com.obric.autoaction.presentation.island.d.e(r4, r5, r6));
    }

    public final void a(long r4) {
        Loog.INSTANCE.d(this.j, "send hide current session");
        this.g.a_(new com.obric.autoaction.presentation.island.d.c(r4));
    }

    public final void b(long r4) {
        Loog.INSTANCE.d(this.j, "send show current session");
        this.g.a_(new com.obric.autoaction.presentation.island.d.C0600d(r4));
    }

    public final void c(long r4) {
        Loog.INSTANCE.d(this.j, "send destroy current session");
        this.g.a_(new com.obric.autoaction.presentation.island.d.b(r4));
    }

    private final Object a(com.obric.autoaction.presentation.island.d.a r29, d.c.d<? super x> r30) {
        b r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f25063d;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r3.f25062c;
        com.obric.autoaction.presentation.island.d.a r7 = (com.obric.autoaction.presentation.island.d.a) ZeusTransformUtils.preCheckCast(r3.f25061b, com.obric.autoaction.presentation.island.d.a.class, "com.obric.aiagent.plugin");
        r0 = (b) ZeusTransformUtils.preCheckCast(r3.f25060a, b.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L26:
        IslandSession r8 = (IslandSession) ZeusTransformUtils.preCheckCast(r2, IslandSession.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(r0.j, "new session created " + r8.getTaskId() + " cost " + (SystemClock.elapsedRealtime() - r6));
        IslandSession r9 = r0.h;
        if (r9 == null) goto L31;
        Loog.INSTANCE.d(r0.j, "destroy old session " + r9.getTaskId());
        IslandApi r10 = n;
        if (r10 == null) goto L31;
        r10.destroySession(r9);
    L31:
        r0.h = r8;
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        long r11 = SystemClock.elapsedRealtime();
        Loog.INSTANCE.d(r0.j, "create new session");
        r3.f25060a = r0;
        r3.f25061b = r29;
        r3.f25062c = r11;
        r3.f = 1;
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r12.e();
        n r13 = (n) ZeusTransformUtils.preCheckCast(r12, n.class, "com.obric.aiagent.plugin");
        IslandWidget r14 = r29.a();
        IslandWidget r15 = r29.b();
        boolean r16 = a();
        long r22 = b();
        IslandSession r17 = new IslandSession(r14, r15, null, (IslandCardCallback) ZeusTransformUtils.preCheckCast(new d(r0, r13), IslandCardCallback.class, "com.obric.aiagent.plugin"), null, 0, getType(), null, d.c.b.a.b.a(r16), null, r22, null, 0, 6836, null);
        if (c(this) == null) goto L17;
        Loog.INSTANCE.w(a(this), "[Hide] Trying to create a new IslandSession when hidden=" + c(this));
        d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r19 = d.n.f38560a;
        r18.resumeWith(d.n.f(r17));
    L20:
        r2 = r12.h();
        if (r2 != d.c.a.b.a()) goto L23;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    L23:
        if (r2 != r4) goto L25;
        return r4;
    L25:
        r6 = r11;
        goto L26
    L17:
        IslandApi r20 = f();
        if (r20 == null) goto L20;
        d.c.b.a.b.a(r20.createSession(r17, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    L7:
        r3 = new c(r0, r1);
        goto L8
    }

    private final Object a(com.obric.autoaction.presentation.island.d.e r8, d.c.d<? super x> r9) {
        d.c.d<? super x> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        IslandSession r0 = this.h;
        if (r0 == null) goto L5;
        IslandWidget r2 = r0.getExpandWidget();
        d.h.a.a<x> r3 = null;
        if (r2 == null) goto L16;
        Object r4 = r2.getTemplateData();
        if (r4 == null) goto L16;
        Class<?> r5 = r4.getClass();
    L17:
        IslandWidget r6 = r8.b();
        if (r6 == null) goto L22;
        Object r7 = r6.getTemplateData();
        if (r7 == null) goto L22;
        Class<?> r11 = r7.getClass();
    L24:
        if (d.h.b.o.a(r5, r11) == false) goto L81;
        IslandWidget r12 = r0.getCollapseWidget();
        if (r12 == null) goto L30;
        Object r13 = r12.getTemplateData();
        if (r13 == null) goto L30;
        Class<?> r14 = r13.getClass();
    L31:
        IslandWidget r15 = r8.a();
        if (r15 == null) goto L36;
        Object r16 = r15.getTemplateData();
        if (r16 == null) goto L36;
        Class<?> r17 = r16.getClass();
    L38:
        if (d.h.b.o.a(r14, r17) == false) goto L81;
        Loog r18 = Loog.INSTANCE;
        String r19 = this.j;
        StringBuilder r20 = new StringBuilder().append("update widget directly ");
        IslandSession r21 = this.h;
        if (r21 == null) goto L43;
        Long r22 = d.c.b.a.b.a(r21.getTaskId());
    L44:
        r18.d(r19, r20.append(r22).toString());
        IslandWidget r23 = r8.b();
        if (r23 == null) goto L47;
        r0.update(r23);
    L47:
        IslandWidget r24 = r8.a();
        if (r24 == null) goto L50;
        r0.update(r24);
    L50:
        IslandWidget r25 = r0.getExpandWidget();
        if (r25 == null) goto L58;
        IslandWidget r26 = r8.b();
        if (r26 == null) goto L56;
        Map<String, d.h.a.a<x>> r27 = r26.getOnClickCallback();
        if (r27 == null) goto L56;
    L57:
        r25.setOnClickCallback(r27);
    L56:
        r27 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L58:
        IslandWidget r28 = r0.getExpandWidget();
        if (r28 == null) goto L65;
        IslandWidget r29 = r8.b();
        if (r29 == null) goto L63;
        d.h.a.a<x> r30 = r29.getOnCardClickCallback();
    L64:
        r28.setOnCardClickCallback(r30);
        goto L65
    L63:
        r30 = null;
    L65:
        IslandWidget r31 = r0.getCollapseWidget();
        if (r31 == null) goto L73;
        IslandWidget r32 = r8.a();
        if (r32 == null) goto L71;
        Map<String, d.h.a.a<x>> r33 = r32.getOnClickCallback();
        if (r33 == null) goto L71;
    L72:
        r31.setOnClickCallback(r33);
    L71:
        r33 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L73:
        IslandWidget r34 = r0.getCollapseWidget();
        if (r34 == null) goto L79;
        IslandWidget r35 = r8.a();
        if (r35 == null) goto L78;
        r3 = r35.getOnCardClickCallback();
    L78:
        r34.setOnCardClickCallback(r3);
    L79:
        r0.updateFlags();
        return x.f38692a;
    L43:
        r22 = null;
    L36:
        r17 = null;
    L30:
        r14 = null;
    L81:
        Loog.INSTANCE.d(this.j, "widget type changed, create a new session");
        Object r36 = a(new com.obric.autoaction.presentation.island.d.a(r8.a(), r8.b()), r10);
        if (r36 != d.c.a.b.a()) goto L85;
        return r36;
    L85:
        return x.f38692a;
    L22:
        r11 = null;
    L16:
        r5 = null;
        goto L17
    L5:
        if (r8.c() == false) goto L10;
        Object r37 = a(new com.obric.autoaction.presentation.island.d.a(r8.a(), r8.b()), r10);
        if (r37 != d.c.a.b.a()) goto L10;
        return r37;
    L10:
        return x.f38692a;
    }

    private final Object a(com.obric.autoaction.presentation.island.d.b r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
        if ((r0.f25072e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f25072e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f25070c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f25072e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        IslandSession r8 = (IslandSession) ZeusTransformUtils.preCheckCast(r0.f25069b, IslandSession.class, "com.obric.aiagent.plugin");
        b r13 = (b) ZeusTransformUtils.preCheckCast(r0.f25068a, b.class, "com.obric.aiagent.plugin");
        o.a(r12);
    L20:
        IslandApi r14 = n;
        if (r14 == null) goto L23;
        r14.destroySession(r8);
    L23:
        Loog.INSTANCE.d(r13.j, "session " + r8.getTaskId() + " destroyed");
        b this = r13;
    L24:
        this.h = null;
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r12);
        IslandSession r15 = this.h;
        if (r15 == null) goto L24;
        Loog.INSTANCE.d(this.j, "will destroy session " + r15.getTaskId() + " after " + r9.a() + "ms");
        long r5 = r9.a();
        r0.f25068a = this;
        r0.f25069b = r15;
        r0.f25072e = 1;
        if (ax.a(r5, r0) != r2) goto L19;
        return r2;
    L19:
        r13 = this;
        r8 = r15;
    L7:
        r0 = new e(this, r11);
        goto L8
    }

    private final Object a(com.obric.autoaction.presentation.island.d.c r5, d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        IslandSession r8 = this.h;
        if (r8 != null) goto L5;
        Loog.INSTANCE.w(this.j, "[Hide] Muting the islandSession when there aren't an ongoing.");
    L5:
        C0599b r9 = this.i;
        if (r8 == null) goto L8;
        long r1 = r8.getTaskId();
    L9:
        this.i = new C0599b(r1);
        Loog.INSTANCE.d(this.j, "[Hide] Muting the islandSession -> (" + this.i + "), priv=" + r9 + '.');
        if (r8 == null) goto L16;
        IslandApi r10 = n;
        if (r10 == null) goto L14;
        r10.destroySession(r8);
    L14:
        Loog.INSTANCE.d(this.j, "session " + r8.getTaskId() + " hidden");
    L16:
        return x.f38692a;
    L8:
        r1 = -1;
        goto L9
    }

    private final Object a(com.obric.autoaction.presentation.island.d.C0600d r8, d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L7;
        f r11 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.aiagent.plugin");
        if ((r11.f25077e & Integer.MIN_VALUE) == 0) goto L7;
        r11.f25077e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r11.f25075c;
        Object r1 = d.c.a.b.a();
        int r2 = r11.f25077e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        IslandSession r7 = (IslandSession) ZeusTransformUtils.preCheckCast(r11.f25074b, IslandSession.class, "com.obric.aiagent.plugin");
        b r13 = (b) ZeusTransformUtils.preCheckCast(r11.f25073a, b.class, "com.obric.aiagent.plugin");
        o.a(r12);
        IslandSession r14 = r7;
        b this = r13;
    L25:
        Loog.INSTANCE.d(this.j, "session " + r14.getTaskId() + " shown");
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r12);
        if (this.i != null) goto L18;
        Loog.INSTANCE.e(this.j, "won't show session because no ongoing hide.");
        return x.f38692a;
    L18:
        this.i = null;
        r14 = this.h;
        if (r14 != null) goto L22;
        Loog.INSTANCE.e(this.j, "won't show session because no current session.");
        return x.f38692a;
    L22:
        Loog.INSTANCE.d(this.j, "[Show] the current session " + r14.getTaskId());
        com.obric.autoaction.presentation.island.d.a r0 = new com.obric.autoaction.presentation.island.d.a(r14.getCollapseWidget(), r14.getExpandWidget());
        r11.f25073a = this;
        r11.f25074b = r14;
        r11.f25077e = 1;
        if (a(r0, r11) != r1) goto L25;
        return r1;
    L7:
        r11 = new f(this, r10);
        goto L8
    }

    public final x e() {
        IslandApi r0 = n;
        if (r0 == null) goto L5;
        r0.collapseIsland();
        return x.f38692a;
    L5:
        return null;
    }
}
