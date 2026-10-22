package com.stepos.stepclaw.bridge.spi;

import android.content.Context;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ImplementedBy;
import com.stepos.stepclaw.base.framework.Lifecycle;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@ImplementedBy(implClass = "com.stepos.stepclaw.edge.NotificationListenerBridgeImpl", lifecycle = Lifecycle.SINGLETON)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/NotificationListenerBridge;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isAccessEnabled", "(Landroid/content/Context;)Z", "Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationSnapshot;", "snapshot", "(Landroid/content/Context;)Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationSnapshot;", "Lb5/a0;", "requestServiceRebind", "(Landroid/content/Context;)V", "Lcom/stepos/stepclaw/bridge/spi/NotificationActionRequest;", "request", "Lcom/stepos/stepclaw/bridge/spi/NotificationActionResult;", "executeAction", "(Landroid/content/Context;Lcom/stepos/stepclaw/bridge/spi/NotificationActionRequest;)Lcom/stepos/stepclaw/bridge/spi/NotificationActionResult;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface NotificationListenerBridge {
    NotificationActionResult executeAction(Context context, NotificationActionRequest request);

    boolean isAccessEnabled(Context context);

    void requestServiceRebind(Context context);

    DeviceNotificationSnapshot snapshot(Context context);
}
