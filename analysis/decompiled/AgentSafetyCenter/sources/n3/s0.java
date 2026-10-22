package n3;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends WindowInsetsAnimation.Callback {

    /* renamed from: a, reason: collision with root package name */
    public r0 f8746a;

    /* renamed from: b, reason: collision with root package name */
    public List f8747b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f8748c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f8749d;

    public final t0 a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.f8749d;
        t0 t0Var = (t0) map.get(windowInsetsAnimation);
        if (t0Var != null) {
            return t0Var;
        }
        t0 t0Var2 = new t0();
        new WindowInsetsAnimation(0, null, 0L);
        a2.i iVar = new a2.i(20);
        iVar.f49f = windowInsetsAnimation;
        VarHandle.storeStoreFence();
        t0Var2.f8753a = iVar;
        map.put(windowInsetsAnimation, t0Var2);
        return t0Var2;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.f8746a.e(a(windowInsetsAnimation));
        this.f8749d.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        r0 r0Var = this.f8746a;
        a(windowInsetsAnimation);
        r0Var.g();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f8748c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f8748c = arrayList2;
            this.f8747b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
            t0 t0VarA = a(windowInsetsAnimation);
            ((WindowInsetsAnimation) t0VarA.f8753a.f49f).setFraction(windowInsetsAnimation.getFraction());
            this.f8748c.add(t0VarA);
        }
        return this.f8746a.h(m1.h(null, windowInsets), this.f8747b).g();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        r0 r0Var = this.f8746a;
        t0 t0VarA = a(windowInsetsAnimation);
        p5.u uVar = new p5.u(7);
        uVar.f9807f = f3.b.b(bounds.getLowerBound());
        uVar.f9808g = f3.b.b(bounds.getUpperBound());
        VarHandle.storeStoreFence();
        p5.u uVarI = r0Var.i(t0VarA, uVar);
        uVarI.getClass();
        return new WindowInsetsAnimation.Bounds(((f3.b) uVarI.f9807f).c(), ((f3.b) uVarI.f9808g).c());
    }
}
