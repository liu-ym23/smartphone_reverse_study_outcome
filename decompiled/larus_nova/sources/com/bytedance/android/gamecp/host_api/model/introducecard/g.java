package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AnchorIntroduceItem")
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bD\u0010ER\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0016\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0004R\u0016\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001cR\u0018\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001cR\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u0010\u0004R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010\u0004R\u0016\u00102\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u0010\u0004R\u0018\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010\u0004R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010!¨\u0006F"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;", "", "", "gameImage", "Ljava/lang/String;", "gameName", "gameDownloadUrl", "gameTraceInfo", "", "gameTags", "Ljava/util/List;", "iosSalePoint", "androidSalePoint", "gameBackgroundColor", "", "introduceTimeLimit", "I", "", "introduceStartTime", "J", "introduceStopType", "gameId", "version", "developer", "permissionUrl", "privacyUrl", "downloadExtra", "downloadCount", "Ljava/lang/Long;", "_animateStartTime", "_animateDuration", "", "isShowAnimate", "Z", "antiHijackContent", "antiHijackImage", "hasPlatformGift", "hasGroupTask", "installUserCount", "toReceiveGiftCount", "Ljava/lang/Integer;", "Lcom/bytedance/android/gamecp/host_api/model/e;", "miniGameInfo", "Lcom/bytedance/android/gamecp/host_api/model/e;", "Lcom/bytedance/android/gamecp/host_api/model/g;", "miniPlayMeta", "Lcom/bytedance/android/gamecp/host_api/model/g;", "supportPlatform", "smallIcon", "productIntroduce", "playIntroduce", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "gameIcon", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "Lcom/bytedance/android/gamecp/host_api/model/a;", "cloudGameMeta", "Lcom/bytedance/android/gamecp/host_api/model/a;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/a;", "atmosphereContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/a;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/e;", "featureContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/e;", "promoteInstanceId", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/j;", "introduceCardTag", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/j;", "isInPreDownloadPeriod", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("animate_duration")
    protected long _animateDuration;

    @SerializedName("animate_start_time")
    protected long _animateStartTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57381a;

    @SerializedName("android_sale_point")
    public String androidSalePoint;

    @SerializedName("anti_hijack_content")
    public String antiHijackContent;

    @SerializedName("anti_hijack_image")
    public String antiHijackImage;

    @SerializedName("atmosphere_content")
    public a atmosphereContent;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JsonObject f57382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57383c;

    @SerializedName("cloud_game_meta")
    public com.bytedance.android.gamecp.host_api.model.a cloudGameMeta;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f57384d;

    @SerializedName("company_name")
    public String developer;

    @SerializedName("download_count")
    public Long downloadCount;

    @SerializedName("download_extra")
    public String downloadExtra;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f57385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IntroduceShowType f57386f;

    @SerializedName("featured_content")
    public e featureContent;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f57387g;

    @SerializedName("game_background_color")
    public String gameBackgroundColor;

    @SerializedName("game_download_url")
    public String gameDownloadUrl;

    @SerializedName("game_icon")
    public GameImageBundler gameIcon;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("game_image")
    public String gameImage;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("game_tag_names")
    public List<String> gameTags;

    @SerializedName("game_trace_info")
    public String gameTraceInfo;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f57388h;

    @SerializedName("has_group_task")
    public boolean hasGroupTask;

    @SerializedName("has_platform_gift")
    public boolean hasPlatformGift;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v f57389i;

    @SerializedName("install_user_count")
    public Long installUserCount;

    @SerializedName("tag")
    public j introduceCardTag;

    @SerializedName("introduce_start_time")
    public long introduceStartTime;

    @SerializedName("introduce_stop_type")
    public int introduceStopType;

    @SerializedName("introduce_time_limit")
    public int introduceTimeLimit;

    @SerializedName("ios_sale_point")
    public String iosSalePoint;

    @SerializedName("is_in_pre_download_period")
    public boolean isInPreDownloadPeriod;

    @SerializedName("is_show_animate")
    public boolean isShowAnimate;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f57390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f57391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f57392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s f57393m;

    @SerializedName("mini_game_meta")
    public com.bytedance.android.gamecp.host_api.model.e miniGameInfo;

    @SerializedName("mini_play_meta")
    public com.bytedance.android.gamecp.host_api.model.g miniPlayMeta;

    @SerializedName("android_authorization_url")
    public String permissionUrl;

    @SerializedName("play_introduce")
    public String playIntroduce;

    @SerializedName("android_privacy_url")
    public String privacyUrl;

    @SerializedName("game_introduction_url")
    public String productIntroduce;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
    public String promoteInstanceId;

    @SerializedName("small_icon")
    public String smallIcon;

    @SerializedName("support_platforms")
    public Long supportPlatform;

    @SerializedName("to_receive_gift_count")
    public Integer toReceiveGiftCount;

    @SerializedName("android_version")
    public String version;

    public g() {
        this.f57381a = "";
        this.f57386f = IntroduceShowType.MANUAL;
        this.f57392l = "";
        this.introduceTimeLimit = -1;
        this.introduceStartTime = -1;
        this.introduceStopType = -1;
        this.downloadCount = 0L;
        this._animateStartTime = 3;
        this._animateDuration = 5;
        this.installUserCount = 0L;
        this.toReceiveGiftCount = 0;
        this.supportPlatform = 0L;
        this.productIntroduce = "";
        this.playIntroduce = "";
        this.introduceCardTag = new j(0);
    }

    public g(am3.g r100) {
        this.gameTags = new ArrayList();
        this.f57381a = "";
        this.f57386f = IntroduceShowType.MANUAL;
        this.f57392l = "";
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L47;
        switch(r103) {
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L43;
            case 6: goto L42;
            case 7: goto L41;
            case 8: goto L40;
            case 9: goto L39;
            case 10: goto L38;
            case 11: goto L6;
            case 12: goto L37;
            case 13: goto L6;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L33;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L32;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L31;
            case 24: goto L30;
            case 25: goto L29;
            case 26: goto L28;
            case 27: goto L27;
            case 28: goto L26;
            case 29: goto L25;
            case 30: goto L6;
            case 31: goto L24;
            case 32: goto L6;
            case 33: goto L23;
            case 34: goto L6;
            case 35: goto L22;
            case 36: goto L21;
            case 37: goto L20;
            case 38: goto L19;
            case 39: goto L18;
            case 40: goto L17;
            case 41: goto L16;
            case 42: goto L15;
            case 43: goto L14;
            case 44: goto L13;
            case 45: goto L12;
            case 46: goto L11;
            case 47: goto L10;
            case 48: goto L6;
            case 49: goto L9;
            case 50: goto L8;
            case 51: goto L7;
            default: goto L6;
        };
    L7:
        this.isInPreDownloadPeriod = am3.h.a(r100);
        goto L3
    L8:
        this.introduceCardTag = new j(r100);
        goto L3
    L9:
        this.promoteInstanceId = am3.h.c(r100);
        goto L3
    L10:
        this.featureContent = new e(r100);
        goto L3
    L11:
        this.atmosphereContent = new a(r100);
        goto L3
    L12:
        this.cloudGameMeta = new com.bytedance.android.gamecp.host_api.model.a(r100);
        goto L3
    L13:
        this.gameIcon = new GameImageBundler(r100);
        goto L3
    L14:
        this.productIntroduce = am3.h.c(r100);
        goto L3
    L15:
        this.smallIcon = am3.h.c(r100);
        goto L3
    L16:
        this.playIntroduce = am3.h.c(r100);
        goto L3
    L17:
        this.miniPlayMeta = new com.bytedance.android.gamecp.host_api.model.g(r100);
        goto L3
    L18:
        this.supportPlatform = Long.valueOf(r100.j());
        goto L3
    L19:
        this.miniGameInfo = new com.bytedance.android.gamecp.host_api.model.e(r100);
        goto L3
    L20:
        this.androidSalePoint = am3.h.c(r100);
        goto L3
    L21:
        this.toReceiveGiftCount = Integer.valueOf(r100.i());
        goto L3
    L22:
        this.installUserCount = Long.valueOf(r100.j());
        goto L3
    L23:
        this.hasGroupTask = am3.h.a(r100);
        goto L3
    L24:
        this.hasPlatformGift = am3.h.a(r100);
        goto L3
    L25:
        this.iosSalePoint = am3.h.c(r100);
        goto L3
    L26:
        this.antiHijackImage = am3.h.c(r100);
        goto L3
    L27:
        this.antiHijackContent = am3.h.c(r100);
        goto L3
    L28:
        this._animateDuration = r100.j();
        r102 = r102 | 16;
        goto L3
    L29:
        this._animateStartTime = r100.j();
        r102 = r102 | 8;
        goto L3
    L30:
        this.isShowAnimate = am3.h.a(r100);
        goto L3
    L31:
        this.downloadCount = Long.valueOf(r100.j());
        goto L3
    L32:
        this.version = am3.h.c(r100);
        goto L3
    L33:
        this.permissionUrl = am3.h.c(r100);
        goto L3
    L34:
        this.privacyUrl = am3.h.c(r100);
        goto L3
    L35:
        this.downloadExtra = am3.h.c(r100);
        goto L3
    L36:
        this.developer = am3.h.c(r100);
        goto L3
    L37:
        this.gameId = am3.h.c(r100);
        goto L3
    L38:
        this.introduceStopType = r100.i();
        r102 = r102 | 4;
        goto L3
    L39:
        this.introduceStartTime = r100.j();
        r102 = r102 | 2;
        goto L3
    L40:
        this.introduceTimeLimit = r100.i();
        r102 = r102 | 1;
        goto L3
    L41:
        this.gameBackgroundColor = am3.h.c(r100);
        goto L3
    L42:
        this.gameTags.add(am3.h.c(r100));
        goto L3
    L43:
        this.gameTraceInfo = am3.h.c(r100);
        goto L3
    L44:
        this.gameDownloadUrl = am3.h.c(r100);
        goto L3
    L45:
        this.gameName = am3.h.c(r100);
        goto L3
    L46:
        this.gameImage = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L47:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L51;
        this.introduceTimeLimit = -1;
    L51:
        if ((r102 & 2) != 0) goto L54;
        this.introduceStartTime = -1;
    L54:
        if ((r102 & 4) != 0) goto L57;
        this.introduceStopType = -1;
    L57:
        if (this.downloadCount != null) goto L60;
        this.downloadCount = 0L;
    L60:
        if ((r102 & 8) != 0) goto L63;
        this._animateStartTime = 3;
    L63:
        if ((r102 & 16) != 0) goto L66;
        this._animateDuration = 5;
    L66:
        if (this.installUserCount != null) goto L69;
        this.installUserCount = 0L;
    L69:
        if (this.toReceiveGiftCount != null) goto L72;
        this.toReceiveGiftCount = 0;
    L72:
        if (this.supportPlatform != null) goto L75;
        this.supportPlatform = 0L;
    L75:
        if (this.productIntroduce != null) goto L78;
        this.productIntroduce = "";
    L78:
        if (this.playIntroduce != null) goto L81;
        this.playIntroduce = "";
    L81:
        if (this.introduceCardTag != null) goto L168;
        this.introduceCardTag = new j(0);
        return;
    }
}
