package androidx.emoji2.text;

import android.os.Build;
import androidx.emoji2.text.d;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends d.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f1925a;

    public c(d.a aVar) {
        this.f1925a = aVar;
    }

    @Override // androidx.emoji2.text.d.i
    public final void a(Throwable th) {
        this.f1925a.f1938a.d(th);
    }

    @Override // androidx.emoji2.text.d.i
    public final void b(h hVar) {
        d.a aVar = this.f1925a;
        aVar.f1937c = hVar;
        h hVar2 = aVar.f1937c;
        d dVar = aVar.f1938a;
        aVar.f1936b = new f(hVar2, dVar.f1934g, dVar.f1935i, Build.VERSION.SDK_INT >= 34 ? i1.c.a() : i1.d.a());
        d dVar2 = aVar.f1938a;
        dVar2.getClass();
        ArrayList arrayList = new ArrayList();
        dVar2.f1928a.writeLock().lock();
        try {
            dVar2.f1930c = 1;
            arrayList.addAll(dVar2.f1929b);
            dVar2.f1929b.clear();
            dVar2.f1928a.writeLock().unlock();
            dVar2.f1931d.post(new d.g(arrayList, dVar2.f1930c, null));
        } catch (Throwable th) {
            dVar2.f1928a.writeLock().unlock();
            throw th;
        }
    }
}
