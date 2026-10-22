package com.bytedance.safetyguard.lxc.internal.d;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.OsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: ProxyEndpointTerminator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static /* synthetic */ void lambda$7eUJXMIDKlEuYCmk_Rwjntr50bo(d.h.a.m r0, ParcelFileDescriptor r1) {
        a(r0, r1);
    }

    public static final p a(d.h.a.m<? super FileDescriptor, ? super Integer, d.x> r2) {
        final d.h.a.m r3 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "shutdownCall");
        return new $$Lambda$q$7eUJXMIDKlEuYCmk_Rwjntr50bo(r3);
    }

    private static final void a(d.h.a.m r2, ParcelFileDescriptor r3) {
        d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "$shutdownCall");
        d.h.b.o.e(r3, "fd");
        FileDescriptor r5 = r3.getFileDescriptor();     // Catch: ErrnoException -> L5
        d.h.b.o.c(r5, "getFileDescriptor(...)");     // Catch: ErrnoException -> L5
        r4.invoke(r5, Integer.valueOf(OsConstants.SHUT_RDWR));     // Catch: ErrnoException -> L5
        return;
    L5:
        e = move-exception;
        if (a(e.errno) == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static final boolean a(int r1) {
        if (r1 != OsConstants.ENOTCONN) goto L5;
    L8:
        return true;
    L5:
        if (r1 == OsConstants.EBADF) goto L8;
        return false;
    }
}
