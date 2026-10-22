package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.BarStyle")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/m0;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "leftIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getLeftIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setLeftIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "rightIcon", "getRightIcon", "setRightIcon", "", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "", "hasFrame", "Ljava/lang/Boolean;", "getHasFrame", "()Ljava/lang/Boolean;", "setHasFrame", "(Ljava/lang/Boolean;)V", "frameBegin", "getFrameBegin", "setFrameBegin", "frameEnd", "getFrameEnd", "setFrameEnd", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 implements vh7.h {

    @SerializedName("background_color")
    protected String backgroundColor;

    @SerializedName("frame_begin")
    protected String frameBegin;

    @SerializedName("frame_end")
    protected String frameEnd;

    @SerializedName("has_frame")
    protected Boolean hasFrame;

    @SerializedName("left_icon")
    protected ImageModel leftIcon;

    @SerializedName("right_icon")
    protected ImageModel rightIcon;

    @SerializedName("text_color")
    protected String textColor;

    public m0() {
    }

    public m0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.leftIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L8:
        this.frameEnd = am3.h.c(r100);
        goto L3
    L9:
        this.frameBegin = am3.h.c(r100);
        goto L3
    L10:
        this.hasFrame = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L11:
        this.textColor = am3.h.c(r100);
        goto L3
    L12:
        this.backgroundColor = am3.h.c(r100);
        goto L3
    L13:
        this.rightIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }
}
