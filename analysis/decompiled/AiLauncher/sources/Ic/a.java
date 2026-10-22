package Ic;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.R$bool;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$integer;
import stepos.support.v7.appcompat.R$styleable;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f3430a;

    public a(Context context) {
        this.f3430a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f3430a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        TypedArray typedArrayObtainStyledAttributes = this.f3430a.obtainStyledAttributes(null, R$styleable.Toolbar, O6.c.c() ? R$attr.steposToolbarStyleFullScreen : androidx.appcompat.R$attr.toolbarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(androidx.appcompat.R$styleable.Toolbar_maxButtonHeight, this.f3430a.getResources().getDimensionPixelSize(R$dimen.stepos_action_button_min_height_appcompat));
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public int d() {
        return this.f3430a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int e() {
        return this.f3430a.getResources().getInteger(R$integer.abc_max_action_buttons);
    }

    public int f() {
        return this.f3430a.getResources().getDimensionPixelSize(R$dimen.stepos_action_mode_split_padding);
    }

    public int g() {
        return this.f3430a.getResources().getDimensionPixelSize(androidx.appcompat.R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int h() {
        return this.f3430a.getResources().getDimensionPixelSize(R$dimen.stepos_action_bar_stacked_max_height);
    }

    public boolean i() {
        return this.f3430a.getApplicationInfo().targetSdkVersion >= 16 ? this.f3430a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs) : this.f3430a.getResources().getBoolean(stepos.support.v7.appcompat.R$bool.abc_action_bar_embed_tabs_pre_jb);
    }

    public boolean j() {
        return true;
    }
}
