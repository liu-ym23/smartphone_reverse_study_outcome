package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", Const.INTENT_KEY_APIKEY, "(LXa/b;)LXa/b;", "Lkotlin/Function2;", "Le9/c;", "LY8/t;", "action", Const.INTENT_KEY_PKGNAME, "(LXa/b;Lp9/p;)LXa/b;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> b<T> a(final b<? extends T> bVar) {
        return new b<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ c f36549a;

                @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {217}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public Object f36550a;

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f36551b;

                    /* renamed from: c, reason: collision with root package name */
                    public int f36552c;

                    /* renamed from: e, reason: collision with root package name */
                    public Object f36554e;

                    /* renamed from: f, reason: collision with root package name */
                    public Object f36555f;

                    /* renamed from: g, reason: collision with root package name */
                    public Object f36556g;

                    /* renamed from: h, reason: collision with root package name */
                    public int f36557h;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f36551b = obj;
                        this.f36552c |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(c cVar) {
                    this.f36549a = cVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(T r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f36552c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f36552c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f36551b
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f36552c
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r4 = r0.f36556g
                        Xa.c r4 = (Xa.c) r4
                        java.lang.Object r4 = r0.f36554e
                        e9.c r4 = (e9.InterfaceC4014c) r4
                        kotlin.C4849c.b(r6)
                        goto L64
                    L31:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L39:
                        kotlin.C4849c.b(r6)
                        Xa.c r4 = r4.f36549a
                        if (r5 == 0) goto L64
                        java.lang.Object r6 = g9.h.a(r5)
                        r0.f36550a = r6
                        java.lang.Object r6 = g9.h.a(r0)
                        r0.f36554e = r6
                        java.lang.Object r6 = g9.h.a(r5)
                        r0.f36555f = r6
                        java.lang.Object r6 = g9.h.a(r4)
                        r0.f36556g = r6
                        r6 = 0
                        r0.f36557h = r6
                        r0.f36552c = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L64
                        return r1
                    L64:
                        Y8.t r4 = Y8.t.f7040a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = bVar.collect(new AnonymousClass2(cVar), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        };
    }

    public static final <T> b<T> b(final b<? extends T> bVar, final p<? super T, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        return new b<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ c f36560a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ p f36561b;

                @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {217, 218}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public Object f36562a;

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f36563b;

                    /* renamed from: c, reason: collision with root package name */
                    public int f36564c;

                    /* renamed from: e, reason: collision with root package name */
                    public Object f36566e;

                    /* renamed from: f, reason: collision with root package name */
                    public Object f36567f;

                    /* renamed from: g, reason: collision with root package name */
                    public Object f36568g;

                    /* renamed from: h, reason: collision with root package name */
                    public int f36569h;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f36563b = obj;
                        this.f36564c |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(c cVar, p pVar) {
                    this.f36560a = cVar;
                    this.f36561b = pVar;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
                
                    if (r7.emit(r2, r0) == r1) goto L22;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(T r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f36564c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f36564c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f36563b
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f36564c
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L4f
                        if (r2 == r4) goto L3d
                        if (r2 != r3) goto L35
                        java.lang.Object r6 = r0.f36568g
                        Xa.c r6 = (Xa.c) r6
                        java.lang.Object r6 = r0.f36566e
                        e9.c r6 = (e9.InterfaceC4014c) r6
                        kotlin.C4849c.b(r8)
                        goto La2
                    L35:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L3d:
                        int r6 = r0.f36569h
                        java.lang.Object r7 = r0.f36568g
                        Xa.c r7 = (Xa.c) r7
                        java.lang.Object r2 = r0.f36567f
                        java.lang.Object r4 = r0.f36566e
                        e9.c r4 = (e9.InterfaceC4014c) r4
                        java.lang.Object r5 = r0.f36562a
                        kotlin.C4849c.b(r8)
                        goto L7f
                    L4f:
                        kotlin.C4849c.b(r8)
                        Xa.c r8 = r6.f36560a
                        p9.p r6 = r6.f36561b
                        java.lang.Object r2 = g9.h.a(r7)
                        r0.f36562a = r2
                        java.lang.Object r2 = g9.h.a(r0)
                        r0.f36566e = r2
                        r0.f36567f = r7
                        r0.f36568g = r8
                        r2 = 0
                        r0.f36569h = r2
                        r0.f36564c = r4
                        r4 = 6
                        kotlin.jvm.internal.n.c(r4)
                        java.lang.Object r6 = r6.invoke(r7, r0)
                        r4 = 7
                        kotlin.jvm.internal.n.c(r4)
                        if (r6 != r1) goto L7a
                        goto La1
                    L7a:
                        r5 = r7
                        r4 = r0
                        r6 = r2
                        r2 = r5
                        r7 = r8
                    L7f:
                        java.lang.Object r8 = g9.h.a(r5)
                        r0.f36562a = r8
                        java.lang.Object r8 = g9.h.a(r4)
                        r0.f36566e = r8
                        java.lang.Object r8 = g9.h.a(r2)
                        r0.f36567f = r8
                        java.lang.Object r8 = g9.h.a(r7)
                        r0.f36568g = r8
                        r0.f36569h = r6
                        r0.f36564c = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto La2
                    La1:
                        return r1
                    La2:
                        Y8.t r6 = Y8.t.f7040a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = bVar.collect(new AnonymousClass2(cVar, pVar), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        };
    }
}
