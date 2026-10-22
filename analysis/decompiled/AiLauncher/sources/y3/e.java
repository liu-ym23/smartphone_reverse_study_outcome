package y3;

import A2.C0610f5;
import D2.C0790b;
import D2.InterfaceC0793e;
import D2.l;
import android.view.A;
import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import com.google.android.gms.common.internal.C1666g;
import com.google.android.gms.common.internal.C1669j;
import com.google.mlkit.common.MlKitException;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import r3.AbstractC5212f;
import x3.C5846a;

/* loaded from: classes2.dex */
public class e<DetectionResultT> implements Closeable, InterfaceC1397o {

    /* renamed from: f, reason: collision with root package name */
    public static final C1666g f43848f = new C1666g("MobileVisionBase", "");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f43849a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5212f f43850b;

    /* renamed from: c, reason: collision with root package name */
    public final C0790b f43851c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f43852d;

    /* renamed from: e, reason: collision with root package name */
    public final D2.i f43853e;

    public e(AbstractC5212f<DetectionResultT, C5846a> abstractC5212f, Executor executor) {
        this.f43850b = abstractC5212f;
        C0790b c0790b = new C0790b();
        this.f43851c = c0790b;
        this.f43852d = executor;
        abstractC5212f.c();
        this.f43853e = abstractC5212f.a(executor, new Callable() { // from class: y3.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C1666g c1666g = e.f43848f;
                return null;
            }
        }, c0790b.b()).d(new InterfaceC0793e() { // from class: y3.h
            @Override // D2.InterfaceC0793e
            public final void onFailure(Exception exc) {
                e.f43848f.d("MobileVisionBase", "Error preloading model resource", exc);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, t3.InterfaceC5505a
    @A(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.f43849a.getAndSet(true)) {
            return;
        }
        this.f43851c.a();
        this.f43850b.e(this.f43852d);
    }

    public synchronized D2.i<DetectionResultT> g(final C5846a c5846a) {
        C1669j.l(c5846a, "InputImage can not be null");
        if (this.f43849a.get()) {
            return l.c(new MlKitException("This detector is already closed!", 14));
        }
        if (c5846a.j() < 32 || c5846a.f() < 32) {
            return l.c(new MlKitException("InputImage width and height should be at least 32!", 3));
        }
        return this.f43850b.a(this.f43852d, new Callable() { // from class: y3.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f43854a.i(c5846a);
            }
        }, this.f43851c.b());
    }

    public final /* synthetic */ Object i(C5846a c5846a) throws Exception {
        C0610f5 c0610f5L = C0610f5.l("detectorTaskWithResource#run");
        c0610f5L.e();
        try {
            Object objI = this.f43850b.i(c5846a);
            c0610f5L.close();
            return objI;
        } catch (Throwable th) {
            try {
                c0610f5L.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
