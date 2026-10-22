package androidx.lifecycle;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1005f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c.i f1006g;

    public /* synthetic */ k0(c.i iVar, int i2) {
        this.f1005f = i2;
        this.f1006g = iVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f1005f) {
            case 0:
                break;
            case 1:
                this.f1006g.reportFullyDrawn();
                break;
            case 2:
                c.i iVar = this.f1006g;
                break;
            case 3:
                d3.a aVar = new d3.a();
                i5.f fVar = ((c.n) ((c.o) this.f1006g.f1702x.getValue()).f1712b.getValue()).f1710c;
                if (((LinkedHashSet) fVar.f4656j).add(aVar)) {
                    ((d3.g) fVar.f4654h).a(fVar, aVar, -1);
                    break;
                }
                break;
            case 4:
                c.i iVar2 = this.f1006g;
                break;
            case 5:
                c.i iVar3 = this.f1006g;
                c.o oVar = new c.o(new a0(1, iVar3));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (!q7.k.a(Looper.myLooper(), Looper.getMainLooper())) {
                        new Handler(Looper.getMainLooper()).post(new c.b(0, iVar3, oVar));
                        break;
                    } else {
                        iVar3.f4074f.a(new c.c(oVar, iVar3));
                        break;
                    }
                }
                break;
            case 6:
                c.i iVar4 = this.f1006g;
                iVar4.f4074f.a(new i3.b(iVar4, 0));
                break;
            default:
                this.f1006g.finish();
                break;
        }
        return c7.r.f1986a;
    }
}
