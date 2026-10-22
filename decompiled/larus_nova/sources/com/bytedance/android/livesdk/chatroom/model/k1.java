package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface k1 extends vh7.c<k1> {
    public static final int DataType_OpenPlatform = 2;
    public static final int DataType_SelfEmployed = 1;
    public static final int InteractType_OpenGame = 100;
    public static final int InteractType_OpenMicroApp = 103;
    public static final int InteractType_SonicMiniGame = 104;
    public static final int Type_Adventure = 12;
    public static final int Type_Audio_Radio = 103;
    public static final int Type_Game = 10;
    public static final int Type_GuestBattle = 3;
    public static final int Type_IGuess = 62;
    public static final int Type_InteractActing = 15;
    public static final int Type_Interactive_Song = 10;
    public static final int Type_KTV = 101;
    public static final int Type_KTV_CHALLENGE = 6;
    public static final int Type_Minesweeper = 64;
    public static final int Type_OpenGame = 100;
    public static final int Type_OpenMicroApp = 103;
    public static final int Type_PaidLinkmic = 5;
    public static final int Type_RealTimeChorus = 102;
    public static final int Type_RoomBattle = 7;
    public static final int Type_RoomChat = 100;
    public static final int Type_SELF_DISCIPLINE = 8;
    public static final int Type_SonicMiniGame = 104;
    public static final int Type_StarWish = 13;
    public static final int Type_TeamFight = 2;
    public static final int Type_Themed_Competition = 11;
    public static final int Type_Turtle_Soup = 65;
    public static final int Type_UnKnown = 0;
    public static final int Type_Undercover = 61;
    public static final int Type_VideoKTV = 1;
    public static final int Type_WereWolfNight = 63;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = SocialConstants.PARAM_APP_DESC)
    String getDesc();

    @FieldName(name = "data_type")
    int getGameDataType();

    @FieldName(name = "icon")
    py.k getIcon();

    @SerializedName("interact_info")
    q1 getInteractInfo();

    @FieldName(name = "new_arrival")
    boolean getNewArrival();

    @FieldName(name = "playmode")
    long getPlayModeId();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "is_dynamic")
    boolean isDynamic();

    void setGameDataType(int r100);

    void setInteractInfo(q1 r100);

    void setPlayModeId(long r100);

    void setType(int r100);
}
