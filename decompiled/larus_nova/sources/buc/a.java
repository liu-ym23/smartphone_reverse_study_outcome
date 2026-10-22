package buc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater<a> f20766b = null;
    private volatile int _value;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f20767a;

    /* JADX INFO: renamed from: buc.a$a, reason: collision with other inner class name */
    public static final class C0363a {
    }

    static {
        f20766b = AtomicIntegerFieldUpdater.newUpdater(a.class, "_value");
    }

    public final boolean c() {
        if (this._value == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return String.valueOf(c());
    }

    public final boolean b(boolean r100) {
        int r101 = f20766b.getAndSet(this, r100 ? 1 : 0);
        f r102 = this.f20767a;
        if (r102 == f.a.f20774a) goto L6;
        r102.getClass();
        f.a("getAndSet(" + r100 + "):" + r101);
    L6:
        if (r101 == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public final void d(boolean r100) {
        this._value = r100 ? 1 : 0;
        f r101 = this.f20767a;
        if (r101 == f.a.f20774a) goto L6;
        r101.getClass();
        f.a("set(" + r100 + ')');
        return;
    }

    public a(boolean r100, f.a r101) {
        Intrinsics.checkNotNullParameter(r101, "trace");
        this.f20767a = r101;
        this._value = r100 ? 1 : 0;
    }

    public final boolean a(boolean r100, boolean r101) {
        boolean r102 = f20766b.compareAndSet(this, r100 ? 1 : 0, r101 ? 1 : 0);
        if (r102 == false) goto L7;
        f r103 = this.f20767a;
        if (r103 == f.a.f20774a) goto L7;
        r103.getClass();
        f.a("CAS(" + r100 + ", " + r101 + ')');
    L7:
        return r102;
    }
}
