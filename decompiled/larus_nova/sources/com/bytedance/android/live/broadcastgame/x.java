package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.common.ui.GameExitConformDialog;
import com.bytedance.android.live.broadcastgame.widget.AnchorGameWidget;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements com.bytedance.android.live.broadcastgame.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<IAnchorGameWidget> f61835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f61836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f61837c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f61838a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f61838a.c(GameSeiConstants.KEY_GAME_IN_CAST, null, 1, true);     // Catch: Throwable -> L8
            WeakReference<IAnchorGameWidget> r100 = this.f61838a.f61835a;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            IAnchorGameWidget r101 = r100.get();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.Aq();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public b(x r100) {
            this.f61838a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void a() {
        WeakReference<IAnchorGameWidget> r100 = this.f61835a;
        if (r100 == null) goto L8;
        IAnchorGameWidget r101 = r100.get();
        if (r101 == null) goto L9;
        r101.xq();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void b() {
        WeakReference<IAnchorGameWidget> r100 = this.f61835a;
        if (r100 == null) goto L8;
        IAnchorGameWidget r101 = r100.get();
        if (r101 == null) goto L9;
        r101.Cq();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final com.bytedance.android.live.broadcastgame.api.model.u getCurrentPlayingGame() {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r100 = AnchorGameContext.a.a();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.u> r101 = r100.getCurrentGame();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final String getGameCategory() {
        WeakReference<IAnchorGameWidget> r100 = this.f61835a;
        if (r100 == null) goto L8;
        IAnchorGameWidget r101 = r100.get();
        if (r101 == null) goto L8;
        String r102 = r101.wq();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final boolean isPlayingGame() {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r100 = AnchorGameContext.a.a();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isPlayingGame();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void stopGameCastToAudience() {
        WeakReference<IAnchorGameWidget> r100 = this.f61835a;
        if (r100 == null) goto L8;
        IAnchorGameWidget r101 = r100.get();
        if (r101 == null) goto L9;
        r101.Fq();
        return;
    L9:
        return;
    }

    public x() {
        this.f61836b = new Handler(Looper.getMainLooper());
        this.f61837c = new b(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final h0 getLiveOpenFeatureSceneFilter(DataCenter r100) {
        h0 r101 = new h0();
        r101.f59630a = r100;
        return r101;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final boolean isPlayingGame(InteractID r100) {
        Intrinsics.checkNotNullParameter(r100, "gameType");
        AnchorGameContext.Companion.getClass();
        return AnchorGameContext.a.b(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void notifyStopLinkCastResult(boolean r100) {
        WeakReference<IAnchorGameWidget> r101 = this.f61835a;
        if (r101 == null) goto L8;
        IAnchorGameWidget r102 = r101.get();
        if (r102 == null) goto L9;
        r102.zq(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void stopRunningPlugin(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        WeakReference<IAnchorGameWidget> r101 = this.f61835a;
        if (r101 == null) goto L8;
        IAnchorGameWidget r102 = r101.get();
        if (r102 == null) goto L9;
        r102.Eq(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final GameExitConformDialog getGameExitConformDialog(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        return new GameExitConformDialog(r100, r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void sendGameCastStatusSEI(boolean r100, JSONObject r101) {
        int r102 = com.bytedance.android.live.broadcastgame.api.interactgame.f.f59309a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L12
        r104.put(GameSeiConstants.KEY_GAME_IN_CAST, r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        Iterator<String> r105 = r101.keys();     // Catch: Throwable -> L12
        if (r105 == null) goto L10;
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();     // Catch: Throwable -> L12
        r104.put(r106, r101.get(r106));     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r104.toString());     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r107) == false) goto L17;
        r107 = "";
    L17:
        String r108 = (String) r107;
        ALogger.i("GameAnchorService", "sendGameCastStatusSEI, inCast: " + r100 + ", data: " + r108);
        if (r100 == false) goto L20;
        this.f61836b.removeCallbacks(this.f61837c);
        c(GameSeiConstants.KEY_GAME_IN_CAST, r108, -1, true);
        return;
    L20:
        c(GameSeiConstants.KEY_GAME_IN_CAST, null, 1, false);
        c(GameSeiConstants.KEY_GAME_IN_CAST, r108, -1, true);
        this.f61836b.postDelayed(this.f61837c, 5000);
        return;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void sendGameSeiData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c(r100, r101, -1, true);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void sendServerMergeCastStatusSEI(boolean r100, JSONObject r101) {
        int r102 = com.bytedance.android.live.broadcastgame.api.interactgame.f.f59309a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L12
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L12
        r105.put(GameSeiConstants.KEY_GAME_IN_CAST, r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        Iterator<String> r106 = r101.keys();     // Catch: Throwable -> L12
        if (r106 == null) goto L10;
    L8:
        if (r106.hasNext() == false) goto L10;
        String r107 = r106.next();     // Catch: Throwable -> L12
        r105.put(r107, r101.get(r107));     // Catch: Throwable -> L12
    L10:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r104.put(GameSeiConstants.KEY_GAME_IN_CAST, r105.toString());     // Catch: Throwable -> L12
        r104.put("source", "TTLiveSDK_Android");     // Catch: Throwable -> L12
        Object r109 = Result.m9449constructorimpl(r104.toString());     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r109) == false) goto L17;
        r109 = "";
    L17:
        String r110 = (String) r109;
        ALogger.i("GameAnchorService", "sendServerMergeCastStatusSEI, inCast: " + r100 + ", data: " + r110);
        if (r100 == false) goto L20;
        this.f61836b.removeCallbacks(this.f61837c);
        c(GameSeiConstants.KEY_GAME_IN_CAST, r110, -1, true);
        return;
    L20:
        c(GameSeiConstants.KEY_GAME_IN_CAST, null, 1, false);
        c(GameSeiConstants.KEY_GAME_IN_CAST, r110, -1, true);
        this.f61836b.postDelayed(this.f61837c, 5000);
        return;
    L12:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void notifyStartLinkCastResult(boolean r100, Surface r101, int r102) {
        WeakReference<IAnchorGameWidget> r103 = this.f61835a;
        if (r103 == null) goto L8;
        IAnchorGameWidget r104 = r103.get();
        if (r104 == null) goto L9;
        r104.yq(r100, r101, r102);
        return;
    L9:
        return;
    }

    public final void c(String r100, String r101, int r102, boolean r103) {
        WeakReference<IAnchorGameWidget> r104 = this.f61835a;
        if (r104 == null) goto L8;
        IAnchorGameWidget r105 = r104.get();
        if (r105 == null) goto L9;
        r105.Bq(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final AnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r100, Room r101, Fragment r102, FragmentManager r103) {
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "fragmentManager");
        AnchorGameWidget r104 = new AnchorGameWidget(r100, r101, r102, r103);
        this.f61835a = new WeakReference(r104);
        return r104;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void tryGetSwitchGameConfirmDialog(com.bytedance.android.live.broadcastgame.api.model.u r100, Context r101, DataCenter r102, Function0<Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "gameItem");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "onSuccess");
        Intrinsics.checkNotNullParameter(r104, "onFail");
        com.bytedance.android.live.broadcastgame.common.utils.b.a(r100, r101, r102, r103, r104);
    }
}
