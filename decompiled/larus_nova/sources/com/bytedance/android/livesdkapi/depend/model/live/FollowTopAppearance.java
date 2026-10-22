package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomFeedData.FollowTopAppearance")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/FollowTopAppearance;", "", "()V", "cutPosition", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamCutPosition;", "getCutPosition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamCutPosition;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "style", "", "getStyle", "()I", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowTopAppearance implements h {

    @SerializedName("cut_position")
    protected StreamCutPosition cutPosition;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("style")
    protected int style;

    public FollowTopAppearance() {
    }

    public final StreamCutPosition getCutPosition() {
        return this.cutPosition;
    }

    public final ImageModel getImage() {
        return this.image;
    }

    public final int getStyle() {
        return this.style;
    }

    public FollowTopAppearance(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.style = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.cutPosition = new StreamCutPosition(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.image = x.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
