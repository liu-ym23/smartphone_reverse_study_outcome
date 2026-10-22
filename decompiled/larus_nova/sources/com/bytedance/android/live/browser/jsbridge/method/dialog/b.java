package com.bytedance.android.live.browser.jsbridge.method.dialog;

import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends g<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseWebDialogFragment f63226a;

    public static final class a {

        @SerializedName("enable_to_full")
        int enableToFull;

        @SerializedName("enable_to_half")
        int enableToHalf;

        @SerializedName("show_close_icon")
        int showCloseIcon;

        public a() {
        }
    }

    public b(WebDialogFragmentForAnnie r100) {
        this.f63226a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        BaseWebDialogFragment r103 = this.f63226a;
        boolean r104 = false;
        if (r102.enableToHalf != 1) goto L5;
        boolean r105 = true;
    L6:
        r103.V90(r105);
        BaseWebDialogFragment r106 = this.f63226a;
        if (r102.enableToFull != 1) goto L9;
        boolean r107 = true;
    L10:
        r106.U90(r107);
        BaseWebDialogFragment r108 = this.f63226a;
        if (r102.showCloseIcon != 1) goto L13;
        r104 = true;
    L13:
        r108.X90(r104);
        return null;
    L9:
        r107 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }
}
