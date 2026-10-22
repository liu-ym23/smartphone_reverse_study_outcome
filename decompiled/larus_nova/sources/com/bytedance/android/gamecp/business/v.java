package com.bytedance.android.gamecp.business;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameCPInfo")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b6\u00107R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0012R\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0016\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\fR\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00100\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u0010$R\u0018\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u0018\u00105\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u0010*¨\u00069"}, d2 = {"Lcom/bytedance/android/gamecp/business/v;", "", "", "id", "Ljava/lang/String;", "name", "status", "iconUrl", "company", "publisher", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "Lcom/bytedance/android/gamecp/business/k0;", "tagProperty", "downloadUrl", "", "images", "Ljava/util/Map;", "introduce", "pkgSize", "versionName", RuleConditionBean.VERSION_CODE_KEY, "privacyUrl", "permissionUrl", UserInfo.UPDATE_TIME, "bgColor", "packageName", "downloadExtra", "antiHijackContent", "antiHijackImage", "Lcom/bytedance/android/gamecp/business/w;", "imgProperty", "onlineTime", "", "gameStageType", "I", "", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/u;", "videoList", "", "gameUnionType", "Ljava/lang/Long;", "playingCount", "", "isPropExpGame", "Z", "appCloudId", "gamePlatformType", "Lcom/bytedance/android/gamecp/host_api/model/e;", "miniGameMeta", "Lcom/bytedance/android/gamecp/host_api/model/e;", "isDownloadSupport", "supportPlatform", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v implements vh7.h {

    @SerializedName("anti_hijack_content")
    public String antiHijackContent;

    @SerializedName("anti_hijack_image")
    public String antiHijackImage;

    @SerializedName("app_cloud_id")
    public Long appCloudId;

    @SerializedName("background_color")
    public String bgColor;

    @SerializedName("company")
    public String company;

    @SerializedName("download_extra")
    public String downloadExtra;

    @SerializedName("android_short_url")
    public String downloadUrl;

    @SerializedName(IPerformanceManager.MODULE_LIVE_GAME_PLATFORM)
    public int gamePlatformType;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE)
    public int gameStageType;

    @SerializedName("game_union_type")
    public Long gameUnionType;

    @SerializedName("icon")
    public String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public String f56433id;

    @SerializedName("images")
    public Map<String, String> images;

    @SerializedName("image_property")
    public Map<String, w> imgProperty;

    @SerializedName("introduce")
    public String introduce;

    @SerializedName("is_download_support")
    public boolean isDownloadSupport;

    @SerializedName("is_prop_exp_game")
    public boolean isPropExpGame;

    @SerializedName("mini_game_meta")
    public com.bytedance.android.gamecp.host_api.model.e miniGameMeta;

    @SerializedName("name")
    public String name;

    @SerializedName("online_time")
    public String onlineTime;

    @SerializedName("android_package_name")
    public String packageName;

    @SerializedName("authorization_url")
    public String permissionUrl;

    @SerializedName("android_package_size")
    public String pkgSize;

    @SerializedName("user_playing_count")
    public Long playingCount;

    @SerializedName("android_privacy_url")
    public String privacyUrl;

    @SerializedName("publisher")
    public String publisher;

    @SerializedName("status")
    public String status;

    @SerializedName("support_platforms")
    public Long supportPlatform;

    @SerializedName("tag_property")
    public List<k0> tagProperty;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<String> tags;

    @SerializedName("package_update_time")
    public String updateTime;

    @SerializedName("version_code")
    public String versionCode;

    @SerializedName("android_version")
    public String versionName;

    @SerializedName("videos")
    public List<com.bytedance.android.gamecp.business.gamedetail.base.model.u> videoList;

    public static final class a {
    }

    static {
    }

    public v() {
        this.f56433id = "";
        this.name = "";
        this.status = "";
        this.iconUrl = "";
        this.company = "";
        this.publisher = "";
        this.downloadUrl = "";
        this.introduce = "";
        this.pkgSize = "";
        this.versionName = "";
        this.versionCode = "";
        this.privacyUrl = "";
        this.permissionUrl = "";
        this.updateTime = "";
        this.bgColor = "";
        this.packageName = "";
        this.downloadExtra = "";
        this.gameUnionType = 0L;
        this.playingCount = 0L;
        this.appCloudId = 0L;
        this.supportPlatform = 0L;
    }

    public v(am3.g r110) {
        this.tags = new ArrayList();
        this.tagProperty = new ArrayList();
        this.images = new HashMap();
        this.imgProperty = new HashMap();
        this.videoList = new ArrayList();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L73;
        String r102 = null;
        switch(r101) {
            case 1: goto L72;
            case 2: goto L71;
            case 3: goto L70;
            case 4: goto L69;
            case 5: goto L7;
            case 6: goto L68;
            case 7: goto L66;
            case 8: goto L65;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L49;
            case 12: goto L48;
            case 13: goto L7;
            case 14: goto L47;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L46;
            case 18: goto L7;
            case 19: goto L45;
            case 20: goto L44;
            case 21: goto L43;
            case 22: goto L7;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L7;
            case 27: goto L7;
            case 28: goto L7;
            case 29: goto L39;
            case 30: goto L7;
            case 31: goto L7;
            case 32: goto L38;
            case 33: goto L7;
            case 34: goto L37;
            case 35: goto L36;
            case 36: goto L7;
            case 37: goto L20;
            case 38: goto L7;
            case 39: goto L19;
            case 40: goto L7;
            case 41: goto L7;
            case 42: goto L18;
            case 43: goto L7;
            case 44: goto L7;
            case 45: goto L17;
            case 46: goto L16;
            case 47: goto L15;
            case 48: goto L14;
            case 49: goto L7;
            case 50: goto L13;
            case 51: goto L7;
            case 52: goto L12;
            case 53: goto L11;
            case 54: goto L7;
            case 55: goto L7;
            case 56: goto L7;
            case 57: goto L7;
            case 58: goto L7;
            case 59: goto L10;
            case 60: goto L9;
            case 61: goto L8;
            default: goto L7;
        };
    L8:
        this.supportPlatform = Long.valueOf(r110.j());
        goto L3
    L9:
        this.miniGameMeta = new com.bytedance.android.gamecp.host_api.model.e(r110);
        goto L3
    L10:
        this.gamePlatformType = r110.i();
        goto L3
    L11:
        this.isDownloadSupport = am3.h.a(r110);
        goto L3
    L12:
        this.appCloudId = Long.valueOf(r110.j());
        goto L3
    L13:
        this.isPropExpGame = am3.h.a(r110);
        goto L3
    L14:
        this.gameUnionType = Long.valueOf(r110.j());
        goto L3
    L15:
        this.gameStageType = r110.i();
        goto L3
    L16:
        this.onlineTime = am3.h.c(r110);
        goto L3
    L17:
        List r103 = this.videoList;
        Object r104 = new com.bytedance.android.gamecp.business.gamedetail.base.model.u(r110);
    L67:
        r103.add(r104);
        goto L3
    L18:
        r103 = this.tagProperty;
        r104 = new k0(r110);
        goto L67
    L19:
        this.playingCount = Long.valueOf(r110.j());
        goto L3
    L20:
        long r105 = r110.c();
        Object r106 = null;
    L21:
        int r111 = r110.f();
        if (r111 == (-1)) goto L28;
        if (r111 != 1) goto L24;
        r102 = am3.h.c(r110);
        goto L21
    L24:
        if (r111 != 2) goto L25;
        r106 = new w(r110);
        goto L21
    L25:
        am3.h.e(r110);
        goto L21
    L28:
        r110.d(r105);
        Map r107 = this.imgProperty;
        if (r102 == null) goto L35;
        if (r106 == null) goto L33;
    L60:
        r107.put(r102, r106);
        goto L3
    L33:
        throw new IllegalStateException("Value must not be null");
    L35:
        throw new IllegalStateException("Key must not be null");
    L36:
        this.antiHijackImage = am3.h.c(r110);
        goto L3
    L37:
        this.antiHijackContent = am3.h.c(r110);
        goto L3
    L38:
        this.publisher = am3.h.c(r110);
        goto L3
    L39:
        this.downloadExtra = am3.h.c(r110);
        goto L3
    L40:
        this.bgColor = am3.h.c(r110);
        goto L3
    L41:
        this.updateTime = am3.h.c(r110);
        goto L3
    L42:
        this.permissionUrl = am3.h.c(r110);
        goto L3
    L43:
        this.privacyUrl = am3.h.c(r110);
        goto L3
    L44:
        this.versionCode = am3.h.c(r110);
        goto L3
    L45:
        this.packageName = am3.h.c(r110);
        goto L3
    L46:
        this.pkgSize = am3.h.c(r110);
        goto L3
    L47:
        this.versionName = am3.h.c(r110);
        goto L3
    L48:
        this.introduce = am3.h.c(r110);
        goto L3
    L49:
        long r108 = r110.c();
        r106 = null;
    L50:
        int r112 = r110.f();
        if (r112 == (-1)) goto L57;
        if (r112 != 1) goto L53;
        r102 = am3.h.c(r110);
        goto L50
    L53:
        if (r112 != 2) goto L54;
        r106 = am3.h.c(r110);
        goto L50
    L54:
        am3.h.e(r110);
        goto L50
    L57:
        r110.d(r108);
        r107 = this.images;
        if (r102 == null) goto L64;
        if (r106 != null) goto L60;
        throw new IllegalStateException("Value must not be null");
    L64:
        throw new IllegalStateException("Key must not be null");
    L65:
        this.downloadUrl = am3.h.c(r110);
        goto L3
    L66:
        r103 = this.tags;
        r104 = am3.h.c(r110);
        goto L67
    L68:
        this.company = am3.h.c(r110);
        goto L3
    L69:
        this.iconUrl = am3.h.c(r110);
        goto L3
    L70:
        this.status = am3.h.c(r110);
        goto L3
    L71:
        this.name = am3.h.c(r110);
        goto L3
    L72:
        this.f56433id = am3.h.c(r110);
        goto L3
    L7:
        am3.h.e(r110);
        goto L3
    L73:
        r110.d(r100);
        if (this.f56433id != null) goto L77;
        this.f56433id = "";
    L77:
        if (this.name != null) goto L80;
        this.name = "";
    L80:
        if (this.status != null) goto L83;
        this.status = "";
    L83:
        if (this.iconUrl != null) goto L86;
        this.iconUrl = "";
    L86:
        if (this.company != null) goto L89;
        this.company = "";
    L89:
        if (this.publisher != null) goto L92;
        this.publisher = "";
    L92:
        if (this.downloadUrl != null) goto L95;
        this.downloadUrl = "";
    L95:
        if (this.introduce != null) goto L98;
        this.introduce = "";
    L98:
        if (this.pkgSize != null) goto L101;
        this.pkgSize = "";
    L101:
        if (this.versionName != null) goto L104;
        this.versionName = "";
    L104:
        if (this.versionCode != null) goto L107;
        this.versionCode = "";
    L107:
        if (this.privacyUrl != null) goto L110;
        this.privacyUrl = "";
    L110:
        if (this.permissionUrl != null) goto L113;
        this.permissionUrl = "";
    L113:
        if (this.updateTime != null) goto L116;
        this.updateTime = "";
    L116:
        if (this.bgColor != null) goto L119;
        this.bgColor = "";
    L119:
        if (this.packageName != null) goto L122;
        this.packageName = "";
    L122:
        if (this.downloadExtra != null) goto L125;
        this.downloadExtra = "";
    L125:
        if (this.gameUnionType != null) goto L128;
        this.gameUnionType = 0L;
    L128:
        if (this.playingCount != null) goto L131;
        this.playingCount = 0L;
    L131:
        if (this.appCloudId != null) goto L134;
        this.appCloudId = 0L;
    L134:
        if (this.supportPlatform != null) goto L228;
        this.supportPlatform = 0L;
        return;
    }
}
