package C;

import C.f;
import C.g;
import android.graphics.Typeface;
import android.os.Handler;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final g.c f244a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f245b;

    /* renamed from: C.a$a, reason: collision with other inner class name */
    class RunnableC0007a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g.c f246a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f247b;

        RunnableC0007a(g.c cVar, Typeface typeface) {
            this.f246a = cVar;
            this.f247b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f246a.b(this.f247b);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g.c f249a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f250b;

        b(g.c cVar, int i5) {
            this.f249a = cVar;
            this.f250b = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f249a.a(this.f250b);
        }
    }

    a(g.c cVar, Handler handler) {
        this.f244a = cVar;
        this.f245b = handler;
    }

    private void a(int i5) {
        this.f245b.post(new b(this.f244a, i5));
    }

    private void c(Typeface typeface) {
        this.f245b.post(new RunnableC0007a(this.f244a, typeface));
    }

    void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f274a);
        } else {
            a(eVar.f275b);
        }
    }
}
