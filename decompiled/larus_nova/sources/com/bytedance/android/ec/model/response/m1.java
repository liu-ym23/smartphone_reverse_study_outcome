package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/android/ec/model/response/m1;", "", "", "buttonLabel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setButtonLabel", "(Ljava/lang/String;)V", "", "style", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "setStyle", "(Ljava/lang/Long;)V", "maskStyle", "d", "setMaskStyle", "Lcom/bytedance/android/ec/model/response/j0;", "action", "Lcom/bytedance/android/ec/model/response/j0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/j0;", "setAction", "(Lcom/bytedance/android/ec/model/response/j0;)V", "Lcom/bytedance/android/ec/model/response/s1;", "click", "Lcom/bytedance/android/ec/model/response/s1;", "c", "()Lcom/bytedance/android/ec/model/response/s1;", "setClick", "(Lcom/bytedance/android/ec/model/response/s1;)V", "show", "e", "setShow", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class m1 {

    @SerializedName("action")
    private j0 action;

    @SerializedName("button_label")
    private String buttonLabel;

    @SerializedName("click")
    private s1 click;

    @SerializedName("mask_style")
    private Long maskStyle;

    @SerializedName("show")
    private s1 show;

    @SerializedName("style")
    private Long style;

    public m1() {
    }

    public final j0 a() {
        return this.action;
    }

    public final String b() {
        return this.buttonLabel;
    }

    public final s1 c() {
        return this.click;
    }

    public final Long d() {
        return this.maskStyle;
    }

    public final s1 e() {
        return this.show;
    }

    public final Long f() {
        return this.style;
    }
}
