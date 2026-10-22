package com.stepos.core.ota.process;

import android.content.Context;
import android.content.Intent;
import com.stepos.core.common.cloud.d;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.adapter.RemoteModelActivator;
import com.stepos.core.ota.downloader.DownloadEngine;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine;
import com.stepos.core.ota.process.PendingActivationStore;
import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessBootstrap {
    private static final String TAG = "OtaProcessBootstrap";
    private static volatile RemoteModelActivator remoteActivator;
    public static final OtaProcessBootstrap INSTANCE = new OtaProcessBootstrap();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessBootstrap$reconcilePendingActivations$1", f = "OtaProcessBootstrap.kt", l = {59, 62}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessBootstrap$reconcilePendingActivations$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ RemoteModelActivator $activator;
        final /* synthetic */ List<PendingActivationStore.Pending> $pendings;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<PendingActivationStore.Pending> list, RemoteModelActivator remoteModelActivator, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$pendings = list;
            this.$activator = remoteModelActivator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass1(this.$pendings, this.$activator, bVar);
        }

        /* JADX WARN: Path cross not found for [B:19:0x0062, B:25:0x00a9], limit reached: 29 */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r14.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r14.L$0
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.c.b(r15)
                kotlin.Result r15 = (kotlin.Result) r15
                java.lang.Object r15 = r15.f9987a
                r12 = r14
                r15 = r1
                goto La7
            L1b:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L23:
                java.lang.Object r1 = r14.L$1
                com.stepos.core.ota.process.PendingActivationStore$Pending r1 = (com.stepos.core.ota.process.PendingActivationStore.Pending) r1
                java.lang.Object r4 = r14.L$0
                java.util.Iterator r4 = (java.util.Iterator) r4
                kotlin.c.b(r15)
                goto L5a
            L2f:
                kotlin.c.b(r15)
                java.util.List<com.stepos.core.ota.process.PendingActivationStore$Pending> r15 = r14.$pendings
                java.util.Iterator r15 = r15.iterator()
            L38:
                boolean r1 = r15.hasNext()
                if (r1 == 0) goto Lb5
                java.lang.Object r1 = r15.next()
                com.stepos.core.ota.process.PendingActivationStore$Pending r1 = (com.stepos.core.ota.process.PendingActivationStore.Pending) r1
                com.stepos.core.ota.adapter.RemoteModelActivator r4 = r14.$activator
                java.lang.String r5 = r1.getOtaId()
                r14.L$0 = r15
                r14.L$1 = r1
                r14.label = r3
                java.lang.Object r4 = r4.currentVersion(r5, r14)
                if (r4 != r0) goto L57
                goto La6
            L57:
                r13 = r4
                r4 = r15
                r15 = r13
            L5a:
                java.lang.Number r15 = (java.lang.Number) r15
                int r15 = r15.intValue()
                if (r15 < 0) goto La9
                int r5 = r1.getVersion()
                if (r15 >= r5) goto La9
                com.stepos.core.common.log.LogModule r5 = com.stepos.core.common.log.LogModule.OTA
                java.lang.String r6 = r1.getOtaId()
                int r7 = r1.getVersion()
                java.lang.String r8 = " cur="
                java.lang.String r9 = " -> v"
                java.lang.String r10 = "reconcile re-activate "
                java.lang.StringBuilder r15 = h0.e.f(r10, r6, r8, r15, r9)
                r15.append(r7)
                java.lang.String r15 = r15.toString()
                java.lang.String r6 = "OtaProcessBootstrap"
                com.stepos.core.common.log.AIEngineLogger.i(r5, r6, r15)
                com.stepos.core.ota.adapter.RemoteModelActivator r7 = r14.$activator
                java.lang.String r8 = r1.getOtaId()
                int r9 = r1.getVersion()
                java.lang.String r10 = r1.getPath()
                r14.L$0 = r4
                r15 = 0
                r14.L$1 = r15
                r14.label = r2
                java.lang.String r11 = "OTA-reconcile"
                r12 = r14
                java.lang.Object r14 = r7.mo115activateyxL6bBk(r8, r9, r10, r11, r12)
                if (r14 != r0) goto Lb3
            La6:
                return r0
            La7:
                r14 = r12
                goto L38
            La9:
                r12 = r14
                com.stepos.core.ota.process.PendingActivationStore r14 = com.stepos.core.ota.process.PendingActivationStore.INSTANCE
                java.lang.String r15 = r1.getOtaId()
                r14.remove(r15)
            Lb3:
                r15 = r4
                goto La7
            Lb5:
                lb.n r14 = lb.n.f10413a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.process.OtaProcessBootstrap.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private OtaProcessBootstrap() {
    }

    private final void reconcilePendingActivations(RemoteModelActivator remoteModelActivator) {
        List<PendingActivationStore.Pending> listAll = PendingActivationStore.INSTANCE.all();
        if (listAll.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(listAll, remoteModelActivator, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelDownloadNotifier start$lambda$1(Context it) {
        g.f(it, "it");
        return new ModelDownloadNotifier(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadEngine start$lambda$2(Context it) {
        g.f(it, "it");
        return new Fetch2DownloadEngine(it);
    }

    public final void ensureRemoteProcess(Context context) {
        g.f(context, "context");
        if (!OtaProcessConfig.INSTANCE.getEnabled() || OtaProcess.INSTANCE.isOtaProcess(context)) {
            return;
        }
        Intent className = new Intent(OtaProcessService.ACTION).setClassName(context, OtaProcessService.class.getName());
        g.e(className, "setClassName(...)");
        try {
            context.getApplicationContext().startService(className);
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        OtaProcessClient.INSTANCE.bindAsync(context);
    }

    public final RemoteModelActivator remoteActivatorOrNull() {
        return remoteActivator;
    }

    public final void start(Context context) {
        g.f(context, "context");
        if (OtaProcess.INSTANCE.isOtaProcess(context)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "bootstrap OTA process");
            Context applicationContext = context.getApplicationContext();
            g.c(applicationContext);
            RemoteModelActivator remoteModelActivator = new RemoteModelActivator(applicationContext);
            remoteActivator = remoteModelActivator;
            remoteModelActivator.bindActivationHost(applicationContext);
            OtaEngine.INSTANCE.initInOtaProcess(applicationContext, remoteModelActivator, new com.stepos.core.common.telemetry.b(19), new d(22));
            reconcilePendingActivations(remoteModelActivator);
            OtaContainer.INSTANCE.restorePausedFromDisk();
        }
    }

    public final void stop(Context context) {
        g.f(context, "context");
        RemoteModelActivator remoteModelActivator = remoteActivator;
        if (remoteModelActivator != null) {
            Context applicationContext = context.getApplicationContext();
            g.e(applicationContext, "getApplicationContext(...)");
            remoteModelActivator.unbind(applicationContext);
        }
        remoteActivator = null;
        OtaEngine.INSTANCE.release();
    }
}
