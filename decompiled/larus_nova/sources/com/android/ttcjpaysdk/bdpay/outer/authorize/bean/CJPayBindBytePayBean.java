package com.android.ttcjpaysdk.bdpay.outer.authorize.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\tR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/CJPayBindBytePayBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "is_complete", "", "is_redirect_url_lynx", ITiktokService.ResponseConstants.REDIRECT_URL, "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;ZZLjava/lang/String;)V", "isResponseOK", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindBytePayBean implements CJPayObject, Serializable {
    public CJPayButtonInfo button_info;
    public String code;
    public boolean is_complete;
    public boolean is_redirect_url_lynx;
    public String msg;
    public String redirect_url;

    public CJPayBindBytePayBean() {
        this(null, null, null, false, false, null, 63, null);
    }

    public final boolean isResponseOK() {
        return TextUtils.equals("UM0000", this.code);
    }

    public CJPayBindBytePayBean(String r100, String r101, CJPayButtonInfo r102, boolean r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r105, ITiktokService.ResponseConstants.REDIRECT_URL);
        this.code = r100;
        this.msg = r101;
        this.button_info = r102;
        this.is_complete = r103;
        this.is_redirect_url_lynx = r104;
        this.redirect_url = r105;
    }

    public /* synthetic */ CJPayBindBytePayBean(String r100, String r101, CJPayButtonInfo r102, boolean r103, boolean r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = null;
    L13:
        CJPayButtonInfo r105 = r102;
        if ((r112 & 8) == 0) goto L16;
        boolean r106 = false;
    L18:
        if ((r112 & 16) == 0) goto L20;
        boolean r107 = false;
    L22:
        if ((r112 & 32) == 0) goto L24;
        String r115 = "";
    L25:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
