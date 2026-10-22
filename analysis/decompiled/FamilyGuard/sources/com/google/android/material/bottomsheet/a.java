package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.X;
import androidx.core.view.Y;
import b1.C0553a;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class a extends X.b {

    /* renamed from: b, reason: collision with root package name */
    private final View f12384b;

    /* renamed from: c, reason: collision with root package name */
    private int f12385c;

    /* renamed from: d, reason: collision with root package name */
    private int f12386d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f12387e;

    public a(View view) {
        super(0);
        this.f12387e = new int[2];
        this.f12384b = view;
    }

    @Override // androidx.core.view.X.b
    public void b(X x5) {
        this.f12384b.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.X.b
    public void c(X x5) {
        this.f12384b.getLocationOnScreen(this.f12387e);
        this.f12385c = this.f12387e[1];
    }

    @Override // androidx.core.view.X.b
    public Y d(Y y5, List<X> list) {
        Iterator<X> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().b() & Y.l.a()) != 0) {
                this.f12384b.setTranslationY(C0553a.c(this.f12386d, 0, r0.a()));
                break;
            }
        }
        return y5;
    }

    @Override // androidx.core.view.X.b
    public X.a e(X x5, X.a aVar) {
        this.f12384b.getLocationOnScreen(this.f12387e);
        int i5 = this.f12385c - this.f12387e[1];
        this.f12386d = i5;
        this.f12384b.setTranslationY(i5);
        return aVar;
    }
}
