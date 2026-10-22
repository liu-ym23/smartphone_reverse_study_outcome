package D3;

import E3.c;
import Z2.I;
import androidx.fragment.app.A;
import java.util.Arrays;
import t3.g;
import w3.b;
import w3.d;
import w3.e;

/* loaded from: classes2.dex */
public final class a extends g {

    /* renamed from: e, reason: collision with root package name */
    public final g f396e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f397f;

    public a(B3.a aVar) {
        super(aVar, true);
        this.f396e = aVar;
    }

    @Override // t3.g
    public final void e() {
        A a4;
        if (this.f397f) {
            return;
        }
        this.f397f = true;
        try {
            this.f396e.e();
            try {
                c();
            } finally {
            }
        } catch (Throwable th) {
            try {
                I.D(th);
                c.a(th);
                throw new w3.c(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    c();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // t3.g
    public final void f(Throwable th) {
        I.D(th);
        if (this.f397f) {
            return;
        }
        this.f397f = true;
        c.a(th);
        try {
            this.f396e.f(th);
            try {
                c();
            } catch (Throwable th2) {
                c.a(th2);
                throw new d(th2.getMessage(), th2);
            }
        } catch (e e4) {
            try {
                c();
                throw e4;
            } catch (Throwable th3) {
                c.a(th3);
                throw new e("Observer.onError not implemented and error while unsubscribing.", new b(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            c.a(th4);
            try {
                c();
                throw new d("Error occurred when trying to propagate error to Observer.onError", new b(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                c.a(th5);
                throw new d("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new b(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // t3.g
    public final void g(Object obj) {
        try {
            if (this.f397f) {
                return;
            }
            this.f396e.g(obj);
        } catch (Throwable th) {
            I.D(th);
            f(th);
        }
    }
}
