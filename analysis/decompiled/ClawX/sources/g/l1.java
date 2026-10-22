package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.stepos.stepclaw.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: g, reason: collision with root package name */
    public static l1 f2772g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f2774a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f2775b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f2776c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public f2.p f2777e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f2771f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final k1 f2773h = new k1(6);

    public static synchronized l1 b() {
        try {
            if (f2772g == null) {
                f2772g = new l1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2772g;
    }

    public static synchronized PorterDuffColorFilter e(int i8, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        k1 k1Var = f2773h;
        k1Var.getClass();
        int i9 = (31 + i8) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) k1Var.c(Integer.valueOf(mode.hashCode() + i9));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i8, mode);
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i8) throws Resources.NotFoundException {
        Drawable drawableNewDrawable;
        WeakReference weakReference;
        if (this.f2776c == null) {
            this.f2776c = new TypedValue();
        }
        TypedValue typedValue = this.f2776c;
        context.getResources().getValue(i8, typedValue, true);
        long j4 = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            j.g gVar = (j.g) this.f2775b.get(context);
            drawableNewDrawable = null;
            if (gVar != null && (weakReference = (WeakReference) gVar.b(j4)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    int iB = k.a.b(gVar.d, j4, gVar.f3294b);
                    if (iB >= 0) {
                        Object[] objArr = gVar.f3295c;
                        Object obj = objArr[iB];
                        Object obj2 = j.h.f3296a;
                        if (obj != obj2) {
                            objArr[iB] = obj2;
                            gVar.f3293a = true;
                        }
                    }
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableD = null;
        if (this.f2777e != null) {
            if (i8 == R.drawable.abc_cab_background_top_material) {
                layerDrawableD = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i8 == R.drawable.abc_ratingbar_material) {
                layerDrawableD = f2.p.d(this, context, R.dimen.abc_star_big);
            } else if (i8 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableD = f2.p.d(this, context, R.dimen.abc_star_medium);
            } else if (i8 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableD = f2.p.d(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableD == null) {
            return layerDrawableD;
        }
        layerDrawableD.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableD.getConstantState();
                if (constantState2 != null) {
                    j.g gVar2 = (j.g) this.f2775b.get(context);
                    if (gVar2 == null) {
                        gVar2 = new j.g();
                        this.f2775b.put(context, gVar2);
                    }
                    gVar2.d(new WeakReference(constantState2), j4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return layerDrawableD;
    }

    public final synchronized Drawable c(Context context, int i8) {
        return d(context, i8);
    }

    public final synchronized Drawable d(Context context, int i8) {
        Drawable drawableA;
        try {
            if (!this.d) {
                this.d = true;
                Drawable drawableC = c(context, R.drawable.abc_vector_test);
                if (drawableC == null || (!(drawableC instanceof b1.a) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(context, i8);
            if (drawableA == null) {
                drawableA = context.getDrawable(i8);
            }
            if (drawableA != null) {
                drawableA = g(context, i8, drawableA);
            }
            if (drawableA != null) {
                int i9 = n0.f2786a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(Context context, int i8) {
        ColorStateList colorStateList;
        j.k kVar;
        WeakHashMap weakHashMap = this.f2774a;
        ColorStateList colorStateListE = null;
        colorStateList = (weakHashMap == null || (kVar = (j.k) weakHashMap.get(context)) == null) ? null : (ColorStateList) kVar.b(i8);
        if (colorStateList == null) {
            f2.p pVar = this.f2777e;
            if (pVar != null) {
                colorStateListE = pVar.e(context, i8);
            }
            if (colorStateListE != null) {
                if (this.f2774a == null) {
                    this.f2774a = new WeakHashMap();
                }
                j.k kVar2 = (j.k) this.f2774a.get(context);
                if (kVar2 == null) {
                    kVar2 = new j.k();
                    this.f2774a.put(context, kVar2);
                }
                kVar2.a(i8, colorStateListE);
            }
            colorStateList = colorStateListE;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.l1.g(android.content.Context, int, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
