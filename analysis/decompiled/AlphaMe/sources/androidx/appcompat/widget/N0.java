package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.stepos.alphame.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import r.AbstractC0827a;

/* loaded from: classes.dex */
public final class N0 {

    /* renamed from: g, reason: collision with root package name */
    public static N0 f2887g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f2889a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f2890b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f2891c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2892d;

    /* renamed from: e, reason: collision with root package name */
    public C0238z f2893e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f2886f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final M0 f2888h = new M0(6);

    public static synchronized N0 c() {
        try {
            if (f2887g == null) {
                f2887g = new N0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2887g;
    }

    public static synchronized PorterDuffColorFilter g(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        M0 m02 = f2888h;
        m02.getClass();
        int i5 = (31 + i4) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) m02.a(Integer.valueOf(mode.hashCode() + i5));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i4, mode);
        }
        return porterDuffColorFilter;
    }

    public final synchronized void a(Context context, long j4, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                q.i iVar = (q.i) this.f2890b.get(context);
                if (iVar == null) {
                    iVar = new q.i();
                    this.f2890b.put(context, iVar);
                }
                iVar.f(j4, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable b(int i4, Context context) throws Resources.NotFoundException {
        if (this.f2891c == null) {
            this.f2891c = new TypedValue();
        }
        TypedValue typedValue = this.f2891c;
        context.getResources().getValue(i4, typedValue, true);
        long j4 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable drawableD = d(context, j4);
        if (drawableD != null) {
            return drawableD;
        }
        LayerDrawable layerDrawableC = null;
        if (this.f2893e != null) {
            if (i4 == R.drawable.abc_cab_background_top_material) {
                layerDrawableC = new LayerDrawable(new Drawable[]{e(context, R.drawable.abc_cab_background_internal_bg), e(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i4 == R.drawable.abc_ratingbar_material) {
                layerDrawableC = C0238z.c(this, context, R.dimen.abc_star_big);
            } else if (i4 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableC = C0238z.c(this, context, R.dimen.abc_star_medium);
            } else if (i4 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableC = C0238z.c(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableC != null) {
            layerDrawableC.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j4, layerDrawableC);
        }
        return layerDrawableC;
    }

    public final synchronized Drawable d(Context context, long j4) {
        q.i iVar = (q.i) this.f2890b.get(context);
        if (iVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) iVar.d(j4);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iB = AbstractC0827a.b(iVar.f13958b, iVar.f13960d, j4);
            if (iB >= 0) {
                Object[] objArr = iVar.f13959c;
                Object obj = objArr[iB];
                Object obj2 = q.j.f13961a;
                if (obj != obj2) {
                    objArr[iB] = obj2;
                    iVar.f13957a = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable e(Context context, int i4) {
        return f(context, i4, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[Catch: all -> 0x00d6, TryCatch #0 {, blocks: (B:3:0x0001, B:12:0x0026, B:14:0x002c, B:16:0x0032, B:18:0x0039, B:25:0x004e, B:23:0x004a, B:26:0x0053, B:30:0x006a, B:37:0x00a0, B:38:0x00c7, B:43:0x00d2, B:6:0x0006, B:8:0x0012, B:10:0x0016, B:49:0x00d9, B:50:0x00e2), top: B:53:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.drawable.Drawable f(android.content.Context r9, int r10, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.f2892d     // Catch: java.lang.Throwable -> Ld6
            if (r0 == 0) goto L6
            goto L26
        L6:
            r0 = 1
            r8.f2892d = r0     // Catch: java.lang.Throwable -> Ld6
            r0 = 2131230844(0x7f08007c, float:1.8077752E38)
            android.graphics.drawable.Drawable r0 = r8.e(r9, r0)     // Catch: java.lang.Throwable -> Ld6
            if (r0 == 0) goto Ld8
            boolean r1 = r0 instanceof p0.o     // Catch: java.lang.Throwable -> Ld6
            if (r1 != 0) goto L26
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r1 = "android.graphics.drawable.VectorDrawable"
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> Ld6
            if (r0 == 0) goto Ld8
        L26:
            android.graphics.drawable.Drawable r0 = r8.b(r10, r9)     // Catch: java.lang.Throwable -> Ld6
            if (r0 != 0) goto L30
            android.graphics.drawable.Drawable r0 = androidx.core.content.a.b(r9, r10)     // Catch: java.lang.Throwable -> Ld6
        L30:
            if (r0 == 0) goto Ld0
            android.content.res.ColorStateList r1 = r8.h(r10, r9)     // Catch: java.lang.Throwable -> Ld6
            r2 = 0
            if (r1 == 0) goto L53
            android.graphics.drawable.Drawable r0 = r0.mutate()     // Catch: java.lang.Throwable -> Ld6
            E.a.h(r0, r1)     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.z r9 = r8.f2893e     // Catch: java.lang.Throwable -> Ld6
            if (r9 != 0) goto L45
            goto L4c
        L45:
            r9 = 2131230831(0x7f08006f, float:1.8077726E38)
            if (r10 != r9) goto L4c
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch: java.lang.Throwable -> Ld6
        L4c:
            if (r2 == 0) goto Ld0
            E.a.i(r0, r2)     // Catch: java.lang.Throwable -> Ld6
            goto Ld0
        L53:
            androidx.appcompat.widget.z r1 = r8.f2893e     // Catch: java.lang.Throwable -> Ld6
            if (r1 == 0) goto Lc7
            r1 = 2131230826(0x7f08006a, float:1.8077716E38)
            r3 = 16908301(0x102000d, float:2.3877265E-38)
            r4 = 16908303(0x102000f, float:2.387727E-38)
            r5 = 16908288(0x1020000, float:2.387723E-38)
            r6 = 2130968918(0x7f040156, float:1.7546503E38)
            r7 = 2130968920(0x7f040158, float:1.7546507E38)
            if (r10 != r1) goto L91
            r10 = r0
            android.graphics.drawable.LayerDrawable r10 = (android.graphics.drawable.LayerDrawable) r10     // Catch: java.lang.Throwable -> Ld6
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r5)     // Catch: java.lang.Throwable -> Ld6
            int r1 = androidx.appcompat.widget.V0.c(r7, r9)     // Catch: java.lang.Throwable -> Ld6
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.A.f2721b     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.C0238z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld6
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r4)     // Catch: java.lang.Throwable -> Ld6
            int r1 = androidx.appcompat.widget.V0.c(r7, r9)     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.C0238z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld6
            android.graphics.drawable.Drawable r10 = r10.findDrawableByLayerId(r3)     // Catch: java.lang.Throwable -> Ld6
            int r9 = androidx.appcompat.widget.V0.c(r6, r9)     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.C0238z.f(r10, r9, r2)     // Catch: java.lang.Throwable -> Ld6
            goto Ld0
        L91:
            r1 = 2131230817(0x7f080061, float:1.8077697E38)
            if (r10 == r1) goto La0
            r1 = 2131230816(0x7f080060, float:1.8077695E38)
            if (r10 == r1) goto La0
            r1 = 2131230818(0x7f080062, float:1.80777E38)
            if (r10 != r1) goto Lc7
        La0:
            r10 = r0
            android.graphics.drawable.LayerDrawable r10 = (android.graphics.drawable.LayerDrawable) r10     // Catch: java.lang.Throwable -> Ld6
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r5)     // Catch: java.lang.Throwable -> Ld6
            int r1 = androidx.appcompat.widget.V0.b(r7, r9)     // Catch: java.lang.Throwable -> Ld6
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.A.f2721b     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.C0238z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld6
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r4)     // Catch: java.lang.Throwable -> Ld6
            int r1 = androidx.appcompat.widget.V0.c(r6, r9)     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.C0238z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld6
            android.graphics.drawable.Drawable r10 = r10.findDrawableByLayerId(r3)     // Catch: java.lang.Throwable -> Ld6
            int r9 = androidx.appcompat.widget.V0.c(r6, r9)     // Catch: java.lang.Throwable -> Ld6
            androidx.appcompat.widget.C0238z.f(r10, r9, r2)     // Catch: java.lang.Throwable -> Ld6
            goto Ld0
        Lc7:
            boolean r9 = r8.i(r9, r10, r0)     // Catch: java.lang.Throwable -> Ld6
            if (r9 != 0) goto Ld0
            if (r11 == 0) goto Ld0
            r0 = r2
        Ld0:
            if (r0 == 0) goto Ld4
            android.graphics.Rect r9 = androidx.appcompat.widget.AbstractC0220p0.f3149a     // Catch: java.lang.Throwable -> Ld6
        Ld4:
            monitor-exit(r8)
            return r0
        Ld6:
            r9 = move-exception
            goto Le3
        Ld8:
            r9 = 0
            r8.f2892d = r9     // Catch: java.lang.Throwable -> Ld6
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r10 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r9.<init>(r10)     // Catch: java.lang.Throwable -> Ld6
            throw r9     // Catch: java.lang.Throwable -> Ld6
        Le3:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.N0.f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList h(int i4, Context context) {
        ColorStateList colorStateList;
        q.m mVar;
        WeakHashMap weakHashMap = this.f2889a;
        ColorStateList colorStateListD = null;
        colorStateList = (weakHashMap == null || (mVar = (q.m) weakHashMap.get(context)) == null) ? null : (ColorStateList) mVar.c(i4);
        if (colorStateList == null) {
            C0238z c0238z = this.f2893e;
            if (c0238z != null) {
                colorStateListD = c0238z.d(i4, context);
            }
            if (colorStateListD != null) {
                if (this.f2889a == null) {
                    this.f2889a = new WeakHashMap();
                }
                q.m mVar2 = (q.m) this.f2889a.get(context);
                if (mVar2 == null) {
                    mVar2 = new q.m();
                    this.f2889a.put(context, mVar2);
                }
                mVar2.a(i4, colorStateListD);
            }
            colorStateList = colorStateListD;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            androidx.appcompat.widget.z r6 = r6.f2893e
            r0 = 0
            if (r6 == 0) goto L74
            android.graphics.PorterDuff$Mode r1 = androidx.appcompat.widget.A.f2721b
            java.lang.Object r2 = r6.f3212a
            int[] r2 = (int[]) r2
            boolean r2 = androidx.appcompat.widget.C0238z.a(r2, r8)
            r3 = 1
            r4 = -1
            if (r2 == 0) goto L19
            r6 = 2130968920(0x7f040158, float:1.7546507E38)
        L16:
            r2 = r3
        L17:
            r8 = r4
            goto L55
        L19:
            java.lang.Object r2 = r6.f3214c
            int[] r2 = (int[]) r2
            boolean r2 = androidx.appcompat.widget.C0238z.a(r2, r8)
            if (r2 == 0) goto L27
            r6 = 2130968918(0x7f040156, float:1.7546503E38)
            goto L16
        L27:
            java.lang.Object r6 = r6.f3215d
            int[] r6 = (int[]) r6
            boolean r6 = androidx.appcompat.widget.C0238z.a(r6, r8)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            if (r6 == 0) goto L38
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.MULTIPLY
        L36:
            r6 = r2
            goto L16
        L38:
            r6 = 2131230803(0x7f080053, float:1.807767E38)
            if (r8 != r6) goto L4c
            r6 = 1109603123(0x42233333, float:40.8)
            int r6 = java.lang.Math.round(r6)
            r8 = 16842800(0x1010030, float:2.3693693E-38)
            r2 = r3
            r5 = r8
            r8 = r6
            r6 = r5
            goto L55
        L4c:
            r6 = 2131230785(0x7f080041, float:1.8077633E38)
            if (r8 != r6) goto L52
            goto L36
        L52:
            r6 = r0
            r2 = r6
            goto L17
        L55:
            if (r2 == 0) goto L74
            android.graphics.drawable.Drawable r9 = r9.mutate()
            int r6 = androidx.appcompat.widget.V0.c(r6, r7)
            java.lang.Class<androidx.appcompat.widget.A> r7 = androidx.appcompat.widget.A.class
            monitor-enter(r7)
            android.graphics.PorterDuffColorFilter r6 = g(r6, r1)     // Catch: java.lang.Throwable -> L71
            monitor-exit(r7)
            r9.setColorFilter(r6)
            if (r8 == r4) goto L6f
            r9.setAlpha(r8)
        L6f:
            r0 = r3
            goto L74
        L71:
            r6 = move-exception
            monitor-exit(r7)
            throw r6
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.N0.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
