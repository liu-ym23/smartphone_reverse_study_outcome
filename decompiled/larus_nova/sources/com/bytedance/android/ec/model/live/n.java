package com.bytedance.android.ec.model.live;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/live/n;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "showIndex", "Z", "c", "()Z", "", "index", "I", "b", "()I", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("index")
    private final int index;

    @SerializedName("show_index")
    private final boolean showIndex;

    public n() {
        this(null, false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L8;
        return false;
    L8:
        if (this.showIndex == r101.showIndex) goto L10;
        return false;
    L10:
        if (this.index == r101.index) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        ECUrlModel r100 = this.cover;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.showIndex;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return ((r102 + r104) * 31) + this.index;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ECInteractionProduct(cover=" + this.cover + ", showIndex=" + this.showIndex + ", index=" + this.index + ")";
    }

    public final ECUrlModel a() {
        return this.cover;
    }

    public final int b() {
        return this.index;
    }

    public final boolean c() {
        return this.showIndex;
    }

    public n(ECUrlModel r100, boolean r101, int r102) {
        this.cover = r100;
        this.showIndex = r101;
        this.index = r102;
    }
}
