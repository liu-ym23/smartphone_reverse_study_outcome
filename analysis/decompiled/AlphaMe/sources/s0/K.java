package s0;

import android.content.Context;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public abstract class K {

    /* renamed from: a, reason: collision with root package name */
    public static final String f14166a = t.f("WorkerFactory");

    public final s a(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = f14166a;
        s sVar = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(s.class);
        } catch (Throwable th) {
            t.d().c(str2, "Invalid class: " + str, th);
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                sVar = (s) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                t.d().c(str2, "Could not instantiate " + str, th2);
            }
        }
        if (sVar == null || !sVar.isUsed()) {
            return sVar;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
