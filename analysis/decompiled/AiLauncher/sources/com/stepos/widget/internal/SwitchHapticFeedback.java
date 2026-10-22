package com.stepos.widget.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/widget/internal/SwitchHapticFeedback;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "isHapticFeedbackEnabled", "(Landroid/content/Context;)Z", "hasStepOSFeature", "()Z", "Landroid/view/View;", "view", "LY8/t;", "perform", "(Landroid/view/View;)V", "", "STEP_OS_SLIDE_HORIZONTAL", "I", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SwitchHapticFeedback {
    public static final SwitchHapticFeedback INSTANCE = new SwitchHapticFeedback();
    private static final int STEP_OS_SLIDE_HORIZONTAL = 31022;

    private SwitchHapticFeedback() {
    }

    private final boolean hasStepOSFeature() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE);
            Boolean bool = Boolean.FALSE;
            Object objInvoke = method.invoke(null, "ro.stepos.shell_hapticfeedback_motor", bool);
            Boolean bool2 = Boolean.TRUE;
            if (!p.d(objInvoke, bool2)) {
                if (!p.d(method.invoke(null, "ro.stepos.use_qcom_vibrate", bool), bool2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean isHapticFeedbackEnabled(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (Settings.System.getInt(contentResolver, "vibrate_on", 1) != 0 && Settings.System.getInt(contentResolver, "haptic_feedback_enabled", 1) != 0) {
                if (Settings.System.getInt(contentResolver, "haptic_feedback_intensity", 2) != 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void perform(View view) {
        Vibrator vibrator;
        p.i(view, "view");
        Context context = view.getContext();
        p.f(context);
        if (isHapticFeedbackEnabled(context)) {
            if (hasStepOSFeature()) {
                view.performHapticFeedback(31022);
            } else if (androidx.core.content.a.a(context, "android.permission.VIBRATE") == 0 && (vibrator = (Vibrator) context.getSystemService(Vibrator.class)) != null && vibrator.hasVibrator()) {
                vibrator.vibrate(50L);
            }
        }
    }
}
