package com.stepos.stepclaw.memory.search;

import b5.a0;
import c5.m;
import c5.n;
import c5.o;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"Ba\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010 R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010 R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010!¨\u0006#"}, d2 = {"Lcom/stepos/stepclaw/memory/search/RerankStage;", "Lcom/stepos/stepclaw/memory/search/SearchStage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "scoreThresholds", "defaultScoreThreshold", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enableHalfLifeRerank", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "halfLifeSMin", "halfLifeSMax", "halfLifeBeta", "memoryFactorWeight", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/util/Map;FZDDDDLcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "result", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "nowMs", "computeHalfLifeRerankScore", "(Lcom/stepos/stepclaw/memory/search/RetrievalResult;J)F", "Lcom/stepos/stepclaw/memory/search/SearchContext;", "context", "Lb5/a0;", "execute", "(Lcom/stepos/stepclaw/memory/search/SearchContext;Lf5/c;)Ljava/lang/Object;", "Ljava/util/Map;", "F", "Z", "D", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RerankStage implements SearchStage {
    private static final String TAG = "RerankStage";
    private final float defaultScoreThreshold;
    private final boolean enableHalfLifeRerank;
    private final double halfLifeBeta;
    private final double halfLifeSMax;
    private final double halfLifeSMin;
    private final MemoryLogger logger;
    private final double memoryFactorWeight;
    private final Map<String, Float> scoreThresholds;

    public RerankStage(Map<String, Float> scoreThresholds, float f3, boolean z, double d, double d9, double d10, double d11, MemoryLogger logger) {
        p.e(scoreThresholds, "scoreThresholds");
        p.e(logger, "logger");
        this.scoreThresholds = scoreThresholds;
        this.defaultScoreThreshold = f3;
        this.enableHalfLifeRerank = z;
        this.halfLifeSMin = d;
        this.halfLifeSMax = d9;
        this.halfLifeBeta = d10;
        this.memoryFactorWeight = d11;
        this.logger = logger;
    }

    private final float computeHalfLifeRerankScore(RetrievalResult result, long nowMs) {
        double hitCount = result.getHitCount();
        double d = this.halfLifeSMin;
        double dExp = ((1 - Math.exp((-this.halfLifeBeta) * hitCount)) * (this.halfLifeSMax - d)) + d;
        if (dExp < 0.1d) {
            dExp = 0.1d;
        }
        double d9 = 0.0d;
        double d10 = (-Math.max(0.0d, (nowMs - (result.getLastAccessedAt() > 0 ? result.getLastAccessedAt() : result.getCreatedAt())) / 3600000.0d)) / dExp;
        if (d10 < -50.0d) {
            d9 = -50.0d;
        } else if (d10 <= 0.0d) {
            d9 = d10;
        }
        return (float) ((Math.exp(d9) * this.memoryFactorWeight) + result.getScore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$0$0(int i8, RetrievalResult retrievalResult) {
        float score = retrievalResult.getScore();
        String strName = retrievalResult.getSource().name();
        String query = retrievalResult.getQuery();
        String category = retrievalResult.getCategory();
        String strEscapeForLog = AndroidMemoryLogger.INSTANCE.escapeForLog(retrievalResult.getContent());
        StringBuilder sb = new StringBuilder("#");
        sb.append(i8);
        sb.append(": [score=");
        sb.append(score);
        sb.append("][");
        a8.b.A(sb, strName, "][query=", query, "][");
        sb.append(category);
        sb.append("][");
        sb.append(strEscapeForLog);
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$7(int i8, List list) {
        return "rerank: " + i8 + " -> " + list.size() + " results after threshold filter";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.stepos.stepclaw.memory.search.SearchContext] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    @Override // com.stepos.stepclaw.memory.search.SearchStage
    public Object execute(SearchContext searchContext, f5.c cVar) {
        ?? J0;
        int size = searchContext.getRawResults().size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<RetrievalResult> rawResults = searchContext.getRawResults();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        int i9 = 0;
        for (Object obj : rawResults) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                n.m0();
                throw null;
            }
            RetrievalResult retrievalResult = (RetrievalResult) obj;
            this.logger.logD(TAG, searchContext.getSessionId(), new d(retrievalResult, i9, 0));
            Float f3 = this.scoreThresholds.get(retrievalResult.getCategory());
            if (retrievalResult.getScore() >= (f3 != null ? f3.floatValue() : this.defaultScoreThreshold)) {
                arrayList.add(obj);
            }
            i9 = i10;
        }
        if (this.enableHalfLifeRerank) {
            ArrayList arrayList2 = new ArrayList(o.n0(arrayList, 10));
            int size2 = arrayList.size();
            while (i8 < size2) {
                Object obj2 = arrayList.get(i8);
                i8++;
                RetrievalResult retrievalResult2 = (RetrievalResult) obj2;
                arrayList2.add(new b5.g(retrievalResult2, new Float(computeHalfLifeRerankScore(retrievalResult2, jCurrentTimeMillis))));
            }
            final Comparator comparator = new Comparator() { // from class: com.stepos.stepclaw.memory.search.RerankStage$execute$$inlined$compareByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    return a.a.l((Comparable) ((b5.g) t9).f893b, (Comparable) ((b5.g) t8).f893b);
                }
            };
            List listJ0 = m.J0(arrayList2, new Comparator() { // from class: com.stepos.stepclaw.memory.search.RerankStage$execute$$inlined$thenByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    int iCompare = comparator.compare(t8, t9);
                    return iCompare != 0 ? iCompare : a.a.l(Long.valueOf(((RetrievalResult) ((b5.g) t9).f892a).getCreatedAt()), Long.valueOf(((RetrievalResult) ((b5.g) t8).f892a).getCreatedAt()));
                }
            });
            J0 = new ArrayList(o.n0(listJ0, 10));
            Iterator it = listJ0.iterator();
            while (it.hasNext()) {
                J0.add((RetrievalResult) ((b5.g) it.next()).f892a);
            }
        } else {
            final Comparator comparator2 = new Comparator() { // from class: com.stepos.stepclaw.memory.search.RerankStage$execute$$inlined$compareByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    return a.a.l(Float.valueOf(((RetrievalResult) t9).getScore()), Float.valueOf(((RetrievalResult) t8).getScore()));
                }
            };
            J0 = m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.memory.search.RerankStage$execute$$inlined$thenByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    int iCompare = comparator2.compare(t8, t9);
                    return iCompare != 0 ? iCompare : a.a.l(Long.valueOf(((RetrievalResult) t9).getCreatedAt()), Long.valueOf(((RetrievalResult) t8).getCreatedAt()));
                }
            });
        }
        searchContext.setRankedResults(J0);
        this.logger.logD(TAG, searchContext.getSessionId(), new d(J0, size, 1));
        return a0.f883a;
    }

    public /* synthetic */ RerankStage(Map map, float f3, boolean z, double d, double d9, double d10, double d11, MemoryLogger memoryLogger, int i8, i iVar) {
        this((i8 & 1) != 0 ? t.f1093a : map, (i8 & 2) != 0 ? 0.0f : f3, (i8 & 4) != 0 ? true : z, (i8 & 8) != 0 ? 2.0d : d, (i8 & 16) != 0 ? 48.0d : d9, (i8 & 32) != 0 ? 0.5d : d10, (i8 & 64) != 0 ? 0.3d : d11, memoryLogger);
    }
}
