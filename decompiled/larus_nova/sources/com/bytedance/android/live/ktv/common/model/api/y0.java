package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/y0;", "", "", EventConstant.Key.RETAIN_PROMPT, "Ljava/lang/String;", "getPrompt", "()Ljava/lang/String;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y0 implements vh7.h {

    @SerializedName("prompts")
    protected String prompt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.prompt, ((y0) r100).prompt) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.prompt;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "UpdateSingerStateResponse(prompt=" + this.prompt + ")";
    }

    public y0() {
        this.prompt = "";
    }

    public y0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.prompt = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.prompt != null) goto L19;
        this.prompt = "";
        return;
    }
}
