package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010*\u001a\u0004\u0018\u00010&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b'\u0010(R\u001c\u0010-\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b+\u0010#¨\u0006."}, d2 = {"Lcom/bytedance/android/live/base/model/message/u2;", "Lvh7/c;", "", "getOpenOrderSingToast", "()Ljava/lang/String;", "getOpenOrderSingToast$annotations", "()V", "openOrderSingToast", "", "getGiftId", "()I", "getGiftId$annotations", "giftId", "", "getAutoEnlarge", "()Z", "getAutoEnlarge$annotations", "autoEnlarge", "", "", "getGiftIds", "()Ljava/util/List;", "getGiftIds$annotations", "giftIds", "getAuditionGiftIds", "getAuditionGiftIds$annotations", "auditionGiftIds", "getShowGiftInfo", "()Ljava/lang/Boolean;", "getShowGiftInfo$annotations", "showGiftInfo", "getAiLyrics", "getAiLyrics$annotations", "aiLyrics", "getMode", "()Ljava/lang/Integer;", "getMode$annotations", "mode", "Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "getRoomSongInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "getRoomSongInfo$annotations", "roomSongInfo", "getStageEffects", "getStageEffects$annotations", "stageEffects", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u2 extends vh7.c<u2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ai_lyrics")
    boolean getAiLyrics();

    @FieldName(name = "audition_gift_ids")
    List<Long> getAuditionGiftIds();

    @FieldName(name = "auto_enlarge")
    boolean getAutoEnlarge();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    int getGiftId();

    @FieldName(name = "gift_ids")
    List<Long> getGiftIds();

    @FieldName(name = "mode")
    Integer getMode();

    @FieldName(name = "open_order_sing_toast")
    String getOpenOrderSingToast();

    @FieldName(name = "room_song_info")
    RoomSongInfo getRoomSongInfo();

    @FieldName(name = "show_gift_info")
    Boolean getShowGiftInfo();

    @FieldName(name = "stage_effects")
    Integer getStageEffects();
}
