package com.android.server.pm;

import android.content.pm.ShortcutInfo;
import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ShortcutPackage$$ExternalSyntheticLambda9 implements Predicate {
    public /* synthetic */ ShortcutPackage$$ExternalSyntheticLambda9() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r1) {
        return ((ShortcutInfo) r1).isNonManifestVisible();
    }
}
