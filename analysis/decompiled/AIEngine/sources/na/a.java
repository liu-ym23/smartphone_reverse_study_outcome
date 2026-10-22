package na;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import java.util.HashMap;
import la.c;
import na.b;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public final b h;

    /* renamed from: i, reason: collision with root package name */
    public String f10697i;

    /* renamed from: f, reason: collision with root package name */
    public long f10695f = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f10694e = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f10693d = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f10692c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f10690a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public final long f10691b = SystemClock.elapsedRealtime();

    /* renamed from: g, reason: collision with root package name */
    public final HandlerC0113a f10696g = new HandlerC0113a(Looper.getMainLooper());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: na.a$a, reason: collision with other inner class name */
    public class HandlerC0113a extends Handler {
        public HandlerC0113a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = a.this;
            b bVar = aVar.h;
            if (message.what == 1) {
                c.a("ActivityLifecycleCallback", "msg.what: ONCE_USE");
                if (aVar.f10692c == 0) {
                    c.a("SessionController", "onForeground");
                    bVar.f10700b.removeCallbacksAndMessages(null);
                    aVar.f10692c = aVar.f10690a;
                    aVar.f10694e = aVar.f10691b;
                }
                c.a("SessionController", "onBackground");
                b.a aVar2 = bVar.f10700b;
                aVar2.removeCallbacksAndMessages(null);
                aVar2.sendEmptyMessageDelayed(1, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
                long j10 = aVar.f10693d - aVar.f10692c;
                long j11 = aVar.f10695f - aVar.f10694e;
                c.a("ActivityLifecycleCallback", "onOnceUse, startTime:" + aVar.f10692c + ", endTime:" + aVar.f10693d + ", duration:" + j10);
                if (aVar.f10692c > 0 && aVar.f10693d > 0 && j10 > 0) {
                    HashMap map = new HashMap();
                    map.put("startTime", String.valueOf(aVar.f10692c));
                    map.put("endTime", String.valueOf(aVar.f10693d));
                    map.put("duration", String.valueOf(j10));
                    map.put("duration2", String.valueOf(j11));
                    la.c cVar = c.a.f10391a;
                    cVar.f10389g.a(cVar.f10383a, "_onceuse_", null, map, 0);
                }
                aVar.f10695f = 0L;
                aVar.f10694e = 0L;
                aVar.f10693d = 0L;
                aVar.f10692c = 0L;
            }
        }
    }

    public a(b bVar) {
        this.h = bVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        ta.c.a("ActivityLifecycleCallback", "onActivityPaused, process:" + Process.myPid());
        this.f10693d = System.currentTimeMillis();
        this.f10695f = SystemClock.elapsedRealtime();
        HandlerC0113a handlerC0113a = this.f10696g;
        handlerC0113a.removeMessages(1);
        handlerC0113a.sendEmptyMessageDelayed(1, 1000L);
        b bVar = this.h;
        if (bVar.a().equals(this.f10697i)) {
            return;
        }
        la.c cVar = c.a.f10391a;
        cVar.f10389g.a(cVar.f10383a, "_startup_", null, null, 0);
        this.f10697i = bVar.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        ta.c.a("ActivityLifecycleCallback", "onActivityResumed, process:" + Process.myPid());
        long j10 = this.f10692c;
        b bVar = this.h;
        if (j10 == 0) {
            ta.c.a("SessionController", "onForeground");
            bVar.f10700b.removeCallbacksAndMessages(null);
            this.f10692c = System.currentTimeMillis();
            this.f10694e = SystemClock.elapsedRealtime();
        }
        this.f10696g.removeMessages(1);
        if (bVar.a().equals(this.f10697i)) {
            return;
        }
        la.c cVar = c.a.f10391a;
        cVar.f10389g.a(cVar.f10383a, "_startup_", null, null, 0);
        this.f10697i = bVar.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
