package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.OpenXPlayRealNameAuthResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.wc;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openXPlayRealNameAuth")
public final class g5 extends w20.w4<wc, OpenXPlayRealNameAuthResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57509a = 0;

    public static final class a {
    }

    static {
    }

    public g5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        wc r102 = (wc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        yr.b.b(4, "OpenXPlayRealNameAuthMethod", "param " + r102);
        String r103 = r102.c();
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L60;
        String r106 = r102.e();
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == false) goto L60;
        String r108 = r102.a();
        if (r108 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L60;
        String r110 = r102.b();
        if (r110 != null) goto L29;
    L32:
        boolean r111 = true;
    L33:
        if (r111 == false) goto L60;
        String r112 = r102.d();
        if (r112 != null) goto L37;
    L40:
        boolean r113 = true;
    L41:
        if (r113 == false) goto L60;
        String r114 = r102.f();
        if (r114 != null) goto L45;
    L48:
        boolean r115 = true;
    L49:
        if (r115 == false) goto L60;
        String r116 = r102.g();
        if (r116 != null) goto L53;
    L56:
        boolean r117 = true;
    L57:
        if (r117 == false) goto L60;
        r104 = false;
        goto L60
    L53:
        if (r116.length() == 0) goto L56;
        r117 = false;
        goto L57
    L45:
        if (r114.length() == 0) goto L48;
        r115 = false;
        goto L49
    L37:
        if (r112.length() == 0) goto L40;
        r113 = false;
        goto L41
    L29:
        if (r110.length() == 0) goto L32;
        r111 = false;
        goto L33
    L21:
        if (r108.length() == 0) goto L24;
        r109 = false;
        goto L25
    L13:
        if (r106.length() == 0) goto L16;
        r107 = false;
    L60:
        if (r104 == false) goto L75;
        xr.f r118 = (xr.f) xr.s.a(xr.f.class);
        if (r118 == null) goto L73;
        xr.g r119 = r118.getCloudGameService();
        if (r119 == null) goto L74;
        String r120 = r102.g();
        if (r120 == null) goto L71;
        Long r121 = StringsKt.toLongOrNull(r120);
        if (r121 == null) goto L71;
        r121.longValue();
    L71:
        new OpenXPlayRealNameAuthMethod$invoke$1(this);
        r119.m();
        return;
    L74:
        return;
    L73:
        return;
    L75:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
