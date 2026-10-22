package G0;

import android.graphics.Path;
import com.airbnb.lottie.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class q implements m, H0.a {

    /* renamed from: a, reason: collision with root package name */
    public final Path f570a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final v f571b;

    /* renamed from: c, reason: collision with root package name */
    public final H0.b f572c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f573d;

    /* renamed from: e, reason: collision with root package name */
    public s f574e;

    public q(v vVar, M0.b bVar, L0.n nVar) {
        nVar.getClass();
        this.f571b = vVar;
        H0.b bVarC = nVar.f1202c.c();
        this.f572c = bVarC;
        bVar.c(bVarC);
        bVarC.a(this);
    }

    @Override // H0.a
    public final void a() {
        this.f573d = false;
        this.f571b.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i4 >= arrayList.size()) {
                return;
            }
            c cVar = (c) arrayList.get(i4);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f580b == 1) {
                    this.f574e = sVar;
                    sVar.c(this);
                }
            }
            i4++;
        }
    }

    @Override // G0.m
    public final Path e() {
        boolean z4 = this.f573d;
        Path path = this.f570a;
        if (z4) {
            return path;
        }
        path.reset();
        path.set((Path) this.f572c.e());
        path.setFillType(Path.FillType.EVEN_ODD);
        P0.c.b(path, this.f574e);
        this.f573d = true;
        return path;
    }
}
