package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: InstalledSkillInteractionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentActivity f20780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<ISkillManagerService> f20781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<d.x> f20782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.m<com.obric.aiagent.skill.manager.api.e, d.h.a.a<d.x>, d.x> f20783d;

    /* JADX INFO: renamed from: lambda$-pAAuOIOTOaOs_P-cyxRIvwmuqo, reason: not valid java name */
    public static /* synthetic */ d.x m344lambda$pAAuOIOTOaOs_PcyxRIvwmuqo(g r0, com.obric.aiagent.skill.manager.api.e r1) {
        return a(r0, r1);
    }

    public g(FragmentActivity r3, d.h.a.a<? extends ISkillManagerService> r4, d.h.a.a<d.x> r5, d.h.a.m<? super com.obric.aiagent.skill.manager.api.e, ? super d.h.a.a<d.x>, d.x> r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a<ISkillManagerService> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.m<com.obric.aiagent.skill.manager.api.e, d.h.a.a<d.x>, d.x> r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "activity");
        d.h.b.o.e(r8, "skillManagerProvider");
        d.h.b.o.e(r9, "refresh");
        this.f20780a = r7;
        this.f20781b = r8;
        this.f20782c = r9;
        this.f20783d = r10;
    }

    public /* synthetic */ g(FragmentActivity r2, d.h.a.a r3, d.h.a.a r4, d.h.a.m r5, int r6, d.h.b.h r7) {
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r11 = null;
    L5:
        this(r8, r9, r10, r11);
    }

    public final void a(final com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r3, "skill");
        if (com.obric.aiagent.skill.manager.impl.az.a(r3) == false) goto L6;
        a();
        return;
    L6:
        if (r3.l() == false) goto L11;
        d.h.a.m<com.obric.aiagent.skill.manager.api.e, d.h.a.a<d.x>, d.x> r0 = this.f20783d;
        if (r0 != null) goto L10;
        b(r3);
        return;
    L10:
        this.f20782c.invoke();
        r0.invoke(r3, new $$Lambda$g$pAAuOIOTOaOs_PcyxRIvwmuqo(this, r3));
        return;
    L11:
        c(r3);
    }

    private static final d.x a(g r0, com.obric.aiagent.skill.manager.api.e r1) {
        r0.b(r1);
        return d.x.f38692a;
    }

    public final void a() {
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20780a, Activity.class, "com.obric.aiagent.plugin"), cm.a.m);
        this.f20782c.invoke();
    }

    private final void b(com.obric.aiagent.skill.manager.api.e r7) {
        ISkillManagerService r1 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(this.f20781b.invoke(), ISkillManagerService.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        this.f20782c.invoke();
        return;
    L13:
        c("Disable installed skill requested", "Disable installed skill requested: slug=" + r7.a());     // Catch: Exception -> L10
        com.obric.aiagent.skill.manager.api.u<d.x> r2 = r1.setSkillEnabled(r7.a(), false);     // Catch: Exception -> L10
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L15;
        d("Disable installed skill failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Disable installed skill failed: slug=" + r7.a() + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L10
        this.f20782c.invoke();     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        b("Disable installed skill failed", "Disable installed skill failed: slug=" + r7.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        this.f20782c.invoke();
    }

    private final void c(com.obric.aiagent.skill.manager.api.e r7) {
        ISkillManagerService r1 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(this.f20781b.invoke(), ISkillManagerService.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        this.f20782c.invoke();
        return;
    L19:
        c("Enable installed skill requested", "Enable installed skill requested: slug=" + r7.a());     // Catch: Exception -> L13
        com.obric.aiagent.skill.manager.api.u<d.x> r2 = r1.setSkillEnabled(r7.a(), true);     // Catch: Exception -> L13
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L21;
        d("Enable installed skill failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Enable installed skill failed: slug=" + r7.a() + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L13
        com.obric.aiagent.skill.manager.impl.bh r3 = com.obric.aiagent.skill.manager.impl.az.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L13
        if (r3 == null) goto L11;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20780a, Activity.class, "com.obric.aiagent.plugin"), r3);     // Catch: Exception -> L13
    L11:
        this.f20782c.invoke();     // Catch: Exception -> L13
        return;
    L21:
        return;
    L13:
        e = move-exception;
        b("Enable installed skill failed", "Enable installed skill failed: slug=" + r7.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.manager.impl.bh r8 = com.obric.aiagent.skill.manager.impl.az.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L17;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20780a, Activity.class, "com.obric.aiagent.plugin"), r8);
    L17:
        this.f20782c.invoke();
    }

    private final void c(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        a("SkillManager", r1);
    }

    private final void d(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        b("SkillManager", r1);
    }

    private final void b(String r2, String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        a("SkillManager", r3, r4);
        return;
    L5:
        b("SkillManager", r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
