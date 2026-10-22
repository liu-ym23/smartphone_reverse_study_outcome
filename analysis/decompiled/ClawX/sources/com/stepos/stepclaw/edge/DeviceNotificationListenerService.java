package com.stepos.stepclaw.edge;

import a.a;
import a6.w;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import b5.a0;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/edge/DeviceNotificationListenerService;", "Landroid/service/notification/NotificationListenerService;", "<init>", "()V", "Lb5/a0;", "refreshActiveNotifications", "Landroid/service/notification/StatusBarNotification;", "Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;", "toEntry", "(Landroid/service/notification/StatusBarNotification;)Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;", "Lcom/stepos/stepclaw/edge/NotificationActionRequest;", "request", "Lcom/stepos/stepclaw/edge/NotificationActionResult;", "executeActionInternal", "(Lcom/stepos/stepclaw/edge/NotificationActionRequest;)Lcom/stepos/stepclaw/edge/NotificationActionResult;", "onListenerConnected", "onListenerDisconnected", "onDestroy", "sbn", "onNotificationPosted", "(Landroid/service/notification/StatusBarNotification;)V", "onNotificationRemoved", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceNotificationListenerService extends NotificationListenerService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile DeviceNotificationListenerService activeService;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/edge/DeviceNotificationListenerService$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/ComponentName;", "serviceComponent", "(Landroid/content/Context;)Landroid/content/ComponentName;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isAccessEnabled", "(Landroid/content/Context;)Z", ExtensionCallContract.ENABLED, "Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;", "snapshot", "(Landroid/content/Context;Z)Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;", "Lb5/a0;", "requestServiceRebind", "(Landroid/content/Context;)V", "Lcom/stepos/stepclaw/edge/NotificationActionRequest;", "request", "Lcom/stepos/stepclaw/edge/NotificationActionResult;", "executeAction", "(Landroid/content/Context;Lcom/stepos/stepclaw/edge/NotificationActionRequest;)Lcom/stepos/stepclaw/edge/NotificationActionResult;", "Lcom/stepos/stepclaw/edge/DeviceNotificationListenerService;", "activeService", "Lcom/stepos/stepclaw/edge/DeviceNotificationListenerService;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final ComponentName serviceComponent(Context context) {
            return new ComponentName(context, (Class<?>) DeviceNotificationListenerService.class);
        }

        public static /* synthetic */ DeviceNotificationSnapshot snapshot$default(Companion companion, Context context, boolean z, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                z = companion.isAccessEnabled(context);
            }
            return companion.snapshot(context, z);
        }

        public final NotificationActionResult executeAction(Context context, NotificationActionRequest request) {
            p.e(context, "context");
            p.e(request, "request");
            if (!isAccessEnabled(context)) {
                return new NotificationActionResult(false, "NOTIFICATIONS_DISABLED", "NOTIFICATIONS_DISABLED: enable notification access in system Settings");
            }
            DeviceNotificationListenerService deviceNotificationListenerService = DeviceNotificationListenerService.activeService;
            return deviceNotificationListenerService == null ? new NotificationActionResult(false, "NOTIFICATIONS_UNAVAILABLE", "NOTIFICATIONS_UNAVAILABLE: notification listener not connected") : deviceNotificationListenerService.executeActionInternal(request);
        }

        public final boolean isAccessEnabled(Context context) {
            p.e(context, "context");
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager == null) {
                return false;
            }
            return notificationManager.isNotificationListenerAccessGranted(serviceComponent(context));
        }

        public final void requestServiceRebind(Context context) {
            p.e(context, "context");
            try {
                NotificationListenerService.requestRebind(serviceComponent(context));
            } catch (Throwable th) {
                a.o(th);
            }
        }

        public final DeviceNotificationSnapshot snapshot(Context context, boolean enabled) {
            p.e(context, "context");
            return DeviceNotificationStore.INSTANCE.snapshot(enabled);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationActionKind.values().length];
            try {
                iArr[NotificationActionKind.Open.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationActionKind.Dismiss.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotificationActionKind.Reply.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationActionResult executeActionInternal(NotificationActionRequest request) {
        Notification.Action action;
        StatusBarNotification statusBarNotification;
        RemoteInput[] remoteInputs;
        StatusBarNotification[] activeNotifications = getActiveNotifications();
        if (activeNotifications != null) {
            int length = activeNotifications.length;
            int i8 = 0;
            while (true) {
                action = null;
                if (i8 >= length) {
                    statusBarNotification = null;
                    break;
                }
                statusBarNotification = activeNotifications[i8];
                if (p.a(statusBarNotification.getKey(), request.getKey())) {
                    break;
                }
                i8++;
            }
            if (statusBarNotification != null) {
                if (DeviceNotificationListenerServiceKt.actionRequiresClearableNotification(request.getKind()) && !statusBarNotification.isClearable()) {
                    return new NotificationActionResult(false, "NOTIFICATION_NOT_CLEARABLE", "NOTIFICATION_NOT_CLEARABLE: notification is ongoing or protected");
                }
                int i9 = WhenMappings.$EnumSwitchMapping$0[request.getKind().ordinal()];
                Object objO = a0.f883a;
                if (i9 == 1) {
                    PendingIntent pendingIntent = statusBarNotification.getNotification().contentIntent;
                    if (pendingIntent == null) {
                        return new NotificationActionResult(false, "ACTION_UNAVAILABLE", "ACTION_UNAVAILABLE: notification has no open action");
                    }
                    try {
                        pendingIntent.send();
                    } catch (Throwable th) {
                        objO = a.o(th);
                    }
                    Throwable thA = b5.i.a(objO);
                    if (thA == null) {
                        return new NotificationActionResult(true, null, null, 6, null);
                    }
                    String message = thA.getMessage();
                    if (message == null) {
                        message = "open failed";
                    }
                    return new NotificationActionResult(false, "ACTION_FAILED", "ACTION_FAILED: ".concat(message));
                }
                if (i9 == 2) {
                    try {
                        cancelNotification(statusBarNotification.getKey());
                        DeviceNotificationStore deviceNotificationStore = DeviceNotificationStore.INSTANCE;
                        String key = statusBarNotification.getKey();
                        p.d(key, "getKey(...)");
                        deviceNotificationStore.remove(key);
                    } catch (Throwable th2) {
                        objO = a.o(th2);
                    }
                    Throwable thA2 = b5.i.a(objO);
                    if (thA2 == null) {
                        return new NotificationActionResult(true, null, null, 6, null);
                    }
                    String message2 = thA2.getMessage();
                    if (message2 == null) {
                        message2 = "dismiss failed";
                    }
                    return new NotificationActionResult(false, "ACTION_FAILED", "ACTION_FAILED: ".concat(message2));
                }
                if (i9 != 3) {
                    throw new w();
                }
                String replyText = request.getReplyText();
                String string = replyText != null ? n.T1(replyText).toString() : null;
                if (string == null) {
                    string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                }
                if (string.length() == 0) {
                    return new NotificationActionResult(false, "INVALID_REQUEST", "INVALID_REQUEST: replyText required for reply action");
                }
                Notification.Action[] actionArr = statusBarNotification.getNotification().actions;
                if (actionArr != null) {
                    int length2 = actionArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        }
                        Notification.Action action2 = actionArr[i10];
                        if (action2.actionIntent != null && (remoteInputs = action2.getRemoteInputs()) != null && remoteInputs.length != 0) {
                            action = action2;
                            break;
                        }
                        i10++;
                    }
                    if (action != null) {
                        RemoteInput[] remoteInputs2 = action.getRemoteInputs();
                        if (remoteInputs2 == null) {
                            remoteInputs2 = new RemoteInput[0];
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        for (RemoteInput remoteInput : remoteInputs2) {
                            bundle.putCharSequence(remoteInput.getResultKey(), string);
                        }
                        RemoteInput.addResultsToIntent(remoteInputs2, intent, bundle);
                        try {
                            action.actionIntent.send(this, 0, intent);
                        } catch (Throwable th3) {
                            objO = a.o(th3);
                        }
                        Throwable thA3 = b5.i.a(objO);
                        if (thA3 == null) {
                            return new NotificationActionResult(true, null, null, 6, null);
                        }
                        String message3 = thA3.getMessage();
                        if (message3 == null) {
                            message3 = "reply failed";
                        }
                        return new NotificationActionResult(false, "ACTION_FAILED", "ACTION_FAILED: ".concat(message3));
                    }
                }
                return new NotificationActionResult(false, "ACTION_UNAVAILABLE", "ACTION_UNAVAILABLE: notification has no reply action");
            }
        }
        return new NotificationActionResult(false, "NOTIFICATION_NOT_FOUND", "NOTIFICATION_NOT_FOUND: notification key not found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [b5.h] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    private final void refreshActiveNotifications() {
        ?? O;
        s sVar = s.f1092a;
        try {
            StatusBarNotification[] activeNotifications = getActiveNotifications();
            if (activeNotifications != null) {
                O = new ArrayList();
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    p.b(statusBarNotification);
                    DeviceNotificationEntry entry = toEntry(statusBarNotification);
                    if (entry != null) {
                        O.add(entry);
                    }
                }
            } else {
                O = sVar;
            }
        } catch (Throwable th) {
            O = a.o(th);
        }
        if (b5.i.a(O) == null) {
            sVar = O;
        }
        DeviceNotificationStore.INSTANCE.replace(sVar);
    }

    private final DeviceNotificationEntry toEntry(StatusBarNotification statusBarNotification) {
        String str;
        String string;
        String string2;
        Bundle bundle = statusBarNotification.getNotification().extras;
        String key = statusBarNotification.getKey();
        p.b(key);
        String str2 = null;
        if (n.t1(key)) {
            key = null;
        }
        if (key == null) {
            key = statusBarNotification.getPackageName() + ":" + statusBarNotification.getId() + ":" + statusBarNotification.getPostTime();
        }
        String str3 = key;
        String strSanitizeNotificationText = DeviceNotificationListenerServiceKt.sanitizeNotificationText(bundle != null ? bundle.getCharSequence("android.title") : null);
        String strSanitizeNotificationText2 = DeviceNotificationListenerServiceKt.sanitizeNotificationText(bundle != null ? bundle.getCharSequence("android.bigText") : null);
        if (strSanitizeNotificationText2 == null) {
            strSanitizeNotificationText2 = DeviceNotificationListenerServiceKt.sanitizeNotificationText(bundle != null ? bundle.getCharSequence("android.text") : null);
        }
        String str4 = strSanitizeNotificationText2;
        String strSanitizeNotificationText3 = DeviceNotificationListenerServiceKt.sanitizeNotificationText(bundle != null ? bundle.getCharSequence("android.subText") : null);
        String packageName = statusBarNotification.getPackageName();
        p.d(packageName, "getPackageName(...)");
        String str5 = statusBarNotification.getNotification().category;
        if (str5 == null || (string2 = n.T1(str5).toString()) == null) {
            str = null;
        } else {
            if (string2.length() == 0) {
                string2 = null;
            }
            str = string2;
        }
        String channelId = statusBarNotification.getNotification().getChannelId();
        if (channelId != null && (string = n.T1(channelId).toString()) != null && string.length() != 0) {
            str2 = string;
        }
        return new DeviceNotificationEntry(str3, packageName, strSanitizeNotificationText, str4, strSanitizeNotificationText3, str, str2, statusBarNotification.getPostTime(), statusBarNotification.isOngoing(), statusBarNotification.isClearable());
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        if (activeService == this) {
            activeService = null;
        }
        super.onDestroy();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        activeService = this;
        DeviceNotificationStore.INSTANCE.setConnected(true);
        refreshActiveNotifications();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        if (activeService == this) {
            activeService = null;
        }
        DeviceNotificationStore.INSTANCE.setConnected(false);
        super.onListenerDisconnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn) {
        DeviceNotificationEntry entry;
        super.onNotificationPosted(sbn);
        if (sbn == null || (entry = toEntry(sbn)) == null) {
            return;
        }
        DeviceNotificationStore.INSTANCE.upsert(entry);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        if (sbn == null) {
            return;
        }
        String key = sbn.getKey();
        p.d(key, "getKey(...)");
        String string = n.T1(key).toString();
        if (string.length() == 0) {
            return;
        }
        DeviceNotificationStore.INSTANCE.remove(string);
    }
}
