package s2;

import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9396g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f9397h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(z zVar, int i2) {
        super(0);
        this.f9396g = i2;
        this.f9397h = zVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9396g) {
            case 0:
                return ((u2.i) this.f9397h.f9472n.getValue()).f9992c;
            default:
                u2.f fVar = this.f9397h.f9464f;
                String strR = ((ob.z) fVar.f9976d.getValue()).f8043f.r();
                synchronized (u2.f.f9972f) {
                    LinkedHashSet linkedHashSet = u2.f.f9971e;
                    if (linkedHashSet.contains(strR)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + strR + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    linkedHashSet.add(strR);
                }
                return new u2.i(fVar.f9973a, (ob.z) fVar.f9976d.getValue(), (g0) fVar.f9974b.invoke((ob.z) fVar.f9976d.getValue(), fVar.f9973a), new u2.e(fVar, 1));
        }
    }
}
