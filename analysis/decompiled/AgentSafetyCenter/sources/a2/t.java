package a2;

import d1.j0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends yb.l implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public static final t f99f;

    /* renamed from: g, reason: collision with root package name */
    public static final t f100g;

    /* renamed from: h, reason: collision with root package name */
    public static final t f101h;
    public static final t i;

    /* renamed from: j, reason: collision with root package name */
    public static final t f102j;

    /* renamed from: k, reason: collision with root package name */
    public static final t f103k;

    /* renamed from: l, reason: collision with root package name */
    public static final t f104l;

    /* renamed from: m, reason: collision with root package name */
    public static final t f105m;

    /* renamed from: n, reason: collision with root package name */
    public static final t f106n;

    /* renamed from: o, reason: collision with root package name */
    public static final t f107o;

    /* renamed from: p, reason: collision with root package name */
    public static final t f108p;

    /* renamed from: q, reason: collision with root package name */
    public static final t f109q;

    /* renamed from: r, reason: collision with root package name */
    public static final t f110r;

    /* renamed from: s, reason: collision with root package name */
    public static final t f111s;

    /* renamed from: t, reason: collision with root package name */
    public static final t f112t;

    /* renamed from: u, reason: collision with root package name */
    public static final t f113u;

    /* renamed from: v, reason: collision with root package name */
    public static final t f114v;

    /* renamed from: w, reason: collision with root package name */
    public static final t f115w;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f116c;

    static {
        int i3 = 2;
        f99f = new t(i3, 0);
        f100g = new t(i3, 1);
        f101h = new t(i3, 2);
        i = new t(i3, 3);
        f102j = new t(i3, 4);
        f103k = new t(i3, 5);
        f104l = new t(i3, 6);
        f105m = new t(i3, 7);
        f106n = new t(i3, 8);
        f107o = new t(i3, 9);
        f108p = new t(i3, 10);
        f109q = new t(i3, 11);
        f110r = new t(i3, 12);
        f111s = new t(i3, 13);
        f112t = new t(i3, 14);
        f113u = new t(i3, 15);
        f114v = new t(i3, 16);
        f115w = new t(i3, 17);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(int i3, int i10) {
        super(i3);
        this.f116c = i10;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        String str;
        jb.b bVar;
        switch (this.f116c) {
            case 0:
                return (x0.j) obj;
            case 1:
                List list = (List) obj;
                List list2 = (List) obj2;
                if (list == null) {
                    return list2;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.addAll(list2);
                return arrayList;
            case 2:
                return (x0.l) obj;
            case 3:
                return (jb.v) obj;
            case 4:
                return (jb.v) obj;
            case 5:
                throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
            case 6:
                return (jb.v) obj;
            case 7:
                throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
            case 8:
                g gVar = (g) obj;
                int i3 = ((g) obj2).f45a;
                return gVar;
            case 9:
                return (j0) obj;
            case 10:
                return (String) obj;
            case 11:
                List list3 = (List) obj;
                List list4 = (List) obj2;
                if (list3 == null) {
                    return list4;
                }
                ArrayList arrayList2 = new ArrayList(list3);
                arrayList2.addAll(list4);
                return arrayList2;
            case 12:
                Float f5 = (Float) obj;
                ((Number) obj2).floatValue();
                return f5;
            case 13:
                return (String) obj;
            case 14:
                Boolean bool = (Boolean) obj;
                ((Boolean) obj2).booleanValue();
                return bool;
            case 15:
                a aVar = (a) obj;
                a aVar2 = (a) obj2;
                if (aVar == null || (str = aVar.f29a) == null) {
                    str = aVar2.f29a;
                }
                if (aVar == null || (bVar = aVar.f30b) == null) {
                    bVar = aVar2.f30b;
                }
                return new a(str, bVar);
            case 16:
                return obj == null ? obj2 : obj;
            default:
                p pVar = (p) obj2;
                Object objValueOf = Float.valueOf(0.0f);
                k kVar = ((p) obj).f88d;
                x xVar = u.f134s;
                Object objG = kVar.f75c.g(xVar);
                if (objG == null) {
                    objG = objValueOf;
                }
                float fFloatValue = ((Number) objG).floatValue();
                Object objG2 = pVar.f88d.f75c.g(xVar);
                if (objG2 != null) {
                    objValueOf = objG2;
                }
                return Integer.valueOf(Float.compare(fFloatValue, ((Number) objValueOf).floatValue()));
        }
    }
}
