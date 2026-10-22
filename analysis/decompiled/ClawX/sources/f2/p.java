package f2;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import c7.x;
import com.stepos.stepclaw.R;
import g.l1;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.q1;
import k2.w0;
import k4.z;
import okhttp3.internal.platform.PlatformRegistry;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f2573a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2574b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2575c;
    public Serializable d;

    /* renamed from: e, reason: collision with root package name */
    public Serializable f2576e;

    /* renamed from: f, reason: collision with root package name */
    public Serializable f2577f;

    public p(String str, com.google.crypto.tink.shaded.protobuf.i iVar, w0 w0Var, q1 q1Var, Integer num) {
        this.f2573a = str;
        this.f2574b = u.b(str);
        this.f2575c = iVar;
        this.d = w0Var;
        this.f2576e = q1Var;
        this.f2577f = num;
    }

    public static boolean a(int i8, int[] iArr) {
        for (int i9 : iArr) {
            if (i9 == i8) {
                return true;
            }
        }
        return false;
    }

    public static p b(String str, com.google.crypto.tink.shaded.protobuf.i iVar, w0 w0Var, q1 q1Var, Integer num) throws GeneralSecurityException {
        if (q1Var == q1.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new p(str, iVar, w0Var, q1Var, num);
    }

    public static ColorStateList c(Context context, int i8) {
        int iC = g.q1.c(context, R.attr.colorControlHighlight);
        int iB = g.q1.b(context, R.attr.colorButtonNormal);
        int[] iArr = g.q1.f2809b;
        int[] iArr2 = g.q1.d;
        int iB2 = x.a.b(iC, i8);
        return new ColorStateList(new int[][]{iArr, iArr2, g.q1.f2810c, g.q1.f2812f}, new int[]{iB, iB2, x.a.b(iC, i8), i8});
    }

    public static LayerDrawable d(l1 l1Var, Context context, int i8) throws Resources.NotFoundException {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i8);
        Drawable drawableC = l1Var.c(context, R.drawable.abc_star_black_48dp);
        Drawable drawableC2 = l1Var.c(context, R.drawable.abc_star_half_black_48dp);
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

    public static void h(Drawable drawable, int i8, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = g.r.f2814b;
        }
        drawableMutate.setColorFilter(g.r.b(i8, mode));
    }

    public ColorStateList e(Context context, int i8) {
        if (i8 == R.drawable.abc_edit_text_material) {
            return z.t(context, R.color.abc_tint_edittext);
        }
        if (i8 == R.drawable.abc_switch_track_mtrl_alpha) {
            return z.t(context, R.color.abc_tint_switch_track);
        }
        if (i8 != R.drawable.abc_switch_thumb_material) {
            if (i8 == R.drawable.abc_btn_default_mtrl_shape) {
                return c(context, g.q1.c(context, R.attr.colorButtonNormal));
            }
            if (i8 == R.drawable.abc_btn_borderless_material) {
                return c(context, 0);
            }
            if (i8 == R.drawable.abc_btn_colored_material) {
                return c(context, g.q1.c(context, R.attr.colorAccent));
            }
            if (i8 == R.drawable.abc_spinner_mtrl_am_alpha || i8 == R.drawable.abc_spinner_textfield_background_material) {
                return z.t(context, R.color.abc_tint_spinner);
            }
            if (a(i8, (int[]) this.f2574b)) {
                return g.q1.d(context, R.attr.colorControlNormal);
            }
            if (a(i8, (int[]) this.f2576e)) {
                return z.t(context, R.color.abc_tint_default);
            }
            if (a(i8, (int[]) this.f2577f)) {
                return z.t(context, R.color.abc_tint_btn_checkable);
            }
            if (i8 == R.drawable.abc_seekbar_thumb_material) {
                return z.t(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = g.q1.d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = g.q1.f2809b;
            iArr2[0] = g.q1.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = g.q1.f2811e;
            iArr2[1] = g.q1.c(context, R.attr.colorControlActivated);
            iArr[2] = g.q1.f2812f;
            iArr2[2] = g.q1.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = g.q1.f2809b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = g.q1.f2811e;
            iArr2[1] = g.q1.c(context, R.attr.colorControlActivated);
            iArr[2] = g.q1.f2812f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public c7.n f() throws IOException {
        Context applicationContext = PlatformRegistry.INSTANCE.getApplicationContext();
        AssetManager assets = applicationContext != null ? applicationContext.getAssets() : null;
        if (assets == null) {
            if (Build.FINGERPRINT == null) {
                throw new IOException("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            }
            throw new IOException("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        }
        InputStream inputStreamOpen = assets.open((String) this.f2573a);
        kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
        return new c7.n(inputStreamOpen, new x());
    }

    public void g() {
        try {
            c7.p pVarB = c7.b.b(f());
            try {
                c7.i iVarI = pVarB.i(pVarB.readInt());
                c7.i iVarI2 = pVarB.i(pVarB.readInt());
                pVarB.close();
                synchronized (this) {
                    kotlin.jvm.internal.p.b(iVarI);
                    this.d = iVarI;
                    kotlin.jvm.internal.p.b(iVarI2);
                    this.f2576e = iVarI2;
                }
            } finally {
            }
        } finally {
            ((CountDownLatch) this.f2575c).countDown();
        }
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v13, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v5, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v9, types: [int[], java.io.Serializable] */
    public p(int i8) {
        switch (i8) {
            case 2:
                this.f2574b = new AtomicBoolean(false);
                this.f2575c = new CountDownLatch(1);
                this.f2573a = "PublicSuffixDatabase.list";
                break;
            default:
                this.f2573a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                this.f2574b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                this.f2575c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                this.d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                this.f2576e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                this.f2577f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                break;
        }
    }
}
