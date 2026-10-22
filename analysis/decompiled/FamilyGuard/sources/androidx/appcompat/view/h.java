package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.S;
import androidx.core.view.T;
import androidx.core.view.U;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f7771c;

    /* renamed from: d, reason: collision with root package name */
    T f7772d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7773e;

    /* renamed from: b, reason: collision with root package name */
    private long f7770b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final U f7774f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<S> f7769a = new ArrayList<>();

    class a extends U {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7775a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f7776b = 0;

        a() {
        }

        void a() {
            this.f7776b = 0;
            this.f7775a = false;
            h.this.b();
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            int i5 = this.f7776b + 1;
            this.f7776b = i5;
            if (i5 == h.this.f7769a.size()) {
                T t5 = h.this.f7772d;
                if (t5 != null) {
                    t5.d(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void e(View view) {
            if (this.f7775a) {
                return;
            }
            this.f7775a = true;
            T t5 = h.this.f7772d;
            if (t5 != null) {
                t5.e(null);
            }
        }
    }

    public void a() {
        if (this.f7773e) {
            ArrayList<S> arrayList = this.f7769a;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                S s5 = arrayList.get(i5);
                i5++;
                s5.c();
            }
            this.f7773e = false;
        }
    }

    void b() {
        this.f7773e = false;
    }

    public h c(S s5) {
        if (!this.f7773e) {
            this.f7769a.add(s5);
        }
        return this;
    }

    public h d(S s5, S s6) {
        this.f7769a.add(s5);
        s6.l(s5.d());
        this.f7769a.add(s6);
        return this;
    }

    public h e(long j5) {
        if (!this.f7773e) {
            this.f7770b = j5;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f7773e) {
            this.f7771c = interpolator;
        }
        return this;
    }

    public h g(T t5) {
        if (!this.f7773e) {
            this.f7772d = t5;
        }
        return this;
    }

    public void h() {
        if (this.f7773e) {
            return;
        }
        ArrayList<S> arrayList = this.f7769a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            S s5 = arrayList.get(i5);
            i5++;
            S s6 = s5;
            long j5 = this.f7770b;
            if (j5 >= 0) {
                s6.h(j5);
            }
            Interpolator interpolator = this.f7771c;
            if (interpolator != null) {
                s6.i(interpolator);
            }
            if (this.f7772d != null) {
                s6.j(this.f7774f);
            }
            s6.n();
        }
        this.f7773e = true;
    }
}
