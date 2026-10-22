package com.obric.aiagent.product.platform.impl.g;

import android.app.IAssistantInputMethodListener;
import android.app.IAssistantWindowGestureListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.AssistantWindowManager;
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

/* JADX INFO: compiled from: AssistantWindowManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0406a f18852a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantWindowManagerImpl.kt */
    public static final class C0406a {
        public /* synthetic */ C0406a(h r1) {
            this();
        }

        private C0406a() {
        }
    }

    static {
        f18852a = new C0406a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public Bitmap takeScreenshot(List<String> r2, List<String> r3) {
        return AssistantWindowManager.takeScreenshot((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isAutoActionRunning() {
        return AssistantWindowManager.isAutoActionRunning();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isAutoImeReady() {
        return AssistantWindowManager.isAutoImeReady();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean focusedWindowIsSecure() {
        return AssistantWindowManager.focusedWindowIsSecure();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isInputMethodShown() {
        return AssistantWindowManager.isInputMethodShown();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean registerInputMethodListener(ObricInputMethodListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantInputMethodListener");
        return AssistantWindowManager.registerInputMethodListener((IAssistantInputMethodListener) ZeusTransformUtils.preCheckCast(r1, IAssistantInputMethodListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean unregisterInputMethodListener(ObricInputMethodListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantInputMethodListener");
        return AssistantWindowManager.unregisterInputMethodListener((IAssistantInputMethodListener) ZeusTransformUtils.preCheckCast(r1, IAssistantInputMethodListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean takeSurfaceControlScreenshot(List<String> r9, List<String> r10, Object r11) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "listener");
        Method[] r1 = AssistantWindowManager.class.getMethods();     // Catch: Exception -> L24
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
        Object r4 = r3.getAssistantStub();
        o.a(r4, "null cannot be cast to non-null type android.app.IAssistantWindowGestureListener");
        return AssistantWindowManager.registerWindowGestureListener(r1, (IAssistantWindowGestureListener) ZeusTransformUtils.preCheckCast(r4, IAssistantWindowGestureListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        o.e(r1, "token");
        o.e(r3, "listener");
        Object r4 = r3.getAssistantStub();
        o.a(r4, "null cannot be cast to non-null type android.app.IAssistantWindowGestureListener");
        return AssistantWindowManager.unregisterWindowGestureListener(r1, (IAssistantWindowGestureListener) ZeusTransformUtils.preCheckCast(r4, IAssistantWindowGestureListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean setAssistantWindowInKeyguardMode(Window r1) {
        o.e(r1, "window");
        return AssistantWindowManager.setAssistantWindowInKeyguardMode(r1);
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
