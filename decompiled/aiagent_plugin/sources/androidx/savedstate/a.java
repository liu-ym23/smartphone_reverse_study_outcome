package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SavedStateRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.a.a.b.b<String, c> f2717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f2719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2720e;
    private Recreator.b f;
    private boolean g;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SavedStateRegistry.kt */
    public interface InterfaceC0075a {
        void a(androidx.savedstate.c r1);
    }

    /* JADX INFO: compiled from: SavedStateRegistry.kt */
    private static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: SavedStateRegistry.kt */
    public interface c {
        Bundle saveState();
    }

    static {
        f2716a = new b(null);
    }

    /* JADX INFO: renamed from: lambda$VjZ3bt2aeoFKNKyn-bJk32MNF6E, reason: not valid java name */
    public static /* synthetic */ void m12lambda$VjZ3bt2aeoFKNKynbJk32MNF6E(a r0, p r1, i.a r2) {
        a(r0, r1, r2);
    }

    public a() {
        this.f2717b = new androidx.a.a.b.b();
        this.g = true;
    }

    public final Bundle a(String r4) {
        o.e(r4, "key");
        if (this.f2720e == false) goto L22;
        Bundle r0 = this.f2719d;
        if (r0 == null) goto L20;
        if (r0 == null) goto L8;
        Bundle r1 = r0.getBundle(r4);
    L9:
        Bundle r2 = this.f2719d;
        if (r2 == null) goto L12;
        r2.remove(r4);
    L12:
        Bundle r5 = this.f2719d;
        boolean r3 = false;
        if (r5 != null) goto L15;
    L17:
        if (r3 == true) goto L19;
        this.f2719d = null;
    L19:
        return r1;
    L15:
        if (r5.isEmpty() == true) goto L17;
        r3 = true;
        goto L17
    L8:
        r1 = null;
        goto L9
    L20:
        return null;
    L22:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final void a(String r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        o.e(r3, "key");
        o.e(r5, "provider");
        if (((c) ZeusTransformUtils.preCheckCast(this.f2717b.a(r3, r5), c.class, "com.obric.aiagent.plugin")) != null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final c b(String r5) {
        o.e(r5, "key");
        Iterator<Map.Entry<String, c>> r4 = this.f2717b.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.c(r0, "components");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        c r2 = (c) ZeusTransformUtils.preCheckCast(r0.getValue(), c.class, "com.obric.aiagent.plugin");
        if (o.a(r1, r5) == false) goto L4;
        return r2;
    L8:
        return null;
    }

    public final void a(Class<? extends InterfaceC0075a> r4) {
        o.e(r4, "clazz");
        if (this.g == false) goto L17;
        Recreator.b r0 = this.f;
        if (r0 != null) goto L7;
        r0 = new Recreator.b(this);
    L7:
        this.f = r0;
        r4.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L13
        Recreator.b r3 = this.f;
        if (r3 == null) goto L20;
        String r5 = r4.getName();
        o.c(r5, "clazz.name");
        r3.a(r5);
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + r4.getSimpleName() + " must have default constructor in order to be automatically recreated", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }

    public final void a(i r5) {
        o.e(r5, "lifecycle");
        if ((!this.f2718c) == false) goto L7;
        r5.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(new $$Lambda$a$VjZ3bt2aeoFKNKynbJk32MNF6E(this), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        this.f2718c = true;
        return;
    L7:
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    private static final void a(a r2, p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        o.e(r5, "<anonymous parameter 0>");
        o.e(r4, "event");
        if (r4 != i.a.ON_START) goto L6;
        r2.g = true;
        return;
    L6:
        if (r4 != i.a.ON_STOP) goto L10;
        r2.g = false;
        return;
    }

    public final void a(Bundle r3) {
        if (this.f2718c == false) goto L14;
        if ((!this.f2720e) == false) goto L12;
        if (r3 == null) goto L8;
        Bundle r4 = r3.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
    L9:
        this.f2719d = r4;
        this.f2720e = true;
        return;
    L8:
        r4 = null;
        goto L9
    L12:
        throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    L14:
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    public final void b(Bundle r6) {
        o.e(r6, "outBundle");
        Bundle r0 = new Bundle();
        Bundle r1 = this.f2719d;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        androidx.a.a.b.b<String, c>.d r5 = this.f2717b.c();
        o.c(r5, "this.components.iteratorWithAdditions()");
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r5, Iterator.class, "com.obric.aiagent.plugin");
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.putBundle((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), ((c) ZeusTransformUtils.preCheckCast(r2.getValue(), c.class, "com.obric.aiagent.plugin")).saveState());
        goto L7
    L10:
        if (r0.isEmpty() == true) goto L14;
        r6.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", r0);
        return;
    }
}
