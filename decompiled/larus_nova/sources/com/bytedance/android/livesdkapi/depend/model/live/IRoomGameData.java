package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.IGameRoomSticker;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameDataEx;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameDataChannelConfig;", "getRoomGameDataChannelConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameDataChannelConfig;", "getRoomGameDataChannelConfig$annotations", "()V", "roomGameDataChannelConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/IGameRoomSticker;", "getGameRoomSticker", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/IGameRoomSticker;", "getGameRoomSticker$annotations", "gameRoomSticker", "Lcom/bytedance/android/livesdkapi/depend/model/ISandwichBorderInfo;", "getSandwichBorderInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/ISandwichBorderInfo;", "getSandwichBorderInfo$annotations", "sandwichBorderInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGameTagInfo;", "getGameTagInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IGameTagInfo;", "getGameTagInfo$annotations", "gameTagInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomGameData extends c<IRoomGameData>, IRoomGameDataEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "game_room_sticker")
        public static /* synthetic */ void getGameRoomSticker$annotations() {
        }

        @FieldName(name = "game_tag_info")
        public static /* synthetic */ void getGameTagInfo$annotations() {
        }

        @FieldName(name = "room_game_data_channel_config")
        public static /* synthetic */ void getRoomGameDataChannelConfig$annotations() {
        }

        @FieldName(name = "sandwich_border_info")
        public static /* synthetic */ void getSandwichBorderInfo$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "game_room_sticker")
    IGameRoomSticker getGameRoomSticker();

    @FieldName(name = "game_tag_info")
    IGameTagInfo getGameTagInfo();

    @FieldName(name = "room_game_data_channel_config")
    IRoomGameDataChannelConfig getRoomGameDataChannelConfig();

    @FieldName(name = "sandwich_border_info")
    ISandwichBorderInfo getSandwichBorderInfo();
}
