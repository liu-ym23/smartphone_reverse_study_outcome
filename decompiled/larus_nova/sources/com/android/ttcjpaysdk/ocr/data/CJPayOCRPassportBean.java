package com.android.ttcjpaysdk.ocr.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/CJPayOCRPassportBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "flow_no", "member_biz_order_no", "hit_ps_process", "need_double_verify", "", "passport_ocr_info", "Lcom/android/ttcjpaysdk/ocr/data/PassportOcrInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/android/ttcjpaysdk/ocr/data/PassportOcrInfo;)V", "isSuccess", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOCRPassportBean implements CJPayObject, Serializable {
    public String code;
    public String flow_no;
    public String hit_ps_process;
    public String member_biz_order_no;
    public String msg;
    public boolean need_double_verify;
    public PassportOcrInfo passport_ocr_info;

    public CJPayOCRPassportBean() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    public final boolean isSuccess() {
        if (Intrinsics.areEqual(this.code, "MP000000") == true) goto L5;
        return false;
    L5:
        if (this.member_biz_order_no.length() <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public CJPayOCRPassportBean(String r100, String r101, String r102, String r103, String r104, boolean r105, PassportOcrInfo r106) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "flow_no");
        Intrinsics.checkNotNullParameter(r103, "member_biz_order_no");
        Intrinsics.checkNotNullParameter(r104, "hit_ps_process");
        this.code = r100;
        this.msg = r101;
        this.flow_no = r102;
        this.member_biz_order_no = r103;
        this.hit_ps_process = r104;
        this.need_double_verify = r105;
        this.passport_ocr_info = r106;
    }

    public /* synthetic */ CJPayOCRPassportBean(String r100, String r101, String r102, String r103, String r110, boolean r111, PassportOcrInfo r112, int r113, DefaultConstructorMarker r114) {
        String r104 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r113 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r113 & 32) == 0) goto L25;
        boolean r108 = false;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r112 = null;
    L29:
        PassportOcrInfo r116 = r112;
        this(r115, r105, r106, r107, r104, r108, r116);
        return;
    L25:
        r108 = r111;
        goto L27
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
