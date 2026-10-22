package j1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import com.stepos.stepclaw.R;
import k4.v;
import t1.j;
import t1.n;
import t1.x;
import t1.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f3485a;

    /* renamed from: b, reason: collision with root package name */
    public n f3486b;

    /* renamed from: c, reason: collision with root package name */
    public z f3487c;
    public n0.f d;

    /* renamed from: e, reason: collision with root package name */
    public a f3488e;

    /* renamed from: f, reason: collision with root package name */
    public int f3489f;

    /* renamed from: g, reason: collision with root package name */
    public int f3490g;

    /* renamed from: h, reason: collision with root package name */
    public int f3491h;

    /* renamed from: i, reason: collision with root package name */
    public int f3492i;

    /* renamed from: j, reason: collision with root package name */
    public int f3493j;

    /* renamed from: k, reason: collision with root package name */
    public int f3494k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f3495l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f3496m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f3497n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f3498o;

    /* renamed from: p, reason: collision with root package name */
    public j f3499p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3503t;

    /* renamed from: v, reason: collision with root package name */
    public RippleDrawable f3505v;

    /* renamed from: w, reason: collision with root package name */
    public int f3506w;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3500q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3501r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3502s = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3504u = true;

    public g(MaterialButton materialButton, n nVar) {
        this.f3485a = materialButton;
        this.f3486b = nVar;
    }

    public final j a(boolean z) {
        RippleDrawable rippleDrawable = this.f3505v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (j) ((LayerDrawable) ((InsetDrawable) this.f3505v.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void b(int i8, int i9) {
        MaterialButton materialButton = this.f3485a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i10 = this.f3491h;
        int i11 = this.f3492i;
        this.f3492i = i9;
        this.f3491h = i8;
        if (!this.f3501r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i8) - i10, paddingEnd, (paddingBottom + i9) - i11);
    }

    public final void c() {
        j jVar = new j(this.f3486b);
        z zVar = this.f3487c;
        if (zVar != null) {
            jVar.n(zVar);
        }
        n0.f fVar = this.d;
        if (fVar != null) {
            jVar.k(fVar);
        }
        a aVar = this.f3488e;
        if (aVar != null) {
            jVar.C = aVar;
        }
        MaterialButton materialButton = this.f3485a;
        jVar.j(materialButton.getContext());
        jVar.setTintList(this.f3496m);
        PorterDuff.Mode mode = this.f3495l;
        if (mode != null) {
            jVar.setTintMode(mode);
        }
        float f3 = this.f3494k;
        ColorStateList colorStateList = this.f3497n;
        jVar.f5475b.f5466k = f3;
        jVar.invalidateSelf();
        t1.h hVar = jVar.f5475b;
        if (hVar.f5460e != colorStateList) {
            hVar.f5460e = colorStateList;
            jVar.onStateChange(jVar.getState());
        }
        j jVar2 = new j(this.f3486b);
        z zVar2 = this.f3487c;
        if (zVar2 != null) {
            jVar2.n(zVar2);
        }
        n0.f fVar2 = this.d;
        if (fVar2 != null) {
            jVar2.k(fVar2);
        }
        jVar2.setTint(0);
        float f7 = this.f3494k;
        int iB = this.f3500q ? v.B(materialButton, R.attr.colorSurface) : 0;
        jVar2.f5475b.f5466k = f7;
        jVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iB);
        t1.h hVar2 = jVar2.f5475b;
        if (hVar2.f5460e != colorStateListValueOf) {
            hVar2.f5460e = colorStateListValueOf;
            jVar2.onStateChange(jVar2.getState());
        }
        j jVar3 = new j(this.f3486b);
        this.f3499p = jVar3;
        z zVar3 = this.f3487c;
        if (zVar3 != null) {
            jVar3.n(zVar3);
        }
        n0.f fVar3 = this.d;
        if (fVar3 != null) {
            this.f3499p.k(fVar3);
        }
        this.f3499p.setTint(-1);
        ColorStateList colorStateListValueOf2 = this.f3498o;
        if (colorStateListValueOf2 == null) {
            colorStateListValueOf2 = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListValueOf2, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{jVar2, jVar}), this.f3489f, this.f3491h, this.f3490g, this.f3492i), this.f3499p);
        this.f3505v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        j jVarA = a(false);
        if (jVarA != null) {
            jVarA.l(this.f3506w);
            jVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        j jVarA = a(false);
        if (jVarA != null) {
            z zVar = this.f3487c;
            if (zVar != null) {
                jVarA.n(zVar);
            } else {
                jVarA.setShapeAppearanceModel(this.f3486b);
            }
            n0.f fVar = this.d;
            if (fVar != null) {
                jVarA.k(fVar);
            }
        }
        j jVarA2 = a(true);
        if (jVarA2 != null) {
            z zVar2 = this.f3487c;
            if (zVar2 != null) {
                jVarA2.n(zVar2);
            } else {
                jVarA2.setShapeAppearanceModel(this.f3486b);
            }
            n0.f fVar2 = this.d;
            if (fVar2 != null) {
                jVarA2.k(fVar2);
            }
        }
        RippleDrawable rippleDrawable = this.f3505v;
        x xVar = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f3505v.getNumberOfLayers() > 2 ? (x) this.f3505v.getDrawable(2) : (x) this.f3505v.getDrawable(1);
        if (xVar != null) {
            xVar.setShapeAppearanceModel(this.f3486b);
            if (xVar instanceof j) {
                j jVar = (j) xVar;
                z zVar3 = this.f3487c;
                if (zVar3 != null) {
                    jVar.n(zVar3);
                }
                n0.f fVar3 = this.d;
                if (fVar3 != null) {
                    jVar.k(fVar3);
                }
            }
        }
    }

    public final void e() {
        j jVarA = a(false);
        j jVarA2 = a(true);
        if (jVarA != null) {
            float f3 = this.f3494k;
            ColorStateList colorStateList = this.f3497n;
            jVarA.f5475b.f5466k = f3;
            jVarA.invalidateSelf();
            t1.h hVar = jVarA.f5475b;
            if (hVar.f5460e != colorStateList) {
                hVar.f5460e = colorStateList;
                jVarA.onStateChange(jVarA.getState());
            }
            if (jVarA2 != null) {
                float f7 = this.f3494k;
                int iB = this.f3500q ? v.B(this.f3485a, R.attr.colorSurface) : 0;
                jVarA2.f5475b.f5466k = f7;
                jVarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iB);
                t1.h hVar2 = jVarA2.f5475b;
                if (hVar2.f5460e != colorStateListValueOf) {
                    hVar2.f5460e = colorStateListValueOf;
                    jVarA2.onStateChange(jVarA2.getState());
                }
            }
        }
    }
}
