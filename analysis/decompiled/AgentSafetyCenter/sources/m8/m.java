package m8;

import android.app.Application;
import android.content.res.Resources;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s8.a3;
import s8.g1;
import s8.p3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public Resources f8444c;

    /* renamed from: f, reason: collision with root package name */
    public Application f8445f;

    /* renamed from: g, reason: collision with root package name */
    public String f8446g;

    /* renamed from: h, reason: collision with root package name */
    public List f8447h;
    public Map i;

    /* renamed from: j, reason: collision with root package name */
    public List f8448j;

    /* renamed from: k, reason: collision with root package name */
    public List f8449k;

    /* renamed from: l, reason: collision with root package name */
    public Object f8450l;

    /* renamed from: m, reason: collision with root package name */
    public LinkedHashMap f8451m;

    /* renamed from: n, reason: collision with root package name */
    public String f8452n;

    /* renamed from: o, reason: collision with root package name */
    public List f8453o;

    /* renamed from: p, reason: collision with root package name */
    public Iterator f8454p;

    /* renamed from: q, reason: collision with root package name */
    public String f8455q;

    /* renamed from: r, reason: collision with root package name */
    public int f8456r;

    /* renamed from: s, reason: collision with root package name */
    public int f8457s;

    /* renamed from: t, reason: collision with root package name */
    public /* synthetic */ Object f8458t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ k0 f8459u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ List f8460v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ a3 f8461w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap f8462x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k0 k0Var, List list, a3 a3Var, LinkedHashMap linkedHashMap, nb.c cVar) {
        super(2, cVar);
        this.f8459u = k0Var;
        this.f8460v = list;
        this.f8461w = a3Var;
        this.f8462x = linkedHashMap;
    }

    public static final void a(lb.f fVar, s8.t tVar) {
        List list;
        if (tVar == null || (list = tVar.f11967e) == null) {
            return;
        }
        gc.n nVarR0 = kb.l.r0(list);
        d2.y yVar = new d2.y(18);
        gc.q qVar = gc.q.f4708m;
        gc.i iVar = new gc.i(0);
        iVar.f4694b = nVarR0;
        iVar.f4695c = yVar;
        VarHandle.storeStoreFence();
        Iterator it = iVar.iterator();
        while (true) {
            gc.g gVar = (gc.g) it;
            if (!gVar.hasNext()) {
                return;
            }
            p3 p3Var = (p3) gVar.next();
            fVar.put(g1.O(p3Var), p3Var);
        }
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        m mVar = new m(this.f8459u, this.f8460v, this.f8461w, this.f8462x, cVar);
        mVar.f8458t = obj;
        return mVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((m) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x02de, code lost:
    
        r1 = kc.e0.f7430a;
        r1 = rc.d.f10552f;
        r6 = new androidx.lifecycle.r(r8, r15, null, 6);
        r53.f8458t = null;
        r53.f8444c = r12;
        r53.f8445f = r8;
        r53.f8446g = r13;
        r53.f8447h = r2;
        r53.i = r11;
        r53.f8448j = r9;
        r7 = r24;
        r53.f8449k = r7;
        r15 = r54;
        r53.f8450l = r15;
        r53.f8451m = null;
        r53.f8452n = r4;
        r53.f8453o = r5;
        r53.f8454p = null;
        r53.f8455q = null;
        r53.f8457s = 1;
        r1 = kc.w.E(r1, r6, r53);
        r6 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0312, code lost:
    
        if (r1 != r6) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0316, code lost:
    
        r52 = r12;
        r12 = r2;
        r2 = r5;
        r5 = r52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0724 A[PHI: r2 r4 r6 r9 r10 r11 r12 r13
      0x0724: PHI (r2v53 java.util.List) = (r2v40 java.util.List), (r2v40 java.util.List), (r2v60 java.util.List) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r4v34 java.lang.String) = (r4v27 java.lang.String), (r4v27 java.lang.String), (r4v35 java.lang.String) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r6v41 ob.a) = (r6v38 ob.a), (r6v38 ob.a), (r6v42 ob.a) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r9v34 android.app.Application) = (r9v29 android.app.Application), (r9v29 android.app.Application), (r9v40 android.app.Application) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r10v23 boolean) = (r10v21 boolean), (r10v21 boolean), (r10v24 boolean) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r11v24 java.util.Map) = (r11v22 java.util.Map), (r11v22 java.util.Map), (r11v25 java.util.Map) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r12v14 android.content.res.Resources) = (r12v12 android.content.res.Resources), (r12v12 android.content.res.Resources), (r12v15 android.content.res.Resources) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]
      0x0724: PHI (r13v37 java.lang.String) = (r13v28 java.lang.String), (r13v29 java.lang.String), (r13v40 java.lang.String) binds: [B:131:0x05f7, B:140:0x064f, B:165:0x0722] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0843  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0873  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0886  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0961  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x096b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x096e  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x09b2  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0494 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x046f  */
    /* JADX WARN: Type inference failed for: r1v106 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r1v95, types: [s8.t] */
    /* JADX WARN: Type inference failed for: r34v2 */
    /* JADX WARN: Type inference failed for: r34v3, types: [s8.t] */
    /* JADX WARN: Type inference failed for: r34v4 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v3, types: [s8.t] */
    /* JADX WARN: Type inference failed for: r35v4 */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r38v2, types: [s8.a3] */
    /* JADX WARN: Type inference failed for: r38v3 */
    /* JADX WARN: Type inference failed for: r40v4 */
    /* JADX WARN: Type inference failed for: r40v5, types: [s8.t] */
    /* JADX WARN: Type inference failed for: r40v6 */
    /* JADX WARN: Type inference failed for: r6v57, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v61, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v42, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0324 -> B:60:0x027c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x03c2 -> B:79:0x03c9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x045c -> B:82:0x044b). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
