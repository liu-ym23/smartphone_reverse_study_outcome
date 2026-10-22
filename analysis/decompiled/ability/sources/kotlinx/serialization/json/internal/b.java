package kotlinx.serialization.json.internal;

import C7.r;
import C9.B;
import C9.d;
import C9.i;
import C9.l;
import C9.u;
import C9.x;
import D9.j;
import D9.t;
import S7.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final t f5268a;
    public final boolean b;
    public int c;

    public b(i iVar, t tVar) {
        this.f5268a = tVar;
        this.b = iVar.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlinx.serialization.json.internal.b r10, C7.b r11, kotlin.coroutines.jvm.internal.BaseContinuationImpl r12) {
        /*
            D9.t r0 = r10.f5268a
            boolean r1 = r12 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r1 == 0) goto L15
            r1 = r12
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r1 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r1
            int r2 = r1.g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.g = r2
            goto L1a
        L15:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r1 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r1.<init>(r10, r12)
        L1a:
            java.lang.Object r12 = r1.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.g
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 7
            r8 = 4
            r9 = 1
            if (r3 == 0) goto L5a
            if (r3 != r9) goto L52
            java.lang.String r10 = r1.d
            java.util.LinkedHashMap r11 = r1.c
            kotlinx.serialization.json.internal.b r0 = r1.b
            C7.b r3 = r1.f5265a
            kotlin.b.b(r12)
            C9.l r12 = (C9.l) r12
            r11.put(r10, r12)
            D9.t r10 = r0.f5268a
            byte r10 = r10.f()
            if (r10 == r8) goto L4d
            if (r10 != r7) goto L45
            goto L98
        L45:
            D9.t r10 = r0.f5268a
            java.lang.String r11 = "Expected end of the object or comma"
            D9.t.o(r10, r11, r4, r5, r6)
            throw r5
        L4d:
            r12 = r10
            r10 = r0
            r0 = r11
            r11 = r3
            goto L6c
        L52:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L5a:
            kotlin.b.b(r12)
            byte r12 = r0.g(r6)
            byte r3 = r0.r()
            if (r3 == r8) goto Lae
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
        L6c:
            D9.t r3 = r10.f5268a
            boolean r4 = r3.c()
            if (r4 == 0) goto L95
            boolean r12 = r10.b
            if (r12 == 0) goto L7d
            java.lang.String r12 = r3.k()
            goto L81
        L7d:
            java.lang.String r12 = r3.j()
        L81:
            r4 = 5
            r3.g(r4)
            r1.f5265a = r11
            r1.b = r10
            r1.c = r0
            r1.d = r12
            r1.g = r9
            r11.getClass()
            r11.b = r1
            return r2
        L95:
            r11 = r0
            r0 = r10
            r10 = r12
        L98:
            D9.t r12 = r0.f5268a
            if (r10 != r6) goto La0
            r12.g(r7)
            goto La2
        La0:
            if (r10 == r8) goto La8
        La2:
            C9.x r10 = new C9.x
            r10.<init>(r11)
            return r10
        La8:
            java.lang.String r10 = "object"
            D9.j.l(r12, r10)
            throw r5
        Lae:
            java.lang.String r10 = "Unexpected leading comma"
            D9.t.o(r0, r10, r4, r5, r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.b.a(kotlinx.serialization.json.internal.b, C7.b, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public final l b() {
        l xVar;
        Object obj;
        t tVar = this.f5268a;
        byte bR = tVar.r();
        if (bR == 1) {
            return d(true);
        }
        if (bR == 0) {
            return d(false);
        }
        if (bR != 6) {
            if (bR == 8) {
                return c();
            }
            t.o(tVar, "Cannot read Json element because of unexpected ".concat(j.r(bR)), 0, null, 6);
            throw null;
        }
        int i = this.c + 1;
        this.c = i;
        if (i == 200) {
            JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this, null);
            CoroutineSingletons coroutineSingletons = C7.a.f304a;
            C7.b bVar = new C7.b();
            bVar.f305a = jsonTreeReader$readDeepRecursive$1;
            bVar.b = bVar;
            CoroutineSingletons coroutineSingletons2 = C7.a.f304a;
            bVar.c = coroutineSingletons2;
            while (true) {
                obj = bVar.c;
                H7.c cVar = bVar.b;
                if (cVar == null) {
                    break;
                }
                if (k.b(coroutineSingletons2, obj)) {
                    try {
                        o oVar = bVar.f305a;
                        p.e(3, oVar);
                        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$12 = new JsonTreeReader$readDeepRecursive$1(((JsonTreeReader$readDeepRecursive$1) oVar).c, cVar);
                        jsonTreeReader$readDeepRecursive$12.b = bVar;
                        Object objInvokeSuspend = jsonTreeReader$readDeepRecursive$12.invokeSuspend(r.f317a);
                        if (objInvokeSuspend != CoroutineSingletons.f4909a) {
                            cVar.resumeWith(objInvokeSuspend);
                        }
                    } catch (Throwable th) {
                        cVar.resumeWith(kotlin.b.a(th));
                    }
                } else {
                    bVar.c = coroutineSingletons2;
                    cVar.resumeWith(obj);
                }
            }
            kotlin.b.b(obj);
            xVar = (l) obj;
        } else {
            byte bG = tVar.g((byte) 6);
            if (tVar.r() == 4) {
                t.o(tVar, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!tVar.c()) {
                    break;
                }
                String strK = this.b ? tVar.k() : tVar.j();
                tVar.g((byte) 5);
                linkedHashMap.put(strK, b());
                bG = tVar.f();
                if (bG != 4) {
                    if (bG != 7) {
                        t.o(tVar, "Expected end of the object or comma", 0, null, 6);
                        throw null;
                    }
                }
            }
            if (bG == 6) {
                tVar.g((byte) 7);
            } else if (bG == 4) {
                j.l(tVar, "object");
                throw null;
            }
            xVar = new x(linkedHashMap);
        }
        this.c--;
        return xVar;
    }

    public final d c() {
        t tVar = this.f5268a;
        byte bF = tVar.f();
        if (tVar.r() == 4) {
            t.o(tVar, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (tVar.c()) {
            arrayList.add(b());
            bF = tVar.f();
            if (bF != 4) {
                boolean z10 = bF == 9;
                int i = tVar.c;
                if (!z10) {
                    t.o(tVar, "Expected end of the array or comma", i, null, 4);
                    throw null;
                }
            }
        }
        if (bF == 8) {
            tVar.g((byte) 9);
        } else if (bF == 4) {
            j.l(tVar, "array");
            throw null;
        }
        return new d(arrayList);
    }

    public final B d(boolean z10) {
        boolean z11 = this.b;
        t tVar = this.f5268a;
        String strK = (z11 || !z10) ? tVar.k() : tVar.j();
        return (z10 || !k.b(strK, "null")) ? new C9.r(strK, z10, null) : u.INSTANCE;
    }
}
