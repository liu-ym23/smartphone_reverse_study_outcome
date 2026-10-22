package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/vd;", "", "", "isLandscapeSupported", "Ljava/lang/Boolean;", "", "width", "Ljava/lang/Integer;", "height", "bottom", "right", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class vd implements vh7.h {

    @SerializedName("bottom")
    public Integer bottom;

    @SerializedName("height")
    public Integer height;

    @SerializedName("is_landscape_supported")
    public Boolean isLandscapeSupported;

    @SerializedName("right")
    public Integer right;

    @SerializedName("width")
    public Integer width;

    public vd() {
        this.isLandscapeSupported = Boolean.FALSE;
    }

    public vd(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.isLandscapeSupported = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.width = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.height = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.bottom = Integer.valueOf(r100.i());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.right = Integer.valueOf(r100.i());
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.isLandscapeSupported != null) goto L43;
        this.isLandscapeSupported = Boolean.FALSE;
        return;
    }
}
