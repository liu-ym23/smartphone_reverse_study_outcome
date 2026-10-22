package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: Recreator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2714b;

    /* JADX INFO: compiled from: Recreator.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Recreator.kt */
    public static final class b implements androidx.savedstate.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f2715a;

        public b(androidx.savedstate.a r4) {
            o.e(r4, "registry");
            this.f2715a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
            r4.a("androidx.savedstate.Restarter", (androidx.savedstate.a.c) ZeusTransformUtils.preCheckCast(this, androidx.savedstate.a.c.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.savedstate.a.c
        public Bundle saveState() {
            Bundle r0 = new Bundle();
            r0.putStringArrayList("classes_to_restore", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.f2715a, Collection.class, "com.obric.aiagent.plugin")));
            return r0;
        }

        public final void a(String r2) {
            o.e(r2, "className");
            this.f2715a.add(r2);
        }
    }

    static {
        f2713a = new a(null);
    }

    public Recreator(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        this.f2714b = r4;
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        o.e(r4, "event");
        if (r4 != i.a.ON_CREATE) goto L17;
        r5.getLifecycle().b((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        Bundle r6 = this.f2714b.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (r6 != null) goto L7;
        return;
    L7:
        ArrayList<String> r7 = r6.getStringArrayList("classes_to_restore");
        if (r7 == null) goto L15;
        Iterator r8 = ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        a((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
        goto L11
    L13:
        return;
    L15:
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    L17:
        throw new AssertionError("Next event must be ON_CREATE");
    }

    private final void a(String r6) {
        Class<? extends U> r2 = Class.forName(r6, false, Recreator.class.getClassLoader()).asSubclass(androidx.savedstate.a.InterfaceC0075a.class);     // Catch: ClassNotFoundException -> L15
        o.c(r2, "{\n                Class.…class.java)\n            }");     // Catch: ClassNotFoundException -> L15
        Constructor r0 = r2.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L12
        r0.setAccessible(true);
        Object r1 = r0.newInstance(new Object[0]);     // Catch: Exception -> L9
        o.c(r1, "{\n                constr…wInstance()\n            }");     // Catch: Exception -> L9
        ((androidx.savedstate.a.InterfaceC0075a) ZeusTransformUtils.preCheckCast(r1, androidx.savedstate.a.InterfaceC0075a.class, "com.obric.aiagent.plugin")).a(this.f2714b);
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to instantiate " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L12:
        e = move-exception;
        throw new IllegalStateException("Class " + r2.getSimpleName() + " must have default constructor in order to be automatically recreated", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L15:
        e = move-exception;
        throw new RuntimeException("Class " + r6 + " wasn't found", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
