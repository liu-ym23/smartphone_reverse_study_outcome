package r2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.UUID;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final s2.c f11713a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.a f11714b;

    /* renamed from: c, reason: collision with root package name */
    public final q2.q f11715c;

    static {
        h2.j.f("WMFgUpdater");
    }

    @SuppressLint({"LambdaLast"})
    public p(WorkDatabase workDatabase, androidx.work.impl.a aVar, s2.c cVar) {
        this.f11714b = aVar;
        this.f11713a = cVar;
        this.f11715c = workDatabase.w();
    }

    public final CallbackToFutureAdapter.c a(final Context context, final UUID uuid, final h2.f fVar) {
        k kVar = this.f11713a.f11878a;
        zb.a aVar = new zb.a() { // from class: r2.o
            @Override // zb.a
            public final Object invoke() {
                p pVar = this.f11709a;
                UUID uuid2 = uuid;
                h2.f fVar2 = fVar;
                Context context2 = context;
                String string = uuid2.toString();
                q2.p pVarI = pVar.f11715c.i(string);
                if (pVarI == null || pVarI.f11506b.a()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                androidx.work.impl.a aVar2 = pVar.f11714b;
                synchronized (aVar2.f2873k) {
                    try {
                        h2.j.d().e(androidx.work.impl.a.f2863l, "Moving WorkSpec (" + string + ") to the foreground");
                        androidx.work.impl.d dVar = (androidx.work.impl.d) aVar2.f2870g.remove(string);
                        if (dVar != null) {
                            if (aVar2.f2864a == null) {
                                PowerManager.WakeLock wakeLockA = m.a(aVar2.f2865b, "ProcessorForegroundLck");
                                aVar2.f2864a = wakeLockA;
                                wakeLockA.acquire();
                            }
                            aVar2.f2869f.put(string, dVar);
                            aVar2.f2865b.startForegroundService(p2.a.c(aVar2.f2865b, y.t(dVar.f2941a), fVar2));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                q2.k kVarT = y.t(pVarI);
                String str = p2.a.f11394m;
                Intent intent = new Intent(context2, (Class<?>) SystemForegroundService.class);
                intent.setAction("ACTION_NOTIFY");
                intent.putExtra("KEY_NOTIFICATION_ID", fVar2.f9268a);
                intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", fVar2.f9269b);
                intent.putExtra("KEY_NOTIFICATION", fVar2.f9270c);
                intent.putExtra("KEY_WORKSPEC_ID", kVarT.f11498a);
                intent.putExtra("KEY_GENERATION", kVarT.f11499b);
                context2.startService(intent);
                return null;
            }
        };
        kotlin.jvm.internal.g.f(kVar, "<this>");
        return CallbackToFutureAdapter.a(new com.stepos.core.ota.downloader.a(kVar, "setForegroundAsync", aVar));
    }
}
