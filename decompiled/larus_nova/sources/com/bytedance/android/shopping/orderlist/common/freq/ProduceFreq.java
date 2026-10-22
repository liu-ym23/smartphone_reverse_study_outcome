package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/ProduceFreq;", "Ljava/io/Serializable;", "id", "", "action", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "maxStoreNum", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getAction", "()Ljava/lang/String;", "getId", "getMaxStoreNum", "()I", "getStrategy", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProduceFreq implements Serializable {

    @SerializedName("action")
    private final String action;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f179876id;

    @SerializedName("max_store_num")
    private final int maxStoreNum;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final List<FreqStrategy> strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProduceFreq copy$default(ProduceFreq r100, String r101, String r102, List r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f179876id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.action;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.strategy;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.maxStoreNum;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f179876id;
    }

    public final String component2() {
        return this.action;
    }

    public final List<FreqStrategy> component3() {
        return this.strategy;
    }

    public final int component4() {
        return this.maxStoreNum;
    }

    public final ProduceFreq copy(String r100, String r101, List<FreqStrategy> r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "action");
        return new ProduceFreq(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProduceFreq) == false) goto L14;
        ProduceFreq r101 = (ProduceFreq) r100;
        if (Intrinsics.areEqual(this.f179876id, r101.f179876id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L12;
        return false;
    L12:
        if (this.maxStoreNum == r101.maxStoreNum) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.f179876id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.action;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<FreqStrategy> r107 = this.strategy;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.maxStoreNum;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ProduceFreq(id=" + this.f179876id + ", action=" + this.action + ", strategy=" + this.strategy + ", maxStoreNum=" + this.maxStoreNum + ")";
    }

    public final String getAction() {
        return this.action;
    }

    public final String getId() {
        return this.f179876id;
    }

    public final int getMaxStoreNum() {
        return this.maxStoreNum;
    }

    public final List<FreqStrategy> getStrategy() {
        return this.strategy;
    }

    public ProduceFreq(String r100, String r101, List<FreqStrategy> r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f179876id = r100;
        this.action = r101;
        this.strategy = r102;
        this.maxStoreNum = r103;
    }

    public /* synthetic */ ProduceFreq(String r100, String r101, List r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = 100;
    L11:
        this(r100, r101, r102, r103);
    }
}
