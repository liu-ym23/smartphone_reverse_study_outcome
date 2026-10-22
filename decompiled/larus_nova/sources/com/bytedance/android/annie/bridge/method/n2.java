package com.bytedance.android.annie.bridge.method;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "showToast")
public final class n2 extends e7.c0<e7.y0, JsonObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public n2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.y0 r102 = (e7.y0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        String r105 = r102.a();
        if (r105 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L29;
        String r107 = r102.a();
        Intrinsics.checkNotNull(r107);
        Object[] r108 = new Regex(",").split(r107, 0).toArray(new String[0]);     // Catch: Exception -> L24
        if (r108 == null) goto L23;
        byte[] r109 = Base64.decode(((String[]) r108)[1], 0);     // Catch: Exception -> L24
        Bitmap r110 = BitmapFactory.decodeByteArray(r109, 0, r109.length);     // Catch: Exception -> L24
    L25:
        if (r110 == null) goto L32;
        String r111 = r102.b();
        if (r111 == null) goto L32;
        String r112 = fa.a.f475990a;
        fa.a.a(r101.getContext(), r111, new BitmapDrawable(r110));
    L32:
        JsonObject r113 = new JsonObject();
        r113.addProperty("code", 1);
        r113.addProperty("msg", "SUCCESS");
        finishWithResult(r113);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L24
    L24:
        r110 = null;
        goto L25
    L29:
        String r114 = r102.b();
        if (r114 == null) goto L32;
        String r115 = fa.a.f475990a;
        fa.a.b(r101.getContext(), r114);
        goto L32
    L14:
        if ((!StringsKt.isBlank(r105)) != true) goto L16;
        r106 = true;
        goto L17
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }
}
