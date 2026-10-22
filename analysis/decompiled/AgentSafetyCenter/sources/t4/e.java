package t4;

import ad.o;
import android.os.Bundle;
import androidx.lifecycle.p;
import h5.t;
import java.util.Arrays;
import java.util.Map;
import jb.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public v4.b f13169a;

    /* renamed from: b, reason: collision with root package name */
    public d f13170b;

    public final void a(Bundle bundle) {
        v4.b bVar = this.f13169a;
        f fVar = bVar.f14764a;
        if (!bVar.f14768e) {
            bVar.a();
        }
        if (fVar.getLifecycle().b().compareTo(p.f1421h) >= 0) {
            o.e(fVar.getLifecycle().b(), "performRestore cannot be called when owner is ");
            return;
        }
        if (bVar.f14770g) {
            od.f.e("SavedStateRegistry was already restored.");
            return;
        }
        Bundle bundleI = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleI = t.o.i(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        bVar.f14769f = bundleI;
        bVar.f14770g = true;
    }

    public final void b(Bundle bundle) {
        v4.b bVar = this.f13169a;
        Bundle bundleO = t.o((g[]) Arrays.copyOf(new g[0], 0));
        Bundle bundle2 = bVar.f14769f;
        if (bundle2 != null) {
            bundleO.putAll(bundle2);
        }
        synchronized (bVar.f14766c) {
            for (Map.Entry entry : bVar.f14767d.entrySet()) {
                String str = (String) entry.getKey();
                Bundle bundleA = ((c) entry.getValue()).a();
                str.getClass();
                bundleO.putBundle(str, bundleA);
            }
        }
        if (bundleO.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleO);
    }
}
