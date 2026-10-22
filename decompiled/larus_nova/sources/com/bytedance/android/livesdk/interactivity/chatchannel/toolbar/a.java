package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import n62.i;
import pp1.g;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f134384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f134385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f134386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f134387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f134388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f134389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoomContext f134390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s22.e f134391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f134392i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.a$a, reason: collision with other inner class name */
    public static final class C2120a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f134393a;

        public b(a r100) {
            this.f134393a = r100;
        }

        public final void a() {
            final a r100 = this.f134393a;
            r100.getClass();
            RoomContext.a r101 = RoomContext.Companion;
            DataCenter r102 = r100.f134386c;
            r101.getClass();
            RoomContext r103 = RoomContext.a.a(r102, 0);
            if (r103 == null) goto L17;
            View r104 = r100.f134384a;
            if (r104 == null) goto L17;
            Context r105 = r104.getContext();
            if (r105 == null) goto L17;
            View r106 = r100.f134384a;
            if (r106 == null) goto L17;
            a0<pp1.c> r107 = r103.getToolbarBubbleManager().getValue();
            if (r107 == null) goto L17;
            int r108 = pp1.c.f530166o;
            pp1.c r109 = pp1.c.a.a("邀请朋友边看边聊");
            r107.addBubble(r109, r109.f530177k, new q2(r100.f134386c, r105, r106), new ChatChannelToolbarBehavior$showGuideBubble$1(r100));
            boolean r110 = true;
        L18:
            if (r110 == false) goto L21;
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r111 = com.bytedance.android.livesdk.sharedpref.b.f158151g3;
            Boolean r112 = Boolean.TRUE;
            r111.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r111, r112);
            return;
        L21:
            return;
        L17:
            r110 = false;
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
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
        return up2.a.f551009i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(s r100) {
        if (u40.a.a() == false) goto L26;
        if (r100 == null) goto L27;
        k r101 = r100.f116193c;
        if (y3.m(this.f134389f).n(ToolbarButton.ROOM_CHANNEL) == false) goto L30;
        SkinLoader.f114373c.getClass();
        if (SkinLoader.a.b() == true) goto L11;
    L20:
        if (r101 == null) goto L31;
        Disposable r102 = a1.l(r101, s1.f(38.0f), s1.f(38.0f), false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.f134396a);
        if (r102 == null) goto L29;
        RxUtilKt.c(r102, this.f134385b);
        return;
    L29:
        return;
    L31:
        return;
    L11:
        if (this.f134392i == true) goto L20;
        SkinLoader r103 = SkinLoader.a.e(r100);
        View r104 = this.f134384a;
        if (r104 == null) goto L15;
        View r105 = r104.findViewById(R.id.icon);
    L16:
        if (r105 == null) goto L20;
        ResKeyEnum r106 = ResKeyEnum.STATIC_ICON;
        if (r103.b(y2.b(r106)) == null) goto L20;
        r103.c(y2.a(r106, Integer.valueOf(R.drawable.ttlive_ic_room_channel_unfold)), r105, new com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.b(this));
        return;
    L15:
        r105 = null;
        goto L16
    L30:
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if (u40.a.a() == true) goto L6;
        return;
    L6:
        if (this.f134392i == false) goto L9;
        return;
    L9:
        if ((r100 instanceof g) == false) goto L21;
        StringBuilder r101 = new StringBuilder("move to more = ");
        g r102 = (g) r100;
        r101.append(r102.f530187a);
        ALogger.e("ToolbarRoomChannelBehavior", r101.toString());
        DataCenter r103 = this.f134386c;
        if (r103 == null) goto L14;
        r103.put("data_room_channel_move_to_more", Boolean.valueOf(r102.f530187a));
    L14:
        if (r102.f530187a == true) goto L16;
        y3.f(this.f134389f).d(ToolbarButton.ROOM_CHANNEL, this.f134387d);
        return;
    L16:
        if (this.f134387d != null) goto L18;
        this.f134387d = new a(this.f134389f, this.f134390g, this.f134391h, true);
    L18:
        y3.f(this.f134389f).k(ToolbarButton.ROOM_CHANNEL, this.f134387d);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (((IUserService) jc1.k.n(IUserService.class)).user().isLogin() == true) goto L10;
        com.bytedance.android.livesdk.user.f r100 = f72.b.a().user();
        if (r110 == null) goto L7;
        Context r111 = r110.getContext();
    L8:
        r100.login(r111, new l(new l.a())).subscribe(new h());
        return;
    L7:
        r111 = null;
        goto L8
    L10:
        if (r110 == null) goto L33;
        Context r101 = r110.getContext();
        if (r101 == null) goto L36;
        s22.a r102 = (s22.a) sh6.c.b(this.f134391h.getCurrentChannel().getValue());
        if (r102 == null) goto L25;
        DataCenter r103 = this.f134386c;
        if (r103 == null) goto L37;
        ChannelMemberManagerDialog r112 = new ChannelMemberManagerDialog(r101, r103, this.f134390g.getRoom().getValue().f162599id, r102, this.f134391h);
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r112);
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L23:
        DialogLancet.beforeDialogShow(r112);
        r112.show();
        DialogLancet.afterDialogShow(r112);
        return;
    L37:
        return;
    L25:
        if (this.f134392i == false) goto L27;
        String r113 = "more";
    L28:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r104 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e(r113);
        n62.h.a(r101, this.f134390g, this.f134389f, this.f134391h, new i(true, 200, true, r104)).c(this.f134385b);
        j.c(r104);
        return;
    L27:
        r113 = NewBroadcastMonitor.STAGE.TOOLBAR;
        goto L28
    L36:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f134388e = false;
        this.f134385b.clear();
        this.f134384a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f134384a = r100;
        this.f134386c = r101;
        ImageView r102 = (ImageView) r100.findViewById(R.id.red_dot);
        if (r102 == null) goto L6;
        r102.getVisibility();
    L6:
        if (this.f134388e == true) goto L13;
        this.f134388e = true;
        int r103 = j.f133002a;
        if (this.f134392i == false) goto L10;
        String r104 = "more";
    L11:
        j.d(false, r104);
        goto L13
    L10:
        r104 = NewBroadcastMonitor.STAGE.TOOLBAR;
    L13:
        if (this.f134392i == false) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.sharedpref.b.f158151g3.getValue(), Boolean.FALSE) == false) goto L19;
        MainThreadPostUtils.c(new b(this), 500);
        return;
    }

    public a(DataCenter r100, RoomContext r101, s22.e r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "chatChannelManager");
        this.f134389f = r100;
        this.f134390g = r101;
        this.f134391h = r102;
        this.f134392i = r103;
        this.f134385b = new CompositeDisposable();
    }
}
