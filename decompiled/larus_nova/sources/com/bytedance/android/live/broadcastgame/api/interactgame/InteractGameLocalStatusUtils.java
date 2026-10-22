package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class InteractGameLocalStatusUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59295a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f59296a = null;

        static {
            f59296a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            ALogger.i("InteractGameLocalStatusUtils", "[success]send game stop to server ");
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f59297a = null;

        static {
            f59297a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.i("InteractGameLocalStatusUtils", "[failed]send game stop to server ");
        }
    }

    public static void a() {
        c(InstantPlayContext.PLAY_ID, String.valueOf(0));
        c("game_token", String.valueOf(0));
        c("game_id", String.valueOf(0));
        String r100 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r100, "startId");
        c("start_id", r100);
        String r101 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r101, "appId");
        c("app_id", r101);
        String r102 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r102, "gameId");
        c("xplay_game_id", r102.toString());
        String r103 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r103, "liveScene");
        c("live_scene", r103);
        String r104 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r104, "xplayRoomId");
        c("xplay_room_id", r104.toString());
        c("in_game_cast", String.valueOf(false));
    }

    static {
    }

    public static void b(long r110) {
        com.bytedance.android.livesdk.sharedpref.e<ConcurrentHashMap<String, String>> r100 = com.bytedance.android.livesdk.sharedpref.b.f158230w2;
        ConcurrentHashMap<String, String> r101 = r100.getValue();
        if (r101 == null) goto L45;
        String r102 = r101.get("game_id");
        if (r102 == null) goto L9;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L9;
        long r104 = r103.longValue();
    L10:
        String r105 = r101.get("room_id");
        if (r105 == null) goto L15;
        Long r106 = StringsKt.toLongOrNull(r105);
        if (r106 == null) goto L15;
        long r107 = r106.longValue();
    L16:
        String r108 = r101.get(InstantPlayContext.PLAY_ID);
        if (r108 == null) goto L21;
        Long r109 = StringsKt.toLongOrNull(r108);
        if (r109 == null) goto L21;
        long r111 = r109.longValue();
    L22:
        String r112 = r101.get("game_token");
        if (r112 == null) goto L27;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L27;
        long r114 = r113.longValue();
    L28:
        ALogger.i("InteractGameLocalStatusUtils", r100.getValue().toString());
        if (r104 != 0) goto L31;
        return;
    L31:
        if (r107 != 0) goto L33;
        return;
    L33:
        if (r111 != 0) goto L36;
        return;
    L36:
        if (r107 != r110) goto L48;
        RxCompatKt.b(((IInteractGameService) jc1.k.n(IInteractGameService.class)).notifyServerGameStop(r104, r110, r111, "", true, 2, r114).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()), RxUtil.rxRetryHelper(3)).subscribe(a.f59296a, b.f59297a);
        ALogger.i("InteractGameLocalStatusUtils", "send game stop to server");
        c(InstantPlayContext.PLAY_ID, String.valueOf(0));
        c("game_token", String.valueOf(0));
        ConcurrentHashMap<String, String> r115 = r100.getValue();
        if (r115 == null) goto L40;
        String r116 = r115.get("in_game_cast");
    L42:
        if (Intrinsics.areEqual(r116, "true") == false) goto L49;
        UtilityKotlinExtentionsKt.r(5000, false, true, InteractGameLocalStatusUtils$notifyServerGameStop$1$1.INSTANCE);
        c("in_game_cast", String.valueOf(false));
        return;
    L49:
        return;
    L40:
        r116 = null;
        goto L42
    L48:
        return;
    L27:
        r114 = 0;
    L21:
        r111 = 0;
    L15:
        r107 = 0;
    L9:
        r104 = 0;
        goto L10
    }

    public static void c(String r100, String r101) {
        com.bytedance.android.livesdk.sharedpref.e<ConcurrentHashMap<String, String>> r102 = com.bytedance.android.livesdk.sharedpref.b.f158230w2;
        ConcurrentHashMap<String, String> r103 = r102.getValue();
        if (r103 == null) goto L5;
        r103.put(r100, r101);
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
    L5:
        ALogger.i("InteractGameLocalStatusUtils", "保存缓存 key is " + r100 + ", value is " + r101 + ", properties is " + r102.getValue());
    }
}
