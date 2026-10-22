package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.core.view.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0478x {

    /* renamed from: a, reason: collision with root package name */
    private int f9830a;

    /* renamed from: b, reason: collision with root package name */
    private int f9831b;

    public C0478x(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f9831b | this.f9830a;
    }

    public void b(View view, View view2, int i5) {
        c(view, view2, i5, 0);
    }

    public void c(View view, View view2, int i5, int i6) {
        if (i6 == 1) {
            this.f9831b = i5;
        } else {
            this.f9830a = i5;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i5) {
        if (i5 == 1) {
            this.f9831b = 0;
        } else {
            this.f9830a = 0;
        }
    }
}
