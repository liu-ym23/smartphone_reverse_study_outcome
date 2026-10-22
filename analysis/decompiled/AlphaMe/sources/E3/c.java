package E3;

import h3.C0611u;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f412a = new a();

    /* renamed from: c, reason: collision with root package name */
    public static volatile C0611u f414c = new C0611u(27);

    /* renamed from: e, reason: collision with root package name */
    public static volatile C0611u f416e = new C0611u(28);

    /* renamed from: d, reason: collision with root package name */
    public static volatile b f415d = new b(2);

    /* renamed from: f, reason: collision with root package name */
    public static volatile b f417f = new b(3);

    /* renamed from: g, reason: collision with root package name */
    public static volatile b f418g = new b(4);

    /* renamed from: b, reason: collision with root package name */
    public static volatile C0611u f413b = new C0611u(24);

    public static void a(Throwable th) {
        a aVar = f412a;
        if (aVar != null) {
            try {
                aVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static Throwable b(Throwable th) {
        b bVar = f417f;
        return bVar != null ? (Throwable) bVar.call(th) : th;
    }

    public static void c(t3.c cVar, t3.a aVar) {
        C0611u c0611u = f414c;
        if (c0611u != null) {
            switch (c0611u.f12973a) {
                case 27:
                    h.f420f.c().getClass();
                    break;
                default:
                    B0.g.y(cVar);
                    h.f420f.f().getClass();
                    break;
            }
        }
    }

    public static x3.a d(x3.a aVar) {
        b bVar = f415d;
        return bVar != null ? (x3.a) bVar.call(aVar) : aVar;
    }
}
