package H0;

import f1.AbstractC0557a;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f693g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i4, List list) {
        super(list);
        this.f693g = i4;
    }

    @Override // H0.b
    public final Object f(Q0.a aVar, float f4) {
        Object obj;
        Object obj2;
        switch (this.f693g) {
            case 0:
                return j(aVar, f4);
            case 1:
                if (aVar.f1627b == null || (obj = aVar.f1628c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                Q0.b bVar = this.f691e;
                Object obj3 = aVar.f1627b;
                if (bVar != null) {
                    aVar.f1631f.getClass();
                    d();
                    Float f5 = (Float) bVar.b(obj3, obj);
                    if (f5 != null) {
                        return f5;
                    }
                }
                return Float.valueOf(AbstractC0557a.M(((Float) obj3).floatValue(), ((Float) obj).floatValue(), f4));
            case 2:
                return j(aVar, f4);
            case 3:
                Object obj4 = aVar.f1627b;
                if (obj4 == null || (obj2 = aVar.f1628c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                Q0.c cVar = (Q0.c) obj4;
                Q0.c cVar2 = (Q0.c) obj2;
                Q0.b bVar2 = this.f691e;
                if (bVar2 != null) {
                    aVar.f1631f.getClass();
                    d();
                    Q0.c cVar3 = (Q0.c) bVar2.b(cVar, cVar2);
                    if (cVar3 != null) {
                        return cVar3;
                    }
                }
                return new Q0.c(AbstractC0557a.M(cVar.f1638a, cVar2.f1638a, f4), AbstractC0557a.M(cVar.f1639b, cVar2.f1639b, f4));
            default:
                return (J0.b) aVar.f1627b;
        }
    }

    public final Integer j(Q0.a aVar, float f4) {
        Object obj;
        Object obj2;
        switch (this.f693g) {
            case 0:
                Object obj3 = aVar.f1627b;
                if (obj3 == null || (obj = aVar.f1628c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                Integer num = (Integer) obj3;
                int iIntValue = num.intValue();
                Integer num2 = (Integer) obj;
                int iIntValue2 = num2.intValue();
                Q0.b bVar = this.f691e;
                if (bVar != null) {
                    aVar.f1631f.getClass();
                    d();
                    Integer num3 = (Integer) bVar.b(num, num2);
                    if (num3 != null) {
                        return num3;
                    }
                }
                return Integer.valueOf(com.stepos.statsrpk.c.r(f4, iIntValue, iIntValue2));
            default:
                if (aVar.f1627b == null || (obj2 = aVar.f1628c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                Q0.b bVar2 = this.f691e;
                Object obj4 = aVar.f1627b;
                if (bVar2 != null) {
                    aVar.f1631f.getClass();
                    d();
                    Integer num4 = (Integer) bVar2.b(obj4, obj2);
                    if (num4 != null) {
                        return num4;
                    }
                }
                return Integer.valueOf((int) ((f4 * (((Integer) obj2).intValue() - r5)) + ((Integer) obj4).intValue()));
        }
    }
}
