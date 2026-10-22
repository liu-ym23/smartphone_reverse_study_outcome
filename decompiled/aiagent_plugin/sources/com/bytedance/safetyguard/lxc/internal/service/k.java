package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
final class k implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f11035a = null;

    static {
        f11035a = new k();
    }

    private k() {
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.aa
    public z a(ParcelFileDescriptor r4) {
        d.h.b.o.e(r4, "sessionFd");
        ParcelFileDescriptor r3 = ParcelFileDescriptor.dup(r4.getFileDescriptor());
        ParcelFileDescriptor r5 = ParcelFileDescriptor.dup(r4.getFileDescriptor());     // Catch: Exception -> L6
        d.h.b.o.a(r3);
        InputStream r6 = (InputStream) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.f.a.a(r3), InputStream.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r5);
        return new z(r6, (OutputStream) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.f.a.b(r5), OutputStream.class, "com.obric.aiagent.plugin"));
    L6:
        e = move-exception;
        d.h.b.o.a(r3);
        d.a(r3);
        throw e;
    }
}
