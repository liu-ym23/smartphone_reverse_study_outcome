package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.GradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxAirCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MultiCouponButtonComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MultiGradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.CouponButtonElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.c;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.CouponButtonElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.CouponButtonElementViewV2;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.IconsWithSpaceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.InlineLongTitleComponentView;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001`\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kB)\b\u0007\u0012\u0006\u0010e\u001a\u00020d\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bh\u0010iJ\u001a\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010#\u001a\u00020\"J\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016J(\u0010-\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\b\u0010.\u001a\u00020\u000eH\u0014J\u000f\u00101\u001a\u00020\u000eH\u0001¢\u0006\u0004\b/\u00100J\u0012\u00104\u001a\u0004\u0018\u0001032\u0006\u00102\u001a\u00020\nH\u0016R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000203058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010@R#\u0010M\u001a\n H*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010c¨\u0006l"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/LongContentLabelComponentView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "component", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "background", "bindLynxCard", "", "paddingTop", "paddingBottom", "height", "", "addHybridView", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxAirCardComponent;", "bindLynxAirCard", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "description", "bind", "update", "getHeadLayout", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "actionHub", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "showEvent", "", "descriptionVO", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "associatedAction", "", "isLynxView", "", "getSchema", "Landroid/graphics/Canvas;", "canvas", "draw", "w", "h", "oldw", "oldh", "onSizeChanged", "onAttachedToWindow", "destroy$ec_shopping_impl_saasRelease", "()V", MapMonitorConst.EVENT_DESTROY, "id", "Landroid/view/View;", "_$_findCachedViewById", "", "_$_findViewCache", "Ljava/util/Map;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "radiusHelper", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "Lti/l;", "hybridComponent", "Lti/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "headButtonView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiCouponButtonComponentView;", "couponButtonView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiCouponButtonComponentView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiGradientTextWithIconsComponentView;", "headLabelView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiGradientTextWithIconsComponentView;", "tailButtonView", "kotlin.jvm.PlatformType", "root$delegate", "Lkotlin/Lazy;", "getRoot", "()Landroid/widget/LinearLayout;", RootDescription.ROOT_ELEMENT, "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "lynxCard", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "isLynx", "Z", "schema", "Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "skuSpecText", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "getSkuSpecText", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "setSkuSpecText", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;)V", "Landroidx/lifecycle/Lifecycle;", "cachedLifecycle", "Landroidx/lifecycle/Lifecycle;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "com/bytedance/android/shopping/anchorv4/voavhs/base/components/LongContentLabelComponentView$b", "cardLifeCycle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/LongContentLabelComponentView$b;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongContentLabelComponentView extends LinearLayout implements ActionHubAccessor, d, LifecycleObserver {
    public static final a Companion = null;
    private static final String TAG = null;
    private Map<Integer, View> _$_findViewCache;
    private com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub;
    private Lifecycle cachedLifecycle;
    private final b cardLifeCycle;
    private MultiCouponButtonComponentView couponButtonView;
    private LongContentLabelComponent descriptionVO;
    private TagsScrollBoxComponentView headButtonView;
    private MultiGradientTextWithIconsComponentView headLabelView;
    private l hybridComponent;
    private boolean isLynx;
    private ECLynxCard lynxCard;
    private final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b radiusHelper;
    private final Lazy root$delegate;
    private String schema;
    private c skuSpecText;
    private TagsScrollBoxComponentView tailButtonView;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends IECLynxCardLifeCycle.Base {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongContentLabelComponentView f167797a;

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle.Base, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onRuntimeReady() {
            ECLynxCard r100 = LongContentLabelComponentView.access$getLynxCard$p(this.f167797a);
            if (r100 == null) goto L5;
            r100.n();
        L5:
            dm.a.b r101 = dm.a.f469202a;
            dm.a.a(LongContentLabelComponentView.access$getTAG$cp()).i("IECLynxCardLifeCycle onRuntimeReady");
        }

        public b(LongContentLabelComponentView r100) {
            this.f167797a = r100;
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle.Base, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            dm.a.b r103 = dm.a.f469202a;
            dm.a.a(LongContentLabelComponentView.access$getTAG$cp()).i("IECLynxCardLifeCycle onLoadFailed: type:" + r100.name() + ", errorCode: " + r101 + ", errorMsg: " + r102);
        }
    }

    public LongContentLabelComponentView(Context r100) {
        this(r100, null, null, 6, null);
    }

    public LongContentLabelComponentView(Context r100, AttributeSet r101) {
        this(r100, r101, null, 4, null);
    }

    private final LinearLayout getRoot() {
        return (LinearLayout) this.root$delegate.getValue();
    }

    static {
        Companion = new a();
        TAG = com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.b.class.getSimpleName();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public Action associatedAction() {
        LongContentLabelComponent r100 = this.descriptionVO;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAction();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy$ec_shopping_impl_saasRelease() {
        l r100 = this.hybridComponent;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        Lifecycle r101 = this.cachedLifecycle;
        if (r101 == null) goto L9;
        r101.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public List<ShowEvent> showEvent() {
        LongContentLabelComponent r100 = this.descriptionVO;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getShowEvent();
    }

    public final LinearLayout getHeadLayout() {
        return (LinearLayout) _$_findCachedViewById(R.id.long_content_head_layout);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = za3.a.f571086a;
        Intrinsics.checkNotNullParameter(this, "view");
        Object r101 = getTag(R.id.ec_view_tree_lifecycle_owner);
        Lifecycle r102 = null;
        if ((r101 instanceof LifecycleOwner) == true) goto L5;
        r101 = null;
    L5:
        LifecycleOwner r103 = (LifecycleOwner) r101;
        if (r103 != null) goto L16;
        Object r104 = getParent();
    L9:
        if (r103 != null) goto L16;
        if ((r104 instanceof View) == false) goto L16;
        View r105 = (View) r104;
        Object r106 = r105.getTag(R.id.ec_view_tree_lifecycle_owner);
        if ((r106 instanceof LifecycleOwner) == true) goto L15;
        r106 = null;
    L15:
        r103 = (LifecycleOwner) r106;
        r104 = r105.getParent();
    L16:
        if (r103 == null) goto L18;
        r102 = r103.getLifecycle();
    L18:
        if (r102 == null) goto L20;
    L26:
        this.cachedLifecycle = r102;
        if (r102 == null) goto L34;
        r102.addObserver(this);
        return;
    L34:
        return;
    L20:
        if ((getContext() instanceof LifecycleOwner) == false) goto L26;
        Object r107 = getContext();
        if (r107 == null) goto L25;
        r102 = ((LifecycleOwner) r107).getLifecycle();
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.actionHub;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public Object descriptionVO() {
        return this.descriptionVO;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final String getSchema() {
        return this.schema;
    }

    public final c getSkuSpecText() {
        return this.skuSpecText;
    }

    public final boolean isLynxView() {
        return this.isLynx;
    }

    public static final /* synthetic */ ECLynxCard access$getLynxCard$p(LongContentLabelComponentView r100) {
        return r100.lynxCard;
    }

    public View _$_findCachedViewById(int r100) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new LinkedHashMap();
    L5:
        View r101 = this._$_findViewCache.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this._$_findViewCache.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final LongContentLabelComponentView bind(LongContentLabelComponent r210) {
        this.descriptionVO = r210;
        if (r210 != null) goto L6;
        setVisibility(8);
        return this;
    L6:
        ExtensionsKt.j(this, r210.getBackground());
        int r100 = 1;
        if (r210.getLynxCard() == null) goto L11;
        this.isLynx = true;
        return bindLynxCard(r210.getLynxCard(), r210.getBackground());
    L11:
        if (r210.getLynxAirCard() == null) goto L14;
        this.isLynx = true;
        return bindLynxAirCard(r210.getLynxAirCard(), r210.getBackground());
    L14:
        ExtensionsKt.a(this, r210.getAlignStrategy());
        ExtensionsKt.a((LinearLayout) _$_findCachedViewById(R.id.long_content_component_root), r210.getAlignStrategy());
        ExtensionsKt.a((LinearLayout) _$_findCachedViewById(R.id.long_content_head_layout), r210.getAlignStrategy());
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r101 = this.radiusHelper;
        Background r102 = r210.getBackground();
        AttributeSet r103 = null;
        if (r102 == null) goto L17;
        Radius r104 = r102.getRadius();
    L18:
        r101.f(r104);
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_head_layout)).removeAllViews();
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_tail_layout)).removeAllViews();
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_head_overflow)).removeAllViews();
        TagsScrollBoxComponent r105 = r210.getHeadButtons();
        int r106 = 14;
        int r110 = 0;
        if (r105 == null) goto L21;
        TagsScrollBoxComponentView r111 = new TagsScrollBoxComponentView(getContext(), null, 0, 14);
        r111.setSkuSpecText(this.skuSpecText);
        r111.setOverflowContainer((ViewGroup) _$_findCachedViewById(R.id.long_content_head_overflow));
        this.headButtonView = r111;
        TagsScrollBoxComponentView.b(r111, r105, null, 14);
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_head_layout)).addView(r111);
    L21:
        MultiCouponButtonComponent r107 = r210.getHeadCouponButtons();
        int r108 = -2;
        if (r107 == null) goto L51;
        MultiCouponButtonComponentView r112 = new MultiCouponButtonComponentView(getContext(), null, 0, 14);
        this.couponButtonView = r112;
        r112.f167806a = r107;
        List<CouponButtonElement> r113 = r107.getButtonList();
        if (r113 != null) goto L27;
        r112.setVisibility(8);
    L50:
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_head_layout)).addView(r112);
        goto L51
    L27:
        ExtensionsKt.a(r112, r107.getAlignStrategy());
        Iterator<T> r114 = r113.iterator();
        int r115 = 0;
    L29:
        if (r114.hasNext() == false) goto L49;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        CouponButtonElement r109 = (CouponButtonElement) r116;
        if (r107.getCouponType() != 0) goto L40;
        CouponButtonElementView r118 = new CouponButtonElementView(r112.getContext(), r103, r110, r106);
        r118.R5(r109);
        ViewGroup.MarginLayoutParams r119 = new ViewGroup.MarginLayoutParams(r108, r108);
        if (r115 <= 0) goto L38;
        r119.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r107.getSpace()));
    L38:
        Unit r120 = Unit.INSTANCE;
        r112.addView(r118, r119);
    L48:
        r115 = r117;
        r100 = 1;
        r103 = null;
        r108 = -2;
        r106 = 14;
        r110 = 0;
        goto L29
    L40:
        if (r107.getCouponType() != r100) goto L48;
        int r121 = r113.size();
        double r122 = n1.f45657f - (com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r107.getSpace())) * (r121 - 1));
        double r123 = (1.0d / ((double) r121)) * r122;
        if (r121 != r100) goto L44;
        r123 = r122 * 0.5d;
    L44:
        CouponButtonElementViewV2 r124 = new CouponButtonElementViewV2(r112.getContext(), null, 0, 14);
        r124.a(r109);
        ViewGroup.MarginLayoutParams r125 = new ViewGroup.MarginLayoutParams((int) r123, -2);
        if (r115 <= 0) goto L47;
        r125.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r107.getSpace()));
    L47:
        Unit r126 = Unit.INSTANCE;
        r112.addView(r124, r125);
        goto L48
    L49:
        ViewGroup.MarginLayoutParams r127 = new ViewGroup.MarginLayoutParams(-2, -2);
        r127.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r107.getLeftSpace()));
        Unit r128 = Unit.INSTANCE;
        r112.setLayoutParams(r127);
        Action r129 = r107.getAction();
        Intrinsics.checkNotNullParameter(r112, "theView");
        ActionHubAccessor.DefaultImpls.a(r112, r112, r129);
    L51:
        MultiGradientTextWithIconsComponent r130 = r210.getHeadLabels();
        if (r130 == null) goto L107;
        MultiGradientTextWithIconsComponentView r131 = new MultiGradientTextWithIconsComponentView(getContext(), null, 0, 14);
        this.headLabelView = r131;
        r131.f167808a = r130;
        List<GradientTextWithIconsComponent> r132 = r130.getLabelList();
        if (r132 != null) goto L57;
        r131.setVisibility(8);
    L106:
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_head_layout)).addView(r131);
        goto L107
    L57:
        ExtensionsKt.a(r131, r130.getAlignStrategy());
        Iterator<T> r133 = r132.iterator();
        int r134 = 0;
    L59:
        if (r133.hasNext() == false) goto L105;
        Object r135 = r133.next();
        int r136 = r134 + 1;
        if (r134 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        GradientTextWithIconsComponent r137 = (GradientTextWithIconsComponent) r135;
        GradientTextWithIconsComponentView r138 = new GradientTextWithIconsComponentView(r131.getContext(), null, 6);
        r138.f167793b = r137;
        if (r137 == null) goto L66;
        Background r139 = r137.getBackground();
    L67:
        ExtensionsKt.j(r138, r139);
        if (r137 == null) goto L97;
        LongTitleComponent r140 = r137.getContent();
        if (r140 == null) goto L97;
        if (r140.getInline() == false) goto L74;
        ((InlineLongTitleComponentView) r138.a(R.id.inline_long_title_component)).x(r140);
        r138.a(R.id.inline_long_title_component).setVisibility(0);
        r138.a(R.id.long_title_component).setVisibility(8);
        int r141 = 0;
    L96:
        r138.setVisibility(r141);
    L98:
        if (r137 == null) goto L100;
        Action r142 = r137.getAction();
    L101:
        Intrinsics.checkNotNullParameter(r138, "theView");
        ActionHubAccessor.DefaultImpls.a(r138, r138, r142);
        ViewGroup.MarginLayoutParams r143 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r134 <= 0) goto L104;
        r143.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getSpace()));
    L104:
        Unit r144 = Unit.INSTANCE;
        r131.addView(r138, r143);
        r134 = r136;
        goto L59
    L100:
        r142 = null;
        goto L101
    L74:
        LongTitleComponentView r145 = (LongTitleComponentView) r138.a(R.id.long_title_component);
        r145.f167799b = r140;
        ExtensionsKt.a(r145, r140.getAlignStrategy());
        IconsWithSpaceElement r146 = r140.getHeadIcons();
        if (r146 == null) goto L77;
        ((IconsWithSpaceElementView) r145.a(R.id.long_title_head_icons)).a(r146);
        ((IconsWithSpaceElementView) r145.a(R.id.long_title_head_icons)).setVisibility(0);
    L78:
        TextElement r147 = r140.getContent();
        if (r147 == null) goto L81;
        ((TextElementView) r145.a(R.id.long_title_content)).x(r147);
        ((TextElementView) r145.a(R.id.long_title_content)).setVisibility(0);
    L82:
        IconsWithSpaceElement r148 = r140.getTailIcons();
        if (r148 == null) goto L94;
        ((IconsWithSpaceElementView) r145.a(R.id.long_title_tail_icons)).a(r148);
        ((IconsWithSpaceElementView) r145.a(R.id.long_title_tail_icons)).setVisibility(0);
        ViewGroup.LayoutParams r149 = ((IconsWithSpaceElementView) r145.a(R.id.long_title_tail_icons)).getLayoutParams();
        if ((r149 instanceof ViewGroup.MarginLayoutParams) == true) goto L87;
        r149 = null;
    L87:
        ViewGroup.MarginLayoutParams r150 = (ViewGroup.MarginLayoutParams) r149;
        if (r150 == null) goto L90;
        r150.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r148.getSpace()));
        Unit r151 = Unit.INSTANCE;
    L91:
        if (r151 == null) goto L94;
        int r152 = 8;
    L95:
        Action r153 = r140.getAction();
        Intrinsics.checkNotNullParameter(r145, "theView");
        ActionHubAccessor.DefaultImpls.a(r145, r145, r153);
        r141 = 0;
        r138.a(R.id.long_title_component).setVisibility(0);
        r138.a(R.id.inline_long_title_component).setVisibility(r152);
        goto L96
    L90:
        r151 = null;
    L94:
        r152 = 8;
        ((IconsWithSpaceElementView) r145.a(R.id.long_title_tail_icons)).setVisibility(8);
        Unit r154 = Unit.INSTANCE;
        goto L95
    L81:
        ((TextElementView) r145.a(R.id.long_title_content)).setVisibility(8);
        goto L82
    L77:
        ((IconsWithSpaceElementView) r145.a(R.id.long_title_head_icons)).setVisibility(8);
    L97:
        r138.setVisibility(8);
        goto L98
    L66:
        r139 = null;
        goto L67
    L105:
        ViewGroup.MarginLayoutParams r155 = new ViewGroup.MarginLayoutParams(-2, -2);
        r155.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getLeftSpace()));
        Unit r156 = Unit.INSTANCE;
        r131.setLayoutParams(r155);
        Action r157 = r130.getAction();
        Intrinsics.checkNotNullParameter(r131, "theView");
        ActionHubAccessor.DefaultImpls.a(r131, r131, r157);
    L107:
        TagsScrollBoxComponent r158 = r210.getTailButtons();
        if (r158 == null) goto L110;
        TagsScrollBoxComponentView r159 = new TagsScrollBoxComponentView(getContext(), null, 0, 14);
        this.tailButtonView = r159;
        TagsScrollBoxComponentView.b(r159, r158, null, 14);
        ((LinearLayout) _$_findCachedViewById(R.id.long_content_tail_layout)).addView(r159);
    L110:
        configPossibleAction(this, r210.getAction());
        return this;
    L17:
        r104 = null;
        goto L18
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.radiusHelper.e(r100);
        super.draw(r100);
        this.radiusHelper.d(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.actionHub = r100;
    }

    public final void setSkuSpecText(c r100) {
        this.skuSpecText = r100;
    }

    public final void update(LongContentLabelComponent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.descriptionVO = r100;
        TagsScrollBoxComponent r101 = r100.getHeadButtons();
        if (r101 == null) goto L9;
        TagsScrollBoxComponentView r102 = this.headButtonView;
        if (r102 == null) goto L9;
        r102.update(r101);
    L9:
        MultiCouponButtonComponent r103 = r100.getHeadCouponButtons();
        if (r103 == null) goto L14;
        MultiCouponButtonComponentView r104 = this.couponButtonView;
        if (r104 == null) goto L14;
        r104.update(r103);
    L14:
        MultiGradientTextWithIconsComponent r105 = r100.getHeadLabels();
        if (r105 == null) goto L19;
        MultiGradientTextWithIconsComponentView r106 = this.headLabelView;
        if (r106 == null) goto L19;
        r106.update(r105);
    L19:
        TagsScrollBoxComponent r107 = r100.getTailButtons();
        if (r107 == null) goto L25;
        TagsScrollBoxComponentView r108 = this.tailButtonView;
        if (r108 == null) goto L26;
        r108.update(r107);
        return;
    L26:
        return;
    }

    public static final /* synthetic */ void access$setLynxCard$p(LongContentLabelComponentView r100, ECLynxCard r101) {
        r100.lynxCard = r101;
    }

    private final LongContentLabelComponentView bindLynxAirCard(LynxAirCardComponent r100, Background r101) {
        this.schema = r100.getSchema();
        String r102 = r100.getSchema();
        if (r102 != null) goto L5;
    L13:
        return this;
    L5:
        if (this.lynxCard != null) goto L7;
        this.lynxCard = new ECLynxCard();
    L7:
        ECLynxLoadParam.a r103 = new ECLynxLoadParam.a(getContext(), r102, this);
        r103.j(2000);
        r103.f46345j = r100.getData();
        r103.f(this.cardLifeCycle);
        LinkedHashMap r104 = new LinkedHashMap();
        String r105 = AnchorV4DataManager.f166338d;
        if (r105 == null) goto L10;
        r104.put(LocationMonitorConst.IDENTIFIER, r105);
    L10:
        Unit r106 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "ecGlobalProps");
        r103.f46351p = r104;
        ECLynxLoadParam r107 = new ECLynxLoadParam(r103);
        ECLynxCard r108 = this.lynxCard;
        if (r108 == null) goto L13;
        r108.j(r107);
        goto L13
    }

    private final LongContentLabelComponentView bindLynxCard(LynxCardComponent r110, Background r111) {
        this.schema = r110.getSchema();
        String r100 = r110.getSchema();
        if (r100 == null) goto L37;
        String r101 = r110.getData();
        if (r101 == null) goto L9;
        JSONObject r102 = k.w(r101);
        if (r102 == null) goto L9;
        Map<String, ? extends Object> r103 = com.bytedance.android.shopping.hybrid.a.b(r102);
    L10:
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        if (r103 == null) goto L16;
        Iterator<Map.Entry<String, ? extends Object>> r105 = r103.entrySet().iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r106 = r105.next();
        r104.appendQueryParameter(r106.getKey(), r106.getValue().toString());
    L16:
        String r107 = AnchorV4DataManager.f166338d;
        if (r107 == null) goto L19;
        r104.appendQueryParameter(LocationMonitorConst.IDENTIFIER, r107);
    L19:
        String r108 = r104.build().toString();
        l r109 = this.hybridComponent;
        if (r109 == null) goto L22;
        r109.renderTemplate(r108, r103);
        goto L37
    L22:
        l r112 = ECLiveHybridUtil.b(getContext(), r108, r103, null, null, null, null, false, null, null, false, 4088);
        this.hybridComponent = r112;
        w.a.e(w.f166998b, r112, getContext(), null, 12);
        int r113 = 0;
        if (r111 == null) goto L27;
        Padding r114 = r111.getPadding();
        if (r114 == null) goto L27;
        int r115 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r114.getTop()));
    L28:
        if (r111 == null) goto L32;
        Padding r116 = r111.getPadding();
        if (r116 == null) goto L32;
        r113 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r116.getBottom()));
    L32:
        int r117 = r110.getHeight();
        if (r117 != null) goto L36;
        r117 = 60;
    L36:
        addHybridView(r115, r113, com.bytedance.android.shopping.extensions.b.b(r117));
        Unit r118 = Unit.INSTANCE;
    L27:
        r115 = 0;
    L9:
        r103 = null;
    L37:
        return this;
    }

    public void configPossibleAction(View r100, Action r101) {
        Intrinsics.checkNotNullParameter(r100, "theView");
        ActionHubAccessor.DefaultImpls.a(this, r100, r101);
    }

    public LongContentLabelComponentView(Context r100, AttributeSet r101, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.actionHub = r102;
        this._$_findViewCache = new LinkedHashMap();
        this.radiusHelper = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.root$delegate = LazyKt.lazy(new LongContentLabelComponentView$root$2(this));
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_anchor_v4_long_conent_label_component, this, true);
        this.cardLifeCycle = new b(this);
    }

    private final void addHybridView(int r100, int r101, int r102) {
        l r103 = this.hybridComponent;
        if (r103 == null) goto L7;
        View r104 = r103.getHybridView();
        if (r104 == null) goto L7;
        getRoot().addView(r104, new LinearLayout.LayoutParams(-1, (r102 - r101) - r100));
        return;
    L7:
        setVisibility(8);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.radiusHelper.c(r100, r101);
    }

    public /* synthetic */ LongContentLabelComponentView(Context r100, AttributeSet r101, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
