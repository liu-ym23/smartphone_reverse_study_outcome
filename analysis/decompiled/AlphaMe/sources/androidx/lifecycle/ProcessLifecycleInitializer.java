package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n0.C0774a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "Ln0/b;", "Landroidx/lifecycle/G;", "<init>", "()V", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements n0.b {
    @Override // n0.b
    public final Object create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        C0774a c0774aC = C0774a.c(context);
        Intrinsics.checkNotNullExpressionValue(c0774aC, "getInstance(context)");
        if (!c0774aC.f13648b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
        }
        AtomicBoolean atomicBoolean = D.f3866a;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!D.f3866a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new C());
        }
        Z z4 = Z.f3905h;
        Intrinsics.checkNotNullParameter(context, "context");
        Z z5 = Z.f3905h;
        z5.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        z5.f3910e = new Handler();
        z5.f3911f.e(EnumC0326x.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new Y(z5));
        return z5;
    }

    @Override // n0.b
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }
}
