package com.bytedance.android.gamecp.live_impl.utils;

import com.bytedance.android.gamecp.common.setting.config.GamePromoteIconLocation;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.live_api.ProviderSource;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.google.gson.Gson;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class PromoteCardLoadOptV2 extends com.bytedance.android.gamecp.common.utils.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, PromoteCardLoadOptV2> f58065g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f58066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f58067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f58068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CloseableReference<CloseableImage> f58069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Function1<? super CloseableReference<CloseableImage>, Unit> f58070f;

    public static final class a {
        public static PromoteCardLoadOptV2 a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "source");
            if (Intrinsics.areEqual(r102, ProviderSource.PREVIEW.name()) == false) goto L5;
            String r103 = r101 + '-' + r102;
        L6:
            ConcurrentHashMap<String, PromoteCardLoadOptV2> r104 = PromoteCardLoadOptV2.f58065g;
            PromoteCardLoadOptV2 r105 = r104.get(r103);
            if (r105 != null) goto L10;
            PromoteCardLoadOptV2 r106 = new PromoteCardLoadOptV2(r100, r101, r102);
            r104.put(r103, r106);
            return r106;
        L10:
            return r105;
        L5:
            r103 = r100 + '-' + r102;
            goto L6
        }
    }

    static {
        f58065g = new ConcurrentHashMap();
    }

    public PromoteCardLoadOptV2(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        super(GamePromoteIconLocation.GAME_PROMOTE_ICON);
    }

    public static Pair d(final String r100, String r101, String r102, final Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (UtilsKt.c(r100) == true) goto L5;
        yr.b.b(6, "game-promote-backend", "roomId=" + r100 + "  is empty or null.");
        return new Pair(Boolean.FALSE, "room_id_empty");
    L5:
        if (Intrinsics.areEqual(r102, ProviderSource.PREVIEW.name()) == false) goto L7;
        String r104 = r101 + '-' + r102;
    L8:
        PromoteCardLoadOptV2 r105 = f58065g.get(r104);
        if (r105 != null) goto L11;
        yr.b.b(6, "game-promote-backend", " not find value for the key,roomId=" + r100);
        return new Pair(Boolean.FALSE, "map_value_empty");
    L11:
        if (r105.f58066b == false) goto L14;
        r105.f58070f = new PromoteCardLoadOptV2$getCachedIconBitmap$$inlined$let$lambda$1(r103, r100);
        return new Pair(Boolean.TRUE, "loading");
    L14:
        if (r105.f58067c == false) goto L19;
        CloseableReference<CloseableImage> r106 = r105.f58069e;
        if (r106 == null) goto L27;
        Intrinsics.checkNotNull(r106);
        r103.invoke(r106);
        return new Pair(Boolean.TRUE, "cache_valid");
    L27:
        return new Pair(Boolean.FALSE, "cache_invalid");
    L19:
        yr.b.b(6, "game-promote-backend", "roomId=" + r100 + ", loading=false and cache not available.");
        return new Pair(Boolean.FALSE, "cache_status_exception");
    L7:
        r104 = r100 + '-' + r102;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r100, String r110, final String r111, final String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "uniqueKey");
        Intrinsics.checkNotNullParameter(r112, "source");
        Object r101 = null;
        if (Intrinsics.areEqual(r112, ILiveRoomControllerProvider.ProviderSource.PREVIEW.name()) == false) goto L8;
        bw.i r102 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        if (r100 == null) goto L7;
        CastLongProtector.parseLong(r100);
    L7:
        r102.p2(r111, r112);
        Room r103 = null;
    L9:
        if (r100 != null) goto L15;
        if (r103 == null) goto L14;
        Long r104 = r103.getRoomId();
        if (r104 == null) goto L14;
        r100 = String.valueOf(r104.longValue());
    L14:
        final String r105 = null;
    L17:
        if (r105 != null) goto L19;
    L22:
        boolean r106 = true;
    L24:
        if (r106 == false) goto L27;
        yr.b.b(6, "PromoteCardLoadOptV2", "preloadIcon room info is null");
        return;
    L27:
        RoomContext.a r107 = RoomContext.Companion;
        r107.getClass();
        if (RoomContext.a.b(r105, r111, r112) != null) goto L31;
        final String r108 = RoomContext.a.a(r105, r111, r112);
        Pair r109 = com.bytedance.live.datacontext.d.a(new PromoteCardLoadOptV2$ensureRoomContextCreate$roomContextPair$1(r108));
        ((RoomContext) r109.getFirst()).setDisposable((Disposable) r109.getSecond());
    L31:
        if (UtilsKt.c(r113) == false) goto L34;
        GameImageBundler r114 = new GameImageBundler();
        ImageModel r115 = new ImageModel();
        ArrayList r116 = new ArrayList();
        Intrinsics.checkNotNull(r113);
        r116.add(r113);
        Unit r117 = Unit.INSTANCE;
        r115.setUrls(r116);
        r114.setOriginImage(r115);
        r114.setThumbImage(r115);
        r114.setThumbHeifImage(r115);
        GameImageBundler r118 = r114;
    L77:
        if (r118 != 0) goto L80;
        yr.b.b(6, "PromoteCardLoadOptV2", "preloadIcon from sense =" + r110 + " ,but image bundle is null");
        return;
    L80:
        this.f58066b = true;
        final GameImageBundler r119 = r118;
        c(r118, new PromoteCardLoadOptV2$preloadIcon$1(this, r105, r111, r112, r119));
        return;
    L34:
        if (Intrinsics.areEqual("enter", r110) == false) goto L39;
        Room r120 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r120 == null) goto L76;
        r101 = r120.getIconBundle();
    L76:
        r118 = r101;
        goto L77
    L39:
        if (Intrinsics.areEqual("im", r110) == false) goto L76;
        RoomContext r121 = RoomContext.a.c(r107, r105, null, null, 6);
        if (r121 == null) goto L76;
        com.bytedance.live.datacontext.m<ArrayList<com.bytedance.android.gamecp.host_api.model.j>> r122 = r121.getSimplePromoteList();
        if (r122 == null) goto L76;
        ArrayList<com.bytedance.android.gamecp.host_api.model.j> r123 = r122.getValue();
        if (r123 == null) goto L76;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L69
        Iterator<T> r125 = r123.iterator();     // Catch: Throwable -> L69
    L49:
        if (r125.hasNext() == false) goto L56;
        Object r126 = r125.next();     // Catch: Throwable -> L69
        if (new JSONObject(((com.bytedance.android.gamecp.host_api.model.j) r126).gameAttr).optInt(IPerformanceManager.MODULE_LIVE_GAME_PLATFORM, 0) != 1) goto L53;
        boolean r127 = true;
    L54:
        if (r127 == false) goto L49;
    L57:
        com.bytedance.android.gamecp.host_api.model.j r128 = (com.bytedance.android.gamecp.host_api.model.j) r126;     // Catch: Throwable -> L69
        if (r128 == null) goto L76;
        String r129 = r128.gameAttr;     // Catch: Throwable -> L69
        if (r129 == null) goto L76;
        JSONObject r130 = new JSONObject(r129).optJSONObject("game_icon_bundler");     // Catch: Throwable -> L69
        if (r130 == null) goto L64;
        String r131 = r130.toString();     // Catch: Throwable -> L69
    L65:
        if (r131 == null) goto L76;
        Object r132 = Result.m9449constructorimpl((GameImageBundler) new Gson().fromJson(r131, GameImageBundler.class));     // Catch: Throwable -> L69
    L72:
        if (Result.m9455isFailureimpl(r132) == true) goto L75;
        r101 = r132;
    L75:
        r101 = (GameImageBundler) r101;
        goto L76
    L64:
        r131 = null;
        goto L65
    L53:
        r127 = false;
        goto L54
    L56:
        r126 = null;
    L69:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L72
    L19:
        if (StringsKt.isBlank(r105) == true) goto L22;
        r106 = false;
    L15:
        r105 = r100;
        goto L17
    L8:
        r103 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        goto L9
    }
}
