package i;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.core.view.W;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f33052c;

    /* renamed from: d, reason: collision with root package name */
    public V f33053d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f33054e;

    /* renamed from: b, reason: collision with root package name */
    public long f33051b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final W f33055f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<U> f33050a = new ArrayList<>();

    public class a extends W {

        /* renamed from: a, reason: collision with root package name */
        public boolean f33056a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f33057b = 0;

        public a() {
        }

        public void a() {
            this.f33057b = 0;
            this.f33056a = false;
            h.this.b();
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            int i10 = this.f33057b + 1;
            this.f33057b = i10;
            if (i10 == h.this.f33050a.size()) {
                V v10 = h.this.f33053d;
                if (v10 != null) {
                    v10.d(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void e(View view) {
            if (this.f33056a) {
                return;
            }
            this.f33056a = true;
            V v10 = h.this.f33053d;
            if (v10 != null) {
                v10.e(null);
            }
        }
    }

    public void a() {
        if (this.f33054e) {
            Iterator<U> it = this.f33050a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f33054e = false;
        }
    }

    public void b() {
        this.f33054e = false;
    }

    public h c(U u10) {
        if (!this.f33054e) {
            this.f33050a.add(u10);
        }
        return this;
    }

    public h d(U u10, U u11) {
        this.f33050a.add(u10);
        u11.j(u10.d());
        this.f33050a.add(u11);
        return this;
    }

    public h e(long j10) {
        if (!this.f33054e) {
            this.f33051b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f33054e) {
            this.f33052c = interpolator;
        }
        return this;
    }

    public h g(V v10) {
        if (!this.f33054e) {
            this.f33053d = v10;
        }
        return this;
    }

    public void h() {
        if (this.f33054e) {
            return;
        }
        Iterator<U> it = this.f33050a.iterator();
        while (it.hasNext()) {
            U next = it.next();
            long j10 = this.f33051b;
            if (j10 >= 0) {
                next.f(j10);
            }
            Interpolator interpolator = this.f33052c;
            if (interpolator != null) {
                next.g(interpolator);
            }
            if (this.f33053d != null) {
                next.h(this.f33055f);
            }
            next.l();
        }
        this.f33054e = true;
    }
}
