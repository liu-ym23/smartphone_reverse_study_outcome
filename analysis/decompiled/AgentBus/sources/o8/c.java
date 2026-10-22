package o8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f7793c;

    /* renamed from: a, reason: collision with root package name */
    public final t f7794a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7795b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : a.values()) {
            String str = aVar.f7778f;
            if (linkedHashMap.get(str) == null) {
                linkedHashMap.put(str, aVar);
            }
        }
        f7793c = linkedHashMap;
    }

    public c(t tVar) {
        q7.k.e(tVar, "javaTypeEnhancementState");
        this.f7794a = tVar;
        this.f7795b = new ConcurrentHashMap();
    }

    public static ArrayList a(Object obj, boolean z4) {
        g8.c cVar = (g8.c) obj;
        q7.k.e(cVar, "<this>");
        Map mapB = cVar.b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : mapB.entrySet()) {
            d7.x.D0(arrayList, (!z4 || q7.k.a((e9.f) entry.getKey(), x.f7859b)) ? j((j9.g) entry.getValue()) : d7.z.f2978f);
        }
        return arrayList;
    }

    public static Object c(Object obj, e9.c cVar) {
        for (Object obj2 : e(obj)) {
            if (q7.k.a(d(obj2), cVar)) {
                return obj2;
            }
        }
        return null;
    }

    public static e9.c d(Object obj) {
        g8.c cVar = (g8.c) obj;
        q7.k.e(cVar, "<this>");
        return cVar.a();
    }

    public static Iterable e(Object obj) {
        g8.j annotations;
        g8.c cVar = (g8.c) obj;
        q7.k.e(cVar, "<this>");
        f8.e eVarD = l9.d.d(cVar);
        return (eVarD == null || (annotations = eVarD.getAnnotations()) == null) ? d7.z.f2978f : annotations;
    }

    public static boolean f(Object obj, e9.c cVar) {
        Iterable iterableE = e(obj);
        if ((iterableE instanceof Collection) && ((Collection) iterableE).isEmpty()) {
            return false;
        }
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            if (q7.k.a(d(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    public static List j(j9.g gVar) {
        if (!(gVar instanceof j9.b)) {
            return gVar instanceof j9.i ? a.a.S(((j9.i) gVar).f5410c.c()) : d7.z.f2978f;
        }
        Iterable iterable = (Iterable) ((j9.b) gVar).f5408a;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            d7.x.D0(arrayList, j((j9.g) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012b  */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [w8.h] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o8.u b(o8.u r18, g8.j r19) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o8.c.b(o8.u, g8.j):o8.u");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
    
        if (r9.equals("ALWAYS") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
    
        if (r9.equals("UNKNOWN") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
    
        if (r9.equals("NEVER") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a1, code lost:
    
        if (r9.equals("MAYBE") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
    
        if (r0.equals(o8.y.f7887m) != false) goto L57;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w8.i g(java.lang.Object r9, boolean r10) {
        /*
            r8 = this;
            e9.c r0 = d(r9)
            r1 = 0
            if (r0 != 0) goto L9
            goto Lda
        L9:
            o8.t r8 = r8.f7794a
            r8.getClass()
            o8.s r8 = o8.s.f7847n
            java.lang.Object r8 = r8.invoke(r0)
            o8.b0 r8 = (o8.b0) r8
            r8.getClass()
            o8.b0 r2 = o8.b0.IGNORE
            if (r8 != r2) goto L1e
            return r1
        L1e:
            java.util.List r2 = o8.y.f7881g
            boolean r2 = r2.contains(r0)
            r3 = 0
            r4 = 1
            w8.h r5 = w8.h.f10899g
            if (r2 == 0) goto L2c
            goto Lc8
        L2c:
            java.util.List r2 = o8.y.f7884j
            boolean r2 = r2.contains(r0)
            w8.h r6 = w8.h.f10900h
            if (r2 == 0) goto L39
        L36:
            r5 = r6
            goto Lc8
        L39:
            e9.c r2 = o8.y.f7875a
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L43
            r2 = r4
            goto L49
        L43:
            e9.c r2 = o8.y.f7878d
            boolean r2 = r0.equals(r2)
        L49:
            if (r2 == 0) goto L4d
            goto Lc8
        L4d:
            e9.c r2 = o8.y.f7876b
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L57
            r2 = r4
            goto L5d
        L57:
            e9.c r2 = o8.y.f7879e
            boolean r2 = r0.equals(r2)
        L5d:
            w8.h r7 = w8.h.f10898f
            if (r2 == 0) goto L64
        L61:
            r5 = r7
            goto Lc8
        L64:
            e9.c r2 = o8.y.f7882h
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto La4
            java.util.ArrayList r9 = a(r9, r3)
            java.lang.Object r9 = d7.r.O0(r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L36
            int r0 = r9.hashCode()
            switch(r0) {
                case 73135176: goto L9b;
                case 74175084: goto L92;
                case 433141802: goto L89;
                case 1933739535: goto L80;
                default: goto L7f;
            }
        L7f:
            goto Lda
        L80:
            java.lang.String r0 = "ALWAYS"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto Lda
            goto L36
        L89:
            java.lang.String r0 = "UNKNOWN"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L61
            goto Lda
        L92:
            java.lang.String r0 = "NEVER"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto Lc8
            goto Lda
        L9b:
            java.lang.String r0 = "MAYBE"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto Lc8
            goto Lda
        La4:
            e9.c r9 = o8.y.f7885k
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto Lad
            goto Lc8
        Lad:
            e9.c r9 = o8.y.f7886l
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto Lb6
            goto L36
        Lb6:
            e9.c r9 = o8.y.f7888n
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto Lc0
            goto L36
        Lc0:
            e9.c r9 = o8.y.f7887m
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto Lda
        Lc8:
            w8.i r9 = new w8.i
            o8.b0 r0 = o8.b0.WARN
            if (r8 != r0) goto Ld0
            r8 = r4
            goto Ld1
        Ld0:
            r8 = r3
        Ld1:
            if (r8 != 0) goto Ld5
            if (r10 == 0) goto Ld6
        Ld5:
            r3 = r4
        Ld6:
            r9.<init>(r5, r3)
            return r9
        Lda:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o8.c.g(java.lang.Object, boolean):w8.i");
    }

    public final b0 h(Object obj) {
        String str;
        t tVar = this.f7794a;
        b0 b0Var = (b0) tVar.f7849a.f7854c.get(d(obj));
        if (b0Var != null) {
            return b0Var;
        }
        Object objC = c(obj, b.f7783d);
        if (objC == null || (str = (String) d7.r.O0(a(objC, false))) == null) {
            return null;
        }
        b0 b0Var2 = tVar.f7849a.f7853b;
        if (b0Var2 != null) {
            return b0Var2;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return b0.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return b0.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && str.equals("WARN")) {
            return b0.WARN;
        }
        return null;
    }

    public final Object i(Object obj) {
        Object objI;
        q7.k.e(obj, "annotation");
        if (!this.f7794a.f7849a.f7855d) {
            if (d7.r.I0(b.f7787h, d(obj)) || f(obj, b.f7781b)) {
                return obj;
            }
            if (f(obj, b.f7780a)) {
                f8.e eVarD = l9.d.d((g8.c) obj);
                q7.k.b(eVarD);
                ConcurrentHashMap concurrentHashMap = this.f7795b;
                Object obj2 = concurrentHashMap.get(eVarD);
                if (obj2 != null) {
                    return obj2;
                }
                Iterator it = e(obj).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        objI = null;
                        break;
                    }
                    objI = i(it.next());
                    if (objI != null) {
                        break;
                    }
                }
                if (objI != null) {
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(eVarD, objI);
                    return objPutIfAbsent == null ? objI : objPutIfAbsent;
                }
            }
        }
        return null;
    }
}
