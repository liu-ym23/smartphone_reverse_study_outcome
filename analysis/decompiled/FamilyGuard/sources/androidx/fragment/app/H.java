package androidx.fragment.app;

import android.view.View;
import androidx.transition.C0550e;
import java.util.ArrayList;
import q.C0933a;

/* loaded from: classes.dex */
class H {

    /* renamed from: a, reason: collision with root package name */
    static final J f10456a = new I();

    /* renamed from: b, reason: collision with root package name */
    static final J f10457b = b();

    static void a(ComponentCallbacksC0511f componentCallbacksC0511f, ComponentCallbacksC0511f componentCallbacksC0511f2, boolean z5, C0933a<String, View> c0933a, boolean z6) {
        if (z5) {
            componentCallbacksC0511f2.z();
        } else {
            componentCallbacksC0511f.z();
        }
    }

    private static J b() {
        try {
            return (J) C0550e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void c(C0933a<String, String> c0933a, C0933a<String, View> c0933a2) {
        for (int size = c0933a.size() - 1; size >= 0; size--) {
            if (!c0933a2.containsKey(c0933a.j(size))) {
                c0933a.h(size);
            }
        }
    }

    static void d(ArrayList<View> arrayList, int i5) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i5);
        }
    }
}
