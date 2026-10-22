package androidx.lifecycle;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class X extends AbstractC0318o {
    final /* synthetic */ Z this$0;

    public X(Z z4) {
        this.this$0 = z4;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.this$0.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Z z4 = this.this$0;
        int i4 = z4.f3906a + 1;
        z4.f3906a = i4;
        if (i4 == 1 && z4.f3909d) {
            z4.f3911f.e(EnumC0326x.ON_START);
            z4.f3909d = false;
        }
    }
}
