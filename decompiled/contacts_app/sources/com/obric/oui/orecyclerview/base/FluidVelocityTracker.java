package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluidVelocityTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J)\u0010\u0012\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J)\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0002¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidVelocityTracker;", "Lcom/obric/oui/orecyclerview/base/VelocityTracker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculatedVelocity", "Landroid/graphics/PointF;", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "positions", "Ljava/util/LinkedList;", "times", "", "addMovement", "", "event", "Landroid/view/MotionEvent;", "calculateRecurrenceRelationVelocity", "", "", "values", "([Ljava/lang/Float;[Ljava/lang/Float;)F", "clear", "computeCurrentVelocity", "units", "", "maxVelocity", "getXVelocity", "id", "getYVelocity", "tryCalculateRecurrenceRelationVelocity", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidVelocityTracker implements VelocityTracker {
    public static final Companion Companion = null;
    private static final String TAG = "FluidVelocityTracker";
    private PointF calculatedVelocity;
    private final Context context;
    private final DisplayMetrics displayMetrics;
    private LinkedList<PointF> positions;
    private LinkedList<Long> times;

    /* JADX INFO: compiled from: FluidVelocityTracker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidVelocityTracker$Companion;", "", "()V", "TAG", "", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FluidVelocityTracker(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.positions = new LinkedList();
        this.times = new LinkedList();
        this.calculatedVelocity = new PointF(0.0f, 0.0f);
        this.displayMetrics = r3.getResources().getDisplayMetrics();
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void addMovement(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.positions.size() < 4) goto L5;
        this.positions.removeFirst();
        this.times.removeFirst();
    L5:
        this.times.add(Long.valueOf(r4.getEventTime()));
        this.positions.add(new PointF(r4.getX(), r4.getY()));
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void clear() {
        this.positions.clear();
        this.times.clear();
        this.calculatedVelocity = new PointF(0.0f, 0.0f);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void computeCurrentVelocity(int r10, float r11) {
        float r0 = 0.0f;
        if (this.times.isEmpty() == false) goto L6;
        this.calculatedVelocity = new PointF(0.0f, 0.0f);
        return;
    L6:
        long r1 = ((Number) CollectionsKt.first(this.times)).longValue();
        LinkedList<Long> r12 = this.times;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r3.add(Float.valueOf(((Number) r13.next()).longValue() - r1));
        goto L8
    L10:
        List r14 = CollectionsKt.toMutableList(r3);
        LinkedList<PointF> r2 = this.positions;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r4.add(Float.valueOf(((PointF) r5.next()).x));
        goto L12
    L14:
        Object[] r6 = r4.toArray(new Float[0]);
        if (r6 == null) goto L39;
        Float[] r7 = (Float[]) r6;
        LinkedList<PointF> r8 = this.positions;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r15 = r8.iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        r9.add(Float.valueOf(((PointF) r15.next()).y));
        goto L18
    L20:
        Object[] r16 = r9.toArray(new Float[0]);
        if (r16 == null) goto L37;
        Float[] r17 = (Float[]) r16;
        List r18 = r14;
        Object[] r19 = r18.toArray(new Float[0]);
        if (r19 == null) goto L35;
        float r20 = tryCalculateRecurrenceRelationVelocity((Float[]) r19, r7);
        Object[] r110 = r18.toArray(new Float[0]);
        if (r110 == null) goto L33;
        float r111 = tryCalculateRecurrenceRelationVelocity((Float[]) r110, r17);
        double r21 = 2;
        if ((((float) Math.pow(r20, r21)) + ((float) Math.pow(r111, r21))) >= (((double) ((float) Math.pow(this.displayMetrics.density, r21))) * 0.0576d)) goto L29;
        r111 = 0.0f;
    L30:
        float r112 = r10;
        this.calculatedVelocity = new PointF(r0 * r112, r111 * r112);
        return;
    L29:
        r0 = r20;
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
    public float getXVelocity(int r1) {
        return this.calculatedVelocity.x;
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getYVelocity(int r1) {
        return this.calculatedVelocity.y;
    }

    private final float tryCalculateRecurrenceRelationVelocity(Float[] r1, Float[] r2) {
        return calculateRecurrenceRelationVelocity(r1, r2);
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "calculateRecurrenceRelationVelocity failed", e);
        return 0.0f;
    }

    private final float calculateRecurrenceRelationVelocity(Float[] r11, Float[] r12) {
        if (r11.length != r12.length) goto L34;
        if (r11.length < 2) goto L32;
        List r10 = CollectionsKt.windowed$default(CollectionsKt.toMutableList(ArraysKt.zip(r12, r11)), 2, 0, false, 6, null);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L7:
        Float r0 = null;
        if (r14.hasNext() == false) goto L18;
        List r15 = (List) r14.next();
        float r3 = ((Number) ((Pair) r15.get(1)).getSecond()).floatValue() - ((Number) ((Pair) r15.get(0)).getSecond()).floatValue();
        if (r3 != 0.0f) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        Float r16 = (Float) null;
    L16:
        if (r0 == null) goto L7;
        r13.add(r0);
        goto L7
    L15:
        r0 = Float.valueOf((((Number) ((Pair) r15.get(1)).getFirst()).floatValue() - ((Number) ((Pair) r15.get(0)).getFirst()).floatValue()) / r3);
        goto L16
    L12:
        r4 = false;
        goto L13
    L18:
        ArrayList r17 = r13;
        Iterator r18 = CollectionsKt.windowed$default(r17, 2, 0, false, 6, null).iterator();
        Float r19 = null;
    L20:
        if (r18.hasNext() == false) goto L25;
        List r5 = (List) r18.next();
        float r6 = (((Number) r5.get(0)).floatValue() * 0.4f) + (((Number) r5.get(1)).floatValue() * 0.6f);
        if (r0 != null) goto L23;
        r0 = Float.valueOf(r6);
        goto L20
    L23:
        Float r9 = r0;
        r0 = Float.valueOf((r0.floatValue() * 0.8f) + (r6 * 0.2f));
        r19 = r9;
        goto L20
    L25:
        if (r0 == null) goto L30;
        if (r19 == null) goto L47;
        return (r19.floatValue() * 0.75f) + (r0.floatValue() * 0.25f);
    L47:
        return r0.floatValue();
    L30:
        return ((Number) CollectionsKt.first(r17)).floatValue();
    L32:
        throw new IllegalArgumentException("At least two points must be provided");
    L34:
        throw new IllegalArgumentException("The number of times and values must be equal");
    }
}
