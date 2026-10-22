package w;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14959a = 1;

    public static final b b(int i, String str) {
        WeakHashMap weakHashMap = z0.f15068u;
        b bVar = new b();
        bVar.f14952a = i;
        bVar.f14953b = str;
        bVar.f14954c = k0.z.v(f3.b.f3899e);
        bVar.f14955d = k0.z.v(Boolean.TRUE);
        VarHandle.storeStoreFence();
        return bVar;
    }

    public static final x0 d(int i, String str) {
        WeakHashMap weakHashMap = z0.f15068u;
        g0 g0Var = new g0();
        g0Var.f14976a = 0;
        g0Var.f14977b = 0;
        g0Var.f14978c = 0;
        g0Var.f14979d = 0;
        VarHandle.storeStoreFence();
        x0 x0Var = new x0();
        x0Var.f15064a = str;
        x0Var.f15065b = k0.z.v(g0Var);
        VarHandle.storeStoreFence();
        return x0Var;
    }

    public static z0 e(k0.s sVar) {
        z0 z0Var;
        View view = (View) sVar.j(AndroidCompositionLocals_androidKt.f986f);
        WeakHashMap weakHashMap = z0.f15068u;
        synchronized (weakHashMap) {
            try {
                Object z0Var2 = weakHashMap.get(view);
                if (z0Var2 == null) {
                    z0Var2 = new z0(view);
                    weakHashMap.put(view, z0Var2);
                }
                z0Var = (z0) z0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean zH = sVar.h(z0Var) | sVar.h(view);
        Object objM = sVar.M();
        if (zH || objM == k0.m.f6974a) {
            objM = new v1.i0(7, z0Var, view);
            sVar.i0(objM);
        }
        k0.z.d(z0Var, (xb.l) objM, sVar);
        return z0Var;
    }

    @Override // w.h
    public void c(int i, s1.h0 h0Var, int[] iArr, int[] iArr2) {
        switch (this.f14959a) {
            case 0:
                k.c(i, iArr, iArr2, false);
                break;
            default:
                k.b(iArr, iArr2, false);
                break;
        }
    }

    public String toString() {
        switch (this.f14959a) {
            case 0:
                return "Arrangement#Bottom";
            case 1:
                return "Arrangement#Top";
            default:
                return super.toString();
        }
    }
}
