package com.bytedance.android.live.impl.strategy;

import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombinCharacterInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.livesdk.jsbridge.methods.draft.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001@BO\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a\u0012\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001c¢\u0006\u0004\b=\u0010>J\u0006\u0010\u0002\u001a\u00020\u0000J$\u0010\b\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00060\u0003J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u00132\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u0006\u0010\u0017\u001a\u00020\u0016J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aHÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001cHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001cHÆ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020$HÖ\u0001J\u0013\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003R4\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R>\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u00130\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b4\u00105R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b6\u00105R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b8\u00109R.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/impl/strategy/Strategy;", "Ljava/io/Serializable;", "deepCopy", "Lkotlin/Pair;", "", "", "", "", "getIntervalData", "faName", "", "Lcom/bytedance/android/live/strategy/api/CombineInfo;", "getCombineInfosByFaName", "", "filterFaList", "filterUsefulCombineInfoByFactors", "chName", "getFactorsByChName", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getFactorsByChNameV3", "getChList", "", "clearCache", "component1", "component2", "Ljava/util/concurrent/CopyOnWriteArrayList;", "component3", "Ljava/util/concurrent/ConcurrentHashMap;", "component4", "id", "strategyHash", "combineStrategys", "abInfos", "copy", "toString", "", "hashCode", "", "other", "", "equals", "factorsCacheMapByChName", "Ljava/util/Map;", "getFactorsCacheMapByChName", "()Ljava/util/Map;", "setFactorsCacheMapByChName", "(Ljava/util/Map;)V", "factorsCacheMapByChNameV3", "getFactorsCacheMapByChNameV3", "setFactorsCacheMapByChNameV3", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getStrategyHash", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getCombineStrategys", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "getAbInfos", "()Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/util/concurrent/ConcurrentHashMap;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livestrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Strategy implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("ab_info")
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> abInfos;

    @SerializedName("combine")
    private final CopyOnWriteArrayList<CombineInfo> combineStrategys;
    private Map<String, List<String>> factorsCacheMapByChName;
    private Map<String, HashSet<String>> factorsCacheMapByChNameV3;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f69296id;

    @SerializedName("strategy_hash")
    private final String strategyHash;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Strategy() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Strategy copy$default(Strategy r100, String r101, String r102, CopyOnWriteArrayList r103, ConcurrentHashMap r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f69296id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.strategyHash;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.combineStrategys;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.abInfos;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f69296id;
    }

    public final String component2() {
        return this.strategyHash;
    }

    public final CopyOnWriteArrayList<CombineInfo> component3() {
        return this.combineStrategys;
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> component4() {
        return this.abInfos;
    }

    public final Strategy copy(String r100, String r101, CopyOnWriteArrayList<CombineInfo> r102, ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r103) {
        return new Strategy(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Strategy) == false) goto L14;
        Strategy r101 = (Strategy) r100;
        if (Intrinsics.areEqual(this.f69296id, r101.f69296id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.strategyHash, r101.strategyHash) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.combineStrategys, r101.combineStrategys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.abInfos, r101.abInfos) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final synchronized Pair<List<Long>, Map<String, Long>> getIntervalData() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L39
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L39
        CopyOnWriteArrayList<CombineInfo> r102 = this.combineStrategys;     // Catch: Throwable -> L39
        if (r102 == null) goto L36;
        Iterator<T> r103 = r102.iterator();     // Catch: Throwable -> L39
    L7:
        if (r103.hasNext() == false) goto L36;
        CombineInfo r104 = (CombineInfo) r103.next();     // Catch: Throwable -> L39
        if (r104 == null) goto L7;
        CopyOnWriteArrayList<CombinCharacterInfo> r105 = r104.getChList();     // Catch: Throwable -> L39
        if (r105 == null) goto L7;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L39
    L14:
        if (r106.hasNext() == false) goto L7;
        CombinCharacterInfo r107 = (CombinCharacterInfo) r106.next();     // Catch: Throwable -> L39
        String r108 = null;
        if (r107 == null) goto L18;
        Long r109 = Long.valueOf(r107.getCheckInterval());     // Catch: Throwable -> L39
    L19:
        if (r107 == null) goto L21;
        r108 = r107.getChName();     // Catch: Throwable -> L39
    L21:
        if (r109 == null) goto L14;
        if (r108 == null) goto L14;
        if (r109.longValue() <= 0) goto L14;
        if (r101.containsKey(r108) == true) goto L27;
        r100.add(r109);     // Catch: Throwable -> L39
        r101.put(r108, r109);     // Catch: Throwable -> L39
        goto L14
    L27:
        Long r110 = (Long) r101.get(r108);     // Catch: Throwable -> L39
        if (r110 == null) goto L29;
        if (r109.longValue() <= r110.longValue()) goto L33;
        long r111 = r110.longValue();     // Catch: Throwable -> L39
    L34:
        r101.put(r108, Long.valueOf(r111));     // Catch: Throwable -> L39
        goto L14
    L33:
        r111 = r109.longValue();     // Catch: Throwable -> L39
        goto L34
    L29:
        r100.add(r109);     // Catch: Throwable -> L39
        r101.put(r108, r109);     // Catch: Throwable -> L39
        goto L14
    L18:
        r109 = null;
    L36:
        Pair<List<Long>, Map<String, Long>> r112 = new Pair(r100, r101);     // Catch: Throwable -> L39
        monitor-exit(this);
        return r112;
    L39:
        th = move-exception;
        throw th;
    }

    public int hashCode() {
        String r100 = this.f69296id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.strategyHash;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CopyOnWriteArrayList<CombineInfo> r107 = this.combineStrategys;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r110 = this.abInfos;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Strategy(id=" + this.f69296id + ", strategyHash=" + this.strategyHash + ", combineStrategys=" + this.combineStrategys + ", abInfos=" + this.abInfos + ")";
    }

    public final void clearCache() {
        this.factorsCacheMapByChName.clear();
    }

    public final Strategy deepCopy() {
        return (Strategy) GsonProtectorUtils.fromJson(new Gson(), m.a(this), Strategy.class);
    }

    public final List<String> getChList() {
        ArrayList r100 = new ArrayList();
        CopyOnWriteArrayList<CombineInfo> r101 = this.combineStrategys;
        if (r101 == null) goto L18;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L18;
        CombineInfo r103 = (CombineInfo) r102.next();
        if (r103 == null) goto L6;
        CopyOnWriteArrayList<CombinCharacterInfo> r104 = r103.getChList();
        if (r104 == null) goto L6;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L6;
        String r106 = ((CombinCharacterInfo) r105.next()).getChName();
        if (r106 == null) goto L13;
        r100.add(r106);
    L18:
        return CollectionsKt.distinct(r100);
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> getAbInfos() {
        return this.abInfos;
    }

    public final CopyOnWriteArrayList<CombineInfo> getCombineStrategys() {
        return this.combineStrategys;
    }

    public final Map<String, List<String>> getFactorsCacheMapByChName() {
        return this.factorsCacheMapByChName;
    }

    public final Map<String, HashSet<String>> getFactorsCacheMapByChNameV3() {
        return this.factorsCacheMapByChNameV3;
    }

    public final String getId() {
        return this.f69296id;
    }

    public final String getStrategyHash() {
        return this.strategyHash;
    }

    public final Strategy filterUsefulCombineInfoByFactors(Set<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "filterFaList");
        CopyOnWriteArrayList<CombineInfo> r100 = this.combineStrategys;     // Catch: Exception -> L79
        if (r100 == null) goto L29;
        Iterator<T> r101 = r100.iterator();     // Catch: Exception -> L79
    L7:
        if (r101.hasNext() == false) goto L29;
        CombineInfo r102 = (CombineInfo) r101.next();     // Catch: Exception -> L79
        CopyOnWriteArrayList<CombbineFactorInfo> r103 = r102.getFaList();     // Catch: Exception -> L79
        if (r103 == null) goto L17;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Exception -> L79
        Iterator<T> r105 = r103.iterator();     // Catch: Exception -> L79
    L12:
        if (r105.hasNext() == false) goto L14;
        r104.add(((CombbineFactorInfo) r105.next()).getFaName());     // Catch: Exception -> L79
        goto L12
    L14:
        Set r106 = CollectionsKt.toSet(r104);     // Catch: Exception -> L79
        if (r106 == null) goto L17;
        Set r107 = CollectionsKt.intersect(r106, r110);     // Catch: Exception -> L79
    L18:
        Set r108 = r107;     // Catch: Exception -> L79
        if (r108 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L7;
        CopyOnWriteArrayList<CombineInfo> r111 = this.combineStrategys;     // Catch: Exception -> L79
        if (r111 == null) goto L7;
        r111.remove(r102);     // Catch: Exception -> L79
        goto L7
    L21:
        if (r108.isEmpty() == true) goto L24;
        r109 = false;
    L17:
        r107 = null;
    L29:
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r112 = this.abInfos;     // Catch: Exception -> L79
        if (r112 == null) goto L78;
        Set<Map.Entry<String, CopyOnWriteArrayList<CombineInfo>>> r113 = r112.entrySet();     // Catch: Exception -> L79
        if (r113 == null) goto L78;
        Iterator<T> r114 = r113.iterator();     // Catch: Exception -> L79
    L34:
        if (r114.hasNext() == false) goto L78;
        Map.Entry r115 = (Map.Entry) r114.next();     // Catch: Exception -> L79
        if (r115 == null) goto L64;
        CopyOnWriteArrayList r116 = (CopyOnWriteArrayList) r115.getValue();     // Catch: Exception -> L79
        if (r116 == null) goto L64;
        Iterator r117 = r116.iterator();     // Catch: Exception -> L79
    L42:
        if (r117.hasNext() == false) goto L64;
        CombineInfo r118 = (CombineInfo) r117.next();     // Catch: Exception -> L79
        CopyOnWriteArrayList<CombbineFactorInfo> r119 = r118.getFaList();     // Catch: Exception -> L79
        if (r119 == null) goto L52;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));     // Catch: Exception -> L79
        Iterator<T> r121 = r119.iterator();     // Catch: Exception -> L79
    L47:
        if (r121.hasNext() == false) goto L49;
        r120.add(((CombbineFactorInfo) r121.next()).getFaName());     // Catch: Exception -> L79
        goto L47
    L49:
        Set r122 = CollectionsKt.toSet(r120);     // Catch: Exception -> L79
        if (r122 == null) goto L52;
        Set r123 = CollectionsKt.intersect(r122, r110);     // Catch: Exception -> L79
    L53:
        Set r124 = r123;     // Catch: Exception -> L79
        if (r124 != null) goto L56;
    L59:
        boolean r125 = true;
    L60:
        if (r125 == false) goto L42;
        CopyOnWriteArrayList r126 = (CopyOnWriteArrayList) r115.getValue();     // Catch: Exception -> L79
        if (r126 == null) goto L42;
        r126.remove(r118);     // Catch: Exception -> L79
        goto L42
    L56:
        if (r124.isEmpty() == true) goto L59;
        r125 = false;
    L52:
        r123 = null;
    L64:
        if (r115 == null) goto L66;
        CopyOnWriteArrayList r127 = (CopyOnWriteArrayList) r115.getValue();     // Catch: Exception -> L79
    L67:
        if (r127 != null) goto L69;
    L72:
        boolean r128 = true;
    L73:
        if (r128 == false) goto L34;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r129 = this.abInfos;     // Catch: Exception -> L79
        if (r129 == null) goto L34;
        CopyOnWriteArrayList<CombineInfo> r130 = r129.remove(r115.getKey());     // Catch: Exception -> L79
        goto L34
    L69:
        if (r127.isEmpty() == true) goto L72;
        r128 = false;
        goto L73
    L66:
        r127 = null;
    L78:
        return this;
    L79:
        return null;
    }

    public final synchronized List<CombineInfo> getCombineInfosByFaName(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "faName");     // Catch: Throwable -> L30
        CopyOnWriteArrayList<CombineInfo> r101 = this.combineStrategys;     // Catch: Throwable -> L30
        if (r101 == null) goto L27;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L30
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L30
    L7:
        if (r103.hasNext() == false) goto L28;
        Object r104 = r103.next();     // Catch: Throwable -> L30
        CombineInfo r105 = (CombineInfo) r104;     // Catch: Throwable -> L30
        boolean r106 = false;
        if (r105 == null) goto L25;
        CopyOnWriteArrayList<CombbineFactorInfo> r107 = r105.getFaList();     // Catch: Throwable -> L30
        if (r107 == null) goto L25;
        if (r107.isEmpty() == true) goto L25;
        Iterator<T> r108 = r107.iterator();     // Catch: Throwable -> L30
    L17:
        if (r108.hasNext() == false) goto L25;
        CombbineFactorInfo r109 = (CombbineFactorInfo) r108.next();     // Catch: Throwable -> L30
        if (r109 == null) goto L21;
        String r110 = r109.getFaName();     // Catch: Throwable -> L30
    L23:
        if (Intrinsics.areEqual(r110, r100) == false) goto L17;
        r106 = true;
        goto L25
    L21:
        r110 = null;
    L25:
        if (r106 == false) goto L7;
        r102.add(r104);     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return r102;
    L27:
        r102 = new ArrayList();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final synchronized List<String> getFactorsByChName(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "chName");     // Catch: Throwable -> L50
        if (this.factorsCacheMapByChName.containsKey(r100) == true) goto L45;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L50
        CopyOnWriteArrayList<CombineInfo> r102 = this.combineStrategys;     // Catch: Throwable -> L50
        if (r102 == null) goto L44;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L50
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L50
    L9:
        if (r104.hasNext() == false) goto L29;
        Object r105 = r104.next();     // Catch: Throwable -> L50
        CombineInfo r106 = (CombineInfo) r105;     // Catch: Throwable -> L50
        boolean r107 = false;
        if (r106 == null) goto L27;
        CopyOnWriteArrayList<CombinCharacterInfo> r108 = r106.getChList();     // Catch: Throwable -> L50
        if (r108 == null) goto L27;
        if (r108.isEmpty() == true) goto L27;
        Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L50
    L19:
        if (r109.hasNext() == false) goto L27;
        CombinCharacterInfo r110 = (CombinCharacterInfo) r109.next();     // Catch: Throwable -> L50
        if (r110 == null) goto L23;
        String r111 = r110.getChName();     // Catch: Throwable -> L50
    L25:
        if (Intrinsics.areEqual(r111, r100) == false) goto L19;
        r107 = true;
        goto L27
    L23:
        r111 = null;
    L27:
        if (r107 == false) goto L9;
        r103.add(r105);     // Catch: Throwable -> L50
        goto L9
    L29:
        Iterator r112 = r103.iterator();     // Catch: Throwable -> L50
    L31:
        if (r112.hasNext() == false) goto L44;
        CombineInfo r113 = (CombineInfo) r112.next();     // Catch: Throwable -> L50
        if (r113 == null) goto L31;
        CopyOnWriteArrayList<CombbineFactorInfo> r114 = r113.getFaList();     // Catch: Throwable -> L50
        if (r114 == null) goto L31;
        Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L50
    L38:
        if (r115.hasNext() == false) goto L31;
        CombbineFactorInfo r116 = (CombbineFactorInfo) r115.next();     // Catch: Throwable -> L50
        if (r116 == null) goto L38;
        String r117 = r116.getFaName();     // Catch: Throwable -> L50
        if (r117 == null) goto L38;
        r101.add(r117);     // Catch: Throwable -> L50
    L44:
        this.factorsCacheMapByChName.put(r100, CollectionsKt.distinct(r101));     // Catch: Throwable -> L50
    L45:
        List<String> r118 = this.factorsCacheMapByChName.get(r100);     // Catch: Throwable -> L50
        if (r118 != null) goto L48;
        r118 = new ArrayList();     // Catch: Throwable -> L50
    L48:
        monitor-exit(this);
        return r118;
    L50:
        th = move-exception;
        throw th;
    }

    public final synchronized HashSet<String> getFactorsByChNameV3(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "chName");     // Catch: Throwable -> L42
        HashSet<String> r101 = this.factorsCacheMapByChNameV3.get(r100);     // Catch: Throwable -> L42
        if (r101 != null) goto L40;
        HashSet<String> r102 = new HashSet();     // Catch: Throwable -> L42
        CopyOnWriteArrayList<CombineInfo> r103 = this.combineStrategys;     // Catch: Throwable -> L42
        if (r103 == null) goto L37;
        Iterator<CombineInfo> r104 = r103.iterator();     // Catch: Throwable -> L42
    L9:
        if (r104.hasNext() == false) goto L37;
        CombineInfo r105 = r104.next();     // Catch: Throwable -> L42
        if (r105 == null) goto L13;
        CopyOnWriteArrayList<CombinCharacterInfo> r106 = r105.getChList();     // Catch: Throwable -> L42
    L14:
        if (r106 == null) goto L9;
        Iterator<CombinCharacterInfo> r107 = r106.iterator();     // Catch: Throwable -> L42
    L17:
        if (r107.hasNext() == false) goto L25;
        CombinCharacterInfo r108 = r107.next();     // Catch: Throwable -> L42
        if (r108 == null) goto L21;
        String r109 = r108.getChName();     // Catch: Throwable -> L42
    L23:
        if (Intrinsics.areEqual(r109, r100) == false) goto L17;
        boolean r110 = true;
    L26:
        if (r110 == false) goto L9;
        CopyOnWriteArrayList<CombbineFactorInfo> r111 = r105.getFaList();     // Catch: Throwable -> L42
        if (r111 == null) goto L9;
        Iterator<CombbineFactorInfo> r112 = r111.iterator();     // Catch: Throwable -> L42
    L31:
        if (r112.hasNext() == false) goto L9;
        CombbineFactorInfo r113 = r112.next();     // Catch: Throwable -> L42
        if (r113 == null) goto L31;
        String r114 = r113.getFaName();     // Catch: Throwable -> L42
        if (r114 == null) goto L31;
        r102.add(r114);     // Catch: Throwable -> L42
        goto L31
    L21:
        r109 = null;
        goto L23
    L25:
        r110 = false;
        goto L26
    L13:
        r106 = null;
    L37:
        this.factorsCacheMapByChNameV3.put(r100, r102);     // Catch: Throwable -> L42
        monitor-exit(this);
        return r102;
    L40:
        monitor-exit(this);
        return r101;
    L42:
        th = move-exception;
        throw th;
    }

    public final void setFactorsCacheMapByChName(Map<String, List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.factorsCacheMapByChName = r100;
    }

    public final void setFactorsCacheMapByChNameV3(Map<String, HashSet<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.factorsCacheMapByChNameV3 = r100;
    }

    public Strategy(String r100, String r101, CopyOnWriteArrayList<CombineInfo> r102, ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r103) {
        this.f69296id = r100;
        this.strategyHash = r101;
        this.combineStrategys = r102;
        this.abInfos = r103;
        this.factorsCacheMapByChName = new LinkedHashMap();
        this.factorsCacheMapByChNameV3 = new LinkedHashMap();
    }

    public /* synthetic */ Strategy(String r100, String r101, CopyOnWriteArrayList r102, ConcurrentHashMap r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "-1";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new CopyOnWriteArrayList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new ConcurrentHashMap();
    L14:
        this(r100, r101, r102, r103);
    }
}
