package com.bytedance.android.shopping.api.image;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/image/m0;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "srLevel", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "matchersType", ce.f26391f, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class m0 implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f170198a;

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("sr_level")
    private final String srLevel;

    @SerializedName("support_mather")
    private final List<d> supportMather;

    public final int hashCode() {
        String r100 = this.srLevel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.ignoreMatch;
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

    public final String toString() {
        return "SRConfig(srLevel=" + this.srLevel + ", ignoreMatch=" + this.ignoreMatch + ", supportMather=" + this.supportMather + ", matchersType=" + this.matchersType + ")";
    }

    public m0() {
        this.srLevel = null;
        this.ignoreMatch = null;
        this.supportMather = null;
        this.matchersType = null;
        this.f170198a = LazyKt.lazy(new SRConfig$srLevelNum$2(this));
    }

    public final String a() {
        return this.srLevel;
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L14;
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.srLevel, r101.srLevel) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ignoreMatch, r101.ignoreMatch) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supportMather, r101.supportMather) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.matchersType, r101.matchersType) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }
}
