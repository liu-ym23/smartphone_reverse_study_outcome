package com.bytedance.android.live.cloudgrouplive.model;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/model/c;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/cloudgrouplive/model/b;", "rtcInfo", "Lcom/bytedance/android/live/cloudgrouplive/model/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/cloudgrouplive/model/b;", "", "roomIdStr", "Ljava/lang/String;", "getRoomIdStr", "()Ljava/lang/String;", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements h {

    @SerializedName("room_id_str")
    protected String roomIdStr;

    @SerializedName("rtc_info")
    protected b rtcInfo;

    @SerializedName("user")
    protected IBaseUser user;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public c(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.user = f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rtcInfo = new b(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.roomIdStr = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final b a() {
        return this.rtcInfo;
    }
}
