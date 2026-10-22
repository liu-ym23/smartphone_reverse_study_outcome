package com.android.server.appop;

import android.content.AttributionSource;
import android.os.IBinder;
import com.android.internal.util.function.UndecFunction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda6 implements UndecFunction {
    public final /* synthetic */ AppOpsService f$0;

    public /* synthetic */ AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda6(AppOpsService r1) {
        this.f$0 = r1;
    }

    public final Object apply(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return AppOpsService.CheckOpsDelegateDispatcher.$r8$lambda$Qiy_yvdentXgLxdC1JZ9pb7Y8QU(this.f$0, (IBinder) r2, ((Integer) r3).intValue(), (AttributionSource) r4, ((Boolean) r5).booleanValue(), ((Boolean) r6).booleanValue(), (String) r7, ((Boolean) r8).booleanValue(), ((Boolean) r9).booleanValue(), ((Integer) r10).intValue(), ((Integer) r11).intValue(), ((Integer) r12).intValue());
    }
}
