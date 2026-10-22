package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/TransferParams;", "Ljava/io/Serializable;", "serverStore", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "freqLimitID", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;Ljava/lang/String;Ljava/util/List;)V", "getFreqLimitID", "()Ljava/lang/String;", "getServerStore", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "getStrategy", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransferParams implements Serializable {

    @SerializedName("freq_limit_id")
    private final String freqLimitID;

    @SerializedName("freq_server_store")
    private final FreqStorage serverStore;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final List<FreqStrategy> strategy;

    public TransferParams() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransferParams copy$default(TransferParams r100, FreqStorage r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.serverStore;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.freqLimitID;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.strategy;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final FreqStorage component1() {
        return this.serverStore;
    }

    public final String component2() {
        return this.freqLimitID;
    }

    public final List<FreqStrategy> component3() {
        return this.strategy;
    }

    public final TransferParams copy(FreqStorage r100, String r101, List<FreqStrategy> r102) {
        return new TransferParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TransferParams) == false) goto L12;
        TransferParams r101 = (TransferParams) r100;
        if (Intrinsics.areEqual(this.serverStore, r101.serverStore) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.freqLimitID, r101.freqLimitID) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        FreqStorage r100 = this.serverStore;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.freqLimitID;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<FreqStrategy> r107 = this.strategy;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TransferParams(serverStore=" + this.serverStore + ", freqLimitID=" + this.freqLimitID + ", strategy=" + this.strategy + ")";
    }

    public final String getFreqLimitID() {
        return this.freqLimitID;
    }

    public final FreqStorage getServerStore() {
        return this.serverStore;
    }

    public final List<FreqStrategy> getStrategy() {
        return this.strategy;
    }

    public TransferParams(FreqStorage r100, String r101, List<FreqStrategy> r102) {
        this.serverStore = r100;
        this.freqLimitID = r101;
        this.strategy = r102;
    }

    public /* synthetic */ TransferParams(FreqStorage r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
