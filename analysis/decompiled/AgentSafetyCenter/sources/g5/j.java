package g5;

import android.content.Context;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f4321a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final j f4322b = new j();

    /* renamed from: c, reason: collision with root package name */
    public static final y f4323c = new y(1);

    /* renamed from: d, reason: collision with root package name */
    public static final y f4324d = new y(0);

    public t a(Context context, String str, WorkerParameters workerParameters) {
        context.getClass();
        str.getClass();
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str).asSubclass(t.class);
            clsAsSubclass.getClass();
            try {
                Object objNewInstance = clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                objNewInstance.getClass();
                t tVar = (t) objNewInstance;
                if (!tVar.f4341d) {
                    return tVar;
                }
                f.i("WorkerFactory (", getClass().getName(), ") returned an instance of a ListenableWorker (", str, ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
                return null;
            } catch (Throwable th) {
                u.d().c(g0.f4317a, "Could not instantiate ".concat(str), th);
                throw th;
            }
        } catch (Throwable th2) {
            u.d().c(g0.f4317a, "Invalid class: ".concat(str), th2);
            throw th2;
        }
    }
}
