package a4;

import V3.o;
import V3.v;
import Z3.e;
import Z3.i;
import i4.p;
import j4.k;
import j4.z;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: a4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0429c {

    /* renamed from: a4.c$a */
    public static final class a extends j {

        /* renamed from: a, reason: collision with root package name */
        private int f7282a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f7283b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f7284c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, p pVar, Object obj) {
            super(eVar);
            this.f7283b = pVar;
            this.f7284c = obj;
            k.e(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i5 = this.f7282a;
            if (i5 == 0) {
                this.f7282a = 1;
                o.b(obj);
                k.e(this.f7283b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) z.b(this.f7283b, 2)).invoke(this.f7284c, this);
            }
            if (i5 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f7282a = 2;
            o.b(obj);
            return obj;
        }
    }

    /* renamed from: a4.c$b */
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        private int f7285a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f7286b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f7287c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, i iVar, p pVar, Object obj) {
            super(eVar, iVar);
            this.f7286b = pVar;
            this.f7287c = obj;
            k.e(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i5 = this.f7285a;
            if (i5 == 0) {
                this.f7285a = 1;
                o.b(obj);
                k.e(this.f7286b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) z.b(this.f7286b, 2)).invoke(this.f7287c, this);
            }
            if (i5 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f7285a = 2;
            o.b(obj);
            return obj;
        }
    }

    /* renamed from: a4.c$c, reason: collision with other inner class name */
    public static final class C0099c extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0099c(e<? super T> eVar) {
            super(eVar);
            k.e(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            o.b(obj);
            return obj;
        }
    }

    /* renamed from: a4.c$d */
    public static final class d extends kotlin.coroutines.jvm.internal.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(e<? super T> eVar, i iVar) {
            super(eVar, iVar);
            k.e(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            o.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> e<v> a(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r5, e<? super T> eVar) {
        k.g(pVar, "<this>");
        k.g(eVar, "completion");
        e<?> eVarA = h.a(eVar);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r5, eVarA);
        }
        i context = eVarA.getContext();
        return context == Z3.j.f6656a ? new a(eVarA, pVar, r5) : new b(eVarA, context, pVar, r5);
    }

    private static final <T> e<T> b(e<? super T> eVar) {
        i context = eVar.getContext();
        return context == Z3.j.f6656a ? new C0099c(eVar) : new d(eVar, context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> e<T> c(e<? super T> eVar) {
        e<T> eVar2;
        k.g(eVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar = eVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) eVar : null;
        return (dVar == null || (eVar2 = (e<T>) dVar.intercepted()) == null) ? eVar : eVar2;
    }

    public static <R, T> Object d(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r5, e<? super T> eVar) {
        k.g(pVar, "<this>");
        k.g(eVar, "completion");
        return ((p) z.b(pVar, 2)).invoke(r5, b(h.a(eVar)));
    }
}
