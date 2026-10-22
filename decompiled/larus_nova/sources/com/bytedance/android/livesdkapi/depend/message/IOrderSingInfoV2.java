package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b!\u0010\"R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b%\u0010\u0005R\u001c\u0010+\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0007\u001a\u0004\b(\u0010)R\u001a\u0010.\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0007\u001a\u0004\b,\u0010\u0014R\u001c\u00103\u001a\u0004\u0018\u00010/8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b0\u00101R\u001c\u00108\u001a\u0004\u0018\u0001048&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IOrderSingInfoV2;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/message/IUserMicrophoneItem;", "getUserMicrophoneList", "()Ljava/util/List;", "getUserMicrophoneList$annotations", "()V", "userMicrophoneList", "", "getGiftId", "()J", "getGiftId$annotations", "giftId", "", "getGiftIds", "getGiftIds$annotations", "giftIds", "", "getAutoEnlarge", "()Z", "getAutoEnlarge$annotations", "autoEnlarge", "", "getCurSingItemId", "()Ljava/lang/String;", "getCurSingItemId$annotations", "curSingItemId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "getMvInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "getMvInfo$annotations", "mvInfo", "getMode", "()Ljava/lang/Long;", "getMode$annotations", "mode", "getAuditionGiftIds", "getAuditionGiftIds$annotations", "auditionGiftIds", "getShowGiftInfo", "()Ljava/lang/Boolean;", "getShowGiftInfo$annotations", "showGiftInfo", "getAiLyricsSwitchOn", "getAiLyricsSwitchOn$annotations", "aiLyricsSwitchOn", "", "getStageEffects", "()Ljava/lang/Integer;", "getStageEffects$annotations", "stageEffects", "Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "getRoomSongInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "getRoomSongInfo$annotations", "roomSongInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IOrderSingInfoV2 extends c<IOrderSingInfoV2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "ai_lyrics_switch_on")
        public static /* synthetic */ void getAiLyricsSwitchOn$annotations() {
        }

        @FieldName(name = "audition_gift_ids")
        public static /* synthetic */ void getAuditionGiftIds$annotations() {
        }

        @FieldName(name = "auto_enlarge")
        public static /* synthetic */ void getAutoEnlarge$annotations() {
        }

        @FieldName(name = "current_sing_item")
        public static /* synthetic */ void getCurSingItemId$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
        public static /* synthetic */ void getGiftId$annotations() {
        }

        @FieldName(name = "gift_ids")
        public static /* synthetic */ void getGiftIds$annotations() {
        }

        @FieldName(name = "mode")
        public static /* synthetic */ void getMode$annotations() {
        }

        @FieldName(name = "mv_info")
        public static /* synthetic */ void getMvInfo$annotations() {
        }

        @FieldName(name = "room_song_info")
        public static /* synthetic */ void getRoomSongInfo$annotations() {
        }

        @FieldName(name = "show_gift_info")
        public static /* synthetic */ void getShowGiftInfo$annotations() {
        }

        @FieldName(name = "stage_effects")
        public static /* synthetic */ void getStageEffects$annotations() {
        }

        @FieldName(name = "user_microphone_list")
        public static /* synthetic */ void getUserMicrophoneList$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "ai_lyrics_switch_on")
    boolean getAiLyricsSwitchOn();

    @FieldName(name = "audition_gift_ids")
    List<Long> getAuditionGiftIds();

    @FieldName(name = "auto_enlarge")
    boolean getAutoEnlarge();

    @FieldName(name = "current_sing_item")
    String getCurSingItemId();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "gift_ids")
    List<Long> getGiftIds();

    @FieldName(name = "mode")
    Long getMode();

    @FieldName(name = "mv_info")
    IOrderSingMVInfo getMvInfo();

    @FieldName(name = "room_song_info")
    RoomSongInfo getRoomSongInfo();

    @FieldName(name = "show_gift_info")
    Boolean getShowGiftInfo();

    @FieldName(name = "stage_effects")
    Integer getStageEffects();

    @FieldName(name = "user_microphone_list")
    List<IUserMicrophoneItem> getUserMicrophoneList();
}
