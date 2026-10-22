package com.bytedance.android.shopping.deepfeed.ui.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, List<Long>> f173937h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ed3.c f173938i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Boolean f173939j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewStub f173940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardView f173941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleDraweeView f173942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f173943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatTextView f173944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f173945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.deepfeed.action.h f173946g;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.ui.view.g$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/g$a$a;", "", "", "", "showTimes", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2601a {

            @SerializedName("show_times")
            private final List<Long> showTimes;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2601a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.showTimes, ((C2601a) r100).showTimes) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                List<Long> r100 = this.showTimes;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "ShowTimeInfo(showTimes=" + this.showTimes + ")";
            }

            public C2601a() {
                this(new ArrayList());
            }

            public final List<Long> a() {
                return this.showTimes;
            }

            public C2601a(List<Long> r100) {
                this.showTimes = r100;
            }
        }
    }

    static {
        f173937h = new LinkedHashMap();
        f173938i = new ed3.c();
    }

    public final void a() {
        int r100 = this.f173943d;
        if (r100 != 0) goto L6;
        return;
    L6:
        if (r100 != 1) goto L17;
        CardView r101 = this.f173941b;
        if (r101 == null) goto L12;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 == null) goto L12;
        r102.cancel();
    L12:
        CardView r103 = this.f173941b;
        if (r103 == null) goto L15;
        ExtensionsKt.gone(r103);
    L15:
        this.f173943d = 0;
        return;
    L17:
        CardView r104 = this.f173941b;
        if (r104 == null) goto L21;
        r104.animate().alpha(0.0f).setDuration(280).start();
        return;
    }

    public g(View r100, com.bytedance.android.shopping.deepfeed.action.b r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "deepFeedContext");
        this.f173945f = r100;
        this.f173946g = r101;
        this.f173940a = (ViewStub) r100.findViewById(R.id.deep_feed_swipe_down_for_tips_card_stub);
        r101.getClass();
    }

    public final void b(int r110, double r111, int r112) {
        Intrinsics.checkNotNullParameter("deep_feed_swipe_show_time", "tipsName");
        Intrinsics.checkNotNullParameter("下一条相关商品", "tipsDesc");
        List<Long> r100 = (List) ((LinkedHashMap) f173937h).get("deep_feed_swipe_show_time");
        if (r100 != null) goto L18;
        f173938i.getClass();
        Intrinsics.checkNotNullParameter("deep_feed_swipe_version", "key");
        if ((-1) >= r110) goto L105;
        Intrinsics.checkNotNullParameter("deep_feed_swipe_version", "key");
        Intrinsics.checkNotNullParameter("deep_feed_swipe_show_time", "key");
        r100 = new ArrayList();
        goto L18
    L105:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("deep_feed_swipe_show_time", "key");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(SliceInitService.DEFAULT_SWITCH, "defaultValue");     // Catch: Throwable -> L12
        List<Long> r114 = ((a.C2601a) u0.b("", a.C2601a.class)).a();     // Catch: Throwable -> L12
        if (r114 != null) goto L10;
        r114 = new ArrayList();     // Catch: Throwable -> L12
    L10:
        r100 = r114;
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r115) == null) goto L18;
        r100 = new ArrayList();
    L12:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        if (r100 != null) goto L20;
    L39:
        boolean r116 = false;
    L40:
        if (r116 == true) goto L42;
        return;
    L42:
        if (this.f173941b != null) goto L89;
        ViewStub r117 = this.f173940a;
        SimpleDraweeView r118 = null;
        if (r117 == null) goto L46;
        View r119 = r117.inflate();
    L48:
        if ((r119 instanceof CardView) == true) goto L50;
        r119 = null;
    L50:
        CardView r120 = (CardView) r119;
        this.f173941b = r120;
        if (r120 == null) goto L53;
        r120.setElevation(20.0f);
    L53:
        CardView r121 = this.f173941b;
        if (r121 == null) goto L56;
        r121.setMaxCardElevation(20.0f);
    L56:
        CardView r122 = this.f173941b;
        if (r122 == null) goto L59;
        AppCompatTextView r123 = (AppCompatTextView) r122.findViewById(R.id.deep_feed_swipe_down_tips_2);
    L60:
        this.f173944e = r123;
        if (Build.VERSION.SDK_INT < 28) goto L68;
        CardView r124 = this.f173941b;
        if (r124 == null) goto L65;
        r124.setOutlineSpotShadowColor(ColorProtector.parseColor("#66000000"));
    L65:
        CardView r125 = this.f173941b;
        if (r125 == null) goto L68;
        r125.setOutlineAmbientShadowColor(ColorProtector.parseColor("#66000000"));
    L68:
        CardView r126 = this.f173941b;
        if (r126 == null) goto L71;
        r118 = (SimpleDraweeView) r126.findViewById(R.id.deep_feed_swipe_down_tips_image);
    L71:
        this.f173942c = r118;
        if (r118 == null) goto L76;
        ViewGroup.LayoutParams r127 = r118.getLayoutParams();
        if (r127 == null) goto L76;
        com.bytedance.android.shopping.deepfeed.ui.view.a r128 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r127.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(this.f173945f.getContext(), 24);
        r127.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(this.f173945f.getContext(), 24);
    L76:
        CardView r129 = this.f173941b;
        if (r129 == null) goto L81;
        ProductTextView r130 = (ProductTextView) r129.findViewById(R.id.deep_feed_swipe_down_tips_1);
        if (r130 == null) goto L81;
        com.bytedance.android.shopping.deepfeed.ui.view.a r102 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r130.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r130.getContext(), 14));
    L81:
        CardView r131 = this.f173941b;
        if (r131 == null) goto L86;
        ProductTextView r132 = (ProductTextView) r131.findViewById(R.id.deep_feed_swipe_down_tips_2);
        if (r132 == null) goto L86;
        com.bytedance.android.shopping.deepfeed.ui.view.a r133 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r132.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r132.getContext(), 14));
    L86:
        CardView r134 = this.f173941b;
        if (r134 == null) goto L89;
        r134.setAlpha(0.0f);
        goto L89
    L59:
        r123 = null;
        goto L60
    L46:
        r119 = null;
    L89:
        AppCompatTextView r135 = this.f173944e;
        if (r135 == null) goto L93;
        r135.setText("下一条相关商品");
    L93:
        if (this.f173943d != 2) goto L95;
        boolean r136 = true;
    L96:
        if (r136 == true) goto L114;
        CardView r137 = this.f173941b;
        if (r137 == null) goto L101;
        r137.setVisibility(0);
    L101:
        AbstractDraweeController r138 = Fresco.newDraweeControllerBuilder().setUri("asset:///deep_feed_swipe_tips_anim.webp").setAutoPlayAnimations(true).setControllerListener(new i(this)).build();
        SimpleDraweeView r139 = this.f173942c;
        if (r139 == null) goto L113;
        r139.setController(r138);
        return;
    L113:
        return;
    L114:
        return;
    L95:
        r136 = false;
        goto L96
    L20:
        if (r100.size() >= r112) goto L23;
    L38:
        r116 = true;
        goto L40
    L23:
        if ((!r100.isEmpty()) == true) goto L25;
    L27:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L29:
        if (r104.hasNext() == false) goto L36;
        Object r105 = r104.next();
        if ((System.currentTimeMillis() - ((Number) r105).longValue()) > (86400000 * r111)) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L29;
        r103.add(r105);
        goto L29
    L33:
        r106 = false;
        goto L34
    L36:
        List<Long> r140 = CollectionsKt.toMutableList(r103);
        f173937h.put("deep_feed_swipe_show_time", r140);
        if (r140.size() >= r112) goto L39;
    L25:
        if (r111 >= 0) goto L27;
        goto L27
    }
}
