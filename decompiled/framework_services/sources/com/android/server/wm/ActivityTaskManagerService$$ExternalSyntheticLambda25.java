package com.android.server.wm;

import android.app.ActivityManagerInternal;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ActivityTaskManagerService$$ExternalSyntheticLambda25 implements BiConsumer {
    public /* synthetic */ ActivityTaskManagerService$$ExternalSyntheticLambda25() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((ActivityManagerInternal) r1).updateOomLevelsForDisplay(((Integer) r2).intValue());
    }
}
