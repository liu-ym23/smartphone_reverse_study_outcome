package io.ktor.server.application;

import Ua.InterfaceC1089x;
import Ua.L0;
import Ua.M;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.events.Events;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@KtorDsl
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B?\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0087@¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u0011\u0010*\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lio/ktor/server/application/Application;", "Lio/ktor/server/application/ApplicationCallPipeline;", "LUa/M;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "", "developmentMode", "", "rootPath", "Lio/ktor/events/Events;", "monitor", "Lkotlin/coroutines/d;", "parentCoroutineContext", "Lkotlin/Function0;", "Lio/ktor/server/engine/ApplicationEngine;", "engineProvider", "<init>", "(Lio/ktor/server/application/ApplicationEnvironment;ZLjava/lang/String;Lio/ktor/events/Events;Lkotlin/coroutines/d;Lp9/a;)V", "LY8/t;", "dispose", "()V", "disposeAndJoin", "(Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getRootPath", "()Ljava/lang/String;", "setRootPath", "(Ljava/lang/String;)V", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "Lkotlin/coroutines/d;", "getParentCoroutineContext", "()Lkotlin/coroutines/d;", "Lp9/a;", "LUa/x;", "applicationJob", "LUa/x;", "coroutineContext", "getCoroutineContext", "getEngine", "()Lio/ktor/server/engine/ApplicationEngine;", C3081a.KEY_ENGINE, "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Application extends ApplicationCallPipeline implements M {
    private final InterfaceC1089x applicationJob;
    private final kotlin.coroutines.d coroutineContext;
    private final InterfaceC5063a<ApplicationEngine> engineProvider;
    private final Events monitor;
    private final kotlin.coroutines.d parentCoroutineContext;
    private String rootPath;

    @InterfaceC4112d(c = "io.ktor.server.application.Application", f = "Application.kt", l = {158}, m = "disposeAndJoin")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.Application$disposeAndJoin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Application.this.disposeAndJoin(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Application(ApplicationEnvironment environment, boolean z10, String rootPath, Events monitor, kotlin.coroutines.d parentCoroutineContext, InterfaceC5063a<? extends ApplicationEngine> engineProvider) {
        super(z10, environment);
        p.i(environment, "environment");
        p.i(rootPath, "rootPath");
        p.i(monitor, "monitor");
        p.i(parentCoroutineContext, "parentCoroutineContext");
        p.i(engineProvider, "engineProvider");
        this.rootPath = rootPath;
        this.monitor = monitor;
        this.parentCoroutineContext = parentCoroutineContext;
        this.engineProvider = engineProvider;
        InterfaceC1089x interfaceC1089xA = L0.a((kotlinx.coroutines.g) parentCoroutineContext.get(kotlinx.coroutines.g.INSTANCE));
        this.applicationJob = interfaceC1089xA;
        this.coroutineContext = parentCoroutineContext.plus(interfaceC1089xA);
    }

    public final void dispose() {
        kotlinx.coroutines.g.Y0(this.applicationJob, null, 1, null);
        ApplicationPluginKt.uninstallAllPlugins(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object disposeAndJoin(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.server.application.Application.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.server.application.Application$disposeAndJoin$1 r0 = (io.ktor.server.application.Application.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.application.Application$disposeAndJoin$1 r0 = new io.ktor.server.application.Application$disposeAndJoin$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            Ua.x r5 = r4.applicationJob
            r0.label = r3
            java.lang.Object r5 = Ua.C1086v0.g(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            io.ktor.server.application.ApplicationPluginKt.uninstallAllPlugins(r4)
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.Application.disposeAndJoin(e9.c):java.lang.Object");
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    public final ApplicationEngine getEngine() {
        return this.engineProvider.invoke();
    }

    public final Events getMonitor() {
        return this.monitor;
    }

    public final kotlin.coroutines.d getParentCoroutineContext() {
        return this.parentCoroutineContext;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final void setRootPath(String str) {
        p.i(str, "<set-?>");
        this.rootPath = str;
    }
}
