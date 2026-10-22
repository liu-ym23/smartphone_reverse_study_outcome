package com.stepos.stepclaw.edge;

import a6.w;
import android.content.Context;
import c5.o;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.NotificationListenerBridge;
import com.stepos.stepclaw.edge.DeviceNotificationListenerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0006\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/edge/NotificationListenerBridgeImpl;", "Lcom/stepos/stepclaw/bridge/spi/NotificationListenerBridge;", "<init>", "()V", "Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;", "Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationSnapshot;", "toSpi", "(Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;)Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationSnapshot;", "Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;", "Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationEntry;", "(Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;)Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationEntry;", "Landroid/content/Context;", "context", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isAccessEnabled", "(Landroid/content/Context;)Z", "snapshot", "(Landroid/content/Context;)Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationSnapshot;", "Lb5/a0;", "requestServiceRebind", "(Landroid/content/Context;)V", "Lcom/stepos/stepclaw/bridge/spi/NotificationActionRequest;", "request", "Lcom/stepos/stepclaw/bridge/spi/NotificationActionResult;", "executeAction", "(Landroid/content/Context;Lcom/stepos/stepclaw/bridge/spi/NotificationActionRequest;)Lcom/stepos/stepclaw/bridge/spi/NotificationActionResult;", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NotificationListenerBridgeImpl implements NotificationListenerBridge {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/stepos/stepclaw/edge/NotificationListenerBridgeImpl$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "create", "Lcom/stepos/stepclaw/bridge/spi/NotificationListenerBridge;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final NotificationListenerBridge create() {
            return new NotificationListenerBridgeImpl();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.stepos.stepclaw.bridge.spi.NotificationActionKind.values().length];
            try {
                iArr[com.stepos.stepclaw.bridge.spi.NotificationActionKind.Open.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.stepos.stepclaw.bridge.spi.NotificationActionKind.Dismiss.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.stepos.stepclaw.bridge.spi.NotificationActionKind.Reply.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final NotificationListenerBridge create() {
        return INSTANCE.create();
    }

    private final com.stepos.stepclaw.bridge.spi.DeviceNotificationSnapshot toSpi(DeviceNotificationSnapshot deviceNotificationSnapshot) {
        boolean enabled = deviceNotificationSnapshot.getEnabled();
        boolean connected = deviceNotificationSnapshot.getConnected();
        List<DeviceNotificationEntry> notifications = deviceNotificationSnapshot.getNotifications();
        ArrayList arrayList = new ArrayList(o.n0(notifications, 10));
        Iterator<T> it = notifications.iterator();
        while (it.hasNext()) {
            arrayList.add(toSpi((DeviceNotificationEntry) it.next()));
        }
        return new com.stepos.stepclaw.bridge.spi.DeviceNotificationSnapshot(enabled, connected, arrayList);
    }

    @Override // com.stepos.stepclaw.bridge.spi.NotificationListenerBridge
    public com.stepos.stepclaw.bridge.spi.NotificationActionResult executeAction(Context context, com.stepos.stepclaw.bridge.spi.NotificationActionRequest request) {
        NotificationActionKind notificationActionKind;
        p.e(context, "context");
        p.e(request, "request");
        String key = request.getKey();
        int i8 = WhenMappings.$EnumSwitchMapping$0[request.getKind().ordinal()];
        if (i8 == 1) {
            notificationActionKind = NotificationActionKind.Open;
        } else if (i8 == 2) {
            notificationActionKind = NotificationActionKind.Dismiss;
        } else {
            if (i8 != 3) {
                throw new w();
            }
            notificationActionKind = NotificationActionKind.Reply;
        }
        NotificationActionResult notificationActionResultExecuteAction = DeviceNotificationListenerService.INSTANCE.executeAction(context, new NotificationActionRequest(key, notificationActionKind, request.getReplyText()));
        return new com.stepos.stepclaw.bridge.spi.NotificationActionResult(notificationActionResultExecuteAction.getOk(), notificationActionResultExecuteAction.getCode(), notificationActionResultExecuteAction.getMessage());
    }

    @Override // com.stepos.stepclaw.bridge.spi.NotificationListenerBridge
    public boolean isAccessEnabled(Context context) {
        p.e(context, "context");
        return DeviceNotificationListenerService.INSTANCE.isAccessEnabled(context);
    }

    @Override // com.stepos.stepclaw.bridge.spi.NotificationListenerBridge
    public void requestServiceRebind(Context context) {
        p.e(context, "context");
        DeviceNotificationListenerService.INSTANCE.requestServiceRebind(context);
    }

    @Override // com.stepos.stepclaw.bridge.spi.NotificationListenerBridge
    public com.stepos.stepclaw.bridge.spi.DeviceNotificationSnapshot snapshot(Context context) {
        p.e(context, "context");
        DeviceNotificationListenerService.Companion companion = DeviceNotificationListenerService.INSTANCE;
        return !companion.isAccessEnabled(context) ? new com.stepos.stepclaw.bridge.spi.DeviceNotificationSnapshot(false, false, s.f1092a) : toSpi(companion.snapshot(context, true));
    }

    private final com.stepos.stepclaw.bridge.spi.DeviceNotificationEntry toSpi(DeviceNotificationEntry deviceNotificationEntry) {
        return new com.stepos.stepclaw.bridge.spi.DeviceNotificationEntry(deviceNotificationEntry.getKey(), deviceNotificationEntry.getPackageName(), deviceNotificationEntry.getTitle(), deviceNotificationEntry.getText(), deviceNotificationEntry.getSubText(), deviceNotificationEntry.getCategory(), deviceNotificationEntry.getChannelId(), deviceNotificationEntry.getPostTimeMs(), deviceNotificationEntry.isOngoing(), deviceNotificationEntry.isClearable());
    }
}
