package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.StreamUrl.StreamUrlExtra.AdaptionInfo")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AdaptionInfo;", "", "()V", "verticalResizeMode", "", "getVerticalResizeMode", "()I", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdaptionInfo implements h {

    @SerializedName("vertical_resize_mode")
    protected int verticalResizeMode;

    public AdaptionInfo() {
    }

    public final int getVerticalResizeMode() {
        return this.verticalResizeMode;
    }

    public AdaptionInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.verticalResizeMode = r100.i();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
