package com.bytedance.android.live.profit.lottery.model;

import am3.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/model/a;", "", "", "candidateState", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setCandidateState", "(I)V", "", "extra", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "<init>", "()V", "liveprofit-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("candidate_state")
    protected int candidateState;

    @SerializedName("extra")
    protected String extra;

    public a() {
    }

    public final int a() {
        return this.candidateState;
    }

    public final String b() {
        return this.extra;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.candidateState = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.extra = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
