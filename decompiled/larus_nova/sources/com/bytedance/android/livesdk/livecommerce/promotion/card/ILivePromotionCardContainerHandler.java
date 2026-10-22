package com.bytedance.android.livesdk.livecommerce.promotion.card;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes10.dex */
public interface ILivePromotionCardContainerHandler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCardContainerHandler$ContainerPriority;", "", "LigoInitDataMap", "AddressInfo", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ContainerPriority extends Enum<ContainerPriority> {
        public static final ContainerPriority AddressInfo = null;
        public static final ContainerPriority LigoInitDataMap = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContainerPriority[] f150019a = null;

        static {
            ContainerPriority r100 = new ContainerPriority("LigoInitDataMap", 0);
            LigoInitDataMap = r100;
            ContainerPriority r101 = new ContainerPriority("AddressInfo", 1);
            AddressInfo = r101;
            f150019a = new ContainerPriority[]{r100, r101};
        }

        public static ContainerPriority valueOf(String r100) {
            return (ContainerPriority) r27.a.a(ContainerPriority.class, r100);
        }

        public static ContainerPriority[] values() {
            return (ContainerPriority[]) f150019a.clone();
        }

        public ContainerPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCardContainerHandler$Scene;", "", "ExplainPromotionBackground", "ExplainPromotionBackgroundRadius", "ExplainBarWaveIcon", "InstantRetailShopStepperTextColor", "InstantRetailShopStepperTextSize", "InstantRetailShopStepperAddEnabledImageUrl", "InstantRetailShopStepperAddDisabledImageUrl", "InstantRetailShopStepperSubImageUrl", "AddCartIconEnabled", "AddCartIconDisabled", "AddCartBtnBgEnabled", "AddCartBtnBgDisabled", "AddCartBtnLargeSize", "BuyBtnBgEnabled", "BuyBtnBgDisabled", "BuyBtnTextColor", "BuyBtnWidthSelfAdapt", "SimilarBtnBgEnabled", "SimilarBtnTextColorEnabled", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        public static final Scene AddCartBtnBgDisabled = null;
        public static final Scene AddCartBtnBgEnabled = null;
        public static final Scene AddCartBtnLargeSize = null;
        public static final Scene AddCartIconDisabled = null;
        public static final Scene AddCartIconEnabled = null;
        public static final Scene BuyBtnBgDisabled = null;
        public static final Scene BuyBtnBgEnabled = null;
        public static final Scene BuyBtnTextColor = null;
        public static final Scene BuyBtnWidthSelfAdapt = null;
        public static final Scene ExplainBarWaveIcon = null;
        public static final Scene ExplainPromotionBackground = null;
        public static final Scene ExplainPromotionBackgroundRadius = null;
        public static final Scene InstantRetailShopStepperAddDisabledImageUrl = null;
        public static final Scene InstantRetailShopStepperAddEnabledImageUrl = null;
        public static final Scene InstantRetailShopStepperSubImageUrl = null;
        public static final Scene InstantRetailShopStepperTextColor = null;
        public static final Scene InstantRetailShopStepperTextSize = null;
        public static final Scene SimilarBtnBgEnabled = null;
        public static final Scene SimilarBtnTextColorEnabled = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f150020a = null;

        static {
            Scene r100 = new Scene("ExplainPromotionBackground", 0);
            ExplainPromotionBackground = r100;
            Scene r101 = new Scene("ExplainPromotionBackgroundRadius", 1);
            ExplainPromotionBackgroundRadius = r101;
            Scene r102 = new Scene("ExplainBarWaveIcon", 2);
            ExplainBarWaveIcon = r102;
            Scene r103 = new Scene("InstantRetailShopStepperTextColor", 3);
            InstantRetailShopStepperTextColor = r103;
            Scene r104 = new Scene("InstantRetailShopStepperTextSize", 4);
            InstantRetailShopStepperTextSize = r104;
            Scene r105 = new Scene("InstantRetailShopStepperAddEnabledImageUrl", 5);
            InstantRetailShopStepperAddEnabledImageUrl = r105;
            Scene r106 = new Scene("InstantRetailShopStepperAddDisabledImageUrl", 6);
            InstantRetailShopStepperAddDisabledImageUrl = r106;
            Scene r107 = new Scene("InstantRetailShopStepperSubImageUrl", 7);
            InstantRetailShopStepperSubImageUrl = r107;
            Scene r108 = new Scene("AddCartIconEnabled", 8);
            AddCartIconEnabled = r108;
            Scene r109 = new Scene("AddCartIconDisabled", 9);
            AddCartIconDisabled = r109;
            Scene r110 = new Scene("AddCartBtnBgEnabled", 10);
            AddCartBtnBgEnabled = r110;
            Scene r111 = new Scene("AddCartBtnBgDisabled", 11);
            AddCartBtnBgDisabled = r111;
            Scene r112 = new Scene("AddCartBtnLargeSize", 12);
            AddCartBtnLargeSize = r112;
            Scene r113 = new Scene("BuyBtnBgEnabled", 13);
            BuyBtnBgEnabled = r113;
            Scene r114 = new Scene("BuyBtnBgDisabled", 14);
            BuyBtnBgDisabled = r114;
            Scene r115 = new Scene("BuyBtnTextColor", 15);
            BuyBtnTextColor = r115;
            Scene r116 = new Scene("BuyBtnWidthSelfAdapt", 16);
            BuyBtnWidthSelfAdapt = r116;
            Scene r117 = new Scene("SimilarBtnBgEnabled", 17);
            SimilarBtnBgEnabled = r117;
            Scene r118 = new Scene("SimilarBtnTextColorEnabled", 18);
            SimilarBtnTextColorEnabled = r118;
            f150020a = new Scene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public static Scene[] values() {
            return (Scene[]) f150020a.clone();
        }

        public Scene(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();

    il2.a b(com.bytedance.android.btm.api.model.d r100);

    void c(String r100, int r101, boolean r102);

    void d();

    Map<String, Object> e(ContainerPriority r100);

    void f(ECUIPromotion r100);

    d g();

    boolean h(Decision r100);

    boolean i(ql.a r100, int r101, boolean r102);

    void j(String r100);

    void k(ql.a r100);

    Object l();

    void m();

    @Deprecated(message = "临时兼容，二期改为动态可配")
    <T> T n(Scene r100, KClass<T> r101, Context r102);

    com.bytedance.android.livesdk.livecommerce.largemode.b o();

    boolean p(View r100, ql.a r101);
}
