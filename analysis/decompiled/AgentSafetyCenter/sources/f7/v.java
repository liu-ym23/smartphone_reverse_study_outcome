package f7;

import android.graphics.Matrix;
import android.graphics.Path;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public float f4022a;

    /* renamed from: b, reason: collision with root package name */
    public float f4023b;

    /* renamed from: c, reason: collision with root package name */
    public float f4024c;

    /* renamed from: d, reason: collision with root package name */
    public float f4025d;

    /* renamed from: e, reason: collision with root package name */
    public float f4026e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f4027f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f4028g = new ArrayList();

    public v() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f5) {
        float f10 = this.f4025d;
        if (f10 == f5) {
            return;
        }
        float f11 = ((f5 - f10) + 360.0f) % 360.0f;
        if (f11 > 180.0f) {
            return;
        }
        float f12 = this.f4023b;
        float f13 = this.f4024c;
        r rVar = new r(f12, f13, f12, f13);
        rVar.f4017f = this.f4025d;
        rVar.f4018g = f11;
        this.f4028g.add(new p(rVar));
        this.f4025d = f5;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f4027f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((t) arrayList.get(i)).a(matrix, path);
        }
    }

    public final void c(float f5, float f10) {
        s sVar = new s();
        sVar.f4019b = f5;
        sVar.f4020c = f10;
        this.f4027f.add(sVar);
        float f11 = this.f4023b;
        float f12 = this.f4024c;
        q qVar = new q();
        qVar.f4009a = sVar;
        qVar.f4010b = f11;
        qVar.f4011c = f12;
        VarHandle.storeStoreFence();
        float fA = qVar.a() + 270.0f;
        float fA2 = qVar.a() + 270.0f;
        a(fA);
        this.f4028g.add(qVar);
        this.f4025d = fA2;
        this.f4023b = f5;
        this.f4024c = f10;
    }

    public final void d(float f5, float f10, float f11) {
        this.f4022a = f5;
        this.f4023b = 0.0f;
        this.f4024c = f5;
        this.f4025d = f10;
        this.f4026e = (f10 + f11) % 360.0f;
        this.f4027f.clear();
        this.f4028g.clear();
    }
}
