package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/model/response/o;", "Lcom/bytedance/android/ec/model/g;", "", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "setPromotionId", "(Ljava/lang/String;)V", "msgTemplate", "c", "setMsgTemplate", "", "nextTick", "I", "e", "()I", "setNextTick", "(I)V", "", "nextReleaseTime", "J", "d", "()J", "setNextReleaseTime", "(J)V", "countDownMinute", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCountDownMinute", "hasStock", "b", "setHasStock", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class o extends com.bytedance.android.ec.model.g {

    @SerializedName("count_down_minute")
    private long countDownMinute;

    @SerializedName("has_stock")
    private int hasStock;

    @SerializedName("msg_template")
    private String msgTemplate;

    @SerializedName("next_release_time")
    private long nextReleaseTime;

    @SerializedName("next_tick")
    private int nextTick;

    @SerializedName("promotion_id")
    private String promotionId;

    public o() {
        this.msgTemplate = "";
    }

    public final long a() {
        return this.countDownMinute;
    }

    public final int b() {
        return this.hasStock;
    }

    public final String c() {
        return this.msgTemplate;
    }

    public final long d() {
        return this.nextReleaseTime;
    }

    public final int e() {
        return this.nextTick;
    }
}
