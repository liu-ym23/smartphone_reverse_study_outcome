package wc;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.h;

/* loaded from: classes5.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public Level f43266a;

    /* renamed from: b, reason: collision with root package name */
    public List<Marker> f43267b;

    /* renamed from: c, reason: collision with root package name */
    public String f43268c;

    /* renamed from: d, reason: collision with root package name */
    public h f43269d;

    /* renamed from: e, reason: collision with root package name */
    public String f43270e;

    /* renamed from: f, reason: collision with root package name */
    public String f43271f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f43272g;

    /* renamed from: h, reason: collision with root package name */
    public List<b> f43273h;

    /* renamed from: i, reason: collision with root package name */
    public long f43274i;

    /* renamed from: j, reason: collision with root package name */
    public Throwable f43275j;

    @Override // wc.c
    public Object[] a() {
        return this.f43272g;
    }

    @Override // wc.c
    public List<Marker> b() {
        return this.f43267b;
    }

    @Override // wc.c
    public List<b> c() {
        return this.f43273h;
    }

    public void e(Marker marker) {
        if (marker == null) {
            return;
        }
        if (this.f43267b == null) {
            this.f43267b = new ArrayList(2);
        }
        this.f43267b.add(marker);
    }

    public h f() {
        return this.f43269d;
    }

    public void g(Object[] objArr) {
        this.f43272g = objArr;
    }

    @Override // wc.c
    public Level getLevel() {
        return this.f43266a;
    }

    @Override // wc.c
    public String getMessage() {
        return this.f43271f;
    }

    @Override // wc.c
    public Throwable getThrowable() {
        return this.f43275j;
    }

    public void h(Level level) {
        this.f43266a = level;
    }

    public void i(h hVar) {
        this.f43269d = hVar;
    }

    public void j(String str) {
        this.f43268c = str;
    }

    public void k(String str) {
        this.f43271f = str;
    }

    public void l(String str) {
        this.f43270e = str;
    }

    public void m(Throwable th) {
        this.f43275j = th;
    }

    public void n(long j10) {
        this.f43274i = j10;
    }
}
