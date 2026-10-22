package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.obric.eventkit.task.model.LocationCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<l> f17148a = null;

    public static final /* synthetic */ int a(List r2, ae r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    public static final /* synthetic */ Float a(List r2, LocationCondition r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    public static final List<l> a() {
        return f17148a;
    }

    static {
        f17148a = d.a.p.b(new l[]{x.f17171a, y.f17173a, v.f17167a, w.f17169a, aa.f17089a, r.f17159a, s.f17161a, d.f17109a, z.f17176a, ad.f17096a, ac.f17093a, e.f17111a, b.f17104a, c.f17106a, u.f17164a, a.f17086a});
    }

    private static final Float b(List<n> r9, LocationCondition r10) {
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.x((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L36;
        d.m r2 = (d.m) ZeusTransformUtils.preCheckCast(r12.next(), d.m.class, "com.obric.aiagent.plugin");
        n r3 = (n) ZeusTransformUtils.preCheckCast(r2.c(), n.class, "com.obric.aiagent.plugin");
        n r4 = (n) ZeusTransformUtils.preCheckCast(r2.d(), n.class, "com.obric.aiagent.plugin");
        Float r5 = k.a(r10, r3);
        Float r6 = null;
        if (r5 == null) goto L33;
        float r7 = r5.floatValue();
        Float r8 = k.a(r10, r4);
        if (r8 == null) goto L33;
        float r13 = r8.floatValue();
        boolean r14 = true;
        if (d.h.b.o.a(r10.getType(), "inside") == false) goto L15;
        if (r13 < r7) goto L16;
    L17:
        boolean r15 = false;
    L19:
        if (d.h.b.o.a(r10.getType(), "inside") == false) goto L24;
        if (r13 > r7) goto L27;
    L26:
        r14 = false;
    L27:
        if (r15 == false) goto L29;
        float r16 = 1.0f;
    L32:
        r6 = Float.valueOf(r16);
        goto L33
    L29:
        if (r14 == false) goto L31;
        r16 = -1.0f;
        goto L32
    L31:
        r16 = 0.0f;
        goto L32
    L24:
        if (r13 >= r7) goto L26;
    L16:
        r15 = true;
        goto L19
    L15:
        if (r13 <= r7) goto L17;
    L33:
        if (r6 == null) goto L4;
        r0.add(r6);
        goto L4
    L36:
        return k.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }

    private static final int b(List<n> r5, ae r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Boolean r2 = k.c(r6.b(), (n) ZeusTransformUtils.preCheckCast(r8.next(), n.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.x((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L11;
    L13:
        Iterator r10 = r9.iterator();
        int r11 = 0;
    L15:
        if (r10.hasNext() == false) goto L25;
        d.m r3 = (d.m) ZeusTransformUtils.preCheckCast(r10.next(), d.m.class, "com.obric.aiagent.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == ((Boolean) ZeusTransformUtils.preCheckCast(r3.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue()) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L15;
        r11 = r11 + 1;
        if (r11 >= 0) goto L15;
        d.a.p.d();
        goto L15
    L19:
        r4 = false;
        goto L20
    L25:
        return r11;
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
        return 0;
    }
}
