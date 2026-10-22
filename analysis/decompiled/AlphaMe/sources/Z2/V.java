package Z2;

import kotlin.collections.ArrayDeque;

/* loaded from: classes2.dex */
public abstract class V extends A {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2193d = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f2194a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2195b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayDeque f2196c;

    public final boolean C() {
        O o4;
        ArrayDeque arrayDeque = this.f2196c;
        if (arrayDeque == null || (o4 = (O) arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        o4.run();
        return true;
    }

    public abstract void D();

    public final void e(boolean z4) {
        long j4 = this.f2194a - (z4 ? 4294967296L : 1L);
        this.f2194a = j4;
        if (j4 <= 0 && this.f2195b) {
            D();
        }
    }

    public final void l(O o4) {
        ArrayDeque arrayDeque = this.f2196c;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.f2196c = arrayDeque;
        }
        arrayDeque.addLast(o4);
    }

    public final void m(boolean z4) {
        this.f2194a = (z4 ? 4294967296L : 1L) + this.f2194a;
        if (z4) {
            return;
        }
        this.f2195b = true;
    }

    public final boolean u() {
        return this.f2194a >= 4294967296L;
    }

    public abstract long w();
}
