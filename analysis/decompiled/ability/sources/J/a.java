package J;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f857a;
    public final /* synthetic */ float b;
    public final /* synthetic */ d c;

    public a(d dVar, String str, float f) {
        this.c = dVar;
        this.f857a = str;
        this.b = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar = this.c;
        HashMap map = dVar.f860a;
        String str = this.f857a;
        b bVar = (b) map.get(str);
        float f = this.b;
        if (bVar != null) {
            bVar.f858a += f;
            bVar.c++;
            return;
        }
        b bVar2 = new b();
        bVar2.f858a = f;
        bVar2.b = System.currentTimeMillis();
        bVar2.c = 1;
        dVar.f860a.put(str, bVar2);
    }
}
