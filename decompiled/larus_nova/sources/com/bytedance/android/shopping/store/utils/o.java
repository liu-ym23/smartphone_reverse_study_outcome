package com.bytedance.android.shopping.store.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f186937a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f186938b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f186939c = false;

    static {
        boolean r100 = true;
        if (ECShopABSettings.d() != 1) goto L13;
        Configuration r101 = Resources.getSystem().getConfiguration();
        if (r101 == null) goto L8;
        Float r102 = Float.valueOf(r101.fontScale);
    L9:
        float r103 = com.bytedance.android.shopping.extensions.k.e(r102, 1.0f);
        if (r103 >= 0.0f) goto L12;
    L14:
        float r104 = 1.15f;
    L15:
        f186937a = r104;
        Resources r105 = Resources.getSystem();
        float r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).widthPixels;
        Resources r107 = Resources.getSystem();
        f186938b = (r106 / WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density) / 375.0f;
        if (r104 > 1.0f) goto L19;
        r100 = false;
    L19:
        f186939c = r100;
        return;
    L12:
        if (r103 > 1.0f) goto L14;
    L8:
        r102 = null;
    L13:
        r104 = 1.0f;
        goto L15
    }

    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$spStore");
        boolean r101 = ECStoreFoldPhoneHelper.d();
        float r102 = r100.floatValue();
        if (r101 == true) goto L6;
        r102 = (r102 * f186937a) * f186938b;
    L6:
        Resources r103 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
    }
}
