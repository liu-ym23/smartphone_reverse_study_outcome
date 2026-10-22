package io.ktor.server.engine;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.engine.internal.ApplicationUtilsJvmKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine;", "", "", "Lio/ktor/server/engine/EngineConnectorConfig;", "resolvedConnectors", "(Le9/c;)Ljava/lang/Object;", "", "wait", "start", "(Z)Lio/ktor/server/engine/ApplicationEngine;", "startSuspend", "(ZLe9/c;)Ljava/lang/Object;", "", "gracePeriodMillis", "timeoutMillis", "LY8/t;", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, "(JJ)V", "stopSuspend", "(JJLe9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Configuration", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ApplicationEngine {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine$Configuration;", "", "<init>", "()V", "other", "LY8/t;", "takeFrom", "(Lio/ktor/server/engine/ApplicationEngine$Configuration;)V", "", "parallelism", "I", "getParallelism", "()I", "connectionGroupSize", "getConnectionGroupSize", "setConnectionGroupSize", "(I)V", "workerGroupSize", "getWorkerGroupSize", "setWorkerGroupSize", "callGroupSize", "getCallGroupSize", "setCallGroupSize", "", "shutdownGracePeriod", "J", "getShutdownGracePeriod", "()J", "setShutdownGracePeriod", "(J)V", "shutdownTimeout", "getShutdownTimeout", "setShutdownTimeout", "", "Lio/ktor/server/engine/EngineConnectorConfig;", "connectors", "Ljava/util/List;", "getConnectors", "()Ljava/util/List;", "setConnectors", "(Ljava/util/List;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Configuration {
        private int callGroupSize;
        private int connectionGroupSize;
        private List<EngineConnectorConfig> connectors;
        private final int parallelism;
        private long shutdownGracePeriod;
        private long shutdownTimeout;
        private int workerGroupSize;

        public Configuration() {
            int iAvailableProcessorsBridge = ApplicationUtilsJvmKt.availableProcessorsBridge();
            this.parallelism = iAvailableProcessorsBridge;
            this.connectionGroupSize = (iAvailableProcessorsBridge / 2) + 1;
            this.workerGroupSize = (iAvailableProcessorsBridge / 2) + 1;
            this.callGroupSize = iAvailableProcessorsBridge;
            this.shutdownGracePeriod = 1000L;
            this.shutdownTimeout = 5000L;
            this.connectors = new ArrayList();
        }

        public final int getCallGroupSize() {
            return this.callGroupSize;
        }

        public final int getConnectionGroupSize() {
            return this.connectionGroupSize;
        }

        public final List<EngineConnectorConfig> getConnectors() {
            return this.connectors;
        }

        public final int getParallelism() {
            return this.parallelism;
        }

        public final long getShutdownGracePeriod() {
            return this.shutdownGracePeriod;
        }

        public final long getShutdownTimeout() {
            return this.shutdownTimeout;
        }

        public final int getWorkerGroupSize() {
            return this.workerGroupSize;
        }

        public final void setCallGroupSize(int i10) {
            this.callGroupSize = i10;
        }

        public final void setConnectionGroupSize(int i10) {
            this.connectionGroupSize = i10;
        }

        public final void setConnectors(List<EngineConnectorConfig> list) {
            kotlin.jvm.internal.p.i(list, "<set-?>");
            this.connectors = list;
        }

        public final void setShutdownGracePeriod(long j10) {
            this.shutdownGracePeriod = j10;
        }

        public final void setShutdownTimeout(long j10) {
            this.shutdownTimeout = j10;
        }

        public final void setWorkerGroupSize(int i10) {
            this.workerGroupSize = i10;
        }

        public final void takeFrom(Configuration other) {
            kotlin.jvm.internal.p.i(other, "other");
            this.connectionGroupSize = other.connectionGroupSize;
            this.workerGroupSize = other.workerGroupSize;
            this.callGroupSize = other.callGroupSize;
            this.shutdownGracePeriod = other.shutdownGracePeriod;
            this.shutdownTimeout = other.shutdownTimeout;
            this.connectors.addAll(other.connectors);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ ApplicationEngine start$default(ApplicationEngine applicationEngine, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return applicationEngine.start(z10);
        }

        public static Object startSuspend(ApplicationEngine applicationEngine, boolean z10, InterfaceC4014c<? super ApplicationEngine> interfaceC4014c) {
            return C1056g.j(ApplicationUtilsJvmKt.getIOBridge(Y.f6353a), applicationEngine.new AnonymousClass2(z10, null), interfaceC4014c);
        }

        public static /* synthetic */ Object startSuspend$default(ApplicationEngine applicationEngine, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSuspend");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return applicationEngine.startSuspend(z10, interfaceC4014c);
        }

        public static /* synthetic */ void stop$default(ApplicationEngine applicationEngine, long j10, long j11, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
            }
            if ((i10 & 1) != 0) {
                j10 = 500;
            }
            if ((i10 & 2) != 0) {
                j11 = 500;
            }
            applicationEngine.stop(j10, j11);
        }

        public static Object stopSuspend(ApplicationEngine applicationEngine, long j10, long j11, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            Object objJ = C1056g.j(ApplicationUtilsJvmKt.getIOBridge(Y.f6353a), applicationEngine.new C43382(j10, j11, null), interfaceC4014c);
            return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
        }

        public static /* synthetic */ Object stopSuspend$default(ApplicationEngine applicationEngine, long j10, long j11, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopSuspend");
            }
            if ((i10 & 1) != 0) {
                j10 = 500;
            }
            if ((i10 & 2) != 0) {
                j11 = 500;
            }
            return applicationEngine.stopSuspend(j10, j11, interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/server/engine/ApplicationEngine;", "<anonymous>", "(LUa/M;)Lio/ktor/server/engine/ApplicationEngine;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.ApplicationEngine$startSuspend$2", f = "ApplicationEngine.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.ApplicationEngine$startSuspend$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super ApplicationEngine>, Object> {
        final /* synthetic */ boolean $wait;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z10, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$wait = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ApplicationEngine.this.new AnonymousClass2(this.$wait, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super ApplicationEngine> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return ApplicationEngine.this.start(this.$wait);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.ApplicationEngine$stopSuspend$2", f = "ApplicationEngine.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.ApplicationEngine$stopSuspend$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43382 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ long $gracePeriodMillis;
        final /* synthetic */ long $timeoutMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43382(long j10, long j11, InterfaceC4014c<? super C43382> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$gracePeriodMillis = j10;
            this.$timeoutMillis = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ApplicationEngine.this.new C43382(this.$gracePeriodMillis, this.$timeoutMillis, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43382) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ApplicationEngine.this.stop(this.$gracePeriodMillis, this.$timeoutMillis);
            return Y8.t.f7040a;
        }
    }

    ApplicationEnvironment getEnvironment();

    Object resolvedConnectors(InterfaceC4014c<? super List<? extends EngineConnectorConfig>> interfaceC4014c);

    ApplicationEngine start(boolean wait);

    Object startSuspend(boolean z10, InterfaceC4014c<? super ApplicationEngine> interfaceC4014c);

    void stop(long gracePeriodMillis, long timeoutMillis);

    Object stopSuspend(long j10, long j11, InterfaceC4014c<? super Y8.t> interfaceC4014c);
}
