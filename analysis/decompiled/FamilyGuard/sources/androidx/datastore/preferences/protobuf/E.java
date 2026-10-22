package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public class E {

    /* renamed from: e, reason: collision with root package name */
    private static final C0496p f9928e = C0496p.b();

    /* renamed from: a, reason: collision with root package name */
    private AbstractC0488h f9929a;

    /* renamed from: b, reason: collision with root package name */
    private C0496p f9930b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile S f9931c;

    /* renamed from: d, reason: collision with root package name */
    private volatile AbstractC0488h f9932d;

    protected void a(S s5) {
        if (this.f9931c != null) {
            return;
        }
        synchronized (this) {
            if (this.f9931c != null) {
                return;
            }
            try {
                if (this.f9929a != null) {
                    this.f9931c = s5.j().a(this.f9929a, this.f9930b);
                    this.f9932d = this.f9929a;
                } else {
                    this.f9931c = s5;
                    this.f9932d = AbstractC0488h.f10009b;
                }
            } catch (B unused) {
                this.f9931c = s5;
                this.f9932d = AbstractC0488h.f10009b;
            }
        }
    }

    public int b() {
        if (this.f9932d != null) {
            return this.f9932d.size();
        }
        AbstractC0488h abstractC0488h = this.f9929a;
        if (abstractC0488h != null) {
            return abstractC0488h.size();
        }
        if (this.f9931c != null) {
            return this.f9931c.g();
        }
        return 0;
    }

    public S c(S s5) {
        a(s5);
        return this.f9931c;
    }

    public S d(S s5) {
        S s6 = this.f9931c;
        this.f9929a = null;
        this.f9932d = null;
        this.f9931c = s5;
        return s6;
    }

    public AbstractC0488h e() {
        if (this.f9932d != null) {
            return this.f9932d;
        }
        AbstractC0488h abstractC0488h = this.f9929a;
        if (abstractC0488h != null) {
            return abstractC0488h;
        }
        synchronized (this) {
            try {
                if (this.f9932d != null) {
                    return this.f9932d;
                }
                if (this.f9931c == null) {
                    this.f9932d = AbstractC0488h.f10009b;
                } else {
                    this.f9932d = this.f9931c.e();
                }
                return this.f9932d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e6 = (E) obj;
        S s5 = this.f9931c;
        S s6 = e6.f9931c;
        return (s5 == null && s6 == null) ? e().equals(e6.e()) : (s5 == null || s6 == null) ? s5 != null ? s5.equals(e6.c(s5.b())) : c(s6.b()).equals(s6) : s5.equals(s6);
    }

    public int hashCode() {
        return 1;
    }
}
