package com.bytedance.android.livesdkapi.service.com.bytedance.android.live.base.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/live/base/utils/ActivityTranslucentUtil;", "", "()V", "convertActivityFromTranslucent", "", "activity", "Landroid/app/Activity;", "convertActivityToTranslucent", "convertActivityToTranslucentAfterL", "convertActivityToTranslucentBeforeL", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityTranslucentUtil {
    public static final ActivityTranslucentUtil INSTANCE = null;

    private ActivityTranslucentUtil() {
    }

    static {
        INSTANCE = new ActivityTranslucentUtil();
    }

    private final void convertActivityToTranslucentAfterL(Activity r110) {
        Method r100 = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);     // Catch: Throwable -> L22
        if (r100 == null) goto L6;
        r100.setAccessible(true);     // Catch: Throwable -> L22
    L6:
        if (r100 == null) goto L8;
        Object r101 = r100.invoke(r110, new Object[0]);     // Catch: Throwable -> L22
    L9:
        Class<?>[] r102 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L22
        int r103 = r102.length;     // Catch: Throwable -> L22
        Class<?> r104 = null;
        int r105 = 0;
    L11:
        if (r105 >= r103) goto L16;
        Class<?> r106 = r102[r105];     // Catch: Throwable -> L22
        if (StringsKt.contains$default(r106.getSimpleName(), "TranslucentConversionListener", false, 2, null) == false) goto L15;
        r104 = r106;
    L15:
        r105 = r105 + 1;     // Catch: Throwable -> L22
        goto L11
    L16:
        Method r107 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r104, ActivityOptions.class});     // Catch: Throwable -> L22
        if (r107 == null) goto L19;
        r107.setAccessible(true);     // Catch: Throwable -> L22
    L19:
        if (r107 == null) goto L28;
        r107.invoke(r110, new Object[]{null, r101});     // Catch: Throwable -> L22
        return;
    L28:
        return;
    L8:
        r101 = null;
    }

    private final void convertActivityToTranslucentBeforeL(Activity r110) {
        Class<?>[] r100 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L14
        int r101 = r100.length;     // Catch: Throwable -> L14
        Class<?> r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L8;
        Class<?> r104 = r100[r103];     // Catch: Throwable -> L14
        if (StringsKt.contains$default(r104.getSimpleName(), "TranslucentConversionListener", false, 2, null) == false) goto L7;
        r102 = r104;
    L7:
        r103 = r103 + 1;     // Catch: Throwable -> L14
        goto L3
    L8:
        Method r105 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r102});     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        r105.setAccessible(true);     // Catch: Throwable -> L14
    L11:
        if (r105 == null) goto L20;
        r105.invoke(r110, new Object[]{new Object[]{null}});     // Catch: Throwable -> L14
        return;
    L20:
        return;
    }

    public final void convertActivityFromTranslucent(Activity r100) {
        if (r100 != null) goto L11;
        return;
    L11:
        if (Build.VERSION.SDK_INT < 30) goto L7;
        r100.setTranslucent(false);     // Catch: Throwable -> L9
    L10:
        return;
    L7:
        Method r101 = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L9
        r101.setAccessible(true);     // Catch: Throwable -> L9
        r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L9
    }

    public final void convertActivityToTranslucent(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        r100.setTranslucent(true);
    L6:
        r100.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return;
    L5:
        convertActivityToTranslucentAfterL(r100);
        goto L6
    }
}
