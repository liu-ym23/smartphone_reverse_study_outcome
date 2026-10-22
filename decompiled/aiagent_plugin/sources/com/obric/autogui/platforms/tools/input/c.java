package com.obric.autogui.platforms.tools.input;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputEvent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: InputManagerProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "InputMgrProv";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static InputManager f30258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f30259c;

    static {
        f30257a = new c();
    }

    private c() {
    }

    public final InputManager a() {
        InputManager r0 = f30258b;
        if (r0 == null) goto L10;
        return r0;
    L10:
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input");     // Catch: Throwable -> L7
        o.a(r1, "null cannot be cast to non-null type android.hardware.input.InputManager");     // Catch: Throwable -> L7
        InputManager r3 = (InputManager) ZeusTransformUtils.preCheckCast(r1, InputManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        f30258b = r3;     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "InputManager exception: " + th);
        return null;
    }

    public final Method b() {
        Method r4 = f30259c;
        if (r4 == null) goto L10;
        return r4;
    L10:
        Method r5 = InputManager.class.getMethod("injectInputEvent", new Class[]{InputEvent.class, Integer.TYPE});     // Catch: Exception -> L7
        f30259c = r5;     // Catch: Exception -> L7
        return r5;
    L7:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "InputManager exception: " + e);
        return null;
    }
}
