package w1;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import lb.n;
import mb.y;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final x1.a f13553a;

    /* renamed from: b, reason: collision with root package name */
    public final b f13554b;

    public c(x1.a aVar) {
        this.f13553a = aVar;
        this.f13554b = new b(aVar);
    }

    public final void a(Bundle bundle) {
        x1.a aVar = this.f13553a;
        d dVar = aVar.f13696a;
        if (!aVar.f13700e) {
            aVar.a();
        }
        if (dVar.getLifecycle().b().compareTo(Lifecycle.State.f2217d) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + dVar.getLifecycle().b()).toString());
        }
        if (aVar.f13702g) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleA = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleA = y.A(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        aVar.f13701f = bundleA;
        aVar.f13702g = true;
    }

    public final void b(Bundle outBundle) {
        g.f(outBundle, "outBundle");
        x1.a aVar = this.f13553a;
        kotlin.collections.b.d0();
        Bundle bundleA = r0.b.a((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = aVar.f13701f;
        if (bundle != null) {
            bundleA.putAll(bundle);
        }
        synchronized (aVar.f13698c) {
            try {
                for (Map.Entry entry : aVar.f13699d.entrySet()) {
                    String key = (String) entry.getKey();
                    Bundle value = ((b.InterfaceC0161b) entry.getValue()).a();
                    g.f(key, "key");
                    g.f(value, "value");
                    bundleA.putBundle(key, value);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bundleA.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleA);
    }
}
