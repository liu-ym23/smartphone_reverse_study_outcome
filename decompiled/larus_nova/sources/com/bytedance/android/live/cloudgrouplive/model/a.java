package com.bytedance.android.live.cloudgrouplive.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.anchor.AcceptCloudCollaborateResp.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/model/a;", "", "Lcom/bytedance/android/live/cloudgrouplive/model/c;", "userInfo", "Lcom/bytedance/android/live/cloudgrouplive/model/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/cloudgrouplive/model/c;", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("user_info")
    protected c userInfo;

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.userInfo = new c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final c a() {
        return this.userInfo;
    }
}
