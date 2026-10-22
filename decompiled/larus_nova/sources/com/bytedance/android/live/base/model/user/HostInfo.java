package com.bytedance.android.live.base.model.user;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.OpenHostInfo")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010(\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000f\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R0\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b>\u0010=¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/base/model/user/HostInfo;", "", "", "shouldUseRealName", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "", "getNickName", "nickName", "", "setNickName", "userId", "setUserId", "getUserId", "_realNickName", "Ljava/lang/String;", "get_realNickName", "()Ljava/lang/String;", "set_realNickName", "(Ljava/lang/String;)V", "", "_gender", "I", "get_gender", "()I", "set_gender", "(I)V", "_signature", "get_signature", "set_signature", "Lcom/bytedance/android/live/base/model/ImageModel;", "_avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_avatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_avatarThumb", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_avatarMedium", "get_avatarMedium", "set_avatarMedium", "_avatarLarge", "get_avatarLarge", "set_avatarLarge", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "_followInfo", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "get_followInfo", "()Lcom/bytedance/android/live/base/model/user/FollowInfo;", "set_followInfo", "(Lcom/bytedance/android/live/base/model/user/FollowInfo;)V", "_userId", "get_userId", "set_userId", "", "_extra", "Ljava/util/Map;", "get_extra", "()Ljava/util/Map;", "set_extra", "(Ljava/util/Map;)V", "isFollowing", "()Z", "isFollowed", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HostInfo implements vh7.h {

    @SerializedName("avatar_large")
    protected ImageModel _avatarLarge;

    @SerializedName("avatar_medium")
    protected ImageModel _avatarMedium;

    @SerializedName("avatar_thumb")
    protected ImageModel _avatarThumb;

    @SerializedName("extra")
    protected Map<String, String> _extra;

    @SerializedName("follow_info")
    protected FollowInfo _followInfo;

    @SerializedName("gender")
    protected int _gender;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String _realNickName;

    @SerializedName("signature")
    protected String _signature;
    private String _userId;

    public HostInfo() {
    }

    public final boolean isFollowed() {
        FollowInfo r100 = this._followInfo;
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r100);
        return r100.isFollowed();
    }

    public final boolean isFollowing() {
        FollowInfo r100 = this._followInfo;
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r100);
        return r100.isFollowing();
    }

    public String getUserId() {
        return this._userId;
    }

    public final ImageModel get_avatarLarge() {
        return this._avatarLarge;
    }

    public final ImageModel get_avatarMedium() {
        return this._avatarMedium;
    }

    public final ImageModel get_avatarThumb() {
        return this._avatarThumb;
    }

    public final Map<String, String> get_extra() {
        return this._extra;
    }

    public final FollowInfo get_followInfo() {
        return this._followInfo;
    }

    public final int get_gender() {
        return this._gender;
    }

    public final String get_realNickName() {
        return this._realNickName;
    }

    public final String get_signature() {
        return this._signature;
    }

    public final String get_userId() {
        return this._userId;
    }

    public HostInfo(am3.g r110) {
        this._extra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L34;
        if (r101 != 100) goto L7;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L17:
        int r105 = r110.f();
        if (r105 == (-1)) goto L26;
        if (r105 != 1) goto L22;
        r103 = am3.h.c(r110);
        goto L17
    L22:
        if (r105 != 2) goto L23;
        r104 = am3.h.c(r110);
        goto L17
    L23:
        am3.h.e(r110);
        goto L17
    L26:
        r110.d(r102);
        Map<String, String> r106 = this._extra;
        if (r103 == null) goto L33;
        if (r104 == null) goto L31;
        r106.put(r103, r104);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L7:
        switch(r101) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this._followInfo = new FollowInfo(r110);
        goto L3
    L10:
        this._avatarLarge = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L11:
        this._avatarMedium = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L12:
        this._avatarThumb = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L13:
        this._signature = am3.h.c(r110);
        goto L3
    L14:
        this._gender = r110.i();
        goto L3
    L15:
        this._realNickName = am3.h.c(r110);
        goto L3
    L8:
        am3.h.e(r110);
        goto L3
    L34:
        r110.d(r100);
    }

    public final void setNickName(String r100) {
        this._realNickName = r100;
    }

    public final void setUserId(String r100) {
        this._userId = r100;
    }

    public final void set_avatarLarge(ImageModel r100) {
        this._avatarLarge = r100;
    }

    public final void set_avatarMedium(ImageModel r100) {
        this._avatarMedium = r100;
    }

    public final void set_avatarThumb(ImageModel r100) {
        this._avatarThumb = r100;
    }

    public final void set_extra(Map<String, String> r100) {
        this._extra = r100;
    }

    public final void set_followInfo(FollowInfo r100) {
        this._followInfo = r100;
    }

    public final void set_gender(int r100) {
        this._gender = r100;
    }

    public final void set_realNickName(String r100) {
        this._realNickName = r100;
    }

    public final void set_signature(String r100) {
        this._signature = r100;
    }

    public final void set_userId(String r100) {
        this._userId = r100;
    }

    public final String getNickName(boolean r100, IBaseUser r101) {
        Intrinsics.checkNotNullParameter(r101, "user");
        if (r100 == true) goto L5;
        kz.a r102 = kz.b.f506725a;
        if (r102 == null) goto L12;
        Intrinsics.checkNotNull(r102);
        if (r102.a() == false) goto L12;
        kz.a r103 = kz.b.f506725a;
        Intrinsics.checkNotNull(r103);
        String r104 = this._realNickName;
        Intrinsics.checkNotNull(r104);
        return r103.getProtectedName(r104, String.valueOf(r101.getUserId()));
    L12:
        return this._realNickName;
    L5:
        return this._realNickName;
    }
}
