package com.google.android.material.bottomsheet;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import v0.l0;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends l0.b {

    /* renamed from: b, reason: collision with root package name */
    public final View f4733b;

    /* renamed from: c, reason: collision with root package name */
    public int f4734c;

    /* renamed from: d, reason: collision with root package name */
    public int f4735d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f4736e;

    public i(View view) {
        super(0);
        this.f4736e = new int[2];
        this.f4733b = view;
    }

    @Override // v0.l0.b
    public final void a(l0 l0Var) {
        this.f4733b.setTranslationY(0.0f);
    }

    @Override // v0.l0.b
    public final void b() {
        View view = this.f4733b;
        int[] iArr = this.f4736e;
        view.getLocationOnScreen(iArr);
        this.f4734c = iArr[1];
    }

    @Override // v0.l0.b
    public final m0 c(m0 m0Var, List<l0> list) {
        Iterator<l0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().f13299a.f13303a.getTypeMask() & 8) != 0) {
                this.f4733b.setTranslationY(l4.a.c(r0.f13299a.f13303a.getInterpolatedFraction(), this.f4735d, 0));
                break;
            }
        }
        return m0Var;
    }

    @Override // v0.l0.b
    public final l0.a d(l0 l0Var, l0.a aVar) {
        View view = this.f4733b;
        int[] iArr = this.f4736e;
        view.getLocationOnScreen(iArr);
        int i10 = this.f4734c - iArr[1];
        this.f4735d = i10;
        view.setTranslationY(i10);
        return aVar;
    }
}
