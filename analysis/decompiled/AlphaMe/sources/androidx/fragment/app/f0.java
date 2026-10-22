package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final k0 f3749a = new k0();

    /* renamed from: b, reason: collision with root package name */
    public static final m0 f3750b;

    static {
        m0 m0Var;
        try {
            m0Var = (m0) o0.m.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            m0Var = null;
        }
        f3750b = m0Var;
    }

    public static void a(ArrayList arrayList, int i4) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i4);
        }
    }
}
