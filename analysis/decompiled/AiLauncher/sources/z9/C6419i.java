package z9;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import w9.C5757p;
import w9.InterfaceC5747f;
import w9.InterfaceC5755n;
import x9.C5857b;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0010\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a=\u0010\u0012\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011\"*\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0014*\u0004\u0018\u00010\u00000\u00000\u00040\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016\"\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016\"<\u0010#\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\r0 j\u0002`!\u0012\u0004\u0012\u00020\u000f0\u001f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016*0\b\u0002\u0010$\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\r0 2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\r0 ¨\u0006%"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/e;", "m", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/e;", "Lw9/f;", "n", "(Ljava/lang/Class;)Lw9/f;", "", "Lw9/p;", "arguments", "", "isMarkedNullable", "Lw9/n;", "k", "(Ljava/lang/Class;Ljava/util/List;Z)Lw9/n;", "l", "Lz9/b;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_APIKEY, "Lz9/b;", "K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/k;", Const.INTENT_KEY_PKGNAME, "K_PACKAGE_CACHE", "c", "CACHE_FOR_BASE_CLASSIFIERS", Const.INTENT_KEY_UMID, "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Lkotlin/reflect/jvm/internal/Key;", "e", "CACHE_FOR_GENERIC_CLASSIFIERS", "Key", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: z9.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6419i {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC6405b<kotlin.reflect.jvm.internal.e<? extends Object>> f45356a = C6407c.a(C6409d.f45342a);

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC6405b<kotlin.reflect.jvm.internal.k> f45357b = C6407c.a(C6411e.f45348a);

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC6405b<InterfaceC5755n> f45358c = C6407c.a(C6413f.f45350a);

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC6405b<InterfaceC5755n> f45359d = C6407c.a(C6415g.f45352a);

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC6405b<ConcurrentHashMap<Pair<List<C5757p>, Boolean>, InterfaceC5755n>> f45360e = C6407c.a(C6417h.f45354a);

    public static final InterfaceC5755n a(Class it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C5857b.b(m(it), C1173v.m(), false, C1173v.m());
    }

    public static final ConcurrentHashMap b(Class it) {
        kotlin.jvm.internal.p.i(it, "it");
        return new ConcurrentHashMap();
    }

    public static final InterfaceC5755n c(Class it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C5857b.b(m(it), C1173v.m(), true, C1173v.m());
    }

    public static final kotlin.reflect.jvm.internal.e d(Class it) {
        kotlin.jvm.internal.p.i(it, "it");
        return new kotlin.reflect.jvm.internal.e(it);
    }

    public static final kotlin.reflect.jvm.internal.k e(Class it) {
        kotlin.jvm.internal.p.i(it, "it");
        return new kotlin.reflect.jvm.internal.k(it);
    }

    public static final <T> InterfaceC5755n k(Class<T> jClass, List<C5757p> arguments, boolean z10) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        return arguments.isEmpty() ? z10 ? f45359d.a(jClass) : f45358c.a(jClass) : l(jClass, arguments, z10);
    }

    public static final <T> InterfaceC5755n l(Class<T> cls, List<C5757p> list, boolean z10) {
        ConcurrentHashMap<Pair<List<C5757p>, Boolean>, InterfaceC5755n> concurrentHashMapA = f45360e.a(cls);
        Pair<List<C5757p>, Boolean> pairA = Y8.j.a(list, Boolean.valueOf(z10));
        InterfaceC5755n interfaceC5755n = concurrentHashMapA.get(pairA);
        if (interfaceC5755n == null) {
            InterfaceC5755n interfaceC5755nB = C5857b.b(m(cls), list, z10, C1173v.m());
            InterfaceC5755n interfaceC5755nPutIfAbsent = concurrentHashMapA.putIfAbsent(pairA, interfaceC5755nB);
            interfaceC5755n = interfaceC5755nPutIfAbsent == null ? interfaceC5755nB : interfaceC5755nPutIfAbsent;
        }
        kotlin.jvm.internal.p.h(interfaceC5755n, "getOrPut(...)");
        return interfaceC5755n;
    }

    public static final <T> kotlin.reflect.jvm.internal.e<T> m(Class<T> jClass) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        kotlin.jvm.internal.f fVarA = f45356a.a(jClass);
        kotlin.jvm.internal.p.g(fVarA, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (kotlin.reflect.jvm.internal.e) fVarA;
    }

    public static final <T> InterfaceC5747f n(Class<T> jClass) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        return f45357b.a(jClass);
    }
}
