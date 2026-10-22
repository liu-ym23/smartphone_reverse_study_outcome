package t4;

import android.os.Bundle;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.o;
import androidx.lifecycle.s0;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import androidx.lifecycle.y0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: c, reason: collision with root package name */
    public f f13166c;

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        f fVar = this.f13166c;
        if (oVar != o.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        xVar.getLifecycle().c(this);
        Bundle bundleA = fVar.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            od.f.e("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        int size = stringArrayList.size();
        int i = 0;
        while (i < size) {
            String str = stringArrayList.get(i);
            i++;
            String str2 = str;
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, a.class.getClassLoader()).asSubclass(b.class);
                clsAsSubclass.getClass();
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        objNewInstance.getClass();
                        if (!(fVar instanceof d1)) {
                            ad.o.e(fVar, "Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: ");
                            return;
                        }
                        c1 viewModelStore = ((d1) fVar).getViewModelStore();
                        d savedStateRegistry = fVar.getSavedStateRegistry();
                        viewModelStore.getClass();
                        LinkedHashMap linkedHashMap = viewModelStore.f1366a;
                        Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            str3.getClass();
                            y0 y0Var = (y0) linkedHashMap.get(str3);
                            if (y0Var != null) {
                                s0.a(y0Var, savedStateRegistry, fVar.getLifecycle());
                            }
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.d();
                        }
                    } catch (Exception e10) {
                        od.f.g(w2.c.b("Failed to instantiate ", str2), e10);
                        return;
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                }
            } catch (ClassNotFoundException e12) {
                od.f.g(k0.a.C("Class ", str2, " wasn't found"), e12);
                return;
            }
        }
    }
}
