package kotlinx.coroutines.b.a;

import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e<T> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.c.g f38882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.coroutines.a.a f38884c;

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @d.c.b.a.f(b = "ChannelFlow.kt", c = {IdlErrors.E_RejectInferDeviceOverheat}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.i<T> f38886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e<T> f38887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f38888d;

        a(kotlinx.coroutines.b.i<? super T> r3, e<T> r4, d.c.d<? super a> r5) {
            kotlinx.coroutines.b.i<T> r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38886b = r6;
            this.f38887c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f38886b, this.f38887c, r6);
            r0.f38888d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38885a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f38888d, am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.i<T> r2 = this.f38886b;
            kotlinx.coroutines.a.s<T> r8 = this.f38887c.a(r7);
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38885a = 1;
            if (kotlinx.coroutines.b.j.a(r2, r8, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @d.c.b.a.f(b = "ChannelFlow.kt", c = {56}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.a.q<? super T>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f38890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e<T> f38891c;

        b(e<T> r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38891c = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.a.q<? super T> r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f38891c, r5);
            r0.f38890b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.a.q) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38889a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.a.q<? super T> r7 = (kotlinx.coroutines.a.q) ZeusTransformUtils.preCheckCast(this.f38890b, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
            e<T> r2 = this.f38891c;
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38889a = 1;
            if (r2.a(r7, r3) != r0) goto L12;
            return r0;
        }
    }

    public abstract Object a(kotlinx.coroutines.a.q<? super T> r1, d.c.d<? super d.x> r2);

    public abstract e<T> a(d.c.g r1, int r2, kotlinx.coroutines.a.a r3);

    public kotlinx.coroutines.b.h<T> a() {
        return null;
    }

    public String b() {
        return null;
    }

    @Override // kotlinx.coroutines.b.h
    public Object collect(kotlinx.coroutines.b.i<? super T> r3, d.c.d<? super d.x> r4) {
        return a(this, (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public e(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        this.f38882a = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        this.f38883b = r4;
        this.f38884c = r5;
        if (aq.a() == true) goto L5;
        return;
    L5:
        if (r4 == (-1)) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        return;
    L11:
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final d.h.a.m<kotlinx.coroutines.a.q<? super T>, d.c.d<? super d.x>, Object> c() {
        return (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin");
    }

    public final int d() {
        int r1 = this.f38883b;
        if (r1 != (-3)) goto L6;
        return -2;
    L6:
        return r1;
    }

    @Override // kotlinx.coroutines.b.a.q
    public kotlinx.coroutines.b.h<T> a_(d.c.g r5, int r6, kotlinx.coroutines.a.a r7) {
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (aq.a() == true) goto L5;
    L12:
        d.c.g r9 = r8.plus(this.f38882a);
        if (r7 != kotlinx.coroutines.a.a.f38771a) goto L50;
        int r10 = this.f38883b;
        if (r10 == (-3)) goto L48;
        if (r6 != (-3)) goto L21;
    L19:
        r6 = r10;
        goto L48
    L21:
        if (r10 == (-2)) goto L48;
        if (r6 == (-2)) goto L19;
        if (aq.a() == false) goto L36;
        if (this.f38883b < 0) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == true) goto L36;
        throw new AssertionError();
    L30:
        r11 = false;
    L36:
        if (aq.a() == false) goto L44;
        if (r6 >= 0) goto L40;
        r2 = false;
    L40:
        if (r2 == true) goto L44;
        throw new AssertionError();
    L44:
        r10 = this.f38883b + r6;
        if (r10 >= 0) goto L19;
        r6 = Integer.MAX_VALUE;
    L48:
        r7 = this.f38884c;
    L50:
        if (d.h.b.o.a(r9, this.f38882a) == false) goto L58;
        if (r6 != this.f38883b) goto L58;
        if (r7 != this.f38884c) goto L58;
        return (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
    L58:
        return (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(a(r9, r6, r7), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
    L5:
        if (r6 == (-1)) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public kotlinx.coroutines.a.s<T> a(am r10) {
        return kotlinx.coroutines.a.o.a((am) ZeusTransformUtils.wrapperContextForParams(r10, am.class, "com.obric.aiagent.plugin"), this.f38882a, d(), this.f38884c, ao.f38853c, null, c(), 16, null);
    }

    static /* synthetic */ <T> Object a(e<T> r3, kotlinx.coroutines.b.i<? super T> r4, d.c.d<? super d.x> r5) {
        kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r6, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return d.x.f38692a;
    }

    public String toString() {
        ArrayList r0 = new ArrayList(4);
        String r1 = b();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (this.f38882a == d.c.h.f38423a) goto L9;
        r0.add("context=" + this.f38882a);
    L9:
        if (this.f38883b == (-3)) goto L12;
        r0.add("capacity=" + this.f38883b);
    L12:
        if (this.f38884c == kotlinx.coroutines.a.a.f38771a) goto L15;
        r0.add("onBufferOverflow=" + this.f38884c);
    L15:
        return ar.b(this) + '[' + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + ']';
    }
}
