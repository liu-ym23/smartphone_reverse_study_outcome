package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements b2.b<q> {
    @Override // b2.b
    public final List<Class<? extends b2.b<?>>> a() {
        return EmptyList.f10001a;
    }

    @Override // b2.b
    public final q b(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        b2.a aVarC = b2.a.c(context);
        kotlin.jvm.internal.g.e(aVarC, "getInstance(...)");
        if (!aVarC.f3039b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!n.f2292a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.g.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new n.a());
        }
        b0 b0Var = b0.f2247k;
        b0Var.getClass();
        b0Var.f2252e = new Handler();
        b0Var.h.f(Lifecycle.Event.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        kotlin.jvm.internal.g.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new a0(b0Var));
        return b0Var;
    }
}
