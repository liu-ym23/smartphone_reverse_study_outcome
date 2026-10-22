package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/image/a;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "matchersType", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "", "minBitmapSizeBytes", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "maxBitmapSizeBytes", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a implements d.b {

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("max_bitmap_size_bytes")
    private final Integer maxBitmapSizeBytes;

    @SerializedName("min_bitmap_size_bytes")
    private final Integer minBitmapSizeBytes;

    @SerializedName("support_mather")
    private final List<d> supportMather;

    public a() {
        this(null);
    }

    public final int hashCode() {
        Boolean r100 = this.ignoreMatch;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<d> r104 = this.supportMather;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.matchersType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.minBitmapSizeBytes;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.maxBitmapSizeBytes;
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

    public final String toString() {
        return "ECImageBitmapPrepareToDrawModel(ignoreMatch=" + this.ignoreMatch + ", supportMather=" + this.supportMather + ", matchersType=" + this.matchersType + ", minBitmapSizeBytes=" + this.minBitmapSizeBytes + ", maxBitmapSizeBytes=" + this.maxBitmapSizeBytes + ")";
    }

    public final Integer a() {
        return this.maxBitmapSizeBytes;
    }

    public final Integer b() {
        return this.minBitmapSizeBytes;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public a(Object r100) {
        this.ignoreMatch = null;
        this.supportMather = null;
        this.matchersType = null;
        this.minBitmapSizeBytes = null;
        this.maxBitmapSizeBytes = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.ignoreMatch, r101.ignoreMatch) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supportMather, r101.supportMather) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.matchersType, r101.matchersType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minBitmapSizeBytes, r101.minBitmapSizeBytes) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.maxBitmapSizeBytes, r101.maxBitmapSizeBytes) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }
}
