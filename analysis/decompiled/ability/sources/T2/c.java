package T2;

import A6.j;
import D7.N;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.card.MaterialCardView;
import com.stepos.ability.R;
import com.stepos.statsrpk.d;
import e3.C1416e;
import e3.k;
import e3.n;
import e3.o;
import e3.p;

/* loaded from: classes3.dex */
public final class c {
    public static final double y = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCardView f1195a;
    public final k c;
    public final k d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f1196j;
    public ColorStateList k;
    public ColorStateList l;
    public p m;
    public ColorStateList n;
    public RippleDrawable o;
    public LayerDrawable p;

    /* renamed from: q, reason: collision with root package name */
    public k f1197q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1199s;

    /* renamed from: t, reason: collision with root package name */
    public ValueAnimator f1200t;
    public final TimeInterpolator u;

    /* renamed from: v, reason: collision with root package name */
    public final int f1201v;

    /* renamed from: w, reason: collision with root package name */
    public final int f1202w;
    public final Rect b = new Rect();

    /* renamed from: r, reason: collision with root package name */
    public boolean f1198r = false;

    /* renamed from: x, reason: collision with root package name */
    public float f1203x = 0.0f;

    public c(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.f1195a = materialCardView;
        k kVar = new k(materialCardView.getContext(), attributeSet, R.attr.materialCardViewStyle, R.style.Widget_MaterialComponents_CardView);
        this.c = kVar;
        kVar.m(materialCardView.getContext());
        kVar.s();
        o oVarF = kVar.b.f4345a.f();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, R.attr.materialCardViewStyle, androidx.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.cardview.R.styleable.CardView_cardCornerRadius)) {
            oVarF.c(typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.d = new k();
        h(oVarF.a());
        this.u = N.O(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, Q2.a.f1097a);
        this.f1201v = N.N(materialCardView.getContext(), R.attr.motionDurationShort2, 300);
        this.f1202w = N.N(materialCardView.getContext(), R.attr.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(d dVar, float f) {
        if (dVar instanceof n) {
            return (float) ((1.0d - y) * f);
        }
        if (dVar instanceof C1416e) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        d dVar = this.m.f4369a;
        k kVar = this.c;
        float fB = b(dVar, kVar.k());
        d dVar2 = this.m.b;
        float[] fArr = kVar.f4354C;
        float fMax = Math.max(fB, b(dVar2, fArr != null ? fArr[0] : kVar.b.f4345a.f.a(kVar.h())));
        d dVar3 = this.m.c;
        float[] fArr2 = kVar.f4354C;
        float fB2 = b(dVar3, fArr2 != null ? fArr2[1] : kVar.b.f4345a.g.a(kVar.h()));
        d dVar4 = this.m.d;
        float[] fArr3 = kVar.f4354C;
        return Math.max(fMax, Math.max(fB2, b(dVar4, fArr3 != null ? fArr3[2] : kVar.b.f4345a.h.a(kVar.h()))));
    }

    public final LayerDrawable c() {
        if (this.o == null) {
            this.f1197q = new k(this.m);
            this.o = new RippleDrawable(this.k, null, this.f1197q);
        }
        if (this.p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.o, this.d, this.f1196j});
            this.p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.p;
    }

    public final b d(Drawable drawable) {
        int iCeil;
        int i;
        if (this.f1195a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new b(drawable, iCeil, i, iCeil, i);
    }

    public final void e(int i, int i6) {
        int iCeil;
        int iCeil2;
        int i10;
        int i11;
        if (this.p != null) {
            MaterialCardView materialCardView = this.f1195a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i12 = this.g;
            int i13 = (i12 & GravityCompat.END) == 8388613 ? ((i - this.e) - this.f) - iCeil2 : this.e;
            int i14 = (i12 & 80) == 80 ? this.e : ((i6 - this.e) - this.f) - iCeil;
            int i15 = (i12 & GravityCompat.END) == 8388613 ? this.e : ((i - this.e) - this.f) - iCeil2;
            int i16 = (i12 & 80) == 80 ? ((i6 - this.e) - this.f) - iCeil : this.e;
            if (materialCardView.getLayoutDirection() == 1) {
                i11 = i15;
                i10 = i13;
            } else {
                i10 = i15;
                i11 = i13;
            }
            this.p.setLayerInset(2, i11, i16, i10, i14);
        }
    }

    public final void f(boolean z10, boolean z11) {
        Drawable drawable = this.f1196j;
        if (drawable != null) {
            if (!z11) {
                drawable.setAlpha(z10 ? 255 : 0);
                this.f1203x = z10 ? 1.0f : 0.0f;
                return;
            }
            float f = z10 ? 1.0f : 0.0f;
            float f7 = z10 ? 1.0f - this.f1203x : this.f1203x;
            ValueAnimator valueAnimator = this.f1200t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f1200t = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f1203x, f);
            this.f1200t = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new j(this, 2));
            this.f1200t.setInterpolator(this.u);
            this.f1200t.setDuration((long) ((z10 ? this.f1201v : this.f1202w) * f7));
            this.f1200t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f1196j = drawableMutate;
            drawableMutate.setTintList(this.l);
            f(this.f1195a.c, false);
        } else {
            this.f1196j = null;
        }
        LayerDrawable layerDrawable = this.p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f1196j);
        }
    }

    public final void h(p pVar) {
        this.m = pVar;
        k kVar = this.c;
        kVar.setShapeAppearanceModel(pVar);
        kVar.f4364x = !kVar.n();
        k kVar2 = this.d;
        if (kVar2 != null) {
            kVar2.setShapeAppearanceModel(pVar);
        }
        k kVar3 = this.f1197q;
        if (kVar3 != null) {
            kVar3.setShapeAppearanceModel(pVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f1195a;
        return materialCardView.getPreventCornerOverlap() && this.c.n() && materialCardView.getUseCompatPadding();
    }

    public final boolean j() {
        View view = this.f1195a;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void k() {
        Drawable drawable = this.i;
        Drawable drawableC = j() ? c() : this.d;
        this.i = drawableC;
        if (drawable != drawableC) {
            MaterialCardView materialCardView = this.f1195a;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
            } else {
                materialCardView.setForeground(d(drawableC));
            }
        }
    }

    public final void l() {
        MaterialCardView materialCardView = this.f1195a;
        float cardViewRadius = 0.0f;
        float fA = ((!materialCardView.getPreventCornerOverlap() || this.c.n()) && !i()) ? 0.0f : a();
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - y) * materialCardView.getCardViewRadius());
        }
        int i = (int) (fA - cardViewRadius);
        Rect rect = this.b;
        materialCardView.b(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
    }

    public final void m() {
        boolean z10 = this.f1198r;
        MaterialCardView materialCardView = this.f1195a;
        if (!z10) {
            materialCardView.setBackgroundInternal(d(this.c));
        }
        materialCardView.setForeground(d(this.i));
    }
}
