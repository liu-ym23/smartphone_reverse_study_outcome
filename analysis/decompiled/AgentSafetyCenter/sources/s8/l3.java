package s8;

import android.graphics.DashPathEffect;
import android.graphics.Path;
import java.lang.invoke.VarHandle;
import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l3 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f11776c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f11777f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ u0.q f11778g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ float f11779h;
    public /* synthetic */ float[] i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ k0.h1 f11780j;

    @Override // xb.l
    public final Object invoke(Object obj) {
        boolean z10 = this.f11776c;
        int i = this.f11777f;
        u0.q qVar = this.f11778g;
        float f5 = this.f11779h;
        float[] fArr = this.i;
        k0.h1 h1Var = this.f11780j;
        f1.d dVar = (f1.d) obj;
        dVar.getClass();
        if (h1Var.g() > 0 && z10 && i != 0) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (dVar.e() >> 32)) / 2.0f;
            float fFloatValue = ((Number) qVar.get(0)).floatValue() + f5;
            float fFloatValue2 = ((Number) qVar.get(i - 1)).floatValue() - f5;
            if (fFloatValue2 > fFloatValue) {
                d1.h hVarA = d1.k.a();
                Path path = hVarA.f2990a;
                path.moveTo(fIntBitsToFloat, fFloatValue);
                path.lineTo(fIntBitsToFloat, fFloatValue2);
                long j10 = o3.f11846d;
                DashPathEffect dashPathEffect = new DashPathEffect(fArr, 0.0f);
                d1.i iVar = new d1.i();
                iVar.f2996a = dashPathEffect;
                VarHandle.storeStoreFence();
                dVar.C(hVarA, j10, new f1.g(2.0f, 0.0f, 1, 0, iVar, 10));
            }
            ListIterator listIterator = qVar.listIterator();
            while (true) {
                lb.a aVar = (lb.a) listIterator;
                if (!aVar.hasNext()) {
                    break;
                }
                float fFloatValue3 = ((Number) aVar.next()).floatValue();
                f1.d dVar2 = dVar;
                f1.d.s(dVar2, d1.p.f3020c, f5, (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fFloatValue3) & 4294967295L), null, 120);
                f1.d.s(dVar2, o3.f11847e, f5, (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fFloatValue3) & 4294967295L), new f1.g(2.0f, 0.0f, 0, 0, null, 30), 104);
                dVar = dVar2;
            }
        }
        return jb.v.f6774a;
    }
}
