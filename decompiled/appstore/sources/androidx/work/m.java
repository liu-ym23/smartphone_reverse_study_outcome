package androidx.work;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5913a = null;

    public class a extends m {
        public a() {
        }

        @Override // androidx.work.m
        public h a(Context r10, String r11, WorkerParameters r12) {
            return null;
        }
    }

    static {
        f5913a = i.i("WorkerFactory");
    }

    public m() {
    }

    public static m c() {
        return new a();
    }

    public abstract h a(Context r10, String r11, WorkerParameters r12);

    public final h b(Context r10, String r11, WorkerParameters r12) {
        h r13 = a(r10, r11, r12);
        if (r13 == null) goto L20;
    L13:
        if (r13 != null) goto L15;
    L19:
        return r13;
    L15:
        if (r13.i() == false) goto L19;
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + r11 + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    L20:
        Class r14 = Class.forName(r11).asSubclass(h.class);     // Catch: Throwable -> L6
    L8:
        if (r14 == null) goto L13;
        r13 = (h) r14.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{r10, r12});     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        i.e().d(f5913a, "Could not instantiate " + r11, th);
    L6:
        th = move-exception;
        i.e().d(f5913a, "Invalid class: " + r11, th);
        r14 = null;
        goto L8
    }
}
