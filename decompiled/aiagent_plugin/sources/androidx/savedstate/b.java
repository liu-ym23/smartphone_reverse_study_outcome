package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SavedStateRegistryController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.savedstate.a f2723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2724d;

    /* JADX INFO: compiled from: SavedStateRegistryController.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a(c r2) {
            c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            o.e(r1, "owner");
            return new b(r1, null);
        }
    }

    static {
        f2721a = new a(null);
    }

    public /* synthetic */ b(c r2, h r3) {
        this((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin"));
    }

    public static final b a(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        return f2721a.a(r3);
    }

    private b(c r3) {
        this.f2722b = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        this.f2723c = new androidx.savedstate.a();
    }

    public final androidx.savedstate.a a() {
        return this.f2723c;
    }

    public final void b() {
        i r0 = this.f2722b.getLifecycle();
        if (r0.b() != i.b.f2055b) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        r0.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(new Recreator(this.f2722b), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        this.f2723c.a(r0);
        this.f2724d = true;
        return;
    L10:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final void a(Bundle r4) {
        if (this.f2724d == true) goto L5;
        b();
    L5:
        i r0 = this.f2722b.getLifecycle();
        if ((!r0.b().a(i.b.f2057d)) == false) goto L10;
        this.f2723c.a(r4);
        return;
    L10:
        throw new IllegalStateException(("performRestore cannot be called when owner is " + r0.b()).toString());
    }

    public final void b(Bundle r2) {
        o.e(r2, "outBundle");
        this.f2723c.b(r2);
    }
}
