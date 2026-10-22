package c29;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f22219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f22220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GradientDrawable f22221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GradientDrawable f22222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Integer> f22224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22233o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f22234p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f22235q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f22236r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f22237s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f22238t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f22239u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float[] f22240v;

    /* JADX INFO: renamed from: c29.a$a, reason: collision with other inner class name */
    public static final class C0395a {
    }

    static {
    }

    public final void c() {
        StateListDrawable r100 = new StateListDrawable();
        if (this.f22237s == true) goto L5;
        f(this.f22221c, this.f22223e, this.f22232n, this.f22224f);
        r100.addState(new int[]{-16842919}, this.f22221c);
        int r101 = this.f22225g;
        if (r101 == Integer.MAX_VALUE) goto L12;
    L13:
        GradientDrawable r102 = this.f22222d;
        if (r101 != Integer.MAX_VALUE) goto L16;
        int r103 = this.f22223e;
    L17:
        int r110 = this.f22233o;
        if (r110 != Integer.MAX_VALUE) goto L20;
        r110 = this.f22232n;
    L20:
        if (r101 != Integer.MAX_VALUE) goto L22;
        List<Integer> r104 = this.f22224f;
    L23:
        f(r102, r103, r110, r104);
        r100.addState(new int[]{R.attr.state_pressed}, this.f22222d);
    L24:
        this.f22219a.setBackground(r100);
    L25:
        View r105 = this.f22219a;
        if ((r105 instanceof TextView) == true) goto L28;
        return;
    L28:
        if (this.f22234p == Integer.MAX_VALUE) goto L32;
        ColorStateList r106 = ((TextView) r105).getTextColors();
        ((TextView) this.f22219a).setTextColor(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{R.attr.state_pressed}}, new int[]{r106.getDefaultColor(), this.f22234p}));
        return;
    L32:
        return;
    L22:
        r104 = CollectionsKt.emptyList();
        goto L23
    L16:
        r103 = r101;
        goto L17
    L12:
        if (this.f22233o == Integer.MAX_VALUE) goto L24;
    L5:
        if (this.f22238t == false) goto L7;
        f(this.f22221c, this.f22223e, 0, this.f22224f);
        GradientDrawable r107 = new GradientDrawable();
        r107.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        f(r107, this.f22223e, 0, CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f22239u), Integer.valueOf(this.f22239u)}));
        LayerDrawable r108 = new LayerDrawable(new GradientDrawable[]{this.f22221c, r107});
        int r111 = this.f22231m;
        r108.setLayerInset(1, r111, r111, r111, r111);
        Drawable r109 = r108;
    L8:
        int r112 = this.f22223e;
        int r113 = this.f22225g;
        this.f22219a.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_activated}, new int[0]}, new int[]{r113, r113, r113, r112}), r109, null));
        goto L25
    L7:
        f(this.f22221c, this.f22223e, this.f22232n, this.f22224f);
        r109 = this.f22221c;
        goto L8
    }

    public final void a(int r100) {
        this.f22223e = r100;
        this.f22224f = CollectionsKt.emptyList();
        c();
    }

    public final void b(int r100) {
        this.f22225g = r100;
        c();
    }

    public final void d(int r100) {
        Resources r101 = this.f22220b.getResources();
        this.f22226h = (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
        c();
    }

    public final void e(int r100) {
        this.f22226h = r100;
        c();
    }

    public final void g(int r100) {
        this.f22232n = r100;
        c();
    }

    public final void h(int r100) {
        this.f22233o = r100;
        c();
    }

    public final void i(int r100) {
        this.f22231m = r100;
        c();
    }

    public final void j(int r100) {
        this.f22234p = r100;
        c();
    }

    public a(View r100, Context r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f22219a = r100;
        this.f22220b = r101;
        this.f22221c = new GradientDrawable();
        this.f22222d = new GradientDrawable();
        this.f22224f = CollectionsKt.emptyList();
        this.f22240v = new float[8];
        if (r102 == null) goto L24;
        TypedArray r103 = r101.obtainStyledAttributes(r102, new int[]{com.larus.nova.R.attr.rv_backgroundColor, com.larus.nova.R.attr.rv_backgroundPressColor, com.larus.nova.R.attr.rv_cornerRadius, com.larus.nova.R.attr.rv_cornerRadius_BL, com.larus.nova.R.attr.rv_cornerRadius_BR, com.larus.nova.R.attr.rv_cornerRadius_TL, com.larus.nova.R.attr.rv_cornerRadius_TR, com.larus.nova.R.attr.rv_isRadiusHalfHeight, com.larus.nova.R.attr.rv_isRippleEnable, com.larus.nova.R.attr.rv_isWidthHeightEqual, com.larus.nova.R.attr.rv_strokeColor, com.larus.nova.R.attr.rv_strokePressColor, com.larus.nova.R.attr.rv_strokeWidth, com.larus.nova.R.attr.rv_textPressColor});
        this.f22223e = r103.getColor(0, 0);
        this.f22225g = r103.getColor(1, -1);
        this.f22226h = r103.getDimensionPixelSize(2, 0);
        this.f22231m = r103.getDimensionPixelSize(12, 0);
        this.f22232n = r103.getColor(10, 0);
        this.f22233o = r103.getColor(11, -1);
        this.f22234p = r103.getColor(13, -1);
        this.f22235q = r103.getBoolean(7, false);
        this.f22236r = r103.getBoolean(9, false);
        this.f22227i = r103.getDimensionPixelSize(5, 0);
        this.f22228j = r103.getDimensionPixelSize(6, 0);
        this.f22229k = r103.getDimensionPixelSize(3, 0);
        this.f22230l = r103.getDimensionPixelSize(4, 0);
        this.f22237s = r103.getBoolean(8, true);
        if (this.f22225g != (-1)) goto L8;
        this.f22225g = this.f22223e;
    L8:
        if (this.f22233o != (-1)) goto L11;
        this.f22233o = this.f22232n;
    L11:
        if (this.f22234p == (-1)) goto L13;
    L22:
        r103.recycle();
        return;
    L13:
        if ((r100 instanceof TextView) == false) goto L15;
        TextView r104 = (TextView) r100;
    L16:
        if (r104 == null) goto L20;
        ColorStateList r105 = r104.getTextColors();
        if (r105 == null) goto L20;
        int r106 = r105.getDefaultColor();
    L21:
        this.f22234p = r106;
    L20:
        r106 = Integer.MAX_VALUE;
        goto L21
    L15:
        r104 = null;
        goto L16
    }

    public final void f(GradientDrawable r100, int r101, int r102, List<Integer> r103) {
        if (r103.isEmpty() == false) goto L5;
    L8:
        r100.setColors(new int[]{r101, r101});
    L9:
        int r104 = this.f22227i;
        if (r104 <= 0) goto L12;
    L19:
        float[] r105 = this.f22240v;
        float r106 = r104;
        r105[0] = r106;
        r105[1] = r106;
        float r107 = this.f22228j;
        r105[2] = r107;
        r105[3] = r107;
        float r108 = this.f22230l;
        r105[4] = r108;
        r105[5] = r108;
        float r109 = this.f22229k;
        r105[6] = r109;
        r105[7] = r109;
        r100.setCornerRadii(r105);
    L20:
        r100.setStroke(this.f22231m, r102);
        return;
    L12:
        if (this.f22228j > 0) goto L19;
        if (this.f22230l > 0) goto L19;
        if (this.f22229k > 0) goto L19;
        r100.setCornerRadius(this.f22226h);
        goto L20
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r100.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r100.setColors(CollectionsKt.toIntArray(r103));
        goto L9
    }
}
