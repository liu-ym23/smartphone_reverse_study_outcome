package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/mb1;", "", "", "agreement_show", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAgreement_show", "(Z)V", "", "agreement_url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setAgreement_url", "(Ljava/lang/String;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class mb1 {

    @SerializedName("agreement_show")
    private boolean agreement_show;

    @SerializedName("agreement_url")
    private String agreement_url;

    public mb1() {
        this.agreement_url = "sslocal://webcast_webview/?url=https://lf3-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/douyin_agreement/0e67167e-b721-4fc4-bcc9-11b5a4a6f71a.html&mix_container_type=anniex";
    }

    public final boolean a() {
        return this.agreement_show;
    }

    public final String b() {
        return this.agreement_url;
    }
}
