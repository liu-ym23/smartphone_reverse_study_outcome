package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.ik1;
import com.bytedance.android.livesdk.config.vz0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.downloadlib.constants.EventConstants;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f62357c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ik1 f62358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f62359b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.screendetect.a$a, reason: collision with other inner class name */
    public static final class C1031a {
        public static a a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "screenDetectorParams");
            if (r100.f62362a == false) goto L5;
            int r101 = f.f62376k;
            Intrinsics.checkNotNullParameter(r100, "screenDetectorParams");
            return new f(r100);
        L5:
            int r102 = XplayAudienceScreenDetector.f62353f;
            Intrinsics.checkNotNullParameter(r100, "screenDetectorParams");
            return new XplayAudienceScreenDetector(r100);
        }
    }

    static {
    }

    public abstract void e();

    public abstract void f();

    public final void g() {
        if (this.f62358a.c() == true) goto L5;
        return;
    L5:
        e();
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "screenDetectorParams");
        this.f62359b = r100;
        this.f62358a = vz0.f121489a.getValue();
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (v.a() == false) goto L5;
    L6:
        XplayLog.c("XplayScreenDetect", r100);
        return;
    L5:
        if (this.f62358a.d() == true) goto L6;
    }

    public static JSONObject a(a r100, Function1 r101) {
        Object r102 = new JSONObject();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "block");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((JSONObject) r101.invoke(r102));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == true) goto L12;
        r102 = r104;
    L12:
        return (JSONObject) r102;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ void d(a r100, String r101, JSONObject r102) {
        r100.c(r101, r102, new JSONObject(), new JSONObject());
    }

    public final void c(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        if (r101 != null) goto L5;
        JSONObject r104 = new JSONObject();
    L12:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        r104.put(IPerformanceManager.Params.is_anchor, m2.b(this.f62359b.f62362a));     // Catch: Throwable -> L8
        r104.put("room_id", this.f62359b.f62363b);     // Catch: Throwable -> L8
        r104.put("anchor_id", this.f62359b.f62364c);     // Catch: Throwable -> L8
        this.f62359b.getClass();     // Catch: Throwable -> L8
        r104.put("user_id", ((IUserService) k.n(IUserService.class)).user().n());     // Catch: Throwable -> L8
        r104.put("game_id", this.f62359b.f62365d);     // Catch: Throwable -> L8
        r104.put("app_id", this.f62359b.f62366e);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(r104.put(EventConstants.ExtraJson.GAME_NAME, this.f62359b.f62367f));     // Catch: Throwable -> L8
    L10:
        b(r100 + ": " + r101 + ' ' + r102 + ' ' + r103);
        LiveTracingMonitor.f(r100, LiveTracingMonitor.EventModule.XPLAY, r104, r102, r103);
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        r104 = r101;
        goto L12
    }
}
