package com.android.server.wm;

import java.util.function.BiPredicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DisplayContent$$ExternalSyntheticLambda8 implements BiPredicate {
    public /* synthetic */ DisplayContent$$ExternalSyntheticLambda8() {
    }

    @Override // java.util.function.BiPredicate
    public final boolean test(Object r1, Object r2) {
        return ((ActivityRecord) r1).isUid(((Integer) r2).intValue());
    }
}
