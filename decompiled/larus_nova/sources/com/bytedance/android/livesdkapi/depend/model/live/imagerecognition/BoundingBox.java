package com.bytedance.android.livesdkapi.depend.model.live.imagerecognition;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BoundingBox")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/BoundingBox;", "", "()V", "height", "", "width", "x", "y", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BoundingBox implements h {

    @SerializedName("height")
    public int height;

    @SerializedName("width")
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("xmin")
    public int f162621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("ymin")
    public int f162622y;

    public BoundingBox() {
    }

    public String toString() {
        return "BoundingBox{x=" + this.f162621x + ",y=" + this.f162622y + ",width=" + this.width + ",height=" + this.height + '}';
    }

    public BoundingBox(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.f162621x = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.f162622y = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.width = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.height = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
