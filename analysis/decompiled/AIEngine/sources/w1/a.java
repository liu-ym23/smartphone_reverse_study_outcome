package w1;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public final d f13549a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: w1.a$a, reason: collision with other inner class name */
    public static final class C0160a implements b.InterfaceC0161b {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f13550a = new LinkedHashSet();

        public C0160a(b bVar) {
            bVar.c("androidx.savedstate.Restarter", this);
        }

        @Override // w1.b.InterfaceC0161b
        public final Bundle a() {
            kotlin.collections.b.d0();
            Bundle bundleA = r0.b.a((Pair[]) Arrays.copyOf(new Pair[0], 0));
            List value = kotlin.collections.a.O0(this.f13550a);
            g.f(value, "value");
            bundleA.putStringArrayList("classes_to_restore", value instanceof ArrayList ? (ArrayList) value : new ArrayList<>(value));
            return bundleA;
        }
    }

    public a(d dVar) {
        this.f13549a = dVar;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        qVar.getLifecycle().c(this);
        d dVar = this.f13549a;
        Bundle bundleA = dVar.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        int size = stringArrayList.size();
        int i10 = 0;
        while (i10 < size) {
            String str = stringArrayList.get(i10);
            i10++;
            String str2 = str;
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, a.class.getClassLoader()).asSubclass(b.a.class);
                g.c(clsAsSubclass);
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        g.c(objNewInstance);
                        ((b.a) objNewInstance).a(dVar);
                    } catch (Exception e10) {
                        throw new RuntimeException(ai.onnxruntime.a.k("Failed to instantiate ", str2), e10);
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                }
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException(a0.a.k("Class ", str2, " wasn't found"), e12);
            }
        }
    }
}
