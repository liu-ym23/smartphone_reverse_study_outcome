package k;

import android.view.animation.Interpolator;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import n3.o0;
import n3.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6853a;

    /* renamed from: b, reason: collision with root package name */
    public long f6854b = -1;

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f6855c;

    /* renamed from: d, reason: collision with root package name */
    public p0 f6856d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6857e;

    /* renamed from: f, reason: collision with root package name */
    public final j f6858f;

    public k() {
        j jVar = new j(0);
        jVar.f6852j = this;
        jVar.f6851h = false;
        jVar.i = 0;
        VarHandle.storeStoreFence();
        this.f6858f = jVar;
        this.f6853a = new ArrayList();
    }

    public final void a() {
        if (this.f6857e) {
            ArrayList arrayList = this.f6853a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((o0) obj).b();
            }
            this.f6857e = false;
        }
    }

    public final void b(o0 o0Var) {
        if (this.f6857e) {
            return;
        }
        this.f6853a.add(o0Var);
    }

    public final void c(long j10) {
        if (this.f6857e) {
            return;
        }
        this.f6854b = j10;
    }

    public final void d(Interpolator interpolator) {
        if (this.f6857e) {
            return;
        }
        this.f6855c = interpolator;
    }

    public final void e(p0 p0Var) {
        if (this.f6857e) {
            return;
        }
        this.f6856d = p0Var;
    }

    public final void f() {
        if (this.f6857e) {
            return;
        }
        ArrayList arrayList = this.f6853a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            o0 o0Var = (o0) obj;
            long j10 = this.f6854b;
            if (j10 >= 0) {
                o0Var.c(j10);
            }
            Interpolator interpolator = this.f6855c;
            if (interpolator != null) {
                o0Var.d(interpolator);
            }
            if (this.f6856d != null) {
                o0Var.e(this.f6858f);
            }
            o0Var.g();
        }
        this.f6857e = true;
    }
}
