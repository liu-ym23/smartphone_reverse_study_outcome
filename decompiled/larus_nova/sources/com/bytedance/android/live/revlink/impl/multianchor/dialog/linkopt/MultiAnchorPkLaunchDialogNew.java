package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkLaunchViewModelNew;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.RoundedLabelTitle;
import com.bytedance.android.live.revlink.impl.pk.ui.CustomViewPager;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/MultiAnchorPkLaunchDialogNew;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPkLaunchDialogNew extends LinkCommonDialogFragment implements com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f93555q = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Integer, View> f93556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f93557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IBattleConfigSetting f93558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f93559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f93560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f93561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f93562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Dialog f93563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PlayMode f93564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p21.e f93565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f93566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f93567p;

    public final class a extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Fragment> f93568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93569b;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public final Fragment getItem(int r100) {
            if (r100 != 0) goto L6;
            MultiAnchorPkLaunchDialogNew r101 = this.f93569b;
            MultiAnchorPersonalPkLaunchFragmentNew r102 = new MultiAnchorPersonalPkLaunchFragmentNew(r101.f93567p, r101.f93565n);
            r102.f93545e = this.f93569b;
            return r102;
        L6:
            if (r100 != 1) goto L10;
            MultiAnchorPkLaunchDialogNew r103 = this.f93569b;
            DataCenter r104 = r103.f93567p;
            MultiAnchorTeamPkLaunchFragmentNew r105 = new MultiAnchorTeamPkLaunchFragmentNew(r103.f93565n);
            r105.f93578e = this.f93569b;
            return r105;
        L10:
            return new Fragment();
        }

        public a(MultiAnchorPkLaunchDialogNew r100, FragmentManager r101) {
            Intrinsics.checkNotNullParameter(r101, "fm");
            this.f93569b = r100;
            super(r101);
            this.f93568a = new SparseArray(2);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Object r102 = super.instantiateItem(r100, r101);
            if (r102 == null) goto L7;
            Fragment r103 = (Fragment) r102;
            this.f93568a.put(r101, r103);
            return r103;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, "object");
            super.destroyItem(r100, r101, r102);
            this.f93568a.remove(r101);
        }
    }

    public static final class b extends i11.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93570a;

        public b(MultiAnchorPkLaunchDialogNew r100) {
            this.f93570a = r100;
        }

        @Override // i11.c.a, i11.c.b
        public final void b(int r100, List<? extends com.bytedance.android.livesdk.link.model.p> r101) {
            View r102 = this.f93570a.getView();
            if (r102 == null) goto L5;
            View r103 = r102.findViewById(R.id.pk_play_mode_content);
        L6:
            if (r101 == null) goto L8;
            int r104 = ((ArrayList) r101).size();
        L10:
            if (r104 <= 6) goto L12;
            int r105 = 216;
        L13:
            UIUtils.updateLayout(r103, -3, UtilityKotlinExtentionsKt.i(r105));
            return;
        L12:
            r105 = 124;
            goto L13
        L8:
            r104 = 0;
            goto L10
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93571a;

        public c(MultiAnchorPkLaunchDialogNew r100) {
            this.f93571a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f93571a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93572a;

        public d(MultiAnchorPkLaunchDialogNew r100) {
            this.f93572a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.live.revlink.impl.multianchor.service.c r101 = com.bytedance.android.live.revlink.impl.global.b.y();
            if (r101 == null) goto L5;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r101, 0, 0, null, 7);
        L5:
            MultiAnchorPkLaunchDialogNew r102 = this.f93572a;
            int r103 = MultiAnchorPkLaunchDialogNew.f93555q;
            r102.X90("click", "back");
            this.f93572a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r104 = DialogFragmentLancet.sLastShowStack;
            if (r104 == null) goto L15;
            com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements RoundedLabelTitle.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93573a;

        public e(MultiAnchorPkLaunchDialogNew r100) {
            this.f93573a = r100;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.RoundedLabelTitle.c
        public final void a(PlayMode r100) {
            Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
            MultiAnchorPkLaunchDialogNew r101 = this.f93573a;
            r101.f93562k = true;
            if (r100 != PlayMode.PERSONAL_PK) goto L5;
            String r102 = IPortraitService.TYPE_ONE_PORTRAIT;
        L6:
            r101.X90("click", r102);
            MultiAnchorPkLaunchDialogNew r103 = this.f93573a;
            PlayMode r104 = r103.V90().getPlayModeLiveData().getValue();
            if (r104 == null) goto L41;
            if (r104 == r100) goto L42;
            jy0.b.d("ttlive_anchor_link_multi_pk", "multiPKLaunchDialog onPlayModeTapped " + r100);
            HashMap r105 = new HashMap();
            String r106 = r103.f93559h;
            if (r106 == null) goto L14;
            r105.put("npk_invite_page_source", r106);
        L14:
            int r107 = y.f93622a[r104.ordinal()];
            if (r107 != 1) goto L17;
            String r108 = "individual_pk";
        L22:
            r105.put("battle_mode", r108);
            d31.d r109 = com.bytedance.android.live.revlink.impl.global.b.c0();
            String r110 = "";
            if (r109 == null) goto L25;
            String r111 = r109.s();
        L26:
            r105.put("room_status", r111);
            d31.d r112 = com.bytedance.android.live.revlink.impl.global.b.c0();
            if (r112 == null) goto L32;
            String r113 = r112.a();
            if (r113 == null) goto L32;
            r110 = r113;
        L32:
            r105.put("anchor_connect_status", r110);
            r105.put("invite_mode", r103.U90());
            mz0.n r114 = new mz0.n();
            Map<String, String> r115 = r114.f516447a;
            Intrinsics.checkNotNullParameter(r115, "map");
            Intrinsics.checkNotNullParameter(r105, "map");
            r115.putAll(r105);
            mz0.m r116 = new mz0.m();
            r116.b(LogCommon.ROOM);
            LinkCrossRoomDataHolder.a r117 = LinkCrossRoomDataHolder.f92004c;
            com.bytedance.android.live.revlink.impl.a.b(r116);
            ((ArrayList) r114.f516448b).addAll(r116.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r118 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r119 = com.bytedance.android.scope.m.b(r118).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r119);
            ((mz0.i) ((f80.a) r119)).w3("livesdk_npk_invite_page_battle_mode_click", r114.f516447a, r114.f516448b);
            if (r103.V90().getHasApplicant() == false) goto L35;
        L38:
            ToastUtil.a(R.string.ttlive_multi_anchor_switch_failed_for_inviting_or_applying, 0);
            return;
        L35:
            if (r103.V90().getHasInvitee() == true) goto L38;
            r103.V90().requestSwitchPlayMode(r100);
            return;
        L25:
            r111 = "";
            goto L26
        L17:
            if (r107 != 2) goto L20;
            r108 = "team_pk";
            goto L22
        L20:
            throw new NoWhenBranchMatchedException();
        L42:
            return;
        L41:
            return;
        L5:
            r102 = WikiSpaceType.TEAM;
            goto L6
        }
    }

    public static final class f implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93574a;

        public f(MultiAnchorPkLaunchDialogNew r100) {
            this.f93574a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f93574a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93575a;

        public g(MultiAnchorPkLaunchDialogNew r100) {
            this.f93575a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            PlayMode r111 = (PlayMode) r110;
            PlayMode r100 = PlayMode.PERSONAL_PK;
            if (r111 != r100) goto L9;
            ((RoundedLabelTitle) this.f93575a.S90(R.id.pk_play_mode_selector)).b(r100);
            ((CustomViewPager) this.f93575a.S90(R.id.pk_play_mode_content)).setCurrentItem(0);
            MultiAnchorPkLaunchDialogNew r101 = this.f93575a;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b r102 = MultiAnchorPkLaunchDialogNew.T90(r101);
            if (r102 == null) goto L7;
            boolean r103 = r102.qr();
        L8:
            r101.JW(r103, r111);
        L17:
            if (r111 == null) goto L47;
            MultiAnchorPkLaunchDialogNew r104 = this.f93575a;
            if (r104.f93561j == false) goto L47;
            r104.f93561j = true;
            HashMap r105 = new HashMap();
            com.bytedance.android.live.revlink.impl.multianchor.vm.g r106 = com.bytedance.android.live.revlink.impl.global.b.u();
            if (r106 == null) goto L23;
            Long r107 = Long.valueOf(r106.a());
        L24:
            r105.put("channel_id", String.valueOf(r107));
            w31.c r108 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r108 == null) goto L27;
            Long r109 = Long.valueOf(r108.i());
        L28:
            r105.put("pk_id", String.valueOf(r109));
            r105.put("connection_anchor_cnt", String.valueOf(r104.V90().getCurrentAnchorList().size()));
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r112 = com.bytedance.android.live.revlink.impl.global.b.l();
            if (r112 == null) goto L32;
            String r113 = r112.f93591a;
            if (r113 == null) goto L32;
        L33:
            r105.put("source", r113);
            r105.put("is_oncemore", "0");
            if (r104.V90().getPlayModeLiveData().getValue() != r100) goto L36;
            String r114 = "individual_pk";
        L37:
            r105.put("battle_mode", r114);
            if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L40;
            String r115 = PbRequest.SwitchType.PK;
        L41:
            r105.put("room_status", r115);
            d31.d r116 = com.bytedance.android.live.revlink.impl.global.b.c0();
            if (r116 == null) goto L45;
            String r117 = r116.a();
            if (r117 == null) goto L45;
        L46:
            r105.put("anchor_connect_status", r117);
            r105.put("invite_mode", r104.U90());
            mz0.n r118 = new mz0.n();
            Map<String, String> r119 = r118.f516447a;
            Intrinsics.checkNotNullParameter(r119, "map");
            Intrinsics.checkNotNullParameter(r105, "map");
            r119.putAll(r105);
            mz0.m r120 = new mz0.m();
            r120.b(LogCommon.ROOM);
            ((ArrayList) r118.f516448b).addAll(r120.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r121 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r122 = com.bytedance.android.scope.m.b(r121).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r122);
            ((mz0.i) ((f80.a) r122)).w3("livesdk_npk_gameplay_banner_show", r118.f516447a, r118.f516448b);
        L45:
            r117 = "";
            goto L46
        L40:
            r115 = WsConstants.KEY_CONNECTION;
            goto L41
        L36:
            r114 = "team_pk";
        L32:
            r113 = "";
            goto L33
        L27:
            r109 = null;
            goto L28
        L23:
            r107 = null;
        L47:
            if (r111 == null) goto L51;
            MultiAnchorPkLaunchDialogNew r123 = this.f93575a;
            if (r123.f93562k == false) goto L51;
            r123.f93562k = false;
            r123.X90("show", "");
        L51:
            if (r111 == null) goto L82;
            Dialog r124 = this.f93575a.f93563l;
            if (r124 != null) goto L55;
            return;
        L55:
            if (r124.isShowing() != true) goto L84;
            MultiAnchorPkLaunchDialogNew r125 = this.f93575a;
            if (r125.f93564m != r111) goto L85;
            Dialog r126 = r125.f93563l;
            if (r126 == null) goto L77;
            Handler r127 = DialogLancet.resolveDialogHandler(r126);
            if (r127 != null) goto L63;
        L65:
            DialogLancet.beforeDialogDismiss(r126);
            r126.dismiss();     // Catch: Throwable -> L68 Exception -> L70
        L74:
            DialogLancet.afterDialogDismiss(r126);
            goto L77
        L70:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L68
            Throwable r128 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L68
            if (r128 == null) goto L74;
            com.bytedance.crash.d.d(r128, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L68
        L68:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r126);
            throw th;
        L63:
            if (Looper.myLooper() == r127.getLooper()) goto L65;
            r127.post(DialogLancet.createDismissRunnable(r126));
        L77:
            MultiAnchorPkLaunchDialogNew r129 = this.f93575a;
            r129.f93563l = null;
            r129.f93564m = null;
            return;
        L85:
            return;
        L84:
            return;
        L82:
            return;
        L7:
            r103 = true;
            goto L8
        L9:
            PlayMode r130 = PlayMode.TEAM_PK;
            if (r111 != r130) goto L17;
            ((RoundedLabelTitle) this.f93575a.S90(R.id.pk_play_mode_selector)).b(r130);
            ((CustomViewPager) this.f93575a.S90(R.id.pk_play_mode_content)).setCurrentItem(1);
            MultiAnchorPkLaunchDialogNew r131 = this.f93575a;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b r132 = MultiAnchorPkLaunchDialogNew.T90(r131);
            if (r132 == null) goto L14;
            boolean r133 = r132.qr();
        L15:
            r131.JW(r133, r111);
            goto L17
        L14:
            r133 = true;
            goto L15
        }
    }

    public final MultiAnchorPkLaunchViewModelNew V90() {
        return (MultiAnchorPkLaunchViewModelNew) this.f93557f.getValue();
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final String getDegradeTag() {
        return "anchor_multi_launch";
    }

    public final boolean W90() {
        IBattleConfigSetting r100 = this.f93558g;
        if (r100 == null) goto L7;
        w2 r101 = r100.getShellConfig();
        if (r101 == null) goto L7;
        long r102 = r101.getType();
    L9:
        if (r102 <= 0) goto L19;
        IBattleConfigSetting r103 = this.f93558g;
        if (r103 == null) goto L19;
        w2 r104 = r103.getShellConfig();
        if (r104 == null) goto L19;
        String r105 = r104.getName();
        if (r105 == null) goto L19;
        if ((!StringsKt.isBlank(r105)) != true) goto L19;
        return true;
    L19:
        return false;
    L7:
        r102 = 0;
        goto L9
    }

    public final String U90() {
        if (W90() == false) goto L5;
        return "compete";
    L5:
        IBattleConfigSetting r100 = this.f93558g;
        if (r100 == null) goto L8;
        u2 r101 = r100.getSelfData();
    L9:
        if (r101 == null) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return "customize_pk";
    L14:
        return "routine_pk";
    L11:
        r102 = false;
        goto L12
    L8:
        r101 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f93565n.b();
        this.f93560i.dispose();
        i11.b r100 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r100 == null) goto L5;
        r100.l(this.f93566o);
    L5:
        jy0.b.d("ttlive_anchor_link_multi_pk", "multiPKLaunchDialog dismissed");
        ((LinkedHashMap) this.f93556e).clear();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b T90(MultiAnchorPkLaunchDialogNew r100) {
        CustomViewPager r101 = (CustomViewPager) r100.S90(R.id.pk_play_mode_content);
        Object r102 = null;
        if (r101 == null) goto L5;
        PagerAdapter r103 = r101.getAdapter();
    L7:
        if ((r103 instanceof a) == true) goto L9;
        r103 = null;
    L9:
        a r104 = (a) r103;
        if (r104 == null) goto L12;
        Fragment r105 = r104.f93568a.get(((CustomViewPager) r100.S90(R.id.pk_play_mode_content)).getCurrentItem());
    L14:
        if ((r105 instanceof com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b) == false) goto L18;
        r102 = r105;
    L18:
        return (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b) r102;
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    public final View S90(int r100) {
        if (this.f93556e != null) goto L5;
        this.f93556e = new LinkedHashMap();
    L5:
        View r101 = this.f93556e.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f93556e.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void Y90(Integer r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.intValue() != 4017209) goto L15;
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    }

    public MultiAnchorPkLaunchDialogNew(DataCenter r100, p21.e r101) {
        this.f93567p = r100;
        this.f93556e = new LinkedHashMap();
        this.f93557f = LazyKt.lazy(new MultiAnchorPkLaunchDialogNew$vm$2(this));
        this.f93560i = new CompositeDisposable();
        this.f93561j = true;
        this.f93562k = true;
        if (r101 != null) goto L5;
        r101 = new p21.e(com.bytedance.android.live.revlink.impl.global.b.k());
    L5:
        this.f93565n = r101;
        this.f93566o = new b(this);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a
    public final void JW(boolean r100, PlayMode r101) {
        Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
        if (V90().getPlayModeLiveData().getValue() == r101) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        ((TextView) S90(R.id.start_pk)).setBackgroundResource(R.drawable.ttlive_bg_pk_cancel);
        return;
    L7:
        ((TextView) S90(R.id.start_pk)).setBackgroundResource(R.drawable.ttlive_bg_switch_multi_disable);
    }

    public final void X90(String r100, String r101) {
        IBattleConfigSetting r102 = this.f93558g;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L14;
        HashMap r103 = new HashMap();
        r103.put("action_type", r100);
        if (V90().getPlayModeLiveData().getValue() != PlayMode.PERSONAL_PK) goto L10;
        String r104 = IPortraitService.TYPE_ONE_PORTRAIT;
    L11:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r104);
        r103.put("btn_type", r101);
        mz0.n r105 = new mz0.n();
        Map<String, String> r106 = r105.f516447a;
        Intrinsics.checkNotNullParameter(r106, "map");
        Intrinsics.checkNotNullParameter(r103, "map");
        r106.putAll(r103);
        mz0.m r107 = new mz0.m();
        r107.b(LogCommon.ROOM);
        List<Object> r108 = r105.f516448b;
        ArrayList r109 = (ArrayList) r108;
        r109.addAll(r107.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r110 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("livesdk_pk_division_season_team_popup_manage", r105.f516447a, r105.f516448b);
        return;
    L10:
        r104 = WikiSpaceType.TEAM;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        V90().setBattleConfigSetting(this.f93558g);
        V90().setNpkInvitePageSource(this.f93559h);
        FragmentManager r102 = getChildFragmentManager();
        int r103 = 0;
        ((CustomViewPager) S90(R.id.pk_play_mode_content)).f96884b = false;
        ((CustomViewPager) S90(R.id.pk_play_mode_content)).setAdapter(new a(this, r102));
        PagerAdapter r104 = ((CustomViewPager) S90(R.id.pk_play_mode_content)).getAdapter();
        if (r104 == null) goto L5;
        r104.notifyDataSetChanged();
    L5:
        i11.b r105 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r105 == null) goto L10;
        List<com.bytedance.android.livesdk.link.model.p> r106 = r105.d();
        if (r106 == null) goto L10;
        int r107 = r106.size();
    L11:
        View r108 = r100.findViewById(R.id.pk_play_mode_content);
        if (r107 <= 6) goto L14;
        int r109 = 216;
    L15:
        UIUtils.updateLayout(r108, -3, UtilityKotlinExtentionsKt.i(r109));
        i11.b r110 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r110 == null) goto L18;
        r110.i(this.f93566o);
    L18:
        TextView r111 = (TextView) S90(R.id.start_pk);
        Object[] r112 = new Object[1];
        IBattleConfigSetting r113 = this.f93558g;
        Boolean r114 = null;
        if (r113 == null) goto L23;
        w2 r115 = r113.getShellConfig();
        if (r115 == null) goto L23;
        String r116 = r115.getName();
    L24:
        if (r116 != null) goto L26;
    L28:
        IBattleConfigSetting r117 = this.f93558g;
        if (r117 != null) goto L31;
    L33:
        r116 = "PK";
    L34:
        r112[0] = r116;
        r111.setText(s1.C(R.string.ttlive_interact_start_shell_pk, r112));
        ((TextView) S90(R.id.start_pk)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        S90(R.id.outside).setOnClickListener(new c(this));
        ((ImageView) S90(R.id.back)).setOnClickListener(new d(this));
        RoundedLabelTitle r118 = (RoundedLabelTitle) S90(R.id.pk_play_mode_selector);
        MultiAnchorPkLaunchContext r119 = com.bytedance.android.live.revlink.impl.global.b.x();
        if (r119 == null) goto L42;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r120 = r119.getMultiPkModeInfo();
        if (r120 == null) goto L42;
        com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r121 = r120.getValue();
        if (r121 == null) goto L42;
        r114 = r121.f94553c;
    L42:
        if (Intrinsics.areEqual(r114, Boolean.FALSE) == false) goto L44;
        r103 = 8;
    L44:
        r118.setVisibility(r103);
        ((RoundedLabelTitle) S90(R.id.pk_play_mode_selector)).setOnTapPlayModeListener(new e(this));
        RxUtilKt.c(V90().getOnDismissEvent().subscribe(new f(this)), this.f93560i);
        V90().getPlayModeLiveData().observe(this, new g(this));
        V90().initPage();
        Y90(V90().getErrorCode().getValue());
        V90().getErrorCode().observe(this, new z(this));
        jy0.b.d("ttlive_anchor_link_multi_pk", "multiPKLaunchDialog show");
        p21.e r122 = this.f93565n;
        r122.getClass();
        i97.a r123 = i97.a.f488802a;
        r122.f527376a = Long.valueOf(System.currentTimeMillis());
        return;
    L31:
        if (r117.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L33;
        r116 = s1.B(R.string.ttlive_pk_history_season_rank);
        goto L34
    L26:
        if ((!StringsKt.isBlank(r116)) != true) goto L28;
    L23:
        r116 = null;
        goto L24
    L14:
        r109 = 124;
    L10:
        r107 = 0;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_multi_anchor_select_pk_new, r101);
    }
}
