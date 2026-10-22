package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0 f179c;

    public l(boolean r10) {
        this.f177a = r10;
        this.f178b = new CopyOnWriteArrayList();
    }

    public final void a(Cancellable r10) {
        kotlin.jvm.internal.q.g(r10, "cancellable");
        this.f178b.add(r10);
    }

    public final Function0 b() {
        return this.f179c;
    }

    public void c() {
    }

    public abstract void d();

    public final boolean e() {
        return this.f177a;
    }

    public final void f() {
        Iterator r10 = this.f178b.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((Cancellable) r10.next()).cancel();
        goto L4
    }

    public final void g(Cancellable r10) {
        kotlin.jvm.internal.q.g(r10, "cancellable");
        this.f178b.remove(r10);
    }

    public final void h(boolean r10) {
        this.f177a = r10;
        Function0 r11 = this.f179c;
        if (r11 == null) goto L6;
        r11.invoke();
        return;
    }

    @MainThread
    public void handleOnBackProgressed(@NotNull BackEventCompat r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(@NotNull BackEventCompat r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
    }

    public final void i(Function0 r10) {
        this.f179c = r10;
    }
}
