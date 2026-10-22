package com.bytedance.android.shopping.buynow.controller;

import android.graphics.Rect;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowElevatorGuideController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f170794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f170795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BuyNowViewModel f170796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AndroidYaTaInstance f170797d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/controller/BuyNowElevatorGuideController$StrategyAppear;", "", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Ljava/lang/String;", "getStrategy", "()Ljava/lang/String;", "TARGET_INVISIBLE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StrategyAppear extends Enum<StrategyAppear> {
        public static final StrategyAppear TARGET_INVISIBLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StrategyAppear[] f170798a = null;
        private final String strategy;

        static {
            StrategyAppear r100 = new StrategyAppear();
            TARGET_INVISIBLE = r100;
            f170798a = new StrategyAppear[]{r100};
        }

        public static StrategyAppear valueOf(String r100) {
            return (StrategyAppear) r27.a.a(StrategyAppear.class, r100);
        }

        public static StrategyAppear[] values() {
            return (StrategyAppear[]) f170798a.clone();
        }

        public StrategyAppear() {
            super("TARGET_INVISIBLE", 0);
            this.strategy = "target_invisible";
        }

        public final String getStrategy() {
            return this.strategy;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/buynow/controller/BuyNowElevatorGuideController$StrategyDisappear;", "", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Ljava/lang/String;", "getStrategy", "()Ljava/lang/String;", "SCROLL", "TARGET_SHOW", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StrategyDisappear extends Enum<StrategyDisappear> {
        public static final StrategyDisappear SCROLL = null;
        public static final StrategyDisappear TARGET_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StrategyDisappear[] f170799a = null;
        private final String strategy;

        static {
            StrategyDisappear r100 = new StrategyDisappear("SCROLL", 0, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
            SCROLL = r100;
            StrategyDisappear r101 = new StrategyDisappear("TARGET_SHOW", 1, "target_show");
            TARGET_SHOW = r101;
            f170799a = new StrategyDisappear[]{r100, r101};
        }

        public static StrategyDisappear valueOf(String r100) {
            return (StrategyDisappear) r27.a.a(StrategyDisappear.class, r100);
        }

        public static StrategyDisappear[] values() {
            return (StrategyDisappear[]) f170799a.clone();
        }

        public final String getStrategy() {
            return this.strategy;
        }

        public StrategyDisappear(String r100, int r101, String r102) {
            super(r100, r101);
            this.strategy = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.store.node.c b() {
        AndroidYaTaInstance r100 = this.f170796c.getYataInstance();
        if (r100 == null) goto L5;
        Object r101 = r100.i("guide_elevator");
    L7:
        if ((r101 instanceof Map) == true) goto L9;
        r101 = null;
    L9:
        Map r102 = (Map) r101;
        if (r102 == null) goto L12;
        Object r103 = r102.get("target_component_name");
    L14:
        if ((r103 instanceof String) == true) goto L16;
        r103 = null;
    L16:
        String r104 = (String) r103;
        if (r102 == null) goto L19;
        Object r105 = r102.get("target_yata_key");
    L21:
        if ((r105 instanceof String) == true) goto L23;
        r105 = null;
    L23:
        String r106 = (String) r105;
        boolean r107 = true;
        if (r102 != null) goto L26;
    L29:
        boolean r108 = true;
    L30:
        if (r108 == true) goto L49;
        if (r104 != null) goto L33;
    L36:
        boolean r109 = true;
    L37:
        if (r109 == true) goto L49;
        if (r106 != null) goto L40;
    L43:
        if (r107 == true) goto L49;
        com.bytedance.kmp.ec.yata.store.node.c r110 = com.bytedance.android.shopping.buynow.utils.h.a(this.f170796c.getYataInstance(), r104, r106);
        if (r110 != null) goto L48;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(this.f170796c.getTracker(), "yata_error", "elevator_render_object is null");
    L48:
        return r110;
    L40:
        if (r106.length() == 0) goto L43;
        r107 = false;
        goto L43
    L33:
        if (r104.length() == 0) goto L36;
        r109 = false;
    L49:
        return null;
    L26:
        if (r102.isEmpty() == true) goto L29;
        r108 = false;
        goto L30
    L19:
        r105 = null;
        goto L21
    L12:
        r103 = null;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public static double a(RecyclerView r100, View r101) {
        if (r101 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (r101.getVisibility() != 0) goto L22;
        Rect r102 = new Rect();
        if (r100.getGlobalVisibleRect(r102) == true) goto L10;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L10:
        Rect r103 = new Rect();
        if (r101.getGlobalVisibleRect(r103) == true) goto L13;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L13:
        Rect r104 = new Rect();
        if (r104.setIntersect(r102, r103) == true) goto L16;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L16:
        double r105 = r104.height();
        double r106 = r101.getHeight();
        if (r106 > 0) goto L19;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L19:
        return r105 / r106;
    L22:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public BuyNowElevatorGuideController(View r100, BuyNowViewModel r101, AndroidYaTaInstance r102) {
        Intrinsics.checkNotNullParameter(r100, "elevatorGuideContainer");
        Intrinsics.checkNotNullParameter(r101, "buyNowViewModel");
        this.f170795b = r100;
        this.f170796c = r101;
        this.f170797d = r102;
        this.f170794a = true;
    }

    public final void c(com.bytedance.kmp.ec.yata.store.node.c r100, String r101, String r110) {
        String r102 = r100.getKey();
        if (r102 != null) goto L6;
        return;
    L6:
        if (StringsKt.isBlank(r102) == false) goto L8;
        return;
    L8:
        com.bytedance.kmp.ec.yata.common.protocol.data.p r103 = r100.f251782b.f251788b;
        Object r104 = null;
        if (r103 == null) goto L12;
        Object r105 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r103, Reflection.getOrCreateKotlinClass(Object.class), r101);
        if ((r105 instanceof Object) == false) goto L12;
    L13:
        if (r105 != null) goto L16;
        return;
    L16:
        if ((r105 instanceof String) == false) goto L19;
        r104 = r105;
    L19:
        String r106 = (String) r104;
        if (r106 != null) goto L23;
        return;
    L23:
        if (StringsKt.isBlank(r106) == false) goto L25;
        return;
    L25:
        AndroidYaTaInstance r107 = this.f170797d;
        if (r107 == null) goto L31;
        YataEventCenter r108 = r107.k();
        if (r108 == null) goto L32;
        r108.d(com.bytedance.kmp.ec.yata.event.common.e.f251660a.a(this.f170797d, null, r102, r106, null, r110));
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r105 = null;
        goto L13
    }
}
