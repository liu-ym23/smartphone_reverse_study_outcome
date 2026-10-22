package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayForgetPwdBtnInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "icon_url", "", "action", "schema", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, CJPayJsonParser.ORIGINAL_JSON_KEY, "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "isRecommendFacePay", "", "isRecommendFaceVerify", "needShowCPMDialog", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayForgetPwdBtnInfo implements CJPayObject, Serializable {
    public String action;
    public String icon_url;
    public String lynx_schema;
    public JSONObject originalJson;
    public String schema;

    public CJPayForgetPwdBtnInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public final boolean isRecommendFacePay() {
        return Intrinsics.areEqual(this.action, "forget_pwd_recommend_face_pay");
    }

    public final boolean isRecommendFaceVerify() {
        if (Intrinsics.areEqual(this.action, "forget_pwd_recommend_face_verify") == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.schema)) == false) goto L7;
        return true;
    }

    public final boolean needShowCPMDialog() {
        return !TextUtils.isEmpty(this.lynx_schema);
    }

    public CJPayForgetPwdBtnInfo(String r100, String r101, String r102, String r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, "icon_url");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY);
        this.icon_url = r100;
        this.action = r101;
        this.schema = r102;
        this.lynx_schema = r103;
        this.originalJson = r104;
    }

    public /* synthetic */ CJPayForgetPwdBtnInfo(String r100, String r101, String r102, String r103, JSONObject r104, int r105, DefaultConstructorMarker r110) {
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
        r104 = null;
    L21:
        JSONObject r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
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
