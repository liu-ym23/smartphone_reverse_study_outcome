package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H¦\u0080\u0004J\u0016\u0010\u0007\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0080\u0004¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/internal/SerializerCache;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "get", "Lkotlinx/serialization/KSerializer;", "key", "Lkotlin/reflect/KClass;", "isStored", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SerializerCache<T> {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean isStored(SerializerCache<T> serializerCache, v5.c key) {
            p.e(key, "key");
            return SerializerCache.super.isStored(key);
        }
    }

    KSerializer<T> get(v5.c cVar);

    default boolean isStored(v5.c key) {
        p.e(key, "key");
        return false;
    }
}
