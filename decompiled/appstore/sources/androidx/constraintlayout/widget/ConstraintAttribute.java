package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AttributeType f2170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2175h;

    public static final enum AttributeType extends Enum<AttributeType> {
        private static final /* synthetic */ AttributeType[] $VALUES = null;
        public static final AttributeType BOOLEAN_TYPE = null;
        public static final AttributeType COLOR_DRAWABLE_TYPE = null;
        public static final AttributeType COLOR_TYPE = null;
        public static final AttributeType DIMENSION_TYPE = null;
        public static final AttributeType FLOAT_TYPE = null;
        public static final AttributeType INT_TYPE = null;
        public static final AttributeType REFERENCE_TYPE = null;
        public static final AttributeType STRING_TYPE = null;

        private static /* synthetic */ AttributeType[] $values() {
            return new AttributeType[]{INT_TYPE, FLOAT_TYPE, COLOR_TYPE, COLOR_DRAWABLE_TYPE, STRING_TYPE, BOOLEAN_TYPE, DIMENSION_TYPE, REFERENCE_TYPE};
        }

        static {
            INT_TYPE = new AttributeType("INT_TYPE", 0);
            FLOAT_TYPE = new AttributeType("FLOAT_TYPE", 1);
            COLOR_TYPE = new AttributeType("COLOR_TYPE", 2);
            COLOR_DRAWABLE_TYPE = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            STRING_TYPE = new AttributeType("STRING_TYPE", 4);
            BOOLEAN_TYPE = new AttributeType("BOOLEAN_TYPE", 5);
            DIMENSION_TYPE = new AttributeType("DIMENSION_TYPE", 6);
            REFERENCE_TYPE = new AttributeType("REFERENCE_TYPE", 7);
            $VALUES = $values();
        }

        private AttributeType(String r10, int r11) {
            super(r10, r11);
        }

        public static AttributeType valueOf(String r10) {
            return (AttributeType) Enum.valueOf(AttributeType.class, r10);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2176a = null;

        static {
            int[] r10 = new int[AttributeType.values().length];
            f2176a = r10;
            r10[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f2176a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f2176a[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f2176a[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f2176a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f2176a[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f2176a[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f2176a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public ConstraintAttribute(String r10, AttributeType r11, Object r12, boolean r13) {
        this.f2169b = r10;
        this.f2170c = r11;
        this.f2168a = r13;
        j(r12);
    }

    public static HashMap a(HashMap r10, View r11) {
        HashMap r12 = new HashMap();
        Class<?> r13 = r11.getClass();
        Iterator r14 = r10.keySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L20;
        String r15 = (String) r14.next();
        ConstraintAttribute r16 = (ConstraintAttribute) r10.get(r15);
    L7:
        if (r15.equals("BackgroundColor") == true) goto L8;
        r12.put(r15, new ConstraintAttribute(r16, r13.getMethod("getMap" + r15, null).invoke(r11, null)));     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
        goto L4
    L8:
        r12.put(r15, new ConstraintAttribute(r16, Integer.valueOf(((ColorDrawable) r11.getBackground()).getColor())));     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L20:
        return r12;
    }

    public static void h(Context r12, XmlPullParser r13, HashMap r14) {
        TypedArray r15 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R$styleable.CustomAttribute);
        int r10 = r15.getIndexCount();
        String r11 = null;
        Object r16 = null;
        AttributeType r17 = null;
        int r18 = 0;
        boolean r19 = false;
    L3:
        if (r18 >= r10) goto L46;
        int r20 = r15.getIndex(r18);
        if (r20 != R$styleable.CustomAttribute_attributeName) goto L12;
        r11 = r15.getString(r20);
        if (r11 == null) goto L45;
        if (r11.length() <= 0) goto L45;
        r11 = Character.toUpperCase(r11.charAt(0)) + r11.substring(1);
    L45:
        r18 = r18 + 1;
        goto L3
    L12:
        if (r20 != R$styleable.CustomAttribute_methodName) goto L15;
        r11 = r15.getString(r20);
        r19 = true;
        goto L45
    L15:
        if (r20 != R$styleable.CustomAttribute_customBoolean) goto L18;
        r16 = Boolean.valueOf(r15.getBoolean(r20, false));
        r17 = AttributeType.BOOLEAN_TYPE;
        goto L45
    L18:
        if (r20 != R$styleable.CustomAttribute_customColorValue) goto L22;
        AttributeType r21 = AttributeType.COLOR_TYPE;
        Object r22 = Integer.valueOf(r15.getColor(r20, 0));
    L20:
        Object r110 = r22;
        r17 = r21;
        r16 = r110;
        goto L45
    L22:
        if (r20 != R$styleable.CustomAttribute_customColorDrawableValue) goto L25;
        r21 = AttributeType.COLOR_DRAWABLE_TYPE;
        r22 = Integer.valueOf(r15.getColor(r20, 0));
        goto L20
    L25:
        if (r20 != R$styleable.CustomAttribute_customPixelDimension) goto L28;
        r21 = AttributeType.DIMENSION_TYPE;
        r22 = Float.valueOf(TypedValue.applyDimension(1, r15.getDimension(r20, 0.0f), r12.getResources().getDisplayMetrics()));
        goto L20
    L28:
        if (r20 != R$styleable.CustomAttribute_customDimension) goto L31;
        r21 = AttributeType.DIMENSION_TYPE;
        r22 = Float.valueOf(r15.getDimension(r20, 0.0f));
        goto L20
    L31:
        if (r20 != R$styleable.CustomAttribute_customFloatValue) goto L34;
        r21 = AttributeType.FLOAT_TYPE;
        r22 = Float.valueOf(r15.getFloat(r20, Float.NaN));
        goto L20
    L34:
        if (r20 != R$styleable.CustomAttribute_customIntegerValue) goto L37;
        r21 = AttributeType.INT_TYPE;
        r22 = Integer.valueOf(r15.getInteger(r20, -1));
        goto L20
    L37:
        if (r20 != R$styleable.CustomAttribute_customStringValue) goto L40;
        r21 = AttributeType.STRING_TYPE;
        r22 = r15.getString(r20);
        goto L20
    L40:
        if (r20 != R$styleable.CustomAttribute_customReference) goto L45;
        r21 = AttributeType.REFERENCE_TYPE;
        int r23 = r15.getResourceId(r20, -1);
        if (r23 != (-1)) goto L44;
        r23 = r15.getInt(r20, -1);
    L44:
        r22 = Integer.valueOf(r23);
        goto L20
    L46:
        if (r11 == null) goto L49;
        if (r16 == null) goto L49;
        r14.put(r11, new ConstraintAttribute(r11, r17, r16, r19));
    L49:
        r15.recycle();
    }

    public static void i(View r10, HashMap r11) {
        Class<?> r12 = r10.getClass();
        Iterator r13 = r11.keySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L30;
        String r14 = (String) r13.next();
        ConstraintAttribute r15 = (ConstraintAttribute) r11.get(r14);
        if (r15.f2168a == true) goto L8;
        String r16 = "set" + r14;
    L31:
    L10:
        switch(a.f2176a[r15.f2170c.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
    L12:
        r12.getMethod(r16, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r15.f2172e)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L19:
        r12.getMethod(r16, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r15.f2172e)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L20:
        r12.getMethod(r16, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r15.f2171d)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L21:
        Method r17 = r12.getMethod(r16, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        ColorDrawable r18 = new ColorDrawable();     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        r18.setColor(r15.f2175h);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        r17.invoke(r10, new Object[]{r18});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L22:
        r12.getMethod(r16, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r15.f2175h)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L23:
        r12.getMethod(r16, new Class[]{CharSequence.class}).invoke(r10, new Object[]{r15.f2173f});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L24:
        r12.getMethod(r16, new Class[]{Boolean.TYPE}).invoke(r10, new Object[]{Boolean.valueOf(r15.f2174g)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L25:
        r12.getMethod(r16, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r15.f2171d)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
    L15:
        e = move-exception;
        Log.e("TransitionLayout", " Custom Attribute \"" + r14 + "\" not found on " + r12.getName());
        e.printStackTrace();
    L17:
        e = move-exception;
        Log.e("TransitionLayout", e.getMessage());
        Log.e("TransitionLayout", " Custom Attribute \"" + r14 + "\" not found on " + r12.getName());
        StringBuilder r19 = new StringBuilder();
        r19.append(r12.getName());
        r19.append(" must have a method ");
        r19.append(r16);
        Log.e("TransitionLayout", r19.toString());
    L13:
        e = move-exception;
        Log.e("TransitionLayout", " Custom Attribute \"" + r14 + "\" not found on " + r12.getName());
        e.printStackTrace();
        goto L4
    L8:
        r16 = r14;
        goto L31
    }

    public String b() {
        return this.f2169b;
    }

    public AttributeType c() {
        return this.f2170c;
    }

    public float d() {
        switch(a.f2176a[this.f2170c.ordinal()]) {
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.f2172e;
    L9:
        return this.f2172e;
    L11:
        return this.f2171d;
    L13:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L15:
        throw new RuntimeException("Cannot interpolate String");
    L17:
        if (this.f2174g == false) goto L19;
        return 1.0f;
    L19:
        return 0.0f;
    }

    public void e(float[] r10) {
        switch(a.f2176a[this.f2170c.ordinal()]) {
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L21;
        };
    L5:
        r10[0] = this.f2172e;
        return;
    L6:
        r10[0] = this.f2172e;
        return;
    L7:
        r10[0] = this.f2171d;
        return;
    L8:
        int r11 = this.f2175h;
        int r12 = (r11 >> 24) & PrivateKeyType.INVALID;
        int r13 = (r11 >> 16) & PrivateKeyType.INVALID;
        int r14 = (r11 >> 8) & PrivateKeyType.INVALID;
        int r15 = r11 & PrivateKeyType.INVALID;
        float r16 = (float) Math.pow(r13 / 255.0f, 2.2d);
        float r17 = (float) Math.pow(r14 / 255.0f, 2.2d);
        float r18 = (float) Math.pow(r15 / 255.0f, 2.2d);
        r10[0] = r16;
        r10[1] = r17;
        r10[2] = r18;
        r10[3] = r12 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.f2174g == false) goto L14;
        float r19 = 1.0f;
    L15:
        r10[0] = r19;
        return;
    L14:
        r19 = 0.0f;
        goto L15
    }

    public boolean f() {
        int r10 = a.f2176a[this.f2170c.ordinal()];
        if (r10 != 1) goto L5;
        return false;
    L5:
        if (r10 != 2) goto L7;
        return false;
    L7:
        if (r10 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    public int g() {
        int r10 = a.f2176a[this.f2170c.ordinal()];
        if (r10 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r10 == 5) goto L8;
        return 1;
    }

    public void j(Object r10) {
        switch(a.f2176a[this.f2170c.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L17;
        };
    L5:
        this.f2172e = ((Float) r10).floatValue();
        return;
    L6:
        this.f2172e = ((Float) r10).floatValue();
        return;
    L7:
        this.f2175h = ((Integer) r10).intValue();
        return;
    L8:
        this.f2173f = (String) r10;
        return;
    L9:
        this.f2174g = ((Boolean) r10).booleanValue();
        return;
    L10:
        this.f2171d = ((Integer) r10).intValue();
        return;
    }

    public ConstraintAttribute(ConstraintAttribute r10, Object r11) {
        this.f2168a = false;
        this.f2169b = r10.f2169b;
        this.f2170c = r10.f2170c;
        j(r11);
    }
}
