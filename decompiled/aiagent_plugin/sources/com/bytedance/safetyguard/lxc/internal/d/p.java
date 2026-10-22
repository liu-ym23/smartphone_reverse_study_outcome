package com.bytedance.safetyguard.lxc.internal.d;

import android.os.ParcelFileDescriptor;
import android.system.Os;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: ProxyEndpointTerminator.kt */
/* JADX INFO: loaded from: classes.dex */
public interface p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10254a = null;

    /* JADX INFO: compiled from: ProxyEndpointTerminator.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f10255a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p f10256b = null;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProxyEndpointTerminator.kt */
        /* synthetic */ class C0233a extends d.h.b.l implements d.h.a.m<FileDescriptor, Integer, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0233a f10257a = null;

            static {
                f10257a = new C0233a();
            }

            C0233a() {
                super(2, Os.class, "shutdown", "shutdown(Ljava/io/FileDescriptor;I)V", 0);
            }

            public final void a(FileDescriptor r1, int r2) {
                Os.shutdown(r1, r2);
            }

            @Override // d.h.a.m
            public /* synthetic */ d.x invoke(FileDescriptor r3, Integer r4) {
                a((FileDescriptor) ZeusTransformUtils.preCheckCast(r3, FileDescriptor.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
                return d.x.f38692a;
            }
        }

        private a() {
        }

        static {
            f10255a = new a();
            f10256b = q.a((d.h.a.m) ZeusTransformUtils.preCheckCast(C0233a.f10257a, d.h.a.m.class, "com.obric.aiagent.plugin"));
        }

        public final p a() {
            return f10256b;
        }
    }

    static {
        f10254a = a.f10255a;
    }

    void shutdown(ParcelFileDescriptor r1);
}
