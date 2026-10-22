package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/image/g;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "targetFormat", "Ljava/lang/String;", "getTargetFormat", "()Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "replaceFormats", "Ljava/util/HashSet;", "getReplaceFormats", "()Ljava/util/HashSet;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "matchersType", ce.f26391f, "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class g implements d.b {

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("replace_formats")
    private final HashSet<String> replaceFormats;

    @SerializedName("contents_v2")
    private final List<d> supportMather;

    @SerializedName("target_format")
    private final String targetFormat;

    public final int hashCode() {
        String r100 = this.targetFormat;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashSet<String> r104 = this.replaceFormats;
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
        return "FormatModel(targetFormat=" + this.targetFormat + ", replaceFormats=" + this.replaceFormats + ", supportMather=" + this.supportMather + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ")";
    }

    public g() {
        this.targetFormat = null;
        this.replaceFormats = null;
        this.supportMather = null;
        this.matchersType = null;
        this.ignoreMatch = null;
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

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originFormat");
        HashSet<String> r101 = this.replaceFormats;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100;
    L12:
        if (this.replaceFormats.contains(r100) == false) goto L18;
        String r103 = this.targetFormat;
        if (r103 != null) goto L17;
        return r100;
    L17:
        return r103;
    L18:
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.targetFormat, r101.targetFormat) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.replaceFormats, r101.replaceFormats) == true) goto L10;
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
