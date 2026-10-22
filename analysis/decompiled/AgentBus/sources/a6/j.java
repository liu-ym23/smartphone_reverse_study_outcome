package a6;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import la.e0;
import la.j0;
import la.k0;

/* loaded from: classes.dex */
public final class j implements o {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f325a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f326b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f327c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f328d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f329e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f330f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f331g;

    /* renamed from: h, reason: collision with root package name */
    public volatile k f332h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicLong f333i;

    /* renamed from: j, reason: collision with root package name */
    public final j0 f334j;

    /* renamed from: k, reason: collision with root package name */
    public final e0 f335k;

    public j() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f329e = concurrentHashMap;
        this.f330f = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.f331g = concurrentHashMap2;
        this.f332h = new k();
        this.f333i = new AtomicLong(0L);
        j0 j0VarB = k0.b(0, 64, 5);
        this.f334j = j0VarB;
        this.f335k = new e0(j0VarB);
        long jCurrentTimeMillis = System.currentTimeMillis();
        z zVar = new z("code-review", "Code Review", "Reviews PR diffs and surfaces issues / suggestions", "1.2.0", d7.s.u0("dev", "github"), true, true, i.BUNDLED, Long.valueOf(jCurrentTimeMillis), d7.e0.T(new c7.j("openclaw.catalog_description", "AI code reviewer")));
        List listU0 = d7.s.u0("dev", "writing");
        i iVar = i.LOCAL;
        for (z zVar2 : d7.s.u0(zVar, new z("doc-writer", "Doc Writer", "Generates technical docs from source code", "0.9.1", listU0, true, true, iVar, Long.valueOf(jCurrentTimeMillis - 86400000), 512), new z("weather", "Weather", "Fetches weather for a city", "2.0.0", a.a.S("util"), false, false, i.REMOTE, Long.valueOf(jCurrentTimeMillis - 3600000), 512), new z("translator", "Translator", "Multi-lingual translator (zh / en / ja)", "1.0.5", d7.s.u0("util", "language"), true, true, iVar, Long.valueOf(jCurrentTimeMillis), 512))) {
            this.f325a.put(zVar2.f389a, zVar2);
        }
        concurrentHashMap2.put("code-review", "# Code Review\n\nReviews diffs.\n");
        concurrentHashMap2.put("doc-writer", "# Doc Writer\n\nGenerates docs.\n");
        concurrentHashMap2.put("translator", "# Translator\n\nzh / en / ja.\n");
        c0 c0Var = c0.CORE;
        i iVar2 = i.BUNDLED;
        b0 b0Var = new b0("shell.exec", "Shell Exec", "Execute shell command in sandbox", "core", (List) null, true, c0Var, "system", iVar2, (Long) null, 1552);
        b0 b0Var2 = new b0("fs.read", "File Read", "Read file from rootfs", "core", (List) null, true, c0Var, "system", iVar2, (Long) null, 1552);
        b0 b0Var3 = new b0("fs.write", "File Write", "Write file to rootfs", "core", (List) null, true, c0Var, "system", iVar2, (Long) null, 1552);
        c0 c0Var2 = c0.INSTALLED;
        i iVar3 = i.LOCAL;
        for (b0 b0Var4 : d7.s.u0(b0Var, b0Var2, b0Var3, new b0("git.commit", "Git Commit", "Stage + commit", "1.0.0", (List) null, true, c0Var2, "vcs", iVar3, (Long) null, 1552), new b0("http.fetch", "HTTP Fetch", "Fetch arbitrary URL", "1.1.0", (List) null, false, c0Var2, "network", iVar3, (Long) null, 1552))) {
            this.f326b.put(b0Var4.f284a, b0Var4);
        }
        d dVar = new d("morning-brief", "Morning Brief", "0 9 * * *", "main", true, false, Long.valueOf(3600000 + jCurrentTimeMillis), "Summarize yesterday's git activity");
        d dVar2 = new d("weekly-report", "Weekly Report", "0 10 * * 1", "main", true, false, Long.valueOf(432000000 + jCurrentTimeMillis), "Generate weekly status report");
        long j2 = jCurrentTimeMillis + 600000;
        for (d dVar3 : d7.s.u0(dVar, dVar2, new d("one-shot", "One-Shot Reminder", a1.a.h("@at:", j2), "reminders", false, true, Long.valueOf(j2), "Check on PR #42"))) {
            this.f327c.put(dVar3.f295a, dVar3);
        }
        for (b bVar : d7.s.u0(new b("feishu-default", "feishu:default", "Feishu (默认)", "configured", "1.0.0", d7.s.u0("im", "enterprise"), true, "Feishu bot 接入", 256), new b("discord-dev", "discord:dev", "Discord Dev Server", "credentials_missing", "0.8.2", d7.s.u0("im", "community"), false, "Discord webhook（需配 token）", 256))) {
            this.f328d.put(bVar.f275a, bVar);
        }
        concurrentHashMap.put(c.SOUL, "# Soul\nYou are a helpful assistant.\n");
        concurrentHashMap.put(c.AGENTS, "agents:\n  - id: main\n    name: Main\n");
        concurrentHashMap.put(c.USER, "name: Demo User\n");
        concurrentHashMap.put(c.MEMORY, "memories: []\n");
        concurrentHashMap.put(c.TOOLS, "# tools.md (placeholder)\n");
        concurrentHashMap.put(c.IDENTITY, "deviceId: demo-device\n");
    }

    @Override // a6.o
    public final Object A(String str, g7.d dVar) {
        I("config.backup", "imported", null);
        return new m(true, null, null, null, null, 28);
    }

    @Override // a6.o
    public final Object B(String str, w wVar, g7.d dVar) {
        if (((d) this.f327c.remove(str)) == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("job ", str), d7.a0.f2944f, 2);
        }
        I("cronjobs", "removed", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object C(h hVar, g7.d dVar) {
        String str = hVar.f319a;
        this.f326b.put(str, new b0(str, str, (String) null, hVar.f320b, (List) null, false, c0.INSTALLED, (String) null, hVar.f322d, new Long(System.currentTimeMillis()), 1204));
        String str2 = hVar.f319a;
        I("tools", "installed", str2);
        return new m(true, str2, null, null, null, 28);
    }

    @Override // a6.o
    public final Object D(String str, Map map, g7.d dVar) {
        if (!this.f328d.containsKey(str)) {
            return new m(false, null, "NOT_FOUND", a1.a.w("channel ", str), d7.a0.f2944f, 2);
        }
        I("channels", "configured", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object E(String str, w wVar, g7.d dVar) {
        return this.f331g.get(str);
    }

    @Override // a6.o
    public final Object F(int i2, String str, w wVar, g7.d dVar) {
        return d7.z.f2978f;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf  */
    @Override // a6.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(a6.y r7, a6.w r8, g7.d r9) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.j.G(a6.y, a6.w, g7.d):java.lang.Object");
    }

    @Override // a6.o
    public final Object H(c cVar, String str, w wVar, g7.d dVar) {
        this.f329e.put(cVar, str);
        String strName = cVar.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        q7.k.d(lowerCase, "toLowerCase(...)");
        I("files", "updated", lowerCase);
        String lowerCase2 = cVar.name().toLowerCase(locale);
        q7.k.d(lowerCase2, "toLowerCase(...)");
        return new m(true, lowerCase2, null, null, null, 28);
    }

    public final void I(String str, String str2, String str3) {
        this.f334j.M(new s(str, str2, str3, this.f333i.incrementAndGet()));
    }

    @Override // a6.o
    public final Object a(String str, boolean z4, w wVar, g7.d dVar) {
        ConcurrentHashMap concurrentHashMap = this.f327c;
        d dVar2 = (d) concurrentHashMap.get(str);
        if (dVar2 == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("job ", str), d7.a0.f2944f, 2);
        }
        String str2 = dVar2.f295a;
        String str3 = dVar2.f296b;
        String str4 = dVar2.f297c;
        String str5 = dVar2.f298d;
        boolean z10 = dVar2.f300f;
        Long l6 = dVar2.f301g;
        String str6 = dVar2.f302h;
        q7.k.e(str4, "schedule");
        concurrentHashMap.put(str, new d(str2, str3, str4, str5, z4, z10, l6, str6));
        I("cronjobs", z4 ? "enabled" : "disabled", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object b(d dVar, w wVar, g7.d dVar2) {
        this.f327c.put(dVar.f295a, dVar);
        String str = dVar.f295a;
        I("cronjobs", "added", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object c(d0 d0Var, w wVar, g7.d dVar) {
        String str = d0Var.f303a;
        ConcurrentHashMap concurrentHashMap = this.f325a;
        z zVar = (z) concurrentHashMap.get(str);
        if (zVar == null) {
            return new m(false, null, "NOT_FOUND", a1.a.j("skill ", str, " not installed"), d7.a0.f2944f, 2);
        }
        concurrentHashMap.put(str, z.a(zVar, false, new Long(System.currentTimeMillis()), 767));
        I("skills", "updated", str);
        return new m(true, d0Var.f303a, null, null, null, 28);
    }

    @Override // a6.o
    public final Object d(String str, boolean z4, w wVar, g7.d dVar) {
        ConcurrentHashMap concurrentHashMap = this.f325a;
        z zVar = (z) concurrentHashMap.get(str);
        if (zVar == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("skill ", str), d7.a0.f2944f, 2);
        }
        concurrentHashMap.put(str, z.a(zVar, z4, null, 991));
        I("skills", z4 ? "enabled" : "disabled", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object e(String str, boolean z4, w wVar, g7.d dVar) {
        ConcurrentHashMap concurrentHashMap = this.f328d;
        b bVar = (b) concurrentHashMap.get(str);
        if (bVar == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("channel ", str), d7.a0.f2944f, 2);
        }
        String str2 = bVar.f275a;
        String str3 = bVar.f276b;
        String str4 = bVar.f277c;
        String str5 = bVar.f278d;
        String str6 = bVar.f279e;
        List list = bVar.f280f;
        String str7 = bVar.f282h;
        Map map = bVar.f283i;
        q7.k.e(str2, "id");
        q7.k.e(str3, "channelId");
        q7.k.e(str4, "name");
        q7.k.e(list, "tags");
        q7.k.e(map, "metadata");
        concurrentHashMap.put(str, new b(str2, str3, str4, str5, str6, list, z4, str7, map));
        I("channels", z4 ? "enabled" : "disabled", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object f(c cVar, w wVar, g7.d dVar) {
        String str = (String) this.f329e.get(cVar);
        return str == null ? "" : str;
    }

    @Override // a6.o
    public final Object g(w wVar, g7.d dVar) {
        Collection collectionValues = this.f327c.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        return d7.r.m1(collectionValues);
    }

    @Override // a6.o
    public final Object h(h hVar, g7.d dVar) {
        String str = hVar.f319a;
        this.f328d.put(str, new b(str, str, str, (String) null, hVar.f320b, (List) null, false, (String) null, 488));
        String str2 = hVar.f319a;
        I("channels", "installed", str2);
        return new m(true, str2, null, null, null, 28);
    }

    @Override // a6.o
    public final Object i(String str, String str2, g7.d dVar) {
        this.f330f.put(str, str2);
        I("files", "updated", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object j(w wVar, g7.d dVar) {
        I("gateway", "restarted", null);
        return new m(true, null, null, null, null, 28);
    }

    @Override // a6.o
    public final Object k(String str, boolean z4, w wVar, g7.d dVar) {
        ConcurrentHashMap concurrentHashMap = this.f326b;
        b0 b0Var = (b0) concurrentHashMap.get(str);
        if (b0Var == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("tool ", str), d7.a0.f2944f, 2);
        }
        concurrentHashMap.put(str, b0.a(b0Var, z4, null, 2015));
        I("tools", z4 ? "enabled" : "disabled", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object l(g7.d dVar) {
        return new a(a1.a.h("mock-backup-", this.f333i.incrementAndGet()), "application/json", 0L);
    }

    @Override // a6.o
    public final Set m() {
        return n.getSupportedNamespaces(this);
    }

    @Override // a6.o
    public final Object n(String str, w wVar, g7.d dVar) {
        if (((b) this.f328d.remove(str)) == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("channel ", str), d7.a0.f2944f, 2);
        }
        I("channels", "uninstalled", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object o(String str, g7.d dVar) {
        ConcurrentHashMap concurrentHashMap = this.f326b;
        b0 b0Var = (b0) concurrentHashMap.get(str);
        d7.a0 a0Var = d7.a0.f2944f;
        if (b0Var == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("tool ", str), a0Var, 2);
        }
        if (b0Var.f290g == c0.CORE) {
            return new m(false, null, "NOT_FOUND", a1.a.j("core tool ", str, " is not removable"), a0Var, 2);
        }
        concurrentHashMap.remove(str);
        I("tools", "uninstalled", str);
        return new m(true, str, null, null, null, 28);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    @Override // a6.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(a6.l r8, a6.w r9, g7.d r10) {
        /*
            r7 = this;
            a6.k r0 = r7.f332h
            java.lang.String r9 = r8.f341a
            if (r9 != 0) goto La
            a6.k r9 = r7.f332h
            java.lang.String r9 = r9.f336a
        La:
            r1 = r9
            java.lang.String r9 = r8.f342b
            if (r9 != 0) goto L13
            a6.k r9 = r7.f332h
            java.lang.String r9 = r9.f337b
        L13:
            r2 = r9
            java.lang.String r9 = r8.f343c
            r10 = 0
            if (r9 == 0) goto L26
            int r3 = r9.length()
            if (r3 <= 0) goto L20
            goto L21
        L20:
            r9 = r10
        L21:
            if (r9 != 0) goto L24
            goto L26
        L24:
            r3 = r9
            goto L2b
        L26:
            a6.k r9 = r7.f332h
            java.lang.String r9 = r9.f338c
            goto L24
        L2b:
            java.lang.String r8 = r8.f344d
            if (r8 != 0) goto L33
            a6.k r8 = r7.f332h
            java.lang.String r8 = r8.f339d
        L33:
            r4 = r8
            r5 = 16
            a6.k r8 = a6.k.a(r0, r1, r2, r3, r4, r5)
            r7.f332h = r8
            java.lang.String r8 = "config.model"
            java.lang.String r9 = "set"
            r7.I(r8, r9, r10)
            a6.m r0 = new a6.m
            r5 = 0
            r6 = 28
            r1 = 1
            r2 = 0
            r3 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.j.p(a6.l, a6.w, g7.d):java.lang.Object");
    }

    @Override // a6.o
    public final Object q(w wVar, g7.d dVar) {
        return k.a(this.f332h, null, null, null, null, 15);
    }

    @Override // a6.o
    public final Object r(String str, g7.d dVar) {
        String str2 = (String) this.f330f.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // a6.o
    public final Object s(d0 d0Var, g7.d dVar) {
        String str = d0Var.f303a;
        ConcurrentHashMap concurrentHashMap = this.f326b;
        b0 b0Var = (b0) concurrentHashMap.get(str);
        if (b0Var == null) {
            return new m(false, null, "NOT_FOUND", "tool ".concat(str), d7.a0.f2944f, 2);
        }
        concurrentHashMap.put(str, b0.a(b0Var, false, new Long(System.currentTimeMillis()), 1535));
        I("tools", "updated", str);
        return new m(true, d0Var.f303a, null, null, null, 28);
    }

    @Override // a6.o
    public final Object t(Set set, g7.d dVar) {
        if (set.contains(x.MODEL) || set.contains(x.ALL) || set.contains(x.CLAW)) {
            this.f332h = new k();
        }
        if (set.contains(x.CRONJOBS) || set.contains(x.ALL)) {
            this.f327c.clear();
        }
        I("config.backup", "restored", null);
        return new m(true, null, null, null, null, 28);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    @Override // a6.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(a6.a0 r8, a6.w r9, g7.d r10) {
        /*
            r7 = this;
            java.util.concurrent.ConcurrentHashMap r7 = r7.f326b
            java.util.Collection r7 = r7.values()
            java.lang.String r9 = "<get-values>(...)"
            q7.k.d(r7, r9)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = d7.r.m1(r7)
            if (r8 != 0) goto L14
            return r7
        L14:
            java.lang.Boolean r9 = r8.f274c
            java.util.Set r10 = r8.f273b
            java.util.Set r8 = r8.f272a
            if (r8 != 0) goto L21
            if (r10 != 0) goto L21
            if (r9 != 0) goto L21
            return r7
        L21:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L2a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L77
            java.lang.Object r1 = r7.next()
            r2 = r1
            a6.b0 r2 = (a6.b0) r2
            r3 = 1
            if (r8 == 0) goto L41
            a6.c0 r4 = r2.f290g
            boolean r4 = r8.contains(r4)
            goto L42
        L41:
            r4 = r3
        L42:
            r5 = 0
            if (r4 == 0) goto L70
            if (r10 == 0) goto L5c
            r4 = r10
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r6 = r2.f288e
            java.util.Set r6 = d7.r.q1(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r4 = d7.r.R0(r4, r6)
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            goto L5d
        L5c:
            r4 = r3
        L5d:
            if (r4 == 0) goto L70
            if (r9 == 0) goto L6c
            boolean r4 = r9.booleanValue()
            boolean r2 = r2.f289f
            if (r4 != r2) goto L6a
            goto L6c
        L6a:
            r2 = r5
            goto L6d
        L6c:
            r2 = r3
        L6d:
            if (r2 == 0) goto L70
            goto L71
        L70:
            r3 = r5
        L71:
            if (r3 == 0) goto L2a
            r0.add(r1)
            goto L2a
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.j.u(a6.a0, a6.w, g7.d):java.lang.Object");
    }

    @Override // a6.o
    public final e0 v() {
        return this.f335k;
    }

    @Override // a6.o
    public final Object w(w wVar, g7.d dVar) {
        return new g(true, true, null, "mock", "1.0.0");
    }

    @Override // a6.o
    public final Object x(w wVar, g7.d dVar) {
        Collection collectionValues = this.f328d.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        return d7.r.m1(collectionValues);
    }

    @Override // a6.o
    public final Object y(String str, w wVar, g7.d dVar) {
        if (((z) this.f325a.remove(str)) == null) {
            return new m(false, null, "NOT_FOUND", a1.a.w("skill ", str), d7.a0.f2944f, 2);
        }
        this.f331g.remove(str);
        I("skills", "uninstalled", str);
        return new m(true, str, null, null, null, 28);
    }

    @Override // a6.o
    public final Object z(h hVar, w wVar, g7.d dVar) {
        String str = hVar.f319a;
        this.f325a.put(str, new z(str, str, (String) null, hVar.f320b, (List) null, true, false, hVar.f322d, new Long(System.currentTimeMillis()), 532));
        String str2 = hVar.f319a;
        I("skills", "installed", str2);
        return new m(true, str2, null, null, null, 28);
    }
}
