package com.bytedance.android.livesdk.model;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/model/v0;", "", "Lcom/bytedance/android/livesdk/model/t0;", "orientation", "Lcom/bytedance/android/livesdk/model/t0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/model/t0;", "setOrientation", "(Lcom/bytedance/android/livesdk/model/t0;)V", "Lcom/bytedance/android/livesdk/model/y0;", "position", "Lcom/bytedance/android/livesdk/model/y0;", "b", "()Lcom/bytedance/android/livesdk/model/y0;", "setPosition", "(Lcom/bytedance/android/livesdk/model/y0;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName(ExifInterface.TAG_ORIENTATION)
    private t0 orientation;

    @SerializedName("position")
    private y0 position;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v0) == false) goto L10;
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.orientation, r101.orientation) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        t0 r100 = this.orientation;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        y0 r104 = this.position;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SpatialAudioPositionConfig(orientation=" + this.orientation + ", position=" + this.position + ")";
    }

    public v0() {
        this.orientation = null;
        this.position = null;
    }

    public final t0 a() {
        return this.orientation;
    }

    public final y0 b() {
        return this.position;
    }
}
