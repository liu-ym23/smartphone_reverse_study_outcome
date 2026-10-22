package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003567R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b#\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010'8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001a\u0004\b(\u0010)R\u001a\u0010.\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0006\u001a\u0004\b,\u0010\u0004R\u001a\u00101\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b/\u0010\u0004R\u001a\u00104\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b2\u0010\n¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "Lvh7/c;", "", "getText", "()Ljava/lang/String;", "getText$annotations", "()V", "text", "", "getText_type", "()I", "getText_type$annotations", com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE, "getLabel", "getLabel$annotations", "label", "getAnchorLayer", "getAnchorLayer$annotations", "anchorLayer", "Lcom/bytedance/android/livesdk/link/model/d6;", "getLinkerInfo", "()Lcom/bytedance/android/livesdk/link/model/d6;", "getLinkerInfo$annotations", "linkerInfo", "Lcom/bytedance/android/livesdk/link/model/u;", "getAnchorLinkmicUserSettings", "()Lcom/bytedance/android/livesdk/link/model/u;", "getAnchorLinkmicUserSettings$annotations", "anchorLinkmicUserSettings", "Lcom/bytedance/android/livesdk/link/model/h;", "getAnchorBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/h;", "getAnchorBattleSetting$annotations", "anchorBattleSetting", "", "getVideoShowScore", "()J", "getVideoShowScore$annotations", "videoShowScore", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo$b;", "getGameInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo$b;", "getGameInfo$annotations", "gameInfo", "getRecommendInfo", "getRecommendInfo$annotations", "recommendInfo", "getSignExtra", "getSignExtra$annotations", "signExtra", "getServerInviteType", "getServerInviteType$annotations", "serverInviteType", "AnchorLayer", "b", "TextType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRivalExtraInfo extends vh7.c<IRivalExtraInfo> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo$AnchorLayer;", "", "AnchorLayerUnknown", "AnchorLayerTop", "AnchorLayerSMALL", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AnchorLayer extends Enum<AnchorLayer> {
        public static final AnchorLayer AnchorLayerSMALL = null;
        public static final AnchorLayer AnchorLayerTop = null;
        public static final AnchorLayer AnchorLayerUnknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorLayer[] f147066a = null;

        static {
            AnchorLayer r100 = new AnchorLayer("AnchorLayerUnknown", 0);
            AnchorLayerUnknown = r100;
            AnchorLayer r101 = new AnchorLayer("AnchorLayerTop", 1);
            AnchorLayerTop = r101;
            AnchorLayer r102 = new AnchorLayer("AnchorLayerSMALL", 2);
            AnchorLayerSMALL = r102;
            f147066a = new AnchorLayer[]{r100, r101, r102};
        }

        public static AnchorLayer valueOf(String r100) {
            return (AnchorLayer) r27.a.a(AnchorLayer.class, r100);
        }

        public static AnchorLayer[] values() {
            return (AnchorLayer[]) f147066a.clone();
        }

        public AnchorLayer(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo$TextType;", "", "TextTypeUnknown", "CurRoomFanTicket", "TotalDiamondCount", "Distance", "DistanceCity", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TextType extends Enum<TextType> {
        public static final TextType CurRoomFanTicket = null;
        public static final TextType Distance = null;
        public static final TextType DistanceCity = null;
        public static final TextType TextTypeUnknown = null;
        public static final TextType TotalDiamondCount = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextType[] f147067a = null;

        static {
            TextType r100 = new TextType("TextTypeUnknown", 0);
            TextTypeUnknown = r100;
            TextType r101 = new TextType("CurRoomFanTicket", 1);
            CurRoomFanTicket = r101;
            TextType r102 = new TextType("TotalDiamondCount", 2);
            TotalDiamondCount = r102;
            TextType r103 = new TextType("Distance", 3);
            Distance = r103;
            TextType r104 = new TextType("DistanceCity", 4);
            DistanceCity = r104;
            f147067a = new TextType[]{r100, r101, r102, r103, r104};
        }

        public static TextType valueOf(String r100) {
            return (TextType) r27.a.a(TextType.class, r100);
        }

        public static TextType[] values() {
            return (TextType[]) f147067a.clone();
        }

        public TextType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo$b;", "Lvh7/c;", "", "getGameText", "()Ljava/lang/String;", "getGameText$annotations", "()V", "gameText", "getGameName", "getGameName$annotations", "gameName", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = EventConstants.ExtraJson.GAME_NAME)
        String getGameName();

        @FieldName(name = "game_text")
        String getGameText();
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_user_settings")
    h getAnchorBattleSetting();

    @FieldName(name = "anchor_layer")
    int getAnchorLayer();

    @FieldName(name = "linkmic_user_settings")
    u getAnchorLinkmicUserSettings();

    @FieldName(name = "game_info")
    b getGameInfo();

    @FieldName(name = "label")
    String getLabel();

    @FieldName(name = "linker_info")
    d6 getLinkerInfo();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    String getRecommendInfo();

    @FieldName(name = "from_server_invite_type")
    int getServerInviteType();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE)
    int getText_type();

    @FieldName(name = "video_show_score")
    long getVideoShowScore();
}
