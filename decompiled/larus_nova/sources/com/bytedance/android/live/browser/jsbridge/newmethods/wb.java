package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/wb;", "", "", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "color", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setColor", "", "isFold", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setFold", "(Ljava/lang/Boolean;)V", "isSkipWait", "d", "setSkipWait", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wb {

    @SerializedName("color")
    private String color;

    @SerializedName("content")
    private String content;

    @SerializedName("isFold")
    private Boolean isFold;

    @SerializedName("isSkipWait")
    private Boolean isSkipWait;

    public wb() {
    }

    public final String a() {
        return this.color;
    }

    public final String b() {
        return this.content;
    }

    public final Boolean c() {
        return this.isFold;
    }

    public final Boolean d() {
        return this.isSkipWait;
    }
}
