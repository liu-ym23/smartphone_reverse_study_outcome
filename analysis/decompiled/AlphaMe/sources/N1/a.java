package N1;

import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import androidx.lifecycle.V;

/* loaded from: classes.dex */
public final class a implements E {

    /* renamed from: a, reason: collision with root package name */
    public final V f1452a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1453b;

    /* renamed from: c, reason: collision with root package name */
    public int f1454c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f1455d;

    /* renamed from: e, reason: collision with root package name */
    public final G f1456e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b f1457f;

    public a(b bVar, G g4, V v4) {
        this.f1457f = bVar;
        this.f1455d = bVar;
        this.f1452a = v4;
        this.f1456e = g4;
    }

    @Override // androidx.lifecycle.E
    public final void a(G g4, EnumC0326x enumC0326x) {
        G g5 = this.f1456e;
        EnumC0327y enumC0327y = ((I) g5.getLifecycle()).f3871d;
        if (enumC0327y == EnumC0327y.f3983a) {
            this.f1457f.d(this.f1452a);
            return;
        }
        EnumC0327y enumC0327y2 = null;
        while (enumC0327y2 != enumC0327y) {
            b(((I) g5.getLifecycle()).f3871d.a(EnumC0327y.f3986d));
            enumC0327y2 = enumC0327y;
            enumC0327y = ((I) g5.getLifecycle()).f3871d;
        }
    }

    public final void b(boolean z4) {
        if (z4 == this.f1453b) {
            return;
        }
        this.f1453b = z4;
        int i4 = z4 ? 1 : -1;
        b bVar = this.f1455d;
        int i5 = bVar.f1460b;
        bVar.f1460b = i4 + i5;
        if (!bVar.f1461c) {
            bVar.f1461c = true;
            while (true) {
                try {
                    int i6 = bVar.f1460b;
                    if (i5 == i6) {
                        break;
                    } else {
                        i5 = i6;
                    }
                } finally {
                    bVar.f1461c = false;
                }
            }
        }
        if (!this.f1453b || bVar.f1463e <= bVar.f1464f) {
            return;
        }
        bVar.b(this);
    }
}
