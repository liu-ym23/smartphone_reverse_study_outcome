package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "toast")
public final class ed extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("image")
        String image;

        @SerializedName("position")
        int position;

        @SerializedName("status")
        String status;

        @SerializedName("text")
        String text;

        @SerializedName("type")
        String type;

        @SerializedName("useOriginalToast")
        Boolean useOriginalToast;

        public a() {
            this.useOriginalToast = Boolean.FALSE;
        }
    }

    public ed() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        if (TextUtils.isEmpty(r102.type) == false) goto L6;
        r102.type = EventConstant.Key.RETAIN_PROMPT;
    L6:
        if (TextUtils.equals("icon", r102.type) == false) goto L9;
        HashMap r103 = new HashMap();
        r103.put("status", r102.status);
        r103.put("text", r102.text);
        ((IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class)).centerIconToast(r101.getContext(), r103);
    L23:
        return null;
    L9:
        if (TextUtils.equals(EventConstant.Key.RETAIN_PROMPT, r102.type) == false) goto L15;
        if (r102.position != 1) goto L13;
        com.bytedance.android.live.core.utils.f2.c(r102.text, 0);
        goto L23
    L13:
        IESUIUtils.displayToast(r101.getContext(), r102.text);
        goto L23
    L15:
        if (TextUtils.equals("image", r102.type) == false) goto L23;
        byte[] r104 = Base64.decode(r102.image.split(",")[1], 0);     // Catch: Exception -> L19
        Bitmap r105 = BitmapFactory.decodeByteArray(r104, 0, r104.length);     // Catch: Exception -> L19
    L21:
        if (r105 == null) goto L23;
        String r106 = rm3.c.f538539a;
        rm3.c.c(r101.getContext(), r102.text, new BitmapDrawable(r105));
    L19:
        e = move-exception;
        e.printStackTrace();
        r105 = null;
        goto L21
    }
}
