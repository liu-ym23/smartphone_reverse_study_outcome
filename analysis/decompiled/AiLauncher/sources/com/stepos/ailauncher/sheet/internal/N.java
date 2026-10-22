package com.stepos.ailauncher.sheet.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/N;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;)V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class N {
    public static final N INSTANCE = new N();

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    public final void a(Activity activity) {
        Class<?> cls;
        kotlin.jvm.internal.p.i(activity, "activity");
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(activity, null);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            kotlin.jvm.internal.p.h(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i10];
                String simpleName = cls.getSimpleName();
                kotlin.jvm.internal.p.h(simpleName, "getSimpleName(...)");
                if (La.H.g0(simpleName, "TranslucentConversionListener", false, 2, null)) {
                    break;
                } else {
                    i10++;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, objInvoke);
        } catch (Throwable unused) {
        }
    }
}
