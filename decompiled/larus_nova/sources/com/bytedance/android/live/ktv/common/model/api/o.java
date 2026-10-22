package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/o;", "", "", "", "successUids", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setSuccessUids", "(Ljava/util/List;)V", "toast", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o implements vh7.h {

    @SerializedName("success_uids")
    protected List<String> successUids;

    @SerializedName("toast")
    protected String toast;

    public o() {
    }

    public o(am3.g r100) {
        this.successUids = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.successUids.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.toast = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final List<String> a() {
        return this.successUids;
    }

    public final String b() {
        return this.toast;
    }
}
