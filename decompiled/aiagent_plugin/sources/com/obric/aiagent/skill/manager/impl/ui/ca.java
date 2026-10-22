package com.obric.aiagent.skill.manager.impl.ui;

import android.os.SystemClock;
import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.hd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: SkillStorePerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f20703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ea f20704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f20705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f20706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f20707e;
    private Long f;

    /* JADX WARN: Multi-variable type inference failed */
    public ca() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ca(hd r13) {
        d.h.b.o.e(r13, "reporter");
        long r7 = SystemClock.elapsedRealtime();
        this.f20703a = r7;
        this.f20704b = new ea(dy.q, r13, null, 0, null, r7, false, 92, null);
    }

    public /* synthetic */ ca(hd r7, int r8, d.h.b.h r9) {
        if ((r8 & 1) == 0) goto L5;
        r7 = new hd(null, null, null, 7, null);
    L5:
        this(r7);
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        if (this.f20707e != null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(boolean r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f20705c == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f20705c = Boolean.valueOf(r2);     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void b(boolean r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f20706d == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f20706d = Boolean.valueOf(r2);     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void c(boolean r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f20707e == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f20707e = Boolean.valueOf(r3);     // Catch: Throwable -> L10
        this.f = Long.valueOf(eb.a(this.f20703a));     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void b() {
        monitor-enter(this);
        ea.a(this.f20704b, dz.f19793c, null, null, null, null, null, dw.n, "page_destroyed", null, null, d(), 830, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final void c() {
        Boolean r1 = this.f20705c;
        if (r1 == null) goto L35;
        boolean r2 = r1.booleanValue();
        Boolean r3 = this.f20706d;
        if (r3 == null) goto L36;
        boolean r4 = r3.booleanValue();
        Boolean r5 = this.f20707e;
        if (r5 == null) goto L37;
        boolean r6 = r5.booleanValue();
        if (r6 == true) goto L12;
        dz r7 = dz.f19792b;
    L11:
        dz r8 = r7;
        ea r9 = this.f20704b;
        if (r8 != dz.f19791a) goto L20;
        dw r10 = null;
    L21:
        if (r6 == true) goto L24;
        String r11 = "featured_list";
    L23:
        String r13 = r11;
    L30:
        if (r8 == dz.f19791a) goto L32;
        boolean r12 = true;
    L33:
        ea.a(r9, r8, null, null, null, null, null, r10, r13, Boolean.valueOf(r12), null, d(), 574, null);
        return;
    L32:
        r12 = false;
        goto L33
    L24:
        if (r2 == true) goto L26;
        r11 = "categories";
        goto L23
    L26:
        if (r4 == true) goto L28;
        r11 = "banner";
        goto L23
    L28:
        r13 = null;
        goto L30
    L20:
        r10 = dw.g;
        goto L21
    L12:
        if (r2 == false) goto L16;
        if (r4 == false) goto L16;
        r7 = dz.f19791a;
    L16:
        r7 = dz.f19794d;
        goto L11
    L37:
        return;
    L36:
        return;
    }

    private final Map<String, Object> d() {
        Map r0 = d.a.ao.a();
        r0.put("page_type", "mall_initial");
        Boolean r1 = this.f20705c;
        if (r1 == null) goto L5;
        r0.put("categories_succeeded", Boolean.valueOf(r1.booleanValue()));
    L5:
        Boolean r2 = this.f20706d;
        if (r2 == null) goto L8;
        r0.put("banner_succeeded", Boolean.valueOf(r2.booleanValue()));
    L8:
        Boolean r3 = this.f20707e;
        if (r3 == null) goto L11;
        r0.put("first_list_succeeded", Boolean.valueOf(r3.booleanValue()));
    L11:
        Long r4 = this.f;
        if (r4 == null) goto L15;
        r0.put("core_display_duration_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L15:
        return d.a.ao.a(r0);
    }
}
