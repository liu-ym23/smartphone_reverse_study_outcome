package com.stepos.core.ota.process;

import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.PauseReason;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaSnapshotMerge {
    public static final OtaSnapshotMerge INSTANCE = new OtaSnapshotMerge();

    private OtaSnapshotMerge() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map mergeForProcessExit$default(OtaSnapshotMerge otaSnapshotMerge, Map map, Map map2, Set set, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            set = EmptySet.f10003a;
        }
        return otaSnapshotMerge.mergeForProcessExit(map, map2, set);
    }

    private final OtaStateSnapshot neutralizeActive(OtaStateSnapshot otaStateSnapshot) {
        OtaState state = otaStateSnapshot.getState();
        OtaState.Downloading downloading = state instanceof OtaState.Downloading ? (OtaState.Downloading) state : null;
        int progress = downloading != null ? downloading.getProgress() : otaStateSnapshot.getProgress();
        return OtaStateSnapshot.copy$default(otaStateSnapshot, null, new OtaState.Paused(PauseReason.USER, progress), progress, 0, 0L, null, null, false, false, false, 1017, null);
    }

    public final Map<String, OtaStateSnapshot> mergeForProcessExit(Map<String, OtaStateSnapshot> live, Map<String, OtaStateSnapshot> disk, Set<String> uninstalled) {
        g.f(live, "live");
        g.f(disk, "disk");
        g.f(uninstalled, "uninstalled");
        LinkedHashMap linkedHashMap = new LinkedHashMap(disk.size() + live.size());
        for (Map.Entry<String, OtaStateSnapshot> entry : live.entrySet()) {
            String key = entry.getKey();
            OtaStateSnapshot value = entry.getValue();
            if (!uninstalled.contains(key)) {
                if (value.getState().isActive()) {
                    value = INSTANCE.neutralizeActive(value);
                }
                linkedHashMap.put(key, value);
            }
        }
        for (Map.Entry<String, OtaStateSnapshot> entry2 : disk.entrySet()) {
            String key2 = entry2.getKey();
            OtaStateSnapshot value2 = entry2.getValue();
            if (!uninstalled.contains(key2)) {
                linkedHashMap.put(key2, value2);
            }
        }
        return linkedHashMap;
    }
}
