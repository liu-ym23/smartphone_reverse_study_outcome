package com.stepos.motionkit.fx.backend.sf;

import C7.f;
import D7.q;
import android.graphics.drawable.Drawable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.motionkit.MKLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010 \u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010+\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010.\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001d\u00101\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010*R\u001d\u00104\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*R\u001d\u00107\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u0010*R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/stepos/motionkit/fx/backend/sf/SfDrawableUniformSetter;", "", AppAgent.CONSTRUCT, "()V", "Ljava/lang/reflect/Method;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "Landroid/graphics/drawable/Drawable;", "drawable", "", "args", "", "invoke", "(Ljava/lang/reflect/Method;Landroid/graphics/drawable/Drawable;[Ljava/lang/Object;)Z", "", HintConstants.AUTOFILL_HINT_NAME, "", "value", "LC7/r;", "setFloat", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;F)V", "setFloatAndInt", "v1", "v2", "setFloat2", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;FF)V", "v3", "setFloat3", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;FFF)V", "v4", "setFloat4", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;FFFF)V", "", "setInt", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;I)V", "TAG", "Ljava/lang/String;", "Ljava/lang/Class;", "clazz", "Ljava/lang/Class;", "methodSetFloat$delegate", "LC7/f;", "getMethodSetFloat", "()Ljava/lang/reflect/Method;", "methodSetFloat", "methodSetFloat2$delegate", "getMethodSetFloat2", "methodSetFloat2", "methodSetFloat3$delegate", "getMethodSetFloat3", "methodSetFloat3", "methodSetFloat4$delegate", "getMethodSetFloat4", "methodSetFloat4", "methodSetInt$delegate", "getMethodSetInt", "methodSetInt", "loggedMethods", "Z", "isAvailable", "()Z", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SfDrawableUniformSetter {
    public static final SfDrawableUniformSetter INSTANCE = new SfDrawableUniformSetter();
    private static final String TAG = "SF";
    private static final Class<?> clazz;
    private static boolean loggedMethods;

    /* renamed from: methodSetFloat$delegate, reason: from kotlin metadata */
    private static final f methodSetFloat;

    /* renamed from: methodSetFloat2$delegate, reason: from kotlin metadata */
    private static final f methodSetFloat2;

    /* renamed from: methodSetFloat3$delegate, reason: from kotlin metadata */
    private static final f methodSetFloat3;

    /* renamed from: methodSetFloat4$delegate, reason: from kotlin metadata */
    private static final f methodSetFloat4;

    /* renamed from: methodSetInt$delegate, reason: from kotlin metadata */
    private static final f methodSetInt;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.android.internal.graphics.drawable.StepOSEffectDrawable");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        clazz = cls;
        methodSetFloat = a.a(new com.stepos.ability.voicewakeup.service.f(4));
        methodSetFloat2 = a.a(new com.stepos.ability.voicewakeup.service.f(5));
        methodSetFloat3 = a.a(new com.stepos.ability.voicewakeup.service.f(6));
        methodSetFloat4 = a.a(new com.stepos.ability.voicewakeup.service.f(7));
        methodSetInt = a.a(new com.stepos.ability.voicewakeup.service.f(8));
    }

    private SfDrawableUniformSetter() {
    }

    private final Method getMethodSetFloat() {
        return (Method) methodSetFloat.getF4884a();
    }

    private final Method getMethodSetFloat2() {
        return (Method) methodSetFloat2.getF4884a();
    }

    private final Method getMethodSetFloat3() {
        return (Method) methodSetFloat3.getF4884a();
    }

    private final Method getMethodSetFloat4() {
        return (Method) methodSetFloat4.getF4884a();
    }

    private final Method getMethodSetInt() {
        return (Method) methodSetInt.getF4884a();
    }

    private final boolean invoke(Method method, Drawable drawable, Object... args) {
        if (method == null) {
            return false;
        }
        if (!loggedMethods) {
            loggedMethods = true;
            MKLog mKLog = MKLog.INSTANCE;
            Method methodSetFloat5 = getMethodSetFloat();
            String name = methodSetFloat5 != null ? methodSetFloat5.getName() : null;
            Method methodSetInt2 = getMethodSetInt();
            String name2 = methodSetInt2 != null ? methodSetInt2.getName() : null;
            Method methodSetFloat22 = getMethodSetFloat2();
            String name3 = methodSetFloat22 != null ? methodSetFloat22.getName() : null;
            StringBuilder sbW = B7.a.w("methods: float=", name, " int=", name2, " float2=");
            sbW.append(name3);
            mKLog.d("SF", sbW.toString());
        }
        try {
            method.invoke(drawable, Arrays.copyOf(args, args.length));
            return true;
        } catch (Throwable th) {
            MKLog.w$default(MKLog.INSTANCE, "SF", androidx.constraintlayout.core.dsl.a.j(B7.a.w("invoke ", method.getName(), "(", q.x0(args, null, null, null, null, 63), ") failed: "), th.getClass().getSimpleName(), ": ", th.getMessage()), null, 4, null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method methodSetFloat2_delegate$lambda$1() {
        Class<?> cls = clazz;
        if (cls == null) {
            return null;
        }
        Class cls2 = Float.TYPE;
        return cls.getDeclaredMethod("setFloat2Uniform", String.class, cls2, cls2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method methodSetFloat3_delegate$lambda$2() {
        Class<?> cls = clazz;
        if (cls == null) {
            return null;
        }
        Class cls2 = Float.TYPE;
        return cls.getDeclaredMethod("setFloat3Uniform", String.class, cls2, cls2, cls2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method methodSetFloat4_delegate$lambda$3() {
        Class<?> cls = clazz;
        if (cls == null) {
            return null;
        }
        Class cls2 = Float.TYPE;
        return cls.getDeclaredMethod("setFloat4Uniform", String.class, cls2, cls2, cls2, cls2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method methodSetFloat_delegate$lambda$0() {
        Class<?> cls = clazz;
        if (cls != null) {
            return cls.getDeclaredMethod("setFloatUniform", String.class, Float.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method methodSetInt_delegate$lambda$4() {
        Class<?> cls = clazz;
        if (cls != null) {
            return cls.getDeclaredMethod("setIntUniform", String.class, Integer.TYPE);
        }
        return null;
    }

    public final boolean isAvailable() {
        return clazz != null;
    }

    public final void setFloat(Drawable drawable, String name, float value) {
        k.f(drawable, "drawable");
        k.f(name, "name");
        invoke(getMethodSetFloat(), drawable, name, Float.valueOf(value));
    }

    public final void setFloat2(Drawable drawable, String name, float v12, float v22) {
        k.f(drawable, "drawable");
        k.f(name, "name");
        invoke(getMethodSetFloat2(), drawable, name, Float.valueOf(v12), Float.valueOf(v22));
    }

    public final void setFloat3(Drawable drawable, String name, float v12, float v22, float v32) {
        k.f(drawable, "drawable");
        k.f(name, "name");
        invoke(getMethodSetFloat3(), drawable, name, Float.valueOf(v12), Float.valueOf(v22), Float.valueOf(v32));
    }

    public final void setFloat4(Drawable drawable, String name, float v12, float v22, float v32, float v42) {
        k.f(drawable, "drawable");
        k.f(name, "name");
        invoke(getMethodSetFloat4(), drawable, name, Float.valueOf(v12), Float.valueOf(v22), Float.valueOf(v32), Float.valueOf(v42));
    }

    public final void setFloatAndInt(Drawable drawable, String name, float value) {
        k.f(drawable, "drawable");
        k.f(name, "name");
        if (invoke(getMethodSetFloat(), drawable, name, Float.valueOf(value))) {
            return;
        }
        invoke(getMethodSetInt(), drawable, name, Integer.valueOf((int) value));
    }

    public final void setInt(Drawable drawable, String name, int value) {
        k.f(drawable, "drawable");
        k.f(name, "name");
        invoke(getMethodSetInt(), drawable, name, Integer.valueOf(value));
    }
}
