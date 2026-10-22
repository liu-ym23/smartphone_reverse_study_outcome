package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u001e\b\u0002\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u001e\b\u0002\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR,\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreMeta;", "Ljava/io/Serializable;", "trackMeta", "Lcom/google/gson/internal/LinkedTreeMap;", "", "", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/TrackMeta;", "businessMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreBusinessMeta;", "(Lcom/google/gson/internal/LinkedTreeMap;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreBusinessMeta;)V", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreBusinessMeta;", "getTrackMeta", "()Lcom/google/gson/internal/LinkedTreeMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4ShopAndStoreBusinessMeta businessMeta;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final LinkedTreeMap<String, Object> trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4ShopAndStoreMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreMeta copy$default(AnchorV4ShopAndStoreMeta r100, LinkedTreeMap r101, AnchorV4ShopAndStoreBusinessMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.trackMeta;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.businessMeta;
    L9:
        return r100.copy(r101, r102);
    }

    public final LinkedTreeMap<String, Object> component1() {
        return this.trackMeta;
    }

    public final AnchorV4ShopAndStoreBusinessMeta component2() {
        return this.businessMeta;
    }

    public final AnchorV4ShopAndStoreMeta copy(LinkedTreeMap<String, Object> r100, AnchorV4ShopAndStoreBusinessMeta r101) {
        return new AnchorV4ShopAndStoreMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ShopAndStoreMeta) == false) goto L10;
        AnchorV4ShopAndStoreMeta r101 = (AnchorV4ShopAndStoreMeta) r100;
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.businessMeta, r101.businessMeta) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        LinkedTreeMap<String, Object> r100 = this.trackMeta;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4ShopAndStoreBusinessMeta r104 = this.businessMeta;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4ShopAndStoreMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4ShopAndStoreBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.trackMeta;
    }

    public AnchorV4ShopAndStoreMeta(LinkedTreeMap<String, Object> r100, AnchorV4ShopAndStoreBusinessMeta r101) {
        this.trackMeta = r100;
        this.businessMeta = r101;
    }

    public /* synthetic */ AnchorV4ShopAndStoreMeta(LinkedTreeMap r100, AnchorV4ShopAndStoreBusinessMeta r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
