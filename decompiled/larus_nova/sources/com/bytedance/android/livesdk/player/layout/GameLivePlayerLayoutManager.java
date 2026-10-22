package com.bytedance.android.livesdk.player.layout;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.AdaptionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.IPullData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerServiceV2;
import com.bytedance.android.livesdkapi.gamestickerv2.ILandscapeLayoutCalculator;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameDisplayRatioConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.service.ILiveService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class GameLivePlayerLayoutManager implements com.bytedance.android.live.platformplayer.layout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.platformplayer.layout.c f155422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GameMode f155423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ILivePlayerScene f155424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f155425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f155426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f155427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f155428g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/layout/GameLivePlayerLayoutManager$GameMode;", "", "PORTRAIT_SCREEN", "PORTRAIT_COMPLETE", "HORIZONTAL_FLOW", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GameMode extends Enum<GameMode> {
        public static final GameMode HORIZONTAL_FLOW = null;
        public static final GameMode PORTRAIT_COMPLETE = null;
        public static final GameMode PORTRAIT_SCREEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GameMode[] f155429a = null;

        static {
            GameMode r100 = new GameMode("PORTRAIT_SCREEN", 0);
            PORTRAIT_SCREEN = r100;
            GameMode r101 = new GameMode("PORTRAIT_COMPLETE", 1);
            PORTRAIT_COMPLETE = r101;
            GameMode r102 = new GameMode("HORIZONTAL_FLOW", 2);
            HORIZONTAL_FLOW = r102;
            f155429a = new GameMode[]{r100, r101, r102};
        }

        public static GameMode valueOf(String r100) {
            return (GameMode) r27.a.a(GameMode.class, r100);
        }

        public static GameMode[] values() {
            return (GameMode[]) f155429a.clone();
        }

        public GameMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f155430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f155431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f155432c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f155430a == r101.f155430a) goto L8;
            return false;
        L8:
            if (this.f155431b == r101.f155431b) goto L10;
            return false;
        L10:
            if (Float.compare(this.f155432c, r101.f155432c) == 0) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            return (((this.f155430a * 31) + this.f155431b) * 31) + Float.floatToIntBits(this.f155432c);
        }

        public final String toString() {
            return "GameDisplayConfig(width=" + this.f155430a + ", height=" + this.f155431b + ", scaleR=" + this.f155432c + ")";
        }

        public a(int r100, int r101, float r102) {
            this.f155430a = r100;
            this.f155431b = r101;
            this.f155432c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f155433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f155434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f155435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f155436d;

        public b() {
            this(0, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f155433a == r101.f155433a) goto L8;
            return false;
        L8:
            if (this.f155434b == r101.f155434b) goto L10;
            return false;
        L10:
            if (this.f155435c == r101.f155435c) goto L12;
            return false;
        L12:
            if (this.f155436d == r101.f155436d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f155433a * 31) + this.f155434b) * 31) + this.f155435c) * 31) + this.f155436d;
        }

        public final String toString() {
            return "GamePlayerParams(width=" + this.f155433a + ", height=" + this.f155434b + ", top=" + this.f155435c + ", left=" + this.f155436d + ")";
        }

        public b(int r100, int r101) {
            if ((r101 & 4) == 0) goto L5;
            r100 = 0;
        L5:
            this.f155433a = 0;
            this.f155434b = 0;
            this.f155435c = r100;
            this.f155436d = 0;
        }
    }

    public final GameDisplayRatioConfig i() {
        return (GameDisplayRatioConfig) this.f155426e.getValue();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void reset() {
        this.f155422a = null;
        this.f155423b = null;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final String d() {
        return "GAME_MODE_" + this.f155423b;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void e() {
        IGameStickerContext r100 = j(this.f155424c);
        if (r100 == null) goto L6;
        r100.setUniversalOutputParam(null);
        r100.setSkinOutputParams(null);
        return;
    }

    public GameLivePlayerLayoutManager() {
        this.f155425d = LazyKt.lazy(GameLivePlayerLayoutManager$skipVs$2.INSTANCE);
        this.f155426e = LazyKt.lazy(GameLivePlayerLayoutManager$ratioConfig$2.INSTANCE);
        this.f155427f = LazyKt.lazy(GameLivePlayerLayoutManager$translationAndScaleOpt$2.INSTANCE);
        this.f155428g = LazyKt.lazy(GameLivePlayerLayoutManager$horizontalOpt$2.INSTANCE);
    }

    public static IGameStickerContext j(ILivePlayerScene r100) {
        if (r100 == null) goto L14;
        String r101 = r100.getScene();
        if (r101 == null) goto L14;
        if (StringsKt.contains$default(r101, "preview", false, 2, null) != true) goto L14;
        ILiveService r102 = TTLiveService.getLiveService();
        if (r102 == null) goto L11;
        IGameStickerServiceV2 r103 = r102.getGameStickerServiceV2();
    L12:
        if (r103 != null) goto L32;
        return null;
    L32:
        return r103.getDataContext(GameStickerScene.PREVIEW);
    L11:
        r103 = null;
    L14:
        if (r100 == null) goto L16;
        String r104 = r100.getScene();
    L18:
        if (StringsKt.equals$default(r104, "inner_draw", false, 2, null) == true) goto L24;
        if (r100 == null) goto L21;
        String r105 = r100.getScene();
    L23:
        if (StringsKt.equals$default(r105, "live_detail_room", false, 2, null) == true) goto L24;
        return null;
    L21:
        r105 = null;
    L24:
        ILiveService r106 = TTLiveService.getLiveService();
        if (r106 == null) goto L27;
        IGameStickerServiceV2 r107 = r106.getGameStickerServiceV2();
    L28:
        if (r107 != null) goto L30;
        return null;
    L30:
        return r107.getDataContext(GameStickerScene.ENTER);
    L27:
        r107 = null;
        goto L28
    L16:
        r104 = null;
        goto L18
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void b(com.bytedance.android.live.platformplayer.layout.c r100) {
        Intrinsics.checkNotNullParameter(r100, "playPosition");
        this.f155422a = r100;
    }

    public final int g(com.bytedance.android.live.platformplayer.layout.f r100) {
        Integer r101 = Integer.valueOf(r100.f85617h);
        if (r101.intValue() <= 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Integer r103 = null;
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L19;
        IBaseStreamUrl r104 = r100.f85624o;
        if (r104 == null) goto L20;
        IStreamUrlExtra r105 = r104.getExtra();
        if (r105 == null) goto L20;
        r103 = Integer.valueOf(r105.getHeight());
    L20:
        if (r103 == null) goto L23;
        return r103.intValue();
    L23:
        return r100.f85617h;
    L19:
        r103 = r101;
        goto L20
    L5:
        if (((Boolean) this.f155428g.getValue()).booleanValue() == false) goto L8;
        r102 = false;
        goto L9
    }

    public final int h(com.bytedance.android.live.platformplayer.layout.f r100) {
        Integer r101 = Integer.valueOf(r100.f85616g);
        if (r101.intValue() <= 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Integer r103 = null;
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L19;
        IBaseStreamUrl r104 = r100.f85624o;
        if (r104 == null) goto L20;
        IStreamUrlExtra r105 = r104.getExtra();
        if (r105 == null) goto L20;
        r103 = Integer.valueOf(r105.getWidth());
    L20:
        if (r103 == null) goto L23;
        return r103.intValue();
    L23:
        return r100.f85616g;
    L19:
        r103 = r101;
        goto L20
    L5:
        if (((Boolean) this.f155428g.getValue()).booleanValue() == false) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final boolean c(String r100, com.bytedance.android.live.platformplayer.layout.f r101) {
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        if (((Boolean) this.f155425d.getValue()).booleanValue() == false) goto L8;
        IRoom r102 = r101.f85621l;
        if (r102 == null) goto L8;
        if (r102.isMergeVSRoom() != true) goto L8;
        return false;
    L8:
        this.f155424c = r101.f85618i;
        if (h(r101) <= g(r101)) goto L11;
        boolean r103 = true;
    L12:
        float r104 = g(r101) / h(r101);
        if (r101.f85613d == true) goto L15;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L25;
        if (r103 == true) goto L25;
        boolean r106 = true;
    L27:
        if (r101.f85623n != LiveMode.THIRD_PARTY) goto L37;
        IBaseStreamUrl r107 = r101.f85624o;
        if (r107 == null) goto L37;
        IStreamUrlExtra r108 = r107.getExtra();
        if (r108 == null) goto L37;
        AdaptionInfo r109 = r108.getAdaptionInfo();
        if (r109 == null) goto L37;
        if (r109.getVerticalResizeMode() != 1) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == true) goto L40;
    L44:
        boolean r111 = false;
    L45:
        if (r106 == false) goto L47;
        GameMode r112 = GameMode.PORTRAIT_SCREEN;
    L52:
        this.f155423b = r112;
        if (r112 == null) goto L55;
        boolean r113 = true;
    L56:
        if (r113 == false) goto L60;
        return true;
    L60:
        return false;
    L55:
        r113 = false;
        goto L56
    L47:
        if (r111 == false) goto L49;
        r112 = GameMode.PORTRAIT_COMPLETE;
        goto L52
    L49:
        if (r103 == false) goto L51;
        r112 = GameMode.HORIZONTAL_FLOW;
        goto L52
    L51:
        r112 = null;
        goto L52
    L40:
        if (r104 < 1.77f) goto L44;
        if (r104 > 1.78f) goto L44;
        r111 = true;
    L37:
        r110 = false;
    L25:
        r106 = false;
        goto L27
    L15:
        if (r101.f85611b == true) goto L21;
        if (r101.f85610a == true) goto L21;
        if (r101.f85623n != LiveMode.SCREEN_RECORD) goto L21;
        r105 = true;
        goto L22
    L11:
        r103 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void a(String r210, com.bytedance.android.live.platformplayer.layout.f r211, String r310) {
        Intrinsics.checkNotNullParameter(r211, "layoutContext");
        Intrinsics.checkNotNullParameter(r310, "from");
        com.bytedance.android.live.platformplayer.layout.c r100 = this.f155422a;
        if (r100 == null) goto L225;
        int r101 = -1;
        r100.setWidth(-1);
        r100.setHeight(-1);
        r100.b(0);
        IGameStickerContext r102 = j(this.f155424c);
        if (r102 == null) goto L7;
        BottomContainerSize r103 = r102.getUniversalInputSize();
    L8:
        if (r103 != null) goto L12;
        IGameStickerContext r104 = j(this.f155424c);
        if (r104 == null) goto L12;
        r104.setUniversalOutputParam(null);
    L12:
        IRoom r105 = r211.f85621l;
        String r110 = "";
        if (r105 == null) goto L16;
        String r106 = r105.getIdStr();
        if (r106 == null) goto L16;
    L17:
        IGameStickerContext r107 = j(this.f155424c);
        if (r107 == null) goto L32;
        Map<String, Integer> r108 = r107.getSkinRequireHeight();
        if (r108 == null) goto L32;
        if (StringsKt.contains$default(r211.f85618i.getScene(), "preview", false, 2, null) != true) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L32;
        Integer r109 = r108.get(r106);
        if (r109 == null) goto L32;
        r101 = r109.intValue();
        goto L32
    L24:
        r111 = false;
    L32:
        if (r101 >= 0) goto L36;
        IGameStickerContext r112 = j(this.f155424c);
        if (r112 == null) goto L36;
        r112.setSkinOutputParams(new BottomContainerParams(0, 0, 0, 0, 0, 0, 0, 0, r106, 255, null));
    L36:
        GameMode r113 = this.f155423b;
        if (r113 == null) goto L220;
        int r114 = com.bytedance.android.livesdk.player.layout.b.f155514a[r113.ordinal()];
        if (r114 == 1) goto L216;
        if (r114 != 2) goto L43;
        Pair r115 = TuplesKt.to(Float.valueOf(g(r211) / h(r211)), Float.valueOf(r211.f85620k / r211.f85619j));
        float r116 = ((Number) r115.component1()).floatValue();
        float r117 = ((Number) r115.component2()).floatValue();
        if (r117 >= 1.5f) goto L212;
    L214:
        int r118 = 0;
    L215:
        r100.setScaleType(r118);
        r100.setGravity(17);
        goto L220
    L212:
        if (r117 > r116) goto L214;
        r118 = 2;
        goto L215
    L43:
        if (r114 != 3) goto L220;
        if (r211.f85612c == true) goto L48;
    L50:
        r100.setScaleType(0);
        if (r211.f85613d == true) goto L54;
    L150:
        a r119 = null;
    L151:
        if (r119 == null) goto L153;
        r100.setScaleType(1);
        r100.setWidth(r119.f155430a);
        r100.setHeight(r119.f155431b);
        int r120 = MathKt.roundToInt(h(r211) * r119.f155432c);
    L154:
        if (r103 == null) goto L171;
        ILiveService r121 = TTLiveService.getLiveService();
        if (r121 == null) goto L158;
        IGameStickerServiceV2 r122 = r121.getGameStickerServiceV2();
    L159:
        if (r122 == null) goto L171;
        ILandscapeLayoutCalculator r123 = r122.getLandscapeCalculator();
        if (r123 == null) goto L171;
        int r124 = 1;
        BottomContainerParams r125 = r123.calculate(r103, r211.f85619j, r211.f85620k, h(r211), r120);
        if (r125 == null) goto L172;
        IRoom r126 = r211.f85621l;
        if (r126 == null) goto L170;
        String r127 = r126.getIdStr();
        if (r127 == null) goto L170;
        r110 = r127;
    L170:
        r125.setRoomId(r110);
    L173:
        if (r125 == null) goto L175;
        int r128 = r125.getContainerH();
    L177:
        if (r211.f85613d == true) goto L179;
    L191:
        if (r128 <= 0) goto L197;
        r100.setHeight(r211.f85620k - r128);
        if (r125 == null) goto L195;
        int r129 = r125.getPlayerY();
    L196:
        r100.f(r129);
        r100.setGravity(r124);
    L198:
        TranslationAndScaleProperty r130 = r211.f85633x;
        if (r130 != null) goto L201;
    L203:
        TranslationAndScaleProperty r131 = null;
    L204:
        if (r131 == null) goto L206;
        r100.setScaleX(r131.getScaleX());
        r100.setScaleY(r131.getScaleY());
        r100.setTranslationX(r131.getTranslationX());
        r100.setTranslationY(r131.getTranslationY());
    L206:
        IGameStickerContext r132 = j(this.f155424c);
        if (r132 == null) goto L220;
        r132.setUniversalOutputParam(r125);
        goto L220
    L201:
        if (((Boolean) this.f155427f.getValue()).booleanValue() == false) goto L203;
        r131 = r130;
        goto L204
    L195:
        r129 = 0;
        goto L196
    L197:
        r100.f(0);
        r100.setGravity(17);
        goto L198
    L179:
        if (r211.f85626q <= 0) goto L191;
        b r133 = f(r211, r120, h(r211), r128, r101);
        int r134 = r133.f155435c;
        if (r128 <= 0) goto L186;
        if (r134 != 0) goto L184;
        r100.setHeight(r211.f85620k - r128);
        goto L186
    L184:
        if (r125 == null) goto L186;
        r125.setPlayerY(r134);
        r125.setContainerY(r125.getPlayerY() + r125.getPlayerH());
    L186:
        if (r101 < 0) goto L190;
        BottomContainerParams r135 = new BottomContainerParams(r133.f155436d, r133.f155435c, r133.f155433a, r133.f155434b, 0, 0, r211.f85619j, r211.f85620k, r106, 48, null);
        IGameStickerContext r136 = j(this.f155424c);
        if (r136 == null) goto L190;
        r136.setSkinOutputParams(r135);
    L190:
        r100.f(r134);
        r100.setGravity(r124);
        goto L206
    L175:
        r128 = 0;
    L172:
        r125 = null;
        goto L173
    L158:
        r122 = null;
    L171:
        r124 = 1;
        goto L172
    L153:
        r120 = g(r211);
        goto L154
    L54:
        if (r211.f85610a == true) goto L150;
        IBaseStreamUrl r137 = r211.f85624o;
        if (r137 == null) goto L150;
        ILiveCoreSDKData r138 = r137.getLiveCoreSDKData();
        if (r138 == null) goto L150;
        IPullData r139 = r138.getPullData();
        if (r139 == null) goto L150;
        ILiveCoreSDKData.IDisplay r140 = r139.getDisplay();
        if (r140 == null) goto L150;
        GameDisplayRatioConfig.SupportRatio r141 = new GameDisplayRatioConfig.SupportRatio(r140.getScaleWidth(), r140.getScaleHeight());
        if (i().getEnable() == false) goto L123;
        if (i().getSwitch() == false) goto L150;
        if (r211.f85612c == true) goto L150;
        if (r211.f85611b == true) goto L75;
    L77:
        List<Integer> r142 = i().getSupportRoomScene();
        if (r142 == null) goto L150;
        if (r211.f85623n != LiveMode.SCREEN_RECORD) goto L82;
        boolean r143 = true;
    L83:
        if (r143 == false) goto L88;
        if (r142.contains(Integer.valueOf(GameDisplayRatioConfig.DisplayRoomScene.SCENE_ROOM_SCREEN_RECORD.getValue())) == false) goto L150;
    L88:
        if (r211.f85623n != LiveMode.THIRD_PARTY) goto L90;
        boolean r144 = true;
    L91:
        if (r144 == true) goto L93;
    L95:
        List<Integer> r145 = i().getSupportPlayerScene();
        if (r145 == null) goto L150;
        if (r145.contains(Integer.valueOf(GameDisplayRatioConfig.DisplayPlayerScene.SCENE_PLAYER_NORMAL.getValue())) != true) goto L150;
        List<GameDisplayRatioConfig.SupportRatio> r146 = i().getSupportRatio();
        if (r146 == null) goto L140;
        List<GameDisplayRatioConfig.SupportRatio> r147 = r146;
        if ((r147 instanceof Collection) == true) goto L105;
    L107:
        Iterator<T> r148 = r147.iterator();
    L109:
        if (r148.hasNext() == false) goto L119;
        GameDisplayRatioConfig.SupportRatio r149 = (GameDisplayRatioConfig.SupportRatio) r148.next();
        if (r149.getRatioWidth() == r141.getRatioWidth()) goto L113;
    L115:
        boolean r150 = false;
    L116:
        if (r150 == false) goto L109;
        boolean r151 = false;
    L120:
        if (r151 != true) goto L140;
    L113:
        if (r149.getRatioHeight() != r141.getRatioHeight()) goto L115;
        r150 = true;
    L119:
        r151 = true;
        goto L120
    L105:
        if (r147.isEmpty() == false) goto L107;
    L140:
        if (r211.f85619j >= r211.f85620k) goto L150;
        float r152 = r141.getRatioHeight() / r141.getRatioWidth();
        float r153 = g(r211) / h(r211);
        if (Float.isNaN(r152) == true) goto L150;
        if (Float.isNaN(r153) == true) goto L150;
        if (r152 <= r153) goto L150;
        int r154 = MathKt.roundToInt(r211.f85619j * r152);
        r119 = new a(MathKt.roundToInt(r154 / r153), r154, r152);
        goto L151
    L93:
        if (r142.contains(Integer.valueOf(GameDisplayRatioConfig.DisplayRoomScene.SCENE_ROOM_THIRD.getValue())) == true) goto L95;
    L90:
        r144 = false;
        goto L91
    L82:
        r143 = false;
        goto L83
    L75:
        if (i().isFoldScreenEnable() == true) goto L77;
    L123:
        if (r211.f85611b == true) goto L150;
        LiveMode r155 = r211.f85623n;
        if (r155 != LiveMode.SCREEN_RECORD) goto L128;
        boolean r156 = true;
    L129:
        if (r156 == false) goto L131;
    L136:
        boolean r157 = false;
    L137:
        if (r157 == false) goto L140;
    L131:
        if (r155 != LiveMode.THIRD_PARTY) goto L133;
        boolean r158 = true;
    L134:
        if (r158 == true) goto L136;
        r157 = true;
        goto L137
    L133:
        r158 = false;
        goto L134
    L128:
        r156 = false;
        goto L129
    L48:
        if (Intrinsics.areEqual(r310, "onConfigurationChanged") == false) goto L50;
    L221:
        Unit r159 = Unit.INSTANCE;
        return;
    L216:
        Pair r160 = TuplesKt.to(Float.valueOf(g(r211) / h(r211)), Float.valueOf(r211.f85620k / r211.f85619j));
        if (((Number) r160.component1()).floatValue() <= ((Number) r160.component2()).floatValue()) goto L219;
        r100.setScaleType(2);
        r100.setGravity(17);
        goto L220
    L219:
        r100.setScaleType(0);
        r100.setGravity(17);
    L220:
        r100.requestLayout(r310);
    L16:
        r106 = "";
        goto L17
    L7:
        r103 = null;
        goto L8
    }

    public static b f(com.bytedance.android.live.platformplayer.layout.f r100, int r101, int r102, int r110, int r111) {
        if (r100.f85611b == true) goto L6;
        if (r111 >= 0) goto L6;
        return new b(r100.f85626q, 11);
    L6:
        int r103 = r100.f85620k - UtilityKotlinExtentionsKt.i(52);
        if (r111 <= 0) goto L9;
        int r104 = r111;
    L10:
        int r105 = r103 - r104;
        int r106 = r100.f85619j;
        float r107 = ((r106 * r101) / r102) + r110;
        b r108 = new b(0, 15);
        if (r107 <= r105) goto L15;
        float r109 = r100.f85620k;
        if (r107 >= r109) goto L15;
        r108.f155433a = r106;
        r108.f155434b = (int) r107;
        r108.f155436d = 0;
        r108.f155435c = (int) ((r109 - r107) / 2);
    L21:
        if (r111 <= 0) goto L26;
        if (r108.f155435c == r111) goto L26;
        return f(r100, r101, r102, r110, 0);
    L26:
        return r108;
    L15:
        int r112 = r100.f85620k;
        if (r107 < r112) goto L18;
        int r113 = r112 - r110;
        int r114 = (r113 * r102) / r101;
        r108.f155433a = r114;
        r108.f155434b = r113;
        r108.f155436d = (r106 - r114) / 2;
        r108.f155435c = 0;
        goto L21
    L18:
        if (r111 <= 0) goto L20;
        r108.f155433a = r106;
        r108.f155434b = (int) r107;
        r108.f155436d = 0;
        r108.f155435c = r111;
        goto L21
    L20:
        r108.f155433a = r106;
        r108.f155434b = (int) r107;
        r108.f155436d = 0;
        r108.f155435c = r100.f85626q;
        goto L21
    L9:
        r104 = r100.f85626q;
        goto L10
    }
}
