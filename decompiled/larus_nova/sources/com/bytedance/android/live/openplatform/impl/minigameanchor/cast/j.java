package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f85159a = null;

        static {
            f85159a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.b(null, 1, true);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }
    }

    static {
    }

    public static void a(boolean r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L9
        r102.put("key_mg_in_cast", r100);     // Catch: Throwable -> L9
        String r103 = r102.toString();     // Catch: Throwable -> L9
        a r104 = a.f85159a;
        if (r100 == false) goto L6;
        i0.c().removeCallbacks(r104);     // Catch: Throwable -> L9
        b(r103, -1, true);     // Catch: Throwable -> L9
        Object r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
        return;
    L6:
        b(null, 1, false);     // Catch: Throwable -> L9
        b(r103, -1, true);     // Catch: Throwable -> L9
        r105 = Boolean.valueOf(i0.c().postDelayed(r104, 5000));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void b(String r100, int r101, boolean r102) {
        com.bytedance.android.live.pushstream.d r103 = ((IPushStreamService) jc1.k.n(IPushStreamService.class)).getPushLiveStream();
        if (r103 == null) goto L6;
        r103.c1(GameSeiConstants.KEY_GAME_IN_CAST, r100, r101, r102, true);
        return;
    }
}
