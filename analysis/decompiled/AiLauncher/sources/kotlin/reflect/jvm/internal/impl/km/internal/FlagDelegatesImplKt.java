package kotlin.reflect.jvm.internal.impl.km.internal;

import N9.d;
import N9.g;
import N9.n;
import N9.o;
import N9.q;
import N9.r;
import N9.u;
import O9.a;
import O9.b;
import O9.c;
import Z8.C1174w;
import ea.C4018b;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.km.MemberKind;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import w9.InterfaceC5751j;

/* loaded from: classes5.dex */
public final class FlagDelegatesImplKt {
    public static final a<d> a(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$classBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((d) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((d) obj).s(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final a<g> b(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$constructorBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((g) obj).c());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((g) obj).f(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final a<n> c(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$functionBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((n) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((n) obj).j(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final <Node> b<Node, MemberKind> d(InterfaceC5751j<Node, Integer> flags) {
        p.i(flags, "flags");
        C4018b.d<ProtoBuf$MemberKind> MEMBER_KIND = C4018b.f32390q;
        p.h(MEMBER_KIND, "MEMBER_KIND");
        InterfaceC4149a<MemberKind> entries = MemberKind.getEntries();
        InterfaceC4149a<MemberKind> entries2 = MemberKind.getEntries();
        ArrayList arrayList = new ArrayList(C1174w.x(entries2, 10));
        Iterator<MemberKind> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        return new b<>(flags, MEMBER_KIND, entries, arrayList);
    }

    public static final <Node> b<Node, Modality> e(InterfaceC5751j<Node, Integer> flags) {
        p.i(flags, "flags");
        C4018b.d<ProtoBuf$Modality> MODALITY = C4018b.f32378e;
        p.h(MODALITY, "MODALITY");
        InterfaceC4149a<Modality> entries = Modality.getEntries();
        InterfaceC4149a<Modality> entries2 = Modality.getEntries();
        ArrayList arrayList = new ArrayList(C1174w.x(entries2, 10));
        Iterator<Modality> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        return new b<>(flags, MODALITY, entries, arrayList);
    }

    public static final a<N9.p> f(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$propertyAccessorBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((N9.p) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((N9.p) obj).c(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final a<o> g(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$propertyBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((o) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((o) obj).m(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final a<r> h(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$typeAliasBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((r) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((r) obj).f(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final a<q> i(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$typeBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((q) obj).d());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((q) obj).g(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final a<u> j(c flag) {
        p.i(flag, "flag");
        return new a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$valueParameterBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((u) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((u) obj).d(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final <Node> b<Node, Visibility> k(InterfaceC5751j<Node, Integer> flags) {
        p.i(flags, "flags");
        C4018b.d<ProtoBuf$Visibility> VISIBILITY = C4018b.f32377d;
        p.h(VISIBILITY, "VISIBILITY");
        InterfaceC4149a<Visibility> entries = Visibility.getEntries();
        InterfaceC4149a<Visibility> entries2 = Visibility.getEntries();
        ArrayList arrayList = new ArrayList(C1174w.x(entries2, 10));
        Iterator<Visibility> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        return new b<>(flags, VISIBILITY, entries, arrayList);
    }
}
