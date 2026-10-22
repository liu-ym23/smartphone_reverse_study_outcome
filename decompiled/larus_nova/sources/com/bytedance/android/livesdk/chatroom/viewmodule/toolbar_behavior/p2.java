package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f117329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2 f117330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f117331c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.f551016p;
    }

    public p2(boolean r100) {
        this.f117331c = r100;
        this.f117330b = new q2(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IUserService r101 = (IUserService) jc1.k.f(IUserService.class);
        IUser r102 = null;
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.user.f r103 = r101.user();
        if (r103 == null) goto L7;
        IUser r104 = r103.b();
    L9:
        if ((r104 instanceof User) == false) goto L12;
        r102 = r104;
    L12:
        User r105 = (User) r102;
        if (r105 == null) goto L40;
        IInteractService r106 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r106 == null) goto L21;
        rj0.m r107 = r106.getVideoTalkService();
        if (r107 == null) goto L21;
        if (r107.C(this.f117331c, r105.getIdString()) != true) goto L21;
    L39:
        boolean r108 = true;
    L41:
        if (r108 == true) goto L43;
    L46:
        ClearScreenLogUtils.Companion r109 = ClearScreenLogUtils.f119492a;
        DataCenter r110 = this.f117329a;
        Map r111 = MapsKt.emptyMap();
        r109.getClass();
        ClearScreenLogUtils.Companion.d(r110, "more_panel", r111);
        ClearScreenHelper.m(true);
        com.bytedance.android.livesdk.chatroom.utils.p.f114578b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.f114577a = System.currentTimeMillis();
        return;
    L43:
        if (n60.f120808a.getValue().booleanValue() == false) goto L46;
        ALogger.w("guest_clear_screen", "try click clear screen button but refused. isClear:true");
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_guest_block_screen_clear_tips, 0);
        return;
    L21:
        IInteractService r112 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r112 == null) goto L27;
        qd0.a r113 = r112.getAudioTalkService();
        if (r113 == null) goto L27;
        if (r113.q(this.f117331c, r105.getIdString()) == true) goto L39;
    L27:
        IInteractService r114 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r114 == null) goto L33;
        qd0.b r115 = r114.getInteractAudienceService();
        if (r115 == null) goto L33;
        if (((com.bytedance.android.live.liveinteract.service.f) r115).S(this.f117331c, r105) == true) goto L39;
    L33:
        IInteractService r116 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r116 == null) goto L40;
        iy.g r117 = r116.getDynamicCenterService(this.f117329a);
        if (r117 == null) goto L40;
        if (r117.Rp() == true) goto L39;
    L40:
        r108 = false;
    L7:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        hd0.c.f().e(this.f117330b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if (wt2.a.e(Boolean.valueOf(this.f117331c)) == true) goto L5;
    L7:
        this.f117329a = r101;
        return;
    L5:
        if (n60.f120808a.getValue().booleanValue() == false) goto L7;
        hd0.c.f().c(this.f117330b);
        goto L7
    }
}
