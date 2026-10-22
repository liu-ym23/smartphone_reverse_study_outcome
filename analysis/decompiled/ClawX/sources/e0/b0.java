package e0;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b0 extends WindowInsetsAnimation.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final i1.d f2290a;

    /* renamed from: b, reason: collision with root package name */
    public List f2291b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f2292c;
    public final HashMap d;

    public b0(i1.d dVar) {
        super(0);
        this.d = new HashMap();
        this.f2290a = dVar;
    }

    public final c0 a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.d;
        c0 c0Var = (c0) map.get(windowInsetsAnimation);
        if (c0Var != null) {
            return c0Var;
        }
        c0 c0Var2 = new c0();
        c0Var2.f2300a = new androidx.emoji2.text.m(new WindowInsetsAnimation(0, null, 0L));
        c0Var2.f2300a = new androidx.emoji2.text.m(windowInsetsAnimation);
        map.put(windowInsetsAnimation, c0Var2);
        return c0Var2;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        ((View) this.f2290a.f3136c).setTranslationY(0.0f);
        this.d.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        i1.d dVar = this.f2290a;
        View view = (View) dVar.f3136c;
        int[] iArr = (int[]) dVar.d;
        view.getLocationOnScreen(iArr);
        dVar.f3134a = iArr[1];
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f2292c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f2292c = arrayList2;
            this.f2291b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
            c0 c0VarA = a(windowInsetsAnimation);
            ((WindowInsetsAnimation) c0VarA.f2300a.f621a).setFraction(windowInsetsAnimation.getFraction());
            this.f2292c.add(c0VarA);
        }
        x0 x0VarC = x0.c(null, windowInsets);
        List list2 = this.f2291b;
        i1.d dVar = this.f2290a;
        dVar.getClass();
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((WindowInsetsAnimation) ((c0) it.next()).f2300a.f621a).getTypeMask() & 8) != 0) {
                ((View) dVar.f3136c).setTranslationY(e1.a.c(dVar.f3135b, 0, ((WindowInsetsAnimation) r0.f2300a.f621a).getInterpolatedFraction()));
                break;
            }
        }
        return x0VarC.b();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        a(windowInsetsAnimation);
        x.b bVarC = x.b.c(bounds.getLowerBound());
        x.b bVarC2 = x.b.c(bounds.getUpperBound());
        i1.d dVar = this.f2290a;
        View view = (View) dVar.f3136c;
        int[] iArr = (int[]) dVar.d;
        view.getLocationOnScreen(iArr);
        int i8 = dVar.f3134a - iArr[1];
        dVar.f3135b = i8;
        view.setTranslationY(i8);
        return new WindowInsetsAnimation.Bounds(bVarC.d(), bVarC2.d());
    }
}
