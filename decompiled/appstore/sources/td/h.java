package td;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.l;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f24801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f24802b = 0.0f;

    static {
        f24801a = new h();
        f24802b = 1.2f;
    }

    public h() {
    }

    public static final int a(int r10, float r11) {
        if (r11 != 1.0f) goto L5;
        return r10;
    L5:
        float r12 = bg.h.j(r11, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r10) * r12), Color.red(r10), Color.green(r10), Color.blue(r10));
    }

    public static final boolean g(float r10) {
        if (r10 < f24802b) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void h(View r10, Function1 r11) {
        q.g(r11, "visitor");
        if (r10 != null) goto L6;
        return;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L14;
        ViewGroup r12 = (ViewGroup) r10;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L18;
        int r15 = r14 + 1;
        View r16 = r12.getChildAt(r14);
        if (r16 == null) goto L13;
        r11.invoke(r16);
    L13:
        r14 = r15;
        goto L8
    L18:
        return;
    }

    public final void b(Context r10, int r11, Shadow r12) {
        q.g(r10, "context");
        q.g(r12, "baseShadow");
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OUILayout);
        q.f(r13, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        e(r13, r12, R$styleable.OUILayout_oui_firstShadowColor, R$styleable.OUILayout_oui_firstShadowBlur, R$styleable.OUILayout_oui_firstOffsetX, R$styleable.OUILayout_oui_firstOffsetY, R$styleable.OUILayout_oui_firstShadowSpread);
        r13.recycle();
    }

    public final void c(Canvas r10, Shadow r11, RectF r12, float r13) {
        q.g(r10, "canvas");
        q.g(r11, "shadow");
        q.g(r12, "rect");
        if (r11.e() <= 0.0f) goto L5;
        r13 = r11.e();
    L5:
        Path r14 = new Path();
        l.f13087a.a(r14, r12, r13);
        int r15 = r10.save();
        RectF r16 = new RectF(r12);
        r16.offset(r11.f(), r11.g());
        r16.inset(-r11.j(), -r11.j());
        r10.clipOutPath(r14);
        r11.h().setColor(r11.d());
        if (r11.i() <= 0.0f) goto L8;
        r11.h().setMaskFilter(new BlurMaskFilter(r11.i(), BlurMaskFilter.Blur.NORMAL));
    L8:
        l.i(r10, r16, r13, r11.h());
        r10.restoreToCount(r15);
    }

    public final ViewGroup d(Activity r10) {
        q.g(r10, "activity");
        return (ViewGroup) r10.getWindow().getDecorView().findViewById(R.id.content);
    L5:
        e = move-exception;
        L.c("ViewUtil", "getActivityContentView, error", e);
        return null;
    }

    public final void e(TypedArray r10, Shadow r11, int r12, int r13, int r14, int r15, int r16) {
        if (r11 != null) goto L4;
        return;
    L4:
        r11.l(r10.getColor(r12, Color.parseColor(Style.DEFAULT_BG_COLOR)));
        r11.o(r10.getDimension(r13, 0.0f));
        r11.m(r10.getDimension(r14, 0.0f));
        r11.n(r10.getDimension(r15, 0.0f));
        r11.p(r10.getDimension(r16, 0.0f));
    }

    public final boolean f(View r10, MotionEvent r11) {
        q.g(r10, "<this>");
        q.g(r11, "ev");
        float r12 = r11.getRawX();
        float r13 = r11.getRawY();
        int[] r14 = new int[2];
        r10.getLocationOnScreen(r14);
        int r15 = r14[0];
        if (r12 < r15) goto L11;
        if (r13 < r14[1]) goto L11;
        if (r12 > (r15 + r10.getWidth())) goto L11;
        if (r13 > (r14[1] + r10.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }
}
