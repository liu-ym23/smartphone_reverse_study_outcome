package com.android.server.appop;

import android.content.AttributionSource;
import android.os.IBinder;
import com.android.internal.util.function.QuadFunction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda2 implements QuadFunction {
    public final /* synthetic */ AppOpsService f$0;

    public /* synthetic */ AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda2(AppOpsService r1) {
        this.f$0 = r1;
    }

    public final Object apply(Object r2, Object r3, Object r4, Object r5) {
        return AppOpsService.CheckOpsDelegateDispatcher.$r8$lambda$5eJqmaakm_s_oGqpAQpTNSFr04s(this.f$0, (IBinder) r2, ((Integer) r3).intValue(), (AttributionSource) r4, ((Boolean) r5).booleanValue());
    }
}
