package wc;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* loaded from: classes5.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public vc.c f43256a;

    /* renamed from: b, reason: collision with root package name */
    public Level f43257b;

    /* renamed from: c, reason: collision with root package name */
    public String f43258c;

    /* renamed from: d, reason: collision with root package name */
    public List<Marker> f43259d;

    /* renamed from: e, reason: collision with root package name */
    public List<Object> f43260e;

    /* renamed from: f, reason: collision with root package name */
    public List<b> f43261f;

    /* renamed from: g, reason: collision with root package name */
    public Throwable f43262g;

    /* renamed from: h, reason: collision with root package name */
    public String f43263h;

    public a(Level level, vc.c cVar) {
        this.f43256a = cVar;
        this.f43257b = level;
    }

    @Override // wc.c
    public Object[] a() {
        List<Object> list = this.f43260e;
        if (list == null) {
            return null;
        }
        return list.toArray();
    }

    @Override // wc.c
    public List<Marker> b() {
        return this.f43259d;
    }

    @Override // wc.c
    public List<b> c() {
        return this.f43261f;
    }

    @Override // wc.c
    public String d() {
        return this.f43263h;
    }

    public void e(Object obj) {
        h().add(obj);
    }

    public void f(String str, Object obj) {
        i().add(new b(str, obj));
    }

    public void g(Marker marker) {
        if (this.f43259d == null) {
            this.f43259d = new ArrayList(2);
        }
        this.f43259d.add(marker);
    }

    @Override // wc.c
    public Level getLevel() {
        return this.f43257b;
    }

    @Override // wc.c
    public String getMessage() {
        return this.f43258c;
    }

    @Override // wc.c
    public Throwable getThrowable() {
        return this.f43262g;
    }

    public final List<Object> h() {
        if (this.f43260e == null) {
            this.f43260e = new ArrayList(3);
        }
        return this.f43260e;
    }

    public final List<b> i() {
        if (this.f43261f == null) {
            this.f43261f = new ArrayList(4);
        }
        return this.f43261f;
    }

    public void j(String str) {
        this.f43263h = str;
    }

    public void k(String str) {
        this.f43258c = str;
    }

    public void l(Throwable th) {
        this.f43262g = th;
    }
}
