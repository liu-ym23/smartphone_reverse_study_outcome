package com.gyf.immersionbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BarConfig.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13825e;
    private final boolean f;
    private final float g;

    a(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getConfiguration().orientation != 1) goto L5;
        boolean r0 = true;
    L6:
        this.f = r0;
        this.g = c(r5);
        this.f13821a = a(r5, "status_bar_height");
        this.f13822b = a(r5);
        int r2 = b(r5);
        this.f13824d = r2;
        this.f13825e = c(r5);
        if (r2 <= 0) goto L9;
        r1 = true;
    L9:
        this.f13823c = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int a(Activity r6) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        if (Build.VERSION.SDK_INT < 14) goto L10;
        View r7 = ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin").findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_container, DbHelper.COL_ID, "action_bar_container"));
        if (r7 == null) goto L7;
        r1 = r7.getMeasuredHeight();
    L7:
        if (r1 != 0) goto L11;
        TypedValue r8 = new TypedValue();
        r5.getTheme().resolveAttribute(android.R.attr.actionBarSize, r8, true);
        return TypedValue.complexToDimensionPixelSize(r8.data, ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDisplayMetrics());
    L11:
        return r1;
    L10:
        return 0;
    }

    private int b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 14) goto L5;
        return 0;
    L5:
        if (b((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return 0;
    L7:
        return a(r5);
    }

    private int c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 14) goto L5;
        return 0;
    L5:
        if (b((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return 0;
    L7:
        return a(r5, "navigation_bar_width");
    }

    private boolean b(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 17) goto L9;
        f.a r5 = f.a(r3);
        if (r5.f13845b == true) goto L9;
        if (r5.f13844a == false) goto L9;
        return false;
    L9:
        Display r6 = r3.getWindowManager().getDefaultDisplay();
        DisplayMetrics r7 = new DisplayMetrics();
        if (Build.VERSION.SDK_INT < 17) goto L12;
        r6.getRealMetrics(r7);
    L12:
        int r1 = r7.heightPixels;
        int r8 = r7.widthPixels;
        DisplayMetrics r2 = new DisplayMetrics();
        r6.getMetrics(r2);
        int r9 = r2.heightPixels;
        if ((r8 - r2.widthPixels) <= 0) goto L15;
    L16:
        return true;
    L15:
        if ((r1 - r9) > 0) goto L16;
        return false;
    }

    static int a(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        int r2 = ZeusTransformUtils.getIdentifier(Resources.getSystem(), r7, "dimen", "android", "com.obric.aiagent.plugin");     // Catch: Resources.NotFoundException -> L20
        if (r2 <= 0) goto L19;
        int r3 = ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDimensionPixelSize(r2);     // Catch: Resources.NotFoundException -> L20
        int r4 = Resources.getSystem().getDimensionPixelSize(r2);     // Catch: Resources.NotFoundException -> L20
        if (r4 >= r3) goto L8;
    L12:
        float r0 = (r3 * Resources.getSystem().getDisplayMetrics().density) / ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        if (r0 < 0.0f) goto L16;
        float r1 = r0 + 0.5f;
    L18:
        return (int) r1;
    L16:
        r1 = r0 - 0.5f;
        goto L18
    L8:
        if (Build.VERSION.SDK_INT >= 29) goto L10;
    L11:
        return r4;
    L10:
        if (r7.equals("status_bar_height") == false) goto L12;
    L19:
        return 0;
    }

    private float c(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        DisplayMetrics r4 = new DisplayMetrics();
        if (Build.VERSION.SDK_INT < 16) goto L5;
        r2.getWindowManager().getDefaultDisplay().getRealMetrics(r4);
    L7:
        return Math.min(r4.widthPixels / r4.density, r4.heightPixels / r4.density);
    L5:
        r2.getWindowManager().getDefaultDisplay().getMetrics(r4);
        goto L7
    }

    boolean a() {
        if (this.g < 600.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.f == true) goto L8;
        return false;
    }

    int b() {
        return this.f13821a;
    }

    int c() {
        return this.f13822b;
    }

    boolean d() {
        return this.f13823c;
    }

    int e() {
        return this.f13824d;
    }

    int f() {
        return this.f13825e;
    }

    static int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration().orientation != 1) goto L5;
        String r0 = "navigation_bar_height";
    L7:
        return a(r3, r0);
    L5:
        r0 = "navigation_bar_height_landscape";
        goto L7
    }
}
