package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.StructStat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: ProxyFdKey.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f11039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l f11040b = null;

    /* JADX INFO: compiled from: ProxyFdKey.kt */
    static final class a extends d.h.b.p implements d.h.a.b<FileDescriptor, u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11041a = null;

        static {
            f11041a = new a();
        }

        a() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ u invoke(FileDescriptor r3) {
            return a((FileDescriptor) ZeusTransformUtils.preCheckCast(r3, FileDescriptor.class, "com.obric.aiagent.plugin"));
        }

        public final u a(FileDescriptor r7) {
            d.h.b.o.e(r7, "fileDescriptor");
            StructStat r6 = Os.fstat(r7);
            return new u(r6.st_dev, r6.st_ino, r6.st_mode);
        }
    }

    private n() {
    }

    static {
        f11039a = new n();
        f11040b = new l((d.h.a.b) ZeusTransformUtils.preCheckCast(a.f11041a, d.h.a.b.class, "com.obric.aiagent.plugin"), null, 2, null);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.t
    public s a(ParcelFileDescriptor r1) {
        d.h.b.o.e(r1, "proxyFd");
        return f11040b.a(r1);
    }
}
