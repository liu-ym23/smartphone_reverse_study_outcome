package com.stepos.core.device.awareness;

import com.stepos.base.awareness.data.SceneType;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import q6.a;
import q6.b;
import q6.c;
import q6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DefaultSceneAwareness implements a {
    private SceneType currentScene;
    private final CopyOnWriteArrayList<a.InterfaceC0129a> listeners;
    private final b sceneEvaluator;
    private final c schedulePolicy;
    private final d systemMonitor;

    public DefaultSceneAwareness() {
        this(null, null, null, 7, null);
    }

    private final void updateScene(SceneType sceneType) {
        if (this.currentScene != sceneType) {
            this.currentScene = sceneType;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0129a) it.next()).a();
            }
        }
    }

    @Override // q6.a
    public void addSceneChangeListener(a.InterfaceC0129a listener) {
        g.f(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // q6.a
    public SceneType getCurrentScene() {
        return this.currentScene;
    }

    @Override // q6.a
    public r6.a getScheduleDecision() {
        r6.b systemLoad = getSystemLoad();
        SceneType sceneTypeEvaluateScene = this.sceneEvaluator.evaluateScene(systemLoad);
        updateScene(sceneTypeEvaluateScene);
        return this.schedulePolicy.makeDecision(sceneTypeEvaluateScene, systemLoad);
    }

    @Override // q6.a
    public r6.b getSystemLoad() {
        return this.systemMonitor.getCurrentLoad();
    }

    @Override // q6.a
    public void refreshScene() {
        updateScene(this.sceneEvaluator.evaluateScene(getSystemLoad()));
    }

    @Override // q6.a
    public void removeSceneChangeListener(a.InterfaceC0129a listener) {
        g.f(listener, "listener");
        this.listeners.remove(listener);
    }

    public DefaultSceneAwareness(d systemMonitor, b sceneEvaluator, c schedulePolicy) {
        g.f(systemMonitor, "systemMonitor");
        g.f(sceneEvaluator, "sceneEvaluator");
        g.f(schedulePolicy, "schedulePolicy");
        this.systemMonitor = systemMonitor;
        this.sceneEvaluator = sceneEvaluator;
        this.schedulePolicy = schedulePolicy;
        this.currentScene = SceneType.f6193a;
        this.listeners = new CopyOnWriteArrayList<>();
    }

    public /* synthetic */ DefaultSceneAwareness(d dVar, b bVar, c cVar, int i10, e eVar) {
        this((i10 & 1) != 0 ? new DefaultSystemMonitor() : dVar, (i10 & 2) != 0 ? new DefaultSceneEvaluator() : bVar, (i10 & 4) != 0 ? new DefaultSchedulePolicy() : cVar);
    }
}
