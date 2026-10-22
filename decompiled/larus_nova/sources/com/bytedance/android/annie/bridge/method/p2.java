package com.bytedance.android.annie.bridge.method;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "toast")
public final class p2 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

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

    public p2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        if (TextUtils.isEmpty(r102.type) == false) goto L6;
        r102.type = EventConstant.Key.RETAIN_PROMPT;
    L6:
        if (r102.useOriginalToast.booleanValue() == false) goto L13;
        Toast r103 = Toast.makeText(r101.getContext(), r102.text, 0);
        if (r102.position != 1) goto L10;
        r103.setGravity(17, 0, 0);
    L11:
        r103.show();
    L30:
        return null;
    L10:
        r103.setGravity(48, 0, 0);
        goto L11
    L13:
        if (TextUtils.equals("icon", r102.type) == false) goto L16;
        String r104 = fa.a.f475990a;
        fa.a.b(r101.getContext(), r102.text);
        goto L30
    L16:
        if (TextUtils.equals(EventConstant.Key.RETAIN_PROMPT, r102.type) == false) goto L22;
        if (r102.position != 1) goto L20;
        com.bytedance.android.annie.util.c.a(r102.text);
        goto L30
    L20:
        String r105 = fa.a.f475990a;
        fa.a.b(r101.getContext(), r102.text);
        goto L30
    L22:
        if (TextUtils.equals("image", r102.type) == false) goto L30;
        byte[] r106 = Base64.decode(r102.image.split(",")[1], 0);     // Catch: Exception -> L26
        Bitmap r107 = BitmapFactory.decodeByteArray(r106, 0, r106.length);     // Catch: Exception -> L26
    L28:
        if (r107 == null) goto L30;
        String r108 = fa.a.f475990a;
        fa.a.a(r101.getContext(), r102.text, new BitmapDrawable(r107));
    L26:
        e = move-exception;
        e.printStackTrace();
        r107 = null;
        goto L28
    }
}
