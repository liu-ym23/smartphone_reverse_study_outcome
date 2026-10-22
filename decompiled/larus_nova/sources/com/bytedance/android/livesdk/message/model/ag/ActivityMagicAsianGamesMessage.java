package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ActivityMagicAsianGamesMessage")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/ActivityMagicAsianGamesMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "push_id", "Ljava/lang/String;", "getPush_id", "()Ljava/lang/String;", "setPush_id", "(Ljava/lang/String;)V", ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT, "getPush_content", "setPush_content", "", "platform", "I", "getPlatform", "()I", "setPlatform", "(I)V", "Lcom/bytedance/android/livesdk/message/model/ag/VideoCardPushModule;", "video_card", "Lcom/bytedance/android/livesdk/message/model/ag/VideoCardPushModule;", "getVideo_card", "()Lcom/bytedance/android/livesdk/message/model/ag/VideoCardPushModule;", "setVideo_card", "(Lcom/bytedance/android/livesdk/message/model/ag/VideoCardPushModule;)V", "Lcom/bytedance/android/livesdk/message/model/ag/MedalRankListModule;", "medal_list", "Lcom/bytedance/android/livesdk/message/model/ag/MedalRankListModule;", "getMedal_list", "()Lcom/bytedance/android/livesdk/message/model/ag/MedalRankListModule;", "setMedal_list", "(Lcom/bytedance/android/livesdk/message/model/ag/MedalRankListModule;)V", "Lcom/bytedance/android/livesdk/message/model/ag/CollectModule;", ShareChannel.COLLECT, "Lcom/bytedance/android/livesdk/message/model/ag/CollectModule;", "getCollect", "()Lcom/bytedance/android/livesdk/message/model/ag/CollectModule;", "setCollect", "(Lcom/bytedance/android/livesdk/message/model/ag/CollectModule;)V", "Lcom/bytedance/android/livesdk/message/model/ag/ScheduleModule;", "popular_star", "Lcom/bytedance/android/livesdk/message/model/ag/ScheduleModule;", "getPopular_star", "()Lcom/bytedance/android/livesdk/message/model/ag/ScheduleModule;", "setPopular_star", "(Lcom/bytedance/android/livesdk/message/model/ag/ScheduleModule;)V", "Lcom/bytedance/android/livesdk/message/model/ag/LatestNewsModule;", "hot_live", "Lcom/bytedance/android/livesdk/message/model/ag/LatestNewsModule;", "getHot_live", "()Lcom/bytedance/android/livesdk/message/model/ag/LatestNewsModule;", "setHot_live", "(Lcom/bytedance/android/livesdk/message/model/ag/LatestNewsModule;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityMagicAsianGamesMessage extends o0 implements h {

    @SerializedName(ShareChannel.COLLECT)
    protected CollectModule collect;

    @SerializedName("hot_live")
    protected LatestNewsModule hot_live;

    @SerializedName("medal_list")
    protected MedalRankListModule medal_list;

    @SerializedName("platform")
    protected int platform;

    @SerializedName("popular_star")
    protected ScheduleModule popular_star;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT)
    protected String push_content;

    @SerializedName("push_id")
    protected String push_id;

    @SerializedName("video_card")
    protected VideoCardPushModule video_card;

    public ActivityMagicAsianGamesMessage() {
        this.type = MessageType.ACTIVITY_MAGIC_ASIAN_GAMES_MESSAGE;
    }

    public final CollectModule getCollect() {
        return this.collect;
    }

    public final LatestNewsModule getHot_live() {
        return this.hot_live;
    }

    public final MedalRankListModule getMedal_list() {
        return this.medal_list;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final ScheduleModule getPopular_star() {
        return this.popular_star;
    }

    public final String getPush_content() {
        return this.push_content;
    }

    public final String getPush_id() {
        return this.push_id;
    }

    public final VideoCardPushModule getVideo_card() {
        return this.video_card;
    }

    public ActivityMagicAsianGamesMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.hot_live = new LatestNewsModule(r100);
        goto L3
    L8:
        this.popular_star = new ScheduleModule(r100);
        goto L3
    L9:
        this.collect = new CollectModule(r100);
        goto L3
    L10:
        this.medal_list = new MedalRankListModule(r100);
        goto L3
    L11:
        this.video_card = new VideoCardPushModule(r100);
        goto L3
    L12:
        this.platform = r100.i();
        goto L3
    L13:
        this.push_content = am3.h.c(r100);
        goto L3
    L14:
        this.push_id = am3.h.c(r100);
        goto L3
    L15:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        this.type = MessageType.ACTIVITY_MAGIC_ASIAN_GAMES_MESSAGE;
    }

    public final void setCollect(CollectModule r100) {
        this.collect = r100;
    }

    public final void setHot_live(LatestNewsModule r100) {
        this.hot_live = r100;
    }

    public final void setMedal_list(MedalRankListModule r100) {
        this.medal_list = r100;
    }

    public final void setPlatform(int r100) {
        this.platform = r100;
    }

    public final void setPopular_star(ScheduleModule r100) {
        this.popular_star = r100;
    }

    public final void setPush_content(String r100) {
        this.push_content = r100;
    }

    public final void setPush_id(String r100) {
        this.push_id = r100;
    }

    public final void setVideo_card(VideoCardPushModule r100) {
        this.video_card = r100;
    }
}
