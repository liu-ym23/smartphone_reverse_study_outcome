package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003JG\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "", "bcmEmId", "", "bcmEm", "emData", "extra", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;)V", "getBcmEm", "()Ljava/lang/String;", "getBcmEmId", "getEmData", "()Ljava/lang/Object;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getBcmMap", "", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Bcm {

    @SerializedName("bcm_em")
    private final String bcmEm;

    @SerializedName("bcm_em_id")
    private final String bcmEmId;

    @SerializedName("em_data")
    private final Object emData;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    public Bcm() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bcm copy$default(Bcm r100, String r101, String r102, Object r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bcmEmId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bcmEm;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.emData;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extra;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.bcmEmId;
    }

    public final String component2() {
        return this.bcmEm;
    }

    public final Object component3() {
        return this.emData;
    }

    public final Map<String, Object> component4() {
        return this.extra;
    }

    public final Bcm copy(String r100, String r101, Object r102, Map<String, ? extends Object> r103) {
        return new Bcm(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Bcm) == false) goto L14;
        Bcm r101 = (Bcm) r100;
        if (Intrinsics.areEqual(this.bcmEmId, r101.bcmEmId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bcmEm, r101.bcmEm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.emData, r101.emData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.bcmEmId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bcmEm;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.emData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.extra;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "Bcm(bcmEmId=" + this.bcmEmId + ", bcmEm=" + this.bcmEm + ", emData=" + this.emData + ", extra=" + this.extra + ")";
    }

    public final Map<String, Object> getBcmMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = this.bcmEmId;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        r100.put("bcm_em_id", this.bcmEmId);
    L11:
        String r104 = this.bcmEm;
        if (r104 != null) goto L14;
    L15:
        r102 = true;
    L16:
        if (r102 == true) goto L18;
        r100.put("bcm_em", this.bcmEm);
    L18:
        Object r105 = this.emData;
        if (r105 == null) goto L21;
        r100.put("em_data", r105);
    L21:
        Map<String, Object> r106 = this.extra;
        if (r106 == null) goto L24;
        r100.put("extra", r106);
    L24:
        return r100;
    L14:
        if (r104.length() != 0) goto L16;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final String getBcmEm() {
        return this.bcmEm;
    }

    public final String getBcmEmId() {
        return this.bcmEmId;
    }

    public final Object getEmData() {
        return this.emData;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public Bcm(String r100, String r101, Object r102, Map<String, ? extends Object> r103) {
        this.bcmEmId = r100;
        this.bcmEm = r101;
        this.emData = r102;
        this.extra = r103;
    }

    public /* synthetic */ Bcm(String r100, String r101, Object r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
