package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import androidx.appcompat.widget.j;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: g, reason: collision with root package name */
    public static n0 f897g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, p.p<ColorStateList>> f898a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Context, p.e<WeakReference<Drawable.ConstantState>>> f899b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f900c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f901d;

    /* renamed from: e, reason: collision with root package name */
    public j.a f902e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f896f = PorterDuff.Mode.SRC_IN;
    public static final a h = new a(6);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends p.g<Integer, PorterDuffColorFilter> {
    }

    public static synchronized n0 b() {
        try {
            if (f897g == null) {
                f897g = new n0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f897g;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA;
        a aVar = h;
        aVar.getClass();
        int i11 = (31 + i10) * 31;
        porterDuffColorFilterA = aVar.a(Integer.valueOf(mode.hashCode() + i11));
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new PorterDuffColorFilter(i10, mode);
            aVar.b(Integer.valueOf(mode.hashCode() + i11), porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    public final Drawable a(int i10, Context context) throws Resources.NotFoundException {
        Drawable drawableNewDrawable;
        WeakReference<Drawable.ConstantState> weakReferenceD;
        if (this.f900c == null) {
            this.f900c = new TypedValue();
        }
        TypedValue typedValue = this.f900c;
        context.getResources().getValue(i10, typedValue, true);
        long j10 = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            p.e<WeakReference<Drawable.ConstantState>> eVar = this.f899b.get(context);
            drawableNewDrawable = null;
            if (eVar != null && (weakReferenceD = eVar.d(j10)) != null) {
                Drawable.ConstantState constantState = weakReferenceD.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    int iB = q.a.b(eVar.f11361b, eVar.f11363d, j10);
                    if (iB >= 0) {
                        Object[] objArr = eVar.f11362c;
                        Object obj = objArr[iB];
                        Object obj2 = p.f.f11364a;
                        if (obj != obj2) {
                            objArr[iB] = obj2;
                            eVar.f11360a = true;
                        }
                    }
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableC = null;
        if (this.f902e != null) {
            if (i10 == R.drawable.abc_cab_background_top_material) {
                layerDrawableC = new LayerDrawable(new Drawable[]{c(R.drawable.abc_cab_background_internal_bg, context), c(R.drawable.abc_cab_background_top_mtrl_alpha, context)});
            } else if (i10 == R.drawable.abc_ratingbar_material) {
                layerDrawableC = j.a.c(this, context, R.dimen.abc_star_big);
            } else if (i10 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableC = j.a.c(this, context, R.dimen.abc_star_medium);
            } else if (i10 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableC = j.a.c(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableC == null) {
            return layerDrawableC;
        }
        layerDrawableC.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableC.getConstantState();
                if (constantState2 != null) {
                    p.e<WeakReference<Drawable.ConstantState>> eVar2 = this.f899b.get(context);
                    if (eVar2 == null) {
                        eVar2 = new p.e<>();
                        this.f899b.put(context, eVar2);
                    }
                    eVar2.f(j10, new WeakReference<>(constantState2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return layerDrawableC;
    }

    public final synchronized Drawable c(int i10, Context context) {
        return d(context, i10, false);
    }

    public final synchronized Drawable d(Context context, int i10, boolean z) {
        Drawable drawableA;
        try {
            if (!this.f901d) {
                this.f901d = true;
                Drawable drawableC = c(R.drawable.abc_vector_test, context);
                if (drawableC == null || (!(drawableC instanceof e2.f) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.f901d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(i10, context);
            if (drawableA == null) {
                drawableA = context.getDrawable(i10);
            }
            if (drawableA != null) {
                drawableA = g(context, i10, z, drawableA);
            }
            if (drawableA != null) {
                f0.a(drawableA);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(int i10, Context context) {
        ColorStateList colorStateListC;
        p.p<ColorStateList> pVar;
        WeakHashMap<Context, p.p<ColorStateList>> weakHashMap = this.f898a;
        ColorStateList colorStateListD = null;
        colorStateListC = (weakHashMap == null || (pVar = weakHashMap.get(context)) == null) ? null : pVar.c(i10);
        if (colorStateListC == null) {
            j.a aVar = this.f902e;
            if (aVar != null) {
                colorStateListD = aVar.d(i10, context);
            }
            if (colorStateListD != null) {
                if (this.f898a == null) {
                    this.f898a = new WeakHashMap<>();
                }
                p.p<ColorStateList> pVar2 = this.f898a.get(context);
                if (pVar2 == null) {
                    pVar2 = new p.p<>();
                    this.f898a.put(context, pVar2);
                }
                pVar2.b(i10, colorStateListD);
            }
            colorStateListC = colorStateListD;
        }
        return colorStateListC;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r8, int r9, boolean r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.n0.g(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
