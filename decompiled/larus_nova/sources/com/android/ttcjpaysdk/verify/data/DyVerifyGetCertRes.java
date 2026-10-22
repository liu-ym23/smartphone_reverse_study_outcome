package com.android.ttcjpaysdk.verify.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyGetCertRes;", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyCertBaseRes;", "cert_data", "", "(Ljava/lang/String;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyGetCertRes extends DyVerifyCertBaseRes {
    public String cert_data;

    /* JADX WARN: Multi-variable type inference failed */
    public DyVerifyGetCertRes() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DyVerifyGetCertRes(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cert_data");
        super(null, null, null, 7, null);
        this.cert_data = r100;
    }

    public /* synthetic */ DyVerifyGetCertRes(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
