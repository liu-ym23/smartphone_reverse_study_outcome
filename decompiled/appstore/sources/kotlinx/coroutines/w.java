package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21767b = null;

    @Volatile
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f21768a;

    static {
        f21767b = AtomicIntegerFieldUpdater.newUpdater(w.class, "_handled");
    }

    public w(Throwable r10, boolean r11) {
        this.f21768a = r10;
        this._handled = r11 ? 1 : 0;
    }

    public final boolean a() {
        if (f21767b.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        return f21767b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return e0.a(this) + '[' + this.f21768a + ']';
    }

    public /* synthetic */ w(Throwable r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        this(r10, r11);
    }
}
