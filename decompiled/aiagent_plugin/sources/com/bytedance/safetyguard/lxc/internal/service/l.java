package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import android.system.OsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: ProxyFdKey.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<FileDescriptor, u> f11036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<Integer, Boolean> f11037b;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.l$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProxyFdKey.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.b<Integer, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f11038a = null;

        static {
            f11038a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(1, OsConstants.class, "S_ISSOCK", "S_ISSOCK(I)Z", 0);
        }

        public final Boolean a(int r1) {
            return Boolean.valueOf(OsConstants.S_ISSOCK(r1));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Integer r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
        }
    }

    public l(d.h.a.b<? super FileDescriptor, u> r3, d.h.a.b<? super Integer, Boolean> r4) {
        d.h.a.b<FileDescriptor, u> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<Integer, Boolean> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "readStat");
        d.h.b.o.e(r6, "isSocketMode");
        this.f11036a = r5;
        this.f11037b = r6;
    }

    public /* synthetic */ l(d.h.a.b r2, d.h.a.b r3, int r4, d.h.b.h r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(AnonymousClass1.f11038a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L5:
        this(r6, r7);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.t
    public s a(ParcelFileDescriptor r5) {
        d.h.b.o.e(r5, "proxyFd");
        d.h.a.b<FileDescriptor, u> r1 = this.f11036a;     // Catch: Exception -> L10
        FileDescriptor r6 = r5.getFileDescriptor();     // Catch: Exception -> L10
        d.h.b.o.c(r6, "getFileDescriptor(...)");     // Catch: Exception -> L10
        u r7 = (u) ZeusTransformUtils.preCheckCast(r1.invoke(r6), u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11037b.invoke(Integer.valueOf(r7.c())), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L9;
        return new s(r7.a(), r7.b());
    L9:
        throw new m("proxyFd must refer to a socket", null, 2, null);
    L10:
        e = move-exception;
        throw new m("proxyFd could not be inspected", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
