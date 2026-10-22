package u6;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.stepos.agentsafetycenter.R;
import f7.g;
import f7.i;
import f7.m;
import f7.w;
import f7.y;
import t1.e;
import z3.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public c f14126a;

    /* renamed from: b, reason: collision with root package name */
    public m f14127b;

    /* renamed from: c, reason: collision with root package name */
    public y f14128c;

    /* renamed from: d, reason: collision with root package name */
    public h f14129d;

    /* renamed from: e, reason: collision with root package name */
    public b.b f14130e;

    /* renamed from: f, reason: collision with root package name */
    public int f14131f;

    /* renamed from: g, reason: collision with root package name */
    public int f14132g;

    /* renamed from: h, reason: collision with root package name */
    public int f14133h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f14134j;

    /* renamed from: k, reason: collision with root package name */
    public int f14135k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f14136l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f14137m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f14138n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f14139o;

    /* renamed from: p, reason: collision with root package name */
    public i f14140p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14141q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14142r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14143s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14144t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14145u;

    /* renamed from: v, reason: collision with root package name */
    public RippleDrawable f14146v;

    /* renamed from: w, reason: collision with root package name */
    public int f14147w;

    public final i a(boolean z10) {
        RippleDrawable rippleDrawable = this.f14146v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (i) ((LayerDrawable) ((InsetDrawable) this.f14146v.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
    }

    public final void b(int i, int i3) {
        c cVar = this.f14126a;
        int paddingStart = cVar.getPaddingStart();
        int paddingTop = cVar.getPaddingTop();
        int paddingEnd = cVar.getPaddingEnd();
        int paddingBottom = cVar.getPaddingBottom();
        int i10 = this.f14133h;
        int i11 = this.i;
        this.i = i3;
        this.f14133h = i;
        if (!this.f14142r) {
            c();
        }
        cVar.setPaddingRelative(paddingStart, (paddingTop + i) - i10, paddingEnd, (paddingBottom + i3) - i11);
    }

    public final void c() {
        c cVar = this.f14126a;
        i iVar = new i(this.f14127b);
        y yVar = this.f14128c;
        if (yVar != null) {
            iVar.k(yVar);
        }
        h hVar = this.f14129d;
        if (hVar != null) {
            iVar.h(hVar);
        }
        b.b bVar = this.f14130e;
        if (bVar != null) {
            iVar.G = bVar;
        }
        iVar.g(cVar.getContext());
        iVar.setTintList(this.f14137m);
        PorterDuff.Mode mode = this.f14136l;
        if (mode != null) {
            iVar.setTintMode(mode);
        }
        float f5 = this.f14135k;
        ColorStateList colorStateList = this.f14138n;
        iVar.f3954f.f3945k = f5;
        iVar.invalidateSelf();
        g gVar = iVar.f3954f;
        if (gVar.f3940e != colorStateList) {
            gVar.f3940e = colorStateList;
            iVar.onStateChange(iVar.getState());
        }
        i iVar2 = new i(this.f14127b);
        y yVar2 = this.f14128c;
        if (yVar2 != null) {
            iVar2.k(yVar2);
        }
        h hVar2 = this.f14129d;
        if (hVar2 != null) {
            iVar2.h(hVar2);
        }
        iVar2.setTint(0);
        float f10 = this.f14135k;
        int i = this.f14141q ? e.i(R.attr.colorSurface, cVar) : 0;
        iVar2.f3954f.f3945k = f10;
        iVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        g gVar2 = iVar2.f3954f;
        if (gVar2.f3940e != colorStateListValueOf) {
            gVar2.f3940e = colorStateListValueOf;
            iVar2.onStateChange(iVar2.getState());
        }
        i iVar3 = new i(this.f14127b);
        this.f14140p = iVar3;
        y yVar3 = this.f14128c;
        if (yVar3 != null) {
            iVar3.k(yVar3);
        }
        h hVar3 = this.f14129d;
        if (hVar3 != null) {
            this.f14140p.h(hVar3);
        }
        this.f14140p.setTint(-1);
        ColorStateList colorStateListValueOf2 = this.f14139o;
        if (colorStateListValueOf2 == null) {
            colorStateListValueOf2 = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListValueOf2, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{iVar2, iVar}), this.f14131f, this.f14133h, this.f14132g, this.i), this.f14140p);
        this.f14146v = rippleDrawable;
        cVar.setInternalBackground(rippleDrawable);
        i iVarA = a(false);
        if (iVarA != null) {
            iVarA.i(this.f14147w);
            iVarA.setState(cVar.getDrawableState());
        }
    }

    public final void d() {
        w wVar;
        i iVarA = a(false);
        if (iVarA != null) {
            y yVar = this.f14128c;
            if (yVar != null) {
                iVarA.k(yVar);
            } else {
                iVarA.setShapeAppearanceModel(this.f14127b);
            }
            h hVar = this.f14129d;
            if (hVar != null) {
                iVarA.h(hVar);
            }
        }
        i iVarA2 = a(true);
        if (iVarA2 != null) {
            y yVar2 = this.f14128c;
            if (yVar2 != null) {
                iVarA2.k(yVar2);
            } else {
                iVarA2.setShapeAppearanceModel(this.f14127b);
            }
            h hVar2 = this.f14129d;
            if (hVar2 != null) {
                iVarA2.h(hVar2);
            }
        }
        RippleDrawable rippleDrawable = this.f14146v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            wVar = null;
        } else {
            int numberOfLayers = this.f14146v.getNumberOfLayers();
            RippleDrawable rippleDrawable2 = this.f14146v;
            wVar = numberOfLayers > 2 ? (w) rippleDrawable2.getDrawable(2) : (w) rippleDrawable2.getDrawable(1);
        }
        if (wVar != null) {
            wVar.setShapeAppearanceModel(this.f14127b);
            if (wVar instanceof i) {
                i iVar = (i) wVar;
                y yVar3 = this.f14128c;
                if (yVar3 != null) {
                    iVar.k(yVar3);
                }
                h hVar3 = this.f14129d;
                if (hVar3 != null) {
                    iVar.h(hVar3);
                }
            }
        }
    }

    public final void e() {
        i iVarA = a(false);
        i iVarA2 = a(true);
        if (iVarA != null) {
            float f5 = this.f14135k;
            ColorStateList colorStateList = this.f14138n;
            iVarA.f3954f.f3945k = f5;
            iVarA.invalidateSelf();
            g gVar = iVarA.f3954f;
            if (gVar.f3940e != colorStateList) {
                gVar.f3940e = colorStateList;
                iVarA.onStateChange(iVarA.getState());
            }
            if (iVarA2 != null) {
                float f10 = this.f14135k;
                int i = this.f14141q ? e.i(R.attr.colorSurface, this.f14126a) : 0;
                iVarA2.f3954f.f3945k = f10;
                iVarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
                g gVar2 = iVarA2.f3954f;
                if (gVar2.f3940e != colorStateListValueOf) {
                    gVar2.f3940e = colorStateListValueOf;
                    iVarA2.onStateChange(iVarA2.getState());
                }
            }
        }
    }
}
