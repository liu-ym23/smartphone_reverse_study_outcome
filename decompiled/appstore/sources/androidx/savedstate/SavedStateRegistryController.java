package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryController {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f4729d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SavedStateRegistryOwner f4730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SavedStateRegistry f4731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4732c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final SavedStateRegistryController a(SavedStateRegistryOwner r10) {
            q.g(r10, "owner");
            return new SavedStateRegistryController(r10, null);
        }

        public a() {
        }
    }

    static {
        f4729d = new a(null);
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static final SavedStateRegistryController a(SavedStateRegistryOwner r10) {
        return f4729d.a(r10);
    }

    public final SavedStateRegistry b() {
        return this.f4731b;
    }

    public final void c() {
        Lifecycle r10 = this.f4730a.getLifecycle();
        if (r10.b() != Lifecycle.State.INITIALIZED) goto L7;
        r10.a(new androidx.savedstate.a(this.f4730a));
        this.f4731b.e(r10);
        this.f4732c = true;
        return;
    L7:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void d(Bundle r10) {
        if (this.f4732c == true) goto L5;
        c();
    L5:
        Lifecycle r11 = this.f4730a.getLifecycle();
        if (r11.b().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        this.f4731b.f(r10);
        return;
    L10:
        throw new IllegalStateException(("performRestore cannot be called when owner is " + r11.b()).toString());
    }

    public final void e(Bundle r10) {
        q.g(r10, "outBundle");
        this.f4731b.g(r10);
    }

    public SavedStateRegistryController(SavedStateRegistryOwner r10) {
        this.f4730a = r10;
        this.f4731b = new SavedStateRegistry();
    }
}
