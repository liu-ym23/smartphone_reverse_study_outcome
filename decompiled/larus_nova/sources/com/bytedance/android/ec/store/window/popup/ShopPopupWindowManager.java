package com.bytedance.android.ec.store.window.popup;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rn.e;

/* JADX INFO: loaded from: classes44.dex */
public final class ShopPopupWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f49015a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/window/popup/ShopPopupWindowManager$PopupPosition;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ABOVE", "BELOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PopupPosition extends Enum<PopupPosition> {
        public static final PopupPosition ABOVE = null;
        public static final PopupPosition BELOW = null;
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PopupPosition[] f49016a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, PopupPosition> f49017b = null;
        private final String desc;

        public static final class a {
            public a() {
            }
        }

        static {
            int r100 = 0;
            PopupPosition r101 = new PopupPosition("ABOVE", 0, "above");
            ABOVE = r101;
            PopupPosition r102 = new PopupPosition("BELOW", 1, "below");
            BELOW = r102;
            f49016a = new PopupPosition[]{r101, r102};
            Companion = new a();
            PopupPosition[] r103 = values();
            LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r103.length), 16));
            int r105 = r103.length;
        L3:
            if (r100 >= r105) goto L5;
            PopupPosition r106 = r103[r100];
            r104.put(r106.desc, r106);
            r100 = r100 + 1;
            goto L3
        L5:
            f49017b = r104;
        }

        public static PopupPosition valueOf(String r100) {
            return (PopupPosition) r27.a.a(PopupPosition.class, r100);
        }

        public static PopupPosition[] values() {
            return (PopupPosition[]) f49016a.clone();
        }

        public static final /* synthetic */ Map access$getMap$cp() {
            return f49017b;
        }

        public final String getDesc() {
            return this.desc;
        }

        public PopupPosition(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/store/window/popup/ShopPopupWindowManager$PopupRelativeAnchorPosition;", "", "LEFT", "HORIZONTAL_CENTER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PopupRelativeAnchorPosition extends Enum<PopupRelativeAnchorPosition> {
        public static final PopupRelativeAnchorPosition HORIZONTAL_CENTER = null;
        public static final PopupRelativeAnchorPosition LEFT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PopupRelativeAnchorPosition[] f49018a = null;

        static {
            PopupRelativeAnchorPosition r100 = new PopupRelativeAnchorPosition("LEFT", 0);
            LEFT = r100;
            PopupRelativeAnchorPosition r101 = new PopupRelativeAnchorPosition("HORIZONTAL_CENTER", 1);
            HORIZONTAL_CENTER = r101;
            f49018a = new PopupRelativeAnchorPosition[]{r100, r101};
        }

        public static PopupRelativeAnchorPosition valueOf(String r100) {
            return (PopupRelativeAnchorPosition) r27.a.a(PopupRelativeAnchorPosition.class, r100);
        }

        public static PopupRelativeAnchorPosition[] values() {
            return (PopupRelativeAnchorPosition[]) f49018a.clone();
        }

        public PopupRelativeAnchorPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f49019a;

        public a() {
            this.f49019a = null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49021b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f49020a == r101.f49020a) goto L8;
            return false;
        L8:
            if (this.f49021b == r101.f49021b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f49020a * 31) + this.f49021b;
        }

        public final String toString() {
            return "PositionControl(innerOffsetX=" + this.f49020a + ", outerOffsetX=" + this.f49021b + ")";
        }

        public b(int r100, int r101) {
            this.f49020a = r100;
            this.f49021b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopupWindow f49022a;

        public c(PopupWindow r100) {
            this.f49022a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopupWindow r100 = this.f49022a;     // Catch: Throwable -> L4
            PopupWindowLancet.handleDismissBeforeOrigin(r100);     // Catch: Throwable -> L4
            r100.dismiss();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f49023a;

        public d(a r100) {
            this.f49023a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r100 = this.f49023a.f49019a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.run();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public static void a(View r100, rn.d r101, LifecycleOwner r102, PopupPosition r103) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "relativePosition");
        b(r100, r101, r102, r103, PopupRelativeAnchorPosition.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PopupWindow b(View r210, final rn.d r211, LifecycleOwner r212, PopupPosition r213, PopupRelativeAnchorPosition r214) {
        Intrinsics.checkNotNullParameter(r210, "targetView");
        Intrinsics.checkNotNullParameter(r211, "content");
        Intrinsics.checkNotNullParameter(r212, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r213, "relativePosition");
        Intrinsics.checkNotNullParameter(r214, "relativeAnchorPosition");
        a r100 = new a();
        ViewGroup r101 = r211.e(r210.getContext(), new d(r100));
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        tn.a.C7744a r102 = ((tn.a.c) r211.f538637b).f546838d;
        float r103 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r102.f546841a, r102.f546842b), r102.f546844d), r102.f546843c);
        int r104 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((tn.a.d) ((tn.a.c) r211.f538637b).f546839e).f546847c));
        E r110 = ((tn.a.c) r211.f538637b).f546839e;
        int r111 = ((tn.a.d) r110).f546848d;
        int r112 = ((tn.a.d) r110).f546850f;
        int[] r113 = {0, 0};
        r210.getLocationInWindow(r113);
        int r114 = r113[0];
        Resources r115 = r210.getResources();
        int r116 = ((WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).widthPixels - r114) - r101.getMeasuredWidth()) - r104;
        PopupRelativeAnchorPosition r117 = PopupRelativeAnchorPosition.HORIZONTAL_CENTER;
        if (r214 != r117) goto L5;
        int r118 = r101.getMeasuredWidth() / r112;
    L6:
        if (r116 < 0) goto L11;
        int r119 = (r210.getMeasuredWidth() / r112) + r114;
        int r120 = rn.a.f538624f;
        int r105 = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r103));
        int r121 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111));
        if (r119 >= ((r105 + rn.a.f538624f) + ((r121 * 3) / 2))) goto L10;
        b r122 = new b(r118 - r104, (-r114) + r104);
    L12:
        int r106 = rn.a.f538624f;
        if (r213 != PopupPosition.BELOW) goto L15;
        boolean r123 = true;
    L16:
        int r107 = r122.f49020a;
        tn.a.c r124 = (tn.a.c) r211.f538637b;
        Intrinsics.checkNotNullParameter(r101, "childView");
        Intrinsics.checkNotNullParameter(r124, "uiConfig");
        int r125 = r124.f546837c;
        tn.a.C7744a r108 = r124.f546838d;
        rn.a r126 = new rn.a(r101, new rn.a.C7503a(r123, r107, r125, (int) RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r108.f546841a, r108.f546842b), r108.f546844d), r108.f546843c), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((tn.a.d) r124.f546839e).f546846b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((tn.a.d) r124.f546839e).f546848d))));
        r126.setWillNotDraw(false);
        boolean r109 = r126.f538629e.f538630a;
        FrameLayout.LayoutParams r127 = new FrameLayout.LayoutParams(-2, -2);
        if (r109 == false) goto L19;
        r127.gravity = 81;
        r127.topMargin = r126.f538625a + r126.f538629e.f538634e;
    L20:
        r126.addView(r126.f538628d, r127);
        r126.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final PopupWindow r128 = new PopupWindow();
        r128.setWidth(-2);
        r128.setHeight(-2);
        r128.setContentView(r126);
        if (((tn.a.d) ((tn.a.c) r211.f538637b).f546839e).f546849e == false) goto L23;
        r128.setOutsideTouchable(true);
    L23:
        r100.f49019a = new c(r128);
        r212.getLifecycle().addObserver(new ShopPopupWindowManager$showWithReturn$2(r128, r211));
        int r129 = e.f538645a[r213.ordinal()];
        if (r129 != 1) goto L26;
        if (r214 != r117) goto L37;
        int r130 = (r210.getWidth() - r128.getContentView().getMeasuredWidth()) / 2;
    L38:
        int r131 = -(r210.getMeasuredHeight() + r128.getContentView().getMeasuredHeight());
        OverlaySource r132 = PopupWindowLancet.resolveSource(r210);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r128, r210, r132) == true) goto L42;
        r128.showAsDropDown(r210, r130, r131, GravityCompat.START);
        PopupWindowLancet.trackAfterShow(r128, r132, r210);
    L42:
        return r128;
    L37:
        r130 = r122.f49021b;
        goto L38
    L26:
        if (r129 != 2) goto L42;
        if (r214 != r117) goto L30;
        int r133 = (r210.getWidth() - r128.getContentView().getMeasuredWidth()) / 2;
    L31:
        OverlaySource r134 = PopupWindowLancet.resolveSource(r210);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r128, r210, r134) == true) goto L42;
        r128.showAsDropDown(r210, r133, 0, GravityCompat.START);
        PopupWindowLancet.trackAfterShow(r128, r134, r210);
        goto L42
    L30:
        r133 = r122.f49021b;
        goto L31
    L19:
        r127.gravity = 49;
        r127.bottomMargin = r126.f538625a + r126.f538629e.f538634e;
        goto L20
    L15:
        r123 = false;
        goto L16
    L10:
        r122 = new b(r118 - r104, r104 + 0);
        goto L12
    L11:
        int r135 = -r104;
        r122 = new b((r118 - r116) - r135, r116 + r135);
        goto L12
    L5:
        r118 = r210.getWidth() / r112;
        goto L6
    }
}
