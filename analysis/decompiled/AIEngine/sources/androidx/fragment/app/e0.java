package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f2123a = new f0();

    /* renamed from: b, reason: collision with root package name */
    public static final j0 f2124b;

    static {
        j0 j0Var = null;
        try {
            j0Var = (j0) d2.d.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f2124b = j0Var;
    }

    public static void a(ArrayList<View> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i10);
        }
    }
}
