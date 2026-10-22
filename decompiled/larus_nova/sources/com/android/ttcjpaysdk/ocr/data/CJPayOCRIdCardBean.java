package com.android.ttcjpaysdk.ocr.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/CJPayOCRIdCardBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "flow_no", "id_name", "id_code", "member_biz_order_no", "id_photo_ocr_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/ocr/data/IdPhotoOcrInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "isSuccess", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOCRIdCardBean implements CJPayObject, Serializable {
    public String code;
    public String flow_no;
    public String id_code;
    public String id_name;
    public ArrayList<IdPhotoOcrInfo> id_photo_ocr_info_list;
    public String member_biz_order_no;
    public String msg;

    public CJPayOCRIdCardBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final boolean isSuccess() {
        if (Intrinsics.areEqual(this.code, "MP000000") == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.flow_no)) == false) goto L7;
        return true;
    }

    public CJPayOCRIdCardBean(String r100, String r101, String r102, String r103, String r104, String r105, ArrayList<IdPhotoOcrInfo> r106) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "flow_no");
        Intrinsics.checkNotNullParameter(r103, "id_name");
        Intrinsics.checkNotNullParameter(r104, "id_code");
        Intrinsics.checkNotNullParameter(r105, "member_biz_order_no");
        this.code = r100;
        this.msg = r101;
        this.flow_no = r102;
        this.id_name = r103;
        this.id_code = r104;
        this.member_biz_order_no = r105;
        this.id_photo_ocr_info_list = r106;
    }

    public /* synthetic */ CJPayOCRIdCardBean(String r100, String r101, String r102, String r103, String r110, String r111, ArrayList r112, int r113, DefaultConstructorMarker r114) {
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
        if ((r113 & 16) == 0) goto L21;
        String r108 = "";
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r112 = null;
    L29:
        ArrayList r116 = r112;
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L21:
        r108 = r110;
        goto L23
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
