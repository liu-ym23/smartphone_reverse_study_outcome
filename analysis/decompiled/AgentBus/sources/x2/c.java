package x2;

import android.os.Build;
import f8.x;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public final class c extends n7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u4.l f11108a;

    public c(u4.l lVar) {
        this.f11108a = lVar;
    }

    @Override // n7.a
    public final void t(Throwable th) {
        ((g) this.f11108a.f10090a).d(th);
    }

    @Override // n7.a
    public final void u(i5.f fVar) {
        u4.l lVar = this.f11108a;
        lVar.f10092c = fVar;
        i5.f fVar2 = (i5.f) lVar.f10092c;
        g gVar = (g) lVar.f10090a;
        w4.a aVar = gVar.f11119g;
        b bVar = gVar.f11121i;
        Set<int[]> setA = Build.VERSION.SDK_INT >= 34 ? k.a() : n7.b.l();
        u5.h hVar = new u5.h();
        hVar.f10129a = aVar;
        hVar.f10130b = fVar2;
        hVar.f10131c = bVar;
        if (!setA.isEmpty()) {
            for (int[] iArr : setA) {
                String str = new String(iArr, 0, iArr.length);
                hVar.e(str, 0, str.length(), 1, true, new x(str, 4));
            }
        }
        lVar.f10091b = hVar;
        g gVar2 = (g) lVar.f10090a;
        gVar2.getClass();
        ArrayList arrayList = new ArrayList();
        gVar2.f11113a.writeLock().lock();
        try {
            gVar2.f11115c = 1;
            arrayList.addAll(gVar2.f11114b);
            gVar2.f11114b.clear();
            gVar2.f11113a.writeLock().unlock();
            gVar2.f11116d.post(new e(arrayList, gVar2.f11115c, null));
        } catch (Throwable th) {
            gVar2.f11113a.writeLock().unlock();
            throw th;
        }
    }
}
