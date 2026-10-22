package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.J;
import f.C4027a;
import t0.C5502d;

/* renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1295h {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f9202b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static C1295h f9203c;

    /* renamed from: a, reason: collision with root package name */
    public J f9204a;

    /* renamed from: androidx.appcompat.widget.h$a */
    public class a implements J.c {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f9205a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f9206b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        public final int[] f9207c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        public final int[] f9208d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        public final int[] f9209e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        public final int[] f9210f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        @Override // androidx.appcompat.widget.J.c
        public Drawable a(J j10, Context context, int i10) {
            if (i10 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{j10.i(context, R$drawable.abc_cab_background_internal_bg), j10.i(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i10 == R$drawable.abc_ratingbar_material) {
                return l(j10, context, R$dimen.abc_star_big);
            }
            if (i10 == R$drawable.abc_ratingbar_indicator_material) {
                return l(j10, context, R$dimen.abc_star_medium);
            }
            if (i10 == R$drawable.abc_ratingbar_small_material) {
                return l(j10, context, R$dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.J.c
        public ColorStateList b(Context context, int i10) {
            if (i10 == R$drawable.abc_edit_text_material) {
                return C4027a.a(context, R$color.abc_tint_edittext);
            }
            if (i10 == R$drawable.abc_switch_track_mtrl_alpha) {
                return C4027a.a(context, R$color.abc_tint_switch_track);
            }
            if (i10 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i10 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i10 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i10 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i10 == R$drawable.abc_spinner_mtrl_am_alpha || i10 == R$drawable.abc_spinner_textfield_background_material) {
                return C4027a.a(context, R$color.abc_tint_spinner);
            }
            if (f(this.f9206b, i10)) {
                return O.e(context, R$attr.colorControlNormal);
            }
            if (f(this.f9209e, i10)) {
                return C4027a.a(context, R$color.abc_tint_default);
            }
            if (f(this.f9210f, i10)) {
                return C4027a.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i10 == R$drawable.abc_seekbar_thumb_material) {
                return C4027a.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[RETURN] */
        @Override // androidx.appcompat.widget.J.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
            /*
                r5 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C1295h.a()
                int[] r1 = r5.f9205a
                boolean r1 = r5.f(r1, r7)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L14
                int r5 = androidx.appcompat.R$attr.colorControlNormal
            L11:
                r1 = r2
            L12:
                r7 = r4
                goto L49
            L14:
                int[] r1 = r5.f9207c
                boolean r1 = r5.f(r1, r7)
                if (r1 == 0) goto L1f
                int r5 = androidx.appcompat.R$attr.colorControlActivated
                goto L11
            L1f:
                int[] r1 = r5.f9208d
                boolean r5 = r5.f(r1, r7)
                r1 = 16842801(0x1010031, float:2.3693695E-38)
                if (r5 == 0) goto L2e
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2c:
                r5 = r1
                goto L11
            L2e:
                int r5 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r7 != r5) goto L41
                r5 = 1109603123(0x42233333, float:40.8)
                int r5 = java.lang.Math.round(r5)
                r7 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r7
                r7 = r5
                r5 = r1
                r1 = r2
                goto L49
            L41:
                int r5 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r7 != r5) goto L46
                goto L2c
            L46:
                r5 = r3
                r1 = r5
                goto L12
            L49:
                if (r1 == 0) goto L60
                android.graphics.drawable.Drawable r8 = r8.mutate()
                int r5 = androidx.appcompat.widget.O.c(r6, r5)
                android.graphics.PorterDuffColorFilter r5 = androidx.appcompat.widget.C1295h.e(r5, r0)
                r8.setColorFilter(r5)
                if (r7 == r4) goto L5f
                r8.setAlpha(r7)
            L5f:
                return r2
            L60:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C1295h.a.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.J.c
        public PorterDuff.Mode d(int i10) {
            if (i10 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.J.c
        public boolean e(Context context, int i10, Drawable drawable) {
            if (i10 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i11 = R$attr.colorControlNormal;
                m(drawableFindDrawableByLayerId, O.c(context, i11), C1295h.f9202b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), O.c(context, i11), C1295h.f9202b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), O.c(context, R$attr.colorControlActivated), C1295h.f9202b);
                return true;
            }
            if (i10 != R$drawable.abc_ratingbar_material && i10 != R$drawable.abc_ratingbar_indicator_material && i10 != R$drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), O.b(context, R$attr.colorControlNormal), C1295h.f9202b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i12 = R$attr.colorControlActivated;
            m(drawableFindDrawableByLayerId2, O.c(context, i12), C1295h.f9202b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), O.c(context, i12), C1295h.f9202b);
            return true;
        }

        public final boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i10) {
            int iC = O.c(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{O.f9010b, O.f9013e, O.f9011c, O.f9017i}, new int[]{O.b(context, R$attr.colorButtonNormal), C5502d.g(iC, i10), C5502d.g(iC, i10), i10});
        }

        public final ColorStateList i(Context context) {
            return h(context, O.c(context, R$attr.colorAccent));
        }

        public final ColorStateList j(Context context) {
            return h(context, O.c(context, R$attr.colorButtonNormal));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i10 = R$attr.colorSwitchThumbNormal;
            ColorStateList colorStateListE = O.e(context, i10);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = O.f9010b;
                iArr2[0] = O.b(context, i10);
                iArr[1] = O.f9014f;
                iArr2[1] = O.c(context, R$attr.colorControlActivated);
                iArr[2] = O.f9017i;
                iArr2[2] = O.c(context, i10);
            } else {
                int[] iArr3 = O.f9010b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = O.f9014f;
                iArr2[1] = O.c(context, R$attr.colorControlActivated);
                iArr[2] = O.f9017i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(J j10, Context context, int i10) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawableI = j10.i(context, R$drawable.abc_star_black_48dp);
            Drawable drawableI2 = j10.i(context, R$drawable.abc_star_half_black_48dp);
            if ((drawableI instanceof BitmapDrawable) && drawableI.getIntrinsicWidth() == dimensionPixelSize && drawableI.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableI;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableI.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableI2 instanceof BitmapDrawable) && drawableI2.getIntrinsicWidth() == dimensionPixelSize && drawableI2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableI2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableI2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = C1295h.f9202b;
            }
            drawableMutate.setColorFilter(C1295h.e(i10, mode));
        }
    }

    public static synchronized C1295h b() {
        try {
            if (f9203c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9203c;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        return J.k(i10, mode);
    }

    public static synchronized void h() {
        if (f9203c == null) {
            C1295h c1295h = new C1295h();
            f9203c = c1295h;
            c1295h.f9204a = J.g();
            f9203c.f9204a.t(new a());
        }
    }

    public static void i(Drawable drawable, S s10, int[] iArr) {
        J.v(drawable, s10, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f9204a.i(context, i10);
    }

    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f9204a.j(context, i10, z10);
    }

    public synchronized ColorStateList f(Context context, int i10) {
        return this.f9204a.l(context, i10);
    }

    public synchronized void g(Context context) {
        this.f9204a.r(context);
    }
}
