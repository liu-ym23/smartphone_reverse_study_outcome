package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class t extends k {

    /* renamed from: R, reason: collision with root package name */
    int f11485R;

    /* renamed from: M, reason: collision with root package name */
    ArrayList<k> f11483M = new ArrayList<>();

    /* renamed from: Q, reason: collision with root package name */
    private boolean f11484Q = true;

    /* renamed from: S, reason: collision with root package name */
    boolean f11486S = false;

    /* renamed from: T, reason: collision with root package name */
    private int f11487T = 0;

    class a extends q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f11488a;

        a(k kVar) {
            this.f11488a = kVar;
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            this.f11488a.b0();
            kVar.X(this);
        }
    }

    static class b extends q {

        /* renamed from: a, reason: collision with root package name */
        t f11490a;

        b(t tVar) {
            this.f11490a = tVar;
        }

        @Override // androidx.transition.q, androidx.transition.k.f
        public void a(k kVar) {
            t tVar = this.f11490a;
            if (tVar.f11486S) {
                return;
            }
            tVar.i0();
            this.f11490a.f11486S = true;
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            t tVar = this.f11490a;
            int i5 = tVar.f11485R - 1;
            tVar.f11485R = i5;
            if (i5 == 0) {
                tVar.f11486S = false;
                tVar.u();
            }
            kVar.X(this);
        }
    }

    private void n0(k kVar) {
        this.f11483M.add(kVar);
        kVar.f11453r = this;
    }

    private void w0() {
        b bVar = new b(this);
        ArrayList<k> arrayList = this.f11483M;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            k kVar = arrayList.get(i5);
            i5++;
            kVar.b(bVar);
        }
        this.f11485R = this.f11483M.size();
    }

    @Override // androidx.transition.k
    public void V(View view) {
        super.V(view);
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f11483M.get(i5).V(view);
        }
    }

    @Override // androidx.transition.k
    public void Z(View view) {
        super.Z(view);
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f11483M.get(i5).Z(view);
        }
    }

    @Override // androidx.transition.k
    protected void b0() {
        if (this.f11483M.isEmpty()) {
            i0();
            u();
            return;
        }
        w0();
        int i5 = 0;
        if (this.f11484Q) {
            ArrayList<k> arrayList = this.f11483M;
            int size = arrayList.size();
            while (i5 < size) {
                k kVar = arrayList.get(i5);
                i5++;
                kVar.b0();
            }
            return;
        }
        for (int i6 = 1; i6 < this.f11483M.size(); i6++) {
            this.f11483M.get(i6 - 1).b(new a(this.f11483M.get(i6)));
        }
        k kVar2 = this.f11483M.get(0);
        if (kVar2 != null) {
            kVar2.b0();
        }
    }

    @Override // androidx.transition.k
    protected void cancel() {
        super.cancel();
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f11483M.get(i5).cancel();
        }
    }

    @Override // androidx.transition.k
    public void d0(k.e eVar) {
        super.d0(eVar);
        this.f11487T |= 8;
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f11483M.get(i5).d0(eVar);
        }
    }

    @Override // androidx.transition.k
    public void f0(g gVar) {
        super.f0(gVar);
        this.f11487T |= 4;
        if (this.f11483M != null) {
            for (int i5 = 0; i5 < this.f11483M.size(); i5++) {
                this.f11483M.get(i5).f0(gVar);
            }
        }
    }

    @Override // androidx.transition.k
    public void g0(s sVar) {
        super.g0(sVar);
        this.f11487T |= 2;
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f11483M.get(i5).g0(sVar);
        }
    }

    @Override // androidx.transition.k
    public void i(v vVar) {
        if (M(vVar.f11493b)) {
            ArrayList<k> arrayList = this.f11483M;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                k kVar = arrayList.get(i5);
                i5++;
                k kVar2 = kVar;
                if (kVar2.M(vVar.f11493b)) {
                    kVar2.i(vVar);
                    vVar.f11494c.add(kVar2);
                }
            }
        }
    }

    @Override // androidx.transition.k
    String j0(String str) {
        String strJ0 = super.j0(str);
        for (int i5 = 0; i5 < this.f11483M.size(); i5++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strJ0);
            sb.append("\n");
            sb.append(this.f11483M.get(i5).j0(str + "  "));
            strJ0 = sb.toString();
        }
        return strJ0;
    }

    @Override // androidx.transition.k
    void k(v vVar) {
        super.k(vVar);
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f11483M.get(i5).k(vVar);
        }
    }

    @Override // androidx.transition.k
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public t b(k.f fVar) {
        return (t) super.b(fVar);
    }

    @Override // androidx.transition.k
    public void l(v vVar) {
        if (M(vVar.f11493b)) {
            ArrayList<k> arrayList = this.f11483M;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                k kVar = arrayList.get(i5);
                i5++;
                k kVar2 = kVar;
                if (kVar2.M(vVar.f11493b)) {
                    kVar2.l(vVar);
                    vVar.f11494c.add(kVar2);
                }
            }
        }
    }

    @Override // androidx.transition.k
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public t d(View view) {
        for (int i5 = 0; i5 < this.f11483M.size(); i5++) {
            this.f11483M.get(i5).d(view);
        }
        return (t) super.d(view);
    }

    public t m0(k kVar) {
        n0(kVar);
        long j5 = this.f11438c;
        if (j5 >= 0) {
            kVar.c0(j5);
        }
        if ((this.f11487T & 1) != 0) {
            kVar.e0(x());
        }
        if ((this.f11487T & 2) != 0) {
            B();
            kVar.g0(null);
        }
        if ((this.f11487T & 4) != 0) {
            kVar.f0(A());
        }
        if ((this.f11487T & 8) != 0) {
            kVar.d0(w());
        }
        return this;
    }

    public k o0(int i5) {
        if (i5 < 0 || i5 >= this.f11483M.size()) {
            return null;
        }
        return this.f11483M.get(i5);
    }

    public int p0() {
        return this.f11483M.size();
    }

    @Override // androidx.transition.k
    /* renamed from: q */
    public k clone() {
        t tVar = (t) super.clone();
        tVar.f11483M = new ArrayList<>();
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            tVar.n0(this.f11483M.get(i5).clone());
        }
        return tVar;
    }

    @Override // androidx.transition.k
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public t X(k.f fVar) {
        return (t) super.X(fVar);
    }

    @Override // androidx.transition.k
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public t Y(View view) {
        for (int i5 = 0; i5 < this.f11483M.size(); i5++) {
            this.f11483M.get(i5).Y(view);
        }
        return (t) super.Y(view);
    }

    @Override // androidx.transition.k
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public t c0(long j5) {
        ArrayList<k> arrayList;
        super.c0(j5);
        if (this.f11438c >= 0 && (arrayList = this.f11483M) != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f11483M.get(i5).c0(j5);
            }
        }
        return this;
    }

    @Override // androidx.transition.k
    void t(ViewGroup viewGroup, w wVar, w wVar2, ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        long jE = E();
        int size = this.f11483M.size();
        for (int i5 = 0; i5 < size; i5++) {
            k kVar = this.f11483M.get(i5);
            if (jE > 0 && (this.f11484Q || i5 == 0)) {
                long jE2 = kVar.E();
                if (jE2 > 0) {
                    kVar.h0(jE2 + jE);
                } else {
                    kVar.h0(jE);
                }
            }
            kVar.t(viewGroup, wVar, wVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public t e0(TimeInterpolator timeInterpolator) {
        this.f11487T |= 1;
        ArrayList<k> arrayList = this.f11483M;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f11483M.get(i5).e0(timeInterpolator);
            }
        }
        return (t) super.e0(timeInterpolator);
    }

    public t u0(int i5) {
        if (i5 == 0) {
            this.f11484Q = true;
            return this;
        }
        if (i5 == 1) {
            this.f11484Q = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i5);
    }

    @Override // androidx.transition.k
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public t h0(long j5) {
        return (t) super.h0(j5);
    }
}
