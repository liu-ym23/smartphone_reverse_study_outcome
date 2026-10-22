package yc;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: yc.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0416a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26231a = null;

        static {
            int[] r10 = new int[ConstraintAttribute.AttributeType.values().length];
            f26231a = r10;
            r10[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f26231a[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f26231a[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f26231a[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f26231a[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f26231a[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f26231a[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static int a(int r10) {
        int r11 = (r10 & (~(r10 >> 31))) - 255;
        return (r11 & (r11 >> 31)) + PrivateKeyType.INVALID;
    }

    public static void b(ConstraintAttribute r16, View r17, float[] r18) {
        Class<?> r10 = r17.getClass();
        String r11 = "set" + r16.c();
        boolean r12 = true;
        switch(C0416a.f26231a[r16.d().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L30;
        };     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L6:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L13:
        Method r13 = r10.getMethod(r11, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        if (r18[0] > 0.5f) goto L17;
        r12 = false;
    L17:
        r13.invoke(r17, new Object[]{Boolean.valueOf(r12)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L20:
        Method r14 = r10.getMethod(r11, new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r15 = a((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r19 = a((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r14.invoke(r17, new Object[]{Integer.valueOf((((r15 << 16) | (a((int) (r18[3] * 255.0f)) << 24)) | (r19 << 8)) | a((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L21:
        Method r20 = r10.getMethod(r11, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r21 = a((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r22 = a((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r23 = (((r21 << 16) | (a((int) (r18[3] * 255.0f)) << 24)) | (r22 << 8)) | a((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        ColorDrawable r24 = new ColorDrawable();     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r24.setColor(r23);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r20.invoke(r17, new Object[]{r24});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L22:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L23:
        r10.getMethod(r11, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((int) r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L30:
        return;
    L19:
        throw new RuntimeException("unable to interpolate strings " + r16.c());     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L9:
        e = move-exception;
        Log.e("CustomSupport", "Cannot access method " + r11 + " on View \"" + com.obric.oui.constraintlayout.motion.widget.a.d(r17) + "\"", e);
        return;
    L11:
        e = move-exception;
        Log.e("CustomSupport", "No method " + r11 + " on View \"" + com.obric.oui.constraintlayout.motion.widget.a.d(r17) + "\"", e);
        return;
    L7:
        e = move-exception;
        Log.e("CustomSupport", "Cannot invoke method " + r11 + " on View \"" + com.obric.oui.constraintlayout.motion.widget.a.d(r17) + "\"", e);
    }
}
