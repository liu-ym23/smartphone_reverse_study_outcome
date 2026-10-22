package y8;

import Bc.b;
import J8.l;
import Zb.d;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import u8.AbstractC5589a;
import u8.i;
import u8.m;
import y8.AbstractC5962j;
import y8.C5957e;
import y8.C5958f;

/* renamed from: y8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5961i extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final e f43957a;

    /* renamed from: b, reason: collision with root package name */
    public final h f43958b;

    /* renamed from: c, reason: collision with root package name */
    public final C5954b f43959c;

    /* renamed from: d, reason: collision with root package name */
    public final io.noties.markwon.image.i f43960d = new g(null);

    /* renamed from: y8.i$a */
    public class a implements m.c<C5956d> {
        public a() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, C5956d c5956d) {
            mVar.q(c5956d);
            String strN = c5956d.n();
            int length = mVar.length();
            mVar.builder().d(C5961i.s(strN));
            mVar.d(length, new C5953a(mVar.z().g(), new C5963k(strN, C5961i.this.f43958b, C5961i.this.f43959c, null, true), C5961i.this.f43957a.f43969a.e()));
            mVar.v(c5956d);
        }
    }

    /* renamed from: y8.i$b */
    public class b implements m.c<C5960h> {
        public b() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, C5960h c5960h) {
            String strM = c5960h.m();
            int length = mVar.length();
            mVar.builder().d(C5961i.s(strM));
            mVar.d(length, new C5955c(mVar.z().g(), new C5963k(strM, C5961i.this.f43958b, C5961i.this.f43960d, null, false), C5961i.this.f43957a.f43969a.j()));
        }
    }

    /* renamed from: y8.i$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC5962j.b f43963a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f43964b = true;

        /* renamed from: c, reason: collision with root package name */
        public boolean f43965c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f43966d;

        /* renamed from: e, reason: collision with root package name */
        public f f43967e;

        /* renamed from: f, reason: collision with root package name */
        public ExecutorService f43968f;

        public c(AbstractC5962j.b bVar) {
            this.f43963a = bVar;
        }

        public c g(boolean z10) {
            this.f43964b = z10;
            return this;
        }

        public c h(boolean z10) {
            this.f43965c = z10;
            return this;
        }

        public e i() {
            return new e(this);
        }

        public c j(f fVar) {
            this.f43967e = fVar;
            return this;
        }

        public c k(boolean z10) {
            this.f43966d = z10;
            return this;
        }

        public AbstractC5962j.b l() {
            return this.f43963a;
        }
    }

    /* renamed from: y8.i$d */
    public interface d {
        void a(c cVar);
    }

    /* renamed from: y8.i$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC5962j f43969a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f43970b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f43971c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f43972d;

        /* renamed from: e, reason: collision with root package name */
        public final f f43973e;

        /* renamed from: f, reason: collision with root package name */
        public final ExecutorService f43974f;

        public e(c cVar) {
            this.f43969a = cVar.f43963a.o();
            this.f43970b = cVar.f43964b;
            this.f43971c = cVar.f43965c;
            this.f43972d = cVar.f43966d;
            this.f43973e = cVar.f43967e;
            ExecutorService executorService = cVar.f43968f;
            this.f43974f = executorService == null ? Executors.newCachedThreadPool() : executorService;
        }
    }

    /* renamed from: y8.i$f */
    public interface f {
        Drawable a(String str, Throwable th);
    }

    /* renamed from: y8.i$g */
    public static class g extends io.noties.markwon.image.i {
        public g() {
        }

        @Override // io.noties.markwon.image.i
        public Rect a(io.noties.markwon.image.a aVar) {
            Rect bounds = aVar.g().getBounds();
            int iF = aVar.f();
            int iWidth = bounds.width();
            if (iWidth <= iF) {
                return bounds;
            }
            return new Rect(0, 0, iF, (int) ((iF / (iWidth / bounds.height())) + 0.5f));
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* renamed from: y8.i$h */
    public static class h extends io.noties.markwon.image.b {

        /* renamed from: a, reason: collision with root package name */
        public final e f43975a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f43976b = new Handler(Looper.getMainLooper());

        /* renamed from: c, reason: collision with root package name */
        public final Map<io.noties.markwon.image.a, Future<?>> f43977c = new HashMap(3);

        /* renamed from: y8.i$h$a */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ io.noties.markwon.image.a f43978a;

            public a(io.noties.markwon.image.a aVar) {
                this.f43978a = aVar;
            }

            public final void a() {
                C5963k c5963k = (C5963k) this.f43978a;
                h.this.l(this.f43978a, c5963k.q() ? h.this.j(c5963k) : h.this.k(c5963k));
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a();
                } catch (Throwable th) {
                    f fVar = h.this.f43975a.f43973e;
                    if (fVar == null) {
                        Log.e("JLatexMathPlugin", "Error displaying latex: `" + this.f43978a.b() + "`", th);
                        return;
                    }
                    Drawable drawableA = fVar.a(this.f43978a.b(), th);
                    if (drawableA != null) {
                        io.noties.markwon.image.f.a(drawableA);
                        h.this.l(this.f43978a, drawableA);
                    }
                }
            }
        }

        /* renamed from: y8.i$h$b */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ io.noties.markwon.image.a f43980a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Drawable f43981b;

            public b(io.noties.markwon.image.a aVar, Drawable drawable) {
                this.f43980a = aVar;
                this.f43981b = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f43977c.remove(this.f43980a) == null || !this.f43980a.k()) {
                    return;
                }
                this.f43980a.p(this.f43981b);
            }
        }

        public h(e eVar) {
            this.f43975a = eVar;
        }

        @Override // io.noties.markwon.image.b
        public void a(io.noties.markwon.image.a aVar) {
            Future<?> futureRemove = this.f43977c.remove(aVar);
            if (futureRemove != null) {
                futureRemove.cancel(true);
            }
            this.f43976b.removeCallbacksAndMessages(aVar);
        }

        @Override // io.noties.markwon.image.b
        public void b(io.noties.markwon.image.a aVar) {
            if (this.f43977c.get(aVar) == null) {
                this.f43977c.put(aVar, this.f43975a.f43974f.submit(new a(aVar)));
            }
        }

        @Override // io.noties.markwon.image.b
        public Drawable d(io.noties.markwon.image.a aVar) {
            return null;
        }

        public final Bc.b j(C5963k c5963k) {
            String strB = c5963k.b();
            AbstractC5962j abstractC5962j = this.f43975a.f43969a;
            abstractC5962j.a();
            abstractC5962j.d();
            int iE = abstractC5962j.e();
            b.a aVarG = Bc.b.a(strB).j(abstractC5962j.f()).g(abstractC5962j.c());
            if (iE != 0) {
                aVarG.i(iE);
            }
            return aVarG.h();
        }

        public final Bc.b k(C5963k c5963k) {
            String strB = c5963k.b();
            AbstractC5962j abstractC5962j = this.f43975a.f43969a;
            abstractC5962j.h();
            abstractC5962j.i();
            int iJ = abstractC5962j.j();
            b.a aVarJ = Bc.b.a(strB).j(abstractC5962j.k());
            if (iJ != 0) {
                aVarJ.i(iJ);
            }
            return aVarJ.h();
        }

        public final void l(io.noties.markwon.image.a aVar, Drawable drawable) {
            this.f43976b.postAtTime(new b(aVar, drawable), aVar, SystemClock.uptimeMillis());
        }
    }

    public C5961i(e eVar) {
        this.f43957a = eVar;
        this.f43958b = new h(eVar);
        this.f43959c = new C5954b(eVar.f43969a.b());
    }

    public static c q(float f10) {
        return new c(AbstractC5962j.g(f10));
    }

    public static C5961i r(float f10, d dVar) {
        c cVarQ = q(f10);
        dVar.a(cVarQ);
        return new C5961i(cVarQ.i());
    }

    public static String s(String str) {
        return str.replace('\n', ' ').trim();
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        o(bVar);
        p(bVar);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void e(TextView textView) {
        io.noties.markwon.image.d.b(textView);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void h(d.b bVar) {
        e eVar = this.f43957a;
        if (eVar.f43970b) {
            if (eVar.f43971c) {
                bVar.g(new C5958f.a());
            } else {
                bVar.g(new C5957e.a());
            }
        }
    }

    @Override // u8.AbstractC5589a, u8.i
    public void i(i.b bVar) {
        if (this.f43957a.f43972d) {
            ((l) bVar.a(l.class)).n().a(new C5959g());
        }
    }

    @Override // u8.AbstractC5589a, u8.i
    public void j(TextView textView, Spanned spanned) {
        io.noties.markwon.image.d.c(textView);
    }

    public final void o(m.b bVar) {
        if (this.f43957a.f43970b) {
            bVar.a(C5956d.class, new a());
        }
    }

    public final void p(m.b bVar) {
        if (this.f43957a.f43972d) {
            bVar.a(C5960h.class, new b());
        }
    }
}
