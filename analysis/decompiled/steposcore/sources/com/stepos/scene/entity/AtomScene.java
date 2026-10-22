package com.stepos.scene.entity;

import android.os.collector.base.StepOSBaseEntity;
import java.util.List;

/* loaded from: classes.dex */
public class AtomScene extends BaseScene {
    private int atomId;
    private AtomSceneCondition exitCondition;
    private AtomSceneCondition triggerCondition;

    public AtomScene() {
    }

    public AtomScene(int sceneId, String name, int atomId, AtomSceneCondition triggerCondition, AtomSceneCondition exitCondition, int priority, List<String> mutexGroups) {
        super(sceneId, name, priority, mutexGroups);
        this.atomId = atomId;
        this.triggerCondition = triggerCondition;
        this.exitCondition = exitCondition;
    }

    public int getAtomId() {
        return this.atomId;
    }

    public void setAtomId(int atomId) {
        this.atomId = atomId;
    }

    @Override // com.stepos.scene.entity.BaseScene, com.stepos.scene.entity.CustomScene
    public String getSceneType() {
        return "ATOMIC";
    }

    public AtomSceneCondition getTriggerCondition() {
        return this.triggerCondition;
    }

    public void setTriggerCondition(AtomSceneCondition triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public void setTriggerCondition(String triggerCondition) {
        this.triggerCondition = new AtomSceneCondition(triggerCondition);
    }

    public AtomSceneCondition getExitCondition() {
        return this.exitCondition;
    }

    public void setExitCondition(AtomSceneCondition exitCondition) {
        this.exitCondition = exitCondition;
    }

    public void setExitCondition(String exitCondition) {
        this.exitCondition = new AtomSceneCondition(exitCondition);
    }

    public boolean evaluateTriggerCondition(StepOSBaseEntity data) throws Exception {
        return this.triggerCondition != null && this.triggerCondition.evaluate(data);
    }

    public boolean evaluateExitCondition(StepOSBaseEntity data) throws Exception {
        return this.exitCondition != null && this.exitCondition.evaluate(data);
    }
}
