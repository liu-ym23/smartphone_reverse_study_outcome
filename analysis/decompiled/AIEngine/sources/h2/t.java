package h2;

import android.content.Context;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class t {
    public abstract void a(Context context, String str, WorkerParameters workerParameters);

    public final androidx.work.c b(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        kotlin.jvm.internal.g.f(appContext, "appContext");
        kotlin.jvm.internal.g.f(workerClassName, "workerClassName");
        kotlin.jvm.internal.g.f(workerParameters, "workerParameters");
        a(appContext, workerClassName, workerParameters);
        try {
            Class<? extends U> clsAsSubclass = Class.forName(workerClassName).asSubclass(androidx.work.c.class);
            kotlin.jvm.internal.g.e(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Object objNewInstance = clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(appContext, workerParameters);
                kotlin.jvm.internal.g.e(objNewInstance, "{\n                val co…Parameters)\n            }");
                androidx.work.c cVar = (androidx.work.c) objNewInstance;
                if (!cVar.isUsed()) {
                    return cVar;
                }
                throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + workerClassName + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
            } catch (Throwable th) {
                j.d().c(u.f9289a, "Could not instantiate ".concat(workerClassName), th);
                throw th;
            }
        } catch (Throwable th2) {
            j.d().c(u.f9289a, "Invalid class: ".concat(workerClassName), th2);
            throw th2;
        }
    }
}
