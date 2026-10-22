package t2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import k0.e2;
import k0.h2;
import k0.i2;
import k0.o;
import k0.t;
import k0.v;
import kb.s;
import p.a0;
import p.u;
import w.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x026b  */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(int r35, int r36, k0.s r37, u.k r38, w.h r39, w.l0 r40, w0.c r41, w0.m r42, x.r r43, xb.l r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.a.a(int, int, k0.s, u.k, w.h, w.l0, w0.c, w0.m, x.r, xb.l, boolean):void");
    }

    public static final int b(int i, m0.e eVar) {
        int i3 = eVar.f8160g - 1;
        int i10 = 0;
        while (i10 < i3) {
            int i11 = ((i3 - i10) / 2) + i10;
            Object[] objArr = eVar.f8158c;
            int i12 = ((y.h) objArr[i11]).f15745a;
            if (i12 != i) {
                if (i12 < i) {
                    i10 = i11 + 1;
                    if (i < ((y.h) objArr[i10]).f15745a) {
                    }
                } else {
                    i3 = i11 - 1;
                }
            }
            return i11;
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [te.f] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [k0.b] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Integer] */
    public static final List c(i2 i2Var, Integer num, int i, Integer num2) {
        int iD;
        a0 a0Var;
        if (i2Var.f6959w || i2Var.p() == 0) {
            return s.f7404c;
        }
        ?? hVar = new v0.h();
        VarHandle.storeStoreFence();
        if (num2 != null) {
            iD = num2.intValue();
        } else {
            iD = i2Var.f6958v;
            if (iD < 0) {
                iD = i2Var.D(i2Var.f6939b, i);
            }
        }
        if (num == 0) {
            int iM = i2Var.i - i2Var.M(i2Var.f6939b, i2Var.r(i));
            u uVar = i2Var.f6955s;
            num = Integer.valueOf(iM + ((uVar == null || (a0Var = (a0) uVar.b(i)) == null) ? 0 : a0Var.f9517b));
        }
        while (i >= 0) {
            hVar.d(i2Var.N(i), num);
            num = i2Var.b(i);
            if (iD >= 0) {
                int i3 = iD;
                iD = i2Var.D(i2Var.f6939b, iD);
                i = i3;
            } else {
                i = iD;
            }
        }
        return (ArrayList) hVar.f13336a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(android.content.Context r23, java.lang.String r24, java.lang.String r25, xb.p r26, xb.l r27, xb.l r28) {
        /*
            Method dump skipped, instructions count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.a.d(android.content.Context, java.lang.String, java.lang.String, xb.p, xb.l, xb.l):boolean");
    }

    public static final void h(AutoCloseable autoCloseable, Throwable th) {
        boolean zIsTerminated;
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    androidx.activity.b.s(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    com.stepos.statsrpk.h.b(th, th2);
                    return;
                }
            }
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (!(autoCloseable instanceof ExecutorService)) {
                od.f.b();
                return;
            }
            ExecutorService executorService = (ExecutorService) autoCloseable;
            if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
                return;
            }
            executorService.shutdown();
            boolean z10 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        executorService.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static final z.a i(u1.l lVar) {
        if (!((w0.l) lVar).f15114c.f15126r) {
            return null;
        }
        z.a aVar = (z.a) u1.f.i(lVar, z.d.f16134u);
        if (aVar != null) {
            return aVar;
        }
        z.e eVar = new z.e();
        eVar.f16137c = lVar;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public static final Integer j(e2 e2Var, v vVar, int i, int i3) {
        Integer numJ;
        int[] iArr = e2Var.f6883b;
        while (true) {
            if (i >= i3) {
                return null;
            }
            int iA = h2.a(iArr, i) + i;
            if (e2Var.j(i) && e2Var.i(i) == 206 && yb.k.a(e2Var.p(iArr, i), t.f7066e)) {
                Object objH = e2Var.h(i, 0);
                o oVar = objH instanceof o ? (o) objH : null;
                if (oVar != null && oVar.f6988c.equals(vVar)) {
                    return Integer.valueOf(i);
                }
            }
            if (e2Var.d(i) && (numJ = j(e2Var, vVar, i + 1, iA)) != null) {
                return Integer.valueOf(numJ.intValue());
            }
            i = iA;
        }
    }

    public static Drawable k(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = u9.g.b("android.content.res.stepostheme.StepOSThemeUtils").a("getCustomRes", Context.class, String.class).f14264a.invoke(null, context, str);
            if (objInvoke instanceof Drawable) {
                return (Drawable) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            Log.w("ThemeUtil", "reflect method#getCustomRes has an error:" + e10);
            return null;
        }
    }

    public static final w0.m l(w0.m mVar) {
        c1 c1Var = new c1(3, 0);
        w0.h hVar = new w0.h();
        hVar.f15111f = c1Var;
        VarHandle.storeStoreFence();
        return mVar.d(hVar);
    }

    public static final String o(int i, k0.s sVar) {
        return ((Resources) sVar.j(AndroidCompositionLocals_androidKt.f983c)).getString(i);
    }

    public static final String p(int i, Object[] objArr, k0.s sVar) {
        return ((Resources) sVar.j(AndroidCompositionLocals_androidKt.f983c)).getString(i, Arrays.copyOf(objArr, objArr.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [te.f, v0.h] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    public static final ArrayList q(e2 e2Var, int i, Integer num) {
        ?? hVar = new v0.h(e2Var);
        int iQ = e2Var.q(i);
        k0.b bVarA = e2Var.a(i);
        while (i >= 0) {
            hVar.d(e2Var.f6882a.f(i), num);
            if (iQ >= 0) {
                k0.b bVar = bVarA;
                bVarA = e2Var.a(iQ);
                i = iQ;
                iQ = e2Var.q(iQ);
                num = bVar;
            } else {
                i = iQ;
                num = bVarA;
            }
        }
        return (ArrayList) hVar.f13336a;
    }

    public abstract boolean e(i iVar, e eVar, e eVar2);

    public abstract boolean f(i iVar, Object obj, Object obj2);

    public abstract boolean g(i iVar, h hVar, h hVar2);

    public abstract void m(h hVar, h hVar2);

    public abstract void n(h hVar, Thread thread);
}
