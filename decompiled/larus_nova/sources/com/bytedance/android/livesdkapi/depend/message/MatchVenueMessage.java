package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.MatchVenueMessage")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MatchVenueMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/message/VideoCardModule;", "videoCard", "Lcom/bytedance/android/livesdkapi/depend/message/VideoCardModule;", "Lcom/bytedance/android/livesdkapi/depend/message/MatchReservationModule;", "matchReservation", "Lcom/bytedance/android/livesdkapi/depend/message/MatchReservationModule;", "Lcom/bytedance/android/livesdkapi/depend/message/FootballTalkingModule;", "footballTalking", "Lcom/bytedance/android/livesdkapi/depend/message/FootballTalkingModule;", "Lcom/bytedance/android/livesdkapi/depend/message/PopularStarModule;", "popularStar", "Lcom/bytedance/android/livesdkapi/depend/message/PopularStarModule;", "Lcom/bytedance/android/livesdkapi/depend/message/HotLiveModule;", "hotLive", "Lcom/bytedance/android/livesdkapi/depend/message/HotLiveModule;", "Lcom/bytedance/android/livesdkapi/depend/message/VenueInfo;", "venueInfo", "Lcom/bytedance/android/livesdkapi/depend/message/VenueInfo;", "teamReservation", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchVenueMessage extends o0 implements h {

    @SerializedName("football_talking")
    public FootballTalkingModule footballTalking;

    @SerializedName("hot_live")
    public HotLiveModule hotLive;

    @SerializedName("match_reservation")
    public MatchReservationModule matchReservation;

    @SerializedName("popular_star")
    public PopularStarModule popularStar;

    @SerializedName("team_reservation")
    public MatchReservationModule teamReservation;

    @SerializedName("venue_info")
    public VenueInfo venueInfo;

    @SerializedName("video_card")
    public VideoCardModule videoCard;

    public MatchVenueMessage() {
        this.type = MessageType.MATCH_VENUE_MESSAGE;
    }

    public MatchVenueMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        this.teamReservation = new MatchReservationModule(r100);
        goto L3
    L9:
        this.venueInfo = new VenueInfo(r100);
        goto L3
    L10:
        this.hotLive = new HotLiveModule(r100);
        goto L3
    L11:
        this.popularStar = new PopularStarModule(r100);
        goto L3
    L12:
        this.footballTalking = new FootballTalkingModule(r100);
        goto L3
    L13:
        this.matchReservation = new MatchReservationModule(r100);
        goto L3
    L14:
        this.videoCard = new VideoCardModule(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.MATCH_VENUE_MESSAGE;
    }
}
