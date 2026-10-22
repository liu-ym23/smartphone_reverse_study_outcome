package y9;

import aa.r;
import aa.u;
import jb.v;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16027c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f16028f;

    public /* synthetic */ a(int i) {
        this.f16027c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f16027c;
        float f5 = this.f16028f;
        switch (i) {
            case 0:
                aa.f fVar = (aa.f) obj;
                ((Float) obj2).getClass();
                fVar.getClass();
                fVar.f315c = f5;
                fVar.f317e = 0.0f;
                break;
            case 1:
                u uVar = (u) obj;
                ((Float) obj2).floatValue();
                uVar.getClass();
                uVar.f367c = 0.0f;
                uVar.f368d = 4.0f;
                uVar.f369e = f5;
                uVar.f370f = 4.0f;
                double radians = Math.toRadians(270.0d);
                double radians2 = Math.toRadians(45.0d);
                uVar.f371g = (float) Math.cos(radians);
                uVar.f372h = (float) Math.sin(radians);
                uVar.i = (float) Math.cos(radians2);
                uVar.f373j = (float) Math.sin(radians2);
                uVar.f374k = 1.0f;
                uVar.f375l = true;
                uVar.f376m = l.a(13421772, 20);
                uVar.f377n = l.a(13684944, 20);
                break;
            default:
                r rVar = (r) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                rVar.getClass();
                rVar.f358c = l.a(16777215, 15);
                rVar.f359d = 22.0f * fFloatValue;
                rVar.f360e = f5;
                break;
        }
        return v.f6774a;
    }
}
