package com.obric.autogui.platforms.tools.e;

import android.view.WindowManager;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.IAutoActionSystemApi;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.List;

/* JADX INFO: compiled from: StandardSystemApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements IAutoActionSystemApi {
    private static final String TAG = "O/SystemApi";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0807a f30216b = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardSystemApiImpl.kt */
    public static final class C0807a {
        public /* synthetic */ C0807a(h r1) {
            this();
        }

        private C0807a() {
        }
    }

    static {
        f30216b = new C0807a(null);
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public Object dumpViewHierarchy(int r3, boolean r4, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r5) {
        return a(this, r3, r4, (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public IAutoActionThermalStateApi getThermalManager() {
        return null;
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public boolean isSupported() {
        return true;
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public void setTrustedOverlay(WindowManager.LayoutParams r1) {
        o.e(r1, "params");
    }

    public a() {
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public String getSystemVersion() {
        return ObricProductSdk.INSTANCE.platformService().romInfo().getOSVersion();
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public boolean isSystemDebuggable() {
        if (com.obric.aiagent.product.a.d.f18776a.a("ro.debuggable", 0) == 1) goto L13;
        return false;
    L13:
        return true;
    L7:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "isSystemDebuggable failed " + th, th);
        return false;
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public String getRomKeyType() {
        Object r0 = "";
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(com.obric.aiagent.product.a.d.f18776a.a("ro.build.tags", ""));     // Catch: Throwable -> L5
    L8:
        if (n.b(r4) == true) goto L12;
        r0 = r4;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    static /* synthetic */ Object a(a r0, int r1, boolean r2, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.d.f29012a.a("not supported");
    }
}
