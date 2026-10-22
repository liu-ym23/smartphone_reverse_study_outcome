package ca7;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<c> f22956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22957b;

    public c() {
        this.f22956a = new ArrayList();
        this.f22957b = Integer.MIN_VALUE;
    }

    public final void a(c r100) {
        Iterator<c> r101 = this.f22956a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next() != r100) goto L4;
        return;
    L8:
        this.f22956a.add(r100);
    }

    public boolean b(da7.b r100) {
        if (r100.f467698b == false) goto L10;
        int r101 = this.f22957b;
        int r102 = r100.f467699c;
        if (r101 > r102) goto L10;
        if (r102 == Integer.MIN_VALUE) goto L10;
        return false;
    L10:
        return true;
    }

    public void c(da7.b r100) {
        if (b(r100) == false) goto L8;
        Iterator<c> r101 = this.f22956a.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        c r102 = r101.next();
        r102.e(r100, this);
        r102.c(r100);
        goto L6
    L10:
        return;
    }

    public Object d(da7.b r100) {
        return Boolean.TRUE;
    }

    public void f(int r100) {
        this.f22957b = Math.max(this.f22957b, r100);
    }

    public void e(da7.b r100, c r101) {
        r100.a(this).f467705a = true;
    }
}
