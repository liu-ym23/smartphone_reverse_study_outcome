package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f78173a = null;

    static {
        f78173a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jd0.l r101 = (jd0.l) r100;
        String r102 = r101.f498204a;
        JSONObject r103 = r101.f498205b;     // Catch: Exception -> L19
        if (r103 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("livesdk_audience_playmode_room_watch", r102) == false) goto L25;
        Object r104 = r103.get(ILoadStallMonitor.START_TIME);     // Catch: Exception -> L19
        Long r105 = null;
        if ((r104 instanceof String) == true) goto L10;
        r104 = null;
    L10:
        String r106 = (String) r104;     // Catch: Exception -> L19
        if (r106 == null) goto L13;
        r105 = Long.valueOf(CastLongProtector.parseLong(r106));     // Catch: Exception -> L19
    L13:
        li0.b r107 = li0.b.f509313b;     // Catch: Exception -> L19
        if (r105 == null) goto L16;
        long r108 = r105.longValue();     // Catch: Exception -> L19
    L17:
        li0.b.f509312a = r108;     // Catch: Exception -> L19
        return;
    L16:
        r108 = 0;
        goto L17
    L25:
        return;
    L19:
        e = move-exception;
        ALogger.e("DynamicTeamFightWidget", "regiestDynamicDataChange, Exception: " + e);
    }
}
