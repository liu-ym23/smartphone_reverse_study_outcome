package com.android.server.am;

import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ErrorDialogController$$ExternalSyntheticLambda0 implements Consumer {
    public /* synthetic */ ErrorDialogController$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        ((BaseErrorDialog) r1).dismiss();
    }
}
