package lb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import mb.C4931a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import pb.B0;
import pb.C0;
import pb.C5112o;
import pb.U0;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u001a/\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00050\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\r\"(\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\"\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u0012\u0004\b\u0017\u0010\u0014\"\"\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00198\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001c\u0010\u0014\"\"\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00198\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u0012\u0004\b\u001f\u0010\u0014¨\u0006!"}, d2 = {"Lw9/d;", "", "clazz", "", "isNullable", "Lkotlinx/serialization/KSerializer;", "m", "(Lw9/d;Z)Lkotlinx/serialization/KSerializer;", "", "Lw9/n;", "types", "Lkotlin/Result;", "n", "(Lw9/d;Ljava/util/List;Z)Ljava/lang/Object;", "Lpb/U0;", Const.INTENT_KEY_APIKEY, "Lpb/U0;", "getSERIALIZERS_CACHE", "()Lpb/U0;", "getSERIALIZERS_CACHE$annotations", "()V", "SERIALIZERS_CACHE", Const.INTENT_KEY_PKGNAME, "getSERIALIZERS_CACHE_NULLABLE$annotations", "SERIALIZERS_CACHE_NULLABLE", "Lpb/B0;", "c", "Lpb/B0;", "getPARAMETRIZED_SERIALIZERS_CACHE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE", Const.INTENT_KEY_UMID, "getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final U0<? extends Object> f37022a = C5112o.a(new InterfaceC5074l() { // from class: lb.n
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return t.k((InterfaceC5745d) obj);
        }
    });

    /* renamed from: b, reason: collision with root package name */
    public static final U0<Object> f37023b = C5112o.a(new InterfaceC5074l() { // from class: lb.o
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return t.l((InterfaceC5745d) obj);
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final B0<? extends Object> f37024c = C5112o.b(new p9.p() { // from class: lb.p
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return t.g((InterfaceC5745d) obj, (List) obj2);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public static final B0<Object> f37025d = C5112o.b(new p9.p() { // from class: lb.q
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return t.i((InterfaceC5745d) obj, (List) obj2);
        }
    });

    public static final KSerializer g(InterfaceC5745d clazz, final List types) {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        kotlin.jvm.internal.p.i(types, "types");
        List<KSerializer<Object>> listG = u.g(sb.d.a(), types, true);
        kotlin.jvm.internal.p.f(listG);
        return u.a(clazz, listG, new InterfaceC5063a() { // from class: lb.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.h(types);
            }
        });
    }

    public static final InterfaceC5746e h(List list) {
        return ((InterfaceC5755n) list.get(0)).getClassifier();
    }

    public static final KSerializer i(InterfaceC5745d clazz, final List types) {
        KSerializer kSerializerT;
        kotlin.jvm.internal.p.i(clazz, "clazz");
        kotlin.jvm.internal.p.i(types, "types");
        List<KSerializer<Object>> listG = u.g(sb.d.a(), types, true);
        kotlin.jvm.internal.p.f(listG);
        KSerializer<? extends Object> kSerializerA = u.a(clazz, listG, new InterfaceC5063a() { // from class: lb.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.j(types);
            }
        });
        if (kSerializerA == null || (kSerializerT = C4931a.t(kSerializerA)) == null) {
            return null;
        }
        return kSerializerT;
    }

    public static final InterfaceC5746e j(List list) {
        return ((InterfaceC5755n) list.get(0)).getClassifier();
    }

    public static final KSerializer k(InterfaceC5745d it) {
        kotlin.jvm.internal.p.i(it, "it");
        KSerializer kSerializerF = u.f(it);
        if (kSerializerF != null) {
            return kSerializerF;
        }
        if (C0.l(it)) {
            return new e(it);
        }
        return null;
    }

    public static final KSerializer l(InterfaceC5745d it) {
        KSerializer kSerializerT;
        kotlin.jvm.internal.p.i(it, "it");
        KSerializer kSerializerF = u.f(it);
        if (kSerializerF == null) {
            kSerializerF = C0.l(it) ? new e(it) : null;
        }
        if (kSerializerF == null || (kSerializerT = C4931a.t(kSerializerF)) == null) {
            return null;
        }
        return kSerializerT;
    }

    public static final KSerializer<Object> m(InterfaceC5745d<Object> clazz, boolean z10) {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        if (z10) {
            return f37023b.a(clazz);
        }
        KSerializer<? extends Object> kSerializerA = f37022a.a(clazz);
        if (kSerializerA != null) {
            return kSerializerA;
        }
        return null;
    }

    public static final Object n(InterfaceC5745d<Object> clazz, List<? extends InterfaceC5755n> types, boolean z10) {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        kotlin.jvm.internal.p.i(types, "types");
        return !z10 ? f37024c.a(clazz, types) : f37025d.a(clazz, types);
    }
}
