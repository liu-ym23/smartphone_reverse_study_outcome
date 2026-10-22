package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003J`\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqFields;", "Ljava/io/Serializable;", "skipAppFrequency", "", "maxStoreNum", "", "freqLimitID", "", "freqLimitStrategy", "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "freqScene", "freqServerStore", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "(Ljava/lang/Boolean;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;)V", "getFreqLimitID", "()Ljava/lang/String;", "getFreqLimitStrategy", "()Ljava/util/List;", "getFreqScene", "getFreqServerStore", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "getMaxStoreNum", "()I", "getSkipAppFrequency", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;)Lcom/bytedance/android/shopping/orderlist/common/freq/FreqFields;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqFields implements Serializable {

    @SerializedName("freq_limit_id")
    private final String freqLimitID;

    @SerializedName("freq_limit_strategy")
    private final List<FreqStrategy> freqLimitStrategy;

    @SerializedName("freq_scene")
    private final List<String> freqScene;

    @SerializedName("freq_server_store")
    private final FreqStorage freqServerStore;

    @SerializedName("max_store_num")
    private final int maxStoreNum;

    @SerializedName("skip_app_frequency")
    private final Boolean skipAppFrequency;

    public FreqFields() {
        this(null, 0, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FreqFields copy$default(FreqFields r100, Boolean r101, int r102, String r103, List r104, List r105, FreqStorage r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.skipAppFrequency;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.maxStoreNum;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.freqLimitID;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.freqLimitStrategy;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.freqScene;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.freqServerStore;
    L20:
        Boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Boolean component1() {
        return this.skipAppFrequency;
    }

    public final int component2() {
        return this.maxStoreNum;
    }

    public final String component3() {
        return this.freqLimitID;
    }

    public final List<FreqStrategy> component4() {
        return this.freqLimitStrategy;
    }

    public final List<String> component5() {
        return this.freqScene;
    }

    public final FreqStorage component6() {
        return this.freqServerStore;
    }

    public final FreqFields copy(Boolean r100, int r110, String r111, List<FreqStrategy> r112, List<String> r113, FreqStorage r114) {
        return new FreqFields(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FreqFields) == false) goto L18;
        FreqFields r101 = (FreqFields) r100;
        if (Intrinsics.areEqual(this.skipAppFrequency, r101.skipAppFrequency) == true) goto L8;
        return false;
    L8:
        if (this.maxStoreNum == r101.maxStoreNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.freqLimitID, r101.freqLimitID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.freqLimitStrategy, r101.freqLimitStrategy) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.freqScene, r101.freqScene) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.freqServerStore, r101.freqServerStore) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Boolean r100 = this.skipAppFrequency;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.maxStoreNum) * 31;
        String r104 = this.freqLimitID;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<FreqStrategy> r107 = this.freqLimitStrategy;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.freqScene;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        FreqStorage r113 = this.freqServerStore;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "FreqFields(skipAppFrequency=" + this.skipAppFrequency + ", maxStoreNum=" + this.maxStoreNum + ", freqLimitID=" + this.freqLimitID + ", freqLimitStrategy=" + this.freqLimitStrategy + ", freqScene=" + this.freqScene + ", freqServerStore=" + this.freqServerStore + ")";
    }

    public final String getFreqLimitID() {
        return this.freqLimitID;
    }

    public final List<FreqStrategy> getFreqLimitStrategy() {
        return this.freqLimitStrategy;
    }

    public final List<String> getFreqScene() {
        return this.freqScene;
    }

    public final FreqStorage getFreqServerStore() {
        return this.freqServerStore;
    }

    public final int getMaxStoreNum() {
        return this.maxStoreNum;
    }

    public final Boolean getSkipAppFrequency() {
        return this.skipAppFrequency;
    }

    public FreqFields(Boolean r100, int r101, String r102, List<FreqStrategy> r103, List<String> r104, FreqStorage r105) {
        this.skipAppFrequency = r100;
        this.maxStoreNum = r101;
        this.freqLimitID = r102;
        this.freqLimitStrategy = r103;
        this.freqScene = r104;
        this.freqServerStore = r105;
    }

    public /* synthetic */ FreqFields(Boolean r100, int r101, String r102, List r103, List r110, FreqStorage r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Boolean r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r104 = 100;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        List r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        FreqStorage r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
