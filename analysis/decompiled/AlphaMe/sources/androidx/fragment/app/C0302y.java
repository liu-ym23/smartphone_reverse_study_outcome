package androidx.fragment.app;

import d.AbstractC0528b;
import java.util.concurrent.atomic.AtomicReference;
import n.InterfaceC0773a;

/* renamed from: androidx.fragment.app.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0302y extends B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0773a f3838a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3839b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0528b f3840c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ androidx.activity.result.a f3841d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ D f3842e;

    public C0302y(D d4, InterfaceC0773a interfaceC0773a, AtomicReference atomicReference, AbstractC0528b abstractC0528b, androidx.activity.result.a aVar) {
        this.f3842e = d4;
        this.f3838a = interfaceC0773a;
        this.f3839b = atomicReference;
        this.f3840c = abstractC0528b;
        this.f3841d = aVar;
    }

    @Override // androidx.fragment.app.B
    public final void a() {
        D d4 = this.f3842e;
        this.f3839b.set(((androidx.activity.result.g) this.f3838a.apply()).c(d4.generateActivityResultKey(), d4, this.f3840c, this.f3841d));
    }
}
