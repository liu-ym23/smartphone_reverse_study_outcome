package com.android.ttcjpaysdk.largeamount.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayVerifyIdentityInfo;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/largeamount/bean/CJPayMemberVerifyBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "face_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", SendClosePdpEventParam.KEY_LYNX_URL, "", "verify_identity", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayVerifyIdentityInfo;", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayVerifyIdentityInfo;)V", "base-pay-largeamount_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayMemberVerifyBean implements CJPayObject, Serializable {
    public CJPayFaceVerifyInfo face_verify_info;
    public String lynx_url;
    public CJPayVerifyIdentityInfo verify_identity;

    public CJPayMemberVerifyBean() {
        this(null, null, null, 7, null);
    }

    public CJPayMemberVerifyBean(CJPayFaceVerifyInfo r100, String r101, CJPayVerifyIdentityInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "face_verify_info");
        Intrinsics.checkNotNullParameter(r101, SendClosePdpEventParam.KEY_LYNX_URL);
        Intrinsics.checkNotNullParameter(r102, "verify_identity");
        this.face_verify_info = r100;
        this.lynx_url = r101;
        this.verify_identity = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CJPayMemberVerifyBean(CJPayFaceVerifyInfo r210, String r211, CJPayVerifyIdentityInfo r212, int r310, DefaultConstructorMarker r311) {
        if ((r310 & 1) == 0) goto L5;
        CJPayFaceVerifyInfo r100 = new CJPayFaceVerifyInfo(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = null;
        Object[] r103 = 0 == true ? 1 : 0;
        CJPayVerifyIdentityInfo r104 = new CJPayVerifyIdentityInfo(r102, r103, 3, 0 == true ? 1 : 0);
    L14:
        this(r100, r101, r104);
        return;
    L13:
        r104 = r212;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
