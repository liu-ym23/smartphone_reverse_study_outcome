package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.stepos.alphame.R;
import org.tensorflow.Operation;
import org.tensorflow.Session;

/* renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0238z {

    /* renamed from: a, reason: collision with root package name */
    public Object f3212a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3213b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3214c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3215d;

    /* renamed from: e, reason: collision with root package name */
    public Object f3216e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3217f;

    public C0238z(int i4) {
        if (i4 != 2) {
            this.f3212a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            this.f3213b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            this.f3214c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            this.f3215d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            this.f3216e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            this.f3217f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
            return;
        }
        this.f3212a = new W1.b(0);
        this.f3213b = new W1.b(1);
        this.f3214c = new W1.d();
        this.f3215d = new W1.c(1);
        this.f3216e = new W1.c(0);
        this.f3217f = new W1.a();
    }

    public static boolean a(int[] iArr, int i4) {
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList b(int i4, Context context) {
        int iC = V0.c(R.attr.colorControlHighlight, context);
        return new ColorStateList(new int[][]{V0.f3024b, V0.f3026d, V0.f3025c, V0.f3028f}, new int[]{V0.b(R.attr.colorButtonNormal, context), D.a.b(iC, i4), D.a.b(iC, i4), i4});
    }

    public static LayerDrawable c(N0 n02, Context context, int i4) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i4);
        Drawable drawableE = n02.e(context, R.drawable.abc_star_black_48dp);
        Drawable drawableE2 = n02.e(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableE instanceof BitmapDrawable) && drawableE.getIntrinsicWidth() == dimensionPixelSize && drawableE.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableE;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableE.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableE.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableE2 instanceof BitmapDrawable) && drawableE2.getIntrinsicWidth() == dimensionPixelSize && drawableE2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableE2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableE2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableE2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void f(Drawable drawable, int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterG;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = A.f2721b;
        }
        PorterDuff.Mode mode2 = A.f2721b;
        synchronized (A.class) {
            porterDuffColorFilterG = N0.g(i4, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterG);
    }

    public final ColorStateList d(int i4, Context context) {
        if (i4 == R.drawable.abc_edit_text_material) {
            return B0.f.x(R.color.abc_tint_edittext, context);
        }
        if (i4 == R.drawable.abc_switch_track_mtrl_alpha) {
            return B0.f.x(R.color.abc_tint_switch_track, context);
        }
        if (i4 != R.drawable.abc_switch_thumb_material) {
            if (i4 == R.drawable.abc_btn_default_mtrl_shape) {
                return b(V0.c(R.attr.colorButtonNormal, context), context);
            }
            if (i4 == R.drawable.abc_btn_borderless_material) {
                return b(0, context);
            }
            if (i4 == R.drawable.abc_btn_colored_material) {
                return b(V0.c(R.attr.colorAccent, context), context);
            }
            if (i4 == R.drawable.abc_spinner_mtrl_am_alpha || i4 == R.drawable.abc_spinner_textfield_background_material) {
                return B0.f.x(R.color.abc_tint_spinner, context);
            }
            if (a((int[]) this.f3213b, i4)) {
                return V0.d(R.attr.colorControlNormal, context);
            }
            if (a((int[]) this.f3216e, i4)) {
                return B0.f.x(R.color.abc_tint_default, context);
            }
            if (a((int[]) this.f3217f, i4)) {
                return B0.f.x(R.color.abc_tint_btn_checkable, context);
            }
            if (i4 == R.drawable.abc_seekbar_thumb_material) {
                return B0.f.x(R.color.abc_tint_seek_thumb, context);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = V0.d(R.attr.colorSwitchThumbNormal, context);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = V0.f3024b;
            iArr2[0] = V0.b(R.attr.colorSwitchThumbNormal, context);
            iArr[1] = V0.f3027e;
            iArr2[1] = V0.c(R.attr.colorControlActivated, context);
            iArr[2] = V0.f3028f;
            iArr2[2] = V0.c(R.attr.colorSwitchThumbNormal, context);
        } else {
            int[] iArr3 = V0.f3024b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = V0.f3027e;
            iArr2[1] = V0.c(R.attr.colorControlActivated, context);
            iArr[2] = V0.f3028f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public final Operation e(String str) {
        Operation operationB = ((Session) this.f3217f).f13819a.b(str);
        if (operationB != null) {
            return operationB;
        }
        throw new IllegalArgumentException(B0.g.n("No Operation named [", str, "] in the Graph"));
    }
}
