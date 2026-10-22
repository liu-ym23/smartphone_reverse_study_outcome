package com.obric.aiagent.product.platform.api.app;

import android.content.Context;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricActivityTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricActivityTaskManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricActivityTaskManager";
    private static IObricActivityTaskManager instance;

    /* JADX INFO: compiled from: ObricActivityTaskManager.kt */
    public static final class Companion implements IObricActivityTaskManager {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean registerAppSwitchListener(ObricAppSwitchListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerAppSwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean unregisterAppSwitchListener(ObricAppSwitchListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterAppSwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean registerActivitySwitchListener(ObricActivitySwitchListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerActivitySwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterActivitySwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean registerFocusListener(ObricFocusListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerFocusListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean unregisterFocusListener(ObricFocusListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterFocusListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean registerSystemAnimationListener(ObricSystemAnimationListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerSystemAnimationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r1) {
            o.e(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterSystemAnimationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        public boolean finishAndRemoveAllTask(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            IObricActivityTaskManager r3 = ObricActivityTaskManager.access$getInstance$cp();
            if (r3 != null) goto L7;
            return false;
        L7:
            return r3.finishAndRemoveAllTask(r1);
        }
    }

    public static boolean finishAndRemoveAllTask(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return Companion.finishAndRemoveAllTask(r3);
    }

    public static /* synthetic */ Object lambda$TRSglkJPwhSjkzX0n0jwHgI_RGM() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ Object lambda$b1xVHb5FKX4MaeQErWK8kL7LUuI() {
        return _init_$lambda$0();
    }

    public static boolean registerActivitySwitchListener(ObricActivitySwitchListener r1) {
        return Companion.registerActivitySwitchListener(r1);
    }

    public static boolean registerAppSwitchListener(ObricAppSwitchListener r1) {
        return Companion.registerAppSwitchListener(r1);
    }

    public static boolean registerFocusListener(ObricFocusListener r1) {
        return Companion.registerFocusListener(r1);
    }

    public static boolean registerSystemAnimationListener(ObricSystemAnimationListener r1) {
        return Companion.registerSystemAnimationListener(r1);
    }

    public static boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r1) {
        return Companion.unregisterActivitySwitchListener(r1);
    }

    public static boolean unregisterAppSwitchListener(ObricAppSwitchListener r1) {
        return Companion.unregisterAppSwitchListener(r1);
    }

    public static boolean unregisterFocusListener(ObricFocusListener r1) {
        return Companion.unregisterFocusListener(r1);
    }

    public static boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r1) {
        return Companion.unregisterSystemAnimationListener(r1);
    }

    public ObricActivityTaskManager() {
    }

    public static final /* synthetic */ IObricActivityTaskManager access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new Companion(null);
    L8:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind ObricActivityTaskManager failed", th);
    L10:
        instance = (IObricActivityTaskManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricActivityTaskManager.class, false), IObricActivityTaskManager.class, "com.obric.aiagent.plugin");
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricActivityTaskManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricActivityTaskManager$b1xVHb5FKX4MaeQErWK8kL7LUuI.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L12:
        goto L10
    L6:
        ServiceManager.get().bind(IObricActivityTaskManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricActivityTaskManager$TRSglkJPwhSjkzX0n0jwHgI_RGM.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        goto L12
    }

    private static final Object _init_$lambda$0() {
        return new com.obric.aiagent.product.platform.impl.app.b();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.app.h();
    }
}
