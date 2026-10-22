package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/image/f0;", "Lcom/bytedance/android/shopping/api/image/d$b;", "Lcom/bytedance/android/shopping/api/image/w;", "", "targetTemplateName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "targetServiceId", "b", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "matchersType", ce.f26391f, "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class f0 implements d.b, w {

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("contents")
    private final List<d> supportMather;

    @SerializedName("target_service_id")
    private final String targetServiceId;

    @SerializedName("target_template")
    private final String targetTemplateName;

    public final int hashCode() {
        String r100 = this.targetTemplateName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.targetServiceId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<d> r107 = this.supportMather;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.matchersType;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.ignoreMatch;
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
        return "OldTargetTemplate(targetTemplateName=" + this.targetTemplateName + ", targetServiceId=" + this.targetServiceId + ", supportMather=" + this.supportMather + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ")";
    }

    public f0() {
        this.targetTemplateName = null;
        this.targetServiceId = null;
        this.supportMather = null;
        this.matchersType = null;
        this.ignoreMatch = null;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String b() {
        return this.targetServiceId;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String d() {
        return this.targetTemplateName;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L16;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.targetTemplateName, r101.targetTemplateName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetServiceId, r101.targetServiceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supportMather, r101.supportMather) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.matchersType, r101.matchersType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ignoreMatch, r101.ignoreMatch) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }
}
