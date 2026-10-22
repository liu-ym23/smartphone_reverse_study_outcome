package xc;

import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* loaded from: classes5.dex */
public class b implements e, xc.a {

    /* renamed from: c, reason: collision with root package name */
    public static String f43635c = "xc.b";

    /* renamed from: a, reason: collision with root package name */
    public wc.a f43636a;

    /* renamed from: b, reason: collision with root package name */
    public vc.c f43637b;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43638a;

        static {
            int[] iArr = new int[Level.values().length];
            f43638a = iArr;
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43638a[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43638a[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43638a[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43638a[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public b(vc.c cVar, Level level) {
        this.f43637b = cVar;
        this.f43636a = new wc.a(level, cVar);
    }

    @Override // xc.e
    public void a(String str) {
        this.f43636a.k(str);
        g(this.f43636a);
    }

    @Override // xc.a
    public void b(String str) {
        this.f43636a.j(str);
    }

    @Override // xc.e
    public e c(Throwable th) {
        this.f43636a.l(th);
        return this;
    }

    @Override // xc.e
    public e d(Object obj) {
        this.f43636a.e(obj);
        return this;
    }

    @Override // xc.e
    public e e(Marker marker) {
        this.f43636a.g(marker);
        return this;
    }

    @Override // xc.e
    public e f(String str, Object obj) {
        this.f43636a.f(str, obj);
        return this;
    }

    public void g(wc.c cVar) {
        if (cVar.d() == null) {
            b(f43635c);
        }
        vc.c cVar2 = this.f43637b;
        if (cVar2 instanceof d) {
            ((d) cVar2).a(cVar);
        } else if (cVar2 instanceof c) {
            h((c) cVar2, cVar);
        } else {
            i(cVar);
        }
    }

    public final void h(c cVar, wc.c cVar2) {
        cVar2.getMessage();
        cVar2.b();
        cVar.s(null, cVar2.d(), cVar2.getLevel().toInt(), l(cVar2), cVar2.a(), cVar2.getThrowable());
    }

    public final void i(wc.c cVar) {
        Object[] objArrA = cVar.a();
        int length = objArrA == null ? 0 : objArrA.length;
        Throwable throwable = cVar.getThrowable();
        Object[] objArr = new Object[(throwable == null ? 0 : 1) + length];
        if (objArrA != null) {
            System.arraycopy(objArrA, 0, objArr, 0, length);
        }
        if (throwable != null) {
            objArr[length] = throwable;
        }
        String strL = l(cVar);
        int i10 = a.f43638a[cVar.getLevel().ordinal()];
        if (i10 == 1) {
            this.f43637b.trace(strL, objArr);
            return;
        }
        if (i10 == 2) {
            this.f43637b.debug(strL, objArr);
            return;
        }
        if (i10 == 3) {
            this.f43637b.info(strL, objArr);
        } else if (i10 == 4) {
            this.f43637b.warn(strL, objArr);
        } else {
            if (i10 != 5) {
                return;
            }
            this.f43637b.error(strL, objArr);
        }
    }

    public final StringBuilder j(List<wc.b> list, StringBuilder sb2) {
        if (list != null && !list.isEmpty()) {
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            for (wc.b bVar : list) {
                sb2.append(bVar.f43264a);
                sb2.append('=');
                sb2.append(bVar.f43265b);
                sb2.append(' ');
            }
        }
        return sb2;
    }

    public final StringBuilder k(List<Marker> list, StringBuilder sb2) {
        if (list != null && !list.isEmpty()) {
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            Iterator<Marker> it = list.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(' ');
            }
        }
        return sb2;
    }

    public final String l(wc.c cVar) {
        return m(cVar.getMessage(), j(cVar.c(), k(cVar.b(), null)));
    }

    public final String m(String str, StringBuilder sb2) {
        if (sb2 == null) {
            return str;
        }
        sb2.append(str);
        return sb2.toString();
    }
}
