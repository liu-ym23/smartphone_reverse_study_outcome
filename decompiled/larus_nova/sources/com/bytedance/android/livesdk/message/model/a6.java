package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.HighValueUserData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/a6;", "", "", "userId", "J", "getUserId", "()J", "", "openId", "Ljava/lang/String;", "getOpenId", "()Ljava/lang/String;", "", "value", "Z", "b", "()Z", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a6 implements vh7.h {

    @SerializedName("user_open_id")
    protected String openId;

    @SerializedName("user_id")
    protected long userId;

    @SerializedName("is_high_value_user")
    protected boolean value;

    public final String a() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.userId);
        String r102 = this.openId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public a6() {
        this.openId = "0";
    }

    public final boolean b() {
        return this.value;
    }

    public a6(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.value = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this.openId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.openId != null) goto L31;
        this.openId = "0";
        return;
    }
}
