package androidx.emoji2.text;

import android.os.Build;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends b8.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f600c;

    public d(e eVar) {
        this.f600c = eVar;
    }

    @Override // b8.h
    public final void A(a1.w wVar) {
        e eVar = this.f600c;
        eVar.f603c = wVar;
        a1.w wVar2 = eVar.f603c;
        j jVar = eVar.f601a;
        eVar.f602b = new a4.d(wVar2, jVar.f614g, jVar.f616i, Build.VERSION.SDK_INT >= 34 ? o.a() : a.a.I());
        j jVar2 = eVar.f601a;
        jVar2.getClass();
        ArrayList arrayList = new ArrayList();
        jVar2.f609a.writeLock().lock();
        try {
            jVar2.f611c = 1;
            arrayList.addAll(jVar2.f610b);
            jVar2.f610b.clear();
            jVar2.f609a.writeLock().unlock();
            jVar2.d.post(new h(arrayList, jVar2.f611c, null));
        } catch (Throwable th) {
            jVar2.f609a.writeLock().unlock();
            throw th;
        }
    }

    @Override // b8.h
    public final void z(Throwable th) {
        this.f600c.f601a.d(th);
    }
}
