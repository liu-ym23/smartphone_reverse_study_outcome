package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.K;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
interface v0 {

    public enum a {
        ASCENDING,
        DESCENDING
    }

    void A(int i5, List<Boolean> list, boolean z5);

    void B(int i5, List<Integer> list, boolean z5);

    void C(int i5, List<Long> list, boolean z5);

    void D(int i5, long j5);

    void E(int i5, float f5);

    @Deprecated
    void F(int i5);

    void G(int i5, List<Integer> list, boolean z5);

    void H(int i5, int i6);

    void I(int i5, List<Long> list, boolean z5);

    void J(int i5, List<Integer> list, boolean z5);

    void K(int i5, List<Double> list, boolean z5);

    <K, V> void L(int i5, K.a<K, V> aVar, Map<K, V> map);

    void M(int i5, int i6);

    void N(int i5, List<AbstractC0488h> list);

    @Deprecated
    void O(int i5, Object obj, h0 h0Var);

    void a(int i5, List<Float> list, boolean z5);

    void b(int i5, int i6);

    void c(int i5, Object obj);

    void d(int i5, int i6);

    void e(int i5, double d6);

    void f(int i5, List<Long> list, boolean z5);

    void g(int i5, List<Long> list, boolean z5);

    void h(int i5, long j5);

    a i();

    void j(int i5, List<?> list, h0 h0Var);

    void k(int i5, List<String> list);

    @Deprecated
    void l(int i5, List<?> list, h0 h0Var);

    void m(int i5, String str);

    void n(int i5, long j5);

    void o(int i5, List<Integer> list, boolean z5);

    void p(int i5, long j5);

    void q(int i5, boolean z5);

    void r(int i5, int i6);

    @Deprecated
    void s(int i5);

    void t(int i5, int i6);

    void u(int i5, List<Long> list, boolean z5);

    void v(int i5, List<Integer> list, boolean z5);

    void w(int i5, AbstractC0488h abstractC0488h);

    void x(int i5, long j5);

    void y(int i5, List<Integer> list, boolean z5);

    void z(int i5, Object obj, h0 h0Var);
}
