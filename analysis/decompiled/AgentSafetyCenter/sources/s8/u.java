package s8;

import android.graphics.DashPathEffect;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f11987c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f11988f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        ?? F;
        int i = this.f11987c;
        boolean z10 = this.f11988f;
        f1.d dVar = (f1.d) obj;
        dVar.getClass();
        char c9 = ' ';
        float fIntBitsToFloat = Float.intBitsToFloat((int) (dVar.e() >> 32));
        long j10 = 4294967295L;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (dVar.e() & 4294967295L));
        int i3 = 2;
        float f5 = 0.0f;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        d1.i iVar = new d1.i();
        iVar.f2996a = dashPathEffect;
        VarHandle.storeStoreFence();
        float f10 = i;
        float f11 = (fIntBitsToFloat * 0.5f) / f10;
        float f12 = ((f10 - 0.5f) * fIntBitsToFloat) / f10;
        int i10 = 0;
        while (i10 < 3) {
            float f13 = (i10 * fIntBitsToFloat2) / 2.0f;
            char c10 = c9;
            float f14 = fIntBitsToFloat;
            long j11 = j10;
            int i11 = i10;
            int i12 = i3;
            dVar.j(w0.f12040d, (Float.floatToRawIntBits(f11) << c10) | (Float.floatToRawIntBits(f13) & j10), (Float.floatToRawIntBits(f12 < f11 ? f11 : f12) << c10) | (Float.floatToRawIntBits(f13) & j11), 0.85f, (496 & 32) != 0 ? null : i10 == i3 ? null : iVar);
            i10 = i11 + 1;
            iVar = iVar;
            i3 = i12;
            f5 = 0.0f;
            c9 = c10;
            fIntBitsToFloat = f14;
            j10 = j11;
        }
        char c11 = c9;
        float f15 = fIntBitsToFloat;
        long j12 = j10;
        d1.i iVar2 = iVar;
        float f16 = f5;
        if (z10) {
            List listF = ac.a.F(0, 6, 12, 18, 23);
            F = new ArrayList(kb.m.m0(listF, 10));
            Iterator it = listF.iterator();
            while (it.hasNext()) {
                F.add(Float.valueOf(((((Number) it.next()).intValue() + 0.5f) * f15) / 24.0f));
            }
        } else {
            F = ac.a.F(Float.valueOf(f11), Float.valueOf(f12));
        }
        Iterator it2 = F.iterator();
        while (it2.hasNext()) {
            float fFloatValue = ((Number) it2.next()).floatValue();
            dVar.j(w0.f12040d, (Float.floatToRawIntBits(fFloatValue) << c11) | (Float.floatToRawIntBits(f16) & j12), (Float.floatToRawIntBits(fFloatValue) << c11) | (Float.floatToRawIntBits(fIntBitsToFloat2) & j12), 0.85f, (496 & 32) != 0 ? null : iVar2);
        }
        return jb.v.f6774a;
    }
}
