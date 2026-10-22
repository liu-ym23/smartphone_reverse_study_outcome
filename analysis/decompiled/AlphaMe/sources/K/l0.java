package K;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class l0 extends WindowInsetsAnimation.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final p1.c f983a;

    /* renamed from: b, reason: collision with root package name */
    public List f984b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f985c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f986d;

    public l0(p1.c cVar) {
        super(0);
        this.f986d = new HashMap();
        this.f983a = cVar;
    }

    public final n0 a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.f986d;
        n0 n0Var = (n0) map.get(windowInsetsAnimation);
        if (n0Var != null) {
            return n0Var;
        }
        n0 n0Var2 = new n0(0, null, 0L);
        n0Var2.f993a = new m0(windowInsetsAnimation);
        map.put(windowInsetsAnimation, n0Var2);
        return n0Var2;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        this.f983a.f13926a.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
        this.f986d.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        p1.c cVar = this.f983a;
        View view = cVar.f13926a;
        int[] iArr = cVar.f13929d;
        view.getLocationOnScreen(iArr);
        cVar.f13927b = iArr[1];
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f985c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f985c = arrayList2;
            this.f984b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
            n0 n0VarA = a(windowInsetsAnimation);
            n0VarA.f993a.g0(windowInsetsAnimation.getFraction());
            this.f985c.add(n0VarA);
        }
        z0 z0VarF = z0.f(null, windowInsets);
        this.f983a.a(z0VarF, this.f984b);
        return z0VarF.e();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        a(windowInsetsAnimation);
        D.c cVarC = D.c.c(bounds.getLowerBound());
        D.c cVarC2 = D.c.c(bounds.getUpperBound());
        p1.c cVar = this.f983a;
        View view = cVar.f13926a;
        int[] iArr = cVar.f13929d;
        view.getLocationOnScreen(iArr);
        int i4 = cVar.f13927b - iArr[1];
        cVar.f13928c = i4;
        view.setTranslationY(i4);
        return new WindowInsetsAnimation.Bounds(cVarC.d(), cVarC2.d());
    }
}
