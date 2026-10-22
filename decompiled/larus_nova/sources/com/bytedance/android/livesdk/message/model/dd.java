package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001R(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/dd;", "", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "getUid$annotations", "()V", "", "openId", "Ljava/lang/String;", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "getOpenId$annotations", "songId", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setSongId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/livesdk/message/model/fd;", "videoInfo", "Lcom/bytedance/android/livesdk/message/model/fd;", "d", "()Lcom/bytedance/android/livesdk/message/model/fd;", "setVideoInfo", "(Lcom/bytedance/android/livesdk/message/model/fd;)V", "Lcom/bytedance/android/livesdk/message/model/od;", "mvInfo", "Lcom/bytedance/android/livesdk/message/model/od;", "b", "()Lcom/bytedance/android/livesdk/message/model/od;", "setMvInfo", "(Lcom/bytedance/android/livesdk/message/model/od;)V", "kSongUid", "getKSongUid", "setKSongUid", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class dd implements vh7.h {

    @SerializedName("k_song_uid")
    protected long kSongUid;

    @SerializedName("mv_info")
    protected od mvInfo;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("song_id")
    protected Long songId;

    @IgnoreProtoFieldCheck
    @SerializedName("uid")
    protected long uid;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_INFO)
    protected fd videoInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof dd) == false) goto L18;
        dd r101 = (dd) r100;
        if (this.uid == r101.uid) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.openId, r101.openId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.songId, r101.songId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoInfo, r101.videoInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mvInfo, r101.mvInfo) == true) goto L16;
        return false;
    L16:
        if (this.kSongUid == r101.kSongUid) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r100 = this.uid;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.openId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.songId;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        fd r109 = this.videoInfo;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        od r112 = this.mvInfo;
        if (r112 == null) goto L17;
        r103 = r112.hashCode();
    L17:
        int r113 = (r111 + r103) * 31;
        long r114 = this.kSongUid;
        return r113 + ((int) (r114 ^ (r114 >>> 32)));
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvAtmosphereVideoContent(uid=" + this.uid + ", openId=" + this.openId + ", songId=" + this.songId + ", videoInfo=" + this.videoInfo + ", mvInfo=" + this.mvInfo + ", kSongUid=" + this.kSongUid + ")";
    }

    public final String a() {
        return com.bytedance.android.livesdk.d9.c(Long.valueOf(this.uid), this.openId);
    }

    public dd() {
        this.uid = 0;
        this.openId = "";
        this.songId = null;
        this.videoInfo = null;
        this.mvInfo = null;
        this.kSongUid = 0;
    }

    public final od b() {
        return this.mvInfo;
    }

    public final Long c() {
        return this.songId;
    }

    public final fd d() {
        return this.videoInfo;
    }

    public dd(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L23;
        if (r103 != 1) goto L7;
        this.uid = r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.songId = Long.valueOf(r100.j());
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.videoInfo = new fd(r100);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.mvInfo = new od(r100);
        goto L3
    L13:
        if (r103 != 5) goto L15;
        this.kSongUid = r100.j();
        r102 = r102 | 2;
        goto L3
    L15:
        if (r103 != 5000) goto L16;
        this.openId = am3.h.c(r100);
        goto L3
    L16:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L27;
        this.uid = 0;
    L27:
        if (this.openId != null) goto L30;
        this.openId = "";
    L30:
        if (this.songId != null) goto L33;
        this.songId = null;
    L33:
        if (this.videoInfo != null) goto L36;
        this.videoInfo = null;
    L36:
        if (this.mvInfo != null) goto L39;
        this.mvInfo = null;
    L39:
        if ((r102 & 2) != 0) goto L63;
        this.kSongUid = 0;
        return;
    }
}
