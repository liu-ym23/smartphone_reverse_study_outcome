package e7;

import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.HybridSearchHit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Le7/l;", "", "<init>", "()V", "", "Lcom/stepos/datacenter/vector/HybridSearchHit;", "hits", "", "", "createdAtMs", "nowMs", "", "halfLifeDays", "", "accessCounts", "accessWeight", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Ljava/util/Map;JFLjava/util/Map;F)Ljava/util/List;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f32323a = new l();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Float.valueOf(((HybridSearchHit) t11).getCombinedScore()), Float.valueOf(((HybridSearchHit) t10).getCombinedScore()));
        }
    }

    public static /* synthetic */ List b(l lVar, List list, Map map, long j10, float f10, Map map2, float f11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = System.currentTimeMillis();
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            f10 = 30.0f;
        }
        return lVar.a(list, map, j11, f10, (i10 & 16) != 0 ? kotlin.collections.a.i() : map2, (i10 & 32) != 0 ? 0.1f : f11);
    }

    public final List<HybridSearchHit> a(List<HybridSearchHit> hits, Map<Long, Long> createdAtMs, long nowMs, float halfLifeDays, Map<Long, Integer> accessCounts, float accessWeight) {
        kotlin.jvm.internal.p.i(hits, "hits");
        kotlin.jvm.internal.p.i(createdAtMs, "createdAtMs");
        kotlin.jvm.internal.p.i(accessCounts, "accessCounts");
        if (hits.isEmpty()) {
            return hits;
        }
        if (halfLifeDays <= 0.0f) {
            throw new IllegalArgumentException("halfLifeDays must be > 0");
        }
        double d10 = halfLifeDays * 24 * 3600 * 1000;
        List<HybridSearchHit> list = hits;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (HybridSearchHit hybridSearchHit : list) {
            arrayList.add(HybridSearchHit.copy$default(hybridSearchHit, 0L, null, (float) (hybridSearchHit.getCombinedScore() * (createdAtMs.get(Long.valueOf(hybridSearchHit.getEntityId())) == null ? 1.0d : Math.exp((C5685n.g(nowMs - r6.longValue(), 0L) * (-0.6931471805599453d)) / d10)) * ((accessWeight * Math.log((accessCounts.get(Long.valueOf(hybridSearchHit.getEntityId())) != null ? r6.intValue() : 0) + 1.0d)) + 1.0d)), null, null, null, null, null, 251, null));
        }
        return F.c1(arrayList, new a());
    }
}
