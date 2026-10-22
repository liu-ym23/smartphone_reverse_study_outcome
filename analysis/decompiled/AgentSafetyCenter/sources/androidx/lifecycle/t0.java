package androidx.lifecycle;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 implements t4.c {

    /* renamed from: a, reason: collision with root package name */
    public t4.d f1437a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1438b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1439c;

    /* renamed from: d, reason: collision with root package name */
    public jb.k f1440d;

    @Override // t4.c
    public final Bundle a() {
        Bundle bundleO = h5.t.o((jb.g[]) Arrays.copyOf(new jb.g[0], 0));
        Bundle bundle = this.f1439c;
        if (bundle != null) {
            bundleO.putAll(bundle);
        }
        for (Map.Entry entry : ((u0) this.f1440d.getValue()).f1442b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((androidx.activity.f) ((p0) entry.getValue()).f1423a.f634d).a();
            if (!bundleA.isEmpty()) {
                str.getClass();
                bundleO.putBundle(str, bundleA);
            }
        }
        this.f1438b = false;
        return bundleO;
    }

    public final void b() {
        if (this.f1438b) {
            return;
        }
        Bundle bundleA = this.f1437a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleO = h5.t.o((jb.g[]) Arrays.copyOf(new jb.g[0], 0));
        Bundle bundle = this.f1439c;
        if (bundle != null) {
            bundleO.putAll(bundle);
        }
        if (bundleA != null) {
            bundleO.putAll(bundleA);
        }
        this.f1439c = bundleO;
        this.f1438b = true;
    }
}
