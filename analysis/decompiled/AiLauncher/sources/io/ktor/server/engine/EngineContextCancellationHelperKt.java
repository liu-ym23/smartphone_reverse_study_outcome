package io.ktor.server.engine;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Ua.M;
import Ua.Y;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.server.application.Application;
import io.ktor.server.engine.internal.ApplicationUtilsJvmKt;
import io.ktor.utils.io.InternalAPI;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a1\u0010\u000f\u001a\u00020\u0006*\u00020\t2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine;", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "", "gracePeriodMillis", "timeoutMillis", "LUa/x;", "stopServerOnCancellation", "(Lio/ktor/server/engine/ApplicationEngine;Lio/ktor/server/application/Application;JJ)LUa/x;", "Lkotlinx/coroutines/g;", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "", "block", "launchOnCancellation", "(Lkotlinx/coroutines/g;Lp9/l;)LUa/x;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EngineContextCancellationHelperKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EngineContextCancellationHelperKt$launchOnCancellation$1", f = "EngineContextCancellationHelper.kt", l = {42, 48}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EngineContextCancellationHelperKt$launchOnCancellation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> $block;
        final /* synthetic */ InterfaceC1089x $completableJob;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC1089x interfaceC1089x, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$completableJob = interfaceC1089x;
            this.$block = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$completableJob, this.$block, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        
            if (r5.T0(r4) == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        
            if (r5.invoke(r4) == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        
            return r0;
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
                if (r1 == 0) goto L21
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r5)
                goto L47
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                int r1 = r4.I$0
                kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L32
            L1f:
                r3 = r1
                goto L32
            L21:
                kotlin.C4849c.b(r5)
                Ua.x r5 = r4.$completableJob     // Catch: java.lang.Throwable -> L32
                r1 = 0
                r4.I$0 = r1     // Catch: java.lang.Throwable -> L32
                r4.label = r3     // Catch: java.lang.Throwable -> L32
                java.lang.Object r5 = r5.T0(r4)     // Catch: java.lang.Throwable -> L32
                if (r5 != r0) goto L1f
                goto L46
            L32:
                if (r3 != 0) goto L3c
                Ua.x r5 = r4.$completableJob
                boolean r5 = r5.isCancelled()
                if (r5 == 0) goto L47
            L3c:
                p9.l<e9.c<? super Y8.t>, java.lang.Object> r5 = r4.$block
                r4.label = r2
                java.lang.Object r4 = r5.invoke(r4)
                if (r4 != r0) goto L47
            L46:
                return r0
            L47:
                Y8.t r4 = Y8.t.f7040a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.EngineContextCancellationHelperKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.EngineContextCancellationHelperKt$stopServerOnCancellation$1", f = "EngineContextCancellationHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.EngineContextCancellationHelperKt$stopServerOnCancellation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43551 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ long $gracePeriodMillis;
        final /* synthetic */ ApplicationEngine $this_stopServerOnCancellation;
        final /* synthetic */ long $timeoutMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43551(ApplicationEngine applicationEngine, long j10, long j11, InterfaceC4014c<? super C43551> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.$this_stopServerOnCancellation = applicationEngine;
            this.$gracePeriodMillis = j10;
            this.$timeoutMillis = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new C43551(this.$this_stopServerOnCancellation, this.$gracePeriodMillis, this.$timeoutMillis, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43551) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$this_stopServerOnCancellation.stop(this.$gracePeriodMillis, this.$timeoutMillis);
            return Y8.t.f7040a;
        }
    }

    @InternalAPI
    public static final InterfaceC1089x launchOnCancellation(kotlinx.coroutines.g gVar, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        InterfaceC1089x interfaceC1089xA = C1086v0.a(gVar);
        C1060i.d(C1073o0.f6391a, gVar.plus(ApplicationUtilsJvmKt.getIOBridge(Y.f6353a)).plus(new CoroutineName("cancellation-watcher")), null, new AnonymousClass1(interfaceC1089xA, block, null), 2, null);
        return interfaceC1089xA;
    }

    public static final InterfaceC1089x stopServerOnCancellation(ApplicationEngine applicationEngine, Application application, long j10, long j11) {
        InterfaceC1089x interfaceC1089xLaunchOnCancellation;
        kotlin.jvm.internal.p.i(applicationEngine, "<this>");
        kotlin.jvm.internal.p.i(application, "application");
        kotlinx.coroutines.g gVar = (kotlinx.coroutines.g) application.getParentCoroutineContext().get(kotlinx.coroutines.g.INSTANCE);
        return (gVar == null || (interfaceC1089xLaunchOnCancellation = launchOnCancellation(gVar, new C43551(applicationEngine, j10, j11, null))) == null) ? JobKt__JobKt.b(null, 1, null) : interfaceC1089xLaunchOnCancellation;
    }

    public static /* synthetic */ InterfaceC1089x stopServerOnCancellation$default(ApplicationEngine applicationEngine, Application application, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 50;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = 5000;
        }
        return stopServerOnCancellation(applicationEngine, application, j12, j11);
    }
}
