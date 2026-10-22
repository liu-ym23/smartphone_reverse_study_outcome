package og;

import androidx.lifecycle.p;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f22620f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final og.b f22621g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f22622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f22623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f22624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f22625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f22626e;

    public static class a extends og.b {
        public a() {
        }
    }

    public class b extends og.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f22627a;

        public b(f r10) {
            this.f22627a = r10;
        }
    }

    static {
        f22620f = new f();
        f22621g = new a();
    }

    public f() {
        this.f22622a = new AtomicReference();
        this.f22623b = new AtomicReference();
        this.f22624c = new AtomicReference();
        this.f22625d = new AtomicReference();
        this.f22626e = new AtomicReference();
    }

    public static f c() {
        return f22620f;
    }

    public static Object e(Class r10, Properties r11) {
        Properties r12 = (Properties) r11.clone();
        String r13 = r10.getSimpleName();
        String r14 = r12.getProperty("rxjava.plugin." + r13 + ".implementation");
        if (r14 != null) goto L18;
        Iterator r15 = r12.entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L18;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = r16.getKey().toString();
        if (r17.startsWith("rxjava.plugin.") == false) goto L6;
        if (r17.endsWith(".class") == false) goto L6;
        if (r13.equals(r16.getValue().toString()) == false) goto L6;
        String r18 = "rxjava.plugin." + r17.substring(0, r17.length() - 6).substring(14) + ".impl";
        String r19 = r12.getProperty(r18);
        if (r19 == null) goto L17;
        r14 = r19;
        goto L18
    L17:
        throw new IllegalStateException("Implementing class declaration for " + r13 + " missing: " + r18);
    L18:
        if (r14 != null) goto L39;
        return null;
    L39:
        return Class.forName(r14).asSubclass(r10).newInstance();
    L27:
        e = move-exception;
        throw new IllegalStateException(r13 + " implementation is not an instance of " + r13 + ": " + r14, e);
    L25:
        e = move-exception;
        throw new IllegalStateException(r13 + " implementation class not found: " + r14, e);
    L21:
        e = move-exception;
        throw new IllegalStateException(r13 + " implementation not able to be accessed: " + r14, e);
    L23:
        e = move-exception;
        throw new IllegalStateException(r13 + " implementation not able to be instantiated: " + r14, e);
    }

    public og.a a() {
        if (this.f22625d.get() != null) goto L9;
        Object r10 = e(og.a.class, System.getProperties());
        if (r10 != null) goto L7;
        p.a(this.f22625d, null, new b(this));
        goto L9
    L7:
        p.a(this.f22625d, null, (og.a) r10);
    L9:
        return (og.a) this.f22625d.get();
    }

    public og.b b() {
        if (this.f22622a.get() != null) goto L9;
        Object r10 = e(og.b.class, System.getProperties());
        if (r10 != null) goto L7;
        p.a(this.f22622a, null, f22621g);
        goto L9
    L7:
        p.a(this.f22622a, null, (og.b) r10);
    L9:
        return (og.b) this.f22622a.get();
    }

    public d d() {
        if (this.f22623b.get() != null) goto L9;
        Object r10 = e(d.class, System.getProperties());
        if (r10 != null) goto L7;
        p.a(this.f22623b, null, e.f());
        goto L9
    L7:
        p.a(this.f22623b, null, (d) r10);
    L9:
        return (d) this.f22623b.get();
    }

    public g f() {
        if (this.f22626e.get() != null) goto L9;
        Object r10 = e(g.class, System.getProperties());
        if (r10 != null) goto L7;
        p.a(this.f22626e, null, g.h());
        goto L9
    L7:
        p.a(this.f22626e, null, (g) r10);
    L9:
        return (g) this.f22626e.get();
    }

    public h g() {
        if (this.f22624c.get() != null) goto L9;
        Object r10 = e(h.class, System.getProperties());
        if (r10 != null) goto L7;
        p.a(this.f22624c, null, i.f());
        goto L9
    L7:
        p.a(this.f22624c, null, (h) r10);
    L9:
        return (h) this.f22624c.get();
    }
}
