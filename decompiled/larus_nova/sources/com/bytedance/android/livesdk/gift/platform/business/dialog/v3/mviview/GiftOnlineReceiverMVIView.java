package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickReceiverWidget;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverStateMachineState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReceiverUIType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowReceiverDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateReceiverInfo;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftOnlineReceiverMVIView extends BaseGiftMVIViewChildNode<GiftReceiverViewState, GiftReceiverStateMachineState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f127669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f127670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public zy0.d f127671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ViewGroup f127672p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f127673q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f127674r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f127675s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f127676t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f127677u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f127678v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f127679w;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftOnlineReceiverMVIView f127680a;

        public a(GiftOnlineReceiverMVIView r100) {
            this.f127680a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GiftOnlineReceiverMVIView r101 = this.f127680a;
            r101.o(new ClickReceiverWidget(GiftOnlineReceiverMVIView.t(r101)));
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftOnlineReceiverMVIView f127682a;

        public b(GiftOnlineReceiverMVIView r100) {
            this.f127682a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GiftOnlineReceiverMVIView r101 = this.f127682a;
            r101.o(new ClickReceiverWidget(GiftOnlineReceiverMVIView.t(r101)));
        }
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
    }

    public final RecyclerView u() {
        return (RecyclerView) this.f127674r.getValue();
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        r().setOnClickListener(new b(this));
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L5;
        return R.layout.ttlive_dialog_select_gift_receiver_widget_new;
    L5:
        return R.layout.ttlive_dialog_select_gift_receiver_widget_old;
    }

    public static final int t(GiftOnlineReceiverMVIView r100) {
        r100.getClass();
        if (nz1.a.j().c() == true) goto L11;
        int[] r101 = new int[2];
        r100.f126234l.getLocationInWindow(r101);
        Point r102 = new Point();
        Context r103 = r100.getContext();
        if (r103 == null) goto L10;
        ((Activity) r103).getWindowManager().getDefaultDisplay().getSize(r102);
        return (int) s1.G((r102.y - r101[1]) - r100.f126234l.getHeight());
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L11:
        return s1.j(R.dimen.ttlive_gift_receiver_panel_height);
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftReceiverViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftOnlineReceiverMVIView$bindToParent$1 r101 = GiftOnlineReceiverMVIView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(com.bytedance.android.anya.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof ShowReceiverDialog) == false) goto L12;
        Uri r101 = ((ShowReceiverDialog) r100).getDialogUri();
        this.f127671o = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(getContext(), r101, null);     // Catch: Exception -> L7
    L18:
        return true;
    L7:
        zy0.d r102 = this.f127671o;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        this.f127671o = null;
        goto L18
    L12:
        if ((r100 instanceof UpdateReceiverInfo) == false) goto L19;
        zy0.d r103 = this.f127671o;
        if (r103 == null) goto L18;
        xy0.a<?> r104 = r103.g();
        if (r104 == null) goto L18;
        r104.sendJsEvent("H5_linkerContributeDidUpdate", ((UpdateReceiverInfo) r100).getData());
        goto L18
    L19:
        return false;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void k(com.bytedance.android.anya.dsl.a<GiftReceiverStateMachineState, GiftAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerListAdapters");
        com.bytedance.android.anya.dsl.a.b(r100, this, GiftOnlineReceiverMVIView$registerListAdapters$1.INSTANCE, new GiftOnlineReceiverMVIView$registerListAdapters$2(this), u());
    }

    public GiftOnlineReceiverMVIView(final Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
        this.f127669m = (ImageView) r().findViewById(R.id.user_avatar);
        this.f127670n = (TextView) r().findViewById(R.id.user_name);
        this.f127674r = LazyKt.lazy(new GiftOnlineReceiverMVIView$receiverItemList$2(this, r100));
        this.f127678v = LazyKt.lazy(new GiftOnlineReceiverMVIView$allMicItemDecoration$2(this));
        this.f127679w = LazyKt.lazy(GiftOnlineReceiverMVIView$multiItemDecoration$2.INSTANCE);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L7;
        View r102 = r().findViewById(R.id.gift_receiver_more_container);
        this.f127675s = r102;
        this.f127673q = r().findViewById(R.id.receiver_info_container);
        this.f127672p = (ViewGroup) r().findViewById(R.id.receiver_content_container);
        this.f127676t = r().findViewById(R.id.right_back);
        this.f127677u = r().findViewById(R.id.space);
        if (r102 == null) goto L9;
        r102.setOnClickListener(new a(this));
        return;
    L9:
        return;
    L7:
        this.f127672p = (ViewGroup) r().findViewById(R.id.receiver_content_container);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftReceiverStateMachineState r102 = (GiftReceiverStateMachineState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, py.k> r103 = r102.getAvatarThumb();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L8;
        r100.f41739b.f41563a.invoke(r103);
        py.k r105 = (py.k) r104;
        if (r105.isValid() == false) goto L7;
        ImageView r106 = this.f127669m;
        com.bytedance.android.livesdk.chatroom.utils.a1.x(r106, r105, r106.getWidth(), this.f127669m.getHeight(), R.drawable.ttlive_ic_default_head_small);
        goto L8
    L7:
        ImageUtil.loadRoundResource(this.f127669m, R.drawable.ttlive_ic_default_head_small, -1, -1);
    L8:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, String> r107 = r102.getNickname();
        Object r108 = r100.f41740c.a(r107);
        if (r108 == null) goto L14;
        r100.f41739b.f41563a.invoke(r107);
        String r109 = (String) r108;
        this.f127670n.setText(r109);
        ViewGroup r110 = this.f127672p;
        if (r110 == null) goto L13;
        r110.setContentDescription(s1.C(R.string.ttlive_live_send_text_accessibility, new Object[]{r109}));
    L13:
        r3.c(this.f127672p, getContext().getString(R.string.ttlive_live_send_text_accessibility, new Object[]{r109}), true);
    L14:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, Integer> r111 = r102.getAvatarVisibility();
        Object r112 = r100.f41740c.a(r111);
        if (r112 == null) goto L19;
        r100.f41739b.f41563a.invoke(r111);
        int r113 = ((Number) r112).intValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == true) goto L19;
        this.f127669m.setVisibility(r113);
    L19:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, py.k> r114 = r102.getBackground();
        Object r115 = r100.f41740c.a(r114);
        if (r115 == null) goto L31;
        r100.f41739b.f41563a.invoke(r114);
        py.k r116 = (py.k) r115;
        if (r116.isValid() != true) goto L27;
        if (nz1.a.j().b() == false) goto L31;
        com.bytedance.android.livesdk.chatroom.utils.a1.k(r116).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i1(this), j1.f127947a);
        goto L31
    L27:
        if (nz1.a.j().b() == false) goto L31;
        ViewGroup r117 = this.f127672p;
        if (r117 == null) goto L31;
        r117.setBackgroundResource(R.drawable.ttlive_bg_gift_receiver_new);
    L31:
        com.bytedance.android.anya.r0<GiftReceiverStateMachineState, ReceiverUIType> r118 = r102.getReceiverUIType();
        Object r119 = r100.f41740c.a(r118);
        if (r119 == null) goto L89;
        r100.f41739b.f41563a.invoke(r118);
        ReceiverUIType r120 = (ReceiverUIType) r119;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L92;
        int r121 = h1.f127939a[r120.ordinal()];
        if (r121 != 1) goto L39;
        ViewGroup r122 = this.f127672p;
        if (r122 == null) goto L78;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r122, -2);
    L78:
        View r123 = this.f127675s;
        if (r123 == null) goto L81;
        UtilityKotlinExtentionsKt.w(r123);
    L81:
        UtilityKotlinExtentionsKt.w(u());
        UtilityKotlinExtentionsKt.t(this.f127670n);
        View r124 = this.f127676t;
        if (r124 == null) goto L84;
        UtilityKotlinExtentionsKt.t(r124);
    L84:
        View r125 = this.f127673q;
        if (r125 == null) goto L87;
        r125.setBackground(null);
    L87:
        RecyclerView r126 = u();
        r126.removeItemDecoration((RecyclerView.ItemDecoration) this.f127678v.getValue());
        r126.addItemDecoration((RecyclerView.ItemDecoration) this.f127679w.getValue());
        r126.setLayoutManager(new LinearLayoutManager(r126.getContext(), 0, false));
        return;
    L39:
        if (r121 != 2) goto L41;
        ViewGroup r127 = this.f127672p;
        if (r127 == null) goto L62;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r127, com.bytedance.android.live.revenue.common.i.b(200));
    L62:
        UtilityKotlinExtentionsKt.w(u());
        View r128 = this.f127677u;
        if (r128 == null) goto L65;
        UtilityKotlinExtentionsKt.w(r128);
    L65:
        View r129 = this.f127676t;
        if (r129 == null) goto L68;
        UtilityKotlinExtentionsKt.w(r129);
    L68:
        UtilityKotlinExtentionsKt.w(this.f127670n);
        View r130 = this.f127673q;
        if (r130 == null) goto L71;
        r130.setBackground(s1.m(R.drawable.ttlive_base_gift_receiver_info_container));
    L71:
        View r131 = this.f127675s;
        if (r131 == null) goto L74;
        UtilityKotlinExtentionsKt.t(r131);
    L74:
        RecyclerView r132 = u();
        r132.removeItemDecoration((RecyclerView.ItemDecoration) this.f127679w.getValue());
        r132.removeItemDecoration((RecyclerView.ItemDecoration) this.f127678v.getValue());
        return;
    L41:
        if (r121 != 3) goto L93;
        ViewGroup r133 = this.f127672p;
        if (r133 == null) goto L46;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r133, com.bytedance.android.live.revenue.common.i.b(200));
    L46:
        UtilityKotlinExtentionsKt.w(u());
        UtilityKotlinExtentionsKt.w(this.f127670n);
        View r134 = this.f127677u;
        if (r134 == null) goto L49;
        UtilityKotlinExtentionsKt.w(r134);
    L49:
        View r135 = this.f127676t;
        if (r135 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r135);
    L52:
        UtilityKotlinExtentionsKt.w(this.f127670n);
        View r136 = this.f127673q;
        if (r136 == null) goto L55;
        r136.setBackground(s1.m(R.drawable.ttlive_base_gift_receiver_info_container));
    L55:
        View r137 = this.f127675s;
        if (r137 == null) goto L58;
        UtilityKotlinExtentionsKt.t(r137);
    L58:
        RecyclerView r138 = u();
        r138.removeItemDecoration((RecyclerView.ItemDecoration) this.f127679w.getValue());
        r138.addItemDecoration((RecyclerView.ItemDecoration) this.f127678v.getValue());
        LinearLayoutManager r139 = new LinearLayoutManager(r138.getContext(), 0, false);
        r139.setStackFromEnd(true);
        r139.setReverseLayout(true);
        r138.setLayoutManager(r139);
        return;
    L93:
        return;
    L92:
        return;
    }
}
