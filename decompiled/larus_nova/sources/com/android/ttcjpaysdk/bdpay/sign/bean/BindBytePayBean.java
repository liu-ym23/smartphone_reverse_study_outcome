package com.android.ttcjpaysdk.bdpay.sign.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/bean/BindBytePayBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "status", "", "code", "msg", "remain_retry_count", "", "remain_lock_time", "remain_lock_desc", "button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "sign_status", "result_desc", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/ResultDescBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/bdpay/sign/bean/ResultDescBean;)V", "isResponseOK", "", "()Z", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindBytePayBean implements CJPayObject, Serializable {
    public CJPayButtonInfo button_info;
    public String code;
    public String msg;
    public String remain_lock_desc;
    public int remain_lock_time;
    public int remain_retry_count;
    public ResultDescBean result_desc;
    public String sign_status;
    public String status;

    public BindBytePayBean() {
        this(null, null, null, 0, 0, null, null, null, null, 511, null);
    }

    public final boolean isResponseOK() {
        return TextUtils.equals("MP000000", this.code);
    }

    public BindBytePayBean(String r100, String r101, String r102, int r103, int r104, String r105, CJPayButtonInfo r106, String r107, ResultDescBean r110) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r105, "remain_lock_desc");
        Intrinsics.checkNotNullParameter(r106, "button_info");
        Intrinsics.checkNotNullParameter(r107, "sign_status");
        Intrinsics.checkNotNullParameter(r110, "result_desc");
        this.status = r100;
        this.code = r101;
        this.msg = r102;
        this.remain_retry_count = r103;
        this.remain_lock_time = r104;
        this.remain_lock_desc = r105;
        this.button_info = r106;
        this.sign_status = r107;
        this.result_desc = r110;
    }

    public /* synthetic */ BindBytePayBean(String r110, String r111, String r112, int r210, int r211, String r212, CJPayButtonInfo r213, String r214, ResultDescBean r215, int r216, DefaultConstructorMarker r217) {
        String r100 = "";
        if ((r216 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = "";
    L14:
        int r104 = 0;
        if ((r216 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r216 & 16) != 0) goto L23;
        r104 = r211;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r216 & 64) == 0) goto L29;
        CJPayButtonInfo r107 = new CJPayButtonInfo();
    L31:
        if ((r216 & 128) != 0) goto L35;
        r100 = r214;
    L35:
        if ((r216 & 256) == 0) goto L37;
        ResultDescBean r108 = new ResultDescBean(null, null, null, null, 0, 31, null);
    L38:
        this(r101, r102, r103, r105, r104, r106, r107, r100, r108);
        return;
    L37:
        r108 = r215;
        goto L38
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L17:
        r105 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
