package com.stepos.stepclaw.edge;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.ENABLED, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "connected", "notifications", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;", "<init>", "(ZZLjava/util/List;)V", "getEnabled", "()Z", "getConnected", "getNotifications", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DeviceNotificationSnapshot {
    private final boolean connected;
    private final boolean enabled;
    private final List<DeviceNotificationEntry> notifications;

    public DeviceNotificationSnapshot(boolean z, boolean z2, List<DeviceNotificationEntry> notifications) {
        p.e(notifications, "notifications");
        this.enabled = z;
        this.connected = z2;
        this.notifications = notifications;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceNotificationSnapshot copy$default(DeviceNotificationSnapshot deviceNotificationSnapshot, boolean z, boolean z2, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = deviceNotificationSnapshot.enabled;
        }
        if ((i8 & 2) != 0) {
            z2 = deviceNotificationSnapshot.connected;
        }
        if ((i8 & 4) != 0) {
            list = deviceNotificationSnapshot.notifications;
        }
        return deviceNotificationSnapshot.copy(z, z2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    public final List<DeviceNotificationEntry> component3() {
        return this.notifications;
    }

    public final DeviceNotificationSnapshot copy(boolean enabled, boolean connected, List<DeviceNotificationEntry> notifications) {
        p.e(notifications, "notifications");
        return new DeviceNotificationSnapshot(enabled, connected, notifications);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceNotificationSnapshot)) {
            return false;
        }
        DeviceNotificationSnapshot deviceNotificationSnapshot = (DeviceNotificationSnapshot) other;
        return this.enabled == deviceNotificationSnapshot.enabled && this.connected == deviceNotificationSnapshot.connected && p.a(this.notifications, deviceNotificationSnapshot.notifications);
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<DeviceNotificationEntry> getNotifications() {
        return this.notifications;
    }

    public int hashCode() {
        return this.notifications.hashCode() + b.g(Boolean.hashCode(this.enabled) * 31, 31, this.connected);
    }

    public String toString() {
        return "DeviceNotificationSnapshot(enabled=" + this.enabled + ", connected=" + this.connected + ", notifications=" + this.notifications + ")";
    }
}
