package g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19728a;

    public a(Context r10) {
        this.f19728a = r10;
    }

    public static a b(Context r10) {
        return new a(r10);
    }

    public boolean a() {
        if (this.f19728a.getApplicationInfo().targetSdkVersion >= 14) goto L5;
        return true;
    L5:
        return false;
    }

    public int c() {
        return this.f19728a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration r10 = this.f19728a.getResources().getConfiguration();
        int r11 = r10.screenWidthDp;
        int r12 = r10.screenHeightDp;
        if (r10.smallestScreenWidthDp > 600) goto L27;
        if (r11 <= 600) goto L6;
        return 5;
    L6:
        if (r11 <= 960) goto L8;
        if (r12 <= 720) goto L8;
        return 5;
    L8:
        if (r11 <= 720) goto L12;
        if (r12 <= 960) goto L12;
        return 5;
    L12:
        if (r11 < 500) goto L14;
        return 4;
    L14:
        if (r11 <= 640) goto L16;
        if (r12 <= 480) goto L16;
        return 4;
    L16:
        if (r11 <= 480) goto L20;
        if (r12 <= 640) goto L20;
        return 4;
    L20:
        if (r11 < 360) goto L23;
        return 3;
    L23:
        return 2;
    L27:
        return 5;
    }

    public int e() {
        return this.f19728a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int f() {
        TypedArray r10 = this.f19728a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int r11 = r10.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources r12 = this.f19728a.getResources();
        if (g() == true) goto L5;
        r11 = Math.min(r11, r12.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
    L5:
        r10.recycle();
        return r11;
    }

    public boolean g() {
        return this.f19728a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    public boolean h() {
        return true;
    }
}
