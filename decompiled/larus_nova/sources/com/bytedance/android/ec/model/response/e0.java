package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/response/e0;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "text", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "animIcon", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnimIcon", "animText", "b", "setAnimText", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("anim_icon")
    private ECUrlModel animIcon;

    @SerializedName("anim_text")
    private String animText;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("text")
    private String text;

    public e0() {
    }

    public final ECUrlModel a() {
        return this.animIcon;
    }

    public final String b() {
        return this.animText;
    }

    public final ECUrlModel c() {
        return this.icon;
    }

    public final String d() {
        return this.text;
    }
}
