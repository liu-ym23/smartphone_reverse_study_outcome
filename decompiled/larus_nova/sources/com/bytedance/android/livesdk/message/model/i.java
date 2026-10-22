package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/i;", "", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "", "roleId", "J", "getRoleId", "()J", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements vh7.h {

    @SerializedName("extra")
    protected String extra;

    @SerializedName("role_id")
    protected long roleId;

    @SerializedName("user_id")
    protected String userId;

    public i() {
        this.userId = "";
        this.extra = "";
    }

    public i(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.userId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.roleId = r100.j();
        goto L3
    L10:
        if (r102 != 100) goto L11;
        this.extra = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.userId != null) goto L19;
        this.userId = "";
    L19:
        if (this.extra != null) goto L34;
        this.extra = "";
        return;
    }
}
