package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bA\u0010BR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00138\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\b¨\u0006E"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopAccountInfoModuleDTO;", "Ljava/io/Serializable;", "", "authorId", "Ljava/lang/String;", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "secAuthorId", "getSecAuthorId", "setSecAuthorId", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "", "hideFollowBtn", "Z", "getHideFollowBtn", "()Z", "setHideFollowBtn", "(Z)V", "showInfoColumn", "getShowInfoColumn", "followIconType", "getFollowIconType", "setFollowIconType", "Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "followGiftConfig", "Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "getFollowGiftConfig", "()Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "setFollowGiftConfig", "(Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)V", "Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;", "entranceInformation", "Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;", "getEntranceInformation", "()Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;", "setEntranceInformation", "(Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;)V", "followTaskText", "getFollowTaskText", "setFollowTaskText", "Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "fansInfo", "Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "getFansInfo", "()Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "setFansInfo", "(Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "authorAvatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAuthorAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAuthorAvatar", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "authorNickName", "getAuthorNickName", "setAuthorNickName", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAccountInfoModuleDTO implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 3;

    @SerializedName("avatar_medium")
    private ECUrlModel authorAvatar;

    @SerializedName("user_id")
    private String authorId;

    @SerializedName("nick_name")
    private String authorNickName;

    @SerializedName("entrance_information")
    private EntranceInformation entranceInformation;

    @SerializedName("fans_info")
    private FansClubInfo fansInfo;

    @SerializedName("follow_config")
    private StoreFollowGiftConfig followGiftConfig;

    @SerializedName("follow_icon_type")
    private Integer followIconType;

    @SerializedName("follow_status")
    private Integer followStatus;

    @SerializedName("follow_task_text")
    private String followTaskText;

    @SerializedName("hide_follow_button")
    private boolean hideFollowBtn;

    @SerializedName("sec_author_id")
    private String secAuthorId;

    @SerializedName("show_info_column")
    private final boolean showInfoColumn;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECShopAccountInfoModuleDTO() {
    }

    public final ECUrlModel getAuthorAvatar() {
        return this.authorAvatar;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorNickName() {
        return this.authorNickName;
    }

    public final EntranceInformation getEntranceInformation() {
        return this.entranceInformation;
    }

    public final FansClubInfo getFansInfo() {
        return this.fansInfo;
    }

    public final StoreFollowGiftConfig getFollowGiftConfig() {
        return this.followGiftConfig;
    }

    public final Integer getFollowIconType() {
        return this.followIconType;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getFollowTaskText() {
        return this.followTaskText;
    }

    public final boolean getHideFollowBtn() {
        return this.hideFollowBtn;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final boolean getShowInfoColumn() {
        return this.showInfoColumn;
    }

    public final void setAuthorAvatar(ECUrlModel r100) {
        this.authorAvatar = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setAuthorNickName(String r100) {
        this.authorNickName = r100;
    }

    public final void setEntranceInformation(EntranceInformation r100) {
        this.entranceInformation = r100;
    }

    public final void setFansInfo(FansClubInfo r100) {
        this.fansInfo = r100;
    }

    public final void setFollowGiftConfig(StoreFollowGiftConfig r100) {
        this.followGiftConfig = r100;
    }

    public final void setFollowIconType(Integer r100) {
        this.followIconType = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setFollowTaskText(String r100) {
        this.followTaskText = r100;
    }

    public final void setHideFollowBtn(boolean r100) {
        this.hideFollowBtn = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }
}
