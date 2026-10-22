package j;

import K.e0;
import K.f0;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f13112c;

    /* renamed from: d, reason: collision with root package name */
    public f0 f13113d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13114e;

    /* renamed from: b, reason: collision with root package name */
    public long f13111b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final l f13115f = new l(this);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13110a = new ArrayList();

    public final void a() {
        if (this.f13114e) {
            Iterator it = this.f13110a.iterator();
            while (it.hasNext()) {
                ((e0) it.next()).b();
            }
            this.f13114e = false;
        }
    }

    public final void b(e0 e0Var) {
        if (this.f13114e) {
            return;
        }
        this.f13110a.add(e0Var);
    }

    public final void c(long j4) {
        if (this.f13114e) {
            return;
        }
        this.f13111b = j4;
    }

    public final void d(Interpolator interpolator) {
        if (this.f13114e) {
            return;
        }
        this.f13112c = interpolator;
    }

    public final void e(f0 f0Var) {
        if (this.f13114e) {
            return;
        }
        this.f13113d = f0Var;
    }

    public final void f() {
        if (this.f13114e) {
            return;
        }
        Iterator it = this.f13110a.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            long j4 = this.f13111b;
            if (j4 >= 0) {
                e0Var.c(j4);
            }
            Interpolator interpolator = this.f13112c;
            if (interpolator != null) {
                e0Var.d(interpolator);
            }
            if (this.f13113d != null) {
                e0Var.e(this.f13115f);
            }
            e0Var.g();
        }
        this.f13114e = true;
    }
}
