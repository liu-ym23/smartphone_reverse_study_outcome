package com.bytedance.android.shopping.anchorv4.dto.meta;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import h73.b;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\u0004\b'\u0010(J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u001f\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003Jq\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR0\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b&\u0010%¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "component1", "Lcom/google/gson/internal/LinkedTreeMap;", "", "", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/TrackMeta;", "component2", "Lh73/b;", "component3", "", "component4", "component5", "commonMeta", "trackMeta", "skuMeta", "serverMonitorMeta", "commonMetaV2", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "getCommonMeta", "()Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "Lcom/google/gson/internal/LinkedTreeMap;", "getTrackMeta", "()Lcom/google/gson/internal/LinkedTreeMap;", "Lh73/b;", "getSkuMeta", "()Lh73/b;", "Ljava/util/Map;", "getServerMonitorMeta", "()Ljava/util/Map;", "getCommonMetaV2", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;Lcom/google/gson/internal/LinkedTreeMap;Lh73/b;Ljava/util/Map;Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageMeta implements Serializable {

    @SerializedName(PageMetaMappedMap.COMMON_META_KEY)
    private final CommonMeta commonMeta;

    @SerializedName(PageMetaMappedMap.COMMON_META_V2_KEY)
    private final Map<String, Object> commonMetaV2;

    @SerializedName(PageMetaMappedMap.SERVER_MONITOR_META_KEY)
    private final Map<String, String> serverMonitorMeta;

    @SerializedName(PageMetaMappedMap.SKU_META_KEY)
    private final b skuMeta;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final LinkedTreeMap<String, Object> trackMeta;

    public PageMeta() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageMeta copy$default(PageMeta r100, CommonMeta r101, LinkedTreeMap r102, b r103, Map r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.commonMeta;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.trackMeta;
    L8:
        LinkedTreeMap r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.skuMeta;
    L11:
        b r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.serverMonitorMeta;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.commonMetaV2;
    L17:
        CommonMeta r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final CommonMeta component1() {
        return this.commonMeta;
    }

    public final LinkedTreeMap<String, Object> component2() {
        return this.trackMeta;
    }

    public final b component3() {
        return this.skuMeta;
    }

    public final Map<String, String> component4() {
        return this.serverMonitorMeta;
    }

    public final Map<String, Object> component5() {
        return this.commonMetaV2;
    }

    public final PageMeta copy(CommonMeta r100, LinkedTreeMap<String, Object> r101, b r110, Map<String, String> r111, Map<String, ? extends Object> r112) {
        return new PageMeta(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PageMeta) == false) goto L16;
        PageMeta r101 = (PageMeta) r100;
        if (Intrinsics.areEqual(this.commonMeta, r101.commonMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.skuMeta, r101.skuMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serverMonitorMeta, r101.serverMonitorMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.commonMetaV2, r101.commonMetaV2) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        CommonMeta r100 = this.commonMeta;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LinkedTreeMap<String, Object> r104 = this.trackMeta;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.skuMeta;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.serverMonitorMeta;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.commonMetaV2;
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
        return "PageMeta(commonMeta=" + this.commonMeta + ", trackMeta=" + this.trackMeta + ", skuMeta=" + this.skuMeta + ", serverMonitorMeta=" + this.serverMonitorMeta + ", commonMetaV2=" + this.commonMetaV2 + ")";
    }

    public final CommonMeta getCommonMeta() {
        return this.commonMeta;
    }

    public final Map<String, Object> getCommonMetaV2() {
        return this.commonMetaV2;
    }

    public final Map<String, String> getServerMonitorMeta() {
        return this.serverMonitorMeta;
    }

    public final b getSkuMeta() {
        return this.skuMeta;
    }

    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.trackMeta;
    }

    public PageMeta(CommonMeta r100, LinkedTreeMap<String, Object> r101, b r102, Map<String, String> r103, Map<String, ? extends Object> r104) {
        this.commonMeta = r100;
        this.trackMeta = r101;
        this.skuMeta = r102;
        this.serverMonitorMeta = r103;
        this.commonMetaV2 = r104;
    }

    public /* synthetic */ PageMeta(CommonMeta r100, LinkedTreeMap r101, b r102, Map r103, Map r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        CommonMeta r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        LinkedTreeMap r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        b r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Map r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Map r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
