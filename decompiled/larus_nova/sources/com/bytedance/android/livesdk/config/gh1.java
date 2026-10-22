package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/gh1;", "", "", "width", "I", "getWidth", "()I", "height", "getHeight", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gh1 {

    @SerializedName("height")
    private final int height;

    @SerializedName("width")
    private final int width;

    public gh1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof gh1) == false) goto L10;
        gh1 r101 = (gh1) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.width * 31) + this.height;
    }

    public final String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ")";
    }

    public gh1(int r100) {
        this.width = VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2;
        this.height = 160;
    }
}
