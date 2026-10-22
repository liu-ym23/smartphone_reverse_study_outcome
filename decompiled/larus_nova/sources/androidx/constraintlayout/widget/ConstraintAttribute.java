package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import com.baidu.mapapi.UIMsg;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r100 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r100;
            r100[AttributeType.COLOR_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum AttributeType extends Enum<AttributeType> {
        private static final /* synthetic */ AttributeType[] $VALUES = null;
        public static final AttributeType BOOLEAN_TYPE = null;
        public static final AttributeType COLOR_DRAWABLE_TYPE = null;
        public static final AttributeType COLOR_TYPE = null;
        public static final AttributeType DIMENSION_TYPE = null;
        public static final AttributeType FLOAT_TYPE = null;
        public static final AttributeType INT_TYPE = null;
        public static final AttributeType STRING_TYPE = null;

        static {
            AttributeType r100 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r100;
            AttributeType r101 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r101;
            AttributeType r102 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r102;
            AttributeType r103 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r103;
            AttributeType r104 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r104;
            AttributeType r105 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r105;
            AttributeType r110 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r110;
            $VALUES = new AttributeType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static AttributeType[] values() {
            return (AttributeType[]) $VALUES.clone();
        }

        public static AttributeType valueOf(String r100) {
            return (AttributeType) a.a(AttributeType.class, r100);
        }

        private AttributeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    private static int clamp(int r100) {
        int r101 = (r100 & (~(r100 >> 31))) + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE;
        return (r101 & (r101 >> 31)) + 255;
    }

    public float getValueToInterpolate() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.mFloatValue;
    L9:
        if (this.mBooleanValue == false) goto L11;
        return 1.0f;
    L11:
        return 0.0f;
    L14:
        throw new RuntimeException("Cannot interpolate String");
    L16:
        return this.mFloatValue;
    L18:
        return this.mIntegerValue;
    L20:
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public int noOfInterpValues() {
        int r100 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if (r100 != 1) goto L5;
        return 4;
    L5:
        if (r100 == 2) goto L9;
        return 1;
    L9:
        return 4;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_constraintlayout_widget_ConstraintAttribute_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public boolean diff(ConstraintAttribute r100) {
        if (r100 == null) goto L39;
        AttributeType r101 = this.mType;
        if (r101 == r100.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r101.ordinal()]) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L27;
            case 4: goto L23;
            case 5: goto L19;
            case 6: goto L15;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        if (this.mFloatValue != r100.mFloatValue) goto L34;
        return true;
    L34:
        return false;
    L15:
        if (this.mBooleanValue != r100.mBooleanValue) goto L35;
        return true;
    L35:
        return false;
    L19:
        if (this.mIntegerValue != r100.mIntegerValue) goto L36;
        return true;
    L36:
        return false;
    L23:
        if (this.mFloatValue != r100.mFloatValue) goto L37;
        return true;
    L37:
        return false;
    L27:
        if (this.mIntegerValue != r100.mIntegerValue) goto L38;
        return true;
    L38:
        return false;
    L31:
        if (this.mColorValue != r100.mColorValue) goto L40;
        return true;
    L40:
        return false;
    L39:
        return false;
    }

    public void getValuesToInterpolate(float[] r110) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L21;
        };
    L5:
        r110[0] = this.mFloatValue;
        return;
    L13:
        r110[0] = this.mFloatValue;
        return;
    L14:
        r110[0] = this.mIntegerValue;
        return;
    L15:
        int r100 = this.mColorValue;
        int r101 = (r100 >> 24) & 255;
        float r102 = (float) Math.pow(((r100 >> 16) & 255) / 255.0f, 2.2d);
        float r103 = (float) Math.pow(((r100 >> 8) & 255) / 255.0f, 2.2d);
        float r104 = (float) Math.pow((r100 & 255) / 255.0f, 2.2d);
        r110[0] = r102;
        r110[1] = r103;
        r110[2] = r104;
        r110[3] = r101 / 255.0f;
        return;
    L21:
        return;
    L7:
        if (this.mBooleanValue == false) goto L9;
        float r105 = 1.0f;
    L10:
        r110[0] = r105;
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L12:
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public void setColorValue(int r100) {
        this.mColorValue = r100;
    }

    public void setFloatValue(float r100) {
        this.mFloatValue = r100;
    }

    public void setIntValue(int r100) {
        this.mIntegerValue = r100;
    }

    public void setStringValue(String r100) {
        this.mStringValue = r100;
    }

    public void setValue(float[] r100) {
        boolean r101 = false;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L20;
        };
    L5:
        this.mFloatValue = r100[0];
        return;
    L12:
        this.mFloatValue = r100[0];
        return;
    L13:
        this.mIntegerValue = (int) r100[0];
        return;
    L14:
        int r102 = Color.HSVToColor(r100);
        this.mColorValue = r102;
        this.mColorValue = (clamp((int) (r100[3] * 255.0f)) << 24) | (r102 & 16777215);
        return;
    L20:
        return;
    L7:
        if (r100[0] <= 0.5d) goto L9;
        r101 = true;
    L9:
        this.mBooleanValue = r101;
        return;
    L11:
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public void setValue(Object r100) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L17;
        };
    L5:
        this.mFloatValue = ((Float) r100).floatValue();
        return;
    L6:
        this.mBooleanValue = ((Boolean) r100).booleanValue();
        return;
    L7:
        this.mStringValue = (String) r100;
        return;
    L8:
        this.mFloatValue = ((Float) r100).floatValue();
        return;
    L9:
        this.mIntegerValue = ((Integer) r100).intValue();
        return;
    L10:
        this.mColorValue = ((Integer) r100).intValue();
        return;
    }

    public ConstraintAttribute(ConstraintAttribute r100, Object r101) {
        this.mName = r100.mName;
        this.mType = r100.mType;
        setValue(r101);
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> r100, View r101) {
        HashMap<String, ConstraintAttribute> r102 = new HashMap();
        Class<?> r103 = r101.getClass();
        Iterator<String> r104 = r100.keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L17;
        String r105 = r104.next();
        ConstraintAttribute r106 = r100.get(r105);
    L7:
        if (r105.equals("BackgroundColor") == true) goto L8;
        r102.put(r105, new ConstraintAttribute(r106, r103.getMethod("getMap" + r105, new Class[0]).invoke(r101, new Object[0])));     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        goto L4
    L8:
        r102.put(r105, new ConstraintAttribute(r106, Integer.valueOf(((ColorDrawable) r101.getBackground()).getColor())));     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L17:
        return r102;
    }

    public static void setAttributes(View r100, HashMap<String, ConstraintAttribute> r101) {
        Class<?> r102 = r100.getClass();
        Iterator<String> r103 = r101.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L23;
        String r104 = r103.next();
        ConstraintAttribute r105 = r101.get(r104);
        String r106 = "set" + r104;
    L7:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r105.mType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
    L9:
        r102.getMethod(r106, new Class[]{Float.TYPE}).invoke(r100, new Object[]{Float.valueOf(r105.mFloatValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        goto L4
    L10:
        r102.getMethod(r106, new Class[]{Boolean.TYPE}).invoke(r100, new Object[]{Boolean.valueOf(r105.mBooleanValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        goto L4
    L11:
        r102.getMethod(r106, new Class[]{CharSequence.class}).invoke(r100, new Object[]{r105.mStringValue});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        goto L4
    L12:
        r102.getMethod(r106, new Class[]{Float.TYPE}).invoke(r100, new Object[]{Float.valueOf(r105.mFloatValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        goto L4
    L13:
        r102.getMethod(r106, new Class[]{Integer.TYPE}).invoke(r100, new Object[]{Integer.valueOf(r105.mIntegerValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        goto L4
    L14:
        Method r107 = r102.getMethod(r106, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        ColorDrawable r108 = new ColorDrawable();     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r108.setColor(r105.mColorValue);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r107.invoke(r100, new Object[]{r108});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        goto L4
    L15:
        r102.getMethod(r106, new Class[]{Integer.TYPE}).invoke(r100, new Object[]{Integer.valueOf(r105.mColorValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.getMessage();
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public void setInterpolatedValue(View r110, float[] r111) {
        Class<?> r100 = r110.getClass();
        String r101 = "set" + this.mName;
        boolean r102 = true;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L27;
        };     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L6:
        r100.getMethod(r101, new Class[]{Float.TYPE}).invoke(r110, new Object[]{Float.valueOf(r111[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L7:
        Method r103 = r100.getMethod(r101, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        Object[] r104 = new Object[1];     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        if (r111[0] > 0.5f) goto L11;
        r102 = false;
    L11:
        r104[0] = Boolean.valueOf(r102);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r103.invoke(r110, r104);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L14:
        r100.getMethod(r101, new Class[]{Float.TYPE}).invoke(r110, new Object[]{Float.valueOf(r111[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L15:
        r100.getMethod(r101, new Class[]{Integer.TYPE}).invoke(r110, new Object[]{Integer.valueOf((int) r111[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L16:
        Method r105 = r100.getMethod(r101, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        int r112 = (((clamp((int) (r111[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(r111[0], 0.45454545454545453d)) * 255.0f)) << 16)) | (clamp((int) (((float) Math.pow(r111[1], 0.45454545454545453d)) * 255.0f)) << 8)) | clamp((int) (((float) Math.pow(r111[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        ColorDrawable r106 = new ColorDrawable();     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r106.setColor(r112);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r105.invoke(r110, new Object[]{r106});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L17:
        r100.getMethod(r101, new Class[]{Integer.TYPE}).invoke(r110, new Object[]{Integer.valueOf((((clamp((int) (r111[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(r111[0], 0.45454545454545453d)) * 255.0f)) << 16)) | (clamp((int) (((float) Math.pow(r111[1], 0.45454545454545453d)) * 255.0f)) << 8)) | clamp((int) (((float) Math.pow(r111[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L27:
        return;
    L13:
        throw new RuntimeException("unable to interpolate strings " + this.mName);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L21:
        e = move-exception;
        Debug.getName(r110);
        e.printStackTrace();
        return;
    L23:
        e = move-exception;
        Debug.getName(r110);
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public ConstraintAttribute(String r100, AttributeType r101) {
        this.mName = r100;
        this.mType = r101;
    }

    public ConstraintAttribute(String r100, AttributeType r101, Object r102) {
        this.mName = r100;
        this.mType = r101;
        setValue(r102);
    }

    public static void parse(Context r110, XmlPullParser r111, HashMap<String, ConstraintAttribute> r112) {
        TypedArray r113 = r110.obtainStyledAttributes(Xml.asAttributeSet(r111), new int[]{R.attr.attributeName, R.attr.customBoolean, R.attr.customColorDrawableValue, R.attr.customColorValue, R.attr.customDimension, R.attr.customFloatValue, R.attr.customIntegerValue, R.attr.customPixelDimension, R.attr.customReference, R.attr.customStringValue, R.attr.methodName});
        int r100 = r113.getIndexCount();
        String r101 = null;
        Object r102 = null;
        AttributeType r103 = null;
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L36;
        int r105 = r113.getIndex(r104);
        if (r105 != 0) goto L11;
        r101 = r113.getString(r105);
        if (r101 == null) goto L35;
        if (r101.length() <= 0) goto L35;
        r101 = Character.toUpperCase(r101.charAt(0)) + r101.substring(1);
    L35:
        r104 = r104 + 1;
        goto L3
    L11:
        if (r105 != 1) goto L14;
        r102 = Boolean.valueOf(r113.getBoolean(r105, false));
        r103 = AttributeType.BOOLEAN_TYPE;
        goto L35
    L14:
        if (r105 != 3) goto L18;
        AttributeType r106 = AttributeType.COLOR_TYPE;
        Object r107 = Integer.valueOf(r113.getColor(r105, 0));
    L16:
        Object r114 = r107;
        r103 = r106;
        r102 = r114;
        goto L35
    L18:
        if (r105 != 2) goto L21;
        r106 = AttributeType.COLOR_DRAWABLE_TYPE;
        r107 = Integer.valueOf(r113.getColor(r105, 0));
        goto L16
    L21:
        if (r105 != 7) goto L24;
        r106 = AttributeType.DIMENSION_TYPE;
        r107 = Float.valueOf(TypedValue.applyDimension(1, r113.getDimension(r105, 0.0f), INVOKEVIRTUAL_androidx_constraintlayout_widget_ConstraintAttribute_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r110.getResources())));
        goto L16
    L24:
        if (r105 != 4) goto L27;
        r106 = AttributeType.DIMENSION_TYPE;
        r107 = Float.valueOf(r113.getDimension(r105, 0.0f));
        goto L16
    L27:
        if (r105 != 5) goto L30;
        r106 = AttributeType.FLOAT_TYPE;
        r107 = Float.valueOf(r113.getFloat(r105, Float.NaN));
        goto L16
    L30:
        if (r105 != 6) goto L33;
        r106 = AttributeType.INT_TYPE;
        r107 = Integer.valueOf(r113.getInteger(r105, -1));
        goto L16
    L33:
        if (r105 != 9) goto L35;
        r106 = AttributeType.STRING_TYPE;
        r107 = r113.getString(r105);
        goto L16
    L36:
        if (r101 == null) goto L39;
        if (r102 == null) goto L39;
        r112.put(r101, new ConstraintAttribute(r101, r103, r102));
    L39:
        r113.recycle();
    }
}
