package com.bytedance.android.live.profile.ui.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f86955a = 0;

    static {
    }

    public static void a(TextView r100) {
        if (r100 == null) goto L16;
        Context r101 = r100.getContext();
        if (r101 == null) goto L17;
        AssetManager r102 = r101.getAssets();
        if (r102 == null) goto L18;
        Typeface r103 = Typeface.createFromAsset(r102, "fonts/clarity_mono_bold.otf");     // Catch: Exception -> L11
        if (r103 == null) goto L19;
        r100.setTypeface(r103);     // Catch: Exception -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L11
        return;
    L19:
        return;
    L11:
        e = move-exception;
        ALogger.i(NewProfileInfoViewModel.TAG, "load font error!-" + e);
        Unit r105 = Unit.INSTANCE;
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void b(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$nullUrl");
        r100.setImageURI(null);
    }

    public static void c(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    L10:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewBorderColor error: " + e.getMessage());
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        Drawable r102 = r100.getBackground();     // Catch: Exception -> L10
        if ((r102 instanceof GradientDrawable) == false) goto L15;
        r102.mutate();     // Catch: Exception -> L10
        ((GradientDrawable) r102).setStroke(s1.f(0.5f), Color.parseColor(r101));     // Catch: Exception -> L10
        return;
    }

    public static void d(View r100, int r101) {
        if ((r100 instanceof TextView) == false) goto L6;
        ((TextView) r100).setTextColor(r101);
        return;
    L6:
        if ((r100 instanceof ImageView) == false) goto L11;
        if ((r100 instanceof HSImageView) == true) goto L22;
        ((ImageView) r100).setColorFilter(r101);
        return;
    L22:
        return;
    L11:
        if ((r100 instanceof ViewGroup) == false) goto L24;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L25;
        View r105 = r102.getChildAt(r104);
        if (r105 == null) goto L17;
        d(r105, r101);
    L17:
        r104 = r104 + 1;
        goto L13
    L25:
        return;
    }

    public static void e(View r100, String r101) {
    L11:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewColor error: " + e.getMessage());
        return;
    L3:
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L16;
        if (r101 == null) goto L8;
        String r102 = StringsKt.trim(r101).toString();     // Catch: Exception -> L11
    L9:
        d(r100, Color.parseColor(r102));     // Catch: Exception -> L11
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static void f(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    L20:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewDrawableColor error: " + e.getMessage());
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        Drawable r102 = r100.getBackground();     // Catch: Exception -> L20
        String r103 = null;
        if ((r102 instanceof GradientDrawable) == false) goto L14;
        r102.mutate();     // Catch: Exception -> L20
        GradientDrawable r104 = (GradientDrawable) r102;     // Catch: Exception -> L20
        if (r101 == null) goto L11;
        String r105 = StringsKt.trim(r101).toString();     // Catch: Exception -> L20
    L12:
        r104.setColor(Color.parseColor(r105));     // Catch: Exception -> L20
        goto L14
    L11:
        r105 = null;
    L14:
        if ((r102 instanceof ColorDrawable) == false) goto L25;
        r102.mutate();     // Catch: Exception -> L20
        ColorDrawable r106 = (ColorDrawable) r102;     // Catch: Exception -> L20
        if (r101 == null) goto L18;
        r103 = StringsKt.trim(r101).toString();     // Catch: Exception -> L20
    L18:
        r106.setColor(Color.parseColor(r103));     // Catch: Exception -> L20
        return;
    }

    public static void g(List r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "views");
        Iterator r102 = r100.iterator();     // Catch: Exception -> L11
    L5:
        if (r102.hasNext() == false) goto L22;
        View r103 = (View) r102.next();     // Catch: Exception -> L11
        if (r103 == null) goto L5;
        d(r103, r101);     // Catch: Exception -> L11
        goto L5
    L22:
        return;
    L11:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewsColor error: " + e.getMessage());
    }

    public static void h(List r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "views");
        if (TextUtils.isEmpty(r101) == false) goto L16;
        return;
    L16:
        int r102 = Color.parseColor(r101);     // Catch: Exception -> L13
        Iterator r103 = r100.iterator();     // Catch: Exception -> L13
    L7:
        if (r103.hasNext() == false) goto L24;
        View r104 = (View) r103.next();     // Catch: Exception -> L13
        if (r104 == null) goto L7;
        d(r104, r102);     // Catch: Exception -> L13
        goto L7
    L24:
        return;
    L13:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewsColor error: " + e.getMessage());
    }
}
