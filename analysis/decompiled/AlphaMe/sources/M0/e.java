package M0;

import com.airbnb.lottie.LottieComposition;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final List f1393a;

    /* renamed from: b, reason: collision with root package name */
    public final LottieComposition f1394b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1395c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1396d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1397e;

    /* renamed from: f, reason: collision with root package name */
    public final long f1398f;

    /* renamed from: g, reason: collision with root package name */
    public final String f1399g;

    /* renamed from: h, reason: collision with root package name */
    public final List f1400h;

    /* renamed from: i, reason: collision with root package name */
    public final K0.c f1401i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1402j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1403k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1404l;

    /* renamed from: m, reason: collision with root package name */
    public final float f1405m;

    /* renamed from: n, reason: collision with root package name */
    public final float f1406n;

    /* renamed from: o, reason: collision with root package name */
    public final int f1407o;

    /* renamed from: p, reason: collision with root package name */
    public final int f1408p;

    /* renamed from: q, reason: collision with root package name */
    public final K0.a f1409q;

    /* renamed from: r, reason: collision with root package name */
    public final t.d f1410r;

    /* renamed from: s, reason: collision with root package name */
    public final K0.b f1411s;

    /* renamed from: t, reason: collision with root package name */
    public final List f1412t;

    /* renamed from: u, reason: collision with root package name */
    public final int f1413u;

    public e(List list, LottieComposition lottieComposition, String str, long j4, int i4, long j5, String str2, List list2, K0.c cVar, int i5, int i6, int i7, float f4, float f5, int i8, int i9, K0.a aVar, t.d dVar, List list3, int i10, K0.b bVar) {
        this.f1393a = list;
        this.f1394b = lottieComposition;
        this.f1395c = str;
        this.f1396d = j4;
        this.f1397e = i4;
        this.f1398f = j5;
        this.f1399g = str2;
        this.f1400h = list2;
        this.f1401i = cVar;
        this.f1402j = i5;
        this.f1403k = i6;
        this.f1404l = i7;
        this.f1405m = f4;
        this.f1406n = f5;
        this.f1407o = i8;
        this.f1408p = i9;
        this.f1409q = aVar;
        this.f1410r = dVar;
        this.f1412t = list3;
        this.f1413u = i10;
        this.f1411s = bVar;
    }

    public final String a(String str) {
        int i4;
        StringBuilder sbS = B0.g.s(str);
        sbS.append(this.f1395c);
        sbS.append("\n");
        long j4 = this.f1398f;
        LottieComposition lottieComposition = this.f1394b;
        e eVarLayerModelForId = lottieComposition.layerModelForId(j4);
        if (eVarLayerModelForId != null) {
            sbS.append("\t\tParents: ");
            sbS.append(eVarLayerModelForId.f1395c);
            for (e eVarLayerModelForId2 = lottieComposition.layerModelForId(eVarLayerModelForId.f1398f); eVarLayerModelForId2 != null; eVarLayerModelForId2 = lottieComposition.layerModelForId(eVarLayerModelForId2.f1398f)) {
                sbS.append("->");
                sbS.append(eVarLayerModelForId2.f1395c);
            }
            sbS.append(str);
            sbS.append("\n");
        }
        List list = this.f1400h;
        if (!list.isEmpty()) {
            sbS.append(str);
            sbS.append("\tMasks: ");
            sbS.append(list.size());
            sbS.append("\n");
        }
        int i5 = this.f1402j;
        if (i5 != 0 && (i4 = this.f1403k) != 0) {
            sbS.append(str);
            sbS.append("\tBackground: ");
            sbS.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(this.f1404l)));
        }
        List list2 = this.f1393a;
        if (!list2.isEmpty()) {
            sbS.append(str);
            sbS.append("\tShapes:\n");
            for (Object obj : list2) {
                sbS.append(str);
                sbS.append("\t\t");
                sbS.append(obj);
                sbS.append("\n");
            }
        }
        return sbS.toString();
    }

    public final String toString() {
        return a("");
    }
}
