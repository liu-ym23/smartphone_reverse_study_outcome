package com.obric.aiagent.skill.manager.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ISkillSettingsService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: SkillSettings.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f19149a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f19150b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile ISkillSettingsService f19151c;

        private a() {
        }

        static {
            f19149a = new a();
            f19150b = new Object();
        }

        public final ISkillSettingsService a() {
            ISkillSettingsService r3 = f19151c;
            if (r3 == null) goto L5;
            return r3;
        L5:
            Object r4 = f19150b;
            monitor-enter(r4);
            ISkillSettingsService r0 = f19151c;     // Catch: Throwable -> L16
            if (r0 != null) goto L14;
            r0 = (ISkillSettingsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ISkillSettingsService.class), ISkillSettingsService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r0 == null) goto L13;
            f19151c = r0;     // Catch: Throwable -> L16
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

    static {
        Companion = a.f19149a;
    }

    al getSettings();
}
