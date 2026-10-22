package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/a;", "Lcom/bytedance/android/live/base/model/Extra;", "Lcom/bytedance/revenue/platform/api/network/Extra;", "Lcom/bytedance/android/livesdk/link/model/g0;", "mLogPb", "Lcom/bytedance/android/livesdk/link/model/g0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/link/model/g0;", "setMLogPb", "(Lcom/bytedance/android/livesdk/link/model/g0;)V", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a extends Extra implements vh7.h {

    @SerializedName("log_pb")
    protected g0 mLogPb;

    public a() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.g0, java.lang.Object] */
    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.mLogPb = vh7.f.a(r100, g0.class);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final g0 a() {
        return this.mLogPb;
    }
}
