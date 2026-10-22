package androidx.room.util;

import Y8.t;
import androidx.room.B;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import c1.j;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"R", "Landroidx/room/Transactor;", "transactor", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1", f = "DBUtil.android.kt", l = {56, 57, 59, 60}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1<R> extends SuspendLambda implements p<Transactor, InterfaceC4014c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f14886a;

    /* renamed from: b, reason: collision with root package name */
    public int f14887b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14888c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f14889d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f14890e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f14891f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l f14892g;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n"}, d2 = {"R", "Landroidx/room/B;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1$1", f = "DBUtil.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<B<R>, InterfaceC4014c<? super R>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f14893a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14894b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l f14895c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC4014c interfaceC4014c, InterfaceC5074l interfaceC5074l) {
            super(2, interfaceC4014c);
            this.f14895c = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c, this.f14895c);
            anonymousClass1.f14894b = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(B<R> b10, InterfaceC4014c<? super R> interfaceC4014c) {
            return ((AnonymousClass1) create(b10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f14893a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            B b10 = (B) this.f14894b;
            kotlin.jvm.internal.p.g(b10, "null cannot be cast to non-null type androidx.room.coroutines.RawConnectionAccessor");
            return this.f14895c.invoke(((j) b10).getDelegate());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(boolean z10, boolean z11, RoomDatabase roomDatabase, InterfaceC4014c interfaceC4014c, InterfaceC5074l interfaceC5074l) {
        super(2, interfaceC4014c);
        this.f14889d = z10;
        this.f14890e = z11;
        this.f14891f = roomDatabase;
        this.f14892g = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.f14889d, this.f14890e, this.f14891f, interfaceC4014c, this.f14892g);
        dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1.f14888c = obj;
        return dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Transactor transactor, InterfaceC4014c<? super R> interfaceC4014c) {
        return ((DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1) create(transactor, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2 A[PHI: r1 r8
      0x00a2: PHI (r1v11 androidx.room.Transactor) = (r1v8 androidx.room.Transactor), (r1v18 androidx.room.Transactor) binds: [B:35:0x009f, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r8v14 java.lang.Object) = (r8v13 java.lang.Object), (r8v0 java.lang.Object) binds: [B:35:0x009f, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c5 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
