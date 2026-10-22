package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes3.dex */
public interface CoreMotionScene {
    String getConstraintSet(int r1);

    String getConstraintSet(String r1);

    String getTransition(String r1);

    void setConstraintSetContent(String r1, String r2);

    void setDebugName(String r1);

    void setTransitionContent(String r1, String r2);
}
