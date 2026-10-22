package com.android.server.credentials;

import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda0 implements Consumer {
    public /* synthetic */ CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        ((ProviderSession) r1).invokeSession();
    }
}
