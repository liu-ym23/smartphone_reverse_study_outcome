package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s6;", "", "", "rate", "D", "getRate", "()D", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "endTime", "getEndTime", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s6 implements vh7.h {

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("rate")
    protected double rate;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    public s6() {
        this.rate = 1.0d;
        this.extra = "";
    }

    public s6(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.rate = Double.longBitsToDouble(r100.h());
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.startTime = r100.j();
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.endTime = r100.j();
        goto L3
    L11:
        if (r103 != 100) goto L12;
        this.extra = am3.h.c(r100);
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & true) == true) goto L21;
        this.rate = 1.0d;
    L21:
        if (this.extra != null) goto L39;
        this.extra = "";
        return;
    }
}
