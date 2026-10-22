package com.bytedance.android.shopping.anchorv4.nav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.i;
import com.bytedance.android.shopping.anchorv4.nav.blur.NavBlurAdapter;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u0010Q\u001a\u00020P\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010U\u001a\u00020T¢\u0006\u0004\bV\u0010WJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001c\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010!\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010%R\u001b\u0010)\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010 R\u001b\u0010,\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b+\u0010%R\u001b\u0010/\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b.\u0010%R\u001b\u00104\u001a\u0002008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b2\u00103R#\u00107\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b6\u0010\u0018R#\u0010:\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\t\u001a\u0004\b9\u0010\u0018R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b=\u0010>R*\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006X"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/nav/AnchorV4NavArea;", "Landroid/widget/FrameLayout;", "", "fullscreenMode", "", "setupWithFullMode", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getCloseBtn", "()Landroid/widget/ImageView;", "closeBtn", "b", "getCloseShadowBtn", "closeShadowBtn", "Lcom/bytedance/android/shopping/anchorv4/nav/AnchorV4SearchEditView;", "c", "getSearchEditView", "()Lcom/bytedance/android/shopping/anchorv4/nav/AnchorV4SearchEditView;", "searchEditView", "Landroid/view/View;", "d", "getDarkArea", "()Landroid/view/View;", "darkArea", "e", "getWhiteArea", "whiteArea", "Landroid/view/ViewGroup;", "f", "getDarkIconsLayout", "()Landroid/view/ViewGroup;", "darkIconsLayout", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", ce.f26391f, "getDarkIcons", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "darkIcons", "h", "getLightIconsLayout", "lightIconsLayout", RXScreenCaptureService.KEY_INDEX, "getLightIcons", "lightIcons", ce.f26395j, "getOffscreenIcons", "offscreenIcons", "Landroid/widget/TextView;", ce.f26396k, "getTitleView", "()Landroid/widget/TextView;", "titleView", "l", "getTopAreaMask", "topAreaMask", "m", "getTopAreaMaskV2", "topAreaMaskV2", "Lr73/a;", OfficeSDKRequestTag.KEY_NEW_USER, "getNavBlurHandler", "()Lr73/a;", "navBlurHandler", "Lkotlin/Function0;", "p", "Lkotlin/jvm/functions/Function0;", "getCloseListener", "()Lkotlin/jvm/functions/Function0;", "setCloseListener", "(Lkotlin/jvm/functions/Function0;)V", "closeListener", "Lr73/c;", "q", "Lr73/c;", "getNavBlurTabDepend", "()Lr73/c;", "setNavBlurTabDepend", "(Lr73/c;)V", "navBlurTabDepend", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4NavArea extends FrameLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f167069r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f167070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f167071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f167072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f167073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f167074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f167075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f167076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f167077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f167078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f167079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f167080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f167081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f167082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f167083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f167084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f167085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public r73.c f167086q;

    public static final class a {
    }

    static {
    }

    public AnchorV4NavArea(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4NavArea(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ImageView getCloseBtn() {
        return (ImageView) this.f167070a.getValue();
    }

    private final ImageView getCloseShadowBtn() {
        return (ImageView) this.f167071b.getValue();
    }

    private final View getDarkArea() {
        return (View) this.f167073d.getValue();
    }

    private final r73.a getNavBlurHandler() {
        return (r73.a) this.f167083n.getValue();
    }

    private final View getTopAreaMask() {
        return (View) this.f167081l.getValue();
    }

    private final View getTopAreaMaskV2() {
        return (View) this.f167082m.getValue();
    }

    private final View getWhiteArea() {
        return (View) this.f167074e.getValue();
    }

    public final TagsScrollBoxComponentView getDarkIcons() {
        return (TagsScrollBoxComponentView) this.f167076g.getValue();
    }

    public final ViewGroup getDarkIconsLayout() {
        return (ViewGroup) this.f167075f.getValue();
    }

    public final TagsScrollBoxComponentView getLightIcons() {
        return (TagsScrollBoxComponentView) this.f167078i.getValue();
    }

    public final ViewGroup getLightIconsLayout() {
        return (ViewGroup) this.f167077h.getValue();
    }

    public final TagsScrollBoxComponentView getOffscreenIcons() {
        return (TagsScrollBoxComponentView) this.f167079j.getValue();
    }

    public final AnchorV4SearchEditView getSearchEditView() {
        return (AnchorV4SearchEditView) this.f167072c.getValue();
    }

    public final TextView getTitleView() {
        return (TextView) this.f167080k.getValue();
    }

    public final void c() {
        if (r73.b.b() == false) goto L5;
        getTopAreaMaskV2().setVisibility(0);
    L5:
        r73.a r100 = getNavBlurHandler();
        r100.getClass();
        if (r73.b.a() == true) goto L8;
        return;
    L8:
        if (r100.f536421e == true) goto L13;
        RecyclerView r101 = r100.f536417a;
        LinearLayoutManager r102 = new LinearLayoutManager(r101.getRootView().getContext());
        r102.setOrientation(0);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutManager(r102);
        r101.setAdapter(new NavBlurAdapter(r101.getRootView().getContext(), r100.f536423g));
        r101.setAdapter(r101.getAdapter());
        r101.setVisibility(0);
        r100.f536421e = true;
        return;
    }

    public final Function0<Unit> getCloseListener() {
        return this.f167085p;
    }

    public final r73.c getNavBlurTabDepend() {
        return this.f167086q;
    }

    public static final /* synthetic */ View a(AnchorV4NavArea r100) {
        return r100.getTopAreaMaskV2();
    }

    public final void d(int r100) {
        r73.a r101 = getNavBlurHandler();
        r101.getClass();
        if (r73.b.a() == false) goto L10;
        int r102 = r101.f536418b;
        float r103 = 1.0f;
        if (r102 == 0) goto L8;
        r103 = RangesKt.coerceAtMost(1.0f, r100 / r102);
    L8:
        r101.f536422f.setAlpha(1 - ((float) Math.sqrt(r103)));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f167084o == true) goto L5;
        return false;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    public final void e(float r100) {
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L5;
        r100 = 1.0f;
    L5:
        Iterator r101 = CollectionsKt.listOf(new View[]{getDarkArea(), getCloseBtn()}).iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        View r102 = (View) r101.next();
        r102.setAlpha(1 - r100);
        if (r102.getAlpha() == 0.0f) goto L10;
        r102.setVisibility(0);
        goto L7
    L10:
        r102.setVisibility(8);
        goto L7
    L12:
        Iterator r103 = CollectionsKt.listOf(new View[]{getSearchEditView(), getWhiteArea(), getCloseShadowBtn(), getTopAreaMask(), getTopAreaMaskV2()}).iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        View r104 = (View) r103.next();
        if (r104 == null) goto L14;
        r104.setAlpha(r100);
        goto L14
    L18:
        AnchorV4SearchEditView r105 = getSearchEditView();
        com.bytedance.android.shopping.anchorv3.widget.e r106 = r105.getLogAction();
        if (r106 == null) goto L37;
        com.bytedance.android.shopping.anchorv3.widget.f r107 = r105.getSearchParams();
        if (r107 == null) goto L23;
        String r108 = r107.f165605c;
    L24:
        r106.a(r108, r105.getSearchInfo());
        return;
    L23:
        r108 = null;
        goto L24
    }

    public final void f(float r100) {
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L6;
        setAlpha(RangesKt.coerceAtLeast(0.0f, r100));
        setVisibility(0);
        return;
    L6:
        if (r100 < 1.0f) goto L8;
        setAlpha(1.0f);
        setVisibility(0);
        return;
    L8:
        setAlpha(0.0f);
        setVisibility(8);
    }

    public final void h(i r100) {
        Intrinsics.checkNotNullParameter(r100, "theSuggest");
        AnchorV4SearchEditView r101 = getSearchEditView();
        String r102 = r100.f165115a;
        r101.f165574b = r100;
        if (r102 == null) goto L12;
        String r103 = a2.d(r102);
        if (r103 == null) goto L12;
        TextView r104 = r101.f165573a;
        if (r104 == null) goto L9;
        r104.setText(r103);
    L9:
        TextView r105 = r101.f165573a;
        if (r105 == null) goto L12;
        r105.setContentDescription(r103.concat(" 搜索栏"));
    L12:
        r101.b();
    }

    public final void setCloseListener(Function0<Unit> r100) {
        this.f167085p = r100;
    }

    public final void setNavBlurTabDepend(r73.c r100) {
        this.f167086q = r100;
    }

    public final void setupWithFullMode(boolean r100) {
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L6;
        if (r100 == true) goto L6;
        setAlpha(0.0f);
        setVisibility(4);
    L6:
        ImageView r101 = getCloseBtn();
        if (r100 == false) goto L9;
        int r102 = R.drawable.ec_commerce_anchor_v4_back_arrow;
    L10:
        r101.setImageResource(r102);
        ImageView r103 = getCloseShadowBtn();
        if (r100 == false) goto L13;
        int r104 = R.drawable.ec_commerce_anchor_v4_back_arrow_shadow;
    L14:
        r103.setImageResource(r104);
        return;
    L13:
        r104 = R.drawable.commerce_anchor_v4_back_cross_shadow;
        goto L14
    L9:
        r102 = R.drawable.commerce_anchor_v4_back_cross;
        goto L10
    }

    public final void g(Boolean r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.booleanValue() == false) goto L12;
        ImageView r102 = getCloseBtn();
        if (r101 == false) goto L8;
        int r103 = R.drawable.ec_commerce_anchor_v4_back_arrow_shadow;
    L9:
        r102.setImageResource(r103);
        return;
    L8:
        r103 = R.drawable.commerce_anchor_v4_back_cross_shadow;
        goto L9
    }

    public AnchorV4NavArea(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167070a = LazyKt.lazy(new AnchorV4NavArea$closeBtn$2(this));
        this.f167071b = LazyKt.lazy(new AnchorV4NavArea$closeShadowBtn$2(this));
        this.f167072c = LazyKt.lazy(new AnchorV4NavArea$searchEditView$2(this));
        this.f167073d = LazyKt.lazy(new AnchorV4NavArea$darkArea$2(this));
        this.f167074e = LazyKt.lazy(new AnchorV4NavArea$whiteArea$2(this));
        this.f167075f = LazyKt.lazy(new AnchorV4NavArea$darkIconsLayout$2(this));
        this.f167076g = LazyKt.lazy(new AnchorV4NavArea$darkIcons$2(this));
        this.f167077h = LazyKt.lazy(new AnchorV4NavArea$lightIconsLayout$2(this));
        this.f167078i = LazyKt.lazy(new AnchorV4NavArea$lightIcons$2(this));
        this.f167079j = LazyKt.lazy(new AnchorV4NavArea$offscreenIcons$2(this));
        this.f167080k = LazyKt.lazy(new AnchorV4NavArea$titleView$2(this));
        this.f167081l = LazyKt.lazy(new AnchorV4NavArea$topAreaMask$2(this));
        this.f167082m = LazyKt.lazy(new AnchorV4NavArea$topAreaMaskV2$2(this));
        this.f167083n = LazyKt.lazy(new AnchorV4NavArea$navBlurHandler$2(this));
        this.f167084o = true;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_nav_area, this, true);
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L5;
        float r103 = 1.0f;
    L6:
        setAlpha(r103);
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L24;
        e(1.0f);
        if (r73.b.b() == false) goto L24;
        AnchorV4SearchEditView r104 = getSearchEditView();
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        ViewGroup.LayoutParams r106 = null;
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r105 = null;
    L13:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105;
        if (r107 == null) goto L16;
        r107.leftMargin = 0;
        r107.rightMargin = 0;
        r104.setLayoutParams(r107);
    L16:
        ViewGroup r108 = getLightIconsLayout();
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r106 = r109;
    L20:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r106;
        if (r110 == null) goto L23;
        r110.leftMargin = 0;
        r110.rightMargin = 0;
        r108.setLayoutParams(r110);
    L23:
        getCloseShadowBtn().setPadding(0, com.bytedance.android.shopping.extensions.b.b(5), 0, com.bytedance.android.shopping.extensions.b.b(5));
    L24:
        Iterator r111 = CollectionsKt.listOf(new ImageView[]{getCloseBtn(), getCloseShadowBtn()}).iterator();
    L26:
        if (r111.hasNext() == false) goto L28;
        ((ImageView) r111.next()).setOnClickListener(new com.bytedance.android.shopping.anchorv4.nav.a(this));
        goto L26
    L28:
        return;
    L5:
        r103 = 0.0f;
        goto L6
    }

    public /* synthetic */ AnchorV4NavArea(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(boolean r100, Integer r101, Integer r102, boolean r103) {
        r73.a r104 = getNavBlurHandler();
        r104.getClass();
        if (r73.b.a() == false) goto L40;
        int r105 = 0;
        if (r103 == false) goto L18;
        RecyclerView.LayoutManager r106 = r104.f536417a.getLayoutManager();
        if ((r106 instanceof LinearLayoutManager) == true) goto L10;
        r106 = null;
    L10:
        LinearLayoutManager r107 = (LinearLayoutManager) r106;
        if (r107 == null) goto L36;
        if (r101 == null) goto L14;
        int r108 = r101.intValue();
    L15:
        if (r102 == null) goto L17;
        r105 = r102.intValue();
    L17:
        r107.scrollToPositionWithOffset(r108, r105);
        return;
    L14:
        r108 = 0;
        goto L15
    L36:
        return;
    L18:
        RecyclerView r109 = r104.f536417a;
        if (r100 == false) goto L22;
        if (r101 == null) goto L28;
        int r110 = (r101.intValue() - r104.f536419c) * r104.f536418b;
    L29:
        r109.scrollBy(r110, 0);
        if (r101 == null) goto L32;
        r104.f536419c = r101.intValue();
    L32:
        if (r102 == null) goto L38;
        if (r100 == true) goto L39;
        r104.f536420d = r102.intValue();
        return;
    L39:
        return;
    L38:
        return;
    L28:
        r110 = 0;
        goto L29
    L22:
        if (r101 == null) goto L25;
        if (r102 == null) goto L25;
        int r111 = (r101.intValue() * r104.f536418b) + r102.intValue();
        int r112 = (r104.f536419c * r104.f536418b) + r104.f536420d;
    L27:
        r110 = r111 - r112;
    L25:
        if (r102 == null) goto L28;
        r111 = r102.intValue();
        r112 = r104.f536420d;
        goto L27
    }
}
