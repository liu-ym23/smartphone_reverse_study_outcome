package U2;

import U2.k;
import android.animation.Animator;
import java.util.ArrayList;
import java.util.List;
import w0.C5715a;

/* loaded from: classes2.dex */
public abstract class l<T extends Animator> {

    /* renamed from: a, reason: collision with root package name */
    public m f6282a;

    /* renamed from: b, reason: collision with root package name */
    public final List<k.a> f6283b = new ArrayList();

    public l(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f6283b.add(new k.a());
        }
    }

    public abstract void a();

    public float b(int i10, int i11, int i12) {
        return C5715a.a((i10 - i11) / i12, 0.0f, 1.0f);
    }

    public abstract void c();

    public abstract void d(q1.b bVar);

    public void e(m mVar) {
        this.f6282a = mVar;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
