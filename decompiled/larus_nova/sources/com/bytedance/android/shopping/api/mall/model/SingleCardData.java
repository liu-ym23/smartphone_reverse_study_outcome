package com.bytedance.android.shopping.api.mall.model;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "", "lynxData", "", "lynxSchema", "extra", "skipCache", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getExtra", "()Ljava/lang/String;", "getLynxData", "getLynxSchema", "getSkipCache", "()Z", "setSkipCache", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleCardData {

    @SerializedName("extra")
    private final String extra;

    @SerializedName("lynx_data")
    private final String lynxData;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private final String lynxSchema;
    private transient boolean skipCache;

    public SingleCardData() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ SingleCardData copy$default(SingleCardData r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.lynxData;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.lynxSchema;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.skipCache;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.lynxData;
    }

    public final String component2() {
        return this.lynxSchema;
    }

    public final String component3() {
        return this.extra;
    }

    public final boolean component4() {
        return this.skipCache;
    }

    public final SingleCardData copy(String r100, String r101, String r102, boolean r103) {
        return new SingleCardData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SingleCardData) == false) goto L14;
        SingleCardData r101 = (SingleCardData) r100;
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxSchema, r101.lynxSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L12;
        return false;
    L12:
        if (this.skipCache == r101.skipCache) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.lynxData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxSchema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.extra;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.skipCache;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SingleCardData(lynxData=" + this.lynxData + ", lynxSchema=" + this.lynxSchema + ", extra=" + this.extra + ", skipCache=" + this.skipCache + ")";
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getLynxData() {
        return this.lynxData;
    }

    public final String getLynxSchema() {
        return this.lynxSchema;
    }

    public final boolean getSkipCache() {
        return this.skipCache;
    }

    public final void setSkipCache(boolean r100) {
        this.skipCache = r100;
    }

    public SingleCardData(String r100, String r101, String r102, boolean r103) {
        this.lynxData = r100;
        this.lynxSchema = r101;
        this.extra = r102;
        this.skipCache = r103;
    }

    public /* synthetic */ SingleCardData(String r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
