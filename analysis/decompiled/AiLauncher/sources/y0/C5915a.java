package y0;

import android.graphics.Typeface;
import java.util.concurrent.Executor;
import y0.f;
import y0.g;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5915a {

    /* renamed from: a, reason: collision with root package name */
    public final g.c f43746a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f43747b;

    /* renamed from: y0.a$a, reason: collision with other inner class name */
    public class RunnableC0554a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f43748a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f43749b;

        public RunnableC0554a(g.c cVar, Typeface typeface) {
            this.f43748a = cVar;
            this.f43749b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43748a.b(this.f43749b);
        }
    }

    /* renamed from: y0.a$b */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f43751a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f43752b;

        public b(g.c cVar, int i10) {
            this.f43751a = cVar;
            this.f43752b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43751a.a(this.f43752b);
        }
    }

    public C5915a(g.c cVar, Executor executor) {
        this.f43746a = cVar;
        this.f43747b = executor;
    }

    public final void a(int i10) {
        this.f43747b.execute(new b(this.f43746a, i10));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f43782a);
        } else {
            a(eVar.f43783b);
        }
    }

    public final void c(Typeface typeface) {
        this.f43747b.execute(new RunnableC0554a(this.f43746a, typeface));
    }
}
