package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "Ljava/io/Serializable;", "skuDocument", "", "Lcom/bytedance/android/ec/model/sku/SkuTrustTagItem;", "showEventTrack", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getShowEventTrack", "()Ljava/util/Map;", "getSkuDocument", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuTrustTags implements Serializable {

    @SerializedName("show_event_track")
    private final Map<String, String> showEventTrack;

    @SerializedName("sku_document")
    private final List<SkuTrustTagItem> skuDocument;

    /* JADX WARN: Multi-variable type inference failed */
    public SkuTrustTags() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuTrustTags copy$default(SkuTrustTags r100, List r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.skuDocument;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.showEventTrack;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<SkuTrustTagItem> component1() {
        return this.skuDocument;
    }

    public final Map<String, String> component2() {
        return this.showEventTrack;
    }

    public final SkuTrustTags copy(List<SkuTrustTagItem> r100, Map<String, String> r101) {
        return new SkuTrustTags(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuTrustTags) == false) goto L10;
        SkuTrustTags r101 = (SkuTrustTags) r100;
        if (Intrinsics.areEqual(this.skuDocument, r101.skuDocument) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showEventTrack, r101.showEventTrack) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<SkuTrustTagItem> r100 = this.skuDocument;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.showEventTrack;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkuTrustTags(skuDocument=" + this.skuDocument + ", showEventTrack=" + this.showEventTrack + ")";
    }

    public final Map<String, String> getShowEventTrack() {
        return this.showEventTrack;
    }

    public final List<SkuTrustTagItem> getSkuDocument() {
        return this.skuDocument;
    }

    public SkuTrustTags(List<SkuTrustTagItem> r100, Map<String, String> r101) {
        this.skuDocument = r100;
        this.showEventTrack = r101;
    }

    public /* synthetic */ SkuTrustTags(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
