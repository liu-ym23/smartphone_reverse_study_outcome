package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f8060b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static s f8061c;

    /* renamed from: a, reason: collision with root package name */
    public d2 f8062a;

    public static synchronized s a() {
        try {
            if (f8061c == null) {
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8061c;
    }

    public static synchronized void c() {
        if (f8061c == null) {
            s sVar = new s();
            f8061c = sVar;
            sVar.f8062a = d2.c();
            d2 d2Var = f8061c.f8062a;
            ad.z zVar = new ad.z(3);
            zVar.f637b = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            zVar.f638c = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            zVar.f639d = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            zVar.f640e = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            zVar.f641f = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            zVar.f642g = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
            VarHandle.storeStoreFence();
            synchronized (d2Var) {
                d2Var.f7895e = zVar;
            }
        }
    }

    public static void d(Drawable drawable, ad.h hVar, int[] iArr) {
        PorterDuff.Mode mode = d2.f7888f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = hVar.f508b;
        if (!z10 && !hVar.f507a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterF = null;
        ColorStateList colorStateList = z10 ? (ColorStateList) hVar.f509c : null;
        PorterDuff.Mode mode2 = hVar.f507a ? (PorterDuff.Mode) hVar.f510d : d2.f7888f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterF = d2.f(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterF);
    }

    public final synchronized Drawable b(int i, Context context) {
        return this.f8062a.d(i, context);
    }
}
