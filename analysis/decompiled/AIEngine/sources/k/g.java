package k;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import mb.y;
import v0.h0;
import v0.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f9824c;

    /* renamed from: d, reason: collision with root package name */
    public i0 f9825d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9826e;

    /* renamed from: b, reason: collision with root package name */
    public long f9823b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final a f9827f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<h0> f9822a = new ArrayList<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends y {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9828a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f9829b = 0;

        public a() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            int i10 = this.f9829b + 1;
            this.f9829b = i10;
            g gVar = g.this;
            if (i10 == gVar.f9822a.size()) {
                i0 i0Var = gVar.f9825d;
                if (i0Var != null) {
                    i0Var.d(null);
                }
                this.f9829b = 0;
                this.f9828a = false;
                gVar.f9826e = false;
            }
        }

        @Override // mb.y, v0.i0
        public final void e(View view) {
            if (this.f9828a) {
                return;
            }
            this.f9828a = true;
            i0 i0Var = g.this.f9825d;
            if (i0Var != null) {
                i0Var.e(null);
            }
        }
    }

    public final void a() {
        if (this.f9826e) {
            ArrayList<h0> arrayList = this.f9822a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                h0 h0Var = arrayList.get(i10);
                i10++;
                h0Var.b();
            }
            this.f9826e = false;
        }
    }

    public final void b(h0 h0Var) {
        if (this.f9826e) {
            return;
        }
        this.f9822a.add(h0Var);
    }

    public final void c(long j10) {
        if (this.f9826e) {
            return;
        }
        this.f9823b = j10;
    }

    public final void d(Interpolator interpolator) {
        if (this.f9826e) {
            return;
        }
        this.f9824c = interpolator;
    }

    public final void e(i0 i0Var) {
        if (this.f9826e) {
            return;
        }
        this.f9825d = i0Var;
    }

    public final void f() {
        if (this.f9826e) {
            return;
        }
        ArrayList<h0> arrayList = this.f9822a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            h0 h0Var = arrayList.get(i10);
            i10++;
            h0 h0Var2 = h0Var;
            long j10 = this.f9823b;
            if (j10 >= 0) {
                h0Var2.c(j10);
            }
            Interpolator interpolator = this.f9824c;
            if (interpolator != null) {
                h0Var2.d(interpolator);
            }
            if (this.f9825d != null) {
                h0Var2.e(this.f9827f);
            }
            h0Var2.g();
        }
        this.f9826e = true;
    }
}
