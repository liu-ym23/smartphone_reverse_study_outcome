package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes8.dex */
@Target({ElementType.TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000bR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u000f\u0010\f\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010R\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000fR\u000f\u0010\r\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl;", "", "key", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$KEY;", "type", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Type;", "style", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Style;", "attachMarginDp", "", "needDynamicControl", "", "ignoreLock", "reverse", "()F", "()Z", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$KEY;", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Style;", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Type;", "KEY", "Style", "Type", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface PlayerViewControl {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\bP\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQ¨\u0006R"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$KEY;", "", "", "describe", "Ljava/lang/String;", "getDescribe", "()Ljava/lang/String;", "LandScapeEpisodeInfo", "LandScapeAnchorInfo", "CastScreenEntry", "MultiDeviceEntry", "ActivityBannerWidget", "VSShortTermIndicatorWidget", "TopRightWidget", "LandscapeTopToolBar", "VSLandscapeStatusBar", "TopLineToolBar", "VSPortraitTopToolBar", "BrightnessView", "VolumeView", "PlayerShadowTop", "PlayerShadow", "MatchRoomBack", "LandscapeRoomTitle", "LandscapeAnchorInfo", "MatchRoomCount", "PortraitRowOne", "PortraitRowTow", "WatchCount", "FirstShowHint", "FirstShowHintAlpha", "VideoPlayControl", "LivePlayControl", "PlayTip", "ProgressBar", "LandscapeBottomToolBar", "LandscapeBottomLeftToolBar", "PortraitVideoDanmakuSend", "LandscapeDanmakuSend", "PlayerShadowBottom", "VerticalPlayerShadow", "PortraitBottomToolBar", "PortraitBottomFollow", "PortraitBottomComment", "PortraitTopClose", "PortraitCamera", "VerticalVersion", "PortraitTopContent", "VerticalShowPlayInfo", "VerticalTopFollow", "VerticalSelectionEntry", "VerticalDanmakuInput", "PortraitTopAnchor", "PortraitLock", "TextMessage", "ChatChannel", "RightBottomBanner", "KtvCard", "RightCard", "GiftTray", "MoreLiveEntry", "Digg", "DiggSelf", "ECProduct", "PaidLiveTempWatch", "PaidTempCardContainer", "LandscapeDrawer", "LandscapeResetPlayerView", "LandscapeBlockComment", "InteractiveWidget", "LandscapeInteractiveWidget", "BottomRightBanner", "CastScreenLoading", "PlayerViewLock", "LiveOrientationControl", "VideoOrientationControl", "XTab_Test", "LandscapeWatchCountInfo", "QuickShotRecordControl", "QuickShotShotControl", "LandscapeRefresh", "LandscapePhoneInfo", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum KEY extends Enum<KEY> {
        public static final KEY ActivityBannerWidget = null;
        public static final KEY BottomRightBanner = null;
        public static final KEY BrightnessView = null;
        public static final KEY CastScreenEntry = null;
        public static final KEY CastScreenLoading = null;
        public static final KEY ChatChannel = null;
        public static final KEY Digg = null;
        public static final KEY DiggSelf = null;
        public static final KEY ECProduct = null;
        public static final KEY FirstShowHint = null;
        public static final KEY FirstShowHintAlpha = null;
        public static final KEY GiftTray = null;
        public static final KEY InteractiveWidget = null;
        public static final KEY KtvCard = null;
        public static final KEY LandScapeAnchorInfo = null;
        public static final KEY LandScapeEpisodeInfo = null;
        public static final KEY LandscapeAnchorInfo = null;
        public static final KEY LandscapeBlockComment = null;
        public static final KEY LandscapeBottomLeftToolBar = null;
        public static final KEY LandscapeBottomToolBar = null;
        public static final KEY LandscapeDanmakuSend = null;
        public static final KEY LandscapeDrawer = null;
        public static final KEY LandscapeInteractiveWidget = null;
        public static final KEY LandscapePhoneInfo = null;
        public static final KEY LandscapeRefresh = null;
        public static final KEY LandscapeResetPlayerView = null;
        public static final KEY LandscapeRoomTitle = null;
        public static final KEY LandscapeTopToolBar = null;
        public static final KEY LandscapeWatchCountInfo = null;
        public static final KEY LiveOrientationControl = null;
        public static final KEY LivePlayControl = null;
        public static final KEY MatchRoomBack = null;
        public static final KEY MatchRoomCount = null;
        public static final KEY MoreLiveEntry = null;
        public static final KEY MultiDeviceEntry = null;
        public static final KEY PaidLiveTempWatch = null;
        public static final KEY PaidTempCardContainer = null;
        public static final KEY PlayTip = null;
        public static final KEY PlayerShadow = null;
        public static final KEY PlayerShadowBottom = null;
        public static final KEY PlayerShadowTop = null;
        public static final KEY PlayerViewLock = null;
        public static final KEY PortraitBottomComment = null;
        public static final KEY PortraitBottomFollow = null;
        public static final KEY PortraitBottomToolBar = null;
        public static final KEY PortraitCamera = null;
        public static final KEY PortraitLock = null;
        public static final KEY PortraitRowOne = null;
        public static final KEY PortraitRowTow = null;
        public static final KEY PortraitTopAnchor = null;
        public static final KEY PortraitTopClose = null;
        public static final KEY PortraitTopContent = null;
        public static final KEY PortraitVideoDanmakuSend = null;
        public static final KEY ProgressBar = null;
        public static final KEY QuickShotRecordControl = null;
        public static final KEY QuickShotShotControl = null;
        public static final KEY RightBottomBanner = null;
        public static final KEY RightCard = null;
        public static final KEY TextMessage = null;
        public static final KEY TopLineToolBar = null;
        public static final KEY TopRightWidget = null;
        public static final KEY VSLandscapeStatusBar = null;
        public static final KEY VSPortraitTopToolBar = null;
        public static final KEY VSShortTermIndicatorWidget = null;
        public static final KEY VerticalDanmakuInput = null;
        public static final KEY VerticalPlayerShadow = null;
        public static final KEY VerticalSelectionEntry = null;
        public static final KEY VerticalShowPlayInfo = null;
        public static final KEY VerticalTopFollow = null;
        public static final KEY VerticalVersion = null;
        public static final KEY VideoOrientationControl = null;
        public static final KEY VideoPlayControl = null;
        public static final KEY VolumeView = null;
        public static final KEY WatchCount = null;
        public static final KEY XTab_Test = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KEY[] f118391a = null;
        private final String describe;

        public static KEY valueOf(String r100) {
            return (KEY) r27.a.a(KEY.class, r100);
        }

        public static KEY[] values() {
            return (KEY[]) f118391a.clone();
        }

        static {
            KEY r100 = new KEY("LandScapeEpisodeInfo", 0, "横屏顶部信息");
            LandScapeEpisodeInfo = r100;
            KEY r101 = new KEY("LandScapeAnchorInfo", 1, "横屏顶部主播信息");
            LandScapeAnchorInfo = r101;
            KEY r102 = new KEY("CastScreenEntry", 2, "投屏入口");
            CastScreenEntry = r102;
            KEY r103 = new KEY("MultiDeviceEntry", 3, "电脑/Pad打开");
            MultiDeviceEntry = r103;
            KEY r104 = new KEY("ActivityBannerWidget", 4, "活动Banner");
            ActivityBannerWidget = r104;
            KEY r105 = new KEY("VSShortTermIndicatorWidget", 5, "短触区");
            VSShortTermIndicatorWidget = r105;
            KEY r106 = new KEY("TopRightWidget", 6, "心愿单");
            TopRightWidget = r106;
            KEY r107 = new KEY("LandscapeTopToolBar", 7, "横屏顶部ToolBar");
            LandscapeTopToolBar = r107;
            KEY r108 = new KEY("VSLandscapeStatusBar", 8, "横屏顶部自定义状态栏");
            VSLandscapeStatusBar = r108;
            KEY r109 = new KEY("TopLineToolBar", 9, "流区域顶部ToolBar");
            TopLineToolBar = r109;
            KEY r110 = new KEY("VSPortraitTopToolBar", 10, "VS横流竖屏顶部ToolBar");
            VSPortraitTopToolBar = r110;
            KEY r111 = new KEY("BrightnessView", 11, "手势亮度");
            BrightnessView = r111;
            KEY r112 = new KEY("VolumeView", 12, "手势音量");
            VolumeView = r112;
            KEY r113 = new KEY("PlayerShadowTop", 13, "播放器顶部阴影");
            PlayerShadowTop = r113;
            KEY r114 = new KEY("PlayerShadow", 14, "播放器阴影");
            PlayerShadow = r114;
            KEY r115 = new KEY("MatchRoomBack", 15, "赛事直播间横屏返回");
            MatchRoomBack = r115;
            KEY r116 = new KEY("LandscapeRoomTitle", 16, "直播间横屏标题栏");
            LandscapeRoomTitle = r116;
            KEY r117 = new KEY("LandscapeAnchorInfo", 17, "直播间横屏主播信息");
            LandscapeAnchorInfo = r117;
            KEY r118 = new KEY("MatchRoomCount", 18, "赛事直播间横屏在线人数");
            MatchRoomCount = r118;
            KEY r119 = new KEY("PortraitRowOne", 19, "竖屏第一行");
            PortraitRowOne = r119;
            KEY r120 = new KEY("PortraitRowTow", 20, "竖屏第二行");
            PortraitRowTow = r120;
            KEY r121 = new KEY("WatchCount", 21, "观看人数");
            WatchCount = r121;
            KEY r122 = new KEY("FirstShowHint", 22, "首播非实时内容提示");
            FirstShowHint = r122;
            KEY r123 = new KEY("FirstShowHintAlpha", 23, "首播非实时内容提示 竖版");
            FirstShowHintAlpha = r123;
            KEY r124 = new KEY("VideoPlayControl", 24, "录播播放控制");
            VideoPlayControl = r124;
            KEY r125 = new KEY("LivePlayControl", 25, "首播播放控制");
            LivePlayControl = r125;
            KEY r126 = new KEY("PlayTip", 26, "播放提示");
            PlayTip = r126;
            KEY r127 = new KEY("ProgressBar", 27, "进度条");
            ProgressBar = r127;
            KEY r128 = new KEY("LandscapeBottomToolBar", 28, "横屏底部ToolBar");
            LandscapeBottomToolBar = r128;
            KEY r129 = new KEY("LandscapeBottomLeftToolBar", 29, "横屏底部左侧Toolbar");
            LandscapeBottomLeftToolBar = r129;
            KEY r130 = new KEY("PortraitVideoDanmakuSend", 30, "竖屏录播弹幕发送");
            PortraitVideoDanmakuSend = r130;
            KEY r131 = new KEY("LandscapeDanmakuSend", 31, "横屏弹幕发送");
            LandscapeDanmakuSend = r131;
            KEY r132 = new KEY("PlayerShadowBottom", 32, "播放器底部阴影");
            PlayerShadowBottom = r132;
            KEY r133 = new KEY("VerticalPlayerShadow", 33, "竖屏流播放器阴影");
            VerticalPlayerShadow = r133;
            KEY r134 = new KEY("PortraitBottomToolBar", 34, "竖屏底部ToolBar");
            PortraitBottomToolBar = r134;
            KEY r135 = new KEY("PortraitBottomFollow", 35, "竖屏底部关注");
            PortraitBottomFollow = r135;
            KEY r136 = new KEY("PortraitBottomComment", 36, "竖屏底部评论框");
            PortraitBottomComment = r136;
            KEY r137 = new KEY("PortraitTopClose", 37, "竖屏顶部关闭");
            PortraitTopClose = r137;
            KEY r138 = new KEY("PortraitCamera", 38, "竖屏多机位");
            PortraitCamera = r138;
            KEY r139 = new KEY("VerticalVersion", 39, "竖屏视频多机位");
            VerticalVersion = r139;
            KEY r140 = new KEY("PortraitTopContent", 40, "竖屏顶部信息区");
            PortraitTopContent = r140;
            KEY r141 = new KEY("VerticalShowPlayInfo", 41, "综艺观看信息");
            VerticalShowPlayInfo = r141;
            KEY r142 = new KEY("VerticalTopFollow", 42, "竖屏顶部关注按钮");
            VerticalTopFollow = r142;
            KEY r143 = new KEY("VerticalSelectionEntry", 43, "选集入口");
            VerticalSelectionEntry = r143;
            KEY r144 = new KEY("VerticalDanmakuInput", 44, "竖屏输入框");
            VerticalDanmakuInput = r144;
            KEY r145 = new KEY("PortraitTopAnchor", 45, "竖屏顶部主播信息");
            PortraitTopAnchor = r145;
            KEY r146 = new KEY("PortraitLock", 46, "竖屏时的锁屏");
            PortraitLock = r146;
            KEY r147 = new KEY("TextMessage", 47, "公屏区");
            TextMessage = r147;
            KEY r148 = new KEY("ChatChannel", 48, "边看边聊");
            ChatChannel = r148;
            KEY r149 = new KEY("RightBottomBanner", 49, "右下角banner");
            RightBottomBanner = r149;
            KEY r150 = new KEY("KtvCard", 50, "ktv卡片");
            KtvCard = r150;
            KEY r151 = new KEY("RightCard", 51, "电商卡片");
            RightCard = r151;
            KEY r152 = new KEY("GiftTray", 52, "礼物托盘");
            GiftTray = r152;
            KEY r153 = new KEY("MoreLiveEntry", 53, "锁链多机位入口");
            MoreLiveEntry = r153;
            KEY r154 = new KEY("Digg", 54, "点赞");
            Digg = r154;
            KEY r155 = new KEY("DiggSelf", 55, "自己点赞");
            DiggSelf = r155;
            KEY r156 = new KEY("ECProduct", 56, "电商商品卡");
            ECProduct = r156;
            KEY r157 = new KEY("PaidLiveTempWatch", 57, "付费直播试看组件");
            PaidLiveTempWatch = r157;
            KEY r158 = new KEY("PaidTempCardContainer", 58, "付费直播试看组件-新");
            PaidTempCardContainer = r158;
            KEY r159 = new KEY("LandscapeDrawer", 59, "横屏抽屉");
            LandscapeDrawer = r159;
            KEY r160 = new KEY("LandscapeResetPlayerView", 60, "横屏重置播放器画面按钮");
            LandscapeResetPlayerView = r160;
            KEY r161 = new KEY("LandscapeBlockComment", 61, "媒体节目融合直播间屏蔽按钮");
            LandscapeBlockComment = r161;
            KEY r162 = new KEY("InteractiveWidget", 62, "互动组件");
            InteractiveWidget = r162;
            KEY r163 = new KEY("LandscapeInteractiveWidget", 63, "横屏互动组件");
            LandscapeInteractiveWidget = r163;
            KEY r164 = new KEY("BottomRightBanner", 64, "右下角banner");
            BottomRightBanner = r164;
            KEY r165 = new KEY("CastScreenLoading", 65, "投屏loading");
            CastScreenLoading = r165;
            KEY r166 = new KEY("PlayerViewLock", 66, "播放器锁屏");
            PlayerViewLock = r166;
            KEY r167 = new KEY("LiveOrientationControl", 67, "直播横竖屏控制");
            LiveOrientationControl = r167;
            KEY r168 = new KEY("VideoOrientationControl", 68, "录播横竖屏控制");
            VideoOrientationControl = r168;
            KEY r169 = new KEY("XTab_Test", 69, "横屏Xtab测试入口");
            XTab_Test = r169;
            KEY r170 = new KEY("LandscapeWatchCountInfo", 70, "回放横屏观看人次");
            LandscapeWatchCountInfo = r170;
            KEY r171 = new KEY("QuickShotRecordControl", 71, "赛事直播录屏");
            QuickShotRecordControl = r171;
            KEY r172 = new KEY("QuickShotShotControl", 72, "赛事直播截屏");
            QuickShotShotControl = r172;
            KEY r173 = new KEY("LandscapeRefresh", 73, "横屏刷新组件");
            LandscapeRefresh = r173;
            KEY r174 = new KEY("LandscapePhoneInfo", 74, "横屏顶部设备信息栏");
            LandscapePhoneInfo = r174;
            f118391a = new KEY[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174};
        }

        public final String getDescribe() {
            return this.describe;
        }

        public KEY(String r100, int r101, String r102) {
            super(r100, r101);
            this.describe = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Style;", "", "HIDE", "ATTACH", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style ATTACH = null;
        public static final Style HIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f118392a = null;

        static {
            Style r100 = new Style("HIDE", 0);
            HIDE = r100;
            Style r101 = new Style("ATTACH", 1);
            ATTACH = r101;
            f118392a = new Style[]{r100, r101};
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f118392a.clone();
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Type;", "", "TOP", "BOTTOM", "LEFT", "RIGHT", UserProfileEvent.POSITION_NONE, "ALPHA", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALPHA = null;
        public static final Type BOTTOM = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f118393a = null;

        static {
            Type r100 = new Type("TOP", 0);
            TOP = r100;
            Type r101 = new Type("BOTTOM", 1);
            BOTTOM = r101;
            Type r102 = new Type("LEFT", 2);
            LEFT = r102;
            Type r103 = new Type("RIGHT", 3);
            RIGHT = r103;
            Type r104 = new Type(UserProfileEvent.POSITION_NONE, 4);
            NONE = r104;
            Type r105 = new Type("ALPHA", 5);
            ALPHA = r105;
            f118393a = new Type[]{r100, r101, r102, r103, r104, r105};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f118393a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    float attachMarginDp() default 0.0f;

    boolean ignoreLock() default false;

    KEY key();

    boolean needDynamicControl() default false;

    boolean reverse() default false;

    Style style() default Style.HIDE;

    Type type();
}
