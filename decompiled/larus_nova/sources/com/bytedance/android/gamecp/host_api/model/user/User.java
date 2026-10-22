package com.bytedance.android.gamecp.host_api.model.user;

import am3.g;
import android.text.TextUtils;
import bw.p;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.gamecp.host_api.model.IImageModel;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.GameUser")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0002R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010$R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/user/User;", "Lcom/bytedance/android/gamecp/host_api/model/user/IUser;", "", "getIdStr", "idStr", "", "setIdStr", "mAvatarThumbStr", "setAvatarThumbStr", "mAvatarMediumStr", "setAVatarMediumStr", "mAvatarLargeStr", "setAvatarLargeStr", "", "isShouldUseRealName", "shouldUseRealName", "setShouldUseRealName", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "imageModel", "setAvatarThumb", "getId", "id", "setId", "getAvatarThumb", "getAvatarMedium", "setAvatarMedium", "getAvatarLarge", "setAvatarLarge", "nickName", "setNickName", "getNickName", "getRealNickName", "getSecUid", "secUid", "setSecUid", "mNickname", "Ljava/lang/String;", NativeDownloadModel.JsonKey.ID, "openId", "mAvatarThumb", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "mSecUid", "mShouldUseRealName", "Z", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class User implements IUser, h {
    private String mAvatarLargeStr;
    private String mAvatarMediumStr;

    @SerializedName("avatar_thumb")
    protected ImageModel mAvatarThumb;
    private String mAvatarThumbStr;

    @SerializedName("user_id")
    protected String mId;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String mNickname;

    @SerializedName("sec_user_id")
    protected String mSecUid;
    private boolean mShouldUseRealName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/user/User$a;", "Lcom/bytedance/android/gamecp/host_api/model/network/Extra;", "", "anonymousIsSilence", "Z", "getAnonymousIsSilence", "()Z", "setAnonymousIsSilence", "(Z)V", "", "mysteryDetailJumpSchema", "Ljava/lang/String;", "getMysteryDetailJumpSchema", "()Ljava/lang/String;", "setMysteryDetailJumpSchema", "(Ljava/lang/String;)V", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends Extra {

        @SerializedName("anonymous_is_silence")
        private boolean anonymousIsSilence;

        @SerializedName("mystery_detail_jump_schema")
        private String mysteryDetailJumpSchema;

        public a() {
        }
    }

    /* JADX INFO: renamed from: getAvatarLarge, reason: collision with other method in class */
    public ImageModel mo8158getAvatarLarge() {
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return this.mAvatarThumb;
    L3:
        if (this.mAvatarThumb != null) goto L11;
        if (TextUtils.isEmpty(this.mAvatarThumbStr) == true) goto L11;
        this.mAvatarThumb = (ImageModel) GsonHelper.get().fromJson(this.mAvatarThumbStr, ImageModel.class);     // Catch: Exception -> L8
        goto L11
    }

    /* JADX INFO: renamed from: getAvatarMedium, reason: collision with other method in class */
    public ImageModel mo8159getAvatarMedium() {
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return this.mAvatarThumb;
    L3:
        if (this.mAvatarThumb != null) goto L11;
        if (TextUtils.isEmpty(this.mAvatarThumbStr) == true) goto L11;
        this.mAvatarThumb = (ImageModel) GsonHelper.get().fromJson(this.mAvatarThumbStr, ImageModel.class);     // Catch: Exception -> L8
        goto L11
    }

    /* JADX INFO: renamed from: getAvatarThumb, reason: collision with other method in class */
    public ImageModel mo8160getAvatarThumb() {
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return this.mAvatarThumb;
    L3:
        if (this.mAvatarThumb != null) goto L11;
        if (TextUtils.isEmpty(this.mAvatarThumbStr) == true) goto L11;
        this.mAvatarThumb = (ImageModel) GsonHelper.get().fromJson(this.mAvatarThumbStr, ImageModel.class);     // Catch: Exception -> L8
        goto L11
    }

    @Override // com.bytedance.android.gamecp.host_api.model.user.IUser
    public String getNickName() {
        if (this.mShouldUseRealName == true) goto L5;
        p r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r100.userNameIsProtected() == false) goto L12;
        String r101 = r100.getProtectedName(this.mNickname, this.mId);
        if (r101 != null) goto L13;
        return "";
    L13:
        return r101;
    L12:
        return this.mNickname;
    L5:
        return this.mNickname;
    }

    public User() {
        this.mNickname = "";
        this.mId = "0";
        this.openId = "0";
        this.mSecUid = "";
    }

    @Override // com.bytedance.android.gamecp.host_api.model.user.IUser
    public String getId() {
        if (GameCpTargetUtils.h() == false) goto L6;
        return this.openId;
    L6:
        return this.mId;
    }

    public final String getIdStr() {
        if (GameCpTargetUtils.h() == false) goto L6;
        return this.openId;
    L6:
        return this.mId;
    }

    @Override // com.bytedance.android.gamecp.host_api.model.user.IUser
    public String getRealNickName() {
        return this.mNickname;
    }

    @Override // com.bytedance.android.gamecp.host_api.model.user.IUser
    public String getSecUid() {
        return this.mSecUid;
    }

    public final boolean isShouldUseRealName() {
        return this.mShouldUseRealName;
    }

    public /* bridge */ /* synthetic */ IImageModel getAvatarLarge() {
        return mo8158getAvatarLarge();
    }

    public /* bridge */ /* synthetic */ IImageModel getAvatarMedium() {
        return mo8159getAvatarMedium();
    }

    public /* bridge */ /* synthetic */ IImageModel getAvatarThumb() {
        return mo8160getAvatarThumb();
    }

    public User(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.mId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.openId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.mNickname = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.mAvatarThumb = new ImageModel(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.mSecUid = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.mNickname != null) goto L25;
        this.mNickname = "";
    L25:
        if (this.mId != null) goto L28;
        this.mId = "0";
    L28:
        if (this.openId != null) goto L31;
        this.openId = "0";
    L31:
        if (this.mSecUid != null) goto L52;
        this.mSecUid = "";
        return;
    }

    public final void setAVatarMediumStr(String r100) {
        this.mAvatarMediumStr = r100;
    }

    public final void setAvatarLarge(ImageModel r100) {
        this.mAvatarThumb = r100;
    }

    public final void setAvatarLargeStr(String r100) {
        this.mAvatarLargeStr = r100;
    }

    public final void setAvatarMedium(ImageModel r100) {
        this.mAvatarThumb = r100;
    }

    public final void setAvatarThumb(ImageModel r100) {
        this.mAvatarThumb = r100;
    }

    public final void setAvatarThumbStr(String r100) {
        this.mAvatarThumbStr = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (GameCpTargetUtils.h() == false) goto L5;
        this.openId = r100;
        return;
    L5:
        this.mId = r100;
    }

    public final void setIdStr(String r100) {
        if (GameCpTargetUtils.h() == false) goto L7;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        this.openId = r100;
        return;
    L7:
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        this.mId = r100;
    }

    public final void setNickName(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.mNickname = r100;
    }

    public final void setSecUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "secUid");
        this.mSecUid = r100;
    }

    public final void setShouldUseRealName(boolean r100) {
        this.mShouldUseRealName = r100;
    }
}
