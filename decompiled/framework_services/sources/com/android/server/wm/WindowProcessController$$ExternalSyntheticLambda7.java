package com.android.server.wm;

import com.android.internal.util.function.QuadConsumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WindowProcessController$$ExternalSyntheticLambda7 implements QuadConsumer {
    public /* synthetic */ WindowProcessController$$ExternalSyntheticLambda7() {
    }

    public final void accept(Object r1, Object r2, Object r3, Object r4) {
        ((WindowProcessListener) r1).updateProcessInfo(((Boolean) r2).booleanValue(), ((Boolean) r3).booleanValue(), ((Boolean) r4).booleanValue());
    }
}
