package com.stepos.scene.entity;

import java.util.List;

/* loaded from: classes.dex */
public class SceneConfig {
    private List<AtomScene> atomicScenes;
    private List<CompositeScene> compositeScenes;
    private List<AbstractCustomScene> customScenes;

    public SceneConfig() {
    }

    public SceneConfig(List<AtomScene> atomicScenes, List<CompositeScene> compositeScenes) {
        this.atomicScenes = atomicScenes;
        this.compositeScenes = compositeScenes;
    }

    public List<AtomScene> getAtomicScenes() {
        return this.atomicScenes;
    }

    public void setAtomicScenes(List<AtomScene> atomicScenes) {
        this.atomicScenes = atomicScenes;
    }

    public List<CompositeScene> getCompositeScenes() {
        return this.compositeScenes;
    }

    public void setCompositeScenes(List<CompositeScene> compositeScenes) {
        this.compositeScenes = compositeScenes;
    }

    public List<AbstractCustomScene> getCustomScenes() {
        return this.customScenes;
    }

    public void setCustomScenes(List<AbstractCustomScene> customScenes) {
        this.customScenes = customScenes;
    }
}
