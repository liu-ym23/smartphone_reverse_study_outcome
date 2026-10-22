package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomPublicScreenInfo;", "", "()V", "attachments", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomPublicScreenAttachments;", "backgroundColor", "", "longPressColor", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomPublicScreenInfo implements h {

    @SerializedName("attachments")
    public RoomPublicScreenAttachments attachments;

    @SerializedName("background_color")
    public String backgroundColor;

    @SerializedName("long_press_color")
    public String longPressColor;

    public RoomPublicScreenInfo() {
    }

    public RoomPublicScreenInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.attachments = new RoomPublicScreenAttachments(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.backgroundColor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.longPressColor = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
