package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface v0 {
    void A(List<Integer> list);

    long B();

    String C();

    int D();

    void E(List<String> list);

    void F(List<Float> list);

    @Deprecated
    <T> void G(List<T> list, w0<T> w0Var, m mVar);

    boolean H();

    int I();

    void J(List<ByteString> list);

    void K(List<Double> list);

    long L();

    String M();

    <T> T a(w0<T> w0Var, m mVar);

    long b();

    void c(List<Integer> list);

    void d(List<Long> list);

    boolean e();

    long f();

    void g(List<Long> list);

    int getTag();

    int h();

    void i(List<Long> list);

    void j(List<Integer> list);

    int k();

    int l();

    void m(List<Boolean> list);

    void n(List<String> list);

    ByteString o();

    int p();

    <T> void q(List<T> list, w0<T> w0Var, m mVar);

    void r(List<Long> list);

    double readDouble();

    float readFloat();

    @Deprecated
    <T> T s(w0<T> w0Var, m mVar);

    void t(List<Integer> list);

    long u();

    void v(List<Integer> list);

    int w();

    void x(List<Long> list);

    void y(List<Integer> list);

    <K, V> void z(Map<K, V> map, c0.a<K, V> aVar, m mVar);
}
