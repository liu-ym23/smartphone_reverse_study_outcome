package kotlinx.serialization.encoding;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlinx.serialization.ExperimentalSerializationApi;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H§\u0080\u0004¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/encoding/ChunkedDecoder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeStringChunked", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "consumeChunk", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/ParameterName;", "name", "chunk", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public interface ChunkedDecoder {
    @ExperimentalSerializationApi
    void decodeStringChunked(l lVar);
}
