package j0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0632g {

    /* renamed from: a, reason: collision with root package name */
    public final h f13126a;

    /* renamed from: b, reason: collision with root package name */
    public final C0631f f13127b = new C0631f();

    /* renamed from: c, reason: collision with root package name */
    public boolean f13128c;

    public C0632g(h hVar) {
        this.f13126a = hVar;
    }

    public final void a() {
        h hVar = this.f13126a;
        AbstractC0328z lifecycle = hVar.getLifecycle();
        if (((I) lifecycle).f3871d != EnumC0327y.f3984b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new C0627b(hVar));
        final C0631f c0631f = this.f13127b;
        c0631f.getClass();
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (!(!c0631f.f13121b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new E() { // from class: j0.c
            @Override // androidx.lifecycle.E
            public final void a(G g4, EnumC0326x event) {
                C0631f this$0 = c0631f;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(g4, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == EnumC0326x.ON_START) {
                    this$0.f13125f = true;
                } else if (event == EnumC0326x.ON_STOP) {
                    this$0.f13125f = false;
                }
            }
        });
        c0631f.f13121b = true;
        this.f13128c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f13128c) {
            a();
        }
        I i4 = (I) this.f13126a.getLifecycle();
        if (!(!i4.f3871d.a(EnumC0327y.f3986d))) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + i4.f3871d).toString());
        }
        C0631f c0631f = this.f13127b;
        if (!c0631f.f13121b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!c0631f.f13123d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        c0631f.f13122c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        c0631f.f13123d = true;
    }

    public final void c(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        C0631f c0631f = this.f13127b;
        c0631f.getClass();
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = c0631f.f13122c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        m.g gVar = c0631f.f13120a;
        gVar.getClass();
        m.d dVar = new m.d(gVar);
        gVar.f13520c.put(dVar, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(dVar, "this.components.iteratorWithAdditions()");
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle.putBundle((String) entry.getKey(), ((InterfaceC0630e) entry.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }
}
