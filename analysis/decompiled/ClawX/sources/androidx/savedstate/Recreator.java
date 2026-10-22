package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.lifecycle.i0;
import androidx.lifecycle.l;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import kotlin.Metadata;
import w0.c;
import w0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/p;", "w0/a", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recreator implements p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f804a;

    public Recreator(f fVar) {
        this.f804a = fVar;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, w0.f] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, w0.f] */
    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (lVar != l.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        rVar.d().e(this);
        Bundle bundleA = this.f804a.a().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        if (stringArrayList.size() <= 0) {
            return;
        }
        String str = stringArrayList.get(0);
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(c.class);
            kotlin.jvm.internal.p.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    kotlin.jvm.internal.p.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ?? r22 = this.f804a;
                    d0 d0VarC = ((i0) r22).c();
                    r22.a();
                    d0VarC.getClass();
                    throw null;
                } catch (Exception e9) {
                    throw new RuntimeException(m0.f.c("Failed to instantiate ", str), e9);
                }
            } catch (NoSuchMethodException e10) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(m0.f.d("Class ", str, " wasn't found"), e11);
        }
    }
}
