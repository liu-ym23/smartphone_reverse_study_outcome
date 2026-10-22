package M4;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f970a;
    public final String b;
    public final AtomicReference c;
    public final AtomicBoolean d;
    public final a e;

    public b(Context context, String servicePackageName, Ba.a aVar) {
        k.f(servicePackageName, "servicePackageName");
        this.f970a = context;
        this.b = servicePackageName;
        this.c = new AtomicReference();
        this.d = new AtomicBoolean(false);
        this.e = new a(this);
    }

    public final void a() {
        Object objA;
        if (this.c.get() != null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.d;
        if (atomicBoolean.compareAndSet(false, true)) {
            Intent intent = new Intent("com.stepos.agentcache.action.BIND_AGENT_CACHE_SERVICE");
            String str = this.b;
            intent.setPackage(str);
            try {
                boolean zBindService = this.f970a.bindService(intent, this.e, 1);
                if (zBindService) {
                    Log.d("LogSdkClient", "bind requested, package=" + str);
                } else {
                    atomicBoolean.set(false);
                    Log.w("LogSdkClient", "bind failed, package=" + str);
                }
                objA = Boolean.valueOf(zBindService);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                atomicBoolean.set(false);
                androidx.constraintlayout.core.dsl.a.w("bind exception: ", thA.getMessage(), "LogSdkClient");
                objA = Boolean.FALSE;
            }
        }
    }
}
