package com.android.ttcjpaysdk.bdpay.outer.authorize.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/CJPayBindAuthorizeBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "authorize_brief_info", "Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/AuthorizeBriefInfo;", "protocol_group_contents", "Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/ProtocolGroupContents;", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/AuthorizeBriefInfo;Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/ProtocolGroupContents;)V", "isResponseOK", "", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindAuthorizeBean implements CJPayObject, Serializable {
    public AuthorizeBriefInfo authorize_brief_info;
    public String code;
    public String msg;
    public ProtocolGroupContents protocol_group_contents;

    public CJPayBindAuthorizeBean() {
        this(null, null, null, null, 15, null);
    }

    public final boolean isResponseOK() {
        return TextUtils.equals("UM0000", this.code);
    }

    public CJPayBindAuthorizeBean(String r100, String r101, AuthorizeBriefInfo r102, ProtocolGroupContents r103) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "authorize_brief_info");
        Intrinsics.checkNotNullParameter(r103, "protocol_group_contents");
        this.code = r100;
        this.msg = r101;
        this.authorize_brief_info = r102;
        this.protocol_group_contents = r103;
    }

    public /* synthetic */ CJPayBindAuthorizeBean(String r100, String r110, AuthorizeBriefInfo r111, ProtocolGroupContents r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r113 & 2) == 0) goto L9;
        r110 = "";
    L9:
        if ((r113 & 4) == 0) goto L12;
        r111 = new AuthorizeBriefInfo(null, null, 3, null);
    L12:
        if ((r113 & 8) == 0) goto L14;
        r112 = new ProtocolGroupContents(null, null, null, null, null, 31, null);
    L14:
        this(r100, r110, r111, r112);
    }
}
