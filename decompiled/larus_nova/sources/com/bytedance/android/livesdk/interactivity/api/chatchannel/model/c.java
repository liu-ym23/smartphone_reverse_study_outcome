package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u001a\u0010\n\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "channelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "getChannelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "setChannelInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;)V", "getChannelInfo$annotations", "()V", "Lcom/bytedance/android/live/base/model/message/a5;", "creatTips", "Lcom/bytedance/android/live/base/model/message/a5;", "getCreatTips", "()Lcom/bytedance/android/live/base/model/message/a5;", "setCreatTips", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getCreatTips$annotations", "", "guideToast", "Ljava/lang/String;", "getGuideToast", "()Ljava/lang/String;", "setGuideToast", "(Ljava/lang/String;)V", "getGuideToast$annotations", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("channel_info")
    protected RoomChannelInfo channelInfo;

    @SerializedName("create_tips")
    protected a5 creatTips;

    @SerializedName("guide_toast")
    protected String guideToast;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.channelInfo = new RoomChannelInfo(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.creatTips = vh7.f.a(r100, a5.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.guideToast = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
