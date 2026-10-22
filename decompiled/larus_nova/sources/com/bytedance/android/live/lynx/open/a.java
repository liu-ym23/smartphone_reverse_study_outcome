package com.bytedance.android.live.lynx.open;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends com.bytedance.ies.web.jsbridge2.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OpenLynxBridgeModule f82628n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LynxView f82629o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f82630p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<String> f82631q;

    /* JADX INFO: renamed from: com.bytedance.android.live.lynx.open.a$a, reason: collision with other inner class name */
    public static final class C1260a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final View g() {
        LynxView r100 = this.f82629o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L5:
        return r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final String h() {
        return this.f82631q.invoke();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public Context getContext(o r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        return this.f82630p;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void k(String r100) {
        JSONObject r101 = new JSONObject(r100);
        Object r102 = r101.remove("__event_id");
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r103 = (String) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        Object r104 = r101.remove("__params");
        if (r104 == null) goto L20;
        JSONObject r105 = new JSONObject();
        r105.put("code", 1);
        r105.put("data", r104);
        WritableMap r106 = kl0.b.d(r105);
        if (r106 == null) goto L21;
        JavaOnlyArray r107 = JavaOnlyArray.of(new Object[]{r106});
        LynxView r108 = this.f82629o;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L15:
        com.lynx.jsbridge.c r109 = r108.getJSModule("BDLynxAPIModule");
        if (r109 == null) goto L22;
        JavaOnlyArray r110 = new JavaOnlyArray();
        r110.pushString(r103);
        r110.pushArray(r107);
        r109.a("emit", r110);
        return;
    L22:
        return;
    L21:
        return;
    }

    public a(Context r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "androidContext");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f82630p = r100;
        this.f82631q = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void m(String r100, c0 r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        OpenLynxBridgeModule r102 = this.f82628n;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
    L7:
        r102.invokeCallback$livehybrid_impl_saasRelease(new JSONObject(r100), r101);
    }

    public final c0 r(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "namespace");
        Intrinsics.checkNotNullParameter(r103, "callbackId");
        c0.a r104 = new c0.a();
        r104.f249329c = r100;
        r104.f249330d = r101;
        r104.f249331e = r103;
        r104.f249332f = r102;
        c0 r105 = new c0(r104);
        o(r105);
        return r105;
    }
}
