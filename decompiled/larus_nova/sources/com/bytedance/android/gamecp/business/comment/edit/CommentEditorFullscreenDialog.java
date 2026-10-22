package com.bytedance.android.gamecp.business.comment.edit;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.gamecp.business.comment.edit.view.CommentEditText;
import com.bytedance.android.gamecp.business.comment.edit.view.CommentLabelsRecycleView;
import com.bytedance.android.gamecp.business.view.GamePromoteCommonRatingBar;
import com.bytedance.android.gamecp.common.track.GPCommonFilterName;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.DouyinLoadingLayout;
import com.bytedance.android.gamecp.common.ui.LoadingStatusView;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/edit/CommentEditorFullscreenDialog;", "Landroidx/fragment/app/DialogFragment;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentEditorFullscreenDialog extends DialogFragment {
    public static final /* synthetic */ int I = 0;
    public final int A;
    public final String B;
    public Map<Integer, String> C;
    public com.bytedance.android.gamecp.business.comment.edit.help.d D;
    public Function0<Unit> E;
    public v F;
    public int G;
    public final /* synthetic */ gs.a H;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f52074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f52075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f52076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f52077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f52079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f52080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f52081k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f52082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f52083m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f52084n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f52085o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f52086p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f52087q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f52088r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f52089s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f52090t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f52091u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f52092v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CommentEditorImageAdapter f52093w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f52094x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f52095y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f52096z;

    public static final class a {
    }

    static {
    }

    public final CommentEditText U90() {
        return (CommentEditText) this.f52076f.getValue();
    }

    public final LoadingStatusView V90() {
        return (LoadingStatusView) this.f52089s.getValue();
    }

    public final GamePromoteCommonRatingBar W90() {
        return (GamePromoteCommonRatingBar) this.f52078h.getValue();
    }

    public final CommentLabelsRecycleView X90() {
        return (CommentLabelsRecycleView) this.f52084n.getValue();
    }

    public final View Y90() {
        return (View) this.f52077g.getValue();
    }

    public final CommentEditViewModel Z90() {
        return (CommentEditViewModel) this.f52074d.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        Function0<Unit> r100 = this.E;
        if (r100 == null) goto L13;
        if (r100 == null) goto L17;
        Unit r101 = r100.invoke();
        return;
    L17:
        return;
    L13:
        super.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public CommentEditorFullscreenDialog() {
        this.H = new gs.a();
        this.f52074d = LazyKt.lazy(new CommentEditorFullscreenDialog$viewModel$2(this));
        this.f52076f = LazyKt.lazy(new CommentEditorFullscreenDialog$editPanel$2(this));
        this.f52077g = LazyKt.lazy(new CommentEditorFullscreenDialog$sendComment$2(this));
        this.f52078h = LazyKt.lazy(new CommentEditorFullscreenDialog$ratingBar$2(this));
        this.f52079i = LazyKt.lazy(new CommentEditorFullscreenDialog$commentProtocol$2(this));
        this.f52080j = LazyKt.lazy(new CommentEditorFullscreenDialog$inputCount$2(this));
        this.f52081k = LazyKt.lazy(new CommentEditorFullscreenDialog$rvImagesSummary$2(this));
        this.f52082l = LazyKt.lazy(new CommentEditorFullscreenDialog$cbDevice$2(this));
        this.f52083m = LazyKt.lazy(new CommentEditorFullscreenDialog$clBottomLabels$2(this));
        this.f52084n = LazyKt.lazy(new CommentEditorFullscreenDialog$rvLabels$2(this));
        this.f52085o = LazyKt.lazy(new CommentEditorFullscreenDialog$ivGameIcon$2(this));
        this.f52086p = LazyKt.lazy(new CommentEditorFullscreenDialog$tvGameName$2(this));
        this.f52087q = LazyKt.lazy(new CommentEditorFullscreenDialog$tvStarDesc$2(this));
        this.f52088r = LazyKt.lazy(new CommentEditorFullscreenDialog$ivClose$2(this));
        this.f52089s = LazyKt.lazy(new CommentEditorFullscreenDialog$loading$2(this));
        this.f52090t = LazyKt.lazy(new CommentEditorFullscreenDialog$clEditorContainer$2(this));
        this.f52091u = LazyKt.lazy(new CommentEditorFullscreenDialog$hideSoftView$2(this));
        this.f52092v = LazyKt.lazy(new CommentEditorFullscreenDialog$gameInfoContainer$2(this));
        this.f52094x = com.bytedance.android.gamecp.business.comment.edit.a.f52116c;
        this.f52095y = 2;
        this.f52096z = com.bytedance.android.gamecp.business.comment.edit.a.f52117d;
        this.A = 5000;
        this.B = com.bytedance.android.gamecp.business.comment.edit.a.f52118e;
        this.C = com.bytedance.android.gamecp.business.comment.edit.a.f52114a;
    }

    public final boolean aa0() {
        v r100 = Z90().getCommentEntranceInfo().getValue();
        if (r100 == null) goto L10;
        com.bytedance.android.gamecp.business.comment.data.d r101 = r100.f52199c;
        if (r101 == null) goto L10;
        com.bytedance.android.gamecp.business.comment.data.u r102 = r101.scoreGuide;
        if (r102 == null) goto L10;
        String r103 = r102.toast;
        if (r103 == null) goto L10;
    L12:
        if (W90().getScore() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L18;
        ToastUtil.b(r103, 0);
        return false;
    L18:
        return true;
    L14:
        r104 = false;
    L10:
        Map<Integer, String> r105 = com.bytedance.android.gamecp.business.comment.edit.a.f52114a;
        r103 = com.bytedance.android.gamecp.business.comment.edit.a.f52115b;
        goto L12
    }

    public final boolean ca0() {
        if (Z90().getLoadingStatus().getValue() == CommentEditViewModel.LoadingStatus.SUCCESS) goto L5;
        return false;
    L5:
        final Ref.BooleanRef r100 = new Ref.BooleanRef();
        r100.element = false;
        Context r101 = getContext();
        if (r101 == null) goto L14;
        com.bytedance.android.gamecp.business.gamedetail.view.comment.f r102 = new com.bytedance.android.gamecp.business.gamedetail.view.comment.f(r101, new CommentEditorFullscreenDialog$showDismissConfirmDialog$$inlined$let$lambda$1(this, r100));
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r102);
    L12:
        r100.element = true;
        goto L14
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L11:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    L14:
        return r100.element;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Dialog r100 = getDialog();
        com.bytedance.android.gamecp.business.comment.edit.help.d r101 = this.D;
        gs.b r102 = this.H.f482430a;
        if (r102 != null) goto L12;
        if (r100 == null) goto L13;
        Window r103 = r100.getWindow();
        if (r103 == null) goto L13;
        View r104 = gs.a.a(r103);
        if (r104 == null) goto L13;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L13;
        r105.removeOnGlobalLayoutListener(r101);
    L13:
        super.onDestroyView();
        return;
    L12:
        r102.b(r101);
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ba0("othershow", "landing_page_new_comment_detail");
    }

    public static final /* synthetic */ View S90(CommentEditorFullscreenDialog r100) {
        View r101 = r100.f52075e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r101;
    }

    public final void da0(int r100) {
        String r101 = this.C.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        ((TextView) this.f52087q.getValue()).setText("");
        return;
    L5:
        ((TextView) this.f52087q.getValue()).setText(r101);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (p0.a() == false) goto L10;
        Dialog r101 = getDialog();
        if (r101 == null) goto L11;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L12;
        r102.setType(1000);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        Z90().parseArgs(getArguments());
    }

    public static final void T90(CommentEditorFullscreenDialog r100, boolean r101) {
        UtilityKotlinExtentionsKt.k((LinearLayout) r100.f52092v.getValue(), r101);
        UtilityKotlinExtentionsKt.k(r100.Y90(), r101);
    }

    public final void ba0(String r100, String r101) {
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        if ("landing_page_new_comment_detail".length() != 0) goto L10;
        r102 = true;
    L10:
        if (r102 == true) goto L25;
        Bundle r104 = getArguments();
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.getInt("promot_scene", -1) != 0) goto L24;
        String r105 = r104.getString("anchor_id");
        JSONObject r106 = new JSONObject();
        r106.putOpt("anchor_id", r104.getString("anchor_id"));
        r106.putOpt("room_id", r105);
        r106.putOpt(EventConstants.ExtraJson.GAME_NAME, r104.getString(EventConstants.ExtraJson.GAME_NAME));
        r106.putOpt("game_id", r104.getString("game_id"));
        int r107 = com.bytedance.android.gamecp.common.track.b.f56775a;
        if (r105 == null) goto L19;
        Long r108 = StringsKt.toLongOrNull(r105);
    L20:
        com.bytedance.android.gamecp.common.track.b.f(r100, "landing_page_new_comment_detail", r108, r106, true);
        return;
    L19:
        r108 = null;
        goto L20
    L24:
        return;
    L25:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.setSoftInputMode(16);
    L7:
        ((TextView) this.f52080j.getValue()).setVisibility(8);
        Context r102 = getContext();
        if (r102 == null) goto L46;
        Y90().setAlpha(1.0f);
        Integer r103 = Z90().getCurrentPercent();
        if (r103 != null) goto L13;
    L21:
        W90().setOnCommonRatingBarScoreListener(new j(this));
        X90().u(U90());
        U90().addTextChangedListener(new k(this));
        ((CheckBox) this.f52082l.getValue()).setChecked(true);
        Y90().setOnClickListener(new l(this));
        ((View) this.f52079i.getValue()).setOnClickListener(new m(this));
        ((ImageView) this.f52088r.getValue()).setOnClickListener(new n(this));
        ((View) this.f52091u.getValue()).setOnClickListener(new o(this));
        ((ConstraintLayout) this.f52090t.getValue()).setOnClickListener(p.f52165a);
        Function1<Integer, Unit> r104 = new CommentEditorFullscreenDialog$initImagesSummary$initAction$1(this);
        if (Z90().getEnterFromPortrait() == false) goto L24;
        r104.invoke(null);
    L28:
        View r105 = this.f52075e;
        if (r105 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L31:
        this.D = new com.bytedance.android.gamecp.business.comment.edit.help.d(r105, (ConstraintLayout) this.f52090t.getValue(), new CommentEditorFullscreenDialog$initInputPanelAdjustHelper$1(this), UtilityKotlinExtentionsKt.c(12));
        Dialog r106 = getDialog();
        com.bytedance.android.gamecp.business.comment.edit.help.d r107 = this.D;
        gs.b r108 = this.H.f482430a;
        if (r108 != null) goto L41;
        if (r106 == null) goto L42;
        Window r109 = r106.getWindow();
        if (r109 == null) goto L42;
        View r112 = gs.a.a(r109);
        if (r112 == null) goto L42;
        ViewTreeObserver r113 = r112.getViewTreeObserver();
        if (r113 == null) goto L42;
        r113.addOnGlobalLayoutListener(r107);
    L42:
        Dialog r114 = getDialog();
        if (r114 == null) goto L45;
        r114.setOnKeyListener(new g(this));
    L45:
        LoadingStatusView r115 = V90();
        LoadingStatusView.a r116 = LoadingStatusView.a.a(getContext());
        View r117 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_common_light_error_view, null);
        ((TextView) r117.findViewById(R.id.tv_game_promote_list_retry)).setOnClickListener(new d(this));
        r116.f56938d = r117;
        r116.f56936b = new DouyinLoadingLayout(r102);
        r115.setBuilder(r116);
        goto L46
    L41:
        r108.a(r107);
        goto L42
    L24:
        View r118 = this.f52075e;
        if (r118 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L27:
        r118.post(new h(this, r104));
        goto L28
    L13:
        if (r103.intValue() < 0.0f) goto L15;
        boolean r119 = true;
    L16:
        if (r119 == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L21;
        W90().setProgress(r103.intValue());
        Y90().setAlpha(1.0f);
        da0((int) W90().getScore());
        goto L21
    L15:
        r119 = false;
    L46:
        Z90().initData(this.F);
        Z90().getCommentEntranceInfo().observe(this, new e(this));
        Z90().getLoadingStatus().observe(this, new f(this));
        int r120 = fs.a.f478651a;
        View r121 = this.f52075e;
        if (r121 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L49:
        Bundle r122 = getArguments();
        CommentEditViewModel r123 = Z90();
        Intrinsics.checkNotNullParameter(r121, "contentView");
        Intrinsics.checkNotNullParameter(r123, "viewModel");
        if (r122 == null) goto L82;
        String r124 = com.bytedance.android.gamecp.business.gamedetail.f.b(r122, "report_params");
        if (r124 == null) goto L82;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L80
        JSONObject r126 = new JSONObject(r124);     // Catch: Throwable -> L80
        HashMap r127 = new HashMap();     // Catch: Throwable -> L80
        JSONObject r128 = r126.optJSONObject("game_info");     // Catch: Throwable -> L80
        if (r128 == null) goto L61;
        Iterator<String> r129 = r128.keys();     // Catch: Throwable -> L80
        if (r129 == null) goto L61;
    L59:
        if (r129.hasNext() == false) goto L61;
        String r130 = r129.next();     // Catch: Throwable -> L80
        r127.put(r130, r128.optString(r130));     // Catch: Throwable -> L80
    L61:
        HashMap r131 = new HashMap();     // Catch: Throwable -> L80
        r131.put(GPCommonFilterName.USER_INFO, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("user_type", r126.optString("user_type", "user"))}));     // Catch: Throwable -> L80
        r131.put(GPCommonFilterName.CONTENT_INFO, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r126.optString(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, ""))}));     // Catch: Throwable -> L80
        r131.put(GPCommonFilterName.TRAFFIC_INFO, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("traffic_source", r126.optString("traffic_source", ""))}));     // Catch: Throwable -> L80
        r131.put(GPCommonFilterName.BIZ_INFO, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, r126.optString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, ""))}));     // Catch: Throwable -> L80
        r131.put(GPCommonFilterName.GAME_INFO, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("game_info", r126.optString("game_info"))}));     // Catch: Throwable -> L80
        String r132 = r126.optString("enter_way");     // Catch: Throwable -> L80
        String r133 = r126.optString(CheckPointType.ENTER_PAGE);     // Catch: Throwable -> L80
        if (r132 != null) goto L64;
    L67:
        boolean r134 = true;
    L68:
        if (r134 == true) goto L70;
        r123.setEnterWay(r132);     // Catch: Throwable -> L80
    L70:
        if (r133 != null) goto L72;
    L75:
        boolean r135 = true;
    L76:
        if (r135 == true) goto L78;
        r123.setEnterPage(r133);     // Catch: Throwable -> L80
    L78:
        GPCommonFilterName.Companion.getClass();     // Catch: Throwable -> L80
        com.bytedance.android.gamecp.common.track.f r136 = new com.bytedance.android.gamecp.common.track.f(GPCommonFilterName.a.b(r131), new com.bytedance.android.gamecp.common.track.h(false), true);     // Catch: Throwable -> L80
        HashMap<String, String> r137 = GamecpTracker.f56755a;     // Catch: Throwable -> L80
        GamecpTracker.y(this, r121, r136);     // Catch: Throwable -> L80
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L80
        goto L82
    L72:
        if (StringsKt.isBlank(r133) == true) goto L75;
        r135 = false;
        goto L76
    L64:
        if (StringsKt.isBlank(r132) == true) goto L67;
        r134 = false;
    L80:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L82:
        HashMap<String, String> r139 = GamecpTracker.f56755a;
        View r140 = this.f52075e;
        if (r140 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L85:
        Map r141 = MapsKt.emptyMap();
        Pair[] r142 = new Pair[2];
        String r143 = Z90().getEnterPage();
        if (r143 != null) goto L88;
        r143 = "promote_detail";
    L88:
        r142[0] = TuplesKt.to("previous_page", r143);
        r142[1] = TuplesKt.to("previous_module", "[\"" + Z90().getEnterWay() + "\"]");
        GamecpTracker.w(this, r140, "comment_write", r141, MapsKt.mapOf(r142), new i());
        GamecpTracker.r(Y90(), "comment_write", MapsKt.emptyMap(), null, false, 120);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.gamecp_game_promote_detail_edit_comment_fullscreen_dialog, r101, false);
        this.f52075e = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r103;
    }
}
