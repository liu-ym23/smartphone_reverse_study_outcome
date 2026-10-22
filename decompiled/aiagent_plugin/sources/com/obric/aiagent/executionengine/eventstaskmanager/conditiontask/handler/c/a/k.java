package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import android.location.Location;
import com.obric.eventkit.task.model.LocationCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMath.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final Float a(Float r3) {
        if (r3 == null) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue() < 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        return r3;
    L7:
        r1 = false;
    L11:
        return null;
    }

    public static final Float a(Iterable<Float> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        Iterator r7 = r6.iterator();
        int r0 = 0;
        float r2 = 0.0f;
    L4:
        if (r7.hasNext() == false) goto L6;
        r2 = r2 + ((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        r0 = r0 + 1;
        goto L4
    L6:
        if (r0 != 0) goto L9;
        return null;
    L9:
        return Float.valueOf(r2 / r0);
    }

    public static final Float a(List<Float> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        List r6 = d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));
        int r0 = r6.size() / 2;
        if ((r6.size() % 2) != 0) goto L10;
        return Float.valueOf((((Number) ZeusTransformUtils.preCheckCast(r6.get(r0 - 1), Number.class, "com.obric.aiagent.plugin")).floatValue() + ((Number) ZeusTransformUtils.preCheckCast(r6.get(r0), Number.class, "com.obric.aiagent.plugin")).floatValue()) / 2.0f);
    L10:
        return (Float) ZeusTransformUtils.preCheckCast(r6.get(r0), Float.class, "com.obric.aiagent.plugin");
    }

    public static final Float a(Float r2, float r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return Float.valueOf(d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).floatValue() / r3, 0.0f, 1.0f));
    }

    public static final Float b(Float r2, float r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return Float.valueOf(d.l.n.a(1.0f - (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).floatValue() / r3), 0.0f, 1.0f));
    }

    public static final Float b(Float r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return Float.valueOf(d.l.n.a((1.0f - d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).floatValue(), -1.0f, 1.0f)) / 2.0f, 0.0f, 1.0f));
    }

    public static final float a(double r10, double r12, double r14, double r16) {
        float[] r0 = new float[1];
        Location.distanceBetween(r12, r10, r16, r14, r0);
        return r0[0];
    }

    public static final float a(LocationCondition r3) {
        d.h.b.o.e(r3, "<this>");
        Integer r0 = r3.getRadius();
        if (r0 != null) goto L5;
    L13:
        float r1 = 250.0f;
    L15:
        if (d.h.b.o.a(r3.getAddrType(), "home") == true) goto L19;
        if (d.h.b.o.a(r3.getAddrType(), "company") == true) goto L19;
        return r1;
    L19:
        return d.l.n.b(r1, 100.0f);
    L5:
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r1 = r0.intValue();
        goto L15
    L7:
        r2 = false;
        goto L8
    }

    public static final Float a(LocationCondition r10, n r11) {
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r11, "frame");
        Double r0 = r10.getLongitude();
        if (r0 == null) goto L8;
        double r6 = r0.doubleValue();
        Double r12 = r10.getLatitude();
        if (r12 == null) goto L8;
        double r8 = r12.doubleValue();
        return Float.valueOf(a(r11.d(), r11.e(), r6, r8));
    L8:
        return null;
    }

    public static final Float b(LocationCondition r1, n r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "frame");
        Float r3 = a(r1, r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return Float.valueOf(r3.floatValue() - a(r1));
    }

    public static final Boolean c(LocationCondition r2, n r3) {
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r3, "frame");
        Float r4 = a(r2, r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.floatValue() > a(r2)) goto L7;
        boolean r5 = true;
    L9:
        if (d.h.b.o.a(r2.getType(), "inside") == false) goto L12;
        return Boolean.valueOf(r5);
    L12:
        return Boolean.valueOf(!r5);
    L7:
        r5 = false;
        goto L9
    }

    public static final Float b(List<n> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "<this>");
        if (r8.size() >= 2) goto L5;
        return null;
    L5:
        Float r9 = Float.valueOf((((n) ZeusTransformUtils.preCheckCast(d.a.p.m(r8), n.class, "com.obric.aiagent.plugin")).a() - ((n) ZeusTransformUtils.preCheckCast(d.a.p.k(r8), n.class, "com.obric.aiagent.plugin")).a()) / 1000.0f);
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        return r9;
    L8:
        r0 = false;
        goto L9
    }
}
