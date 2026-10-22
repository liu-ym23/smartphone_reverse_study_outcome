package com.bytedance.android.live.base.model.data;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/base/model/data/d;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "userInfo", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUserInfo", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "roomId", "J", "d", "()J", "setRoomId", "(J)V", "", "status", "I", "e", "()I", "setStatus", "(I)V", "role", "c", "setRole", "minRejoinTime", "b", "setMinRejoinTime", "maxRejoinTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setMaxRejoinTime", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements vh7.h {

    @SerializedName("max_rejoin_time")
    protected long maxRejoinTime;

    @SerializedName("min_rejoin_time")
    protected long minRejoinTime;

    @SerializedName("role")
    protected int role;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("status")
    protected int status;

    @SerializedName("user")
    protected IBaseUser userInfo;

    public final String toString() {
        return "[" + this.roomId + ", " + this.status + ']';
    }

    public d() {
        this.status = 1;
    }

    public final long a() {
        return this.maxRejoinTime;
    }

    public final long b() {
        return this.minRejoinTime;
    }

    public final int c() {
        return this.role;
    }

    public final long d() {
        return this.roomId;
    }

    public final int e() {
        return this.status;
    }

    public final IBaseUser f() {
        return this.userInfo;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public d(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.maxRejoinTime = r100.j();
        goto L3
    L8:
        this.minRejoinTime = r100.j();
        goto L3
    L9:
        this.role = (int) r100.j();
        goto L3
    L10:
        this.status = (int) r100.j();
        r102 = r102 | true;
        goto L3
    L11:
        this.roomId = r100.j();
        goto L3
    L12:
        this.userInfo = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if ((r102 & true) == true) goto L33;
        this.status = 1;
        return;
    }
}
