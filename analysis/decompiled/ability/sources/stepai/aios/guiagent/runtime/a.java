package stepai.aios.guiagent.runtime;

import Ca.C0203b;
import Ca.C0205d;
import Ca.C0206e;
import Ca.C0207f;
import Ca.C0208g;
import Ca.G;
import android.content.Context;
import j9.m;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.c;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.q0;
import p9.i;
import p9.j;
import s9.C1923c;
import stepai.aios.guiagent.config.RuntimeConfig;
import stepai.aios.guiagent.model.SessionState;
import stepai.aios.guiagent.tracer.GuiTracerConfig;
import stepai.aios.guiagent.tracer.GuiTracerManager;
import stepai.aios.guiagent.tracer.TraceScreenshotStore;
import stepai.aios.guiexecutor.input.UserInputManager;
import w9.f;
import w9.g;
import wa.C2110a;
import wa.e;
import z2.l;
import za.d;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public RuntimeConfig f6128a;
    public final androidx.compose.runtime.changelist.a b;
    public final C1923c c;
    public final C2110a d;
    public GuiTracerManager e;
    public final UserInputManager f;
    public final stepai.aios.guiagent.pipeline.b g;
    public final ConcurrentHashMap h;
    public final ConcurrentHashMap i;

    /* renamed from: j, reason: collision with root package name */
    public int f6129j;
    public final f k;

    public a(Context context, RuntimeConfig _runtimeConfig, androidx.compose.runtime.changelist.a aVar) {
        k.f(_runtimeConfig, "_runtimeConfig");
        this.f6128a = _runtimeConfig;
        this.b = aVar;
        this.c = AbstractC1683A.b(l.H(AbstractC1683A.c(), AbstractC1691I.f5315a));
        C2110a c2110a = new C2110a();
        this.d = c2110a;
        UserInputManager userInputManager = new UserInputManager();
        this.f = userInputManager;
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        new ConcurrentHashMap();
        int maxConcurrentTasks = this.f6128a.getMaxConcurrentTasks();
        this.f6129j = maxConcurrentTasks;
        int i = g.f6856a;
        this.k = new f(maxConcurrentTasks);
        TraceScreenshotStore traceScreenshotStore = TraceScreenshotStore.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        traceScreenshotStore.initialize(applicationContext);
        this.g = new stepai.aios.guiagent.pipeline.b(context, this.f6128a, c2110a, userInputManager, new stepai.aios.guiagent.pipeline.a(), new C0203b(this, 0));
        userInputManager.addUserInputListener(new C0208g(this));
        C0207f c0207f = new C0207f(this);
        e eVar = c2110a.c;
        eVar.getClass();
        eVar.b.add(c0207f);
        j(this.f6128a.getTracerConfig());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(stepai.aios.guiagent.runtime.a r6, java.lang.String r7, Ca.C0205d r8, java.lang.String r9, long r10, kotlin.coroutines.jvm.internal.ContinuationImpl r12) {
        /*
            boolean r0 = r12 instanceof stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$1
            if (r0 == 0) goto L13
            r0 = r12
            stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$1 r0 = (stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$1 r0 = new stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$1
            r0.<init>(r6, r12)
        L18:
            java.lang.Object r12 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.String r7 = r0.c
            Ca.d r8 = r0.b
            java.lang.String r9 = r0.f6119a
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L34
            r5 = r9
            r9 = r7
            r7 = r5
            goto La1
        L34:
            r10 = move-exception
            r5 = r9
            r9 = r7
            r7 = r5
            goto La8
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            long r10 = r0.d
            java.lang.String r9 = r0.c
            Ca.d r8 = r0.b
            java.lang.String r7 = r0.f6119a
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L74
            goto L70
        L4e:
            kotlin.b.b(r12)
            m9.q r12 = r8.c
            boolean r12 = r12.r()
            if (r12 != 0) goto Lab
            stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$completed$1 r12 = new stepai.aios.guiagent.runtime.GuiRuntime$awaitOrForceFinalize$completed$1     // Catch: java.lang.Throwable -> L74
            r2 = 0
            r12.<init>(r8, r2)     // Catch: java.lang.Throwable -> L74
            r0.f6119a = r7     // Catch: java.lang.Throwable -> L74
            r0.b = r8     // Catch: java.lang.Throwable -> L74
            r0.c = r9     // Catch: java.lang.Throwable -> L74
            r0.d = r10     // Catch: java.lang.Throwable -> L74
            r0.g = r4     // Catch: java.lang.Throwable -> L74
            java.lang.Object r12 = kotlinx.coroutines.a.p(r10, r12, r0)     // Catch: java.lang.Throwable -> L74
            if (r12 != r1) goto L70
            goto Lb0
        L70:
            if (r12 == 0) goto L73
            goto L74
        L73:
            r4 = 0
        L74:
            if (r4 != 0) goto Lab
            m9.q r12 = r8.c
            boolean r12 = r12.r()
            if (r12 != 0) goto Lab
            za.d r12 = s2.C1912a.j(r9)
            za.d r12 = za.d.a(r12, r7)
            m9.q r2 = r8.c
            i(r12, r2)
            stepai.aios.guiagent.pipeline.b r12 = r6.g     // Catch: java.lang.Throwable -> La7
            r0.f6119a = r7     // Catch: java.lang.Throwable -> La7
            r0.b = r8     // Catch: java.lang.Throwable -> La7
            r0.c = r9     // Catch: java.lang.Throwable -> La7
            r0.d = r10     // Catch: java.lang.Throwable -> La7
            r0.g = r3     // Catch: java.lang.Throwable -> La7
            r12.getClass()     // Catch: java.lang.Throwable -> La7
            java.lang.Object r12 = stepai.aios.guiagent.pipeline.b.u(r12, r7, r9, r0)     // Catch: java.lang.Throwable -> La7
            if (r12 != r1) goto La1
            goto Lb0
        La1:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> La7
            r12.getClass()     // Catch: java.lang.Throwable -> La7
            goto Lab
        La7:
            r10 = move-exception
        La8:
            kotlin.b.a(r10)
        Lab:
            r6.l(r7, r8, r9)
            C7.r r1 = C7.r.f317a
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.runtime.a.a(stepai.aios.guiagent.runtime.a, java.lang.String, Ca.d, java.lang.String, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final void b(a aVar, String str, G g) {
        i iVar = (i) aVar.i.get(str);
        if (iVar == null) {
            return;
        }
        aVar.k(iVar, g);
    }

    public static final String c(a aVar, String str) {
        int iQ0 = m.q0(str, "sessionId=", 0, false, 6);
        if (iQ0 < 0) {
            return null;
        }
        int i = iQ0 + 10;
        int iP0 = m.p0(str, ';', i, 4);
        String strSubstring = iP0 < 0 ? str.substring(i) : str.substring(i, iP0);
        k.e(strSubstring, "substring(...)");
        return m.R0(strSubstring).toString();
    }

    public static final String d(a aVar, String str) {
        int iQ0 = m.q0(str, "sessionId=", 0, false, 6);
        if (iQ0 < 0) {
            return str;
        }
        int iP0 = m.p0(str, ';', iQ0 + 10, 4);
        if (iP0 < 0) {
            return "";
        }
        String strSubstring = str.substring(iP0 + 1);
        k.e(strSubstring, "substring(...)");
        return m.R0(strSubstring).toString();
    }

    public static final boolean e(a aVar, String str, j jVar, SessionState sessionState) {
        aVar.getClass();
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) jVar;
        SessionState sessionState2 = (SessionState) iVar.getValue();
        if (!sessionState2.a() || sessionState == sessionState2) {
            iVar.i(sessionState);
            return true;
        }
        N9.j.F("Ignoring stale session state " + sessionState + " (handle already " + sessionState2 + ", session=" + str + ")", "GuiRuntime");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(d dVar, InterfaceC1723p interfaceC1723p) {
        if (((c) interfaceC1723p).r()) {
            return;
        }
        ((C1724q) interfaceC1723p).U(dVar);
    }

    public final void f(String sessionId, za.b bVar) {
        k.f(sessionId, "sessionId");
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new GuiRuntime$addActionPath$1(this, sessionId, bVar, null));
    }

    public final void g(String sessionId, String str, String str2) {
        k.f(sessionId, "sessionId");
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new GuiRuntime$addInquiryHistory$1(this, sessionId, str, str2, null));
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final java.lang.Object h(za.f r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.runtime.a.h(za.f, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void j(GuiTracerConfig guiTracerConfig) {
        if (!guiTracerConfig.getEnabled()) {
            GuiTracerManager guiTracerManager = this.e;
            if (guiTracerManager != null) {
                guiTracerManager.shutdown();
            }
            this.e = null;
            return;
        }
        GuiTracerManager guiTracerManager2 = this.e;
        if (guiTracerManager2 != null) {
            guiTracerManager2.updateConfig(guiTracerConfig);
            guiTracerManager2.initializeIfNeeded();
        } else {
            GuiTracerManager guiTracerManager3 = new GuiTracerManager(this.d, guiTracerConfig);
            guiTracerManager3.initializeIfNeeded();
            this.e = guiTracerManager3;
        }
    }

    public final void k(i iVar, G g) {
        if (iVar.a(g)) {
            return;
        }
        AbstractC1683A.n(this.c, null, new GuiRuntime$emitEvent$1(iVar, g, null), 3);
    }

    public final void l(String str, C0205d c0205d, String str2) {
        if (c0205d == null) {
            c0205d = (C0205d) this.h.get(str);
        }
        if (c0205d == null) {
            this.d.a(str);
            this.i.remove(str);
            return;
        }
        if (c0205d.f.compareAndSet(false, true)) {
            q0 q0Var = c0205d.h;
            if (q0Var != null) {
                q0Var.cancel(null);
            }
            c0205d.h = null;
            n(c0205d);
            e eVar = this.d.c;
            C0206e listener = c0205d.b;
            eVar.getClass();
            k.f(listener, "listener");
            eVar.f6861a.remove(listener);
            this.d.a(str);
            this.h.remove(str, c0205d);
            this.i.remove(str);
            N9.j.H("Task finalized: sessionId=" + str + ", reason=" + str2, "GuiRuntime");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.runtime.a.m(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void n(C0205d c0205d) {
        if (c0205d.g.compareAndSet(true, false)) {
            this.k.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof stepai.aios.guiagent.runtime.GuiRuntime$startTask$3
            if (r0 == 0) goto L13
            r0 = r13
            stepai.aios.guiagent.runtime.GuiRuntime$startTask$3 r0 = (stepai.aios.guiagent.runtime.GuiRuntime$startTask$3) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.runtime.GuiRuntime$startTask$3 r0 = new stepai.aios.guiagent.runtime.GuiRuntime$startTask$3
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            Ca.d r12 = r0.b
            java.lang.String r0 = r0.f6125a
            kotlin.b.b(r13)
            r8 = r12
            r7 = r0
            goto L74
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            kotlin.b.b(r13)
            java.util.concurrent.ConcurrentHashMap r13 = r11.h
            java.lang.Object r13 = r13.get(r12)
            Ca.d r13 = (Ca.C0205d) r13
            if (r13 == 0) goto L92
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.e
            r5 = 0
            boolean r2 = r2.compareAndSet(r5, r4)
            if (r2 != 0) goto L4f
            stepai.aios.guiagent.runtime.b r11 = r13.f347a
            return r11
        L4f:
            m9.q r2 = r13.c
            boolean r2 = r2.r()
            if (r2 == 0) goto L5a
            stepai.aios.guiagent.runtime.b r11 = r13.f347a
            return r11
        L5a:
            m9.q0 r2 = r13.h
            if (r2 == 0) goto L61
            r2.cancel(r3)
        L61:
            r13.h = r3
            w9.f r2 = r11.k
            r0.f6125a = r12
            r0.b = r13
            r0.e = r4
            java.lang.Object r0 = r2.a(r0)
            if (r0 != r1) goto L72
            return r1
        L72:
            r7 = r12
            r8 = r13
        L74:
            java.util.concurrent.atomic.AtomicBoolean r12 = r8.g
            r12.set(r4)
            s9.c r12 = r11.c
            stepai.aios.guiagent.runtime.GuiRuntime$startTask$result$1 r13 = new stepai.aios.guiagent.runtime.GuiRuntime$startTask$result$1
            r13.<init>(r11, r7, r3)
            r0 = 3
            m9.E r9 = m9.AbstractC1683A.d(r12, r3, r13, r0)
            Ca.c r5 = new Ca.c
            r10 = 0
            r6 = r11
            r5.<init>(r6, r7, r8, r9, r10)
            r9.w(r5)
            stepai.aios.guiagent.runtime.b r11 = r8.f347a
            return r11
        L92:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r13 = "Task not built: "
            java.lang.String r12 = B7.a.k(r13, r12)
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.runtime.a.o(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void p(RuntimeConfig config) {
        int i;
        k.f(config, "config");
        this.f6128a = config;
        int maxConcurrentTasks = config.getMaxConcurrentTasks();
        if (maxConcurrentTasks > 0 && (i = maxConcurrentTasks - this.f6129j) != 0) {
            this.f6129j = maxConcurrentTasks;
            f fVar = this.k;
            int i6 = 0;
            if (i > 0) {
                while (i6 < i) {
                    fVar.c();
                    i6++;
                }
            } else {
                int i10 = -i;
                while (i6 < i10 && fVar.d()) {
                    i6++;
                }
            }
        }
        j(config.getTracerConfig());
        stepai.aios.guiagent.pipeline.b bVar = this.g;
        bVar.getClass();
        bVar.b = config;
    }
}
