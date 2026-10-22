package com.stepos.stepclaw.edge;

import a.a;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u001dj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/stepclaw/edge/DeviceNotificationStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;", "entries", "Lb5/a0;", "replace", "(Ljava/util/List;)V", "entry", "upsert", "(Lcom/stepos/stepclaw/edge/DeviceNotificationEntry;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", "remove", "(Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", "setConnected", "(Z)V", ExtensionCallContract.ENABLED, "Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;", "snapshot", "(Z)Lcom/stepos/stepclaw/edge/DeviceNotificationSnapshot;", "lock", "Ljava/lang/Object;", "connected", "Z", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "byKey", "Ljava/util/LinkedHashMap;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
final class DeviceNotificationStore {
    private static boolean connected;
    public static final DeviceNotificationStore INSTANCE = new DeviceNotificationStore();
    private static final Object lock = new Object();
    private static final LinkedHashMap<String, DeviceNotificationEntry> byKey = new LinkedHashMap<>();

    private DeviceNotificationStore() {
    }

    public final void remove(String key) {
        p.e(key, "key");
        synchronized (lock) {
            byKey.remove(key);
        }
    }

    public final void replace(List<DeviceNotificationEntry> entries) {
        p.e(entries, "entries");
        synchronized (lock) {
            byKey.clear();
            for (DeviceNotificationEntry deviceNotificationEntry : entries) {
                byKey.put(deviceNotificationEntry.getKey(), deviceNotificationEntry);
            }
        }
    }

    public final void setConnected(boolean value) {
        synchronized (lock) {
            connected = value;
            if (!value) {
                byKey.clear();
            }
        }
    }

    public final DeviceNotificationSnapshot snapshot(boolean enabled) {
        Boolean boolValueOf;
        List listJ0;
        synchronized (lock) {
            boolValueOf = Boolean.valueOf(connected);
            Collection<DeviceNotificationEntry> collectionValues = byKey.values();
            p.d(collectionValues, "<get-values>(...)");
            listJ0 = m.J0(collectionValues, new Comparator() { // from class: com.stepos.stepclaw.edge.DeviceNotificationStore$snapshot$lambda$0$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    return a.l(Long.valueOf(((DeviceNotificationEntry) t9).getPostTimeMs()), Long.valueOf(((DeviceNotificationEntry) t8).getPostTimeMs()));
                }
            });
        }
        return new DeviceNotificationSnapshot(enabled, boolValueOf.booleanValue(), listJ0);
    }

    public final void upsert(DeviceNotificationEntry entry) {
        p.e(entry, "entry");
        synchronized (lock) {
            byKey.put(entry.getKey(), entry);
        }
    }
}
