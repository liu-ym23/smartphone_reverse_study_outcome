package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements VelocityTracker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f15369f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedList f15371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList f15372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PointF f15373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DisplayMetrics f15374e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f15369f = new a(null);
    }

    public e(Context r10) {
        q.g(r10, "context");
        this.f15370a = r10;
        this.f15371b = new LinkedList();
        this.f15372c = new LinkedList();
        this.f15373d = new PointF(0.0f, 0.0f);
        this.f15374e = r10.getResources().getDisplayMetrics();
    }

    public final float a(Float[] r11, Float[] r12) {
        if (r11.length != r12.length) goto L31;
        if (r11.length < 2) goto L29;
        List r10 = b0.D0(b0.z0(n.P(r12, r11)), 2, 0, false, 6, null);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L7:
        Float r15 = null;
        if (r14.hasNext() == false) goto L15;
        List r16 = (List) r14.next();
        float r17 = ((Number) ((Pair) r16.get(1)).getSecond()).floatValue() - ((Number) ((Pair) r16.get(0)).getSecond()).floatValue();
        if (r17 == 0.0f) goto L13;
        r15 = Float.valueOf((((Number) ((Pair) r16.get(1)).getFirst()).floatValue() - ((Number) ((Pair) r16.get(0)).getFirst()).floatValue()) / r17);
    L13:
        if (r15 == null) goto L7;
        r13.add(r15);
        goto L7
    L15:
        Iterator r18 = b0.D0(r13, 2, 0, false, 6, null).iterator();
        Float r19 = null;
    L17:
        if (r18.hasNext() == false) goto L22;
        List r20 = (List) r18.next();
        float r21 = (((Number) r20.get(0)).floatValue() * 0.4f) + (((Number) r20.get(1)).floatValue() * 0.6f);
        if (r15 != null) goto L20;
        r15 = Float.valueOf(r21);
        goto L17
    L20:
        Float r22 = r15;
        r15 = Float.valueOf((r15.floatValue() * 0.8f) + (r21 * 0.2f));
        r19 = r22;
        goto L17
    L22:
        if (r15 == null) goto L27;
        if (r19 == null) goto L44;
        return (r19.floatValue() * 0.75f) + (r15.floatValue() * 0.25f);
    L44:
        return r15.floatValue();
    L27:
        return ((Number) b0.Y(r13)).floatValue();
    L29:
        throw new IllegalArgumentException("At least two points must be provided");
    L31:
        throw new IllegalArgumentException("The number of times and values must be equal");
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void addMovement(@NotNull MotionEvent r10) {
        q.g(r10, "event");
        if (this.f15371b.size() < 4) goto L5;
        this.f15371b.removeFirst();
        this.f15372c.removeFirst();
    L5:
        this.f15372c.add(Long.valueOf(r10.getEventTime()));
        this.f15371b.add(new PointF(r10.getX(), r10.getY()));
    }

    public final float b(Float[] r10, Float[] r11) {
        return a(r10, r11);
    L4:
        e = move-exception;
        Log.e("FluidVelocityTracker", "calculateRecurrenceRelationVelocity failed", e);
        return 0.0f;
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void clear() {
        this.f15371b.clear();
        this.f15372c.clear();
        this.f15373d = new PointF(0.0f, 0.0f);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void computeCurrentVelocity(int r10, float r11) {
        float r12 = 0.0f;
        if (this.f15372c.isEmpty() == false) goto L6;
        this.f15373d = new PointF(0.0f, 0.0f);
        return;
    L6:
        long r13 = ((Number) b0.Y(this.f15372c)).longValue();
        LinkedList r14 = this.f15372c;
        ArrayList r15 = new ArrayList(u.r(r14, 10));
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.add(Float.valueOf(((Number) r16.next()).longValue() - r13));
        goto L8
    L10:
        List r17 = b0.z0(r15);
        LinkedList r18 = this.f15371b;
        ArrayList r19 = new ArrayList(u.r(r18, 10));
        Iterator r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L14;
        r19.add(Float.valueOf(((PointF) r20.next()).x));
        goto L12
    L14:
        Object[] r21 = r19.toArray(new Float[0]);
        if (r21 == null) goto L39;
        Float[] r22 = (Float[]) r21;
        LinkedList r23 = this.f15371b;
        ArrayList r24 = new ArrayList(u.r(r23, 10));
        Iterator r25 = r23.iterator();
    L18:
        if (r25.hasNext() == false) goto L20;
        r24.add(Float.valueOf(((PointF) r25.next()).y));
        goto L18
    L20:
        Object[] r26 = r24.toArray(new Float[0]);
        if (r26 == null) goto L37;
        Float[] r27 = (Float[]) r26;
        Object[] r28 = r17.toArray(new Float[0]);
        if (r28 == null) goto L35;
        float r29 = b((Float[]) r28, r22);
        Object[] r110 = r17.toArray(new Float[0]);
        if (r110 == null) goto L33;
        float r111 = b((Float[]) r110, r27);
        double r30 = 2;
        if ((((float) Math.pow(r29, r30)) + ((float) Math.pow(r111, r30))) >= (((double) ((float) Math.pow(this.f15374e.density, r30))) * 0.0576d)) goto L29;
        r111 = 0.0f;
    L30:
        float r112 = r10;
        this.f15373d = new PointF(r12 * r112, r111 * r112);
        return;
    L29:
        r12 = r29;
        goto L30
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getXVelocity(int r10) {
        return this.f15373d.x;
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getYVelocity(int r10) {
        return this.f15373d.y;
    }
}
