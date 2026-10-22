package j2;

import android.graphics.Typeface;
import h2.j;
import m0.f;
import n0.e;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9656a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9657b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9658c;

    public a(e.a aVar, Typeface typeface) {
        this.f9657b = aVar;
        this.f9658c = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9656a) {
            case 0:
                j jVarD = j.d();
                String str = b.f9659e;
                StringBuilder sb2 = new StringBuilder("Scheduling work ");
                p pVar = (p) this.f9657b;
                sb2.append(pVar.f11505a);
                jVarD.a(str, sb2.toString());
                ((b) this.f9658c).f9660a.c(pVar);
                break;
            default:
                e.a aVar = (e.a) this.f9657b;
                Typeface typeface = (Typeface) this.f9658c;
                f.c cVar = aVar.f10598c;
                if (cVar != null) {
                    cVar.c(typeface);
                    break;
                }
                break;
        }
    }

    public a(b bVar, p pVar) {
        this.f9658c = bVar;
        this.f9657b = pVar;
    }
}
