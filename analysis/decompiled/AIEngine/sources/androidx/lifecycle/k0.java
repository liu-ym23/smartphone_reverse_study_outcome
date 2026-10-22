package androidx.lifecycle;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k0 implements b.InterfaceC0161b {

    /* renamed from: a, reason: collision with root package name */
    public final w1.b f2280a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2281b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f2282c;

    /* renamed from: d, reason: collision with root package name */
    public final lb.d f2283d;

    public k0(w1.b savedStateRegistry, t0 t0Var) {
        kotlin.jvm.internal.g.f(savedStateRegistry, "savedStateRegistry");
        this.f2280a = savedStateRegistry;
        this.f2283d = kotlin.b.b(new j0(t0Var, 0));
    }

    @Override // w1.b.InterfaceC0161b
    public final Bundle a() {
        kotlin.collections.b.d0();
        Bundle bundleA = r0.b.a((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.f2282c;
        if (bundle != null) {
            bundleA.putAll(bundle);
        }
        for (Map.Entry entry : ((l0) this.f2283d.getValue()).f2284b.entrySet()) {
            String key = (String) entry.getKey();
            Bundle bundleA2 = ((f0) entry.getValue()).f2268a.f11393e.a();
            if (!bundleA2.isEmpty()) {
                kotlin.jvm.internal.g.f(key, "key");
                bundleA.putBundle(key, bundleA2);
            }
        }
        this.f2281b = false;
        return bundleA;
    }

    public final void b() {
        if (this.f2281b) {
            return;
        }
        Bundle bundleA = this.f2280a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        kotlin.collections.b.d0();
        Bundle bundleA2 = r0.b.a((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.f2282c;
        if (bundle != null) {
            bundleA2.putAll(bundle);
        }
        if (bundleA != null) {
            bundleA2.putAll(bundleA);
        }
        this.f2282c = bundleA2;
        this.f2281b = true;
    }
}
