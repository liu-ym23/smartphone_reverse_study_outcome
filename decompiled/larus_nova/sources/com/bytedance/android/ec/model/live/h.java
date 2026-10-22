package com.bytedance.android.ec.model.live;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/live/h;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "radius", "I", "c", "()I", "Lcom/bytedance/android/ec/model/live/f;", "bubble", "Lcom/bytedance/android/ec/model/live/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/live/f;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("bubble")
    private final f bubble;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("radius")
    private final int radius;

    public h() {
        this(null, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (this.radius == r101.radius) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bubble, r101.bubble) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.radius) * 31;
        f r104 = this.bubble;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECElementImage(image=" + this.image + ", radius=" + this.radius + ", bubble=" + this.bubble + ")";
    }

    public final f a() {
        return this.bubble;
    }

    public final ECUrlModel b() {
        return this.image;
    }

    public final int c() {
        return this.radius;
    }

    public h(ECUrlModel r100, int r101, f r102) {
        this.image = r100;
        this.radius = r101;
        this.bubble = r102;
    }
}
