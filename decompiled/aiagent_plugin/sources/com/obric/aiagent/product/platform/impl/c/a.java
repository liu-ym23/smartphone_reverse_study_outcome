package com.obric.aiagent.product.platform.impl.c;

import aiassistant.memorydata.MemoryManagerProxy;
import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricScenePerceptionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricSystemEventCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AssistantMemoryManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricMemoryManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0402a f18826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18830e;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantMemoryManagerImpl.kt */
    public static final class C0402a {
        public /* synthetic */ C0402a(h r1) {
            this();
        }

        private C0402a() {
        }
    }

    static {
        f18826a = new C0402a(null);
    }

    public a() {
        this.f18827b = "com.aiassistant.memorydata.EXTRA_TEXT";
        this.f18828c = "com.aiassistant.memorydata.EXTRA_IMAGE_URI";
        this.f18829d = "com.aiassistant.memorydata.EXTRA_PACKAGE";
        this.f18830e = "com.aiassistant.memorydata.EXTRA_TIMESTAMP";
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_TEXT() {
        return this.f18827b;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_IMAGE_URI() {
        return this.f18828c;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_PACKAGE() {
        return this.f18829d;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_TIMESTAMP() {
        return this.f18830e;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doMemoryActionIfEnabled(int r2, Bundle r3, Context r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "extras");
        o.e(r1, "context");
        MemoryManagerProxy.doMemoryActionIfEnabled(r2, r3, r1);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doMemoryAction(int r1, Bundle r2) {
        o.e(r2, "extras");
        MemoryManagerProxy.doMemoryAction(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerMemoryActionCallback(ObricMemoryActionCallback r3) {
        o.e(r3, "callback");
        ILogDepend.Companion.d("AssistantMemoryManagerImpl", "registerMemoryActionCallback: " + r3);
        Object r2 = r3.getAssistantStub();
        o.a(r2, "null cannot be cast to non-null type aiassistant.memorydata.MemoryManagerProxy.MemoryActionCallbackWrapper");
        MemoryManagerProxy.registerMemoryActionCallback((MemoryManagerProxy.MemoryActionCallbackWrapper) ZeusTransformUtils.preCheckCast(r2, MemoryManagerProxy.MemoryActionCallbackWrapper.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterMemoryActionCallback() {
        MemoryManagerProxy.unregisterMemoryActionCallback();
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void reportSystemEvent(int r1, int r2, Bundle r3) {
        o.e(r3, "extras");
        MemoryManagerProxy.reportSystemEvent(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerSystemEventCallback(ObricSystemEventCallback r2) {
        o.e(r2, "callback");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type aiassistant.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper");
        MemoryManagerProxy.registerSystemEventCallback((MemoryManagerProxy.SystemEventCallbackWrapper) ZeusTransformUtils.preCheckCast(r1, MemoryManagerProxy.SystemEventCallbackWrapper.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterSystemEventCallback() {
        MemoryManagerProxy.unregisterSystemEventCallback();
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doScenePerceptionAction(int r7, Bundle r8) {
        o.e(r8, "extras");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r9 = n.f(MemoryManagerProxy.class.getMethod("doScenePerceptionAction", new Class[]{Integer.TYPE, Bundle.class}).invoke(null, new Object[]{Integer.valueOf(r7), r8}));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L13;
        ILogDepend.Companion.e("AssistantMemoryManagerImpl", "doScenePerceptionAction failed", r10);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void reportScenePerceptionEvent(int r7, Bundle r8) {
        o.e(r8, "extras");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r9 = n.f(MemoryManagerProxy.class.getMethod("reportScenePerceptionEvent", new Class[]{Integer.TYPE, Bundle.class}).invoke(null, new Object[]{Integer.valueOf(r7), r8}));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L13;
        ILogDepend.Companion.e("AssistantMemoryManagerImpl", "reportScenePerceptionEvent failed", r10);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerScenePerceptionCallback(ObricScenePerceptionCallback r9) {
        o.e(r9, "callback");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L18
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Object r10 = r9.getAssistantStub();     // Catch: Throwable -> L18
        Method[] r11 = MemoryManagerProxy.class.getMethods();     // Catch: Throwable -> L18
        o.c(r11, "getMethods(...)");     // Catch: Throwable -> L18
        Object[] r12 = (Object[]) ZeusTransformUtils.preCheckCast(r11, Object[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        int r2 = r12.length;     // Catch: Throwable -> L18
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L17;
        Object r4 = r12[r3];     // Catch: Throwable -> L18
        Method r5 = (Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (o.a(r5.getName(), "registerScenePerceptionCallback") == true) goto L8;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L14;
        r3 = r3 + 1;     // Catch: Throwable -> L18
        goto L4
    L14:
        Object r13 = n.f(((Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.aiagent.plugin")).invoke(null, new Object[]{r10}));     // Catch: Throwable -> L18
    L20:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L27;
        ILogDepend.Companion.e("AssistantMemoryManagerImpl", "registerScenePerceptionCallback failed", r14);
        return;
    L27:
        return;
    L8:
        if (r5.getParameterTypes().length != 1) goto L12;
        if (ZeusTransformUtils.instanceOf(r5.getParameterTypes()[0], r10) == false) goto L12;
        r6 = true;
        goto L13
    L17:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L20
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterScenePerceptionCallback() {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        Object r4 = n.f(MemoryManagerProxy.class.getMethod("unregisterScenePerceptionCallback", new Class[0]).invoke(null, new Object[0]));     // Catch: Throwable -> L4
    L6:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L12;
        ILogDepend.Companion.e("AssistantMemoryManagerImpl", "unregisterScenePerceptionCallback failed", r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        n.a r1 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L6
    }
}
