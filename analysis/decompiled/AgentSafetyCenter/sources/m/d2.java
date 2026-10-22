package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d2 {

    /* renamed from: g, reason: collision with root package name */
    public static d2 f7889g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f7891a;

    /* renamed from: b, reason: collision with root package name */
    public WeakHashMap f7892b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f7893c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7894d;

    /* renamed from: e, reason: collision with root package name */
    public ad.z f7895e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f7888f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final c2 f7890h = new c2(6);

    public static synchronized d2 c() {
        try {
            if (f7889g == null) {
                d2 d2Var = new d2();
                d2Var.f7892b = new WeakHashMap(0);
                VarHandle.storeStoreFence();
                f7889g = d2Var;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7889g;
    }

    public static synchronized PorterDuffColorFilter f(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        c2 c2Var = f7890h;
        c2Var.getClass();
        int i3 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) c2Var.b(Integer.valueOf(mode.hashCode() + i3));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final void a(Context context, int i, ColorStateList colorStateList) {
        if (this.f7891a == null) {
            this.f7891a = new WeakHashMap();
        }
        p.q0 q0Var = (p.q0) this.f7891a.get(context);
        if (q0Var == null) {
            q0Var = new p.q0(0);
            this.f7891a.put(context, q0Var);
        }
        int i3 = q0Var.f9616g;
        if (i3 != 0 && i <= q0Var.f9614c[i3 - 1]) {
            q0Var.c(i, colorStateList);
            return;
        }
        if (i3 >= q0Var.f9614c.length) {
            int i10 = (i3 + 1) * 4;
            int i11 = 4;
            while (true) {
                if (i11 >= 32) {
                    break;
                }
                int i12 = (1 << i11) - 12;
                if (i10 <= i12) {
                    i10 = i12;
                    break;
                }
                i11++;
            }
            int i13 = i10 / 4;
            q0Var.f9614c = Arrays.copyOf(q0Var.f9614c, i13);
            q0Var.f9615f = Arrays.copyOf(q0Var.f9615f, i13);
        }
        q0Var.f9614c[i3] = i;
        q0Var.f9615f[i3] = colorStateList;
        q0Var.f9616g = i3 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable b(int r7, android.content.Context r8) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.util.TypedValue r0 = r6.f7893c
            if (r0 != 0) goto Lb
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r6.f7893c = r0
        Lb:
            android.util.TypedValue r0 = r6.f7893c
            android.content.res.Resources r1 = r8.getResources()
            r2 = 1
            r1.getValue(r7, r0, r2)
            int r1 = r0.assetCookie
            long r1 = (long) r1
            r3 = 32
            long r1 = r1 << r3
            int r3 = r0.data
            long r3 = (long) r3
            long r1 = r1 | r3
            monitor-enter(r6)
            java.util.WeakHashMap r3 = r6.f7892b     // Catch: java.lang.Throwable -> L48
            java.lang.Object r3 = r3.get(r8)     // Catch: java.lang.Throwable -> L48
            p.n r3 = (p.n) r3     // Catch: java.lang.Throwable -> L48
            r4 = 0
            if (r3 != 0) goto L2e
            monitor-exit(r6)
        L2c:
            r3 = r4
            goto L50
        L2e:
            java.lang.Object r5 = r3.c(r1)     // Catch: java.lang.Throwable -> L48
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch: java.lang.Throwable -> L48
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r5.get()     // Catch: java.lang.Throwable -> L48
            android.graphics.drawable.Drawable$ConstantState r5 = (android.graphics.drawable.Drawable.ConstantState) r5     // Catch: java.lang.Throwable -> L48
            if (r5 == 0) goto L4b
            android.content.res.Resources r3 = r8.getResources()     // Catch: java.lang.Throwable -> L48
            android.graphics.drawable.Drawable r3 = r5.newDrawable(r3)     // Catch: java.lang.Throwable -> L48
            monitor-exit(r6)
            goto L50
        L48:
            r7 = move-exception
            goto Ld0
        L4b:
            r3.f(r1)     // Catch: java.lang.Throwable -> L48
        L4e:
            monitor-exit(r6)
            goto L2c
        L50:
            if (r3 == 0) goto L53
            return r3
        L53:
            ad.z r3 = r6.f7895e
            if (r3 != 0) goto L59
        L57:
            r7 = r4
            goto L9c
        L59:
            r3 = 2131230782(0x7f08003e, float:1.8077626E38)
            if (r7 != r3) goto L76
            android.graphics.drawable.LayerDrawable r7 = new android.graphics.drawable.LayerDrawable
            r3 = 2131230781(0x7f08003d, float:1.8077624E38)
            android.graphics.drawable.Drawable r3 = r6.d(r3, r8)
            r5 = 2131230783(0x7f08003f, float:1.8077629E38)
            android.graphics.drawable.Drawable r5 = r6.d(r5, r8)
            android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[]{r3, r5}
            r7.<init>(r3)
            goto L9c
        L76:
            r3 = 2131230817(0x7f080061, float:1.8077697E38)
            if (r7 != r3) goto L83
            r7 = 2131165243(0x7f07003b, float:1.7944698E38)
            android.graphics.drawable.LayerDrawable r7 = ad.z.l(r6, r8, r7)
            goto L9c
        L83:
            r3 = 2131230816(0x7f080060, float:1.8077695E38)
            if (r7 != r3) goto L90
            r7 = 2131165244(0x7f07003c, float:1.79447E38)
            android.graphics.drawable.LayerDrawable r7 = ad.z.l(r6, r8, r7)
            goto L9c
        L90:
            r3 = 2131230818(0x7f080062, float:1.80777E38)
            if (r7 != r3) goto L57
            r7 = 2131165245(0x7f07003d, float:1.7944702E38)
            android.graphics.drawable.LayerDrawable r7 = ad.z.l(r6, r8, r7)
        L9c:
            if (r7 == 0) goto Lcf
            int r0 = r0.changingConfigurations
            r7.setChangingConfigurations(r0)
            monitor-enter(r6)
            android.graphics.drawable.Drawable$ConstantState r0 = r7.getConstantState()     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lcb
            java.util.WeakHashMap r3 = r6.f7892b     // Catch: java.lang.Throwable -> Lbf
            java.lang.Object r3 = r3.get(r8)     // Catch: java.lang.Throwable -> Lbf
            p.n r3 = (p.n) r3     // Catch: java.lang.Throwable -> Lbf
            if (r3 != 0) goto Lc1
            p.n r3 = new p.n     // Catch: java.lang.Throwable -> Lbf
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lbf
            java.util.WeakHashMap r4 = r6.f7892b     // Catch: java.lang.Throwable -> Lbf
            r4.put(r8, r3)     // Catch: java.lang.Throwable -> Lbf
            goto Lc1
        Lbf:
            r7 = move-exception
            goto Lcd
        Lc1:
            java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference     // Catch: java.lang.Throwable -> Lbf
            r8.<init>(r0)     // Catch: java.lang.Throwable -> Lbf
            r3.e(r8, r1)     // Catch: java.lang.Throwable -> Lbf
            monitor-exit(r6)
            return r7
        Lcb:
            monitor-exit(r6)
            return r7
        Lcd:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lbf
            throw r7
        Lcf:
            return r7
        Ld0:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L48
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d2.b(int, android.content.Context):android.graphics.drawable.Drawable");
    }

    public final synchronized Drawable d(int i, Context context) {
        return e(context, i, false);
    }

    public final synchronized Drawable e(Context context, int i, boolean z10) {
        Drawable drawableB;
        try {
            if (!this.f7894d) {
                this.f7894d = true;
                Drawable drawableD = d(R.drawable.abc_vector_test, context);
                if (drawableD == null || (!(drawableD instanceof d5.p) && !"android.graphics.drawable.VectorDrawable".equals(drawableD.getClass().getName()))) {
                    this.f7894d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableB = b(i, context);
            if (drawableB == null) {
                drawableB = context.getDrawable(i);
            }
            if (drawableB != null) {
                drawableB = h(context, i, z10, drawableB);
            }
            if (drawableB != null) {
                Rect rect = e1.f7901a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableB;
    }

    public final synchronized ColorStateList g(int i, Context context) {
        ColorStateList colorStateList;
        p.q0 q0Var;
        WeakHashMap weakHashMap = this.f7891a;
        ColorStateList colorStateListN = null;
        colorStateList = (weakHashMap == null || (q0Var = (p.q0) weakHashMap.get(context)) == null) ? null : (ColorStateList) q0Var.b(i);
        if (colorStateList == null) {
            ad.z zVar = this.f7895e;
            if (zVar != null) {
                colorStateListN = zVar.n(i, context);
            }
            if (colorStateListN != null) {
                a(context, i, colorStateListN);
            }
            colorStateList = colorStateListN;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable h(android.content.Context r9, int r10, boolean r11, android.graphics.drawable.Drawable r12) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d2.h(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
