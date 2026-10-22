package com.stepos.datacenter.vector;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/stepos/datacenter/vector/MultiCollectionHit;", "", "entityId", "", "entityClassName", "", "combinedScore", "", "perCollectionRanks", "", "", "matchedCollections", "", "<init>", "(JLjava/lang/String;FLjava/util/Map;Ljava/util/Set;)V", "getEntityId", "()J", "getEntityClassName", "()Ljava/lang/String;", "getCombinedScore", "()F", "getPerCollectionRanks", "()Ljava/util/Map;", "getMatchedCollections", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MultiCollectionHit {
    private final float combinedScore;
    private final String entityClassName;
    private final long entityId;
    private final Set<String> matchedCollections;
    private final Map<String, Integer> perCollectionRanks;

    public MultiCollectionHit(long j10, String entityClassName, float f10, Map<String, Integer> perCollectionRanks, Set<String> matchedCollections) {
        p.i(entityClassName, "entityClassName");
        p.i(perCollectionRanks, "perCollectionRanks");
        p.i(matchedCollections, "matchedCollections");
        this.entityId = j10;
        this.entityClassName = entityClassName;
        this.combinedScore = f10;
        this.perCollectionRanks = perCollectionRanks;
        this.matchedCollections = matchedCollections;
    }

    public static /* synthetic */ MultiCollectionHit copy$default(MultiCollectionHit multiCollectionHit, long j10, String str, float f10, Map map, Set set, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = multiCollectionHit.entityId;
        }
        long j11 = j10;
        if ((i10 & 2) != 0) {
            str = multiCollectionHit.entityClassName;
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            f10 = multiCollectionHit.combinedScore;
        }
        float f11 = f10;
        if ((i10 & 8) != 0) {
            map = multiCollectionHit.perCollectionRanks;
        }
        Map map2 = map;
        if ((i10 & 16) != 0) {
            set = multiCollectionHit.matchedCollections;
        }
        return multiCollectionHit.copy(j11, str2, f11, map2, set);
    }

    /* renamed from: component1, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEntityClassName() {
        return this.entityClassName;
    }

    /* renamed from: component3, reason: from getter */
    public final float getCombinedScore() {
        return this.combinedScore;
    }

    public final Map<String, Integer> component4() {
        return this.perCollectionRanks;
    }

    public final Set<String> component5() {
        return this.matchedCollections;
    }

    public final MultiCollectionHit copy(long entityId, String entityClassName, float combinedScore, Map<String, Integer> perCollectionRanks, Set<String> matchedCollections) {
        p.i(entityClassName, "entityClassName");
        p.i(perCollectionRanks, "perCollectionRanks");
        p.i(matchedCollections, "matchedCollections");
        return new MultiCollectionHit(entityId, entityClassName, combinedScore, perCollectionRanks, matchedCollections);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiCollectionHit)) {
            return false;
        }
        MultiCollectionHit multiCollectionHit = (MultiCollectionHit) other;
        return this.entityId == multiCollectionHit.entityId && p.d(this.entityClassName, multiCollectionHit.entityClassName) && Float.compare(this.combinedScore, multiCollectionHit.combinedScore) == 0 && p.d(this.perCollectionRanks, multiCollectionHit.perCollectionRanks) && p.d(this.matchedCollections, multiCollectionHit.matchedCollections);
    }

    public final float getCombinedScore() {
        return this.combinedScore;
    }

    public final String getEntityClassName() {
        return this.entityClassName;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final Set<String> getMatchedCollections() {
        return this.matchedCollections;
    }

    public final Map<String, Integer> getPerCollectionRanks() {
        return this.perCollectionRanks;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.entityId) * 31) + this.entityClassName.hashCode()) * 31) + Float.hashCode(this.combinedScore)) * 31) + this.perCollectionRanks.hashCode()) * 31) + this.matchedCollections.hashCode();
    }

    public String toString() {
        return "MultiCollectionHit(entityId=" + this.entityId + ", entityClassName=" + this.entityClassName + ", combinedScore=" + this.combinedScore + ", perCollectionRanks=" + this.perCollectionRanks + ", matchedCollections=" + this.matchedCollections + ")";
    }
}
