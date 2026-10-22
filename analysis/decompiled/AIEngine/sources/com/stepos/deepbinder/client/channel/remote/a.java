package com.stepos.deepbinder.client.channel.remote;

import android.net.Uri;
import android.os.SystemClock;
import androidx.appcompat.widget.z0;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import kotlin.jvm.internal.g;
import w9.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a implements o9.b {
    public static final C0064a Companion = new C0064a();
    private static Uri cacheUri;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.deepbinder.client.channel.remote.a$a, reason: collision with other inner class name */
    public static final class C0064a {
    }

    private final void commitIPCState(u9.a aVar, IPCException iPCException, long j10, long j11) {
        aVar.f13184d = iPCException != null ? iPCException.getErrorCode() : 0;
        aVar.f13185e = SystemClock.currentThreadTimeMillis() - (j10 + j11);
        aVar.f13186f = j11;
        e.f13612e.b(new z0(aVar, 21), false, true);
        if (iPCException != null) {
            throw iPCException;
        }
    }

    public final void connect() {
        u9.a aVar = new u9.a(6);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            internalConnect();
            e = null;
        } catch (IPCException e10) {
            e = e10;
        }
        commitIPCState(aVar, e, jCurrentThreadTimeMillis, 0L);
    }

    public abstract void internalConnect();

    public abstract Reply internalSendCall(Call call);

    public final void recycleRemote(Long[] ids) {
        IPCException iPCException;
        g.f(ids, "ids");
        u9.a aVar = new u9.a(4);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            internalRecycle(ids);
            iPCException = null;
        } catch (IPCException e10) {
            iPCException = e10;
        }
        commitIPCState(aVar, iPCException, jCurrentThreadTimeMillis, 0L);
    }

    public abstract void release();

    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.deepbinder.core.entity.Reply sendCall(com.stepos.deepbinder.core.entity.Call r11) {
        /*
            r10 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.g.f(r11, r0)
            com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper r0 = r11.getServiceWrapper()
            r1 = 0
            if (r0 == 0) goto L11
            int r0 = r0.getType()
            goto L12
        L11:
            r0 = r1
        L12:
            r2 = 1
            if (r0 == 0) goto L39
            if (r0 == r2) goto L29
            u9.a r0 = new u9.a
            r3 = 2
            r0.<init>(r3)
            com.stepos.deepbinder.core.entity.wrapper.MethodWrapper r3 = r11.getMethodWrapper()
            java.lang.String r3 = r3.getName()
            r0.f13183c = r3
        L27:
            r4 = r0
            goto L3f
        L29:
            u9.a r0 = new u9.a
            r0.<init>(r2)
            com.stepos.deepbinder.core.entity.wrapper.MethodWrapper r3 = r11.getMethodWrapper()
            java.lang.String r3 = r3.getName()
            r0.f13183c = r3
            goto L27
        L39:
            u9.a r0 = new u9.a
            r0.<init>(r1)
            goto L27
        L3f:
            com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper r0 = r11.getServiceWrapper()
            r3 = 0
            if (r0 == 0) goto L4b
            java.lang.String r0 = r0.getName()
            goto L4c
        L4b:
            r0 = r3
        L4c:
            r4.f13182b = r0
            long r6 = android.os.SystemClock.currentThreadTimeMillis()
            com.stepos.deepbinder.core.entity.Reply r3 = r10.internalSendCall(r11)     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            int r0 = r11.getDataSize()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            r4.f13187g = r0     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            r3.getInvokeTime()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            com.stepos.deepbinder.core.exception.IPCException r0 = r3.getIpcException()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            if (r0 == 0) goto L77
            int r5 = r0.getErrorCode()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            r8 = 22
            if (r5 != r8) goto L77
            boolean r11 = r11.getAutoRecover()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L74
            if (r11 == 0) goto L77
            goto L78
        L74:
            r0 = move-exception
            r11 = r0
            goto L78
        L77:
            r1 = r2
        L78:
            r5 = r0
            r11 = r3
            if (r1 == 0) goto L92
            if (r11 == 0) goto L85
            long r0 = r11.getInvokeTime()
        L82:
            r3 = r10
            r8 = r0
            goto L88
        L85:
            r0 = 0
            goto L82
        L88:
            r3.commitIPCState(r4, r5, r6, r8)
            if (r11 == 0) goto L8e
            return r11
        L8e:
            kotlin.jvm.internal.g.c(r5)
            throw r5
        L92:
            kotlin.jvm.internal.g.c(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.client.channel.remote.a.sendCall(com.stepos.deepbinder.core.entity.Call):com.stepos.deepbinder.core.entity.Reply");
    }
}
