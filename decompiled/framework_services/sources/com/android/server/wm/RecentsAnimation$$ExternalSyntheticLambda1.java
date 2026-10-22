package com.android.server.wm;

import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RecentsAnimation$$ExternalSyntheticLambda1 implements Predicate {
    public /* synthetic */ RecentsAnimation$$ExternalSyntheticLambda1() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r1) {
        return ((ActivityRecord) r1).occludesParent();
    }
}
