package na;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import java.util.UUID;
import la.c;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f10699a;

    /* renamed from: b, reason: collision with root package name */
    public final a f10700b;

    /* renamed from: c, reason: collision with root package name */
    public final na.a f10701c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            V3OfflineEmitter v3OfflineEmitter;
            c.a("SessionController", "session timeout");
            b bVar = b.this;
            if (bVar.f10699a != null) {
                synchronized (bVar) {
                    c.a("SessionController", "end a session id: " + bVar.f10699a);
                    bVar.f10699a = null;
                }
            }
            c.a("SessionController", "flush events when session end");
            oa.b bVar2 = c.a.f10391a.f10386d;
            if (bVar2 == null || (v3OfflineEmitter = bVar2.f10839a) == null) {
                return;
            }
            ta.c.a("V3OfflineEmitter", "flush");
            sa.a aVar = v3OfflineEmitter.f8018f;
            if (aVar == null || aVar.f11898a.getAll().size() <= 0) {
                return;
            }
            ta.c.a("V3OfflineEmitter", "flush sp data");
            v3OfflineEmitter.f8017e.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(v3OfflineEmitter, true));
        }
    }

    public b(Application application) {
        HandlerThread handlerThread = new HandlerThread("com.stepos.statsapp.v3.SessionControllerWorker", 5);
        handlerThread.start();
        this.f10700b = new a(handlerThread.getLooper());
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f10701c;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f10701c = null;
        }
        na.a aVar = new na.a(this);
        this.f10701c = aVar;
        application.registerActivityLifecycleCallbacks(aVar);
        ta.c.a("SessionController", "registerApplicationLifeCycle");
        ta.c.a("SessionController", "SessionController init");
    }

    public final String a() {
        if (this.f10699a == null) {
            synchronized (this) {
                this.f10699a = UUID.randomUUID().toString();
                ta.c.a("SessionController", "generate a sessionId: " + this.f10699a);
            }
        }
        return this.f10699a;
    }
}
