package com.android.server.inputmethod;

import android.view.MotionEvent;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class HandwritingModeController$$ExternalSyntheticLambda1 implements Consumer {
    public /* synthetic */ HandwritingModeController$$ExternalSyntheticLambda1() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        ((MotionEvent) r1).recycle();
    }
}
