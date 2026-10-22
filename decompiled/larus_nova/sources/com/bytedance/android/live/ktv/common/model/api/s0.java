package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdk.d9;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/s0;", "", "", "openUid", "Ljava/lang/String;", "getOpenUid", "()Ljava/lang/String;", "getOpenUid$annotations", "()V", "", "uid", "Ljava/lang/Long;", "getUid", "()Ljava/lang/Long;", "getUid$annotations", "nickName", "b", "Lpy/k;", "avatar", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "uidStr", "getUidStr", "getUidStr$annotations", "secUid", "c", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s0 implements vh7.h {

    @SerializedName("avatar")
    protected py.k avatar;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String nickName;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openUid;

    @IgnoreProtoFieldCheck
    @SerializedName("sec_uid")
    protected String secUid;

    @IgnoreProtoFieldCheck
    @SerializedName("uid")
    protected Long uid;

    @IgnoreProtoFieldCheck
    @SerializedName("uid_str")
    protected String uidStr;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L18;
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.openUid, r101.openUid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uidStr, r101.uidStr) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.openUid;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.uid;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nickName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        py.k r110 = this.avatar;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.uidStr;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.secUid;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "ReportMidiScoreResponseUserInfo(openUid=" + this.openUid + ", uid=" + this.uid + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", uidStr=" + this.uidStr + ", secUid=" + this.secUid + ")";
    }

    public final String d() {
        String r100 = d9.a(this.uidStr);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return d9.c(this.uid, this.openUid);
    }

    public s0() {
        this.openUid = null;
        this.uid = null;
        this.nickName = null;
        this.avatar = null;
        this.uidStr = null;
        this.secUid = null;
    }

    public final py.k a() {
        return this.avatar;
    }

    public final String b() {
        return this.nickName;
    }

    public final String c() {
        return this.secUid;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public s0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.uid = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.nickName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.avatar = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.uidStr = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.secUid = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this.openUid = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.openUid != null) goto L28;
        this.openUid = null;
    L28:
        if (this.uid != null) goto L31;
        this.uid = null;
    L31:
        if (this.nickName != null) goto L34;
        this.nickName = null;
    L34:
        if (this.avatar != null) goto L37;
        this.avatar = null;
    L37:
        if (this.uidStr != null) goto L40;
        this.uidStr = null;
    L40:
        if (this.secUid != null) goto L64;
        this.secUid = null;
        return;
    }
}
