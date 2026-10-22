package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.api.d;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.shopping.store.utils.f;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b \u0010!R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedLynxCardView;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/ImageView;", "getLoadingImageView", "()Landroid/widget/ImageView;", "setLoadingImageView", "(Landroid/widget/ImageView;)V", "loadingImageView", "b", "Landroid/widget/FrameLayout;", "getLynxContainer", "()Landroid/widget/FrameLayout;", "setLynxContainer", "(Landroid/widget/FrameLayout;)V", "lynxContainer", "Lkotlin/Function1;", "", "", "c", "Lkotlin/jvm/functions/Function1;", "getOnLoadLynxSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLoadLynxSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "onLoadLynxSuccessCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShopFeedLynxCardView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f186180f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f186181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f186182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f186183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ShopFeedItemCard f186184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECLynxCard f186185e;

    public static final class a {
    }

    public static final class b implements IECLynxCardLifeCycle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsShopFeedLynxCardView f186186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f186187b;

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void createViewDuration(long r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onCreateKitViewEnd(long r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onFirstScreen() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onLoadStart() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onPreCreateView(boolean r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onRealSuccess() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onRuntimeReady() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onTimingSetup(Map<String, ? extends Object> r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onTimingSetupPref(k r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onTimingUpdatePref(k r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onTransDataTime(long r100, long r101) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onLoadSuccess() {
            ImageView r100 = this.f186186a.getLoadingImageView();
            if (r100 == null) goto L5;
            r100.setVisibility(8);
        L5:
            this.f186186a.getOnLoadLynxSuccessCallback().invoke(Integer.valueOf(this.f186187b));
            dm.a.a("AbsShopFeedLynxCardView").a("bindData onLoadSuccess");
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r100) {
            Intrinsics.checkNotNullParameter(r100, "cache");
            Intrinsics.checkNotNullParameter(r100, "cache");
        }

        public b(AbsShopFeedLynxCardView r100, int r101) {
            this.f186186a = r100;
            this.f186187b = r101;
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            dm.a.a("AbsShopFeedLynxCardView").a("bindData onLoadFailed errType: " + r100 + ", errorCode: " + r101 + " errMsg: " + r102);
        }
    }

    static {
    }

    public AbsShopFeedLynxCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsShopFeedLynxCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public Map b(ShopFeedItemCard r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "passThroughParams");
        return null;
    }

    public final ImageView getLoadingImageView() {
        return this.f186181a;
    }

    public final FrameLayout getLynxContainer() {
        return this.f186182b;
    }

    public final Function1<Integer, Unit> getOnLoadLynxSuccessCallback() {
        return this.f186183c;
    }

    public final void setLoadingImageView(ImageView r100) {
        this.f186181a = r100;
    }

    public final void setLynxContainer(FrameLayout r100) {
        this.f186182b = r100;
    }

    public final void setOnLoadLynxSuccessCallback(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f186183c = r100;
    }

    public final void c(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        dm.a.a("AbsShopFeedLynxCardView").a("item: " + hashCode() + ", sendJsEvent, event: " + r100 + ", params: " + r101);
        ECLynxCard r102 = this.f186185e;
        if (r102 == null) goto L6;
        r102.o(r100, r101);
        return;
    }

    public AbsShopFeedLynxCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186183c = AbsShopFeedLynxCardView$onLoadLynxSuccessCallback$1.INSTANCE;
    }

    public /* synthetic */ AbsShopFeedLynxCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(ShopFeedItemCard r100, String r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "passThroughParams");
        FrameLayout r103 = this.f186182b;
        if (r103 != null) goto L5;
        return;
    L5:
        this.f186184d = r100;
        LinkedHashMap r104 = new LinkedHashMap();
        String r105 = r100.getItemId();
        String r106 = "";
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r104.put("item_id", r105);
        r104.put("card_index", Integer.valueOf(r102));
        String r107 = r100.getLynxCardData();
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        r104.put("lynx_item_data", r107);
        r104.put("is_current_show", Boolean.valueOf(r110));
        r104.put("pass_through_params", r101);
        Map r108 = b(r100, r101, r110);
        if (r108 == null) goto L17;
        String r109 = f.b(r108);
        if (r109 != null) goto L16;
        r109 = "";
    L16:
        r104.put("extra", r109);
    L17:
        ECLynxCard r111 = this.f186185e;
        if (r111 == null) goto L26;
        int r112 = d.f46381e;
        r111.e(d.a.a(r104), true);
        ShopFeedItemCard r113 = this.f186184d;
        if (r113 == null) goto L37;
        Map<String, Object> r114 = r113.getExtraLynxCardData();
        if (r114 == null) goto L38;
        ECLynxCard r115 = this.f186185e;
        if (r115 == null) goto L39;
        r115.e(d.a.c("", r114), false);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L26:
        this.f186185e = new ECLynxCard();
        Context r116 = getContext();
        String r117 = r100.getLynxCardSchema();
        if (r117 == null) goto L30;
        r106 = r117;
    L30:
        ECLynxLoadParam.a r118 = new ECLynxLoadParam.a(r116, r106, r103);
        ViewGroup.LayoutParams r119 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r119, "ecLayoutParams");
        r118.f46356u = r119;
        r118.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ec.lynxCardSetData", new LynxStatefulBridgeProxy(new AbsShopFeedLynxCardView$makeJsBridgeMap$1(this), "ec.lynxCardSetData")), TuplesKt.to("openNativeSKU", new LynxStatefulBridgeProxy(new AbsShopFeedLynxCardView$makeJsBridgeMap$2(this), "openNativeSKU"))}));
        r118.f46345j = f.b(r104);
        Map<String, ? extends Object> r120 = r100.getExtraLynxCardData();
        if (r120 != null) goto L33;
        r120 = MapsKt.emptyMap();
    L33:
        Intrinsics.checkNotNullParameter(r120, "appendData");
        r118.f46348m = r120;
        b r121 = new b(this, r102);
        Intrinsics.checkNotNullParameter(r121, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r118.f46350o = r121;
        ECLynxLoadParam r122 = new ECLynxLoadParam(r118);
        ECLynxCard r123 = this.f186185e;
        if (r123 == null) goto L41;
        r123.j(r122);
        return;
    }
}
