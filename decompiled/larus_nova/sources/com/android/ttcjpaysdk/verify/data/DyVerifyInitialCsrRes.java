package com.android.ttcjpaysdk.verify.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyInitialCsrRes;", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyCertBaseRes;", "sign_factor", "", "sign_factor_id", "(Ljava/lang/String;Ljava/lang/String;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyInitialCsrRes extends DyVerifyCertBaseRes {
    public String sign_factor;
    public String sign_factor_id;

    /* JADX WARN: Multi-variable type inference failed */
    public DyVerifyInitialCsrRes() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public DyVerifyInitialCsrRes(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sign_factor");
        Intrinsics.checkNotNullParameter(r101, "sign_factor_id");
        super(null, null, null, 7, null);
        this.sign_factor = r100;
        this.sign_factor_id = r101;
    }

    public /* synthetic */ DyVerifyInitialCsrRes(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
