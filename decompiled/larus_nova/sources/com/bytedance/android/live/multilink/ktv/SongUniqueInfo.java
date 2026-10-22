package com.bytedance.android.live.multilink.ktv;

import am3.g;
import com.bytedance.android.livesdk.d9;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR \u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR$\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R \u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/multilink/ktv/SongUniqueInfo;", "", "()V", "isPublic", "", "()Z", "setPublic", "(Z)V", "kSongUid", "", "getKSongUid", "()J", "setKSongUid", "(J)V", "mainUserId", "getMainUserId$annotations", "getMainUserId", "setMainUserId", "openId", "", "getOpenId$annotations", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "songId", "getSongId", "setSongId", "songIdStr", "getSongIdStr", "setSongIdStr", "songType", "getSongType", "setSongType", "value", "userId", "getUserId", "setUserId", "userIdStr", "getUserIdStr", "setUserIdStr", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SongUniqueInfo implements h {

    @SerializedName("is_public")
    protected boolean isPublic;

    @SerializedName("k_song_uid")
    protected long kSongUid;

    @IgnoreProtoFieldCheck
    @SerializedName("user_id")
    protected long mainUserId;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("song_id")
    protected long songId;

    @SerializedName("song_id_str")
    protected String songIdStr;

    @SerializedName("song_type")
    protected long songType;

    @IgnoreProtoFieldCheck
    @SerializedName("str_user_id")
    protected String userIdStr;

    @Deprecated(message = "不要直接读取这个字段，SaaS有问题", replaceWith = @ReplaceWith(expression = "userId", imports = {}))
    public static /* synthetic */ void getMainUserId$annotations() {
    }

    @Deprecated(message = "不要直接读取这个字段，SaaS有问题", replaceWith = @ReplaceWith(expression = "userId", imports = {}))
    public static /* synthetic */ void getOpenId$annotations() {
    }

    public final String getUserId() {
        return d9.c(Long.valueOf(this.mainUserId), this.openId);
    }

    public SongUniqueInfo() {
        this.openId = "";
    }

    public final long getKSongUid() {
        return this.kSongUid;
    }

    public final long getMainUserId() {
        return this.mainUserId;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final long getSongId() {
        return this.songId;
    }

    public final String getSongIdStr() {
        return this.songIdStr;
    }

    public final long getSongType() {
        return this.songType;
    }

    public final String getUserIdStr() {
        return this.userIdStr;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public SongUniqueInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        if (r102 != 5000) goto L7;
        this.openId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
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
        this.userIdStr = am3.h.c(r100);
        goto L3
    L10:
        this.songIdStr = am3.h.c(r100);
        goto L3
    L11:
        this.kSongUid = r100.j();
        goto L3
    L12:
        this.isPublic = am3.h.a(r100);
        goto L3
    L13:
        this.songType = r100.j();
        goto L3
    L14:
        this.mainUserId = r100.j();
        goto L3
    L15:
        this.songId = r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.openId != null) goto L42;
        this.openId = "";
        return;
    }

    public final void setKSongUid(long r100) {
        this.kSongUid = r100;
    }

    public final void setMainUserId(long r100) {
        this.mainUserId = r100;
    }

    public final void setOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openId = r100;
    }

    public final void setPublic(boolean r100) {
        this.isPublic = r100;
    }

    public final void setSongId(long r100) {
        this.songId = r100;
    }

    public final void setSongIdStr(String r100) {
        this.songIdStr = r100;
    }

    public final void setSongType(long r100) {
        this.songType = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        d9.b(r100, new SongUniqueInfo$userId$1(this), new SongUniqueInfo$userId$2(this));
    }

    public final void setUserIdStr(String r100) {
        this.userIdStr = r100;
    }
}
