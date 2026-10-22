package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InfoBoxBackGround")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/InfoBoxBackGround;", "", "()V", "backgroundAlpha", "", "Ljava/lang/Long;", "backgroundColor", "", "backgroundImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InfoBoxBackGround implements vh7.h {

    @SerializedName("background_alpha")
    public Long backgroundAlpha;

    @SerializedName("background_color")
    public String backgroundColor;

    @SerializedName("background_image")
    public ImageModel backgroundImage;

    public InfoBoxBackGround() {
        this.backgroundAlpha = 1L;
        this.backgroundColor = "";
    }

    public InfoBoxBackGround(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.backgroundAlpha = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.backgroundColor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.backgroundImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.backgroundAlpha != null) goto L19;
        this.backgroundAlpha = 1L;
    L19:
        if (this.backgroundColor != null) goto L34;
        this.backgroundColor = "";
        return;
    }
}
