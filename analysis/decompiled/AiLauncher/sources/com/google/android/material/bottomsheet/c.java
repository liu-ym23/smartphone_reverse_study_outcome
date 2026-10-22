package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.Z;
import androidx.core.view.a0;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class c extends Z.b {

    /* renamed from: a, reason: collision with root package name */
    public final View f20448a;

    /* renamed from: b, reason: collision with root package name */
    public int f20449b;

    /* renamed from: c, reason: collision with root package name */
    public int f20450c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f20451d;

    public c(View view) {
        super(0);
        this.f20451d = new int[2];
        this.f20448a = view;
    }

    @Override // androidx.core.view.Z.b
    public void b(Z z10) {
        this.f20448a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.Z.b
    public void c(Z z10) {
        this.f20448a.getLocationOnScreen(this.f20451d);
        this.f20449b = this.f20451d[1];
    }

    @Override // androidx.core.view.Z.b
    public a0 d(a0 a0Var, List<Z> list) {
        Iterator<Z> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().d() & a0.o.b()) != 0) {
                this.f20448a.setTranslationY(E2.a.c(this.f20450c, 0, r0.c()));
                break;
            }
        }
        return a0Var;
    }

    @Override // androidx.core.view.Z.b
    public Z.a e(Z z10, Z.a aVar) {
        this.f20448a.getLocationOnScreen(this.f20451d);
        int i10 = this.f20449b - this.f20451d[1];
        this.f20450c = i10;
        this.f20448a.setTranslationY(i10);
        return aVar;
    }
}
