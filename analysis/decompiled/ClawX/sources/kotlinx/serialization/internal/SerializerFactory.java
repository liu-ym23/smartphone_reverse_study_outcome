package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0005\"\u0006\u0012\u0002\b\u00030\u0003H¦\u0080\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkotlinx/serialization/internal/SerializerFactory;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serializer", "Lkotlinx/serialization/KSerializer;", "typeParamsSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "([Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SerializerFactory {
    KSerializer<?> serializer(KSerializer<?>... typeParamsSerializers);
}
