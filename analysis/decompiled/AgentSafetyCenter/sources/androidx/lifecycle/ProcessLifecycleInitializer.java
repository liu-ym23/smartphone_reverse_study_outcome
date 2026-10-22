package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements b5.b {
    @Override // b5.b
    public final List a() {
        return kb.s.f7404c;
    }

    @Override // b5.b
    public final Object b(Context context) {
        context.getClass();
        b5.a aVarC = b5.a.c(context);
        aVarC.getClass();
        if (!aVarC.f1904b.contains(ProcessLifecycleInitializer.class)) {
            od.f.e("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        if (!u.f1441a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new t());
        }
        g0 g0Var = g0.f1381l;
        g0Var.getClass();
        g0Var.i = new Handler();
        g0Var.f1386j.f(o.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new f0(g0Var));
        return g0Var;
    }
}
