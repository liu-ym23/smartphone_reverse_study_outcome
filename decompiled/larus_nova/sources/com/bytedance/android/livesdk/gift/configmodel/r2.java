package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/r2;", "", "", "", "priceRange", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "urlList", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r2 {

    @SerializedName("price_range")
    private final List<Integer> priceRange;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> urlList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r2) == false) goto L10;
        r2 r101 = (r2) r100;
        if (Intrinsics.areEqual(this.priceRange, r101.priceRange) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<Integer> r100 = this.priceRange;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.urlList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TrayBaseImageConfig(priceRange=" + this.priceRange + ", urlList=" + this.urlList + ")";
    }

    public r2() {
        List<Integer> r100 = CollectionsKt.emptyList();
        List<String> r101 = CollectionsKt.emptyList();
        this.priceRange = r100;
        this.urlList = r101;
    }

    public final List<Integer> a() {
        return this.priceRange;
    }

    public final List<String> b() {
        return this.urlList;
    }
}
