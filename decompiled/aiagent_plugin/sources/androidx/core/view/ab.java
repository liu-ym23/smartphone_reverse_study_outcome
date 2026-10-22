package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: compiled from: ViewGroup.kt */
    public static final class a implements d.n.j<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1419a;

        a(ViewGroup r1) {
            this.f1419a = r1;
        }

        @Override // d.n.j
        public Iterator<View> a() {
            return ab.a(this.f1419a);
        }
    }

    /* JADX INFO: compiled from: ViewGroup.kt */
    @d.c.b.a.f(b = "ViewGroup.kt", c = {IdlErrors.E_RejectInferDeviceOverheat, 121}, d = "invokeSuspend", e = "androidx.core.view.ViewGroupKt$descendants$1")
    static final class b extends d.c.b.a.k implements d.h.a.m<d.n.l<? super View>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f1420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f1421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1424e;
        final /* synthetic */ ViewGroup f;
        private /* synthetic */ Object g;

        b(ViewGroup r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(2, r5);
        }

        public final Object a(d.n.l<? super View> r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f, r5);
            r0.g = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(d.n.l<? super View> r3, d.c.d<? super d.x> r4) {
            return a((d.n.l) ZeusTransformUtils.preCheckCast(r3, d.n.l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b5 -> B:22:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00bc -> B:24:0x00be). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f1424e;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r2 = this.f1423d;
            int r5 = this.f1422c;
            ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f1420a, ViewGroup.class, "com.obric.aiagent.plugin");
            d.n.l r7 = (d.n.l) ZeusTransformUtils.preCheckCast(this.g, d.n.l.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
        L22:
            d.n.l r13 = r7;
            ViewGroup r10 = r6;
            int r8 = r2;
            ViewGroup r3 = r10;
        L24:
            r5 = r5 + 1;
        L11:
            if (r5 >= r8) goto L26;
            View r9 = r3.getChildAt(r5);
            this.g = r13;
            this.f1420a = r3;
            this.f1421b = r9;
            this.f1422c = r5;
            this.f1423d = r8;
            this.f1424e = 1;
            if (r13.a(r9, this) != r0) goto L15;
            return r0;
        L15:
            ViewGroup r11 = r3;
            r2 = r8;
            View r14 = r9;
        L17:
            if (ZeusTransformUtils.instanceOf(r14, ViewGroup.class) == false) goto L23;
            d.n.j<View> r15 = ab.c((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.aiagent.plugin"));
            this.g = r13;
            this.f1420a = r11;
            this.f1421b = null;
            this.f1422c = r5;
            this.f1423d = r2;
            this.f1424e = 2;
            if (r13.a(r15, this) != r0) goto L21;
            return r0;
        L21:
            r6 = r11;
            r7 = r13;
            goto L22
        L23:
            r8 = r2;
            r3 = r11;
            goto L24
        L26:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r2 = this.f1423d;
            r5 = this.f1422c;
            r14 = (View) ZeusTransformUtils.preCheckCast(this.f1421b, View.class, "com.obric.aiagent.plugin");
            r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f1420a, ViewGroup.class, "com.obric.aiagent.plugin");
            d.n.l r16 = (d.n.l) ZeusTransformUtils.preCheckCast(this.g, d.n.l.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
            r13 = r16;
            goto L17
        L10:
            d.o.a(r12);
            r13 = (d.n.l) ZeusTransformUtils.preCheckCast(this.g, d.n.l.class, "com.obric.aiagent.plugin");
            r3 = this.f;
            r5 = 0;
            r8 = r3.getChildCount();
            goto L11
        }
    }

    /* JADX INFO: compiled from: ViewGroup.kt */
    public static final class c implements d.h.b.a.d, Iterator<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1426b;

        c(ViewGroup r1) {
            this.f1425a = r1;
        }

        @Override // java.util.Iterator
        public /* synthetic */ View next() {
            return a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1426b >= this.f1425a.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        public View a() {
            ViewGroup r0 = this.f1425a;
            int r1 = this.f1426b;
            this.f1426b = r1 + 1;
            View r3 = r0.getChildAt(r1);
            if (r3 == null) goto L6;
            return r3;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup r0 = this.f1425a;
            int r1 = this.f1426b - 1;
            this.f1426b = r1;
            r0.removeViewAt(r1);
        }
    }

    public static final Iterator<View> a(ViewGroup r2) {
        return (Iterator) ZeusTransformUtils.preCheckCast(new c(r2), Iterator.class, "com.obric.aiagent.plugin");
    }

    public static final d.n.j<View> b(ViewGroup r2) {
        return (d.n.j) ZeusTransformUtils.preCheckCast(new a(r2), d.n.j.class, "com.obric.aiagent.plugin");
    }

    public static final d.n.j<View> c(ViewGroup r2) {
        return d.n.m.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r2, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }
}
