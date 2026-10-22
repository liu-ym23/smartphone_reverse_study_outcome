package com.obric.autogui.session.state;

import android.app.Application;
import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AOStateUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "AOStateUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f31396a = null;

    static {
        f31396a = new d();
    }

    private d() {
    }

    public final Application a() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Application.class) == true) goto L7;
        return null;
    L7:
        return (Application) ZeusTransformUtils.preCheckCast(r2, Application.class, "com.obric.aiagent.plugin");
    }

    public final void a(com.obric.autogui.session.a r8, com.obric.autogui.common.e r9, int r10) {
        o.e(r8, SensitiveType.SESSION);
        com.obric.autogui.session.state.termination.a.a(r8.J(), r9, r10, null, null, 12, null);
    }
}
