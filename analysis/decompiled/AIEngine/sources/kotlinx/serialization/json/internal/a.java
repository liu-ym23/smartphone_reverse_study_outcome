package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.c;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.jvm.internal.k;
import lb.n;
import mb.y;
import uc.e;
import uc.g;
import uc.p;
import uc.r;
import uc.t;
import vc.m;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final m f10143a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10144b;

    /* renamed from: c, reason: collision with root package name */
    public int f10145c;

    public a(e eVar, m mVar) {
        this.f10143a = mVar;
        this.f10144b = eVar.f13204b;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlinx.serialization.json.internal.a r10, lb.a r11, kotlin.coroutines.jvm.internal.BaseContinuationImpl r12) {
        /*
            vc.m r0 = r10.f10143a
            boolean r1 = r12 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r1 == 0) goto L15
            r1 = r12
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r1 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r1
            int r2 = r1.f10135j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f10135j = r2
            goto L1a
        L15:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r1 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r1.<init>(r10, r12)
        L1a:
            java.lang.Object r12 = r1.f10134e
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.f10135j
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 7
            r8 = 4
            r9 = 1
            if (r3 == 0) goto L5a
            if (r3 != r9) goto L52
            java.lang.String r10 = r1.f10133d
            java.util.LinkedHashMap r11 = r1.f10132c
            kotlinx.serialization.json.internal.a r0 = r1.f10131b
            lb.a r3 = r1.f10130a
            kotlin.c.b(r12)
            uc.g r12 = (uc.g) r12
            r11.put(r10, r12)
            vc.m r10 = r0.f10143a
            byte r10 = r10.e()
            if (r10 == r8) goto L4d
            if (r10 != r7) goto L45
            goto L98
        L45:
            vc.m r10 = r0.f10143a
            java.lang.String r11 = "Expected end of the object or comma"
            vc.m.n(r10, r11, r4, r6)
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
            kotlin.c.b(r12)
            byte r12 = r0.f(r6)
            byte r3 = r0.r()
            if (r3 == r8) goto Lac
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
        L6c:
            vc.m r3 = r10.f10143a
            boolean r4 = r3.b()
            if (r4 == 0) goto L95
            boolean r12 = r10.f10144b
            if (r12 == 0) goto L7d
            java.lang.String r12 = r3.j()
            goto L81
        L7d:
            java.lang.String r12 = r3.i()
        L81:
            r4 = 5
            r3.f(r4)
            lb.n r3 = lb.n.f10413a
            r1.f10130a = r11
            r1.f10131b = r10
            r1.f10132c = r0
            r1.f10133d = r12
            r1.f10135j = r9
            r11.a(r3, r1)
            return r2
        L95:
            r11 = r0
            r0 = r10
            r10 = r12
        L98:
            vc.m r12 = r0.f10143a
            if (r10 != r6) goto La0
            r12.f(r7)
            goto La2
        La0:
            if (r10 == r8) goto La8
        La2:
            uc.r r10 = new uc.r
            r10.<init>(r11)
            return r10
        La8:
            mb.y.E(r12)
            throw r5
        Lac:
            java.lang.String r10 = "Unexpected leading comma"
            vc.m.n(r0, r10, r4, r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.a.a(kotlinx.serialization.json.internal.a, lb.a, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g b() {
        g rVar;
        Object obj;
        Object objInvoke;
        m mVar = this.f10143a;
        byte bR = mVar.r();
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
            m.n(mVar, "Cannot read Json element because of unexpected ".concat(y.Q(bR)), 0, 6);
            throw null;
        }
        int i10 = this.f10145c + 1;
        this.f10145c = i10;
        if (i10 == 200) {
            JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this, null);
            n nVar = n.f10413a;
            CoroutineSingletons coroutineSingletons = kotlin.a.f10000a;
            lb.b bVar = new lb.b();
            bVar.f10392a = jsonTreeReader$readDeepRecursive$1;
            bVar.f10393b = nVar;
            bVar.f10394c = bVar;
            CoroutineSingletons coroutineSingletons2 = kotlin.a.f10000a;
            bVar.f10395d = coroutineSingletons2;
            while (true) {
                obj = bVar.f10395d;
                qb.b<Object> bVar2 = bVar.f10394c;
                if (bVar2 == null) {
                    break;
                }
                if (kotlin.jvm.internal.g.b(coroutineSingletons2, obj)) {
                    try {
                        q<? super lb.a<?, ?>, Object, ? super qb.b<Object>, ? extends Object> qVar = bVar.f10392a;
                        Object obj2 = bVar.f10393b;
                        if (qVar == null) {
                            kotlin.jvm.internal.g.f(qVar, "<this>");
                            d context = bVar2.getContext();
                            Object intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 = context == EmptyCoroutineContext.f10057a ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(bVar2) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(bVar2, context);
                            k.c(3, qVar);
                            objInvoke = ((JsonTreeReader$readDeepRecursive$1) qVar).invoke(bVar, obj2, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1);
                        } else {
                            k.c(3, qVar);
                            objInvoke = ((JsonTreeReader$readDeepRecursive$1) qVar).invoke(bVar, obj2, bVar2);
                        }
                        if (objInvoke != CoroutineSingletons.f10059a) {
                            bVar2.resumeWith(objInvoke);
                        }
                    } catch (Throwable th) {
                        bVar2.resumeWith(c.a(th));
                    }
                } else {
                    bVar.f10395d = coroutineSingletons2;
                    bVar2.resumeWith(obj);
                }
            }
            c.b(obj);
            rVar = (g) obj;
        } else {
            byte bF = mVar.f((byte) 6);
            if (mVar.r() == 4) {
                m.n(mVar, "Unexpected leading comma", 0, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!mVar.b()) {
                    break;
                }
                String strJ = this.f10144b ? mVar.j() : mVar.i();
                mVar.f((byte) 5);
                linkedHashMap.put(strJ, b());
                bF = mVar.e();
                if (bF != 4) {
                    if (bF != 7) {
                        m.n(mVar, "Expected end of the object or comma", 0, 6);
                        throw null;
                    }
                }
            }
            if (bF == 6) {
                mVar.f((byte) 7);
            } else if (bF == 4) {
                y.E(mVar);
                throw null;
            }
            rVar = new r(linkedHashMap);
        }
        this.f10145c--;
        return rVar;
    }

    public final uc.b c() {
        m mVar = this.f10143a;
        byte bE = mVar.e();
        if (mVar.r() == 4) {
            m.n(mVar, "Unexpected leading comma", 0, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (mVar.b()) {
            arrayList.add(b());
            bE = mVar.e();
            if (bE != 4) {
                boolean z = bE == 9;
                int i10 = mVar.f13515a;
                if (!z) {
                    m.n(mVar, "Expected end of the array or comma", i10, 4);
                    throw null;
                }
            }
        }
        if (bE == 8) {
            mVar.f((byte) 9);
        } else if (bE == 4) {
            y.D(mVar, "array");
            throw null;
        }
        return new uc.b(arrayList);
    }

    public final t d(boolean z) {
        boolean z3 = this.f10144b;
        m mVar = this.f10143a;
        String strJ = (z3 || !z) ? mVar.j() : mVar.i();
        return (z || !kotlin.jvm.internal.g.b(strJ, "null")) ? new uc.m(strJ, z) : p.INSTANCE;
    }
}
