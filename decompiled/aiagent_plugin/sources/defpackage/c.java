package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.common.oea.foundation.animation.h.a;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import d.x;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final Object a(View r7, String r8) {
        o.e(r7, "$this$getPropertyValue");
        o.e(r8, "propertyName");
        a.EnumC0885a[] r0 = a.EnumC0885a.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L20;
        a.EnumC0885a r4 = r0[r3];
        r3 = r3 + 1;
        if (o.a(r4.a(), r8) == false) goto L3;
        switch(d.f38305a[r4.ordinal()]) {
            case 1: goto L19;
            case 2: goto L71;
            case 3: goto L70;
            case 4: goto L69;
            case 5: goto L68;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L65;
            case 9: goto L64;
            case 10: goto L63;
            default: goto L62;
        };
    L62:
        return x.f38692a;
    L63:
        return Float.valueOf(r7.getAlpha());
    L64:
        return Float.valueOf(r7.getRotationY());
    L65:
        return Float.valueOf(r7.getRotationX());
    L66:
        return Float.valueOf(r7.getTranslationY());
    L67:
        return Float.valueOf(r7.getTranslationX());
    L68:
        return Float.valueOf(r7.getRotation());
    L69:
        return Float.valueOf(r7.getScaleY());
    L70:
        return Float.valueOf(r7.getScaleX());
    L71:
        return Float.valueOf(r7.getY());
    L19:
        return Float.valueOf(r7.getX());
    L20:
        a.b[] r2 = a.b.values();
        int r5 = r2.length;
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L55;
        a.b r9 = r2[r6];
        r6 = r6 + 1;
        if (o.a(r9.a(), r8) == false) goto L22;
        switch(d.f38306b[r9.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L36;
            case 4: goto L31;
            case 5: goto L73;
            case 6: goto L72;
            default: goto L28;
        };
    L31:
        Drawable r10 = r7.getBackground();
        if (ZeusTransformUtils.instanceOf(r10, ShapeDrawable.class) == false) goto L74;
        Paint r11 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r10, ShapeDrawable.class, "com.obric.aiagent.plugin")).getPaint();
        o.c(r11, "paint");
        if (r11.getStyle() == Paint.Style.FILL) goto L76;
        return null;
    L76:
        return Integer.valueOf(r11.getColor());
    L74:
        return null;
    L36:
        Drawable r12 = r7.getBackground();
        if (ZeusTransformUtils.instanceOf(r12, ShapeDrawable.class) == false) goto L77;
        Paint r13 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r12, ShapeDrawable.class, "com.obric.aiagent.plugin")).getPaint();
        o.c(r13, "paint");
        if (r13.getStyle() == Paint.Style.STROKE) goto L79;
        return null;
    L79:
        return Integer.valueOf(r13.getColor());
    L77:
        return null;
    L44:
        Drawable r14 = r7.getBackground();
        if (ZeusTransformUtils.instanceOf(r14, ColorDrawable.class) == true) goto L47;
        return null;
    L47:
        return Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r14, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
    L28:
        throw new k();
    L72:
        return Integer.valueOf(r7.getHeight());
    L73:
        return Integer.valueOf(r7.getWidth());
    L42:
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L80;
        ColorStateList r15 = ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).getTextColors();
        o.c(r15, "this.textColors");
        return Integer.valueOf(r15.getDefaultColor());
    L80:
        return null;
    L55:
        Method r16 = r7.getClass().getMethod(a(r8), new Class[0]);     // Catch: Exception -> L50 NoSuchMethodException -> L52
        o.c(r16, "this.javaClass.getMethod(methodName)");     // Catch: Exception -> L50 NoSuchMethodException -> L52
        return r16.invoke(r7, new Object[0]);
    L52:
        e = move-exception;
        e.printStackTrace();
    L54:
        return null;
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L54
    }

    public static final void a(View r5, String r6, Object r7) {
        o.e(r5, "$this$setPropertyValue");
        o.e(r6, "propertyName");
        o.e(r7, "value");
        if (o.a(r6, "x") == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L126;
        r5.setX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L126:
        return;
    L8:
        if (o.a(r6, "y") == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L128;
        r5.setY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L128:
        return;
    L13:
        if (o.a(r6, "alpha") == false) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L130;
        r5.setAlpha(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L130:
        return;
    L18:
        if (o.a(r6, "rotation") == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L132;
        r5.setRotation(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L132:
        return;
    L23:
        if (o.a(r6, "scaleX") == false) goto L28;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L134;
        r5.setScaleX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L134:
        return;
    L28:
        if (o.a(r6, "scaleY") == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L136;
        r5.setScaleY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L136:
        return;
    L33:
        if (o.a(r6, "translationX") == false) goto L38;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L138;
        r5.setTranslationX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L138:
        return;
    L38:
        if (o.a(r6, "translationY") == false) goto L43;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L140;
        r5.setTranslationY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L140:
        return;
    L43:
        if (o.a(r6, "rotationX") == false) goto L48;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L142;
        r5.setRotationX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L142:
        return;
    L48:
        if (o.a(r6, "rotationY") == false) goto L53;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L144;
        r5.setRotationY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L144:
        return;
    L53:
        if (o.a(r6, "scale") == false) goto L58;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L146;
        r5.setScaleX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        r5.setScaleY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L146:
        return;
    L58:
        if (o.a(r6, a.b.f32417a.a()) == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L148;
        r5.setBackgroundColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L148:
        return;
    L63:
        if (o.a(r6, a.b.f32418b.a()) == false) goto L70;
        if (ZeusTransformUtils.instanceOf(r5, TextView.class) == true) goto L67;
        return;
    L67:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L151;
        ((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin")).setTextColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L151:
        return;
    L70:
        if (o.a(r6, a.b.f32419c.a()) == false) goto L79;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L153;
        Drawable r8 = r5.getBackground();
        if (ZeusTransformUtils.instanceOf(r8, ShapeDrawable.class) == false) goto L154;
        Paint r9 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r8, ShapeDrawable.class, "com.obric.aiagent.plugin")).getPaint();
        o.c(r9, "paint");
        if (r9.getStyle() != Paint.Style.STROKE) goto L155;
        r9.setColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
        r5.invalidate();
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L79:
        if (o.a(r6, a.b.f32420d.a()) == true) goto L81;
        int r2 = 0;
        if (o.a(r6, a.b.f32421e.a()) == false) goto L98;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L161;
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.LayoutParams.class) == true) goto L94;
        return;
    L94:
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L96;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue();
    L96:
        r10.width = r2;
        r5.setLayoutParams(r10);
        r5.requestLayout();
        return;
    L161:
        return;
    L98:
        if (o.a(r6, a.b.f.a()) == true) goto L100;
        String r11 = b(r6);     // Catch: Exception -> L119 NoSuchMethodException -> L121
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L111;
        Class<?> r0 = Integer.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L117:
        Method r12 = r5.getClass().getMethod(r11, new Class[]{r0});     // Catch: Exception -> L119 NoSuchMethodException -> L121
        o.c(r12, "this.javaClass.getMethod(methodName, valueClass)");     // Catch: Exception -> L119 NoSuchMethodException -> L121
        r12.invoke(r5, new Object[]{r7});     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L168:
        return;
    L111:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L114;
        r0 = Float.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
        goto L117
    L114:
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L116;
        r0 = Boolean.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
        goto L117
    L116:
        r0 = r7.getClass();     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L121:
        e = move-exception;
        e.printStackTrace();
        return;
    L119:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L164;
        ViewGroup.LayoutParams r13 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.LayoutParams.class) == true) goto L104;
        return;
    L104:
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L106;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue();
    L106:
        r13.height = r2;
        r5.setLayoutParams(r13);
        r5.requestLayout();
        return;
    L164:
        return;
    L81:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L157;
        Drawable r14 = r5.getBackground();
        if (ZeusTransformUtils.instanceOf(r14, ShapeDrawable.class) == false) goto L158;
        Paint r15 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r14, ShapeDrawable.class, "com.obric.aiagent.plugin")).getPaint();
        o.c(r15, "paint");
        if (r15.getStyle() != Paint.Style.FILL) goto L159;
        r15.setColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
        r5.invalidate();
        return;
    L159:
        return;
    L158:
        return;
    }

    private static final String a(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder().append(MonitorConstants.CONNECT_TYPE_GET).append(Character.toUpperCase(r4.charAt(0)));
        String r5 = r4.substring(1);
        o.c(r5, "this as java.lang.String).substring(startIndex)");
        return r1.append(r5).toString();
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    private static final String b(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder().append("set").append(Character.toUpperCase(r4.charAt(0)));
        String r5 = r4.substring(1);
        o.c(r5, "this as java.lang.String).substring(startIndex)");
        return r1.append(r5).toString();
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }
}
