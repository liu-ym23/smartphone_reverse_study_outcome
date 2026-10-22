package t1;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public float f5543a;

    /* renamed from: b, reason: collision with root package name */
    public float f5544b;

    /* renamed from: c, reason: collision with root package name */
    public float f5545c;
    public float d;

    /* renamed from: e, reason: collision with root package name */
    public float f5546e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f5547f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f5548g = new ArrayList();

    public w() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f3) {
        float f7 = this.d;
        if (f7 == f3) {
            return;
        }
        float f9 = ((f3 - f7) + 360.0f) % 360.0f;
        if (f9 > 180.0f) {
            return;
        }
        float f10 = this.f5544b;
        float f11 = this.f5545c;
        s sVar = new s(f10, f11, f10, f11);
        sVar.f5538f = this.d;
        sVar.f5539g = f9;
        this.f5548g.add(new q(sVar));
        this.d = f3;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f5547f;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((u) arrayList.get(i8)).a(matrix, path);
        }
    }

    public final void c(float f3, float f7) {
        t tVar = new t();
        tVar.f5540b = f3;
        tVar.f5541c = f7;
        this.f5547f.add(tVar);
        r rVar = new r(tVar, this.f5544b, this.f5545c);
        float fA = rVar.a() + 270.0f;
        float fA2 = rVar.a() + 270.0f;
        a(fA);
        this.f5548g.add(rVar);
        this.d = fA2;
        this.f5544b = f3;
        this.f5545c = f7;
    }

    public final void d(float f3, float f7, float f9) {
        this.f5543a = f3;
        this.f5544b = 0.0f;
        this.f5545c = f3;
        this.d = f7;
        this.f5546e = (f7 + f9) % 360.0f;
        this.f5547f.clear();
        this.f5548g.clear();
    }
}
