package com.stepos.core.common.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.stepos.core.ability.util.EmbedSessionImageMock;
import com.stepos.core.common.R;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import gc.q;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.j;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ModelDownloadNotifier {
    public static final String ACTION_MODEL_MANAGER = "com.stepos.aiengine.action.MODEL_MANAGER";
    private static final int BANNER_PINNED_TIMEOUT_MS = 1500;
    public static final String CHANNEL_CHECK = "model_download_check";
    public static final String CHANNEL_PROGRESS = "model_download_progress";
    public static final String CHANNEL_STATE = "model_download_state";
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_DISMISS_NOTIF_ID = "com.stepos.aiengine.extra.DISMISS_NOTIF_ID";
    public static final String EXTRA_MODEL_TYPE = "modelType";
    public static final String EXTRA_NOTIF_ID = "id";
    public static final String EXTRA_OP = "op";
    public static final String MODEL_MANAGER_ACTIVITY_CLASS = "com.stepos.aiengine.modelmanager.ModelManagerActivity";
    public static final String RECEIVER_ACTION = "com.stepos.aiengine.MODEL_DOWNLOAD_NOTIFY";
    private static final int REQ_OPEN_MODEL_MANAGER = 90001;
    private volatile Integer anchorId;
    private final Context context;
    private volatile ForegroundHost foregroundHost;
    private final NotificationManager nm;
    private final NotificationSender sender;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NotifState {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ NotifState[] $VALUES;
        private final int iconRes;
        public static final NotifState DOWNLOADING = new NotifState("DOWNLOADING", 0, R.drawable.ic_live_dl_pause);
        public static final NotifState PAUSED = new NotifState("PAUSED", 1, R.drawable.ic_live_dl_play);
        public static final NotifState INSTALLING = new NotifState("INSTALLING", 2, R.drawable.ic_live_dl_installing);
        public static final NotifState DONE = new NotifState("DONE", 3, R.drawable.ic_live_dl_done);
        public static final NotifState ERROR = new NotifState("ERROR", 4, R.drawable.ic_live_dl_error);

        private static final /* synthetic */ NotifState[] $values() {
            return new NotifState[]{DOWNLOADING, PAUSED, INSTALLING, DONE, ERROR};
        }

        static {
            NotifState[] notifStateArr$values = $values();
            $VALUES = notifStateArr$values;
            $ENTRIES = kotlin.enums.a.a(notifStateArr$values);
        }

        private NotifState(String str, int i10, int i11) {
            this.iconRes = i11;
        }

        public static a<NotifState> getEntries() {
            return $ENTRIES;
        }

        public static NotifState valueOf(String str) {
            return (NotifState) Enum.valueOf(NotifState.class, str);
        }

        public static NotifState[] values() {
            return (NotifState[]) $VALUES.clone();
        }

        public final int getIconRes() {
            return this.iconRes;
        }
    }

    public ModelDownloadNotifier(Context context) {
        g.f(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("notification");
        g.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.nm = (NotificationManager) systemService;
        this.sender = new NotificationSender(context);
        refreshChannels();
    }

    private final void attachLive(IDownloadGroup iDownloadGroup, Notification notification, NotifVisualSpec notifVisualSpec) {
        DownloadNotificationState notification2 = iDownloadGroup.getNotification();
        boolean liveCreated = notification2.getLiveCreated();
        notification2.setLiveCreated(true);
        String strI = d.i(iDownloadGroup.getNotifyTitle(), " ", iDownloadGroup.formatFileSizeSplit());
        LiveNotification liveNotification = LiveNotification.INSTANCE;
        Bundle extras = notification.extras;
        g.e(extras, "extras");
        String statusText = notifVisualSpec.getStatusText();
        Icon iconCreateWithResource = Icon.createWithResource(this.context, R.drawable.ic_live_dl_model);
        g.e(iconCreateWithResource, "createWithResource(...)");
        Icon iconCreateWithResource2 = Icon.createWithResource(this.context, notifVisualSpec.getState().getIconRes());
        g.e(iconCreateWithResource2, "createWithResource(...)");
        int color = this.context.getColor(R.color.live_dl_card_bg);
        int color2 = this.context.getColor(R.color.live_dl_capsule_bg);
        int color3 = this.context.getColor(R.color.live_dl_card_title);
        int color4 = this.context.getColor(R.color.live_dl_card_content);
        String statusText2 = notifVisualSpec.getStatusText();
        int color5 = this.context.getColor(R.color.live_dl_capsule_content);
        PendingIntent contentIntent = notifVisualSpec.getContentIntent();
        Icon[] iconArr = {Icon.createWithBitmap(NotifRingBitmap.INSTANCE.create(this.context, notifVisualSpec.getProgress(), notifVisualSpec.getState(), notifVisualSpec.getShowProgressRing()))};
        ArrayList<Icon> arrayList = iconArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new j(iconArr, true));
        liveNotification.applyModelDownload(extras, liveCreated ? 1 : 0, statusText, strI, iconCreateWithResource, iconCreateWithResource2, color, color2, color3, color4, statusText2, color5, contentIntent, arrayList, 1, true, false, BANNER_PINNED_TIMEOUT_MS, notifVisualSpec.getAllowPopup());
    }

    private final Notification build(IDownloadGroup iDownloadGroup, String str, String str2, float f8, boolean z, boolean z3, NotifVisualSpec notifVisualSpec) {
        Notification notificationB;
        synchronized (iDownloadGroup.getNotification()) {
            try {
                int id2 = iDownloadGroup.getNotification().getId();
                String str3 = iDownloadGroup.getNotifyTitle() + " " + iDownloadGroup.formatFileSizeSplit();
                ModelDownloadNotifyOp actionOp = notifVisualSpec.getActionOp();
                PendingIntent pendingIntent = actionOp != null ? pendingIntent(actionOp, iDownloadGroup.getModelType(), id2) : null;
                RemoteViews remoteViewsBuild = ModelDownloadNotificationViews.INSTANCE.build(this.context, notifVisualSpec.getStatusText(), str3, notifVisualSpec, pendingIntent);
                PendingIntent pendingIntent2 = pendingIntent(ModelDownloadNotifyOp.DISMISS, iDownloadGroup.getModelType(), id2);
                if (iDownloadGroup.getNotification().getWhenMs() == 0) {
                    iDownloadGroup.getNotification().setWhenMs(System.currentTimeMillis());
                }
                androidx.core.app.g orCreateBuilder = iDownloadGroup.getNotification().getOrCreateBuilder(this.context, str);
                orCreateBuilder.f1495b.clear();
                orCreateBuilder.d(8, true);
                orCreateBuilder.f1507o.icon = android.R.drawable.stat_sys_download;
                orCreateBuilder.f1505m = 1;
                orCreateBuilder.f1507o.when = iDownloadGroup.getNotification().getWhenMs();
                orCreateBuilder.f1498e = androidx.core.app.g.c(notifVisualSpec.getStatusText());
                orCreateBuilder.f1499f = androidx.core.app.g.c(str3);
                orCreateBuilder.f1508p = z3;
                orCreateBuilder.d(2, false);
                orCreateBuilder.d(16, !z);
                orCreateBuilder.f1500g = notifVisualSpec.getContentIntent();
                orCreateBuilder.f1502j = remoteViewsBuild;
                orCreateBuilder.f1503k = remoteViewsBuild;
                orCreateBuilder.f1507o.deleteIntent = pendingIntent2;
                if (pendingIntent == null) {
                    pendingIntent = notifVisualSpec.getContentIntent();
                }
                orCreateBuilder.a("", pendingIntent);
                notificationB = orCreateBuilder.b();
                g.c(notificationB);
                attachLive(iDownloadGroup, notificationB, notifVisualSpec);
            } catch (Throwable th) {
                throw th;
            }
        }
        return notificationB;
    }

    private final String downloadingPct(IDownloadGroup iDownloadGroup) {
        String string = this.context.getString(R.string.mdl_notif_downloading_pct, Integer.valueOf(percent(iDownloadGroup)));
        g.e(string, "getString(...)");
        return string;
    }

    private final String formatSize(long j10) {
        float f8 = j10 * 1.0f;
        float f9 = 1024;
        return String.format("%.2fMB", Arrays.copyOf(new Object[]{Float.valueOf((f8 / f9) / f9)}, 1));
    }

    private final PendingIntent modelManagerPendingIntent(Integer num) {
        Intent intent = new Intent(ACTION_MODEL_MANAGER);
        intent.setPackage(this.context.getPackageName());
        intent.setClassName(this.context.getPackageName(), MODEL_MANAGER_ACTIVITY_CLASS);
        if (num != null) {
            intent.putExtra(EXTRA_DISMISS_NOTIF_ID, num.intValue());
        }
        intent.addFlags(335544320);
        PendingIntent activity = PendingIntent.getActivity(this.context, (num != null ? num.intValue() : 0) + REQ_OPEN_MODEL_MANAGER, intent, 201326592);
        g.e(activity, "getActivity(...)");
        return activity;
    }

    public static /* synthetic */ PendingIntent modelManagerPendingIntent$default(ModelDownloadNotifier modelDownloadNotifier, Integer num, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelManagerPendingIntent");
        }
        if ((i10 & 1) != 0) {
            num = null;
        }
        return modelDownloadNotifier.modelManagerPendingIntent(num);
    }

    private final void notify(String str, int i10, Notification notification, boolean z) {
        Integer num;
        int iIntValue;
        if (NotificationDismissStore.INSTANCE.isSuppressed(str)) {
            return;
        }
        ModelDownloadNotificationRegistry modelDownloadNotificationRegistry = ModelDownloadNotificationRegistry.INSTANCE;
        Integer numLastShownId = modelDownloadNotificationRegistry.lastShownId(str);
        if (numLastShownId != null && (iIntValue = numLastShownId.intValue()) != i10) {
            this.sender.cancelPending(iIntValue);
            this.nm.cancel(iIntValue);
            releaseForegroundIfAnchor(iIntValue);
        }
        modelDownloadNotificationRegistry.recordShown(str, i10);
        ForegroundHost foregroundHost = this.foregroundHost;
        if (!z || foregroundHost == null || (this.anchorId != null && ((num = this.anchorId) == null || num.intValue() != i10))) {
            this.sender.sendDelayed(i10, notification);
        } else {
            this.anchorId = Integer.valueOf(i10);
            foregroundHost.attachForeground(i10, notification);
        }
    }

    public static /* synthetic */ void notify$default(ModelDownloadNotifier modelDownloadNotifier, String str, int i10, Notification notification, boolean z, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notify");
        }
        if ((i11 & 8) != 0) {
            z = true;
        }
        modelDownloadNotifier.notify(str, i10, notification, z);
    }

    public static /* synthetic */ void notifyProgress$default(ModelDownloadNotifier modelDownloadNotifier, IDownloadGroup iDownloadGroup, boolean z, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyProgress");
        }
        if ((i10 & 2) != 0) {
            z = false;
        }
        modelDownloadNotifier.notifyProgress(iDownloadGroup, z);
    }

    public static /* synthetic */ void onTaskPaused$default(ModelDownloadNotifier modelDownloadNotifier, IDownloadGroup iDownloadGroup, boolean z, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTaskPaused");
        }
        if ((i10 & 2) != 0) {
            z = false;
        }
        modelDownloadNotifier.onTaskPaused(iDownloadGroup, z);
    }

    public static /* synthetic */ void onTaskStarted$default(ModelDownloadNotifier modelDownloadNotifier, IDownloadGroup iDownloadGroup, boolean z, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTaskStarted");
        }
        if ((i10 & 2) != 0) {
            z = false;
        }
        modelDownloadNotifier.onTaskStarted(iDownloadGroup, z);
    }

    private final PendingIntent pendingIntent(ModelDownloadNotifyOp modelDownloadNotifyOp, String str, int i10) {
        if (modelDownloadNotifyOp == ModelDownloadNotifyOp.OPEN_MODEL_MANAGER) {
            return modelManagerPendingIntent(Integer.valueOf(i10));
        }
        if (modelDownloadNotifyOp == ModelDownloadNotifyOp.NETWORK_SETTING) {
            PendingIntent activity = PendingIntent.getActivity(this.context, modelDownloadNotifyOp.ordinal(), new Intent("android.settings.WIRELESS_SETTINGS"), 201326592);
            g.e(activity, "getActivity(...)");
            return activity;
        }
        Intent intent = new Intent(RECEIVER_ACTION);
        intent.setPackage(this.context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_OP, modelDownloadNotifyOp.ordinal());
        bundle.putString(EXTRA_MODEL_TYPE, str);
        bundle.putInt(EXTRA_NOTIF_ID, i10);
        intent.putExtras(bundle);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context, modelDownloadNotifyOp.ordinal() + (i10 * 10), intent, 201326592);
        g.e(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final int percent(IDownloadGroup iDownloadGroup) {
        return (int) (iDownloadGroup.getProgressIn1() * 100);
    }

    private final NotifVisualSpec visualDownloading(IDownloadGroup iDownloadGroup, String str, boolean z) {
        return new NotifVisualSpec(NotifState.DOWNLOADING, str, iDownloadGroup.getProgressIn1(), true, modelManagerPendingIntent$default(this, null, 1, null), ModelDownloadNotifyOp.PAUSE, ModelDownloadNotifyOp.CANCEL, false, z);
    }

    public static /* synthetic */ NotifVisualSpec visualDownloading$default(ModelDownloadNotifier modelDownloadNotifier, IDownloadGroup iDownloadGroup, String str, boolean z, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: visualDownloading");
        }
        if ((i10 & 4) != 0) {
            z = false;
        }
        return modelDownloadNotifier.visualDownloading(iDownloadGroup, str, z);
    }

    public void cancel(int i10) {
        this.sender.cancelPending(i10);
        this.nm.cancel(i10);
    }

    public void cancelNotification(IDownloadGroup group) {
        g.f(group, "group");
        this.sender.cancelPending(group.getCheckId());
        this.nm.cancel(group.getCheckId());
        int id2 = group.getNotification().getId();
        removeForegroundIfAnchor(id2);
        this.sender.cancelPending(id2);
        this.nm.cancel(id2);
        group.getNotification().renew();
        ModelDownloadNotificationRegistry.INSTANCE.clear(group.getModelType());
    }

    public void dismissForModel(String modelType) {
        g.f(modelType, "modelType");
        if (q.t0(modelType)) {
            return;
        }
        ModelDownloadNotificationRegistry modelDownloadNotificationRegistry = ModelDownloadNotificationRegistry.INSTANCE;
        int iCheckIdFor = modelDownloadNotificationRegistry.checkIdFor(modelType);
        Integer numLastShownId = modelDownloadNotificationRegistry.lastShownId(modelType);
        if (numLastShownId != null) {
            int iIntValue = numLastShownId.intValue();
            this.sender.cancelPending(iIntValue);
            removeForegroundIfAnchor(iIntValue);
            this.nm.cancel(iIntValue);
        }
        this.sender.cancelPending(iCheckIdFor);
        this.nm.cancel(iCheckIdFor);
        modelDownloadNotificationRegistry.clear(modelType);
    }

    public final ForegroundHost getForegroundHost() {
        return this.foregroundHost;
    }

    public void notifyCellularOnCheck(IDownloadGroup group) {
        g.f(group, "group");
        int checkId = group.getCheckId();
        PendingIntent pendingIntent = pendingIntent(ModelDownloadNotifyOp.CONTINUE_WITH_MOBILE_DATA, group.getModelType(), checkId);
        PendingIntent pendingIntent2 = pendingIntent(ModelDownloadNotifyOp.CANCEL, group.getModelType(), checkId);
        androidx.core.app.g gVar = new androidx.core.app.g(this.context, CHANNEL_STATE);
        gVar.f1507o.icon = android.R.drawable.stat_sys_download;
        gVar.f1505m = 1;
        gVar.f1498e = androidx.core.app.g.c(this.context.getString(R.string.mdl_notif_use_cellular_title));
        gVar.f1499f = androidx.core.app.g.c(group.getNotifyTitle() + " " + formatSize(group.getTotalSize()));
        gVar.d(2, true);
        gVar.f1508p = false;
        gVar.d(16, true);
        gVar.f1507o.deleteIntent = pendingIntent2;
        gVar.a(this.context.getString(R.string.mdl_notif_cancel), pendingIntent2);
        gVar.a(this.context.getString(R.string.mdl_notif_use_cellular), pendingIntent);
        Notification notificationB = gVar.b();
        NotificationSender notificationSender = this.sender;
        g.c(notificationB);
        notificationSender.sendDelayed(checkId, notificationB);
    }

    public void notifyNoNetwork(IDownloadGroup group) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        group.getNotification().renew();
        String string = this.context.getString(R.string.mdl_notif_no_network);
        g.e(string, "getString(...)");
        notify(group.getModelType(), id2, build(group, CHANNEL_STATE, string, group.getProgressIn1(), false, false, new NotifVisualSpec(NotifState.PAUSED, string, group.getProgressIn1(), true, modelManagerPendingIntent$default(this, null, 1, null), ModelDownloadNotifyOp.NETWORK_SETTING, ModelDownloadNotifyOp.DISMISS, false, false, EmbedSessionImageMock.DIM, null)), false);
    }

    public void notifyNoNetworkOnCheck(IDownloadGroup group) {
        g.f(group, "group");
        int checkId = group.getCheckId();
        PendingIntent pendingIntent = pendingIntent(ModelDownloadNotifyOp.CANCEL, group.getModelType(), checkId);
        PendingIntent pendingIntent2 = pendingIntent(ModelDownloadNotifyOp.NETWORK_SETTING, group.getModelType(), checkId);
        androidx.core.app.g gVar = new androidx.core.app.g(this.context, CHANNEL_CHECK);
        gVar.f1507o.icon = android.R.drawable.stat_sys_download;
        gVar.d(8, true);
        gVar.f1505m = 1;
        gVar.f1498e = androidx.core.app.g.c(this.context.getString(R.string.mdl_notif_no_network));
        gVar.f1499f = androidx.core.app.g.c(group.getNotifyTitle());
        gVar.d(2, true);
        gVar.d(16, true);
        gVar.f1507o.deleteIntent = pendingIntent;
        gVar.a(this.context.getString(R.string.mdl_notif_cancel), pendingIntent);
        gVar.a(this.context.getString(R.string.mdl_notif_network_settings), pendingIntent2);
        Notification notificationB = gVar.b();
        NotificationSender notificationSender = this.sender;
        g.c(notificationB);
        notificationSender.sendDelayed(checkId, notificationB);
    }

    public void notifyProgress(IDownloadGroup group, boolean z) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        boolean z3 = !z && System.currentTimeMillis() - group.getRestartTime() < 2000;
        String modelType = group.getModelType();
        String string = this.context.getString(R.string.mdl_notif_downloading);
        g.e(string, "getString(...)");
        notify$default(this, modelType, id2, build(group, CHANNEL_PROGRESS, string, group.getProgressIn1(), true, !z3, visualDownloading$default(this, group, downloadingPct(group), false, 4, null)), false, 8, null);
    }

    public void onTaskCanceled(IDownloadGroup group) {
        g.f(group, "group");
        cancelNotification(group);
    }

    public void onTaskChecking(IDownloadGroup group) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        String string = this.context.getString(R.string.mdl_notif_installing);
        g.e(string, "getString(...)");
        notify$default(this, group.getModelType(), id2, build(group, CHANNEL_CHECK, string, -1.0f, true, false, new NotifVisualSpec(NotifState.INSTALLING, string, 0.0f, false, modelManagerPendingIntent$default(this, null, 1, null), null, ModelDownloadNotifyOp.CANCEL, false, false, 300, null)), false, 8, null);
    }

    public void onTaskError(IDownloadGroup group) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        String string = this.context.getString(R.string.mdl_notif_failed);
        g.e(string, "getString(...)");
        notify(group.getModelType(), id2, build(group, CHANNEL_STATE, string, 2.0f, false, false, new NotifVisualSpec(NotifState.ERROR, string, 0.0f, false, modelManagerPendingIntent$default(this, null, 1, null), ModelDownloadNotifyOp.RETRY, ModelDownloadNotifyOp.DISMISS, false, false, 396, null)), false);
    }

    public void onTaskFinished(IDownloadGroup group) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        PendingIntent pendingIntentModelManagerPendingIntent = modelManagerPendingIntent(Integer.valueOf(id2));
        String string = this.context.getString(R.string.mdl_notif_finished);
        g.e(string, "getString(...)");
        notify(group.getModelType(), id2, build(group, CHANNEL_STATE, string, 1.0f, false, false, new NotifVisualSpec(NotifState.DONE, string, 0.0f, false, pendingIntentModelManagerPendingIntent, null, ModelDownloadNotifyOp.DISMISS, false, true, 140, null)), false);
        group.getNotification().renew();
    }

    public void onTaskPaused(IDownloadGroup group, boolean z) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        String string = group.hasFlag(4) ? this.context.getString(R.string.mdl_notif_need_wifi) : this.context.getString(R.string.mdl_notif_paused);
        g.c(string);
        String modelType = group.getModelType();
        float progressIn1 = group.getProgressIn1();
        NotifState notifState = NotifState.PAUSED;
        String string2 = this.context.getString(R.string.mdl_notif_paused_pct, Integer.valueOf(percent(group)));
        g.e(string2, "getString(...)");
        notify(modelType, id2, build(group, CHANNEL_STATE, string, progressIn1, true, z, new NotifVisualSpec(notifState, string2, group.getProgressIn1(), true, modelManagerPendingIntent$default(this, null, 1, null), ModelDownloadNotifyOp.CONTINUE_DOWNLOAD, ModelDownloadNotifyOp.CANCEL, false, false, 256, null)), false);
    }

    public void onTaskStarted(IDownloadGroup group, boolean z) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        String modelType = group.getModelType();
        String string = this.context.getString(R.string.mdl_notif_downloading);
        g.e(string, "getString(...)");
        notify$default(this, modelType, id2, build(group, CHANNEL_STATE, string, group.getProgressIn1(), true, z, visualDownloading(group, downloadingPct(group), !z)), false, 8, null);
    }

    public void onTaskWaiting(IDownloadGroup group) {
        g.f(group, "group");
        int id2 = group.getNotification().getId();
        group.setRestartTime(System.currentTimeMillis());
        String string = this.context.getString(R.string.mdl_notif_waiting);
        g.e(string, "getString(...)");
        notify$default(this, group.getModelType(), id2, build(group, CHANNEL_STATE, string, group.getProgressIn1(), true, false, visualDownloading$default(this, group, string, false, 4, null)), false, 8, null);
    }

    public final void refreshChannels() {
        this.nm.createNotificationChannel(new NotificationChannel(CHANNEL_STATE, this.context.getString(R.string.mdl_notif_channel_state), 4));
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_PROGRESS, this.context.getString(R.string.mdl_notif_channel_progress), 2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        this.nm.createNotificationChannel(notificationChannel);
        this.nm.createNotificationChannel(new NotificationChannel(CHANNEL_CHECK, this.context.getString(R.string.mdl_notif_channel_check), 4));
    }

    public final void releaseAnyForegroundAnchor() {
        this.anchorId = null;
        ForegroundHost foregroundHost = this.foregroundHost;
        if (foregroundHost != null) {
            foregroundHost.detachForeground();
        }
    }

    public final void releaseForegroundIfAnchor(int i10) {
        Integer num = this.anchorId;
        if (num != null && num.intValue() == i10) {
            this.anchorId = null;
            ForegroundHost foregroundHost = this.foregroundHost;
            if (foregroundHost != null) {
                foregroundHost.detachForeground();
            }
        }
    }

    public final void removeForegroundIfAnchor(int i10) {
        Integer num = this.anchorId;
        if (num != null && num.intValue() == i10) {
            this.anchorId = null;
            ForegroundHost foregroundHost = this.foregroundHost;
            if (foregroundHost != null) {
                foregroundHost.removeForeground();
            }
        }
    }

    public final void setForegroundHost(ForegroundHost foregroundHost) {
        this.foregroundHost = foregroundHost;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NotifVisualSpec {
        private final ModelDownloadNotifyOp actionOp;
        private final boolean allowPopup;
        private final PendingIntent contentIntent;
        private final ModelDownloadNotifyOp dismissOp;
        private final boolean dismissable;
        private final float progress;
        private final boolean showProgressRing;
        private final NotifState state;
        private final String statusText;

        public NotifVisualSpec(NotifState state, String statusText, float f8, boolean z, PendingIntent contentIntent, ModelDownloadNotifyOp modelDownloadNotifyOp, ModelDownloadNotifyOp dismissOp, boolean z3, boolean z10) {
            g.f(state, "state");
            g.f(statusText, "statusText");
            g.f(contentIntent, "contentIntent");
            g.f(dismissOp, "dismissOp");
            this.state = state;
            this.statusText = statusText;
            this.progress = f8;
            this.showProgressRing = z;
            this.contentIntent = contentIntent;
            this.actionOp = modelDownloadNotifyOp;
            this.dismissOp = dismissOp;
            this.dismissable = z3;
            this.allowPopup = z10;
        }

        public static /* synthetic */ NotifVisualSpec copy$default(NotifVisualSpec notifVisualSpec, NotifState notifState, String str, float f8, boolean z, PendingIntent pendingIntent, ModelDownloadNotifyOp modelDownloadNotifyOp, ModelDownloadNotifyOp modelDownloadNotifyOp2, boolean z3, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                notifState = notifVisualSpec.state;
            }
            if ((i10 & 2) != 0) {
                str = notifVisualSpec.statusText;
            }
            if ((i10 & 4) != 0) {
                f8 = notifVisualSpec.progress;
            }
            if ((i10 & 8) != 0) {
                z = notifVisualSpec.showProgressRing;
            }
            if ((i10 & 16) != 0) {
                pendingIntent = notifVisualSpec.contentIntent;
            }
            if ((i10 & 32) != 0) {
                modelDownloadNotifyOp = notifVisualSpec.actionOp;
            }
            if ((i10 & 64) != 0) {
                modelDownloadNotifyOp2 = notifVisualSpec.dismissOp;
            }
            if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
                z3 = notifVisualSpec.dismissable;
            }
            if ((i10 & 256) != 0) {
                z10 = notifVisualSpec.allowPopup;
            }
            boolean z11 = z3;
            boolean z12 = z10;
            ModelDownloadNotifyOp modelDownloadNotifyOp3 = modelDownloadNotifyOp;
            ModelDownloadNotifyOp modelDownloadNotifyOp4 = modelDownloadNotifyOp2;
            PendingIntent pendingIntent2 = pendingIntent;
            float f9 = f8;
            return notifVisualSpec.copy(notifState, str, f9, z, pendingIntent2, modelDownloadNotifyOp3, modelDownloadNotifyOp4, z11, z12);
        }

        public final NotifState component1() {
            return this.state;
        }

        public final String component2() {
            return this.statusText;
        }

        public final float component3() {
            return this.progress;
        }

        public final boolean component4() {
            return this.showProgressRing;
        }

        public final PendingIntent component5() {
            return this.contentIntent;
        }

        public final ModelDownloadNotifyOp component6() {
            return this.actionOp;
        }

        public final ModelDownloadNotifyOp component7() {
            return this.dismissOp;
        }

        public final boolean component8() {
            return this.dismissable;
        }

        public final boolean component9() {
            return this.allowPopup;
        }

        public final NotifVisualSpec copy(NotifState state, String statusText, float f8, boolean z, PendingIntent contentIntent, ModelDownloadNotifyOp modelDownloadNotifyOp, ModelDownloadNotifyOp dismissOp, boolean z3, boolean z10) {
            g.f(state, "state");
            g.f(statusText, "statusText");
            g.f(contentIntent, "contentIntent");
            g.f(dismissOp, "dismissOp");
            return new NotifVisualSpec(state, statusText, f8, z, contentIntent, modelDownloadNotifyOp, dismissOp, z3, z10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NotifVisualSpec)) {
                return false;
            }
            NotifVisualSpec notifVisualSpec = (NotifVisualSpec) obj;
            return this.state == notifVisualSpec.state && g.b(this.statusText, notifVisualSpec.statusText) && Float.compare(this.progress, notifVisualSpec.progress) == 0 && this.showProgressRing == notifVisualSpec.showProgressRing && g.b(this.contentIntent, notifVisualSpec.contentIntent) && this.actionOp == notifVisualSpec.actionOp && this.dismissOp == notifVisualSpec.dismissOp && this.dismissable == notifVisualSpec.dismissable && this.allowPopup == notifVisualSpec.allowPopup;
        }

        public final ModelDownloadNotifyOp getActionOp() {
            return this.actionOp;
        }

        public final boolean getAllowPopup() {
            return this.allowPopup;
        }

        public final PendingIntent getContentIntent() {
            return this.contentIntent;
        }

        public final ModelDownloadNotifyOp getDismissOp() {
            return this.dismissOp;
        }

        public final boolean getDismissable() {
            return this.dismissable;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final boolean getShowProgressRing() {
            return this.showProgressRing;
        }

        public final NotifState getState() {
            return this.state;
        }

        public final String getStatusText() {
            return this.statusText;
        }

        public int hashCode() {
            int iHashCode = (this.contentIntent.hashCode() + ai.onnxruntime.a.f(a0.a.a(this.progress, v1.d.a(this.state.hashCode() * 31, 31, this.statusText), 31), 31, this.showProgressRing)) * 31;
            ModelDownloadNotifyOp modelDownloadNotifyOp = this.actionOp;
            return Boolean.hashCode(this.allowPopup) + ai.onnxruntime.a.f((this.dismissOp.hashCode() + ((iHashCode + (modelDownloadNotifyOp == null ? 0 : modelDownloadNotifyOp.hashCode())) * 31)) * 31, 31, this.dismissable);
        }

        public String toString() {
            NotifState notifState = this.state;
            String str = this.statusText;
            float f8 = this.progress;
            boolean z = this.showProgressRing;
            PendingIntent pendingIntent = this.contentIntent;
            ModelDownloadNotifyOp modelDownloadNotifyOp = this.actionOp;
            ModelDownloadNotifyOp modelDownloadNotifyOp2 = this.dismissOp;
            boolean z3 = this.dismissable;
            boolean z10 = this.allowPopup;
            StringBuilder sb2 = new StringBuilder("NotifVisualSpec(state=");
            sb2.append(notifState);
            sb2.append(", statusText=");
            sb2.append(str);
            sb2.append(", progress=");
            sb2.append(f8);
            sb2.append(", showProgressRing=");
            sb2.append(z);
            sb2.append(", contentIntent=");
            sb2.append(pendingIntent);
            sb2.append(", actionOp=");
            sb2.append(modelDownloadNotifyOp);
            sb2.append(", dismissOp=");
            sb2.append(modelDownloadNotifyOp2);
            sb2.append(", dismissable=");
            sb2.append(z3);
            sb2.append(", allowPopup=");
            return a0.a.m(sb2, z10, ")");
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public /* synthetic */ NotifVisualSpec(com.stepos.core.common.notification.ModelDownloadNotifier.NotifState r11, java.lang.String r12, float r13, boolean r14, android.app.PendingIntent r15, com.stepos.core.common.notification.ModelDownloadNotifyOp r16, com.stepos.core.common.notification.ModelDownloadNotifyOp r17, boolean r18, boolean r19, int r20, kotlin.jvm.internal.e r21) {
            /*
                r10 = this;
                r0 = r20
                r1 = r0 & 4
                if (r1 == 0) goto L7
                r13 = 0
            L7:
                r3 = r13
                r13 = r0 & 8
                r1 = 0
                if (r13 == 0) goto Lf
                r4 = r1
                goto L10
            Lf:
                r4 = r14
            L10:
                r13 = r0 & 32
                if (r13 == 0) goto L17
                r13 = 0
                r6 = r13
                goto L19
            L17:
                r6 = r16
            L19:
                r13 = r0 & 64
                if (r13 == 0) goto L21
                com.stepos.core.common.notification.ModelDownloadNotifyOp r13 = com.stepos.core.common.notification.ModelDownloadNotifyOp.DISMISS
                r7 = r13
                goto L23
            L21:
                r7 = r17
            L23:
                r13 = r0 & 128(0x80, float:1.8E-43)
                if (r13 == 0) goto L2a
                r13 = 1
                r8 = r13
                goto L2c
            L2a:
                r8 = r18
            L2c:
                r13 = r0 & 256(0x100, float:3.59E-43)
                if (r13 == 0) goto L36
                r9 = r1
                r0 = r10
                r2 = r12
                r5 = r15
                r1 = r11
                goto L3c
            L36:
                r9 = r19
                r0 = r10
                r1 = r11
                r2 = r12
                r5 = r15
            L3c:
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.notification.ModelDownloadNotifier.NotifVisualSpec.<init>(com.stepos.core.common.notification.ModelDownloadNotifier$NotifState, java.lang.String, float, boolean, android.app.PendingIntent, com.stepos.core.common.notification.ModelDownloadNotifyOp, com.stepos.core.common.notification.ModelDownloadNotifyOp, boolean, boolean, int, kotlin.jvm.internal.e):void");
        }
    }
}
