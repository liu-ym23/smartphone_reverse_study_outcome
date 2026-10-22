package mb;

import Y8.k;
import Y8.l;
import Y8.m;
import Y8.n;
import Y8.o;
import Y8.r;
import Y8.s;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.C4852c;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;
import kotlin.time.Instant;
import kotlin.time.a;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import pb.C;
import pb.C5082A;
import pb.C5083B;
import pb.C5089c0;
import pb.C5094f;
import pb.C5098h;
import pb.C5099h0;
import pb.C5100i;
import pb.C5101i0;
import pb.C5104k;
import pb.C5105k0;
import pb.C5106l;
import pb.C5116q;
import pb.C5122t0;
import pb.C5124u0;
import pb.C5134z0;
import pb.K;
import pb.L;
import pb.R0;
import pb.U;
import pb.W;
import pb.W0;
import pb.X;
import pb.X0;
import pb.Y0;
import pb.e1;
import pb.h1;
import pb.i1;
import pb.k1;
import pb.l1;
import pb.n1;
import pb.o1;
import pb.q1;
import pb.r;
import pb.r1;
import pb.s1;
import pb.t1;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000Ú\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\u001aG\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001aG\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\u0007\u001aa\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00100\u0002\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b\"\u0004\b\u0002\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002*\u00020\u0013¢\u0006\u0004\b\u000b\u0010\u0015\u001a\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002*\u00020\u0019¢\u0006\u0004\b\n\u0010\u001b\u001a\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002¢\u0006\u0004\b\u001d\u0010\u0018\u001a\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0002H\u0007¢\u0006\u0004\b\u001f\u0010\u0018\u001a\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0002*\u00020 ¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0002¢\u0006\u0004\b%\u0010\u0018\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0002H\u0007¢\u0006\u0004\b'\u0010\u0018\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0002*\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0002¢\u0006\u0004\b-\u0010\u0018\u001a\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0002H\u0007¢\u0006\u0004\b/\u0010\u0018\u001a\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0002*\u000200¢\u0006\u0004\b2\u00103\u001a\u0013\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0002¢\u0006\u0004\b5\u0010\u0018\u001a\u0015\u00107\u001a\b\u0012\u0004\u0012\u0002060\u0002H\u0007¢\u0006\u0004\b7\u0010\u0018\u001a\u0017\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0002*\u000208¢\u0006\u0004\b:\u0010;\u001a\u0013\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u0002¢\u0006\u0004\b=\u0010\u0018\u001a\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020?0\u0002*\u00020>¢\u0006\u0004\b\f\u0010@\u001a\u0013\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u0002¢\u0006\u0004\bB\u0010\u0018\u001a\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020D0\u0002*\u00020C¢\u0006\u0004\bE\u0010F\u001a\u0013\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u0002¢\u0006\u0004\bH\u0010\u0018\u001a\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u0002*\u00020I¢\u0006\u0004\bJ\u0010K\u001a\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u0002*\u00020L¢\u0006\u0004\bN\u0010O\u001aM\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010U0\u0002\"\b\b\u0000\u0010Q*\u00020P\"\n\b\u0001\u0010**\u0004\u0018\u00018\u00002\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000R2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bV\u0010W\u001a-\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000X0\u0002\"\u0004\b\u0000\u0010Q2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\bY\u0010Z\u001aG\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010[0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\\\u0010\u0007\u001a\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020^0\u0002*\u00020]¢\u0006\u0004\b_\u0010`\u001a\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020b0\u0002*\u00020a¢\u0006\u0004\bc\u0010d\u001a\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020f0\u0002*\u00020e¢\u0006\u0004\bg\u0010h\u001a\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020j0\u0002*\u00020i¢\u0006\u0004\bk\u0010l\u001a\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020n0\u0002*\u00020m¢\u0006\u0004\bo\u0010p\u001a\u0019\u0010s\u001a\b\u0012\u0004\u0012\u00020r0\u0002*\u00020qH\u0007¢\u0006\u0004\bs\u0010t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020v0\u0002*\u00020uH\u0007¢\u0006\u0004\b\u0000\u0010w\u001a\u0015\u0010y\u001a\b\u0012\u0004\u0012\u00020x0\u0002H\u0007¢\u0006\u0004\by\u0010\u0018\"3\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\"\b\b\u0000\u0010Q*\u00020P*\b\u0012\u0004\u0012\u00028\u00000\u00028F¢\u0006\f\u0012\u0004\b{\u0010|\u001a\u0004\bz\u0010Z¨\u0006~"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "Lkotlin/Pair;", "m", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "aSerializer", "bSerializer", "cSerializer", "Lkotlin/Triple;", "o", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Lkotlin/Char$Companion;", "", "(Lkotlin/jvm/internal/e;)Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_UMID, "()Lkotlinx/serialization/KSerializer;", "Lkotlin/Byte$Companion;", "", "(Lkotlin/jvm/internal/d;)Lkotlinx/serialization/KSerializer;", "", "c", "LY8/l;", "p", "Lkotlin/Short$Companion;", "", "G", "(Lkotlin/jvm/internal/w;)Lkotlinx/serialization/KSerializer;", "", "n", "LY8/s;", "s", "Lkotlin/Int$Companion;", "", ExifInterface.LONGITUDE_EAST, "(Lkotlin/jvm/internal/o;)Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "LY8/n;", "q", "Lkotlin/Long$Companion;", "", "F", "(Lkotlin/jvm/internal/r;)Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/p;", "r", "Lkotlin/Float$Companion;", "", "D", "(Lkotlin/jvm/internal/k;)Lkotlinx/serialization/KSerializer;", "", "f", "Lkotlin/Double$Companion;", "", "(Lkotlin/jvm/internal/j;)Lkotlinx/serialization/KSerializer;", "", "e", "Lkotlin/Boolean$Companion;", "", "z", "(Lkotlin/jvm/internal/c;)Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_PKGNAME, "LY8/t;", "y", "(LY8/t;)Lkotlinx/serialization/KSerializer;", "Lkotlin/String$Companion;", "", "H", "(Lkotlin/jvm/internal/y;)Lkotlinx/serialization/KSerializer;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "kClass", "elementSerializer", "", Const.INTENT_KEY_APIKEY, "(Lw9/d;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "k", "LY8/m$a;", "LY8/m;", "v", "(LY8/m$a;)Lkotlinx/serialization/KSerializer;", "LY8/o$a;", "LY8/o;", "w", "(LY8/o$a;)Lkotlinx/serialization/KSerializer;", "LY8/k$a;", "LY8/k;", "u", "(LY8/k$a;)Lkotlinx/serialization/KSerializer;", "LY8/r$a;", "LY8/r;", "x", "(LY8/r$a;)Lkotlinx/serialization/KSerializer;", "Lkotlin/time/a$a;", "Lkotlin/time/a;", "I", "(Lkotlin/time/a$a;)Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Instant$a;", "Lkotlin/time/Instant;", "J", "(Lkotlin/time/Instant$a;)Lkotlinx/serialization/KSerializer;", "Lkotlin/uuid/Uuid$a;", "Lkotlin/uuid/Uuid;", "(Lkotlin/uuid/Uuid$a;)Lkotlinx/serialization/KSerializer;", "", "l", "t", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "nullable", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: mb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4931a {
    public static final KSerializer<Byte> A(d dVar) {
        p.i(dVar, "<this>");
        return C5106l.f38380a;
    }

    public static final KSerializer<Character> B(e eVar) {
        p.i(eVar, "<this>");
        return r.f38404a;
    }

    public static final KSerializer<Double> C(j jVar) {
        p.i(jVar, "<this>");
        return C5083B.f38260a;
    }

    public static final KSerializer<Float> D(k kVar) {
        p.i(kVar, "<this>");
        return L.f38300a;
    }

    public static final KSerializer<Integer> E(o oVar) {
        p.i(oVar, "<this>");
        return X.f38325a;
    }

    public static final KSerializer<Long> F(kotlin.jvm.internal.r rVar) {
        p.i(rVar, "<this>");
        return C5101i0.f38365a;
    }

    public static final KSerializer<Short> G(w wVar) {
        p.i(wVar, "<this>");
        return X0.f38327a;
    }

    public static final KSerializer<String> H(y yVar) {
        p.i(yVar, "<this>");
        return Y0.f38329a;
    }

    public static final KSerializer<kotlin.time.a> I(a.Companion companion) {
        p.i(companion, "<this>");
        return C.f38262a;
    }

    public static final KSerializer<Instant> J(Instant.Companion companion) {
        p.i(companion, "<this>");
        return U.f38317a;
    }

    public static final KSerializer<Uuid> K(Uuid.Companion companion) {
        p.i(companion, "<this>");
        return t1.f38423a;
    }

    public static final <T, E extends T> KSerializer<E[]> a(InterfaceC5745d<T> kClass, KSerializer<E> elementSerializer) {
        p.i(kClass, "kClass");
        p.i(elementSerializer, "elementSerializer");
        return new R0(kClass, elementSerializer);
    }

    public static final KSerializer<boolean[]> b() {
        return C5098h.f38360c;
    }

    public static final KSerializer<byte[]> c() {
        return C5104k.f38375c;
    }

    public static final KSerializer<char[]> d() {
        return C5116q.f38402c;
    }

    public static final KSerializer<double[]> e() {
        return C5082A.f38258c;
    }

    public static final KSerializer<float[]> f() {
        return K.f38299c;
    }

    public static final KSerializer<int[]> g() {
        return W.f38323c;
    }

    public static final <T> KSerializer<List<T>> h(KSerializer<T> elementSerializer) {
        p.i(elementSerializer, "elementSerializer");
        return new C5094f(elementSerializer);
    }

    public static final KSerializer<long[]> i() {
        return C5099h0.f38361c;
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> j(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        p.i(keySerializer, "keySerializer");
        p.i(valueSerializer, "valueSerializer");
        return new C5105k0(keySerializer, valueSerializer);
    }

    public static final <K, V> KSerializer<Map<K, V>> k(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        p.i(keySerializer, "keySerializer");
        p.i(valueSerializer, "valueSerializer");
        return new C5089c0(keySerializer, valueSerializer);
    }

    public static final KSerializer l() {
        return C5122t0.f38421a;
    }

    public static final <K, V> KSerializer<Pair<K, V>> m(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        p.i(keySerializer, "keySerializer");
        p.i(valueSerializer, "valueSerializer");
        return new C5134z0(keySerializer, valueSerializer);
    }

    public static final KSerializer<short[]> n() {
        return W0.f38324c;
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> o(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        p.i(aSerializer, "aSerializer");
        p.i(bSerializer, "bSerializer");
        p.i(cSerializer, "cSerializer");
        return new e1(aSerializer, bSerializer, cSerializer);
    }

    public static final KSerializer<l> p() {
        return h1.f38362c;
    }

    public static final KSerializer<n> q() {
        return k1.f38379c;
    }

    public static final KSerializer<Y8.p> r() {
        return n1.f38394c;
    }

    public static final KSerializer<s> s() {
        return q1.f38403c;
    }

    public static final <T> KSerializer<T> t(KSerializer<T> kSerializer) {
        p.i(kSerializer, "<this>");
        return kSerializer.getDescriptor().b() ? kSerializer : new C5124u0(kSerializer);
    }

    public static final KSerializer<Y8.k> u(k.Companion companion) {
        p.i(companion, "<this>");
        return i1.f38367a;
    }

    public static final KSerializer<m> v(m.Companion companion) {
        p.i(companion, "<this>");
        return l1.f38386a;
    }

    public static final KSerializer<Y8.o> w(o.Companion companion) {
        p.i(companion, "<this>");
        return o1.f38396a;
    }

    public static final KSerializer<Y8.r> x(r.Companion companion) {
        p.i(companion, "<this>");
        return r1.f38408a;
    }

    public static final KSerializer<t> y(t tVar) {
        p.i(tVar, "<this>");
        return s1.f38417b;
    }

    public static final KSerializer<Boolean> z(C4852c c4852c) {
        p.i(c4852c, "<this>");
        return C5100i.f38363a;
    }
}
