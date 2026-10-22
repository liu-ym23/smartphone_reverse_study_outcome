package com.bytedance.android.live.revlink.impl.multianchor.scope;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.RevLinkDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorLinkInviteFragment;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.o6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f94633d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RevLinkDialog f94634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f94635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f94636c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final void c() {
        com.bytedance.android.live.revlink.impl.service.internal.a r100 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r100 == null) goto L5;
        r100.m();
    L5:
        RevLinkDialog r101 = this.f94634a;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isShowing() != true) goto L21;
        RevLinkDialog r102 = this.f94634a;
        if (r102 == null) goto L22;
        r102.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L23;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        c();
        this.f94634a = null;
    }

    public final void d(i6 r110) {
        Intrinsics.checkNotNullParameter(r110, "linkerMessage");
        c();
        com.bytedance.android.livesdk.revenue.service.room.c r100 = (com.bytedance.android.livesdk.revenue.service.room.c) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        if (r100 == null) goto L5;
        DataCenter r101 = r100.getDataCenter();
    L6:
        LifecycleOwner r102 = this.f94636c;
        int r103 = RevLinkDialog.f92317x;
        RevLinkDialog r104 = new RevLinkDialog.a(r101, r102).a();
        this.f94634a = r104;
        int r105 = AnchorLinkInviteFragment.W;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNullParameter(r104, "view");
        Intrinsics.checkNotNullParameter(r110, "linkerMessage");
        AnchorLinkInviteFragment r106 = new AnchorLinkInviteFragment();
        r106.f92316f = new m21.d(r106);
        r106.f92314d = r104;
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L17;
        LinkCrossRoomDataHolder r107 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r107 != null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r110, "$this$getAppliedUserOrNull");
        e6 r108 = r110.getInvite();
        if (r108 == null) goto L15;
        p r109 = r108.getAppliedUser();
    L16:
        r106.f93369w = r106.ga0(r109);
    L18:
        Intrinsics.checkNotNullParameter(r110, "$this$getAppliedUserOrNull");
        e6 r111 = r110.getInvite();
        if (r111 == null) goto L21;
        p r112 = r111.getAppliedUser();
    L22:
        r106.f93352J = r112;
        if (((int) r110.getType2()) != 3) goto L26;
        r106.f93362p = 1;
    L31:
        r106.D = r110;
        e6 r113 = r110.getInvite();
        if (r113 == null) goto L34;
        String r114 = r113.getClientAttachedInfoStr();
    L35:
        r106.F = r114;
        e6 r115 = r110.getInvite();
        if (r115 == null) goto L39;
        String r116 = r115.getBattleAttachedInfoStr();
        if (r116 == null) goto L39;
    L43:
        r106.G = r116;
        r106.f93368v = r104.getCurrentRoom().getId();
        r106.f93367u = r110.getLinkerId();
        IBattleLinkerInviteMessageExtra r117 = j6.a(r110);
        if (r117 == null) goto L46;
        r106.f93370x = (int) r117.getInviteType();
        r106.f93371y = (int) r117.getMatchType();
        r106.M = r117.getBattleConfigSetting();
    L46:
        e6 r118 = r110.getInvite();
        if (r118 == null) goto L50;
        e6 r119 = r118;
        Intrinsics.checkNotNullParameter(r119, "$this$fromUid");
        r106.f93364r = r119.get_fromUid();
        Intrinsics.checkNotNullParameter(r119, "$this$secFromUid");
        r106.f93365s = r119.get_secFromUid();
        r106.f93372z = r118.getInviteSource();
    L52:
        if (r118 == null) goto L70;
        if (com.bytedance.android.live.revenuelink.connect.b.a(r110) == false) goto L70;
        r106.H = x.g(f6.a(r118));
        List<p> r120 = f6.b(r118);
        if (r120 == null) goto L70;
        Iterator<p> r121 = r120.iterator();
    L59:
        if (r121.hasNext() == false) goto L70;
        p r122 = r121.next();
        if (r122.getUser() == null) goto L59;
        IBaseUser r123 = r122.getUser();
        if (r123 == null) goto L65;
        String r124 = r123.getIdString();
    L66:
        e6 r125 = r118;
        Intrinsics.checkNotNullParameter(r125, "$this$fromUid");
        if (TextUtils.equals(r124, r125.get_fromUid()) == false) goto L59;
        r106.f93363q = r122;
        goto L70
    L65:
        r124 = null;
    L70:
        if (r110.getInvite() == null) goto L86;
        e6 r126 = r110.getInvite();
        Intrinsics.checkNotNull(r126);
        if (r126.getInviteUser() == null) goto L86;
        e6 r127 = r110.getInvite();
        Intrinsics.checkNotNull(r127);
        p r128 = r127.getInviteUser();
        Intrinsics.checkNotNull(r128);
        if (r128.getUser() == null) goto L86;
        e6 r129 = r110.getInvite();
        if (r129 == null) goto L83;
        p r130 = r129.getInviteUser();
        if (r130 == null) goto L83;
        IBaseUser r131 = r130.getUser();
        if (r131 == null) goto L83;
        String r132 = r131.getNickName();
        if (r132 == null) goto L83;
    L84:
        r106.O = r132;
    L83:
        r132 = "";
    L86:
        if (r106.f93362p == 2) goto L96;
        i6 r133 = r106.D;
        if (r133 == null) goto L96;
        if (j6.a(r133) == null) goto L96;
        IBattleLinkerInviteMessageExtra r134 = j6.a(r106.D);
        Intrinsics.checkNotNull(r134);
        if (r134.getInviteStatus() == null) goto L94;
        IBattleLinkerInviteMessageExtra r135 = j6.a(r106.D);
        Intrinsics.checkNotNull(r135);
        Integer r136 = r135.getInviteStatus();
    L95:
        r106.R = r136;
        goto L96
    L94:
        r136 = Integer.valueOf(IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusUnknown.ordinal());
    L96:
        RevLinkDialog r137 = this.f94634a;
        if (r137 == null) goto L99;
        r137.f92319f = r106;
    L99:
        FragmentActivity r138 = ContextUtil.contextToFragmentActivity(this.f94635b);
        if (r138 == null) goto L113;
        FragmentManager r139 = r138.getSupportFragmentManager();
        if (r139 == null) goto L114;
        RevLinkDialog r140 = this.f94634a;
        if (r140 == null) goto L115;
        a(r140, r139);
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L50:
        if (r110.getSwitchChannelInviteContent() == null) goto L52;
        o6 r141 = r110.getSwitchChannelInviteContent();
        Intrinsics.checkNotNull(r141);
        e6 r142 = r141.getInviteContent();
        e6 r143 = r142;
        Intrinsics.checkNotNullParameter(r143, "$this$fromUid");
        r106.f93364r = r143.get_fromUid();
        Intrinsics.checkNotNullParameter(r143, "$this$secFromUid");
        r106.f93365s = r143.get_secFromUid();
        r106.f93372z = r142.getInviteSource();
        r106.E = r142;
        r106.f93363q = r142.getInviteUser();
        r106.N = false;
    L39:
        k6 r144 = r110.getReply();
        if (r144 == null) goto L42;
        r116 = r144.getBattleAttachedInfoStr();
        goto L43
    L42:
        r116 = null;
        goto L43
    L34:
        r114 = null;
        goto L35
    L26:
        if (((int) r110.getType2()) != 4) goto L29;
        r106.f93362p = 2;
        goto L31
    L29:
        if (((int) r110.getType2()) != 60) goto L31;
        r106.f93362p = 3;
        goto L31
    L21:
        r112 = null;
        goto L22
    L15:
        r109 = null;
        goto L16
    L11:
        if (r107.c() != 0) goto L12;
    L17:
        r106.f93369w = s1.B(R.string.ttlive_anchor_link_invite_you_to_join_link);
        goto L18
    L5:
        r101 = null;
        goto L6
    }

    public c(Context r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifeCycle");
        this.f94635b = r100;
        this.f94636c = r101;
    }

    public static void a(RevLinkDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "LinkDialog", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "LinkDialog");
    }
}
