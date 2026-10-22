package com.obric.aiagent.product.platform.impl.g;

import android.app.IObricInputMethodListener;
import android.app.IObricWindowGestureListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.ObricWindowManager;
import android.view.Window;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: CommonObricWindowManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IObricWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18853a = null;

    /* JADX INFO: compiled from: CommonObricWindowManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18853a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public Bitmap takeScreenshot(List<String> r2, List<String> r3) {
        return ObricWindowManager.takeScreenshot((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isAutoActionRunning() {
        return ObricWindowManager.isAutoActionRunning();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isAutoImeReady() {
        return ObricWindowManager.isAutoImeReady();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean focusedWindowIsSecure() {
        return ObricWindowManager.focusedWindowIsSecure();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isInputMethodShown() {
        return ObricWindowManager.isInputMethodShown();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean registerInputMethodListener(ObricInputMethodListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricInputMethodListener");
        return ObricWindowManager.registerInputMethodListener((IObricInputMethodListener) ZeusTransformUtils.preCheckCast(r1, IObricInputMethodListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean unregisterInputMethodListener(ObricInputMethodListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricInputMethodListener");
        return ObricWindowManager.unregisterInputMethodListener((IObricInputMethodListener) ZeusTransformUtils.preCheckCast(r1, IObricInputMethodListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean takeSurfaceControlScreenshot(List<String> r9, List<String> r10, Object r11) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "listener");
        Method[] r1 = ObricWindowManager.class.getMethods();     // Catch: Exception -> L24
        o.c(r1, "getMethods(...)");     // Catch: Exception -> L24
        Object[] r2 = (Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        int r3 = r2.length;     // Catch: Exception -> L24
        int r4 = 0;
    L4:
        Boolean r5 = null;
        if (r4 >= r3) goto L10;
        Object r6 = r2[r4];     // Catch: Exception -> L24
        if (o.a(((Method) ZeusTransformUtils.preCheckCast(r6, Method.class, "com.obric.aiagent.plugin")).getName(), "takeSurfaceControlScreenshot") == true) goto L11;
        r4 = r4 + 1;     // Catch: Exception -> L24
    L11:
        Method r7 = (Method) ZeusTransformUtils.preCheckCast(r6, Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (r7 == null) goto L14;
        r7.setAccessible(true);     // Catch: Exception -> L24
    L14:
        if (r7 == null) goto L16;
        Object r13 = r7.invoke(null, new Object[]{r8, r12, r11});     // Catch: Exception -> L24
    L18:
        if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == false) goto L20;
        r5 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
    L20:
        if (r5 == null) goto L29;
        return r5.booleanValue();
    L29:
        return false;
    L16:
        r13 = null;
        goto L18
    L10:
        r6 = null;
    L30:
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean registerWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        o.e(r1, "token");
        o.e(r3, "listener");
        Object r4 = r3.getObricStub();
        o.a(r4, "null cannot be cast to non-null type android.app.IObricWindowGestureListener");
        return ObricWindowManager.registerWindowGestureListener(r1, (IObricWindowGestureListener) ZeusTransformUtils.preCheckCast(r4, IObricWindowGestureListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        o.e(r1, "token");
        o.e(r3, "listener");
        Object r4 = r3.getObricStub();
        o.a(r4, "null cannot be cast to non-null type android.app.IObricWindowGestureListener");
        return ObricWindowManager.unregisterWindowGestureListener(r1, (IObricWindowGestureListener) ZeusTransformUtils.preCheckCast(r4, IObricWindowGestureListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean setAssistantWindowInKeyguardMode(Window r1) {
        o.e(r1, "window");
        return ObricWindowManager.setAssistantWindowInKeyguardMode(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean showGlobalActions(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Object r6 = r4.getSystemService("window");
        Field r0 = r6.getClass().getDeclaredField("mGlobal");     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        Object r7 = r0.get(r6);     // Catch: Exception -> L5
        Field r1 = r7.getClass().getDeclaredField("sWindowManagerService");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Object r8 = r1.get(r7);     // Catch: Exception -> L5
        Method r2 = r8.getClass().getDeclaredMethod("showGlobalActions", new Class[0]);     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        r2.invoke(r8, new Object[0]);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }
}
