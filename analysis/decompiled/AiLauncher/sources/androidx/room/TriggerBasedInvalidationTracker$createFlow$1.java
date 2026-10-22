package androidx.room;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LXa/c;", "", "", "LY8/t;", "<anonymous>", "(LXa/c;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", l = {239, 239, 243}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1 extends SuspendLambda implements p9.p<Xa.c<? super Set<? extends String>>, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14559a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14560b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14561c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int[] f14562d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f14563e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String[] f14564f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1", f = "InvalidationTracker.kt", l = {239}, m = "invokeSuspend")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f14565a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TriggerBasedInvalidationTracker f14566b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f14566b = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f14566b, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f14565a;
            if (i10 == 0) {
                C4849c.b(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.f14566b;
                this.f14565a = 1;
                if (triggerBasedInvalidationTracker.x(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Xa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<int[]> f14567a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14568b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Xa.c<Set<String>> f14569c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String[] f14570d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int[] f14571e;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Ref$ObjectRef<int[]> ref$ObjectRef, boolean z10, Xa.c<? super Set<String>> cVar, String[] strArr, int[] iArr) {
            this.f14567a = ref$ObjectRef;
            this.f14568b = z10;
            this.f14569c = cVar;
            this.f14570d = strArr;
            this.f14571e = iArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
        
            return r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(int[] r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) r0
                int r1 = r0.f14575d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f14575d = r1
                goto L18
            L13:
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.f14573b
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.f14575d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L39
                if (r2 == r4) goto L31
                if (r2 != r3) goto L29
                goto L31
            L29:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L31:
                java.lang.Object r13 = r0.f14572a
                int[] r13 = (int[]) r13
                kotlin.C4849c.b(r14)
                goto L9f
            L39:
                kotlin.C4849c.b(r14)
                kotlin.jvm.internal.Ref$ObjectRef<int[]> r14 = r12.f14567a
                T r2 = r14.f34820a
                if (r2 != 0) goto L59
                boolean r14 = r12.f14568b
                if (r14 == 0) goto L9f
                Xa.c<java.util.Set<java.lang.String>> r14 = r12.f14569c
                java.lang.String[] r2 = r12.f14570d
                java.util.Set r2 = Z8.r.i1(r2)
                r0.f14572a = r13
                r0.f14575d = r4
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto L9f
                goto L9e
            L59:
                java.lang.String[] r2 = r12.f14570d
                int[] r4 = r12.f14571e
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                int r6 = r2.length
                r7 = 0
                r8 = r7
            L65:
                if (r7 >= r6) goto L88
                r9 = r2[r7]
                int r10 = r8 + 1
                T r11 = r14.f34820a
                if (r11 == 0) goto L80
                int[] r11 = (int[]) r11
                r8 = r4[r8]
                r11 = r11[r8]
                r8 = r13[r8]
                if (r11 == r8) goto L7c
                r5.add(r9)
            L7c:
                int r7 = r7 + 1
                r8 = r10
                goto L65
            L80:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "Required value was null."
                r12.<init>(r13)
                throw r12
            L88:
                boolean r14 = r5.isEmpty()
                if (r14 != 0) goto L9f
                Xa.c<java.util.Set<java.lang.String>> r14 = r12.f14569c
                java.util.Set r2 = Z8.F.r1(r5)
                r0.f14572a = r13
                r0.f14575d = r3
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto L9f
            L9e:
                return r1
            L9f:
                kotlin.jvm.internal.Ref$ObjectRef<int[]> r12 = r12.f14567a
                r12.f34820a = r13
                Y8.t r12 = Y8.t.f7040a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2.emit(int[], e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z10, String[] strArr, InterfaceC4014c<? super TriggerBasedInvalidationTracker$createFlow$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14561c = triggerBasedInvalidationTracker;
        this.f14562d = iArr;
        this.f14563e = z10;
        this.f14564f = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.f14561c, this.f14562d, this.f14563e, this.f14564f, interfaceC4014c);
        triggerBasedInvalidationTracker$createFlow$1.f14560b = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Xa.c<? super Set<String>> cVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(cVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if (Ua.C1056g.j((kotlin.coroutines.d) r12, r5, r11) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
    
        if (r12.a(r4, r11) != r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.f14559a
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L33
            if (r1 == r5) goto L2b
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1a
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1a:
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L1f
            goto L95
        L1f:
            r0 = move-exception
            r12 = r0
            goto L9b
        L23:
            java.lang.Object r1 = r11.f14560b
            Xa.c r1 = (Xa.c) r1
            kotlin.C4849c.b(r12)
            goto L71
        L2b:
            java.lang.Object r1 = r11.f14560b
            Xa.c r1 = (Xa.c) r1
            kotlin.C4849c.b(r12)
            goto L5d
        L33:
            kotlin.C4849c.b(r12)
            java.lang.Object r12 = r11.f14560b
            Xa.c r12 = (Xa.c) r12
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.f14561c
            androidx.room.ObservedTableStates r1 = androidx.room.TriggerBasedInvalidationTracker.e(r1)
            int[] r6 = r11.f14562d
            boolean r1 = r1.i(r6)
            if (r1 == 0) goto L73
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.f14561c
            androidx.room.RoomDatabase r1 = androidx.room.TriggerBasedInvalidationTracker.d(r1)
            r11.f14560b = r12
            r11.f14559a = r5
            r5 = 0
            java.lang.Object r1 = f1.C4031a.b(r1, r5, r11)
            if (r1 != r0) goto L5a
            goto L94
        L5a:
            r10 = r1
            r1 = r12
            r12 = r10
        L5d:
            kotlin.coroutines.d r12 = (kotlin.coroutines.d) r12
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r11.f14561c
            r5.<init>(r6, r2)
            r11.f14560b = r1
            r11.f14559a = r4
            java.lang.Object r12 = Ua.C1056g.j(r12, r5, r11)
            if (r12 != r0) goto L71
            goto L94
        L71:
            r7 = r1
            goto L74
        L73:
            r7 = r12
        L74:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L1f
            r5.<init>()     // Catch: java.lang.Throwable -> L1f
            androidx.room.TriggerBasedInvalidationTracker r12 = r11.f14561c     // Catch: java.lang.Throwable -> L1f
            androidx.room.ObservedTableVersions r12 = androidx.room.TriggerBasedInvalidationTracker.f(r12)     // Catch: java.lang.Throwable -> L1f
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r4 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2     // Catch: java.lang.Throwable -> L1f
            boolean r6 = r11.f14563e     // Catch: java.lang.Throwable -> L1f
            java.lang.String[] r8 = r11.f14564f     // Catch: java.lang.Throwable -> L1f
            int[] r9 = r11.f14562d     // Catch: java.lang.Throwable -> L1f
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1f
            r11.f14560b = r2     // Catch: java.lang.Throwable -> L1f
            r11.f14559a = r3     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r12 = r12.a(r4, r11)     // Catch: java.lang.Throwable -> L1f
            if (r12 != r0) goto L95
        L94:
            return r0
        L95:
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L1f
            r12.<init>()     // Catch: java.lang.Throwable -> L1f
            throw r12     // Catch: java.lang.Throwable -> L1f
        L9b:
            androidx.room.TriggerBasedInvalidationTracker r0 = r11.f14561c
            androidx.room.ObservedTableStates r0 = androidx.room.TriggerBasedInvalidationTracker.e(r0)
            int[] r11 = r11.f14562d
            r0.j(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Xa.c<? super Set<? extends String>> cVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return invoke2((Xa.c<? super Set<String>>) cVar, interfaceC4014c);
    }
}
