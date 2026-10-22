package com.android.ttcjpaysdk.largeamount.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/largeamount/bean/CJPayFetchVerifyBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "data", "Lcom/android/ttcjpaysdk/largeamount/bean/CJPayMemberVerifyBean;", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/largeamount/bean/CJPayMemberVerifyBean;)V", "isSuccess", "", "base-pay-largeamount_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFetchVerifyBean implements CJPayObject, Serializable {
    public String code;
    public CJPayMemberVerifyBean data;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayFetchVerifyBean() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual("CA0000", this.code);
    }

    public CJPayFetchVerifyBean(String r100, CJPayMemberVerifyBean r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.code = r100;
        this.data = r101;
    }

    public /* synthetic */ CJPayFetchVerifyBean(String r100, CJPayMemberVerifyBean r101, int r102, DefaultConstructorMarker r110) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new CJPayMemberVerifyBean(null, null, null, 7, null);
    L8:
        this(r100, r101);
    }
}
