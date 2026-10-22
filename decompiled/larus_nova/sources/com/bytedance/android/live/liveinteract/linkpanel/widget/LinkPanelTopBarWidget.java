package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.AudioTalkSettingFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.SettingLynxContainerFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.VideoTalkSettingFragment;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.search.dto.UserGroupScene;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/LinkPanelTopBarWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPanelTopBarWidget extends PlatformMultiLinkWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f75372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f75373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f75374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f75375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f75376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f75377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataContext f75378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewPager f75379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public yf0.g f75380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f75381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f75382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f75383l;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkPanelTopBarWidget f75384a;

        public a(LinkPanelTopBarWidget r100) {
            this.f75384a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            Integer r100 = (Integer) hd0.c.f().f481009b;
            if (r100 == null) goto L22;
            if (r100.intValue() != 0) goto L22;
            String r101 = this.f75384a.f75383l;
            int r102 = r101.hashCode();
            if (r102 == (-1383228885)) goto L15;
            if (r102 == 3526149) goto L12;
        L17:
            int r103 = bh0.a.f18994a;
        L18:
            gd0.m r104 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r104 == null) goto L94;
            ((LinkPanelTransitService) r104).b(r101, "top_bar_admin_click", -1);
            return;
        L94:
            return;
        L12:
            if (r101.equals("seat") == false) goto L17;
            int r105 = bh0.a.f18994a;
            goto L18
        L15:
            if (r101.equals("bottom") == false) goto L17;
            int r106 = bh0.a.f18994a;
        L22:
            if (r100 != null) goto L25;
        L27:
            if (r100 != null) goto L30;
            return;
        L30:
            if (r100.intValue() != 2) goto L97;
            gd0.m r107 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r107 == null) goto L98;
            LinkPanelTopBarWidget r108 = this.f75384a;
            Context r109 = r108.f75376e;
            String r110 = r108.f75383l;
            LinkPanelTransitService r111 = (LinkPanelTransitService) r107;
            Intrinsics.checkNotNullParameter(r110, "requestPage");
            if (r109 == null) goto L109;
            Boolean r112 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
            if (r112 == null) goto L39;
            boolean r113 = r112.booleanValue();
        L40:
            int r114 = 200;
            if (s0.c(r113) == false) goto L76;
            ILinkPanelService r115 = com.bytedance.android.live.liveinteract.component.b.a();
            if (r115 == null) goto L45;
            r115.close();
        L45:
            int r116 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            if (r116 != 9) goto L54;
            LiveDialogFragment r117 = ((IKtvService) jc1.k.n(IKtvService.class)).getKtvFeedbackDialog(r110, new com.bytedance.android.live.liveinteract.service.i(r111), false);
            if (r117 == null) goto L99;
            FragmentManager r118 = ((FragmentActivity) r109).getSupportFragmentManager();
            LandscapeRestrictionOperation r119 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r117, "KtvFeedbackDialog", r119);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r118, r117, r119) == true) goto L110;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L91
        L53:
            r117.show(r118, "KtvFeedbackDialog");
            return;
        L110:
            return;
        L99:
            return;
        L54:
            if (r113 == false) goto L56;
            int r120 = TalkRoomFeedbackDialog.f71958r;
            LinkPanelTransitService.a(TalkRoomFeedbackDialog.a.a(r116, r113, r110, null, false, null, null, null, 1016), ((FragmentActivity) r109).getSupportFragmentManager());
            return;
        L56:
            int r121 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
            int r122 = r110.hashCode();
            if (r122 == (-1383228885)) goto L64;
            if (r122 != 3526149) goto L67;
            if (r110.equals("seat") == false) goto L67;
            r114 = 201;
        L67:
            if (gd0.v.a(r121, 32) == false) goto L72;
            rj0.l.f537955n2.getClass();
            rj0.l r123 = rj0.l.a.a();
            if (r123 == null) goto L102;
            rj0.l.b.d(r123, r114, true, false, 12);
            return;
        L102:
            return;
        L72:
            if (gd0.v.a(r121, 8) == false) goto L104;
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r124 = IVoiceChatGuestService.a.a();
            if (r124 == null) goto L105;
            IVoiceChatGuestService.b.b(r124, r114, true, true, false, 24);
            return;
        L105:
            return;
        L104:
            return;
        L64:
            if (r110.equals("bottom") == false) goto L67;
            r114 = 202;
            goto L67
        L76:
            int r125 = r110.hashCode();
            if (r125 == (-1383228885)) goto L84;
            if (r125 == 3526149) goto L81;
        L86:
            int r126 = 200;
        L87:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r127 = IVoiceChatGuestService.a.a();
            if (r127 == null) goto L107;
            IVoiceChatGuestService.b.b(r127, r126, true, true, false, 24);
            return;
        L107:
            return;
        L81:
            if (r110.equals("seat") == false) goto L86;
            r126 = 201;
            goto L87
        L84:
            if (r110.equals("bottom") == false) goto L86;
            r126 = 202;
            goto L87
        L39:
            r113 = false;
            goto L40
        L109:
            return;
        L98:
            return;
        L97:
            return;
        L25:
            if (r100.intValue() != 1) goto L27;
            LinkPanelTopBarWidget r128 = this.f75384a;
            r128.getClass();
            Context r129 = r128.f75376e;
            Intrinsics.checkNotNull(r129);
            j0.a r130 = new j0.a(r129);
            r130.f161764a = s1.B(R.string.ttlive_live_radio_interact_cancel_apply_confirm);
            r130.a(s1.B(R.string.ttlive_confirm), c0.f75390a);
            r130.b(s1.B(R.string.ttlive_cancel), d0.f75392a);
            r130.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void xq() {
        ViewGroup r100 = this.f75373b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L5:
        ((TextView) r100.findViewById(R.id.admin_operation)).setVisibility(0);
        ViewGroup r101 = this.f75373b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L8:
        ((TextView) r101.findViewById(R.id.not_anchor_update_position)).setVisibility(8);
        if (jc0.a.a() == false) goto L16;
        ViewGroup r102 = this.f75373b;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L13:
        ((TextView) r102.findViewById(R.id.admin_operation)).setVisibility(8);
        return;
    L16:
        if (this.f75372a == true) goto L18;
        ViewGroup r103 = this.f75373b;
        if (r103 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L50:
        ((TextView) r103.findViewById(R.id.admin_operation)).setCompoundDrawables(null, null, null, null);
        ViewGroup r104 = this.f75373b;
        if (r104 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L53:
        ((TextView) r104.findViewById(R.id.admin_operation)).setTextColor(ColorProtector.parseColor("#80000000"));
        ViewGroup r105 = this.f75373b;
        if (r105 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L56:
        ((TextView) r105.findViewById(R.id.admin_operation)).setTextSize(14.0f);
        Integer r106 = (Integer) hd0.c.f().f481009b;
        if (r106 != null) goto L60;
    L65:
        if (r106 != null) goto L68;
    L73:
        if (r106 != null) goto L76;
    L81:
        ViewGroup r107 = this.f75373b;
        if (r107 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L84:
        ((TextView) r107.findViewById(R.id.admin_operation)).setOnClickListener(new a(this));
        hd0.c.f().c(this.f75375d);
        return;
    L76:
        if (r106.intValue() != 2) goto L81;
        ViewGroup r108 = this.f75373b;
        if (r108 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L80:
        ((TextView) r108.findViewById(R.id.admin_operation)).setText(R.string.ttlive_live_interact_disconnect);
        goto L81
    L68:
        if (r106.intValue() != 1) goto L73;
        ViewGroup r109 = this.f75373b;
        if (r109 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L72:
        ((TextView) r109.findViewById(R.id.admin_operation)).setText(R.string.ttlive_interact_audience_cancel_apply);
        goto L81
    L60:
        if (r106.intValue() != 0) goto L65;
        ViewGroup r110 = this.f75373b;
        if (r110 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L64:
        ((TextView) r110.findViewById(R.id.admin_operation)).setText(R.string.ttlive_video_talk_room_audio_apply);
        goto L81
    L18:
        if (((IKtvService) jc1.k.n(IKtvService.class)).isCurrentUserIsSinger() == false) goto L26;
        Drawable r111 = s1.m(R.drawable.ttlive_icon_ktv_tune);
        ViewGroup r112 = this.f75373b;
        if (r112 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L22:
        ((TextView) r112.findViewById(R.id.admin_operation)).setCompoundDrawablesWithIntrinsicBounds(r111, null, null, null);
        ViewGroup r113 = this.f75373b;
        if (r113 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L25:
        ((TextView) r113.findViewById(R.id.admin_operation)).setText(R.string.ttlive_live_ktv_tune_title);
    L33:
        ViewGroup r114 = this.f75373b;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L36:
        ((TextView) r114.findViewById(R.id.admin_operation)).setCompoundDrawablePadding(s1.f(2.0f));
        ViewGroup r115 = this.f75373b;
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L39:
        ((TextView) r115.findViewById(R.id.admin_operation)).setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        ViewGroup r116 = this.f75373b;
        if (r116 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L42:
        ((TextView) r116.findViewById(R.id.admin_operation)).setTextSize(15.0f);
        ViewGroup r117 = this.f75373b;
        if (r117 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L45:
        ((TextView) r117.findViewById(R.id.admin_operation)).setOnClickListener(x0.a(new LinkPanelTopBarWidget$initAdminOperationButtonView$1(this)));
        return;
    L26:
        Drawable r118 = s1.m(R.drawable.ttlive_icon_ktv_sing);
        ViewGroup r119 = this.f75373b;
        if (r119 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L29:
        ((TextView) r119.findViewById(R.id.admin_operation)).setCompoundDrawablesWithIntrinsicBounds(r118, null, null, null);
        ViewGroup r120 = this.f75373b;
        if (r120 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L32:
        ((TextView) r120.findViewById(R.id.admin_operation)).setText(R.string.ttlive_live_ktv_sing_title);
        goto L33
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        this.f75374c.dispose();
    }

    public static final void wq(LinkPanelTopBarWidget r100) {
        r100.getClass();
        Room r101 = com.bytedance.android.live.liveinteract.api.utils.m.j(r100).getCurrentRoom();
        if (r101 == null) goto L43;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = b6.f65230e;
        Boolean r103 = Boolean.FALSE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        ViewGroup r104 = r100.f75373b;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L7:
        r104.findViewById(R.id.setting_guide_dot).setVisibility(8);
        boolean r105 = com.bytedance.android.live.liveinteract.linkpanel.util.o.I();
        LinkedHashMap r106 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.z(r106);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r106);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r106, null, 6);
        if (r105 == false) goto L10;
        String r107 = UserGroupScene.DEFAULT_NAME_SPACE;
    L11:
        r106.put("user_type", r107);
        if (r105 == false) goto L14;
        String r108 = "0";
    L15:
        r106.put(IPerformanceManager.Params.is_anchor, r108);
        am2.x r109 = new am2.x();
        if (r105 == false) goto L18;
        String r110 = "live_take_detail";
    L19:
        r109.f4350b = r110;
        r109.f4349a = "live";
        r109.f4353e = "click";
        boolean r111 = true;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_link_setting_click", r106, new Object[]{r109, IRoom.class, am2.x.class});
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L35;
        if (hg6.i.d() == false) goto L26;
        yf0.g r112 = r100.f75380i;
        if (r112 == null) goto L44;
        SettingLynxContainerFragment.a r113 = SettingLynxContainerFragment.f74595r;
        Intrinsics.checkNotNull(r112);
        DataCenter r114 = r100.f75377f;
        DataContext r115 = r100.f75378g;
        int r116 = r100.f75381j;
        r113.getClass();
        r112.Rh(SettingLynxContainerFragment.a.a(r112, r114, r101, r115, null, r116, true));
        return;
    L44:
        return;
    L26:
        yf0.g r117 = r100.f75380i;
        if (r117 == null) goto L46;
        int r118 = VideoTalkSettingFragment.f74636z;
        Intrinsics.checkNotNull(r117);
        boolean r119 = r100.f75382k;
        DataCenter r120 = r100.f75377f;
        if (r120 == null) goto L33;
        Boolean r121 = (Boolean) r120.get("data_is_portrait", Boolean.TRUE);
        if (r121 == null) goto L33;
        r111 = r121.booleanValue();
    L33:
        r117.Rh(VideoTalkSettingFragment.a.a(r117, r101, r119, r111, r100.f75381j, r100.f75377f, false, true));
        return;
    L46:
        return;
    L35:
        if (hg6.i.d() == false) goto L39;
        yf0.g r122 = r100.f75380i;
        if (r122 == null) goto L48;
        SettingLynxContainerFragment.a r123 = SettingLynxContainerFragment.f74595r;
        Intrinsics.checkNotNull(r122);
        DataCenter r124 = r100.f75377f;
        DataContext r125 = r100.f75378g;
        r123.getClass();
        r122.Rh(SettingLynxContainerFragment.a.a(r122, r124, r101, r125, null, -1, true));
        return;
    L48:
        return;
    L39:
        yf0.g r126 = r100.f75380i;
        if (r126 == null) goto L50;
        int r127 = AudioTalkSettingFragment.f74464w;
        Intrinsics.checkNotNull(r126);
        r126.Rh(AudioTalkSettingFragment.a.a(r126, r101, r100.f75378g, r100.f75377f, "link_setting_click"));
        return;
    L50:
        return;
    L18:
        r110 = "live_detail";
        goto L19
    L14:
        r108 = "1";
        goto L15
    L10:
        r107 = "anchor";
        goto L11
    }

    public LinkPanelTopBarWidget(Context r100, DataCenter r101, DataContext r102, LinkNoScrollViewPager r103, yf0.g r104, int r105, boolean r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r103, "viewPager");
        Intrinsics.checkNotNullParameter(r107, "requestPage");
        this.f75376e = r100;
        this.f75377f = r101;
        this.f75378g = r102;
        this.f75379h = r103;
        this.f75380i = r104;
        this.f75381j = r105;
        this.f75382k = r106;
        this.f75383l = r107;
        this.f75374c = new CompositeDisposable();
        this.f75375d = new y(this);
    }
}
