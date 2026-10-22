package com.android.server.appop;

import com.android.internal.util.function.QuadFunction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda4 implements QuadFunction {
    public final /* synthetic */ AppOpsService f$0;

    public /* synthetic */ AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda4(AppOpsService r1) {
        this.f$0 = r1;
    }

    public final Object apply(Object r2, Object r3, Object r4, Object r5) {
        return Integer.valueOf(AppOpsService.CheckOpsDelegateDispatcher.$r8$lambda$TqGvemNPXzXUjdqWw7kwupm3azw(this.f$0, ((Integer) r2).intValue(), ((Integer) r3).intValue(), ((Integer) r4).intValue(), (String) r5));
    }
}
