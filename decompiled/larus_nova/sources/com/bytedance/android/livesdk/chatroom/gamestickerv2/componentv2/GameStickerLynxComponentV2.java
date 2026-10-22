package com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.gamestickerv2.config.ComponentMode;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class GameStickerLynxComponentV2 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ComponentState f106306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GameStickerInfo f106308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f106309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f106310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HybridCard f106311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f106312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f106313h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameStickerLynxComponentV2 f106314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function5 f106315b;

        public b(GameStickerLynxComponentV2 r100, Function5 r101) {
            this.f106314a = r100;
            this.f106315b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            SubscriberJsEvent r111 = (SubscriberJsEvent) r110;
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
            Map<String, Object> r101 = r111.getParams();     // Catch: Throwable -> L11
            if (r101 == null) goto L6;
            Object r102 = r101.get("status");     // Catch: Throwable -> L11
        L7:
            if (r102 == null) goto L10;
            Object r103 = Result.m9449constructorimpl(Integer.valueOf(((Integer) r102).intValue()));     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r103) == false) goto L16;
            r103 = -1;
        L16:
            int r104 = ((Number) r103).intValue();
            Map<String, Object> r105 = r111.getParams();     // Catch: Throwable -> L25
            if (r105 == null) goto L20;
            Object r106 = r105.get("roomId");     // Catch: Throwable -> L25
        L21:
            if (r106 == null) goto L24;
            Object r107 = Result.m9449constructorimpl((String) r106);     // Catch: Throwable -> L25
        L28:
            if (Result.m9455isFailureimpl(r107) == false) goto L30;
            r107 = "-1";
        L30:
            String r108 = (String) r107;
            Map<String, Object> r109 = r111.getParams();     // Catch: Throwable -> L39
            if (r109 == null) goto L34;
            Object r112 = r109.get("errorMsg");     // Catch: Throwable -> L39
        L35:
            if (r112 == null) goto L38;
            Object r113 = Result.m9449constructorimpl((String) r112);     // Catch: Throwable -> L39
        L42:
            if (Result.m9455isFailureimpl(r113) == false) goto L44;
            r113 = "";
        L44:
            String r114 = (String) r113;
            Map<String, Object> r115 = r111.getParams();     // Catch: Throwable -> L53
            if (r115 == null) goto L48;
            Object r116 = r115.get("errorCode");     // Catch: Throwable -> L53
        L49:
            if (r116 == null) goto L52;
            Object r117 = Result.m9449constructorimpl(Integer.valueOf(((Integer) r116).intValue()));     // Catch: Throwable -> L53
        L55:
            boolean r118 = false;
            if (Result.m9455isFailureimpl(r117) == false) goto L58;
            r117 = 0;
        L58:
            int r119 = ((Number) r117).intValue();
            GameStickerLynxComponentV2 r120 = this.f106314a;
            HybridCard r121 = r120.f106311f;
            if ((!Intrinsics.areEqual(r108, r120.f106313h)) == true) goto L61;
        L65:
            GameStickerLynxComponentV2 r122 = this.f106314a;
            Disposable r123 = r122.f106309d;
            if (r123 == null) goto L68;
            r123.dispose();
        L68:
            r122.f106309d = null;
            this.f106315b.invoke(r108, Integer.valueOf(r104), Integer.valueOf(r119), r114, r121);
            return;
        L61:
            if (r108.length() <= 0) goto L63;
            r118 = true;
        L63:
            if (r118 == false) goto L65;
            return;
        L52:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L53
        L48:
            r116 = null;
        L53:
            th = move-exception;
            Result.Companion r124 = Result.Companion;
            r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L55
        L38:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L39
        L34:
            r112 = null;
        L39:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L42
        L24:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L25
        L20:
            r106 = null;
        L25:
            th = move-exception;
            Result.Companion r126 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L28
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L11
        L6:
            r102 = null;
        L11:
            th = move-exception;
            Result.Companion r127 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final void c(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onVisible");
        Intrinsics.checkNotNullParameter(r101, "onGone");
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final void unload() {
        HybridCard r100 = this.f106311f;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f106311f = null;
        this.f106306a = ComponentState.NONE;
        Disposable r101 = this.f106309d;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f106309d = null;
        this.f106308c = null;
        this.f106307b = -1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final GameStickerInfo a() {
        return this.f106308c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final int d() {
        return this.f106310e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final ComponentMode mode() {
        return ComponentMode.LYNX;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final ComponentState state() {
        return this.f106306a;
    }

    public final void g(Function5<? super String, ? super Integer, ? super Integer, ? super String, ? super View, Unit> r100) {
        Disposable r101 = this.f106309d;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f106309d = null;
        IBrowserService r102 = (IBrowserService) k.f(IBrowserService.class);
        if (r102 == null) goto L13;
        Observable<SubscriberJsEvent> r103 = r102.registerJsEventSubscriber("gameStickerLoadStatus");
        if (r103 == null) goto L14;
        Disposable r104 = r103.subscribe(new b(this, r100));
        if (r104 == null) goto L15;
        this.f106309d = r104;
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final void onOrientationChanged(int r100) {
        if (r100 != this.f106307b) goto L5;
        return;
    L5:
        this.f106307b = r100;
        HybridCard r101 = this.f106311f;     // Catch: Exception -> L10
        if (r101 == null) goto L13;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L10
        r102.put("orientation", r100);     // Catch: Exception -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Exception -> L10
        r101.sendJsEvent("Lynx_StickerOrientationChange", r102);     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    public GameStickerLynxComponentV2(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomId");
        this.f106312g = r100;
        this.f106313h = r101;
        this.f106306a = ComponentState.NONE;
        this.f106307b = -1;
        this.f106310e = -1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final void b(GameStickerInfo r100, final Function2<? super Integer, ? super String, Unit> r101, final Function2<? super Integer, ? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFailure");
        this.f106308c = r100;
        g(new GameStickerLynxComponentV2$refresh$1(this, r101, r102));     // Catch: Exception -> L7
        HybridCard r103 = this.f106311f;     // Catch: Exception -> L7
        if (r103 == null) goto L10;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L7
        r104.put("data", r100.getStickerData());     // Catch: Exception -> L7
        Unit r105 = Unit.INSTANCE;     // Catch: Exception -> L7
        r103.sendJsEvent("Lynx_WebcastGameStickerUpdate", r104);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2.g
    public final void e(GameStickerInfo r100, final Function3<? super View, ? super Integer, ? super String, Unit> r101, final Function2<? super Integer, ? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFailure");
        if (this.f106306a != ComponentState.FAIL) goto L6;
        this.f106310e = -3002;
        r102.invoke(-3002, "load state is fail");
        return;
    L6:
        this.f106308c = r100;
        this.f106306a = ComponentState.LOADING;
        g(new GameStickerLynxComponentV2$load$1(this, r101, r102));
        String r103 = r100.getStickerUrl();
        r103.getClass();
        boolean r104 = StringsKt.startsWith$default(r103, "https://", false, 2, null);
        if (StringsKt.startsWith$default(r103, "sslocal://webcast_lynxview", false, 2, null) == false) goto L10;
        Uri r105 = UriProtector.parse(r103);
    L13:
        IBrowserService r106 = (IBrowserService) k.f(IBrowserService.class);
        if (r106 == null) goto L16;
        HybridCard r107 = r106.getHybridCard(this.f106312g, r105, new d(this, r102));
    L17:
        this.f106311f = r107;
        if (r107 == null) goto L21;
        r107.load(null, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("webcastInteractionExtra", r100.getStickerData())}));
        return;
    L21:
        return;
    L16:
        r107 = null;
        goto L17
    L10:
        if (r104 == false) goto L12;
        r105 = x6.a.c(r103).appendQueryParameter("room_id", this.f106313h).appendQueryParameter(CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE, ILiveHybridMonitor.ContainerType.ANNIE).build();
        goto L13
    L12:
        r105 = x6.a.c("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/game_priority_high_lynx_douyin/pages/game_sticker_page/template.js").appendQueryParameter("room_id", this.f106313h).appendQueryParameter(CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE, ILiveHybridMonitor.ContainerType.ANNIE).build();
        goto L13
    }

    public static final void f(GameStickerLynxComponentV2 r100, Function2 r101, int r102, String r103) {
        ComponentState r104 = r100.f106306a;
        ComponentState r105 = ComponentState.FAIL;
        if (r104 == r105) goto L7;
        r100.f106310e = r102;
        r100.f106306a = r105;
        r101.invoke(Integer.valueOf(r102), r103);
        return;
    }
}
