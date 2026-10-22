package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/r;", "", "", "id", "J", "getId", "()J", "Lcom/bytedance/android/live/ktv/common/model/api/m0;", "own_room", "Lcom/bytedance/android/live/ktv/common/model/api/m0;", "c", "()Lcom/bytedance/android/live/ktv/common/model/api/m0;", "", InstantPlayContext.NICKNAME, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lpy/k;", "avatar_thumb", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "", "secret", "I", "getSecret", "()I", "sec_uid", "getSec_uid", "id_str", "getId_str", "text", "d", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r implements vh7.h {

    @SerializedName("avatar_thumb")
    protected py.k avatar_thumb;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f69986id;

    @SerializedName("id_str")
    protected String id_str;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String nickname;

    @SerializedName("own_room")
    protected m0 own_room;

    @SerializedName("sec_uid")
    protected String sec_uid;

    @SerializedName("secret")
    protected int secret;

    @SerializedName("text")
    protected String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L22;
        r r101 = (r) r100;
        if (this.f69986id == r101.f69986id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.own_room, r101.own_room) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar_thumb, r101.avatar_thumb) == true) goto L14;
        return false;
    L14:
        if (this.secret == r101.secret) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.sec_uid, r101.sec_uid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.id_str, r101.id_str) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f69986id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        m0 r102 = this.own_room;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.nickname;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        py.k r109 = this.avatar_thumb;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.secret) * 31;
        String r112 = this.sec_uid;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.id_str;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.text;
        if (r118 == null) goto L26;
        r103 = r118.hashCode();
    L26:
        return r117 + r103;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
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
        return "GroupUser(id=" + this.f69986id + ", own_room=" + this.own_room + ", nickname=" + this.nickname + ", avatar_thumb=" + this.avatar_thumb + ", secret=" + this.secret + ", sec_uid=" + this.sec_uid + ", id_str=" + this.id_str + ", text=" + this.text + ")";
    }

    public r() {
        this.f69986id = 0;
        this.own_room = null;
        this.nickname = null;
        this.avatar_thumb = null;
        this.secret = 0;
        this.sec_uid = null;
        this.id_str = null;
        this.text = null;
    }

    public final py.k a() {
        return this.avatar_thumb;
    }

    public final String b() {
        return this.nickname;
    }

    public final m0 c() {
        return this.own_room;
    }

    public final String d() {
        return this.text;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, py.k] */
    public r(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.text = am3.h.c(r100);
        goto L3
    L8:
        this.id_str = am3.h.c(r100);
        goto L3
    L9:
        this.sec_uid = am3.h.c(r100);
        goto L3
    L10:
        this.secret = r100.i();
        r102 = r102 | 2;
        goto L3
    L11:
        this.own_room = new m0(r100);
        goto L3
    L12:
        this.avatar_thumb = vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        this.nickname = am3.h.c(r100);
        goto L3
    L14:
        this.f69986id = r100.j();
        r102 = r102 | 1;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L19;
        this.f69986id = 0;
    L19:
        if (this.own_room != null) goto L22;
        this.own_room = null;
    L22:
        if (this.nickname != null) goto L25;
        this.nickname = null;
    L25:
        if (this.avatar_thumb != null) goto L28;
        this.avatar_thumb = null;
    L28:
        if ((r102 & 2) != 0) goto L31;
        this.secret = 0;
    L31:
        if (this.sec_uid != null) goto L34;
        this.sec_uid = null;
    L34:
        if (this.id_str != null) goto L37;
        this.id_str = null;
    L37:
        if (this.text != null) goto L60;
        this.text = null;
        return;
    }
}
