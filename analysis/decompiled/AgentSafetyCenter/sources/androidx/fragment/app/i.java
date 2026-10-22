package androidx.fragment.app;

import android.os.Handler;
import androidx.activity.e0;
import androidx.activity.g0;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements d1, g0, d.i, t4.f {

    /* renamed from: c, reason: collision with root package name */
    public j f1283c;

    /* renamed from: f, reason: collision with root package name */
    public Handler f1284f;

    /* renamed from: g, reason: collision with root package name */
    public v f1285g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ j f1286h;

    @Override // d.i
    public final d.h getActivityResultRegistry() {
        return this.f1286h.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.x
    public final androidx.lifecycle.q getLifecycle() {
        return this.f1286h.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.g0
    public final e0 getOnBackPressedDispatcher() {
        return this.f1286h.getOnBackPressedDispatcher();
    }

    @Override // t4.f
    public final t4.d getSavedStateRegistry() {
        return this.f1286h.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.d1
    public final c1 getViewModelStore() {
        return this.f1286h.getViewModelStore();
    }
}
