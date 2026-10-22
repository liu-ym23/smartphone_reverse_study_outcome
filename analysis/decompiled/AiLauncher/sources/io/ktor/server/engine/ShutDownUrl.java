package io.ktor.server.engine;

import Ua.InterfaceC1083u;
import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.BaseApplicationPlugin;
import io.ktor.server.application.CreatePluginUtilsKt;
import io.ktor.server.application.PluginBuilder;
import io.ktor.server.application.PluginInstance;
import io.ktor.server.engine.ShutDownUrl;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0003\u0015\u0016\u0014B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/ktor/server/engine/ShutDownUrl;", "", "", "url", "Lkotlin/Function1;", "Lio/ktor/server/application/ApplicationCall;", "", "exitCode", "<init>", "(Ljava/lang/String;Lp9/l;)V", "call", "LY8/t;", "doShutdown", "(Lio/ktor/server/application/ApplicationCall;Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "Lp9/l;", "getExitCode", "()Lp9/l;", "Companion", "EnginePlugin", "Config", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShutDownUrl {
    private final InterfaceC5074l<ApplicationCall, Integer> exitCode;
    private final String url;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BaseApplicationPlugin<Application, Config, PluginInstance> ApplicationCallPlugin = CreatePluginUtilsKt.createApplicationPlugin("shutdown.url", ShutDownUrl$Companion$ApplicationCallPlugin$1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.server.engine.C
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return ShutDownUrl.ApplicationCallPlugin$lambda$0((PluginBuilder) obj);
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/engine/ShutDownUrl$Companion;", "", "<init>", "()V", "Lio/ktor/server/application/BaseApplicationPlugin;", "Lio/ktor/server/application/Application;", "Lio/ktor/server/engine/ShutDownUrl$Config;", "Lio/ktor/server/application/PluginInstance;", "ApplicationCallPlugin", "Lio/ktor/server/application/BaseApplicationPlugin;", "getApplicationCallPlugin", "()Lio/ktor/server/application/BaseApplicationPlugin;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final BaseApplicationPlugin<Application, Config, PluginInstance> getApplicationCallPlugin() {
            return ShutDownUrl.ApplicationCallPlugin;
        }

        private Companion() {
        }
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/server/engine/ShutDownUrl$Config;", "", "<init>", "()V", "", "shutDownUrl", "Ljava/lang/String;", "getShutDownUrl", "()Ljava/lang/String;", "setShutDownUrl", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lio/ktor/server/application/ApplicationCall;", "", "exitCodeSupplier", "Lp9/l;", "getExitCodeSupplier", "()Lp9/l;", "setExitCodeSupplier", "(Lp9/l;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Config {
        private String shutDownUrl = "/ktor/application/shutdown";
        private InterfaceC5074l<? super ApplicationCall, Integer> exitCodeSupplier = new InterfaceC5074l() { // from class: io.ktor.server.engine.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(ShutDownUrl.Config.exitCodeSupplier$lambda$0((ApplicationCall) obj));
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final int exitCodeSupplier$lambda$0(ApplicationCall applicationCall) {
            kotlin.jvm.internal.p.i(applicationCall, "<this>");
            return 0;
        }

        public final InterfaceC5074l<ApplicationCall, Integer> getExitCodeSupplier() {
            return this.exitCodeSupplier;
        }

        public final String getShutDownUrl() {
            return this.shutDownUrl;
        }

        public final void setExitCodeSupplier(InterfaceC5074l<? super ApplicationCall, Integer> interfaceC5074l) {
            kotlin.jvm.internal.p.i(interfaceC5074l, "<set-?>");
            this.exitCodeSupplier = interfaceC5074l;
        }

        public final void setShutDownUrl(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.shutDownUrl = str;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/engine/ShutDownUrl$EnginePlugin;", "Lio/ktor/server/application/BaseApplicationPlugin;", "Lio/ktor/server/engine/EnginePipeline;", "Lio/ktor/server/engine/ShutDownUrl$Config;", "Lio/ktor/server/engine/ShutDownUrl;", "<init>", "()V", "pipeline", "Lkotlin/Function1;", "LY8/t;", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/server/engine/EnginePipeline;Lp9/l;)Lio/ktor/server/engine/ShutDownUrl;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EnginePlugin implements BaseApplicationPlugin<EnginePipeline, Config, ShutDownUrl> {
        public static final EnginePlugin INSTANCE = new EnginePlugin();
        private static final AttributeKey<ShutDownUrl> key;

        static {
            InterfaceC5755n interfaceC5755nM;
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(ShutDownUrl.class);
            try {
                interfaceC5755nM = kotlin.jvm.internal.t.m(ShutDownUrl.class);
            } catch (Throwable unused) {
                interfaceC5755nM = null;
            }
            key = new AttributeKey<>("shutdown.url", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        }

        private EnginePlugin() {
        }

        @Override // io.ktor.server.application.Plugin
        public AttributeKey<ShutDownUrl> getKey() {
            return key;
        }

        @Override // io.ktor.server.application.Plugin
        public /* bridge */ /* synthetic */ Object install(Pipeline pipeline, InterfaceC5074l interfaceC5074l) {
            return install((EnginePipeline) pipeline, (InterfaceC5074l<? super Config, Y8.t>) interfaceC5074l);
        }

        public ShutDownUrl install(EnginePipeline pipeline, InterfaceC5074l<? super Config, Y8.t> configure) {
            kotlin.jvm.internal.p.i(pipeline, "pipeline");
            kotlin.jvm.internal.p.i(configure, "configure");
            Config config = new Config();
            configure.invoke(config);
            ShutDownUrl shutDownUrl = new ShutDownUrl(config.getShutDownUrl(), config.getExitCodeSupplier());
            pipeline.intercept(EnginePipeline.INSTANCE.getBefore(), new ShutDownUrl$EnginePlugin$install$1(shutDownUrl, null));
            return shutDownUrl;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.ShutDownUrl", f = "ShutDownUrl.kt", l = {123}, m = "doShutdown")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.ShutDownUrl$doShutdown$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShutDownUrl.this.doShutdown(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.ShutDownUrl$doShutdown$2", f = "ShutDownUrl.kt", l = {43, 46}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.ShutDownUrl$doShutdown$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Application $application;
        final /* synthetic */ ApplicationEnvironment $environment;
        final /* synthetic */ int $exitCode;
        final /* synthetic */ InterfaceC1083u $latch;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC1083u interfaceC1083u, Application application, ApplicationEnvironment applicationEnvironment, int i10, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$latch = interfaceC1083u;
            this.$application = application;
            this.$environment = applicationEnvironment;
            this.$exitCode = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$latch, this.$application, this.$environment, this.$exitCode, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        
            if (r5.disposeAndJoin(r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 == r2) goto L16
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L16:
                kotlin.C4849c.b(r5)
                goto L46
            L1a:
                kotlin.C4849c.b(r5)
                goto L2c
            L1e:
                kotlin.C4849c.b(r5)
                Ua.u r5 = r4.$latch
                r4.label = r3
                java.lang.Object r5 = r5.T0(r4)
                if (r5 != r0) goto L2c
                goto L45
            L2c:
                io.ktor.server.application.Application r5 = r4.$application
                io.ktor.events.Events r5 = r5.getMonitor()
                io.ktor.events.EventDefinition r1 = io.ktor.server.application.DefaultApplicationEventsKt.getApplicationStopPreparing()
                io.ktor.server.application.ApplicationEnvironment r3 = r4.$environment
                r5.raise(r1, r3)
                io.ktor.server.application.Application r5 = r4.$application
                r4.label = r2
                java.lang.Object r5 = r5.disposeAndJoin(r4)
                if (r5 != r0) goto L46
            L45:
                return r0
            L46:
                int r4 = r4.$exitCode
                java.lang.System.exit(r4)
                java.lang.RuntimeException r4 = new java.lang.RuntimeException
                java.lang.String r5 = "System.exit returned normally, while it was supposed to halt JVM."
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.ShutDownUrl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShutDownUrl(String url, InterfaceC5074l<? super ApplicationCall, Integer> exitCode) {
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(exitCode, "exitCode");
        this.url = url;
        this.exitCode = exitCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t ApplicationCallPlugin$lambda$0(PluginBuilder createApplicationPlugin) {
        kotlin.jvm.internal.p.i(createApplicationPlugin, "$this$createApplicationPlugin");
        createApplicationPlugin.onCall(new ShutDownUrl$Companion$ApplicationCallPlugin$2$1(new ShutDownUrl(((Config) createApplicationPlugin.getPluginConfig()).getShutDownUrl(), ((Config) createApplicationPlugin.getPluginConfig()).getExitCodeSupplier()), null));
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doShutdown(io.ktor.server.application.ApplicationCall r21, e9.InterfaceC4014c<? super Y8.t> r22) throws java.lang.Throwable {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.Class<io.ktor.http.HttpStatusCode> r3 = io.ktor.http.HttpStatusCode.class
            boolean r4 = r2 instanceof io.ktor.server.engine.ShutDownUrl.AnonymousClass1
            if (r4 == 0) goto L1b
            r4 = r2
            io.ktor.server.engine.ShutDownUrl$doShutdown$1 r4 = (io.ktor.server.engine.ShutDownUrl.AnonymousClass1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.label = r5
            goto L20
        L1b:
            io.ktor.server.engine.ShutDownUrl$doShutdown$1 r4 = new io.ktor.server.engine.ShutDownUrl$doShutdown$1
            r4.<init>(r2)
        L20:
            java.lang.Object r2 = r4.result
            java.lang.Object r5 = f9.C4063a.g()
            int r6 = r4.label
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L41
            if (r6 != r7) goto L39
            java.lang.Object r0 = r4.L$0
            r1 = r0
            Ua.u r1 = (Ua.InterfaceC1083u) r1
            kotlin.C4849c.b(r2)     // Catch: java.lang.Throwable -> L37
            goto La1
        L37:
            r0 = move-exception
            goto La9
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.C4849c.b(r2)
            io.ktor.server.application.Application r2 = r1.getApplication()
            vc.c r2 = io.ktor.server.application.ApplicationKt.getLog(r2)
            java.lang.String r6 = "Shutdown URL was called: server is going down"
            r2.warn(r6)
            io.ktor.server.application.Application r11 = r1.getApplication()
            io.ktor.server.application.ApplicationEnvironment r12 = r11.getEnvironment()
            p9.l<io.ktor.server.application.ApplicationCall, java.lang.Integer> r0 = r0.exitCode
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            int r13 = r0.intValue()
            Ua.u r10 = Ua.C1087w.c(r8, r7, r8)
            io.ktor.server.application.Application r0 = r1.getApplication()
            io.ktor.server.engine.ShutDownUrl$doShutdown$2 r17 = new io.ktor.server.engine.ShutDownUrl$doShutdown$2
            r14 = 0
            r9 = r17
            r9.<init>(r10, r11, r12, r13, r14)
            r18 = 3
            r19 = 0
            r15 = 0
            r16 = 0
            r14 = r0
            Ua.C1056g.d(r14, r15, r16, r17, r18, r19)
            io.ktor.http.HttpStatusCode$Companion r0 = io.ktor.http.HttpStatusCode.INSTANCE     // Catch: java.lang.Throwable -> La7
            io.ktor.http.HttpStatusCode r0 = r0.getGone()     // Catch: java.lang.Throwable -> La7
            w9.d r2 = kotlin.jvm.internal.t.b(r3)     // Catch: java.lang.Throwable -> La7
            w9.n r3 = kotlin.jvm.internal.t.m(r3)     // Catch: java.lang.Throwable -> L8f
            goto L90
        L8f:
            r3 = r8
        L90:
            io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo     // Catch: java.lang.Throwable -> La7
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> La7
            r4.L$0 = r10     // Catch: java.lang.Throwable -> La7
            r4.label = r7     // Catch: java.lang.Throwable -> La7
            java.lang.Object r0 = r1.respond(r0, r6, r4)     // Catch: java.lang.Throwable -> La7
            if (r0 != r5) goto La0
            return r5
        La0:
            r1 = r10
        La1:
            kotlinx.coroutines.g.a.a(r1, r8, r7, r8)
            Y8.t r0 = Y8.t.f7040a
            return r0
        La7:
            r0 = move-exception
            r1 = r10
        La9:
            kotlinx.coroutines.g.a.a(r1, r8, r7, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.ShutDownUrl.doShutdown(io.ktor.server.application.ApplicationCall, e9.c):java.lang.Object");
    }

    public final InterfaceC5074l<ApplicationCall, Integer> getExitCode() {
        return this.exitCode;
    }

    public final String getUrl() {
        return this.url;
    }
}
