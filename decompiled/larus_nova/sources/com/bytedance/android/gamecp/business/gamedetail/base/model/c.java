package com.bytedance.android.gamecp.business.gamedetail.base.model;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010*R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006R\u001c\u00105\u001a\u0004\u0018\u0001048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u0010:\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010@\u001a\u0004\bD\u0010BR\u001c\u0010E\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006R\"\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010\u000f\u001a\u0004\bH\u0010\u0011R\u001c\u0010I\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010\u0018\u001a\u0004\bJ\u0010\u001aR\u001c\u0010K\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010;\u001a\u0004\bL\u0010=R\u001c\u0010N\u001a\u0004\u0018\u00010M8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\f\n\u0004\bR\u0010;\u001a\u0004\bS\u0010=R\"\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\u000f\u001a\u0004\bV\u0010\u0011R\u001c\u0010X\u001a\u0004\u0018\u00010W8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001c\u0010]\u001a\u0004\u0018\u00010\\8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006R\u001c\u0010c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010\u0004\u001a\u0004\bd\u0010\u0006¨\u0006e"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/c;", "", "", "id", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "name", "t", "onlineTime", "getOnlineTime", "icon", OfficeSDKRequestTag.KEY_NEW_USER, "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "ageLimit", "c", "introduction", "s", "", "gameUnionType", "Ljava/lang/Long;", "getGameUnionType", "()Ljava/lang/Long;", "gameStage", ce.f26395j, "gameAccessType", "getGameAccessType", "gamePlatform", ce.f26391f, "company", "e", "publisher", "y", "version", "B", "packageSize", "w", "D", "(Ljava/lang/String;)V", "incrementPackageSize", "r", "setIncrementPackageSize", "packageName", BaseSwitches.V, "authorizationUrl", "d", "privacyUrl", "x", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "gameIcon", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "f", "()Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "", "gameStatusEnum", "Ljava/lang/Integer;", ce.f26396k, "()Ljava/lang/Integer;", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "gameStatusImage", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "l", "()Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "gameStatusImageWhite", "m", "shortAdditionalDesc", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "additionalDescList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamePlatform_v2", "h", "omniCooperationType", "u", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "officialAccountInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "getOfficialAccountInfo", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "publishStage", "getPublishStage", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/a;", "additionalDescriptionList", "b", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/q;", "gameRankEntranceInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/q;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/q;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/v;", "videoRankListEntrance", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/v;", "C", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/v;", "icpRegistration", "p", "icpFillingEntityName", "o", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("additional_desc_list")
    private final List<String> additionalDescList;

    @SerializedName("additional_description_list")
    private final List<a> additionalDescriptionList;

    @SerializedName("age_limit")
    private final String ageLimit;

    @SerializedName("android_authorization_url")
    private final String authorizationUrl;

    @SerializedName("company")
    private final String company;

    @SerializedName("game_access_type")
    private final Long gameAccessType;

    @SerializedName("game_icon")
    private final GameImageBundler gameIcon;

    @SerializedName(IPerformanceManager.MODULE_LIVE_GAME_PLATFORM)
    private final Long gamePlatform;

    @SerializedName("game_platform_v2")
    private final Long gamePlatform_v2;

    @SerializedName("game_rank_list_entrance")
    private final q gameRankEntranceInfo;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE)
    private final Long gameStage;

    @SerializedName("game_status_int")
    private final Integer gameStatusEnum;

    @SerializedName("game_status_img")
    private final ImageModel gameStatusImage;

    @SerializedName("game_status_img_white")
    private final ImageModel gameStatusImageWhite;

    @SerializedName("game_union_type")
    private final Long gameUnionType;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icp_filing_entity_name")
    private final String icpFillingEntityName;

    @SerializedName("icp_registration")
    private final String icpRegistration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f53482id;

    @SerializedName("increment_package_size")
    private String incrementPackageSize;

    @SerializedName("introduction")
    private final String introduction;

    @SerializedName("name")
    private final String name;

    @SerializedName("official_account_info")
    private final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g officialAccountInfo;

    @SerializedName("omni_cooperation_type")
    private final Integer omniCooperationType;

    @SerializedName("online_time")
    private final String onlineTime;

    @SerializedName("android_package_name")
    private final String packageName;

    @SerializedName("android_package_size")
    private String packageSize;

    @SerializedName("android_privacy_url")
    private final String privacyUrl;

    @SerializedName("publish_stage")
    private final Integer publishStage;

    @SerializedName("publisher")
    private final String publisher;

    @SerializedName("short_additional_desc")
    private final String shortAdditionalDesc;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<String> tags;

    @SerializedName("android_version")
    private final String version;

    @SerializedName("video_rank_list_entrance")
    private final v videoRankListEntrance;

    public c() {
        this.f53482id = "";
        this.name = "";
        this.onlineTime = "";
        this.icon = "";
        this.tags = null;
        this.ageLimit = "";
        this.introduction = "";
        this.gameUnionType = null;
        this.gameStage = null;
        this.gameAccessType = null;
        this.gamePlatform = null;
        this.company = "";
        this.publisher = "";
        this.version = "";
        this.packageSize = "";
        this.incrementPackageSize = "";
        this.packageName = "";
        this.authorizationUrl = "";
        this.privacyUrl = "";
        this.gameIcon = null;
        this.gameStatusEnum = 0;
        this.gameStatusImage = null;
        this.gameStatusImageWhite = null;
        this.shortAdditionalDesc = null;
        this.additionalDescList = null;
        this.gamePlatform_v2 = 0L;
        this.omniCooperationType = 0;
        this.officialAccountInfo = null;
        this.publishStage = null;
        this.additionalDescriptionList = null;
        this.gameRankEntranceInfo = null;
        this.videoRankListEntrance = null;
        this.icpRegistration = null;
        this.icpFillingEntityName = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L74;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f53482id, r101.f53482id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.onlineTime, r101.onlineTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ageLimit, r101.ageLimit) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.introduction, r101.introduction) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.gameUnionType, r101.gameUnionType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.gameStage, r101.gameStage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.gameAccessType, r101.gameAccessType) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.gamePlatform, r101.gamePlatform) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.company, r101.company) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.publisher, r101.publisher) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.packageSize, r101.packageSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.incrementPackageSize, r101.incrementPackageSize) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.authorizationUrl, r101.authorizationUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.privacyUrl, r101.privacyUrl) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.gameIcon, r101.gameIcon) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.gameStatusEnum, r101.gameStatusEnum) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.gameStatusImage, r101.gameStatusImage) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.gameStatusImageWhite, r101.gameStatusImageWhite) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.shortAdditionalDesc, r101.shortAdditionalDesc) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.additionalDescList, r101.additionalDescList) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.gamePlatform_v2, r101.gamePlatform_v2) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.omniCooperationType, r101.omniCooperationType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.officialAccountInfo, r101.officialAccountInfo) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.publishStage, r101.publishStage) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.additionalDescriptionList, r101.additionalDescriptionList) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.gameRankEntranceInfo, r101.gameRankEntranceInfo) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.videoRankListEntrance, r101.videoRankListEntrance) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.icpRegistration, r101.icpRegistration) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.icpFillingEntityName, r101.icpFillingEntityName) == true) goto L112;
        return false;
    L112:
        return true;
    L74:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f53482id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.onlineTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.icon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.tags;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ageLimit;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.introduction;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.gameUnionType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.gameStage;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.gameAccessType;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.gamePlatform;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.company;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.publisher;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.version;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.packageSize;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.incrementPackageSize;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.packageName;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.authorizationUrl;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.privacyUrl;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        GameImageBundler r158 = this.gameIcon;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.gameStatusEnum;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        ImageModel r164 = this.gameStatusImage;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        ImageModel r167 = this.gameStatusImageWhite;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.shortAdditionalDesc;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        List<String> r173 = this.additionalDescList;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        Long r176 = this.gamePlatform_v2;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        Integer r179 = this.omniCooperationType;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g r182 = this.officialAccountInfo;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        Integer r185 = this.publishStage;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        List<a> r188 = this.additionalDescriptionList;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        q r191 = this.gameRankEntranceInfo;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        v r194 = this.videoRankListEntrance;
        if (r194 == null) goto L129;
        int r195 = r194.hashCode();
    L130:
        int r196 = (r193 + r195) * 31;
        String r197 = this.icpRegistration;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (r196 + r198) * 31;
        String r200 = this.icpFillingEntityName;
        if (r200 == null) goto L138;
        r101 = r200.hashCode();
    L138:
        return r199 + r101;
    L133:
        r198 = 0;
        goto L134
    L129:
        r195 = 0;
        goto L130
    L125:
        r192 = 0;
        goto L126
    L121:
        r189 = 0;
        goto L122
    L117:
        r186 = 0;
        goto L118
    L113:
        r183 = 0;
        goto L114
    L109:
        r180 = 0;
        goto L110
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonGameInfo(id=" + this.f53482id + ", name=" + this.name + ", onlineTime=" + this.onlineTime + ", icon=" + this.icon + ", tags=" + this.tags + ", ageLimit=" + this.ageLimit + ", introduction=" + this.introduction + ", gameUnionType=" + this.gameUnionType + ", gameStage=" + this.gameStage + ", gameAccessType=" + this.gameAccessType + ", gamePlatform=" + this.gamePlatform + ", company=" + this.company + ", publisher=" + this.publisher + ", version=" + this.version + ", packageSize=" + this.packageSize + ", incrementPackageSize=" + this.incrementPackageSize + ", packageName=" + this.packageName + ", authorizationUrl=" + this.authorizationUrl + ", privacyUrl=" + this.privacyUrl + ", gameIcon=" + this.gameIcon + ", gameStatusEnum=" + this.gameStatusEnum + ", gameStatusImage=" + this.gameStatusImage + ", gameStatusImageWhite=" + this.gameStatusImageWhite + ", shortAdditionalDesc=" + this.shortAdditionalDesc + ", additionalDescList=" + this.additionalDescList + ", gamePlatform_v2=" + this.gamePlatform_v2 + ", omniCooperationType=" + this.omniCooperationType + ", officialAccountInfo=" + this.officialAccountInfo + ", publishStage=" + this.publishStage + ", additionalDescriptionList=" + this.additionalDescriptionList + ", gameRankEntranceInfo=" + this.gameRankEntranceInfo + ", videoRankListEntrance=" + this.videoRankListEntrance + ", icpRegistration=" + this.icpRegistration + ", icpFillingEntityName=" + this.icpFillingEntityName + ")";
    }

    public final List<String> A() {
        return this.tags;
    }

    public final String B() {
        return this.version;
    }

    public final v C() {
        return this.videoRankListEntrance;
    }

    public final List<String> a() {
        return this.additionalDescList;
    }

    public final List<a> b() {
        return this.additionalDescriptionList;
    }

    public final String c() {
        return this.ageLimit;
    }

    public final String d() {
        return this.authorizationUrl;
    }

    public final String e() {
        return this.company;
    }

    public final GameImageBundler f() {
        return this.gameIcon;
    }

    public final Long g() {
        return this.gamePlatform;
    }

    public final Long h() {
        return this.gamePlatform_v2;
    }

    public final q i() {
        return this.gameRankEntranceInfo;
    }

    public final Long j() {
        return this.gameStage;
    }

    public final Integer k() {
        return this.gameStatusEnum;
    }

    public final ImageModel l() {
        return this.gameStatusImage;
    }

    public final ImageModel m() {
        return this.gameStatusImageWhite;
    }

    public final String n() {
        return this.icon;
    }

    public final String o() {
        return this.icpFillingEntityName;
    }

    public final String p() {
        return this.icpRegistration;
    }

    public final String q() {
        return this.f53482id;
    }

    public final String r() {
        return this.incrementPackageSize;
    }

    public final String s() {
        return this.introduction;
    }

    public final String t() {
        return this.name;
    }

    public final Integer u() {
        return this.omniCooperationType;
    }

    public final String v() {
        return this.packageName;
    }

    public final String w() {
        return this.packageSize;
    }

    public final String x() {
        return this.privacyUrl;
    }

    public final String y() {
        return this.publisher;
    }

    public final String z() {
        return this.shortAdditionalDesc;
    }

    public final void D(String r100) {
        this.packageSize = r100;
    }
}
