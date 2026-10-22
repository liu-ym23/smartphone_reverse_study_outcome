package com.bytedance.android.window.shop.widget.popup;

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
import dr3.f;
import dr3.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowPopupWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f190064a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/popup/WindowPopupWindowManager$PopupPosition;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ABOVE", "BELOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PopupPosition extends Enum<PopupPosition> {
        public static final PopupPosition ABOVE = null;
        public static final PopupPosition BELOW = null;
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PopupPosition[] f190065a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, PopupPosition> f190066b = null;
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
            f190065a = new PopupPosition[]{r101, r102};
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
            f190066b = r104;
        }

        public static PopupPosition valueOf(String r100) {
            return (PopupPosition) r27.a.a(PopupPosition.class, r100);
        }

        public static PopupPosition[] values() {
            return (PopupPosition[]) f190065a.clone();
        }

        public static final /* synthetic */ Map access$getMap$cp() {
            return f190066b;
        }

        public final String getDesc() {
            return this.desc;
        }

        public PopupPosition(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f190067a;

        public a() {
            this.f190067a = null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f190068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f190069b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f190068a == r101.f190068a) goto L8;
            return false;
        L8:
            if (this.f190069b == r101.f190069b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f190068a * 31) + this.f190069b;
        }

        public final String toString() {
            return "PositionControl(innerOffsetX=" + this.f190068a + ", outerOffsetX=" + this.f190069b + ")";
        }

        public b(int r100, int r101) {
            this.f190068a = r100;
            this.f190069b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopupWindow f190070a;

        public c(PopupWindow r100) {
            this.f190070a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopupWindow r100 = this.f190070a;     // Catch: Throwable -> L4
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
        public final /* synthetic */ a f190071a;

        public d(a r100) {
            this.f190071a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r100 = this.f190071a.f190067a;     // Catch: Throwable -> L6
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View r110, final f r210, LifecycleOwner r211, PopupPosition r212) {
        Intrinsics.checkNotNullParameter(r110, "targetView");
        Intrinsics.checkNotNullParameter(r210, "content");
        Intrinsics.checkNotNullParameter(r211, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r212, "relativePosition");
        a r100 = new a();
        ViewGroup r101 = r210.e(r110.getContext(), new d(r100));
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        fr3.a.C5943a r102 = ((fr3.a.c) r210.f469762b).f478584d;
        float r103 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r102.f478588a, r102.f478589b), r102.f478591d), r102.f478590c);
        int r104 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((fr3.a.d) ((fr3.a.c) r210.f469762b).f478585e).f478594c));
        E r105 = ((fr3.a.c) r210.f469762b).f478585e;
        int r111 = ((fr3.a.d) r105).f478595d;
        int r106 = ((fr3.a.d) r105).f478597f;
        int[] r112 = {0, 0};
        r110.getLocationInWindow(r112);
        int r113 = r112[0];
        Resources r114 = r110.getResources();
        int r115 = ((WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()).widthPixels - r113) - r101.getMeasuredWidth()) - r104;
        int r116 = r110.getWidth() / r106;
        if (r115 < 0) goto L8;
        int r117 = (r110.getMeasuredWidth() / r106) + r113;
        int r107 = dr3.a.f469748f;
        int r108 = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r103));
        int r109 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111));
        if (r117 >= ((r108 + dr3.a.f469748f) + ((r109 * 3) / 2))) goto L7;
        b r118 = new b(r116 - r104, (-r113) + r104);
    L9:
        int r119 = dr3.a.f469748f;
        if (r212 != PopupPosition.BELOW) goto L12;
        boolean r120 = true;
    L13:
        int r121 = r118.f190068a;
        fr3.a.c r122 = (fr3.a.c) r210.f469762b;
        Intrinsics.checkNotNullParameter(r101, "childView");
        Intrinsics.checkNotNullParameter(r122, "uiConfig");
        int r123 = r122.f478583c;
        fr3.a.C5943a r124 = r122.f478584d;
        dr3.a r125 = new dr3.a(r101, new dr3.a.C5701a(r120, r121, r123, (int) RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r124.f478588a, r124.f478589b), r124.f478591d), r124.f478590c), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((fr3.a.d) r122.f478585e).f478593b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((fr3.a.d) r122.f478585e).f478595d))));
        r125.setWillNotDraw(false);
        boolean r126 = r125.f469753e.f469754a;
        FrameLayout.LayoutParams r127 = new FrameLayout.LayoutParams(-2, -2);
        if (r126 == false) goto L16;
        r127.gravity = 81;
        r127.topMargin = r125.f469749a + r125.f469753e.f469758e;
    L17:
        r125.addView(r125.f469752d, r127);
        r125.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final PopupWindow r128 = new PopupWindow();
        r128.setWidth(-2);
        r128.setHeight(-2);
        r128.setContentView(r125);
        if (((fr3.a.d) ((fr3.a.c) r210.f469762b).f478585e).f478596e == false) goto L20;
        r128.setOutsideTouchable(true);
    L20:
        r100.f190067a = new c(r128);
        r211.getLifecycle().addObserver(new WindowPopupWindowManager$show$2(r128, r210));
        int r129 = g.f469771a[r212.ordinal()];
        if (r129 != 1) goto L23;
        int r130 = r118.f190069b;
        int r131 = -(r110.getMeasuredHeight() + r128.getContentView().getMeasuredHeight());
        OverlaySource r132 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r128, r110, r132) == true) goto L37;
        r128.showAsDropDown(r110, r130, r131, GravityCompat.START);
        PopupWindowLancet.trackAfterShow(r128, r132, r110);
        return;
    L37:
        return;
    L23:
        if (r129 != 2) goto L35;
        int r133 = r118.f190069b;
        OverlaySource r134 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r128, r110, r134) == true) goto L36;
        r128.showAsDropDown(r110, r133, 0, GravityCompat.START);
        PopupWindowLancet.trackAfterShow(r128, r134, r110);
        return;
    L36:
        return;
    L35:
        return;
    L16:
        r127.gravity = 49;
        r127.bottomMargin = r125.f469749a + r125.f469753e.f469758e;
        goto L17
    L12:
        r120 = false;
        goto L13
    L7:
        r118 = new b(r116 - r104, r104 + 0);
        goto L9
    L8:
        int r135 = -r104;
        r118 = new b((r116 - r115) - r135, r115 + r135);
        goto L9
    }
}
