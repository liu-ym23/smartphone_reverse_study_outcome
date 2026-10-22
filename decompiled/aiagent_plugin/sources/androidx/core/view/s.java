package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: NestedScrollingParentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1522b;

    public s(ViewGroup r1) {
    }

    public void a(View r2, View r3, int r4) {
        a(r2, r3, r4, 0);
    }

    public void a(View r1, View r2, int r3, int r4) {
        if (r4 != 1) goto L5;
        this.f1522b = r3;
        return;
    L5:
        this.f1521a = r3;
    }

    public int a() {
        int r0 = this.f1521a;
        return this.f1522b | r0;
    }

    public void a(View r2) {
        a(r2, 0);
    }

    public void a(View r2, int r3) {
        if (r3 != 1) goto L5;
        this.f1522b = 0;
        return;
    L5:
        this.f1521a = 0;
    }
}
