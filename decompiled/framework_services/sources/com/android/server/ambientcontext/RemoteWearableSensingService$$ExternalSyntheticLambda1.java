package com.android.server.ambientcontext;

import android.os.IBinder;
import android.service.wearable.IWearableSensingService;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RemoteWearableSensingService$$ExternalSyntheticLambda1 implements Function {
    public /* synthetic */ RemoteWearableSensingService$$ExternalSyntheticLambda1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return IWearableSensingService.Stub.asInterface((IBinder) r1);
    }
}
