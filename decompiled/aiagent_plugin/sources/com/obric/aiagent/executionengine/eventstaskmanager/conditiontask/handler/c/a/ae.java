package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.obric.eventkit.task.model.LocationCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationCondition f17100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f17101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<n> f17102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<n> f17103e;
    private final int f;

    public static /* synthetic */ ae a(ae r7, String r8, LocationCondition r9, n r10, List r11, List r12, int r13, int r14, Object r15) {
        List<n> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List<n> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.f17099a;
    L5:
        String r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.f17100b;
    L8:
        LocationCondition r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.f17101c;
    L11:
        n r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r16 = r7.f17102d;
    L14:
        List<n> r4 = r16;
        if ((r14 & 16) == 0) goto L17;
        r17 = r7.f17103e;
    L17:
        List<n> r5 = r17;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.f;
    L21:
        return r7.a(r1, r2, r3, r4, r5, r13);
    }

    public final ae a(String r9, LocationCondition r10, n r11, List<n> r12, List<n> r13, int r14) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        d.h.b.o.e(r10, "condition");
        d.h.b.o.e(r11, "triggerFrame");
        d.h.b.o.e(r5, "beforeFrames");
        d.h.b.o.e(r6, "afterFrames");
        return new ae(r9, r10, r11, r5, r6, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ae.class) == true) goto L8;
        return false;
    L8:
        ae r6 = (ae) ZeusTransformUtils.preCheckCast(r5, ae.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f17099a, r6.f17099a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f17100b, r6.f17100b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f17101c, r6.f17101c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f17102d, r6.f17102d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f17103e, r6.f17103e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f17099a.hashCode() * 31) + this.f17100b.hashCode()) * 31) + this.f17101c.hashCode()) * 31) + this.f17102d.hashCode()) * 31) + this.f17103e.hashCode()) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "TriggerWindow(taskId=" + this.f17099a + ", condition=" + this.f17100b + ", triggerFrame=" + this.f17101c + ", beforeFrames=" + this.f17102d + ", afterFrames=" + this.f17103e + ", triggerResult=" + this.f + ')';
    }

    public ae(String r3, LocationCondition r4, n r5, List<n> r6, List<n> r7, int r8) {
        List<n> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<n> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        d.h.b.o.e(r4, "condition");
        d.h.b.o.e(r5, "triggerFrame");
        d.h.b.o.e(r9, "beforeFrames");
        d.h.b.o.e(r10, "afterFrames");
        this.f17099a = r3;
        this.f17100b = r4;
        this.f17101c = r5;
        this.f17102d = r9;
        this.f17103e = r10;
        this.f = r8;
    }

    public final String a() {
        return this.f17099a;
    }

    public final LocationCondition b() {
        return this.f17100b;
    }

    public final n c() {
        return this.f17101c;
    }

    public final List<n> d() {
        return this.f17102d;
    }

    public final List<n> e() {
        return this.f17103e;
    }

    public final int f() {
        return this.f;
    }

    public final List<n> g() {
        return d.a.p.c((Collection) ZeusTransformUtils.preCheckCast(d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this.f17102d, Collection.class, "com.obric.aiagent.plugin"), this.f17101c), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f17103e, Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final List<n> h() {
        return d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this.f17102d, Collection.class, "com.obric.aiagent.plugin"), this.f17101c);
    }

    public final List<n> i() {
        return d.a.p.c((Collection) ZeusTransformUtils.preCheckCast(d.a.p.a(this.f17101c), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f17103e, Iterable.class, "com.obric.aiagent.plugin"));
    }
}
