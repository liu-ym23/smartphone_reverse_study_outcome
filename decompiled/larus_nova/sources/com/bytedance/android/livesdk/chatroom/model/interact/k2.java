package com.bytedance.android.livesdk.chatroom.model.interact;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/k2;", "", "", "rtcExtInfo", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "liveCoreExtInfo", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "rtcUserId", "b", "setRtcUserId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k2 implements vh7.h {

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    @SerializedName("rtc_user_id")
    protected String rtcUserId;

    public k2() {
    }

    public k2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.rtcExtInfo = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.liveCoreExtInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.rtcUserId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String toString() {
        return "InitRTCResponse(rtcExtInfo=" + this.rtcExtInfo + ", liveCoreExtInfo='" + this.liveCoreExtInfo + "', rtcUserId='" + this.rtcUserId + "')";
    }

    public final String a() {
        return this.rtcExtInfo;
    }

    public final String b() {
        return this.rtcUserId;
    }
}
