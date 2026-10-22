package g1;

import Z8.F;
import android.os.Bundle;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import g1.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lg1/a;", "Landroidx/lifecycle/m;", "Lg1/h;", "owner", "<init>", "(Lg1/h;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "", "className", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lg1/h;", Const.INTENT_KEY_PKGNAME, "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: g1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4090a implements InterfaceC1395m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h owner;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010¨\u0006\u0012"}, d2 = {"Lg1/a$b;", "Lg1/e$b;", "Lg1/e;", "registry", "<init>", "(Lg1/e;)V", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", Const.INTENT_KEY_APIKEY, "()Landroid/os/Bundle;", "", "className", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "", "Ljava/util/Set;", "classes", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: g1.a$b */
    public static final class b implements e.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Set<String> classes;

        public b(e registry) {
            p.i(registry, "registry");
            this.classes = new LinkedHashSet();
            registry.c("androidx.savedstate.Restarter", this);
        }

        @Override // g1.e.b
        public Bundle a() {
            Pair[] pairArr;
            Map mapI = kotlin.collections.a.i();
            if (mapI.isEmpty()) {
                pairArr = new Pair[0];
            } else {
                ArrayList arrayList = new ArrayList(mapI.size());
                for (Map.Entry entry : mapI.entrySet()) {
                    arrayList.add(Y8.j.a((String) entry.getKey(), entry.getValue()));
                }
                pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            }
            Bundle bundleA = x0.c.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            i.d(i.a(bundleA), "classes_to_restore", F.m1(this.classes));
            return bundleA;
        }

        public final void b(String className) {
            p.i(className, "className");
            this.classes.add(className);
        }
    }

    public C4090a(h owner) {
        p.i(owner, "owner");
        this.owner = owner;
    }

    public final void a(String className) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(className, false, C4090a.class.getClassLoader()).asSubclass(e.a.class);
            p.f(clsAsSubclass);
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    p.f(objNewInstance);
                    ((e.a) objNewInstance).a(this.owner);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + className, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + className + " wasn't found", e12);
        }
    }

    @Override // android.view.InterfaceC1395m
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        p.i(source, "source");
        p.i(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().d(this);
        Bundle bundleA = this.owner.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        List<String> listE = C4091b.e(C4091b.a(bundleA), "classes_to_restore");
        if (listE == null) {
            throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = listE.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
