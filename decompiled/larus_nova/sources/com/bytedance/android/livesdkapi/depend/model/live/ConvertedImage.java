package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PicoInfo.VirtualLiveBgImages.ConvertedImage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ConvertedImage;", "", GearStrategyConsts.EV_QUALITY, "", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "localPath", "", "(ILcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;)V", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "getLocalPath", "()Ljava/lang/String;", "setLocalPath", "(Ljava/lang/String;)V", "getQuality", "()I", "setQuality", "(I)V", "toJsonObj", "Lorg/json/JSONObject;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConvertedImage implements h {

    @SerializedName("image")
    protected ImageModel image;
    private String localPath;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    protected int quality;

    public ConvertedImage(int r100, ImageModel r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "localPath");
        this.quality = r100;
        this.image = r101;
        this.localPath = r102;
    }

    public final JSONObject toJsonObj() {
        JSONObject r100 = new JSONObject();
        r100.put(GearStrategyConsts.EV_QUALITY, this.quality);
        ImageModel r101 = this.image;
        if (r101 == null) goto L5;
        r100.put("image", ImageModel.toJsonString(r101));
    L5:
        r100.put("local_path", this.localPath);
        return r100;
    }

    public ConvertedImage() {
        this.quality = -1;
        this.image = null;
    }

    public final ImageModel getImage() {
        return this.image;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final int getQuality() {
        return this.quality;
    }

    public ConvertedImage(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.quality = (int) r100.j();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.image = x.a(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & true) == true) goto L15;
        this.quality = -1;
    L15:
        if (this.image != null) goto L27;
        this.image = null;
        return;
    }

    public final void setImage(ImageModel r100) {
        this.image = r100;
    }

    public final void setLocalPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.localPath = r100;
    }

    public final void setQuality(int r100) {
        this.quality = r100;
    }

    public /* synthetic */ ConvertedImage(int r100, ImageModel r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
