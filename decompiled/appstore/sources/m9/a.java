package m9;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f22176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f22178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f22179h;

    public a(Activity r10) {
        boolean r11 = false;
        if (r10.getResources().getConfiguration().orientation != 1) goto L5;
        boolean r12 = true;
    L6:
        this.f22177f = r12;
        this.f22178g = h(r10);
        this.f22172a = c(r10, "status_bar_height");
        this.f22173b = b(r10);
        int r13 = e(r10);
        this.f22175d = r13;
        this.f22176e = g(r10);
        if (r13 <= 0) goto L9;
        r11 = true;
    L9:
        this.f22174c = r11;
        this.f22179h = f.g(r10);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public int a() {
        return this.f22173b;
    }

    public final int b(Context r10) {
        TypedValue r11 = new TypedValue();
        r10.getTheme().resolveAttribute(R.attr.actionBarSize, r11, true);
        return TypedValue.complexToDimensionPixelSize(r11.data, r10.getResources().getDisplayMetrics());
    }

    public final int c(Context r10, String r11) {
        int r12 = Resources.getSystem().getIdentifier(r11, "dimen", "android");     // Catch: Resources.NotFoundException -> L10
        if (r12 <= 0) goto L13;
        int r13 = r10.getResources().getDimensionPixelSize(r12);     // Catch: Resources.NotFoundException -> L10
        int r14 = Resources.getSystem().getDimensionPixelSize(r12);     // Catch: Resources.NotFoundException -> L10
        if (r14 < r13) goto L8;
        return r14;
    L8:
        return Math.round((r13 * Resources.getSystem().getDisplayMetrics().density) / r10.getResources().getDisplayMetrics().density);
    L13:
        return 0;
    L14:
        return 0;
    }

    public int d() {
        return this.f22175d;
    }

    public final int e(Context r10) {
        if (j((Activity) r10) == true) goto L5;
        return 0;
    L5:
        if (this.f22177f == false) goto L7;
        String r11 = "navigation_bar_height";
    L9:
        return c(r10, r11);
    L7:
        r11 = "navigation_bar_height_landscape";
        goto L9
    }

    public int f() {
        return this.f22176e;
    }

    public final int g(Context r10) {
        if (j((Activity) r10) == true) goto L5;
        return 0;
    L5:
        return c(r10, "navigation_bar_width");
    }

    public final float h(Activity r10) {
        DisplayMetrics r11 = new DisplayMetrics();
        r10.getWindowManager().getDefaultDisplay().getRealMetrics(r11);
        float r12 = r11.widthPixels;
        float r13 = r11.density;
        return Math.min(r12 / r13, r11.heightPixels / r13);
    }

    public int i() {
        return this.f22172a;
    }

    public final boolean j(Activity r10) {
        if (Settings.Global.getInt(r10.getContentResolver(), "force_fsg_nav_bar", 0) == 0) goto L5;
        return false;
    L5:
        Display r11 = r10.getWindowManager().getDefaultDisplay();
        DisplayMetrics r12 = new DisplayMetrics();
        r11.getRealMetrics(r12);
        int r13 = r12.heightPixels;
        int r14 = r12.widthPixels;
        DisplayMetrics r15 = new DisplayMetrics();
        r11.getMetrics(r15);
        int r16 = r15.heightPixels;
        if ((r14 - r15.widthPixels) <= 0) goto L8;
    L9:
        return true;
    L8:
        if ((r13 - r16) > 0) goto L9;
        return false;
    }

    public boolean k() {
        return this.f22174c;
    }

    public boolean l() {
        if (this.f22178g < 600.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.f22177f == true) goto L8;
        return false;
    }
}
