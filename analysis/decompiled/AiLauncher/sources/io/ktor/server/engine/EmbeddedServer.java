package io.ktor.server.engine;

import Ua.C1056g;
import Ua.C1058h;
import Ua.C1060i;
import Ua.M;
import Ua.Y;
import Z8.C1173v;
import Z8.C1174w;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.events.EventDefinition;
import io.ktor.events.Events;
import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.ApplicationModuleLoader;
import io.ktor.server.application.ApplicationModulesKt;
import io.ktor.server.application.ApplicationModules_jvmKt;
import io.ktor.server.application.DefaultApplicationEventsKt;
import io.ktor.server.application.DynamicApplicationModule;
import io.ktor.server.application.ModuleParametersInjector;
import io.ktor.server.application.ServerConfig;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.ApplicationEngine.Configuration;
import io.ktor.server.engine.internal.ApplicationUtilsJvmKt;
import io.ktor.server.engine.internal.AutoReloadUtilsKt;
import io.ktor.server.engine.internal.CallableUtilsKt;
import io.ktor.server.engine.internal.EngineUtilsJvmKt;
import io.ktor.util.Attributes;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.TimeoutKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B9\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001f\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0012H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0017H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b0\u00101J5\u00105\u001a\u0004\u0018\u00010/*\"\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u00010\u000502j\u0002`4H\u0002¢\u0006\u0004\b5\u00106J3\u00107\u001a\u00020/*\"\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u00010\u000502j\u0002`4H\u0002¢\u0006\u0004\b7\u00106J(\u00109\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b9\u0010:J-\u0010<\u001a\u00020\u000b2\u001c\u0010;\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nH\u0002¢\u0006\u0004\b<\u0010=J6\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020-2\u001c\u0010;\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nH\u0082@¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000bH\u0002¢\u0006\u0004\bA\u0010\"J\r\u0010B\u001a\u00020\u000b¢\u0006\u0004\bB\u0010\"J#\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ&\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010D\u001a\u00020CH\u0086@¢\u0006\u0004\bG\u0010HJ%\u0010N\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020I2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ!\u0010N\u001a\u00020\u000b2\b\b\u0002\u0010P\u001a\u00020I2\b\b\u0002\u0010Q\u001a\u00020I¢\u0006\u0004\bN\u0010RJ$\u0010S\u001a\u00020\u000b2\b\b\u0002\u0010P\u001a\u00020I2\b\b\u0002\u0010Q\u001a\u00020IH\u0086@¢\u0006\u0004\bS\u0010TR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010UR\u001d\u0010W\u001a\u00020V8\u0006¢\u0006\u0012\n\u0004\bW\u0010X\u0012\u0004\b[\u0010\"\u001a\u0004\bY\u0010ZR\u0017\u0010]\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010a\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020l0\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020-0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010nR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020-0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010nR!\u0010w\u001a\u00020q8BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\br\u0010s\u0012\u0004\bv\u0010\"\u001a\u0004\bt\u0010uR!\u0010z\u001a\b\u0012\u0004\u0012\u00020/0\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010s\u001a\u0004\by\u0010\u0015R\u0018\u0010{\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010}\u001a\u00028\u00008\u0006¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\"\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0081\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010s\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0012\u0010\u001e\u001a\u00020\u000f8F¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u0011¨\u0006\u0087\u0001"}, d2 = {"Lio/ktor/server/engine/EmbeddedServer;", "Lio/ktor/server/engine/ApplicationEngine;", "TEngine", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "TConfiguration", "", "Lio/ktor/server/application/ServerConfig;", "rootConfig", "Lio/ktor/server/engine/ApplicationEngineFactory;", "engineFactory", "Lkotlin/Function1;", "LY8/t;", "engineConfigBlock", "<init>", "(Lio/ktor/server/application/ServerConfig;Lio/ktor/server/engine/ApplicationEngineFactory;Lp9/l;)V", "Lio/ktor/server/application/Application;", "currentApplication", "()Lio/ktor/server/application/Application;", "", "Ljava/nio/file/WatchEvent;", "getFileChanges", "()Ljava/util/List;", "Lkotlin/Pair;", "Ljava/lang/ClassLoader;", "createApplication", "()Lkotlin/Pair;", "createClassLoader", "()Ljava/lang/ClassLoader;", "Lio/ktor/events/EventDefinition;", "event", ContentType.Application.TYPE, "safeRaiseEvent", "(Lio/ktor/events/EventDefinition;Lio/ktor/server/application/Application;)V", "destroyApplication", "()V", "classLoader", "destroyBlocking", "(Lio/ktor/server/application/Application;Ljava/lang/ClassLoader;)V", "Ljava/net/URL;", "urls", "watchUrls", "(Ljava/util/List;)V", "currentClassLoader", "instantiateAndConfigureApplication", "(Ljava/lang/ClassLoader;)Lio/ktor/server/application/Application;", "", "name", "Lio/ktor/server/application/DynamicApplicationModule;", "dynamicModule", "(Ljava/lang/String;)Lio/ktor/server/application/DynamicApplicationModule;", "Lkotlin/Function2;", "Le9/c;", "Lio/ktor/server/engine/ApplicationModule;", "toDynamicModuleOrNull", "(Lp9/p;)Lio/ktor/server/application/DynamicApplicationModule;", "wrapWithDynamicModule", "newInstance", "launchModuleByName", "(Ljava/lang/String;Ljava/lang/ClassLoader;Lio/ktor/server/application/Application;Le9/c;)Ljava/lang/Object;", "block", "avoidingDoubleStartup", "(Lp9/l;)V", "fqName", "avoidingDoubleStartupFor", "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "cleanupWatcher", ChatTracker.RETRY_RELOAD, "", "wait", "start", "(Z)Lio/ktor/server/engine/EmbeddedServer;", "startSuspend", "(ZLe9/c;)Ljava/lang/Object;", "", "shutdownGracePeriod", "shutdownTimeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, "(JJLjava/util/concurrent/TimeUnit;)V", "gracePeriodMillis", "timeoutMillis", "(JJ)V", "stopSuspend", "(JJLe9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ServerConfig;", "Lio/ktor/events/Events;", "monitor", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "getMonitor$annotations", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "engineConfig", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "getEngineConfig", "()Lio/ktor/server/engine/ApplicationEngine$Configuration;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "applicationInstanceLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "recreateInstance", "Z", "applicationClassLoader", "Ljava/lang/ClassLoader;", "Ljava/nio/file/WatchKey;", "packageWatchKeys", "Ljava/util/List;", "configuredWatchPath", "watchPatterns", "Lio/ktor/server/application/ModuleParametersInjector;", "moduleInjector$delegate", "LY8/h;", "getModuleInjector", "()Lio/ktor/server/application/ModuleParametersInjector;", "getModuleInjector$annotations", "moduleInjector", "modules$delegate", "getModules", "modules", "applicationInstance", "Lio/ktor/server/application/Application;", C3081a.KEY_ENGINE, "Lio/ktor/server/engine/ApplicationEngine;", "getEngine", "()Lio/ktor/server/engine/ApplicationEngine;", "Ljava/nio/file/WatchService;", "watcher$delegate", "getWatcher", "()Ljava/nio/file/WatchService;", "watcher", "getApplication", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmbeddedServer<TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> {
    private ClassLoader applicationClassLoader;
    private Application applicationInstance;
    private final ReentrantReadWriteLock applicationInstanceLock;
    private final List<String> configuredWatchPath;
    private final TEngine engine;
    private final TConfiguration engineConfig;
    private final ApplicationEnvironment environment;

    /* renamed from: moduleInjector$delegate, reason: from kotlin metadata */
    private final Y8.h moduleInjector;

    /* renamed from: modules$delegate, reason: from kotlin metadata */
    private final Y8.h modules;
    private final Events monitor;
    private List<? extends WatchKey> packageWatchKeys;
    private boolean recreateInstance;
    private final ServerConfig rootConfig;
    private final List<String> watchPatterns;

    /* renamed from: watcher$delegate, reason: from kotlin metadata */
    private final Y8.h watcher;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$avoidingDoubleStartup$1", f = "EmbeddedServerJvm.kt", l = {MinusOneTransitionSpec.OVERLAY_CLOSE_DURATION_MS}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$avoidingDoubleStartup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$block = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$block, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> interfaceC5074l = this.$block;
                this.label = 1;
                if (interfaceC5074l.invoke(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer", f = "EmbeddedServerJvm.kt", l = {469}, m = "avoidingDoubleStartupFor")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.EmbeddedServer$avoidingDoubleStartupFor$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43471(EmbeddedServer<TEngine, TConfiguration> embeddedServer, InterfaceC4014c<? super C43471> interfaceC4014c) {
            super(interfaceC4014c);
            this.this$0 = embeddedServer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.avoidingDoubleStartupFor(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$destroyBlocking$1", f = "EmbeddedServerJvm.kt", l = {256}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$destroyBlocking$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43481 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Application $application;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$destroyBlocking$1$1", f = "EmbeddedServerJvm.kt", l = {CustomCameraView.BUTTON_STATE_ONLY_CAPTURE}, m = "invokeSuspend")
        /* renamed from: io.ktor.server.engine.EmbeddedServer$destroyBlocking$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04131 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ Application $application;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04131(Application application, InterfaceC4014c<? super C04131> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$application = application;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C04131(this.$application, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((C04131) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Application application = this.$application;
                    this.label = 1;
                    if (application.disposeAndJoin(this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43481(EmbeddedServer<TEngine, TConfiguration> embeddedServer, Application application, InterfaceC4014c<? super C43481> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = embeddedServer;
            this.$application = application;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C43481(this.this$0, this.$application, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43481) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                long shutdownTimeout = this.this$0.getEngineConfig().getShutdownTimeout();
                C04131 c04131 = new C04131(this.$application, null);
                this.label = 1;
                if (TimeoutKt.c(shutdownTimeout, c04131, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/server/application/Application;", "Ljava/lang/ClassLoader;", "classLoader", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/Application;Ljava/lang/ClassLoader;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$dynamicModule$1", f = "EmbeddedServerJvm.kt", l = {402}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$dynamicModule$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43491 extends SuspendLambda implements p9.q<Application, ClassLoader, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $name;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43491(EmbeddedServer<TEngine, TConfiguration> embeddedServer, String str, InterfaceC4014c<? super C43491> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.this$0 = embeddedServer;
            this.$name = str;
        }

        @Override // p9.q
        public final Object invoke(Application application, ClassLoader classLoader, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            C43491 c43491 = new C43491(this.this$0, this.$name, interfaceC4014c);
            c43491.L$0 = application;
            c43491.L$1 = classLoader;
            return c43491.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Application application = (Application) this.L$0;
                ClassLoader classLoader = (ClassLoader) this.L$1;
                EmbeddedServer<TEngine, TConfiguration> embeddedServer = this.this$0;
                String str = this.$name;
                this.L$0 = null;
                this.label = 1;
                if (embeddedServer.launchModuleByName(str, classLoader, application, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$instantiateAndConfigureApplication$1", f = "EmbeddedServerJvm.kt", l = {com.stepos.agentframework.chatui.longtext.b.BLOCK_CHARS}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$instantiateAndConfigureApplication$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43501 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ ClassLoader $currentClassLoader;
        final /* synthetic */ Application $newInstance;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$instantiateAndConfigureApplication$1$1", f = "EmbeddedServerJvm.kt", l = {385}, m = "invokeSuspend")
        /* renamed from: io.ktor.server.engine.EmbeddedServer$instantiateAndConfigureApplication$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04141 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ ClassLoader $currentClassLoader;
            final /* synthetic */ Application $newInstance;
            int label;
            final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04141(EmbeddedServer<TEngine, TConfiguration> embeddedServer, Application application, ClassLoader classLoader, InterfaceC4014c<? super C04141> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = embeddedServer;
                this.$newInstance = application;
                this.$currentClassLoader = classLoader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C04141(this.this$0, this.$newInstance, this.$currentClassLoader, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((C04141) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    ApplicationModuleLoader moduleLoader = ApplicationModules_jvmKt.getModuleLoader(this.this$0.getEnvironment());
                    Application application = this.$newInstance;
                    ClassLoader classLoader = this.$currentClassLoader;
                    List<DynamicApplicationModule> modules = this.this$0.getModules();
                    this.label = 1;
                    if (moduleLoader.loadModules(application, classLoader, modules, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43501(EmbeddedServer<TEngine, TConfiguration> embeddedServer, Application application, ClassLoader classLoader, InterfaceC4014c<? super C43501> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.this$0 = embeddedServer;
            this.$newInstance = application;
            this.$currentClassLoader = classLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new C43501(this.this$0, this.$newInstance, this.$currentClassLoader, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43501) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                long startupTimeout = ApplicationModulesKt.getStartupTimeout(this.this$0.getEnvironment());
                C04141 c04141 = new C04141(this.this$0, this.$newInstance, this.$currentClassLoader, null);
                this.label = 1;
                if (TimeoutKt.d(startupTimeout, c04141, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$launchModuleByName$2", f = "EmbeddedServerJvm.kt", l = {443}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$launchModuleByName$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ ClassLoader $currentClassLoader;
        final /* synthetic */ String $name;
        final /* synthetic */ Application $newInstance;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ClassLoader classLoader, String str, Application application, EmbeddedServer<TEngine, TConfiguration> embeddedServer, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.$currentClassLoader = classLoader;
            this.$name = str;
            this.$newInstance = application;
            this.this$0 = embeddedServer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$currentClassLoader, this.$name, this.$newInstance, this.this$0, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ClassLoader classLoader = this.$currentClassLoader;
                String str = this.$name;
                Application application = this.$newInstance;
                ModuleParametersInjector moduleInjector = this.this$0.getModuleInjector();
                this.label = 1;
                if (CallableUtilsKt.executeModuleFunction(classLoader, str, application, moduleInjector, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$start$3", f = "EmbeddedServerJvm.kt", l = {328}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$start$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(EmbeddedServer<TEngine, TConfiguration> embeddedServer, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = embeddedServer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ApplicationEngine engine = this.this$0.getEngine();
                this.label = 1;
                obj = engine.resolvedConnectors(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            EmbeddedServer<TEngine, TConfiguration> embeddedServer = this.this$0;
            for (EngineConnectorConfig engineConnectorConfig : (Iterable) obj) {
                String strEscapeHostname = EngineUtilsJvmKt.escapeHostname(engineConnectorConfig.getHost());
                vc.c log = embeddedServer.getEnvironment().getLog();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Responding at ");
                String lowerCase = engineConnectorConfig.getType().getName().toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                sb2.append(lowerCase);
                sb2.append("://");
                sb2.append(strEscapeHostname);
                sb2.append(':');
                sb2.append(engineConnectorConfig.getPort());
                log.info(sb2.toString());
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine;", "TEngine", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "TConfiguration", "LUa/M;", "Lio/ktor/server/engine/EmbeddedServer;", "<anonymous>", "(LUa/M;)Lio/ktor/server/engine/EmbeddedServer;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$startSuspend$2", f = "EmbeddedServerJvm.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$startSuspend$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43512 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super EmbeddedServer<TEngine, TConfiguration>>, Object> {
        final /* synthetic */ boolean $wait;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43512(EmbeddedServer<TEngine, TConfiguration> embeddedServer, boolean z10, InterfaceC4014c<? super C43512> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = embeddedServer;
            this.$wait = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C43512(this.this$0, this.$wait, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super EmbeddedServer<TEngine, TConfiguration>> interfaceC4014c) {
            return ((C43512) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return this.this$0.start(this.$wait);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$stopSuspend$2", f = "EmbeddedServerJvm.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$stopSuspend$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43522 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ long $gracePeriodMillis;
        final /* synthetic */ long $timeoutMillis;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43522(EmbeddedServer<TEngine, TConfiguration> embeddedServer, long j10, long j11, InterfaceC4014c<? super C43522> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = embeddedServer;
            this.$gracePeriodMillis = j10;
            this.$timeoutMillis = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C43522(this.this$0, this.$gracePeriodMillis, this.$timeoutMillis, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43522) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.stop(this.$gracePeriodMillis, this.$timeoutMillis);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/server/application/Application;", "Ljava/lang/ClassLoader;", "classLoader", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/Application;Ljava/lang/ClassLoader;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$toDynamicModuleOrNull$1", f = "EmbeddedServerJvm.kt", l = {425, 431}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$toDynamicModuleOrNull$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43531 extends SuspendLambda implements p9.q<Application, ClassLoader, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> $module;
        final /* synthetic */ String $name;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ EmbeddedServer<TEngine, TConfiguration> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43531(EmbeddedServer<TEngine, TConfiguration> embeddedServer, String str, p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super C43531> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.this$0 = embeddedServer;
            this.$name = str;
            this.$module = pVar;
        }

        @Override // p9.q
        public final Object invoke(Application application, ClassLoader classLoader, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            C43531 c43531 = new C43531(this.this$0, this.$name, this.$module, interfaceC4014c);
            c43531.L$0 = application;
            c43531.L$1 = classLoader;
            return c43531.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        
            if (r4.launchModuleByName(r5, r7, r1, r6) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
        
            if (r7.invoke(r1, r6) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r7)
                goto L7a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                java.lang.Object r1 = r6.L$1
                io.ktor.server.application.Application r1 = (io.ktor.server.application.Application) r1
                java.lang.Object r3 = r6.L$0
                io.ktor.server.application.Application r3 = (io.ktor.server.application.Application) r3
                kotlin.C4849c.b(r7)     // Catch: io.ktor.server.engine.internal.ReloadingException -> L26
                goto L7a
            L26:
                r7 = move-exception
                goto L47
            L28:
                kotlin.C4849c.b(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                io.ktor.server.application.Application r1 = (io.ktor.server.application.Application) r1
                java.lang.Object r7 = r6.L$1
                java.lang.ClassLoader r7 = (java.lang.ClassLoader) r7
                io.ktor.server.engine.EmbeddedServer<TEngine extends io.ktor.server.engine.ApplicationEngine, TConfiguration extends io.ktor.server.engine.ApplicationEngine$Configuration> r4 = r6.this$0     // Catch: io.ktor.server.engine.internal.ReloadingException -> L45
                java.lang.String r5 = r6.$name     // Catch: io.ktor.server.engine.internal.ReloadingException -> L45
                r6.L$0 = r1     // Catch: io.ktor.server.engine.internal.ReloadingException -> L45
                r6.L$1 = r1     // Catch: io.ktor.server.engine.internal.ReloadingException -> L45
                r6.label = r3     // Catch: io.ktor.server.engine.internal.ReloadingException -> L45
                java.lang.Object r6 = io.ktor.server.engine.EmbeddedServer.access$launchModuleByName(r4, r5, r7, r1, r6)     // Catch: io.ktor.server.engine.internal.ReloadingException -> L45
                if (r6 != r0) goto L7a
                goto L79
            L45:
                r7 = move-exception
                r3 = r1
            L47:
                io.ktor.server.application.ApplicationEnvironment r3 = r3.getEnvironment()
                vc.c r3 = r3.getLog()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Failed to load module '"
                r4.append(r5)
                java.lang.String r5 = r6.$name
                r4.append(r5)
                java.lang.String r5 = "' by classpath reference, falling back to currently loaded value"
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                r3.debug(r4, r7)
                p9.p<io.ktor.server.application.Application, e9.c<? super Y8.t>, java.lang.Object> r7 = r6.$module
                r3 = 0
                r6.L$0 = r3
                r6.L$1 = r3
                r6.label = r2
                java.lang.Object r6 = r7.invoke(r1, r6)
                if (r6 != r0) goto L7a
            L79:
                return r0
            L7a:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.EmbeddedServer.C43531.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/server/application/Application;", "Ljava/lang/ClassLoader;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/Application;Ljava/lang/ClassLoader;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EmbeddedServer$wrapWithDynamicModule$1", f = "EmbeddedServerJvm.kt", l = {438}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EmbeddedServer$wrapWithDynamicModule$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43541 extends SuspendLambda implements p9.q<Application, ClassLoader, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> $module;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43541(p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super C43541> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$module = pVar;
        }

        @Override // p9.q
        public final Object invoke(Application application, ClassLoader classLoader, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            C43541 c43541 = new C43541(this.$module, interfaceC4014c);
            c43541.L$0 = application;
            return c43541.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Application application = (Application) this.L$0;
                p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> pVar = this.$module;
                this.label = 1;
                if (pVar.invoke(application, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public EmbeddedServer(ServerConfig rootConfig, ApplicationEngineFactory<? extends TEngine, TConfiguration> engineFactory, InterfaceC5074l<? super TConfiguration, Y8.t> engineConfigBlock) {
        kotlin.jvm.internal.p.i(rootConfig, "rootConfig");
        kotlin.jvm.internal.p.i(engineFactory, "engineFactory");
        kotlin.jvm.internal.p.i(engineConfigBlock, "engineConfigBlock");
        this.rootConfig = rootConfig;
        Events monitor = rootConfig.getEnvironment().getMonitor();
        this.monitor = monitor;
        ApplicationEnvironment environment = rootConfig.getEnvironment();
        this.environment = environment;
        TConfiguration tconfiguration = (TConfiguration) engineFactory.configuration(engineConfigBlock);
        this.engineConfig = tconfiguration;
        this.applicationInstanceLock = new ReentrantReadWriteLock();
        this.packageWatchKeys = C1173v.m();
        ApplicationConfigValue applicationConfigValuePropertyOrNull = environment.getConfig().propertyOrNull(ConfigKeys.hostWatchPaths);
        List<String> list = applicationConfigValuePropertyOrNull != null ? applicationConfigValuePropertyOrNull.getList() : null;
        list = list == null ? C1173v.m() : list;
        this.configuredWatchPath = list;
        this.watchPatterns = Z8.F.S0(list, rootConfig.getWatchPaths$ktor_server_core());
        this.moduleInjector = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.engine.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return EmbeddedServer.moduleInjector_delegate$lambda$1();
            }
        });
        this.modules = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.engine.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return EmbeddedServer.modules_delegate$lambda$3(this.f33385a);
            }
        });
        this.applicationInstance = new Application(environment, rootConfig.getDevelopmentMode(), rootConfig.getRootPath(), monitor, rootConfig.getParentCoroutineContext(), new PropertyReference0Impl(this) { // from class: io.ktor.server.engine.EmbeddedServer$applicationInstance$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, w9.InterfaceC5753l
            public Object get() {
                return ((EmbeddedServer) this.receiver).getEngine();
            }
        });
        this.engine = (TEngine) engineFactory.create(environment, monitor, rootConfig.getDevelopmentMode(), tconfiguration, new EmbeddedServer$engine$1(this));
        this.watcher = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.engine.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return EmbeddedServer.watcher_delegate$lambda$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$0(ApplicationEngine.Configuration configuration) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        return Y8.t.f7040a;
    }

    private final void avoidingDoubleStartup(InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        try {
            C1058h.b(null, new AnonymousClass1(block, null), 1, null);
        } finally {
            List<String> list = AutoReloadUtilsKt.getCurrentStartupModules().get();
            if (list != null && list.isEmpty()) {
                AutoReloadUtilsKt.getCurrentStartupModules().remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object avoidingDoubleStartupFor(java.lang.String r6, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.server.engine.EmbeddedServer.C43471
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.engine.EmbeddedServer$avoidingDoubleStartupFor$1 r0 = (io.ktor.server.engine.EmbeddedServer.C43471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.engine.EmbeddedServer$avoidingDoubleStartupFor$1 r0 = new io.ktor.server.engine.EmbeddedServer$avoidingDoubleStartupFor$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L31
            goto L6b
        L31:
            r5 = move-exception
            goto L76
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.C4849c.b(r5)
            java.lang.ThreadLocal r5 = io.ktor.server.engine.internal.AutoReloadUtilsKt.getCurrentStartupModules()
            java.lang.Object r1 = r5.get()
            if (r1 != 0) goto L50
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r2)
            r5.set(r1)
        L50:
            r5 = r1
            java.util.List r5 = (java.util.List) r5
            boolean r1 = r5.contains(r6)
            if (r1 != 0) goto L7a
            r5.add(r6)
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L71
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L71
            r0.label = r2     // Catch: java.lang.Throwable -> L71
            java.lang.Object r7 = r7.invoke(r0)     // Catch: java.lang.Throwable -> L71
            if (r7 != r8) goto L69
            return r8
        L69:
            r7 = r6
            r6 = r5
        L6b:
            r6.remove(r7)
            Y8.t r5 = Y8.t.f7040a
            return r5
        L71:
            r7 = move-exception
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L76:
            r6.remove(r7)
            throw r5
        L7a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Module startup is already in progress for function "
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = " (recursive module startup from module main?)"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.EmbeddedServer.avoidingDoubleStartupFor(java.lang.String, p9.l, e9.c):java.lang.Object");
    }

    private final void cleanupWatcher() {
        Y8.t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            WatchService watcher = getWatcher();
            if (watcher != null) {
                watcher.close();
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    private final Pair<Application, ClassLoader> createApplication() throws IOException {
        ClassLoader classLoaderCreateClassLoader = createClassLoader();
        Thread threadCurrentThread = Thread.currentThread();
        ClassLoader contextClassLoader = threadCurrentThread.getContextClassLoader();
        threadCurrentThread.setContextClassLoader(classLoaderCreateClassLoader);
        try {
            return Y8.j.a(instantiateAndConfigureApplication(classLoaderCreateClassLoader), classLoaderCreateClassLoader);
        } finally {
            threadCurrentThread.setContextClassLoader(contextClassLoader);
        }
    }

    private final ClassLoader createClassLoader() throws IOException {
        ClassLoader classLoader = this.environment.getClassLoader();
        if (!this.rootConfig.getDevelopmentMode()) {
            this.environment.getLog().info("Autoreload is disabled because the development mode is off.");
            return classLoader;
        }
        List<String> list = this.watchPatterns;
        if (list.isEmpty()) {
            this.environment.getLog().info("No ktor.deployment.watch patterns specified, automatic reload is not active.");
            return classLoader;
        }
        Set<URL> setAllURLs = ClassLoadersKt.allURLs(classLoader);
        String parent = new File(System.getProperty("java.home")).getParent();
        Set<URL> set = setAllURLs;
        ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((URL) it.next()).getFile());
        }
        this.environment.getLog().debug("Java Home: " + parent);
        vc.c log = this.environment.getLog();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Class Loader: ");
        sb2.append(classLoader);
        sb2.append(": ");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String string = ((String) obj).toString();
            kotlin.jvm.internal.p.f(parent);
            if (!La.D.X(string, parent, false, 2, null)) {
                arrayList2.add(obj);
            }
        }
        sb2.append(arrayList2);
        log.debug(sb2.toString());
        List listP = C1173v.p(ApplicationEnvironment.class, Pipeline.class, HttpStatusCode.class, InterfaceC5074l.class, vc.c.class, ByteReadChannel.class, fb.v.class, Attributes.class);
        HashSet hashSet = new HashSet();
        Iterator it2 = listP.iterator();
        while (it2.hasNext()) {
            URL location = ((Class) it2.next()).getProtectionDomain().getCodeSource().getLocation();
            if (location != null) {
                hashSet.add(location);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : set) {
            URL url = (URL) obj2;
            if (!hashSet.contains(url)) {
                List<String> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it3 = list2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if (EmbeddedServerJvmKt.checkUrlMatches(url, (String) it3.next())) {
                            String path = url.getPath();
                            if (path == null) {
                                path = "";
                            }
                            kotlin.jvm.internal.p.f(parent);
                            if (!La.D.X(path, parent, false, 2, null)) {
                                arrayList3.add(obj2);
                            }
                        }
                    }
                }
            }
        }
        if (arrayList3.isEmpty()) {
            this.environment.getLog().info("No ktor.deployment.watch patterns match classpath entries, automatic reload is not active");
            return classLoader;
        }
        watchUrls(arrayList3);
        return new OverridingClassLoader(arrayList3, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public final Application currentApplication() {
        List<WatchEvent<?>> fileChanges;
        ReentrantReadWriteLock.ReadLock lock = this.applicationInstanceLock.readLock();
        lock.lock();
        try {
            Application application = this.applicationInstance;
            if (application == null) {
                throw new IllegalStateException("EmbeddedServer was stopped");
            }
            if (this.rootConfig.getDevelopmentMode() && (fileChanges = getFileChanges()) != null && !fileChanges.isEmpty()) {
                ReentrantReadWriteLock reentrantReadWriteLock = this.applicationInstanceLock;
                ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
                int i10 = 0;
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i11 = 0; i11 < readHoldCount; i11++) {
                    lock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    destroyApplication();
                    Pair<Application, ClassLoader> pairCreateApplication = createApplication();
                    Application applicationA = pairCreateApplication.a();
                    ClassLoader classLoaderB = pairCreateApplication.b();
                    this.applicationInstance = applicationA;
                    this.applicationClassLoader = classLoaderB;
                    Y8.t tVar = Y8.t.f7040a;
                    while (i10 < readHoldCount) {
                        lock2.lock();
                        i10++;
                    }
                    writeLock.unlock();
                    application = this.applicationInstance;
                    if (application == null) {
                        throw new IllegalStateException("EmbeddedServer was stopped");
                    }
                } catch (Throwable th) {
                    while (i10 < readHoldCount) {
                        lock2.lock();
                        i10++;
                    }
                    writeLock.unlock();
                    throw th;
                }
            }
            lock.unlock();
            return application;
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    private final void destroyApplication() {
        Application application = this.applicationInstance;
        ClassLoader classLoader = this.applicationClassLoader;
        this.applicationInstance = null;
        this.applicationClassLoader = null;
        if (application != null) {
            safeRaiseEvent(DefaultApplicationEventsKt.getApplicationStopping(), application);
            try {
                destroyBlocking(application, classLoader);
            } catch (Throwable th) {
                this.environment.getLog().error("Failed to destroy application instance.", th);
            }
            safeRaiseEvent(DefaultApplicationEventsKt.getApplicationStopped(), application);
        }
        Iterator<T> it = this.packageWatchKeys.iterator();
        while (it.hasNext()) {
            ((WatchKey) it.next()).cancel();
        }
        this.packageWatchKeys = new ArrayList();
    }

    private final void destroyBlocking(Application application, ClassLoader classLoader) throws IOException {
        try {
            C1058h.b(null, new C43481(this, application, null), 1, null);
        } finally {
            overridingClassLoader = classLoader instanceof OverridingClassLoader ? (OverridingClassLoader) classLoader : null;
            if (overridingClassLoader != null) {
                overridingClassLoader.close();
            }
        }
    }

    private final DynamicApplicationModule dynamicModule(String name) {
        return new DynamicApplicationModule(name, new C43491(this, name, null));
    }

    private final List<WatchEvent<?>> getFileChanges() throws InterruptedException {
        try {
            List<? extends WatchKey> list = this.packageWatchKeys;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List<WatchEvent<?>> listPollEvents = ((WatchKey) it.next()).pollEvents();
                kotlin.jvm.internal.p.h(listPollEvents, "pollEvents(...)");
                Z8.A.E(arrayList, listPollEvents);
            }
            if (!arrayList.isEmpty()) {
                this.environment.getLog().info("Changes in application detected.");
                int size = arrayList.size();
                while (true) {
                    Thread.sleep(200L);
                    List<? extends WatchKey> list2 = this.packageWatchKeys;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        List<WatchEvent<?>> listPollEvents2 = ((WatchKey) it2.next()).pollEvents();
                        kotlin.jvm.internal.p.h(listPollEvents2, "pollEvents(...)");
                        Z8.A.E(arrayList2, listPollEvents2);
                    }
                    if (arrayList2.isEmpty()) {
                        break;
                    }
                    this.environment.getLog().debug("Waiting for more changes.");
                    size += arrayList2.size();
                }
                this.environment.getLog().debug("Changes to " + size + " files caused application restart.");
                Iterator it3 = Z8.F.f1(arrayList, 5).iterator();
                while (it3.hasNext()) {
                    this.environment.getLog().t("...  {}", ((WatchEvent) it3.next()).context());
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            this.environment.getLog().debug("Watch service was interrupted", e10);
            return null;
        } catch (ClosedWatchServiceException e11) {
            this.environment.getLog().debug("Watch service was closed", e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModuleParametersInjector getModuleInjector() {
        return (ModuleParametersInjector) this.moduleInjector.getValue();
    }

    private static /* synthetic */ void getModuleInjector$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DynamicApplicationModule> getModules() {
        return (List) this.modules.getValue();
    }

    public static /* synthetic */ void getMonitor$annotations() {
    }

    private final WatchService getWatcher() {
        return (WatchService) this.watcher.getValue();
    }

    private final Application instantiateAndConfigureApplication(ClassLoader currentClassLoader) {
        Application application;
        if (this.recreateInstance || (application = this.applicationInstance) == null) {
            application = new Application(this.environment, this.rootConfig.getDevelopmentMode(), this.rootConfig.getRootPath(), this.monitor, this.rootConfig.getParentCoroutineContext(), new PropertyReference0Impl(this) { // from class: io.ktor.server.engine.EmbeddedServer$instantiateAndConfigureApplication$newInstance$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, w9.InterfaceC5753l
                public Object get() {
                    return ((EmbeddedServer) this.receiver).getEngine();
                }
            });
        } else {
            this.recreateInstance = true;
            kotlin.jvm.internal.p.f(application);
        }
        safeRaiseEvent(DefaultApplicationEventsKt.getApplicationStarting(), application);
        avoidingDoubleStartup(new C43501(this, application, currentClassLoader, null));
        this.monitor.raise(DefaultApplicationEventsKt.getApplicationModulesLoaded(), application);
        this.monitor.raise(DefaultApplicationEventsKt.getApplicationStarted(), application);
        return application;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object launchModuleByName(String str, ClassLoader classLoader, Application application, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objAvoidingDoubleStartupFor = avoidingDoubleStartupFor(str, new AnonymousClass2(classLoader, str, application, this, null), interfaceC4014c);
        return objAvoidingDoubleStartupFor == C4063a.g() ? objAvoidingDoubleStartupFor : Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModuleParametersInjector moduleInjector_delegate$lambda$1() {
        Iterator it = ServiceLoader.load(ModuleParametersInjector.class, ModuleParametersInjector.class.getClassLoader()).iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        ModuleParametersInjector moduleParametersInjector = (ModuleParametersInjector) SequencesKt___SequencesKt.K(Ka.t.h(it));
        return moduleParametersInjector == null ? ModuleParametersInjector.INSTANCE.getDisabled$ktor_server_core() : moduleParametersInjector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List modules_delegate$lambda$3(EmbeddedServer embeddedServer) {
        List<String> moduleConfigReferences = ApplicationModulesKt.getModuleConfigReferences(embeddedServer.environment);
        ArrayList arrayList = new ArrayList(C1174w.x(moduleConfigReferences, 10));
        Iterator<T> it = moduleConfigReferences.iterator();
        while (it.hasNext()) {
            arrayList.add(embeddedServer.dynamicModule((String) it.next()));
        }
        List<p9.p<Application, InterfaceC4014c<? super Y8.t>, Object>> modules$ktor_server_core = embeddedServer.rootConfig.getModules$ktor_server_core();
        ArrayList arrayList2 = new ArrayList(C1174w.x(modules$ktor_server_core, 10));
        Iterator<T> it2 = modules$ktor_server_core.iterator();
        while (it2.hasNext()) {
            p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar = (p9.p) it2.next();
            DynamicApplicationModule dynamicModuleOrNull = embeddedServer.toDynamicModuleOrNull(pVar);
            if (dynamicModuleOrNull == null) {
                dynamicModuleOrNull = embeddedServer.wrapWithDynamicModule(pVar);
            }
            arrayList2.add(dynamicModuleOrNull);
        }
        return Z8.F.S0(arrayList, arrayList2);
    }

    private final void safeRaiseEvent(EventDefinition<Application> event, Application application) {
        try {
            this.monitor.raise(event, application);
        } catch (Throwable th) {
            this.environment.getLog().debug("One or more of the handlers thrown an exception", th);
        }
    }

    public static /* synthetic */ EmbeddedServer start$default(EmbeddedServer embeddedServer, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return embeddedServer.start(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t start$lambda$22(EmbeddedServer embeddedServer) {
        stop$default(embeddedServer, 0L, 0L, 3, null);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ Object startSuspend$default(EmbeddedServer embeddedServer, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return embeddedServer.startSuspend(z10, interfaceC4014c);
    }

    public static /* synthetic */ void stop$default(EmbeddedServer embeddedServer, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = embeddedServer.engineConfig.getShutdownGracePeriod();
        }
        if ((i10 & 2) != 0) {
            j11 = embeddedServer.engineConfig.getShutdownGracePeriod();
        }
        embeddedServer.stop(j10, j11);
    }

    public static /* synthetic */ Object stopSuspend$default(EmbeddedServer embeddedServer, long j10, long j11, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = embeddedServer.engineConfig.getShutdownGracePeriod();
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            j11 = embeddedServer.engineConfig.getShutdownGracePeriod();
        }
        return embeddedServer.stopSuspend(j12, j11, interfaceC4014c);
    }

    private final DynamicApplicationModule toDynamicModuleOrNull(p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        Object objB;
        if (!this.rootConfig.getDevelopmentMode()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(ServerHostUtilsKt.methodName(pVar));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            this.environment.getLog().debug("Module can't be loaded dynamically, auto-reloading won't work for this module", thE);
        }
        if (Result.e(objB) != null) {
            return null;
        }
        String str = (String) objB;
        return new DynamicApplicationModule(str, new C43531(this, str, pVar, null));
    }

    private final void watchUrls(List<URL> urls) throws IOException {
        Object objB;
        final HashSet<Path> hashSet = new HashSet();
        Iterator<URL> it = urls.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String path = it.next().getPath();
            if (path != null) {
                String strDecode = URLDecoder.decode(path, "utf-8");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(new File(strDecode).toPath());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Path path2 = (Path) (Result.g(objB) ? null : objB);
                if (path2 != null && Files.exists(path2, new LinkOption[0])) {
                    SimpleFileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>() { // from class: io.ktor.server.engine.EmbeddedServer$watchUrls$visitor$1
                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                            kotlin.jvm.internal.p.i(dir, "dir");
                            kotlin.jvm.internal.p.i(attrs, "attrs");
                            hashSet.add(dir);
                            return FileVisitResult.CONTINUE;
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            kotlin.jvm.internal.p.i(file, "file");
                            kotlin.jvm.internal.p.i(attrs, "attrs");
                            Path parent = file.getParent();
                            if (parent != null) {
                                hashSet.add(parent);
                            }
                            return FileVisitResult.CONTINUE;
                        }
                    };
                    if (Files.isDirectory(path2, new LinkOption[0])) {
                        Files.walkFileTree(path2, simpleFileVisitor);
                    }
                }
            }
        }
        for (Path path3 : hashSet) {
            this.environment.getLog().debug("Watching " + path3 + " for changes.");
        }
        WatchEvent.Modifier modifier = AutoReloadUtilsKt.get_com_sun_nio_file_SensitivityWatchEventModifier_HIGH();
        WatchEvent.Modifier[] modifierArr = modifier != null ? new WatchEvent.Modifier[]{modifier} : new WatchEvent.Modifier[0];
        ArrayList arrayList = new ArrayList();
        for (Path path4 : hashSet) {
            WatchService watcher = getWatcher();
            WatchKey watchKeyRegister = watcher != null ? path4.register(watcher, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY}, (WatchEvent.Modifier[]) Arrays.copyOf(modifierArr, modifierArr.length)) : null;
            if (watchKeyRegister != null) {
                arrayList.add(watchKeyRegister);
            }
        }
        this.packageWatchKeys = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WatchService watcher_delegate$lambda$4() {
        try {
            return FileSystems.getDefault().newWatchService();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    private final DynamicApplicationModule wrapWithDynamicModule(p9.p<? super Application, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        return new DynamicApplicationModule(null, new C43541(pVar, null), 1, null);
    }

    public final Application getApplication() {
        return currentApplication();
    }

    public final TEngine getEngine() {
        return this.engine;
    }

    public final TConfiguration getEngineConfig() {
        return this.engineConfig;
    }

    public final ApplicationEnvironment getEnvironment() {
        return this.environment;
    }

    public final Events getMonitor() {
        return this.monitor;
    }

    public final void reload() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.applicationInstanceLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            destroyApplication();
            Pair<Application, ClassLoader> pairCreateApplication = createApplication();
            Application applicationA = pairCreateApplication.a();
            ClassLoader classLoaderB = pairCreateApplication.b();
            this.applicationInstance = applicationA;
            this.applicationClassLoader = classLoaderB;
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
        }
    }

    public final EmbeddedServer<TEngine, TConfiguration> start(boolean wait) {
        ShutdownHookKt.addShutdownHook(this, new InterfaceC5063a() { // from class: io.ktor.server.engine.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return EmbeddedServer.start$lambda$22(this.f33386a);
            }
        });
        ReentrantReadWriteLock reentrantReadWriteLock = this.applicationInstanceLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            try {
                Pair<Application, ClassLoader> pairCreateApplication = createApplication();
                Application applicationA = pairCreateApplication.a();
                ClassLoader classLoaderB = pairCreateApplication.b();
                this.applicationInstance = applicationA;
                this.applicationClassLoader = classLoaderB;
                Y8.t tVar = Y8.t.f7040a;
                while (i10 < readHoldCount) {
                    lock.lock();
                    i10++;
                }
                writeLock.unlock();
                C1060i.d(kotlinx.coroutines.d.a(getApplication().getCoroutineContext()), null, null, new AnonymousClass3(this, null), 3, null);
                this.engine.start(wait);
                return this;
            } finally {
            }
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final Object startSuspend(boolean z10, InterfaceC4014c<? super EmbeddedServer<TEngine, TConfiguration>> interfaceC4014c) {
        return C1056g.j(ApplicationUtilsJvmKt.getIOBridge(Y.f6353a), new C43512(this, z10, null), interfaceC4014c);
    }

    /* JADX WARN: Finally extract failed */
    public final void stop(long shutdownGracePeriod, long shutdownTimeout, TimeUnit timeUnit) {
        kotlin.jvm.internal.p.i(timeUnit, "timeUnit");
        try {
            this.engine.stop(timeUnit.toMillis(shutdownGracePeriod), timeUnit.toMillis(shutdownTimeout));
        } catch (Exception e10) {
            this.environment.getLog().warn("Exception occurred during engine shutdown", e10);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.applicationInstanceLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            destroyApplication();
            Y8.t tVar = Y8.t.f7040a;
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            if (this.watchPatterns.isEmpty()) {
                return;
            }
            cleanupWatcher();
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final Object stopSuspend(long j10, long j11, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ = C1056g.j(ApplicationUtilsJvmKt.getIOBridge(Y.f6353a), new C43522(this, j10, j11, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
    }

    public final void stop(long gracePeriodMillis, long timeoutMillis) {
        stop(gracePeriodMillis, timeoutMillis, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ EmbeddedServer(ServerConfig serverConfig, ApplicationEngineFactory applicationEngineFactory, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(serverConfig, applicationEngineFactory, (i10 & 4) != 0 ? new InterfaceC5074l() { // from class: io.ktor.server.engine.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddedServer._init_$lambda$0((ApplicationEngine.Configuration) obj);
            }
        } : interfaceC5074l);
    }
}
