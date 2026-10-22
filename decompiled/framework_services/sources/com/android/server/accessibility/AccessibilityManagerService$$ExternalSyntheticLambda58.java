package com.android.server.accessibility;

import android.content.ComponentName;
import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessibilityManagerService$$ExternalSyntheticLambda58 implements Predicate {
    public final /* synthetic */ ComponentName f$0;

    public /* synthetic */ AccessibilityManagerService$$ExternalSyntheticLambda58(ComponentName r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r2) {
        return this.f$0.equals((ComponentName) r2);
    }
}
