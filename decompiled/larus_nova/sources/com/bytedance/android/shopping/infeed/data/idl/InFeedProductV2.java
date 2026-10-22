package com.bytedance.android.shopping.infeed.data.idl;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import he3.n0;
import he3.p0;
import he3.s0;
import he3.u0;
import he3.v;
import he3.z0;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010,\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "Ljava/io/Serializable;", "Lhe3/p0;", "cardData", "Lhe3/n0;", "slcCard", "", "cardName", "Ljava/lang/String;", "getCardName", "()Ljava/lang/String;", "cardType", "getCardType", "cardSubtype", "getCardSubtype", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackData;", "packData", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackData;", "getPackData", "()Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackData;", "setPackData", "(Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackData;)V", "Lhe3/s0;", "filterData", "Lhe3/s0;", "getFilterData", "()Lhe3/s0;", "Lhe3/u0;", "custom", "Lhe3/u0;", "getCustom", "()Lhe3/u0;", "setCustom", "(Lhe3/u0;)V", "Lhe3/z0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lhe3/z0;", "getRespExtra", "()Lhe3/z0;", "setRespExtra", "(Lhe3/z0;)V", "respExtra", "", "isCacheData", "Z", "()Z", "setCacheData", "(Z)V", "isSkeletonData", "setSkeletonData", "Lhe3/v;", "dynamicData", "Lhe3/v;", "getDynamicData", "()Lhe3/v;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedProductV2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient z0 f176230a;

    @SerializedName("card_name")
    private final String cardName;

    @SerializedName("card_subtype")
    private final String cardSubtype;

    @SerializedName(a.KEY_CARD_TYPE)
    private final String cardType;

    @SerializedName("custom")
    private u0 custom;
    private final v dynamicData;

    @SerializedName("filter_data")
    private final s0 filterData;
    private boolean isCacheData;
    private boolean isSkeletonData;

    @SerializedName("pack_data")
    private InFeedProductPackData packData;

    public final p0 cardData() {
        InFeedProductPackData r100 = this.packData;
        if (r100 == null) goto L9;
        InFeedProductPackDataElements r101 = r100.getElements();
        if (r101 == null) goto L9;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L9;
        return (p0) CollectionsKt.firstOrNull(r102);
    L9:
        return null;
    }

    public final n0 slcCard() {
        InFeedProductPackData r100 = this.packData;
        if (r100 == null) goto L7;
        InFeedProductPackDataElements r101 = r100.getElements();
        if (r101 == null) goto L7;
        return r101.getSliceCard();
    L7:
        return null;
    }

    public InFeedProductV2() {
        this.dynamicData = new v();
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getCardSubtype() {
        return this.cardSubtype;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final u0 getCustom() {
        return this.custom;
    }

    public final v getDynamicData() {
        return this.dynamicData;
    }

    public final s0 getFilterData() {
        return this.filterData;
    }

    public final InFeedProductPackData getPackData() {
        return this.packData;
    }

    public final z0 getRespExtra() {
        return this.f176230a;
    }

    public final boolean isCacheData() {
        return this.isCacheData;
    }

    public final boolean isSkeletonData() {
        return this.isSkeletonData;
    }

    public final void setCacheData(boolean r100) {
        this.isCacheData = r100;
    }

    public final void setCustom(u0 r100) {
        this.custom = r100;
    }

    public final void setPackData(InFeedProductPackData r100) {
        this.packData = r100;
    }

    public final void setRespExtra(z0 r100) {
        this.f176230a = r100;
    }

    public final void setSkeletonData(boolean r100) {
        this.isSkeletonData = r100;
    }
}
