package androidx.lifecycle;

import android.os.Bundle;
import j0.C0631f;
import j0.InterfaceC0630e;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i0 implements InterfaceC0630e {

    /* renamed from: a, reason: collision with root package name */
    public final C0631f f3950a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3951b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f3952c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f3953d;

    public i0(C0631f savedStateRegistry, u0 viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.f3950a = savedStateRegistry;
        this.f3953d = LazyKt.lazy(new S.A(2, viewModelStoreOwner));
    }

    @Override // j0.InterfaceC0630e
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3952c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((j0) this.f3953d.getValue()).f3957a.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((e0) entry.getValue()).f3935e.a();
            if (!Intrinsics.areEqual(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f3951b = false;
        return bundle;
    }

    public final void b() {
        if (this.f3951b) {
            return;
        }
        Bundle bundleA = this.f3950a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3952c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        this.f3952c = bundle;
        this.f3951b = true;
    }
}
