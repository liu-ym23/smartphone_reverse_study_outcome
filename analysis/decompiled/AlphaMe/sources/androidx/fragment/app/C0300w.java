package androidx.fragment.app;

import n.InterfaceC0773a;

/* renamed from: androidx.fragment.app.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0300w implements InterfaceC0773a, G.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3835a;

    public /* synthetic */ C0300w(Object obj) {
        this.f3835a = obj;
    }

    @Override // n.InterfaceC0773a
    public final Object apply() {
        D d4 = (D) this.f3835a;
        Object obj = d4.mHost;
        return obj instanceof androidx.activity.result.h ? ((androidx.activity.result.h) obj).getActivityResultRegistry() : d4.requireActivity().getActivityResultRegistry();
    }

    @Override // G.b
    public final void onCancel() {
        ((q0) this.f3835a).a();
    }
}
