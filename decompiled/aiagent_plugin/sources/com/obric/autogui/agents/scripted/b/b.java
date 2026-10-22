package com.obric.autogui.agents.scripted.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ScriptMemoryMeasurement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f26903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<String, d> f26904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f26905e;
    private boolean f;

    /* JADX INFO: compiled from: ScriptMemoryMeasurement.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26901a = new a(null);
    }

    public b(boolean r2, e r3) {
        o.e(r3, "collector");
        this.f26902b = r2;
        this.f26903c = r3;
        this.f26904d = new LinkedHashMap();
        this.f26905e = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ b(boolean r1, e r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        d.h.a.a r5 = null;
        r2 = new e(r5, 1, 0 == true ? 1 : 0);
    L5:
        this(r1, r2);
    }

    public final void a() {
        if (this.f26902b == true) goto L5;
        return;
    L5:
        if (this.f26905e.contains("baseline") == true) goto L14;
        a("baseline");
        if (this.f26904d.get("baseline") != null) goto L10;
        boolean r0 = true;
    L11:
        this.f = r0;
        return;
    L10:
        r0 = false;
        goto L11
    }

    public final void a(String r4) {
        o.e(r4, "name");
        if (this.f26902b == true) goto L5;
        return;
    L5:
        if (this.f == false) goto L7;
        return;
    L7:
        if (this.f26905e.contains(r4) == false) goto L9;
        return;
    L9:
        if (o.a(r4, "baseline") == true) goto L11;
    L13:
        ((Collection) ZeusTransformUtils.preCheckCast(this.f26905e, Collection.class, "com.obric.aiagent.plugin")).add(r4);
        d r0 = this.f26903c.a();
        if (r0 == null) goto L20;
        ((Map) ZeusTransformUtils.preCheckCast(this.f26904d, Map.class, "com.obric.aiagent.plugin")).put(r4, r0);
        return;
    L20:
        return;
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f26905e, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L13;
    }

    public final void a(Map<String, Object> r5, String r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "fields");
        o.e(r6, "snapshotName");
        o.e(r7, "deltaFieldSuffix");
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.f26904d.get("baseline"), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        d r4 = (d) ZeusTransformUtils.preCheckCast(this.f26904d.get(r6), d.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        return;
    L8:
        com.obric.autogui.agents.scripted.b.a r9 = r4.a(r0);
        r8.put(c.f26906a.a(r7), Long.valueOf(r9.a()));
        Long r10 = r9.b();
        if (r10 == null) goto L11;
        Long r11 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.b(r7), r11);
    L11:
        Long r12 = r9.c();
        if (r12 == null) goto L14;
        Long r13 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.c(r7), r13);
    L14:
        Long r14 = r9.d();
        if (r14 == null) goto L17;
        Long r15 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.d(r7), r15);
    L17:
        Long r16 = r9.e();
        if (r16 == null) goto L20;
        Long r17 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.e(r7), r17);
    L20:
        Long r18 = r9.f();
        if (r18 == null) goto L23;
        Long r19 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.f(r7), r19);
    L23:
        Long r20 = r9.g();
        if (r20 == null) goto L26;
        Long r21 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.g(r7), r21);
    L26:
        Long r22 = r9.h();
        if (r22 == null) goto L29;
        Long r23 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.h(r7), r23);
    L29:
        Long r24 = r9.i();
        if (r24 == null) goto L33;
        Long r25 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r24, Number.class, "com.obric.aiagent.plugin")).longValue());
        r8.put(c.f26906a.i(r7), r25);
        return;
    }

    public final Long a(String r3, String r4) {
        o.e(r3, "fromSnapshotName");
        o.e(r4, "toSnapshotName");
        d r5 = (d) ZeusTransformUtils.preCheckCast(this.f26904d.get(r3), d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        d r2 = (d) ZeusTransformUtils.preCheckCast(this.f26904d.get(r4), d.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
        return null;
    L9:
        return Long.valueOf(r2.a() - r5.a());
    }

    public final void b(Map<String, Object> r6, String r7, String r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, "fields");
        o.e(r7, "snapshotName");
        o.e(r8, "totalPssDeltaField");
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.f26904d.get("baseline"), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        d r5 = (d) ZeusTransformUtils.preCheckCast(this.f26904d.get(r7), d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
        return;
    L8:
        r9.put(r8, Long.valueOf(r5.a() - r0.a()));
    }
}
