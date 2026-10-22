package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.core.view.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1337z {

    /* renamed from: a, reason: collision with root package name */
    public int f13216a;

    /* renamed from: b, reason: collision with root package name */
    public int f13217b;

    public C1337z(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f13217b | this.f13216a;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f13217b = i10;
        } else {
            this.f13216a = i10;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i10) {
        if (i10 == 1) {
            this.f13217b = 0;
        } else {
            this.f13216a = 0;
        }
    }
}
