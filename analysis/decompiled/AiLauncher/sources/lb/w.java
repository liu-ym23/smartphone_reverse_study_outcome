package lb;

import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlinx.serialization.KSerializer;
import mb.C4931a;
import p9.InterfaceC5063a;
import pb.C0;
import pb.C5089c0;
import pb.C5093e0;
import pb.C5094f;
import pb.D0;
import pb.O;
import pb.Q;
import pb.Q0;
import sb.AbstractC5465c;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001d\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\b\u001a-\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r\u001a9\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u000e*\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0012*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\"\b\b\u0000\u0010\u0012*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0015\u001aI\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00132\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a9\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00132\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aI\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00132\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002¢\u0006\u0004\b\u001f\u0010\u001c\u001a3\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\"\b\b\u0000\u0010\u0012*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lw9/n;", "type", "Lkotlinx/serialization/KSerializer;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lw9/n;)Lkotlinx/serialization/KSerializer;", "Lsb/c;", "f", "(Lsb/c;Lw9/n;)Lkotlinx/serialization/KSerializer;", "k", "", "failOnMissingTypeArgSerializer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lsb/c;Lw9/n;Z)Lkotlinx/serialization/KSerializer;", "", "typeArguments", "m", "(Lsb/c;Ljava/util/List;Z)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw9/d;)Lkotlinx/serialization/KSerializer;", "l", "serializers", "Lkotlin/Function0;", "Lw9/e;", "elementClassifierIfArray", "e", "(Lw9/d;Ljava/util/List;Lp9/a;)Lkotlinx/serialization/KSerializer;", "c", "(Lw9/d;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "shouldBeNullable", Const.INTENT_KEY_UMID, "(Lkotlinx/serialization/KSerializer;Z)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class w {
    public static final KSerializer<? extends Object> b(InterfaceC5745d<Object> interfaceC5745d, List<? extends KSerializer<Object>> list, InterfaceC5063a<? extends InterfaceC5746e> interfaceC5063a) {
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Collection.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(List.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(List.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(ArrayList.class))) {
            return new C5094f(list.get(0));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(HashSet.class))) {
            return new Q(list.get(0));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Set.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Set.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(LinkedHashSet.class))) {
            return new C5093e0(list.get(0));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(HashMap.class))) {
            return new O(list.get(0), list.get(1));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Map.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Map.class)) || kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(LinkedHashMap.class))) {
            return new C5089c0(list.get(0), list.get(1));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Map.Entry.class))) {
            return C4931a.j(list.get(0), list.get(1));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Pair.class))) {
            return C4931a.m(list.get(0), list.get(1));
        }
        if (kotlin.jvm.internal.p.d(interfaceC5745d, kotlin.jvm.internal.t.b(Triple.class))) {
            return C4931a.o(list.get(0), list.get(1), list.get(2));
        }
        if (!C0.o(interfaceC5745d)) {
            return null;
        }
        InterfaceC5746e interfaceC5746eInvoke = interfaceC5063a.invoke();
        kotlin.jvm.internal.p.g(interfaceC5746eInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return C4931a.a((InterfaceC5745d) interfaceC5746eInvoke, list.get(0));
    }

    public static final KSerializer<? extends Object> c(InterfaceC5745d<Object> interfaceC5745d, List<? extends KSerializer<Object>> list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        return C0.d(interfaceC5745d, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final <T> KSerializer<T> d(KSerializer<T> kSerializer, boolean z10) {
        if (z10) {
            return C4931a.t(kSerializer);
        }
        kotlin.jvm.internal.p.g(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<? extends Object> e(InterfaceC5745d<Object> interfaceC5745d, List<? extends KSerializer<Object>> serializers, InterfaceC5063a<? extends InterfaceC5746e> elementClassifierIfArray) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        kotlin.jvm.internal.p.i(serializers, "serializers");
        kotlin.jvm.internal.p.i(elementClassifierIfArray, "elementClassifierIfArray");
        KSerializer<? extends Object> kSerializerB = b(interfaceC5745d, serializers, elementClassifierIfArray);
        return kSerializerB == null ? c(interfaceC5745d, serializers) : kSerializerB;
    }

    public static final KSerializer<Object> f(AbstractC5465c abstractC5465c, InterfaceC5755n type) {
        kotlin.jvm.internal.p.i(abstractC5465c, "<this>");
        kotlin.jvm.internal.p.i(type, "type");
        KSerializer<Object> kSerializerI = i(abstractC5465c, type, true);
        if (kSerializerI != null) {
            return kSerializerI;
        }
        C0.p(D0.c(type));
        throw new KotlinNothingValueException();
    }

    public static final <T> KSerializer<T> g(InterfaceC5745d<T> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        KSerializer<T> kSerializerF = u.f(interfaceC5745d);
        if (kSerializerF != null) {
            return kSerializerF;
        }
        D0.f(interfaceC5745d);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> h(InterfaceC5755n type) {
        kotlin.jvm.internal.p.i(type, "type");
        return u.b(sb.d.a(), type);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlinx.serialization.KSerializer<java.lang.Object> i(sb.AbstractC5465c r6, w9.InterfaceC5755n r7, boolean r8) {
        /*
            w9.d r0 = pb.D0.c(r7)
            boolean r1 = r7.e()
            java.util.List r7 = r7.g()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = Z8.C1174w.x(r7, r3)
            r2.<init>(r3)
            java.util.Iterator r7 = r7.iterator()
        L1d:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L31
            java.lang.Object r3 = r7.next()
            w9.p r3 = (w9.C5757p) r3
            w9.n r3 = pb.D0.g(r3)
            r2.add(r3)
            goto L1d
        L31:
            boolean r7 = r2.isEmpty()
            r3 = 2
            r4 = 0
            if (r7 == 0) goto L4c
            boolean r7 = pb.C0.l(r0)
            if (r7 == 0) goto L47
            kotlinx.serialization.KSerializer r7 = sb.AbstractC5465c.c(r6, r0, r4, r3, r4)
            if (r7 == 0) goto L47
        L45:
            r7 = r4
            goto L60
        L47:
            kotlinx.serialization.KSerializer r7 = lb.t.m(r0, r1)
            goto L60
        L4c:
            boolean r7 = r6.getHasInterfaceContextualSerializers()
            if (r7 == 0) goto L53
            goto L45
        L53:
            java.lang.Object r7 = lb.t.n(r0, r2, r1)
            boolean r5 = kotlin.Result.g(r7)
            if (r5 == 0) goto L5e
            r7 = r4
        L5e:
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
        L60:
            if (r7 == 0) goto L63
            return r7
        L63:
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L84
            kotlinx.serialization.KSerializer r7 = lb.u.f(r0)
            if (r7 != 0) goto La9
            kotlinx.serialization.KSerializer r7 = sb.AbstractC5465c.c(r6, r0, r4, r3, r4)
            if (r7 != 0) goto La9
            boolean r6 = pb.C0.l(r0)
            if (r6 == 0) goto L82
            lb.e r6 = new lb.e
            r6.<init>(r0)
        L80:
            r7 = r6
            goto La9
        L82:
            r7 = r4
            goto La9
        L84:
            java.util.List r7 = lb.u.g(r6, r2, r8)
            if (r7 != 0) goto L8b
            return r4
        L8b:
            lb.v r8 = new lb.v
            r8.<init>()
            kotlinx.serialization.KSerializer r8 = lb.u.a(r0, r7, r8)
            if (r8 != 0) goto La8
            kotlinx.serialization.KSerializer r7 = r6.b(r0, r7)
            if (r7 != 0) goto La9
            boolean r6 = pb.C0.l(r0)
            if (r6 == 0) goto L82
            lb.e r6 = new lb.e
            r6.<init>(r0)
            goto L80
        La8:
            r7 = r8
        La9:
            if (r7 == 0) goto Lb0
            kotlinx.serialization.KSerializer r6 = d(r7, r1)
            return r6
        Lb0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.w.i(sb.c, w9.n, boolean):kotlinx.serialization.KSerializer");
    }

    public static final InterfaceC5746e j(List list) {
        return ((InterfaceC5755n) list.get(0)).getClassifier();
    }

    public static final KSerializer<Object> k(AbstractC5465c abstractC5465c, InterfaceC5755n type) {
        kotlin.jvm.internal.p.i(abstractC5465c, "<this>");
        kotlin.jvm.internal.p.i(type, "type");
        return i(abstractC5465c, type, false);
    }

    public static final <T> KSerializer<T> l(InterfaceC5745d<T> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        KSerializer<T> kSerializerB = C0.b(interfaceC5745d);
        return kSerializerB == null ? Q0.b(interfaceC5745d) : kSerializerB;
    }

    public static final List<KSerializer<Object>> m(AbstractC5465c abstractC5465c, List<? extends InterfaceC5755n> typeArguments, boolean z10) {
        kotlin.jvm.internal.p.i(abstractC5465c, "<this>");
        kotlin.jvm.internal.p.i(typeArguments, "typeArguments");
        if (z10) {
            List<? extends InterfaceC5755n> list = typeArguments;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(u.b(abstractC5465c, (InterfaceC5755n) it.next()));
            }
            return arrayList;
        }
        List<? extends InterfaceC5755n> list2 = typeArguments;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            KSerializer<Object> kSerializerE = u.e(abstractC5465c, (InterfaceC5755n) it2.next());
            if (kSerializerE == null) {
                return null;
            }
            arrayList2.add(kSerializerE);
        }
        return arrayList2;
    }
}
