package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/mf1;", "", "", "detectCount", "I", "b", "()I", "setDetectCount", "(I)V", "rttThreshold", "d", "setRttThreshold", "minCount", "c", "setMinCount", "", "assignLeadDetect", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAssignLeadDetect", "(Z)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class mf1 {

    @SerializedName("assign_lead_need_detect")
    private boolean assignLeadDetect;

    @SerializedName("detect_count")
    private int detectCount;

    @SerializedName("min_people")
    private int minCount;

    @SerializedName("rtt_threshold")
    private int rttThreshold;

    public mf1() {
        this.detectCount = 2;
        this.rttThreshold = 200;
        this.minCount = 3;
        this.assignLeadDetect = true;
    }

    public final boolean a() {
        return this.assignLeadDetect;
    }

    public final int b() {
        return this.detectCount;
    }

    public final int c() {
        return this.minCount;
    }

    public final int d() {
        return this.rttThreshold;
    }
}
