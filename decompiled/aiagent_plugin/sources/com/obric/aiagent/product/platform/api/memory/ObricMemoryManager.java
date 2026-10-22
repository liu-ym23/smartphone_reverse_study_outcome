package com.obric.aiagent.product.platform.api.memory;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.impl.c.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricMemoryManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricMemoryManager {
    public static final Companion Companion = null;
    private static final f<String> KEY_IMAGE_URI$delegate = null;
    private static final f<String> KEY_PACKAGE$delegate = null;
    private static final f<String> KEY_TEXT$delegate = null;
    private static final f<String> KEY_TIMESTAMP$delegate = null;
    private static final String TAG = "ObricMemoryManager";
    private static IObricMemoryManager instance;

    /* JADX INFO: compiled from: ObricMemoryManager.kt */
    public static final class Companion implements IObricMemoryManager {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_TEXT() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_TEXT$delegate$cp().b(), String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_IMAGE_URI() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_IMAGE_URI$delegate$cp().b(), String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_PACKAGE() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_PACKAGE$delegate$cp().b(), String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_TIMESTAMP() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_TIMESTAMP$delegate$cp().b(), String.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void doMemoryActionIfEnabled(int r2, Bundle r3, Context r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "extras");
            o.e(r1, "context");
            IObricMemoryManager r5 = ObricMemoryManager.access$getInstance$cp();
            if (r5 == null) goto L6;
            r5.doMemoryActionIfEnabled(r2, r3, r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void doMemoryAction(int r1, Bundle r2) {
            o.e(r2, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.doMemoryAction(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void registerMemoryActionCallback(ObricMemoryActionCallback r1) {
            o.e(r1, "callback");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.registerMemoryActionCallback(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void unregisterMemoryActionCallback() {
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.unregisterMemoryActionCallback();
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void reportSystemEvent(int r1, int r2, Bundle r3) {
            o.e(r3, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.reportSystemEvent(r1, r2, r3);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void registerSystemEventCallback(ObricSystemEventCallback r1) {
            o.e(r1, "callback");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.registerSystemEventCallback(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void unregisterSystemEventCallback() {
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.unregisterSystemEventCallback();
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void doScenePerceptionAction(int r1, Bundle r2) {
            o.e(r2, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.doScenePerceptionAction(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void reportScenePerceptionEvent(int r1, Bundle r2) {
            o.e(r2, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.reportScenePerceptionEvent(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void registerScenePerceptionCallback(ObricScenePerceptionCallback r1) {
            o.e(r1, "callback");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.registerScenePerceptionCallback(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public void unregisterScenePerceptionCallback() {
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.unregisterScenePerceptionCallback();
            return;
        }
    }

    public static void doMemoryAction(int r1, Bundle r2) {
        Companion.doMemoryAction(r1, r2);
    }

    public static void doMemoryActionIfEnabled(int r2, Bundle r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Companion.doMemoryActionIfEnabled(r2, r3, r5);
    }

    public static void doScenePerceptionAction(int r1, Bundle r2) {
        Companion.doScenePerceptionAction(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$7vcDEj4Jyqd2bzKY3fz-7agh5JQ, reason: not valid java name */
    public static /* synthetic */ Object m212lambda$7vcDEj4Jyqd2bzKY3fz7agh5JQ() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ String lambda$C0aMzAHTfjFDgcxM0VkY7jNuC4s() {
        return KEY_IMAGE_URI_delegate$lambda$3();
    }

    /* JADX INFO: renamed from: lambda$ZAxCACjzQ7CZaLhz8rMKEIa-A7s, reason: not valid java name */
    public static /* synthetic */ Object m213lambda$ZAxCACjzQ7CZaLhz8rMKEIaA7s() {
        return _init_$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$lQw7ygo1qNrOpkF9T-FIsQXRr38, reason: not valid java name */
    public static /* synthetic */ String m214lambda$lQw7ygo1qNrOpkF9TFIsQXRr38() {
        return KEY_PACKAGE_delegate$lambda$4();
    }

    public static /* synthetic */ String lambda$nzE984R3GEYj6o31SgHkM5edbVQ() {
        return KEY_TEXT_delegate$lambda$2();
    }

    public static /* synthetic */ String lambda$oreRS0qFB9FIoWlFKHOBnpolveA() {
        return KEY_TIMESTAMP_delegate$lambda$5();
    }

    public static void registerMemoryActionCallback(ObricMemoryActionCallback r1) {
        Companion.registerMemoryActionCallback(r1);
    }

    public static void registerScenePerceptionCallback(ObricScenePerceptionCallback r1) {
        Companion.registerScenePerceptionCallback(r1);
    }

    public static void registerSystemEventCallback(ObricSystemEventCallback r1) {
        Companion.registerSystemEventCallback(r1);
    }

    public static void reportScenePerceptionEvent(int r1, Bundle r2) {
        Companion.reportScenePerceptionEvent(r1, r2);
    }

    public static void reportSystemEvent(int r1, int r2, Bundle r3) {
        Companion.reportSystemEvent(r1, r2, r3);
    }

    public static void unregisterMemoryActionCallback() {
        Companion.unregisterMemoryActionCallback();
    }

    public static void unregisterScenePerceptionCallback() {
        Companion.unregisterScenePerceptionCallback();
    }

    public static void unregisterSystemEventCallback() {
        Companion.unregisterSystemEventCallback();
    }

    public ObricMemoryManager() {
    }

    public static final /* synthetic */ IObricMemoryManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ f access$getKEY_IMAGE_URI$delegate$cp() {
        return KEY_IMAGE_URI$delegate;
    }

    public static final /* synthetic */ f access$getKEY_PACKAGE$delegate$cp() {
        return KEY_PACKAGE$delegate;
    }

    public static final /* synthetic */ f access$getKEY_TEXT$delegate$cp() {
        return KEY_TEXT$delegate;
    }

    public static final /* synthetic */ f access$getKEY_TIMESTAMP$delegate$cp() {
        return KEY_TIMESTAMP$delegate;
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind ObricMemoryManager failed", th);
    L11:
        instance = (IObricMemoryManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricMemoryManager.class, false), IObricMemoryManager.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "ObricMemoryManager instance: " + instance);
        KEY_TEXT$delegate = g.a($$Lambda$ObricMemoryManager$nzE984R3GEYj6o31SgHkM5edbVQ.INSTANCE);
        KEY_IMAGE_URI$delegate = g.a($$Lambda$ObricMemoryManager$C0aMzAHTfjFDgcxM0VkY7jNuC4s.INSTANCE);
        KEY_PACKAGE$delegate = g.a($$Lambda$ObricMemoryManager$lQw7ygo1qNrOpkF9TFIsQXRr38.INSTANCE);
        KEY_TIMESTAMP$delegate = g.a($$Lambda$ObricMemoryManager$oreRS0qFB9FIoWlFKHOBnpolveA.INSTANCE);
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricMemoryManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricMemoryManager$ZAxCACjzQ7CZaLhz8rMKEIaA7s.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L7:
        ILogDepend.Companion.i(TAG, "bind MemoryManager assistantApi= " + b.f18770a.a());     // Catch: Throwable -> L9
        goto L11
    L6:
        ServiceManager.get().bind(IObricMemoryManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricMemoryManager$7vcDEj4Jyqd2bzKY3fz7agh5JQ.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L7
    }

    private static final Object _init_$lambda$0() {
        return new a();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.c.b();
    }

    private static final String KEY_TEXT_delegate$lambda$2() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_TEXT();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final String KEY_IMAGE_URI_delegate$lambda$3() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_IMAGE_URI();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final String KEY_PACKAGE_delegate$lambda$4() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_PACKAGE();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final String KEY_TIMESTAMP_delegate$lambda$5() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_TIMESTAMP();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }
}
