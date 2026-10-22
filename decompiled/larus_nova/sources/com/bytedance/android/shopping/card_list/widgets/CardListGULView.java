package com.bytedance.android.shopping.card_list.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedStickyConfig;
import com.bytedance.android.shopping.api.mall.feed.d;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.card_list.utils.e;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u0004¢\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&RA\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0006\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00109\u001a\u0002032\u0006\u00104\u001a\u0002038\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010@\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006H"}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/CardListGULView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedStickyConfig;", "getStickyConfig", "", "height", "", "setSafeHeight", "Landroidx/recyclerview/widget/RecyclerView;", "getGULRecyclerView", "Lcom/bytedance/android/shopping/card_list/widgets/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/card_list/widgets/b;", "getViewState", "()Lcom/bytedance/android/shopping/card_list/widgets/b;", "setViewState", "(Lcom/bytedance/android/shopping/card_list/widgets/b;)V", "viewState", "Lcom/bytedance/android/shopping/card_list/widgets/a;", "b", "Lcom/bytedance/android/shopping/card_list/widgets/a;", "getViewAction", "()Lcom/bytedance/android/shopping/card_list/widgets/a;", "setViewAction", "(Lcom/bytedance/android/shopping/card_list/widgets/a;)V", "viewAction", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "e", "Lkotlin/Lazy;", "getMallFeedComponent", "()Lcom/bytedance/android/shopping/api/mall/feed/d;", "mallFeedComponent", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "f", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "getObjectContainer", "()Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "setObjectContainer", "(Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;)V", "objectContainer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rev", ce.f26391f, "Lkotlin/jvm/functions/Function1;", "getSetUpCallBack", "()Lkotlin/jvm/functions/Function1;", "setSetUpCallBack", "(Lkotlin/jvm/functions/Function1;)V", "setUpCallBack", "", "value", "h", "Z", "setShow", "(Z)V", "isShow", RXScreenCaptureService.KEY_INDEX, "I", "getOuterHeight", "()I", "setOuterHeight", "(I)V", "outerHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListGULView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f171929j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f171930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.card_list.widgets.a f171931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f171932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f171933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f171934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CardListObjectContainer f171935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super RecyclerView, Unit> f171936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f171937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f171938i;

    public static final class a {
    }

    static {
    }

    public CardListGULView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListGULView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final d getMallFeedComponent() {
        return (d) this.f171934e.getValue();
    }

    private final ECMallFeedStickyConfig getStickyConfig() {
        return new ECMallFeedStickyConfig(new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public final void f() {
        b r100 = this.f171930a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        b r101 = this.f171930a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L8:
        r100.b(r101.f171946c, new CardListGULView$initObserver$1(this), true);
        b r102 = this.f171930a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L11:
        b r103 = this.f171930a;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L14:
        r102.b(r103.f171947d, new CardListGULView$initObserver$2(this), true);
        b r104 = this.f171930a;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L17:
        b r105 = this.f171930a;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L20:
        r104.b(r105.f171948e, new CardListGULView$initObserver$3(this), true);
        b r106 = this.f171930a;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L23:
        b r107 = this.f171930a;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L26:
        r106.b(r107.f171949f, new CardListGULView$initObserver$4(this), true);
    }

    public final com.bytedance.android.shopping.card_list.widgets.a getViewAction() {
        com.bytedance.android.shopping.card_list.widgets.a r100 = this.f171931b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r100;
    }

    public final b getViewState() {
        b r100 = this.f171930a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r100;
    }

    private final RecyclerView getGULRecyclerView() {
        return CardListExtentionsKt.e(this);
    }

    public final CardListObjectContainer getObjectContainer() {
        return this.f171935f;
    }

    public final int getOuterHeight() {
        return this.f171938i;
    }

    public final Function1<RecyclerView, Unit> getSetUpCallBack() {
        return this.f171936g;
    }

    public static final /* synthetic */ d a(CardListGULView r100) {
        return r100.getMallFeedComponent();
    }

    public static final /* synthetic */ ECMallFeedStickyConfig b(CardListGULView r100) {
        return r100.getStickyConfig();
    }

    public static final void c(final CardListGULView r100) {
        r100.getClass();
        r100.setSafeHeight(com.bytedance.android.shopping.extensions.b.b(12));
        r100.setShow(false);
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r101 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        Function0<Unit> r102 = new CardListGULView$initOrReload$1(r100);
        Intrinsics.checkNotNullParameter(r102, "task");
        Completable.timer(5, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.shopping.card_list.utils.d(r102), new e(null));
    }

    public static final void d(CardListGULView r100) {
        r100.setShow(false);
        r100.setSafeHeight(0);
    }

    public static final void e(CardListGULView r100) {
        r100.setShow(true);
        r100.setSafeHeight(r100.f171938i);
        RecyclerView r101 = r100.getGULRecyclerView();
        if (r101 == null) goto L6;
        CardListExtentionsKt.i(r101);
        return;
    }

    private final void setSafeHeight(int r100) {
        if (getLayoutParams() == null) goto L5;
        getLayoutParams().height = r100;
    L6:
        requestLayout();
        invalidate();
        return;
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, r100));
        goto L6
    }

    private final void setShow(boolean r100) {
        this.f171937h = r100;
        if (r100 == false) goto L9;
        RecyclerView r101 = getGULRecyclerView();
        if (r101 == null) goto L13;
        Function1<? super RecyclerView, Unit> r102 = this.f171936g;
        if (r102 == null) goto L14;
        Unit r103 = r102.invoke(r101);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        Function1<? super RecyclerView, Unit> r104 = this.f171936g;
        if (r104 == null) goto L16;
        Unit r105 = r104.invoke(null);
        return;
    }

    public final void setObjectContainer(CardListObjectContainer r100) {
        this.f171935f = r100;
    }

    public final void setOuterHeight(int r100) {
        this.f171938i = r100;
        if (this.f171937h == true) goto L5;
        return;
    L5:
        if (getLayoutParams().height == r100) goto L9;
        getLayoutParams().height = r100;
        requestLayout();
        return;
    }

    public final void setSetUpCallBack(Function1<? super RecyclerView, Unit> r100) {
        this.f171936g = r100;
    }

    public final void setViewAction(com.bytedance.android.shopping.card_list.widgets.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171931b = r100;
    }

    public final void setViewState(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171930a = r100;
    }

    public CardListGULView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f171932c = true;
        this.f171933d = LazyKt.lazy(new CardListGULView$isInSplitScreen$2(this));
        this.f171934e = LazyKt.lazy(new CardListGULView$mallFeedComponent$2(this, r100));
    }

    public /* synthetic */ CardListGULView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
