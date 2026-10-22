package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "Lp3/b;", "Landroidx/lifecycle/v;", "<init>", "()V", "lifecycle-process"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements p3.b {
    @Override // p3.b
    public final List a() {
        return d7.z.f2978f;
    }

    @Override // p3.b
    public final Object b(Context context) {
        q7.k.e(context, "context");
        p3.a aVarC = p3.a.c(context);
        q7.k.d(aVarC, "getInstance(...)");
        if (!aVarC.f8400b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!s.f1029a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            q7.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new r());
        }
        c0 c0Var = c0.f980m;
        c0Var.getClass();
        c0Var.f985j = new Handler();
        c0Var.f986k.d(p.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        q7.k.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new b0(c0Var));
        return c0Var;
    }
}
