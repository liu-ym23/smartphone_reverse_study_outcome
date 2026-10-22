package I1;

import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final Constructor<?> f3309a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3310b;

    /* renamed from: c, reason: collision with root package name */
    public final Constructor<?> f3311c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f3312d;

    /* renamed from: e, reason: collision with root package name */
    public final L1.a[] f3313e;

    /* renamed from: f, reason: collision with root package name */
    public final L1.a[] f3314f;

    /* renamed from: g, reason: collision with root package name */
    public final H1.c f3315g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3316h = false;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3317i;

    /* renamed from: j, reason: collision with root package name */
    public final String f3318j;

    /* renamed from: k, reason: collision with root package name */
    public final String f3319k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3320l;

    public g(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, L1.a[] aVarArr, L1.a[] aVarArr2, H1.c cVar) {
        int i10;
        boolean z10;
        int length = 0;
        this.f3309a = constructor;
        this.f3311c = constructor2;
        this.f3312d = method;
        this.f3313e = aVarArr;
        this.f3315g = cVar;
        if (cVar != null) {
            String strTypeName = cVar.typeName();
            this.f3318j = strTypeName.length() <= 0 ? cls.getName() : strTypeName;
            String strTypeKey = cVar.typeKey();
            this.f3319k = strTypeKey.length() > 0 ? strTypeKey : null;
            i10 = 0;
            for (Feature feature : cVar.parseFeatures()) {
                i10 |= feature.mask;
            }
        } else {
            this.f3318j = cls.getName();
            this.f3319k = null;
            i10 = 0;
        }
        this.f3320l = i10;
        if (cVar != null) {
            Feature[] features = cVar.parseFeatures();
            z10 = false;
            for (Feature feature2 : features) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z10 = true;
                }
            }
        } else {
            z10 = false;
        }
        this.f3317i = z10;
        L1.a[] aVarArrC = c(aVarArr, aVarArr2);
        this.f3314f = Arrays.equals(aVarArr, aVarArrC) ? aVarArr : aVarArrC;
        if (constructor != null) {
            length = constructor.getParameterTypes().length;
        } else if (method != null) {
            length = method.getParameterTypes().length;
        }
        this.f3310b = length;
    }

    public static boolean a(List<L1.a> list, L1.a aVar, boolean z10) {
        if (!z10) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                L1.a aVar2 = list.get(i10);
                if (aVar2.f4261a.equals(aVar.f4261a) && (!aVar2.f4270j || aVar.f4270j)) {
                    return false;
                }
            }
        }
        list.add(aVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x05ea  */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.reflect.Type[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static I1.g b(java.lang.Class<?> r34, int r35, java.lang.reflect.Type r36, boolean r37, boolean r38, boolean r39, boolean r40, com.alibaba.fastjson.PropertyNamingStrategy r41) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 1654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.g.b(java.lang.Class, int, java.lang.reflect.Type, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):I1.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final L1.a[] c(L1.a[] r9, L1.a[] r10) {
        /*
            Method dump skipped, instructions count: 174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.g.c(L1.a[], L1.a[]):L1.a[]");
    }
}
