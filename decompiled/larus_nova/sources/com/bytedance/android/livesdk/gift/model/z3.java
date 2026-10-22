package com.bytedance.android.livesdk.gift.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/z3;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "sendActionText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setSendActionText", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z3 implements vh7.h {

    @SerializedName("send_action_text")
    protected String sendActionText;

    @SerializedName("title")
    protected String title;

    public z3() {
        this.title = "";
        this.sendActionText = "";
    }

    public final String a() {
        return this.sendActionText;
    }

    public z3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 3) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 5) goto L9;
        this.sendActionText = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.title != null) goto L16;
        this.title = "";
    L16:
        if (this.sendActionText != null) goto L28;
        this.sendActionText = "";
        return;
    }
}
