package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2774b;

    public i(ViewGroup r10) {
    }

    public int a() {
        int r10 = this.f2773a;
        return this.f2774b | r10;
    }

    public void b(View r10, View r11, int r12) {
        c(r10, r11, r12, 0);
    }

    public void c(View r10, View r11, int r12, int r13) {
        if (r13 != 1) goto L5;
        this.f2774b = r12;
        return;
    L5:
        this.f2773a = r12;
    }

    public void d(View r10) {
        e(r10, 0);
    }

    public void e(View r10, int r11) {
        if (r11 != 1) goto L5;
        this.f2774b = 0;
        return;
    L5:
        this.f2773a = 0;
    }
}
