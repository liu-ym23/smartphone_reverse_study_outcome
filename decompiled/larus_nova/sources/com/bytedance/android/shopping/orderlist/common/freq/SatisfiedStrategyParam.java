package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/SatisfiedStrategyParam;", "Ljava/io/Serializable;", "cacheData", "", "", "", "", "key", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActions;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "freqTime", "(Ljava/util/Map;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActions;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;J)V", "getCacheData", "()Ljava/util/Map;", "getFreqTime", "()J", "getKey", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActions;", "getStrategy", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SatisfiedStrategyParam implements Serializable {

    @SerializedName("cache_data")
    private final Map<String, List<Long>> cacheData;

    @SerializedName("freq_time")
    private final long freqTime;

    @SerializedName("key")
    private final FreqActions key;

    @SerializedName("strategy_item")
    private final FreqStrategy strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SatisfiedStrategyParam copy$default(SatisfiedStrategyParam r100, Map r101, FreqActions r102, FreqStrategy r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.cacheData;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.key;
    L8:
        FreqActions r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.strategy;
    L11:
        FreqStrategy r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.freqTime;
    L14:
        Map r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final Map<String, List<Long>> component1() {
        return this.cacheData;
    }

    public final FreqActions component2() {
        return this.key;
    }

    public final FreqStrategy component3() {
        return this.strategy;
    }

    public final long component4() {
        return this.freqTime;
    }

    public final SatisfiedStrategyParam copy(Map<String, List<Long>> r100, FreqActions r101, FreqStrategy r110, long r111) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return new SatisfiedStrategyParam(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SatisfiedStrategyParam) == false) goto L14;
        SatisfiedStrategyParam r101 = (SatisfiedStrategyParam) r100;
        if (Intrinsics.areEqual(this.cacheData, r101.cacheData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L10;
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
        Map<String, List<Long>> r100 = this.cacheData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FreqActions r104 = this.key;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FreqStrategy r107 = this.strategy;
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
        return "SatisfiedStrategyParam(cacheData=" + this.cacheData + ", key=" + this.key + ", strategy=" + this.strategy + ", freqTime=" + this.freqTime + ")";
    }

    public final Map<String, List<Long>> getCacheData() {
        return this.cacheData;
    }

    public final long getFreqTime() {
        return this.freqTime;
    }

    public final FreqActions getKey() {
        return this.key;
    }

    public final FreqStrategy getStrategy() {
        return this.strategy;
    }

    public SatisfiedStrategyParam(Map<String, List<Long>> r100, FreqActions r101, FreqStrategy r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "key");
        this.cacheData = r100;
        this.key = r101;
        this.strategy = r102;
        this.freqTime = r103;
    }

    public /* synthetic */ SatisfiedStrategyParam(Map r100, FreqActions r101, FreqStrategy r110, long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Map r102 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        FreqStrategy r103 = null;
    L10:
        this(r102, r101, r103, r111);
        return;
    L9:
        r103 = r110;
        goto L10
    L5:
        r102 = r100;
        goto L7
    }
}
