package v3;

import V3.v;
import i4.InterfaceC0761a;
import j4.k;

/* renamed from: v3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1190g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f23345a;

    public final boolean a() {
        if (!this.f23345a) {
            return false;
        }
        this.f23345a = false;
        return true;
    }

    public final void b(InterfaceC0761a<v> interfaceC0761a) {
        k.g(interfaceC0761a, "click");
        boolean z5 = this.f23345a;
        this.f23345a = true;
        try {
            interfaceC0761a.invoke();
        } finally {
            this.f23345a = z5;
        }
    }

    public final boolean c() {
        return this.f23345a;
    }
}
