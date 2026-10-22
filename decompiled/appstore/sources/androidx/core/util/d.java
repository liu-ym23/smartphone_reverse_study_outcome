package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public class d implements Pools$Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f2648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2649b;

    public d(int r10) {
        if (r10 <= 0) goto L7;
        this.f2648a = new Object[r10];
        return;
    L7:
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public final boolean a(Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f2649b) goto L10;
        if (this.f2648a[r11] == r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @Override // androidx.core.util.Pools$Pool
    public Object acquire() {
        int r10 = this.f2649b;
        if (r10 <= 0) goto L6;
        int r11 = r10 - 1;
        Object[] r12 = this.f2648a;
        Object r13 = r12[r11];
        r12[r11] = null;
        this.f2649b = r10 - 1;
        return r13;
    L6:
        return null;
    }

    @Override // androidx.core.util.Pools$Pool
    public boolean release(Object r10) {
        if (a(r10) == true) goto L11;
        int r11 = this.f2649b;
        Object[] r12 = this.f2648a;
        if (r11 >= r12.length) goto L8;
        r12[r11] = r10;
        this.f2649b = r11 + 1;
        return true;
    L8:
        return false;
    L11:
        throw new IllegalStateException("Already in the pool!");
    }
}
