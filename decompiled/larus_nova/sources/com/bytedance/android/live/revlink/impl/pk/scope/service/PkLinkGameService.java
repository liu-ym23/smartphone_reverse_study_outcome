package com.bytedance.android.live.revlink.impl.pk.scope.service;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.link.model.bridge.e2;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b)\u0010*J\u0018\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u0018\u0010\u0018\u001a\u00060\u0016j\u0002`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R2\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/scope/service/PkLinkGameService;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/tools/kcp/kmpscope/runtime/ScopeService;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/c;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", WidgetCostModule.TYPE_ON_START, "onStop", "", "getCurrentGameStatus", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "getCurrentTrackInfo", "", "getWatchDuration", "onAttach", "onDetach", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "gameStatus", "I", "", "hasEnterGame", "Z", "watchStartTimeStamp", "J", "trackInfo", "Ljava/util/Map;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkLinkGameService extends DataContext implements o, c {

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f96775cd;
    private int gameStatus;
    private boolean hasEnterGame;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final f messageService;
    private Map<String, String> trackInfo;
    private long watchStartTimeStamp;

    public void onAttach() {
    }

    public void onDetach() {
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c
    public long getWatchDuration() {
        i97.a r100 = i97.a.f488802a;
        return (System.currentTimeMillis() - this.watchStartTimeStamp) / ((long) 1000);
    }

    @Override // com.bytedance.android.scope.o
    public void onStart() {
        f r100 = this.messageService;
        com.bytedance.android.live.revenue.common.message.a r101 = com.bytedance.android.live.revenue.common.message.a.f90883g;
        Lazy r102 = CommonMessageTypeKt.f90851a;
        Intrinsics.checkNotNullParameter(r101, "$this$PROFIT_GAME_STATUS_MESSAGE");
        Observable r103 = h.a.a(r100, (yh6.b) CommonMessageTypeKt.A.getValue(), false, 6);
        final PkLinkGameService$onStart$1$1 r104 = new PkLinkGameService$onStart$1$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.subscribe(new a(r104)), this.f96775cd);
        Observable r105 = h.a.a(r100, CommonMessageTypeKt.b(r101), false, 6);
        final PkLinkGameService$onStart$1$2 r106 = new PkLinkGameService$onStart$1$2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r105.subscribe(new a(r106)), this.f96775cd);
        Pair r107 = d.a(new AnonymousClass2(this));
        com.bytedance.live.datacontext.b.a((DataContext) r107.getFirst(), Reflection.getOrCreateKotlinClass(c.class));
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r107.getSecond(), this.f96775cd);
    }

    @Override // com.bytedance.android.scope.o
    public void onStop() {
        if (this.gameStatus != IProfitGameStatusMessage.GameStatus.BizStart.ordinal()) goto L5;
        this.linkFakeGlobalService.getPkBaseLogger().d("game_link", 0, this.linkFakeGlobalService.getLinkCrossRoomDataHolder().c(), "", 7);
    L5:
        this.f96775cd.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c
    public int getCurrentGameStatus() {
        return this.gameStatus;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c
    public Map<String, String> getCurrentTrackInfo() {
        return this.trackInfo;
    }

    private final void onMessage(yh6.c r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if ((r110 instanceof e2) == false) goto L19;
        IProfitGameStatusMessage r111 = (IProfitGameStatusMessage) ((vh7.c) r110).castTo(IProfitGameStatusMessage.class);
        int r100 = r111.getGameStatus();
        IProfitGameStatusMessage.GameStatus r101 = IProfitGameStatusMessage.GameStatus.BizStart;
        if (r100 == r101.ordinal()) goto L9;
        int r112 = r111.getGameStatus();
        IProfitGameStatusMessage.GameStatus r102 = IProfitGameStatusMessage.GameStatus.BizEnd;
        if (r112 != r102.ordinal()) goto L23;
        this.hasEnterGame = false;
        if (this.gameStatus != r101.ordinal()) goto L17;
        this.linkFakeGlobalService.getPkBaseLogger().d("game_link", 0, this.linkFakeGlobalService.getLinkCrossRoomDataHolder().c(), "", 7);
    L17:
        this.gameStatus = r102.ordinal();
        return;
    L23:
        return;
    L9:
        if (this.hasEnterGame == false) goto L11;
        return;
    L11:
        this.hasEnterGame = true;
        this.trackInfo = MapsKt.toMutableMap(r111.getTrackInfo());
        i97.a r113 = i97.a.f488802a;
        this.watchStartTimeStamp = System.currentTimeMillis();
        this.gameStatus = r101.ordinal();
        this.linkFakeGlobalService.getPkBaseLogger().c(0, "", "game_link");
        return;
    L19:
        if ((r110 instanceof r0) == false) goto L25;
        this.trackInfo.clear();
        return;
    }

    public PkLinkGameService(com.bytedance.android.live.revlink.impl.global.c r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "linkFakeGlobalService");
        Intrinsics.checkNotNullParameter(r101, "messageService");
        this.linkFakeGlobalService = r100;
        this.messageService = r101;
        this.f96775cd = new CompositeDisposable();
        this.gameStatus = IProfitGameStatusMessage.GameStatus.Default.ordinal();
        this.trackInfo = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$onMessage(PkLinkGameService r100, yh6.c r101) {
        r100.onMessage(r101);
    }
}
