package com.stepos.stepclaw.memory.lightmem.remote;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002¨\u0006\b"}, d2 = {"memoryBucketItemCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "memoryBucketsHaveNoItems", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OfflineEvolutionModelsKt {
    public static final int memoryBucketItemCount(Map<String, ? extends List<CatchMemoryItem>> map) {
        p.e(map, "<this>");
        Iterator<T> it = map.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((List) it.next()).size();
        }
        return size;
    }

    public static final boolean memoryBucketsHaveNoItems(Map<String, ? extends List<CatchMemoryItem>> map) {
        p.e(map, "<this>");
        return memoryBucketItemCount(map) == 0;
    }
}
