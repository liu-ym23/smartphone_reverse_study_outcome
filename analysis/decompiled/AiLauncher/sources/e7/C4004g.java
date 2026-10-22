package e7;

import La.H;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.MultiCollectionHit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Le7/g;", "", "<init>", "()V", "", "Le7/g$a;", "results", "", "topK", "rrfK", "Lcom/stepos/datacenter/vector/MultiCollectionHit;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;II)Ljava/util/List;", "", "weights", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e7.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4004g {

    /* renamed from: a, reason: collision with root package name */
    public static final C4004g f32305a = new C4004g();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b¨\u0006\u001c"}, d2 = {"Le7/g$a;", "", "", "collectionId", "", "weight", "", "Le7/g$b;", "entries", "<init>", "(Ljava/lang/String;FLjava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "F", "c", "()F", "Ljava/util/List;", "()Ljava/util/List;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.g$a, reason: from toString */
    public static final /* data */ class CollectionResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String collectionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float weight;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<RankedEntry> entries;

        public CollectionResult(String collectionId, float f10, List<RankedEntry> entries) {
            kotlin.jvm.internal.p.i(collectionId, "collectionId");
            kotlin.jvm.internal.p.i(entries, "entries");
            this.collectionId = collectionId;
            this.weight = f10;
            this.entries = entries;
        }

        /* renamed from: a, reason: from getter */
        public final String getCollectionId() {
            return this.collectionId;
        }

        public final List<RankedEntry> b() {
            return this.entries;
        }

        /* renamed from: c, reason: from getter */
        public final float getWeight() {
            return this.weight;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CollectionResult)) {
                return false;
            }
            CollectionResult collectionResult = (CollectionResult) other;
            return kotlin.jvm.internal.p.d(this.collectionId, collectionResult.collectionId) && Float.compare(this.weight, collectionResult.weight) == 0 && kotlin.jvm.internal.p.d(this.entries, collectionResult.entries);
        }

        public int hashCode() {
            return (((this.collectionId.hashCode() * 31) + Float.hashCode(this.weight)) * 31) + this.entries.hashCode();
        }

        public String toString() {
            return "CollectionResult(collectionId=" + this.collectionId + ", weight=" + this.weight + ", entries=" + this.entries + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\r¨\u0006\u0019"}, d2 = {"Le7/g$b;", "", "", "entityId", "", "entityClassName", "", "rank", "<init>", "(JLjava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "Ljava/lang/String;", "c", "I", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.g$b, reason: from toString */
    public static final /* data */ class RankedEntry {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final long entityId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String entityClassName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int rank;

        public RankedEntry(long j10, String entityClassName, int i10) {
            kotlin.jvm.internal.p.i(entityClassName, "entityClassName");
            this.entityId = j10;
            this.entityClassName = entityClassName;
            this.rank = i10;
        }

        /* renamed from: a, reason: from getter */
        public final String getEntityClassName() {
            return this.entityClassName;
        }

        /* renamed from: b, reason: from getter */
        public final long getEntityId() {
            return this.entityId;
        }

        /* renamed from: c, reason: from getter */
        public final int getRank() {
            return this.rank;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RankedEntry)) {
                return false;
            }
            RankedEntry rankedEntry = (RankedEntry) other;
            return this.entityId == rankedEntry.entityId && kotlin.jvm.internal.p.d(this.entityClassName, rankedEntry.entityClassName) && this.rank == rankedEntry.rank;
        }

        public int hashCode() {
            return (((Long.hashCode(this.entityId) * 31) + this.entityClassName.hashCode()) * 31) + Integer.hashCode(this.rank);
        }

        public String toString() {
            return "RankedEntry(entityId=" + this.entityId + ", entityClassName=" + this.entityClassName + ", rank=" + this.rank + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.g$c */
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Float.valueOf(((Acc) ((Map.Entry) t11).getValue()).getScore()), Float.valueOf(((Acc) ((Map.Entry) t10).getValue()).getScore()));
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.g$d */
    public static final class d<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f32312a;

        public d(Comparator comparator) {
            this.f32312a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f32312a.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d((Comparable) ((Map.Entry) t10).getKey(), (Comparable) ((Map.Entry) t11).getKey());
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.g$e */
    public static final class e<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f32313a;

        public e(Comparator comparator) {
            this.f32313a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f32313a.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(Integer.valueOf(((Acc) ((Map.Entry) t11).getValue()).b().size()), Integer.valueOf(((Acc) ((Map.Entry) t10).getValue()).b().size()));
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\"\u001a\u0004\b\u0019\u0010#¨\u0006$"}, d2 = {"e7/g$f", "", "", "className", "", "score", "", "", "ranks", "", "matched", "<init>", "(Ljava/lang/String;FLjava/util/Map;Ljava/util/Set;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "F", Const.INTENT_KEY_UMID, "()F", "f", "(F)V", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "Ljava/util/Set;", "()Ljava/util/Set;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.g$f, reason: from toString */
    public static final /* data */ class Acc {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public String className;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public float score;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Map<String, Integer> ranks;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Set<String> matched;

        public Acc(String className, float f10, Map<String, Integer> ranks, Set<String> matched) {
            kotlin.jvm.internal.p.i(className, "className");
            kotlin.jvm.internal.p.i(ranks, "ranks");
            kotlin.jvm.internal.p.i(matched, "matched");
            this.className = className;
            this.score = f10;
            this.ranks = ranks;
            this.matched = matched;
        }

        /* renamed from: a, reason: from getter */
        public final String getClassName() {
            return this.className;
        }

        public final Set<String> b() {
            return this.matched;
        }

        public final Map<String, Integer> c() {
            return this.ranks;
        }

        /* renamed from: d, reason: from getter */
        public final float getScore() {
            return this.score;
        }

        public final void e(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.className = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Acc)) {
                return false;
            }
            Acc acc = (Acc) other;
            return kotlin.jvm.internal.p.d(this.className, acc.className) && Float.compare(this.score, acc.score) == 0 && kotlin.jvm.internal.p.d(this.ranks, acc.ranks) && kotlin.jvm.internal.p.d(this.matched, acc.matched);
        }

        public final void f(float f10) {
            this.score = f10;
        }

        public int hashCode() {
            return (((((this.className.hashCode() * 31) + Float.hashCode(this.score)) * 31) + this.ranks.hashCode()) * 31) + this.matched.hashCode();
        }

        public String toString() {
            return "Acc(className=" + this.className + ", score=" + this.score + ", ranks=" + this.ranks + ", matched=" + this.matched + ")";
        }
    }

    public final List<MultiCollectionHit> a(List<CollectionResult> results, int topK, int rrfK) {
        kotlin.jvm.internal.p.i(results, "results");
        if (topK <= 0) {
            throw new IllegalArgumentException("topK must be > 0");
        }
        if (results.isEmpty()) {
            return C1173v.m();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (CollectionResult collectionResult : results) {
            if (collectionResult.getWeight() > 0.0f) {
                for (RankedEntry rankedEntry : collectionResult.b()) {
                    Long lValueOf = Long.valueOf(rankedEntry.getEntityId());
                    Object acc = linkedHashMap.get(lValueOf);
                    if (acc == null) {
                        acc = new Acc(rankedEntry.getEntityClassName(), 0.0f, new LinkedHashMap(), new LinkedHashSet());
                        linkedHashMap.put(lValueOf, acc);
                    }
                    Acc acc2 = (Acc) acc;
                    if (H.x0(acc2.getClassName()) && !H.x0(rankedEntry.getEntityClassName())) {
                        acc2.e(rankedEntry.getEntityClassName());
                    }
                    acc2.f(acc2.getScore() + (collectionResult.getWeight() / (rankedEntry.getRank() + rrfK)));
                    acc2.c().put(collectionResult.getCollectionId(), Integer.valueOf(rankedEntry.getRank()));
                    acc2.b().add(collectionResult.getCollectionId());
                }
            }
        }
        Set setEntrySet = linkedHashMap.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        List<Map.Entry> listF1 = F.f1(F.c1(setEntrySet, new d(new e(new c()))), topK);
        ArrayList arrayList = new ArrayList(C1174w.x(listF1, 10));
        for (Map.Entry entry : listF1) {
            kotlin.jvm.internal.p.f(entry);
            Object key = entry.getKey();
            kotlin.jvm.internal.p.h(key, "component1(...)");
            Object value = entry.getValue();
            kotlin.jvm.internal.p.h(value, "component2(...)");
            Acc acc3 = (Acc) value;
            arrayList.add(new MultiCollectionHit(((Long) key).longValue(), acc3.getClassName(), acc3.getScore(), kotlin.collections.a.A(acc3.c()), F.r1(acc3.b())));
        }
        return arrayList;
    }

    public final List<Float> b(List<Float> weights) {
        kotlin.jvm.internal.p.i(weights, "weights");
        List<Float> list = weights;
        double dFloatValue = 0.0d;
        while (list.iterator().hasNext()) {
            dFloatValue += ((Number) r0.next()).floatValue();
        }
        if (dFloatValue > 0.0d) {
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf((float) (((Number) it.next()).floatValue() / dFloatValue)));
            }
            return arrayList;
        }
        int size = weights.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(Float.valueOf(0.0f));
        }
        return arrayList2;
    }
}
