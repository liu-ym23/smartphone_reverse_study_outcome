package com.obric.oui.constraintlayout.core;

/* JADX INFO: loaded from: classes4.dex */
public class d implements Pools$Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f13160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13161b;

    public d(int r10) {
        if (r10 <= 0) goto L7;
        this.f13160a = new Object[r10];
        return;
    L7:
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // com.obric.oui.constraintlayout.core.Pools$Pool
    public Object acquire() {
        int r10 = this.f13161b;
        if (r10 <= 0) goto L6;
        int r11 = r10 - 1;
        Object[] r12 = this.f13160a;
        Object r13 = r12[r11];
        r12[r11] = null;
        this.f13161b = r10 - 1;
        return r13;
    L6:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.Pools$Pool
    public boolean release(Object r10) {
        int r11 = this.f13161b;
        Object[] r12 = this.f13160a;
        if (r11 >= r12.length) goto L6;
        r12[r11] = r10;
        this.f13161b = r11 + 1;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.Pools$Pool
    public void releaseAll(Object[] r10, int r11) {
        if (r11 <= r10.length) goto L5;
        r11 = r10.length;
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        Object r13 = r10[r12];
        int r14 = this.f13161b;
        Object[] r15 = this.f13160a;
        if (r14 >= r15.length) goto L10;
        r15[r14] = r13;
        this.f13161b = r14 + 1;
    L10:
        r12 = r12 + 1;
        goto L6
    }
}
