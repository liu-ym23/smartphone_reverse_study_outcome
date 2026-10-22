package com.stepos.scene.entity;

import android.os.collector.base.StepOSBaseEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractCustomScene extends BaseScene implements CustomScene {
    private int atomId;

    @Override // com.stepos.scene.entity.CustomScene
    public abstract boolean evaluateCondition(StepOSBaseEntity stepOSBaseEntity);

    public AbstractCustomScene() {
    }

    public AbstractCustomScene(int sceneId, String name, int atomId, int priority, List<String> mutexGroups) {
        super(sceneId, name, priority, mutexGroups);
        this.atomId = atomId;
    }

    public int getAtomId() {
        return this.atomId;
    }

    public void setAtomId(int atomId) {
        this.atomId = atomId;
    }

    @Override // com.stepos.scene.entity.BaseScene, com.stepos.scene.entity.CustomScene
    public String getSceneType() {
        return "CUSTOM";
    }
}
