package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.GameCPShowMessage")
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\bO\u0010PR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0007R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0007R\u0016\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0007R\u0018\u0010'\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001bR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010\u0007R\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0007R\u0018\u0010.\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010\u001bR\u0016\u0010/\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010 R\u0018\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u0010\u001bR\u0018\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0007R\u0018\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u0010\u0007R\u0016\u00109\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u0010\u0007R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010\u001bR\u0018\u0010G\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bG\u0010\u0007R\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bK\u0010 R\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/l;", "", "", "type", "I", "", "gameImage", "Ljava/lang/String;", "gameName", "gameDownloadUrl", "gameTraceInfo", "", "gameTags", "Ljava/util/List;", "gameBackgroundColor", "introduceTimeLimit", "", "introduceStartTime", "J", "introduceStopType", "gameId", "version", "developer", "permissionUrl", "privacyUrl", "downloadExtra", "downloadCount", "Ljava/lang/Long;", "_animateStartTime", "_animateDuration", "", "isShowAnimate", "Z", "antiHijackContent", "antiHijackImage", "hasPlatformGift", "propIcon", "propName", "propId", "marketPrice", "sellingPrice", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/r;", "reserveItem", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/r;", "salePoint", "androidSalePoint", "propType", "isPropExpGame", "Lcom/bytedance/android/gamecp/host_api/model/f;", "miniGameMeta", "Lcom/bytedance/android/gamecp/host_api/model/f;", "Lcom/bytedance/android/gamecp/host_api/model/h;", "miniPlayMeta", "Lcom/bytedance/android/gamecp/host_api/model/h;", "supportPlatform", "smallIcon", "productIntroduce", "playIntroduce", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "gameIcon", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "Lcom/bytedance/android/gamecp/host_api/model/b;", "cloudGameMeta", "Lcom/bytedance/android/gamecp/host_api/model/b;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/b;", "atmosphereContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/b;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/f;", "featureContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/f;", "_propStockNum", "promoteInstanceId", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/i;", "introduceCardTag", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/i;", "isInPreDownloadPeriod", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/t;", "displayInfo", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/t;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("animate_duration")
    protected long _animateDuration;

    @SerializedName("animate_start_time")
    protected long _animateStartTime;

    @SerializedName("prop_stock_num")
    protected Long _propStockNum;

    @SerializedName("android_sale_point")
    public String androidSalePoint;

    @SerializedName("anti_hijack_content")
    public String antiHijackContent;

    @SerializedName("anti_hijack_image")
    public String antiHijackImage;

    @SerializedName("atmosphere_content")
    public b atmosphereContent;

    @SerializedName("cloud_game_meta")
    public com.bytedance.android.gamecp.host_api.model.b cloudGameMeta;

    @SerializedName("company_name")
    public String developer;

    @SerializedName("card_display_info")
    public t displayInfo;

    @SerializedName("download_count")
    public Long downloadCount;

    @SerializedName("download_extra")
    public String downloadExtra;

    @SerializedName("featured_content")
    public f featureContent;

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

    @SerializedName("has_platform_gift")
    public boolean hasPlatformGift;

    @SerializedName("tag")
    public i introduceCardTag;

    @SerializedName("introduce_start_time")
    public long introduceStartTime;

    @SerializedName("introduce_stop_type")
    public int introduceStopType;

    @SerializedName("introduce_time_limit")
    public int introduceTimeLimit;

    @SerializedName("is_in_pre_download_period")
    public boolean isInPreDownloadPeriod;

    @SerializedName("is_prop_exp_game")
    public boolean isPropExpGame;

    @SerializedName("is_show_animate")
    public boolean isShowAnimate;

    @SerializedName("market_price")
    public Long marketPrice;

    @SerializedName("mini_game_meta")
    public com.bytedance.android.gamecp.host_api.model.f miniGameMeta;

    @SerializedName("mini_play_meta")
    public com.bytedance.android.gamecp.host_api.model.h miniPlayMeta;

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

    @SerializedName("prop_icon")
    public String propIcon;

    @SerializedName("prop_id")
    public String propId;

    @SerializedName("prop_name")
    public String propName;

    @SerializedName("prop_type")
    public Long propType;

    @SerializedName("reserve_item")
    public r reserveItem;

    @SerializedName("ios_sale_point")
    public String salePoint;

    @SerializedName("selling_price")
    public Long sellingPrice;

    @SerializedName("small_icon")
    public String smallIcon;

    @SerializedName("support_platforms")
    public Long supportPlatform;

    @SerializedName("type")
    public int type;

    @SerializedName("android_version")
    public String version;

    public static final class a {
    }

    static {
    }

    public l() {
        this.introduceTimeLimit = -1;
        this.introduceStartTime = -1;
        this.introduceStopType = -1;
        this.downloadCount = 0L;
        this._animateStartTime = 3;
        this._animateDuration = 2;
        this.marketPrice = 0L;
        this.sellingPrice = 0L;
        this.salePoint = "";
        this.androidSalePoint = "";
        this.propType = 1L;
        this.supportPlatform = 0L;
        this.productIntroduce = "";
        this.playIntroduce = "";
    }

    public l(am3.g r100) {
        this.gameTags = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L74;
        if (r103 != 1) goto L8;
        this.type = r100.i();
        goto L3
    L8:
        if (r103 != 13) goto L10;
        this.gameId = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 22) goto L12;
        this.version = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 33) goto L14;
        this.hasPlatformGift = am3.h.a(r100);
        goto L3
    L14:
        if (r103 != 54) goto L16;
        this.isPropExpGame = am3.h.a(r100);
        goto L3
    L16:
        if (r103 != 51) goto L18;
        this.reserveItem = new r(r100);
        goto L3
    L18:
        if (r103 != 52) goto L19;
        this.propType = Long.valueOf(r100.j());
        goto L3
    L19:
        switch(r103) {
            case 3: goto L66;
            case 4: goto L65;
            case 5: goto L64;
            case 6: goto L63;
            case 7: goto L62;
            case 8: goto L61;
            case 9: goto L60;
            case 10: goto L59;
            case 11: goto L58;
            default: goto L20;
        };
    L58:
        this.introduceStopType = r100.i();
        r102 = r102 | 4;
        goto L3
    L59:
        this.introduceStartTime = r100.j();
        r102 = r102 | 2;
        goto L3
    L60:
        this.introduceTimeLimit = r100.i();
        r102 = r102 | 1;
        goto L3
    L61:
        this.gameBackgroundColor = am3.h.c(r100);
        goto L3
    L62:
        this.gameTags.add(am3.h.c(r100));
        goto L3
    L63:
        this.gameTraceInfo = am3.h.c(r100);
        goto L3
    L64:
        this.gameDownloadUrl = am3.h.c(r100);
        goto L3
    L65:
        this.gameName = am3.h.c(r100);
        goto L3
    L66:
        this.gameImage = am3.h.c(r100);
        goto L3
    L20:
        switch(r103) {
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            case 19: goto L54;
            default: goto L21;
        };
    L54:
        this.permissionUrl = am3.h.c(r100);
        goto L3
    L55:
        this.privacyUrl = am3.h.c(r100);
        goto L3
    L56:
        this.downloadExtra = am3.h.c(r100);
        goto L3
    L57:
        this.developer = am3.h.c(r100);
        goto L3
    L21:
        switch(r103) {
            case 25: goto L53;
            case 26: goto L52;
            case 27: goto L51;
            case 28: goto L50;
            case 29: goto L49;
            case 30: goto L48;
            case 31: goto L47;
            default: goto L22;
        };
    L47:
        this.salePoint = am3.h.c(r100);
        goto L3
    L48:
        this.antiHijackImage = am3.h.c(r100);
        goto L3
    L49:
        this.antiHijackContent = am3.h.c(r100);
        goto L3
    L50:
        this._animateDuration = r100.j();
        r102 = r102 | 16;
        goto L3
    L51:
        this._animateStartTime = r100.j();
        r102 = r102 | 8;
        goto L3
    L52:
        this.isShowAnimate = am3.h.a(r100);
        goto L3
    L53:
        this.downloadCount = Long.valueOf(r100.j());
        goto L3
    L22:
        switch(r103) {
            case 45: goto L46;
            case 46: goto L45;
            case 47: goto L44;
            case 48: goto L43;
            case 49: goto L42;
            default: goto L23;
        };
    L42:
        this.sellingPrice = Long.valueOf(r100.j());
        goto L3
    L43:
        this.marketPrice = Long.valueOf(r100.j());
        goto L3
    L44:
        this.propId = am3.h.c(r100);
        goto L3
    L45:
        this.propName = am3.h.c(r100);
        goto L3
    L46:
        this.propIcon = am3.h.c(r100);
        goto L3
    L23:
        switch(r103) {
            case 58: goto L41;
            case 59: goto L40;
            case 60: goto L39;
            case 61: goto L38;
            case 62: goto L37;
            case 63: goto L36;
            case 64: goto L35;
            case 65: goto L34;
            case 66: goto L33;
            case 67: goto L32;
            case 68: goto L31;
            default: goto L24;
        };
    L31:
        this.featureContent = new f(r100);
        goto L3
    L32:
        this.atmosphereContent = new b(r100);
        goto L3
    L33:
        this.cloudGameMeta = new com.bytedance.android.gamecp.host_api.model.b(r100);
        goto L3
    L34:
        this.gameIcon = new GameImageBundler(r100);
        goto L3
    L35:
        this.productIntroduce = am3.h.c(r100);
        goto L3
    L36:
        this.smallIcon = am3.h.c(r100);
        goto L3
    L37:
        this.playIntroduce = am3.h.c(r100);
        goto L3
    L38:
        this.miniPlayMeta = new com.bytedance.android.gamecp.host_api.model.h(r100);
        goto L3
    L39:
        this.supportPlatform = Long.valueOf(r100.j());
        goto L3
    L40:
        this.miniGameMeta = new com.bytedance.android.gamecp.host_api.model.f(r100);
        goto L3
    L41:
        this.androidSalePoint = am3.h.c(r100);
        goto L3
    L24:
        switch(r103) {
            case 70: goto L30;
            case 71: goto L29;
            case 72: goto L28;
            case 73: goto L27;
            case 74: goto L26;
            default: goto L25;
        };
    L26:
        this.isInPreDownloadPeriod = am3.h.a(r100);
        goto L3
    L27:
        this.displayInfo = new t(r100);
        goto L3
    L28:
        this.introduceCardTag = new i(r100);
        goto L3
    L29:
        this._propStockNum = Long.valueOf(r100.j());
        goto L3
    L30:
        this.promoteInstanceId = am3.h.c(r100);
        goto L3
    L25:
        am3.h.e(r100);
        goto L3
    L74:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L78;
        this.introduceTimeLimit = -1;
    L78:
        if ((r102 & 2) != 0) goto L81;
        this.introduceStartTime = -1;
    L81:
        if ((r102 & 4) != 0) goto L84;
        this.introduceStopType = -1;
    L84:
        if (this.downloadCount != null) goto L87;
        this.downloadCount = 0L;
    L87:
        if ((r102 & 8) != 0) goto L90;
        this._animateStartTime = 3;
    L90:
        if ((r102 & 16) != 0) goto L93;
        this._animateDuration = 2;
    L93:
        if (this.marketPrice != null) goto L96;
        this.marketPrice = 0L;
    L96:
        if (this.sellingPrice != null) goto L99;
        this.sellingPrice = 0L;
    L99:
        if (this.salePoint != null) goto L102;
        this.salePoint = "";
    L102:
        if (this.androidSalePoint != null) goto L105;
        this.androidSalePoint = "";
    L105:
        if (this.propType != null) goto L108;
        this.propType = 1L;
    L108:
        if (this.supportPlatform != null) goto L111;
        this.supportPlatform = 0L;
    L111:
        if (this.productIntroduce != null) goto L114;
        this.productIntroduce = "";
    L114:
        if (this.playIntroduce != null) goto L229;
        this.playIntroduce = "";
        return;
    }
}
