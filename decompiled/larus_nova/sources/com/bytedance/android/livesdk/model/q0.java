package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/model/q0;", "", "", "background", "Ljava/lang/String;", "getBackground", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "height", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "d", "(I)V", "width", "b", "e", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q0 {

    @SerializedName("background")
    private String background;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    public q0() {
    }

    public final int a() {
        return this.height;
    }

    public final int b() {
        return this.width;
    }

    public final void c(String r100) {
        this.background = r100;
    }

    public final void d(int r100) {
        this.height = r100;
    }

    public final void e(int r100) {
        this.width = r100;
    }
}
