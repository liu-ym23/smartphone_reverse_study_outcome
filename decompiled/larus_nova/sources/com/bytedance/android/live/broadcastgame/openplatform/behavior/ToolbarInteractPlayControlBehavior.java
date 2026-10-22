package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.xplay.f1;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.message.model.m;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.k;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import p11.j;
import vlc.l;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/behavior/ToolbarInteractPlayControlBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarInteractPlayControlBehavior implements c0.b, Observer<KVData>, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f61337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f61338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjectAnimator f61339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f61340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f61341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f61342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public vlc.d f61343g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public ToolbarInteractPlayControlBehavior() {
        this.f61338b = true;
        this.f61340d = new CompositeDisposable();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101.getKey(), "cmd_notify_live_game_play_toolbar_show_bubble") == false) goto L13;
        View r102 = this.f61337a;
        if (r102 != null) goto L10;
        return;
    L10:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L15;
        this.f61340d.add(((SingleSubscribeProxy) Single.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) r102.getContext()))).subscribe(new e(r102)));
        return;
    L15:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f61338b == true) goto L5;
        return;
    L5:
        String r101 = "";
        if (this.f61341e == true) goto L8;
    L39:
        XplayExternalContext r102 = XplayExternalContext.Companion.getContext();
        if (r102 == null) goto L50;
        k<String> r103 = r102.getOpenGameMoreDialog();
        if (r103 == null) goto L51;
        r103.post("");
        return;
    L51:
        return;
    L50:
        return;
    L8:
        if (r2.a(this.f61342f) == false) goto L39;
        String r104 = this.f61342f;
        if (r104 != null) goto L13;
        return;
    L13:
        if (this.f61341e == false) goto L19;
        HashMap<String, String> r105 = new HashMap();
        r105.put("user_type", "anchor");
        ILinkServiceExternal r106 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r106 == null) goto L19;
        lc0.a r107 = r106.getControlService();
        if (r107 == null) goto L19;
        r107.d("livesdk_cohost_game_operate_icon_click", r105);
    L19:
        u6 r108 = new u6(r104);
        u6 r109 = r108.d("url");
        boolean r110 = h.f91037a;
        j r111 = ((ILinkService) h.d(ILinkService.class)).getRevenueLinkDataHolder();
        if (r111 == null) goto L22;
        Long r112 = Long.valueOf(r111.getChannelId());
    L23:
        String r113 = String.valueOf(r112.longValue());
        if (r113 == null) goto L27;
        r101 = r113;
    L27:
        r109.b("channel_id", r101);
        Uri r114 = r108.c();
        View r115 = this.f61337a;
        if (r115 == null) goto L47;
        Context r116 = r115.getContext();
        if (r116 == null) goto L48;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L33
        Object r118 = Result.m9449constructorimpl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(r116, r114, new c()));     // Catch: Throwable -> L33
    L35:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L38;
        int r120 = q.f60744a;
        q.e("ToolbarInteractPlayControlBehavior", new Object[]{"rev link lynx start failed, cause: " + r119.getCause() + ", message: " + r119.getMessage()});
    L38:
        Result.m9448boximpl(r118);
        return;
    L33:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L48:
        return;
    L47:
        return;
    L22:
        r112 = null;
        goto L23
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof m) == false) goto L23;
        m r101 = (m) r100;
        if (r101.getIntType() != MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType()) goto L24;
        View r102 = this.f61337a;
        if (r102 == null) goto L25;
        ItemBubbleInfo r103 = r101.E();
        if (r103 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r103.getShowItemId(), String.valueOf(6)) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L27;
        IBroadcastService r104 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r104 == null) goto L28;
        nz.h r105 = r104.getBroadcastBubbleManager();
        if (r105 == null) goto L29;
        CompositeDisposable r106 = r105.a(r102.getContext(), r102, r103, BubblePosition.Top);
        if (r106 == null) goto L30;
        RxUtilKt.c(r106, this.f61340d);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        vlc.d r102 = this.f61343g;
        if (r102 == null) goto L5;
        r102.removeMessageListener(this);
    L5:
        this.f61338b = true;
        this.f61337a = null;
        this.f61340d.dispose();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f61337a = r100;
        HSImageView r102 = (HSImageView) r100.findViewById(R.id.icon);
        if (this.f61341e == false) goto L5;
        Integer r103 = Integer.valueOf(R.drawable.ttlive_ic_rev_interact_play_toolbar);
        int r104 = f1.f62074a;
        Pair r105 = TuplesKt.to(r103, f1.b(XplayScene.RevenueLink, true, false));
    L6:
        int r106 = ((Number) r105.component1()).intValue();
        String r107 = (String) r105.component2();
        if (r107 != null) goto L9;
    L14:
        if (r102 == null) goto L17;
        r102.setActualImageResource(r106);
    L17:
        if (this.f61341e == false) goto L23;
        HashMap<String, String> r108 = new HashMap();
        r108.put("user_type", "anchor");
        ILinkServiceExternal r109 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r109 == null) goto L23;
        lc0.a r110 = r109.getControlService();
        if (r110 == null) goto L23;
        r110.d("livesdk_cohost_game_operate_icon_show", r108);
    L23:
        vlc.d r111 = (vlc.d) r101.get("data_message_manager", null);
        this.f61343g = r111;
        if (r111 == null) goto L26;
        r111.addMessageListener(MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType(), this);
    L26:
        r101.observe("cmd_notify_live_game_play_toolbar_show_bubble", this);
        return;
    L9:
        if (r2.a(r107) == true) goto L12;
        r107 = null;
    L12:
        if (r107 == null) goto L14;
        a1.n(r102, r107);
        goto L17
    L5:
        Integer r112 = Integer.valueOf(R.drawable.ttlive_ic_interact_play_toolbar);
        int r113 = f1.f62074a;
        r105 = TuplesKt.to(r112, f1.b(XplayScene.Video, true, false));
        goto L6
    }
}
