package z0;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0998f f16408a;

    /* renamed from: b, reason: collision with root package name */
    public final C0993a f16409b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0998f f16410c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0998f f16411d;

    public l(Context context, E0.a taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        C0993a batteryChargingTracker = new C0993a(applicationContext, taskExecutor, 0);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        C0993a batteryNotLowTracker = new C0993a(applicationContext2, taskExecutor, 1);
        Context context2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context.applicationContext");
        String str = AbstractC1002j.f16406a;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        C1001i networkStateTracker = new C1001i(context2, taskExecutor);
        Context applicationContext3 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "context.applicationContext");
        C0993a storageNotLowTracker = new C0993a(applicationContext3, taskExecutor, 2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Intrinsics.checkNotNullParameter(batteryChargingTracker, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(batteryNotLowTracker, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(networkStateTracker, "networkStateTracker");
        Intrinsics.checkNotNullParameter(storageNotLowTracker, "storageNotLowTracker");
        this.f16408a = batteryChargingTracker;
        this.f16409b = batteryNotLowTracker;
        this.f16410c = networkStateTracker;
        this.f16411d = storageNotLowTracker;
    }
}
