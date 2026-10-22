package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FluidVelocityTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements h {
    private static final String TAG = "FluidVelocityTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<PointF> f35531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinkedList<Long> f35532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PointF f35533e;
    private final DisplayMetrics f;

    /* JADX INFO: compiled from: FluidVelocityTracker.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f35529a = new a(null);
    }

    public e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f35530b = r6;
        this.f35531c = new LinkedList();
        this.f35532d = new LinkedList();
        this.f35533e = new PointF(0.0f, 0.0f);
        this.f = ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDisplayMetrics();
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public void a(MotionEvent r4) {
        o.e(r4, "event");
        if (this.f35531c.size() < 4) goto L5;
        this.f35531c.removeFirst();
        this.f35532d.removeFirst();
    L5:
        this.f35532d.add(Long.valueOf(r4.getEventTime()));
        this.f35531c.add(new PointF(r4.getX(), r4.getY()));
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public void a() {
        this.f35531c.clear();
        this.f35532d.clear();
        this.f35533e = new PointF(0.0f, 0.0f);
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public void a(int r11, float r12) {
        float r0 = 0.0f;
        if (this.f35532d.isEmpty() == false) goto L6;
        this.f35533e = new PointF(0.0f, 0.0f);
        return;
    L6:
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(p.k((List) ZeusTransformUtils.preCheckCast(this.f35532d, List.class, "com.obric.aiagent.plugin")), Number.class, "com.obric.aiagent.plugin")).longValue();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(this.f35532d, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r1.add(Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14.next(), Number.class, "com.obric.aiagent.plugin")).longValue() - r3));
        goto L8
    L10:
        List r15 = p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f35531c, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r4.add(Float.valueOf(((PointF) ZeusTransformUtils.preCheckCast(r5.next(), PointF.class, "com.obric.aiagent.plugin")).x));
        goto L12
    L14:
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Float[] r7 = (Float[]) ZeusTransformUtils.preCheckCast(r6, Float[].class, "com.obric.aiagent.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(this.f35531c, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        r9.add(Float.valueOf(((PointF) ZeusTransformUtils.preCheckCast(r10.next(), PointF.class, "com.obric.aiagent.plugin")).y));
        goto L16
    L18:
        Object[] r16 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r16, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Float[] r17 = (Float[]) ZeusTransformUtils.preCheckCast(r16, Float[].class, "com.obric.aiagent.plugin");
        Object[] r18 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        float r19 = a((Float[]) ZeusTransformUtils.preCheckCast(r18, Float[].class, "com.obric.aiagent.plugin"), r7);
        Object[] r110 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r110, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        float r111 = a((Float[]) ZeusTransformUtils.preCheckCast(r110, Float[].class, "com.obric.aiagent.plugin"), r17);
        double r20 = 2;
        if ((((float) Math.pow(r19, r20)) + ((float) Math.pow(r111, r20))) >= (((double) ((float) Math.pow(this.f.density, r20))) * 0.0576d)) goto L21;
        r111 = 0.0f;
    L22:
        float r112 = r11;
        this.f35533e = new PointF(r0 * r112, r111 * r112);
        return;
    L21:
        r0 = r19;
        goto L22
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public float a(int r1) {
        return this.f35533e.x;
    }

    @Override // com.obric.oui.orecyclerview.base.h
    public float b(int r1) {
        return this.f35533e.y;
    }

    private final float a(Float[] r1, Float[] r2) {
        return b(r1, r2);
    L4:
        e = move-exception;
        a(TAG, "calculateRecurrenceRelationVelocity failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 0.0f;
    }

    private final float b(Float[] r12, Float[] r13) {
        if (r12.length != r13.length) goto L34;
        if (r12.length < 2) goto L32;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(p.g((Collection) ZeusTransformUtils.preCheckCast(d.a.i.b(r13, r12), Collection.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), 2, 0, false, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r11.iterator();
    L7:
        Float r1 = null;
        if (r15.hasNext() == false) goto L18;
        List r0 = (List) ZeusTransformUtils.preCheckCast(r15.next(), List.class, "com.obric.aiagent.plugin");
        float r4 = ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r0.get(1), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r0.get(0), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        if (r4 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        Float r2 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
    L16:
        if (r2 == null) goto L7;
        r14.add(r2);
        goto L7
    L15:
        r2 = Float.valueOf((((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r0.get(1), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r0.get(0), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).floatValue()) / r4);
        goto L16
    L12:
        r5 = false;
        goto L13
    L18:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin"), 2, 0, false, 6, null), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        Float r3 = null;
    L20:
        if (r17.hasNext() == false) goto L25;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r17.next(), List.class, "com.obric.aiagent.plugin");
        float r7 = (((Number) ZeusTransformUtils.preCheckCast(r6.get(0), Number.class, "com.obric.aiagent.plugin")).floatValue() * 0.4f) + (((Number) ZeusTransformUtils.preCheckCast(r6.get(1), Number.class, "com.obric.aiagent.plugin")).floatValue() * 0.6f);
        if (r1 != null) goto L23;
        r1 = Float.valueOf(r7);
        goto L20
    L23:
        Float r10 = r1;
        r1 = Float.valueOf((((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue() * 0.8f) + (r7 * 0.2f));
        r3 = r10;
        goto L20
    L25:
        if (r1 == null) goto L30;
        if (r3 == null) goto L47;
        return (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue() * 0.75f) + (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue() * 0.25f);
    L47:
        return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue();
    L30:
        return ((Number) ZeusTransformUtils.preCheckCast(p.k(r16), Number.class, "com.obric.aiagent.plugin")).floatValue();
    L32:
        throw new IllegalArgumentException("At least two points must be provided");
    L34:
        throw new IllegalArgumentException("The number of times and values must be equal");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
