package androidx.room;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "connection", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1", f = "InvalidationTracker.kt", l = {418, 425}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 extends SuspendLambda implements p9.p<Transactor, InterfaceC4014c<? super Set<? extends Integer>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14580a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14581b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14582c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/room/B;", "", "", "<anonymous>", "(Landroidx/room/B;)Ljava/util/Set;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1", f = "InvalidationTracker.kt", l = {426}, m = "invokeSuspend")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<B<Set<? extends Integer>>, InterfaceC4014c<? super Set<? extends Integer>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f14583a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14584b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TriggerBasedInvalidationTracker f14585c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f14585c = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14585c, interfaceC4014c);
            anonymousClass1.f14584b = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(B<Set<Integer>> b10, InterfaceC4014c<? super Set<Integer>> interfaceC4014c) {
            return ((AnonymousClass1) create(b10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f14583a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            B b10 = (B) this.f14584b;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.f14585c;
            this.f14583a = 1;
            Object objJ = triggerBasedInvalidationTracker.j(b10, this);
            return objJ == objG ? objG : objJ;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14582c = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this.f14582c, interfaceC4014c);
        triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.f14581b = obj;
        return triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Transactor transactor, InterfaceC4014c<? super Set<Integer>> interfaceC4014c) {
        return ((TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1) create(transactor, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r7 == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.f14580a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r7)     // Catch: android.database.SQLException -> L5a
            goto L57
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            java.lang.Object r1 = r6.f14581b
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            kotlin.C4849c.b(r7)
            goto L35
        L22:
            kotlin.C4849c.b(r7)
            java.lang.Object r7 = r6.f14581b
            r1 = r7
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            r6.f14581b = r1
            r6.f14580a = r3
            java.lang.Object r7 = r1.b(r6)
            if (r7 != r0) goto L35
            goto L56
        L35:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L42
            java.util.Set r6 = Z8.Y.e()
            return r6
        L42:
            androidx.room.Transactor$SQLiteTransactionType r7 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE     // Catch: android.database.SQLException -> L5a
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1 r3 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1     // Catch: android.database.SQLException -> L5a
            androidx.room.TriggerBasedInvalidationTracker r4 = r6.f14582c     // Catch: android.database.SQLException -> L5a
            r5 = 0
            r3.<init>(r4, r5)     // Catch: android.database.SQLException -> L5a
            r6.f14581b = r5     // Catch: android.database.SQLException -> L5a
            r6.f14580a = r2     // Catch: android.database.SQLException -> L5a
            java.lang.Object r7 = r1.a(r7, r3, r6)     // Catch: android.database.SQLException -> L5a
            if (r7 != r0) goto L57
        L56:
            return r0
        L57:
            java.util.Set r7 = (java.util.Set) r7     // Catch: android.database.SQLException -> L5a
            return r7
        L5a:
            java.util.Set r6 = Z8.Y.e()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
