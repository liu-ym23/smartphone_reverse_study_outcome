package com.bytedance.android.ec.store.product.presenter.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import im.v;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECProductCardFunctionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f48352a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f48353b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f48354c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f48355d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f48356e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f48357f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f48358g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f48359h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f48360i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f48361j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f48362k = 0;

    public static final class a implements TypeEvaluator<Point> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Point f48363a;

        public a(Point r100) {
            Intrinsics.checkNotNullParameter(r100, "controlPoint");
            this.f48363a = r100;
        }

        @Override // android.animation.TypeEvaluator
        public final Point evaluate(float r100, Point r101, Point r102) {
            Point r103 = r101;
            Point r104 = r102;
            if (r103 == null) goto L8;
            if (r104 == null) goto L8;
            float r105 = 1 - r100;
            float r106 = r105 * r105;
            float r107 = r103.x * r106;
            float r108 = (2 * r100) * r105;
            Point r109 = this.f48363a;
            float r110 = r100 * r100;
            return new Point((int) ((r107 + (r109.x * r108)) + (r104.x * r110)), (int) (((r106 * r103.y) + (r108 * r109.y)) + (r110 * r104.y)));
        L8:
            return new Point(0, 0);
        }
    }

    static {
        f48352a = ExtensionsKt.a(106);
        f48353b = ExtensionsKt.a(106);
        f48354c = ExtensionsKt.a(2);
        f48355d = (int) 4294901820L;
        f48356e = ExtensionsKt.a(16);
        f48357f = ExtensionsKt.a(100);
        f48358g = 200;
        f48359h = 550;
        f48360i = 500;
        f48361j = 50;
        f48362k = 400;
    }

    public static void b(StoreV2ProductItemVO r100, QContext r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "params");
        v r103 = r100.f48441u;
        FragmentActivity r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.i();
    L7:
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        return;
    L15:
        int r107 = ECSdk.f48106a;
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r108 == null) goto L27;
        j r109 = r108.getLiveWindowService();
        if (r109 == null) goto L28;
        FragmentActivity r110 = l0.c(r101.c());
        if ((r110 instanceof FragmentActivity) == false) goto L23;
        r104 = r110;
    L23:
        if (r104 != null) goto L25;
        r104 = r101.a();
    L25:
        com.bytedance.android.ec.adapter.api.a r111 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter(LiveEndPageData.TAG_WINDOW, "<set-?>");
        r111.f42669a = LiveEndPageData.TAG_WINDOW;
        r111.f42670b = Long.valueOf(CastLongProtector.parseLong(r105));
        r111.f42673e = r102;
        Unit r112 = Unit.INSTANCE;
        r109.c(r104, r111);
        r109.toggleLiveAudio(false);
        return;
    L28:
        return;
    L27:
        return;
    L9:
        if (r105.length() == 0) goto L12;
        r106 = false;
        goto L13
    L5:
        r105 = null;
        goto L7
    }

    public static void a(Context r110, String r111, View r112, LottieAnimationViewWithPlayCount r210, Boolean r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (StringsKt.isBlank(r111) == false) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L26;
        if (r112 == null) goto L27;
        Object r101 = r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r101 instanceof WindowManager) == true) goto L11;
        r101 = null;
    L11:
        final WindowManager r113 = (WindowManager) r101;
        int r114 = eh.b.b(r110);
        final ECDraweeView r115 = new ECDraweeView(r110, null, 0, 6, null);
        r r102 = new r("ec_shop", "ec_shop_home_product_card");
        int r116 = f48352a;
        Integer r103 = Integer.valueOf(r116);
        int r117 = f48353b;
        h0.e(r115, r111, r102, r103, Integer.valueOf(r117), 96);
        r115.setBorderWidth(f48354c);
        r115.setBorderColor(f48355d);
        r115.setCornerRadius(f48356e);
        int[] r104 = new int[2];
        r112.getLocationOnScreen(r104);
        r104[1] = r104[1] - r114;
        int r105 = (r104[0] + (r112.getWidth() / 2)) - (r116 / 2);
        int r106 = (r104[1] + (r112.getHeight() / 2)) - (r117 / 2);
        WindowManager.LayoutParams r107 = new WindowManager.LayoutParams();
        r107.width = r116;
        r107.height = r117;
        r107.flags = 664;
        r107.format = -3;
        r107.type = 99;
        r107.x = r105;
        r107.y = r106;
        r107.gravity = 8388659;
        if (r113 == null) goto L14;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r115, r107);
        r113.addView(r115, r107);
    L14:
        final ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.addUpdateListener(new b(r115));
        r108.setDuration(f48358g);
        int[] r109 = new int[2];
        r210.getLocationOnScreen(r109);
        r109[1] = r109[1] - r114;
        r109[0] = r109[0] + (r210.getWidth() / 2);
        r109[1] = r109[1] + (r210.getHeight() / 2);
        Point r118 = new Point(r107.x, r107.y);
        Point r119 = new Point(r109[0] - (r107.width / 10), r109[1] - (r107.height / 10));
        int r120 = r107.height;
        int r121 = r107.width;
        int r122 = (r118.x + r119.x) / 2;
        int r123 = (int) RangesKt.coerceAtLeast(Math.abs(r119.y - r118.y) * 0.3f, f48357f);
        int r124 = r118.y;
        int r125 = r119.y;
        if (r124 <= r125) goto L17;
        int r126 = r125 + r123;
    L18:
        ValueAnimator r127 = ValueAnimator.ofObject(new a(new Point(r122, r126)), new Object[]{r118, r119});
        r127.addUpdateListener(new e(r127, r113, r115, r107, r121, r120));
        r127.setDuration(f48359h);
        if (r210.getPlayCount() >= 1) goto L21;
    L24:
        ValueAnimator r128 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r128.setDuration(f48362k);
        r128.addListener(new c(r210));
        ValueAnimator r129 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r129.setDuration(f48360i);
        ValueAnimator r130 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r130.addUpdateListener(new d(r115));
        r130.setDuration(f48361j);
        AnimatorSet r131 = new AnimatorSet();
        r131.playSequentially(new Animator[]{r129, r130});
        final AnimatorSet r132 = new AnimatorSet();
        r132.playTogether(new Animator[]{r127, r128, r131});
        AnimatorSet r133 = new AnimatorSet();
        r133.playSequentially(new Animator[]{r108, r132});
        com.bytedance.android.ec.core.utils.f.a(r133, new ECProductCardFunctionUtils$doScaleAnimation$$inlined$apply$lambda$1(r108, r132, r115, r113));
        r133.start();
        return;
    L21:
        if (Intrinsics.areEqual(r211, Boolean.TRUE) == false) goto L23;
        r210.setAnimation("shop_cart_animation_all_red_new.json");
        goto L24
    L23:
        r210.setAnimation("shop_cart_animation_all_red.json");
        goto L24
    L17:
        r126 = r124 - r123;
        goto L18
    L27:
        return;
    L26:
        return;
    L5:
        r100 = false;
        goto L6
    }
}
