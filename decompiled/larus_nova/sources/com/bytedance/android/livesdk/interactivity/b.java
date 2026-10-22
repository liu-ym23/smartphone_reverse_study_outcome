package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import java.util.EnumMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<DegradeScene, DegradeSceneLevel> f133882b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<DegradeScene, DegradeSceneLevel> f133883a;

    public static final class a {
    }

    static {
        f133882b = new EnumMap(DegradeScene.class);
    }

    public final boolean a() {
        DegradeSceneLevel r100 = b(DegradeScene.PERFORMANCE_FRAME);
        if (r100 != DegradeSceneLevel.Default.NONE) goto L5;
    L7:
        return false;
    L5:
        if (r100 == DegradeSceneLevel.PerformanceFrame.ANCHOR_OVERHEAT) goto L7;
        return true;
    }

    public b() {
        this.f133883a = new EnumMap(DegradeScene.class);
    }

    public final DegradeSceneLevel b(DegradeScene r100) {
        Intrinsics.checkNotNullParameter(r100, "degradeScene");
        DegradeSceneLevel r101 = (DegradeSceneLevel) ((EnumMap) this.f133883a).get(r100);
        if (r101 != null) goto L5;
        r101 = (DegradeSceneLevel) ((EnumMap) f133882b).get(r100);
    L5:
        if (r101 == null) goto L7;
        return r101;
    L7:
        return DegradeSceneLevel.Default.NONE;
    }

    public final void c(e32.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r100.f470903c != DegradeDimension.GLOBAL) goto L5;
        Map<DegradeScene, DegradeSceneLevel> r101 = f133882b;
    L6:
        DegradeSceneLevel r102 = r101.get(r100.f470901a);
        if (r102 != null) goto L9;
        r102 = DegradeSceneLevel.Default.NONE;
    L9:
        DegradeSceneLevel r103 = r100.f470902b;
        if (r103 != DegradeSceneLevel.Default.NONE) goto L12;
        r101.remove(r100.f470901a);
    L13:
        int r104 = g32.c.f479795a;
        Intrinsics.checkNotNullParameter(r100, "degradeRequest");
        Intrinsics.checkNotNullParameter(r102, "oldLevel");
        ALogger.i("InteractivityDegradeLogger", "degrade status update. type: " + r100.f470901a.name() + ", old level: " + r102.logName() + ", new level: " + r100.f470902b.logName() + ", dimension: " + r100.f470903c.name());
        return;
    L12:
        r101.put(r100.f470901a, r103);
        goto L13
    L5:
        r101 = this.f133883a;
        goto L6
    }
}
