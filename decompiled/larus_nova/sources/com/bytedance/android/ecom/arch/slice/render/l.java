package com.bytedance.android.ecom.arch.slice.render;

import com.bytedance.android.livesdk.chatroom.event.VSUserProfileEvent;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/l;", "", "", "topLeft", FaceService.girlLabel, "c", "()F", "topRight", "d", "bottomRight", "b", "bottomLeft", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class l {

    @SerializedName("bottom_left")
    private final float bottomLeft;

    @SerializedName(VSUserProfileEvent.CLICK_POS_RIGHT)
    private final float bottomRight;

    @SerializedName("top_left")
    private final float topLeft;

    @SerializedName("top_right")
    private final float topRight;

    public l() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L14;
        l r101 = (l) r100;
        if (Float.compare(this.topLeft, r101.topLeft) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.topRight, r101.topRight) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.bottomRight, r101.bottomRight) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.bottomLeft, r101.bottomLeft) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.topLeft) * 31) + Float.floatToIntBits(this.topRight)) * 31) + Float.floatToIntBits(this.bottomRight)) * 31) + Float.floatToIntBits(this.bottomLeft);
    }

    public final String toString() {
        return "SlcRadius(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ")";
    }

    public final float a() {
        return this.bottomLeft;
    }

    public final float b() {
        return this.bottomRight;
    }

    public final float c() {
        return this.topLeft;
    }

    public final float d() {
        return this.topRight;
    }

    public l(float r100, float r101, float r102, float r103) {
        this.topLeft = r100;
        this.topRight = r101;
        this.bottomRight = r102;
        this.bottomLeft = r103;
    }
}
