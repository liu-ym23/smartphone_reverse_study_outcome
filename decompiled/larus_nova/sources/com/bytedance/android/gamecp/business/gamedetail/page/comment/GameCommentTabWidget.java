package com.bytedance.android.gamecp.business.gamedetail.page.comment;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.comment.CommentDetailListView;
import com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel;
import com.bytedance.android.gamecp.business.gamedetail.base.track.GameDetailTrackV2;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget;
import com.bytedance.android.gamecp.business.gamedetail.page.root.effect.j;
import com.bytedance.android.gamecp.business.gamedetail.view.NestedChildRecyclerView;
import com.bytedance.android.gamecp.business.v;
import com.bytedance.android.gamecp.common.ui.LoadingStatusView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/page/comment/GameCommentTabWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/page/BaseGameDetailTabWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/page/comment/c;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCommentTabWidget extends BaseGameDetailTabWidget<c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AudienceGamePromoteDetailViewModel f55329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GamePromoteCommentViewModel f55330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f55331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CommentDetailListView f55332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f55334n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f55335o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f55336p;

    public GameCommentTabWidget() {
        this(null);
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_comment_tab_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget, com.bytedance.ies.viewpager.PagerItemWidget
    public final void Nq() {
        if (this.f55335o == false) goto L14;
        Tq();
        LoadingStatusView r100 = this.f55313d;
        if (r100 == null) goto L7;
        r100.a();
    L7:
        LoadingStatusView r101 = this.f55313d;
        if (r101 == null) goto L10;
        UtilityKotlinExtentionsKt.j(r101);
    L10:
        LoadingStatusView r102 = this.f55313d;
        if (r102 == null) goto L13;
        r102.d();
    L13:
        this.contentView.setVisibility(0);
    L14:
        this.f55333m = System.currentTimeMillis();
        Wo(new j("tab_comment"));
        GamePromoteCommentViewModel r103 = this.f55330j;
        if (r103 == null) goto L18;
        String r104 = r103.getCommentListEnterWay();
        if (r104 == null) goto L18;
    L19:
        this.f55336p = r104;
        if (r104.length() != 0) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == false) goto L25;
        this.f55336p = "comment_tab_click";
    L25:
        CommentDetailListView r106 = this.f55332l;
        if (r106 == null) goto L28;
        r106.setEnterWay(this.f55336p);
    L28:
        AudienceGamePromoteDetailViewModel r107 = GameDetailTrackV2.f53492a;
        String r108 = this.f55336p;
        Intrinsics.checkNotNullParameter(r108, "enterFrom");
        Boolean r109 = null;
        GameDetailTrackV2.h("livesdk_game_promote_user_comment_page_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(DownloadHelper.IDENTITY, "user"), TuplesKt.to("enter_from", r108)}), null);
        GamePromoteCommentViewModel r110 = this.f55330j;
        if (r110 == null) goto L32;
        r110.setCommentListEnterWay("");
    L32:
        if (this.f55335o == false) goto L66;
        GamePromoteCommentViewModel r111 = this.f55330j;
        if (r111 == null) goto L40;
        c r112 = (c) this.f248681b.f248670b;
        if (r112 == null) goto L38;
        String r113 = r112.f55341c;
    L39:
        r111.setGameId(r113);
        goto L40
    L38:
        r113 = null;
    L40:
        GamePromoteCommentViewModel r114 = this.f55330j;
        if (r114 == null) goto L55;
        v r115 = new v();
        c r116 = (c) this.f248681b.f248670b;
        if (r116 == null) goto L45;
        String r117 = r116.f55341c;
    L46:
        r115.f56433id = r117;
        if (r116 == null) goto L49;
        String r118 = r116.f55342d;
    L50:
        r115.name = r118;
        if (r116 == null) goto L53;
        String r119 = r116.f55343e;
    L54:
        r115.packageName = r119;
        Unit r120 = Unit.INSTANCE;
        r114.setGameInfo(r115);
        goto L55
    L53:
        r119 = null;
        goto L54
    L49:
        r118 = null;
        goto L50
    L45:
        r117 = null;
    L55:
        GamePromoteCommentViewModel r121 = this.f55330j;
        if (r121 == null) goto L61;
        c r122 = (c) this.f248681b.f248670b;
        if (r122 == null) goto L60;
        r109 = r122.f55344f;
    L60:
        r121.setEnableInternalEntrance(r109);
    L61:
        CommentDetailListView r123 = this.f55332l;
        if (r123 == null) goto L64;
        r123.c(r123.f51786d);
    L64:
        this.f55335o = false;
        return;
    L66:
        return;
    L22:
        r105 = false;
    L18:
        r104 = "";
        goto L19
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget
    public final String Rq() {
        c r100 = (c) this.f248681b.f248670b;
        if (r100 == null) goto L6;
        String r101 = r100.f55339a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "tab_comment";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget
    public final String Sq() {
        c r100 = (c) this.f248681b.f248670b;
        if (r100 == null) goto L6;
        String r101 = r100.f55340b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "评价";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.view.f
    public final NestedChildRecyclerView ig() {
        CommentDetailListView r100 = (CommentDetailListView) this.contentView.findViewById(R.id.list_comment_detail);
        this.f55332l = r100;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (NestedChildRecyclerView) r100.findViewById(R.id.rv_comment_detail_list);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f55332l = (CommentDetailListView) this.contentView.findViewById(R.id.list_comment_detail);
        c r100 = (c) this.f248681b.f248670b;
        if (r100 == null) goto L5;
        Boolean r101 = r100.f55344f;
    L7:
        if ((!Intrinsics.areEqual(r101, Boolean.TRUE)) == false) goto L11;
        CommentDetailListView r102 = this.f55332l;
        if (r102 == null) goto L11;
        r102.setUpdateCommentEntranceInfoHere(false);
    L11:
        CommentDetailListView r103 = this.f55332l;
        if (r103 == null) goto L14;
        r103.b(this.f55330j);
    L14:
        CommentDetailListView r104 = this.f55332l;
        if (r104 == null) goto L17;
        r104.setOcclusionListener(new GameCommentTabWidget$initListView$1(this));
    L17:
        CommentDetailListView r105 = this.f55332l;
        if (r105 == null) goto L20;
        r105.setShowLoadingListener(new GameCommentTabWidget$initListView$2(this));
    L20:
        CommentDetailListView r106 = this.f55332l;
        if (r106 == null) goto L23;
        r106.setHideLoadingListener(new GameCommentTabWidget$initListView$3(this));
    L23:
        CommentDetailListView r107 = this.f55332l;
        if (r107 == null) goto L26;
        r107.setShowEmptyListener(new GameCommentTabWidget$initListView$4(this));
    L26:
        CommentDetailListView r108 = this.f55332l;
        if (r108 == null) goto L29;
        r108.setShowErrorListener(new GameCommentTabWidget$initListView$5(this));
    L29:
        AudienceGamePromoteDetailViewModel r109 = this.f55329i;
        if (r109 == null) goto L38;
        m<String> r110 = r109.getCurrentTab();
        if (r110 == null) goto L38;
        Observable<String> r111 = r110.a();
        if (r111 == null) goto L38;
        Disposable r112 = r111.subscribe(new d(this));
        if (r112 == null) goto L38;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r112, this.f55331k);
    L38:
        GamePromoteCommentViewModel r113 = this.f55330j;
        if (r113 == null) goto L47;
        m<Boolean> r114 = r113.getShowEntrance();
        if (r114 == null) goto L47;
        Observable<Boolean> r115 = r114.a();
        if (r115 == null) goto L47;
        Disposable r116 = r115.subscribe(new e(this));
        if (r116 == null) goto L47;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r116, this.f55331k);
    L47:
        GamePromoteCommentViewModel r117 = this.f55330j;
        if (r117 == null) goto L57;
        m<Integer> r118 = r117.getCommentUpdateEvent();
        if (r118 == null) goto L58;
        Observable<Integer> r119 = r118.a();
        if (r119 == null) goto L59;
        Disposable r120 = r119.subscribe(new f(this));
        if (r120 == null) goto L60;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r120, this.f55331k);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        AudienceGamePromoteDetailViewModel r100 = GameDetailTrackV2.f53492a;
        GameDetailTrackV2.d(System.currentTimeMillis() - this.f55333m, this.f55336p);
        this.f55331k.dispose();
        CommentDetailListView r101 = this.f55332l;
        if (r101 == null) goto L9;
        GamePromoteCommentViewModel r102 = r101.f51792j;
        if (r102 == null) goto L7;
        r102.setSelectedCommentTag(null);
    L7:
        r101.f51785c.dispose();
        return;
    }

    public GameCommentTabWidget(Function1<? super PureWidget<c>, Unit> r100) {
        super(r100);
        DataContext r101 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        String r102 = null;
        if ((r101 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r101 = null;
    L5:
        AudienceGamePromoteDetailViewModel r103 = (AudienceGamePromoteDetailViewModel) r101;
        this.f55329i = r103;
        DataContext r104 = com.bytedance.live.datacontext.d.d(GamePromoteCommentViewModel.class);
        if ((r104 instanceof GamePromoteCommentViewModel) == true) goto L8;
        r104 = null;
    L8:
        this.f55330j = (GamePromoteCommentViewModel) r104;
        this.f55331k = new CompositeDisposable();
        if (r103 == null) goto L13;
        m<String> r105 = r103.getCurrentTab();
        if (r105 == null) goto L13;
        r102 = r105.getValue();
    L13:
        this.f55334n = r102;
        this.f55335o = true;
        this.f55336p = "";
    }

    @Override // com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorPagerItemWidget, com.bytedance.ies.sve_core.q
    public final void wj(p r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        super.wj(r101);
    }
}
