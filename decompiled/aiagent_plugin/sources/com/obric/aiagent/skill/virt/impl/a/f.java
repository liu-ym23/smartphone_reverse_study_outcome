package com.obric.aiagent.skill.virt.impl.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ShellCalling.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f22046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<String, x> f22047e;
    private final d.h.a.b<String, x> f;
    private final w<h> g;
    private final AtomicReference<j> h;
    private final AtomicReference<h> i;
    private final AtomicReference<String> j;

    public f(String r3, String r4, String r5, g r6, d.h.a.b<? super String, x> r7, d.h.a.b<? super String, x> r8) {
        g r9 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, x> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, DbHelper.COL_ID);
        o.e(r4, "groupId");
        o.e(r5, "command");
        o.e(r9, "controller");
        o.e(r10, "onStdout");
        o.e(r11, "onStderr");
        this.f22043a = r3;
        this.f22044b = r4;
        this.f22045c = r5;
        this.f22046d = r9;
        this.f22047e = r10;
        this.f = r11;
        this.g = y.a(null, 1, null);
        this.h = new AtomicReference(j.f22057b);
        this.i = new AtomicReference(null);
        this.j = new AtomicReference(null);
    }

    public final String a() {
        return this.f22043a;
    }

    public final String b() {
        return this.f22045c;
    }

    public final j c() {
        j r2 = this.h.get();
        o.c(r2, "get(...)");
        return (j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.aiagent.plugin");
    }

    public final void a(h r3) {
        o.e(r3, "result");
        AtomicReference<j> r0 = this.h;
        if (r3.b() == false) goto L6;
        j r1 = j.f;
    L9:
        r0.set(r1);
        this.i.set(r3);
        this.g.a(r3);
        return;
    L6:
        if (r3.a() != 0) goto L8;
        r1 = j.f22058c;
        goto L9
    L8:
        r1 = j.f22059d;
        goto L9
    }

    public final void a(Throwable r4) {
        o.e(r4, "t");
        this.h.set(j.f22059d);
        if (this.g.i() == true) goto L6;
        a(new h(-1, null, false));
        return;
    }

    public final Object d() {
        return this.f22046d.a();
    }

    public final Object e() {
        return this.f22046d.b();
    }

    public final Object a(d.c.d<? super h> r3) {
        d.c.d<? super h> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.g.a(r4);
    }

    public final void a(String r1) {
        this.j.set(r1);
    }

    public final void b(String r3) {
        o.e(r3, MonitorConstants.CHUNK);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.f22047e.invoke(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(String r3) {
        o.e(r3, MonitorConstants.CHUNK);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.f.invoke(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final i f() {
        String r1 = this.f22043a;
        String r2 = this.f22044b;
        String r3 = this.f22045c;
        j r4 = c();
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.i.get(), h.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        Integer r5 = Integer.valueOf(r0.a());
    L7:
        return new i(r1, r2, r3, r4, r5, (String) ZeusTransformUtils.preCheckCast(this.j.get(), String.class, "com.obric.aiagent.plugin"));
    L5:
        r5 = null;
        goto L7
    }
}
