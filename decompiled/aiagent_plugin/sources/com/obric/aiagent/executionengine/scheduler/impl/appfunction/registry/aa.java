package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.api.aq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppFunctionSkillManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class aa {
    private static final String TAG = "AppFunctionSkillSync";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f18198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f18199b = null;

    /* JADX INFO: compiled from: AppFunctionSkillManager.kt */
    @d.c.b.a.f(b = "AppFunctionSkillManager.kt", c = {107}, d = "sync", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionSkillManager")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18204e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        /* synthetic */ Object m;
        final /* synthetic */ aa n;
        int o;

        a(aa r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.n = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.m = r3;
            this.o |= Integer.MIN_VALUE;
            return this.n.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private aa() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x03e9 -> B:106:0x04cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x0438 -> B:96:0x043e). Please report as a decompilation issue!!! */
    public final Object a(List<ad> r22, d.c.d<? super d.x> r23) {
        String r2 = "com.obric.aiagent.plugin";
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        if ((r4.o & Integer.MIN_VALUE) == 0) goto L7;
        r4.o -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.m;
        Object r6 = d.c.a.b.a();
        int r7 = r4.o;
        String r9 = TAG;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        com.obric.aiagent.skill.manager.api.e r0 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r4.l, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.k, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c r10 = (com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c) ZeusTransformUtils.preCheckCast(r4.j, com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c.class, "com.obric.aiagent.plugin");
        Iterator r11 = (Iterator) ZeusTransformUtils.preCheckCast(r4.i, Iterator.class, "com.obric.aiagent.plugin");
        File r12 = (File) ZeusTransformUtils.preCheckCast(r4.h, File.class, "com.obric.aiagent.plugin");
        d.h.b.z.d r13 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r4.g, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        d.h.b.z.d r14 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r4.f, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        d.h.b.z.d r15 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r4.f18204e, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        d.h.b.z.d r16 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r4.f18203d, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        d.h.b.z.d r17 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r4.f18202c, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(r4.f18201b, Map.class, "com.obric.aiagent.plugin");
        ISkillManagerService r19 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(r4.f18200a, ISkillManagerService.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14
        String r110 = "com.obric.aiagent.plugin";
        Object r111 = r6;
        String r20 = r8;
        Map r21 = r18;
        String r112 = TAG;
        Object r24 = r5;
        ISkillManagerService r25 = r19;
        com.obric.aiagent.skill.manager.api.e r26 = r0;
    L96:
        Map r27 = r21;
        String r28 = r110;
        com.obric.aiagent.skill.manager.api.u r29 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r24, com.obric.aiagent.skill.manager.api.u.class, r28);     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r29, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L103;
        if (r26 != null) goto L100;
        r17.f38502a++;     // Catch: Throwable -> L14
    L101:
        String r30 = r112;
    L105:
        Map r31 = r27;
        Object r32 = r111;
    L106:
        r2 = r28;
        r9 = r30;
        r25 = r25;
    L83:
        if (r11.hasNext() == false) goto L109;
        r10 = (com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c.class, r2);     // Catch: Throwable -> L14
        String r33 = r10.b();     // Catch: Throwable -> L14
        aa r113 = f18198a;     // Catch: Throwable -> L14
        r112 = r9;
        Object r114 = r32;
        com.obric.aiagent.skill.manager.api.e r34 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r31.get(r113.a(r10)), com.obric.aiagent.skill.manager.api.e.class, r2);     // Catch: Throwable -> L14
        if (r34 != null) goto L87;
    L89:
        if (r34 == null) goto L91;
        boolean r35 = true;
    L92:
        com.obric.aiagent.skill.manager.api.d r36 = r113.a(r10, r12, r35);     // Catch: Throwable -> L14
        r110 = r2;
        com.obric.aiagent.skill.manager.api.o r115 = new com.obric.aiagent.skill.manager.api.o(com.obric.aiagent.skill.manager.api.p.f19290a, null, 2, null);     // Catch: Throwable -> L14
        r4.f18200a = r25;     // Catch: Throwable -> L14
        r4.f18201b = r31;     // Catch: Throwable -> L14
        r4.f18202c = r17;     // Catch: Throwable -> L14
        r4.f18203d = r16;     // Catch: Throwable -> L14
        r4.f18204e = r15;     // Catch: Throwable -> L14
        r4.f = r14;     // Catch: Throwable -> L14
        r4.g = r13;     // Catch: Throwable -> L14
        r4.h = r12;     // Catch: Throwable -> L14
        r4.i = r11;     // Catch: Throwable -> L14
        r4.j = r10;     // Catch: Throwable -> L14
        r4.k = r33;     // Catch: Throwable -> L14
        r4.l = r34;     // Catch: Throwable -> L14
        r4.o = 1;     // Catch: Throwable -> L14
        r24 = r25.importSkill(r36, r115, r4);     // Catch: Throwable -> L14
        r111 = r114;
        if (r24 != r111) goto L95;
        return r111;
    L95:
        r21 = r31;
        r26 = r34;
        r20 = r33;
        goto L96
    L91:
        r35 = false;
        goto L92
    L87:
        if (r113.a(r34, r10) == false) goto L89;
        r14.f38502a++;     // Catch: Throwable -> L14
        r28 = r2;
        r32 = r114;
        r25 = r25;
        r30 = r112;
        goto L106
    L109:
        ILogDepend.Companion.i(r9, "sync done: added=" + r17.f38502a + ", updated=" + r16.f38502a + ", deleted=" + r15.f38502a + ", unchanged=" + r14.f38502a + ", failed=" + r13.f38502a);     // Catch: Throwable -> L14
        d.f.k.h(r12);
        return d.x.f38692a;
    L100:
        r16.f38502a++;     // Catch: Throwable -> L14
        goto L101
    L103:
        if (ZeusTransformUtils.instanceOf(r29, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L108;
        r13.f38502a++;     // Catch: Throwable -> L14
        r30 = r112;
        ILogDepend.Companion.e(r30, "import failed package=" + r10.a() + ", slug=" + r20 + ": code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r29, com.obric.aiagent.skill.manager.api.u.a.class, r28)).a() + ", diagnostic=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r29, com.obric.aiagent.skill.manager.api.u.a.class, r28)).c());     // Catch: Throwable -> L14
        goto L105
    L108:
        throw new d.k();     // Catch: Throwable -> L14
    L14:
        th = th;
    L114:
        d.f.k.h(r12);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r5);
        ILogDepend.Companion r37 = ILogDepend.Companion;
        StringBuilder r38 = new StringBuilder().append("sync start: entries=");
        Iterator r39 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r40 = 0;
    L20:
        if (r39.hasNext() == false) goto L22;
        r40 = r40 + ((ad) ZeusTransformUtils.preCheckCast(r39.next(), ad.class, "com.obric.aiagent.plugin")).b().size();
        goto L20
    L22:
        r37.i(TAG, r38.append(r40).append(", packages=").append(r1.size()).toString());
        r25 = ISkillManagerService.Companion.a();
        if (r25 != null) goto L26;
        aa r41 = (aa) ZeusTransformUtils.preCheckCast(this, aa.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "SkillManager service unavailable");
        return d.x.f38692a;
    L26:
        com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> r42 = r25.getInstalledSkills();
        if (ZeusTransformUtils.instanceOf(r42, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L117;
        Iterable r43 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r42, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r44 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r45 = r43.iterator();
    L30:
        if (r45.hasNext() == false) goto L34;
        Object r46 = r45.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r46, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).g(), aq.a.f19212a) == false) goto L30;
        r44.add(r46);
        goto L30
    L34:
        List r47 = (List) ZeusTransformUtils.preCheckCast(r44, List.class, "com.obric.aiagent.plugin");
        if (com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a.f16409a.a().b() == true) goto L46;
        Iterator r48 = ((Iterable) ZeusTransformUtils.preCheckCast(r47, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L38:
        if (r48.hasNext() == false) goto L45;
        com.obric.aiagent.skill.manager.api.e r49 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r48.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion r50 = ILogDepend.Companion;
        StringBuilder r51 = new StringBuilder().append("enableKDoc=false, remove omni AppFunction skills:");
        com.obric.aiagent.skill.manager.api.a r52 = r49.h();
        if (r52 == null) goto L42;
        String r53 = r52.a();
    L43:
        r50.d(TAG, r51.append(r53).toString());
        f18198a.a(r25, r49);
        goto L38
    L42:
        r53 = null;
        goto L43
    L45:
        return d.x.f38692a;
    L46:
        Iterable r54 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r55 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r56 = r54.iterator();
    L48:
        if (r56.hasNext() == false) goto L54;
        ad r57 = (ad) ZeusTransformUtils.preCheckCast(r56.next(), ad.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c r58 = y.f18329a.a(r57);
        if (r58 != null) goto L52;
        ILogDepend.Companion.w(TAG, "Skill.md validation failed, package=" + r57.a());
    L52:
        if (r58 == null) goto L48;
        r55.add(r58);
        goto L48
    L54:
        List r59 = (List) ZeusTransformUtils.preCheckCast(r55, List.class, "com.obric.aiagent.plugin");
        Iterable r60 = (Iterable) ZeusTransformUtils.preCheckCast(r59, Iterable.class, "com.obric.aiagent.plugin");
        Collection r61 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r60, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r62 = r60.iterator();
    L56:
        if (r62.hasNext() == false) goto L58;
        r61.add(f18198a.a((com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c) ZeusTransformUtils.preCheckCast(r62.next(), com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c.class, "com.obric.aiagent.plugin")));
        goto L56
    L58:
        Set r63 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r61, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        Iterable r64 = (Iterable) ZeusTransformUtils.preCheckCast(r47, Iterable.class, "com.obric.aiagent.plugin");
        Collection r65 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r66 = r64.iterator();
    L60:
        if (r66.hasNext() == false) goto L67;
        com.obric.aiagent.skill.manager.api.e r116 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r66.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        z r117 = f18198a.a(r116);
        if (r117 == null) goto L64;
        d.m r118 = d.s.a(r117, r116);
    L65:
        if (r118 == null) goto L60;
        r65.add(r118);
        goto L60
    L64:
        r118 = null;
        goto L65
    L67:
        Map r67 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r65, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        d.h.b.z.d r68 = new d.h.b.z.d();
        d.h.b.z.d r119 = new d.h.b.z.d();
        d.h.b.z.d r120 = new d.h.b.z.d();
        d.h.b.z.d r121 = new d.h.b.z.d();
        r13 = new d.h.b.z.d();
        a r122 = r4;
        File r123 = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getCacheDir(), "app_function_skill_import_" + System.nanoTime());
        Iterator r69 = ((Iterable) ZeusTransformUtils.preCheckCast(r47, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L112
    L70:
        if (r69.hasNext() == false) goto L80;
        com.obric.aiagent.skill.manager.api.e r70 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r69.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L112
        aa r71 = f18198a;     // Catch: Throwable -> L112
        z r72 = r71.a(r70);     // Catch: Throwable -> L112
        if (r72 == null) goto L70;
        if (r63.contains(r72) == true) goto L70;
        if (r71.a(r25, r70) == true) goto L78;
        r13.f38502a++;     // Catch: Throwable -> L112
        goto L70
    L78:
        r120.f38502a++;     // Catch: Throwable -> L112
        goto L70
    L80:
        r16 = r119;
        r15 = r120;
        r17 = r68;
        r4 = r122;
        r32 = r6;
        r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r59, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L112
        r31 = r67;
        r14 = r121;
        r12 = r123;
    L112:
        th = th;
        r12 = r123;
        goto L114
    L117:
        if (ZeusTransformUtils.instanceOf(r42, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L121;
        ILogDepend.Companion.e(TAG, "SkillManager unavailable: " + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r42, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).c());
        return d.x.f38692a;
    L121:
        throw new d.k();
    L7:
        r4 = new a(this, r3);
        goto L8
    }

    private final boolean a(com.obric.aiagent.skill.manager.api.e r1, com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c r2) {
        com.obric.aiagent.skill.manager.api.a r0 = r1.h();
        if (r0 == null) goto L5;
        String r3 = r0.b();
    L7:
        return d.h.b.o.a(r3, r2.e());
    L5:
        r3 = null;
        goto L7
    }

    private final z a(com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c r2) {
        return new z(r2.b(), r2.a());
    }

    private final z a(com.obric.aiagent.skill.manager.api.e r2) {
        com.obric.aiagent.skill.manager.api.a r1 = r2.h();
        if (r1 == null) goto L9;
        String r3 = r1.a();
        if (r3 != null) goto L8;
        return null;
    L8:
        return new z(r2.a(), r3);
    L9:
        return null;
    }

    private final com.obric.aiagent.skill.manager.api.d a(com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c r6, File r7, boolean r8) {
        File r0 = new File(r7, r6.a());
        r0.mkdirs();
        d.f.k.a(new File(r0, "SKILL.md"), r6.c(), null, 2, null);
        File r9 = new File(r0, ".obric");
        r9.mkdirs();
        d.f.k.a(new File(r9, "manifest.json"), f18199b, null, 2, null);
        d.f.k.a(new File(r9, "tool-schema.txt"), r6.d(), null, 2, null);
        return new com.obric.aiagent.skill.manager.api.d(r0, a(r6.a()), r8, new com.obric.aiagent.skill.manager.api.b(new com.obric.aiagent.skill.manager.api.a(r6.a(), r6.e())));
    }

    private final String a(String r15) {
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        PackageManager r5 = r3.getPackageManager();     // Catch: Exception -> L49
        boolean r6 = false;
        long r7 = androidx.core.content.a.a.a(r5.getPackageInfo(r15, 0));     // Catch: Exception -> L49
        File r9 = new File(r3.getCacheDir(), "app_function_skill_icons");     // Catch: Exception -> L49
        if (r9.mkdirs() == false) goto L6;
    L9:
        File r10 = new File(r9, b(r15) + '_' + r7 + ".png");     // Catch: Exception -> L49
        if (r10.isFile() == true) goto L13;
    L16:
        Drawable r14 = r5.getApplicationIcon(r15);     // Catch: Exception -> L49
        d.h.b.o.c(r14, "getApplicationIcon(...)");     // Catch: Exception -> L49
        Integer r8 = Integer.valueOf(r14.getIntrinsicWidth());     // Catch: Exception -> L49
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L19;
        boolean r11 = true;
    L21:
        if (r11 == true) goto L24;
        r8 = null;
    L24:
        int r12 = 192;
        if (r8 == null) goto L27;
        int r13 = r8.intValue();     // Catch: Exception -> L49
    L28:
        Integer r16 = Integer.valueOf(r14.getIntrinsicHeight());     // Catch: Exception -> L49
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L31;
        r6 = true;
    L31:
        if (r6 == true) goto L34;
        r16 = null;
    L34:
        if (r16 == null) goto L36;
        r12 = r16.intValue();     // Catch: Exception -> L49
    L36:
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r10), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
        boolean r18 = androidx.core.graphics.drawable.b.a(r14, r13, r12, Bitmap.Config.ARGB_8888).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r17, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L44
        d.f.c.a(r17, null);     // Catch: Exception -> L49
        if (r18 == true) goto L42;
        r10.delete();     // Catch: Exception -> L49
        ILogDepend.Companion.w(TAG, "cache icon failed package=" + r15 + ": encode failed");     // Catch: Exception -> L49
        return "";
    L42:
        String r19 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.agent.fileprovider", r10, "com.obric.aiagent.plugin").toString();     // Catch: Exception -> L49
        d.h.b.o.a(r19);     // Catch: Exception -> L49
        return r19;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        d.f.c.a(r17, th);     // Catch: Exception -> L49
        throw th;     // Catch: Exception -> L49
    L27:
        r13 = 192;
        goto L28
    L19:
        r11 = false;
        goto L21
    L13:
        if (r10.length() <= 0) goto L16;
        String r110 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.agent.fileprovider", r10, "com.obric.aiagent.plugin").toString();     // Catch: Exception -> L49
        d.h.b.o.c(r110, "toString(...)");     // Catch: Exception -> L49
        return r110;
    L6:
        if (r9.isDirectory() == true) goto L9;
        ILogDepend.Companion.w(TAG, "cache icon failed package=" + r15 + ": create directory failed");     // Catch: Exception -> L49
        return "";
    L49:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "cache icon failed package=" + r15 + ": " + e.getMessage());
        return "";
    }

    private final String b(String r11) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.length()), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r10.length()) goto L16;
        char r2 = r10.charAt(r1);
        if (Character.isLetterOrDigit(r2) == true) goto L14;
        if (r2 == '.') goto L14;
        if (r2 == '_') goto L14;
        if (r2 == '-') goto L14;
        r2 = '_';
    L14:
        r12.add(Character.valueOf(r2));
        r1 = r1 + 1;
        goto L4
    L16:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    private final boolean a(ISkillManagerService r4, com.obric.aiagent.skill.manager.api.e r5) {
        com.obric.aiagent.skill.manager.api.u<d.x> r3 = ((ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin")).deleteSkill(r5.a());
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L10;
        ILogDepend.Companion.e(TAG, "delete failed slug=" + r5.a() + ": code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a() + ", diagnostic=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).c());
        return false;
    L10:
        throw new d.k();
    }

    static {
        f18198a = new aa();
        f18199b = "{\n  \"obric_skill_version\": 1,\n  \"is_secret\": false,\n  \"obric_skill_tool_schema\": \"tool-schema.txt\",\n  \"require_bins\": []\n}";
    }
}
