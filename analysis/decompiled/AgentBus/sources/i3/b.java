package i3;

import android.os.Bundle;
import androidx.lifecycle.j0;
import androidx.lifecycle.p;
import androidx.lifecycle.p0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import c.f;
import c.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import q7.k;

/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4638f;

    /* renamed from: g, reason: collision with root package name */
    public final i f4639g;

    public /* synthetic */ b(i iVar, int i2) {
        this.f4638f = i2;
        this.f4639g = iVar;
    }

    @Override // androidx.lifecycle.t
    public final void b(v vVar, p pVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        switch (this.f4638f) {
            case 0:
                i iVar = this.f4639g;
                q6.b bVar = iVar.f1687i;
                if (pVar != p.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                vVar.a().f(this);
                Bundle bundleY0 = ((q6.b) bVar.f8787g).y0("androidx.savedstate.Restarter");
                if (bundleY0 == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleY0.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str, false, b.class.getClassLoader()).asSubclass(c.class);
                        k.b(clsAsSubclass);
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                k.b(objNewInstance);
                                LinkedHashMap linkedHashMap = iVar.c().f1030a;
                                q6.b bVar2 = (q6.b) bVar.f8787g;
                                Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                                while (it.hasNext()) {
                                    String str2 = (String) it.next();
                                    k.e(str2, "key");
                                    p0 p0Var = (p0) linkedHashMap.get(str2);
                                    if (p0Var != null) {
                                        j0.a(p0Var, bVar2, iVar.f4074f);
                                    }
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    bVar2.N0();
                                }
                            } catch (Exception e10) {
                                throw new RuntimeException(a1.a.w("Failed to instantiate ", str), e10);
                            }
                        } catch (NoSuchMethodException e11) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                        }
                    } catch (ClassNotFoundException e12) {
                        throw new RuntimeException(a1.a.j("Class ", str, " wasn't found"), e12);
                    }
                }
                return;
            default:
                i iVar2 = this.f4639g;
                if (iVar2.f1688j == null) {
                    f fVar = (f) iVar2.getLastNonConfigurationInstance();
                    if (fVar != null) {
                        iVar2.f1688j = fVar.f1674a;
                    }
                    if (iVar2.f1688j == null) {
                        iVar2.f1688j = new s0(0);
                    }
                }
                iVar2.f4074f.f(this);
                return;
        }
    }
}
