package o2;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class p extends WindowInsetsAnimation.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final o f7240a;

    /* renamed from: b, reason: collision with root package name */
    public List f7241b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f7242c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f7243d;

    public p(o oVar) {
        super(oVar.f7239f);
        this.f7243d = new HashMap();
        this.f7240a = oVar;
    }

    public final q a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.f7243d;
        q qVar = (q) map.get(windowInsetsAnimation);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q();
        qVar2.f7244a = new a7.d(29, new WindowInsetsAnimation(0, null, 0L));
        qVar2.f7244a = new a7.d(29, windowInsetsAnimation);
        map.put(windowInsetsAnimation, qVar2);
        return qVar2;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.f7240a.b(a(windowInsetsAnimation));
        this.f7243d.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        this.f7240a.c();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f7242c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f7242c = arrayList2;
            this.f7241b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
            q qVarA = a(windowInsetsAnimation);
            ((WindowInsetsAnimation) qVarA.f7244a.f411g).setFraction(windowInsetsAnimation.getFraction());
            this.f7242c.add(qVarA);
        }
        g0 g0Var = this.f7240a.d(j0.a(null, windowInsets), this.f7241b).f7236a;
        if (g0Var instanceof y) {
            return ((y) g0Var).f7249b;
        }
        return null;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        nb.f fVarE = this.f7240a.e(a(windowInsetsAnimation), new nb.f(bounds));
        fVarE.getClass();
        return new WindowInsetsAnimation.Bounds(((k2.a) fVarE.f6947g).d(), ((k2.a) fVarE.f6948h).d());
    }
}
