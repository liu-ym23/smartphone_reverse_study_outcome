package com.stepos.scene.entity;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CompositeScene extends BaseScene {
    private String compositionExpression;
    private transient CompositionSceneCondition sceneComposition;

    public CompositeScene() {
    }

    public CompositeScene(int sceneId, String name, String compositionExpression, int priority, List<String> mutexGroups) {
        super(sceneId, name, priority, mutexGroups);
        this.compositionExpression = compositionExpression;
    }

    @Override // com.stepos.scene.entity.BaseScene, com.stepos.scene.entity.CustomScene
    public String getSceneType() {
        return "COMPOSITE";
    }

    public CompositionSceneCondition getSceneComposition() {
        if (this.sceneComposition == null && this.compositionExpression != null && !this.compositionExpression.isEmpty()) {
            this.sceneComposition = new CompositionSceneCondition(this.compositionExpression);
        }
        return this.sceneComposition;
    }

    public boolean evaluate(Map<Integer, Boolean> sceneStates) throws Exception {
        CompositionSceneCondition comp = getSceneComposition();
        return comp != null && comp.evaluate(sceneStates);
    }

    public List<Integer> getAllReferencedSceneIds() {
        CompositionSceneCondition comp = getSceneComposition();
        return comp != null ? comp.getAllSceneIds() : List.of();
    }

    public String getCompositionExpression() {
        return this.compositionExpression;
    }

    public void setCompositionExpression(String compositionExpression) {
        this.compositionExpression = compositionExpression;
        this.sceneComposition = null;
    }

    @Override // com.stepos.scene.entity.BaseScene
    public String toString() {
        return "CompositeScene{sceneId=" + this.sceneId + ", name='" + this.name + "', composition='" + this.compositionExpression + "', priority=" + this.priority + '}';
    }
}
