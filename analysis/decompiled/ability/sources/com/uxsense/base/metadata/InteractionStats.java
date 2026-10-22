package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.d0;
import C7.f;
import D7.v;
import N9.j;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002BCBS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rB[\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0017J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0017J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0017J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0017J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0017J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b$\u0010%J\\\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020-2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/J'\u00108\u001a\u0002052\u0006\u00100\u001a\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b6\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00109\u001a\u0004\b;\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b<\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00109\u001a\u0004\b=\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00109\u001a\u0004\b>\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b?\u0010\u0017R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010@\u001a\u0004\bA\u0010%¨\u0006D"}, d2 = {"Lcom/uxsense/base/metadata/InteractionStats;", "", "", "likeCount", "starCount", "shareCount", "commentCount", "viewCount", "lastInteractionAt", "", "Lcom/uxsense/base/metadata/InteractionBucket;", "buckets", AppAgent.CONSTRUCT, "(JJJJJJLjava/util/List;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJJJJJJLjava/util/List;LB9/d0;)V", "hours", "totalInLastHours", "(I)J", "hot1h", "()J", "hot6h", "hot24h", "hot7d", "other", "mergeWith", "(Lcom/uxsense/base/metadata/InteractionStats;)Lcom/uxsense/base/metadata/InteractionStats;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "()Ljava/util/List;", "copy", "(JJJJJJLjava/util/List;)Lcom/uxsense/base/metadata/InteractionStats;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/InteractionStats;LA9/d;Lz9/g;)V", "write$Self", "J", "getLikeCount", "getStarCount", "getShareCount", "getCommentCount", "getViewCount", "getLastInteractionAt", "Ljava/util/List;", "getBuckets", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InteractionStats {
    private final List<InteractionBucket> buckets;
    private final long commentCount;
    private final long lastInteractionAt;
    private final long likeCount;
    private final long shareCount;
    private final long starCount;
    private final long viewCount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f[] $childSerializers = {null, null, null, null, null, null, kotlin.a.b(LazyThreadSafetyMode.b, new a(3))};

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/uxsense/base/metadata/InteractionStats$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "Lcom/uxsense/base/metadata/InteractionBucket;", "buckets1", "buckets2", "mergeBuckets", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lx9/b;", "Lcom/uxsense/base/metadata/InteractionStats;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<InteractionBucket> mergeBuckets(List<InteractionBucket> buckets1, List<InteractionBucket> buckets2) {
            Iterator it;
            InteractionBucket interactionBucket;
            if (buckets1.isEmpty()) {
                return buckets2;
            }
            if (buckets2.isEmpty()) {
                return buckets1;
            }
            ArrayList arrayListQ0 = v.Q0(buckets2, buckets1);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it2 = arrayListQ0.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Long lValueOf = Long.valueOf(((InteractionBucket) next).getTimestamp());
                Object arrayList = linkedHashMap.get(lValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(lValueOf, arrayList);
                }
                ((List) arrayList).add(next);
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            Iterator it3 = linkedHashMap.entrySet().iterator();
            while (it3.hasNext()) {
                List list = (List) ((Map.Entry) it3.next()).getValue();
                if (list.size() == 1) {
                    interactionBucket = (InteractionBucket) v.A0(list);
                    it = it3;
                } else {
                    Iterator it4 = list.iterator();
                    if (!it4.hasNext()) {
                        throw new UnsupportedOperationException("Empty collection can't be reduced.");
                    }
                    Object next2 = it4.next();
                    while (it4.hasNext()) {
                        InteractionBucket interactionBucket2 = (InteractionBucket) it4.next();
                        InteractionBucket interactionBucket3 = (InteractionBucket) next2;
                        it3 = it3;
                        it4 = it4;
                        next2 = new InteractionBucket(interactionBucket3.getTimestamp(), Math.max(interactionBucket3.getLike(), interactionBucket2.getLike()), Math.max(interactionBucket3.getStar(), interactionBucket2.getStar()), Math.max(interactionBucket3.getShare(), interactionBucket2.getShare()), Math.max(interactionBucket3.getComment(), interactionBucket2.getComment()), Math.max(interactionBucket3.getView(), interactionBucket2.getView()));
                    }
                    it = it3;
                    interactionBucket = (InteractionBucket) next2;
                }
                arrayList2.add(interactionBucket);
                it3 = it;
            }
            return v.Z0(arrayList2, new Comparator() { // from class: com.uxsense.base.metadata.InteractionStats$Companion$mergeBuckets$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    return j.m(Long.valueOf(((InteractionBucket) t9).getTimestamp()), Long.valueOf(((InteractionBucket) t10).getTimestamp()));
                }
            });
        }

        public final b serializer() {
            return InteractionStats$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public InteractionStats() {
        this(0L, 0L, 0L, 0L, 0L, 0L, (List) null, 127, (e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(InteractionBucket$$serializer.INSTANCE);
    }

    public static final void write$Self$uxsense_release(InteractionStats self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.likeCount != 0) {
            output.encodeLongElement(serialDesc, 0, self.likeCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.starCount != 0) {
            output.encodeLongElement(serialDesc, 1, self.starCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shareCount != 0) {
            output.encodeLongElement(serialDesc, 2, self.shareCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.commentCount != 0) {
            output.encodeLongElement(serialDesc, 3, self.commentCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.viewCount != 0) {
            output.encodeLongElement(serialDesc, 4, self.viewCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.lastInteractionAt != 0) {
            output.encodeLongElement(serialDesc, 5, self.lastInteractionAt);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && k.b(self.buckets, EmptyList.f4893a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 6, (x9.f) fVarArr[6].getF4884a(), self.buckets);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLikeCount() {
        return this.likeCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStarCount() {
        return this.starCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getShareCount() {
        return this.shareCount;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCommentCount() {
        return this.commentCount;
    }

    /* renamed from: component5, reason: from getter */
    public final long getViewCount() {
        return this.viewCount;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastInteractionAt() {
        return this.lastInteractionAt;
    }

    public final List<InteractionBucket> component7() {
        return this.buckets;
    }

    public final InteractionStats copy(long likeCount, long starCount, long shareCount, long commentCount, long viewCount, long lastInteractionAt, List<InteractionBucket> buckets) {
        k.f(buckets, "buckets");
        return new InteractionStats(likeCount, starCount, shareCount, commentCount, viewCount, lastInteractionAt, buckets);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionStats)) {
            return false;
        }
        InteractionStats interactionStats = (InteractionStats) other;
        return this.likeCount == interactionStats.likeCount && this.starCount == interactionStats.starCount && this.shareCount == interactionStats.shareCount && this.commentCount == interactionStats.commentCount && this.viewCount == interactionStats.viewCount && this.lastInteractionAt == interactionStats.lastInteractionAt && k.b(this.buckets, interactionStats.buckets);
    }

    public final List<InteractionBucket> getBuckets() {
        return this.buckets;
    }

    public final long getCommentCount() {
        return this.commentCount;
    }

    public final long getLastInteractionAt() {
        return this.lastInteractionAt;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final long getShareCount() {
        return this.shareCount;
    }

    public final long getStarCount() {
        return this.starCount;
    }

    public final long getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        return this.buckets.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.likeCount) * 31, 31, this.starCount), 31, this.shareCount), 31, this.commentCount), 31, this.viewCount), 31, this.lastInteractionAt);
    }

    public final long hot1h() {
        return totalInLastHours(1);
    }

    public final long hot24h() {
        return totalInLastHours(24);
    }

    public final long hot6h() {
        return totalInLastHours(6);
    }

    public final long hot7d() {
        return totalInLastHours(168);
    }

    public final InteractionStats mergeWith(InteractionStats other) {
        k.f(other, "other");
        return copy(Math.max(this.likeCount, other.likeCount), Math.max(this.starCount, other.starCount), Math.max(this.shareCount, other.shareCount), Math.max(this.commentCount, other.commentCount), Math.max(this.viewCount, other.viewCount), Math.max(this.lastInteractionAt, other.lastInteractionAt), INSTANCE.mergeBuckets(this.buckets, other.buckets));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InteractionStats(likeCount=");
        sb.append(this.likeCount);
        sb.append(", starCount=");
        sb.append(this.starCount);
        sb.append(", shareCount=");
        sb.append(this.shareCount);
        sb.append(", commentCount=");
        sb.append(this.commentCount);
        sb.append(", viewCount=");
        sb.append(this.viewCount);
        sb.append(", lastInteractionAt=");
        sb.append(this.lastInteractionAt);
        sb.append(", buckets=");
        return B7.a.r(sb, this.buckets, ')');
    }

    public final long totalInLastHours(int hours) {
        long total = 0;
        if (!this.buckets.isEmpty() && hours > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - (hours * 3600000);
            List<InteractionBucket> list = this.buckets;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((InteractionBucket) obj).getTimestamp() >= jCurrentTimeMillis) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                total += ((InteractionBucket) it.next()).getTotal();
            }
        }
        return total;
    }

    public InteractionStats(int i, long j5, long j6, long j10, long j11, long j12, long j13, List list, d0 d0Var) {
        if ((i & 1) == 0) {
            this.likeCount = 0L;
        } else {
            this.likeCount = j5;
        }
        if ((i & 2) == 0) {
            this.starCount = 0L;
        } else {
            this.starCount = j6;
        }
        if ((i & 4) == 0) {
            this.shareCount = 0L;
        } else {
            this.shareCount = j10;
        }
        if ((i & 8) == 0) {
            this.commentCount = 0L;
        } else {
            this.commentCount = j11;
        }
        if ((i & 16) == 0) {
            this.viewCount = 0L;
        } else {
            this.viewCount = j12;
        }
        if ((i & 32) == 0) {
            this.lastInteractionAt = 0L;
        } else {
            this.lastInteractionAt = j13;
        }
        this.buckets = (i & 64) == 0 ? EmptyList.f4893a : list;
    }

    public InteractionStats(long j5, long j6, long j10, long j11, long j12, long j13, List<InteractionBucket> buckets) {
        k.f(buckets, "buckets");
        this.likeCount = j5;
        this.starCount = j6;
        this.shareCount = j10;
        this.commentCount = j11;
        this.viewCount = j12;
        this.lastInteractionAt = j13;
        this.buckets = buckets;
    }

    public InteractionStats(long j5, long j6, long j10, long j11, long j12, long j13, List list, int i, e eVar) {
        this((i & 1) != 0 ? 0L : j5, (i & 2) != 0 ? 0L : j6, (i & 4) != 0 ? 0L : j10, (i & 8) != 0 ? 0L : j11, (i & 16) != 0 ? 0L : j12, (i & 32) == 0 ? j13 : 0L, (i & 64) != 0 ? EmptyList.f4893a : list);
    }
}
