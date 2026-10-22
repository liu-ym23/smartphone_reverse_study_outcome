package U;

import D.AbstractC0772i;
import D.W;
import androidx.camera.core.ImageCaptureException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: U.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1042x {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6148a;

    /* renamed from: b, reason: collision with root package name */
    public final D.W f6149b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.a<Throwable> f6150c;

    public C1042x(AbstractC0772i abstractC0772i) {
        B0.h.a(abstractC0772i.g() == 4);
        this.f6148a = abstractC0772i.c();
        D.W wD = abstractC0772i.d();
        Objects.requireNonNull(wD);
        this.f6149b = wD;
        this.f6150c = abstractC0772i.b();
    }

    public static /* synthetic */ Object a(final C1042x c1042x, final W.a aVar, final CallbackToFutureAdapter.a aVar2) {
        c1042x.f6148a.execute(new Runnable() { // from class: U.w
            @Override // java.lang.Runnable
            public final void run() {
                C1042x c1042x2 = this.f6145a;
                aVar2.c(c1042x2.f6149b.a(aVar));
            }
        });
        return "InternalImageProcessor#process " + aVar.hashCode();
    }

    public W.b c(final W.a aVar) throws ImageCaptureException {
        try {
            return (W.b) CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: U.v
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar2) {
                    return C1042x.a(this.f6143a, aVar, aVar2);
                }
            }).get();
        } catch (Exception e10) {
            e = e10;
            if (e.getCause() != null) {
                e = e.getCause();
            }
            throw new ImageCaptureException(0, "Failed to invoke ImageProcessor.", e);
        }
    }
}
