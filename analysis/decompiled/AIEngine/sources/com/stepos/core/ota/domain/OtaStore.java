package com.stepos.core.ota.domain;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.notification.NotificationCancelSuppressStore;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.domain.OtaAction;
import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.install.InstallPipeline;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.domain.port.DownloadSpec;
import com.stepos.core.ota.domain.port.ManifestSource;
import com.stepos.core.ota.domain.port.ModelDownloadPort;
import com.stepos.core.ota.domain.port.ModelStorage;
import com.stepos.core.ota.domain.port.OtaClock;
import com.stepos.core.ota.domain.port.OtaLogger;
import com.stepos.core.ota.download.control.DeviceConditions;
import com.stepos.core.ota.download.control.DownloadController;
import com.stepos.core.ota.download.control.DownloadVerdict;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.storage.OtaFailureMarker;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import com.stepos.core.ota.storage.SilentInstallFailureStore;
import com.stepos.core.ota.storage.UserUninstallStore;
import dc.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import lb.n;
import mb.m;
import mb.q;
import mb.v;
import mb.x;
import qb.b;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaStore {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAILBOX_CAPACITY = 256;
    private static final int PROGRESS_LOG_STEP = 5;
    private static final String TAG = "OtaStore";
    private final MutableStateFlow<Map<String, OtaStateSnapshot>> _state;
    private final OtaClock clock;
    private final zb.a<DeviceConditions> conditions;
    private volatile Job consumer;
    private final ModelDownloadPort downloadPort;
    private final DownloadController governor;
    private final InstallPipeline installPipeline;
    private final HashMap<String, Integer> lastLoggedProgressBucket;
    private final OtaLogger log;
    private final Channel<OtaAction> mailbox;
    private final ManifestSource manifestSource;
    private final l<ModelManifest, n> onManifestInstalled;
    private final CoroutineScope scope;
    private final StateFlow<Map<String, OtaStateSnapshot>> state;
    private final ModelStorage storage;
    private final HashMap<String, OtaTask> tasks;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$launchInstall$1", f = "OtaStore.kt", l = {748, 749, 750}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$launchInstall$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ String $filePath;
        final /* synthetic */ ModelManifest $manifest;
        final /* synthetic */ OtaTask $task;
        int label;
        final /* synthetic */ OtaStore this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelManifest modelManifest, String str, OtaStore otaStore, OtaTask otaTask, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$manifest = modelManifest;
            this.$filePath = str;
            this.this$0 = otaStore;
            this.$task = otaTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.$manifest, this.$filePath, this.this$0, this.$task, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
        
            if (r1.send(r2, r8) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
        
            if (r1.send(r3, r8) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                goto L18
            L10:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L18:
                kotlin.c.b(r9)
                goto L98
            L1d:
                kotlin.c.b(r9)
                goto L4e
            L21:
                kotlin.c.b(r9)
                com.stepos.core.ota.domain.install.InstallContext r9 = new com.stepos.core.ota.domain.install.InstallContext
                com.stepos.core.ota.domain.model.ModelManifest r1 = r8.$manifest
                java.lang.String r5 = r8.$filePath
                com.stepos.core.ota.domain.OtaStore r6 = r8.this$0
                com.stepos.core.ota.domain.port.ModelStorage r6 = com.stepos.core.ota.domain.OtaStore.access$getStorage$p(r6)
                com.stepos.core.ota.domain.OtaStore$OtaTask r7 = r8.$task
                java.lang.String r7 = r7.getOtaId()
                java.lang.String r6 = r6.bucketDir(r7)
                java.lang.String r7 = "OTA"
                r9.<init>(r1, r5, r6, r7)
                com.stepos.core.ota.domain.OtaStore r1 = r8.this$0
                com.stepos.core.ota.domain.install.InstallPipeline r1 = com.stepos.core.ota.domain.OtaStore.access$getInstallPipeline$p(r1)
                r8.label = r4
                java.lang.Object r9 = r1.run(r9, r8)
                if (r9 != r0) goto L4e
                goto L97
            L4e:
                com.stepos.core.ota.domain.install.InstallOutcome r9 = (com.stepos.core.ota.domain.install.InstallOutcome) r9
                boolean r1 = r9 instanceof com.stepos.core.ota.domain.install.InstallOutcome.Success
                if (r1 == 0) goto L74
                com.stepos.core.ota.domain.OtaStore r1 = r8.this$0
                kotlinx.coroutines.channels.Channel r1 = com.stepos.core.ota.domain.OtaStore.access$getMailbox$p(r1)
                com.stepos.core.ota.domain.OtaAction$InstallSucceeded r2 = new com.stepos.core.ota.domain.OtaAction$InstallSucceeded
                com.stepos.core.ota.domain.OtaStore$OtaTask r4 = r8.$task
                java.lang.String r4 = r4.getOtaId()
                com.stepos.core.ota.domain.install.InstallOutcome$Success r9 = (com.stepos.core.ota.domain.install.InstallOutcome.Success) r9
                int r9 = r9.getVersion()
                r2.<init>(r4, r9)
                r8.label = r3
                java.lang.Object r8 = r1.send(r2, r8)
                if (r8 != r0) goto L98
                goto L97
            L74:
                boolean r1 = r9 instanceof com.stepos.core.ota.domain.install.InstallOutcome.Failure
                if (r1 == 0) goto L9b
                com.stepos.core.ota.domain.OtaStore r1 = r8.this$0
                kotlinx.coroutines.channels.Channel r1 = com.stepos.core.ota.domain.OtaStore.access$getMailbox$p(r1)
                com.stepos.core.ota.domain.OtaAction$InstallFailed r3 = new com.stepos.core.ota.domain.OtaAction$InstallFailed
                com.stepos.core.ota.domain.OtaStore$OtaTask r4 = r8.$task
                java.lang.String r4 = r4.getOtaId()
                com.stepos.core.ota.domain.install.InstallOutcome$Failure r9 = (com.stepos.core.ota.domain.install.InstallOutcome.Failure) r9
                com.stepos.core.ota.domain.OtaError r9 = r9.getError()
                r3.<init>(r4, r9)
                r8.label = r2
                java.lang.Object r8 = r1.send(r3, r8)
                if (r8 != r0) goto L98
            L97:
                return r0
            L98:
                lb.n r8 = lb.n.f10413a
                return r8
            L9b:
                kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$launchPlan$1", f = "OtaStore.kt", l = {604, 602}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$launchPlan$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03921 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ List<ModelManifest> $fallbackPlan;
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ String $otaId;
        final /* synthetic */ Set<String> $plugins;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03921(String str, Set<String> set, boolean z, List<ModelManifest> list, b<? super C03921> bVar) {
            super(2, bVar);
            this.$otaId = str;
            this.$plugins = set;
            this.$forceRefresh = z;
            this.$fallbackPlan = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return OtaStore.this.new C03921(this.$otaId, this.$plugins, this.$forceRefresh, this.$fallbackPlan, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        
            if (r4.sendResolvedPlan(r5, r6, r7, r8, r10) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r11)
                goto L5f
            L10:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L18:
                java.lang.Object r1 = r10.L$1
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r10.L$0
                com.stepos.core.ota.domain.OtaStore r3 = (com.stepos.core.ota.domain.OtaStore) r3
                kotlin.c.b(r11)
                kotlin.Result r11 = (kotlin.Result) r11
                java.lang.Object r11 = r11.f9987a
                r6 = r11
                r4 = r3
            L29:
                r5 = r1
                goto L4c
            L2b:
                kotlin.c.b(r11)
                com.stepos.core.ota.domain.OtaStore r11 = com.stepos.core.ota.domain.OtaStore.this
                java.lang.String r1 = r10.$otaId
                com.stepos.core.ota.domain.port.ManifestSource r4 = com.stepos.core.ota.domain.OtaStore.access$getManifestSource$p(r11)
                java.lang.String r5 = r10.$otaId
                java.util.Set<java.lang.String> r6 = r10.$plugins
                boolean r7 = r10.$forceRefresh
                r10.L$0 = r11
                r10.L$1 = r1
                r10.label = r3
                java.lang.Object r3 = r4.mo114planUpdatesBWLJW6A(r5, r6, r7, r10)
                if (r3 != r0) goto L49
                goto L5e
            L49:
                r4 = r11
                r6 = r3
                goto L29
            L4c:
                java.util.List<com.stepos.core.ota.domain.model.ModelManifest> r7 = r10.$fallbackPlan
                boolean r8 = r10.$forceRefresh
                r11 = 0
                r10.L$0 = r11
                r10.L$1 = r11
                r10.label = r2
                r9 = r10
                java.lang.Object r10 = com.stepos.core.ota.domain.OtaStore.access$sendResolvedPlan(r4, r5, r6, r7, r8, r9)
                if (r10 != r0) goto L5f
            L5e:
                return r0
            L5f:
                lb.n r10 = lb.n.f10413a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.C03921.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C03921) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore", f = "OtaStore.kt", l = {495}, m = "onCancel")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$onCancel$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03931(b<? super C03931> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaStore.this.onCancel(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore", f = "OtaStore.kt", l = {577}, m = "onConditionsChanged")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$onConditionsChanged$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03941(b<? super C03941> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaStore.this.onConditionsChanged(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$onDownload$1", f = "OtaStore.kt", l = {205}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$onDownload$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03951 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ OtaTask $task;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03951(OtaTask otaTask, b<? super C03951> bVar) {
            super(2, bVar);
            this.$task = otaTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return OtaStore.this.new C03951(this.$task, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                OtaStore otaStore = OtaStore.this;
                OtaTask otaTask = this.$task;
                this.label = 1;
                if (otaStore.preemptAndRestart(otaTask, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C03951) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$onDownload$2", f = "OtaStore.kt", l = {216}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$onDownload$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ OtaTask $task;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OtaTask otaTask, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$task = otaTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return OtaStore.this.new AnonymousClass2(this.$task, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                OtaStore otaStore = OtaStore.this;
                OtaTask otaTask = this.$task;
                this.label = 1;
                if (otaStore.preemptAndRestart(otaTask, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore", f = "OtaStore.kt", l = {438}, m = "onPause")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$onPause$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03961(b<? super C03961> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaStore.this.onPause(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore", f = "OtaStore.kt", l = {483}, m = "preemptAndRestart")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$preemptAndRestart$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03971(b<? super C03971> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaStore.this.preemptAndRestart(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$retryAfterInstallFailure$1", f = "OtaStore.kt", l = {301, 299}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$retryAfterInstallFailure$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03981 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ int $fallbackBaseVer;
        final /* synthetic */ int $fromIndex;
        final /* synthetic */ String $otaId;
        final /* synthetic */ List<ModelManifest> $planSnapshot;
        final /* synthetic */ String $previousFile;
        final /* synthetic */ OtaTask $task;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ OtaStore this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03981(String str, OtaStore otaStore, List<ModelManifest> list, int i10, int i11, String str2, OtaTask otaTask, b<? super C03981> bVar) {
            super(2, bVar);
            this.$previousFile = str;
            this.this$0 = otaStore;
            this.$planSnapshot = list;
            this.$fromIndex = i10;
            this.$fallbackBaseVer = i11;
            this.$otaId = str2;
            this.$task = otaTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new C03981(this.$previousFile, this.this$0, this.$planSnapshot, this.$fromIndex, this.$fallbackBaseVer, this.$otaId, this.$task, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
        
            if (com.stepos.core.ota.domain.OtaStore.sendResolvedPlan$default(r4, r5, r6, r7, false, r12, 8, null) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r12.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2c
                if (r1 == r3) goto L19
                if (r1 != r2) goto L11
                kotlin.c.b(r13)
                goto La5
            L11:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L19:
                java.lang.Object r1 = r12.L$1
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r12.L$0
                com.stepos.core.ota.domain.OtaStore r3 = (com.stepos.core.ota.domain.OtaStore) r3
                kotlin.c.b(r13)
                kotlin.Result r13 = (kotlin.Result) r13
                java.lang.Object r13 = r13.f9987a
                r6 = r13
                r4 = r3
            L2a:
                r5 = r1
                goto L90
            L2c:
                kotlin.c.b(r13)
                java.lang.String r13 = r12.$previousFile
                if (r13 == 0) goto L3c
                com.stepos.core.ota.domain.OtaStore r1 = r12.this$0
                com.stepos.core.ota.domain.port.ModelStorage r1 = com.stepos.core.ota.domain.OtaStore.access$getStorage$p(r1)
                r1.deleteDir(r13)
            L3c:
                java.util.List<com.stepos.core.ota.domain.model.ModelManifest> r13 = r12.$planSnapshot
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L52
                com.stepos.core.ota.domain.OtaStore r13 = r12.this$0
                java.util.List<com.stepos.core.ota.domain.model.ModelManifest> r1 = r12.$planSnapshot
                int r4 = r12.$fromIndex
                int r5 = r12.$fallbackBaseVer
                java.lang.String r6 = r12.$otaId
                com.stepos.core.ota.domain.OtaStore.access$cleanInstallAttemptArtifacts(r13, r1, r4, r5, r6)
                goto L5f
            L52:
                com.stepos.core.ota.domain.OtaStore r13 = r12.this$0
                com.stepos.core.ota.domain.port.ModelStorage r13 = com.stepos.core.ota.domain.OtaStore.access$getStorage$p(r13)
                java.lang.String r1 = r12.$otaId
                int r4 = r12.$fallbackBaseVer
                r13.setInstalledVersion(r1, r4)
            L5f:
                com.stepos.core.ota.domain.OtaStore r13 = r12.this$0
                com.stepos.core.ota.domain.port.ModelDownloadPort r13 = com.stepos.core.ota.domain.OtaStore.access$getDownloadPort$p(r13)
                java.lang.String r1 = r12.$otaId
                r13.discardEngineRecord(r1)
                com.stepos.core.ota.domain.OtaStore r13 = r12.this$0
                java.lang.String r1 = r12.$otaId
                com.stepos.core.ota.domain.port.ManifestSource r4 = com.stepos.core.ota.domain.OtaStore.access$getManifestSource$p(r13)
                java.lang.String r5 = r12.$otaId
                com.stepos.core.ota.domain.OtaStore$OtaTask r6 = r12.$task
                java.util.Set r6 = r6.getPlugins()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Set r6 = kotlin.collections.a.R0(r6)
                r12.L$0 = r13
                r12.L$1 = r1
                r12.label = r3
                java.lang.Object r3 = r4.mo114planUpdatesBWLJW6A(r5, r6, r3, r12)
                if (r3 != r0) goto L8d
                goto La4
            L8d:
                r4 = r13
                r6 = r3
                goto L2a
            L90:
                java.util.List<com.stepos.core.ota.domain.model.ModelManifest> r7 = r12.$planSnapshot
                r13 = 0
                r12.L$0 = r13
                r12.L$1 = r13
                r12.label = r2
                r8 = 0
                r10 = 8
                r11 = 0
                r9 = r12
                java.lang.Object r12 = com.stepos.core.ota.domain.OtaStore.sendResolvedPlan$default(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r12 != r0) goto La5
            La4:
                return r0
            La5:
                lb.n r12 = lb.n.f10413a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.C03981.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C03981) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$start$1", f = "OtaStore.kt", l = {98, 99}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03991 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C03991(b<? super C03991> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C03991 c03991 = OtaStore.this.new C03991(bVar);
            c03991.L$0 = obj;
            return c03991;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        
            if (r11.handle(r1, r10) == r0) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0075 -> B:26:0x0078). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L34
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r10.L$2
                com.stepos.core.ota.domain.OtaAction r1 = (com.stepos.core.ota.domain.OtaAction) r1
                java.lang.Object r4 = r10.L$1
                kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
                java.lang.Object r5 = r10.L$0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                kotlin.c.b(r11)     // Catch: java.lang.Throwable -> L1c
                goto L78
            L1c:
                r11 = move-exception
                goto L7b
            L1e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L26:
                java.lang.Object r1 = r10.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r10.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.c.b(r11)
                r5 = r4
            L32:
                r4 = r1
                goto L58
            L34:
                kotlin.c.b(r11)
                java.lang.Object r11 = r10.L$0
                kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
                com.stepos.core.ota.domain.OtaStore r1 = com.stepos.core.ota.domain.OtaStore.this
                kotlinx.coroutines.channels.Channel r1 = com.stepos.core.ota.domain.OtaStore.access$getMailbox$p(r1)
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            L45:
                r10.L$0 = r11
                r10.L$1 = r1
                r4 = 0
                r10.L$2 = r4
                r10.label = r3
                java.lang.Object r4 = r1.hasNext(r10)
                if (r4 != r0) goto L55
                goto L77
            L55:
                r5 = r11
                r11 = r4
                goto L32
            L58:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto Lab
                java.lang.Object r11 = r4.next()
                r1 = r11
                com.stepos.core.ota.domain.OtaAction r1 = (com.stepos.core.ota.domain.OtaAction) r1
                com.stepos.core.ota.domain.OtaStore r11 = com.stepos.core.ota.domain.OtaStore.this
                r10.L$0 = r5     // Catch: java.lang.Throwable -> L1c
                r10.L$1 = r4     // Catch: java.lang.Throwable -> L1c
                r10.L$2 = r1     // Catch: java.lang.Throwable -> L1c
                r10.label = r2     // Catch: java.lang.Throwable -> L1c
                java.lang.Object r11 = com.stepos.core.ota.domain.OtaStore.access$handle(r11, r1, r10)     // Catch: java.lang.Throwable -> L1c
                if (r11 != r0) goto L78
            L77:
                return r0
            L78:
                lb.n r11 = lb.n.f10413a     // Catch: java.lang.Throwable -> L1c
                goto L7f
            L7b:
                kotlin.Result$Failure r11 = kotlin.c.a(r11)
            L7f:
                com.stepos.core.ota.domain.OtaStore r6 = com.stepos.core.ota.domain.OtaStore.this
                java.lang.Throwable r11 = kotlin.Result.b(r11)
                if (r11 == 0) goto La8
                com.stepos.core.ota.domain.port.OtaLogger r6 = com.stepos.core.ota.domain.OtaStore.access$getLog$p(r6)
                java.lang.Class r7 = r1.getClass()
                kotlin.jvm.internal.c r7 = kotlin.jvm.internal.i.a(r7)
                java.lang.String r7 = r7.c()
                java.lang.String r1 = r1.getOtaId()
                java.lang.String r8 = "handle failed: "
                java.lang.String r9 = " "
                java.lang.String r1 = ai.onnxruntime.a.l(r8, r7, r9, r1)
                java.lang.String r7 = "OtaStore"
                r6.e(r7, r1, r11)
            La8:
                r1 = r4
                r11 = r5
                goto L45
            Lab:
                lb.n r10 = lb.n.f10413a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.C03991.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C03991) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore$startNext$3", f = "OtaStore.kt", l = {722, 725, 733}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$startNext$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ DownloadSpec $spec;
        final /* synthetic */ String $targetFilePath;
        final /* synthetic */ OtaTask $task;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DownloadSpec downloadSpec, OtaTask otaTask, String str, b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$spec = downloadSpec;
            this.$task = otaTask;
            this.$targetFilePath = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n invokeSuspend$lambda$0(OtaStore otaStore, OtaTask otaTask, String str, long j10, long j11) {
            otaStore.mailbox.mo149trySendJP2dKIU(new OtaAction.ProgressUpdated(otaTask.getOtaId(), j10, j11, str));
            return n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return OtaStore.this.new AnonymousClass3(this.$spec, this.$task, this.$targetFilePath, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
        
            if (r1.send(r2, r9) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
        
            if (r10.send(r1, r9) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                goto L18
            L10:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L18:
                kotlin.c.b(r10)
                goto Lae
            L1d:
                kotlin.c.b(r10)
                kotlin.Result r10 = (kotlin.Result) r10
                java.lang.Object r10 = r10.f9987a
                goto L44
            L25:
                kotlin.c.b(r10)
                com.stepos.core.ota.domain.OtaStore r10 = com.stepos.core.ota.domain.OtaStore.this
                com.stepos.core.ota.domain.port.ModelDownloadPort r10 = com.stepos.core.ota.domain.OtaStore.access$getDownloadPort$p(r10)
                com.stepos.core.ota.domain.port.DownloadSpec r1 = r9.$spec
                com.stepos.core.ota.domain.OtaStore r5 = com.stepos.core.ota.domain.OtaStore.this
                com.stepos.core.ota.domain.OtaStore$OtaTask r6 = r9.$task
                java.lang.String r7 = r9.$targetFilePath
                com.stepos.core.ota.domain.a r8 = new com.stepos.core.ota.domain.a
                r8.<init>()
                r9.label = r4
                java.lang.Object r10 = r10.mo110download0E7RQCE(r1, r8, r9)
                if (r10 != r0) goto L44
                goto Lad
            L44:
                com.stepos.core.ota.domain.OtaStore r1 = com.stepos.core.ota.domain.OtaStore.this
                com.stepos.core.ota.domain.OtaStore$OtaTask r4 = r9.$task
                java.lang.Throwable r5 = kotlin.Result.b(r10)
                if (r5 != 0) goto L66
                java.lang.String r10 = (java.lang.String) r10
                kotlinx.coroutines.channels.Channel r1 = com.stepos.core.ota.domain.OtaStore.access$getMailbox$p(r1)
                com.stepos.core.ota.domain.OtaAction$DownloadSucceeded r2 = new com.stepos.core.ota.domain.OtaAction$DownloadSucceeded
                java.lang.String r4 = r4.getOtaId()
                r2.<init>(r4, r10)
                r9.label = r3
                java.lang.Object r9 = r1.send(r2, r9)
                if (r9 != r0) goto Lae
                goto Lad
            L66:
                boolean r10 = r5 instanceof java.util.concurrent.CancellationException
                if (r10 == 0) goto L8b
                com.stepos.core.ota.domain.port.OtaLogger r9 = com.stepos.core.ota.domain.OtaStore.access$getLog$p(r1)
                java.lang.String r10 = r4.getOtaId()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "["
                r0.<init>(r1)
                r0.append(r10)
                java.lang.String r10 = "] download cancelled by us, keep current state"
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "OtaStore"
                r9.d(r0, r10)
                goto Lae
            L8b:
                kotlinx.coroutines.channels.Channel r10 = com.stepos.core.ota.domain.OtaStore.access$getMailbox$p(r1)
                com.stepos.core.ota.domain.OtaAction$DownloadFailed r1 = new com.stepos.core.ota.domain.OtaAction$DownloadFailed
                java.lang.String r3 = r4.getOtaId()
                com.stepos.core.ota.domain.OtaError$Network r4 = new com.stepos.core.ota.domain.OtaError$Network
                java.lang.String r6 = r5.getMessage()
                if (r6 != 0) goto L9f
                java.lang.String r6 = "download failed"
            L9f:
                r4.<init>(r6, r5)
                r1.<init>(r3, r4)
                r9.label = r2
                java.lang.Object r9 = r10.send(r1, r9)
                if (r9 != r0) goto Lae
            Lad:
                return r0
            Lae:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.OtaStore", f = "OtaStore.kt", l = {Content.Types.TYPE_DOUBLE_ARRAY}, m = "stop")
    /* renamed from: com.stepos.core.ota.domain.OtaStore$stop$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C04001(b<? super C04001> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaStore.this.stop(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OtaStore(CoroutineScope scope, ManifestSource manifestSource, ModelDownloadPort downloadPort, InstallPipeline installPipeline, ModelStorage storage, OtaClock clock, DownloadController downloadController, zb.a<DeviceConditions> conditions, OtaLogger log, int i10, l<? super ModelManifest, n> onManifestInstalled) {
        g.f(scope, "scope");
        g.f(manifestSource, "manifestSource");
        g.f(downloadPort, "downloadPort");
        g.f(installPipeline, "installPipeline");
        g.f(storage, "storage");
        g.f(clock, "clock");
        g.f(conditions, "conditions");
        g.f(log, "log");
        g.f(onManifestInstalled, "onManifestInstalled");
        this.scope = scope;
        this.manifestSource = manifestSource;
        this.downloadPort = downloadPort;
        this.installPipeline = installPipeline;
        this.storage = storage;
        this.clock = clock;
        this.governor = downloadController;
        this.conditions = conditions;
        this.log = log;
        this.onManifestInstalled = onManifestInstalled;
        this.mailbox = ChannelKt.Channel$default(i10, null, null, 6, null);
        this.tasks = new HashMap<>();
        this.lastLoggedProgressBucket = new HashMap<>();
        MutableStateFlow<Map<String, OtaStateSnapshot>> MutableStateFlow = StateFlowKt.MutableStateFlow(kotlin.collections.b.d0());
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceConditions _init_$lambda$0() {
        return DeviceConditions.Companion.getEMPTY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n _init_$lambda$1(ModelManifest it) {
        g.f(it, "it");
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanInstallAttemptArtifacts(List<ModelManifest> list, int i10, int i11, String str) {
        if (list.isEmpty()) {
            return;
        }
        OtaLogger otaLogger = this.log;
        int size = list.size();
        StringBuilder sbF = h0.e.f("[", str, "] clean install artifacts from index=", i10, " planSize=");
        sbF.append(size);
        otaLogger.i(TAG, sbF.toString());
        if (i10 < 0) {
            i10 = 0;
        }
        int size2 = list.size();
        while (i10 < size2) {
            ModelManifest modelManifest = list.get(i10);
            String strBucketDir = this.storage.bucketDir(modelManifest.getBaseModelId());
            this.storage.deleteDir(strBucketDir + "/" + modelManifest.getOtaId() + "-" + modelManifest.getVersion() + ".zip");
            this.storage.deleteDir(strBucketDir + "/" + modelManifest.getOtaId() + "-" + modelManifest.getVersion());
            this.storage.deleteDir(strBucketDir + "/" + modelManifest.getOtaId() + "-" + modelManifest.getVersion() + ".tmp");
            if (modelManifest.isPlugin()) {
                this.storage.setPluginVersion(modelManifest.getBaseModelId(), modelManifest.getPluginName(), 0);
            } else {
                this.storage.setInstalledVersion(modelManifest.getOtaId(), g.b(modelManifest.getOtaId(), str) ? i11 : this.storage.installedVersion(modelManifest.getOtaId()));
            }
            i10++;
        }
    }

    private final void dropUninstalledTask(String str) {
        OtaTask otaTaskRemove = this.tasks.remove(str);
        if (otaTaskRemove == null) {
            return;
        }
        Job job = otaTaskRemove.getJob();
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        otaTaskRemove.setJob(null);
        OtaTaskSnapshotStore.INSTANCE.clear(str);
        publish();
    }

    private final void fail(String str, OtaError otaError, boolean z) {
        Object next;
        int version;
        OtaTask otaTask = this.tasks.get(str);
        if (otaTask == null) {
            return;
        }
        otaTask.setJob(null);
        Iterator<T> it = otaTask.getPlan().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (g.b(((ModelManifest) next).getOtaId(), str)) {
                    break;
                }
            }
        }
        ModelManifest modelManifest = (ModelManifest) next;
        if (modelManifest != null) {
            version = modelManifest.getVersion();
        } else {
            ModelManifest currentManifest = otaTask.getCurrentManifest();
            version = currentManifest != null ? currentManifest.getVersion() : 0;
        }
        OtaFailureMarker.INSTANCE.mark(str, z, TriggerSourcePolicy.INSTANCE.isSilent(otaTask.getSources()), version);
        if (z && !otaTask.isForeground() && version > 0) {
            SilentInstallFailureStore.INSTANCE.mark(str, version);
            OtaLogger otaLogger = this.log;
            Set<TriggerSource> sources = otaTask.getSources();
            StringBuilder sbF = h0.e.f("[", str, "] silent install failed at v", version, " → blacklist re-download (source=");
            sbF.append(sources);
            sbF.append(")");
            otaLogger.w(TAG, sbF.toString());
        }
        if (z) {
            String downloadFilePath = otaTask.getDownloadFilePath();
            if (downloadFilePath != null) {
                this.storage.deleteDir(downloadFilePath);
            }
            otaTask.setDownloadFilePath(null);
            otaTask.setPausedDownloadedBytes(-1L);
            otaTask.setRestoredProgressPct(-1);
            this.downloadPort.discardEngineRecord(str);
        }
        transition(otaTask, new OtaState.Failed(otaError));
    }

    public static /* synthetic */ void fail$default(OtaStore otaStore, String str, OtaError otaError, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = OtaErrorKt.requiresCleanRedownload(otaError);
        }
        otaStore.fail(str, otaError, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handle(OtaAction otaAction, b<? super n> bVar) {
        if (otaAction instanceof OtaAction.CheckUpdate) {
            onCheckUpdate((OtaAction.CheckUpdate) otaAction);
        } else if (otaAction instanceof OtaAction.Download) {
            onDownload((OtaAction.Download) otaAction);
        } else {
            if (otaAction instanceof OtaAction.Pause) {
                Object objOnPause = onPause((OtaAction.Pause) otaAction, bVar);
                return objOnPause == CoroutineSingletons.f10059a ? objOnPause : n.f10413a;
            }
            if (otaAction instanceof OtaAction.Resume) {
                onResume((OtaAction.Resume) otaAction);
            } else {
                if (otaAction instanceof OtaAction.Cancel) {
                    Object objOnCancel = onCancel((OtaAction.Cancel) otaAction, bVar);
                    return objOnCancel == CoroutineSingletons.f10059a ? objOnCancel : n.f10413a;
                }
                if (otaAction instanceof OtaAction.RestorePaused) {
                    onRestorePaused((OtaAction.RestorePaused) otaAction);
                } else {
                    if (otaAction instanceof OtaAction.Detach) {
                        Object objOnDetach = onDetach((OtaAction.Detach) otaAction, bVar);
                        return objOnDetach == CoroutineSingletons.f10059a ? objOnDetach : n.f10413a;
                    }
                    if (otaAction instanceof OtaAction.Attach) {
                        onAttach((OtaAction.Attach) otaAction);
                    } else {
                        if (otaAction instanceof OtaAction.ConditionsChanged) {
                            Object objOnConditionsChanged = onConditionsChanged(bVar);
                            return objOnConditionsChanged == CoroutineSingletons.f10059a ? objOnConditionsChanged : n.f10413a;
                        }
                        if (otaAction instanceof OtaAction.ManifestResolved) {
                            onManifestResolved((OtaAction.ManifestResolved) otaAction);
                        } else if (otaAction instanceof OtaAction.ProgressUpdated) {
                            onProgress((OtaAction.ProgressUpdated) otaAction);
                        } else if (otaAction instanceof OtaAction.DownloadSucceeded) {
                            onDownloadSucceeded((OtaAction.DownloadSucceeded) otaAction);
                        } else if (otaAction instanceof OtaAction.DownloadFailed) {
                            OtaAction.DownloadFailed downloadFailed = (OtaAction.DownloadFailed) otaAction;
                            fail$default(this, downloadFailed.getOtaId(), downloadFailed.getError(), false, 4, null);
                        } else if (otaAction instanceof OtaAction.InstallSucceeded) {
                            onInstallSucceeded((OtaAction.InstallSucceeded) otaAction);
                        } else {
                            if (!(otaAction instanceof OtaAction.InstallFailed)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            OtaAction.InstallFailed installFailed = (OtaAction.InstallFailed) otaAction;
                            fail(installFailed.getOtaId(), installFailed.getError(), true);
                        }
                    }
                }
            }
        }
        return n.f10413a;
    }

    private final void launchInstall(OtaTask otaTask, ModelManifest modelManifest, String str) {
        otaTask.setJob(BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(modelManifest, str, this, otaTask, null), 3, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void launchPlan(java.lang.String r13, boolean r14) {
        /*
            r12 = this;
            java.util.HashMap<java.lang.String, com.stepos.core.ota.domain.OtaStore$OtaTask> r0 = r12.tasks
            java.lang.Object r0 = r0.get(r13)
            com.stepos.core.ota.domain.OtaStore$OtaTask r0 = (com.stepos.core.ota.domain.OtaStore.OtaTask) r0
            if (r0 == 0) goto L18
            java.util.Set r3 = r0.getPlugins()
            if (r3 == 0) goto L18
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Set r3 = kotlin.collections.a.R0(r3)
            if (r3 != 0) goto L1a
        L18:
            kotlin.collections.EmptySet r3 = kotlin.collections.EmptySet.f10003a
        L1a:
            if (r14 == 0) goto L26
            if (r0 == 0) goto L23
            java.util.List r0 = r0.getPlan()
            goto L24
        L23:
            r0 = 0
        L24:
            if (r0 != 0) goto L28
        L26:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.f10001a
        L28:
            r5 = r0
            kotlinx.coroutines.CoroutineScope r7 = r12.scope
            com.stepos.core.ota.domain.OtaStore$launchPlan$1 r0 = new com.stepos.core.ota.domain.OtaStore$launchPlan$1
            r6 = 0
            r1 = r12
            r2 = r13
            r4 = r14
            r0.<init>(r2, r3, r4, r5, r6)
            r10 = 3
            r11 = 0
            r6 = r7
            r7 = 0
            r8 = 0
            r9 = r0
            kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.launchPlan(java.lang.String, boolean):void");
    }

    public static /* synthetic */ void launchPlan$default(OtaStore otaStore, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        otaStore.launchPlan(str, z);
    }

    private final void onAttach(OtaAction.Attach attach) {
        OtaTask otaTask = this.tasks.get(attach.getOtaId());
        if (otaTask == null || otaTask.getSources().contains(attach.getSource())) {
            return;
        }
        otaTask.getSources().add(attach.getSource());
        if (attach.getSource() == TriggerSource.USER) {
            NotificationCancelSuppressStore.INSTANCE.clear(attach.getOtaId());
        }
        otaTask.recomputePrimary();
        this.log.i(TAG, "[" + attach.getOtaId() + "] attach source=" + attach.getSource() + " primary=" + otaTask.getPrimarySource() + " state=" + i.a(otaTask.getState().getClass()).c());
        publish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onCancel(com.stepos.core.ota.domain.OtaAction.Cancel r6, qb.b<? super lb.n> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ota.domain.OtaStore.C03931
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ota.domain.OtaStore$onCancel$1 r0 = (com.stepos.core.ota.domain.OtaStore.C03931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.OtaStore$onCancel$1 r0 = new com.stepos.core.ota.domain.OtaStore$onCancel$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$2
            com.stepos.core.ota.domain.OtaStore$OtaTask r5 = (com.stepos.core.ota.domain.OtaStore.OtaTask) r5
            java.lang.Object r6 = r0.L$1
            com.stepos.core.ota.domain.OtaAction$Cancel r6 = (com.stepos.core.ota.domain.OtaAction.Cancel) r6
            java.lang.Object r0 = r0.L$0
            com.stepos.core.ota.domain.OtaStore r0 = (com.stepos.core.ota.domain.OtaStore) r0
            kotlin.c.b(r7)
            goto L6c
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.c.b(r7)
            java.util.HashMap<java.lang.String, com.stepos.core.ota.domain.OtaStore$OtaTask> r7 = r5.tasks
            java.lang.String r2 = r6.getOtaId()
            java.lang.Object r7 = r7.get(r2)
            com.stepos.core.ota.domain.OtaStore$OtaTask r7 = (com.stepos.core.ota.domain.OtaStore.OtaTask) r7
            if (r7 == 0) goto L72
            com.stepos.core.ota.domain.port.ModelDownloadPort r2 = r5.downloadPort
            java.lang.String r4 = r6.getOtaId()
            r2.cancel(r4)
            kotlinx.coroutines.Job r2 = r7.getJob()
            if (r2 == 0) goto L6e
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r0)
            if (r0 != r1) goto L6a
            return r1
        L6a:
            r0 = r5
            r5 = r7
        L6c:
            r7 = r5
            r5 = r0
        L6e:
            r0 = 0
            r7.setJob(r0)
        L72:
            com.stepos.core.ota.domain.port.ModelDownloadPort r0 = r5.downloadPort
            java.lang.String r1 = r6.getOtaId()
            r0.discardEngineRecord(r1)
            com.stepos.core.ota.storage.OtaFailureMarker r0 = com.stepos.core.ota.storage.OtaFailureMarker.INSTANCE
            java.lang.String r1 = r6.getOtaId()
            r0.clear(r1)
            com.stepos.core.ota.storage.OtaTaskSnapshotStore r0 = com.stepos.core.ota.storage.OtaTaskSnapshotStore.INSTANCE
            java.lang.String r1 = r6.getOtaId()
            r0.clear(r1)
            if (r7 != 0) goto L97
            java.lang.String r7 = r6.getOtaId()
            com.stepos.core.ota.domain.OtaStore$OtaTask r7 = r5.task(r7)
        L97:
            com.stepos.core.ota.domain.OtaState$Removed r0 = com.stepos.core.ota.domain.OtaState.Removed.INSTANCE
            r5.transition(r7, r0)
            java.util.HashMap<java.lang.String, com.stepos.core.ota.domain.OtaStore$OtaTask> r7 = r5.tasks
            java.lang.String r6 = r6.getOtaId()
            r7.remove(r6)
            r5.publish()
            lb.n r5 = lb.n.f10413a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.onCancel(com.stepos.core.ota.domain.OtaAction$Cancel, qb.b):java.lang.Object");
    }

    private final void onCheckUpdate(OtaAction.CheckUpdate checkUpdate) {
        if (checkUpdate.getSource() != TriggerSource.USER && !UserUninstallPolicy.INSTANCE.allowBackgroundDownload(UserUninstallStore.INSTANCE.contains(checkUpdate.getOtaId()))) {
            this.log.i(TAG, "[" + checkUpdate.getOtaId() + "] checkUpdate refused: user uninstalled, source=" + checkUpdate.getSource());
            return;
        }
        OtaTask otaTaskTask = task(checkUpdate.getOtaId());
        otaTaskTask.dropSettledRoundSignature();
        otaTaskTask.getSources().add(checkUpdate.getSource());
        otaTaskTask.recomputePrimary();
        if (!otaTaskTask.getState().isActive()) {
            otaTaskTask.setWantsDownload(false);
            transition(otaTaskTask, OtaState.Checking.INSTANCE);
            launchPlan$default(this, checkUpdate.getOtaId(), false, 2, null);
            return;
        }
        this.log.d(TAG, "[" + checkUpdate.getOtaId() + "] checkUpdate ignored, already active primary=" + otaTaskTask.getPrimarySource());
        publish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onConditionsChanged(qb.b<? super lb.n> r15) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.onConditionsChanged(qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onDetach(OtaAction.Detach detach, b<? super n> bVar) {
        OtaTask otaTask = this.tasks.get(detach.getOtaId());
        if (otaTask == null) {
            return n.f10413a;
        }
        otaTask.getClientTags().remove(detach.getClientTag());
        if (!otaTask.getClientTags().isEmpty()) {
            return n.f10413a;
        }
        OtaState state = otaTask.getState();
        if (!(state instanceof OtaState.Queued) && !(state instanceof OtaState.Checking) && !(state instanceof OtaState.Downloading)) {
            this.log.d(TAG, h0.e.c("[", detach.getOtaId(), "] refCount=0 but in ", i.a(otaTask.getState().getClass()).c(), ", let finish"));
            return n.f10413a;
        }
        this.log.i(TAG, "[" + detach.getOtaId() + "] refCount=0, cancelling in-flight download");
        Object objOnCancel = onCancel(new OtaAction.Cancel(detach.getOtaId()), bVar);
        return objOnCancel == CoroutineSingletons.f10059a ? objOnCancel : n.f10413a;
    }

    private final void onDownload(OtaAction.Download download) {
        TriggerSource source = download.getSource();
        TriggerSource triggerSource = TriggerSource.USER;
        if (source == triggerSource) {
            NotificationCancelSuppressStore.INSTANCE.clear(download.getOtaId());
            UserUninstallStore.INSTANCE.clearAll(x.V(OtaBucketLegacy.INSTANCE.allBucketIds(download.getOtaId()), download.getOtaId()));
            SilentInstallFailureStore.INSTANCE.clear(download.getOtaId());
        } else if (!UserUninstallPolicy.INSTANCE.allowBackgroundDownload(UserUninstallStore.INSTANCE.contains(download.getOtaId()))) {
            this.log.w(TAG, "[" + download.getOtaId() + "] download refused: user uninstalled, source=" + download.getSource());
            dropUninstalledTask(download.getOtaId());
            return;
        }
        OtaTask otaTaskTask = task(download.getOtaId());
        otaTaskTask.dropSettledRoundSignature();
        otaTaskTask.getSources().add(download.getSource());
        q.g0(otaTaskTask.getPlugins(), download.getPlugins());
        if (download.getCellularAllowed()) {
            otaTaskTask.setCellularAllowed(true);
        }
        String clientTag = download.getClientTag();
        if (clientTag != null) {
            otaTaskTask.getClientTags().add(clientTag);
        }
        otaTaskTask.setRecoveredAfterInterruption(false);
        otaTaskTask.recomputePrimary();
        if (download.getSource() != triggerSource && TriggerSourcePolicy.INSTANCE.isUserHeld(otaTaskTask.getSources(), otaTaskTask.getState())) {
            this.log.i(TAG, "[" + download.getOtaId() + "] bg source=" + download.getSource() + " on in-flight foreground task → attach-only (Part3)");
            publish();
            return;
        }
        if (otaTaskTask.getState().isActive()) {
            if (TriggerSourcePolicy.INSTANCE.shouldPreempt(otaTaskTask.getPrimarySource(), download.getSource())) {
                this.log.i(TAG, "[" + download.getOtaId() + "] preempt " + otaTaskTask.getPrimarySource() + " <- " + download.getSource());
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03951(otaTaskTask, null), 3, null);
                return;
            }
            this.log.d(TAG, "[" + download.getOtaId() + "] download attach source=" + download.getSource() + " primary=" + otaTaskTask.getPrimarySource());
            publish();
            return;
        }
        if ((otaTaskTask.getState() instanceof OtaState.Paused) && TriggerSourcePolicy.INSTANCE.shouldPreempt(otaTaskTask.getPrimarySource(), download.getSource())) {
            otaTaskTask.setWantsDownload(true);
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(otaTaskTask, null), 3, null);
            return;
        }
        DownloadController downloadController = this.governor;
        if (downloadController != null) {
            DeviceConditions deviceConditionsInvoke = this.conditions.invoke();
            TriggerSource primarySource = otaTaskTask.getPrimarySource();
            if (primarySource == null) {
                primarySource = download.getSource();
            }
            DownloadVerdict downloadVerdictDecide = downloadController.decide(deviceConditionsInvoke, primarySource);
            this.log.i(TAG, ai.onnxruntime.a.l("[", download.getOtaId(), "] admission: ", downloadVerdictDecide.describe()));
            if (downloadVerdictDecide.isStop()) {
                otaTaskTask.setWantsDownload(true);
                PauseReason reason = downloadVerdictDecide.getReason();
                if (reason == null) {
                    reason = PauseReason.THERMAL;
                }
                transition(otaTaskTask, new OtaState.Paused(reason, 0));
                return;
            }
        }
        otaTaskTask.setWantsDownload(true);
        OtaState state = otaTaskTask.getState();
        if (download.getSource() == triggerSource && !(state instanceof OtaState.Paused) && OtaFailureMarker.INSTANCE.isMarked(download.getOtaId())) {
            retryAfterInstallFailure(otaTaskTask);
            return;
        }
        OtaState.Failed failed = state instanceof OtaState.Failed ? (OtaState.Failed) state : null;
        if (failed != null) {
            if (download.getSource() == triggerSource || OtaErrorKt.requiresCleanRedownload(failed.getError())) {
                retryAfterInstallFailure(otaTaskTask);
                return;
            } else {
                retryAfterDownloadFailure(otaTaskTask);
                return;
            }
        }
        if ((state instanceof OtaState.Paused) && !otaTaskTask.getPlan().isEmpty() && otaTaskTask.getPlanIndex() < otaTaskTask.getPlan().size()) {
            startNext(otaTaskTask);
        } else {
            transition(otaTaskTask, OtaState.Checking.INSTANCE);
            launchPlan(download.getOtaId(), download.getSource() == triggerSource);
        }
    }

    private final void onDownloadSucceeded(OtaAction.DownloadSucceeded downloadSucceeded) {
        OtaTask otaTask = this.tasks.get(downloadSucceeded.getOtaId());
        if (otaTask != null && g.b(downloadSucceeded.getFilePath(), otaTask.getDownloadFilePath())) {
            ModelManifest currentManifest = otaTask.getCurrentManifest();
            if (currentManifest == null) {
                fail$default(this, downloadSucceeded.getOtaId(), new OtaError.Unknown(downloadSucceeded.getOtaId(), new IllegalStateException("manifest lost")), false, 4, null);
            } else {
                transition(otaTask, OtaState.Installing.INSTANCE);
                launchInstall(otaTask, currentManifest, downloadSucceeded.getFilePath());
            }
        }
    }

    private final void onInstallSucceeded(OtaAction.InstallSucceeded installSucceeded) {
        Object objA;
        OtaTask otaTask = this.tasks.get(installSucceeded.getOtaId());
        if (otaTask == null) {
            return;
        }
        ModelManifest currentManifest = otaTask.getCurrentManifest();
        if (currentManifest != null) {
            long doneBytes = otaTask.getDoneBytes();
            long sizeBytes = currentManifest.getSizeBytes();
            if (sizeBytes < 0) {
                sizeBytes = 0;
            }
            otaTask.setDoneBytes(doneBytes + sizeBytes);
            if (g.b(currentManifest.getOtaId(), otaTask.getOtaId())) {
                otaTask.setInstalledVersion(currentManifest.getVersion());
            }
            try {
                this.onManifestInstalled.invoke(currentManifest);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                this.log.e(TAG, a0.a.k("[", currentManifest.getOtaId(), "] record installed display meta failed"), thB);
            }
        }
        otaTask.setDownloadFilePath(null);
        otaTask.setPlanIndex(otaTask.getPlanIndex() + 1);
        if (otaTask.getPlanIndex() < otaTask.getPlan().size()) {
            startNext(otaTask);
            return;
        }
        otaTask.setJob(null);
        int installedVersion = otaTask.getInstalledVersion() > 0 ? otaTask.getInstalledVersion() : installSucceeded.getVersion();
        OtaFailureMarker.INSTANCE.clear(otaTask.getOtaId());
        SilentInstallFailureStore.INSTANCE.clear(otaTask.getOtaId());
        this.downloadPort.discardEngineRecord(otaTask.getOtaId());
        transition(otaTask, new OtaState.Installed(installedVersion));
    }

    private final void onManifestResolved(OtaAction.ManifestResolved manifestResolved) {
        OtaTask otaTask = this.tasks.get(manifestResolved.getOtaId());
        if (otaTask == null) {
            return;
        }
        otaTask.setInstalledVersion(this.storage.installedVersion(manifestResolved.getOtaId()));
        otaTask.setPlan(manifestResolved.getManifests());
        otaTask.setPlanIndex(0);
        Iterator<T> it = manifestResolved.getManifests().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            long sizeBytes = ((ModelManifest) it.next()).getSizeBytes();
            if (sizeBytes < 0) {
                sizeBytes = 0;
            }
            j10 += sizeBytes;
        }
        otaTask.setTotalBytesAll(j10);
        otaTask.setDoneBytes(0L);
        if (!manifestResolved.getManifests().isEmpty()) {
            if (otaTask.getWantsDownload()) {
                startNext(otaTask);
                return;
            } else {
                settleIdle(otaTask);
                return;
            }
        }
        if (otaTask.getWantsDownload() && otaTask.getPrimarySource() == TriggerSource.USER) {
            fail$default(this, manifestResolved.getOtaId(), new OtaError.ManifestEmpty(manifestResolved.getOtaId()), false, 4, null);
        } else {
            settleIdle(otaTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onPause(com.stepos.core.ota.domain.OtaAction.Pause r6, qb.b<? super lb.n> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ota.domain.OtaStore.C03961
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ota.domain.OtaStore$onPause$1 r0 = (com.stepos.core.ota.domain.OtaStore.C03961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.OtaStore$onPause$1 r0 = new com.stepos.core.ota.domain.OtaStore$onPause$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$2
            com.stepos.core.ota.domain.OtaStore$OtaTask r5 = (com.stepos.core.ota.domain.OtaStore.OtaTask) r5
            java.lang.Object r6 = r0.L$1
            com.stepos.core.ota.domain.OtaAction$Pause r6 = (com.stepos.core.ota.domain.OtaAction.Pause) r6
            java.lang.Object r0 = r0.L$0
            com.stepos.core.ota.domain.OtaStore r0 = (com.stepos.core.ota.domain.OtaStore) r0
            kotlin.c.b(r7)
            goto L85
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.c.b(r7)
            java.util.HashMap<java.lang.String, com.stepos.core.ota.domain.OtaStore$OtaTask> r7 = r5.tasks
            java.lang.String r2 = r6.getOtaId()
            java.lang.Object r7 = r7.get(r2)
            com.stepos.core.ota.domain.OtaStore$OtaTask r7 = (com.stepos.core.ota.domain.OtaStore.OtaTask) r7
            if (r7 != 0) goto L4f
            lb.n r5 = lb.n.f10413a
            return r5
        L4f:
            com.stepos.core.ota.domain.PauseReason r2 = r6.getReason()
            com.stepos.core.ota.domain.PauseReason r4 = com.stepos.core.ota.domain.PauseReason.USER
            if (r2 != r4) goto L65
            java.util.Set r2 = r7.getSources()
            java.util.Collection r2 = (java.util.Collection) r2
            com.stepos.core.ota.domain.TriggerSource r4 = com.stepos.core.ota.domain.TriggerSource.USER
            r2.add(r4)
            r7.recomputePrimary()
        L65:
            com.stepos.core.ota.domain.port.ModelDownloadPort r2 = r5.downloadPort
            java.lang.String r4 = r6.getOtaId()
            r2.cancel(r4)
            kotlinx.coroutines.Job r2 = r7.getJob()
            if (r2 == 0) goto L87
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r0)
            if (r0 != r1) goto L83
            return r1
        L83:
            r0 = r5
            r5 = r7
        L85:
            r7 = r5
            r5 = r0
        L87:
            r0 = 0
            r7.setJob(r0)
            com.stepos.core.ota.domain.OtaState r1 = r7.getState()
            boolean r2 = r1 instanceof com.stepos.core.ota.domain.OtaState.Downloading
            if (r2 == 0) goto L96
            com.stepos.core.ota.domain.OtaState$Downloading r1 = (com.stepos.core.ota.domain.OtaState.Downloading) r1
            goto L97
        L96:
            r1 = r0
        L97:
            if (r1 == 0) goto La0
            long r2 = r1.getDownloadedBytes()
            r7.setPausedDownloadedBytes(r2)
        La0:
            if (r1 == 0) goto La7
            int r0 = r1.getProgress()
            goto Lba
        La7:
            com.stepos.core.ota.domain.OtaState r1 = r7.getState()
            boolean r2 = r1 instanceof com.stepos.core.ota.domain.OtaState.Paused
            if (r2 == 0) goto Lb2
            r0 = r1
            com.stepos.core.ota.domain.OtaState$Paused r0 = (com.stepos.core.ota.domain.OtaState.Paused) r0
        Lb2:
            if (r0 == 0) goto Lb9
            int r0 = r0.getProgress()
            goto Lba
        Lb9:
            r0 = 0
        Lba:
            com.stepos.core.ota.domain.OtaState$Paused r1 = new com.stepos.core.ota.domain.OtaState$Paused
            com.stepos.core.ota.domain.PauseReason r6 = r6.getReason()
            r1.<init>(r6, r0)
            r5.transition(r7, r1)
            lb.n r5 = lb.n.f10413a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.onPause(com.stepos.core.ota.domain.OtaAction$Pause, qb.b):java.lang.Object");
    }

    private final void onProgress(OtaAction.ProgressUpdated progressUpdated) {
        OtaTask otaTask = this.tasks.get(progressUpdated.getOtaId());
        if (otaTask != null && (otaTask.getState() instanceof OtaState.Downloading)) {
            if (progressUpdated.getFilePath() == null || g.b(progressUpdated.getFilePath(), otaTask.getDownloadFilePath())) {
                long totalBytesAll = otaTask.getTotalBytesAll() > 0 ? otaTask.getTotalBytesAll() : progressUpdated.getTotalBytes();
                long downloadedBytes = progressUpdated.getDownloadedBytes() + otaTask.getDoneBytes();
                OtaState state = otaTask.getState();
                OtaState.Downloading downloading = state instanceof OtaState.Downloading ? (OtaState.Downloading) state : null;
                transition(otaTask, new OtaState.Downloading(Math.max(downloadedBytes, downloading != null ? downloading.getDownloadedBytes() : 0L), totalBytesAll));
            }
        }
    }

    private final void onRestorePaused(OtaAction.RestorePaused restorePaused) {
        if (!UserUninstallPolicy.INSTANCE.allowBackgroundDownload(UserUninstallStore.INSTANCE.contains(restorePaused.getOtaId()))) {
            this.log.i(TAG, "[" + restorePaused.getOtaId() + "] restorePaused skipped: user uninstalled");
            OtaTaskSnapshotStore.INSTANCE.clear(restorePaused.getOtaId());
            dropUninstalledTask(restorePaused.getOtaId());
            return;
        }
        OtaTask otaTaskTask = task(restorePaused.getOtaId());
        if (otaTaskTask.getState().isActive()) {
            return;
        }
        otaTaskTask.setWantsDownload(true);
        q.g0(otaTaskTask.getSources(), restorePaused.getSources());
        otaTaskTask.setCellularAllowed(restorePaused.getCellularAllowed());
        otaTaskTask.setRecoveredAfterInterruption(restorePaused.getReason() == PauseReason.INTERRUPTED);
        otaTaskTask.recomputePrimary();
        otaTaskTask.setRestoredProgressPct(restorePaused.getProgress());
        transition(otaTaskTask, new OtaState.Paused(restorePaused.getReason(), restorePaused.getProgress()));
    }

    private final void onResume(OtaAction.Resume resume) {
        OtaTask otaTask = this.tasks.get(resume.getOtaId());
        if (otaTask == null) {
            return;
        }
        if (!(otaTask.getState() instanceof OtaState.Failed)) {
            if (otaTask.getState() instanceof OtaState.Paused) {
                otaTask.setWantsDownload(true);
                otaTask.getSources().add(resume.getSource());
                if (resume.getSource() == TriggerSource.USER) {
                    NotificationCancelSuppressStore.INSTANCE.clear(resume.getOtaId());
                }
                otaTask.recomputePrimary();
                if (!otaTask.getPlan().isEmpty() && otaTask.getPlanIndex() < otaTask.getPlan().size()) {
                    startNext(otaTask);
                    return;
                } else {
                    transition(otaTask, OtaState.Checking.INSTANCE);
                    launchPlan$default(this, resume.getOtaId(), false, 2, null);
                    return;
                }
            }
            return;
        }
        OtaState state = otaTask.getState();
        g.d(state, "null cannot be cast to non-null type com.stepos.core.ota.domain.OtaState.Failed");
        OtaError error = ((OtaState.Failed) state).getError();
        otaTask.setWantsDownload(true);
        otaTask.getSources().add(resume.getSource());
        TriggerSource source = resume.getSource();
        TriggerSource triggerSource = TriggerSource.USER;
        if (source == triggerSource) {
            NotificationCancelSuppressStore.INSTANCE.clear(resume.getOtaId());
        }
        otaTask.recomputePrimary();
        if (resume.getSource() == triggerSource || OtaErrorKt.requiresCleanRedownload(error)) {
            retryAfterInstallFailure(otaTask);
        } else {
            retryAfterDownloadFailure(otaTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object preemptAndRestart(com.stepos.core.ota.domain.OtaStore.OtaTask r5, qb.b<? super lb.n> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ota.domain.OtaStore.C03971
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ota.domain.OtaStore$preemptAndRestart$1 r0 = (com.stepos.core.ota.domain.OtaStore.C03971) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.OtaStore$preemptAndRestart$1 r0 = new com.stepos.core.ota.domain.OtaStore$preemptAndRestart$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.stepos.core.ota.domain.OtaStore$OtaTask r5 = (com.stepos.core.ota.domain.OtaStore.OtaTask) r5
            java.lang.Object r4 = r0.L$0
            com.stepos.core.ota.domain.OtaStore r4 = (com.stepos.core.ota.domain.OtaStore) r4
            kotlin.c.b(r6)
            goto L57
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.c.b(r6)
            com.stepos.core.ota.domain.port.ModelDownloadPort r6 = r4.downloadPort
            java.lang.String r2 = r5.getOtaId()
            r6.cancel(r2)
            kotlinx.coroutines.Job r6 = r5.getJob()
            if (r6 == 0) goto L57
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.JobKt.cancelAndJoin(r6, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            r6 = 0
            r5.setJob(r6)
            r5.setWantsDownload(r3)
            r5.recomputePrimary()
            com.stepos.core.ota.domain.OtaState$Checking r0 = com.stepos.core.ota.domain.OtaState.Checking.INSTANCE
            r4.transition(r5, r0)
            java.lang.String r5 = r5.getOtaId()
            r0 = 0
            r1 = 2
            launchPlan$default(r4, r5, r0, r1, r6)
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.preemptAndRestart(com.stepos.core.ota.domain.OtaStore$OtaTask, qb.b):java.lang.Object");
    }

    private final void publish() {
        MutableStateFlow<Map<String, OtaStateSnapshot>> mutableStateFlow = this._state;
        Collection<OtaTask> collectionValues = this.tasks.values();
        g.e(collectionValues, "<get-values>(...)");
        Collection<OtaTask> collection = collectionValues;
        int iA0 = v.a0(m.Z(collection, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (OtaTask otaTask : collection) {
            linkedHashMap.put(otaTask.getOtaId(), snapshot(otaTask));
        }
        mutableStateFlow.setValue(linkedHashMap);
    }

    private final void recomputeGlobalRate() {
        DownloadController downloadController = this.governor;
        if (downloadController == null) {
            return;
        }
        DeviceConditions deviceConditionsInvoke = this.conditions.invoke();
        long maxRateBytesPerSec = Long.MAX_VALUE;
        for (OtaTask otaTask : this.tasks.values()) {
            g.e(otaTask, "next(...)");
            OtaTask otaTask2 = otaTask;
            if (otaTask2.getState().isActive()) {
                TriggerSource primarySource = otaTask2.getPrimarySource();
                if (primarySource == null) {
                    primarySource = TriggerSource.SILENT;
                }
                DownloadVerdict downloadVerdictDecide = downloadController.decide(deviceConditionsInvoke, primarySource);
                if (downloadVerdictDecide.isThrottled()) {
                    long maxRateBytesPerSec2 = downloadVerdictDecide.getMaxRateBytesPerSec();
                    if (1 <= maxRateBytesPerSec2 && maxRateBytesPerSec2 < maxRateBytesPerSec) {
                        maxRateBytesPerSec = downloadVerdictDecide.getMaxRateBytesPerSec();
                    }
                }
            }
        }
        ModelDownloadPort modelDownloadPort = this.downloadPort;
        if (maxRateBytesPerSec == Long.MAX_VALUE) {
            maxRateBytesPerSec = 0;
        }
        modelDownloadPort.setRate(maxRateBytesPerSec);
    }

    private final void retryAfterDownloadFailure(OtaTask otaTask) {
        this.log.i(TAG, "[" + otaTask.getOtaId() + "] retry after download failure, resume partial");
        if (!otaTask.getPlan().isEmpty() && otaTask.getPlanIndex() < otaTask.getPlan().size()) {
            startNext(otaTask);
        } else {
            transition(otaTask, OtaState.Checking.INSTANCE);
            launchPlan(otaTask.getOtaId(), false);
        }
    }

    private final void retryAfterInstallFailure(OtaTask otaTask) {
        String otaId = otaTask.getOtaId();
        List listO0 = kotlin.collections.a.O0(otaTask.getPlan());
        int planIndex = otaTask.getPlanIndex();
        int installedVersion = otaTask.getInstalledVersion();
        String downloadFilePath = otaTask.getDownloadFilePath();
        otaTask.setPlanIndex(0);
        otaTask.setDoneBytes(0L);
        otaTask.setTotalBytesAll(0L);
        otaTask.setPausedDownloadedBytes(-1L);
        otaTask.setRestoredProgressPct(-1);
        otaTask.setDownloadFilePath(null);
        otaTask.setFreshDownload(true);
        transition(otaTask, OtaState.Checking.INSTANCE);
        otaTask.setJob(BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03981(downloadFilePath, this, listO0, planIndex, installedVersion, otaId, otaTask, null), 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendResolvedPlan(String str, Object obj, List<ModelManifest> list, boolean z, b<? super n> bVar) {
        ModelManifest modelManifestCached = this.manifestSource.cached(str);
        List<ModelManifest> listP = null;
        if (modelManifestCached != null) {
            if (gc.q.t0(modelManifestCached.getUrl())) {
                modelManifestCached = null;
            }
            if (modelManifestCached != null) {
                listP = b1.P(modelManifestCached);
            }
        }
        if (listP == null) {
            listP = EmptyList.f10001a;
        }
        Throwable thB = Result.b(obj);
        if (thB == null) {
            List<ModelManifest> list2 = (List) obj;
            if (z) {
                DownloadPlanFallback downloadPlanFallback = DownloadPlanFallback.INSTANCE;
                List<ModelManifest> listResolve = downloadPlanFallback.resolve(list2, list, listP);
                if (!downloadPlanFallback.hasUsableUrl(list2) && downloadPlanFallback.hasUsableUrl(listResolve)) {
                    this.log.w(TAG, "[" + str + "] no latest url, fallback to last download url");
                }
                list2 = listResolve;
            }
            Object objSend = this.mailbox.send(new OtaAction.ManifestResolved(str, list2), bVar);
            if (objSend == CoroutineSingletons.f10059a) {
                return objSend;
            }
        } else {
            List<ModelManifest> listResolve2 = z ? DownloadPlanFallback.INSTANCE.resolve(EmptyList.f10001a, list, listP) : EmptyList.f10001a;
            if (DownloadPlanFallback.INSTANCE.hasUsableUrl(listResolve2)) {
                this.log.w(TAG, h0.e.c("[", str, "] plan failed (", thB.getMessage(), "), fallback to last download url"));
                Object objSend2 = this.mailbox.send(new OtaAction.ManifestResolved(str, listResolve2), bVar);
                if (objSend2 == CoroutineSingletons.f10059a) {
                    return objSend2;
                }
            } else {
                Channel<OtaAction> channel = this.mailbox;
                String message = thB.getMessage();
                if (message == null) {
                    message = "plan failed";
                }
                Object objSend3 = channel.send(new OtaAction.DownloadFailed(str, new OtaError.Network(message, thB)), bVar);
                if (objSend3 == CoroutineSingletons.f10059a) {
                    return objSend3;
                }
            }
        }
        return n.f10413a;
    }

    public static /* synthetic */ Object sendResolvedPlan$default(OtaStore otaStore, String str, Object obj, List list, boolean z, b bVar, int i10, Object obj2) {
        if ((i10 & 8) != 0) {
            z = true;
        }
        return otaStore.sendResolvedPlan(str, obj, list, z, bVar);
    }

    private final void settleIdle(OtaTask otaTask) {
        transition(otaTask, otaTask.getInstalledVersion() > 0 ? new OtaState.Installed(otaTask.getInstalledVersion()) : OtaState.Idle.INSTANCE);
    }

    private final boolean shouldLogTransition(String str, OtaState otaState, OtaState otaState2) {
        if (!(otaState instanceof OtaState.Downloading) || !(otaState2 instanceof OtaState.Downloading)) {
            if (!(otaState2 instanceof OtaState.Downloading)) {
                this.lastLoggedProgressBucket.remove(str);
            }
            return (otaState.getClass() == otaState2.getClass() && otaState.equals(otaState2)) ? false : true;
        }
        OtaState.Downloading downloading = (OtaState.Downloading) otaState2;
        int progress = downloading.getProgress() / 5;
        Integer num = this.lastLoggedProgressBucket.get(str);
        int iIntValue = num != null ? num.intValue() : -1;
        if (downloading.getProgress() < 100 && progress <= iIntValue) {
            return false;
        }
        this.lastLoggedProgressBucket.put(str, Integer.valueOf(progress));
        return true;
    }

    private final OtaStateSnapshot snapshot(OtaTask otaTask) {
        int restoredProgressPct;
        OtaState state = otaTask.getState();
        if (state instanceof OtaState.Downloading) {
            restoredProgressPct = ((OtaState.Downloading) state).getProgress();
        } else if (state instanceof OtaState.Paused) {
            restoredProgressPct = ((OtaState.Paused) state).getProgress();
        } else if (state instanceof OtaState.Installed) {
            restoredProgressPct = 100;
        } else {
            restoredProgressPct = otaTask.getRestoredProgressPct();
            if (restoredProgressPct < 0) {
                restoredProgressPct = 0;
            }
        }
        return new OtaStateSnapshot(otaTask.getOtaId(), otaTask.getState(), restoredProgressPct, otaTask.getInstalledVersion(), otaTask.getUpdatedAtMs(), kotlin.collections.a.R0(otaTask.getSources()), otaTask.getPrimarySource(), otaTask.getCellularAllowed(), otaTask.getRecoveredAfterInterruption(), otaTask.getWantsDownload());
    }

    private final void startNext(OtaTask otaTask) {
        long doneBytes;
        ModelManifest currentManifest = otaTask.getCurrentManifest();
        if (currentManifest == null) {
            otaTask.setJob(null);
            transition(otaTask, new OtaState.Installed(otaTask.getInstalledVersion()));
            return;
        }
        String strBucketDir = this.storage.bucketDir(currentManifest.getBaseModelId());
        String strFindResumeFile = strBucketDir + "/" + currentManifest.getOtaId() + "-" + currentManifest.getVersion() + ".zip";
        if (otaTask.getFreshDownload()) {
            strFindResumeFile = strBucketDir + "/" + currentManifest.getOtaId() + "-" + currentManifest.getVersion() + "-retry-" + UUID.randomUUID() + ".zip";
        } else if (otaTask.getDownloadFilePath() != null) {
            strFindResumeFile = otaTask.getDownloadFilePath();
            g.c(strFindResumeFile);
        } else if (otaTask.getRestoredProgressPct() >= 0) {
            strFindResumeFile = this.downloadPort.findResumeFile(otaTask.getOtaId(), strFindResumeFile);
        }
        String str = strFindResumeFile;
        otaTask.setDownloadFilePath(str);
        otaTask.setFreshDownload(false);
        Long lQueryPartialDownloadedBytes = this.downloadPort.queryPartialDownloadedBytes(otaTask.getOtaId(), str);
        if (otaTask.getPausedDownloadedBytes() >= 0) {
            doneBytes = h.b0(otaTask.getPausedDownloadedBytes(), otaTask.getDoneBytes(), otaTask.getTotalBytesAll() > 0 ? otaTask.getTotalBytesAll() : otaTask.getPausedDownloadedBytes());
        } else {
            int restoredProgressPct = otaTask.getRestoredProgressPct();
            if (1 <= restoredProgressPct && restoredProgressPct < 101 && otaTask.getTotalBytesAll() > 0) {
                doneBytes = h.b0(Math.max(((otaTask.getTotalBytesAll() * otaTask.getRestoredProgressPct()) + 99) / 100, lQueryPartialDownloadedBytes != null ? lQueryPartialDownloadedBytes.longValue() : otaTask.getDoneBytes()), otaTask.getDoneBytes(), otaTask.getTotalBytesAll());
            } else if ((otaTask.getState() instanceof OtaState.Paused) && otaTask.getTotalBytesAll() > 0) {
                long totalBytesAll = otaTask.getTotalBytesAll();
                g.d(otaTask.getState(), "null cannot be cast to non-null type com.stepos.core.ota.domain.OtaState.Paused");
                doneBytes = h.b0((totalBytesAll * ((OtaState.Paused) r8).getProgress()) / 100, otaTask.getDoneBytes(), otaTask.getTotalBytesAll());
            } else if (lQueryPartialDownloadedBytes != null) {
                long jLongValue = lQueryPartialDownloadedBytes.longValue();
                doneBytes = h.b0(jLongValue, otaTask.getDoneBytes(), otaTask.getTotalBytesAll() > 0 ? otaTask.getTotalBytesAll() : jLongValue);
            } else {
                doneBytes = otaTask.getDoneBytes();
            }
        }
        otaTask.setPausedDownloadedBytes(-1L);
        otaTask.setRestoredProgressPct(-1);
        Job job = otaTask.getJob();
        if (job != null) {
            if (!job.isActive()) {
                job = null;
            }
            if (job != null) {
                OtaLogger.DefaultImpls.e$default(this.log, TAG, a0.a.k("[", otaTask.getOtaId(), "] startNext with a live job → cancelling it first (missing cancel upstream)"), null, 4, null);
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
        }
        transition(otaTask, new OtaState.Downloading(doneBytes, otaTask.getTotalBytesAll()));
        recomputeGlobalRate();
        otaTask.setJob(BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass3(new DownloadSpec(otaTask.getOtaId(), currentManifest.getUrl(), str, currentManifest.getSizeBytes(), TriggerSourcePolicy.INSTANCE.allowCellular(otaTask.getPrimarySource(), otaTask.getCellularAllowed())), otaTask, str, null), 3, null));
    }

    private final OtaTask task(String str) {
        HashMap<String, OtaTask> map = this.tasks;
        OtaTask otaTask = map.get(str);
        if (otaTask == null) {
            OtaTask otaTask2 = new OtaTask(str, this.storage.installedVersion(str), this.clock.elapsedMs(), null, null, null, null, null, false, false, null, 0, 0L, 0L, false, 0L, 0, null, null, false, 1048568, null);
            map.put(str, otaTask2);
            otaTask = otaTask2;
        }
        return otaTask;
    }

    private final void transition(OtaTask otaTask, OtaState otaState) {
        OtaState state = otaTask.getState();
        if (shouldLogTransition(otaTask.getOtaId(), state, otaState)) {
            String strG = otaState instanceof OtaState.Downloading ? ai.onnxruntime.a.g(((OtaState.Downloading) otaState).getProgress(), " ", "%") : "";
            OtaLogger otaLogger = this.log;
            String otaId = otaTask.getOtaId();
            String strC = i.a(state.getClass()).c();
            String strC2 = i.a(otaState.getClass()).c();
            StringBuilder sbS = ai.onnxruntime.a.s("[", otaId, "] ", strC, " -> ");
            sbS.append(strC2);
            sbS.append(strG);
            otaLogger.d(TAG, sbS.toString());
        }
        otaTask.setState(otaState);
        otaTask.setUpdatedAtMs(this.clock.elapsedMs());
        publish();
    }

    public final StateFlow<Map<String, OtaStateSnapshot>> getState() {
        return this.state;
    }

    public final void start() {
        Job job = this.consumer;
        if (job == null || !job.isActive()) {
            this.consumer = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03991(null), 3, null);
            this.log.i(TAG, "OtaStore started");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object stop(qb.b<? super lb.n> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.core.ota.domain.OtaStore.C04001
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.core.ota.domain.OtaStore$stop$1 r0 = (com.stepos.core.ota.domain.OtaStore.C04001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.OtaStore$stop$1 r0 = new com.stepos.core.ota.domain.OtaStore$stop$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.stepos.core.ota.domain.OtaStore r4 = (com.stepos.core.ota.domain.OtaStore) r4
            kotlin.c.b(r5)
            goto L45
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r5)
            kotlinx.coroutines.Job r5 = r4.consumer
            if (r5 == 0) goto L45
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.JobKt.cancelAndJoin(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r5 = 0
            r4.consumer = r5
            kotlinx.coroutines.channels.Channel<com.stepos.core.ota.domain.OtaAction> r4 = r4.mailbox
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r4, r5, r3, r5)
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.stop(qb.b):java.lang.Object");
    }

    public final boolean submit(OtaAction command) {
        g.f(command, "command");
        boolean zM160isSuccessimpl = ChannelResult.m160isSuccessimpl(this.mailbox.mo149trySendJP2dKIU(command));
        if (!zM160isSuccessimpl) {
            this.log.w(TAG, ai.onnxruntime.a.l("mailbox full, dropped: ", i.a(command.getClass()).c(), " ", command.getOtaId()));
        }
        return zM160isSuccessimpl;
    }

    public /* synthetic */ OtaStore(CoroutineScope coroutineScope, ManifestSource manifestSource, ModelDownloadPort modelDownloadPort, InstallPipeline installPipeline, ModelStorage modelStorage, OtaClock otaClock, DownloadController downloadController, zb.a aVar, OtaLogger otaLogger, int i10, l lVar, int i11, e eVar) {
        this(coroutineScope, manifestSource, modelDownloadPort, installPipeline, modelStorage, otaClock, (i11 & 64) != 0 ? null : downloadController, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? new a9.a(20) : aVar, (i11 & 256) != 0 ? OtaLogger.Noop.INSTANCE : otaLogger, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? 256 : i10, (i11 & 1024) != 0 ? new com.stepos.core.common.telemetry.b(17) : lVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class OtaTask {
        private boolean cellularAllowed;
        private final Set<String> clientTags;
        private long doneBytes;
        private String downloadFilePath;
        private boolean freshDownload;
        private int installedVersion;
        private Job job;
        private final String otaId;
        private long pausedDownloadedBytes;
        private List<ModelManifest> plan;
        private int planIndex;
        private final Set<String> plugins;
        private TriggerSource primarySource;
        private boolean recoveredAfterInterruption;
        private int restoredProgressPct;
        private final Set<TriggerSource> sources;
        private OtaState state;
        private long totalBytesAll;
        private long updatedAtMs;
        private boolean wantsDownload;

        public OtaTask(String otaId, int i10, long j10, OtaState state, Set<TriggerSource> sources, TriggerSource triggerSource, Set<String> clientTags, Set<String> plugins, boolean z, boolean z3, List<ModelManifest> plan, int i11, long j11, long j12, boolean z10, long j13, int i12, Job job, String str, boolean z11) {
            g.f(otaId, "otaId");
            g.f(state, "state");
            g.f(sources, "sources");
            g.f(clientTags, "clientTags");
            g.f(plugins, "plugins");
            g.f(plan, "plan");
            this.otaId = otaId;
            this.installedVersion = i10;
            this.updatedAtMs = j10;
            this.state = state;
            this.sources = sources;
            this.primarySource = triggerSource;
            this.clientTags = clientTags;
            this.plugins = plugins;
            this.cellularAllowed = z;
            this.recoveredAfterInterruption = z3;
            this.plan = plan;
            this.planIndex = i11;
            this.totalBytesAll = j11;
            this.doneBytes = j12;
            this.wantsDownload = z10;
            this.pausedDownloadedBytes = j13;
            this.restoredProgressPct = i12;
            this.job = job;
            this.downloadFilePath = str;
            this.freshDownload = z11;
        }

        public final void dropSettledRoundSignature() {
            OtaState otaState = this.state;
            if ((otaState instanceof OtaState.Installed) || (otaState instanceof OtaState.Idle)) {
                this.sources.clear();
                this.primarySource = null;
                this.cellularAllowed = false;
                this.recoveredAfterInterruption = false;
            }
        }

        public final boolean getCellularAllowed() {
            return this.cellularAllowed;
        }

        public final Set<String> getClientTags() {
            return this.clientTags;
        }

        public final ModelManifest getCurrentManifest() {
            return (ModelManifest) kotlin.collections.a.w0(this.planIndex, this.plan);
        }

        public final long getDoneBytes() {
            return this.doneBytes;
        }

        public final String getDownloadFilePath() {
            return this.downloadFilePath;
        }

        public final boolean getFreshDownload() {
            return this.freshDownload;
        }

        public final int getInstalledVersion() {
            return this.installedVersion;
        }

        public final Job getJob() {
            return this.job;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final long getPausedDownloadedBytes() {
            return this.pausedDownloadedBytes;
        }

        public final List<ModelManifest> getPlan() {
            return this.plan;
        }

        public final int getPlanIndex() {
            return this.planIndex;
        }

        public final Set<String> getPlugins() {
            return this.plugins;
        }

        public final TriggerSource getPrimarySource() {
            return this.primarySource;
        }

        public final boolean getRecoveredAfterInterruption() {
            return this.recoveredAfterInterruption;
        }

        public final int getRestoredProgressPct() {
            return this.restoredProgressPct;
        }

        public final Set<TriggerSource> getSources() {
            return this.sources;
        }

        public final OtaState getState() {
            return this.state;
        }

        public final long getTotalBytesAll() {
            return this.totalBytesAll;
        }

        public final long getUpdatedAtMs() {
            return this.updatedAtMs;
        }

        public final boolean getWantsDownload() {
            return this.wantsDownload;
        }

        public final boolean isForeground() {
            return this.sources.contains(TriggerSource.USER);
        }

        public final void recomputePrimary() {
            this.primarySource = TriggerSourcePolicy.INSTANCE.primary(this.sources);
        }

        public final void setCellularAllowed(boolean z) {
            this.cellularAllowed = z;
        }

        public final void setDoneBytes(long j10) {
            this.doneBytes = j10;
        }

        public final void setDownloadFilePath(String str) {
            this.downloadFilePath = str;
        }

        public final void setFreshDownload(boolean z) {
            this.freshDownload = z;
        }

        public final void setInstalledVersion(int i10) {
            this.installedVersion = i10;
        }

        public final void setJob(Job job) {
            this.job = job;
        }

        public final void setPausedDownloadedBytes(long j10) {
            this.pausedDownloadedBytes = j10;
        }

        public final void setPlan(List<ModelManifest> list) {
            g.f(list, "<set-?>");
            this.plan = list;
        }

        public final void setPlanIndex(int i10) {
            this.planIndex = i10;
        }

        public final void setPrimarySource(TriggerSource triggerSource) {
            this.primarySource = triggerSource;
        }

        public final void setRecoveredAfterInterruption(boolean z) {
            this.recoveredAfterInterruption = z;
        }

        public final void setRestoredProgressPct(int i10) {
            this.restoredProgressPct = i10;
        }

        public final void setState(OtaState otaState) {
            g.f(otaState, "<set-?>");
            this.state = otaState;
        }

        public final void setTotalBytesAll(long j10) {
            this.totalBytesAll = j10;
        }

        public final void setUpdatedAtMs(long j10) {
            this.updatedAtMs = j10;
        }

        public final void setWantsDownload(boolean z) {
            this.wantsDownload = z;
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public OtaTask(java.lang.String r28, int r29, long r30, com.stepos.core.ota.domain.OtaState r32, java.util.Set r33, com.stepos.core.ota.domain.TriggerSource r34, java.util.Set r35, java.util.Set r36, boolean r37, boolean r38, java.util.List r39, int r40, long r41, long r43, boolean r45, long r46, int r48, kotlinx.coroutines.Job r49, java.lang.String r50, boolean r51, int r52, kotlin.jvm.internal.e r53) {
            /*
                Method dump skipped, instructions count: 198
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStore.OtaTask.<init>(java.lang.String, int, long, com.stepos.core.ota.domain.OtaState, java.util.Set, com.stepos.core.ota.domain.TriggerSource, java.util.Set, java.util.Set, boolean, boolean, java.util.List, int, long, long, boolean, long, int, kotlinx.coroutines.Job, java.lang.String, boolean, int, kotlin.jvm.internal.e):void");
        }
    }
}
