package com.android.server.wm;

import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AppCompatSizeCompatModePolicy$$ExternalSyntheticLambda2 implements Consumer {
    public /* synthetic */ AppCompatSizeCompatModePolicy$$ExternalSyntheticLambda2() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        ((WindowState) r1).updateGlobalScale();
    }
}
