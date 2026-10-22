package z5;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.agentcache.ipc.ILogIngestService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14262a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14263b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference<ILogIngestService> f14264c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f14265d;

    /* renamed from: e, reason: collision with root package name */
    public final a f14266e;

    public b(Context context, String servicePackageName, com.stepos.cpuset.b bVar) {
        g.f(servicePackageName, "servicePackageName");
        this.f14262a = context;
        this.f14263b = servicePackageName;
        this.f14264c = new AtomicReference<>();
        this.f14265d = new AtomicBoolean(false);
        this.f14266e = new a(this);
    }

    public final void a() {
        Object objA;
        if (this.f14264c.get() != null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.f14265d;
        if (atomicBoolean.compareAndSet(false, true)) {
            Intent intent = new Intent("com.stepos.agentcache.action.BIND_AGENT_CACHE_SERVICE");
            String str = this.f14263b;
            intent.setPackage(str);
            try {
                boolean zBindService = this.f14262a.bindService(intent, this.f14266e, 1);
                if (zBindService) {
                    Log.d("LogSdkClient", "bind requested, package=" + str);
                } else {
                    atomicBoolean.set(false);
                    Log.w("LogSdkClient", "bind failed, package=" + str);
                }
                objA = Boolean.valueOf(zBindService);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                atomicBoolean.set(false);
                a0.a.A("bind exception: ", thB.getMessage(), "LogSdkClient");
                objA = Boolean.FALSE;
            }
        }
    }
}
