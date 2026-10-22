package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.w;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceMonitorContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.MiniAppHotAtmosphereView;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfSupplementInfoContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.MiniAppExplainCard;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/AudienceExplainCardContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceExplainCardContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f84816h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f84817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f84818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> f84819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f84820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f84821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f84822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudienceExplainCardContextService$tryShowExplainCard$1 f84823g;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceExplainCardContextService f84824a;

        public b(AudienceExplainCardContextService r100) {
            this.f84824a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AudienceExplainCardContextService r100 = this.f84824a;     // Catch: Throwable -> L4
            int r101 = AudienceExplainCardContextService.f84816h;     // Catch: Throwable -> L4
            r100.f(false);     // Catch: Throwable -> L4
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

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r100 = this.f84819c;
        if (r100 == null) goto L5;
        r100.f84843g.d();
    L5:
        this.f84821e.removeCallbacksAndMessages(null);
        DataCenter r101 = getOpenPlatformContext().getDataCenter();
        if (r101 == null) goto L9;
        r101.removeObserver(this.f84823g);
        return;
    }

    public AudienceExplainCardContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f84820d = new w();
        this.f84821e = new Handler(Looper.getMainLooper());
        this.f84822f = new b(this);
    }

    public final void f(boolean r100) {
        if (m71.e.c(10) == false) goto L6;
        return;
    L6:
        if (this.f84818b == true) goto L8;
        return;
    L8:
        this.f84818b = false;
        this.f84821e.removeCallbacks(this.f84822f);
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r101 = this.f84819c;
        if (r101 != null) goto L11;
        return;
    L11:
        this.f84820d.a("register hide tasks", new AudienceExplainCardContextService$hideExplainCard$1(this, r101, r100));
    }

    public final void h(ShelfInfo r100, boolean r101) {
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r102 = com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.a(r100);
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r103 = this.f84819c;
        if (r103 == null) goto L5;
        r103.setData(r102);
    L5:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r104 = this.f84819c;
        if (r104 == null) goto L8;
        r104.setOnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCard, r101));
    L8:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r105 = this.f84819c;
        if (r105 == null) goto L11;
        r105.setOnBtnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCardButton, r101));
    L11:
        AudienceShelfSupplementInfoContextService r106 = (AudienceShelfSupplementInfoContextService) getOpenPlatformContext().getService(AudienceShelfSupplementInfoContextService.class);
        if (r102 == null) goto L14;
        Long r107 = Long.valueOf(r102.f85033a);
    L15:
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r108 = r106.f(r107);
        if (r108 == null) goto L21;
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r109 = this.f84819c;
        if (r109 == null) goto L22;
        r109.setSupplementInfo(r108);
        return;
    L22:
        return;
    L21:
        return;
    L14:
        r107 = null;
        goto L15
    }

    public final void g(final ShelfInfo r110, boolean r111, boolean r112) {
        if (m71.e.c(10) == false) goto L6;
        return;
    L6:
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L9;
        ((EntranceMonitorContextService) getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf).a("is casting", null);
        return;
    L9:
        DataCenter r100 = getOpenPlatformContext().getDataCenter();
        if (r100 == null) goto L12;
        Boolean r101 = (Boolean) r100.get("cmd_commerce_ad_show", Boolean.FALSE);
    L14:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L17;
        return;
    L17:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(getOpenPlatformContext().getDataCenter()), PaidSceneEnum.PAID_ROOM, 2) == true) goto L19;
        return;
    L19:
        List<ShelfCardInfo> r102 = r110.cardInfoList;
        if (r102 == null) goto L71;
        ListIterator<ShelfCardInfo> r103 = r102.listIterator(r102.size());
    L22:
        boolean r104 = true;
        if (r103.hasPrevious() == false) goto L30;
        ShelfCardInfo r105 = r103.previous();
        if (r105.getStatus() != 1) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L22;
    L31:
        ShelfCardInfo r107 = r105;
        if (r107 == null) goto L79;
        HashMap<String, zo0.f> r108 = zo0.g.f573094a;
        zo0.f r109 = h.b(PerformanceScene.EXPLAIN_CARD);
        r109.o();
        r109.m("is_from_enter", r111);
        this.f84818b = true;
        uc1 r113 = ee0.f120119a.getValue();
        if (r113 == null) goto L39;
        if (r113.d() != 1) goto L39;
    L42:
        if (r104 == false) goto L46;
        this.f84821e.removeCallbacks(this.f84822f);
        if (r107.f0() <= 0) goto L46;
        this.f84821e.postDelayed(this.f84822f, ((long) r107.f0()) * 1000);
    L46:
        RoomContext r114 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r114 == null) goto L52;
        j<a0<pp1.c>> r115 = r114.getToolbarBubbleManager();
        if (r115 == null) goto L52;
        r115.c(new AudienceExplainCardContextService$realShowExplainCard$1(this));
    L52:
        if (this.f84819c == null) goto L54;
    L57:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r116 = this.f84819c;
        if (r116 != null) goto L60;
        return;
    L60:
        w r117 = this.f84820d;
        int r118 = w.f84080d;
        monitor-enter(r117);
    L68:
        th = move-exception;
        throw th;
    L63:
        if ((SystemClock.uptimeMillis() - r117.f84083c) < 10000) goto L65;
        v.a();     // Catch: Throwable -> L68
        r117.f84081a.clear();     // Catch: Throwable -> L68
    L65:
        monitor-exit(r117);
        this.f84820d.a("register show tasks", new AudienceExplainCardContextService$realShowExplainCard$2(this, r116, r112, r110, r111));
        return;
    L54:
        if (this.f84817a == null) goto L56;
        qo0.a.c("AudienceExplainCardContextService", "content view is preloaded");
    L56:
        AudienceExplainCardWidget<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r119 = new AudienceExplainCardWidget(getOpenPlatformContext().getContext(), getOpenPlatformContext().getRoomId(), new f(getOpenPlatformContext(), new MiniAppExplainCard(getOpenPlatformContext().getContext(), null, 0, this.f84817a), new MiniAppHotAtmosphereView(getOpenPlatformContext().getContext(), null, 6, 0)));
        r119.setData(com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.a(r110));
        r119.setOnCloseBlock(new AudienceExplainCardContextService$createExplainCardWidget$$inlined$apply$lambda$1(this, r110));
        r119.setOnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCard, false));
        r119.setOnBtnClickBlock(new AudienceExplainCardContextService$getOnExplainCardClickListener$1(this, MountedMiniAppSource.ExplainCardButton, false));
        this.f84819c = r119;
    L39:
        if (r110.coexistKAAnchor == 1) goto L42;
        r104 = false;
        goto L42
    L79:
        return;
    L27:
        r106 = false;
        goto L28
    L30:
        r105 = null;
        goto L31
    L71:
        return;
    L12:
        r101 = null;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r9v11, types: [com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$tryShowExplainCard$1] */
    public static void i(final AudienceExplainCardContextService r100, final ShelfInfo r101, final boolean r102, final boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "shelfInfo");
        if (r102 == true) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L25;
        DataCenter r106 = r100.getOpenPlatformContext().getDataCenter();
        if (r106 == null) goto L18;
        String r107 = (String) r106.get("data_right_card_loaded", "");
    L20:
        if ((true ^ Intrinsics.areEqual(r107, "3")) == false) goto L24;
        int r108 = qo0.a.f534145a;
        qo0.a.c("Perf", "right card widget is not loaded, wait until load, curr time: " + SystemClock.uptimeMillis());
        r100.f84823g = new AudienceExplainCardContextService$tryShowExplainCard$1(r100, r101, r102, r103);
        DataCenter r109 = r100.getOpenPlatformContext().getDataCenter();
        if (r109 == null) goto L27;
        r109.observe("data_right_card_loaded", r100.f84823g, false);
        return;
    L27:
        return;
    L24:
        int r110 = qo0.a.f534145a;
        qo0.a.c("Perf", "right card widget is already loaded, show explain card, curr time: " + SystemClock.uptimeMillis());
        r100.g(r101, r102, r103);
        return;
    L18:
        r107 = null;
        goto L20
    L25:
        r100.g(r101, r102, r103);
        return;
    L11:
        if (de0.f120026a.getValue().b() != 1) goto L13;
        r105 = true;
        goto L14
    }
}
