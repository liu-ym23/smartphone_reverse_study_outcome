package androidx.appcompat.widget;

import android.R;
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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f996c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResourceManagerInternal f997a;

    public class a implements ResourceManagerInternal.ResourceManagerHooks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f1000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f1001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f1002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f1003f;

        public a() {
            this.f998a = new int[]{R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
            this.f999b = new int[]{R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};
            this.f1000c = new int[]{R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};
            this.f1001d = new int[]{R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
            this.f1002e = new int[]{R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};
            this.f1003f = new int[]{R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};
        }

        public final boolean a(int[] r10, int r11) {
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            if (r10[r13] == r11) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public final ColorStateList b(Context r10) {
            return c(r10, 0);
        }

        public final ColorStateList c(Context r10, int r11) {
            int r12 = x.c(r10, R$attr.colorControlHighlight);
            int r13 = x.b(r10, R$attr.colorButtonNormal);
            return new ColorStateList(new int[][]{x.f1148b, x.f1151e, x.f1149c, x.f1155i}, new int[]{r13, androidx.core.graphics.d.g(r12, r11), androidx.core.graphics.d.g(r12, r11), r11});
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public Drawable createDrawableFor(ResourceManagerInternal r10, Context r11, int r12) {
            if (r12 != R$drawable.abc_cab_background_top_material) goto L7;
            return new LayerDrawable(new Drawable[]{r10.i(r11, R$drawable.abc_cab_background_internal_bg), r10.i(r11, R$drawable.abc_cab_background_top_mtrl_alpha)});
        L7:
            if (r12 != R$drawable.abc_ratingbar_material) goto L11;
            return g(r10, r11, R$dimen.abc_star_big);
        L11:
            if (r12 != R$drawable.abc_ratingbar_indicator_material) goto L15;
            return g(r10, r11, R$dimen.abc_star_medium);
        L15:
            if (r12 == R$drawable.abc_ratingbar_small_material) goto L17;
            return null;
        L17:
            return g(r10, r11, R$dimen.abc_star_small);
        }

        public final ColorStateList d(Context r10) {
            return c(r10, x.c(r10, R$attr.colorAccent));
        }

        public final ColorStateList e(Context r10) {
            return c(r10, x.c(r10, R$attr.colorButtonNormal));
        }

        public final ColorStateList f(Context r10) {
            int[][] r11 = new int[3][];
            int[] r12 = new int[3];
            int r13 = R$attr.colorSwitchThumbNormal;
            ColorStateList r14 = x.e(r10, r13);
            if (r14 != null) goto L5;
        L7:
            r11[0] = x.f1148b;
            r12[0] = x.b(r10, r13);
            r11[1] = x.f1152f;
            r12[1] = x.c(r10, R$attr.colorControlActivated);
            r11[2] = x.f1155i;
            r12[2] = x.c(r10, r13);
        L9:
            return new ColorStateList(r11, r12);
        L5:
            if (r14.isStateful() == false) goto L7;
            int[] r15 = x.f1148b;
            r11[0] = r15;
            r12[0] = r14.getColorForState(r15, 0);
            r11[1] = x.f1152f;
            r12[1] = x.c(r10, R$attr.colorControlActivated);
            r11[2] = x.f1155i;
            r12[2] = r14.getDefaultColor();
            goto L9
        }

        public final LayerDrawable g(ResourceManagerInternal r10, Context r11, int r12) {
            int r13 = r11.getResources().getDimensionPixelSize(r12);
            Drawable r14 = r10.i(r11, R$drawable.abc_star_black_48dp);
            Drawable r15 = r10.i(r11, R$drawable.abc_star_half_black_48dp);
            if ((r14 instanceof BitmapDrawable) == true) goto L5;
        L9:
            Bitmap r16 = Bitmap.createBitmap(r13, r13, Bitmap.Config.ARGB_8888);
            Canvas r17 = new Canvas(r16);
            r14.setBounds(0, 0, r13, r13);
            r14.draw(r17);
            BitmapDrawable r18 = new BitmapDrawable(r16);
            BitmapDrawable r19 = new BitmapDrawable(r16);
        L10:
            r19.setTileModeX(Shader.TileMode.REPEAT);
            if ((r15 instanceof BitmapDrawable) == true) goto L13;
        L17:
            Bitmap r20 = Bitmap.createBitmap(r13, r13, Bitmap.Config.ARGB_8888);
            Canvas r21 = new Canvas(r20);
            r15.setBounds(0, 0, r13, r13);
            r15.draw(r21);
            BitmapDrawable r22 = new BitmapDrawable(r20);
        L18:
            LayerDrawable r23 = new LayerDrawable(new Drawable[]{r18, r22, r19});
            r23.setId(0, R.id.background);
            r23.setId(1, R.id.secondaryProgress);
            r23.setId(2, R.id.progress);
            return r23;
        L13:
            if (r15.getIntrinsicWidth() != r13) goto L17;
            if (r15.getIntrinsicHeight() != r13) goto L17;
            r22 = (BitmapDrawable) r15;
            goto L18
        L5:
            if (r14.getIntrinsicWidth() != r13) goto L9;
            if (r14.getIntrinsicHeight() != r13) goto L9;
            r18 = (BitmapDrawable) r14;
            r19 = new BitmapDrawable(r18.getBitmap());
            goto L10
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public ColorStateList getTintListForDrawableRes(Context r10, int r11) {
            if (r11 != R$drawable.abc_edit_text_material) goto L7;
            return c.a.a(r10, R$color.abc_tint_edittext);
        L7:
            if (r11 != R$drawable.abc_switch_track_mtrl_alpha) goto L11;
            return c.a.a(r10, R$color.abc_tint_switch_track);
        L11:
            if (r11 != R$drawable.abc_switch_thumb_material) goto L15;
            return f(r10);
        L15:
            if (r11 != R$drawable.abc_btn_default_mtrl_shape) goto L19;
            return e(r10);
        L19:
            if (r11 != R$drawable.abc_btn_borderless_material) goto L23;
            return b(r10);
        L23:
            if (r11 != R$drawable.abc_btn_colored_material) goto L27;
            return d(r10);
        L27:
            if (r11 == R$drawable.abc_spinner_mtrl_am_alpha) goto L50;
            if (r11 == R$drawable.abc_spinner_textfield_background_material) goto L50;
            if (a(this.f999b, r11) == false) goto L36;
            return x.e(r10, R$attr.colorControlNormal);
        L36:
            if (a(this.f1002e, r11) == false) goto L40;
            return c.a.a(r10, R$color.abc_tint_default);
        L40:
            if (a(this.f1003f, r11) == false) goto L44;
            return c.a.a(r10, R$color.abc_tint_btn_checkable);
        L44:
            if (r11 == R$drawable.abc_seekbar_thumb_material) goto L46;
            return null;
        L46:
            return c.a.a(r10, R$color.abc_tint_seek_thumb);
        L50:
            return c.a.a(r10, R$color.abc_tint_spinner);
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public PorterDuff.Mode getTintModeForDrawableRes(int r10) {
            if (r10 == R$drawable.abc_switch_thumb_material) goto L7;
            return null;
        L7:
            return PorterDuff.Mode.MULTIPLY;
        }

        public final void h(Drawable r10, int r11, PorterDuff.Mode r12) {
            if (r.a(r10) == false) goto L5;
            r10 = r10.mutate();
        L5:
            if (r12 != null) goto L7;
            r12 = f.a();
        L7:
            r10.setColorFilter(f.e(r11, r12));
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public boolean tintDrawable(Context r10, int r11, Drawable r12) {
            if (r11 != R$drawable.abc_seekbar_track_material) goto L7;
            LayerDrawable r13 = (LayerDrawable) r12;
            Drawable r14 = r13.findDrawableByLayerId(R.id.background);
            int r15 = R$attr.colorControlNormal;
            h(r14, x.c(r10, r15), f.a());
            h(r13.findDrawableByLayerId(R.id.secondaryProgress), x.c(r10, r15), f.a());
            h(r13.findDrawableByLayerId(R.id.progress), x.c(r10, R$attr.colorControlActivated), f.a());
            return true;
        L7:
            if (r11 != R$drawable.abc_ratingbar_material) goto L9;
        L15:
            LayerDrawable r16 = (LayerDrawable) r12;
            h(r16.findDrawableByLayerId(R.id.background), x.b(r10, R$attr.colorControlNormal), f.a());
            Drawable r17 = r16.findDrawableByLayerId(R.id.secondaryProgress);
            int r18 = R$attr.colorControlActivated;
            h(r17, x.c(r10, r18), f.a());
            h(r16.findDrawableByLayerId(R.id.progress), x.c(r10, r18), f.a());
            return true;
        L9:
            if (r11 == R$drawable.abc_ratingbar_indicator_material) goto L15;
            if (r11 == R$drawable.abc_ratingbar_small_material) goto L15;
            return false;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public boolean tintDrawableUsingColorFilter(Context r10, int r11, Drawable r12) {
            PorterDuff.Mode r13 = f.a();
            if (a(this.f998a, r11) == false) goto L8;
            int r14 = R$attr.colorControlNormal;
        L5:
            boolean r15 = true;
        L6:
            int r16 = -1;
        L21:
            if (r15 == true) goto L23;
            return false;
        L23:
            if (r.a(r12) == false) goto L25;
            r12 = r12.mutate();
        L25:
            r12.setColorFilter(f.e(x.c(r10, r14), r13));
            if (r16 == (-1)) goto L28;
            r12.setAlpha(r16);
        L28:
            return true;
        L8:
            if (a(this.f1000c, r11) == false) goto L11;
            r14 = R$attr.colorControlActivated;
            goto L5
        L11:
            if (a(this.f1001d, r11) == false) goto L15;
            r13 = PorterDuff.Mode.MULTIPLY;
        L13:
            r14 = 16842801;
            goto L5
        L15:
            if (r11 != R$drawable.abc_list_divider_mtrl_alpha) goto L18;
            r15 = true;
            r16 = Math.round(40.8f);
            r14 = 16842800;
            goto L21
        L18:
            if (r11 == R$drawable.abc_dialog_material_background) goto L13;
            r14 = 0;
            r15 = false;
            goto L6
        }
    }

    static {
        f995b = PorterDuff.Mode.SRC_IN;
    }

    public f() {
    }

    public static /* synthetic */ PorterDuff.Mode a() {
        return f995b;
    }

    public static synchronized f b() {
        monitor-enter(f.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f996c != null) goto L9;
        h();     // Catch: Throwable -> L7
    L9:
        f r10 = f996c;     // Catch: Throwable -> L7
        monitor-exit(f.class);
        return r10;
    }

    public static synchronized PorterDuffColorFilter e(int r10, PorterDuff.Mode r11) {
        monitor-enter(f.class);
        PorterDuffColorFilter r12 = ResourceManagerInternal.k(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(f.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void h() {
        monitor-enter(f.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (f996c != null) goto L10;
        f r10 = new f();     // Catch: Throwable -> L8
        f996c = r10;     // Catch: Throwable -> L8
        r10.f997a = ResourceManagerInternal.g();     // Catch: Throwable -> L8
        f996c.f997a.t(new a());     // Catch: Throwable -> L8
    L10:
        monitor-exit(f.class);
    }

    public static void i(Drawable r10, z r11, int[] r12) {
        ResourceManagerInternal.v(r10, r11, r12);
    }

    public synchronized Drawable c(Context r10, int r11) {
        monitor-enter(this);
        Drawable r12 = this.f997a.i(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable d(Context r10, int r11, boolean r12) {
        monitor-enter(this);
        Drawable r13 = this.f997a.j(r10, r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList f(Context r10, int r11) {
        monitor-enter(this);
        ColorStateList r12 = this.f997a.l(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void g(Context r10) {
        monitor-enter(this);
        this.f997a.r(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
