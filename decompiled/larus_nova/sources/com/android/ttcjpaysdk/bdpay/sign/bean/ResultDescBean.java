package com.android.ttcjpaysdk.bdpay.sign.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/bean/ResultDescBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "sign_status", "", "sign_status_desc", "service_name", "sign_fail_reason", "remain_time", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResultDescBean implements CJPayObject, Serializable {
    public int remain_time;
    public String service_name;
    public String sign_fail_reason;
    public String sign_status;
    public String sign_status_desc;

    public ResultDescBean() {
        this(null, null, null, null, 0, 31, null);
    }

    public ResultDescBean(String r100, String r101, String r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "sign_status");
        Intrinsics.checkNotNullParameter(r101, "sign_status_desc");
        Intrinsics.checkNotNullParameter(r102, "service_name");
        Intrinsics.checkNotNullParameter(r103, "sign_fail_reason");
        this.sign_status = r100;
        this.sign_status_desc = r101;
        this.service_name = r102;
        this.sign_fail_reason = r103;
        this.remain_time = r104;
    }

    public /* synthetic */ ResultDescBean(String r100, String r101, String r102, String r103, int r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = "";
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = -1;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
