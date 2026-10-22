package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class Y extends AbstractC0318o {
    final /* synthetic */ Z this$0;

    public Y(Z z4) {
        this.this$0 = z4;
    }

    @Override // androidx.lifecycle.AbstractC0318o, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // androidx.lifecycle.AbstractC0318o, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Z z4 = this.this$0;
        int i4 = z4.f3907b - 1;
        z4.f3907b = i4;
        if (i4 == 0) {
            Handler handler = z4.f3910e;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(z4.f3912g, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @RequiresApi(29)
    public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        W.a(activity, new X(this.this$0));
    }

    @Override // androidx.lifecycle.AbstractC0318o, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Z z4 = this.this$0;
        int i4 = z4.f3906a - 1;
        z4.f3906a = i4;
        if (i4 == 0 && z4.f3908c) {
            z4.f3911f.e(EnumC0326x.ON_STOP);
            z4.f3909d = true;
        }
    }
}
