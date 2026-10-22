package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdkapi.model.PlayerSpeedRangeParams;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f155962b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f155963a;

    public static final class a implements e.a {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e.a
        public final e create() {
            return new h();
        }
    }

    public static final class b {
    }

    static {
        f155962b = new a();
    }

    public h() {
        this.f155963a = MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        String r102 = r100.f155965a;
        if (Intrinsics.areEqual(r102, "inner_draw") == false) goto L6;
        String r103 = "inner_draw_player_speed_range_params";
    L9:
        boolean r104 = true;
        if (r103.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        PlayerSpeedRangeParams r106 = null;
        if (r105 == true) goto L69;
        IStrategyService r107 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r107 == null) goto L69;
        LiveData r108 = IStrategyService.a.a(r107, r103, this.f155963a, false, 12);
        if (r108 == null) goto L69;
        Map r109 = (Map) r108.getValue();
        if (r109 == null) goto L69;
        if ((!r109.isEmpty()) == true) goto L25;
    L27:
        r104 = false;
    L28:
        if (r104 == true) goto L31;
        r109 = null;
    L31:
        if (r109 == null) goto L69;
        Object r110 = r109.get("upRatio");
        if ((r110 instanceof Double) == true) goto L35;
        r110 = null;
    L35:
        Double r111 = (Double) r110;
        if (r111 == null) goto L38;
        Float r112 = Float.valueOf((float) r111.doubleValue());
    L39:
        Object r113 = r109.get("upBuffer");
        if ((r113 instanceof Double) == true) goto L42;
        r113 = null;
    L42:
        Double r114 = (Double) r113;
        if (r114 == null) goto L45;
        Integer r115 = Integer.valueOf((int) r114.doubleValue());
    L46:
        Object r116 = r109.get("downRatio");
        if ((r116 instanceof Double) == true) goto L49;
        r116 = null;
    L49:
        Double r117 = (Double) r116;
        if (r117 == null) goto L52;
        Float r118 = Float.valueOf((float) r117.doubleValue());
    L53:
        Object r119 = r109.get("downBuffer");
        if ((r119 instanceof Double) == true) goto L56;
        r119 = null;
    L56:
        Double r120 = (Double) r119;
        if (r120 == null) goto L59;
        Integer r121 = Integer.valueOf((int) r120.doubleValue());
    L60:
        if (r112 == null) goto L69;
        if (r115 == null) goto L69;
        if (r118 == null) goto L69;
        if (r121 == null) goto L69;
        float r122 = 0;
        if (r112.floatValue() <= r122) goto L69;
        if (r118.floatValue() <= r122) goto L69;
        r106 = new PlayerSpeedRangeParams(r112.floatValue(), r115.intValue(), r118.floatValue(), r121.intValue());
        goto L69
    L59:
        r121 = null;
        goto L60
    L52:
        r118 = null;
        goto L53
    L45:
        r115 = null;
        goto L46
    L38:
        r112 = null;
        goto L39
    L25:
        if ((!Intrinsics.areEqual(r109, this.f155963a)) == false) goto L27;
    L69:
        r101.f155994p = r106;
        return;
    L12:
        r105 = false;
        goto L13
    L6:
        if (Intrinsics.areEqual(r102, "feed_preview") == false) goto L8;
        r103 = "preview_player_speed_range_params";
        goto L9
    L8:
        r103 = "unify_player_speed_range_params";
        goto L9
    }
}
