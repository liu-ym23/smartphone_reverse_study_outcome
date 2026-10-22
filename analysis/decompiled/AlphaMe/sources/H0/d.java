package H0;

import android.graphics.PointF;
import f1.AbstractC0557a;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f694g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f695h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i4, List list) {
        super(list);
        this.f694g = i4;
        if (i4 == 1) {
            super(list);
            this.f695h = new PointF();
        } else {
            L0.c cVar = (L0.c) ((Q0.a) list.get(0)).f1627b;
            int length = cVar != null ? cVar.f1152b.length : 0;
            this.f695h = new L0.c(new int[length], new float[length]);
        }
    }

    @Override // H0.b
    public final Object f(Q0.a aVar, float f4) {
        Object obj;
        int i4 = this.f694g;
        Object obj2 = this.f695h;
        switch (i4) {
            case 0:
                L0.c cVar = (L0.c) obj2;
                L0.c cVar2 = (L0.c) aVar.f1627b;
                L0.c cVar3 = (L0.c) aVar.f1628c;
                cVar.getClass();
                int[] iArr = cVar2.f1152b;
                int length = iArr.length;
                int[] iArr2 = cVar3.f1152b;
                if (length != iArr2.length) {
                    StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
                    sb.append(iArr.length);
                    sb.append(" vs ");
                    throw new IllegalArgumentException(AbstractC0831a.d(sb, iArr2.length, ")"));
                }
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    cVar.f1151a[i5] = AbstractC0557a.M(cVar2.f1151a[i5], cVar3.f1151a[i5], f4);
                    cVar.f1152b[i5] = com.stepos.statsrpk.c.r(f4, iArr[i5], iArr2[i5]);
                }
                return cVar;
            default:
                Object obj3 = aVar.f1627b;
                if (obj3 == null || (obj = aVar.f1628c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                PointF pointF = (PointF) obj3;
                PointF pointF2 = (PointF) obj;
                Q0.b bVar = this.f691e;
                if (bVar != null) {
                    aVar.f1631f.getClass();
                    d();
                    PointF pointF3 = (PointF) bVar.b(pointF, pointF2);
                    if (pointF3 != null) {
                        return pointF3;
                    }
                }
                PointF pointF4 = (PointF) obj2;
                float f5 = pointF.x;
                float fC = AbstractC0831a.c(pointF2.x, f5, f4, f5);
                float f6 = pointF.y;
                pointF4.set(fC, AbstractC0831a.c(pointF2.y, f6, f4, f6));
                return pointF4;
        }
    }
}
