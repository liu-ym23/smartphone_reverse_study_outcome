package com.amap.api.col.jmsl;

import android.os.SystemClock;
import com.amap.api.col.jmsl.AbstractC1581m2;
import com.autonavi.aps.amapapi.config.Const;

/* renamed from: com.amap.api.col.jmsl.d2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1545d2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    a f16583a;

    /* renamed from: com.amap.api.col.jmsl.d2$a */
    public interface a {
    }

    public final void cancelTask() {
        try {
            a aVar = this.f16583a;
            if (aVar != null) {
                ((AbstractC1581m2.a) aVar).c(this);
            }
        } catch (Throwable th) {
            C1541c2.b(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            a aVar = this.f16583a;
            if (aVar != null) {
                ((AbstractC1581m2.a) aVar).a(this);
            }
            if (Thread.interrupted()) {
                r.i("AMapThreadPool", "Task interrupted | task=" + getClass().getSimpleName(), false);
                return;
            }
            runTask();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (Thread.interrupted()) {
                r.i("AMapThreadPool", "Task interrupted after run | task=" + getClass().getSimpleName() + " | elapsed=" + jElapsedRealtime2 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false);
                return;
            }
            r.i("AMapThreadPool", "Task finished | task=" + getClass().getSimpleName() + " | elapsed=" + jElapsedRealtime2 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false);
            a aVar2 = this.f16583a;
            if (aVar2 != null) {
                ((AbstractC1581m2.a) aVar2).b(this);
            }
        } catch (Throwable th) {
            C1541c2.b(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
