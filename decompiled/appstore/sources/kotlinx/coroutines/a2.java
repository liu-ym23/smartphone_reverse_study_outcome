package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class a2 implements Function1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21303d = null;

    @Volatile
    private volatile int _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f21304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f21305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DisposableHandle f21306c;

    static {
        f21303d = AtomicIntegerFieldUpdater.newUpdater(a2.class, "_state");
    }

    public a2(Job r10) {
        this.f21304a = r10;
        this.f21305b = Thread.currentThread();
    }

    public final void a() {
        AtomicIntegerFieldUpdater r10 = f21303d;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L6;
        if (f21303d.compareAndSet(this, r11, 1) == false) goto L3;
        DisposableHandle r12 = this.f21306c;
        if (r12 == null) goto L26;
        r12.dispose();
        return;
    L26:
        return;
    L6:
        if (r11 == 2) goto L3;
        if (r11 != 3) goto L11;
        Thread.interrupted();
        return;
    L11:
        b(r11);
        throw new KotlinNothingValueException();
    }

    public final Void b(int r10) {
        throw new IllegalStateException(("Illegal state " + r10).toString());
    }

    public void c(Throwable r10) {
        AtomicIntegerFieldUpdater r11 = f21303d;
    L3:
        int r12 = r11.get(this);
        if (r12 != 0) goto L6;
        AtomicIntegerFieldUpdater r13 = f21303d;
        if (r13.compareAndSet(this, r12, 2) == false) goto L3;
        this.f21305b.interrupt();
        r13.set(this, 3);
        return;
    L6:
        if (r12 == 1) goto L12;
        if (r12 == 2) goto L20;
        if (r12 == 3) goto L21;
        b(r12);
        throw new KotlinNothingValueException();
    L21:
        return;
    L20:
        return;
    }

    public final void d() {
        this.f21306c = this.f21304a.invokeOnCompletion(true, true, this);
        AtomicIntegerFieldUpdater r10 = f21303d;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L6;
        if (f21303d.compareAndSet(this, r11, 0) == false) goto L3;
        return;
    L6:
        if (r11 != 2) goto L8;
        return;
    L8:
        if (r11 == 3) goto L19;
        b(r11);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        c((Throwable) r10);
        return Unit.f21064a;
    }
}
