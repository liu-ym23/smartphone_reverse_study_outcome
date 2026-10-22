package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/JudgeStrategyParams;", "Ljava/io/Serializable;", "singleFreqCache", "Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "id", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "freqTime", "", "(Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;Ljava/lang/String;Ljava/util/List;J)V", "getFreqTime", "()J", "getId", "()Ljava/lang/String;", "getSingleFreqCache", "()Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "getStrategy", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JudgeStrategyParams implements Serializable {

    @SerializedName("freq_time")
    private final long freqTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f179869id;

    @SerializedName("single_cache")
    private final SingleFreqCache singleFreqCache;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final List<FreqStrategy> strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JudgeStrategyParams copy$default(JudgeStrategyParams r100, SingleFreqCache r101, String r102, List r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.singleFreqCache;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.f179869id;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.strategy;
    L11:
        List r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.freqTime;
    L14:
        SingleFreqCache r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final SingleFreqCache component1() {
        return this.singleFreqCache;
    }

    public final String component2() {
        return this.f179869id;
    }

    public final List<FreqStrategy> component3() {
        return this.strategy;
    }

    public final long component4() {
        return this.freqTime;
    }

    public final JudgeStrategyParams copy(SingleFreqCache r100, String r101, List<FreqStrategy> r110, long r111) {
        return new JudgeStrategyParams(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof JudgeStrategyParams) == false) goto L14;
        JudgeStrategyParams r101 = (JudgeStrategyParams) r100;
        if (Intrinsics.areEqual(this.singleFreqCache, r101.singleFreqCache) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f179869id, r101.f179869id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L12;
        return false;
    L12:
        if (this.freqTime == r101.freqTime) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        SingleFreqCache r100 = this.singleFreqCache;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f179869id;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<FreqStrategy> r107 = this.strategy;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.freqTime;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "JudgeStrategyParams(singleFreqCache=" + this.singleFreqCache + ", id=" + this.f179869id + ", strategy=" + this.strategy + ", freqTime=" + this.freqTime + ")";
    }

    public final long getFreqTime() {
        return this.freqTime;
    }

    public final String getId() {
        return this.f179869id;
    }

    public final SingleFreqCache getSingleFreqCache() {
        return this.singleFreqCache;
    }

    public final List<FreqStrategy> getStrategy() {
        return this.strategy;
    }

    public JudgeStrategyParams(SingleFreqCache r100, String r101, List<FreqStrategy> r102, long r103) {
        this.singleFreqCache = r100;
        this.f179869id = r101;
        this.strategy = r102;
        this.freqTime = r103;
    }

    public /* synthetic */ JudgeStrategyParams(SingleFreqCache r100, String r101, List r110, long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        SingleFreqCache r102 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        List r104 = null;
    L14:
        this(r102, r103, r104, r111);
        return;
    L13:
        r104 = r110;
        goto L14
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
