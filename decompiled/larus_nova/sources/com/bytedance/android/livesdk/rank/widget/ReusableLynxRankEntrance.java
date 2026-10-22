package com.bytedance.android.livesdk.rank.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.l2;
import com.bytedance.android.live.core.setting.y1;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.config.setting.i;
import com.bytedance.android.livesdk.event.t;
import com.bytedance.android.livesdk.rank.k;
import com.bytedance.android.livesdk.revenue.experience.RevExpBizScene;
import com.bytedance.android.livesdk.revenue.experience.f;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/rank/widget/ReusableLynxRankEntrance;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReusableLynxRankEntrance extends RowRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f157035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f157036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zy0.b f157037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f157038d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReusableLynxRankEntrance f157039a;

        public a(ReusableLynxRankEntrance r100) {
            this.f157039a = r100;
        }

        public final void a() {
            zy0.b r100 = this.f157039a.f157037c;
            String r101 = null;
            if (r100 != null) goto L56;
            ALogger.w("ReusableLynxRankEntrance", "card not ready, creating...");
            ReusableLynxRankEntrance r102 = this.f157039a;
            r102.getClass();
            ALogger.i("ReusableLynxRankEntrance", "create new Card");
            ReadOnlyProperty r103 = k.f156976d;
            KProperty<?>[] r104 = k.f156973a;
            String r105 = (String) r103.getValue(null, r104[2]);
            if (r102.context != null) goto L7;
            ALogger.e("ReusableLynxRankEntrance", "context is null");
        L53:
            r100 = this.f157039a.f157037c;
            if (r100 != null) goto L56;
            return;
        L7:
            if (r105 != null) goto L9;
        L12:
            boolean r110 = true;
        L13:
            if (r110 == false) goto L15;
            ALogger.e("ReusableLynxRankEntrance", "schema is null or empty");
            goto L53
        L15:
            com.bytedance.android.livesdk.revenue.experience.c r111 = (com.bytedance.android.livesdk.revenue.experience.c) vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
            if (r111 == null) goto L22;
            f r112 = r111.Mg(r102.dataCenter, RevExpBizScene.DEGRADE_BUSINESS_REVENUE_RANK);
            if (r112 == null) goto L22;
            if (r112.f157150a != true) goto L22;
            ALogger.e("ReusableLynxRankEntrance", "canLoadCard is false");
        L22:
            IRevBroadcastService r113 = (IRevBroadcastService) vh6.c.b(IRevBroadcastService.class);
            IRevBroadcastService.BroadcastBizKey r114 = IRevBroadcastService.BroadcastBizKey.MONITOR_RANK_ENTRANCE_CREATE_CARD;
            r113.J4(r114);
            if (r102.f157035a == false) goto L35;
            ReadOnlyProperty r106 = k.f156977e;
            String r107 = (String) r106.getValue(null, r104[3]);
            if (r107 != null) goto L27;
        L30:
            boolean r108 = true;
        L31:
            if (r108 == true) goto L33;
            String r109 = (String) r106.getValue(null, r104[3]);
        L34:
            zy0.b r115 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(r102.context, UriProtector.parse(r109), ReusableLynxRankEntrance$createCard$card$1.INSTANCE);
        L39:
            com.bytedance.android.livesdk.rank.widget.a r116 = new com.bytedance.android.livesdk.rank.widget.a(r115);
            if (y1.f65460a.getValue().booleanValue() == false) goto L42;
            i0.i(c50.b.b(r102.dataCenter), r116);
        L43:
            r102.f157037c = r115;
            r102.f157038d = r102.context;
            if (r115 == null) goto L48;
            View r117 = r115.c();
            if (r117 == null) goto L48;
            ViewUtilsKt.d(r117, -2);
        L48:
            if (r115 == null) goto L52;
            View r118 = r115.c();
            if (r118 == null) goto L52;
            a1.k(r118, -1);
        L52:
            ((IRevBroadcastService) vh6.c.b(IRevBroadcastService.class)).Rk(r114);
            goto L53
        L42:
            r116.run();
            goto L43
        L33:
            r109 = (String) r103.getValue(null, r104[2]);
            goto L34
        L27:
            if (r107.length() == 0) goto L30;
            r108 = false;
            goto L31
        L35:
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r119 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r102.context, UriProtector.parse(r105), null);
            if (r119 != null) goto L38;
            ALogger.e("ReusableLynxRankEntrance", "failed to create card");
            goto L53
        L38:
            r115 = r119;
            goto L39
        L9:
            if (r105.length() == 0) goto L12;
            r110 = false;
        L56:
            View r120 = this.f157039a.contentView;
            if (r120 == null) goto L91;
            ((ViewGroup) r120).addView(r100.c());
            ReusableLynxRankEntrance r121 = this.f157039a;
            zy0.b r122 = r121.f157037c;
            if (r122 == null) goto L86;
            xy0.a<?> r123 = r122.g();
            if (r123 == null) goto L78;
            Pair[] r124 = new Pair[3];
            r124[0] = TuplesKt.to("user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString());
            j.a r125 = j.C0;
            yz0.k r126 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r125.a(), yz0.k.class);
            if (r126 == null) goto L66;
            IRoom r127 = r126.getRoom();
        L67:
            if (r127 == null) goto L69;
            String r128 = String.valueOf(r127.getRoomId());
        L70:
            r124[1] = TuplesKt.to("room_id", r128);
            yz0.k r129 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r125.a(), yz0.k.class);
            if (r129 == null) goto L73;
            IRoom r130 = r129.getRoom();
        L74:
            if (r130 == null) goto L76;
            r101 = r130.getOwnerUserIdString();
        L76:
            r124[2] = TuplesKt.to("anchor_id", r101);
            r123.updateGlobalProps(MapsKt.mutableMapOf(r124));
            goto L78
        L73:
            r130 = null;
            goto L74
        L69:
            r128 = null;
            goto L70
        L66:
            r127 = null;
        L78:
            if (r121.f157035a == false) goto L80;
            ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).tn(r122);
        L80:
            av0.a r131 = yt0.c.j();
            if (r131 == null) goto L86;
            RxUtilKt.c(r131.Uc().getFromClient().subscribe(new d(r122)), r121.f157036b);
            xy0.a<?> r132 = r122.g();
            if (r132 == null) goto L86;
            r132.registerMethod("hourRankStateChanged", new e(r131, r122));
        L86:
            xy0.a<?> r133 = r100.g();
            if (r133 == null) goto L92;
            Handler r134 = UtilityKotlinExtentionsKt.f66103a;
            r133.sendJsEvent("onLiveRoomEnter", new JSONObject());
            return;
        L92:
            return;
        L91:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
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

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_lynx_rank_entrance;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ALogger.w("ReusableLynxRankEntrance", "onUnload");
        this.f157036b.clear();
        zy0.b r100 = this.f157037c;
        if (r100 == null) goto L7;
        xy0.a<?> r101 = r100.g();
        if (r101 == null) goto L7;
        Handler r102 = UtilityKotlinExtentionsKt.f66103a;
        r101.sendJsEvent("onLiveRoomExit", new JSONObject());
    L7:
        View r103 = this.contentView;
        if (r103 == null) goto L12;
        ((ViewGroup) r103).removeAllViews();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final int supportClearScene() {
        if (l2.f65348a.getValue().booleanValue() == false) goto L5;
        return 1289;
    L5:
        return 1288;
    }

    public final void wq() {
        ALogger.w("ReusableLynxRankEntrance", "releaseCard");
        zy0.b r100 = this.f157037c;
        if (r100 == null) goto L9;
        View r101 = this.contentView;
        if (r101 == null) goto L8;
        ((ViewGroup) r101).removeView(r100.c());
        r100.dispose();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        this.f157037c = null;
        this.f157038d = null;
    }

    public ReusableLynxRankEntrance() {
        this.f157035a = ((Boolean) k.f156979g.getValue(null, k.f156973a[5])).booleanValue();
        this.f157036b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onClear() {
        super.onClear();
        ALogger.w("ReusableLynxRankEntrance", "onClear");
        zy0.b r100 = this.f157037c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f157037c = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onEnterClear(int r100) {
        if (r100 == 256) goto L7;
        if (r100 == 8) goto L7;
        if (r100 == 1) goto L7;
        return;
    L7:
        this.contentView.setVisibility(8);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onExitClear(int r100) {
        if (r100 != 256) goto L5;
    L8:
        this.contentView.setVisibility(0);
        return;
    L5:
        if (r100 == 8) goto L8;
        if (r100 == 1) goto L8;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        ALogger.w("ReusableLynxRankEntrance", "onInit");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ALogger.w("ReusableLynxRankEntrance", "onLoad, widget=" + this);
        if (this.f157037c == null) goto L9;
        Context r101 = this.f157038d;
        if (r101 == null) goto L9;
        if (r101 == this.context) goto L9;
        ALogger.w("ReusableLynxRankEntrance", "context changed, release old card");
        wq();
    L9:
        AnchorMainPostOptUtils.c("createCard", this.dataCenter, this, new a(this));
        RxUtilKt.c(xs2.b.a().b(t.class).subscribe(new c(this)), this.f157036b);
        if (i.f121210a.K() == true) goto L20;
        com.bytedance.android.livesdk.revenue.experience.c r102 = (com.bytedance.android.livesdk.revenue.experience.c) vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        if (r102 == null) goto L18;
        Disposable r103 = r102.Vi(RevExpBizScene.DEGRADE_BUSINESS_REVENUE_RANK, new b(this));
        if (r103 == null) goto L19;
        RxUtilKt.c(r103, this.f157036b);
        return;
    L19:
        return;
    L18:
        return;
    }
}
