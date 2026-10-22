package com.obric.aiagent.skill.ovirt.api;

import com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener;
import com.obric.aiagent.skill.virt.api.y;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IOVirtService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20937a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f20938b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile IOVirtService f20939c;

        private a() {
        }

        static {
            f20937a = new a();
            f20938b = new Object();
        }

        public final IOVirtService a() {
            IOVirtService r3 = f20939c;
            if (r3 == null) goto L5;
            return r3;
        L5:
            Object r4 = f20938b;
            monitor-enter(r4);
            IOVirtService r0 = f20939c;     // Catch: Throwable -> L16
            if (r0 != null) goto L14;
            r0 = (IOVirtService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOVirtService.class), IOVirtService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r0 == null) goto L13;
            f20939c = r0;     // Catch: Throwable -> L16
            goto L14
        L13:
            r0 = null;
        L14:
            monitor-exit(r4);
            return r0;
        L16:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public interface b {

        /* JADX INFO: compiled from: IOVirtService.kt */
        public static final class a {
            public static /* synthetic */ x lambda$aEGpZ2LkV3dhLAWvOf1L8A5ZJ1o() {
                return a();
            }

            public static /* synthetic */ Object a(b r16, String r17, String r18, com.obric.aiagent.skill.ovirt.api.a.d r19, com.obric.aiagent.skill.ovirt.api.a.c r20, boolean r21, d.h.a.a r22, d.c.d r23, int r24, Object r25) {
                b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r16, b.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.ovirt.api.a.d r0 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
                d.h.a.a<x> r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.e>> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
                if (r25 != null) goto L22;
                if ((r24 & 4) == 0) goto L7;
                r0 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.ovirt.api.a.d.a.f20954a, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
            L7:
                com.obric.aiagent.skill.ovirt.api.a.d r5 = r0;
                if ((r24 & 8) == 0) goto L10;
                com.obric.aiagent.skill.ovirt.api.a.c r6 = new com.obric.aiagent.skill.ovirt.api.a.c(false, false, false, 7, null);
            L12:
                if ((r24 & 16) == 0) goto L14;
                boolean r7 = false;
            L16:
                if ((r24 & 32) == 0) goto L18;
                d.h.a.a<x> r8 = $$Lambda$IOVirtService$b$a$aEGpZ2LkV3dhLAWvOf1L8A5ZJ1o.INSTANCE;
            L20:
                return r2.a(r17, r18, r5, r6, r7, r8, r9);
            L18:
                r8 = r3;
                goto L20
            L14:
                r7 = r21;
                goto L16
            L10:
                r6 = r20;
                goto L12
            L22:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: export");
            }

            private static x a() {
                return x.f38692a;
            }
        }

        Object a(String r1, com.obric.aiagent.skill.ovirt.api.a.g r2, String r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.f>> r4);

        Object a(String r1, String r2, com.obric.aiagent.skill.ovirt.api.a.d r3, com.obric.aiagent.skill.ovirt.api.a.c r4, boolean r5, d.h.a.a<x> r6, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.e>> r7);

        Object a(String r1, String r2, com.obric.aiagent.skill.ovirt.api.a.d r3, boolean r4, d.h.a.a<x> r5, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.e>> r6);
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public interface c {
        Object a(d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<Long>> r1);

        Object b(d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<x>> r1);
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public interface d {
        com.obric.aiagent.skill.ovirt.api.b.b.c a(String r1, String r2);

        Object a(String r1, com.obric.aiagent.skill.ovirt.api.b.a r2, d.c.d<? super com.obric.aiagent.skill.ovirt.api.d> r3);

        boolean a(String r1, String r2, boolean r3);
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public interface e {

        /* JADX INFO: compiled from: IOVirtService.kt */
        public static final class a {
            public static /* synthetic */ Object a(e r2, String r3, Map r4, d.c.d r5, int r6, Object r7) {
                e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
                Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
                d.c.d<? super h> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                if (r7 != null) goto L10;
                if ((r6 & 2) == 0) goto L8;
                r9 = ao.b();
            L8:
                return r8.ensureActive(r3, r9, r10);
            L10:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureActive");
            }
        }

        Object cleanupIfOwned(String r1, d.c.d<? super i> r2);

        Object ensureActive(String r1, Map<String, String> r2, d.c.d<? super h> r3);

        boolean isAvailable();

        y paths(String r1);

        Object skillLoaded(String r1, String r2, List<String> r3, d.c.d<? super x> r4);
    }

    static {
        Companion = a.f20937a;
    }

    b getFiles();

    c getMaintenance();

    d getShell();

    e getTask();

    void registerLifecycleListeners(List<? extends OVirtLifecycleListener> r1);
}
