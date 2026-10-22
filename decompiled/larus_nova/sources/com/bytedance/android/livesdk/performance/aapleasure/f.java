package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.AtomicAbility;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.bytedance.android.livesdkapi.service.StrategyAbility;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import j40.k2;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicAbility f154436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f154437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f154438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f154439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f154440e;

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        this.f154440e = r100;
        StrategyScene r101 = StrategyScene.preview;
        this.f154438c = "0";
        this.f154439d = new ConcurrentHashMap();
    }

    public final void a(int r100) {
        IPerfBalanceService r101 = (IPerfBalanceService) jc1.k.f(IPerfBalanceService.class);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return;
    L11:
        if (this.f154439d.isEmpty() == false) goto L113;
        return;
    L113:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L107
        Object r104 = this.f154439d.get("scene");     // Catch: Throwable -> L107
        Unit r105 = null;
        String r106 = null;
        r106 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        if (r104 != null) goto L16;
    L105:
        Object r107 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L107
    L109:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L115;
        ALogger.d("AAPleasureManager", "update error " + r108.getMessage() + ' ' + this.f154440e);
        return;
    L115:
        return;
    L16:
        if ((r104 instanceof String) == true) goto L19;
        r104 = null;
    L19:
        if (r104 == null) goto L105;
        String r109 = r104.toString();     // Catch: Throwable -> L107
        if (r109 == null) goto L105;
        StrategyScene r110 = StrategyScene.valueOf(r109);     // Catch: Throwable -> L107
        Object r111 = this.f154439d.get("type");     // Catch: Throwable -> L107
        if (r111 != null) goto L25;
    L30:
        String r112 = null;
    L33:
        if (r110.checkPermission(this.f154440e, r112) == false) goto L80;
        Intrinsics.checkNotNullParameter(r110, "scene");     // Catch: Throwable -> L107
        AtomicAbility r113 = this.f154436a;     // Catch: Throwable -> L107
        if ((r113 instanceof LevelAbility) == true) goto L37;
        r113 = null;
    L37:
        LevelAbility r114 = (LevelAbility) r113;     // Catch: Throwable -> L107
        if (r114 == null) goto L53;
        Object r115 = this.f154439d.get("level");     // Catch: Throwable -> L107
        if (r115 == null) goto L53;
        if ((r115 instanceof String) == true) goto L45;
        r115 = null;
    L45:
        if (r115 == null) goto L53;
        String r116 = r115.toString();     // Catch: Throwable -> L107
        if (r116 == null) goto L53;
        Integer r117 = StringsKt.toIntOrNull(r116);     // Catch: Throwable -> L107
        if (r117 == null) goto L53;
        int r118 = r117.intValue();     // Catch: Throwable -> L107
        if (r118 == this.f154437b) goto L53;
        r114.onPropertyChange(this.f154439d);     // Catch: Throwable -> L107
        r114.onLevelChange(r118);     // Catch: Throwable -> L107
        this.f154437b = r118;     // Catch: Throwable -> L107
    L53:
        AtomicAbility r119 = this.f154436a;     // Catch: Throwable -> L107
        if ((r119 instanceof StrategyAbility) == true) goto L56;
        r119 = null;
    L56:
        StrategyAbility r120 = (StrategyAbility) r119;     // Catch: Throwable -> L107
        if (r120 == null) goto L105;
        Object r121 = this.f154439d.get(BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L107
        if (r121 == null) goto L105;
        if ((r121 instanceof String) == true) goto L64;
        r121 = null;
    L64:
        if (r121 == null) goto L105;
        String r122 = r121.toString();     // Catch: Throwable -> L107
        if (r122 == null) goto L105;
        if ((!Intrinsics.areEqual(r122, this.f154438c)) == false) goto L78;
        r120.onPropertyChange(this.f154439d);     // Catch: Throwable -> L107
        Object r123 = this.f154439d.get("value");     // Catch: Throwable -> L107
        if (r123 != null) goto L72;
    L77:
        r120.onStrategyChange(r122, r106);     // Catch: Throwable -> L107
        this.f154438c = r122;     // Catch: Throwable -> L107
        goto L78
    L72:
        if ((r123 instanceof String) == true) goto L75;
        r123 = null;
    L75:
        if (r123 == null) goto L77;
        r106 = r123.toString();     // Catch: Throwable -> L107
    L78:
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L107
        goto L105
    L80:
        if (k2.f497251a.getValue().booleanValue() == true) goto L82;
    L84:
        AtomicAbility r124 = this.f154436a;     // Catch: Throwable -> L107
        if ((r124 instanceof LevelAbility) == true) goto L87;
        r124 = null;
    L87:
        LevelAbility r125 = (LevelAbility) r124;     // Catch: Throwable -> L107
        if (r125 == null) goto L90;
        r125.onLevelChange(0);     // Catch: Throwable -> L107
        this.f154437b = 0;     // Catch: Throwable -> L107
    L90:
        AtomicAbility r126 = this.f154436a;     // Catch: Throwable -> L107
        if ((r126 instanceof StrategyAbility) == true) goto L93;
        r126 = null;
    L93:
        StrategyAbility r127 = (StrategyAbility) r126;     // Catch: Throwable -> L107
        if (r127 == null) goto L105;
        Object r128 = this.f154439d.get(BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L107
        if (r128 == null) goto L105;
        if ((r128 instanceof String) == true) goto L101;
        r128 = null;
    L101:
        if (r128 == null) goto L105;
        String r129 = r128.toString();     // Catch: Throwable -> L107
        if (r129 == null) goto L105;
        r127.onStrategyChange("0", null);     // Catch: Throwable -> L107
        this.f154438c = r129;     // Catch: Throwable -> L107
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L107
        goto L105
    L82:
        if (r100 != 2) goto L84;
        return;
    L25:
        if ((r111 instanceof String) == true) goto L28;
        r111 = null;
    L28:
        if (r111 == null) goto L30;
        r112 = r111.toString();     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L109
    L5:
        if (r101.isAnchorScene() != true) goto L7;
        r102 = true;
        goto L8
    }
}
