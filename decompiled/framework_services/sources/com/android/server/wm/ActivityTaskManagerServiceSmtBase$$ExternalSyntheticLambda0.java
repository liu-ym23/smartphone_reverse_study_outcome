package com.android.server.wm;

import android.app.ActivityManagerInternal;
import com.android.internal.util.function.QuintConsumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ActivityTaskManagerServiceSmtBase$$ExternalSyntheticLambda0 implements QuintConsumer {
    public /* synthetic */ ActivityTaskManagerServiceSmtBase$$ExternalSyntheticLambda0() {
    }

    public final void accept(Object r1, Object r2, Object r3, Object r4, Object r5) {
        ((ActivityManagerInternal) r1).hotWarmStartSvpSetting((String) r2, ((Integer) r3).intValue(), ((Integer) r4).intValue(), ((Integer) r5).intValue());
    }
}
