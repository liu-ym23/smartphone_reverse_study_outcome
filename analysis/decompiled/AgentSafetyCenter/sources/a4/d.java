package a4;

import android.os.Build;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends id.k {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ e f163c;

    @Override // id.k
    public final void J(Throwable th) {
        this.f163c.f164a.e(th);
    }

    @Override // id.k
    public final void K(p5.i iVar) {
        e eVar = this.f163c;
        eVar.f166c = iVar;
        p5.i iVar2 = eVar.f166c;
        j jVar = eVar.f164a;
        f7.f fVar = jVar.f181g;
        c cVar = jVar.i;
        Set<int[]> setA = Build.VERSION.SDK_INT >= 34 ? p.a() : p5.f.A();
        p5.m mVar = new p5.m(1);
        mVar.f9741f = fVar;
        mVar.f9742g = iVar2;
        mVar.f9743h = cVar;
        if (!setA.isEmpty()) {
            for (int[] iArr : setA) {
                String str = new String(iArr, 0, iArr.length);
                r rVar = new r();
                rVar.f192c = str;
                VarHandle.storeStoreFence();
                mVar.L(str, 0, str.length(), 1, true, rVar);
            }
        }
        VarHandle.storeStoreFence();
        eVar.f165b = mVar;
        j jVar2 = eVar.f164a;
        ArrayList arrayList = new ArrayList();
        jVar2.f175a.writeLock().lock();
        try {
            jVar2.f177c = 1;
            arrayList.addAll(jVar2.f176b);
            jVar2.f176b.clear();
            jVar2.f175a.writeLock().unlock();
            jVar2.f178d.post(new h(arrayList, jVar2.f177c, null));
        } catch (Throwable th) {
            jVar2.f175a.writeLock().unlock();
            throw th;
        }
    }
}
