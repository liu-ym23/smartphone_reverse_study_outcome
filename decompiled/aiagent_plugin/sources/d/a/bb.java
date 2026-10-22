package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bb {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    @d.c.b.a.f(b = "SlidingWindow.kt", c = {34, 40, 49, 55, 58}, d = "invokeSuspend", e = "kotlin.collections.SlidingWindowKt$windowedIterator$1")
    static final class a<T> extends d.c.b.a.k implements d.h.a.m<d.n.l<? super List<? extends T>>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f38370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f38371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f38372e;
        final /* synthetic */ int f;
        final /* synthetic */ Iterator<T> g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        private /* synthetic */ Object j;

        a(int r3, int r4, Iterator<? extends T> r5, boolean r6, boolean r7, d.c.d<? super a> r8) {
            Iterator<T> r9 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r5, Iterator.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38372e = r3;
            this.f = r4;
            this.g = r9;
            this.h = r6;
            this.i = r7;
            super(2, r10);
        }

        public final Object a(d.n.l<? super List<? extends T>> r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            a r12 = new a(this.f38372e, this.f, this.g, this.h, this.i, r8);
            r12.j = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super d.x> r4) {
            return a((d.n.l) ZeusTransformUtils.preCheckCast(r3, d.n.l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e1 -> B:29:0x00e4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0184 -> B:58:0x0187). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01cf -> B:71:0x01d2). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38371d;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            aw r2 = (aw) ZeusTransformUtils.preCheckCast(this.f38368a, aw.class, "com.obric.aiagent.plugin");
            d.n.l r4 = (d.n.l) ZeusTransformUtils.preCheckCast(this.j, d.n.l.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L71:
            r2.b(this.f);
        L63:
            if (r2.size() <= this.f) goto L73;
            if (this.h == false) goto L67;
            Object r14 = ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L68:
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r4;
            this.f38368a = r2;
            this.f38369b = null;
            this.f38371d = 4;
            if (r4.a((List) r14, r5) != r0) goto L71;
            return r0;
        L67:
            r14 = ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
            goto L68
        L73:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L78;
            d.c.d<? super d.x> r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = null;
            this.f38368a = null;
            this.f38369b = null;
            this.f38371d = 5;
            if (r4.a(r2, r15) != r0) goto L78;
            return r0;
        L78:
            return d.x.f38692a;
        L13:
            Iterator<T> r3 = (Iterator) ZeusTransformUtils.preCheckCast(this.f38369b, Iterator.class, "com.obric.aiagent.plugin");
            aw r6 = (aw) ZeusTransformUtils.preCheckCast(this.f38368a, aw.class, "com.obric.aiagent.plugin");
            d.n.l r9 = (d.n.l) ZeusTransformUtils.preCheckCast(this.j, d.n.l.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L58:
            r6.b(this.f);
        L45:
            if (r3.hasNext() == false) goto L60;
            r6.a(r3.next());
            if (r6.b() == false) goto L45;
            int r16 = r6.size();
            int r10 = this.f38372e;
            if (r16 >= r10) goto L52;
            r6 = r6.a(r10);
            goto L45
        L52:
            if (this.h == false) goto L54;
            Object r17 = ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        L55:
            d.c.d<? super d.x> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r9;
            this.f38368a = r6;
            this.f38369b = r3;
            this.f38371d = 3;
            if (r9.a((List) r17, r11) != r0) goto L58;
            return r0;
        L54:
            r17 = ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
            goto L55
        L60:
            if (this.i == false) goto L78;
            r2 = r6;
            r4 = r9;
        L14:
            d.o.a(r13);
            goto L78
        L15:
            int r7 = this.f38370c;
            Iterator<T> r8 = (Iterator) ZeusTransformUtils.preCheckCast(this.f38369b, Iterator.class, "com.obric.aiagent.plugin");
            ArrayList r12 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f38368a, ArrayList.class, "com.obric.aiagent.plugin");
            d.n.l r18 = (d.n.l) ZeusTransformUtils.preCheckCast(this.j, d.n.l.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
            int r19 = r7;
        L30:
            if (this.h == false) goto L32;
            r12.clear();
        L33:
            int r20 = r19;
        L20:
            if (r8.hasNext() == false) goto L35;
            T r110 = r8.next();
            if (r20 > 0) goto L23;
            r12.add(r110);
            if (r12.size() != this.f38372e) goto L20;
            d.c.d<? super d.x> r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r18;
            this.f38368a = r12;
            this.f38369b = r8;
            this.f38370c = r19;
            this.f38371d = 1;
            if (r18.a(r12, r111) != r0) goto L30;
            return r0;
        L23:
            r20 = r20 - 1;
            goto L20
        L35:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L78;
            if (this.i == false) goto L39;
        L40:
            d.c.d<? super d.x> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = null;
            this.f38368a = null;
            this.f38369b = null;
            this.f38371d = 2;
            if (r18.a(r12, r112) != r0) goto L78;
            return r0;
        L39:
            if (r12.size() != this.f38372e) goto L78;
        L32:
            r12 = new ArrayList(this.f38372e);
            goto L33
        L16:
            d.o.a(r13);
            d.n.l r113 = (d.n.l) ZeusTransformUtils.preCheckCast(this.j, d.n.l.class, "com.obric.aiagent.plugin");
            int r21 = d.l.n.d(this.f38372e, 1024);
            r19 = this.f - this.f38372e;
            if (r19 < 0) goto L43;
            ArrayList r22 = new ArrayList(r21);
            r20 = 0;
            r18 = r113;
            r12 = r22;
            r8 = this.g;
            goto L20
        L43:
            r6 = new aw(r21);
            r3 = this.g;
            r9 = r113;
            goto L45
        }
    }

    public static final void a(int r3, int r4) {
        if (r3 <= 0) goto L5;
        if (r4 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r3 == r4) goto L10;
        String r5 = "Both size " + r3 + " and step " + r4 + " must be greater than zero.";
    L12:
        throw new IllegalArgumentException(r5.toString());
    L10:
        r5 = "size " + r3 + " must be greater than zero.";
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Iterator<List<T>> a(Iterator<? extends T> r9, int r10, int r11, boolean r12, boolean r13) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r9, Iterator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "iterator");
        if (r5.hasNext() == true) goto L7;
        return (Iterator) ZeusTransformUtils.preCheckCast(aa.f38344a, Iterator.class, "com.obric.aiagent.plugin");
    L7:
        return d.n.m.b((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, r11, r5, r13, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }
}
