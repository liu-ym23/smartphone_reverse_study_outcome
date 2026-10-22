package cn2;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.o0;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcn2/a;", "Lfz/a;", "", "id", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "", "openId", "Ljava/lang/String;", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "nickName", "c", "setNickName", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatarThumb", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "avatarMedium", "getAvatarMedium", "setAvatarMedium", "avatarLarge", "getAvatarLarge", "setAvatarLarge", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "followInfo", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "b", "()Lcom/bytedance/android/live/base/model/user/FollowInfo;", "setFollowInfo", "(Lcom/bytedance/android/live/base/model/user/FollowInfo;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends fz.a {

    @SerializedName("avatar_large")
    private ImageModel avatarLarge;

    @SerializedName("avatar_medium")
    private ImageModel avatarMedium;

    @SerializedName("avatar_thumb")
    private ImageModel avatarThumb;

    @SerializedName("follow_info")
    private FollowInfo followInfo;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private Long f24506id;

    @SerializedName(InstantPlayContext.NICKNAME)
    private String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private String openId;

    /* JADX INFO: renamed from: cn2.a$a, reason: collision with other inner class name */
    public static final class C0468a {
    }

    static {
    }

    public final String d() {
        o0.a r100 = o0.f58946a;
        Long r101 = this.f24506id;
        String r102 = this.openId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public a() {
    }

    public final ImageModel a() {
        return this.avatarThumb;
    }

    public final FollowInfo b() {
        return this.followInfo;
    }

    public final String c() {
        return this.nickName;
    }
}
