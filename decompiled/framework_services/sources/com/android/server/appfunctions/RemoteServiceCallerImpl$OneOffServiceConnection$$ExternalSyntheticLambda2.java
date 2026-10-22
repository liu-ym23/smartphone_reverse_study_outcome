package com.android.server.appfunctions;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ RemoteServiceCaller.RunServiceCallCallback f$0;

    public /* synthetic */ RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda2(RemoteServiceCaller.RunServiceCallCallback r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onFailedToConnect();
    }
}
