package Xa;

import Ua.M;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt__BuildersKt;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.FlowKt__CollectKt;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt;

@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "Xa/e", "kotlinx/coroutines/flow/FlowKt__DelayKt", "Xa/i", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {
    public static final <T> Object A(b<? extends T> bVar, p9.p<? super T, ? super InterfaceC4014c<? super Boolean>, ? extends Object> pVar, InterfaceC4014c<? super T> interfaceC4014c) {
        return FlowKt__ReduceKt.c(bVar, pVar, interfaceC4014c);
    }

    public static final <T> b<T> B(p9.p<? super c<? super T>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.c(pVar);
    }

    public static final <T1, T2, R> b<R> C(b<? extends T1> bVar, b<? extends T2> bVar2, p9.q<? super T1, ? super T2, ? super InterfaceC4014c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.f(bVar, bVar2, qVar);
    }

    public static final <T> b<T> D(T t10) {
        return FlowKt__BuildersKt.d(t10);
    }

    public static final <T> b<T> E(b<? extends T> bVar, kotlin.coroutines.d dVar) {
        return e.e(bVar, dVar);
    }

    public static final <T> kotlinx.coroutines.g F(b<? extends T> bVar, M m10) {
        return FlowKt__CollectKt.d(bVar, m10);
    }

    public static final <T, R> b<R> G(b<? extends T> bVar, p9.p<? super T, ? super InterfaceC4014c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(bVar, pVar);
    }

    public static final <T> b<T> H(Iterable<? extends b<? extends T>> iterable) {
        return FlowKt__MergeKt.b(iterable);
    }

    public static final <T> b<T> I(b<? extends T>... bVarArr) {
        return FlowKt__MergeKt.c(bVarArr);
    }

    public static final <T> b<T> J(b<? extends T> bVar, p9.q<? super c<? super T>, ? super Throwable, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.d(bVar, qVar);
    }

    public static final <T> b<T> K(b<? extends T> bVar, p9.p<? super T, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        return FlowKt__TransformKt.b(bVar, pVar);
    }

    public static final <T> o<T> L(b<? extends T> bVar, M m10, kotlinx.coroutines.flow.a aVar, int i10) {
        return FlowKt__ShareKt.e(bVar, m10, aVar, i10);
    }

    public static final <T> t<T> M(b<? extends T> bVar, M m10, kotlinx.coroutines.flow.a aVar, T t10) {
        return FlowKt__ShareKt.f(bVar, m10, aVar, t10);
    }

    public static final <T, R> b<R> N(b<? extends T> bVar, p9.q<? super c<? super R>, ? super T, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar) {
        return FlowKt__MergeKt.d(bVar, qVar);
    }

    public static final <T> b<T> a(Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    public static final <T> o<T> b(j<T> jVar) {
        return FlowKt__ShareKt.a(jVar);
    }

    public static final <T> t<T> c(k<T> kVar) {
        return FlowKt__ShareKt.b(kVar);
    }

    public static final <T> b<T> d(b<? extends T> bVar, int i10, BufferOverflow bufferOverflow) {
        return e.a(bVar, i10, bufferOverflow);
    }

    public static final <T> b<T> f(p9.p<? super Wa.p<? super T>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.b(pVar);
    }

    public static final <T> b<T> g(b<? extends T> bVar, p9.q<? super c<? super T>, ? super Throwable, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.a(bVar, qVar);
    }

    public static final <T> Object h(b<? extends T> bVar, c<? super T> cVar, InterfaceC4014c<? super Throwable> interfaceC4014c) {
        return FlowKt__ErrorsKt.b(bVar, cVar, interfaceC4014c);
    }

    public static final Object i(b<?> bVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return FlowKt__CollectKt.a(bVar, interfaceC4014c);
    }

    public static final <T> Object j(b<? extends T> bVar, p9.p<? super T, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return FlowKt__CollectKt.b(bVar, pVar, interfaceC4014c);
    }

    public static final <T1, T2, T3, T4, T5, R> b<R> k(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, b<? extends T4> bVar4, b<? extends T5> bVar5, p9.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC4014c<? super R>, ? extends Object> tVar) {
        return FlowKt__ZipKt.b(bVar, bVar2, bVar3, bVar4, bVar5, tVar);
    }

    public static final <T1, T2, T3, T4, R> b<R> l(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, b<? extends T4> bVar4, p9.s<? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC4014c<? super R>, ? extends Object> sVar) {
        return FlowKt__ZipKt.c(bVar, bVar2, bVar3, bVar4, sVar);
    }

    public static final <T1, T2, T3, R> b<R> m(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, p9.r<? super T1, ? super T2, ? super T3, ? super InterfaceC4014c<? super R>, ? extends Object> rVar) {
        return FlowKt__ZipKt.d(bVar, bVar2, bVar3, rVar);
    }

    public static final <T1, T2, R> b<R> n(b<? extends T1> bVar, b<? extends T2> bVar2, p9.q<? super T1, ? super T2, ? super InterfaceC4014c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.e(bVar, bVar2, qVar);
    }

    public static final <T> b<T> o(b<? extends T> bVar) {
        return e.d(bVar);
    }

    public static final <T> b<T> p(b<? extends T> bVar, long j10) {
        return FlowKt__DelayKt.b(bVar, j10);
    }

    public static final <T> b<T> q(b<? extends T> bVar) {
        return i.e(bVar);
    }

    public static final <T> b<T> r(b<? extends T> bVar, p9.p<? super T, ? super T, Boolean> pVar) {
        return i.f(bVar, pVar);
    }

    public static final <T> b<T> s(b<? extends T> bVar, int i10) {
        return FlowKt__LimitKt.a(bVar, i10);
    }

    public static final <T> b<T> t(b<? extends T> bVar, p9.p<? super T, ? super InterfaceC4014c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.b(bVar, pVar);
    }

    public static final <T> Object u(c<? super T> cVar, Wa.r<? extends T> rVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return FlowKt__ChannelsKt.b(cVar, rVar, interfaceC4014c);
    }

    public static final <T> Object v(c<? super T> cVar, b<? extends T> bVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return FlowKt__CollectKt.c(cVar, bVar, interfaceC4014c);
    }

    public static final void w(c<?> cVar) {
        FlowKt__EmittersKt.b(cVar);
    }

    public static final <T> b<T> x(b<? extends T> bVar) {
        return FlowKt__TransformKt.a(bVar);
    }

    public static final <T> Object y(b<? extends T> bVar, InterfaceC4014c<? super T> interfaceC4014c) {
        return FlowKt__ReduceKt.a(bVar, interfaceC4014c);
    }

    public static final <T> Object z(b<? extends T> bVar, p9.p<? super T, ? super InterfaceC4014c<? super Boolean>, ? extends Object> pVar, InterfaceC4014c<? super T> interfaceC4014c) {
        return FlowKt__ReduceKt.b(bVar, pVar, interfaceC4014c);
    }
}
