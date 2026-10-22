package com.bytedance.android.marketing.sdk.impl.utils;

import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f162818a = 0;

    static {
    }

    public static int b(int r100) {
        if (r100 <= 0) goto L5;
        return ex2.a.a(Integer.valueOf(r100));
    L5:
        if (r100 != (-2)) goto L8;
    L10:
        return -2;
    L8:
        if (r100 != (-1)) goto L10;
        return -1;
    }

    public static Pair a(String r100, String r101) {
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        r100 = r101;
    L11:
        if (r100 != null) goto L13;
    L16:
        float r104 = 0.0f;
        int r105 = 80;
        if (r102 == false) goto L20;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -2);
        r106.gravity = 80;
        return TuplesKt.to(r106, Float.valueOf(0.0f));
    L20:
        com.bytedance.android.marketing.sdk.impl.data.g r107 = (com.bytedance.android.marketing.sdk.impl.data.g) GsonProtectorUtils.fromJson(new Gson(), r100, com.bytedance.android.marketing.sdk.impl.data.g.class);
        if (r107.c() == null) goto L23;
        int r108 = GravityCompat.START;
    L25:
        if (r107.e() == null) goto L27;
        r105 = 48;
    L27:
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(b(r107.f()), b(r107.b()));
        r109.gravity = r108 | r105;
        if (r107.c() == null) goto L31;
        r109.leftMargin = ex2.a.a(r107.c());
    L31:
        if (r107.e() == null) goto L34;
        r109.topMargin = ex2.a.a(r107.e());
    L34:
        if (r107.d() == null) goto L37;
        r109.rightMargin = ex2.a.a(r107.d());
    L37:
        if (r107.a() == null) goto L39;
        r109.bottomMargin = ex2.a.a(r107.a());
    L39:
        Integer r110 = r107.g();
        if (r110 == null) goto L43;
        r104 = r110.intValue();
    L43:
        return TuplesKt.to(r109, Float.valueOf(r104));
    L23:
        r108 = GravityCompat.END;
        goto L25
    L13:
        if (r100.length() == 0) goto L16;
        r102 = false;
        goto L16
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
