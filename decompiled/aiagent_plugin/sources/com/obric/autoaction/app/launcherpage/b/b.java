package com.obric.autoaction.app.launcherpage.b;

import android.app.Activity;
import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.floating.FloatingTransitionBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: LauncherFloatingTransition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "LauncherFloatingTransition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22905a = null;

    static {
        f22905a = new b();
    }

    private b() {
    }

    public final void a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        OFloatingTitleBar r0 = null;
        if (r11 == null) goto L5;
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.a(r11), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    L7:
        if (r4 != null) goto L11;
        Loog.INSTANCE.i(TAG, "notifyBeforeLaunch skip: no activity from context=" + r11);
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L13;
        a r12 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
    L14:
        if (r12 == null) goto L16;
        r0 = r12.getFloatingTransitionSourceTitleBar();
    L16:
        OFloatingTitleBar r5 = r0;
        if (r5 != null) goto L20;
        Loog.INSTANCE.i(TAG, "notifyBeforeLaunch skip: activity=" + r4.getClass().getSimpleName() + " isProvider=" + ZeusTransformUtils.instanceOf(r4, a.class) + " sourceTitleBar=null");
        return;
    L20:
        Loog.INSTANCE.i(TAG, "notifyBeforeLaunch invoke: activity=" + r4.getClass().getSimpleName() + " titleBar=" + r5);
        n.a r13 = n.f38560a;     // Catch: Throwable -> L23
        b r9 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        FloatingTransitionBridge.b.a(FloatingTransitionBridge.f36698a, r4, r5, null, 4, null);     // Catch: Throwable -> L23
        Object r14 = n.f(x.f38692a);     // Catch: Throwable -> L23
    L25:
        Throwable r15 = n.c(r14);
        if (r15 == null) goto L31;
        Loog.INSTANCE.e(TAG, "notifyFloatingTransitionLaunch failed", r15);
        return;
    L31:
        return;
    L23:
        th = move-exception;
        n.a r16 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L25
    L13:
        r12 = null;
        goto L14
    L5:
        r4 = null;
        goto L7
    }
}
