package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class f4 extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f27246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f27248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f27250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f27251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f27252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f27255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f27256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f27257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Runnable f27258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f27259o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private d f27260p;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f4 f27261a;

        /* JADX INFO: renamed from: com.amap.api.mapcore.util.f4$a$a, reason: collision with other inner class name */
        public class RunnableC0509a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27262a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f27263b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f27264c;

            @Override // java.lang.Runnable
            public void run() {
                com_amap_api_mapcore_util_f4$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_amap_api_mapcore_util_f4$a$a__run$___twin___() {
                f4 r100 = this.f27264c.f27261a;
                r100.smoothScrollTo(0, (f4.a(r100) - this.f27262a) + f4.b(this.f27264c.f27261a));
                f4 r101 = this.f27264c.f27261a;
                r101.f27256l = (this.f27263b + f4.e(r101)) + 1;
                f4.f(this.f27264c.f27261a);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_mapcore_util_f4$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0509a r100) {
                r100.com_amap_api_mapcore_util_f4$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0509a(a r100, int r101, int r102) {
                this.f27264c = r100;
                this.f27262a = r101;
                this.f27263b = r102;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27265a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f27266b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f27267c;

            @Override // java.lang.Runnable
            public void run() {
                com_amap_api_mapcore_util_f4$a$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_amap_api_mapcore_util_f4$a$b__run$___twin___() {
                f4 r100 = this.f27267c.f27261a;
                r100.smoothScrollTo(0, f4.a(r100) - this.f27265a);
                f4 r101 = this.f27267c.f27261a;
                r101.f27256l = this.f27266b + f4.e(r101);
                f4.f(this.f27267c.f27261a);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_mapcore_util_f4$a$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
                r100.com_amap_api_mapcore_util_f4$a$b__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(a r100, int r101, int r102) {
                this.f27267c = r100;
                this.f27265a = r101;
                this.f27266b = r102;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_mapcore_util_f4$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_mapcore_util_f4$a__run$___twin___() {
            if ((f4.a(this.f27261a) - this.f27261a.getScrollY()) == 0) goto L5;
            f4 r100 = this.f27261a;
            f4.a(r100, r100.getScrollY());
            f4 r101 = this.f27261a;
            r101.postDelayed(f4.g(r101), f4.h(this.f27261a));
            return;
        L5:
            if (f4.b(this.f27261a) != 0) goto L7;
            return;
        L7:
            int r102 = f4.a(this.f27261a) % f4.b(this.f27261a);
            int r103 = f4.a(this.f27261a) / f4.b(this.f27261a);
            if (r102 != 0) goto L11;
            f4 r104 = this.f27261a;
            r104.f27256l = r103 + f4.e(r104);
            f4.f(this.f27261a);
            return;
        L11:
            if (r102 <= (f4.b(this.f27261a) / 2)) goto L13;
            this.f27261a.post(new RunnableC0509a(this, r102, r103));
            return;
        L13:
            this.f27261a.post(new b(this, r102, r103));
        }

        public a(f4 r100) {
            this.f27261a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_f4$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_mapcore_util_f4$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f4 f27268a;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r100) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r100) {
        }

        public b(f4 r100) {
            this.f27268a = r100;
        }

        private void a(Canvas r100) {
            Paint r101 = new Paint();
            Rect r102 = new Rect();
            Rect r103 = new Rect();
            r102.left = 0;
            r102.top = 0;
            r102.right = f4.j(this.f27268a).getWidth() + 0;
            r102.bottom = f4.j(this.f27268a).getHeight() + 0;
            r103.left = 0;
            r103.top = f4.k(this.f27268a)[0];
            r103.right = f4.l(this.f27268a) + 0;
            r103.bottom = f4.k(this.f27268a)[1];
            r100.drawBitmap(f4.j(this.f27268a), r102, r103, r101);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r100) {
            r100.drawColor(f4.i(this.f27268a));     // Catch: Throwable -> L4
            a(r100);     // Catch: Throwable -> L4
            Paint r101 = new Paint();     // Catch: Throwable -> L4
            Rect r102 = r100.getClipBounds();     // Catch: Throwable -> L4
            r101.setColor(f4.c(this.f27268a));     // Catch: Throwable -> L4
            r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L4
            r101.setStrokeWidth(f4.d(this.f27268a));     // Catch: Throwable -> L4
            r100.drawRect(r102, r101);     // Catch: Throwable -> L4
            return;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f4 f27270b;

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_mapcore_util_f4$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_mapcore_util_f4$c__run$___twin___() {
            f4 r100 = this.f27270b;
            r100.smoothScrollTo(0, this.f27269a * f4.b(r100));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_f4$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_amap_api_mapcore_util_f4$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(f4 r100, int r101) {
            this.f27270b = r100;
            this.f27269a = r101;
        }
    }

    public interface d {
        void a(int r100);
    }

    public void a() {
        Bitmap r100 = this.f27250f;
        if (r100 == null) goto L8;
        if (r100.isRecycled() == true) goto L8;
        w3.a(this.f27250f);
        this.f27250f = null;
    L8:
        if (this.f27260p == null) goto L11;
        this.f27260p = null;
        return;
    }

    public boolean b() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public f4(Context r100) {
        super(r100);
        this.f27247c = 0;
        this.f27250f = null;
        this.f27251g = ColorProtector.parseColor("#eeffffff");
        this.f27252h = ColorProtector.parseColor("#44383838");
        this.f27253i = 4;
        this.f27254j = 1;
        this.f27256l = 1;
        this.f27259o = 50;
        a(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_mapcore_util_f4_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ int b(f4 r100) {
        return r100.f27247c;
    }

    public static /* synthetic */ int c(f4 r100) {
        return r100.f27252h;
    }

    public static /* synthetic */ int d(f4 r100) {
        return r100.f27253i;
    }

    public static /* synthetic */ int e(f4 r100) {
        return r100.f27254j;
    }

    public static void f(f4 r100) {
        d r101 = r100.f27260p;
        if (r101 == null) goto L15;
        List<String> r102 = r100.f27248d;     // Catch: Throwable -> L12
        int r103 = 0;
        if (r102 != null) goto L7;
    L10:
        r101.a(r103);     // Catch: Throwable -> L12
        return;
    L7:
        if (r102.size() == 0) goto L10;
        r103 = Math.min(r100.f27248d.size() - (r100.f27254j * 2), Math.max(0, ((r100.f27248d.size() - 1) - r100.f27256l) - r100.f27254j));     // Catch: Throwable -> L12
    L16:
        return;
    }

    public static /* synthetic */ Runnable g(f4 r100) {
        return r100.f27258n;
    }

    public static /* synthetic */ int h(f4 r100) {
        return r100.f27259o;
    }

    public static /* synthetic */ int i(f4 r100) {
        return r100.f27251g;
    }

    public static /* synthetic */ Bitmap j(f4 r100) {
        return r100.f27250f;
    }

    public static int[] k(f4 r100) {
        int r101 = r100.f27247c;
        int r102 = r100.f27254j;
        return new int[]{r101 * r102, r101 * (r102 + 1)};
    }

    public static /* synthetic */ int l(f4 r100) {
        return r100.f27249e;
    }

    public void a(String[] r110) {
        if (this.f27248d != null) goto L5;
        this.f27248d = new ArrayList();
    L5:
        this.f27248d.clear();
        int r100 = 0;
    L7:
        if (r100 >= r110.length) goto L9;
        this.f27248d.add(r110[r100]);
        r100 = r100 + 1;
        goto L7
    L9:
        int r111 = 0;
    L11:
        if (r111 >= this.f27254j) goto L13;
        ListProtector.add(this.f27248d, 0, "");
        this.f27248d.add("");
        r111 = r111 + 1;
        goto L11
    L13:
        List<String> r112 = this.f27248d;
        if (r112 != null) goto L16;
        return;
    L16:
        if (r112.size() == 0) goto L32;
        this.f27246b.removeAllViews();
        this.f27255k = (this.f27254j * 2) + 1;
        int r113 = this.f27248d.size() - 1;
    L19:
        if (r113 < 0) goto L24;
        LinearLayout r101 = this.f27246b;
        String r102 = (String) ListProtector.get(this.f27248d, r113);
        TextView r103 = new TextView(this.f27245a);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r103.setSingleLine(true);
        r103.setTextSize(2, 16.0f);
        r103.setText(r102);
        r103.setGravity(17);
        r103.getPaint().setFakeBoldText(true);
        int r104 = (int) ((INVOKEVIRTUAL_com_amap_api_mapcore_util_f4_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.f27245a.getResources()).density * 8.0f) + 0.5f);
        int r105 = (int) ((INVOKEVIRTUAL_com_amap_api_mapcore_util_f4_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.f27245a.getResources()).density * 6.0f) + 0.5f);
        r103.setPadding(r104, r105, r104, r105);
        if (this.f27247c != 0) goto L23;
        r103.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        this.f27247c = r103.getMeasuredHeight();
        this.f27246b.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f27247c * this.f27255k));
        setLayoutParams(new LinearLayout.LayoutParams(-2, this.f27247c * this.f27255k));
    L23:
        r101.addView(r103);
        r113 = r113 - 1;
        goto L19
    L24:
        a(0);
        return;
    }

    @Override // android.widget.ScrollView
    public void fling(int r100) {
        super.fling(r100 / 3);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 1) goto L6;
        this.f27257m = getScrollY();
        postDelayed(this.f27258n, this.f27259o);
    L6:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f27251g = r100;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        if (this.f27249e == 0) goto L12;
    L10:
        super.setBackgroundDrawable(new b(this));
        return;
    L12:
        WindowManager r101 = (WindowManager) this.f27245a.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L8
        if (r101 == null) goto L10;
        this.f27249e = r101.getDefaultDisplay().getWidth();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    private void a(int r100) {
        int r101 = this.f27247c;
        if (r101 != 0) goto L5;
        return;
    L5:
        int r102 = (r100 / r101) + this.f27254j;
        int r103 = r100 % r101;
        if (r103 != 0) goto L9;
    L11:
        int r104 = this.f27246b.getChildCount();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L20;
        TextView r106 = (TextView) this.f27246b.getChildAt(r105);
        if (r106 == null) goto L15;
        if (r102 != r105) goto L18;
        r106.setTextColor(ColorProtector.parseColor("#0288ce"));
    L19:
        r105 = r105 + 1;
        goto L12
    L18:
        r106.setTextColor(ColorProtector.parseColor("#bbbbbb"));
        goto L19
    L15:
        return;
    L20:
        return;
    L9:
        if (r103 <= (r101 / 2)) goto L11;
        r102 = r102 + 1;
        goto L11
    }

    private void a(Context r100) {
        this.f27245a = r100;
        setVerticalScrollBarEnabled(false);
        if (this.f27250f != null) goto L6;
        this.f27250f = p3.b(r100, "map_indoor_select.png");     // Catch: Throwable -> L8
    L6:
        LinearLayout r101 = new LinearLayout(r100);
        this.f27246b = r101;
        r101.setOrientation(1);
        addView(this.f27246b);
        this.f27258n = new a(this);
    }

    public void a(String r100) {
        List<String> r101 = this.f27248d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() == 0) goto L10;
        int r102 = this.f27248d.indexOf(r100);
        int r103 = this.f27248d.size();
        int r104 = this.f27254j;
        int r105 = ((r103 - r104) - 1) - r102;
        this.f27256l = r104 + r105;
        post(new c(this, r105));
        return;
    }

    public void a(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public static /* synthetic */ int a(f4 r100) {
        return r100.f27257m;
    }

    public void a(d r100) {
        this.f27260p = r100;
    }

    public static /* synthetic */ int a(f4 r100, int r101) {
        r100.f27257m = r101;
        return r101;
    }

    @Override // android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        a(r101);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f27249e = r100;
        setBackgroundDrawable(null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
