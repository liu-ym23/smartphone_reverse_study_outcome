package androidx.lifecycle;

import android.os.Bundle;
import c0.C0574d;
import i4.InterfaceC0761a;
import java.util.Map;

/* loaded from: classes.dex */
public final class N implements C0574d.c {

    /* renamed from: a, reason: collision with root package name */
    private final C0574d f10826a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10827b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f10828c;

    /* renamed from: d, reason: collision with root package name */
    private final V3.f f10829d;

    static final class a extends j4.l implements InterfaceC0761a<O> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ X f10830a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(X x5) {
            super(0);
            this.f10830a = x5;
        }

        @Override // i4.InterfaceC0761a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final O invoke() {
            return M.e(this.f10830a);
        }
    }

    public N(C0574d c0574d, X x5) {
        j4.k.g(c0574d, "savedStateRegistry");
        j4.k.g(x5, "viewModelStoreOwner");
        this.f10826a = c0574d;
        this.f10829d = V3.g.b(new a(x5));
    }

    private final O c() {
        return (O) this.f10829d.getValue();
    }

    @Override // c0.C0574d.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f10828c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, J> entry : c().K().entrySet()) {
            String key = entry.getKey();
            Bundle bundleA = entry.getValue().c().a();
            if (!j4.k.b(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleA);
            }
        }
        this.f10827b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        j4.k.g(str, "key");
        d();
        Bundle bundle = this.f10828c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f10828c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f10828c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f10828c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.f10827b) {
            return;
        }
        Bundle bundleB = this.f10826a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f10828c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f10828c = bundle;
        this.f10827b = true;
        c();
    }
}
