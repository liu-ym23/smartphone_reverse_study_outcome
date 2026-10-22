package com.obric.autoaction.presentation;

import android.view.Window;
import android.view.WindowManager;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SurfaceCardActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.obric.autoaction.presentation.island.b f24950a = null;

    public static final /* synthetic */ com.obric.autoaction.presentation.island.b a() {
        return f24950a;
    }

    public static final /* synthetic */ void a(Window r0) {
        b(r0);
    }

    static {
        f24950a = new com.obric.autoaction.presentation.island.b(true, 0, null, "player_security", 6, null);
    }

    private static final void b(Window r7) {
        ZeusTransformUtils.forName("android.view.WindowManagerExt", "com.obric.aiagent.plugin").getMethod("disableStartingWindow", new Class[]{WindowManager.LayoutParams.class, Boolean.TYPE}).invoke(null, new Object[]{r7.getAttributes(), true});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Loog.INSTANCE.d("Reflection", "exDisableUserInterfaceSaving fail: " + d.a.a(th));
    }
}
