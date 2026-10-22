package com.android.server.devicepolicy;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DevicePolicyManagerService$$ExternalSyntheticLambda214 implements Executor {
    public final /* synthetic */ Handler f$0;

    public /* synthetic */ DevicePolicyManagerService$$ExternalSyntheticLambda214(Handler r1) {
        this.f$0 = r1;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        this.f$0.post(r2);
    }
}
