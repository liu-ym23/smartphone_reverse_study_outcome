package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveUserStayTimeStrategyConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveUserPredictStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f161119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Integer> f161120b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LiveUserPredictStrategy f161121c = null;

    public LiveUserPredictStrategy() {
    }

    static {
        f161121c = new LiveUserPredictStrategy();
        f161119a = LazyKt.lazy(LiveUserPredictStrategy$liveUserPredictStrategyConfig$2.INSTANCE);
        f161120b = new ConcurrentHashMap(16);
    }

    public static v1 a(IRoom r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L69
        Lazy r102 = f161119a;     // Catch: Throwable -> L69
        if (((LiveUserStayTimeStrategyConfig) r102.getValue()).getEnable() == false) goto L6;
        if (r100 != null) goto L11;
        return new v1(-1, "0");
    L11:
        if (((LiveUserStayTimeStrategyConfig) r102.getValue()).getStrategy() != 0) goto L34;
        String r103 = r100.getAnchorId();     // Catch: Throwable -> L25
        if (r103 != null) goto L15;
        r103 = "-1";
    L15:
        r100.getAnchorId();     // Catch: Throwable -> L25
        IFeatureService r104 = (IFeatureService) jc1.k.f(IFeatureService.class);     // Catch: Throwable -> L25
        if (r104 == null) goto L22;
        z90.a r105 = r104.getFeatureManager();     // Catch: Throwable -> L25
        if (r105 == null) goto L22;
        Integer r106 = (Integer) r105.b("inner_feed_stay_duration_p50", r103, -1);     // Catch: Throwable -> L25
        if (r106 == null) goto L22;
        int r107 = r106.intValue();     // Catch: Throwable -> L25
    L23:
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r107));     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r108) == false) goto L31;
        r108 = -1;
    L31:
        return new v1(((Number) r108).intValue(), "1");
    L22:
        r107 = -1;
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L69
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
        goto L28
    L34:
        if (((LiveUserStayTimeStrategyConfig) r102.getValue()).getStrategy() == 1) goto L73;
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L72:
        return new v1(-1, "0");
    L73:
        String r110 = r100.getItemExplicitInfo();     // Catch: Throwable -> L60
        ConcurrentHashMap<Integer, Integer> r111 = f161120b;     // Catch: Throwable -> L60
        if (r111.size() <= 160) goto L39;
        r111.clear();     // Catch: Throwable -> L60
    L39:
        if (com.bytedance.android.livesdk.utils.r2.a(r110) == true) goto L41;
    L57:
        int r112 = -1;
    L58:
        Object r113 = Result.m9449constructorimpl(Integer.valueOf(r112));     // Catch: Throwable -> L60
    L63:
        if (Result.m9455isFailureimpl(r113) == false) goto L66;
        r113 = -1;
    L66:
        return new v1(((Number) r113).intValue(), "2");
    L41:
        if (r110 == null) goto L43;
        int r114 = r110.hashCode();     // Catch: Throwable -> L60
    L44:
        Integer r115 = r111.get(Integer.valueOf(r114));     // Catch: Throwable -> L60
        if (r115 == null) goto L47;
        r112 = r115.intValue();     // Catch: Throwable -> L60
        goto L58
    L47:
        String r116 = new JSONObject(r110).optString("feed_draw_client_targets_rec_info");     // Catch: Throwable -> L60
        if (com.bytedance.android.livesdk.utils.r2.a(r116) == false) goto L57;
        Float r117 = StringsKt.toFloatOrNull(new JSONObject(r116).optString("staytime"));     // Catch: Throwable -> L60
        if (r117 == null) goto L52;
        float r118 = r117.floatValue();     // Catch: Throwable -> L60
    L54:
        if (r118 <= 0) goto L56;
        r118 = r118 * 1000;     // Catch: Throwable -> L60
    L56:
        r112 = (int) r118;     // Catch: Throwable -> L60
        r111.put(Integer.valueOf(r114), Integer.valueOf(r112));     // Catch: Throwable -> L60
        goto L58
    L52:
        r118 = -1;
        goto L54
    L43:
        r114 = 0;
    L60:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L69
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
        goto L63
    L6:
        return new v1(-1, "0");
    L69:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L72
    }
}
