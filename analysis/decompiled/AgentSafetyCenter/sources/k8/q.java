package k8;

import android.graphics.Typeface;
import android.text.Spannable;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentsafetycenter.MainActivity;
import d1.f0;
import d1.j0;
import d2.e0;
import java.lang.invoke.VarHandle;
import k0.c1;
import s8.j3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7336c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7337f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7338g;

    public /* synthetic */ q(int i) {
        this.f7336c = i;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f7336c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                d0 d0Var = (d0) this.f7337f;
                c1 c1Var = (c1) this.f7338g;
                j3 j3Var = (j3) obj;
                b bVar = (b) obj3;
                int i3 = MainActivity.f2491h;
                j3Var.getClass();
                bVar.getClass();
                w wVar = (w) d0Var;
                b bVar2 = wVar.f7355a;
                a aVar = wVar.f7357c;
                bVar2.getClass();
                c1Var.setValue(new c0(j3Var, (String) obj2, new w(bVar2, false, aVar, bVar)));
                return vVar;
            case 1:
                Spannable spannable = (Spannable) this.f7337f;
                k2.c cVar = (k2.c) this.f7338g;
                e0 e0Var = (e0) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int iIntValue2 = ((Integer) obj3).intValue();
                g2.q qVar = e0Var.f3086f;
                g2.k kVar = e0Var.f3083c;
                if (kVar == null) {
                    kVar = g2.k.f4252g;
                }
                g2.i iVar = e0Var.f3084d;
                int i10 = iVar != null ? iVar.f4249a : 0;
                g2.i iVar2 = new g2.i();
                iVar2.f4249a = i10;
                VarHandle.storeStoreFence();
                g2.j jVar = e0Var.f3085e;
                int i11 = jVar != null ? jVar.f4250a : ExifInterface.COLOR_SPACE_UNCALIBRATED;
                g2.j jVar2 = new g2.j();
                jVar2.f4250a = i11;
                VarHandle.storeStoreFence();
                Typeface typeface = (Typeface) cVar.c(qVar, kVar, iVar2, jVar2);
                f2.b bVar3 = new f2.b(1);
                bVar3.f3872f = typeface;
                VarHandle.storeStoreFence();
                spannable.setSpan(bVar3, iIntValue, iIntValue2, 33);
                return vVar;
            default:
                j0 j0Var = (j0) this.f7337f;
                xb.a aVar2 = (xb.a) this.f7338g;
                w0.m mVar = (w0.m) obj;
                k0.s sVar = (k0.s) obj2;
                ((Integer) obj3).getClass();
                mVar.getClass();
                sVar.X(682341604);
                Object objM = sVar.M();
                if (objM == k0.m.f6974a) {
                    objM = t0.a.a();
                    sVar.i0(objM);
                }
                v.k kVar2 = (v.k) objM;
                w0.m mVarD = androidx.compose.foundation.a.d(androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(mVar.d(w0.j.f15113c), j0Var), ((Boolean) t1.e.c(kVar2, sVar).getValue()).booleanValue() ? d1.p.c(0.1f, d1.p.f3020c) : d1.p.f3023f, f0.f2972a), kVar2, null, true, null, aVar2, 24);
                sVar.q(false);
                return mVarD;
        }
    }
}
