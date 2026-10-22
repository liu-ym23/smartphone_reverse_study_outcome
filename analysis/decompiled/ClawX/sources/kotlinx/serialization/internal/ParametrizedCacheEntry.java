package kotlinx.serialization.internal;

import b5.i;
import c5.o;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004JF\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\u000fH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u0005\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t0\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializers", "Ljava/util/concurrent/ConcurrentHashMap;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "computeIfAbsent", "types", "Lkotlin/reflect/KType;", "producer", "Lkotlin/Function0;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
final class ParametrizedCacheEntry<T> {
    private final ConcurrentHashMap<List<KTypeWrapper>, i> serializers = new ConcurrentHashMap<>();

    /* renamed from: computeIfAbsent-gIAlu-s, reason: not valid java name */
    public final Object m3computeIfAbsentgIAlus(List<? extends v5.i> types, p5.a producer) {
        Object objO;
        p.e(types, "types");
        p.e(producer, "producer");
        ArrayList arrayList = new ArrayList(o.n0(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeWrapper((v5.i) it.next()));
        }
        ConcurrentHashMap concurrentHashMap = this.serializers;
        Object obj = concurrentHashMap.get(arrayList);
        if (obj == null) {
            try {
                objO = (KSerializer) producer.invoke();
            } catch (Throwable th) {
                objO = a.a.o(th);
            }
            i iVar = new i(objO);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, iVar);
            obj = objPutIfAbsent == null ? iVar : objPutIfAbsent;
        }
        return ((i) obj).f895a;
    }
}
