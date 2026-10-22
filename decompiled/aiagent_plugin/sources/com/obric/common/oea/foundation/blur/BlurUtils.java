package com.obric.common.oea.foundation.blur;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class BlurUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Method> f32477a;

    public static class BackgroundBlurDrawable extends DrawableWrapper {
        public BackgroundBlurDrawable(Drawable r1) {
            super(r1);
        }

        public void setBlurRadius(int r8) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setBlurRadiusNative"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Integer.valueOf(r8)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setBlurRadius", new Class[]{Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setBlurRadiusNative", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setCornerRadius(float r10, float r11, float r12, float r13) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setCornerRadius"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Float.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12), Float.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setCornerRadius", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setCornerRadius", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int r10, int r11, int r12, int r13) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setBounds"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setBounds", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setBounds", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlendColorExt(float r10, float r11, float r12, int r13) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setBlendColorExt"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Float.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setBlendColorExt", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setBlendColorExt", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlendColorExt2(int... r8) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setBlendColorExt2"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{r8});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setBlendColorExt", new Class[]{int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setBlendColorExt2", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlurUvOffsetsExt(float r8, float r9) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setBlurUvOffsetsExt"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Float.valueOf(r8), Float.valueOf(r9)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setBlurUvOffsetsExt", new Class[]{Float.TYPE, Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setBlurUvOffsetsExt", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlurDirectionExt(int r7) {
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(BlurUtils.a().get("setBlurDirectionExt"), Method.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Integer.valueOf(r7)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.a(ZeusTransformUtils.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable", "com.obric.aiagent.plugin"), "setBlurDirectionExt", new Class[]{Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.a().put("setBlurDirectionExt", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }
    }

    static /* synthetic */ HashMap a() {
        return f32477a;
    }

    static {
        f32477a = new HashMap();
    }
}
