package com.bytedance.android.live.strategy.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00016B\u007f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t¢\u0006\u0004\b3\u00104J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tHÆ\u0003J\u0088\u0001\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0013\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\bR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b-\u0010'R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b.\u0010\bR(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b2\u0010,¨\u00067"}, d2 = {"Lcom/bytedance/android/live/strategy/api/CombineInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;", "component1", "", "component2", "", "component3", "()Ljava/lang/Integer;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/android/live/strategy/api/CombinCharacterInfo;", "component4", "component5", "component6", "", "", "component7", "Lcom/bytedance/android/live/strategy/api/CombbineFactorInfo;", "component8", "combineBaseInfo", "combineId", "priority", "chList", "combineOp", "totalDuration", "extra", "faList", "copy", "(Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/concurrent/CopyOnWriteArrayList;)Lcom/bytedance/android/live/strategy/api/CombineInfo;", "toString", "hashCode", "other", "", "equals", "Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;", "getCombineBaseInfo", "()Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;", "Ljava/lang/String;", "getCombineId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getPriority", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getChList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getCombineOp", "getTotalDuration", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "getFaList", "<init>", "(Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/concurrent/CopyOnWriteArrayList;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livestrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombineInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("ch_list")
    private final CopyOnWriteArrayList<CombinCharacterInfo> chList;

    @SerializedName("combine_base_info")
    private final CombineBaseInfo combineBaseInfo;

    @SerializedName("id")
    private final String combineId;

    @SerializedName("combine_op")
    private final String combineOp;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    @SerializedName("fa_list")
    private final CopyOnWriteArrayList<CombbineFactorInfo> faList;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("total_duration")
    private final Integer totalDuration;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CombineInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CombineInfo copy$default(CombineInfo r100, CombineBaseInfo r110, String r111, Integer r112, CopyOnWriteArrayList r113, String r114, Integer r115, Map r116, CopyOnWriteArrayList r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        CombineBaseInfo r101 = r100.combineBaseInfo;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.combineId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = r100.priority;
    L15:
        if ((r118 & 8) == 0) goto L17;
        CopyOnWriteArrayList r104 = r100.chList;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.combineOp;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = r100.totalDuration;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = r100.extra;
    L31:
        if ((r118 & 128) == 0) goto L33;
        CopyOnWriteArrayList r108 = r100.faList;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final CombineBaseInfo component1() {
        return this.combineBaseInfo;
    }

    public final String component2() {
        return this.combineId;
    }

    public final Integer component3() {
        return this.priority;
    }

    public final CopyOnWriteArrayList<CombinCharacterInfo> component4() {
        return this.chList;
    }

    public final String component5() {
        return this.combineOp;
    }

    public final Integer component6() {
        return this.totalDuration;
    }

    public final Map<String, Object> component7() {
        return this.extra;
    }

    public final CopyOnWriteArrayList<CombbineFactorInfo> component8() {
        return this.faList;
    }

    public final CombineInfo copy(CombineBaseInfo r110, String r111, Integer r112, CopyOnWriteArrayList<CombinCharacterInfo> r113, String r114, Integer r115, Map<String, ? extends Object> r116, CopyOnWriteArrayList<CombbineFactorInfo> r117) {
        return new CombineInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CombineInfo) == false) goto L22;
        CombineInfo r101 = (CombineInfo) r100;
        if (Intrinsics.areEqual(this.combineBaseInfo, r101.combineBaseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.combineId, r101.combineId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chList, r101.chList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.combineOp, r101.combineOp) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.totalDuration, r101.totalDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.faList, r101.faList) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        CombineBaseInfo r100 = this.combineBaseInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.combineId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.priority;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        CopyOnWriteArrayList<CombinCharacterInfo> r110 = this.chList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.combineOp;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.totalDuration;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.extra;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        CopyOnWriteArrayList<CombbineFactorInfo> r122 = this.faList;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "CombineInfo(combineBaseInfo=" + this.combineBaseInfo + ", combineId=" + this.combineId + ", priority=" + this.priority + ", chList=" + this.chList + ", combineOp=" + this.combineOp + ", totalDuration=" + this.totalDuration + ", extra=" + this.extra + ", faList=" + this.faList + ")";
    }

    public final CopyOnWriteArrayList<CombinCharacterInfo> getChList() {
        return this.chList;
    }

    public final CombineBaseInfo getCombineBaseInfo() {
        return this.combineBaseInfo;
    }

    public final String getCombineId() {
        return this.combineId;
    }

    public final String getCombineOp() {
        return this.combineOp;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final CopyOnWriteArrayList<CombbineFactorInfo> getFaList() {
        return this.faList;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getTotalDuration() {
        return this.totalDuration;
    }

    public CombineInfo(CombineBaseInfo r100, String r101, Integer r102, CopyOnWriteArrayList<CombinCharacterInfo> r103, String r104, Integer r105, Map<String, ? extends Object> r106, CopyOnWriteArrayList<CombbineFactorInfo> r107) {
        this.combineBaseInfo = r100;
        this.combineId = r101;
        this.priority = r102;
        this.chList = r103;
        this.combineOp = r104;
        this.totalDuration = r105;
        this.extra = r106;
        this.faList = r107;
    }

    public /* synthetic */ CombineInfo(CombineBaseInfo r100, String r110, Integer r111, CopyOnWriteArrayList r112, String r113, Integer r114, Map r115, CopyOnWriteArrayList r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        CombineBaseInfo r101 = new CombineBaseInfo(null, null, 3, null);
    L6:
        String r102 = "";
        if ((r117 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r117 & 4) == 0) goto L13;
        Integer r104 = 0;
    L15:
        if ((r117 & 8) == 0) goto L17;
        CopyOnWriteArrayList r105 = new CopyOnWriteArrayList();
    L19:
        if ((r117 & 16) != 0) goto L23;
        r102 = r113;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Integer r106 = 0;
    L27:
        if ((r117 & 64) == 0) goto L29;
        Map r107 = new LinkedHashMap();
    L31:
        if ((r117 & 128) == 0) goto L33;
        CopyOnWriteArrayList r108 = new CopyOnWriteArrayList();
    L34:
        this(r101, r103, r104, r105, r102, r106, r107, r108);
        return;
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }
}
