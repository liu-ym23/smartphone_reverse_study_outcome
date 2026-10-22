package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/TalkRoomNormalApplyTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkRoomNormalApplyTitleViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f75163m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f75164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f75165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f75166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f75167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f75168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f75169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f75170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f75171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f75172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c90.a f75173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.linkpanel.list.a f75174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList<?> f75175l;

    public static final class a {
    }

    static {
    }

    public final TextView U3() {
        return (TextView) this.f75165b.getValue();
    }

    public final TextView W3() {
        return (TextView) this.f75167d.getValue();
    }

    public static int V3(ApplyTitlePanelType r100) {
        Integer r101 = b6.B.getValue();
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        if (r101 != null) goto L16;
    L21:
        return R.string.waiting_time;
    L16:
        if (r101.intValue() != 42) goto L21;
        if (r100 != ApplyTitlePanelType.GUEST_APPLY) goto L20;
        return R.string.order_by_recommend_guest;
    L20:
        return R.string.order_by_recommend;
    L11:
        if (r101.intValue() != 40) goto L13;
    L6:
        if (r101.intValue() != 41) goto L8;
        return R.string.gift_value;
    }

    public final void X3(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateBubbleSelectUi");
        if (r101 == false) goto L5;
        r100.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ttlive_ic_interact_sort_selected, 0);
        return;
    L5:
        r100.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public TalkRoomNormalApplyTitleViewHolder(final View r100, com.bytedance.android.live.liveinteract.linkpanel.list.a r101, LinkedList<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f75174k = r101;
        this.f75175l = r102;
        this.f75164a = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$sortViewLayout$2(r100));
        this.f75165b = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$currentOrder$2(r100));
        this.f75166c = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$switchSortLayout$2(r100));
        this.f75167d = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$tvSortType$2(r100));
        this.f75168e = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$ivSwitcher$2(r100));
        this.f75169f = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$ivRule$2(r100));
        this.f75170g = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$priceAmountSortTypeTv$2(r100));
        Boolean r103 = m.i().isAnchor();
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L6:
        this.f75171h = r104;
        this.f75172i = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().c();
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final void T3(boolean r100, int r101, ApplyTitlePanelType r102) {
        Intrinsics.checkNotNullParameter(r102, "panelType");
        if (r101 != 1) goto L9;
        View r103 = this.itemView;
        ((ImageView) this.f75168e.getValue()).setVisibility(8);
        a1.n(W3(), s1.f(0.0f));
        if (this.f75171h == false) goto L7;
        ((FrameLayout) this.f75166c.getValue()).setVisibility(8);
        r103.setBackgroundColor(s1.h(R.color.ttlive_core_hs_w4));
        U3().setText(R.string.premium_guests);
        return;
    L7:
        U3().setText(R.string.premium_guests);
        W3().setText(R.string.premium_guests_wait_time);
        return;
    L9:
        if (r101 != 2) goto L29;
        this.itemView.setBackgroundColor(s1.h(R.color.ttlive_core_hs_w1));
        boolean r104 = this.f75171h;
        if (r104 == false) goto L23;
        if (r104 == false) goto L19;
        IInteractService r105 = (IInteractService) k.f(IInteractService.class);
        if (r105 != null) goto L16;
    L18:
        ((FrameLayout) this.f75166c.getValue()).setOnClickListener(x0.a(new TalkRoomNormalApplyTitleViewHolder$initSortView$1(this)));
        goto L19
    L16:
        if (r105.getCurrentScene() != 4) goto L18;
        ((ImageView) this.f75168e.getValue()).setVisibility(8);
        a1.n(W3(), s1.f(0.0f));
    L19:
        if (r100 == false) goto L21;
        U3().setText(R.string.normal_apply_guests);
    L22:
        W3().setText(V3(r102));
        return;
    L21:
        U3().setText(R.string.current_order);
        goto L22
    L23:
        UtilityKotlinExtentionsKt.t((ImageView) this.f75169f.getValue());
        a1.n(W3(), s1.f(0.0f));
        ((ImageView) this.f75168e.getValue()).setVisibility(8);
        if (r100 == false) goto L26;
        U3().setText(R.string.normal_apply_guests);
    L27:
        W3().setText(V3(r102));
        return;
    L26:
        U3().setText(R.string.audience_in_waiting_list);
        goto L27
    L29:
        if (r101 != 3) goto L43;
        UtilityKotlinExtentionsKt.t((ImageView) this.f75168e.getValue());
        UtilityKotlinExtentionsKt.t(W3());
        if (this.f75172i == false) goto L33;
    L36:
        UtilityKotlinExtentionsKt.t((TextView) this.f75170g.getValue());
    L37:
        U3().setText(s1.B(R.string.normal_apply_guests));
        return;
    L33:
        if (this.f75171h == true) goto L36;
        UtilityKotlinExtentionsKt.w((TextView) this.f75170g.getValue());
        goto L37
    }
}
