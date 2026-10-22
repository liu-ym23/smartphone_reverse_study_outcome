package com.android.server.wm;

import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ActivityStarter$$ExternalSyntheticLambda0 implements Predicate {
    public /* synthetic */ ActivityStarter$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r1) {
        return ((ActivityRecord) r1).canBeTopRunning();
    }
}
