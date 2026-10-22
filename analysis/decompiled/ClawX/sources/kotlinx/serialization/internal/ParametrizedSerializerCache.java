package kotlinx.serialization.internal;

import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import v5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J=\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH¦\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "get", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "key", "Lkotlin/reflect/KClass;", "types", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KType;", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ParametrizedSerializerCache<T> {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: get-gIAlu-s$default, reason: not valid java name */
    static /* synthetic */ Object m4getgIAlus$default(ParametrizedSerializerCache parametrizedSerializerCache, v5.c cVar, List list, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-gIAlu-s");
        }
        if ((i8 & 2) != 0) {
            list = s.f1092a;
        }
        return parametrizedSerializerCache.mo0getgIAlus(cVar, list);
    }

    /* renamed from: get-gIAlu-s */
    Object mo0getgIAlus(v5.c cVar, List<? extends i> list);
}
