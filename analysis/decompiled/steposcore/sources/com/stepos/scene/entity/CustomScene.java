package com.stepos.scene.entity;

import android.os.collector.base.StepOSBaseEntity;

/* loaded from: classes.dex */
public interface CustomScene {
    boolean evaluateCondition(StepOSBaseEntity stepOSBaseEntity);

    default String getSceneType() {
        return "CUSTOM";
    }
}
