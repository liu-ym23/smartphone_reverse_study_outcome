package p1;

import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.List;
import u0.c0;

/* loaded from: classes.dex */
public final class r extends q7.m implements p7.n {

    /* renamed from: h, reason: collision with root package name */
    public static final r f8326h;

    /* renamed from: i, reason: collision with root package name */
    public static final r f8327i;

    /* renamed from: j, reason: collision with root package name */
    public static final r f8328j;

    /* renamed from: k, reason: collision with root package name */
    public static final r f8329k;

    /* renamed from: l, reason: collision with root package name */
    public static final r f8330l;

    /* renamed from: m, reason: collision with root package name */
    public static final r f8331m;

    /* renamed from: n, reason: collision with root package name */
    public static final r f8332n;

    /* renamed from: o, reason: collision with root package name */
    public static final r f8333o;

    /* renamed from: p, reason: collision with root package name */
    public static final r f8334p;

    /* renamed from: q, reason: collision with root package name */
    public static final r f8335q;

    /* renamed from: r, reason: collision with root package name */
    public static final r f8336r;

    /* renamed from: s, reason: collision with root package name */
    public static final r f8337s;

    /* renamed from: t, reason: collision with root package name */
    public static final r f8338t;

    /* renamed from: u, reason: collision with root package name */
    public static final r f8339u;

    /* renamed from: v, reason: collision with root package name */
    public static final r f8340v;

    /* renamed from: w, reason: collision with root package name */
    public static final r f8341w;

    /* renamed from: x, reason: collision with root package name */
    public static final r f8342x;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8343g;

    static {
        int i2 = 2;
        f8326h = new r(i2, 0);
        f8327i = new r(i2, 1);
        f8328j = new r(i2, 2);
        f8329k = new r(i2, 3);
        f8330l = new r(i2, 4);
        f8331m = new r(i2, 5);
        f8332n = new r(i2, 6);
        f8333o = new r(i2, 7);
        f8334p = new r(i2, 8);
        f8335q = new r(i2, 9);
        f8336r = new r(i2, 10);
        f8337s = new r(i2, 11);
        f8338t = new r(i2, 12);
        f8339u = new r(i2, 13);
        f8340v = new r(i2, 14);
        f8341w = new r(i2, 15);
        f8342x = new r(i2, 16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i2, int i10) {
        super(i2);
        this.f8343g = i10;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        String str;
        c7.c cVar;
        switch (this.f8343g) {
            case 0:
                return (o0.c) obj;
            case 1:
                List list = (List) obj;
                List list2 = (List) obj2;
                if (list == null) {
                    return list2;
                }
                ArrayList arrayListN1 = d7.r.n1(list);
                arrayListN1.addAll(list2);
                return arrayListN1;
            case 2:
                return (o0.k) obj;
            case 3:
                return (c7.r) obj;
            case 4:
                return (c7.r) obj;
            case 5:
                return (c7.r) obj;
            case 6:
                throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
            case 7:
                f fVar = (f) obj;
                ((f) obj2).getClass();
                return fVar;
            case 8:
                return (c0) obj;
            case 9:
                return (String) obj;
            case 10:
                List list3 = (List) obj;
                List list4 = (List) obj2;
                if (list3 == null) {
                    return list4;
                }
                ArrayList arrayListN12 = d7.r.n1(list3);
                arrayListN12.addAll(list4);
                return arrayListN12;
            case 11:
                Float f10 = (Float) obj;
                ((Number) obj2).floatValue();
                return f10;
            case 12:
                return (String) obj;
            case 13:
                Boolean bool = (Boolean) obj;
                ((Boolean) obj2).booleanValue();
                return bool;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                a aVar = (a) obj;
                a aVar2 = (a) obj2;
                if (aVar == null || (str = aVar.f8266a) == null) {
                    str = aVar2.f8266a;
                }
                if (aVar == null || (cVar = aVar.f8267b) == null) {
                    cVar = aVar2.f8267b;
                }
                return new a(str, cVar);
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return obj == null ? obj2 : obj;
            default:
                n nVar = (n) obj2;
                Object objValueOf = Float.valueOf(0.0f);
                i iVar = ((n) obj).f8315d;
                v vVar = s.f8362s;
                Object objG = iVar.f8304f.g(vVar);
                if (objG == null) {
                    objG = objValueOf;
                }
                float fFloatValue = ((Number) objG).floatValue();
                Object objG2 = nVar.f8315d.f8304f.g(vVar);
                if (objG2 != null) {
                    objValueOf = objG2;
                }
                return Integer.valueOf(Float.compare(fFloatValue, ((Number) objValueOf).floatValue()));
        }
    }
}
