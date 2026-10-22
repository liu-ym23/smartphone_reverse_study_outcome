package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.reflect.Method;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final String a(String r10) {
        if (r10.length() <= 0) goto L6;
        StringBuilder r11 = new StringBuilder();
        r11.append("get");
        r11.append(Character.toUpperCase(r10.charAt(0)));
        String r12 = r10.substring(1);
        q.f(r12, "this as java.lang.String).substring(startIndex)");
        r11.append(r12);
        return r11.toString();
    L6:
        return r10;
    }

    public static final String b(String r10) {
        if (r10.length() <= 0) goto L6;
        StringBuilder r11 = new StringBuilder();
        r11.append("set");
        r11.append(Character.toUpperCase(r10.charAt(0)));
        String r12 = r10.substring(1);
        q.f(r12, "this as java.lang.String).substring(startIndex)");
        r11.append(r12);
        return r11.toString();
    L6:
        return r10;
    }

    public static final Object c(View r10, String r11) {
        q.g(r10, "$this$getPropertyValue");
        q.g(r11, "propertyName");
        AnimationProperty$FloatProperty[] r12 = AnimationProperty$FloatProperty.values();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L20;
        AnimationProperty$FloatProperty r16 = r12[r15];
        r15 = r15 + 1;
        if (q.b(r16.getPropertyName(), r11) == false) goto L3;
        switch(c.f6017a[r16.ordinal()]) {
            case 1: goto L19;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            case 7: goto L68;
            case 8: goto L67;
            case 9: goto L66;
            case 10: goto L65;
            default: goto L64;
        };
    L64:
        return Unit.f21064a;
    L65:
        return Float.valueOf(r10.getAlpha());
    L66:
        return Float.valueOf(r10.getRotationY());
    L67:
        return Float.valueOf(r10.getRotationX());
    L68:
        return Float.valueOf(r10.getTranslationY());
    L69:
        return Float.valueOf(r10.getTranslationX());
    L70:
        return Float.valueOf(r10.getRotation());
    L71:
        return Float.valueOf(r10.getScaleY());
    L72:
        return Float.valueOf(r10.getScaleX());
    L73:
        return Float.valueOf(r10.getY());
    L19:
        return Float.valueOf(r10.getX());
    L20:
        AnimationProperty$IntProperty[] r17 = AnimationProperty$IntProperty.values();
        int r18 = r17.length;
    L22:
        if (r14 >= r18) goto L57;
        AnimationProperty$IntProperty r19 = r17[r14];
        r14 = r14 + 1;
        if (q.b(r19.getPropertyName(), r11) == false) goto L22;
        switch(c.f6018b[r19.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L36;
            case 4: goto L31;
            case 5: goto L75;
            case 6: goto L74;
            default: goto L28;
        };
    L31:
        Drawable r20 = r10.getBackground();
        if ((r20 instanceof ShapeDrawable) == false) goto L76;
        Paint r21 = ((ShapeDrawable) r20).getPaint();
        q.f(r21, "paint");
        if (r21.getStyle() == Paint.Style.FILL) goto L78;
        return null;
    L78:
        return Integer.valueOf(r21.getColor());
    L76:
        return null;
    L36:
        Drawable r22 = r10.getBackground();
        if ((r22 instanceof ShapeDrawable) == false) goto L79;
        Paint r23 = ((ShapeDrawable) r22).getPaint();
        q.f(r23, "paint");
        if (r23.getStyle() == Paint.Style.STROKE) goto L81;
        return null;
    L81:
        return Integer.valueOf(r23.getColor());
    L79:
        return null;
    L44:
        Drawable r24 = r10.getBackground();
        if ((r24 instanceof ColorDrawable) == true) goto L47;
        return null;
    L47:
        return Integer.valueOf(((ColorDrawable) r24).getColor());
    L28:
        throw new NoWhenBranchMatchedException();
    L74:
        return Integer.valueOf(r10.getHeight());
    L75:
        return Integer.valueOf(r10.getWidth());
    L42:
        if ((r10 instanceof TextView) == false) goto L82;
        ColorStateList r25 = ((TextView) r10).getTextColors();
        q.f(r25, "this.textColors");
        return Integer.valueOf(r25.getDefaultColor());
    L82:
        return null;
    L57:
        Method r26 = r10.getClass().getMethod(a(r11), null);     // Catch: Exception -> L50 NoSuchMethodException -> L52
        q.f(r26, "this.javaClass.getMethod(methodName)");     // Catch: Exception -> L50 NoSuchMethodException -> L52
        return r26.invoke(r10, null);
    L52:
        e = move-exception;
        e.printStackTrace();
    L56:
        return null;
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L56
    }

    public static final void d(View r10, String r11, Object r12) {
        q.g(r10, "$this$setPropertyValue");
        q.g(r11, "propertyName");
        q.g(r12, CommonKey.KEY_VALUE);
        if (q.b(r11, FixCard.FixStyle.KEY_X) == false) goto L8;
        if ((r12 instanceof Float) == false) goto L128;
        r10.setX(((Number) r12).floatValue());
        return;
    L128:
        return;
    L8:
        if (q.b(r11, FixCard.FixStyle.KEY_Y) == false) goto L13;
        if ((r12 instanceof Float) == false) goto L130;
        r10.setY(((Number) r12).floatValue());
        return;
    L130:
        return;
    L13:
        if (q.b(r11, "alpha") == false) goto L18;
        if ((r12 instanceof Float) == false) goto L132;
        r10.setAlpha(((Number) r12).floatValue());
        return;
    L132:
        return;
    L18:
        if (q.b(r11, "rotation") == false) goto L23;
        if ((r12 instanceof Float) == false) goto L134;
        r10.setRotation(((Number) r12).floatValue());
        return;
    L134:
        return;
    L23:
        if (q.b(r11, "scaleX") == false) goto L28;
        if ((r12 instanceof Float) == false) goto L136;
        r10.setScaleX(((Number) r12).floatValue());
        return;
    L136:
        return;
    L28:
        if (q.b(r11, "scaleY") == false) goto L33;
        if ((r12 instanceof Float) == false) goto L138;
        r10.setScaleY(((Number) r12).floatValue());
        return;
    L138:
        return;
    L33:
        if (q.b(r11, "translationX") == false) goto L38;
        if ((r12 instanceof Float) == false) goto L140;
        r10.setTranslationX(((Number) r12).floatValue());
        return;
    L140:
        return;
    L38:
        if (q.b(r11, "translationY") == false) goto L43;
        if ((r12 instanceof Float) == false) goto L142;
        r10.setTranslationY(((Number) r12).floatValue());
        return;
    L142:
        return;
    L43:
        if (q.b(r11, "rotationX") == false) goto L48;
        if ((r12 instanceof Float) == false) goto L144;
        r10.setRotationX(((Number) r12).floatValue());
        return;
    L144:
        return;
    L48:
        if (q.b(r11, "rotationY") == false) goto L53;
        if ((r12 instanceof Float) == false) goto L146;
        r10.setRotationY(((Number) r12).floatValue());
        return;
    L146:
        return;
    L53:
        if (q.b(r11, "scale") == false) goto L58;
        if ((r12 instanceof Float) == false) goto L148;
        Number r13 = (Number) r12;
        r10.setScaleX(r13.floatValue());
        r10.setScaleY(r13.floatValue());
        return;
    L148:
        return;
    L58:
        if (q.b(r11, AnimationProperty$IntProperty.BACKGROUND_COLOR.getPropertyName()) == false) goto L63;
        if ((r12 instanceof Integer) == false) goto L150;
        r10.setBackgroundColor(((Number) r12).intValue());
        return;
    L150:
        return;
    L63:
        if (q.b(r11, AnimationProperty$IntProperty.TEXT_COLOR.getPropertyName()) == false) goto L70;
        if ((r10 instanceof TextView) == true) goto L67;
        return;
    L67:
        if ((r12 instanceof Integer) == false) goto L153;
        ((TextView) r10).setTextColor(((Number) r12).intValue());
        return;
    L153:
        return;
    L70:
        if (q.b(r11, AnimationProperty$IntProperty.STROKE_COLOR.getPropertyName()) == false) goto L79;
        if ((r12 instanceof Integer) == false) goto L155;
        Drawable r14 = r10.getBackground();
        if ((r14 instanceof ShapeDrawable) == false) goto L156;
        Paint r15 = ((ShapeDrawable) r14).getPaint();
        q.f(r15, "paint");
        if (r15.getStyle() != Paint.Style.STROKE) goto L157;
        r15.setColor(((Number) r12).intValue());
        r10.invalidate();
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L79:
        if (q.b(r11, AnimationProperty$IntProperty.FILL_COLOR.getPropertyName()) == true) goto L81;
        int r16 = 0;
        if (q.b(r11, AnimationProperty$IntProperty.WIDTH.getPropertyName()) == false) goto L98;
        if ((r12 instanceof Integer) == false) goto L163;
        ViewGroup.LayoutParams r17 = r10.getLayoutParams();
        if (r17 == null) goto L164;
        Number r18 = (Number) r12;
        if (r18.intValue() <= 0) goto L96;
        r16 = r18.intValue();
    L96:
        r17.width = r16;
        r10.setLayoutParams(r17);
        r10.requestLayout();
        return;
    L164:
        return;
    L163:
        return;
    L98:
        if (q.b(r11, AnimationProperty$IntProperty.HEIGHT.getPropertyName()) == true) goto L100;
        String r19 = b(r11);     // Catch: Exception -> L110 NoSuchMethodException -> L112
        if ((r12 instanceof Integer) == false) goto L115;
        Class<?> r20 = Integer.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L121:
        Method r21 = r10.getClass().getMethod(r19, new Class[]{r20});     // Catch: Exception -> L110 NoSuchMethodException -> L112
        q.f(r21, "this.javaClass.getMethod(methodName, valueClass)");     // Catch: Exception -> L110 NoSuchMethodException -> L112
        r21.invoke(r10, new Object[]{r12});     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L170:
        return;
    L115:
        if ((r12 instanceof Float) == false) goto L118;
        r20 = Float.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
        goto L121
    L118:
        if ((r12 instanceof Boolean) == false) goto L120;
        r20 = Boolean.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
        goto L121
    L120:
        r20 = r12.getClass();     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L112:
        e = move-exception;
        e.printStackTrace();
        return;
    L110:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        if ((r12 instanceof Integer) == false) goto L166;
        ViewGroup.LayoutParams r22 = r10.getLayoutParams();
        if (r22 == null) goto L167;
        Number r23 = (Number) r12;
        if (r23.intValue() <= 0) goto L106;
        r16 = r23.intValue();
    L106:
        r22.height = r16;
        r10.setLayoutParams(r22);
        r10.requestLayout();
        return;
    L167:
        return;
    L166:
        return;
    L81:
        if ((r12 instanceof Integer) == false) goto L159;
        Drawable r24 = r10.getBackground();
        if ((r24 instanceof ShapeDrawable) == false) goto L160;
        Paint r25 = ((ShapeDrawable) r24).getPaint();
        q.f(r25, "paint");
        if (r25.getStyle() != Paint.Style.FILL) goto L161;
        r25.setColor(((Number) r12).intValue());
        r10.invalidate();
        return;
    L161:
        return;
    L160:
        return;
    }
}
