package com.bytedance.android.livesdkapi.room.handler.toolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u0001:#\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./012B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\"3456789:;<=>?@ABCDEFGHIJKLMNOPQRST¨\u0006U"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "", "id", "", "groupId", "name", "", "(IILjava/lang/String;)V", "getGroupId$annotations", "()V", "getGroupId", "()I", "getId", "getName", "()Ljava/lang/String;", "toString", "CommerceCart", "Companion", "GamePromote", "LifeGroupon", "LittleGame", "MiniApp", "MiniGame", "TicketSale", "ToolBarVSMessageBoard", "ToolbarAudioSubtitle", "ToolbarCommerceIM", "ToolbarCoupon", "ToolbarEasterEgg", "ToolbarExchange", "ToolbarFastGift", "ToolbarGift", "ToolbarIM", "ToolbarLandscapeMultiTab", "ToolbarLinkmic", "ToolbarMorePanel", "ToolbarMultiCamera", "ToolbarRoomChannel", "ToolbarShare", "ToolbarTreasureBox", "ToolbarUnionLive", "ToolbarVR", "ToolbarVSAnthology", "ToolbarVSClarity", "ToolbarVSMatchMultiCamera", "ToolbarVSMultiCamera", "ToolbarVSOperation", "ToolbarVSSNAPSHOT", "ToolbarWatchLater", "TransformWidget", "Welfare", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$CommerceCart;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$GamePromote;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$LifeGroupon;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$LittleGame;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$MiniApp;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$MiniGame;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$TicketSale;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolBarVSMessageBoard;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarAudioSubtitle;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarCommerceIM;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarCoupon;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarEasterEgg;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarExchange;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarFastGift;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarGift;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarIM;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarLandscapeMultiTab;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarLinkmic;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarMorePanel;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarMultiCamera;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarRoomChannel;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarShare;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarTreasureBox;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarUnionLive;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVR;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSAnthology;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSClarity;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSMatchMultiCamera;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSMultiCamera;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSOperation;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSSNAPSHOT;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarWatchLater;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$TransformWidget;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$Welfare;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class NewToolbarButtonConstants {
    public static final int COMMERCE_CART = 1;
    public static final Companion Companion = null;
    public static final int GAME_PROMOTE = 5;
    public static final String IN_ANCHOR = "_Anchor";
    public static final String IN_AUDIENCE = "_Audience";
    public static final String IN_MORE = "_More";
    public static final String IN_TOOLBAR = "_Toolbar";
    public static final int LIFE_GROUPON = 7;
    public static final int LITTLE_GAME = 9;
    public static final int MINI_APP = 3;
    public static final int MINI_GAME = 6;
    public static final int TICKET_SALE = 8;
    public static final int TOOLBAR_ANCHOR_MORE_ADD_PICTURE = 3071;
    public static final int TOOLBAR_ANCHOR_MORE_COMMENT = 3003;
    public static final int TOOLBAR_ANCHOR_MORE_CONTENT_MANAGE = 3051;
    public static final int TOOLBAR_ANCHOR_MORE_CONTENT_SELECTION = 3057;
    public static final int TOOLBAR_ANCHOR_MORE_FAN_GROUP = 3002;
    public static final int TOOLBAR_ANCHOR_MORE_FUNCTION_SETTING = 3104;
    public static final int TOOLBAR_ANCHOR_MORE_LIVE_MANAGE = 3103;
    public static final int TOOLBAR_ANCHOR_MORE_MUSIC = 3001;
    public static final int TOOLBAR_ANCHOR_MORE_PAUSE = 3059;
    public static final int TOOLBAR_ANCHOR_MORE_PREVIEW = 3007;
    public static final int TOOLBAR_ANCHOR_MORE_PUBLIC_AREA_SETTING = 3058;
    public static final int TOOLBAR_ANCHOR_MORE_RECORD = 3056;
    public static final int TOOLBAR_ANCHOR_MORE_SHARE = 3053;
    public static final int TOOLBAR_ANCHOR_PUBLIC_AREA_HELPER = 3062;
    public static final int TOOLBAR_ANCHOR_ROOM_CHANNEL = 3061;
    public static final int TOOLBAR_ANCHOR_STABLE_MODE = 3060;
    public static final int TOOLBAR_AUDIO_SUBTITLE = 1039;
    public static final int TOOLBAR_COMMERCE_IM = 43;
    public static final int TOOLBAR_COUPON = 25;
    public static final int TOOLBAR_DECORATION = 40;
    public static final int TOOLBAR_EASTER_EGG = 22;
    public static final int TOOLBAR_EXCHANGE = 30;
    public static final int TOOLBAR_FAST_GIFT = 29;
    public static final int TOOLBAR_GIFT = 28;
    public static final int TOOLBAR_IM = 21;
    public static final int TOOLBAR_INTERACTION = 39;
    public static final int TOOLBAR_LANDSCAPE_MULTI_TAB = 38;
    public static final int TOOLBAR_LINKMIC = 26;
    public static final int TOOLBAR_MERCHANT_QUALIFICATIONS = 1061;
    public static final int TOOLBAR_MESSAGE_NOTIFICATION = 1059;
    public static final int TOOLBAR_MORE = 24;
    public static final int TOOLBAR_MORE_PANEL_UNION_LIVE = 1036;
    public static final int TOOLBAR_MULTI_CAMERA = 42;
    public static final int TOOLBAR_RECHARGE_RECORD = 1060;
    public static final int TOOLBAR_ROOM_CHANNEL = 31;
    public static final int TOOLBAR_SHARE = 20;
    public static final int TOOLBAR_TREASURE_BOX = 41;
    public static final int TOOLBAR_VR = 23;
    public static final int TOOLBAR_VS_ANTHOLOGY = 36;
    public static final int TOOLBAR_VS_CLARITY = 35;
    public static final int TOOLBAR_VS_MATCH_MULTI_CAMERA = 37;
    public static final int TOOLBAR_VS_MESSAGE_BOARD = 27;
    public static final int TOOLBAR_VS_MESSAGE_BOARD_REPLAY = 12;
    public static final int TOOLBAR_VS_MULTI_CAMERA = 34;
    public static final int TOOLBAR_VS_OPERATION = 32;
    public static final int TOOLBAR_VS_SNAPSHOT = 33;
    public static final int TOOLBAR_WATCH_LATER = 1062;
    public static final int TRANSFORM_WIDGET = 2;
    public static final int WELFARE = 4;
    private static ArrayList<NewToolbarButtonConstants> list;
    private static List<Integer> mountButtonIds;
    private final int groupId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f162653id;
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$CommerceCart;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommerceCart extends NewToolbarButtonConstants {
        public static final CommerceCart INSTANCE = null;

        static {
            INSTANCE = new CommerceCart();
        }

        private CommerceCart() {
            int r100 = 1;
            int r101 = 0;
            super(r100, r101, "CommerceCart", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010G\u001a\u0004\u0018\u00010C2\u0006\u0010H\u001a\u00020\u0004J\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040FR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010A\u001a\u0016\u0012\u0004\u0012\u00020C\u0018\u00010Bj\n\u0012\u0004\u0012\u00020C\u0018\u0001`DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$Companion;", "", "()V", "COMMERCE_CART", "", "GAME_PROMOTE", "IN_ANCHOR", "", "IN_AUDIENCE", "IN_MORE", "IN_TOOLBAR", "LIFE_GROUPON", "LITTLE_GAME", "MINI_APP", "MINI_GAME", "TICKET_SALE", "TOOLBAR_ANCHOR_MORE_ADD_PICTURE", "TOOLBAR_ANCHOR_MORE_COMMENT", "TOOLBAR_ANCHOR_MORE_CONTENT_MANAGE", "TOOLBAR_ANCHOR_MORE_CONTENT_SELECTION", "TOOLBAR_ANCHOR_MORE_FAN_GROUP", "TOOLBAR_ANCHOR_MORE_FUNCTION_SETTING", "TOOLBAR_ANCHOR_MORE_LIVE_MANAGE", "TOOLBAR_ANCHOR_MORE_MUSIC", "TOOLBAR_ANCHOR_MORE_PAUSE", "TOOLBAR_ANCHOR_MORE_PREVIEW", "TOOLBAR_ANCHOR_MORE_PUBLIC_AREA_SETTING", "TOOLBAR_ANCHOR_MORE_RECORD", "TOOLBAR_ANCHOR_MORE_SHARE", "TOOLBAR_ANCHOR_PUBLIC_AREA_HELPER", "TOOLBAR_ANCHOR_ROOM_CHANNEL", "TOOLBAR_ANCHOR_STABLE_MODE", "TOOLBAR_AUDIO_SUBTITLE", "TOOLBAR_COMMERCE_IM", "TOOLBAR_COUPON", "TOOLBAR_DECORATION", "TOOLBAR_EASTER_EGG", "TOOLBAR_EXCHANGE", "TOOLBAR_FAST_GIFT", "TOOLBAR_GIFT", "TOOLBAR_IM", "TOOLBAR_INTERACTION", "TOOLBAR_LANDSCAPE_MULTI_TAB", "TOOLBAR_LINKMIC", "TOOLBAR_MERCHANT_QUALIFICATIONS", "TOOLBAR_MESSAGE_NOTIFICATION", "TOOLBAR_MORE", "TOOLBAR_MORE_PANEL_UNION_LIVE", "TOOLBAR_MULTI_CAMERA", "TOOLBAR_RECHARGE_RECORD", "TOOLBAR_ROOM_CHANNEL", "TOOLBAR_SHARE", "TOOLBAR_TREASURE_BOX", "TOOLBAR_VR", "TOOLBAR_VS_ANTHOLOGY", "TOOLBAR_VS_CLARITY", "TOOLBAR_VS_MATCH_MULTI_CAMERA", "TOOLBAR_VS_MESSAGE_BOARD", "TOOLBAR_VS_MESSAGE_BOARD_REPLAY", "TOOLBAR_VS_MULTI_CAMERA", "TOOLBAR_VS_OPERATION", "TOOLBAR_VS_SNAPSHOT", "TOOLBAR_WATCH_LATER", "TRANSFORM_WIDGET", "WELFARE", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "Lkotlin/collections/ArrayList;", "mountButtonIds", "", "getConstants", "id", "getMountButtonIds", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final List<Integer> getMountButtonIds() {
            List<Integer> r100 = NewToolbarButtonConstants.access$getMountButtonIds$cp();
            if (r100 != null) goto L6;
            List<Integer> r101 = CollectionsKt.listOf(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            NewToolbarButtonConstants.access$setMountButtonIds$cp(r101);
            return r101;
        L6:
            return r100;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final NewToolbarButtonConstants getConstants(int r100) {
            if (NewToolbarButtonConstants.access$getList$cp() != null) goto L5;
            NewToolbarButtonConstants.access$setList$cp(CollectionsKt.arrayListOf(new NewToolbarButtonConstants[]{CommerceCart.INSTANCE, TransformWidget.INSTANCE, MiniApp.INSTANCE, Welfare.INSTANCE, GamePromote.INSTANCE, LittleGame.INSTANCE, MiniGame.INSTANCE, LifeGroupon.INSTANCE, TicketSale.INSTANCE, ToolbarShare.INSTANCE, ToolbarMorePanel.INSTANCE, ToolbarVR.INSTANCE, ToolbarMultiCamera.INSTANCE, ToolbarIM.INSTANCE, ToolbarEasterEgg.INSTANCE, ToolbarCoupon.INSTANCE, ToolbarLinkmic.INSTANCE, ToolbarRoomChannel.INSTANCE, ToolBarVSMessageBoard.INSTANCE, ToolbarGift.INSTANCE, ToolbarFastGift.INSTANCE, ToolbarLandscapeMultiTab.INSTANCE, ToolbarExchange.INSTANCE, ToolbarVSOperation.INSTANCE, ToolbarVSSNAPSHOT.INSTANCE, ToolbarVSMultiCamera.INSTANCE, ToolbarVSClarity.INSTANCE, ToolbarVSAnthology.INSTANCE, ToolbarVSMatchMultiCamera.INSTANCE, ToolbarUnionLive.INSTANCE, ToolbarWatchLater.INSTANCE, ToolbarCommerceIM.INSTANCE}));
        L5:
            ArrayList r101 = NewToolbarButtonConstants.access$getList$cp();
            Object r102 = null;
            if (r101 == null) goto L23;
            Iterator r103 = r101.iterator();
        L9:
            if (r103.hasNext() == false) goto L17;
            Object r104 = r103.next();
            if (((NewToolbarButtonConstants) r104).getId() != r100) goto L13;
            boolean r105 = true;
        L14:
            if (r105 == false) goto L9;
            r102 = r104;
            goto L17
        L13:
            r105 = false;
        L17:
            return (NewToolbarButtonConstants) r102;
        L23:
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$GamePromote;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GamePromote extends NewToolbarButtonConstants {
        public static final GamePromote INSTANCE = null;

        static {
            INSTANCE = new GamePromote();
        }

        private GamePromote() {
            int r100 = 5;
            int r101 = 0;
            super(r100, r101, "GamePromote", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$LifeGroupon;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LifeGroupon extends NewToolbarButtonConstants {
        public static final LifeGroupon INSTANCE = null;

        static {
            INSTANCE = new LifeGroupon();
        }

        private LifeGroupon() {
            int r100 = 7;
            int r101 = 0;
            super(r100, r101, "LifeGroupon", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$LittleGame;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LittleGame extends NewToolbarButtonConstants {
        public static final LittleGame INSTANCE = null;

        static {
            INSTANCE = new LittleGame();
        }

        private LittleGame() {
            int r100 = 9;
            int r101 = 0;
            super(r100, r101, "LittleGame", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$MiniApp;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiniApp extends NewToolbarButtonConstants {
        public static final MiniApp INSTANCE = null;

        static {
            INSTANCE = new MiniApp();
        }

        private MiniApp() {
            int r100 = 3;
            int r101 = 0;
            super(r100, r101, "MiniApp", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$MiniGame;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiniGame extends NewToolbarButtonConstants {
        public static final MiniGame INSTANCE = null;

        static {
            INSTANCE = new MiniGame();
        }

        private MiniGame() {
            int r100 = 6;
            int r101 = 0;
            super(r100, r101, "MiniGame", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$TicketSale;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TicketSale extends NewToolbarButtonConstants {
        public static final TicketSale INSTANCE = null;

        static {
            INSTANCE = new TicketSale();
        }

        private TicketSale() {
            int r100 = 8;
            int r101 = 0;
            super(r100, r101, "TicketSale", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolBarVSMessageBoard;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolBarVSMessageBoard extends NewToolbarButtonConstants {
        public static final ToolBarVSMessageBoard INSTANCE = null;

        static {
            INSTANCE = new ToolBarVSMessageBoard();
        }

        private ToolBarVSMessageBoard() {
            int r100 = 27;
            int r101 = 9;
            super(r100, r101, "VSMessageBoard", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarAudioSubtitle;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarAudioSubtitle extends NewToolbarButtonConstants {
        public static final ToolbarAudioSubtitle INSTANCE = null;

        static {
            INSTANCE = new ToolbarAudioSubtitle();
        }

        private ToolbarAudioSubtitle() {
            int r100 = 1039;
            int r101 = -1;
            super(r100, r101, "AudioSubtitle", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarCommerceIM;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarCommerceIM extends NewToolbarButtonConstants {
        public static final ToolbarCommerceIM INSTANCE = null;

        static {
            INSTANCE = new ToolbarCommerceIM();
        }

        private ToolbarCommerceIM() {
            int r100 = 43;
            int r101 = 18;
            super(r100, r101, "CommerceIM", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarCoupon;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarCoupon extends NewToolbarButtonConstants {
        public static final ToolbarCoupon INSTANCE = null;

        static {
            INSTANCE = new ToolbarCoupon();
        }

        private ToolbarCoupon() {
            int r100 = 25;
            int r101 = 6;
            super(r100, r101, "Coupon", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarEasterEgg;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarEasterEgg extends NewToolbarButtonConstants {
        public static final ToolbarEasterEgg INSTANCE = null;

        static {
            INSTANCE = new ToolbarEasterEgg();
        }

        private ToolbarEasterEgg() {
            int r100 = 22;
            int r101 = 3;
            super(r100, r101, "EasterEgg", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarExchange;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarExchange extends NewToolbarButtonConstants {
        public static final ToolbarExchange INSTANCE = null;

        static {
            INSTANCE = new ToolbarExchange();
        }

        private ToolbarExchange() {
            int r100 = 30;
            int r101 = 6;
            super(r100, r101, "Exchange", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarFastGift;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarFastGift extends NewToolbarButtonConstants {
        public static final ToolbarFastGift INSTANCE = null;

        static {
            INSTANCE = new ToolbarFastGift();
        }

        private ToolbarFastGift() {
            int r100 = 29;
            int r101 = 6;
            super(r100, r101, "FastGift", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarGift;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarGift extends NewToolbarButtonConstants {
        public static final ToolbarGift INSTANCE = null;

        static {
            INSTANCE = new ToolbarGift();
        }

        private ToolbarGift() {
            int r100 = 28;
            int r101 = 8;
            super(r100, r101, "Gift", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarIM;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarIM extends NewToolbarButtonConstants {
        public static final ToolbarIM INSTANCE = null;

        static {
            INSTANCE = new ToolbarIM();
        }

        private ToolbarIM() {
            int r100 = 21;
            int r101 = 2;
            super(r100, r101, "IM", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarLandscapeMultiTab;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarLandscapeMultiTab extends NewToolbarButtonConstants {
        public static final ToolbarLandscapeMultiTab INSTANCE = null;

        static {
            INSTANCE = new ToolbarLandscapeMultiTab();
        }

        private ToolbarLandscapeMultiTab() {
            int r100 = 38;
            int r101 = 11;
            super(r100, r101, "LandscapeMultiTab", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarLinkmic;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarLinkmic extends NewToolbarButtonConstants {
        public static final ToolbarLinkmic INSTANCE = null;

        static {
            INSTANCE = new ToolbarLinkmic();
        }

        private ToolbarLinkmic() {
            int r100 = 26;
            int r101 = 7;
            super(r100, r101, "Linkmic", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarMorePanel;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarMorePanel extends NewToolbarButtonConstants {
        public static final ToolbarMorePanel INSTANCE = null;

        static {
            INSTANCE = new ToolbarMorePanel();
        }

        private ToolbarMorePanel() {
            int r100 = 24;
            int r101 = 5;
            super(r100, r101, "MorePanel", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarMultiCamera;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarMultiCamera extends NewToolbarButtonConstants {
        public static final ToolbarMultiCamera INSTANCE = null;

        static {
            INSTANCE = new ToolbarMultiCamera();
        }

        private ToolbarMultiCamera() {
            int r100 = 42;
            int r101 = 4;
            super(r100, r101, "MultiCamera", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarRoomChannel;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarRoomChannel extends NewToolbarButtonConstants {
        public static final ToolbarRoomChannel INSTANCE = null;

        static {
            INSTANCE = new ToolbarRoomChannel();
        }

        private ToolbarRoomChannel() {
            int r100 = 31;
            int r101 = 10;
            super(r100, r101, "RoomChannel", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarShare;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarShare extends NewToolbarButtonConstants {
        public static final ToolbarShare INSTANCE = null;

        static {
            INSTANCE = new ToolbarShare();
        }

        private ToolbarShare() {
            int r100 = 20;
            int r101 = 1;
            super(r100, r101, "Share", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarTreasureBox;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarTreasureBox extends NewToolbarButtonConstants {
        public static final ToolbarTreasureBox INSTANCE = null;

        static {
            INSTANCE = new ToolbarTreasureBox();
        }

        private ToolbarTreasureBox() {
            int r100 = 41;
            int r101 = 6;
            super(r100, r101, "TreasureBox", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarUnionLive;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarUnionLive extends NewToolbarButtonConstants {
        public static final ToolbarUnionLive INSTANCE = null;

        static {
            INSTANCE = new ToolbarUnionLive();
        }

        private ToolbarUnionLive() {
            int r100 = 1036;
            int r101 = -1;
            super(r100, r101, "UnionLive", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVR;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVR extends NewToolbarButtonConstants {
        public static final ToolbarVR INSTANCE = null;

        static {
            INSTANCE = new ToolbarVR();
        }

        private ToolbarVR() {
            int r100 = 23;
            int r101 = 4;
            super(r100, r101, "VR", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSAnthology;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVSAnthology extends NewToolbarButtonConstants {
        public static final ToolbarVSAnthology INSTANCE = null;

        static {
            INSTANCE = new ToolbarVSAnthology();
        }

        private ToolbarVSAnthology() {
            int r100 = 36;
            int r101 = 14;
            super(r100, r101, "VSAnthology", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSClarity;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVSClarity extends NewToolbarButtonConstants {
        public static final ToolbarVSClarity INSTANCE = null;

        static {
            INSTANCE = new ToolbarVSClarity();
        }

        private ToolbarVSClarity() {
            int r100 = 35;
            int r101 = 12;
            super(r100, r101, "VSClarity", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSMatchMultiCamera;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVSMatchMultiCamera extends NewToolbarButtonConstants {
        public static final ToolbarVSMatchMultiCamera INSTANCE = null;

        static {
            INSTANCE = new ToolbarVSMatchMultiCamera();
        }

        private ToolbarVSMatchMultiCamera() {
            int r100 = 37;
            int r101 = 17;
            super(r100, r101, "VSMatchMultiCamera", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSMultiCamera;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVSMultiCamera extends NewToolbarButtonConstants {
        public static final ToolbarVSMultiCamera INSTANCE = null;

        static {
            INSTANCE = new ToolbarVSMultiCamera();
        }

        private ToolbarVSMultiCamera() {
            int r100 = 34;
            int r101 = 16;
            super(r100, r101, "VSMultiCamera", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSOperation;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVSOperation extends NewToolbarButtonConstants {
        public static final ToolbarVSOperation INSTANCE = null;

        static {
            INSTANCE = new ToolbarVSOperation();
        }

        private ToolbarVSOperation() {
            int r100 = 32;
            int r101 = 13;
            super(r100, r101, "VSOperation", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarVSSNAPSHOT;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarVSSNAPSHOT extends NewToolbarButtonConstants {
        public static final ToolbarVSSNAPSHOT INSTANCE = null;

        static {
            INSTANCE = new ToolbarVSSNAPSHOT();
        }

        private ToolbarVSSNAPSHOT() {
            int r100 = 33;
            int r101 = 15;
            super(r100, r101, "VSSnapshot", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$ToolbarWatchLater;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarWatchLater extends NewToolbarButtonConstants {
        public static final ToolbarWatchLater INSTANCE = null;

        static {
            INSTANCE = new ToolbarWatchLater();
        }

        private ToolbarWatchLater() {
            int r100 = 1062;
            int r101 = -1;
            super(r100, r101, "WatchLater", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$TransformWidget;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TransformWidget extends NewToolbarButtonConstants {
        public static final TransformWidget INSTANCE = null;

        static {
            INSTANCE = new TransformWidget();
        }

        private TransformWidget() {
            int r100 = 2;
            int r101 = 0;
            super(r100, r101, "Transform", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants$Welfare;", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Welfare extends NewToolbarButtonConstants {
        public static final Welfare INSTANCE = null;

        static {
            INSTANCE = new Welfare();
        }

        private Welfare() {
            int r100 = 4;
            int r101 = 0;
            super(r100, r101, "Welfare", null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Deprecated(message = "stop use")
    public static /* synthetic */ void getGroupId$annotations() {
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f162653id + ')';
    }

    public static final /* synthetic */ ArrayList access$getList$cp() {
        return list;
    }

    public static final /* synthetic */ List access$getMountButtonIds$cp() {
        return mountButtonIds;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.f162653id;
    }

    public final String getName() {
        return this.name;
    }

    public static final /* synthetic */ void access$setList$cp(ArrayList r100) {
        list = r100;
    }

    public static final /* synthetic */ void access$setMountButtonIds$cp(List r100) {
        mountButtonIds = r100;
    }

    private NewToolbarButtonConstants(int r100, int r101, String r102) {
        this.f162653id = r100;
        this.groupId = r101;
        this.name = r102;
    }

    public /* synthetic */ NewToolbarButtonConstants(int r100, int r101, String r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ NewToolbarButtonConstants(int r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
