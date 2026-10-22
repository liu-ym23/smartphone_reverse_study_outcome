package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a implements LifecycleEventObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0048a f4733b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SavedStateRegistryOwner f4734a;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public static final class C0048a {
        public /* synthetic */ C0048a(DefaultConstructorMarker r10) {
            this();
        }

        public C0048a() {
        }
    }

    public static final class b implements SavedStateRegistry.SavedStateProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f4735a;

        public b(SavedStateRegistry r10) {
            q.g(r10, "registry");
            this.f4735a = new LinkedHashSet();
            r10.h("androidx.savedstate.Restarter", this);
        }

        public final void a(String r10) {
            q.g(r10, "className");
            this.f4735a.add(r10);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            Bundle r10 = new Bundle();
            r10.putStringArrayList("classes_to_restore", new ArrayList(this.f4735a));
            return r10;
        }
    }

    static {
        f4733b = new C0048a(null);
    }

    public a(SavedStateRegistryOwner r10) {
        q.g(r10, "owner");
        this.f4734a = r10;
    }

    public final void a(String r10) {
        Class<? extends U> r11 = Class.forName(r10, false, a.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);     // Catch: ClassNotFoundException -> L16
        q.f(r11, "{\n                Class.…class.java)\n            }");     // Catch: ClassNotFoundException -> L16
        Constructor r12 = r11.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L13
        r12.setAccessible(true);
        Object r13 = r12.newInstance(null);     // Catch: Exception -> L10
        q.f(r13, "{\n                constr…wInstance()\n            }");     // Catch: Exception -> L10
        ((SavedStateRegistry.AutoRecreated) r13).onRecreated(this.f4734a);
        return;
    L10:
        e = move-exception;
        throw new RuntimeException("Failed to instantiate " + r10, e);
    L13:
        e = move-exception;
        throw new IllegalStateException("Class " + r11.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L16:
        e = move-exception;
        throw new RuntimeException("Class " + r10 + " wasn't found", e);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        q.g(r10, "source");
        q.g(r11, "event");
        if (r11 != Lifecycle.Event.ON_CREATE) goto L17;
        r10.getLifecycle().d(this);
        Bundle r12 = this.f4734a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (r12 != null) goto L7;
        return;
    L7:
        ArrayList<String> r13 = r12.getStringArrayList("classes_to_restore");
        if (r13 == null) goto L15;
        Iterator<String> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        a(r14.next());
        goto L11
    L13:
        return;
    L15:
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    L17:
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
