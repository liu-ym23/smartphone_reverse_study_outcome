package h3;

import k3.InterfaceC0696k;

/* loaded from: classes2.dex */
public final class d0 extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f12887a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f12888b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0696k f12889c;

    public d0(M m4, long j4, InterfaceC0696k interfaceC0696k) {
        this.f12887a = m4;
        this.f12888b = j4;
        this.f12889c = interfaceC0696k;
    }

    @Override // h3.f0
    public final long contentLength() {
        return this.f12888b;
    }

    @Override // h3.f0
    public final M contentType() {
        return this.f12887a;
    }

    @Override // h3.f0
    public final InterfaceC0696k source() {
        return this.f12889c;
    }
}
