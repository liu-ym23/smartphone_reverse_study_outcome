package com.obric.aiagent.product.platform.api.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.Window;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import com.obric.aiagent.product.platform.impl.g.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ObricWindowManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricWindowManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricWindowManager";
    private static IObricWindowManager instance;

    /* JADX INFO: compiled from: ObricWindowManager.kt */
    public static final class Companion implements IObricWindowManager {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public Bitmap takeScreenshot(List<String> r2, List<String> r3) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            IObricWindowManager r5 = ObricWindowManager.access$getInstance$cp();
            if (r5 == null) goto L6;
            Bitmap r6 = r5.takeScreenshot(r1, r4);
            if (r6 == null) goto L6;
            return r6;
        L6:
            return null;
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean isAutoActionRunning() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isAutoActionRunning();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean isAutoImeReady() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isAutoImeReady();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean focusedWindowIsSecure() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.focusedWindowIsSecure();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean isInputMethodShown() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isInputMethodShown();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean registerInputMethodListener(ObricInputMethodListener r1) {
            o.e(r1, "listener");
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerInputMethodListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean unregisterInputMethodListener(ObricInputMethodListener r1) {
            o.e(r1, "listener");
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterInputMethodListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean takeSurfaceControlScreenshot(List<String> r2, List<String> r3, Object r4) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "listener");
            IObricWindowManager r6 = ObricWindowManager.access$getInstance$cp();
            if (r6 != null) goto L7;
            return false;
        L7:
            return r6.takeSurfaceControlScreenshot(r1, r5, r4);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean registerWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            o.e(r1, "token");
            o.e(r3, "listener");
            IObricWindowManager r4 = ObricWindowManager.access$getInstance$cp();
            if (r4 != null) goto L7;
            return false;
        L7:
            return r4.registerWindowGestureListener(r1, r3);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            o.e(r1, "token");
            o.e(r3, "listener");
            IObricWindowManager r4 = ObricWindowManager.access$getInstance$cp();
            if (r4 != null) goto L7;
            return false;
        L7:
            return r4.unregisterWindowGestureListener(r1, r3);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean setAssistantWindowInKeyguardMode(Window r1) {
            o.e(r1, "window");
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.setAssistantWindowInKeyguardMode(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean showGlobalActions(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            IObricWindowManager r3 = ObricWindowManager.access$getInstance$cp();
            if (r3 != null) goto L7;
            return false;
        L7:
            return r3.showGlobalActions(r1);
        }
    }

    public static boolean focusedWindowIsSecure() {
        return Companion.focusedWindowIsSecure();
    }

    public static boolean isAutoActionRunning() {
        return Companion.isAutoActionRunning();
    }

    public static boolean isAutoImeReady() {
        return Companion.isAutoImeReady();
    }

    public static boolean isInputMethodShown() {
        return Companion.isInputMethodShown();
    }

    /* JADX INFO: renamed from: lambda$AHFJVN7ROAILNC-Ea_UXkqT9npA, reason: not valid java name */
    public static /* synthetic */ Object m226lambda$AHFJVN7ROAILNCEa_UXkqT9npA() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ Object lambda$zbtgqrHEB4TWe2X0wp4JQuc4bsU() {
        return _init_$lambda$0();
    }

    public static boolean registerInputMethodListener(ObricInputMethodListener r1) {
        return Companion.registerInputMethodListener(r1);
    }

    public static boolean registerWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        return Companion.registerWindowGestureListener(r4, r3);
    }

    public static boolean setAssistantWindowInKeyguardMode(Window r1) {
        return Companion.setAssistantWindowInKeyguardMode(r1);
    }

    public static Bitmap takeScreenshot(List<String> r2, List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return Companion.takeScreenshot(r4, r5);
    }

    public static boolean takeSurfaceControlScreenshot(List<String> r2, List<String> r3, Object r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return Companion.takeSurfaceControlScreenshot(r5, r6, r4);
    }

    public static boolean unregisterInputMethodListener(ObricInputMethodListener r1) {
        return Companion.unregisterInputMethodListener(r1);
    }

    public static boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        return Companion.unregisterWindowGestureListener(r4, r3);
    }

    public ObricWindowManager() {
    }

    public static final /* synthetic */ IObricWindowManager access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new Companion(null);
    L8:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind ObricWindowManager failed", th);
    L10:
        instance = (IObricWindowManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricWindowManager.class, false), IObricWindowManager.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "ObricWindowManager instance: " + instance);
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricWindowManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricWindowManager$zbtgqrHEB4TWe2X0wp4JQuc4bsU.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L12:
        goto L10
    L6:
        ServiceManager.get().bind(IObricWindowManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricWindowManager$AHFJVN7ROAILNCEa_UXkqT9npA.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        goto L12
    }

    private static final Object _init_$lambda$0() {
        return new a();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.g.b();
    }
}
