package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.emoji2.text.t;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.stepclaw.R;
import d1.a;
import k1.b;
import k1.c;
import k1.e;
import v0.b0;
import v0.c0;
import v0.h0;
import v0.k0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class CarouselLayoutManager extends b0 {

    /* renamed from: k, reason: collision with root package name */
    public final e f1287k;

    /* renamed from: l, reason: collision with root package name */
    public c f1288l;

    /* renamed from: m, reason: collision with root package name */
    public final View.OnLayoutChangeListener f1289m;

    public CarouselLayoutManager() {
        e eVar = new e();
        new b();
        this.f1289m = new View.OnLayoutChangeListener() { // from class: k1.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                if (i10 - i8 == i14 - i12 && i11 - i9 == i15 - i13) {
                    return;
                }
                view.post(new t(4, this.f3540a));
            }
        };
        this.f1287k = eVar;
        W();
        d0(0);
    }

    @Override // v0.b0
    public final boolean E() {
        return true;
    }

    @Override // v0.b0
    public final void K(RecyclerView recyclerView) throws Resources.NotFoundException {
        Context context = recyclerView.getContext();
        e eVar = this.f1287k;
        float dimension = eVar.f3546a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        eVar.f3546a = dimension;
        float dimension2 = eVar.f3547b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        eVar.f3547b = dimension2;
        W();
        recyclerView.addOnLayoutChangeListener(this.f1289m);
    }

    @Override // v0.b0
    public final void L(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.f1289m);
    }

    @Override // v0.b0
    public final void M(AccessibilityEvent accessibilityEvent) {
        super.M(accessibilityEvent);
        if (q() > 0) {
            accessibilityEvent.setFromIndex(b0.A(p(0)));
            accessibilityEvent.setToIndex(b0.A(p(q() - 1)));
        }
    }

    @Override // v0.b0
    public final boolean V(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // v0.b0
    public final int X(int i8, h0 h0Var, k0 k0Var) {
        if (!c0() || q() == 0 || i8 == 0) {
            return 0;
        }
        h0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // v0.b0
    public final int Y(int i8, h0 h0Var, k0 k0Var) {
        if (!d() || q() == 0 || i8 == 0) {
            return 0;
        }
        h0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // v0.b0
    public final boolean c() {
        return c0();
    }

    public final boolean c0() {
        return this.f1288l.f3543a == 0;
    }

    @Override // v0.b0
    public final boolean d() {
        return !c0();
    }

    public final void d0(int i8) {
        c cVar;
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException(a8.b.j(i8, "invalid orientation:"));
        }
        b(null);
        c cVar2 = this.f1288l;
        if (cVar2 == null || i8 != cVar2.f3543a) {
            if (i8 == 0) {
                cVar = new c(this, 1);
            } else {
                if (i8 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                cVar = new c(this, 0);
            }
            this.f1288l = cVar;
            W();
        }
    }

    @Override // v0.b0
    public final int g(k0 k0Var) {
        q();
        return 0;
    }

    @Override // v0.b0
    public final int h(k0 k0Var) {
        return 0;
    }

    @Override // v0.b0
    public final int i(k0 k0Var) {
        return 0;
    }

    @Override // v0.b0
    public final int j(k0 k0Var) {
        q();
        return 0;
    }

    @Override // v0.b0
    public final int k(k0 k0Var) {
        return 0;
    }

    @Override // v0.b0
    public final int l(k0 k0Var) {
        return 0;
    }

    @Override // v0.b0
    public final c0 m() {
        return new c0(-2, -2);
    }

    @Override // v0.b0
    public final void t(View view, Rect rect) {
        super.t(view, rect);
        rect.centerY();
        if (c0()) {
            rect.centerX();
        }
        throw null;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        new b();
        this.f1289m = new View.OnLayoutChangeListener() { // from class: k1.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i82, int i92, int i10, int i11, int i12, int i13, int i14, int i15) {
                if (i10 - i82 == i14 - i12 && i11 - i92 == i15 - i13) {
                    return;
                }
                view.post(new t(4, this.f3540a));
            }
        };
        this.f1287k = new e();
        W();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f1761b);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            W();
            d0(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
