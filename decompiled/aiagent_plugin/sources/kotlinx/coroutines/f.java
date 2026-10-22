package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: compiled from: Await.kt */
    @d.c.b.a.f(b = "Await.kt", c = {58}, d = "joinAll", e = "kotlinx.coroutines.AwaitKt")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f39318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f39319c;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f39318b = r2;
            this.f39319c |= Integer.MIN_VALUE;
            return f.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final <T> Object a(au<? extends T>[] r2, d.c.d<? super List<? extends T>> r3) {
        d.c.d<? super List<? extends T>> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return d.a.p.b();
    L10:
        return new e(r2).a(r4);
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Object a(Collection<? extends au<? extends T>> r3, d.c.d<? super List<? extends T>> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.c.d<? super List<? extends T>> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5.isEmpty() == false) goto L7;
        return d.a.p.b();
    L7:
        return new e((au[]) ZeusTransformUtils.preCheckCast(r5.toArray(new au[0]), au[].class, "com.obric.aiagent.plugin")).a(r6);
    }

    public static final Object b(Collection<? extends ca> r5, d.c.d<? super d.x> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f39319c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39319c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f39318b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39319c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f39317a, Iterator.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L16:
        if (r10.hasNext() == false) goto L21;
        ca r11 = (ca) ZeusTransformUtils.preCheckCast(r10.next(), ca.class, "com.obric.aiagent.plugin");
        r0.f39317a = r10;
        r0.f39319c = 1;
        if (r11.b(r0) != r2) goto L16;
        return r2;
    L21:
        return d.x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        r0 = new a(r8);
        goto L8
    }
}
