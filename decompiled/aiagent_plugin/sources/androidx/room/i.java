package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f2645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h f2648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.b f2649e;
    IMultiInstanceInvalidationService f;
    final Executor g;
    final IMultiInstanceInvalidationCallback h;
    final AtomicBoolean i;
    final ServiceConnection j;
    final Runnable k;
    final Runnable l;

    i(Context r5, String r6, Intent r7, h r8, Executor r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.aiagent.plugin");
        this.h = new MultiInstanceInvalidationClient$1(this);
        this.i = new AtomicBoolean(false);
        ServiceConnection r0 = new MultiInstanceInvalidationClient$2(this);
        this.j = r0;
        this.k = new AnonymousClass1(this);
        this.l = new AnonymousClass2(this);
        Context r12 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f2645a = r12;
        this.f2646b = r6;
        this.f2648d = r8;
        this.g = r11;
        final String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(r8.f2630a.keySet().toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        this.f2649e = new AnonymousClass3(this, r13);
        ZeusTransformUtils.bindService(r12, r7, r0, 1, "com.obric.aiagent.plugin");
    }

    void a() {
        if (this.i.compareAndSet(false, true) == false) goto L15;
        this.f2648d.b(this.f2649e);
        IMultiInstanceInvalidationService r0 = this.f;     // Catch: RemoteException -> L9
        if (r0 == null) goto L11;
        r0.unregisterCallback(this.h, this.f2647c);     // Catch: RemoteException -> L9
    L11:
        ZeusTransformUtils.unbindService(this.f2645a, this.j, "com.obric.aiagent.plugin");
        return;
    L9:
        e = move-exception;
        a("ROOM", "Cannot unregister multi-instance invalidation callback", e);
        goto L11
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
