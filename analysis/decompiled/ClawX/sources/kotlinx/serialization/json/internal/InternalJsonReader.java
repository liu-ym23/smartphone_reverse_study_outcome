package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@JsonFriendModuleApi
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H¦\u0080\u0004¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/internal/InternalJsonReader;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "read", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "buffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "bufferOffset", "count", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface InternalJsonReader {
    int read(char[] buffer, int bufferOffset, int count);
}
