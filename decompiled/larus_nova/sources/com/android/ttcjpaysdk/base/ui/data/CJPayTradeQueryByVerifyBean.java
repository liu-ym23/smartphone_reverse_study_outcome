package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayTradeQueryByVerifyBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "data", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTradeQueryByVerifyDataBean;", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/CJPayTradeQueryByVerifyDataBean;)V", "getLynxSchema", "isNeedRetry", "", "isVerifySuccess", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTradeQueryByVerifyBean implements CJPayObject, Serializable {
    public String code;
    public CJPayTradeQueryByVerifyDataBean data;
    public String msg;

    public CJPayTradeQueryByVerifyBean() {
        this(null, null, null, 7, null);
    }

    public final String getLynxSchema() {
        return this.data.lynx_url;
    }

    public final boolean isNeedRetry() {
        return Intrinsics.areEqual("CA9008", this.code);
    }

    public final boolean isVerifySuccess() {
        return Intrinsics.areEqual("CA0000", this.code);
    }

    public CJPayTradeQueryByVerifyBean(String r100, String r101, CJPayTradeQueryByVerifyDataBean r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CJPayTradeQueryByVerifyBean(String r100, String r101, CJPayTradeQueryByVerifyDataBean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new CJPayTradeQueryByVerifyDataBean(null, 1, 0 == true ? 1 : 0);
    L11:
        this(r100, r101, r102);
    }
}
