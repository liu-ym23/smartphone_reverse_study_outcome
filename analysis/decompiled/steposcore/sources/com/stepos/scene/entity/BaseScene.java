package com.stepos.scene.entity;

import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseScene {
    protected List<String> mutexGroups;
    protected String name;
    protected int priority;
    protected int sceneId;

    public abstract String getSceneType();

    public BaseScene() {
    }

    public BaseScene(int sceneId, String name, int priority, List<String> mutexGroups) {
        this.sceneId = sceneId;
        this.name = name;
        this.priority = priority;
        this.mutexGroups = mutexGroups;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<String> getMutexGroups() {
        return this.mutexGroups;
    }

    public void setMutexGroups(List<String> mutexGroups) {
        this.mutexGroups = mutexGroups;
    }

    public String toString() {
        return getClass().getSimpleName() + "{sceneId=" + this.sceneId + ", name='" + this.name + "', type='" + getSceneType() + "', priority=" + this.priority + ", mutexGroups=" + this.mutexGroups + '}';
    }
}
