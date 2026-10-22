package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ConstraintAttribute.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EnumC0017a f946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f947e;
    private float f;
    private String g;
    private int h;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintAttribute.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f948a = null;

        static {
            int[] r0 = new int[EnumC0017a.values().length];
            f948a = r0;
            r0[EnumC0017a.h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f948a[EnumC0017a.f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f948a[EnumC0017a.f953e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f948a[EnumC0017a.f951c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f948a[EnumC0017a.f952d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f948a[EnumC0017a.f949a.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f948a[EnumC0017a.f950b.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f948a[EnumC0017a.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintAttribute.java */
    public static final enum EnumC0017a extends Enum<EnumC0017a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0017a f949a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0017a f950b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0017a f951c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0017a f952d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0017a f953e = null;
        public static final EnumC0017a f = null;
        public static final EnumC0017a g = null;
        public static final EnumC0017a h = null;
        private static final /* synthetic */ EnumC0017a[] i = null;

        private EnumC0017a(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ EnumC0017a[] a() {
            return new EnumC0017a[]{f949a, f950b, f951c, f952d, f953e, f, g, h};
        }

        public static EnumC0017a valueOf(String r2) {
            return (EnumC0017a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0017a.class, r2), EnumC0017a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0017a[] values() {
            return (EnumC0017a[]) ZeusTransformUtils.preCheckCast(i.clone(), EnumC0017a[].class, "com.obric.aiagent.plugin");
        }

        static {
            f949a = new EnumC0017a("INT_TYPE", 0);
            f950b = new EnumC0017a("FLOAT_TYPE", 1);
            f951c = new EnumC0017a("COLOR_TYPE", 2);
            f952d = new EnumC0017a("COLOR_DRAWABLE_TYPE", 3);
            f953e = new EnumC0017a("STRING_TYPE", 4);
            f = new EnumC0017a("BOOLEAN_TYPE", 5);
            g = new EnumC0017a("DIMENSION_TYPE", 6);
            h = new EnumC0017a("REFERENCE_TYPE", 7);
            i = a();
        }
    }

    public String a() {
        return this.f943a;
    }

    public EnumC0017a getType() {
        return this.f946d;
    }

    public boolean b() {
        int r2 = AnonymousClass1.f948a[this.f946d.ordinal()];
        if (r2 != 1) goto L5;
        return false;
    L5:
        if (r2 != 2) goto L7;
        return false;
    L7:
        if (r2 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    public int c() {
        int r2 = AnonymousClass1.f948a[this.f946d.ordinal()];
        if (r2 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r2 == 5) goto L8;
        return 1;
    }

    public float d() {
        switch(AnonymousClass1.f948a[this.f946d.ordinal()]) {
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
        return this.f;
    L9:
        return this.f;
    L11:
        return this.f947e;
    L13:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L15:
        throw new RuntimeException("Cannot interpolate String");
    L17:
        if (this.f944b == false) goto L19;
        return 1.0f;
    L19:
        return 0.0f;
    }

    public void a(float[] r10) {
        switch(AnonymousClass1.f948a[this.f946d.ordinal()]) {
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
        r10[0] = this.f;
        return;
    L6:
        r10[0] = this.f;
        return;
    L7:
        r10[0] = this.f947e;
        return;
    L8:
        int r9 = this.h;
        int r0 = (r9 >> 24) & 255;
        float r2 = (float) Math.pow(((r9 >> 16) & 255) / 255.0f, 2.2d);
        float r3 = (float) Math.pow(((r9 >> 8) & 255) / 255.0f, 2.2d);
        float r11 = (float) Math.pow((r9 & 255) / 255.0f, 2.2d);
        r10[0] = r2;
        r10[1] = r3;
        r10[2] = r11;
        r10[3] = r0 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.f944b == false) goto L14;
        float r12 = 1.0f;
    L15:
        r10[0] = r12;
        return;
    L14:
        r12 = 0.0f;
        goto L15
    }

    public a(String r2, EnumC0017a r3, Object r4, boolean r5) {
        this.f945c = false;
        this.f943a = r2;
        this.f946d = r3;
        this.f945c = r5;
        a(r4);
    }

    public a(a r2, Object r3) {
        this.f945c = false;
        this.f943a = r2.f943a;
        this.f946d = r2.f946d;
        a(r3);
    }

    public void a(Object r3) {
        switch(AnonymousClass1.f948a[this.f946d.ordinal()]) {
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
        this.f = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
        return;
    L6:
        this.f = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
        return;
    L7:
        this.h = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L8:
        this.g = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        return;
    L9:
        this.f944b = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        return;
    L10:
        this.f947e = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    }

    public static HashMap<String, a> a(HashMap<String, a> r8, View r9) {
        HashMap<String, a> r0 = new HashMap();
        Class<?> r1 = r9.getClass();
        Iterator<String> r2 = r8.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r8.get(r3), a.class, "com.obric.aiagent.plugin");
    L7:
        if (r3.equals("BackgroundColor") == true) goto L8;
        r0.put(r3, new a(r4, r1.getMethod("getMap" + r3, new Class[0]).invoke(r9, new Object[0])));     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        goto L4
    L8:
        r0.put(r3, new a(r4, Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r9.getBackground(), ColorDrawable.class, "com.obric.aiagent.plugin")).getColor())));     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
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
        return r0;
    }

    public static void a(View r12, HashMap<String, a> r13) {
        Class<?> r3 = r12.getClass();
        Iterator<String> r4 = r13.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L27;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        a r6 = (a) ZeusTransformUtils.preCheckCast(r13.get(r5), a.class, "com.obric.aiagent.plugin");
        if (r6.f945c == true) goto L8;
        String r7 = "set" + r5;
    L28:
    L10:
        switch(AnonymousClass1.f948a[r6.f946d.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
    L12:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r6.f)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L13:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r6.f)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L14:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.f947e)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L15:
        Method r8 = r3.getMethod(r7, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        ColorDrawable r11 = new ColorDrawable();     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        r11.setColor(r6.h);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        r8.invoke(r12, new Object[]{r11});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L16:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.h)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L17:
        r3.getMethod(r7, new Class[]{CharSequence.class}).invoke(r12, new Object[]{r6.g});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L18:
        r3.getMethod(r7, new Class[]{Boolean.TYPE}).invoke(r12, new Object[]{Boolean.valueOf(r6.f944b)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L19:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.f947e)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
    L23:
        e = move-exception;
        a(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        e.printStackTrace();
    L25:
        e = move-exception;
        a(TAG, e.getMessage());
        a(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        a(TAG, r3.getName() + " must have a method " + r7);
    L21:
        e = move-exception;
        a(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        e.printStackTrace();
        goto L4
    L8:
        r7 = r5;
        goto L28
    }

    public void a(View r11) {
        Class<?> r3 = r11.getClass();
        String r4 = this.f943a;
        if (this.f945c == true) goto L5;
        String r5 = "set" + r4;
    L24:
    L19:
        e = move-exception;
        a(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        e.printStackTrace();
        return;
    L21:
        e = move-exception;
        a(TAG, e.getMessage());
        a(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        a(TAG, r3.getName() + " must have a method " + r5);
        return;
    L17:
        e = move-exception;
        a(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        e.printStackTrace();
        return;
    L7:
        switch(AnonymousClass1.f948a[this.f946d.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L15;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L25;
        };     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
    L9:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.f)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L10:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.f)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L11:
        Method r6 = r3.getMethod(r5, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        ColorDrawable r9 = new ColorDrawable();     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r9.setColor(this.h);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r6.invoke(r11, new Object[]{r9});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L12:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.h)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L13:
        r3.getMethod(r5, new Class[]{CharSequence.class}).invoke(r11, new Object[]{this.g});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L14:
        r3.getMethod(r5, new Class[]{Boolean.TYPE}).invoke(r11, new Object[]{Boolean.valueOf(this.f944b)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L15:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.f947e)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L25:
        return;
    L5:
        r5 = r4;
        goto L24
    }

    public static void a(Context r16, XmlPullParser r17, HashMap<String, a> r18) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        TypedArray r2 = r0.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r17, XmlPullParser.class, "com.obric.aiagent.plugin")), R.styleable.CustomAttribute);
        int r3 = r2.getIndexCount();
        String r4 = null;
        Object r6 = null;
        EnumC0017a r7 = null;
        int r8 = 0;
        boolean r9 = false;
    L3:
        if (r8 >= r3) goto L46;
        int r10 = r2.getIndex(r8);
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_attributeName, "styleable", "CustomAttribute_attributeName")) goto L12;
        r4 = r2.getString(r10);
        if (r4 == null) goto L45;
        if (r4.length() <= 0) goto L45;
        r4 = Character.toUpperCase(r4.charAt(0)) + r4.substring(1);
    L45:
        r8 = r8 + 1;
        goto L3
    L12:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_methodName, "styleable", "CustomAttribute_methodName")) goto L15;
        r4 = r2.getString(r10);
        r9 = true;
        goto L45
    L15:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customBoolean, "styleable", "CustomAttribute_customBoolean")) goto L18;
        r6 = Boolean.valueOf(r2.getBoolean(r10, false));
        r7 = EnumC0017a.f;
        goto L45
    L18:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customColorValue, "styleable", "CustomAttribute_customColorValue")) goto L22;
        EnumC0017a r11 = EnumC0017a.f951c;
        Object r12 = Integer.valueOf(r2.getColor(r10, 0));
    L20:
        Object r15 = r12;
        r7 = r11;
        r6 = r15;
        goto L45
    L22:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customColorDrawableValue, "styleable", "CustomAttribute_customColorDrawableValue")) goto L25;
        r11 = EnumC0017a.f952d;
        r12 = Integer.valueOf(r2.getColor(r10, 0));
        goto L20
    L25:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customPixelDimension, "styleable", "CustomAttribute_customPixelDimension")) goto L28;
        r11 = EnumC0017a.g;
        r12 = Float.valueOf(TypedValue.applyDimension(1, r2.getDimension(r10, 0.0f), ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getDisplayMetrics()));
        goto L20
    L28:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customDimension, "styleable", "CustomAttribute_customDimension")) goto L31;
        r11 = EnumC0017a.g;
        r12 = Float.valueOf(r2.getDimension(r10, 0.0f));
        goto L20
    L31:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customFloatValue, "styleable", "CustomAttribute_customFloatValue")) goto L34;
        r11 = EnumC0017a.f950b;
        r12 = Float.valueOf(r2.getFloat(r10, Float.NaN));
        goto L20
    L34:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customIntegerValue, "styleable", "CustomAttribute_customIntegerValue")) goto L37;
        r11 = EnumC0017a.f949a;
        r12 = Integer.valueOf(r2.getInteger(r10, -1));
        goto L20
    L37:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customStringValue, "styleable", "CustomAttribute_customStringValue")) goto L40;
        r11 = EnumC0017a.f953e;
        r12 = r2.getString(r10);
        goto L20
    L40:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customReference, "styleable", "CustomAttribute_customReference")) goto L45;
        r11 = EnumC0017a.h;
        int r13 = r2.getResourceId(r10, -1);
        if (r13 != (-1)) goto L44;
        r13 = r2.getInt(r10, -1);
    L44:
        r12 = Integer.valueOf(r13);
        goto L20
    L46:
        if (r4 == null) goto L49;
        if (r6 == null) goto L49;
        r18.put(r4, new a(r4, r7, r6, r9));
    L49:
        r2.recycle();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
