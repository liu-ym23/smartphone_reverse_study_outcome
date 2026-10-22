package com.bytedance.android.livesdk.player.stratege;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/c;", "", "", "sr_enable", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setSr_enable", "(Ljava/lang/Integer;)V", "sr_type", "d", "setSr_type", "sr_sharpen_level", "c", "setSr_sharpen_level", "", "operate_reason", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setOperate_reason", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("operate_reason")
    private String operate_reason;

    @SerializedName("sr_enable")
    private Integer sr_enable;

    @SerializedName("sr_sharpen_level")
    private Integer sr_sharpen_level;

    @SerializedName("sr_type")
    private Integer sr_type;

    public c() {
        this.sr_enable = -1;
        this.sr_type = -1;
        this.sr_sharpen_level = -1;
        this.operate_reason = "";
    }

    public final String a() {
        return this.operate_reason;
    }

    public final Integer b() {
        return this.sr_enable;
    }

    public final Integer c() {
        return this.sr_sharpen_level;
    }

    public final Integer d() {
        return this.sr_type;
    }
}
