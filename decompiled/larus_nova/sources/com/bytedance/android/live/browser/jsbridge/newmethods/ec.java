package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public final class ec extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseWebDialogFragment f63363a;

    public static final class a {

        @SerializedName("args")
        C1040a args;

        @SerializedName("type")
        String type;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.ec$a$a, reason: collision with other inner class name */
        public static final class C1040a {

            @SerializedName("close_by_mask")
            int close_by_mask;

            @SerializedName("height")
            int height;

            @SerializedName("radius")
            int radius;

            @SerializedName("url")
            String url;

            @SerializedName("width")
            int width;

            public C1040a() {
            }
        }

        public a() {
        }
    }

    public ec(WebDialogFragmentForAnnie r100) {
        this.f63363a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        if (TextUtils.equals(AppConstants.HOST_WEBVIEW_DIALOG, r102.type) == false) goto L6;
        a.C1040a r103 = r102.args;
        this.f63363a.W90(r103.url, r103.width, r103.height, r103.radius, r103.close_by_mask, BaseHybridParamVo.HybridType.H5);
        return null;
    L6:
        if (TextUtils.equals("lynxview_popup", r102.type) == false) goto L8;
        a.C1040a r104 = r102.args;
        this.f63363a.W90(r104.url, r104.width, r104.height, r104.radius, r104.close_by_mask, BaseHybridParamVo.HybridType.LYNX);
        return null;
    L8:
        terminate();
        return null;
    }
}
