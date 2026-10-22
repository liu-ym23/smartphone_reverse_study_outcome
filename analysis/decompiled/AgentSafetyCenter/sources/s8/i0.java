package s8;

import android.graphics.DashPathEffect;
import android.graphics.Path;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ c1.c f11656c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f11657f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ float f11658g;

    @Override // xb.l
    public final Object invoke(Object obj) {
        c1.c cVar = this.f11656c;
        float f5 = this.f11657f;
        float f10 = this.f11658g;
        f1.d dVar = (f1.d) obj;
        dVar.getClass();
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5.0f, 4.0f}, 0.0f);
        d1.i iVar = new d1.i();
        iVar.f2996a = dashPathEffect;
        VarHandle.storeStoreFence();
        float fX = dVar.X(1);
        float f11 = cVar.f2170d;
        d1.h hVarA = d1.k.a();
        Path path = hVarA.f2990a;
        path.moveTo(f5, f11);
        path.lineTo(f5, f10);
        dVar.C(hVarA, w0.f12042f, new f1.g(fX, 0.0f, 1, 1, iVar, 2));
        return jb.v.f6774a;
    }
}
