package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.b2;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public class RealtimeBlurView extends View {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f168007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final StopException f168008q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f168009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f168010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f168011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f168012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f168013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f168014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f168015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Canvas f168016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f168017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f168018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f168019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f168020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f168021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f168022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f168023o;

    public static class StopException extends RuntimeException {
        private StopException() {
        }

        public /* synthetic */ StopException(a r100) {
            this();
        }
    }

    public class a implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f168024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RealtimeBlurView f168025b;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RealtimeBlurView r100 = this.f168025b;
            f.a r101 = f.f168043g;
            Context r102 = this.f168024a;
            r101.getClass();
            r100.f168012d = f.a.b(r102);
            return null;
        }

        public a(RealtimeBlurView r100, Context r101) {
            this.f168025b = r100;
            this.f168024a = r101;
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeBlurView f168026a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            int[] r100 = new int[2];
            RealtimeBlurView r101 = this.f168026a;
            Bitmap r102 = r101.f168015g;
            View r103 = r101.f168021m;
            if (r103 != null) goto L5;
        L64:
            return true;
        L5:
            if (r101.isShown() == false) goto L64;
            RealtimeBlurView r104 = this.f168026a;
            if (r104.f168012d == null) goto L42;
            float r105 = r104.f168011c;
            if (r105 != 0.0f) goto L12;
            r104.a();
            goto L42
        L12:
            float r106 = r104.f168009a;
            if (r106 != 0.0f) goto L15;
            r106 = 4.0f;
        L15:
            float r107 = r105 / r106;
            if (r107 <= 25.0f) goto L18;
            r106 = (r106 * r107) / 25.0f;
            r107 = 25.0f;
        L18:
            int r108 = r104.getWidth();
            int r109 = r104.getHeight();
            int r110 = Math.max(1, (int) (r108 / r106));
            int r111 = Math.max(1, (int) (r109 / r106));
            boolean r112 = r104.f168013e;
            if (r104.f168016h == null) goto L26;
            Bitmap r113 = r104.f168015g;
            if (r113 == null) goto L26;
            if (r113.getWidth() != r110) goto L26;
            if (r104.f168015g.getHeight() != r111) goto L26;
        L34:
            if (r112 == false) goto L40;
            e r114 = r104.f168012d;
            if (r114 == null) goto L40;
            if (r114.a(r104.getContext(), r104.f168014f, r107) == false) goto L42;
            r104.f168013e = false;
        L40:
            boolean r115 = true;
        L43:
            if (r115 == false) goto L64;
            if (this.f168026a.f168015g == r102) goto L47;
            boolean r116 = true;
        L48:
            r103.getLocationOnScreen(r100);
            int r117 = -r100[0];
            int r118 = -r100[1];
            this.f168026a.getLocationOnScreen(r100);
            int r119 = r117 + r100[0];
            int r120 = r118 + r100[1];
            RealtimeBlurView r121 = this.f168026a;
            r121.f168014f.eraseColor(r121.f168010b & 16777215);
            int r122 = this.f168026a.f168016h.save();
            RealtimeBlurView r123 = this.f168026a;
            r123.f168017i = true;
            RealtimeBlurView.f168007p++;
            r123.f168016h.scale((r123.f168014f.getWidth() * 1.0f) / this.f168026a.getWidth(), (this.f168026a.f168014f.getHeight() * 1.0f) / this.f168026a.getHeight());     // Catch: StopException -> L65 Throwable -> L54
            this.f168026a.f168016h.translate(-r119, -r120);     // Catch: StopException -> L65 Throwable -> L54
            if (r103.getBackground() == null) goto L52;
            r103.getBackground().draw(this.f168026a.f168016h);     // Catch: StopException -> L65 Throwable -> L54
        L52:
            r103.draw(this.f168026a.f168016h);     // Catch: StopException -> L65 Throwable -> L54
        L54:
            th = move-exception;
            RealtimeBlurView r124 = this.f168026a;
            r124.f168017i = false;
            RealtimeBlurView.f168007p--;
            r124.f168016h.restoreToCount(r122);
            throw th;
        L53:
            RealtimeBlurView r125 = this.f168026a;
            r125.f168017i = false;
            RealtimeBlurView.f168007p--;
            r125.f168016h.restoreToCount(r122);
            RealtimeBlurView r126 = this.f168026a;
            Bitmap r127 = r126.f168014f;
            Bitmap r128 = r126.f168015g;
            e r129 = r126.f168012d;
            if (r129 == null) goto L60;
            r129.b(r127, r128);
        L60:
            if (r116 == false) goto L62;
        L63:
            this.f168026a.invalidate();
            goto L64
        L62:
            if (this.f168026a.f168022n == false) goto L64;
        L47:
            r116 = false;
        L26:
            r104.b();
            Bitmap r130 = Bitmap.createBitmap(r110, r111, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L66
            r104.f168014f = r130;     // Catch: Throwable -> L66
            if (r130 == null) goto L41;
            r104.f168016h = new Canvas(r104.f168014f);     // Catch: Throwable -> L66
            Bitmap r131 = Bitmap.createBitmap(r110, r111, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L66
            r104.f168015g = r131;     // Catch: Throwable -> L66
            if (r131 == null) goto L41;
            r112 = true;
        L41:
            r104.a();
        L42:
            r115 = false;
            goto L43
        }

        public b(RealtimeBlurView r100) {
            this.f168026a = r100;
        }
    }

    static {
        f168008q = new StopException(null);
    }

    public final void b() {
        Bitmap r100 = this.f168014f;
        if (r100 == null) goto L5;
        r100.recycle();
        this.f168014f = null;
    L5:
        Bitmap r101 = this.f168015g;
        if (r101 == null) goto L9;
        r101.recycle();
        this.f168015g = null;
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        View r100 = this.f168021m;
        if (r100 == null) goto L5;
        r100.getViewTreeObserver().removeOnPreDrawListener(this.f168023o);
    L5:
        a();
        super.onDetachedFromWindow();
    }

    public final void a() {
        b();
        e r100 = this.f168012d;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public View getActivityDecorView() {
        Context r100 = getContext();
        int r101 = 0;
    L4:
        if (r101 >= 4) goto L12;
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L12;
        if ((r100 instanceof ContextWrapper) == false) goto L12;
        r100 = ((ContextWrapper) r100).getBaseContext();
        r101 = r101 + 1;
    L12:
        if ((r100 instanceof Activity) == false) goto L19;
        View r102 = ((Activity) r100).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L18:
        return r102;
    L19:
        return null;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r100 = getParent();
        if ((r100 instanceof View) == false) goto L5;
        this.f168021m = (View) r100;
    L5:
        View r101 = this.f168021m;
        boolean r102 = false;
        if (r101 == null) goto L13;
        r101.getViewTreeObserver().addOnPreDrawListener(this.f168023o);
        if (this.f168021m.getRootView() == getRootView()) goto L10;
        r102 = true;
    L10:
        this.f168022n = r102;
        if (r102 == false) goto L15;
        this.f168021m.postInvalidate();
        return;
    L15:
        return;
    L13:
        this.f168022n = false;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        if (this.f168017i == true) goto L9;
        if (f168007p > 0) goto L10;
        super.draw(r100);
        return;
    L10:
        return;
    L9:
        throw f168008q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Bitmap r101 = this.f168015g;
        int r102 = this.f168010b;
        if (r101 == null) goto L5;
        Rect r103 = this.f168019k;
        r103.right = r101.getWidth();
        Rect r104 = this.f168019k;
        r104.bottom = r101.getHeight();
        Rect r105 = this.f168020l;
        r105.right = getWidth();
        Rect r106 = this.f168020l;
        r106.bottom = getHeight();
        r100.drawBitmap(r101, this.f168019k, this.f168020l, null);
    L5:
        this.f168018j.setColor(r102);
        r100.drawRect(this.f168020l, this.f168018j);
    }

    public void setBlurRadius(float r100) {
        if (this.f168011c == r100) goto L6;
        this.f168011c = r100;
        this.f168013e = true;
        invalidate();
        return;
    }

    public void setDownsampleFactor(float r100) {
        if (r100 <= 0.0f) goto L9;
        if (this.f168009a == r100) goto L10;
        this.f168009a = r100;
        this.f168013e = true;
        b();
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int r100) {
        if (this.f168010b == r100) goto L6;
        this.f168010b = r100;
        invalidate();
        return;
    }

    public RealtimeBlurView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f168019k = new Rect();
        this.f168020l = new Rect();
        this.f168023o = new b(this);
        if (PdpPerfOpt.e() == false) goto L5;
        b2.b(new a(this, r100));
    L6:
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.realtimeBlurRadius, R.attr.realtimeDownsampleFactor, R.attr.realtimeOverlayColor});
        Resources r103 = r100.getResources();
        this.f168011c = r102.getDimension(0, TypedValue.applyDimension(1, 10.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        this.f168009a = r102.getFloat(1, 4.0f);
        this.f168010b = r102.getColor(2, -1426063361);
        r102.recycle();
        this.f168018j = new Paint();
        return;
    L5:
        f.f168043g.getClass();
        this.f168012d = f.a.b(r100);
        goto L6
    }
}
