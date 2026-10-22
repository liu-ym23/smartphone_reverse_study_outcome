package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.obric.capabilitykit.common.UiType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f1071l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap f1072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ConcurrentHashMap f1073n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f1079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f1081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f1082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f1083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f1084k;

    public static final class a {
        @NonNull
        @DoNotInline
        public static StaticLayout a(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, @NonNull TextView r13, @NonNull TextPaint r14) {
            return new StaticLayout(r10, r14, r12, r11, r13.getLineSpacingMultiplier(), r13.getLineSpacingExtra(), r13.getIncludeFontPadding());
        }

        @DoNotInline
        public static int b(@NonNull TextView r10) {
            return r10.getMaxLines();
        }
    }

    public static final class b {
        @DoNotInline
        public static boolean a(@NonNull View r10) {
            return r10.isInLayout();
        }
    }

    public static final class c {
        @NonNull
        @DoNotInline
        public static StaticLayout a(@NonNull CharSequence r10, @NonNull Layout.Alignment r11, int r12, int r13, @NonNull TextView r14, @NonNull TextPaint r15, @NonNull f r16) {
            StaticLayout.Builder r17 = StaticLayout.Builder.obtain(r10, 0, r10.length(), r15, r12);
            StaticLayout.Builder r18 = r17.setAlignment(r11).setLineSpacing(r14.getLineSpacingExtra(), r14.getLineSpacingMultiplier()).setIncludePad(r14.getIncludeFontPadding()).setBreakStrategy(r14.getBreakStrategy()).setHyphenationFrequency(r14.getHyphenationFrequency());
            if (r13 != (-1)) goto L5;
            r13 = Channel.UNLIMITED;
        L5:
            r18.setMaxLines(r13);
            r16.a(r17, r14);     // Catch: ClassCastException -> L8
        L10:
            return r17.build();
        L8:
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            goto L10
        }
    }

    public static class d extends f {
        public d() {
        }
    }

    public static class e extends d {
        public e() {
        }

        @Override // androidx.appcompat.widget.q.f
        public void a(StaticLayout.Builder r10, TextView r11) {
            r10.setTextDirection(r11.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.q.f
        public boolean b(TextView r10) {
            return r10.isHorizontallyScrollable();
        }
    }

    public static class f {
        public f() {
        }

        public abstract void a(StaticLayout.Builder r10, TextView r11);

        public abstract boolean b(TextView r10);
    }

    static {
        f1071l = new RectF();
        f1072m = new ConcurrentHashMap();
        f1073n = new ConcurrentHashMap();
    }

    public q(TextView r10) {
        this.f1074a = 0;
        this.f1075b = false;
        this.f1076c = -1.0f;
        this.f1077d = -1.0f;
        this.f1078e = -1.0f;
        this.f1079f = new int[0];
        this.f1080g = false;
        this.f1082i = r10;
        this.f1083j = r10.getContext();
        this.f1084k = new e();
    }

    public static Method k(String r10) {
        Method r11 = (Method) f1072m.get(r10);     // Catch: Exception -> L9
        if (r11 != null) goto L11;
        r11 = TextView.class.getDeclaredMethod(r10, null);     // Catch: Exception -> L9
        if (r11 == null) goto L11;
        r11.setAccessible(true);     // Catch: Exception -> L9
        f1072m.put(r10, r11);     // Catch: Exception -> L9
    L11:
        return r11;
    L9:
        e = move-exception;
        Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + r10 + "() method", e);
        return null;
    }

    public static Object m(Object r10, String r11, Object r12) {
    L13:
        return k(r11).invoke(r10, null);
    L6:
        e = move-exception;
        Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + r11 + "() method", e);
        return r12;
    L4:
        th = move-exception;
        throw th;
    }

    public void a() {
        if (n() == true) goto L6;
        return;
    L6:
        if (this.f1075b == true) goto L8;
    L32:
        this.f1075b = true;
        return;
    L8:
        if (this.f1082i.getMeasuredHeight() > 0) goto L10;
        return;
    L10:
        if (this.f1082i.getMeasuredWidth() > 0) goto L13;
        return;
    L13:
        if (this.f1084k.b(this.f1082i) == false) goto L15;
        int r10 = UiType.FLAG_APP_CHOOSER_CARD;
    L16:
        int r11 = (this.f1082i.getHeight() - this.f1082i.getCompoundPaddingBottom()) - this.f1082i.getCompoundPaddingTop();
        if (r10 <= 0) goto L36;
        if (r11 <= 0) goto L38;
        RectF r12 = f1071l;
        monitor-enter(r12);
        r12.setEmpty();     // Catch: Throwable -> L25
        r12.right = r10;     // Catch: Throwable -> L25
        r12.bottom = r11;     // Catch: Throwable -> L25
        float r13 = e(r12);     // Catch: Throwable -> L25
        if (r13 == this.f1082i.getTextSize()) goto L27;
        t(0, r13);     // Catch: Throwable -> L25
    L27:
        monitor-exit(r12);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L38:
        return;
    L36:
        return;
    L15:
        r10 = (this.f1082i.getMeasuredWidth() - this.f1082i.getTotalPaddingLeft()) - this.f1082i.getTotalPaddingRight();
        goto L16
    }

    public final int[] b(int[] r10) {
        int r11 = r10.length;
        if (r11 != 0) goto L5;
        return r10;
    L5:
        Arrays.sort(r10);
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L14;
        int r15 = r10[r14];
        if (r15 <= 0) goto L12;
        if (Collections.binarySearch(r12, Integer.valueOf(r15)) >= 0) goto L12;
        r12.add(Integer.valueOf(r15));
    L12:
        r14 = r14 + 1;
        goto L6
    L14:
        if (r11 != r12.size()) goto L16;
        return r10;
    L16:
        int r16 = r12.size();
        int[] r17 = new int[r16];
    L17:
        if (r13 >= r16) goto L19;
        r17[r13] = ((Integer) r12.get(r13)).intValue();
        r13 = r13 + 1;
        goto L17
    L19:
        return r17;
    }

    public final void c() {
        this.f1074a = 0;
        this.f1077d = -1.0f;
        this.f1078e = -1.0f;
        this.f1076c = -1.0f;
        this.f1079f = new int[0];
        this.f1075b = false;
    }

    public StaticLayout d(CharSequence r10, Layout.Alignment r11, int r12, int r13) {
        return c.a(r10, r11, r12, r13, this.f1082i, this.f1081h, this.f1084k);
    }

    public final int e(RectF r10) {
        int r11 = this.f1079f.length;
        if (r11 == 0) goto L13;
        int r12 = 1;
        int r13 = r11 - 1;
        int r14 = 0;
    L5:
        if (r12 > r13) goto L11;
        int r15 = (r12 + r13) / 2;
        if (x(this.f1079f[r15], r10) == true) goto L8;
        r14 = r15 - 1;
        r13 = r14;
        goto L5
    L8:
        int r16 = r15 + 1;
        r14 = r12;
        r12 = r16;
        goto L5
    L11:
        return this.f1079f[r14];
    L13:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public int f() {
        return Math.round(this.f1078e);
    }

    public int g() {
        return Math.round(this.f1077d);
    }

    public int h() {
        return Math.round(this.f1076c);
    }

    public int[] i() {
        return this.f1079f;
    }

    public int j() {
        return this.f1074a;
    }

    public void l(int r10) {
        TextPaint r11 = this.f1081h;
        if (r11 != null) goto L5;
        this.f1081h = new TextPaint();
    L6:
        this.f1081h.set(this.f1082i.getPaint());
        this.f1081h.setTextSize(r10);
        return;
    L5:
        r11.reset();
        goto L6
    }

    public boolean n() {
        if (y() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1074a == 0) goto L7;
        return true;
    }

    public void o(AttributeSet r10, int r11) {
        Context r12 = this.f1083j;
        int[] r13 = R$styleable.AppCompatTextView;
        TypedArray r14 = r12.obtainStyledAttributes(r10, r13, r11, 0);
        TextView r15 = this.f1082i;
        ViewCompat.n0(r15, r15.getContext(), r13, r10, r14, r11, 0);
        int r16 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (r14.hasValue(r16) == false) goto L5;
        this.f1074a = r14.getInt(r16, 0);
    L5:
        int r17 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        if (r14.hasValue(r17) == false) goto L8;
        float r18 = r14.getDimension(r17, -1.0f);
    L9:
        int r19 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        if (r14.hasValue(r19) == false) goto L12;
        float r110 = r14.getDimension(r19, -1.0f);
    L13:
        int r20 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (r14.hasValue(r20) == false) goto L16;
        float r21 = r14.getDimension(r20, -1.0f);
    L17:
        int r22 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (r14.hasValue(r22) == false) goto L22;
        int r23 = r14.getResourceId(r22, 0);
        if (r23 <= 0) goto L22;
        TypedArray r24 = r14.getResources().obtainTypedArray(r23);
        v(r24);
        r24.recycle();
    L22:
        r14.recycle();
        if (y() == true) goto L25;
        this.f1074a = 0;
        return;
    L25:
        if (this.f1074a == 1) goto L27;
        return;
    L27:
        if (this.f1080g == true) goto L38;
        DisplayMetrics r25 = this.f1083j.getResources().getDisplayMetrics();
        if (r110 != (-1.0f)) goto L32;
        r110 = TypedValue.applyDimension(2, 12.0f, r25);
    L32:
        if (r21 != (-1.0f)) goto L35;
        r21 = TypedValue.applyDimension(2, 112.0f, r25);
    L35:
        if (r18 != (-1.0f)) goto L37;
        r18 = 1.0f;
    L37:
        z(r110, r21, r18);
    L38:
        u();
        return;
    L16:
        r21 = -1.0f;
        goto L17
    L12:
        r110 = -1.0f;
        goto L13
    L8:
        r18 = -1.0f;
        goto L9
    }

    public void p(int r10, int r11, int r12, int r13) {
        if (y() == false) goto L8;
        DisplayMetrics r14 = this.f1083j.getResources().getDisplayMetrics();
        z(TypedValue.applyDimension(r13, r10, r14), TypedValue.applyDimension(r13, r11, r14), TypedValue.applyDimension(r13, r12, r14));
        if (u() == false) goto L9;
        a();
        return;
    L9:
        return;
    }

    public void q(int[] r10, int r11) {
        if (y() == false) goto L23;
        int r12 = r10.length;
        int r13 = 0;
        if (r12 <= 0) goto L17;
        int[] r14 = new int[r12];
        if (r11 != 0) goto L9;
        r14 = Arrays.copyOf(r10, r12);
    L12:
        this.f1079f = b(r14);
        if (w() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r10));
    L19:
        if (u() == false) goto L24;
        a();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r15 = this.f1083j.getResources().getDisplayMetrics();
    L10:
        if (r13 >= r12) goto L12;
        r14[r13] = Math.round(TypedValue.applyDimension(r11, r10[r13], r15));
        r13 = r13 + 1;
        goto L10
    L17:
        this.f1080g = false;
        goto L19
    }

    public void r(int r10) {
        if (y() == false) goto L14;
        if (r10 != 0) goto L6;
        c();
        return;
    L6:
        if (r10 != 1) goto L11;
        DisplayMetrics r11 = this.f1083j.getResources().getDisplayMetrics();
        z(TypedValue.applyDimension(2, 12.0f, r11), TypedValue.applyDimension(2, 112.0f, r11), 1.0f);
        if (u() == false) goto L15;
        a();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException("Unknown auto-size text type: " + r10);
    }

    public final void s(float r10) {
        if (r10 == this.f1082i.getPaint().getTextSize()) goto L20;
        this.f1082i.getPaint().setTextSize(r10);
        boolean r11 = b.a(this.f1082i);
        if (this.f1082i.getLayout() == null) goto L21;
        this.f1075b = false;
        Method r12 = k("nullLayouts");     // Catch: Exception -> L11
        if (r12 == null) goto L13;
        r12.invoke(this.f1082i, null);     // Catch: Exception -> L11
    L13:
        if (r11 == true) goto L15;
        this.f1082i.requestLayout();
    L16:
        this.f1082i.invalidate();
        return;
    L15:
        this.f1082i.forceLayout();
    L11:
        e = move-exception;
        Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
        goto L13
    L21:
        return;
    }

    public void t(int r10, float r11) {
        Context r12 = this.f1083j;
        if (r12 != null) goto L5;
        Resources r13 = Resources.getSystem();
    L6:
        s(TypedValue.applyDimension(r10, r11, r13.getDisplayMetrics()));
        return;
    L5:
        r13 = r12.getResources();
        goto L6
    }

    public final boolean u() {
        int r10 = 0;
        if (y() == true) goto L5;
    L15:
        this.f1075b = false;
    L17:
        return this.f1075b;
    L5:
        if (this.f1074a != 1) goto L15;
        if (this.f1080g == true) goto L9;
    L10:
        int r11 = ((int) Math.floor((this.f1078e - this.f1077d) / this.f1076c)) + 1;
        int[] r12 = new int[r11];
    L11:
        if (r10 >= r11) goto L13;
        r12[r10] = Math.round(this.f1077d + (r10 * this.f1076c));
        r10 = r10 + 1;
        goto L11
    L13:
        this.f1079f = b(r12);
    L14:
        this.f1075b = true;
        goto L17
    L9:
        if (this.f1079f.length != 0) goto L14;
        goto L10
    }

    public final void v(TypedArray r10) {
        int r11 = r10.length();
        int[] r12 = new int[r11];
        if (r11 <= 0) goto L10;
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L7;
        r12[r13] = r10.getDimensionPixelSize(r13, -1);
        r13 = r13 + 1;
        goto L5
    L7:
        this.f1079f = b(r12);
        w();
        return;
    }

    public final boolean w() {
        int[] r10 = this.f1079f;
        int r11 = r10.length;
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        this.f1080g = r12;
        if (r12 == false) goto L9;
        this.f1074a = 1;
        this.f1077d = r10[0];
        this.f1078e = r10[r11 - 1];
        this.f1076c = -1.0f;
    L9:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    public final boolean x(int r10, RectF r11) {
        CharSequence r12 = this.f1082i.getText();
        TransformationMethod r13 = this.f1082i.getTransformationMethod();
        if (r13 == null) goto L7;
        CharSequence r14 = r13.getTransformation(r12, this.f1082i);
        if (r14 == null) goto L7;
        r12 = r14;
    L7:
        int r15 = a.b(this.f1082i);
        l(r10);
        StaticLayout r16 = d(r12, (Layout.Alignment) m(this.f1082i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(r11.right), r15);
        if (r15 == (-1)) goto L15;
        if (r16.getLineCount() <= r15) goto L12;
    L13:
        return false;
    L12:
        if (r16.getLineEnd(r16.getLineCount() - 1) != r12.length()) goto L13;
    L15:
        if (r16.getHeight() <= r11.bottom) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean y() {
        return !(this.f1082i instanceof AppCompatEditText);
    }

    public final void z(float r10, float r11, float r12) {
        if (r10 <= 0.0f) goto L15;
        if (r11 <= r10) goto L13;
        if (r12 <= 0.0f) goto L11;
        this.f1074a = 1;
        this.f1077d = r10;
        this.f1078e = r11;
        this.f1076c = r12;
        this.f1080g = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r12 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r11 + "px) is less or equal to minimum auto-size text size (" + r10 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r10 + "px) is less or equal to (0px)");
    }
}
