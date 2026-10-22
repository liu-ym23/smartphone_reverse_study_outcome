package com.obric.aiagent.skill.manager.api;

import android.os.Bundle;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ISkillManagerService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: SkillManagerContracts.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f19146a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f19147b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile ISkillManagerService f19148c;

        private a() {
        }

        static {
            f19146a = new a();
            f19147b = new Object();
        }

        public final ISkillManagerService a() {
            ISkillManagerService r3 = f19148c;
            if (r3 == null) goto L5;
            return r3;
        L5:
            Object r4 = f19147b;
            monitor-enter(r4);
            ISkillManagerService r0 = f19148c;     // Catch: Throwable -> L16
            if (r0 != null) goto L14;
            r0 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ISkillManagerService.class), ISkillManagerService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r0 == null) goto L13;
            f19148c = r0;     // Catch: Throwable -> L16
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
        Companion = a.f19146a;
    }

    Object applySkillChange(k r1, d.c.d<? super u<l>> r2);

    Object createSkill(m r1, o r2, d.c.d<? super u<e>> r3);

    u<d.x> deleteSkill(String r1);

    u<List<e>> getInstalledSkills();

    OSkillManagerConfig getSkillManagerConfig();

    String getSkillManagerStatus(String r1);

    Object importSkill(d r1, o r2, d.c.d<? super u<e>> r3);

    u<e> installSkill(String r1, String r2);

    u<e> installSkill(String r1, String r2, au r3);

    Object installSkillPackage(x r1, d.c.d<? super u<y>> r2);

    u<av> installStoreSkill(String r1, au r2);

    Object loadSkill(String r1, String r2, d.c.d<? super u<c>> r3);

    u<kotlinx.coroutines.b.ak<List<e>>> observeInstalledSkills();

    Object prepareInstalledSkillProjection(d.c.d<? super u<? extends aa>> r1);

    Object refreshSkillSignatures(ap r1, d.c.d<? super u<ao>> r2);

    u<e> saveSkill(e r1);

    u<e> saveSkillCover(String r1, String r2);

    u<d.x> setSkillEnabled(String r1, boolean r2);

    boolean setSkillManagerConfigValues(Bundle r1);
}
