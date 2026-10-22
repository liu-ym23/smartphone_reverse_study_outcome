package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.obric.eventkit.task.model.LocationCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationCondition f17115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<i> f17118e;
    private final ab f;
    private final t g;
    private final Float h;
    private final Float i;
    private final int j;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f17114a, r6.f17114a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f17115b, r6.f17115b) == true) goto L15;
        return false;
    L15:
        if (this.f17116c == r6.f17116c) goto L18;
        return false;
    L18:
        if (this.f17117d == r6.f17117d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f17118e, r6.f17118e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f17114a.hashCode() * 31) + this.f17115b.hashCode()) * 31) + Integer.hashCode(this.f17116c)) * 31) + Integer.hashCode(this.f17117d)) * 31) + this.f17118e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Float r1 = this.h;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Float r5 = this.i;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Integer.hashCode(this.j);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationMonitorAnalyzeResult(taskId=" + this.f17114a + ", condition=" + this.f17115b + ", beforePointCount=" + this.f17116c + ", afterPointCount=" + this.f17117d + ", featureFrames=" + this.f17118e + ", rawMetrics=" + this.f + ", normalizedMetrics=" + this.g + ", errorRisk=" + this.h + ", delayRisk=" + this.i + ", triggerResult=" + this.j + ')';
    }

    public f(String r3, LocationCondition r4, int r5, int r6, List<i> r7, ab r8, t r9, Float r10, Float r11, int r12) {
        List<i> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        d.h.b.o.e(r4, "condition");
        d.h.b.o.e(r13, "featureFrames");
        d.h.b.o.e(r8, "rawMetrics");
        d.h.b.o.e(r9, "normalizedMetrics");
        this.f17114a = r3;
        this.f17115b = r4;
        this.f17116c = r5;
        this.f17117d = r6;
        this.f17118e = r13;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }

    public final String a() {
        return this.f17114a;
    }

    public final LocationCondition b() {
        return this.f17115b;
    }

    public final int c() {
        return this.f17116c;
    }

    public final int d() {
        return this.f17117d;
    }

    public final List<i> e() {
        return this.f17118e;
    }

    public final ab f() {
        return this.f;
    }

    public final t g() {
        return this.g;
    }

    public final Float h() {
        return this.h;
    }

    public final Float i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }
}
