package com.bytedance.android.live.base.model.user;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0002H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0002H&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010!\u001a\u00020\u0002H&J\b\u0010\"\u001a\u00020\u0002H&J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H&J\b\u0010%\u001a\u00020\u0002H&J\n\u0010&\u001a\u0004\u0018\u00010\u0010H&J\b\u0010'\u001a\u00020\u0010H&J\b\u0010(\u001a\u00020\u0015H&J\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H&J\u0012\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H&J\b\u0010-\u001a\u00020\u0018H&J\n\u0010.\u001a\u0004\u0018\u00010\rH&R\u001c\u00103\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00108\u001a\u00020\u00158&@&X¦\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010=\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010@\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\u001e\u0010C\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bA\u00100\"\u0004\bB\u00102R\u001e\u0010F\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u00100\"\u0004\bE\u00102R\u001e\u0010L\u001a\u0004\u0018\u00010G8&@&X¦\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010Q\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010T\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR\u001e\u0010W\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bU\u00100\"\u0004\bV\u00102R\u001c\u0010Z\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\bX\u0010N\"\u0004\bY\u0010PR(\u0010_\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010[j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\\8&X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u001c\u0010`\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010:\"\u0004\ba\u0010<R\u001e\u0010d\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bb\u00100\"\u0004\bc\u00102R\u001c\u0010g\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\be\u0010N\"\u0004\bf\u0010PR(\u0010i\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010[j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\\8&X¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010^R\u001e\u0010o\u001a\u0004\u0018\u00010j8&@&X¦\u000e¢\u0006\f\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010s\u001a\u0004\u0018\u00010p8&X¦\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u001e\u0010v\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bt\u00100\"\u0004\bu\u00102R\u001e\u0010{\u001a\u0004\u0018\u00010\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001e\u0010~\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b|\u00100\"\u0004\b}\u00102R\u001e\u0010\u0081\u0001\u001a\u00020\u00188&@&X¦\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010N\"\u0005\b\u0080\u0001\u0010PR!\u0010\u0086\u0001\u001a\f\u0018\u00010\u0082\u0001j\u0005\u0018\u0001`\u0083\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R$\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0087\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008d\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R!\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u00100\"\u0005\b\u0094\u0001\u00102R$\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0096\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R!\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u00100\"\u0005\b\u009d\u0001\u00102R\u001f\u0010¡\u0001\u001a\u00020\u00188&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010N\"\u0005\b \u0001\u0010PR\u001f\u0010¤\u0001\u001a\u00020\u00188&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¢\u0001\u0010N\"\u0005\b£\u0001\u0010PR\u001f\u0010§\u0001\u001a\u00020\u00158&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¥\u0001\u00105\"\u0005\b¦\u0001\u00107R\u001f\u0010ª\u0001\u001a\u00020\u00188&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010N\"\u0005\b©\u0001\u0010PR\u001f\u0010\u00ad\u0001\u001a\u00020\u00188&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b«\u0001\u0010N\"\u0005\b¬\u0001\u0010PR\u001f\u0010°\u0001\u001a\u00020\u00158&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b®\u0001\u00105\"\u0005\b¯\u0001\u00107R\u001f\u0010³\u0001\u001a\u00020\u00158&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b±\u0001\u00105\"\u0005\b²\u0001\u00107R\u001f\u0010¶\u0001\u001a\u00020\u00188&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b´\u0001\u0010N\"\u0005\bµ\u0001\u0010P¨\u0006·\u0001"}, d2 = {"Lcom/bytedance/android/live/base/model/user/IUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "", "contentAuthorized", "relationAuthorized", "", "setVcdAdversaryAuthorizeState", "isVcdContentAuthorized", "isVcdRelationAuthorized", "isVcdAdversaryContentAuthorized", "isVcdAdversaryRelationAuthorized", "isEnableShowFansClubReverse", "isWithCommercePermission", "Lpy/k;", "getAvatarMedium", "getAvatarLarge", "", "getLocationCity", "isRoomAnchor", "getProperNickName", "getRealNickName", "", "getLiveRoomId", "canJumpToLiveRoom", "", "followStatus", "setFollowStatus", "getRequestId", "requestId", "setRequestId", "getLogPb", "logPb", "setLogPb", "childrenManagerForbidCreateLiveRoom", "childrenManagerForbidWalletFunctions", "", "getBadgeImageList", "isFollowing", "getRemarkNameOrNickname", "getRelationship", "getPayScores", "getNewUserBadges", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "roomAuthStatus", "isFollowingByRoomAuth", "getPrivilegeLevel", "getAvatarThumb", "getIdString", "()Ljava/lang/String;", "setIdString", "(Ljava/lang/String;)V", "idString", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "fanTicketCount", "getEnableShowCommerceSale", "()Z", "setEnableShowCommerceSale", "(Z)V", "enableShowCommerceSale", "getEnableCarManagementPermission", "setEnableCarManagementPermission", "enableCarManagementPermission", "getDisplayId", "setDisplayId", "displayId", "getCity", "setCity", "city", "Lpy/q;", "getPoiInfo", "()Lpy/q;", "setPoiInfo", "(Lpy/q;)V", "poiInfo", "getGender", "()I", "setGender", "(I)V", "gender", "getAgeRange", "setAgeRange", CommonConstant.KEY_AGE_RANGE, "getSignature", "setSignature", "signature", "getLevel", "setLevel", "level", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTopFans", "()Ljava/util/List;", "topFans", "isVerified", "setVerified", "getVerifiedReason", "setVerifiedReason", "verifiedReason", "getLinkMicStats", "setLinkMicStats", "linkMicStats", "getUserBadges", "userBadges", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "getAnchorLevel", "()Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "setAnchorLevel", "(Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;)V", "anchorLevel", "Lpy/f;", "getBorder", "()Lpy/f;", "border", "getSpecialId", "setSpecialId", "specialId", "getMedal", "()Lpy/k;", "setMedal", "(Lpy/k;)V", "medal", "getBackgroundImgUrl", "setBackgroundImgUrl", "backgroundImgUrl", "getSecret", "setSecret", "secret", "Lpy/j;", "Lcom/bytedance/android/live/api/IFollowInfoKt;", "getFollowInfo", "()Lpy/j;", "followInfo", "Lpy/t;", "getUserAttr", "()Lpy/t;", "setUserAttr", "(Lpy/t;)V", "userAttr", "Lcom/bytedance/android/live/base/model/user/l0;", "getDressInfo", "()Lcom/bytedance/android/live/base/model/user/l0;", "setDressInfo", "(Lcom/bytedance/android/live/base/model/user/l0;)V", "dressInfo", "getUnionId", "setUnionId", CommonConstant.KEY_UNION_ID, "Lpy/b;", "getAnchorInfo", "()Lpy/b;", "setAnchorInfo", "(Lpy/b;)V", "anchorInfo", "getShareQrcodeUri", "setShareQrcodeUri", "shareQrcodeUri", "getIncomeSharePercent", "setIncomeSharePercent", "incomeSharePercent", "getExperience", "setExperience", "experience", "getModifyTime", "setModifyTime", "modifyTime", "getStatus", "setStatus", "status", "getTopVipNo", "setTopVipNo", "topVipNo", "getCreateTime", "setCreateTime", "createTime", "getBirthday", "setBirthday", "birthday", "getUserRole", "setUserRole", "userRole", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IUser extends IBaseUser {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean canJumpToLiveRoom();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean childrenManagerForbidCreateLiveRoom();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean childrenManagerForbidWalletFunctions();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ IBaseUser cloneFrom();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "adversary_user_status")
    /* synthetic */ int getAdversaryUserStatus();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    int getAgeRange();

    py.b getAnchorInfo();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ py.b getAnchorInfoExt();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    IAnchorLevel getAnchorLevel();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.k getAvatarLarge();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.k getAvatarMedium();

    py.k getAvatarThumb();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "avatar_thumb")
    /* synthetic */ py.k getAvatarThumbKt();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ String getAvatarUrl();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getBackgroundImgUrl();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    List<py.k> getBadgeImageList();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ List<py.k> getBadgeImageListV2();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ List<py.k> getBadgeImageListV2Ext();

    long getBirthday();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.f getBorder();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "bottom_entry")
    /* synthetic */ e getBottomEntry();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ String getCastSecUid();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getCity();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ int getCommerceUserLevel();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ j getCommonVipInfo();

    long getCreateTime();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getDisplayId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser, com.bytedance.android.live.base.model.user.l
    l0 getDressInfo();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean getEnableCarManagementPermission();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean getEnableShowCommerceSale();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ String getEncryptedId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ int getEnterprise();

    int getExperience();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    long getFanTicketCount();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = PbRequest.SwitchType.FANS_CLUB)
    /* synthetic */ t getFansClub();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.j getFollowInfo();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ py.j getFollowInfoExt();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    int getGender();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ String getIdStrKt();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser, com.bytedance.android.live.base.model.user.l
    String getIdString();

    int getIncomeSharePercent();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "industry_certification")
    /* synthetic */ x getIndustryCertification();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    int getLevel();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    int getLinkMicStats();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    long getLiveRoomId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getLocationCity();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getLogPb();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "authentication_info")
    /* synthetic */ py.c getMAuthenticationInfo();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.k getMedal();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "media_badge_image_list")
    /* synthetic */ List<py.k> getMediaBadgeImageList();

    long getModifyTime();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "mystery_man")
    /* synthetic */ int getMysteryMan();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    List<py.k> getNewUserBadges();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = InstantPlayContext.NICKNAME)
    /* synthetic */ String getNickName();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ py.o getOwnRoom();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    long getPayScores();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "personal_card")
    /* synthetic */ py.k getPersonalCard();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.q getPoiInfo();

    int getPrivilegeLevel();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "profile_style_params")
    /* synthetic */ d0 getProfileStyleParams();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getProperNickName(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "public_area_oper_freq")
    /* synthetic */ long getPublicScreenOperateFreq();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getRealNickName();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getRelationship();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getRemarkNameOrNickname();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ String getRemarkNameOrRealNickName();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getRequestId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ boolean getRoomAutoGiftThanks();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "desensitized_nickname")
    /* synthetic */ String getSafeNicName();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ int getSearchType();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    int getSecret();

    String getShareQrcodeUri();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "short_id")
    /* synthetic */ long getShortId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getSignature();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getSpecialId();

    int getStatus();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "subscribe")
    /* synthetic */ g0 getSubscribe();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "telephone")
    /* synthetic */ String getTelephone();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    List<IBaseUser> getTopFans();

    int getTopVipNo();

    String getUnionId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    py.t getUserAttr();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ py.t getUserAttrExt();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ py.t getUserAttrFlex();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    List<py.k> getUserBadges();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "pay_grade")
    /* synthetic */ py.d getUserHonor();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ String getUserId();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ o0 getUserIdCompat();

    int getUserRole();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "watch_duration_month")
    /* synthetic */ long getUserWatchMonth();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ boolean getUserWatchMonthValid();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    String getVerifiedReason();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "webcast_uid")
    /* synthetic */ String getWebcastUid();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    /* synthetic */ boolean isAnonymous();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isEnableShowFansClubReverse();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ boolean isEnterpriseVerify();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isFollowing();

    boolean isFollowingByRoomAuth(IRoomAuthStatus r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ boolean isMysteryMan();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ boolean isSubscriber();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isVcdAdversaryContentAuthorized();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isVcdAdversaryRelationAuthorized();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isVcdContentAuthorized();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isVcdRelationAuthorized();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isVerified();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    boolean isWithCommercePermission();

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "adversary_user_status#setter")
    /* synthetic */ void setAdversaryUserStatus(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setAgeRange(int r100);

    void setAnchorInfo(py.b r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setAnchorInfoExt(py.b r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setAnchorLevel(IAnchorLevel r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "is_anonymous#setter")
    /* synthetic */ void setAnonymous(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setAvatarLargeImplicit(py.k r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setAvatarMediumImplicit(py.k r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setAvatarThumbImplicit(py.k r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "avatar_thumb#setter")
    /* synthetic */ void setAvatarThumbKt(py.k r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setAvatarUrl(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setBackgroundImgUrl(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setBadgeImageListV2(List<? extends py.k> r100);

    void setBirthday(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setCastSecUid(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setCity(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setCommerceUserLevel(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setCommonVipInfo(j r100);

    void setCreateTime(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setDisplayId(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setDressInfo(l0 r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setEnableCarManagementPermission(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setEnableShowCommerceSale(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setEnterprise(int r100);

    void setExperience(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setFanTicketCount(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "fans_club#setter")
    /* synthetic */ void setFansClub(t r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setFollowInfoExt(py.j r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setFollowStatus(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setGender(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setIdString(String r100);

    void setIncomeSharePercent(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "industry_certification#setter")
    /* synthetic */ void setIndustryCertification(x r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setLevel(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setLinkMicStats(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setLogPb(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "authentication_info#setter")
    /* synthetic */ void setMAuthenticationInfo(py.c r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setMedal(py.k r100);

    void setModifyTime(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "mystery_man#setter")
    /* synthetic */ void setMysteryMan(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "nickname#setter")
    /* synthetic */ void setNickName(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "personal_card#setter")
    /* synthetic */ void setPersonalCard(py.k r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setPoiInfo(py.q r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "profile_style_params#setter")
    /* synthetic */ void setProfileStyleParams(d0 r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "public_area_oper_freq#setter")
    /* synthetic */ void setPublicScreenOperateFreq(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setRequestId(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "desensitized_nickname#setter")
    /* synthetic */ void setSafeNicName(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setSearchType(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setSecret(int r100);

    void setShareQrcodeUri(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "short_id#setter")
    /* synthetic */ void setShortId(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setShouldUseRealName(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setSignature(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setSpecialId(String r100);

    void setStatus(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "subscribe#setter")
    /* synthetic */ void setSubscribe(g0 r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "telephone#setter")
    /* synthetic */ void setTelephone(String r100);

    void setTopVipNo(int r100);

    void setUnionId(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setUserAttr(py.t r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setUserAttrExt(py.t r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "pay_grade#setter")
    /* synthetic */ void setUserHonor(py.d r100);

    void setUserRole(int r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "watch_duration_month#setter")
    /* synthetic */ void setUserWatchMonth(long r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setUserWatchMonthValid(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setVcdAdversaryAuthorizeState(boolean r100, boolean r101);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setVerified(boolean r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    void setVerifiedReason(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    @FieldName(name = "webcast_uid#setter")
    /* synthetic */ void setWebcastUid(String r100);

    @Override // com.bytedance.android.live.base.model.user.IBaseUser
    /* synthetic */ void setWithCommercePermission(boolean r100);
}
