package fb;

import com.stepos.widget.toolbar.StepOSTitleBar;
import java.lang.invoke.VarHandle;
import jb.v;
import u0.q;
import xb.l;
import y9.f;
import y9.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4046c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f4047f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ float f4048g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f4049h;

    public /* synthetic */ a(int i) {
        this.f4046c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f4046c) {
            case 0:
                float f5 = this.f4048g;
                int i = this.f4047f;
                f fVar = (f) obj;
                int i3 = StepOSTitleBar.f2893c0;
                fVar.getClass();
                stepos.support.v7.app.f fVar2 = k.f16061f;
                b bVar = new b();
                bVar.f4050c = f5;
                bVar.f4051f = i;
                VarHandle.storeStoreFence();
                fVar.b(fVar2, bVar);
                return fVar;
            default:
                int i10 = this.f4047f;
                q qVar = (q) this.f4049h;
                float f10 = this.f4048g;
                s1.q qVar2 = (s1.q) obj;
                qVar2.getClass();
                s1.q qVarW = qVar2.w();
                if (qVarW != null) {
                    long jB = qVarW.B(qVar2, 0L);
                    if (i10 < qVar.size()) {
                        qVar.set(i10, Float.valueOf(Float.intBitsToFloat((int) (jB & 4294967295L)) + f10));
                    }
                }
                return v.f6774a;
        }
    }
}
