package com.bytedance.android.ec.core.hybrid.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/model/TabKitDeeplinkPrefetchRule;", "Ljava/io/Serializable;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "bizTag", "", "prefetchChannelTag", "(ILjava/lang/String;Ljava/lang/String;)V", "getBizTag", "()Ljava/lang/String;", "getPrefetchChannelTag", "getStrategy", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitDeeplinkPrefetchRule implements Serializable {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("prefetch_channel_tag")
    private final String prefetchChannelTag;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final int strategy;

    public TabKitDeeplinkPrefetchRule() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ TabKitDeeplinkPrefetchRule copy$default(TabKitDeeplinkPrefetchRule r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.strategy;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bizTag;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.prefetchChannelTag;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.strategy;
    }

    public final String component2() {
        return this.bizTag;
    }

    public final String component3() {
        return this.prefetchChannelTag;
    }

    public final TabKitDeeplinkPrefetchRule copy(int r100, String r101, String r102) {
        return new TabKitDeeplinkPrefetchRule(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TabKitDeeplinkPrefetchRule) == false) goto L12;
        TabKitDeeplinkPrefetchRule r101 = (TabKitDeeplinkPrefetchRule) r100;
        if (this.strategy == r101.strategy) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.prefetchChannelTag, r101.prefetchChannelTag) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.strategy * 31;
        String r101 = this.bizTag;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.prefetchChannelTag;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "TabKitDeeplinkPrefetchRule(strategy=" + this.strategy + ", bizTag=" + this.bizTag + ", prefetchChannelTag=" + this.prefetchChannelTag + ")";
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final String getPrefetchChannelTag() {
        return this.prefetchChannelTag;
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public TabKitDeeplinkPrefetchRule(int r100, String r101, String r102) {
        this.strategy = r100;
        this.bizTag = r101;
        this.prefetchChannelTag = r102;
    }

    public /* synthetic */ TabKitDeeplinkPrefetchRule(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
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
