package com.obric.aiagent.skill.credentials.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ISkillCredentialService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ISkillCredentialService {
    public static final c Companion = null;

    /* JADX INFO: compiled from: ISkillCredentialService.kt */
    public interface a {
        Object a(f r1, d.c.d<? super d.n<h>> r2);

        Object a(f r1, List<String> r2, d.c.d<? super kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c>> r3);

        Object b(f r1, d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.a>> r2);

        Object b(f r1, List<String> r2, d.c.d<? super kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c>> r3);
    }

    /* JADX INFO: compiled from: ISkillCredentialService.kt */
    public interface b {
        Object a(f r1, d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.b>> r2);

        Object b(f r1, d.c.d<? super kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c>> r2);

        Object c(f r1, d.c.d<? super d.n<h>> r2);
    }

    /* JADX INFO: compiled from: ISkillCredentialService.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ c f18932a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f18933b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile ISkillCredentialService f18934c;

        private c() {
        }

        static {
            f18932a = new c();
            f18933b = new Object();
        }

        public final ISkillCredentialService a() {
            ISkillCredentialService r3 = f18934c;
            if (r3 == null) goto L5;
            return r3;
        L5:
            Object r4 = f18933b;
            monitor-enter(r4);
            ISkillCredentialService r0 = f18934c;     // Catch: Throwable -> L16
            if (r0 != null) goto L14;
            r0 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ISkillCredentialService.class), ISkillCredentialService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r0 == null) goto L13;
            f18934c = r0;     // Catch: Throwable -> L16
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

    /* JADX INFO: compiled from: ISkillCredentialService.kt */
    public interface d {
        Object a(f r1, String r2, long r3, d.c.d<? super d.n<g>> r5);

        Object a(String r1, d.c.d<? super d.n<x>> r2);
    }

    /* JADX INFO: compiled from: ISkillCredentialService.kt */
    public interface e {
        Object a(f r1, String r2, d.c.d<? super d.n<x>> r3);

        Object a(String r1, d.c.d<? super d.n<? extends Map<String, String>>> r2);

        Object b(String r1, d.c.d<? super d.n<x>> r2);
    }

    static {
        Companion = c.f18932a;
    }

    a getAccount();

    b getApps();

    d getSessions();

    e getTaskSessions();
}
