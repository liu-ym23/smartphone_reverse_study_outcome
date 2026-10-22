package io.ktor.server.engine;

import Ua.C1073o0;
import Ua.M;
import Z8.C1172u;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.ApplicationKt;
import io.ktor.server.application.ServerConfig;
import io.ktor.server.application.ServerConfigBuilder;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Arrays;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a{\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0089\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0004\b\u0011\u0010\u0016\u001a\u0089\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u00172\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u001a\u001a\u0097\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u00172\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0004\b\u0011\u0010\u001b\u001a\u008b\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u00172\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\b\u0002\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001d2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u001f\u001a\u0099\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u00172\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\b\u0002\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001d2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0004\b\u0011\u0010 \u001ay\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020!2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0004\b\u0011\u0010$\u001a\u0087\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020!2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\f2$\b\u0002\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0004\b\u0011\u0010%\u001a_\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010'\u001a\u00020&2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0011\u0010(¨\u0006)"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine;", "TEngine", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "TConfiguration", "Lio/ktor/server/engine/ApplicationEngineFactory;", "factory", "", "port", "", "host", "", "watchPaths", "Lkotlin/Function1;", "Lio/ktor/server/application/Application;", "LY8/t;", "module", "Lio/ktor/server/engine/EmbeddedServer;", "embeddedServer", "(Lio/ktor/server/engine/ApplicationEngineFactory;ILjava/lang/String;Ljava/util/List;Lp9/l;)Lio/ktor/server/engine/EmbeddedServer;", "Lkotlin/Function2;", "Le9/c;", "", "(Lio/ktor/server/engine/ApplicationEngineFactory;ILjava/lang/String;Ljava/util/List;Lp9/p;)Lio/ktor/server/engine/EmbeddedServer;", "LUa/M;", "Lkotlin/coroutines/d;", "parentCoroutineContext", "(LUa/M;Lio/ktor/server/engine/ApplicationEngineFactory;ILjava/lang/String;Ljava/util/List;Lkotlin/coroutines/d;Lp9/l;)Lio/ktor/server/engine/EmbeddedServer;", "(LUa/M;Lio/ktor/server/engine/ApplicationEngineFactory;ILjava/lang/String;Ljava/util/List;Lkotlin/coroutines/d;Lp9/p;)Lio/ktor/server/engine/EmbeddedServer;", "", "Lio/ktor/server/engine/EngineConnectorConfig;", "connectors", "(LUa/M;Lio/ktor/server/engine/ApplicationEngineFactory;[Lio/ktor/server/engine/EngineConnectorConfig;Ljava/util/List;Lkotlin/coroutines/d;Lp9/l;)Lio/ktor/server/engine/EmbeddedServer;", "(LUa/M;Lio/ktor/server/engine/ApplicationEngineFactory;[Lio/ktor/server/engine/EngineConnectorConfig;Ljava/util/List;Lkotlin/coroutines/d;Lp9/p;)Lio/ktor/server/engine/EmbeddedServer;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "configure", "(Lio/ktor/server/engine/ApplicationEngineFactory;Lio/ktor/server/application/ApplicationEnvironment;Lp9/l;Lp9/l;)Lio/ktor/server/engine/EmbeddedServer;", "(Lio/ktor/server/engine/ApplicationEngineFactory;Lio/ktor/server/application/ApplicationEnvironment;Lp9/l;Lp9/p;)Lio/ktor/server/engine/EmbeddedServer;", "Lio/ktor/server/application/ServerConfig;", "rootConfig", "(Lio/ktor/server/engine/ApplicationEngineFactory;Lio/ktor/server/application/ServerConfig;Lp9/l;)Lio/ktor/server/engine/EmbeddedServer;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmbeddedServerKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.EmbeddedServerKt$embeddedServer$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> {
        public AnonymousClass1(Object obj) {
            super(2, obj, p.a.class, "suspendConversion0", "embeddedServer$suspendConversion0(Lkotlin/jvm/functions/Function1;Lio/ktor/server/application/Application;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p9.p
        public final Object invoke(Application application, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return EmbeddedServerKt.embeddedServer$suspendConversion0((InterfaceC5074l) this.receiver, application, interfaceC4014c);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.EmbeddedServerKt$embeddedServer$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> {
        public AnonymousClass2(Object obj) {
            super(2, obj, p.a.class, "suspendConversion0", "embeddedServer$suspendConversion0$1(Lkotlin/jvm/functions/Function1;Lio/ktor/server/application/Application;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p9.p
        public final Object invoke(Application application, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return EmbeddedServerKt.embeddedServer$suspendConversion0$1((InterfaceC5074l) this.receiver, application, interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/application/Application;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/Application;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServerKt$embeddedServer$6", f = "EmbeddedServer.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServerKt$embeddedServer$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass6(InterfaceC4014c<? super AnonymousClass6> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass6(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Application application, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass6) create(application, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    public static final /* synthetic */ EmbeddedServer embeddedServer(ApplicationEngineFactory factory, int i10, String host, List watchPaths, InterfaceC5074l module) {
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(module, "module");
        return embeddedServer$default(C1073o0.f6391a, factory, i10, host, watchPaths, (kotlin.coroutines.d) null, new AnonymousClass1(module), 16, (Object) null);
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(ApplicationEngineFactory applicationEngineFactory, int i10, String str, List list, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 80;
        }
        if ((i11 & 4) != 0) {
            str = "0.0.0.0";
        }
        if ((i11 & 8) != 0) {
            list = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        }
        return embeddedServer(applicationEngineFactory, i10, str, list, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$10(ApplicationEngine.Configuration configuration) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$11(Application application) {
        kotlin.jvm.internal.p.i(application, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$13(InterfaceC5074l interfaceC5074l, ServerConfigBuilder serverConfig) {
        kotlin.jvm.internal.p.i(serverConfig, "$this$serverConfig");
        serverConfig.module(new EmbeddedServerKt$embeddedServer$applicationProperties$3$1(interfaceC5074l));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object embeddedServer$lambda$13$suspendConversion0$12(InterfaceC5074l interfaceC5074l, Application application, InterfaceC4014c interfaceC4014c) {
        interfaceC5074l.invoke(application);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$14(ApplicationEngine.Configuration configuration) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$15(p9.p pVar, ServerConfigBuilder serverConfig) {
        kotlin.jvm.internal.p.i(serverConfig, "$this$serverConfig");
        serverConfig.module((p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$16(ApplicationEngine.Configuration configuration) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$3(ApplicationEnvironmentBuilder applicationEnvironment) {
        kotlin.jvm.internal.p.i(applicationEnvironment, "$this$applicationEnvironment");
        applicationEnvironment.setLog(KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.Application"));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$5(M m10, kotlin.coroutines.d dVar, List list, InterfaceC5074l interfaceC5074l, ServerConfigBuilder serverConfig) {
        kotlin.jvm.internal.p.i(serverConfig, "$this$serverConfig");
        serverConfig.setParentCoroutineContext(m10.getCoroutineContext().plus(dVar));
        serverConfig.setWatchPaths(list);
        serverConfig.module(new EmbeddedServerKt$embeddedServer$applicationProperties$1$1(interfaceC5074l));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object embeddedServer$lambda$5$suspendConversion0$4(InterfaceC5074l interfaceC5074l, Application application, InterfaceC4014c interfaceC4014c) {
        interfaceC5074l.invoke(application);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$6(EngineConnectorConfig[] engineConnectorConfigArr, ApplicationEngine.Configuration configuration) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        Z8.A.F(configuration.getConnectors(), engineConnectorConfigArr);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$7(ApplicationEnvironmentBuilder applicationEnvironment) {
        kotlin.jvm.internal.p.i(applicationEnvironment, "$this$applicationEnvironment");
        applicationEnvironment.setLog(KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.Application"));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$8(M m10, kotlin.coroutines.d dVar, List list, p9.p pVar, ServerConfigBuilder serverConfig) {
        kotlin.jvm.internal.p.i(serverConfig, "$this$serverConfig");
        serverConfig.setParentCoroutineContext(m10.getCoroutineContext().plus(dVar));
        serverConfig.setWatchPaths(list);
        serverConfig.module((p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t embeddedServer$lambda$9(EngineConnectorConfig[] engineConnectorConfigArr, ApplicationEngine.Configuration configuration) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        Z8.A.F(configuration.getConnectors(), engineConnectorConfigArr);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object embeddedServer$suspendConversion0(InterfaceC5074l interfaceC5074l, Application application, InterfaceC4014c interfaceC4014c) {
        interfaceC5074l.invoke(application);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object embeddedServer$suspendConversion0$1(InterfaceC5074l interfaceC5074l, Application application, InterfaceC4014c interfaceC4014c) {
        interfaceC5074l.invoke(application);
        return Y8.t.f7040a;
    }

    public static final <TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> EmbeddedServer<TEngine, TConfiguration> embeddedServer(ApplicationEngineFactory<? extends TEngine, TConfiguration> factory, int i10, String host, List<String> watchPaths, p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> module) {
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(module, "module");
        return embeddedServer$default(C1073o0.f6391a, factory, i10, host, watchPaths, (kotlin.coroutines.d) null, module, 16, (Object) null);
    }

    public static final /* synthetic */ EmbeddedServer embeddedServer(M m10, ApplicationEngineFactory factory, int i10, String host, List watchPaths, kotlin.coroutines.d parentCoroutineContext, InterfaceC5074l module) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(parentCoroutineContext, "parentCoroutineContext");
        kotlin.jvm.internal.p.i(module, "module");
        EngineConnectorBuilder engineConnectorBuilder = new EngineConnectorBuilder(null, 1, null);
        engineConnectorBuilder.setPort(i10);
        engineConnectorBuilder.setHost(host);
        Y8.t tVar = Y8.t.f7040a;
        return embeddedServer(m10, factory, (EngineConnectorConfig[]) Arrays.copyOf(new EngineConnectorConfig[]{engineConnectorBuilder}, 1), (List<String>) watchPaths, parentCoroutineContext, new AnonymousClass2(module));
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(ApplicationEngineFactory applicationEngineFactory, int i10, String str, List list, p9.p pVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 80;
        }
        if ((i11 & 4) != 0) {
            str = "0.0.0.0";
        }
        if ((i11 & 8) != 0) {
            list = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        }
        return embeddedServer(applicationEngineFactory, i10, str, (List<String>) list, (p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar);
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(M m10, ApplicationEngineFactory applicationEngineFactory, int i10, String str, List list, kotlin.coroutines.d dVar, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 80;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = "0.0.0.0";
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            list = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        }
        List list2 = list;
        if ((i11 & 16) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return embeddedServer(m10, applicationEngineFactory, i12, str2, list2, dVar, interfaceC5074l);
    }

    public static final <TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> EmbeddedServer<TEngine, TConfiguration> embeddedServer(M m10, ApplicationEngineFactory<? extends TEngine, TConfiguration> factory, int i10, String host, List<String> watchPaths, kotlin.coroutines.d parentCoroutineContext, p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> module) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(parentCoroutineContext, "parentCoroutineContext");
        kotlin.jvm.internal.p.i(module, "module");
        EngineConnectorBuilder engineConnectorBuilder = new EngineConnectorBuilder(null, 1, null);
        engineConnectorBuilder.setPort(i10);
        engineConnectorBuilder.setHost(host);
        Y8.t tVar = Y8.t.f7040a;
        return embeddedServer(m10, factory, (EngineConnectorConfig[]) Arrays.copyOf(new EngineConnectorConfig[]{engineConnectorBuilder}, 1), watchPaths, parentCoroutineContext, module);
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(M m10, ApplicationEngineFactory applicationEngineFactory, int i10, String str, List list, kotlin.coroutines.d dVar, p9.p pVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 80;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = "0.0.0.0";
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            list = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        }
        List list2 = list;
        if ((i11 & 16) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return embeddedServer(m10, applicationEngineFactory, i12, str2, (List<String>) list2, dVar, (p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar);
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(M m10, ApplicationEngineFactory applicationEngineFactory, EngineConnectorConfig[] engineConnectorConfigArr, List list, kotlin.coroutines.d dVar, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            engineConnectorConfigArr = new EngineConnectorConfig[0];
        }
        EngineConnectorConfig[] engineConnectorConfigArr2 = engineConnectorConfigArr;
        if ((i10 & 4) != 0) {
            list = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return embeddedServer(m10, applicationEngineFactory, engineConnectorConfigArr2, list2, dVar, interfaceC5074l);
    }

    public static final /* synthetic */ EmbeddedServer embeddedServer(final M m10, ApplicationEngineFactory factory, final EngineConnectorConfig[] connectors, final List watchPaths, final kotlin.coroutines.d parentCoroutineContext, final InterfaceC5074l module) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(connectors, "connectors");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(parentCoroutineContext, "parentCoroutineContext");
        kotlin.jvm.internal.p.i(module, "module");
        return embeddedServer(factory, ApplicationKt.serverConfig(ApplicationEnvironmentBuilderKt.applicationEnvironment(new InterfaceC5074l() { // from class: io.ktor.server.engine.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$3((ApplicationEnvironmentBuilder) obj);
            }
        }), new InterfaceC5074l() { // from class: io.ktor.server.engine.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$5(m10, parentCoroutineContext, watchPaths, module, (ServerConfigBuilder) obj);
            }
        }), new InterfaceC5074l() { // from class: io.ktor.server.engine.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$6(connectors, (ApplicationEngine.Configuration) obj);
            }
        });
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(M m10, ApplicationEngineFactory applicationEngineFactory, EngineConnectorConfig[] engineConnectorConfigArr, List list, kotlin.coroutines.d dVar, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            engineConnectorConfigArr = new EngineConnectorConfig[0];
        }
        EngineConnectorConfig[] engineConnectorConfigArr2 = engineConnectorConfigArr;
        if ((i10 & 4) != 0) {
            list = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return embeddedServer(m10, applicationEngineFactory, engineConnectorConfigArr2, (List<String>) list2, dVar, (p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar);
    }

    public static final <TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> EmbeddedServer<TEngine, TConfiguration> embeddedServer(final M m10, ApplicationEngineFactory<? extends TEngine, TConfiguration> factory, final EngineConnectorConfig[] connectors, final List<String> watchPaths, final kotlin.coroutines.d parentCoroutineContext, final p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> module) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(connectors, "connectors");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(parentCoroutineContext, "parentCoroutineContext");
        kotlin.jvm.internal.p.i(module, "module");
        return embeddedServer(factory, ApplicationKt.serverConfig(ApplicationEnvironmentBuilderKt.applicationEnvironment(new InterfaceC5074l() { // from class: io.ktor.server.engine.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$7((ApplicationEnvironmentBuilder) obj);
            }
        }), new InterfaceC5074l() { // from class: io.ktor.server.engine.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$8(m10, parentCoroutineContext, watchPaths, module, (ServerConfigBuilder) obj);
            }
        }), new InterfaceC5074l() { // from class: io.ktor.server.engine.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$9(connectors, (ApplicationEngine.Configuration) obj);
            }
        });
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(ApplicationEngineFactory applicationEngineFactory, ApplicationEnvironment applicationEnvironment, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            applicationEnvironment = ApplicationEnvironmentBuilderKt.applicationEnvironment$default(null, 1, null);
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.engine.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return EmbeddedServerKt.embeddedServer$lambda$10((ApplicationEngine.Configuration) obj2);
                }
            };
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l2 = new InterfaceC5074l() { // from class: io.ktor.server.engine.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return EmbeddedServerKt.embeddedServer$lambda$11((Application) obj2);
                }
            };
        }
        return embeddedServer(applicationEngineFactory, applicationEnvironment, interfaceC5074l, interfaceC5074l2);
    }

    public static final /* synthetic */ EmbeddedServer embeddedServer(ApplicationEngineFactory factory, ApplicationEnvironment environment, InterfaceC5074l configure, final InterfaceC5074l module) {
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(environment, "environment");
        kotlin.jvm.internal.p.i(configure, "configure");
        kotlin.jvm.internal.p.i(module, "module");
        return embeddedServer(factory, ApplicationKt.serverConfig(environment, new InterfaceC5074l() { // from class: io.ktor.server.engine.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$13(module, (ServerConfigBuilder) obj);
            }
        }), configure);
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(ApplicationEngineFactory applicationEngineFactory, ApplicationEnvironment applicationEnvironment, InterfaceC5074l interfaceC5074l, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            applicationEnvironment = ApplicationEnvironmentBuilderKt.applicationEnvironment$default(null, 1, null);
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.engine.v
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return EmbeddedServerKt.embeddedServer$lambda$14((ApplicationEngine.Configuration) obj2);
                }
            };
        }
        if ((i10 & 8) != 0) {
            pVar = new AnonymousClass6(null);
        }
        return embeddedServer(applicationEngineFactory, applicationEnvironment, interfaceC5074l, (p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar);
    }

    public static final <TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> EmbeddedServer<TEngine, TConfiguration> embeddedServer(ApplicationEngineFactory<? extends TEngine, TConfiguration> factory, ApplicationEnvironment environment, InterfaceC5074l<? super TConfiguration, Y8.t> configure, final p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> module) {
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(environment, "environment");
        kotlin.jvm.internal.p.i(configure, "configure");
        kotlin.jvm.internal.p.i(module, "module");
        return embeddedServer(factory, ApplicationKt.serverConfig(environment, new InterfaceC5074l() { // from class: io.ktor.server.engine.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServerKt.embeddedServer$lambda$15(module, (ServerConfigBuilder) obj);
            }
        }), configure);
    }

    public static final <TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> EmbeddedServer<TEngine, TConfiguration> embeddedServer(ApplicationEngineFactory<? extends TEngine, TConfiguration> factory, ServerConfig rootConfig, InterfaceC5074l<? super TConfiguration, Y8.t> configure) {
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(rootConfig, "rootConfig");
        kotlin.jvm.internal.p.i(configure, "configure");
        return new EmbeddedServer<>(rootConfig, factory, configure);
    }

    public static /* synthetic */ EmbeddedServer embeddedServer$default(ApplicationEngineFactory applicationEngineFactory, ServerConfig serverConfig, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.engine.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return EmbeddedServerKt.embeddedServer$lambda$16((ApplicationEngine.Configuration) obj2);
                }
            };
        }
        return embeddedServer(applicationEngineFactory, serverConfig, interfaceC5074l);
    }
}
