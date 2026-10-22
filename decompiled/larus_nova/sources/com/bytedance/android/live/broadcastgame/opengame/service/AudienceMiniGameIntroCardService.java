package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.opengame.GameIntroCard;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.IntroduceCardWidget;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/AudienceMiniGameIntroCardService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniGameIntroCardService implements y10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e f60904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> f60905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f60906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f60907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.openplatform.a f60908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PluginContext f60909f;

    @Override // y10.a
    public final void g() {
    }

    public AudienceMiniGameIntroCardService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        this.f60909f = r100;
        this.f60904a = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e();
        this.f60906c = new CompositeDisposable();
    }

    public final void b(com.bytedance.android.live.broadcastgame.api.openplatform.a r110) {
        Intrinsics.checkNotNullParameter(r110, "gameIntroCardInfo");
        if (r110.f59402k <= 1) goto L5;
        return;
    L5:
        DataCenter r100 = this.f60909f.f60805i;
        if (r100 == null) goto L8;
        Boolean r101 = (Boolean) r100.get("cmd_commerce_ad_show", Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L12;
        return;
    L12:
        long r102 = 0;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, this.f60909f.f60805i, 0, 2);
        if (r103 == null) goto L17;
        j<a0<pp1.c>> r104 = r103.getToolbarBubbleManager();
        if (r104 == null) goto L17;
        r104.c(new AudienceMiniGameIntroCardService$showCard$1(this));
    L17:
        IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r105 = new IntroduceCardWidget(this.f60909f.getContext(), this.f60909f.f60809m.f61075a);
        if (r105.f61744c != null) goto L20;
        int r106 = com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.b.f61750a;
        Context r107 = r105.f61746e;
        Intrinsics.checkNotNullParameter(r107, "ctx");
        r105.f61744c = new GameIntroCard(r107, null, 6, 0);
    L20:
        GameIntroCard r108 = r105.f61744c;
        if (r108 == null) goto L23;
        r108.setData(r110);
    L23:
        r105.t(new a(this));
        r105.q(new b(this, r110));
        this.f60905b = r105;
        Long r109 = r110.f59401j;
        if (r109 == null) goto L26;
        long r111 = r109.longValue();
    L27:
        long r112 = r111;
        IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r113 = this.f60905b;
        if (r113 != null) goto L31;
        return;
    L31:
        if (r110.f59403l == false) goto L33;
        r102 = 3000;
    L33:
        long r114 = r102;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e r115 = this.f60904a;
        int r116 = com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e.f61754d;
        monitor-enter(r115);
    L41:
        th = move-exception;
        throw th;
    L36:
        if ((SystemClock.uptimeMillis() - r115.f61757c) < 10000) goto L38;
        v.a();     // Catch: Throwable -> L41
        r115.f61755a.clear();     // Catch: Throwable -> L41
    L38:
        monitor-exit(r115);
        this.f60904a.a("load", new AudienceMiniGameIntroCardService$showCard$2(this, r113, r114, r110, r112));
        return;
    L26:
        r111 = 10;
        goto L27
    L8:
        r101 = null;
        goto L10
    }

    public static void a(final AudienceMiniGameIntroCardService r100, final boolean r101, final boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        final IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r104 = r100.f60905b;
        if (r104 == null) goto L20;
        r100.f60906c.clear();
        if (r104.f61743b == false) goto L18;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e r105 = r100.f60904a;
        r105.a("隐藏卡片动画", new AudienceMiniGameIntroCardService$hideCard$1(r100, r104, r102));
        r105.a("dismiss widget", new AudienceMiniGameIntroCardService$hideCard$2(r100, r104, r101));
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, r100.f60909f.f60805i, 0, 2);
        if (r106 == null) goto L18;
        j<a0<pp1.c>> r107 = r106.getToolbarBubbleManager();
        if (r107 == null) goto L18;
        r107.c(new AudienceMiniGameIntroCardService$hideCard$3(r100));
    L18:
        r100.f60904a.a("unload widget", new AudienceMiniGameIntroCardService$hideCard$4(r104));
        return;
    }
}
