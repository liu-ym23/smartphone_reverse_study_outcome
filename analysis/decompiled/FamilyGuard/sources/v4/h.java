package v4;

import V3.v;
import a4.C0428b;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import j4.s;

/* loaded from: classes.dex */
final /* synthetic */ class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements InterfaceC1193b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1193b f23352a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i4.p f23353b;

        public a(InterfaceC1193b interfaceC1193b, i4.p pVar) {
            this.f23352a = interfaceC1193b;
            this.f23353b = pVar;
        }

        @Override // v4.InterfaceC1193b
        public Object a(InterfaceC1194c<? super T> interfaceC1194c, Z3.e<? super v> eVar) {
            Object objA = this.f23352a.a(new b(new s(), interfaceC1194c, this.f23353b), eVar);
            return objA == C0428b.e() ? objA : v.f5542a;
        }
    }

    static final class b<T> implements InterfaceC1194c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f23354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC1194c<T> f23355b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i4.p<T, Z3.e<? super Boolean>, Object> f23356c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT, PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF, PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE}, m = "emit")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a, reason: collision with root package name */
            Object f23357a;

            /* renamed from: b, reason: collision with root package name */
            Object f23358b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f23359c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b<T> f23360d;

            /* renamed from: e, reason: collision with root package name */
            int f23361e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, Z3.e<? super a> eVar) {
                super(eVar);
                this.f23360d = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f23359c = obj;
                this.f23361e |= Integer.MIN_VALUE;
                return this.f23360d.g(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(s sVar, InterfaceC1194c<? super T> interfaceC1194c, i4.p<? super T, ? super Z3.e<? super Boolean>, ? extends Object> pVar) {
            this.f23354a = sVar;
            this.f23355b = interfaceC1194c;
            this.f23356c = pVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            if (r6.g(r7, r0) == r1) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        
            if (r6.g(r7, r0) == r1) goto L32;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // v4.InterfaceC1194c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object g(T r7, Z3.e<? super V3.v> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof v4.h.b.a
                if (r0 == 0) goto L13
                r0 = r8
                v4.h$b$a r0 = (v4.h.b.a) r0
                int r1 = r0.f23361e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f23361e = r1
                goto L18
            L13:
                v4.h$b$a r0 = new v4.h$b$a
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f23359c
                java.lang.Object r1 = a4.C0428b.e()
                int r2 = r0.f23361e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                V3.o.b(r8)
                goto L87
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                java.lang.Object r7 = r0.f23358b
                java.lang.Object r6 = r0.f23357a
                v4.h$b r6 = (v4.h.b) r6
                V3.o.b(r8)
                goto L6b
            L41:
                V3.o.b(r8)
                goto L59
            L45:
                V3.o.b(r8)
                j4.s r8 = r6.f23354a
                boolean r8 = r8.f17833a
                if (r8 == 0) goto L5c
                v4.c<T> r6 = r6.f23355b
                r0.f23361e = r5
                java.lang.Object r6 = r6.g(r7, r0)
                if (r6 != r1) goto L59
                goto L86
            L59:
                V3.v r6 = V3.v.f5542a
                return r6
            L5c:
                i4.p<T, Z3.e<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f23356c
                r0.f23357a = r6
                r0.f23358b = r7
                r0.f23361e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                goto L86
            L6b:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8a
                j4.s r8 = r6.f23354a
                r8.f17833a = r5
                v4.c<T> r6 = r6.f23355b
                r8 = 0
                r0.f23357a = r8
                r0.f23358b = r8
                r0.f23361e = r3
                java.lang.Object r6 = r6.g(r7, r0)
                if (r6 != r1) goto L87
            L86:
                return r1
            L87:
                V3.v r6 = V3.v.f5542a
                return r6
            L8a:
                V3.v r6 = V3.v.f5542a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: v4.h.b.g(java.lang.Object, Z3.e):java.lang.Object");
        }
    }

    public static final <T> InterfaceC1193b<T> a(InterfaceC1193b<? extends T> interfaceC1193b, i4.p<? super T, ? super Z3.e<? super Boolean>, ? extends Object> pVar) {
        return new a(interfaceC1193b, pVar);
    }
}
