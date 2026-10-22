package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f66079c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<STATE> f66080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<STATE, EVENT, SIDE_EFFECT> f66081b;

    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public STATE f66082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> f66083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f66084c;

        public final class StateDefinitionBuilder<S extends STATE> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b.a<STATE, EVENT, SIDE_EFFECT> f66085a;

            public StateDefinitionBuilder() {
                this.f66085a = new b.a();
            }

            public final void c(final Function2 r100) {
                Intrinsics.checkNotNullParameter(r100, "listener");
                List<Function2<STATE, EVENT, Unit>> r101 = this.f66085a.f66092a;
                ArrayList r102 = (ArrayList) r101;
                r102.add(new StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$$inlined$with$lambda$1(r100));
            }

            public static b.a.C1094a a(StateDefinitionBuilder r100, Object r101) {
                r100.getClass();
                Intrinsics.checkNotNullParameter(r101, "$this$dontTransition");
                return d(r101, r101, null);
            }

            public final <E extends EVENT> void b(Matcher<EVENT, ? extends E> r100, final Function2<? super S, ? super E, ? extends b.a.C1094a<? extends STATE, ? extends SIDE_EFFECT>> r101) {
                Intrinsics.checkNotNullParameter(r100, "eventMatcher");
                Intrinsics.checkNotNullParameter(r101, "createTransitionTo");
                this.f66085a.f66094c.put((Matcher<EVENT, EVENT>) r100, (Function2<STATE, EVENT, b.a.C1094a<STATE, SIDE_EFFECT>>) new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(r101));
            }

            public static b.a.C1094a d(Object r100, Object r101, Object r102) {
                Intrinsics.checkNotNullParameter(r100, "$this$transitionTo");
                Intrinsics.checkNotNullParameter(r101, "state");
                return new b.a.C1094a(r101, r102);
            }
        }

        public GraphBuilder() {
            this(null);
        }

        public GraphBuilder(b<STATE, EVENT, SIDE_EFFECT> r100) {
            if (r100 == null) goto L5;
            STATE r101 = r100.f66089a;
        L6:
            this.f66082a = r101;
            if (r100 == null) goto L10;
            Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = r100.f66090b;
            if (r102 == null) goto L10;
        L11:
            this.f66083b = new LinkedHashMap(r102);
            if (r100 == null) goto L16;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r103 = r100.f66091c;
            if (r103 == null) goto L16;
        L17:
            this.f66084c = new ArrayList(r103);
            return;
        L16:
            r103 = CollectionsKt.emptyList();
        L10:
            r102 = MapsKt.emptyMap();
            goto L11
        L5:
            r101 = null;
            goto L6
        }

        public final void a(STATE r100) {
            Intrinsics.checkNotNullParameter(r100, "initialState");
            this.f66082a = r100;
        }

        public final void b(Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f66084c.add(r100);
        }

        public final <S extends STATE> void c(Matcher<STATE, ? extends S> r100, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "stateMatcher");
            Intrinsics.checkNotNullParameter(r101, "init");
            LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = this.f66083b;
            StateDefinitionBuilder r103 = new StateDefinitionBuilder();
            r101.invoke(r103);
            r102.put(r100, r103.f66085a);
        }
    }

    public static final class Matcher<T, R extends T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f66086c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Function1<T, Boolean>> f66087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f66088b;

        public static final class a {
            public static Matcher a(Class r100) {
                Intrinsics.checkNotNullParameter(r100, "clazz");
                return new Matcher(r100);
            }
        }

        static {
        }

        public Matcher() {
            throw null;
        }

        public Matcher(Class r100) {
            this.f66088b = r100;
            this.f66087a = CollectionsKt.mutableListOf(new Function1[]{new StateMachine$Matcher$predicates$1(this)});
        }

        public final boolean a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            List<Function1<T, Boolean>> r101 = this.f66087a;
            if ((r101 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r102 = r101.iterator();
        L9:
            if (r102.hasNext() == false) goto L18;
            if (((Boolean) ((Function1) r102.next()).invoke(r100)).booleanValue() == true) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (r101.isEmpty() == false) goto L7;
            return true;
        }

        public final void b(final Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "predicate");
            this.f66087a.add((Function1<T, Boolean>) new StateMachine$Matcher$where$$inlined$apply$lambda$1(r100));
        }
    }

    public static final class a {
        public a() {
        }

        public static StateMachine a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "init");
            GraphBuilder r101 = new GraphBuilder(null);
            r100.invoke(r101);
            STATE r102 = r101.f66082a;
            if (r102 == null) goto L7;
            return new StateMachine(new b(r102, MapsKt.toMap(r101.f66083b), CollectionsKt.toList(r101.f66084c)));
        L7:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class b<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final STATE f66089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> f66090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f66091c;

        public static final class a<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f66092a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f66093b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, C1094a<STATE, SIDE_EFFECT>>> f66094c;

            /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.StateMachine$b$a$a, reason: collision with other inner class name */
            public static final class C1094a<STATE, SIDE_EFFECT> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final STATE f66095a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final SIDE_EFFECT f66096b;

                public final boolean equals(Object r100) {
                    if (this != r100) goto L4;
                    return true;
                L4:
                    if ((r100 instanceof C1094a) == false) goto L10;
                    C1094a r101 = (C1094a) r100;
                    if (Intrinsics.areEqual(this.f66095a, r101.f66095a) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.f66096b, r101.f66096b) == true) goto L16;
                    return false;
                L16:
                    return true;
                L10:
                    return false;
                }

                public final int hashCode() {
                    STATE r100 = this.f66095a;
                    int r101 = 0;
                    if (r100 == null) goto L5;
                    int r102 = r100.hashCode();
                L6:
                    int r103 = r102 * 31;
                    SIDE_EFFECT r104 = this.f66096b;
                    if (r104 == null) goto L10;
                    r101 = r104.hashCode();
                L10:
                    return r103 + r101;
                L5:
                    r102 = 0;
                    goto L6
                }

                public final String toString() {
                    return "TransitionTo(toState=" + this.f66095a + ", sideEffect=" + this.f66096b + ")";
                }

                public C1094a(STATE r100, SIDE_EFFECT r101) {
                    Intrinsics.checkNotNullParameter(r100, "toState");
                    this.f66095a = r100;
                    this.f66096b = r101;
                }
            }

            public a() {
                this.f66092a = new ArrayList();
                this.f66093b = new ArrayList();
                this.f66094c = new LinkedHashMap();
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f66089a, r101.f66089a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f66090b, r101.f66090b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f66091c, r101.f66091c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            STATE r100 = this.f66089a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r104 = this.f66090b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r107 = this.f66091c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Graph(initialState=" + this.f66089a + ", stateDefinitions=" + this.f66090b + ", onTransitionListeners=" + this.f66091c + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(STATE r100, Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r101, List<? extends Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r102) {
            Intrinsics.checkNotNullParameter(r100, "initialState");
            Intrinsics.checkNotNullParameter(r101, "stateDefinitions");
            Intrinsics.checkNotNullParameter(r102, "onTransitionListeners");
            this.f66089a = r100;
            this.f66090b = r101;
            this.f66091c = r102;
        }
    }

    public static abstract class c<STATE, EVENT, SIDE_EFFECT> {

        public static final class a<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f66097a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f66098b;

            public final int hashCode() {
                STATE r100 = this.f66097a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                EVENT r104 = this.f66098b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Invalid(fromState=" + this.f66097a + ", event=" + this.f66098b + ")";
            }

            @Override // com.bytedance.android.live.core.utils.StateMachine.c
            public final EVENT a() {
                return this.f66098b;
            }

            @Override // com.bytedance.android.live.core.utils.StateMachine.c
            public final STATE b() {
                return this.f66097a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L10;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f66097a, r101.f66097a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f66098b, r101.f66098b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public a(STATE r100, EVENT r101) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                this.f66097a = r100;
                this.f66098b = r101;
            }
        }

        public static final class b<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f66099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f66100b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final STATE f66101c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final SIDE_EFFECT f66102d;

            public final int hashCode() {
                STATE r100 = this.f66099a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                EVENT r104 = this.f66100b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                STATE r107 = this.f66101c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                SIDE_EFFECT r110 = this.f66102d;
                if (r110 == null) goto L18;
                r101 = r110.hashCode();
            L18:
                return r109 + r101;
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Valid(fromState=" + this.f66099a + ", event=" + this.f66100b + ", toState=" + this.f66101c + ", sideEffect=" + this.f66102d + ")";
            }

            @Override // com.bytedance.android.live.core.utils.StateMachine.c
            public final EVENT a() {
                return this.f66100b;
            }

            @Override // com.bytedance.android.live.core.utils.StateMachine.c
            public final STATE b() {
                return this.f66099a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L14;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f66099a, r101.f66099a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f66100b, r101.f66100b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f66101c, r101.f66101c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f66102d, r101.f66102d) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public b(STATE r100, EVENT r101, STATE r102, SIDE_EFFECT r103) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                Intrinsics.checkNotNullParameter(r102, "toState");
                this.f66099a = r100;
                this.f66100b = r101;
                this.f66101c = r102;
                this.f66102d = r103;
            }
        }

        public c() {
        }

        public abstract EVENT a();

        public abstract STATE b();
    }

    static {
        f66079c = new a();
    }

    public final STATE b() {
        return this.f66080a.get();
    }

    public StateMachine(b r100) {
        this.f66081b = r100;
        this.f66080a = new AtomicReference(r100.f66089a);
    }

    public final b.a<STATE, EVENT, SIDE_EFFECT> a(STATE r100) {
        Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r101 = this.f66081b.f66090b;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r104 = r103.next();
        if (r104.getKey().a(r100) == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        ArrayList r105 = new ArrayList(r102.size());
        Iterator r106 = r102.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add((b.a) ((Map.Entry) r106.next()).getValue());
        goto L10
    L12:
        b.a<STATE, EVENT, SIDE_EFFECT> r107 = (b.a) CollectionsKt.firstOrNull(r105);
        if (r107 == null) goto L16;
        return r107;
    L16:
        throw new IllegalStateException(("Missing definition for state " + r100.getClass().getSimpleName() + '!').toString());
    }

    public final c<STATE, EVENT, SIDE_EFFECT> c(STATE r100, EVENT r101) {
        Iterator<Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C1094a<STATE, SIDE_EFFECT>>>> r102 = a(r100).f66094c.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C1094a<STATE, SIDE_EFFECT>>> r103 = r102.next();
        Matcher<EVENT, EVENT> r104 = r103.getKey();
        Function2<STATE, EVENT, b.a.C1094a<STATE, SIDE_EFFECT>> r105 = r103.getValue();
        if (r104.a(r101) == false) goto L4;
        b.a.C1094a<STATE, SIDE_EFFECT> r106 = r105.invoke(r100, r101);
        return new c.b(r100, r101, r106.f66095a, r106.f66096b);
    L10:
        return new c.a(r100, r101);
    }

    public final c<STATE, EVENT, SIDE_EFFECT> d(EVENT r100, Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        monitor-enter(this);
        c<STATE, EVENT, SIDE_EFFECT> r102 = c(this.f66080a.get(), r100);     // Catch: Throwable -> L38
        if (r101 == null) goto L8;
        Unit r103 = r101.invoke(r102);     // Catch: Throwable -> L38
    L8:
        if ((r102 instanceof c.b) == false) goto L10;
        this.f66080a.set(((c.b) r102).f66101c);     // Catch: Throwable -> L38
    L10:
        monitor-exit(this);
        Iterator<T> r104 = this.f66081b.f66091c.iterator();     // Catch: Throwable -> L17
    L14:
        if (r104.hasNext() == false) goto L20;
        ((Function1) r104.next()).invoke(r102);     // Catch: Throwable -> L17
    L20:
        if ((r102 instanceof c.b) == false) goto L37;
        c.b r105 = (c.b) r102;
        STATE r106 = r105.f66099a;
        Iterator r107 = ((ArrayList) a(r106).f66093b).iterator();     // Catch: Throwable -> L27
    L24:
        if (r107.hasNext() == false) goto L29;
        ((Function2) r107.next()).invoke(r106, r100);     // Catch: Throwable -> L27
    L29:
        STATE r108 = r105.f66101c;
        Iterator r109 = ((ArrayList) a(r108).f66092a).iterator();     // Catch: Throwable -> L35
    L32:
        if (r109.hasNext() == false) goto L37;
        ((Function2) r109.next()).invoke(r108, r100);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        SafetyGuard.c(null, th, "StateMachine notifyOnEnter error");
    L27:
        th = move-exception;
        SafetyGuard.c(null, th, "StateMachine notifyOnExit error");
    L37:
        return r102;
    L17:
        th = move-exception;
        SafetyGuard.c(null, th, "StateMachine notifyOnTransition error");
    L38:
        th = move-exception;
        throw th;
    }
}
