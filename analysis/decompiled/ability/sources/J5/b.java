package J5;

import D8.f;
import D8.j;
import h8.InterfaceC1503K;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f876a = 1;
    public final Object b;
    public final Object c;
    public final Object d;

    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r8, java.lang.String r9, java.util.Map r10) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J5.b.<init>(android.content.Context, java.lang.String, java.util.Map):void");
    }

    public abstract G8.c a();

    public String toString() {
        switch (this.f876a) {
            case 1:
                return getClass().getSimpleName() + ": " + a();
            default:
                return super.toString();
        }
    }

    public b(f fVar, j jVar, InterfaceC1503K interfaceC1503K) {
        this.b = fVar;
        this.c = jVar;
        this.d = interfaceC1503K;
    }
}
