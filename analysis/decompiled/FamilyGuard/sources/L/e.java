package L;

import V3.v;
import a4.C0428b;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import i4.InterfaceC0772l;
import i4.p;
import java.util.List;

/* loaded from: classes.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3673a = new a(null);

    public static final class a {

        @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT}, m = "invokeSuspend")
        /* renamed from: L.e$a$a, reason: collision with other inner class name */
        static final class C0051a extends kotlin.coroutines.jvm.internal.l implements p<i<T>, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f3674a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f3675b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ List<d<T>> f3676c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0051a(List<? extends d<T>> list, Z3.e<? super C0051a> eVar) {
                super(2, eVar);
                this.f3676c = list;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                C0051a c0051a = new C0051a(this.f3676c, eVar);
                c0051a.f3675b = obj;
                return c0051a;
            }

            @Override // i4.p
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(i<T> iVar, Z3.e<? super v> eVar) {
                return ((C0051a) create(iVar, eVar)).invokeSuspend(v.f5542a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f3674a;
                if (i5 == 0) {
                    V3.o.b(obj);
                    i iVar = (i) this.f3675b;
                    a aVar = e.f3673a;
                    List<d<T>> list = this.f3676c;
                    this.f3674a = 1;
                    if (aVar.c(list, iVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                }
                return v.f5542a;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY, 57}, m = "runMigrations")
        static final class b<T> extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a, reason: collision with root package name */
            Object f3677a;

            /* renamed from: b, reason: collision with root package name */
            Object f3678b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f3679c;

            /* renamed from: e, reason: collision with root package name */
            int f3681e;

            b(Z3.e<? super b> eVar) {
                super(eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f3679c = obj;
                this.f3681e |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
        static final class c extends kotlin.coroutines.jvm.internal.l implements p<T, Z3.e<? super T>, Object> {

            /* renamed from: a, reason: collision with root package name */
            Object f3682a;

            /* renamed from: b, reason: collision with root package name */
            Object f3683b;

            /* renamed from: c, reason: collision with root package name */
            Object f3684c;

            /* renamed from: d, reason: collision with root package name */
            int f3685d;

            /* renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f3686e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ List<d<T>> f3687f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ List<InterfaceC0772l<Z3.e<? super v>, Object>> f3688g;

            @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
            /* renamed from: L.e$a$c$a, reason: collision with other inner class name */
            static final class C0052a extends kotlin.coroutines.jvm.internal.l implements InterfaceC0772l<Z3.e<? super v>, Object> {

                /* renamed from: a, reason: collision with root package name */
                int f3689a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ d<T> f3690b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0052a(d<T> dVar, Z3.e<? super C0052a> eVar) {
                    super(1, eVar);
                    this.f3690b = dVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Z3.e<v> create(Z3.e<?> eVar) {
                    return new C0052a(this.f3690b, eVar);
                }

                @Override // i4.InterfaceC0772l
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Z3.e<? super v> eVar) {
                    return ((C0052a) create(eVar)).invokeSuspend(v.f5542a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objE = C0428b.e();
                    int i5 = this.f3689a;
                    if (i5 == 0) {
                        V3.o.b(obj);
                        d<T> dVar = this.f3690b;
                        this.f3689a = 1;
                        if (dVar.c(this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        V3.o.b(obj);
                    }
                    return v.f5542a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(List<? extends d<T>> list, List<InterfaceC0772l<Z3.e<? super v>, Object>> list2, Z3.e<? super c> eVar) {
                super(2, eVar);
                this.f3687f = list;
                this.f3688g = list2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                c cVar = new c(this.f3687f, this.f3688g, eVar);
                cVar.f3686e = obj;
                return cVar;
            }

            @Override // i4.p
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(T t5, Z3.e<? super T> eVar) {
                return ((c) create(t5, eVar)).invokeSuspend(v.f5542a);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = a4.C0428b.e()
                    int r1 = r9.f3685d
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L37
                    if (r1 == r3) goto L22
                    if (r1 != r2) goto L1a
                    java.lang.Object r1 = r9.f3682a
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r4 = r9.f3686e
                    java.util.List r4 = (java.util.List) r4
                    V3.o.b(r10)
                    goto L44
                L1a:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L22:
                    java.lang.Object r1 = r9.f3684c
                    java.lang.Object r4 = r9.f3683b
                    L.d r4 = (L.d) r4
                    java.lang.Object r5 = r9.f3682a
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r9.f3686e
                    java.util.List r6 = (java.util.List) r6
                    V3.o.b(r10)
                    r8 = r6
                    r6 = r4
                    r4 = r8
                    goto L66
                L37:
                    V3.o.b(r10)
                    java.lang.Object r10 = r9.f3686e
                    java.util.List<L.d<T>> r1 = r9.f3687f
                    java.util.List<i4.l<Z3.e<? super V3.v>, java.lang.Object>> r4 = r9.f3688g
                    java.util.Iterator r1 = r1.iterator()
                L44:
                    boolean r5 = r1.hasNext()
                    if (r5 == 0) goto L8c
                    java.lang.Object r5 = r1.next()
                    L.d r5 = (L.d) r5
                    r9.f3686e = r4
                    r9.f3682a = r1
                    r9.f3683b = r5
                    r9.f3684c = r10
                    r9.f3685d = r3
                    java.lang.Object r6 = r5.a(r10, r9)
                    if (r6 != r0) goto L61
                    goto L87
                L61:
                    r8 = r1
                    r1 = r10
                    r10 = r6
                    r6 = r5
                    r5 = r8
                L66:
                    java.lang.Boolean r10 = (java.lang.Boolean) r10
                    boolean r10 = r10.booleanValue()
                    if (r10 == 0) goto L8a
                    L.e$a$c$a r10 = new L.e$a$c$a
                    r7 = 0
                    r10.<init>(r6, r7)
                    r4.add(r10)
                    r9.f3686e = r4
                    r9.f3682a = r5
                    r9.f3683b = r7
                    r9.f3684c = r7
                    r9.f3685d = r2
                    java.lang.Object r10 = r6.b(r1, r9)
                    if (r10 != r0) goto L88
                L87:
                    return r0
                L88:
                    r1 = r5
                    goto L44
                L8a:
                    r10 = r1
                    goto L88
                L8c:
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: L.e.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Throwable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0087 -> B:25:0x006a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008a -> B:25:0x006a). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <T> java.lang.Object c(java.util.List<? extends L.d<T>> r6, L.i<T> r7, Z3.e<? super V3.v> r8) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r8 instanceof L.e.a.b
                if (r0 == 0) goto L13
                r0 = r8
                L.e$a$b r0 = (L.e.a.b) r0
                int r1 = r0.f3681e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f3681e = r1
                goto L18
            L13:
                L.e$a$b r0 = new L.e$a$b
                r0.<init>(r8)
            L18:
                java.lang.Object r5 = r0.f3679c
                java.lang.Object r8 = a4.C0428b.e()
                int r1 = r0.f3681e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L46
                if (r1 == r3) goto L3e
                if (r1 != r2) goto L36
                java.lang.Object r6 = r0.f3678b
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r0.f3677a
                j4.v r7 = (j4.v) r7
                V3.o.b(r5)     // Catch: java.lang.Throwable -> L34
                goto L6a
            L34:
                r5 = move-exception
                goto L83
            L36:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L3e:
                java.lang.Object r6 = r0.f3677a
                java.util.List r6 = (java.util.List) r6
                V3.o.b(r5)
                goto L60
            L46:
                V3.o.b(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                L.e$a$c r1 = new L.e$a$c
                r4 = 0
                r1.<init>(r6, r5, r4)
                r0.f3677a = r5
                r0.f3681e = r3
                java.lang.Object r6 = r7.b(r1, r0)
                if (r6 != r8) goto L5f
                goto L82
            L5f:
                r6 = r5
            L60:
                j4.v r5 = new j4.v
                r5.<init>()
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L6a:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L95
                java.lang.Object r5 = r6.next()
                i4.l r5 = (i4.InterfaceC0772l) r5
                r0.f3677a = r7     // Catch: java.lang.Throwable -> L34
                r0.f3678b = r6     // Catch: java.lang.Throwable -> L34
                r0.f3681e = r2     // Catch: java.lang.Throwable -> L34
                java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r5 != r8) goto L6a
            L82:
                return r8
            L83:
                T r1 = r7.f17836a
                if (r1 != 0) goto L8a
                r7.f17836a = r5
                goto L6a
            L8a:
                j4.k.d(r1)
                T r1 = r7.f17836a
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                V3.a.a(r1, r5)
                goto L6a
            L95:
                T r5 = r7.f17836a
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto L9e
                V3.v r5 = V3.v.f5542a
                return r5
            L9e:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: L.e.a.c(java.util.List, L.i, Z3.e):java.lang.Object");
        }

        public final <T> p<i<T>, Z3.e<? super v>, Object> b(List<? extends d<T>> list) {
            j4.k.g(list, "migrations");
            return new C0051a(list, null);
        }

        private a() {
        }
    }
}
