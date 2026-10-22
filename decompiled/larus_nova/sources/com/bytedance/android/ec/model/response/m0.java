package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/m0;", "", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "c", "setTextColor", "backgroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBackgroundColor", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    public m0() {
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final String b() {
        return this.text;
    }

    public final String c() {
        return this.textColor;
    }
}
