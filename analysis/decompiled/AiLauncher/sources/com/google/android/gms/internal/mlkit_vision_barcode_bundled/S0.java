package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public class S0 {

    /* renamed from: a, reason: collision with root package name */
    public volatile InterfaceC1720h1 f20050a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzdf f20051b;

    public final int a() {
        if (this.f20051b != null) {
            return ((zzde) this.f20051b).f20158c.length;
        }
        if (this.f20050a != null) {
            return this.f20050a.a();
        }
        return 0;
    }

    public final zzdf b() {
        if (this.f20051b != null) {
            return this.f20051b;
        }
        synchronized (this) {
            try {
                if (this.f20051b != null) {
                    return this.f20051b;
                }
                if (this.f20050a == null) {
                    this.f20051b = zzdf.f20159b;
                } else {
                    this.f20051b = this.f20050a.i();
                }
                return this.f20051b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final InterfaceC1720h1 c(InterfaceC1720h1 interfaceC1720h1) {
        InterfaceC1720h1 interfaceC1720h12 = this.f20050a;
        this.f20051b = null;
        this.f20050a = interfaceC1720h1;
        return interfaceC1720h12;
    }

    public final void d(InterfaceC1720h1 interfaceC1720h1) {
        if (this.f20050a != null) {
            return;
        }
        synchronized (this) {
            if (this.f20050a != null) {
                return;
            }
            try {
                this.f20050a = interfaceC1720h1;
                this.f20051b = zzdf.f20159b;
            } catch (zzer unused) {
                this.f20050a = interfaceC1720h1;
                this.f20051b = zzdf.f20159b;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S0)) {
            return false;
        }
        S0 s02 = (S0) obj;
        InterfaceC1720h1 interfaceC1720h1 = this.f20050a;
        InterfaceC1720h1 interfaceC1720h12 = s02.f20050a;
        if (interfaceC1720h1 == null && interfaceC1720h12 == null) {
            return b().equals(s02.b());
        }
        if (interfaceC1720h1 != null && interfaceC1720h12 != null) {
            return interfaceC1720h1.equals(interfaceC1720h12);
        }
        if (interfaceC1720h1 != null) {
            s02.d(interfaceC1720h1.g());
            return interfaceC1720h1.equals(s02.f20050a);
        }
        d(interfaceC1720h12.g());
        return this.f20050a.equals(interfaceC1720h12);
    }

    public int hashCode() {
        return 1;
    }
}
