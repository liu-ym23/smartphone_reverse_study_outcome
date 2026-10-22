package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.revenue.common.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<c> f90089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<b> f90090b;

    public static final class a {
    }

    public static final class b implements Order {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<e> f90091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f90092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.live.revenue.common.reactive.c f90093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f90094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.bytedance.android.live.revenue.common.reactive.c f90095e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.bytedance.android.live.recharge.deal.f f90096f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k f90097g;

        public static final class a implements Order.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f90098a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final e f90099b;

            /* JADX WARN: Multi-variable type inference failed */
            public final boolean g() {
                if (((Order.State) this.f90098a.f90093c.f90981b) == Order.State.Accepted) goto L7;
                if (((Order.State) this.f90098a.f90093c.f90981b) == Order.State.Transmitting) goto L7;
            L9:
                return false;
            L7:
                if (this.f90098a.f90092b != this) goto L9;
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void f() {
                if (g() == false) goto L9;
                b r100 = this.f90098a;
                if (((Order.State) r100.f90093c.f90981b) != Order.State.Accepted) goto L10;
                r100.f90092b = null;
                r100.f90093c.setValue(Order.State.Open);
                jy0.b.a("Recharge/OrderService", "drop: order = " + r100);
                r100.d();
                return;
            L10:
                return;
            }

            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final b getOrder() {
                return this.f90098a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void a(Object r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                if (g() == false) goto L9;
                b r101 = this.f90098a;
                r101.getClass();
                Intrinsics.checkNotNullParameter(r100, "result");
                if (((Order.State) r101.f90093c.f90981b).isClosed() == true) goto L10;
                jy0.b.d("Recharge/OrderService", "succeed: order = " + r101 + ", result = " + r100);
                r101.setResult(r100);
                r101.f90093c.setValue(Order.State.Successful);
                return;
            L10:
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void b(Object r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                if (g() == false) goto L9;
                b r101 = this.f90098a;
                r101.getClass();
                Intrinsics.checkNotNullParameter(r100, "progress");
                if (((Order.State) r101.f90093c.f90981b).isClosed() == true) goto L10;
                jy0.b.a("Recharge/OrderService", "progress: order = " + r101 + ", progress = " + r100);
                r101.f90095e.setValue(r100);
                return;
            L10:
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void c(Object r100) {
                b r101 = this.f90098a;
                if (((Order.State) r101.f90093c.f90981b).isClosed() == true) goto L7;
                jy0.b.a("Recharge/OrderService", "transmit: order = " + r101 + ", result = " + r100);
                r101.setResult(r100);
                r101.f90093c.setValue(Order.State.Transmitting);
                return;
            }

            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void cancel(Object r100) {
                if (g() == false) goto L6;
                this.f90098a.c(r100);
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void d(Object r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                if (g() == false) goto L9;
                b r101 = this.f90098a;
                r101.getClass();
                Intrinsics.checkNotNullParameter(r100, "result");
                if (((Order.State) r101.f90093c.f90981b).isClosed() == true) goto L10;
                jy0.b.f("Recharge/OrderService", "fail: order = " + r101 + ", result = " + r100, null, 4);
                r101.setResult(r100);
                r101.f90093c.setValue(Order.State.Failed);
                return;
            L10:
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.android.live.recharge.order.Order.a
            public final void e(e r100) {
                Intrinsics.checkNotNullParameter(r100, "processor");
                if (g() == false) goto L9;
                b r101 = this.f90098a;
                r101.getClass();
                Intrinsics.checkNotNullParameter(r100, "processor");
                if (((Order.State) r101.f90093c.f90981b) != Order.State.Accepted) goto L10;
                a r102 = new a(r101, r100);
                r101.f90092b = r102;
                jy0.b.a("Recharge/OrderService", "transfer: order = " + r101 + ", processor = " + r100);
                r100.a(r101, r102);
                return;
            L10:
                return;
            }

            public a(b r100, e r101) {
                Intrinsics.checkNotNullParameter(r100, "order");
                Intrinsics.checkNotNullParameter(r101, "processor");
                this.f90098a = r100;
                this.f90099b = r101;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d() {
            if (((Order.State) this.f90093c.f90981b) == Order.State.Open) goto L5;
            return;
        L5:
            e r100 = this.f90091a.removeFirstOrNull();
            if (r100 == null) goto L9;
            a r101 = new a(this, r100);
            this.f90092b = r101;
            this.f90093c.setValue(Order.State.Accepted);
            jy0.b.a("Recharge/OrderService", "tryInvokeNextProcessor: order = " + this + ", processor = " + r100);
            r100.a(this, r101);
            return;
        }

        public final String toString() {
            return "Order@" + t.a(this);
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final k a() {
            return this.f90097g;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final com.bytedance.android.live.revenue.common.reactive.c getProgress() {
            return this.f90095e;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final Object getResult() {
            return this.f90094d;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final com.bytedance.android.live.revenue.common.reactive.c getState() {
            return this.f90093c;
        }

        @Override // com.bytedance.android.live.recharge.order.Order
        public final com.bytedance.android.live.recharge.deal.f o() {
            return this.f90096f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "processor");
            if (((Order.State) this.f90093c.f90981b).isClosed() == false) goto L5;
            return;
        L5:
            this.f90091a.add(r100);
            d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(Object r100) {
            if (((Order.State) this.f90093c.f90981b).isClosed() == false) goto L5;
            return;
        L5:
            jy0.b.d("Recharge/OrderService", "cancel: order = " + this + ", result = " + r100);
            setResult(r100);
            this.f90093c.setValue(Order.State.Canceled);
        }

        public void setResult(Object r100) {
            this.f90094d = r100;
        }

        public b(com.bytedance.android.live.recharge.deal.f r100, k r101, BusinessType r102) {
            Intrinsics.checkNotNullParameter(r100, "deal");
            Intrinsics.checkNotNullParameter(r101, "entranceParams");
            Intrinsics.checkNotNullParameter(r102, "businessType");
            this.f90096f = r100;
            this.f90097g = r101;
            this.f90091a = new ArrayDeque();
            this.f90093c = new com.bytedance.android.live.revenue.common.reactive.c(Order.State.Open);
            this.f90095e = new com.bytedance.android.live.revenue.common.reactive.c(Order.b.f90064a);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f90100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BusinessType f90101b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f90100a, r101.f90100a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f90101b, r101.f90101b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            e r100 = this.f90100a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            BusinessType r104 = this.f90101b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ProcessorDescriptor(processor=" + this.f90100a + ", businessType=" + this.f90101b + ")";
        }

        public c(e r100, BusinessType r101) {
            Intrinsics.checkNotNullParameter(r100, "processor");
            Intrinsics.checkNotNullParameter(r101, "businessType");
            this.f90100a = r100;
            this.f90101b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Iterator r100 = CollectionsKt.toMutableList(this.f90090b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).c(null);
        goto L4
    L6:
        ((HashSet) this.f90090b).clear();
        this.f90089a.clear();
    }

    public f() {
        this.f90089a = new LinkedHashSet();
        this.f90090b = new HashSet();
    }

    @Override // com.bytedance.android.live.recharge.order.a
    public final void N(e r100, BusinessType r101) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        jy0.b.a("Recharge/OrderService", "registerOrderProcessor: processor = " + r100 + ", businessType = " + r101);
        this.f90089a.add(new c(r100, r101));
    }

    @Override // com.bytedance.android.live.recharge.order.a
    public final b u1(com.bytedance.android.live.recharge.deal.f r100, k r101, BusinessType r102) {
        Intrinsics.checkNotNullParameter(r100, "deal");
        Intrinsics.checkNotNullParameter(r101, "options");
        Intrinsics.checkNotNullParameter(r102, "businessType");
        b r103 = new b(r100, r101, r102);
        StringBuilder r104 = new StringBuilder("buy: order = ");
        StringBuilder r105 = new StringBuilder();
        StringBuilder r106 = new StringBuilder();
        r106.append(r103);
        r106.append('(');
        r105.append(r106.toString());
        r105.append("state=" + ((Order.State) r103.f90093c.f90981b));
        if (r103.f90095e.f90981b == Order.b.f90064a) goto L6;
        r105.append(", progress=" + r103.f90095e.f90981b);
    L6:
        if (r103.f90094d == null) goto L9;
        r105.append(", result = " + r103.f90094d);
    L9:
        if (r103.f90092b == null) goto L15;
        StringBuilder r107 = new StringBuilder(", owner = ");
        b.a r108 = r103.f90092b;
        if (r108 == null) goto L13;
        e r109 = r108.f90099b;
    L14:
        r107.append(r109);
        r105.append(r107.toString());
        goto L15
    L13:
        r109 = null;
    L15:
        r105.append(", deal=" + r103.f90096f);
        r105.append(")");
        r104.append(r105.toString());
        jy0.b.d("Recharge/OrderService", r104.toString());
        ((HashSet) this.f90090b).add(r103);
        com.bytedance.android.live.revenue.common.reactive.j.a(r103.f90093c, false).filter(g.f90102a).take(1).subscribe(new h(this, r103));
        Set<c> r110 = this.f90089a;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L17:
        if (r112.hasNext() == false) goto L24;
        Object r113 = r112.next();
        if (((c) r113).f90101b != r102) goto L21;
        boolean r114 = true;
    L22:
        if (r114 == false) goto L17;
        r111.add(r113);
        goto L17
    L21:
        r114 = false;
        goto L22
    L24:
        Iterator r115 = r111.iterator();
    L26:
        if (r115.hasNext() == false) goto L28;
        ((c) r115.next()).f90100a.c(r103);
        goto L26
    L28:
        r103.d();
        return r103;
    }
}
