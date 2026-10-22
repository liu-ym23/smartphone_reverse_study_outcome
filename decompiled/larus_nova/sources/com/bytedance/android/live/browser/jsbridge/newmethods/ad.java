package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showToast")
public final class ad extends x<bd, JSONObject> {
    public ad() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        bd r102 = (bd) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.c();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        String r105 = r102.a();
        String r106 = "";
        if (r105 != null) goto L14;
    L28:
        String r107 = r102.b();
        if (r107 != null) goto L31;
    L52:
        com.bytedance.android.live.core.utils.f2.c(r102.c(), 0);
    L53:
        JSONObject r108 = new JSONObject();
        r108.put("code", 1);
        r108.put("msg", "SUCCESS");
        finishWithResult(r108);
        return;
    L31:
        if ((!StringsKt.isBlank(r107)) != true) goto L52;
        LinkedHashMap r109 = new LinkedHashMap();
        String r110 = r102.b();
        if (r110 == null) goto L46;
        int r111 = r110.hashCode();
        if (r111 == (-1867169789)) goto L44;
        if (r111 != 96784904) goto L46;
        if (r110.equals("error") == false) goto L46;
        int r112 = 2;
    L47:
        r109.put("status", Integer.valueOf(r112));
        String r113 = r102.c();
        if (r113 == null) goto L51;
        r106 = r113;
    L51:
        r109.put("text", r106);
        ((IHostApp) jc1.k.n(IHostApp.class)).centerIconToast(r101.getContext(), r109);
        goto L53
    L44:
        if (r110.equals("success") == false) goto L46;
        r112 = 1;
    L46:
        r112 = -1;
        goto L47
    L14:
        if ((!StringsKt.isBlank(r105)) != true) goto L28;
        String r114 = r102.a();
        Intrinsics.checkNotNull(r114);
        Object[] r115 = new Regex(",").split(r114, 0).toArray(new String[0]);     // Catch: Exception -> L21
        if (r115 == null) goto L20;
        byte[] r116 = Base64.decode(((String[]) r115)[1], 0);     // Catch: Exception -> L21
        Bitmap r117 = BitmapFactory.decodeByteArray(r116, 0, r116.length);     // Catch: Exception -> L21
    L22:
        if (r117 == null) goto L53;
        String r118 = rm3.c.f538539a;
        Context r119 = r101.getContext();
        String r120 = r102.c();
        if (r120 == null) goto L27;
        r106 = r120;
    L27:
        rm3.c.c(r119, r106, new BitmapDrawable(r117));
        goto L53
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L21
    L21:
        r117 = null;
        goto L22
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }
}
