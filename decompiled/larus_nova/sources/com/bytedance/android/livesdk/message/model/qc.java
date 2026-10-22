package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/qc;", "", "", "roleId", "J", "getRoleId", "()J", "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "I", "getPos", "()I", "auditStatus", "getAuditStatus", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class qc implements vh7.h {

    @SerializedName("audit_status")
    protected int auditStatus;

    @SerializedName("avatar_thumb")
    protected py.k avatarThumb;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("nick_name")
    protected String nickName;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    protected int pos;

    @SerializedName("role_id")
    protected long roleId;

    public qc() {
        this.nickName = "";
        this.extra = "";
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public qc(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.roleId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.avatarThumb = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.nickName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.pos = (int) r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.auditStatus = r100.i();
        goto L3
    L16:
        if (r102 != 100) goto L17;
        this.extra = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.nickName != null) goto L28;
        this.nickName = "";
    L28:
        if (this.extra != null) goto L52;
        this.extra = "";
        return;
    }
}
