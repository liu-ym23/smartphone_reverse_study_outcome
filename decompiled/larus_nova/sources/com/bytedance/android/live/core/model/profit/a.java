package com.bytedance.android.live.core.model.profit;

import am3.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/core/model/profit/a;", "", "", "leftTime", "I", "getLeftTime", "()I", "setLeftTime", "(I)V", "", "popupText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setPopupText", "(Ljava/lang/String;)V", "", "needFaceDetect", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setNeedFaceDetect", "(Z)V", "verified", "getVerified", "setVerified", "verifyType", "getVerifyType", "setVerifyType", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("left_time_second")
    protected int leftTime;

    @SerializedName("need_face_recognition")
    protected boolean needFaceDetect;

    @SerializedName("popup_text")
    protected String popupText;

    @SerializedName("two_elements_verified")
    protected boolean verified;

    @SerializedName("verify_type")
    protected int verifyType;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.model.profit.a$a, reason: collision with other inner class name */
    public static final class C1067a {
    }

    static {
    }

    public a() {
    }

    public final String toString() {
        return "DSLimitCalmPeriod{leftTime=" + this.leftTime + ", popupText='" + this.popupText + "', needFaceDetect=" + this.needFaceDetect + '}';
    }

    public final boolean a() {
        return this.needFaceDetect;
    }

    public final String b() {
        return this.popupText;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.leftTime = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.popupText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.needFaceDetect = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.verified = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.verifyType = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
