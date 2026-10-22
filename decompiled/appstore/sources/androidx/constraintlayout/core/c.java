package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
public class c implements Pools$Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f1346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1347b;

    public c(int r10) {
        if (r10 <= 0) goto L7;
        this.f1346a = new Object[r10];
        return;
    L7:
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // androidx.constraintlayout.core.Pools$Pool
    public Object acquire() {
        int r10 = this.f1347b;
        if (r10 <= 0) goto L6;
        int r11 = r10 - 1;
        Object[] r12 = this.f1346a;
        Object r13 = r12[r11];
        r12[r11] = null;
        this.f1347b = r10 - 1;
        return r13;
    L6:
        return null;
    }

    @Override // androidx.constraintlayout.core.Pools$Pool
    public boolean release(Object r10) {
        int r11 = this.f1347b;
        Object[] r12 = this.f1346a;
        if (r11 >= r12.length) goto L6;
        r12[r11] = r10;
        this.f1347b = r11 + 1;
        return true;
    L6:
        return false;
    }

    @Override // androidx.constraintlayout.core.Pools$Pool
    public void releaseAll(Object[] r10, int r11) {
        if (r11 <= r10.length) goto L5;
        r11 = r10.length;
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        Object r13 = r10[r12];
        int r14 = this.f1347b;
        Object[] r15 = this.f1346a;
        if (r14 >= r15.length) goto L10;
        r15[r14] = r13;
        this.f1347b = r14 + 1;
    L10:
        r12 = r12 + 1;
        goto L6
    }
}
