package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
class n {
    private static final String TAG = "ACTVAutoSizeHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RectF f463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f467e;
    private float f;
    private float g;
    private float h;
    private int[] i;
    private boolean j;
    private TextPaint k;
    private final TextView l;
    private final Context m;
    private final d n;

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static final class a {
        static int a(TextView r0) {
            return r0.getMaxLines();
        }

        static StaticLayout a(CharSequence r8, Layout.Alignment r9, int r10, TextView r11, TextPaint r12) {
            return new StaticLayout((CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin"), r12, r10, r9, r11.getLineSpacingMultiplier(), r11.getLineSpacingExtra(), r11.getIncludeFontPadding());
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static final class b {
        static boolean a(View r0) {
            return r0.isInLayout();
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static final class c {
        static StaticLayout a(CharSequence r2, Layout.Alignment r3, int r4, int r5, TextView r6, TextPaint r7, d r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            StaticLayout.Builder r10 = StaticLayout.Builder.obtain(r9, 0, r9.length(), r7, r4);
            StaticLayout.Builder r11 = r10.setAlignment(r3).setLineSpacing(r6.getLineSpacingExtra(), r6.getLineSpacingMultiplier()).setIncludePad(r6.getIncludeFontPadding()).setBreakStrategy(r6.getBreakStrategy()).setHyphenationFrequency(r6.getHyphenationFrequency());
            if (r5 != (-1)) goto L5;
            r5 = Integer.MAX_VALUE;
        L5:
            r11.setMaxLines(r5);
            r8.a(r10, r6);     // Catch: ClassCastException -> L8
        L10:
            return r10.build();
        L8:
            a(n.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            goto L10
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class d {
        void a(StaticLayout.Builder r1, TextView r2) {
        }

        d() {
        }

        boolean a(TextView r2) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(n.a(r2, "getHorizontallyScrolling", false), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class e extends d {
        e() {
        }

        @Override // androidx.appcompat.widget.n.d
        void a(StaticLayout.Builder r2, TextView r3) {
            r2.setTextDirection((TextDirectionHeuristic) ZeusTransformUtils.preCheckCast(n.a(r3, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR), TextDirectionHeuristic.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class f extends e {
        f() {
        }

        @Override // androidx.appcompat.widget.n.d
        boolean a(TextView r1) {
            return r1.isHorizontallyScrollable();
        }

        @Override // androidx.appcompat.widget.n.e, androidx.appcompat.widget.n.d
        void a(StaticLayout.Builder r1, TextView r2) {
            r1.setTextDirection(r2.getTextDirectionHeuristic());
        }
    }

    static {
        f463a = new RectF();
        f464b = new ConcurrentHashMap();
        f465c = new ConcurrentHashMap();
    }

    n(TextView r3) {
        this.f466d = 0;
        this.f467e = false;
        this.f = -1.0f;
        this.g = -1.0f;
        this.h = -1.0f;
        this.i = new int[0];
        this.j = false;
        this.l = r3;
        this.m = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L6;
        this.n = new f();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        this.n = new e();
        return;
    L8:
        this.n = new d();
    }

    void a(AttributeSet r11, int r12) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r13 = this.m.obtainStyledAttributes(r5, R.styleable.AppCompatTextView, r12, 0);
        TextView r2 = this.l;
        ViewCompat.a(r2, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.AppCompatTextView, r5, r13, r12, 0);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeTextType, "styleable", "AppCompatTextView_autoSizeTextType")) == false) goto L6;
        this.f466d = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeTextType, "styleable", "AppCompatTextView_autoSizeTextType"), 0);
    L6:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeStepGranularity, "styleable", "AppCompatTextView_autoSizeStepGranularity")) == false) goto L8;
        float r14 = r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeStepGranularity, "styleable", "AppCompatTextView_autoSizeStepGranularity"), -1.0f);
    L10:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMinTextSize, "styleable", "AppCompatTextView_autoSizeMinTextSize")) == false) goto L12;
        float r3 = r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMinTextSize, "styleable", "AppCompatTextView_autoSizeMinTextSize"), -1.0f);
    L14:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMaxTextSize, "styleable", "AppCompatTextView_autoSizeMaxTextSize")) == false) goto L16;
        float r4 = r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizeMaxTextSize, "styleable", "AppCompatTextView_autoSizeMaxTextSize"), -1.0f);
    L18:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizePresetSizes, "styleable", "AppCompatTextView_autoSizePresetSizes")) == false) goto L22;
        int r0 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_autoSizePresetSizes, "styleable", "AppCompatTextView_autoSizePresetSizes"), 0);
        if (r0 <= 0) goto L22;
        TypedArray r1 = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").obtainTypedArray(r0);
        a(r1);
        r1.recycle();
    L22:
        r13.recycle();
        if (k() == true) goto L25;
        this.f466d = 0;
        return;
    L25:
        if (this.f466d == 1) goto L27;
        return;
    L27:
        if (this.j == true) goto L38;
        DisplayMetrics r15 = ZeusTransformUtils.getResources(this.m, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r3 != (-1.0f)) goto L32;
        r3 = TypedValue.applyDimension(2, 12.0f, r15);
    L32:
        if (r4 != (-1.0f)) goto L35;
        r4 = TypedValue.applyDimension(2, 112.0f, r15);
    L35:
        if (r14 != (-1.0f)) goto L37;
        r14 = 1.0f;
    L37:
        a(r3, r4, r14);
    L38:
        i();
        return;
    L16:
        r4 = -1.0f;
        goto L18
    L12:
        r3 = -1.0f;
        goto L14
    L8:
        r14 = -1.0f;
        goto L10
    }

    void a(int r4) {
        if (k() == false) goto L14;
        if (r4 != 0) goto L6;
        j();
        return;
    L6:
        if (r4 != 1) goto L11;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.m, "com.obric.aiagent.plugin").getDisplayMetrics();
        a(TypedValue.applyDimension(2, 12.0f, r5), TypedValue.applyDimension(2, 112.0f, r5), 1.0f);
        if (i() == false) goto L15;
        f();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException("Unknown auto-size text type: " + r4);
    }

    void a(int r3, int r4, int r5, int r6) {
        if (k() == false) goto L8;
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this.m, "com.obric.aiagent.plugin").getDisplayMetrics();
        a(TypedValue.applyDimension(r6, r3, r0), TypedValue.applyDimension(r6, r4, r0), TypedValue.applyDimension(r6, r5, r0));
        if (i() == false) goto L9;
        f();
        return;
    L9:
        return;
    }

    void a(int[] r6, int r7) {
        if (k() == false) goto L23;
        int r0 = r6.length;
        int r1 = 0;
        if (r0 <= 0) goto L17;
        int[] r2 = new int[r0];
        if (r7 != 0) goto L9;
        r2 = Arrays.copyOf(r6, r0);
    L12:
        this.i = a(r2);
        if (h() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r6));
    L19:
        if (i() == false) goto L24;
        f();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r3 = ZeusTransformUtils.getResources(this.m, "com.obric.aiagent.plugin").getDisplayMetrics();
    L10:
        if (r1 >= r0) goto L12;
        r2[r1] = Math.round(TypedValue.applyDimension(r7, r6[r1], r3));
        r1 = r1 + 1;
        goto L10
    L17:
        this.j = false;
        goto L19
    }

    int a() {
        return this.f466d;
    }

    int b() {
        return Math.round(this.f);
    }

    int c() {
        return Math.round(this.g);
    }

    int d() {
        return Math.round(this.h);
    }

    int[] e() {
        return this.i;
    }

    private void a(TypedArray r5) {
        int r0 = r5.length();
        int[] r1 = new int[r0];
        if (r0 <= 0) goto L10;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r1[r2] = r5.getDimensionPixelSize(r2, -1);
        r2 = r2 + 1;
        goto L5
    L7:
        this.i = a(r1);
        h();
        return;
    }

    private boolean h() {
        int[] r0 = this.i;
        int r1 = r0.length;
        if (r1 <= 0) goto L5;
        boolean r4 = true;
    L6:
        this.j = r4;
        if (r4 == false) goto L9;
        this.f466d = 1;
        this.g = r0[0];
        this.h = r0[r1 - 1];
        this.f = -1.0f;
    L9:
        return r4;
    L5:
        r4 = false;
        goto L6
    }

    private int[] a(int[] r6) {
        int r5 = r6.length;
        if (r5 != 0) goto L5;
        return r6;
    L5:
        Arrays.sort(r6);
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L14;
        int r3 = r6[r2];
        if (r3 <= 0) goto L12;
        if (Collections.binarySearch(r0, Integer.valueOf(r3)) >= 0) goto L12;
        r0.add(Integer.valueOf(r3));
    L12:
        r2 = r2 + 1;
        goto L6
    L14:
        if (r5 != r0.size()) goto L16;
        return r6;
    L16:
        int r7 = r0.size();
        int[] r8 = new int[r7];
    L17:
        if (r1 >= r7) goto L19;
        r8[r1] = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r1), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r1 = r1 + 1;
        goto L17
    L19:
        return r8;
    }

    private void a(float r4, float r5, float r6) {
        if (r4 <= 0.0f) goto L15;
        if (r5 <= r4) goto L13;
        if (r6 <= 0.0f) goto L11;
        this.f466d = 1;
        this.g = r4;
        this.h = r5;
        this.f = r6;
        this.j = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r6 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r5 + "px) is less or equal to minimum auto-size text size (" + r4 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r4 + "px) is less or equal to (0px)");
    }

    private boolean i() {
        int r1 = 0;
        if (k() == true) goto L5;
    L15:
        this.f467e = false;
    L17:
        return this.f467e;
    L5:
        if (this.f466d != 1) goto L15;
        if (this.j == true) goto L9;
    L10:
        int r0 = ((int) Math.floor((this.h - this.g) / this.f)) + 1;
        int[] r3 = new int[r0];
    L11:
        if (r1 >= r0) goto L13;
        r3[r1] = Math.round(this.g + (r1 * this.f));
        r1 = r1 + 1;
        goto L11
    L13:
        this.i = a(r3);
    L14:
        this.f467e = true;
        goto L17
    L9:
        if (this.i.length != 0) goto L14;
        goto L10
    }

    void f() {
        if (g() == true) goto L6;
        return;
    L6:
        if (this.f467e == true) goto L8;
    L31:
        this.f467e = true;
        return;
    L8:
        if (this.l.getMeasuredHeight() > 0) goto L10;
        return;
    L10:
        if (this.l.getMeasuredWidth() > 0) goto L13;
        return;
    L13:
        if (this.n.a(this.l) == false) goto L15;
        int r0 = 1048576;
    L16:
        int r1 = (this.l.getHeight() - this.l.getCompoundPaddingBottom()) - this.l.getCompoundPaddingTop();
        if (r0 <= 0) goto L35;
        if (r1 <= 0) goto L37;
        RectF r2 = f463a;
        monitor-enter(r2);
        r2.setEmpty();     // Catch: Throwable -> L27
        r2.right = r0;     // Catch: Throwable -> L27
        r2.bottom = r1;     // Catch: Throwable -> L27
        float r3 = a(r2);     // Catch: Throwable -> L27
        if (r3 == this.l.getTextSize()) goto L25;
        a(0, r3);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L37:
        return;
    L35:
        return;
    L15:
        r0 = (this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft()) - this.l.getTotalPaddingRight();
        goto L16
    }

    private void j() {
        this.f466d = 0;
        this.g = -1.0f;
        this.h = -1.0f;
        this.f = -1.0f;
        this.i = new int[0];
        this.f467e = false;
    }

    void a(int r3, float r4) {
        Context r0 = this.m;
        if (r0 != null) goto L5;
        Resources r1 = Resources.getSystem();
    L6:
        a(TypedValue.applyDimension(r3, r4, r1.getDisplayMetrics()));
        return;
    L5:
        r1 = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin");
        goto L6
    }

    private void a(float r4) {
        if (r4 == this.l.getPaint().getTextSize()) goto L24;
        this.l.getPaint().setTextSize(r4);
        if (Build.VERSION.SDK_INT < 18) goto L7;
        boolean r5 = b.a(this.l);
    L9:
        if (this.l.getLayout() == null) goto L25;
        this.f467e = false;
        Method r0 = a("nullLayouts");     // Catch: Exception -> L15
        if (r0 == null) goto L17;
        r0.invoke(this.l, new Object[0]);     // Catch: Exception -> L15
    L17:
        if (r5 == true) goto L19;
        this.l.requestLayout();
    L20:
        this.l.invalidate();
        return;
    L19:
        this.l.forceLayout();
    L15:
        e = move-exception;
        a(TAG, "Failed to invoke TextView#nullLayouts() method", e);
        goto L17
    L25:
        return;
    L7:
        r5 = false;
        goto L9
    }

    private int a(RectF r6) {
        int r0 = this.i.length;
        if (r0 == 0) goto L14;
        int r1 = 0;
        int r2 = 1;
        int r3 = r0 - 1;
    L5:
        int r4 = r2;
        int r5 = r1;
        r1 = r4;
    L6:
        if (r1 > r3) goto L12;
        int r7 = (r1 + r3) / 2;
        if (a(this.i[r7], r6) == true) goto L9;
        r5 = r7 - 1;
        r3 = r5;
        goto L6
    L9:
        r2 = r7 + 1;
        goto L5
    L12:
        return this.i[r5];
    L14:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    void b(int r3) {
        TextPaint r0 = this.k;
        if (r0 != null) goto L5;
        this.k = new TextPaint();
    L6:
        this.k.set(this.l.getPaint());
        this.k.setTextSize(r3);
        return;
    L5:
        r0.reset();
        goto L6
    }

    StaticLayout a(CharSequence r8, Layout.Alignment r9, int r10, int r11) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return c.a(r0, r9, r10, r11, this.l, this.k, this.n);
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L11;
        return a.a(r0, r9, r10, this.l, this.k);
    L11:
        return a(r0, r9, r10);
    }

    private boolean a(int r6, RectF r7) {
        CharSequence r0 = this.l.getText();
        TransformationMethod r1 = this.l.getTransformationMethod();
        if (r1 == null) goto L8;
        CharSequence r2 = r1.getTransformation(r0, this.l);
        if (r2 == null) goto L8;
        r0 = r2;
    L8:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        int r3 = a.a(this.l);
    L11:
        b(r6);
        StaticLayout r5 = a(r0, (Layout.Alignment) ZeusTransformUtils.preCheckCast(a(this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Layout.Alignment.class, "com.obric.aiagent.plugin"), Math.round(r7.right), r3);
        if (r3 == (-1)) goto L19;
        if (r5.getLineCount() <= r3) goto L16;
    L17:
        return false;
    L16:
        if (r5.getLineEnd(r5.getLineCount() - 1) != r0.length()) goto L17;
    L19:
        if (r5.getHeight() <= r7.bottom) goto L21;
        return false;
    L21:
        return true;
    L10:
        r3 = -1;
        goto L11
    }

    private StaticLayout a(CharSequence r11, Layout.Alignment r12, int r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        float r7 = ((Float) ZeusTransformUtils.preCheckCast(b(this.l, "mSpacingMult", Float.valueOf(1.0f)), Float.class, "com.obric.aiagent.plugin")).floatValue();
        float r8 = ((Float) ZeusTransformUtils.preCheckCast(b(this.l, "mSpacingAdd", Float.valueOf(0.0f)), Float.class, "com.obric.aiagent.plugin")).floatValue();
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(b(this.l, "mIncludePad", true), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        return new StaticLayout(r3, this.k, r13, r12, r7, r8, r9);
    }

    static <T> T a(Object r4, String r5, T r6) {
    L15:
        return (T) a(r5).invoke(r4, new Object[0]);
    L7:
        e = move-exception;
        a(TAG, "Failed to invoke TextView#" + r5 + "() method", e);     // Catch: Throwable -> L5
        return r6;
    L5:
        th = move-exception;
        throw th;
    }

    private static <T> T b(Object r2, String r3, T r4) {
        Field r0 = b(r3);     // Catch: IllegalAccessException -> L7
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (T) r0.get(r2);
    L7:
        e = move-exception;
        a(TAG, "Failed to access TextView#" + r3 + " member", e);
        return r4;
    }

    private static Method a(String r3) {
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(f464b.get(r3), Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        if (r0 != null) goto L7;
        r0 = TextView.class.getDeclaredMethod(r3, new Class[0]);     // Catch: Exception -> L8
        if (r0 == null) goto L7;
        r0.setAccessible(true);     // Catch: Exception -> L8
        f464b.put(r3, r0);     // Catch: Exception -> L8
    L7:
        return r0;
    L8:
        e = move-exception;
        a(TAG, "Failed to retrieve TextView#" + r3 + "() method", e);
        return null;
    }

    private static Field b(String r3) {
        Field r0 = (Field) ZeusTransformUtils.preCheckCast(f465c.get(r3), Field.class, "com.obric.aiagent.plugin");     // Catch: NoSuchFieldException -> L8
        if (r0 != null) goto L7;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L8
        if (r0 == null) goto L7;
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        f465c.put(r3, r0);     // Catch: NoSuchFieldException -> L8
    L7:
        return r0;
    L8:
        e = move-exception;
        a(TAG, "Failed to access TextView#" + r3 + " member", e);
        return null;
    }

    boolean g() {
        if (k() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f466d == 0) goto L7;
        return true;
    }

    private boolean k() {
        return !ZeusTransformUtils.instanceOf(this.l, AppCompatEditText.class);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
