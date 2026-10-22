package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: OBaseIndicator.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OBaseIndicator extends FrameLayout {
    private final String TAG;
    private boolean dotsClickable;
    private int dotsColor;
    private float dotsCornerRadius;
    private float dotsHeight;
    private float dotsSpacing;
    private int dotsStrokeColor;
    private float dotsStrokeWidth;
    private float dotsWidth;
    private boolean initialized;
    private int layoutHeight;
    private d pager;
    private e pagerDataSetObserver;
    private boolean pendingRefreshDots;
    private boolean pendingRefreshDotsDraws;
    private boolean pendingRefreshDotsSize;
    private boolean pendingRefreshDotsSpacing;
    private boolean pendingRefreshParentLayout;
    private int sidePadding;
    private int type;
    private int verticalSidePadding;

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f35322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f35323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f35324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f35325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f35326e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final int m;
        private final int n;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(Float.valueOf(this.f35322a), Float.valueOf(r6.f35322a)) == true) goto L12;
            return false;
        L12:
            if (o.a(Float.valueOf(this.f35323b), Float.valueOf(r6.f35323b)) == true) goto L15;
            return false;
        L15:
            if (o.a(Float.valueOf(this.f35324c), Float.valueOf(r6.f35324c)) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f35325d, r6.f35325d) == true) goto L21;
            return false;
        L21:
            if (this.f35326e == r6.f35326e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L50;
            return false;
        L50:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((Float.hashCode(this.f35322a) * 31) + Float.hashCode(this.f35323b)) * 31) + Float.hashCode(this.f35324c)) * 31) + Arrays.hashCode(this.f35325d)) * 31) + Integer.hashCode(this.f35326e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("CustomDot(defaultWidth=").append(this.f35322a).append(", defaultHeight=").append(this.f35323b).append(", defaultSpacing=").append(this.f35324c).append(", styleableId=").append(Arrays.toString(this.f35325d)).append(", typeId=").append(this.f35326e).append(", layoutHeightId=").append(this.f).append(", dotsWidthId=").append(this.g).append(", dotsHeightId=").append(this.h).append(", dotsSpacingId=").append(this.i).append(", dotsColorId=").append(this.j).append(", dotsCornerRadiusId=").append(this.k).append(", dotsClickableId=");
            r0.append(this.l).append(", dotsStrokeColorId=").append(this.m).append(", dotsStrokeWidthId=").append(this.n).append(')');
            return r0.toString();
        }

        public a(float r2, float r3, float r4, int[] r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
            o.e(r5, "styleableId");
            this.f35322a = r2;
            this.f35323b = r3;
            this.f35324c = r4;
            this.f35325d = r5;
            this.f35326e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
        }

        public final float a() {
            return this.f35322a;
        }

        public final float b() {
            return this.f35323b;
        }

        public final float c() {
            return this.f35324c;
        }

        public final int[] d() {
            return this.f35325d;
        }

        public final int e() {
            return this.f35326e;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.j;
        }

        public final int k() {
            return this.k;
        }

        public final int l() {
            return this.l;
        }

        public final int m() {
            return this.m;
        }

        public final int n() {
            return this.n;
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    private final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f35327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f35328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.obric.oui.indicator.j f35329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f35331e;

        public b(OBaseIndicator r3, int r4, int r5, c r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
            o.e(r3, "this$0");
            this.f35327a = r3;
            this.f35328b = r7;
            if (r4 <= 0) goto L12;
            boolean r8 = false;
            if (r5 < 0) goto L8;
            if (r5 >= r4) goto L8;
            r8 = true;
        L8:
            if (r8 == true) goto L12;
            String r2 = "setManualPager requires currentItem in 0 until pageCount, currentItem=" + r5 + " pageCount=" + r4;
            com.obric.oui.d.a.b.d(OBaseIndicator.access$getTAG$p(r3), r2);
            throw new IllegalArgumentException(r2);
        L12:
            this.f35330d = r4;
            this.f35331e = r5;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public int a() {
            return this.f35330d;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public int b() {
            return this.f35331e;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public boolean c() {
            if (a() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void a(int r1, boolean r2) {
            if (b(r1) == true) goto L5;
            return;
        L5:
            e();
            c r3 = this.f35328b;
            if (r3 == null) goto L10;
            r3.a(b());
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void d() {
            this.f35329c = null;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void a(com.obric.oui.indicator.j r2) {
            o.e(r2, "onPageChangeListenerHelper");
            this.f35329c = r2;
        }

        public final boolean a(int r4) {
            if (r4 < 0) goto L25;
            if (r4 > 0) goto L10;
            if (b() == 0) goto L10;
            String r5 = "setManualPageCount requires currentItem=0 when pageCount=" + r4 + ", currentItem=" + b();
            com.obric.oui.d.a.b.d(OBaseIndicator.access$getTAG$p(this.f35327a), r5);
            throw new IllegalArgumentException(r5);
        L10:
            if (r4 <= 0) goto L21;
            int r2 = b();
            if (r2 < 0) goto L15;
            if (r2 >= r4) goto L15;
            boolean r3 = true;
        L16:
            if (r3 == true) goto L21;
            String r6 = "setManualPageCount requires currentItem in 0 until pageCount, currentItem=" + b() + " pageCount=" + r4;
            com.obric.oui.d.a.b.d(OBaseIndicator.access$getTAG$p(this.f35327a), r6);
            throw new IllegalArgumentException(r6);
        L15:
            r3 = false;
        L21:
            if (a() != r4) goto L23;
            return false;
        L23:
            this.f35330d = r4;
            return true;
        L25:
            String r7 = o.a("setManualPageCount requires pageCount >= 0, pageCount=", Integer.valueOf(r4));
            com.obric.oui.d.a.b.d(OBaseIndicator.access$getTAG$p(this.f35327a), r7);
            throw new IllegalArgumentException(r7);
        }

        public final void e() {
            com.obric.oui.indicator.j r0 = this.f35329c;
            if (r0 != null) goto L5;
        L7:
            this.f35327a.refreshDots();
            return;
        L5:
            if (c() == false) goto L7;
            r0.a(b(), 0.0f);
        }

        public final boolean b(int r4) {
            if (a() > 0) goto L9;
            if (r4 == 0) goto L9;
            String r5 = "ManualPager requires currentItem=0 when pageCount=" + a() + ", currentItem=" + r4;
            com.obric.oui.d.a.b.d(OBaseIndicator.access$getTAG$p(this.f35327a), r5);
            throw new IllegalArgumentException(r5);
        L9:
            if (a() <= 0) goto L20;
            if (r4 >= 0) goto L12;
        L14:
            boolean r0 = false;
        L15:
            if (r0 == true) goto L20;
            String r6 = "ManualPager requires currentItem in 0 until pageCount, currentItem=" + r4 + " pageCount=" + a();
            com.obric.oui.d.a.b.d(OBaseIndicator.access$getTAG$p(this.f35327a), r6);
            throw new IllegalArgumentException(r6);
        L12:
            if (r4 >= a()) goto L14;
            r0 = true;
        L20:
            if (b() != r4) goto L22;
            return false;
        L22:
            this.f35331e = r4;
            return true;
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public interface c {
        void a(int r1);
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public interface d {
        int a();

        void a(int r1, boolean r2);

        void a(com.obric.oui.indicator.j r1);

        int b();

        boolean c();

        void d();
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public interface e {
        d.h.a.b<e, x> getReleaseAction();
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    static final class f extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f35332a;

        f(int r1) {
            this.f35332a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(this.f35332a);
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public static final class g implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f35333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f35334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<Integer> f35335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ViewPager.e f35336d;

        /* JADX INFO: compiled from: OBaseIndicator.kt */
        public static final class a implements ViewPager.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.obric.oui.indicator.j f35337a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OBaseIndicator f35338b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ g f35339c;

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int r1) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int r1) {
            }

            a(com.obric.oui.indicator.j r1, OBaseIndicator r2, g r3) {
                this.f35337a = r1;
                this.f35338b = r2;
                this.f35339c = r3;
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int r2, float r3, int r4) {
                this.f35337a.a(OBaseIndicator.access$mod(this.f35338b, r2, this.f35339c.a()), r3);
            }
        }

        g(ViewPager r3, OBaseIndicator r4, d.h.a.a<Integer> r5) {
            d.h.a.a<Integer> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f35333a = r3;
            this.f35334b = r4;
            this.f35335c = r6;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public boolean c() {
            return com.obric.oui.indicator.d.a(this.f35333a);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public int b() {
            return OBaseIndicator.access$mod(this.f35334b, this.f35333a.getCurrentItem(), a());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public int a() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.f35335c.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void a(int r1, boolean r2) {
            this.f35333a.setCurrentItem(r1, r2);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void d() {
            ViewPager.e r0 = this.f35336d;
            if (r0 == null) goto L7;
            this.f35333a.removeOnPageChangeListener(r0);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void a(com.obric.oui.indicator.j r3) {
            o.e(r3, "onPageChangeListenerHelper");
            ViewPager.e r4 = (ViewPager.e) ZeusTransformUtils.preCheckCast(new a(r3, this.f35334b, this), ViewPager.e.class, "com.obric.aiagent.plugin");
            this.f35336d = r4;
            ViewPager r2 = this.f35333a;
            o.a(r4);
            r2.addOnPageChangeListener(r4);
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    static final class h extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f35340a;

        h(int r1) {
            this.f35340a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(this.f35340a);
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public static final class i extends RecyclerView.b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f35341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f35342b;

        /* JADX INFO: compiled from: OBaseIndicator.kt */
        static final class a extends p implements d.h.a.b<e, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewPager2 f35343a;

            a(ViewPager2 r1) {
                this.f35343a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(e r3) {
                a((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(e r3) {
                e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
                o.e(r4, "it");
                RecyclerView.a r2 = this.f35343a.getAdapter();
                o.a(r2);
                r2.b((RecyclerView.b) ZeusTransformUtils.preCheckCast(r4, RecyclerView.b.class, "com.obric.aiagent.plugin"));
            }
        }

        i(OBaseIndicator r1, ViewPager2 r2) {
            this.f35341a = r1;
            this.f35342b = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public d.h.a.b<e, x> getReleaseAction() {
            return (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this.f35342b), d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void a() {
            super.a();
            this.f35341a.refreshDots();
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public static final class j implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f35344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f35345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<Integer> f35346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ViewPager2.e f35347d;

        /* JADX INFO: compiled from: OBaseIndicator.kt */
        public static final class a extends ViewPager2.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.obric.oui.indicator.j f35348a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OBaseIndicator f35349b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ j f35350c;

            @Override // androidx.viewpager2.widget.ViewPager2.e
            public void a(int r1) {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e
            public void b(int r1) {
            }

            a(com.obric.oui.indicator.j r1, OBaseIndicator r2, j r3) {
                this.f35348a = r1;
                this.f35349b = r2;
                this.f35350c = r3;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e
            public void a(int r2, float r3, int r4) {
                this.f35348a.a(OBaseIndicator.access$mod(this.f35349b, r2, this.f35350c.a()), r3);
            }
        }

        j(ViewPager2 r3, OBaseIndicator r4, d.h.a.a<Integer> r5) {
            d.h.a.a<Integer> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f35344a = r3;
            this.f35345b = r4;
            this.f35346c = r6;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public boolean c() {
            if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.f35344a, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public int b() {
            return OBaseIndicator.access$mod(this.f35345b, this.f35344a.getCurrentItem(), a());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public int a() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.f35346c.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void a(int r1, boolean r2) {
            this.f35344a.setCurrentItem(r1, r2);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void d() {
            ViewPager2.e r0 = this.f35347d;
            if (r0 == null) goto L7;
            this.f35344a.unregisterOnPageChangeCallback(r0);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public void a(com.obric.oui.indicator.j r3) {
            o.e(r3, "onPageChangeListenerHelper");
            ViewPager2.e r4 = (ViewPager2.e) ZeusTransformUtils.preCheckCast(new a(r3, this.f35345b, this), ViewPager2.e.class, "com.obric.aiagent.plugin");
            this.f35347d = r4;
            ViewPager2 r2 = this.f35344a;
            o.a(r4);
            r2.registerOnPageChangeCallback(r4);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2, reason: invalid class name */
    /* JADX INFO: compiled from: OBaseIndicator.kt */
    public static final class AnonymousClass2 extends DataSetObserver implements e {
        final /* synthetic */ ViewPager $viewPager;
        final /* synthetic */ OBaseIndicator this$0;

        /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2$a */
        /* JADX INFO: compiled from: OBaseIndicator.kt */
        static final class a extends p implements d.h.a.b<e, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewPager f35351a;

            a(ViewPager r1) {
                this.f35351a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(e r3) {
                a((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(e r3) {
                e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
                o.e(r4, "it");
                androidx.viewpager.widget.a r2 = this.f35351a.getAdapter();
                o.a(r2);
                r2.b((DataSetObserver) ZeusTransformUtils.preCheckCast(r4, DataSetObserver.class, "com.obric.aiagent.plugin"));
            }
        }

        AnonymousClass2(OBaseIndicator r1, ViewPager r2) {
            this.this$0 = r1;
            this.$viewPager = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public d.h.a.b<e, x> getReleaseAction() {
            return (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this.$viewPager), d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.this$0.refreshDots();
        }
    }

    public OBaseIndicator(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBaseIndicator(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$btDugYOLtfaXnhmkSgyzJs5Lvn8(OBaseIndicator r0) {
        m1095postPendingRefresh$lambda1(r0);
    }

    public static /* synthetic */ void lambda$yPd5Isx6PNLQ3fsYPJifVqRdrLo(OBaseIndicator r0) {
        m1096refreshDots$lambda0(r0);
    }

    public abstract void addDot(int r1);

    public abstract com.obric.oui.indicator.j buildOnPageChangedListener();

    public abstract a getCustom();

    public abstract void onRefreshDotsDraws();

    public abstract void onRefreshDotsSize();

    public abstract void onRefreshDotsSpacing();

    public abstract void onRefreshIndicator();

    public abstract void refreshDotDraw(int r1);

    public abstract void refreshParentLayout();

    public abstract void removeDot(int r1);

    public final void setManualPager(int r7) {
        setManualPager$default(this, r7, 0, null, 6, null);
    }

    public final void setManualPager(int r7, int r8) {
        setManualPager$default(this, r7, r8, null, 4, null);
    }

    public /* synthetic */ OBaseIndicator(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ String access$getTAG$p(OBaseIndicator r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ int access$mod(OBaseIndicator r0, int r1, int r2) {
        return r0.mod(r1, r2);
    }

    public OBaseIndicator(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.TAG = "OBaseIndicator";
        this.dotsWidth = getCustom().a();
        this.dotsHeight = getCustom().b();
        this.layoutHeight = -2;
        this.verticalSidePadding = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 7);
        this.sidePadding = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10);
        this.dotsSpacing = getCustom().c();
        this.dotsColor = androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.oui_text_4, "color", "oui_text_4"));
        this.dotsCornerRadius = this.dotsHeight / 2;
        this.dotsClickable = true;
        this.dotsStrokeColor = androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent"));
        this.dotsStrokeWidth = com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
        if (r10 == null) goto L6;
        TypedArray r11 = r9.obtainStyledAttributes(r10, getCustom().d());
        o.c(r11, "context.obtainStyledAttr…ttrs, custom.styleableId)");
        setType(r11.getInt(getCustom().e(), this.type));
        setDotsWidth(r11.getDimension(getCustom().g(), this.dotsWidth));
        setDotsHeight(r11.getDimension(getCustom().h(), this.dotsHeight));
        setLayoutHeight(r11.getDimensionPixelSize(getCustom().f(), -2));
        setDotsSpacing(r11.getDimension(getCustom().i(), this.dotsSpacing));
        setDotsColor(r11.getColor(getCustom().j(), this.dotsColor));
        setDotsCornerRadius(r11.getDimension(getCustom().k(), this.dotsCornerRadius));
        this.dotsClickable = r11.getBoolean(getCustom().l(), true);
        setDotsStrokeColor(r11.getColor(getCustom().m(), this.dotsStrokeColor));
        setDotsStrokeWidth(r11.getDimension(getCustom().n(), this.dotsStrokeWidth));
        r11.recycle();
        return;
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final void setInitialized(boolean r1) {
        this.initialized = r1;
    }

    public final boolean getPendingRefreshParentLayout() {
        return this.pendingRefreshParentLayout;
    }

    public final void setPendingRefreshParentLayout(boolean r1) {
        this.pendingRefreshParentLayout = r1;
    }

    public final float getDotsWidth() {
        return this.dotsWidth;
    }

    public final void setDotsWidth(float r2) {
        if (this.dotsWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsWidth = r2;
        refreshDotsSize();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final float getDotsHeight() {
        return this.dotsHeight;
    }

    public final void setDotsHeight(float r2) {
        if (this.dotsHeight != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsHeight = r2;
        refreshDotsSize();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int getLayoutHeight() {
        return this.layoutHeight;
    }

    public final void setLayoutHeight(int r2) {
        if (this.layoutHeight == r2) goto L6;
        this.layoutHeight = r2;
        refreshParentLayout();
        return;
    }

    public final int getVerticalSidePadding() {
        return this.verticalSidePadding;
    }

    public final void setVerticalSidePadding(int r2) {
        if (this.verticalSidePadding == r2) goto L6;
        this.verticalSidePadding = r2;
        refreshParentLayout();
        return;
    }

    public final int getSidePadding() {
        return this.sidePadding;
    }

    public final void setSidePadding(int r2) {
        if (this.sidePadding == r2) goto L6;
        this.sidePadding = r2;
        refreshParentLayout();
        return;
    }

    public final float getDotsSpacing() {
        return this.dotsSpacing;
    }

    public final void setDotsSpacing(float r2) {
        if (this.dotsSpacing != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsSpacing = r2;
        refreshDotsSpacing();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int r2) {
        if (this.type == r2) goto L6;
        this.type = r2;
        refreshParentLayout();
        refreshDotsDraws();
        return;
    }

    public final int getDotsColor() {
        return this.dotsColor;
    }

    public final void setDotsColor(int r4) {
        if (this.type == 1) goto L5;
        this.dotsColor = r4;
        refreshDotsDraws();
        return;
    L5:
        this.dotsColor = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_4, "color", "oui_on_accent_text_4"));
        refreshDotsDraws();
    }

    public final float getDotsCornerRadius() {
        return this.dotsCornerRadius;
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.dotsCornerRadius != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsCornerRadius = r2;
        refreshDotsDraws();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getDotsClickable() {
        return this.dotsClickable;
    }

    public final void setDotsClickable(boolean r1) {
        this.dotsClickable = r1;
    }

    public final int getDotsStrokeColor() {
        return this.dotsStrokeColor;
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.dotsStrokeColor == r2) goto L6;
        this.dotsStrokeColor = r2;
        refreshDotsDraws();
        return;
    }

    public final float getDotsStrokeWidth() {
        return this.dotsStrokeWidth;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.dotsStrokeWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsStrokeWidth = r2;
        refreshDotsDraws();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setInitComplete() {
        this.initialized = true;
    }

    public final d getPager() {
        return this.pager;
    }

    public final void setPager(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d r0 = this.pager;
        if (r0 == null) goto L6;
        r0.d();
    L6:
        this.pager = r4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshDots();
        postPendingRefresh();
    }

    public final void refreshDots() {
        if (this.pager != null) goto L6;
        return;
    L6:
        if (this.initialized == true) goto L9;
        this.pendingRefreshDots = true;
        return;
    L9:
        post(new $$Lambda$OBaseIndicator$yPd5Isx6PNLQ3fsYPJifVqRdrLo(this));
    }

    /* JADX INFO: renamed from: refreshDots$lambda-0, reason: not valid java name */
    private static final void m1096refreshDots$lambda0(OBaseIndicator r3) {
        o.e(r3, "this$0");
        boolean r1 = true;
        if (r3.initialized == true) goto L6;
        r3.pendingRefreshDots = true;
        return;
    L6:
        r3.pendingRefreshDots = false;
        r3.onRefreshIndicator();
        r3.refreshDotsSpacing();
        r3.refreshDotsDraws();
        r3.refreshDotsSize();
        r3.refreshOnPageChangedListener();
        d r2 = r3.pager;
        if (r2 != null) goto L10;
    L8:
        r1 = false;
    L12:
        if (r1 == false) goto L14;
        k.c((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        if (r2.a() != 1) goto L8;
        goto L8
    }

    public final int pagerCount() {
        d r0 = this.pager;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.a();
    }

    public final void refreshDotsDraws() {
        if (this.initialized == true) goto L6;
        this.pendingRefreshDotsDraws = true;
        return;
    L6:
        this.pendingRefreshDotsDraws = false;
        onRefreshDotsDraws();
    }

    public final void refreshDotsSpacing() {
        if (this.initialized == true) goto L6;
        this.pendingRefreshDotsSpacing = true;
        return;
    L6:
        this.pendingRefreshDotsSpacing = false;
        onRefreshDotsSpacing();
    }

    public final void refreshDotsSize() {
        if (this.initialized == true) goto L6;
        this.pendingRefreshDotsSize = true;
        return;
    L6:
        this.pendingRefreshDotsSize = false;
        onRefreshDotsSize();
    }

    private final void postPendingRefresh() {
        post(new $$Lambda$OBaseIndicator$btDugYOLtfaXnhmkSgyzJs5Lvn8(this));
    }

    /* JADX INFO: renamed from: postPendingRefresh$lambda-1, reason: not valid java name */
    private static final void m1095postPendingRefresh$lambda1(OBaseIndicator r1) {
        o.e(r1, "this$0");
        if (r1.pendingRefreshParentLayout == false) goto L6;
        r1.refreshParentLayout();
    L6:
        if (r1.pendingRefreshDots == false) goto L10;
        r1.refreshDots();
        return;
    L10:
        if (r1.pendingRefreshDotsSpacing == false) goto L13;
        r1.refreshDotsSpacing();
    L13:
        if (r1.pendingRefreshDotsDraws == false) goto L16;
        r1.refreshDotsDraws();
    L16:
        if (r1.pendingRefreshDotsSize == false) goto L19;
        r1.refreshDotsSize();
        return;
    }

    private final void refreshOnPageChangedListener() {
        d r0 = this.pager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.c() == true) goto L8;
        return;
    L8:
        r0.d();
        com.obric.oui.indicator.j r2 = buildOnPageChangedListener();
        r0.a(r2);
        r2.a(r0.b(), 0.0f);
    }

    private final void setPagerDataSetObserver(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        e r0 = this.pagerDataSetObserver;
        if (r0 == null) goto L9;
        d.h.a.b<e, x> r1 = r0.getReleaseAction();
        if (r1 == null) goto L9;
        e r2 = this.pagerDataSetObserver;
        o.a(r2);
        r1.invoke(r2);
    L9:
        this.pagerDataSetObserver = r4;
    }

    public static /* synthetic */ void setManualPager$default(OBaseIndicator r2, int r3, int r4, c r5, int r6, Object r7) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L13;
        if ((r6 & 2) == 0) goto L8;
        r4 = 0;
    L8:
        if ((r6 & 4) == 0) goto L10;
        r8 = null;
    L10:
        r2.setManualPager(r3, r4, r8);
        return;
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setManualPager");
    }

    public final void setManualPager(int r3, int r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        setPagerDataSetObserver(null);
        setPager((d) ZeusTransformUtils.preCheckCast(new b(this, r3, r4, r6), d.class, "com.obric.aiagent.plugin"));
        refreshDots();
    }

    public final void setManualPageCount(int r4) {
        d r0 = this.pager;
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L5;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        com.obric.oui.d.a.b.d(this.TAG, "setManualPageCount requires setManualPager before manual updates");
        throw new IllegalStateException("setManualPageCount requires setManualPager before manual updates");
    L8:
        if (r1.a(r4) == false) goto L13;
        refreshDots();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setManualCurrentItem(int r4) {
        d r0 = this.pager;
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L5;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        com.obric.oui.d.a.b.d(this.TAG, "setManualCurrentItem requires setManualPager before manual updates");
        throw new IllegalStateException("setManualCurrentItem requires setManualPager before manual updates");
    L8:
        if (r1.b(r4) == false) goto L13;
        r1.e();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setViewPager(ViewPager r2) {
        o.e(r2, "viewPager");
        androidx.viewpager.widget.a r0 = r2.getAdapter();
        if (r0 != null) goto L5;
        int r1 = 1;
    L6:
        setViewPager(r2, r1);
        return;
    L5:
        r1 = r0.a();
        goto L6
    }

    public final void setViewPager(ViewPager r3, int r4) {
        o.e(r3, "viewPager");
        setViewPager(r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final void setViewPager(ViewPager r5, d.h.a.a<Integer> r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "viewPager");
        o.e(r7, "pageCount");
        if (r5.getAdapter() == null) goto L7;
        setPagerDataSetObserver((e) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r5), e.class, "com.obric.aiagent.plugin"));
        androidx.viewpager.widget.a r0 = r5.getAdapter();
        o.a(r0);
        e r2 = this.pagerDataSetObserver;
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.database.DataSetObserver");
        r0.a((DataSetObserver) ZeusTransformUtils.preCheckCast(r2, DataSetObserver.class, "com.obric.aiagent.plugin"));
        setPager((d) ZeusTransformUtils.preCheckCast(new g(r5, this, r7), d.class, "com.obric.aiagent.plugin"));
        refreshDots();
        return;
    L7:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    public final void setViewPager2(ViewPager2 r3, int r4) {
        o.e(r3, "viewPager");
        setViewPager2(r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final void setViewPager2(ViewPager2 r5, d.h.a.a<Integer> r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "viewPager");
        o.e(r7, "pageCount");
        if (r5.getAdapter() == null) goto L7;
        setPagerDataSetObserver((e) ZeusTransformUtils.preCheckCast(new i(this, r5), e.class, "com.obric.aiagent.plugin"));
        RecyclerView.a r0 = r5.getAdapter();
        o.a(r0);
        e r2 = this.pagerDataSetObserver;
        Objects.requireNonNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.AdapterDataObserver");
        r0.a((RecyclerView.b) ZeusTransformUtils.preCheckCast(r2, RecyclerView.b.class, "com.obric.aiagent.plugin"));
        setPager((d) ZeusTransformUtils.preCheckCast(new j(r5, this, r7), d.class, "com.obric.aiagent.plugin"));
        refreshDots();
        return;
    L7:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    private final int mod(int r2, int r3) {
        if (r3 != 0) goto L13;
        com.obric.oui.d.a.b.d(this.TAG, "mod num is 0");
        return r2;
    L13:
        return r2 % r3;
    L7:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, ArithmeticException.class) == false) goto L11;
        com.obric.oui.d.a.b.d(this.TAG, o.a("不要乱除0呀 ", e.getMessage()));
        return r2;
    L11:
        com.obric.oui.d.a.b.d(this.TAG, o.a("抓住了一个Exception并ignore, ", e.getMessage()));
        return r2;
    }
}
