package com.bytedance.android.live.ktv.common.search.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J+\u0010\u000b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010!R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchContainer;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lkotlin/Function1;", "Lcom/bytedance/android/live/ktv/common/ordersong/feedback/a;", "Lkotlin/ParameterName;", "name", "predicateContent", "", "goFeedbackAction", "setGoFeedbackAction", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchEnterView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMSearchView", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchEnterView;", "mSearchView", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchResultView;", "b", "getMSearchResult", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchResultView;", "mSearchResult", "Landroid/widget/LinearLayout;", "c", "getFeedbackContainer", "()Landroid/widget/LinearLayout;", "feedbackContainer", "Landroid/widget/TextView;", "d", "getSearchGoFeedbackTips", "()Landroid/widget/TextView;", "searchGoFeedbackTips", "e", "getSearchGoFeedback", "searchGoFeedback", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "f", "getCommonSearchViewModel", "()Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchContainer extends FrameLayout implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f70256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f70257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super com.bytedance.android.live.ktv.common.ordersong.feedback.a, Unit> f70258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LifecycleRegistry f70259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f70260i;

    private final com.bytedance.android.live.ktv.common.search.viewmodel.a getCommonSearchViewModel() {
        return (com.bytedance.android.live.ktv.common.search.viewmodel.a) this.f70257f.getValue();
    }

    private final LinearLayout getFeedbackContainer() {
        return (LinearLayout) this.f70254c.getValue();
    }

    private final CommonSearchResultView getMSearchResult() {
        return (CommonSearchResultView) this.f70253b.getValue();
    }

    private final CommonSearchEnterView getMSearchView() {
        return (CommonSearchEnterView) this.f70252a.getValue();
    }

    private final TextView getSearchGoFeedback() {
        return (TextView) this.f70256e.getValue();
    }

    private final TextView getSearchGoFeedbackTips() {
        return (TextView) this.f70255d.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final void f() {
        this.f70260i.onSearchEnter();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r100 = getCommonSearchViewModel();
        if (r100 == null) goto L5;
        xb0.a r101 = r100.getExtraRequestData();
    L6:
        pb0.a r102 = pb0.b.f528406a;
        if (r101 == null) goto L10;
        String r103 = r101.f563102c;
        if (r103 == null) goto L10;
    L11:
        if (r101 == null) goto L13;
        String r104 = r101.f563101b;
    L14:
        String r105 = this.f70260i.a();
        Intrinsics.checkNotNullParameter(r103, "source");
        pb0.a r106 = pb0.b.f528406a;
        if (r106 == null) goto L17;
        r106.r(com.bytedance.android.live.ktv.common.util.j.g(), r103, r104, r105);
    L17:
        CommonSearchEnterView r107 = getMSearchView();
        if (r107 == null) goto L24;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r108 = getCommonSearchViewModel();
        if (r108 == null) goto L22;
        String r109 = r108.getCurSearchInitText();
    L23:
        r107.d(r109);
        goto L24
    L22:
        r109 = null;
    L24:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r110 = getCommonSearchViewModel();
        if (r110 == null) goto L28;
        r110.updateSearchInitText(null);
        return;
    L28:
        return;
    L13:
        r104 = null;
    L10:
        r103 = "";
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public final void g() {
        CommonSearchEnterView r100 = getMSearchView();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f70259h.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f70259h.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f70259h;
    }

    public static final /* synthetic */ com.bytedance.android.live.ktv.common.search.viewmodel.a a(CommonSearchContainer r100) {
        return r100.getCommonSearchViewModel();
    }

    public static final /* synthetic */ CommonSearchResultView b(CommonSearchContainer r100) {
        return r100.getMSearchResult();
    }

    public static final /* synthetic */ CommonSearchEnterView c(CommonSearchContainer r100) {
        return r100.getMSearchView();
    }

    public void setGoFeedbackAction(Function1<? super com.bytedance.android.live.ktv.common.ordersong.feedback.a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "goFeedbackAction");
        this.f70258g = r100;
    }

    public static final void e(CommonSearchContainer r100, List r101) {
        if (r101 == null) goto L4;
        r100.getClass();
        ((SingleSubscribeProxy) Single.create(new h(r100, r101)).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r100))).subscribe(new i(r100, r101), j.f70312a);
    L4:
        CommonSearchEnterView r102 = r100.getMSearchView();
        if (r102 == null) goto L7;
        r102.g();
    L7:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r103 = r100.getCommonSearchViewModel();
        Long r104 = null;
        if (r103 == null) goto L10;
        String r105 = r103.getCurSearchKeyword();
    L11:
        boolean r106 = false;
        if (r101 == null) goto L16;
        MusicPanel r107 = (MusicPanel) CollectionsKt.getOrNull(r101, 0);
        if (r107 == null) goto L16;
        KtvMusic r108 = r107.f153577a;
    L18:
        if (r105 == null) goto L44;
        if (r108 == null) goto L44;
        int r109 = yb0.a.f567059a;
        String r110 = yb0.a.a(r108.getMTitle(), r105);
        String r111 = yb0.a.a(r108.getMAuthor(), r105);
        if (r110.length() <= 0) goto L23;
        boolean r112 = true;
    L24:
        if (r112 == false) goto L33;
        if (r108.getMTitle() == null) goto L33;
        if (Intrinsics.areEqual(r110, r108.getMTitle()) == false) goto L33;
        r111 = r108.getMAuthor();
        if (r111 != null) goto L33;
        r111 = "";
    L33:
        if (r111.length() <= 0) goto L35;
        r106 = true;
    L35:
        if (r106 == true) goto L37;
    L43:
        com.bytedance.android.live.ktv.common.ordersong.feedback.a r113 = new com.bytedance.android.live.ktv.common.ordersong.feedback.a(r110, r111);
    L45:
        if (r113 != null) goto L47;
        r113 = new com.bytedance.android.live.ktv.common.ordersong.feedback.a("", "");
    L47:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r114 = r100.getCommonSearchViewModel();
        if (r114 == null) goto L50;
        r114.updatePredicateContent(r113);
    L50:
        CommonSearchEnterView r115 = r100.getMSearchView();
        if (r115 == null) goto L53;
        r104 = Long.valueOf(r115.getSearchStartTime());
    L53:
        if (r104 != null) goto L55;
        return;
    L55:
        if (r104.longValue() == 0) goto L63;
        CommonSearchResultView r116 = r100.getMSearchResult();
        if (r116 == null) goto L64;
        ViewTreeObserver r117 = r116.getViewTreeObserver();
        if (r117 == null) goto L65;
        r117.addOnGlobalLayoutListener(new k(r100, r104));
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L37:
        if (r108.getMAuthor() == null) goto L43;
        if (Intrinsics.areEqual(r111, r108.getMAuthor()) == false) goto L43;
        r110 = r108.getMTitle();
        if (r110 != null) goto L43;
        r110 = "";
        goto L43
    L23:
        r112 = false;
    L44:
        r113 = null;
    L16:
        r108 = null;
        goto L18
    L10:
        r105 = null;
        goto L11
    }

    public CommonSearchContainer(q r100, Context r101, boolean r102, int r103) {
        int r104 = 0;
        if ((r103 & 16) == 0) goto L5;
        r102 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "outerCallback");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f70260i = r100;
        this.f70252a = LazyKt.lazy(new CommonSearchContainer$mSearchView$2(this));
        this.f70253b = LazyKt.lazy(new CommonSearchContainer$mSearchResult$2(this));
        this.f70254c = LazyKt.lazy(new CommonSearchContainer$feedbackContainer$2(this));
        this.f70255d = LazyKt.lazy(new CommonSearchContainer$searchGoFeedbackTips$2(this));
        this.f70256e = LazyKt.lazy(new CommonSearchContainer$searchGoFeedback$2(this));
        this.f70257f = LazyKt.lazy(new CommonSearchContainer$commonSearchViewModel$2(this));
        LifecycleRegistry r105 = new LifecycleRegistry(this);
        this.f70259h = r105;
        if (r102 == false) goto L8;
        int r106 = R.layout.ttlive_ktv_common_search_adapt_layout;
    L9:
        LayoutInflater.from(r101).inflate(r106, this);
        r105.setCurrentState(Lifecycle.State.CREATED);
        CommonSearchResultView r107 = getMSearchResult();
        if (r107 == null) goto L12;
        r107.setOuterCallback(r100);
    L12:
        CommonSearchEnterView r108 = getMSearchView();
        if (r108 == null) goto L15;
        r108.setOuterCallback(r100);
    L15:
        CommonSearchEnterView r109 = getMSearchView();
        if (r109 == null) goto L18;
        r109.setSearchResultView(getMSearchResult());
    L18:
        CommonSearchEnterView r110 = getMSearchView();
        if (r110 == null) goto L21;
        r110.setCancelAction(new AnonymousClass1(this));
    L21:
        TextView r111 = getSearchGoFeedback();
        if (r111 == null) goto L24;
        r111.setOnClickListener(new g(this));
    L24:
        TextView r112 = getSearchGoFeedbackTips();
        if (r112 == null) goto L27;
        KtvOrderSongThemeManager.d(r112, KtvOrderSongThemeManager.f70197f);
    L27:
        KtvOrderSongThemeManager.b(this, 1);
        com.bytedance.android.live.ktv.common.search.viewmodel.a r113 = getCommonSearchViewModel();
        if (r113 == null) goto L30;
        r113.observeHistoryListChange(this, new c(this));
    L30:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r114 = getCommonSearchViewModel();
        if (r114 == null) goto L33;
        r114.observeHotWordListChange(this, new d(this));
    L33:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r115 = getCommonSearchViewModel();
        if (r115 == null) goto L36;
        r115.observeGuessWordListChange(this, new e(this));
    L36:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r116 = getCommonSearchViewModel();
        if (r116 == null) goto L39;
        r116.observeSearchedMusicListChange(this, new f(this));
    L39:
        LinearLayout r117 = getFeedbackContainer();
        if (r117 != null) goto L42;
    L46:
        setClickable(true);
        setEnabled(true);
        return;
    L42:
        if (r100.f() == true) goto L45;
        r104 = 8;
    L45:
        r117.setVisibility(r104);
        goto L46
    L8:
        r106 = R.layout.ttlive_ktv_common_search_layout;
        goto L9
    }
}
