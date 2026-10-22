package com.obric.oui.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MotionScene {
    ArrayList<ConstraintSet> mConstraintSets;
    ArrayList<Transition> mTransitions;

    public MotionScene() {
        this.mTransitions = new ArrayList();
        this.mConstraintSets = new ArrayList();
    }

    public void addTransition(Transition r1) {
        this.mTransitions.add(r1);
    }

    public void addConstraintSet(ConstraintSet r1) {
        this.mConstraintSets.add(r1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{\n");
        if (this.mTransitions.isEmpty() == true) goto L10;
        r0.append("Transitions:{\n");
        Iterator<Transition> r1 = this.mTransitions.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.append(r1.next().toString());
        goto L6
    L8:
        r0.append("},\n");
    L10:
        if (this.mConstraintSets.isEmpty() == true) goto L16;
        r0.append("ConstraintSets:{\n");
        Iterator<ConstraintSet> r4 = this.mConstraintSets.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        r0.append(r4.next().toString());
        goto L13
    L15:
        r0.append("},\n");
    L16:
        r0.append("}\n");
        return r0.toString();
    }
}
