package bo2;

import android.content.Context;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongProgression;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements a {
    public d() {
    }

    @Override // bo2.a
    public final File a(Context r110, PolarisFileWrapper r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "hprofFile");
        Intrinsics.checkNotNullParameter("threshold", "scene");
        Npth.dumpHprof(r111.getAbsolutePath());     // Catch: Throwable -> L18
        LongProgression r112 = RangesKt.step(new LongRange(0, 180000), 500);     // Catch: Throwable -> L18
        long r100 = r112.getFirst();     // Catch: Throwable -> L18
        long r101 = r112.getLast();     // Catch: Throwable -> L18
        long r102 = r112.getStep();     // Catch: Throwable -> L18
        if (r102 < 0) goto L9;
        if (r100 <= r101) goto L10;
        return r111;
    L10:
        if (r111.exists() == true) goto L34;
        Thread.sleep(500);     // Catch: InterruptedException -> L23 Throwable -> L18
    L16:
        if (r100 == r101) goto L33;
        r100 = r100 + r102;
        goto L10
    L33:
        return r111;
    L34:
        return r111;
    L9:
        if (r100 >= r101) goto L10;
        return r111;
    L19:
        if (r111.exists() == false) goto L21;
        r111.delete();
    L21:
        return null;
    }
}
