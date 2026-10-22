package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/image/o0;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "thumbExtraSupport", "Ljava/util/HashSet;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/HashSet;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SerializedName("thumb_extra_support")
    private final HashSet<String> thumbExtraSupport;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.thumbExtraSupport, ((o0) r100).thumbExtraSupport) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        HashSet<String> r100 = this.thumbExtraSupport;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SupportTemplates(thumbExtraSupport=" + this.thumbExtraSupport + ")";
    }

    public o0() {
        this.thumbExtraSupport = null;
    }

    public final HashSet<String> a() {
        return this.thumbExtraSupport;
    }
}
