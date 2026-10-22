package com.obric.aiagent.product.platform.impl.c;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.product.platform.api.memory.ObricScenePerceptionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricSystemEventCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import obric.memorydata.MemoryManagerProxy;

/* JADX INFO: compiled from: CommonObricMemoryManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IObricMemoryManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18835e;

    /* JADX INFO: compiled from: CommonObricMemoryManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18831a = new a(null);
    }

    public b() {
        this.f18832b = ObricMemoryConstants.KEY_TEXT;
        this.f18833c = ObricMemoryConstants.KEY_IMAGE_URI;
        this.f18834d = ObricMemoryConstants.KEY_PACKAGE;
        this.f18835e = ObricMemoryConstants.KEY_TIMESTAMP;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_TEXT() {
        return this.f18832b;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_IMAGE_URI() {
        return this.f18833c;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_PACKAGE() {
        return this.f18834d;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_TIMESTAMP() {
        return this.f18835e;
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
        ILogDepend.Companion.d("CommonObricMemoryManager", "registerMemoryActionCallback: " + r3);
        Object r2 = r3.getObricStub();
        o.a(r2, "null cannot be cast to non-null type obric.memorydata.MemoryManagerProxy.MemoryActionCallbackWrapper");
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
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type obric.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper");
        MemoryManagerProxy.registerSystemEventCallback((MemoryManagerProxy.SystemEventCallbackWrapper) ZeusTransformUtils.preCheckCast(r1, MemoryManagerProxy.SystemEventCallbackWrapper.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterSystemEventCallback() {
        MemoryManagerProxy.unregisterSystemEventCallback();
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doScenePerceptionAction(int r1, Bundle r2) {
        o.e(r2, "extras");
        MemoryManagerProxy.doScenePerceptionAction(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void reportScenePerceptionEvent(int r1, Bundle r2) {
        o.e(r2, "extras");
        MemoryManagerProxy.reportScenePerceptionEvent(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerScenePerceptionCallback(ObricScenePerceptionCallback r2) {
        o.e(r2, "callback");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type obric.memorydata.MemoryManagerProxy.ScenePerceptionCallbackWrapper");
        MemoryManagerProxy.registerScenePerceptionCallback((MemoryManagerProxy.ScenePerceptionCallbackWrapper) ZeusTransformUtils.preCheckCast(r1, MemoryManagerProxy.ScenePerceptionCallbackWrapper.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterScenePerceptionCallback() {
        MemoryManagerProxy.unregisterScenePerceptionCallback();
    }
}
