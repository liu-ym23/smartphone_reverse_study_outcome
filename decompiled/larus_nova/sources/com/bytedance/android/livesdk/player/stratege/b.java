package com.bytedance.android.livesdk.player.stratege;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/b;", "", "", "sharpen_enable", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setSharpen_enable", "(Ljava/lang/Integer;)V", "sharpen_level", "c", "setSharpen_level", "", "operate_reason", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setOperate_reason", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("operate_reason")
    private String operate_reason;

    @SerializedName("sharpen_enable")
    private Integer sharpen_enable;

    @SerializedName("sharpen_level")
    private Integer sharpen_level;

    public b() {
        this.sharpen_enable = -1;
        this.sharpen_level = -1;
        this.operate_reason = "";
    }

    public final String a() {
        return this.operate_reason;
    }

    public final Integer b() {
        return this.sharpen_enable;
    }

    public final Integer c() {
        return this.sharpen_level;
    }
}
