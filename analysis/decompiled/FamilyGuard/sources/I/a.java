package I;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.N;
import androidx.core.view.O;
import j4.k;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2886a = d.f2890b;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2887b = d.f2889a;

    public static final void a(View view) {
        k.g(view, "<this>");
        Iterator<View> it = O.a(view).iterator();
        while (it.hasNext()) {
            c(it.next()).a();
        }
    }

    public static final void b(ViewGroup viewGroup) {
        k.g(viewGroup, "<this>");
        Iterator<View> it = N.a(viewGroup).iterator();
        while (it.hasNext()) {
            c(it.next()).a();
        }
    }

    private static final c c(View view) {
        int i5 = f2886a;
        c cVar = (c) view.getTag(i5);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        view.setTag(i5, cVar2);
        return cVar2;
    }

    public static final void d(View view, boolean z5) {
        k.g(view, "<this>");
        view.setTag(f2887b, Boolean.valueOf(z5));
    }
}
