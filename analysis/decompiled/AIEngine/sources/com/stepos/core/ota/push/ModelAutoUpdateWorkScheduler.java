package com.stepos.core.ota.push;

import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.impl.b;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import dc.h;
import h2.c;
import h2.j;
import h2.l;
import h2.q;
import i2.n;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import q2.p;
import r2.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelAutoUpdateWorkScheduler {
    public static final ModelAutoUpdateWorkScheduler INSTANCE = new ModelAutoUpdateWorkScheduler();
    private static final long ONCE_DELAY_SECONDS = 15;
    private static final String ONCE_WORK = "model_auto_update_once";
    private static final String PERIODIC_WORK = "model_auto_update_periodic";
    private static final long REPEAT_HOURS = 6;
    private static final String TAG = "ModelAutoUpdateWorkScheduler";

    private ModelAutoUpdateWorkScheduler() {
    }

    private final c constraints() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return new c(new g(null), NetworkType.f2785c, true, false, true, true, -1L, -1L, kotlin.collections.a.R0(linkedHashSet));
    }

    public final void cancelAll(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        b bVarA = b.a(context);
        kotlin.jvm.internal.g.e(bVarA, "getInstance(context)");
        androidx.work.impl.utils.a.c(bVarA, PERIODIC_WORK);
        b bVarA2 = b.a(context);
        kotlin.jvm.internal.g.e(bVarA2, "getInstance(context)");
        androidx.work.impl.utils.a.c(bVarA2, ONCE_WORK);
        AIEngineLogger.i(LogModule.OTA, TAG, "all model-auto-update work cancelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scheduleOnce(Context context, String reason) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(reason, "reason");
        l.a aVar = new l.a(ModelAutoUpdateWorker.class);
        c constraints = constraints();
        kotlin.jvm.internal.g.f(constraints, "constraints");
        aVar.f9287b.f11513j = constraints;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        kotlin.jvm.internal.g.f(timeUnit, "timeUnit");
        aVar.f9287b.f11511g = timeUnit.toMillis(ONCE_DELAY_SECONDS);
        if (Long.MAX_VALUE - System.currentTimeMillis() <= aVar.f9287b.f11511g) {
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
        Pair[] pairArr = {new Pair(ModelAutoUpdateWorker.KEY_REASON, reason)};
        Data.a aVar2 = new Data.a();
        Pair pair = pairArr[0];
        aVar2.b(pair.f9986b, (String) pair.f9985a);
        aVar.f9287b.f11509e = aVar2.a();
        l lVarA = aVar.a();
        b bVarA = b.a(context);
        kotlin.jvm.internal.g.e(bVarA, "getInstance(context)");
        new n(bVarA, ONCE_WORK, ExistingWorkPolicy.f2774a, b1.P(lVarA)).a();
        AIEngineLogger.i(LogModule.OTA, TAG, "once scheduled delay=15s reason=".concat(reason));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void schedulePeriodic(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        TimeUnit repeatIntervalTimeUnit = TimeUnit.HOURS;
        kotlin.jvm.internal.g.f(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        q.a aVar = new q.a(ModelAutoUpdateWorker.class);
        p pVar = aVar.f9287b;
        long millis = repeatIntervalTimeUnit.toMillis(REPEAT_HOURS);
        pVar.getClass();
        String str = p.f11504y;
        if (millis < 900000) {
            j.d().g(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        long j10 = millis < 900000 ? 900000L : millis;
        long j11 = millis < 900000 ? 900000L : millis;
        if (j10 < 900000) {
            j.d().g(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        pVar.h = j10 >= 900000 ? j10 : 900000L;
        if (j11 < InteractiveSessionRegistry.DEFAULT_TTL_MS) {
            j.d().g(str, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j11 > pVar.h) {
            j.d().g(str, "Flex duration greater than interval duration; Changed to " + j10);
        }
        pVar.f11512i = h.b0(j11, InteractiveSessionRegistry.DEFAULT_TTL_MS, pVar.h);
        c constraints = constraints();
        kotlin.jvm.internal.g.f(constraints, "constraints");
        aVar.f9287b.f11513j = constraints;
        Pair[] pairArr = {new Pair(ModelAutoUpdateWorker.KEY_REASON, "periodic")};
        Data.a aVar2 = new Data.a();
        Pair pair = pairArr[0];
        aVar2.b(pair.f9986b, (String) pair.f9985a);
        aVar.f9287b.f11509e = aVar2.a();
        q qVarA = aVar.a();
        b bVarA = b.a(context);
        kotlin.jvm.internal.g.e(bVarA, "getInstance(context)");
        new n(bVarA, PERIODIC_WORK, ExistingWorkPolicy.f2775b, Collections.singletonList(qVarA)).a();
        AIEngineLogger.i(LogModule.OTA, TAG, "periodic scheduled every 6h (charging+unmetered+battery/storage-ok)");
    }
}
