package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.multitype.MultiTypeAdapter;
import com.bytedance.android.livesdk.livecommerce.multitype.f;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.livesdk.livecommerce.view.ECHostNoCouponLayout;
import com.bytedance.android.livesdk.livecommerce.view.ECLoadingLayout;
import com.bytedance.android.livesdk.livecommerce.view.ECLoadingStateView;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fh2.e;
import fh2.g;
import fh2.l;
import fh2.o;
import fh2.q;
import fh2.r;
import fh2.s;
import fh2.t;
import fh2.u;
import java.util.ArrayList;
import si2.p;

/* JADX INFO: loaded from: classes10.dex */
public class LiveRoomCouponListFragment extends ECBaseDialogFragment<LiveRoomCouponListViewModel> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f147680x = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f147681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RelativeLayout f147682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ECFunctionGuideView f147683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f147684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f147685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f147686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ECLoadingStateView f147687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ECHostNoCouponLayout f147688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ECLoadingLayout f147689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f147690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ECAlertDialog f147691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearLayoutManager f147692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MultiTypeAdapter f147693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f147694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f147695w;

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return R.layout.ec_fragment_live_room_coupon;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final boolean ha0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void da0() {
        this.f147687o.setVisibility(0);
        ECLoadingStateView r100 = this.f147687o;
        r100.f153169e.showLoading();
        r100.f153168d.setVisibility(8);
        r100.f153167c.setVisibility(8);
        this.f147686n.setVisibility(8);
        this.f147688p.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        LiveRoomCouponListViewModel r100 = (LiveRoomCouponListViewModel) this.f147650g;
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ea0() {
        this.f147687o.setVisibility(0);
        ECLoadingStateView r100 = this.f147687o;
        r100.f153167c.setVisibility(8);
        r100.f153168d.setVisibility(0);
        r100.f153168d.setBackgroundGray(false);
        r100.f153169e.reset();
        this.f147686n.setVisibility(8);
        this.f147688p.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void fa0() {
        if (this.f147693u.getItemCount() <= ((this.f147693u.f149485d ? 1 : 0) + 0)) goto L5;
        this.f147686n.setVisibility(0);
        this.f147688p.setVisibility(8);
        this.f147685m.setVisibility(0);
    L6:
        this.f147690r.setText(th.a.g(getContext(), R.string.ec_search_no_more));
        this.f147687o.setVisibility(8);
        return;
    L5:
        this.f147686n.setVisibility(8);
        this.f147688p.setBindNotice(((LiveRoomCouponListViewModel) this.f147650g).getCouponBindNotice());
        this.f147688p.setVisibility(0);
        this.f147685m.setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, com.bytedance.android.livesdk.livecommerce.room.controller.z
    public final void onLiveEnd() {
        ECAlertDialog r100 = this.f147691s;
        if (r100 != null) goto L5;
    L23:
        ECBaseDialogFragment.T90(this);
        return;
    L5:
        if (r100.isShowing() == false) goto L23;
        ECAlertDialog r101 = this.f147691s;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r101);
        goto L23
    L16:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L23
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r100.gravity = 80;
        return r100;
    }

    public LiveRoomCouponListFragment() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog.b
    public final void Nc(ECBottomDialog.a r100) {
        super.Nc(r100);
        LiveRoomCouponListViewModel r101 = (LiveRoomCouponListViewModel) this.f147650g;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void aa0(Bundle r100) {
        if (r100 == null) goto L5;
        this.f147694v = r100.getString("room_id");
        this.f147695w = r100.getString("anchor_id");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ga0(String r100) {
        this.f147687o.setVisibility(0);
        ECLoadingStateView r101 = this.f147687o;
        r101.f153166b.setTextColor(r101.getContext().getResources().getColor(R.color.ec_color_black_161823_75));
        r101.f153166b.setText(r100);
        r101.f153168d.setVisibility(8);
        r101.f153167c.setVisibility(0);
        r101.f153169e.reset();
        this.f147686n.setVisibility(8);
        this.f147688p.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        ((LiveRoomCouponListViewModel) this.f147650g).init(this.f147694v, this.f147695w, getContext());
        ((LiveRoomCouponListViewModel) this.f147650g).setEnterFrom("");
        View r111 = getView();
        if (r111 == null) goto L19;
        this.f147682j = (RelativeLayout) r111.findViewById(R.id.rl_title_layout);
        TextView r100 = (TextView) r111.findViewById(R.id.tv_coupon_text);
        this.f147681i = (ImageView) r111.findViewById(R.id.iv_back);
        this.f147684l = (ImageView) r111.findViewById(R.id.iv_coupon_desc);
        this.f147685m = r111.findViewById(R.id.tv_bind_coupon);
        this.f147686n = (RecyclerView) r111.findViewById(R.id.rv_coupon_list);
        this.f147687o = (ECLoadingStateView) r111.findViewById(R.id.eclv_loading);
        this.f147688p = (ECHostNoCouponLayout) r111.findViewById(R.id.echncl_no_coupon);
        this.f147689q = (ECLoadingLayout) r111.findViewById(R.id.ecll_loading);
        this.f147683k = (ECFunctionGuideView) r111.findViewById(R.id.view_function_guide);
        RecyclerView r112 = this.f147686n;
        LinearLayoutManager r101 = new LinearLayoutManager(getActivity(), 1, false);
        this.f147692t = r101;
        r112.setLayoutManager(r101);
        MultiTypeAdapter r102 = new MultiTypeAdapter();
        this.f147693u = r102;
        LiveRoomNewCouponViewBinder r103 = new LiveRoomNewCouponViewBinder((LiveRoomNewCouponViewBinder.a) this.f147650g);
        com.bytedance.android.livesdk.livecommerce.multitype.d r104 = (com.bytedance.android.livesdk.livecommerce.multitype.d) r102.f149483b;
        r104.getClass();
        boolean r105 = false;
    L6:
        int r106 = ((ArrayList) r104.f149489a).indexOf(p.class);
        if (r106 == (-1)) goto L9;
        ListProtector.remove(r104.f149489a, r106);
        ListProtector.remove(r104.f149490b, r106);
        ListProtector.remove(r104.f149491c, r106);
        r105 = true;
        goto L6
    L9:
        if (r105 == true) goto L11;
    L11:
        f r107 = r102.f149483b;
        com.bytedance.android.livesdk.livecommerce.multitype.a r108 = new com.bytedance.android.livesdk.livecommerce.multitype.a();
        com.bytedance.android.livesdk.livecommerce.multitype.d r109 = (com.bytedance.android.livesdk.livecommerce.multitype.d) r107;
        r109.getClass();
        ((ArrayList) r109.f149489a).add(p.class);
        ((ArrayList) r109.f149490b).add(r103);
        ((ArrayList) r109.f149491c).add(r108);
        if (getContext() == null) goto L15;
        this.f147690r = new TextView(getContext());
        ViewGroup.MarginLayoutParams r113 = new ViewGroup.MarginLayoutParams(-1, -2);
        r113.topMargin = w0.a(3.0f);
        r113.bottomMargin = w0.a(5.0f);
        this.f147690r.setTextSize(1, 13.0f);
        this.f147690r.setLayoutParams(r113);
        this.f147690r.setTextColor(th.a.a(getContext(), R.color.ec_color_black_161823_50));
        this.f147690r.setGravity(17);
        this.f147690r.setText(th.a.g(getContext(), R.string.ec_loading_text));
    L15:
        MultiTypeAdapter r114 = this.f147693u;
        q r115 = new q(this);
        View r116 = r114.f149484c;
        if (r116 == null) goto L18;
        r116.setVisibility(0);
    L18:
        r114.f149486e = r115;
        r114.f149485d = true;
        MultiTypeAdapter r117 = this.f147693u;
        r117.f149487f = new b(this);
        ((LiveRoomCouponListViewModel) this.f147650g).bindDataAdapter(r117);
        r112.setAdapter(this.f147693u);
        this.f147681i.setOnClickListener(this);
        this.f147684l.setOnClickListener(this);
        this.f147685m.setOnClickListener(this);
        this.f147687o.setRetryClickListener(new l(this));
        this.f147688p.setBindCouponClickListener(new o(this));
        this.f147687o.post(new fh2.p(this));
    L19:
        ((LiveRoomCouponListViewModel) this.f147650g).getAdapterChangeData().observe(this, new r(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getAdapterAppendData().observe(this, new s(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getDistributeCouponData().observe(this, new t(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getFullLoadingData().observe(this, new u(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getFullLoadingFinishData().observe(this, new fh2.b(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getScrollData().observe(this, new fh2.c(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getCouponDetailGuideData().observe(this, new fh2.d(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getDismissFunctionGuideData().observe(this, new e(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getEndCouponGuideData().observe(this, new fh2.f(this));
        ((LiveRoomCouponListViewModel) this.f147650g).getDistributeResponse().observe(this, new g(this));
        ((LiveRoomCouponListViewModel) this.f147650g).start();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, android.view.View.OnClickListener
    public final void onClick(View r100) {
        super.onClick(r100);
        if (r100 != this.f147681i) goto L11;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L19;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L11:
        if (r100 != this.f147684l) goto L14;
        com.bytedance.android.livesdk.livecommerce.event.t r102 = new com.bytedance.android.livesdk.livecommerce.event.t();
        r102.f("room_id", this.f147694v);
        r102.f("anchor_id", this.f147695w);
        r102.f("button_for", "coupon_question");
        r102.f("page_name", "within_live");
        r102.k();
        ((LiveRoomCouponListViewModel) this.f147650g).openDistributeCouponDescFragment(getContext(), getFragmentManager());
        return;
    L14:
        if (r100 != this.f147685m) goto L22;
        ((LiveRoomCouponListViewModel) this.f147650g).bindCoupon(getFragmentManager());
        return;
    }
}
