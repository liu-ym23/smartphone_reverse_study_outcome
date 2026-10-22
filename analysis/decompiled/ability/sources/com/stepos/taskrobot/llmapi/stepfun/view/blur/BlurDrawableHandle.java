package com.stepos.taskrobot.llmapi.stepfun.view.blur;

import C7.f;
import android.graphics.drawable.Drawable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1436a;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/blur/BlurDrawableHandle;", "", AppAgent.CONSTRUCT, "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "", "radiusPx", "LC7/r;", "setBlurRadius", "(Landroid/graphics/drawable/Drawable;I)V", "", "TAG", "Ljava/lang/String;", "Ljava/lang/reflect/Method;", "setBlurRadiusMethod$delegate", "LC7/f;", "getSetBlurRadiusMethod", "()Ljava/lang/reflect/Method;", "setBlurRadiusMethod", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlurDrawableHandle {
    private static final String TAG = "BlurDrawableHandle";
    public static final BlurDrawableHandle INSTANCE = new BlurDrawableHandle();

    /* renamed from: setBlurRadiusMethod$delegate, reason: from kotlin metadata */
    private static final f setBlurRadiusMethod = a.a(new com.uxsense.parse.a(23));

    private BlurDrawableHandle() {
    }

    private final Method getSetBlurRadiusMethod() {
        return (Method) setBlurRadiusMethod.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method setBlurRadiusMethod_delegate$lambda$0() {
        Object objA;
        try {
            Class<?> cls = Class.forName("android.graphics.drawable.BackgroundBlurDrawable");
            Class cls2 = Integer.TYPE;
            k.c(cls2);
            objA = cls.getMethod("setBlurRadius", cls2);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, "BackgroundBlurDrawable#setBlurRadius unavailable: " + thA.getMessage(), true);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (Method) objA;
    }

    public final void setBlurRadius(Drawable drawable, int radiusPx) {
        Object objA;
        k.f(drawable, "drawable");
        Method setBlurRadiusMethod2 = getSetBlurRadiusMethod();
        if (setBlurRadiusMethod2 == null) {
            return;
        }
        try {
            objA = setBlurRadiusMethod2.invoke(drawable, Integer.valueOf(radiusPx));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c(TAG, "setBlurRadius failed", thA);
        }
    }
}
