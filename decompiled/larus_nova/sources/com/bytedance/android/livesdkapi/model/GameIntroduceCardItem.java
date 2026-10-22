package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.livesdkapi.depend.IntroduceCardType;
import com.bytedance.android.livesdkapi.depend.IntroduceShowType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.AnchorIntroduceItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010Q\u001a\u00020\u0004J\u0006\u0010R\u001a\u00020\u0004J\u0006\u0010S\u001a\u00020\u0006J\u0006\u0010T\u001a\u00020\u000bJ\u0006\u0010U\u001a\u00020\u000bJ\u0006\u0010V\u001a\u00020\u000bJ\u0006\u0010W\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001c\u00108\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001aR\u0012\u0010:\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010P\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GameIntroduceCardItem;", "", "()V", "androidSalePoint", "", "animateDuration", "", "animateStartTime", "antiHijackContent", "antiHijackImage", "cardShowWhenEnter", "", "getCardShowWhenEnter", "()Z", "setCardShowWhenEnter", "(Z)V", "cardType", "Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "getCardType", "()Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "setCardType", "(Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;)V", "componentExtra", "getComponentExtra", "()Ljava/lang/String;", "setComponentExtra", "(Ljava/lang/String;)V", "developer", "downloadCount", "", "Ljava/lang/Long;", "downloadExtra", "downloadText", "Lcom/bytedance/android/livesdkapi/message/Text;", "gameBackgroundColor", "gameDownloadUrl", "gameId", "gameImage", "gameName", "gamePropIntroduceCardItem", "Lcom/bytedance/android/livesdkapi/model/GamePropIntroduceCardItem;", "getGamePropIntroduceCardItem", "()Lcom/bytedance/android/livesdkapi/model/GamePropIntroduceCardItem;", "setGamePropIntroduceCardItem", "(Lcom/bytedance/android/livesdkapi/model/GamePropIntroduceCardItem;)V", "gameTags", "", "gameTraceInfo", "hasGroupTask", "hasPlatformGift", "introduceStartTime", "introduceStopMessage", "introduceStopType", "introduceTimeLimit", "isAuto", "setAuto", "isAutoDownload", "setAutoDownload", "isShowAnimate", "permissionUrl", "privacyUrl", "productIntroduce", "reserveIntroduceCardItem", "Lcom/bytedance/android/livesdkapi/model/ReserveIntroduceCardItem;", "getReserveIntroduceCardItem", "()Lcom/bytedance/android/livesdkapi/model/ReserveIntroduceCardItem;", "setReserveIntroduceCardItem", "(Lcom/bytedance/android/livesdkapi/model/ReserveIntroduceCardItem;)V", "showType", "Lcom/bytedance/android/livesdkapi/depend/IntroduceShowType;", "getShowType", "()Lcom/bytedance/android/livesdkapi/depend/IntroduceShowType;", "setShowType", "(Lcom/bytedance/android/livesdkapi/depend/IntroduceShowType;)V", "userGiftStatus", "Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItem;", "getUserGiftStatus", "()Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItem;", "setUserGiftStatus", "(Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItem;)V", "version", "getGameId", "getGameName", "getReserveStatus", "isAutoCard", "isGameOrReserveCard", "isManualCard", "isTimerCard", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameIntroduceCardItem implements h {

    @SerializedName("android_sale_point")
    public String androidSalePoint;

    @SerializedName("animate_duration")
    public int animateDuration;

    @SerializedName("animate_start_time")
    public int animateStartTime;

    @SerializedName("anti_hijack_content")
    public String antiHijackContent;

    @SerializedName("anti_hijack_image")
    public String antiHijackImage;
    private boolean cardShowWhenEnter;
    private IntroduceCardType cardType;
    private String componentExtra;

    @SerializedName("company_name")
    public String developer;

    @SerializedName("download_count")
    public Long downloadCount;

    @SerializedName("download_extra")
    public String downloadExtra;

    @SerializedName("introduce_download_info")
    public Text downloadText;

    @SerializedName("game_background_color")
    public String gameBackgroundColor;

    @SerializedName("game_download_url")
    public String gameDownloadUrl;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("game_image")
    public String gameImage;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;
    private GamePropIntroduceCardItem gamePropIntroduceCardItem;

    @SerializedName("game_tag_names")
    public List<String> gameTags;

    @SerializedName("game_trace_info")
    public String gameTraceInfo;

    @SerializedName("has_group_task")
    public boolean hasGroupTask;

    @SerializedName("has_platform_gift")
    public boolean hasPlatformGift;

    @SerializedName("introduce_start_time")
    public long introduceStartTime;

    @SerializedName("introduce_stop_message")
    public Text introduceStopMessage;

    @SerializedName("introduce_stop_type")
    public int introduceStopType;

    @SerializedName("introduce_time_limit")
    public int introduceTimeLimit;
    private boolean isAuto;
    private String isAutoDownload;

    @SerializedName("is_show_animate")
    public boolean isShowAnimate;

    @SerializedName("android_authorization_url")
    public String permissionUrl;

    @SerializedName("android_privacy_url")
    public String privacyUrl;

    @SerializedName("game_introduction_url")
    public String productIntroduce;
    private ReserveIntroduceCardItem reserveIntroduceCardItem;
    private IntroduceShowType showType;
    private GameUserGiftStatusItem userGiftStatus;

    @SerializedName("android_version")
    public String version;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[IntroduceCardType.values().length];
            $EnumSwitchMapping$0 = r100;
            IntroduceCardType r101 = IntroduceCardType.GAME;
            r100[r101.ordinal()] = 1;
            IntroduceCardType r102 = IntroduceCardType.PROP;
            r100[r102.ordinal()] = 2;
            IntroduceCardType r103 = IntroduceCardType.RESERVE;
            r100[r103.ordinal()] = 3;
            int[] r104 = new int[IntroduceCardType.values().length];
            $EnumSwitchMapping$1 = r104;
            r104[r101.ordinal()] = 1;
            r104[r102.ordinal()] = 2;
            r104[r103.ordinal()] = 3;
        }
    }

    public final String getGameId() {
        IntroduceCardType r100 = this.cardType;
        int r101 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r101 != 1) goto L5;
        String r102 = this.gameId;
        if (r102 != null) goto L25;
        return "";
    L25:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        GamePropIntroduceCardItem r103 = this.gamePropIntroduceCardItem;
        if (r103 == null) goto L27;
        r102 = r103.gameId;
        if (r102 != null) goto L25;
        return "";
    L27:
        return "";
    L7:
        if (r101 == 3) goto L11;
        r102 = this.gameId;
        if (r102 != null) goto L25;
        return "";
    L11:
        ReserveIntroduceCardItem r104 = this.reserveIntroduceCardItem;
        if (r104 == null) goto L26;
        r102 = r104.getGameId();
        if (r102 != null) goto L25;
        return "";
    L26:
        return "";
    }

    public final String getGameName() {
        IntroduceCardType r100 = this.cardType;
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 != 1) goto L5;
        String r102 = this.gameName;
        if (r102 != null) goto L25;
        return "";
    L25:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        GamePropIntroduceCardItem r103 = this.gamePropIntroduceCardItem;
        if (r103 == null) goto L27;
        r102 = r103.gameName;
        if (r102 != null) goto L25;
        return "";
    L27:
        return "";
    L7:
        if (r101 == 3) goto L11;
        r102 = this.gameName;
        if (r102 != null) goto L25;
        return "";
    L11:
        ReserveIntroduceCardItem r104 = this.reserveIntroduceCardItem;
        if (r104 == null) goto L26;
        r102 = r104.getGameName();
        if (r102 != null) goto L25;
        return "";
    L26:
        return "";
    }

    public final int getReserveStatus() {
        ReserveIntroduceCardItem r100 = this.reserveIntroduceCardItem;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getReserveStatus();
    }

    public final boolean isAutoCard() {
        if (this.showType != IntroduceShowType.AUTO) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isGameOrReserveCard() {
        IntroduceCardType r100 = this.cardType;
        if (r100 != IntroduceCardType.GAME) goto L5;
    L8:
        return true;
    L5:
        if (r100 == IntroduceCardType.RESERVE) goto L8;
        return false;
    }

    public final boolean isManualCard() {
        if (this.showType != IntroduceShowType.MANUAL) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isTimerCard() {
        if (this.showType != IntroduceShowType.TIMER) goto L5;
        return true;
    L5:
        return false;
    }

    public GameIntroduceCardItem() {
        this.cardType = IntroduceCardType.GAME;
        this.showType = IntroduceShowType.MANUAL;
        this.introduceTimeLimit = -1;
        this.introduceStartTime = -1;
        this.introduceStopType = -1;
        this.downloadCount = 0L;
        this.animateStartTime = 3;
        this.animateDuration = 5;
        this.productIntroduce = "";
    }

    public final boolean getCardShowWhenEnter() {
        return this.cardShowWhenEnter;
    }

    public final IntroduceCardType getCardType() {
        return this.cardType;
    }

    public final String getComponentExtra() {
        return this.componentExtra;
    }

    public final GamePropIntroduceCardItem getGamePropIntroduceCardItem() {
        return this.gamePropIntroduceCardItem;
    }

    public final ReserveIntroduceCardItem getReserveIntroduceCardItem() {
        return this.reserveIntroduceCardItem;
    }

    public final IntroduceShowType getShowType() {
        return this.showType;
    }

    public final GameUserGiftStatusItem getUserGiftStatus() {
        return this.userGiftStatus;
    }

    public final boolean isAuto() {
        return this.isAuto;
    }

    public final String isAutoDownload() {
        return this.isAutoDownload;
    }

    public GameIntroduceCardItem(g r100) {
        this.gameTags = new ArrayList();
        this.cardType = IntroduceCardType.GAME;
        this.showType = IntroduceShowType.MANUAL;
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L46;
        if (r103 != 20) goto L8;
        this.version = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 31) goto L10;
        this.hasPlatformGift = am3.h.a(r100);
        goto L3
    L10:
        if (r103 != 33) goto L12;
        this.hasGroupTask = am3.h.a(r100);
        goto L3
    L12:
        if (r103 != 37) goto L14;
        this.androidSalePoint = am3.h.c(r100);
        goto L3
    L14:
        if (r103 != 43) goto L15;
        this.productIntroduce = am3.h.c(r100);
        goto L3
    L15:
        switch(r103) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L30;
            case 12: goto L29;
            default: goto L16;
        };
    L29:
        this.gameId = am3.h.c(r100);
        goto L3
    L30:
        this.introduceStopMessage = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L31:
        this.introduceStopType = r100.i();
        r102 = r102 | 4;
        goto L3
    L32:
        this.introduceStartTime = r100.j();
        r102 = r102 | 2;
        goto L3
    L33:
        this.introduceTimeLimit = r100.i();
        r102 = r102 | 1;
        goto L3
    L34:
        this.gameBackgroundColor = am3.h.c(r100);
        goto L3
    L35:
        this.gameTags.add(am3.h.c(r100));
        goto L3
    L36:
        this.gameTraceInfo = am3.h.c(r100);
        goto L3
    L37:
        this.gameDownloadUrl = am3.h.c(r100);
        goto L3
    L38:
        this.gameName = am3.h.c(r100);
        goto L3
    L39:
        this.gameImage = am3.h.c(r100);
        goto L3
    L40:
        this.downloadText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L16:
        switch(r103) {
            case 14: goto L28;
            case 15: goto L27;
            case 16: goto L26;
            case 17: goto L25;
            default: goto L17;
        };
    L25:
        this.permissionUrl = am3.h.c(r100);
        goto L3
    L26:
        this.privacyUrl = am3.h.c(r100);
        goto L3
    L27:
        this.downloadExtra = am3.h.c(r100);
        goto L3
    L28:
        this.developer = am3.h.c(r100);
        goto L3
    L17:
        switch(r103) {
            case 23: goto L24;
            case 24: goto L23;
            case 25: goto L22;
            case 26: goto L21;
            case 27: goto L20;
            case 28: goto L19;
            default: goto L18;
        };
    L19:
        this.antiHijackImage = am3.h.c(r100);
        goto L3
    L20:
        this.antiHijackContent = am3.h.c(r100);
        goto L3
    L21:
        this.animateDuration = (int) r100.j();
        r102 = r102 | 16;
        goto L3
    L22:
        this.animateStartTime = (int) r100.j();
        r102 = r102 | 8;
        goto L3
    L23:
        this.isShowAnimate = am3.h.a(r100);
        goto L3
    L24:
        this.downloadCount = Long.valueOf(r100.j());
        goto L3
    L18:
        am3.h.e(r100);
        goto L3
    L46:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L50;
        this.introduceTimeLimit = -1;
    L50:
        if ((r102 & 2) != 0) goto L53;
        this.introduceStartTime = -1;
    L53:
        if ((r102 & 4) != 0) goto L56;
        this.introduceStopType = -1;
    L56:
        if (this.downloadCount != null) goto L59;
        this.downloadCount = 0L;
    L59:
        if ((r102 & 8) != 0) goto L62;
        this.animateStartTime = 3;
    L62:
        if ((r102 & 16) != 0) goto L65;
        this.animateDuration = 5;
    L65:
        if (this.productIntroduce != null) goto L133;
        this.productIntroduce = "";
        return;
    }

    public final void setAuto(boolean r100) {
        this.isAuto = r100;
    }

    public final void setAutoDownload(String r100) {
        this.isAutoDownload = r100;
    }

    public final void setCardShowWhenEnter(boolean r100) {
        this.cardShowWhenEnter = r100;
    }

    public final void setCardType(IntroduceCardType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardType = r100;
    }

    public final void setComponentExtra(String r100) {
        this.componentExtra = r100;
    }

    public final void setGamePropIntroduceCardItem(GamePropIntroduceCardItem r100) {
        this.gamePropIntroduceCardItem = r100;
    }

    public final void setReserveIntroduceCardItem(ReserveIntroduceCardItem r100) {
        this.reserveIntroduceCardItem = r100;
    }

    public final void setShowType(IntroduceShowType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showType = r100;
    }

    public final void setUserGiftStatus(GameUserGiftStatusItem r100) {
        this.userGiftStatus = r100;
    }
}
