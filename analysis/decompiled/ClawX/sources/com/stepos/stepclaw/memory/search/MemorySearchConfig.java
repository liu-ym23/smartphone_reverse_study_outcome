package com.stepos.stepclaw.memory.search;

import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b1\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001CB»\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u0015\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\u0015\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J½\u0001\u0010>\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001J\u0013\u0010?\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0006HÖ\u0001J\t\u0010B\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)¨\u0006D"}, d2 = {"Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxQueryLength", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "topKPerCategory", "rrfK", "enableVectorRetrieval", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enableHalfLifeRerank", "halfLifeSMin", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "halfLifeSMax", "halfLifeBeta", "memoryFactorWeight", "scoreThresholds", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "defaultScoreThreshold", "maxEntries", "maxFormatTokens", "categoryTokenWeights", "<init>", "(Ljava/util/List;IIIZZDDDDLjava/util/Map;FIILjava/util/Map;)V", "getCategories", "()Ljava/util/List;", "getMaxQueryLength", "()I", "getTopKPerCategory", "getRrfK", "getEnableVectorRetrieval", "()Z", "getEnableHalfLifeRerank", "getHalfLifeSMin", "()D", "getHalfLifeSMax", "getHalfLifeBeta", "getMemoryFactorWeight", "getScoreThresholds", "()Ljava/util/Map;", "getDefaultScoreThreshold", "()F", "getMaxEntries", "getMaxFormatTokens", "getCategoryTokenWeights", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MemorySearchConfig {
    private final List<String> categories;
    private final Map<String, Float> categoryTokenWeights;
    private final float defaultScoreThreshold;
    private final boolean enableHalfLifeRerank;
    private final boolean enableVectorRetrieval;
    private final double halfLifeBeta;
    private final double halfLifeSMax;
    private final double halfLifeSMin;
    private final int maxEntries;
    private final int maxFormatTokens;
    private final int maxQueryLength;
    private final double memoryFactorWeight;
    private final int rrfK;
    private final Map<String, Float> scoreThresholds;
    private final int topKPerCategory;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MemorySearchConfig DEFAULT = new MemorySearchConfig(null, 0, 0, 0, false, false, 0.0d, 0.0d, 0.0d, 0.0d, null, 0.0f, 0, 0, null, 32767, null);
    private static final MemorySearchConfig DEBUG = new MemorySearchConfig(null, 0, 10, 0, false, false, 0.0d, 0.0d, 0.0d, 0.0d, t.f1093a, 0.0f, 50, 9000, null, 17371, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/memory/search/MemorySearchConfig$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "DEFAULT", "Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", "getDEFAULT", "()Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", "DEBUG", "getDEBUG", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final MemorySearchConfig getDEBUG() {
            return MemorySearchConfig.DEBUG;
        }

        public final MemorySearchConfig getDEFAULT() {
            return MemorySearchConfig.DEFAULT;
        }

        private Companion() {
        }
    }

    public MemorySearchConfig() {
        this(null, 0, 0, 0, false, false, 0.0d, 0.0d, 0.0d, 0.0d, null, 0.0f, 0, 0, null, 32767, null);
    }

    public final List<String> component1() {
        return this.categories;
    }

    /* renamed from: component10, reason: from getter */
    public final double getMemoryFactorWeight() {
        return this.memoryFactorWeight;
    }

    public final Map<String, Float> component11() {
        return this.scoreThresholds;
    }

    /* renamed from: component12, reason: from getter */
    public final float getDefaultScoreThreshold() {
        return this.defaultScoreThreshold;
    }

    /* renamed from: component13, reason: from getter */
    public final int getMaxEntries() {
        return this.maxEntries;
    }

    /* renamed from: component14, reason: from getter */
    public final int getMaxFormatTokens() {
        return this.maxFormatTokens;
    }

    public final Map<String, Float> component15() {
        return this.categoryTokenWeights;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxQueryLength() {
        return this.maxQueryLength;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTopKPerCategory() {
        return this.topKPerCategory;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRrfK() {
        return this.rrfK;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnableVectorRetrieval() {
        return this.enableVectorRetrieval;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnableHalfLifeRerank() {
        return this.enableHalfLifeRerank;
    }

    /* renamed from: component7, reason: from getter */
    public final double getHalfLifeSMin() {
        return this.halfLifeSMin;
    }

    /* renamed from: component8, reason: from getter */
    public final double getHalfLifeSMax() {
        return this.halfLifeSMax;
    }

    /* renamed from: component9, reason: from getter */
    public final double getHalfLifeBeta() {
        return this.halfLifeBeta;
    }

    public final MemorySearchConfig copy(List<String> categories, int maxQueryLength, int topKPerCategory, int rrfK, boolean enableVectorRetrieval, boolean enableHalfLifeRerank, double halfLifeSMin, double halfLifeSMax, double halfLifeBeta, double memoryFactorWeight, Map<String, Float> scoreThresholds, float defaultScoreThreshold, int maxEntries, int maxFormatTokens, Map<String, Float> categoryTokenWeights) {
        p.e(categories, "categories");
        p.e(scoreThresholds, "scoreThresholds");
        p.e(categoryTokenWeights, "categoryTokenWeights");
        return new MemorySearchConfig(categories, maxQueryLength, topKPerCategory, rrfK, enableVectorRetrieval, enableHalfLifeRerank, halfLifeSMin, halfLifeSMax, halfLifeBeta, memoryFactorWeight, scoreThresholds, defaultScoreThreshold, maxEntries, maxFormatTokens, categoryTokenWeights);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemorySearchConfig)) {
            return false;
        }
        MemorySearchConfig memorySearchConfig = (MemorySearchConfig) other;
        return p.a(this.categories, memorySearchConfig.categories) && this.maxQueryLength == memorySearchConfig.maxQueryLength && this.topKPerCategory == memorySearchConfig.topKPerCategory && this.rrfK == memorySearchConfig.rrfK && this.enableVectorRetrieval == memorySearchConfig.enableVectorRetrieval && this.enableHalfLifeRerank == memorySearchConfig.enableHalfLifeRerank && Double.compare(this.halfLifeSMin, memorySearchConfig.halfLifeSMin) == 0 && Double.compare(this.halfLifeSMax, memorySearchConfig.halfLifeSMax) == 0 && Double.compare(this.halfLifeBeta, memorySearchConfig.halfLifeBeta) == 0 && Double.compare(this.memoryFactorWeight, memorySearchConfig.memoryFactorWeight) == 0 && p.a(this.scoreThresholds, memorySearchConfig.scoreThresholds) && Float.compare(this.defaultScoreThreshold, memorySearchConfig.defaultScoreThreshold) == 0 && this.maxEntries == memorySearchConfig.maxEntries && this.maxFormatTokens == memorySearchConfig.maxFormatTokens && p.a(this.categoryTokenWeights, memorySearchConfig.categoryTokenWeights);
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final Map<String, Float> getCategoryTokenWeights() {
        return this.categoryTokenWeights;
    }

    public final float getDefaultScoreThreshold() {
        return this.defaultScoreThreshold;
    }

    public final boolean getEnableHalfLifeRerank() {
        return this.enableHalfLifeRerank;
    }

    public final boolean getEnableVectorRetrieval() {
        return this.enableVectorRetrieval;
    }

    public final double getHalfLifeBeta() {
        return this.halfLifeBeta;
    }

    public final double getHalfLifeSMax() {
        return this.halfLifeSMax;
    }

    public final double getHalfLifeSMin() {
        return this.halfLifeSMin;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public final int getMaxFormatTokens() {
        return this.maxFormatTokens;
    }

    public final int getMaxQueryLength() {
        return this.maxQueryLength;
    }

    public final double getMemoryFactorWeight() {
        return this.memoryFactorWeight;
    }

    public final int getRrfK() {
        return this.rrfK;
    }

    public final Map<String, Float> getScoreThresholds() {
        return this.scoreThresholds;
    }

    public final int getTopKPerCategory() {
        return this.topKPerCategory;
    }

    public int hashCode() {
        return this.categoryTokenWeights.hashCode() + a8.b.C(this.maxFormatTokens, a8.b.C(this.maxEntries, (Float.hashCode(this.defaultScoreThreshold) + ((this.scoreThresholds.hashCode() + ((Double.hashCode(this.memoryFactorWeight) + ((Double.hashCode(this.halfLifeBeta) + ((Double.hashCode(this.halfLifeSMax) + ((Double.hashCode(this.halfLifeSMin) + a8.b.g(a8.b.g(a8.b.C(this.rrfK, a8.b.C(this.topKPerCategory, a8.b.C(this.maxQueryLength, this.categories.hashCode() * 31, 31), 31), 31), 31, this.enableVectorRetrieval), 31, this.enableHalfLifeRerank)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31), 31);
    }

    public String toString() {
        List<String> list = this.categories;
        int i8 = this.maxQueryLength;
        int i9 = this.topKPerCategory;
        int i10 = this.rrfK;
        boolean z = this.enableVectorRetrieval;
        boolean z2 = this.enableHalfLifeRerank;
        double d = this.halfLifeSMin;
        double d9 = this.halfLifeSMax;
        double d10 = this.halfLifeBeta;
        double d11 = this.memoryFactorWeight;
        Map<String, Float> map = this.scoreThresholds;
        float f3 = this.defaultScoreThreshold;
        int i11 = this.maxEntries;
        int i12 = this.maxFormatTokens;
        Map<String, Float> map2 = this.categoryTokenWeights;
        StringBuilder sb = new StringBuilder("MemorySearchConfig(categories=");
        sb.append(list);
        sb.append(", maxQueryLength=");
        sb.append(i8);
        sb.append(", topKPerCategory=");
        a8.b.z(sb, i9, ", rrfK=", i10, ", enableVectorRetrieval=");
        sb.append(z);
        sb.append(", enableHalfLifeRerank=");
        sb.append(z2);
        sb.append(", halfLifeSMin=");
        sb.append(d);
        sb.append(", halfLifeSMax=");
        sb.append(d9);
        sb.append(", halfLifeBeta=");
        sb.append(d10);
        sb.append(", memoryFactorWeight=");
        sb.append(d11);
        sb.append(", scoreThresholds=");
        sb.append(map);
        sb.append(", defaultScoreThreshold=");
        sb.append(f3);
        sb.append(", maxEntries=");
        a8.b.z(sb, i11, ", maxFormatTokens=", i12, ", categoryTokenWeights=");
        sb.append(map2);
        sb.append(")");
        return sb.toString();
    }

    public MemorySearchConfig(List<String> categories, int i8, int i9, int i10, boolean z, boolean z2, double d, double d9, double d10, double d11, Map<String, Float> scoreThresholds, float f3, int i11, int i12, Map<String, Float> categoryTokenWeights) {
        p.e(categories, "categories");
        p.e(scoreThresholds, "scoreThresholds");
        p.e(categoryTokenWeights, "categoryTokenWeights");
        this.categories = categories;
        this.maxQueryLength = i8;
        this.topKPerCategory = i9;
        this.rrfK = i10;
        this.enableVectorRetrieval = z;
        this.enableHalfLifeRerank = z2;
        this.halfLifeSMin = d;
        this.halfLifeSMax = d9;
        this.halfLifeBeta = d10;
        this.memoryFactorWeight = d11;
        this.scoreThresholds = scoreThresholds;
        this.defaultScoreThreshold = f3;
        this.maxEntries = i11;
        this.maxFormatTokens = i12;
        this.categoryTokenWeights = categoryTokenWeights;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public MemorySearchConfig(java.util.List r21, int r22, int r23, int r24, boolean r25, boolean r26, double r27, double r29, double r31, double r33, java.util.Map r35, float r36, int r37, int r38, java.util.Map r39, int r40, kotlin.jvm.internal.i r41) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.MemorySearchConfig.<init>(java.util.List, int, int, int, boolean, boolean, double, double, double, double, java.util.Map, float, int, int, java.util.Map, int, kotlin.jvm.internal.i):void");
    }
}
