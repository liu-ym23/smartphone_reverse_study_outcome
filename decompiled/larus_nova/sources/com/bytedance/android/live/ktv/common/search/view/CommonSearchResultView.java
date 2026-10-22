package com.bytedance.android.live.ktv.common.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonSongListView;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchResultView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/ktv/common/search/view/q;", "outerInject", "", "setOuterCallback", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "b", "Lkotlin/Lazy;", "getCommonSearchViewModel", "()Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView;", "c", "getMusicListRecyclerView", "()Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView;", "musicListRecyclerView", "Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "d", "getEmptyView", "()Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "emptyView", "Lcom/bytedance/android/live/ktv/common/ordersong/view/DialogLoadingView;", "e", "getLoadingAnimView", "()Lcom/bytedance/android/live/ktv/common/ordersong/view/DialogLoadingView;", "loadingAnimView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchResultView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f70295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f70299e;

    public CommonSearchResultView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonSearchResultView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final com.bytedance.android.live.ktv.common.search.viewmodel.a getCommonSearchViewModel() {
        return (com.bytedance.android.live.ktv.common.search.viewmodel.a) this.f70296b.getValue();
    }

    private final KtvCommonEmptyView getEmptyView() {
        return (KtvCommonEmptyView) this.f70298d.getValue();
    }

    private final DialogLoadingView getLoadingAnimView() {
        return (DialogLoadingView) this.f70299e.getValue();
    }

    private final CommonSongListView getMusicListRecyclerView() {
        return (CommonSongListView) this.f70297c.getValue();
    }

    public final void a(List<MusicPanel> r100) {
        Intrinsics.checkNotNullParameter(r100, "musicList");
        y r101 = new y(0, 0, 65535);
        r101.f69583h.addAll(r100);
        Intrinsics.checkNotNullParameter("search", "<set-?>");
        r101.f69578c = "search";
        com.bytedance.android.live.ktv.common.search.viewmodel.a r102 = getCommonSearchViewModel();
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r101.f69587l = r104;
        CommonSearchResultView$bindSearchedResult$1 r105 = CommonSearchResultView$bindSearchedResult$1.INSTANCE;
        CommonSongListView r106 = getMusicListRecyclerView();
        if (r106 == null) goto L11;
        r106.w(r101, r105);
    L11:
        List<MusicPanel> r107 = r101.f69583h;
        if (r107 != null) goto L14;
    L17:
        if (r103 == false) goto L27;
        CommonSongListView r108 = getMusicListRecyclerView();
        if (r108 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r108);
    L21:
        KtvCommonEmptyView r109 = getEmptyView();
        if (r109 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r109);
    L24:
        KtvCommonEmptyView r110 = getEmptyView();
        if (r110 == null) goto L34;
        r110.b(r101.f69578c, false);
        return;
    L34:
        return;
    L27:
        CommonSongListView r111 = getMusicListRecyclerView();
        if (r111 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r111);
    L30:
        KtvCommonEmptyView r112 = getEmptyView();
        if (r112 == null) goto L36;
        UtilityKotlinExtentionsKt.t(r112);
        return;
    L36:
        return;
    L14:
        if (r107.isEmpty() == true) goto L17;
        r103 = false;
        goto L17
    L5:
        if (r102.hasMoreSearchResult() != true) goto L7;
        r104 = true;
        goto L8
    }

    public final void setOuterCallback(q r100) {
        Intrinsics.checkNotNullParameter(r100, "outerInject");
        this.f70295a = r100;
        if (r100 == null) goto L9;
        Function1<t, Unit> r101 = r100.d(getLoadingAnimView());
        if (r101 == null) goto L9;
        CommonSongListView r102 = getMusicListRecyclerView();
        if (r102 == null) goto L9;
        r102.setHandleLoadMoreAction(r101);
    L9:
        CommonSongListView r103 = getMusicListRecyclerView();
        Function1<MultiTypeAdapter, Unit> r104 = null;
        if (r103 == null) goto L16;
        q r105 = this.f70295a;
        if (r105 == null) goto L14;
        me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> r106 = r105.g();
    L15:
        r103.setCommonSongListItemViewBinder(r106);
        goto L16
    L14:
        r106 = null;
    L16:
        CommonSongListView r107 = getMusicListRecyclerView();
        if (r107 == null) goto L22;
        q r108 = this.f70295a;
        if (r108 == null) goto L21;
        r104 = r108.b();
    L21:
        r107.setCustomItemViewBinderAction(r104);
    L22:
        CommonSongListView r109 = getMusicListRecyclerView();
        if (r109 == null) goto L25;
        r109.v();
    L25:
        q r110 = this.f70295a;
        if (r110 == null) goto L29;
        r110.c(getMusicListRecyclerView());
        return;
    }

    public CommonSearchResultView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f70296b = LazyKt.lazy(new CommonSearchResultView$commonSearchViewModel$2(this));
        this.f70297c = LazyKt.lazy(new CommonSearchResultView$musicListRecyclerView$2(this));
        this.f70298d = LazyKt.lazy(new CommonSearchResultView$emptyView$2(this));
        this.f70299e = LazyKt.lazy(new CommonSearchResultView$loadingAnimView$2(this));
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_common_search_result_view, this);
    }

    public /* synthetic */ CommonSearchResultView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
