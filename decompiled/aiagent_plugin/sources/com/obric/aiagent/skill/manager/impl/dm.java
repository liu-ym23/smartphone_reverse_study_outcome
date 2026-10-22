package com.obric.aiagent.skill.manager.impl;

import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.IAppContext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillOperationBoundary.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<com.obric.aiagent.skill.manager.api.r> f19748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<com.obric.aiagent.ttnet.k> f19749b = null;

    /* JADX INFO: compiled from: SkillOperationBoundary.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19750a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19751b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f19752c = null;

        static {
            int[] r0 = new int[fq.values().length];
            r0[fq.f19908a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L61:
            r0[fq.f19909b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L71:
            r0[fq.f19910c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L8:
            f19750a = r0;
            int[] r1 = new int[di.values().length];
            r1[di.f19743a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L63:
            r1[di.f19744b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L73:
            r1[di.f19745c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L43:
            r1[di.f19746d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L49:
            r1[di.f19747e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L16:
            f19751b = r1;
            int[] r2 = new int[com.obric.aiagent.ttnet.k.values().length];
            r2[com.obric.aiagent.ttnet.k.f22276a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L45:
            r2[com.obric.aiagent.ttnet.k.f22277b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L51:
            r2[com.obric.aiagent.ttnet.k.f22278c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L57:
            r2[com.obric.aiagent.ttnet.k.f22279d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L65:
            r2[com.obric.aiagent.ttnet.k.f22280e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L47:
            r2[com.obric.aiagent.ttnet.k.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L59:
            r2[com.obric.aiagent.ttnet.k.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L69:
            r2[com.obric.aiagent.ttnet.k.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L25:
            f19752c = r2;
        }
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.u.a a(Exception r0, String r1, com.obric.aiagent.skill.manager.api.r r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ com.obric.aiagent.skill.manager.api.u.a a(com.obric.aiagent.skill.manager.api.r r0, String r1, boolean r2, String r3, com.obric.aiagent.skill.manager.api.s r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 16) == 0) goto L12;
        r4 = null;
    L12:
        return a(r0, r1, r2, r3, r4);
    }

    public static final com.obric.aiagent.skill.manager.api.u.a a(com.obric.aiagent.skill.manager.api.r r11, String r12, boolean r13, String r14, com.obric.aiagent.skill.manager.api.s r15) {
        d.h.b.o.e(r11, MonitorConstants.CODE);
        d.h.b.o.e(r12, "operation");
        d.h.b.o.e(r14, "reason");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{r12, r14}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L9;
        Object r2 = r17.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return new com.obric.aiagent.skill.manager.api.u.a(r11, r13, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null), r15);
    }

    private static final com.obric.aiagent.skill.manager.api.u.a b(Exception r9, String r10, com.obric.aiagent.skill.manager.api.r r11) {
        if (ZeusTransformUtils.instanceOf(r9, dh.class) == true) goto L5;
        String r0 = r9.getMessage();
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        String r1 = r0.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r1, "toLowerCase(...)");
        if (ZeusTransformUtils.instanceOf(r9, bi.class) == false) goto L13;
        r11 = com.obric.aiagent.skill.manager.api.r.k;
    L136:
        return a(r11, r10, f19748a.contains(r11), "operation_failed", a(r9));
    L13:
        if (ZeusTransformUtils.instanceOf(r9, bo.class) == false) goto L16;
        r11 = com.obric.aiagent.skill.manager.api.r.m;
        goto L136
    L16:
        if (ZeusTransformUtils.instanceOf(r9, em.class) == false) goto L19;
        r11 = com.obric.aiagent.skill.manager.api.r.j;
        goto L136
    L19:
        if (ZeusTransformUtils.instanceOf(r9, cd.class) == false) goto L22;
        r11 = com.obric.aiagent.skill.manager.api.r.f19302c;
        goto L136
    L22:
        if (ZeusTransformUtils.instanceOf(r9, dj.class) == false) goto L25;
        r11 = com.obric.aiagent.skill.manager.api.r.f19300a;
        goto L136
    L25:
        if (ZeusTransformUtils.instanceOf(r9, dl.class) == false) goto L28;
        r11 = com.obric.aiagent.skill.manager.api.r.f19301b;
        goto L136
    L28:
        if (ZeusTransformUtils.instanceOf(r9, dk.class) == false) goto L31;
        r11 = com.obric.aiagent.skill.manager.api.r.f19303d;
        goto L136
    L31:
        if (ZeusTransformUtils.instanceOf(r9, ha.class) == false) goto L34;
        r11 = com.obric.aiagent.skill.manager.api.r.f19301b;
        goto L136
    L34:
        if (ZeusTransformUtils.instanceOf(r9, bu.class) == false) goto L39;
        if (d.h.b.o.a(((bu) ZeusTransformUtils.preCheckCast(r9, bu.class, "com.obric.aiagent.plugin")).a(), bt.p.f19608a) == false) goto L39;
        r11 = com.obric.aiagent.skill.manager.api.r.f19300a;
    L39:
        if (ZeusTransformUtils.instanceOf(r9, bu.class) == false) goto L42;
        r11 = com.obric.aiagent.skill.manager.api.r.l;
        goto L136
    L42:
        if (ZeusTransformUtils.instanceOf(r9, dq.class) == false) goto L45;
        r11 = com.obric.aiagent.skill.manager.api.r.l;
        goto L136
    L45:
        if (ZeusTransformUtils.instanceOf(r9, Cdo.class) == false) goto L48;
        r11 = com.obric.aiagent.skill.manager.api.r.m;
        goto L136
    L48:
        if (ZeusTransformUtils.instanceOf(r9, dn.class) == false) goto L53;
        if (((dn) ZeusTransformUtils.preCheckCast(r9, dn.class, "com.obric.aiagent.plugin")).a() != com.obric.aiagent.ttnet.k.f22279d) goto L53;
        r11 = com.obric.aiagent.skill.manager.api.r.l;
    L53:
        if (ZeusTransformUtils.instanceOf(r9, dn.class) == false) goto L58;
        if (f19749b.contains(((dn) ZeusTransformUtils.preCheckCast(r9, dn.class, "com.obric.aiagent.plugin")).a()) == false) goto L58;
        r11 = com.obric.aiagent.skill.manager.api.r.f19300a;
    L58:
        if (ZeusTransformUtils.instanceOf(r9, dn.class) == false) goto L63;
        if (((dn) ZeusTransformUtils.preCheckCast(r9, dn.class, "com.obric.aiagent.plugin")).a() != com.obric.aiagent.ttnet.k.g) goto L63;
        r11 = com.obric.aiagent.skill.manager.api.r.o;
    L63:
        if (ZeusTransformUtils.instanceOf(r9, dn.class) == false) goto L65;
        r11 = com.obric.aiagent.skill.manager.api.r.n;
        goto L136
    L65:
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r9, fp.class) == false) goto L78;
        int r12 = a.f19750a[((fp) ZeusTransformUtils.preCheckCast(r9, fp.class, "com.obric.aiagent.plugin")).a().ordinal()];
        if (r12 == 1) goto L76;
        if (r12 != 2) goto L71;
        r11 = com.obric.aiagent.skill.manager.api.r.n;
        goto L136
    L71:
        if (r12 != 3) goto L74;
        r11 = com.obric.aiagent.skill.manager.api.r.m;
        goto L136
    L74:
        throw new d.k();
    L76:
        r11 = com.obric.aiagent.skill.manager.api.r.m;
        goto L136
    L78:
        if (ZeusTransformUtils.instanceOf(r9, UnknownHostException.class) == false) goto L80;
    L134:
        r11 = com.obric.aiagent.skill.manager.api.r.n;
        goto L136
    L80:
        if (ZeusTransformUtils.instanceOf(r9, SocketException.class) == true) goto L134;
        if (ZeusTransformUtils.instanceOf(r9, SecurityException.class) == false) goto L86;
        r11 = com.obric.aiagent.skill.manager.api.r.j;
        goto L136
    L86:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("not found", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L88;
    L133:
        r11 = com.obric.aiagent.skill.manager.api.r.f19301b;
        goto L136
    L88:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("not installed", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L133;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("cannot be edited", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L93;
    L132:
        r11 = com.obric.aiagent.skill.manager.api.r.f19303d;
        goto L136
    L93:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("cannot be deleted", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L132;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("non-removable", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L132;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("already exists", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L100;
    L131:
        r11 = com.obric.aiagent.skill.manager.api.r.f19302c;
        goto L136
    L100:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("already installed", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L131;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("conflict", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L131;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("downgrade", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L131;
        if (ZeusTransformUtils.instanceOf(r9, IllegalArgumentException.class) == false) goto L118;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("package", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L111;
    L116:
        r11 = com.obric.aiagent.skill.manager.api.r.l;
        goto L136
    L111:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("zip", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L116;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("skill.md", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L116;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("manifest", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L116;
    L118:
        if (ZeusTransformUtils.instanceOf(r9, IllegalArgumentException.class) == false) goto L121;
        r11 = com.obric.aiagent.skill.manager.api.r.f19300a;
        goto L136
    L121:
        if (ZeusTransformUtils.instanceOf(r9, IOException.class) == false) goto L136;
        if (r11 == com.obric.aiagent.skill.manager.api.r.q) goto L126;
        r3 = false;
    L126:
        if (r3 == false) goto L129;
        r11 = null;
    L129:
        if (r11 != null) goto L136;
        r11 = com.obric.aiagent.skill.manager.api.r.o;
        goto L136
    L5:
        return a(r10, ((dh) ZeusTransformUtils.preCheckCast(r9, dh.class, "com.obric.aiagent.plugin")).a());
    }

    private static final com.obric.aiagent.skill.manager.api.s a(Exception r2) {
        if (ZeusTransformUtils.instanceOf(r2, bo.class) == false) goto L6;
        return a(com.obric.aiagent.skill.manager.api.t.f19308a, "This Skill is disabled by policy");
    L6:
        if (ZeusTransformUtils.instanceOf(r2, cd.class) == false) goto L9;
        return a(com.obric.aiagent.skill.manager.api.t.f19312e, "A Skill with the same name already exists");
    L9:
        if (ZeusTransformUtils.instanceOf(r2, dj.class) == false) goto L12;
        return a(com.obric.aiagent.skill.manager.api.t.f, "SKILL.md name cannot be changed after installation");
    L12:
        if (ZeusTransformUtils.instanceOf(r2, dl.class) == false) goto L15;
        return a(com.obric.aiagent.skill.manager.api.t.g, "The Skill is not installed");
    L15:
        if (ZeusTransformUtils.instanceOf(r2, dk.class) == false) goto L18;
        return a(com.obric.aiagent.skill.manager.api.t.h, "This Skill cannot be edited");
    L18:
        if (ZeusTransformUtils.instanceOf(r2, em.class) == false) goto L21;
        return a(com.obric.aiagent.skill.manager.api.t.n, "The Skill is blocked by security policy");
    L21:
        if (ZeusTransformUtils.instanceOf(r2, ha.class) == false) goto L24;
        return a(com.obric.aiagent.skill.manager.api.t.u, "The Skill was not found in the Skill Store");
    L24:
        if (ZeusTransformUtils.instanceOf(r2, bu.class) == false) goto L27;
        return a(((bu) ZeusTransformUtils.preCheckCast(r2, bu.class, "com.obric.aiagent.plugin")).a());
    L27:
        if (ZeusTransformUtils.instanceOf(r2, dq.class) == false) goto L30;
        return a(com.obric.aiagent.skill.manager.api.t.V, "Skill package SHA-256 does not match expected_sha256");
    L30:
        if (ZeusTransformUtils.instanceOf(r2, Cdo.class) == false) goto L33;
        return a(com.obric.aiagent.skill.manager.api.t.o, "Skill package download service is unavailable");
    L33:
        if (ZeusTransformUtils.instanceOf(r2, dn.class) == false) goto L36;
        return a((dn) ZeusTransformUtils.preCheckCast(r2, dn.class, "com.obric.aiagent.plugin"));
    L36:
        if (ZeusTransformUtils.instanceOf(r2, fp.class) == true) goto L51;
        return null;
    L51:
        return a((fp) ZeusTransformUtils.preCheckCast(r2, fp.class, "com.obric.aiagent.plugin"));
    }

    public static final com.obric.aiagent.skill.manager.api.u.a a(String r8, di r9) {
        d.h.b.o.e(r8, "operation");
        d.h.b.o.e(r9, "failure");
        int r0 = a.f19751b[r9.ordinal()];
        boolean r5 = true;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L12;
        if (r0 == 4) goto L11;
        if (r0 != 5) goto L10;
        com.obric.aiagent.skill.manager.api.r r1 = com.obric.aiagent.skill.manager.api.r.i;
    L15:
        int r6 = a.f19751b[r9.ordinal()];
        if (r6 == 1) goto L27;
        if (r6 == 2) goto L26;
        if (r6 == 3) goto L25;
        if (r6 == 4) goto L24;
        if (r6 != 5) goto L23;
        com.obric.aiagent.skill.manager.api.s r2 = a(com.obric.aiagent.skill.manager.api.t.m, "The Skill security status could not be refreshed");
    L29:
        if (r9 == di.f19747e) goto L33;
        r5 = false;
    L33:
        return a(r1, r8, r5, "security_modification_blocked", r2);
    L23:
        throw new d.k();
    L24:
        r2 = a(com.obric.aiagent.skill.manager.api.t.l, "The Skill security result is unavailable");
        goto L29
    L25:
        r2 = a(com.obric.aiagent.skill.manager.api.t.k, "Security scanning failed for the current Skill version");
        goto L29
    L26:
        r2 = a(com.obric.aiagent.skill.manager.api.t.i, "The Skill security scan is still in progress");
        goto L29
    L27:
        r2 = a(com.obric.aiagent.skill.manager.api.t.j, "Security scanning has not started for the current Skill version");
        goto L29
    L10:
        throw new d.k();
    L11:
        r1 = com.obric.aiagent.skill.manager.api.r.h;
        goto L15
    L12:
        r1 = com.obric.aiagent.skill.manager.api.r.g;
        goto L15
    L13:
        r1 = com.obric.aiagent.skill.manager.api.r.f19304e;
        goto L15
    L14:
        r1 = com.obric.aiagent.skill.manager.api.r.f;
        goto L15
    }

    private static final com.obric.aiagent.skill.manager.api.s a(dn r4) {
        switch(a.f19752c[r4.a().ordinal()]) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L27;
            case 4: goto L14;
            case 5: goto L8;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L22;
            default: goto L5;
        };
    L8:
        com.obric.aiagent.skill.manager.api.t r0 = com.obric.aiagent.skill.manager.api.t.r;
        Integer r5 = r4.c();
        if (r5 == null) goto L12;
        String r6 = "Skill package download failed with HTTP " + ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r6 == null) goto L12;
    L24:
        return a(r0, r6);
    L12:
        r6 = "Skill package download failed with an HTTP error";
        goto L24
    L14:
        Long r7 = r4.b();
        if (r7 == null) goto L26;
        com.obric.aiagent.skill.manager.api.s r8 = a(com.obric.aiagent.skill.manager.api.t.A, "Skill package exceeds the " + a(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue()) + " size limit");
        if (r8 == null) goto L26;
        return r8;
    L26:
        return a(com.obric.aiagent.skill.manager.api.t.s, "Skill package download failed");
    L5:
        throw new d.k();
    L22:
        return a(com.obric.aiagent.skill.manager.api.t.t, "Skill package download failed while saving the file");
    L23:
        return a(com.obric.aiagent.skill.manager.api.t.s, "Skill package download failed because of a network error");
    L27:
        return a(com.obric.aiagent.skill.manager.api.t.q, "Skill package download exceeded the redirect limit");
    L21:
        return a(com.obric.aiagent.skill.manager.api.t.p, "Skill package URL is not allowed");
    }

    private static final com.obric.aiagent.skill.manager.api.s a(fp r1) {
        fq r2 = r1.a();
        int r3 = a.f19750a[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return a(com.obric.aiagent.skill.manager.api.t.x, "Skill Store returned an invalid response");
    L10:
        throw new d.k();
    L15:
        return a(com.obric.aiagent.skill.manager.api.t.w, "Skill Store request failed because of a network error");
    L13:
        return a(com.obric.aiagent.skill.manager.api.t.v, "Skill Store service is unavailable");
    }

    private static final com.obric.aiagent.skill.manager.api.s a(bt r6) {
        if (d.h.b.o.a(r6, bt.g.f19599a) == false) goto L6;
        return a(com.obric.aiagent.skill.manager.api.t.z, "Skill package file is unavailable");
    L6:
        if (ZeusTransformUtils.instanceOf(r6, bt.w.class) == false) goto L9;
        return a(com.obric.aiagent.skill.manager.api.t.A, "Skill package exceeds the " + a(((bt.w) ZeusTransformUtils.preCheckCast(r6, bt.w.class, "com.obric.aiagent.plugin")).b()) + " size limit");
    L9:
        if (ZeusTransformUtils.instanceOf(r6, bt.v.class) == false) goto L12;
        return a(com.obric.aiagent.skill.manager.api.t.B, "SKILL.md exceeds the " + a(((bt.v) ZeusTransformUtils.preCheckCast(r6, bt.v.class, "com.obric.aiagent.plugin")).b()) + " size limit");
    L12:
        if (ZeusTransformUtils.instanceOf(r6, bt.aa.class) == false) goto L15;
        return a(com.obric.aiagent.skill.manager.api.t.C, "A ZIP entry exceeds the " + a(((bt.aa) ZeusTransformUtils.preCheckCast(r6, bt.aa.class, "com.obric.aiagent.plugin")).b()) + " size limit");
    L15:
        if (ZeusTransformUtils.instanceOf(r6, bt.ab.class) == false) goto L18;
        return a(com.obric.aiagent.skill.manager.api.t.D, "Extracted Skill package exceeds the " + a(((bt.ab) ZeusTransformUtils.preCheckCast(r6, bt.ab.class, "com.obric.aiagent.plugin")).b()) + " size limit");
    L18:
        if (ZeusTransformUtils.instanceOf(r6, bt.ac.class) == false) goto L21;
        return a(com.obric.aiagent.skill.manager.api.t.E, "Skill package contains more than " + ((bt.ac) ZeusTransformUtils.preCheckCast(r6, bt.ac.class, "com.obric.aiagent.plugin")).b() + " entries");
    L21:
        if (d.h.b.o.a(r6, bt.l.f19604a) == false) goto L24;
        return a(com.obric.aiagent.skill.manager.api.t.F, "Skill package is not a valid ZIP archive");
    L24:
        if (d.h.b.o.a(r6, bt.y.f19617a) == false) goto L27;
        return a(com.obric.aiagent.skill.manager.api.t.G, "Skill package contains an unsafe ZIP path");
    L27:
        if (d.h.b.o.a(r6, bt.f.f19598a) == false) goto L30;
        return a(com.obric.aiagent.skill.manager.api.t.H, "Skill package contains duplicate ZIP entries");
    L30:
        if (d.h.b.o.a(r6, bt.x.f19616a) == false) goto L33;
        return a(com.obric.aiagent.skill.manager.api.t.I, "This Skill package must be installed from the Skill Store");
    L33:
        if (d.h.b.o.a(r6, bt.n.f19606a) == false) goto L36;
        return a(com.obric.aiagent.skill.manager.api.t.f19307J, "Skill package does not contain SKILL.md");
    L36:
        if (d.h.b.o.a(r6, bt.o.f19607a) == false) goto L39;
        return a(com.obric.aiagent.skill.manager.api.t.K, "Skill package contains multiple SKILL.md files");
    L39:
        if (d.h.b.o.a(r6, bt.k.f19603a) == false) goto L42;
        return a(com.obric.aiagent.skill.manager.api.t.L, "SKILL.md must be at the ZIP root or one top-level directory");
    L42:
        if (ZeusTransformUtils.instanceOf(r6, bt.u.class) == false) goto L45;
        return a(com.obric.aiagent.skill.manager.api.t.M, "SKILL.md content exceeds " + ((bt.u) ZeusTransformUtils.preCheckCast(r6, bt.u.class, "com.obric.aiagent.plugin")).b() + " characters");
    L45:
        if (d.h.b.o.a(r6, bt.h.f19600a) == false) goto L48;
        return a(com.obric.aiagent.skill.manager.api.t.N, "SKILL.md must start with YAML frontmatter");
    L48:
        if (d.h.b.o.a(r6, bt.i.f19601a) == false) goto L51;
        return a(com.obric.aiagent.skill.manager.api.t.O, "SKILL.md frontmatter is not closed");
    L51:
        if (ZeusTransformUtils.instanceOf(r6, bt.e.class) == false) goto L54;
        com.obric.aiagent.skill.manager.api.t r0 = com.obric.aiagent.skill.manager.api.t.P;
        StringBuilder r1 = new StringBuilder().append("SKILL.md frontmatter defines ");
        String r7 = ((bt.e) ZeusTransformUtils.preCheckCast(r6, bt.e.class, "com.obric.aiagent.plugin")).b().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r7, "toLowerCase(...)");
        return a(r0, r1.append(r7).append(" more than once").toString());
    L54:
        if (d.h.b.o.a(r6, bt.q.f19609a) == false) goto L57;
        return a(com.obric.aiagent.skill.manager.api.t.Q, "SKILL.md frontmatter requires a non-empty name");
    L57:
        if (d.h.b.o.a(r6, bt.p.f19608a) == false) goto L60;
        return a(com.obric.aiagent.skill.manager.api.t.R, "Skill name does not meet the required format");
    L60:
        if (d.h.b.o.a(r6, bt.c.f19595a) == false) goto L63;
        return a(com.obric.aiagent.skill.manager.api.t.S, "SKILL.md frontmatter requires a non-empty description");
    L63:
        if (d.h.b.o.a(r6, bt.b.f19594a) == false) goto L66;
        return a(com.obric.aiagent.skill.manager.api.t.T, "SKILL.md requires a non-empty body");
    L66:
        if (d.h.b.o.a(r6, bt.t.f19612a) == false) goto L69;
        return a(com.obric.aiagent.skill.manager.api.t.U, "Skill package could not be processed");
    L69:
        if (d.h.b.o.a(r6, bt.s.f19611a) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r6, bt.z.class) == true) goto L86;
        if (d.h.b.o.a(r6, bt.m.f19605a) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r6, bt.a.class) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r6, bt.r.class) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r6, bt.d.class) == true) goto L86;
        if (d.h.b.o.a(r6, bt.j.f19602a) == true) goto L86;
        throw new d.k();
    L86:
        return a(com.obric.aiagent.skill.manager.api.t.W, "Skill package is invalid");
    }

    private static final com.obric.aiagent.skill.manager.api.s a(com.obric.aiagent.skill.manager.api.t r1, String r2) {
        return new com.obric.aiagent.skill.manager.api.s(r1, r2);
    }

    private static final String a(long r7) {
        if (r7 < DownloadConstants.GB) goto L8;
        if ((r7 % DownloadConstants.GB) != 0) goto L8;
        return (r7 / DownloadConstants.GB) + " GB";
    L8:
        if (r7 < 1048576) goto L13;
        if ((r7 % 1048576) != 0) goto L13;
        return (r7 / 1048576) + " MB";
    L13:
        if (r7 < 1024) goto L18;
        if ((r7 % 1024) != 0) goto L18;
        return (r7 / 1024) + " KB";
    L18:
        return r7 + " B";
    }

    public static final void a(String r4, com.obric.aiagent.skill.manager.api.r r5, Throwable r6) {
        d.h.b.o.e(r4, "operation");
        d.h.b.o.e(r5, MonitorConstants.CODE);
        d.h.b.o.e(r6, WsConstants.KEY_CONNECTION_ERROR);
        if (IAppContext.Companion.isDebug() == false) goto L5;
        a("SkillManager", "operation=" + r4 + " failed code=" + r5, r6);
        return;
    L5:
        a("SkillManager", "operation=" + r4 + " failed code=" + r5);
    }

    static {
        f19748a = d.a.ax.a(new com.obric.aiagent.skill.manager.api.r[]{com.obric.aiagent.skill.manager.api.r.m, com.obric.aiagent.skill.manager.api.r.n, com.obric.aiagent.skill.manager.api.r.o, com.obric.aiagent.skill.manager.api.r.p, com.obric.aiagent.skill.manager.api.r.q});
        f19749b = d.a.ax.a(new com.obric.aiagent.ttnet.k[]{com.obric.aiagent.ttnet.k.f22276a, com.obric.aiagent.ttnet.k.f22277b, com.obric.aiagent.ttnet.k.f22278c});
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
