package androidx.appcompat.widget;

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
import android.util.Log;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f846b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static j f847c;

    /* renamed from: a, reason: collision with root package name */
    public n0 f848a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f849a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f850b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        public final int[] f851c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        public final int[] f852d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        public final int[] f853e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        public final int[] f854f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public static boolean a(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList b(int i10, Context context) {
            int iC = s0.c(R.attr.colorControlHighlight, context);
            int iB = s0.b(R.attr.colorButtonNormal, context);
            int[] iArr = s0.f925b;
            int[] iArr2 = s0.f927d;
            int iB2 = n0.a.b(iC, i10);
            return new ColorStateList(new int[][]{iArr, iArr2, s0.f926c, s0.f929f}, new int[]{iB, iB2, n0.a.b(iC, i10), i10});
        }

        public static LayerDrawable c(n0 n0Var, Context context, int i10) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawableC = n0Var.c(R.drawable.abc_star_black_48dp, context);
            Drawable drawableC2 = n0Var.c(R.drawable.abc_star_half_black_48dp, context);
            if ((drawableC instanceof BitmapDrawable) && drawableC.getIntrinsicWidth() == dimensionPixelSize && drawableC.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableC;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableC.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableC.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableC2 instanceof BitmapDrawable) && drawableC2.getIntrinsicWidth() == dimensionPixelSize && drawableC2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableC2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableC2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableC2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public static void e(Drawable drawable, int i10, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = j.f846b;
            }
            drawableMutate.setColorFilter(j.c(i10, mode));
        }

        public final ColorStateList d(int i10, Context context) {
            if (i10 == R.drawable.abc_edit_text_material) {
                return androidx.core.content.a.b(R.color.abc_tint_edittext, context);
            }
            if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
                return androidx.core.content.a.b(R.color.abc_tint_switch_track, context);
            }
            if (i10 != R.drawable.abc_switch_thumb_material) {
                if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
                    return b(s0.c(R.attr.colorButtonNormal, context), context);
                }
                if (i10 == R.drawable.abc_btn_borderless_material) {
                    return b(0, context);
                }
                if (i10 == R.drawable.abc_btn_colored_material) {
                    return b(s0.c(R.attr.colorAccent, context), context);
                }
                if (i10 == R.drawable.abc_spinner_mtrl_am_alpha || i10 == R.drawable.abc_spinner_textfield_background_material) {
                    return androidx.core.content.a.b(R.color.abc_tint_spinner, context);
                }
                if (a(this.f850b, i10)) {
                    return s0.d(R.attr.colorControlNormal, context);
                }
                if (a(this.f853e, i10)) {
                    return androidx.core.content.a.b(R.color.abc_tint_default, context);
                }
                if (a(this.f854f, i10)) {
                    return androidx.core.content.a.b(R.color.abc_tint_btn_checkable, context);
                }
                if (i10 == R.drawable.abc_seekbar_thumb_material) {
                    return androidx.core.content.a.b(R.color.abc_tint_seek_thumb, context);
                }
                return null;
            }
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListD = s0.d(R.attr.colorSwitchThumbNormal, context);
            if (colorStateListD == null || !colorStateListD.isStateful()) {
                iArr[0] = s0.f925b;
                iArr2[0] = s0.b(R.attr.colorSwitchThumbNormal, context);
                iArr[1] = s0.f928e;
                iArr2[1] = s0.c(R.attr.colorControlActivated, context);
                iArr[2] = s0.f929f;
                iArr2[2] = s0.c(R.attr.colorSwitchThumbNormal, context);
            } else {
                int[] iArr3 = s0.f925b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
                iArr[1] = s0.f928e;
                iArr2[1] = s0.c(R.attr.colorControlActivated, context);
                iArr[2] = s0.f929f;
                iArr2[2] = colorStateListD.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }
    }

    public static synchronized j a() {
        try {
            if (f847c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f847c;
    }

    public static synchronized PorterDuffColorFilter c(int i10, PorterDuff.Mode mode) {
        return n0.e(i10, mode);
    }

    public static synchronized void d() {
        if (f847c == null) {
            j jVar = new j();
            f847c = jVar;
            jVar.f848a = n0.b();
            n0 n0Var = f847c.f848a;
            a aVar = new a();
            synchronized (n0Var) {
                n0Var.f902e = aVar;
            }
        }
    }

    public static void e(Drawable drawable, v0 v0Var, int[] iArr) {
        PorterDuff.Mode mode = n0.f896f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = v0Var.f940d;
        if (!z && !v0Var.f939c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterE = null;
        ColorStateList colorStateList = z ? v0Var.f937a : null;
        PorterDuff.Mode mode2 = v0Var.f939c ? v0Var.f938b : n0.f896f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterE = n0.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterE);
    }

    public final synchronized Drawable b(int i10, Context context) {
        return this.f848a.c(i10, context);
    }
}
