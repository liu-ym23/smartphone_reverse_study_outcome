package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\u0080\u0004¨\u0006\u0006"}, d2 = {"createMapForCache", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "K", "V", "initialCapacity", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CreateMapForCacheKt {
    public static final <K, V> Map<K, V> createMapForCache(int i8) {
        return new ConcurrentHashMap(i8);
    }
}
