package b0;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.fragment.app.D;
import androidx.fragment.app.Y;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0357c {

    /* renamed from: a, reason: collision with root package name */
    public static final C0356b f4364a = C0356b.f4361c;

    public static C0356b a(D d4) {
        while (d4 != null) {
            if (d4.isAdded()) {
                Y parentFragmentManager = d4.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "declaringFragment.parentFragmentManager");
                parentFragmentManager.getClass();
            }
            d4 = d4.getParentFragment();
        }
        return f4364a;
    }

    public static void b(C0356b c0356b, AbstractC0364j abstractC0364j) {
        D d4 = abstractC0364j.f4366a;
        String name = d4.getClass().getName();
        EnumC0355a enumC0355a = EnumC0355a.f4352a;
        Set set = c0356b.f4362a;
        if (set.contains(enumC0355a)) {
            Log.d("FragmentStrictMode", "Policy violation in ".concat(name), abstractC0364j);
        }
        if (set.contains(EnumC0355a.f4353b)) {
            o oVar = new o(3, name, abstractC0364j);
            if (!d4.isAdded()) {
                oVar.run();
                return;
            }
            Handler handler = d4.getParentFragmentManager().f3682u.f3627c;
            Intrinsics.checkNotNullExpressionValue(handler, "fragment.parentFragmentManager.host.handler");
            if (Intrinsics.areEqual(handler.getLooper(), Looper.myLooper())) {
                oVar.run();
            } else {
                handler.post(oVar);
            }
        }
    }

    public static void c(AbstractC0364j abstractC0364j) {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(abstractC0364j.f4366a.getClass().getName()), abstractC0364j);
        }
    }

    public static final void d(D fragment, String previousFragmentId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        C0358d c0358d = new C0358d(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        c(c0358d);
        C0356b c0356bA = a(fragment);
        if (c0356bA.f4362a.contains(EnumC0355a.f4354c) && e(c0356bA, fragment.getClass(), C0358d.class)) {
            b(c0356bA, c0358d);
        }
    }

    public static boolean e(C0356b c0356b, Class cls, Class cls2) {
        Set set = (Set) c0356b.f4363b.get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.areEqual(cls2.getSuperclass(), AbstractC0364j.class) || !CollectionsKt.contains(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
