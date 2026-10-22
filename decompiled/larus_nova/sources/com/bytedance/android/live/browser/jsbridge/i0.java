package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livehostapi.platform.ISaasHostWebView;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f63221a = 0;

    public static void b() {
        Map<String, Class<? extends XBridgeMethod>> r100 = XBridge.INSTANCE.getMethodList(XBridgePlatformType.LYNX, "DEFAULT");
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, Class<? extends XBridgeMethod>>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, Class<? extends XBridgeMethod>> r102 = r101.next();
        ArrayList<Class<? extends Object>> r103 = com.bytedance.android.live.browser.b0.f62587a;
        com.bytedance.android.live.browser.b0.a(r102.getValue());
    L8:
        ISaasHostWebView r104 = (ISaasHostWebView) jc1.k.f(ISaasHostWebView.class);
        if (r104 == null) goto L15;
        ArrayList<Class> r105 = r104.getXBridgeMethods();
        if (r105 == null) goto L16;
        com.bytedance.android.live.browser.b0.b(r105);
        return;
    L16:
        return;
    }

    static {
    }

    public static void a(JSONObject r100, Object r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        if (r100.opt("__code") != null) goto L11;
        Object r103 = r100.opt("code");     // Catch: Throwable -> L13
        if (r103 == null) goto L9;
        r101 = r103;
    L9:
        if (r101 == null) goto L11;
        r100.put("__code", r101);     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
