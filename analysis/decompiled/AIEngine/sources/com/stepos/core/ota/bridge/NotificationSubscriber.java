package com.stepos.core.ota.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import com.stepos.core.common.notification.DownloadNotificationState;
import com.stepos.core.common.notification.IDownloadGroup;
import com.stepos.core.common.notification.ModelDownloadNotificationRegistry;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.notification.NotificationCancelSuppressStore;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.display.ModelDisplayLookup;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.display.ModelLabelResolver;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import dc.h;
import gc.q;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NotificationSubscriber {
    public static final Companion Companion = new Companion(null);
    private static final long PAUSE_ALERT_WINDOW_MS = 3000;
    private static final long PROGRESS_NOTIFY_INTERVAL_MS = 500;
    private static final long START_ALERT_WINDOW_MS = 3000;
    private final Context context;
    private final HashMap<String, NotifGroup> groups;
    private long lastPauseAlertAt;
    private final HashMap<String, Long> lastProgressNotifyAt;
    private long lastStartAlertAt;
    private final HashMap<String, OtaState> lastState;
    private final ModelDownloadNotifier notifier;
    private final HashSet<String> resumeReplanning;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.bridge.NotificationSubscriber$1", f = "NotificationSubscriber.kt", l = {57}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.bridge.NotificationSubscriber$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ StateFlow<Map<String, OtaStateSnapshot>> $state;
        int label;
        final /* synthetic */ NotificationSubscriber this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(StateFlow<? extends Map<String, OtaStateSnapshot>> stateFlow, NotificationSubscriber notificationSubscriber, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$state = stateFlow;
            this.this$0 = notificationSubscriber;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.$state, this.this$0, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                StateFlow<Map<String, OtaStateSnapshot>> stateFlow = this.$state;
                final NotificationSubscriber notificationSubscriber = this.this$0;
                FlowCollector<? super Map<String, OtaStateSnapshot>> flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.bridge.NotificationSubscriber.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, b bVar) {
                        return emit((Map<String, OtaStateSnapshot>) obj2, (b<? super n>) bVar);
                    }

                    public final Object emit(Map<String, OtaStateSnapshot> map, b<? super n> bVar) {
                        Collection<OtaStateSnapshot> collectionValues = map.values();
                        NotificationSubscriber notificationSubscriber2 = notificationSubscriber;
                        Iterator<T> it = collectionValues.iterator();
                        while (it.hasNext()) {
                            notificationSubscriber2.onSnapshot((OtaStateSnapshot) it.next());
                        }
                        return n.f10413a;
                    }
                };
                this.label = 1;
                if (stateFlow.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NotifGroup implements IDownloadGroup {
        private String cachedLabel;
        private String cachedLocale;
        private final int checkId;
        private final Context context;
        private int displayProgress;
        private long downloaded;
        private final String modelType;
        private final DownloadNotificationState notification;
        private long restartTime;
        private long totalSize;

        public NotifGroup(String modelType, Context context) {
            g.f(modelType, "modelType");
            g.f(context, "context");
            this.modelType = modelType;
            this.context = context;
            this.notification = new DownloadNotificationState(ModelDownloadNotificationRegistry.INSTANCE.downloadIdFor(getModelType()));
            this.checkId = (getModelType().hashCode() & 65535) + 1000000;
        }

        private final String currentLocaleTag() {
            Locale locale = this.context.getResources().getConfiguration().getLocales().get(0);
            String languageTag = locale != null ? locale.toLanguageTag() : null;
            return languageTag == null ? "" : languageTag;
        }

        private final String displayLabel() {
            String strCurrentLocaleTag = currentLocaleTag();
            String str = this.cachedLabel;
            if (str != null && g.b(this.cachedLocale, strCurrentLocaleTag)) {
                return str;
            }
            String strBucketDirOf = OtaEngine.INSTANCE.bucketDirOf(getModelType());
            ModelDisplayLookup modelDisplayLookup = ModelDisplayLookup.INSTANCE;
            String strResolveDir$default = ModelDisplayLookup.resolveDir$default(modelDisplayLookup, this.context, getModelType(), strBucketDirOf, modelDisplayLookup.readUse(this.context, getModelType()), false, 16, null);
            if (q.t0(strResolveDir$default)) {
                strResolveDir$default = null;
            }
            if (strResolveDir$default == null) {
                ModelDisplayResourceStore.ensureAsync$default(ModelDisplayResourceStore.INSTANCE, this.context, getModelType(), null, strBucketDirOf, 0, null, 48, null);
            }
            String strResolve = ModelLabelResolver.INSTANCE.resolve(this.context, getModelType(), strResolveDir$default);
            if (strResolveDir$default != null && !g.b(strResolve, getModelType())) {
                this.cachedLabel = strResolve;
                this.cachedLocale = strCurrentLocaleTag;
            }
            return strResolve;
        }

        public static /* synthetic */ void update$default(NotifGroup notifGroup, OtaStateSnapshot otaStateSnapshot, OtaState otaState, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                otaState = null;
            }
            notifGroup.update(otaStateSnapshot, otaState);
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public String formatFileSizeSplit() {
            return String.format("%.1fMB/%.1fMB", Arrays.copyOf(new Object[]{Float.valueOf(this.downloaded / 1048576.0f), Float.valueOf(getTotalSize() / 1048576.0f)}, 2));
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public int getCheckId() {
            return this.checkId;
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public String getModelType() {
            return this.modelType;
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public DownloadNotificationState getNotification() {
            return this.notification;
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public String getNotifyTitle() {
            return displayLabel();
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public float getProgressIn1() {
            return h.Z(this.displayProgress / 100.0f, 0.0f, 1.0f);
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public long getRestartTime() {
            return this.restartTime;
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public long getTotalSize() {
            return this.totalSize;
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public boolean hasFlag(int i10) {
            return false;
        }

        public final void invalidateLabel() {
            this.cachedLabel = null;
            this.cachedLocale = null;
        }

        @Override // com.stepos.core.common.notification.IDownloadGroup
        public void setRestartTime(long j10) {
            this.restartTime = j10;
        }

        public void setTotalSize(long j10) {
            this.totalSize = j10;
        }

        public final void update(OtaStateSnapshot snap, OtaState otaState) {
            g.f(snap, "snap");
            OtaState state = snap.getState();
            if (!(state instanceof OtaState.Downloading)) {
                if (state instanceof OtaState.Paused) {
                    this.displayProgress = Math.max(this.displayProgress, snap.getProgress());
                    return;
                }
                if ((state instanceof OtaState.Installed) || (state instanceof OtaState.Removed)) {
                    this.displayProgress = snap.getProgress();
                    return;
                } else {
                    if (snap.getProgress() > 0) {
                        this.displayProgress = snap.getProgress();
                        return;
                    }
                    return;
                }
            }
            if (!(otaState instanceof OtaState.Downloading) && !(otaState instanceof OtaState.Paused)) {
                this.displayProgress = snap.getProgress();
                OtaState.Downloading downloading = (OtaState.Downloading) state;
                this.downloaded = downloading.getDownloadedBytes();
                setTotalSize(downloading.getTotalBytes());
                return;
            }
            if (snap.getProgress() >= this.displayProgress) {
                this.displayProgress = snap.getProgress();
                OtaState.Downloading downloading2 = (OtaState.Downloading) state;
                this.downloaded = downloading2.getDownloadedBytes();
                setTotalSize(downloading2.getTotalBytes());
            }
        }
    }

    public NotificationSubscriber(CoroutineScope scope, StateFlow<? extends Map<String, OtaStateSnapshot>> state, ModelDownloadNotifier notifier, Context context) {
        g.f(scope, "scope");
        g.f(state, "state");
        g.f(notifier, "notifier");
        g.f(context, "context");
        this.notifier = notifier;
        this.context = context;
        this.groups = new HashMap<>();
        this.lastState = new HashMap<>();
        this.lastProgressNotifyAt = new HashMap<>();
        this.resumeReplanning = new HashSet<>();
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(state, this, null), 3, null);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.stepos.core.ota.bridge.NotificationSubscriber.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (g.b(intent != null ? intent.getAction() : null, "android.intent.action.LOCALE_CHANGED")) {
                    NotificationSubscriber.this.refreshForLocale();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null, 2);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null, 0);
        }
    }

    private final void cleanup(String str) {
        this.groups.remove(str);
        this.lastState.remove(str);
        this.resumeReplanning.remove(str);
        this.lastProgressNotifyAt.remove(str);
    }

    private final boolean isBurstPause() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = jElapsedRealtime - this.lastPauseAlertAt < 3000;
        this.lastPauseAlertAt = jElapsedRealtime;
        return z;
    }

    private final boolean isBurstStart() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = jElapsedRealtime - this.lastStartAlertAt < 3000;
        this.lastStartAlertAt = jElapsedRealtime;
        return z;
    }

    private final void maybeNotifyProgress(NotifGroup notifGroup, String str, int i10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l10 = this.lastProgressNotifyAt.get(str);
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        if (i10 >= 100 || jElapsedRealtime - jLongValue >= 500) {
            this.lastProgressNotifyAt.put(str, Long.valueOf(jElapsedRealtime));
            ModelDownloadNotifier.notifyProgress$default(this.notifier, notifGroup, false, 2, null);
        }
    }

    private final void onChecking(NotifGroup notifGroup, OtaStateSnapshot otaStateSnapshot, OtaState otaState) {
        if (!NotificationSubscriberKt.isResumeReplan(otaState, otaStateSnapshot.getRecoveredAfterInterruption())) {
            this.resumeReplanning.remove(otaStateSnapshot.getOtaId());
            this.notifier.onTaskChecking(notifGroup);
        } else {
            this.resumeReplanning.add(otaStateSnapshot.getOtaId());
            if (notifGroup.getTotalSize() > 0) {
                this.notifier.notifyProgress(notifGroup, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSnapshot(OtaStateSnapshot otaStateSnapshot) {
        if (NotificationCancelSuppressStore.INSTANCE.isSuppressed(otaStateSnapshot.getOtaId())) {
            this.notifier.dismissForModel(otaStateSnapshot.getOtaId());
            cleanup(otaStateSnapshot.getOtaId());
            return;
        }
        if (otaStateSnapshot.getShowNotification()) {
            HashMap<String, NotifGroup> map = this.groups;
            String otaId = otaStateSnapshot.getOtaId();
            NotifGroup notifGroup = map.get(otaId);
            if (notifGroup == null) {
                notifGroup = new NotifGroup(otaStateSnapshot.getOtaId(), this.context);
                map.put(otaId, notifGroup);
            }
            NotifGroup notifGroup2 = notifGroup;
            OtaState otaState = this.lastState.get(otaStateSnapshot.getOtaId());
            notifGroup2.update(otaStateSnapshot, otaState);
            OtaState state = otaStateSnapshot.getState();
            if (g.b(otaState, state)) {
                return;
            }
            this.lastState.put(otaStateSnapshot.getOtaId(), state);
            boolean z = state instanceof OtaState.Checking;
            if (!z) {
                this.resumeReplanning.remove(otaStateSnapshot.getOtaId());
            }
            if (z) {
                onChecking(notifGroup2, otaStateSnapshot, otaState);
                return;
            }
            if (state instanceof OtaState.Downloading) {
                if (otaState instanceof OtaState.Downloading) {
                    maybeNotifyProgress(notifGroup2, otaStateSnapshot.getOtaId(), otaStateSnapshot.getProgress());
                    return;
                }
                if (otaState instanceof OtaState.Paused) {
                    this.lastProgressNotifyAt.put(otaStateSnapshot.getOtaId(), Long.valueOf(SystemClock.elapsedRealtime()));
                    this.notifier.notifyProgress(notifGroup2, otaStateSnapshot.getRecoveredAfterInterruption());
                    return;
                }
                this.lastProgressNotifyAt.put(otaStateSnapshot.getOtaId(), Long.valueOf(SystemClock.elapsedRealtime()));
                if (otaStateSnapshot.getRecoveredAfterInterruption()) {
                    this.notifier.notifyProgress(notifGroup2, true);
                    return;
                } else {
                    notifGroup2.setRestartTime(System.currentTimeMillis());
                    this.notifier.onTaskStarted(notifGroup2, isBurstStart());
                    return;
                }
            }
            if ((state instanceof OtaState.Verifying) || (state instanceof OtaState.Installing) || (state instanceof OtaState.Activating)) {
                this.notifier.onTaskChecking(notifGroup2);
                return;
            }
            if (state instanceof OtaState.Installed) {
                if (otaState != null && !(otaState instanceof OtaState.Idle) && !(otaState instanceof OtaState.Installed)) {
                    this.notifier.releaseForegroundIfAnchor(notifGroup2.getNotification().getId());
                    this.notifier.onTaskFinished(notifGroup2);
                    cleanup(otaStateSnapshot.getOtaId());
                    return;
                }
                if (!(otaState instanceof OtaState.Checking)) {
                    cleanup(otaStateSnapshot.getOtaId());
                    return;
                }
                this.notifier.releaseForegroundIfAnchor(notifGroup2.getNotification().getId());
                this.notifier.onTaskCanceled(notifGroup2);
                cleanup(otaStateSnapshot.getOtaId());
                return;
            }
            if (state instanceof OtaState.Failed) {
                this.notifier.releaseForegroundIfAnchor(notifGroup2.getNotification().getId());
                this.notifier.onTaskError(notifGroup2);
                return;
            }
            if (state instanceof OtaState.Paused) {
                if (otaState != null) {
                    this.notifier.releaseForegroundIfAnchor(notifGroup2.getNotification().getId());
                    this.notifier.onTaskPaused(notifGroup2, isBurstPause());
                    return;
                }
                return;
            }
            if (state instanceof OtaState.Removed) {
                this.notifier.releaseForegroundIfAnchor(notifGroup2.getNotification().getId());
                this.notifier.onTaskCanceled(notifGroup2);
                cleanup(otaStateSnapshot.getOtaId());
            } else if (!(state instanceof OtaState.Idle) && !(state instanceof OtaState.Queued)) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshForLocale() {
        this.notifier.refreshChannels();
        Collection<NotifGroup> collectionValues = this.groups.values();
        g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((NotifGroup) it.next()).invalidateLabel();
        }
        for (Map.Entry<String, NotifGroup> entry : this.groups.entrySet()) {
            String key = entry.getKey();
            NotifGroup value = entry.getValue();
            OtaState otaState = this.lastState.get(key);
            if (otaState instanceof OtaState.Downloading) {
                ModelDownloadNotifier.notifyProgress$default(this.notifier, value, false, 2, null);
            } else if (otaState instanceof OtaState.Paused) {
                this.notifier.onTaskPaused(value, true);
            } else if (otaState instanceof OtaState.Checking) {
                if (this.resumeReplanning.contains(key)) {
                    ModelDownloadNotifier.notifyProgress$default(this.notifier, value, false, 2, null);
                } else {
                    this.notifier.onTaskChecking(value);
                }
            } else if ((otaState instanceof OtaState.Verifying) || (otaState instanceof OtaState.Installing) || (otaState instanceof OtaState.Activating)) {
                this.notifier.onTaskChecking(value);
            } else if (otaState instanceof OtaState.Failed) {
                this.notifier.onTaskError(value);
            }
        }
    }
}
