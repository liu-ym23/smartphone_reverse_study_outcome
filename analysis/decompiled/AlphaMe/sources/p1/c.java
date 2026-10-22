package p1;

import K.n0;
import K.z0;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import n1.AbstractC0775a;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final View f13926a;

    /* renamed from: b, reason: collision with root package name */
    public int f13927b;

    /* renamed from: c, reason: collision with root package name */
    public int f13928c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f13929d = new int[2];

    public c(View view) {
        this.f13926a = view;
    }

    public final void a(z0 z0Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((n0) it.next()).f993a.f989i.getTypeMask() & 8) != 0) {
                this.f13926a.setTranslationY(AbstractC0775a.c(r3.f993a.f989i.getInterpolatedFraction(), this.f13928c, 0));
                return;
            }
        }
    }
}
