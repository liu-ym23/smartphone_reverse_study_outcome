package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoInviteView;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkBanSettingFragment;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorLinkMatchInviteFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/contract/AnchorLinkInviteContract$View;", "Lx31/e;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkMatchInviteFragment extends AnchorLinkInviteContract$View implements x31.e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f93382p = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, View> f93383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s1 f93384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animation f93385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Animation f93386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Animation f93387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f93388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.connect.n f93389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f93390n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f93391o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkMatchInviteFragment f93392a;

        public b(AnchorLinkMatchInviteFragment r100) {
            this.f93392a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            IRoom r101 = com.bytedance.android.live.revlink.impl.utils.u.a();
            if (r101 == null) goto L5;
            int r102 = PkBanSettingFragment.f95362n;
            AnchorLinkMatchInviteFragment r103 = this.f93392a;
            int r104 = AnchorLinkMatchInviteFragment.f93382p;
            PkBanSettingFragment r105 = PkBanSettingFragment.a.a(r103.f92314d, r101, r103, null);
            AnchorLinkMatchInviteFragment r106 = this.f93392a;
            r106.getClass();
            r105.ca0(r106.f93384h);
            this.f93392a.f92314d.zD(r105);
        L5:
            l51.a.H();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkMatchInviteFragment f93393a;

        public c(AnchorLinkMatchInviteFragment r100) {
            this.f93393a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = AnchorLinkMatchInviteFragment.f93382p;
            this.f93393a.ea0(2);
            this.f93393a.da0("reject");
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkMatchInviteFragment f93394a;

        public d(AnchorLinkMatchInviteFragment r100) {
            this.f93394a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r410) {
            AnchorLinkMatchInviteFragment r100 = this.f93394a;
            int r101 = AnchorLinkMatchInviteFragment.f93382p;
            r100.da0("accept");
            s1 r102 = this.f93394a.f93384h;
            if (r102 == null) goto L28;
            long r103 = com.bytedance.android.live.revlink.impl.utils.u.d();
            long r104 = r102.getFromRoomId();
            int r105 = r102.getInviteType();
            int r110 = r102.getMatchType();
            Intrinsics.checkNotNullParameter(r102, "$this$fromUid");
            String r111 = r102.get_fromUid();
            IBattleLinkerInviteMessageExtra r106 = r102.getBattleExtra();
            if (r106 == null) goto L11;
            IRoom r107 = r106.getInviteRoom();
            if (r107 == null) goto L11;
            IBaseUser r108 = r107.getOwner();
            if (r108 == null) goto L11;
            Intrinsics.checkNotNullParameter(r108, "$this$secUidExt");
            String r112 = r108.getCastSecUid();
        L12:
            s1 r109 = this.f93394a.f93384h;
            if (r109 == null) goto L17;
            IBattleLinkerInviteMessageExtra r113 = r109.getBattleExtra();
            if (r113 == null) goto L17;
            IRoom r114 = r113.getInviteRoom();
        L18:
            int r115 = BizType.AnchorLink.ordinal();
            s1 r116 = this.f93394a.f93384h;
            if (r116 == null) goto L21;
            String r210 = r116.getBattleAttachedInfo();
        L22:
            String r117 = r102.getClientInfo();
            if (r117 != null) goto L25;
            r117 = "";
        L25:
            d11.d r118 = new d11.d(7, r103, r104, r105, r110, r111, r112, r114, r115, null, 0, null, 0, 0, null, 0, null, null, null, r210, 0, 0, 0, null, r117, null, null, null, 519568896);
            com.bytedance.android.live.revenuelink.connect.n r119 = this.f93394a.f93389m;
            if (r119 == null) goto L28;
            r119.d(r118, null);
            goto L28
        L21:
            r210 = null;
        L17:
            r114 = null;
        L11:
            r112 = null;
        L28:
            AnchorLinkMatchInviteFragment r120 = this.f93394a;
            p0 r121 = e21.c.b(r120.f93384h);
            LinkedHashMap r122 = new LinkedHashMap();
            r122.put("if_strategy_invite", "1");
            r122.put("match_time", String.valueOf((int) ((System.currentTimeMillis() - r120.f93391o) / ((long) 1000))));
            r122.put("success_type", "1v1");
            mz0.n r123 = new mz0.n();
            mz0.o r124 = new mz0.o(r123.f516447a);
            r124.a("from_room_status", "live");
            r124.a("anchor_type", "invitee");
            r124.a("is_rematch", "0");
            r124.a(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, "single_link");
            r124.a("connection_sub_type", "");
            r124.a("invite_mode", "routine_pk");
            r124.a("anchor_connect_status", "2");
            r124.a("room_status", "live");
            com.bytedance.android.live.revlink.impl.control.d r125 = com.bytedance.android.live.revlink.impl.global.b.f();
            if (r125 == null) goto L33;
            String r126 = r125.getRequestId();
            if (r126 == null) goto L33;
            r124.a("request_id", r126);
        L33:
            r124.b(r122);
            e21.c.e(r124, r121);
            mz0.m r127 = new mz0.m();
            r127.b(LogCommon.ROOM);
            ((ArrayList) r123.f516448b).addAll(r127.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r128 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r129 = com.bytedance.android.scope.m.b(r128).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r129);
            ((mz0.i) ((f80.a) r129)).w3("livesdk_random_match_success", r123.f516447a, r123.f516448b);
            com.bytedance.android.live.revlink.impl.control.dialog.r r130 = this.f93394a.f92314d;
            if (r130 == null) goto L37;
            r130.dismiss();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkMatchInviteFragment f93395a;

        public e(AnchorLinkMatchInviteFragment r100) {
            this.f93395a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            AnchorLinkMatchInviteFragment r102 = this.f93395a;
            int r103 = AnchorLinkMatchInviteFragment.f93382p;
            com.bytedance.android.live.revlink.impl.control.dialog.r r104 = r102.f92314d;
            if (r104 == null) goto L6;
            r104.dismiss();
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkMatchInviteFragment f93396a;

        public f(AnchorLinkMatchInviteFragment r100) {
            this.f93396a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = this.f93396a.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
            AnchorLinkMatchInviteFragment r102 = this.f93396a;
            int r103 = AnchorLinkMatchInviteFragment.f93382p;
            com.bytedance.android.live.revlink.impl.control.dialog.r r104 = r102.f92314d;
            if (r104 == null) goto L6;
            r104.dismiss();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // x31.e
    public final void ec() {
        ea0(5);
        ((i21.a) this.f92316f).e();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return this.f93388l;
    }

    public AnchorLinkMatchInviteFragment() {
        this.f93383g = new LinkedHashMap();
        this.f93388l = 251;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r100 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r100 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.n r101 = r100.getLinkOutManagerFn();
    L6:
        this.f93389m = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View W90() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_ban_be_invite_setting_opt, (ViewGroup) getView(), false);
        if (l51.a.i() == false) goto L5;
        r100.findViewById(R.id.ban_setting_guide_dot).setVisibility(0);
    L5:
        r100.setOnClickListener(new b(this));
        return r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_multi_anchor_invite_dialog_top, null);
        if (r100 == null) goto L15;
        ViewGroup r101 = (ViewGroup) r100;
        ((TextView) r101.findViewById(R.id.anchor_pk_hint)).setVisibility(8);
        TextView r102 = (TextView) r101.findViewById(R.id.title_left);
        s1 r103 = this.f93384h;
        if (r103 == null) goto L11;
        IBattleLinkerInviteMessageExtra r104 = r103.getBattleExtra();
        if (r104 == null) goto L11;
        String r105 = r104.getTips();
        if (r105 == null) goto L11;
    L12:
        r102.setText(r105);
        return r101;
    L11:
        r105 = "";
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ((i21.a) this.f92316f).e();
        Animation r100 = this.f93385i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Animation r101 = this.f93386j;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        Animation r102 = this.f93387k;
        if (r102 == null) goto L12;
        r102.cancel();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f93383g.clear();
    }

    @Override // x31.e
    public final boolean UK() {
        return this.f93390n;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View
    public final void ba0(int r100) {
        if (this.mStatusViewValid == true) goto L5;
        return;
    L5:
        ((TextView) ca0(R.id.bt_refuse)).setText(FormatUtils.format(getString(R.string.ttlive_anchor_link_invite_refuse_time), new Object[]{Integer.valueOf(r100)}));
        if (r100 != 0) goto L9;
        this.f93390n = true;
        da0("overtime");
        ea0(5);
        return;
    }

    public final View ca0(int r100) {
        if (this.f93383g != null) goto L5;
        this.f93383g = new LinkedHashMap();
    L5:
        View r101 = this.f93383g.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f93383g.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void da0(String r100) {
        s1 r101 = this.f93384h;
        if (r101 == null) goto L14;
        String r102 = r101.getClientInfo();
        if (r102 == null) goto L14;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl((v3) com.bytedance.android.live.revlink.impl.utils.e.a(r102, v3.class));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        v3 r105 = (v3) r104;
    L15:
        s1 r106 = this.f93384h;
        if (r106 == null) goto L18;
        p0 r107 = e21.c.b(r106);
    L19:
        HashMap r108 = new HashMap();
        s1 r109 = this.f93384h;
        if (r109 == null) goto L24;
        IBattleLinkerInviteMessageExtra r110 = r109.getBattleExtra();
        if (r110 == null) goto L24;
        IRoom r111 = r110.getInviteRoom();
    L25:
        String r112 = "";
        if (r111 == null) goto L31;
        IBaseUser r113 = r111.getOwner();
        if (r113 == null) goto L31;
        String r114 = iz.a.a(r113);
        if (r114 == null) goto L31;
    L32:
        r108.put("inviter_id", r114);
        String r115 = iz.a.a(((com.bytedance.android.livesdk.revenue.service.user.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class)).b());
        if (r115 != null) goto L35;
        r115 = "";
    L35:
        r108.put("invitee_id", r115);
        r108.put("selection", r100);
        int r116 = UserListInviteType.f70864a;
        s1 r117 = this.f93384h;
        if (r117 == null) goto L40;
        IBattleLinkerInviteMessageExtra r118 = r117.getBattleExtra();
        if (r118 == null) goto L40;
        int r119 = (int) r118.getInviteType();
    L41:
        r108.put("invitee_list", UserListInviteType.a(r119, null));
        r108.put("npk_link_type", "single");
        r108.put("connection_type", "random_link");
        r108.put("connection_sub_type", "random_nlink");
        r108.put("audience_connect_cnt", "0");
        r108.put("list_num", "0");
        d31.d r120 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r120 == null) goto L45;
        String r121 = r120.a();
        if (r121 == null) goto L45;
    L46:
        r108.put("anchor_connect_status", r121);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r122 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r122 == null) goto L49;
        String r123 = r122.p();
    L50:
        r108.put("invitee_connection_status", r123);
        r108.put("anchor_connection_type", "invite");
        r108.put("is_oncemore", "0");
        r108.put("invite_mode", WsConstants.KEY_CONNECTION);
        r108.put("invite_type", "anchor");
        d31.d r124 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r124 == null) goto L53;
        String r125 = r124.s();
    L54:
        r108.put("room_status", r125);
        r108.put("inviter_connect_cnt", "0");
        r108.put("inviter_room_status", "live");
        d31.d r126 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r126 == null) goto L57;
        String r127 = r126.s();
    L58:
        r108.put("from_room_status", r127);
        d31.d r128 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r128 == null) goto L61;
        String r129 = r128.s();
    L62:
        r108.put("room_status", r129);
        if (r111 == null) goto L68;
        String r130 = String.valueOf(r111.getRoomId());
        if (r130 == null) goto L68;
        r112 = r130;
    L68:
        r108.put("inviter_room_id", r112);
        s1 r131 = this.f93384h;
        if (r131 == null) goto L75;
        IBattleLinkerInviteMessageExtra r132 = r131.getBattleExtra();
        if (r132 == null) goto L75;
        if (((int) r132.getInviteType()) != 13) goto L75;
        r108.put("if_strategy_invite", "1");
    L76:
        mz0.n r133 = new mz0.n();
        mz0.o r134 = new mz0.o(r133.f516447a);
        r134.b(r108);
        e21.e.d(r134, r105);
        e21.c.e(r134, r107);
        mz0.m r135 = new mz0.m();
        LinkCrossRoomDataHolder.a r136 = LinkCrossRoomDataHolder.f92004c;
        com.bytedance.android.live.revlink.impl.a.a(r135);
        r135.b(LogCommon.ROOM);
        ((ArrayList) r133.f516448b).addAll(r135.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r137 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r138 = com.bytedance.android.scope.m.b(r137).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r138);
        ((mz0.i) ((f80.a) r138)).w3("livesdk_connection_invited", r133.f516447a, r133.f516448b);
        return;
    L75:
        r108.put("if_strategy_invite", "0");
        goto L76
    L61:
        r129 = "";
        goto L62
    L57:
        r127 = "";
        goto L58
    L53:
        r125 = "";
        goto L54
    L49:
        r123 = "";
    L45:
        r121 = "";
    L40:
        r119 = 0;
    L31:
        r114 = "";
    L24:
        r111 = null;
        goto L25
    L18:
        r107 = null;
    L8:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        r105 = null;
        goto L15
    }

    public final void ea0(long r100) {
        r31.a r101 = r31.b.a(r31.a.f535859a);
        long r102 = com.bytedance.android.live.revlink.impl.utils.u.d();
        s1 r103 = this.f93384h;
        if (r103 == null) goto L8;
        Intrinsics.checkNotNullParameter(r103, "$this$fromUid");
        String r104 = r103.get_fromUid();
        if (r104 == null) goto L8;
        String r105 = r104;
    L9:
        s1 r106 = this.f93384h;
        if (r106 == null) goto L15;
        String r107 = r106.getClientInfo();
        if (r107 == null) goto L15;
        String r108 = r107;
    L16:
        Observable<ExtraResponse<Object, Extra>> r109 = r101.o(r100, r102, r105, r108);
        if (r109 == null) goto L24;
        Observable<R> r110 = r109.compose(RxUtil.rxSchedulerHelper());
        if (r110 == 0) goto L25;
        ObservableSubscribeProxy r111 = (ObservableSubscribeProxy) r110.as(S90());
        if (r111 == null) goto L26;
        r111.subscribe(new e(this), new f(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L15:
        r108 = "";
    L8:
        r105 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f93391o = System.currentTimeMillis();
        this.f93385i = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_beinvited_avatar);
        this.f93386j = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_beinvited_avatar_out);
        this.f93387k = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_beinvited_wave);
        Animation r101 = this.f93385i;
        if (r101 == null) goto L5;
        r101.setRepeatCount(-1);
    L5:
        Animation r102 = this.f93385i;
        if (r102 == null) goto L8;
        r102.setInterpolator(new LinearInterpolator());
    L8:
        Animation r103 = this.f93387k;
        if (r103 == null) goto L11;
        r103.setInterpolator(new LinearInterpolator());
    L11:
        this.f92314d.F4(false);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        IBaseUser r100 = ((com.bytedance.android.livesdk.revenue.service.user.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class)).b();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        ((TextView) ca0(R.id.private_hint)).setVisibility(0);
        String r102 = f51.a.f475613e.a();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        TextView r103 = (TextView) ca0(R.id.private_hint);
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r103.setText(String.format(r102, Arrays.copyOf(new Object[]{Integer.valueOf(R.string.ttlive_interaction_more)}, 1)));
    L12:
        s1 r105 = this.f93384h;
        String r106 = null;
        if (r105 == null) goto L61;
        IBattleLinkerInviteMessageExtra r107 = r105.getBattleExtra();
        if (r107 == null) goto L61;
        IRoom r108 = r107.getInviteRoom();
        if (r108 == null) goto L61;
        IBaseUser r109 = r108.getOwner();
        if (r109 == null) goto L61;
        AnchorLinkInfoInviteView r110 = (AnchorLinkInfoInviteView) ca0(R.id.link_anchor_1);
        a1.x(r110.getIvAvatar(), r109.getAvatarThumbKt(), r110.getIvAvatar().getWidth(), r110.getIvAvatar().getHeight(), R.drawable.ttlive_ic_default_head_small);
        r110.getTvNickname().setText(r109.getNickName());
        if (r109.getGender() != 1) goto L24;
        r110.getIvGender().setImageResource(R.drawable.ttlive_gender_male_icon);
        r110.getIvGender().setVisibility(0);
    L28:
        if (r109.getFollowInfo() == null) goto L34;
        py.j r111 = r109.getFollowInfo();
        if (r111 == null) goto L34;
        if (r111.getFollowStatus() != 2) goto L34;
        r110.getTvLabelTop().setVisibility(0);
    L34:
        r110.getTvDistance().setVisibility(0);
        if (r109.getFollowInfo() == null) goto L41;
        TextView r112 = r110.getTvDistance();
        Object[] r113 = new Object[1];
        py.j r114 = r109.getFollowInfo();
        if (r114 == null) goto L39;
        long r115 = r114.getFollowerCount();
    L40:
        r113[0] = IESUIUtils.getDisplayCount(r115, "w");
        r112.setText(com.bytedance.android.live.core.utils.s1.C(R.string.ttlive_anchor_link_dialog_fans_number, r113));
        goto L41
    L39:
        r115 = 0;
    L41:
        r110.setVisibility(0);
        s1 r116 = this.f93384h;
        if (r116 == null) goto L61;
        IBattleLinkerInviteMessageExtra r117 = r116.getBattleExtra();
        if (r117 == null) goto L61;
        List<IBattleRivalTag> r118 = r117.getMatchTags();
        if (r118 == null) goto L61;
        Iterator<IBattleRivalTag> r119 = r118.iterator();
    L49:
        if (r119.hasNext() == false) goto L61;
        IBattleRivalTag r120 = r119.next();
        LinearLayout r121 = (LinearLayout) ca0(R.id.anchor_match_tags);
        if (r121 == null) goto L49;
        View r122 = LayoutInflater.from(((LinearLayout) ca0(R.id.anchor_match_tags)).getContext()).inflate(R.layout.ttlive_layout_match_tag, null);
        if (r122 == null) goto L60;
        TextView r123 = (TextView) r122;
        r123.setText(r120.getContent());
        r123.setTextColor(Color.parseColor(r120.getFontColor()));     // Catch: Exception -> L57
    L58:
        ((ObservableSubscribeProxy) a1.k(r120.getBackgroundImage()).compose(RxUtil.rxSchedulerHelper()).as(S90())).subscribe(new q(r123));
        LinearLayout.LayoutParams r124 = new LinearLayout.LayoutParams(-2, com.bytedance.android.live.revenue.common.i.b(20));
        r124.rightMargin = com.bytedance.android.live.revenue.common.i.b(4);
        Unit r125 = Unit.INSTANCE;
        r121.addView(r123, r124);
    L57:
        r123.setTextColor(ColorProtector.parseColor("#ff3b61"));
        goto L58
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L24:
        if (r109.getGender() != 2) goto L26;
        r110.getIvGender().setImageResource(R.drawable.ttlive_gender_female_icon);
        r110.getIvGender().setVisibility(0);
        goto L28
    L26:
        r110.getIvGender().setVisibility(8);
    L61:
        AnchorLinkInfoInviteView r126 = (AnchorLinkInfoInviteView) ca0(R.id.link_anchor_1);
        r126.getIvAvatar().startAnimation(this.f93385i);
        r126.getViewWave().setVisibility(0);
        r126.getAnimWave().setVisibility(0);
        r126.getAnimWave().startAnimation(this.f93387k);
        Animation r127 = this.f93385i;
        if (r127 == null) goto L64;
        r127.setAnimationListener(new r(this, r126));
    L64:
        Animation r128 = this.f93386j;
        if (r128 == null) goto L67;
        r128.setAnimationListener(new s(this, r126));
    L67:
        i21.a r129 = (i21.a) this.f92316f;
        s1 r130 = this.f93384h;
        if (r130 == null) goto L70;
        int r131 = (int) r130.getWaitSec();
    L71:
        r129.f(r131);
        ((TextView) ca0(R.id.bt_refuse)).setOnClickListener(new c(this));
        ((TextView) ca0(R.id.bt_accept)).setOnClickListener(new d(this));
        s1 r132 = this.f93384h;
        if (r132 == null) goto L83;
        String r133 = r132.getClientInfo();
        if (r133 == null) goto L83;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L77
        Object r135 = Result.m9449constructorimpl((v3) com.bytedance.android.live.revlink.impl.utils.e.a(r133, v3.class));     // Catch: Throwable -> L77
    L80:
        if (Result.m9455isFailureimpl(r135) == false) goto L82;
        r135 = null;
    L82:
        v3 r136 = (v3) r135;
    L84:
        s1 r137 = this.f93384h;
        if (r137 == null) goto L87;
        p0 r138 = e21.c.b(r137);
    L88:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r139 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r139 == null) goto L122;
        s1 r140 = this.f93384h;
        if (r140 == null) goto L95;
        IBattleLinkerInviteMessageExtra r141 = r140.getBattleExtra();
        if (r141 == null) goto L95;
        int r142 = (int) r141.getInviteType();
    L96:
        s1 r143 = this.f93384h;
        if (r143 == null) goto L101;
        IBattleLinkerInviteMessageExtra r144 = r143.getBattleExtra();
        if (r144 == null) goto L101;
        int r145 = (int) r144.getMatchType();
    L102:
        s1 r146 = this.f93384h;
        if (r146 == null) goto L105;
        Intrinsics.checkNotNullParameter(r146, "$this$fromUid");
        r106 = r146.get_fromUid();
    L105:
        String r147 = r106;
        s1 r148 = this.f93384h;
        if (r148 == null) goto L109;
        String r149 = String.valueOf(r148.getFromRoomId());
        if (r149 == null) goto L109;
    L110:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q.o(r139, r142, false, false, 1, false, r145, r147, r149, r136, r138, null, 1024);
        return;
    L109:
        r149 = "";
    L101:
        r145 = 0;
    L95:
        r142 = 0;
        goto L96
    L122:
        return;
    L87:
        r138 = null;
    L77:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L83:
        r136 = null;
        goto L84
    L70:
        r131 = 10;
        goto L71
    L5:
        if (r100.getSecret() != 1) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_fragment_anchor_link_match_invite, r101, false);
    }
}
