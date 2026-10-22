package com.android.server.wm;

import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ActivityRecord$$ExternalSyntheticLambda7 implements Predicate {
    public /* synthetic */ ActivityRecord$$ExternalSyntheticLambda7() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r1) {
        return ((TaskFragment) r1).isEmbedded();
    }
}
