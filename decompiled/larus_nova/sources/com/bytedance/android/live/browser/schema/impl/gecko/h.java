package com.bytedance.android.live.browser.schema.impl.gecko;

import android.content.SharedPreferences;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements g {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.android.live.browser.schema.impl.gecko.g
    public final com.bytedance.android.live.browser.schema.core.d restore() {
        boolean r100 = false;
        SharedPreferences r101 = ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).context().getSharedPreferences("webcast_redirect", 0);
        String r102 = r101.getString("redirect_rules", "");
        if (r102 != null) goto L5;
    L6:
        r100 = true;
    L7:
        Object r103 = null;
        if (r100 == false) goto L23;
        return null;
    L23:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r105 = new JSONObject(r102);     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(new com.bytedance.android.live.browser.schema.core.d(r105.optJSONObject(TemplateNodeType.RAW), r105.optString("version")));     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L18;
        r101.edit().remove("redirect_rules").apply();
    L18:
        if (Result.m9455isFailureimpl(r106) == true) goto L22;
        r103 = r106;
    L22:
        return (com.bytedance.android.live.browser.schema.core.d) r103;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r102.length() != 0) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.schema.impl.gecko.g
    public final void a(com.bytedance.android.live.browser.schema.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        SharedPreferences r101 = ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).context().getSharedPreferences("webcast_redirect", 0);
        JSONObject r102 = new JSONObject();
        r102.put(TemplateNodeType.RAW, r100.f64207a);
        String r103 = r100.f64208b;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("version", r103);
        if (r101 == null) goto L13;
        SharedPreferences.Editor r104 = r101.edit();
        if (r104 == null) goto L14;
        SharedPreferences.Editor r105 = r104.putString("redirect_rules", r102.toString());
        if (r105 == null) goto L15;
        r105.apply();
        return;
    L15:
        return;
    L14:
        return;
    }
}
